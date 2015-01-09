package net.anei.cadpage.parsers.dispatch;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/**
 * Base parser for centers using Countryside software
 */
public class DispatchA48Parser extends SmartAddressParser {
  
  public enum FieldType { NAME, X, X_NAME, DATE_TIME_INFO };
  
  /**
   * Flag indicating the call description is a single word code
   */
  public static final int A48_ONE_WORD_CODE = 0x1;
  public static final int A48_OPT_ONE_WORD_CODE = 0x2;
  
  private static final Pattern SUBJECT_PTN = Pattern.compile("As of \\d\\d?/\\d\\d?/\\d\\d \\d\\d");
  private static final Pattern PREFIX_PTN = Pattern.compile("(?!\\d\\d:)([-a-z0-9]+: *)(.*)");
  private static final Pattern MASTER_PTN = Pattern.compile("(?:CAD:|[-A-Za-z0-9]*:)? *As of (\\d\\d?/\\d\\d?/\\d\\d) (\\d\\d:\\d\\d:\\d\\d) (?:([AP]M) )?(\\d{4}-\\d{8}) (.*)");
  private static final Pattern DATE_TIME_PTN = Pattern.compile("\\b(\\d\\d?/\\d\\d?/\\d\\d) (\\d\\d:\\d\\d:\\d\\d)\\b");
  private static final DateFormat TIME_FMT = new SimpleDateFormat("hh:mm:dd aa");
    
  private FieldType fieldType;
  private boolean dateTimeInfo; 
  private boolean oneWordCode;
  private boolean optOneWordCode;
  private Properties callCodes;

  public DispatchA48Parser(String[] cityList, String defCity, String defState, FieldType fieldType) {
    this(cityList, defCity, defState, fieldType, 0, null);
  }
  public DispatchA48Parser(String[] cityList, String defCity, String defState, FieldType fieldType, int flags) {
    this(cityList, defCity, defState, fieldType, flags, null);
  }

