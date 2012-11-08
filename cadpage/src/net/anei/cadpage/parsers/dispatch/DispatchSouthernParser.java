package net.anei.cadpage.parsers.dispatch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class DispatchSouthernParser extends FieldProgramParser {
  
  // Flag indicating  a leading dispatch name is required
  public static final int DSFLAG_DISPATCH_ID = 0x01;
  
  // Flag indicating a leading dispatch name is optional
  public static final int DSFLAG_OPT_DISPATCH_ID = 0x02;
  
  // Flag indicate a unit designation follows the time stamp
  public static final int DSFLAG_UNIT = 0x04;
  
  // Flag indicating that the call ID is optional
  public static final int DSFLAG_ID_OPTIONAL = 0x08;
  
  // Flag indicating a place name may precede the address
  // And Name/Phone number follows address
  public static final int DSFLAG_LEAD_PLACE = 0x010;
  
  // Flag indicating cross street information follows the address instead of
  // the usual name & phone
  public static final int DSFLAG_FOLLOW_CROSS = 0x20;
  
  // Flag indicating address will be followed by cross street, and then the usual
  // name & phone
  public static final int DSFLAG_CROSS_NAME_PHONE = 0x40;
  
  private static final Pattern LEAD_PTN = Pattern.compile("^[\\w\\.]+:");
  private static final Pattern ID_TIME_PTN = Pattern.compile("\\b(\\d{2,4}-?\\d{4,8}) (\\d\\d:\\d\\d:\\d\\d)\\b");
  private static final Pattern OPT_ID_TIME_PTN = Pattern.compile("\\b(?:(\\d{2,4}-?\\d{4,8}) )?(\\d\\d:\\d\\d:\\d\\d)\\b");
  private static final Pattern CALL_PTN = Pattern.compile("^([A-Z0-9\\- /]+)\\b[ \\.,-]*");
  private static final Pattern PHONE_PTN = Pattern.compile("\\b\\d{10}\\b");
  private static final Pattern CALL_BRK_PTN = Pattern.compile(" +/+ *");

  private Pattern idTimePattern;
  private boolean leadDispatch;
  private boolean optDispatch;
  private boolean unitId;
  private boolean inclPlace;
  private boolean inclCross;
  private boolean inclCrossNamePhone;
  
  public DispatchSouthernParser(String[] cityList, String defCity, String defState) {
    this(cityList, defCity, defState, DSFLAG_DISPATCH_ID);
  }
  
  public DispatchSouthernParser(String[] cityList, String defCity, String defState, int flags) {
    super(cityList, defCity, defState,
          "ADDR/S"+((flags & DSFLAG_LEAD_PLACE) != 0 ? "P" : "") +" CODE? ID? TIME INFO! INFO2");
    this.leadDispatch = (flags & DSFLAG_DISPATCH_ID) != 0;
    this.optDispatch = (flags & DSFLAG_OPT_DISPATCH_ID) != 0;
    this.unitId = (flags & DSFLAG_UNIT) != 0;
    this.idTimePattern = (flags & DSFLAG_ID_OPTIONAL) != 0 ? OPT_ID_TIME_PTN : ID_TIME_PTN;
    this.inclPlace = (flags &  DSFLAG_LEAD_PLACE) != 0;
    this.inclCross = (flags & DSFLAG_FOLLOW_CROSS) != 0;
    this.inclCrossNamePhone = (flags & DSFLAG_CROSS_NAME_PHONE) != 0;
  }

  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // Message must always start with dispatcher ID, which we promptly discard
    if (leadDispatch || optDispatch) {
      Matcher match = LEAD_PTN.matcher(body);
      if (match.find()) {
        body = body.substring(match.end()).trim();
      } else if (!optDispatch) return false;
    }
    
    // See if this looks like one of the new comma delimited page formats
    // If it is, let FieldProgramParser handle it.
    String[] flds = body.split(",");
    if (flds.length >= 3) {
      if (parseFields(flds, data)) return true;
      data.initialize();
    }
    
    // find an ID/Time pattern which splits the message into two fields
    Matcher match = idTimePattern.matcher(body);
    if (!match.find()) return false;
    
    data.strCallId = getOptGroup(match.group(1));
    data.strTime = match.group(2);
    String sAddr = body.substring(0,match.start()).trim();
    String sExtra = body.substring(match.end()).trim();
    
    if (sAddr.length() > 0) {
      parseMain(sAddr, data);
      parseExtra(sExtra, data);
    } else {
      parseExtra2(sExtra, data);
    }
    
    // If we could not identify a call description, see if we can break one
    // out of the supplemental info
    if (data.strCall.length() == 0) {
      if (data.strSupp.length() == 0) {
        data.strCall = "ALERT";
      } else {
        match = CALL_BRK_PTN.matcher(data.strSupp);
        if (match.find() && match.start() <= 30) {
          data.strCall = data.strSupp.substring(0,match.start()).trim();
          data.strSupp = data.strSupp.substring(match.end()).trim();
        }
      }
    }

    return true;
  }

  protected void parseMain(String sAddr, Data data) {
    // First half contains address, optional place/name, and possibly an MDL call code
    Parser p = new Parser(sAddr);
    data.strCode = p.getLastOptional(" MDL ");
    if (data.strCode.length() == 0) data.strCode = p.getLastOptional(" FDL ");
    sAddr = p.get();
    StartType st = (inclPlace ? StartType.START_PLACE : StartType.START_ADDR);
    int flags = (inclCross || inclCrossNamePhone ? FLAG_CROSS_FOLLOWS : 0);
    parseAddress(st, flags, sAddr, data);
    String sLeft = getLeft();
    
    // Processing what is left gets complicated
    // First strip anything that looks like a trailing phone number
    Matcher match = PHONE_PTN.matcher(sLeft);
    if (match.find()) {
      data.strPhone = match.group();
      sLeft = sLeft.substring(0,match.start()).trim();
    }
    
    // if cross street information follows the address, process that
    if (inclCross) {
      data.strCross = sLeft.replace(" X ", " / ");
    } 
    
    else {
      
      if (inclCrossNamePhone) {
        int pt = sLeft.indexOf(" X ");
        if (pt >= 0) {
          String save = sLeft.substring(0,pt).trim();
          sLeft = sLeft.substring(pt+3).trim();
          parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS, sLeft, data);
          data.strCross = save + " / " + data.strCross;
          sLeft = getLeft();
        }
      }
      
      // Otherwise, if the place name isn't located in front of the address
      // assume whatever follows it is a place name
      if (!inclPlace) {
        data.strPlace = sLeft;
      }
  
      // Otherwise assume it is a name followed by an optional phone number
      else {
        data.strName = sLeft;
      }
    }
  }

  protected void parseExtra(String sExtra, Data data) {

    // Second half May contain unit ID,
    // then call description and long call description
    // Call description comes first and contains only upper case letters and numbers
    Matcher match;
    Parser p;
    if (unitId) {
      p = new Parser(sExtra);
      data.strUnit = p.get(' ');
      sExtra = p.get();
    }
    match = CALL_PTN.matcher(sExtra);
    if (match.find() && match.end() > 0) {
      String sCall = match.group(1).trim();
      if (sCall.length() <= 30) {
        sExtra = sExtra.substring(match.end()).trim();
        if (sExtra.startsWith("y")) {
          int pt = sCall.length();
          while (pt > 0 && Character.isDigit(sCall.charAt(pt-1))) pt--;
          if (pt > 0 && pt < sCall.length()) {
            sExtra = sCall.substring(pt) + ' ' + sExtra;
            sCall = sCall.substring(0,pt).trim();
          }
        }
        data.strCall = sCall;
        data.strSupp = sExtra;
      } else {
        data.strSupp = sExtra;
      }
    } else if (sExtra.length() <= 30) {
      data.strCall = sExtra;
    } else {
      data.strSupp = sExtra;
    }
    if (data.strCall.length() == 0 && data.strSupp.length() == 0) data.strCall= "ALERT";
  }

  protected void parseExtra2(String sExtra, Data data) {
    // First half contains address, optional place/name, and possibly an MDL call code
    Parser p = new Parser(sExtra);
    data.strCode = p.getLastOptional(" MDL ");
    if (data.strCode.length() == 0) data.strCode =p.getLastOptional(" FDL ");
    sExtra = p.get();
    parseAddress(StartType.START_CALL, sExtra, data);
    data.strSupp = getLeft();
  }
  
  //  Classes for handling the new comma delimited format
  
  private class MyCodeField extends CodeField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (!field.startsWith("MDL ") && !field.startsWith("FDL ")) return false;
      data.strCode = field.substring(4).trim();
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      parseExtra(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "UNIT CALL INFO";
    }
  }
  
  private class MyInfo2Field extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (data.strCall.length() == 0) {
        data.strCall = data.strSupp;
        data.strSupp = field;
      } else {
        super.parse(field, data);
      }
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CODE"))  return new MyCodeField();
    if (name.equals("ID")) return new IdField("\\d\\d-?\\d{5,8}", true);
    if (name.equals("TIME")) return new TimeField("\\d\\d:\\d\\d:\\d\\d", true);
    if (name.equals("INFO")) return new MyInfoField();
    if (name.equals("INFO2")) return new MyInfo2Field();
    return super.getField(name);
  }
}
