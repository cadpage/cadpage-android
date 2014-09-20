package net.anei.cadpage.parsers.dispatch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

public class DispatchA48Parser extends SmartAddressParser {
  
  public enum FieldType { NAME, X, DATE_TIME_INFO };
  
  /**
   * Flag indicating the call description is a single word code
   */
  public static final int A48_ONE_WORD_CODE = 0x1;
  
  private static final Pattern SUBJECT_PTN = Pattern.compile("As of \\d\\d?/\\d\\d?/\\d\\d \\d\\d");
  private static final Pattern PREFIX_PTN = Pattern.compile("[-a-z0-9]+: +");
  private static final Pattern MASTER_PTN = Pattern.compile("(?:CAD:)?As of (\\d\\d?/\\d\\d?/\\d\\d) (\\d\\d:\\d\\d:\\d\\d) (\\d{4}-\\d{8}) (.*)");
  private static final Pattern DATE_TIME_PTN = Pattern.compile("\\b(\\d\\d?/\\d\\d?/\\d\\d) (\\d\\d:\\d\\d:\\d\\d)\\b");
    
  private FieldType fieldType;
  private boolean dateTimeInfo; 
  private boolean oneWordCode;

  public DispatchA48Parser(String[] cityList, String defCity, String defState, FieldType fieldType) {
    this(cityList, defCity, defState, fieldType, 0);
  }

  public DispatchA48Parser(String[] cityList, String defCity, String defState, FieldType fieldType, int flags) {
    super(cityList, defCity, defState);
    this.fieldType = fieldType;
    dateTimeInfo = (fieldType == FieldType.DATE_TIME_INFO);
    oneWordCode = (flags & A48_ONE_WORD_CODE) != 0;
    setFieldList("SRC DATE TIME ID CODE CALL ADDR APT CITY NAME " + fieldType.toString().replace('_', ' ') + " UNIT");
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (SUBJECT_PTN.matcher(subject).matches()) {
      Matcher match = PREFIX_PTN.matcher(body);
      if (match.lookingAt()) body = body.substring(match.end());
      body = "CAD:" + subject + ':' + body;
      subject = "";
    }
    data.strSource = subject;
    
    Matcher match = MASTER_PTN.matcher(body);
    if (!match.matches()) return false;
    data.strDate = match.group(1);
    data.strTime = match.group(2);
    data.strCallId = match.group(3);
    String addr = match.group(4).trim();
    
    Parser p = new Parser(addr);
    data.strUnit = p.getLastOptional(" Unit Org Name Area Types ");

    StartType st;
    int flags;
    if (oneWordCode) {
      st = StartType.START_ADDR;
      flags = 0;
      data.strCall = p.get(' ');
    } else {
      st = StartType.START_CALL;
      flags = FLAG_START_FLD_REQ;
      data.strCode = p.get(" - ");
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
      
    case DATE_TIME_INFO:
      for (String info : DATE_TIME_PTN.split(extra)) {
        data.strSupp = append(data.strSupp, "\n", info.trim()); 
      }
      break;
    }
      
    
    if (data.strCall.equals(data.strCode)) data.strCode = "";
    return true;
  }
}