  public DispatchA48Parser(String[] cityList, String defCity, String defState, FieldType fieldType, int flags, Properties callCodes) {
    super(cityList, defCity, defState);
    this.fieldType = fieldType;
    dateTimeInfo = (fieldType == FieldType.DATE_TIME_INFO);
    oneWordCode = (flags & A48_ONE_WORD_CODE) != 0;
    optOneWordCode = (flags & A48_OPT_ONE_WORD_CODE) != 0;
    this.callCodes = callCodes;
    setFieldList("SRC DATE TIME ID CODE CALL ADDR APT CITY NAME " + fieldType.toString().replace('_', ' ') + " UNIT");
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (SUBJECT_PTN.matcher(subject).matches()) {
      Matcher match = PREFIX_PTN.matcher(body);
      if (match.matches()) {
        body = match.group(1) + subject + ':' + match.group(2);
      } else if (!body.startsWith(":As of")) {
        body = subject + ':' + body;
      }
      subject = "";
    } 
    
    // Handle case where subject was split off from main message and then discarded
    else if (subject.length() == 0 && !body.startsWith("As of ")) {
      body = "As of 99/99/99 99:" + body; 
    }
    
    data.strSource = subject;
    
    Matcher match = MASTER_PTN.matcher(body);
    if (!match.matches()) return false;
    data.strDate = match.group(1);
    if (data.strDate.startsWith("99/")) data.strDate = "";
    String time = match.group(2);
    if (!time.startsWith("99:")) {
      String time_qual = match.group(3);
      if (time_qual != null) {
        setTime(TIME_FMT, time + ' ' + time_qual, data);
      } else {
        data.strTime = time;
      }
    }
    data.strCallId = match.group(4);
    String addr = match.group(5).trim();
    
    Parser p = new Parser(fixCallAddress(addr));
    data.strUnit = p.getLastOptional(" Unit Org Name Area Types ");

    StartType st;
    int flags;
    if (optOneWordCode || !oneWordCode) data.strCode = p.getOptional(" - ");
    if (data.strCode.length() > 0) {
      st = StartType.START_CALL;
      flags = FLAG_START_FLD_REQ;
    } else {
      if (oneWordCode) return false;
      st = StartType.START_ADDR;
      flags = 0;
      String code  = p.get(' ');
      if (callCodes != null) {
        data.strCode = code;
        data.strCall = convertCodes(code, callCodes);
      } else {
        data.strCall = code;
      }
    }

    addr = p.get();
    int pt = addr.lastIndexOf(" Unit");
    if (pt >= 0) {
      if (" Unit Org Name Area Types ".startsWith(addr.substring(pt))) {
        addr = addr.substring(0,pt).trim();
      }
    }
    if (addr.length() == 0) return false;
    
    boolean addressParsed = false;
    String extra = null;
    if (dateTimeInfo) {
      match = DATE_TIME_PTN.matcher(addr);
      if (match.find()) {
        extra = addr.substring(match.end()).trim();
        addr = addr.substring(0,match.start());
      } else {
        extra = "";
      }
      flags |= FLAG_ANCHOR_END;
    }
    
    addr = cleanWirelessCarrier(addr, true);
    
    pt = addr.lastIndexOf(',');
    if (pt >= 0) {
      parseAddress(StartType.START_ADDR, FLAG_ONLY_CITY, addr.substring(pt+1).trim(), data);
      if (data.strCity.length() > 0) {
        String tmp = stripFieldStart(getLeft(), data.strCity);
        if (dateTimeInfo) {
          data.strName = tmp;
        } else {
          extra = tmp;
        }
        
        addressParsed = true;
        addr = addr.substring(0,pt).trim().replace('@', '&');
        if (st == StartType.START_ADDR){
          parseAddress(addr, data);
        } else {
          pt = addr.lastIndexOf(',');
          if (pt >= 0) {
            data.strCall = addr.substring(0,pt).trim();
            parseAddress(addr.substring(pt+1).trim(), data);
          } else {
            parseAddress(st, flags | FLAG_NO_CITY | FLAG_ANCHOR_END, addr, data);
          }
        }
        
        // Check for duplicated city/address
        pt = data.strAddress.indexOf(',');
        if (pt >= 0) {
          String tmp1 = data.strAddress.substring(0,pt).trim();
          String tmp2 = data.strAddress.substring(pt+1).trim();
          if (tmp1.equals(tmp2) ||
              tmp2.startsWith(data.strCity) && tmp2.endsWith(tmp1)) {
            data.strAddress = tmp1;
          }
        }
      }
    }
    
    if (!addressParsed) {
      addr = addr.replace('@', '&');
      parseAddress(st, flags, addr, data);
      if (!dateTimeInfo) extra = getLeft();
    }
    
    switch (fieldType) {
    case NAME:
      data.strName = extra;
      break;
      
    case X:
      parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS | FLAG_IMPLIED_INTERSECT | FLAG_ANCHOR_END, extra, data);
      break;
      
    case X_NAME:
      String cross = "";
      while (true) {
        Result res = parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS | FLAG_IMPLIED_INTERSECT, extra);
        if (!res.isValid()) break;
        res.getData(data);
        cross = append(cross, " / ", data.strCross);
        data.strCross = "";
        extra = res.getLeft();
      } 
      data.strCross = cross;
      data.strName = extra;
      break;
      
    case DATE_TIME_INFO:
      for (String info : DATE_TIME_PTN.split(extra)) {
        data.strSupp = append(data.strSupp, "\n", info.trim()); 
      }
      break;
    }
      
    
    if (data.strCall.equals(data.strCode)) data.strCode = "";
    return true;
  }

  /**
   * Can be overridden by parser subclasses to make corrections to the
   * call/address combination
   * @param addr
   * @return
   */
  protected String fixCallAddress(String addr) {
    return addr;
  }
}
