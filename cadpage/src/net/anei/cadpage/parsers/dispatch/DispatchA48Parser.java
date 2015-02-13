package net.anei.cadpage.parsers.dispatch;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Base parser for centers using Countryside software
 */
public class DispatchA48Parser extends FieldProgramParser {
  
  public enum FieldType { 
    NONE("", "") {
      @Override
      public void parse(DispatchA48Parser parser, String field, Data data) {}
    }, 
    
    NAME("NAME", "NAME") {
      @Override
      public void parse(DispatchA48Parser parser, String field, Data data) {
        data.strName = field;
      }
    }, 
    
    X("X", "X") {
      @Override
      public void parse(DispatchA48Parser parser, String field, Data data) {
        parser.parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS | FLAG_IMPLIED_INTERSECT | FLAG_ANCHOR_END, field, data);
      }
    },
    
    X_NAME("X NAME", "X NAME") {
      @Override
      public void parse(DispatchA48Parser parser, String field, Data data) {
        String cross = "";
        while (true) {
          Result res = parser.parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS | FLAG_IMPLIED_INTERSECT, field);
          if (!res.isValid()) break;
          res.getData(data);
          cross = append(cross, " / ", data.strCross);
          data.strCross = "";
          field = res.getLeft();
        } 
        data.strCross = cross;
        data.strName = field;
      }
    },
    
    DATE_TIME_INFO("NAME INFO+", "NAME DATE TIME INFO") {
      @Override
      public void parse(DispatchA48Parser parser, String field, Data data) {
        for (String info : DATE_TIME_PTN.split(field)) {
          data.strSupp = append(data.strSupp, "\n", info.trim()); 
        }
      }
    };
    
    private String fieldProg, fieldList;
    private FieldType(String fieldProg, String fieldList) {
      this.fieldProg = fieldProg;
      this.fieldList = fieldList;
    }
    
    public String getFieldProg() {
      return fieldProg;
    }
    
    public String getFieldList() {
      return fieldList;
    }
    
    public abstract void parse(DispatchA48Parser parser, String field, Data data);
  };
  
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
  private String fieldList;

  public DispatchA48Parser(String[] cityList, String defCity, String defState, FieldType fieldType) {
    this(cityList, defCity, defState, fieldType, 0, null);
  }
  public DispatchA48Parser(String[] cityList, String defCity, String defState, FieldType fieldType, int flags) {
    this(cityList, defCity, defState, fieldType, flags, null);
  }

  public DispatchA48Parser(String[] cityList, String defCity, String defState, FieldType fieldType, int flags, Properties callCodes) {
    super(cityList, defCity, defState,
          append("DATETIME ID CALL ADDRCITY SKIP!", " ", fieldType.getFieldProg()));
    this.fieldType = fieldType;
    dateTimeInfo = (fieldType == FieldType.DATE_TIME_INFO);
    oneWordCode = (flags & A48_ONE_WORD_CODE) != 0;
    optOneWordCode = (flags & A48_OPT_ONE_WORD_CODE) != 0;
    this.callCodes = callCodes;
    fieldList = ("DATE TIME ID CODE CALL ADDR APT CITY NAME " + fieldType.getFieldList() + " UNIT").replace("  ", " ");
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
    
    // Check for the new newline delimited format
    String flds[] = body.split("\n");
    if (flds.length >= 4) {
      return parseFields(flds, data);
    }
    
    // No such luck, have to do this the old way
    Matcher match = MASTER_PTN.matcher(body);
    if (!match.matches()) return false;
    setFieldList(fieldList);
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
      if (!optOneWordCode && !oneWordCode) return false;
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
    else if (fieldType == FieldType.NONE) {
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
          parseAddress(st, flags | FLAG_NO_CITY | FLAG_ANCHOR_END, addr, data);
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
    
    fieldType.parse(this, extra, data);
    
    if (data.strCall.equals(data.strCode)) data.strCode = "";
    return true;
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME")) return new MyDateTimeField();
    if (name.equals("ID")) return new IdField("\\d{4}-\\d{8}", true);
    if (name.equals("CALL")) return new MyCallField();
    return super.getField(name);
  }
  
  private static final Pattern DATE_TIME_PTN2 = Pattern.compile("(?:CAD:|[-A-Za-z0-9]*:)? *As of (\\d\\d?/\\d\\d?/\\d\\d) (\\d\\d:\\d\\d:\\d\\d(?: [AP]M)?)");
  private class MyDateTimeField extends DateTimeField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = DATE_TIME_PTN2.matcher(field);
      if (!match.matches()) abort();
      data.strDate = match.group(1);
      String time = match.group(2);
      if (time.endsWith("M")) {
        setTime(TIME_FMT, time, data);
      } else {
        data.strTime = time;
      }
    }
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      field = fixCallAddress(field);
      if (optOneWordCode || !oneWordCode) {
        int pt = field.indexOf(" - ");
        if (pt >= 0) {
          data.strCode = field.substring(0,pt).trim();
          data.strCall = field.substring(pt+3).trim();
          return;
        }
      }
      
      if (!optOneWordCode && !oneWordCode) abort();
      if (callCodes != null) {
        data.strCode = field;
        data.strCall = convertCodes(field, callCodes);
      } else {
        data.strCall = field;
      }
    }
    
    @Override
    public String getFieldNames() {
      return "CODE CALL";
    }
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
