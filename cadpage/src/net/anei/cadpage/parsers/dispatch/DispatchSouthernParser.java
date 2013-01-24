package net.anei.cadpage.parsers.dispatch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
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
  
  // Flag indicating there is no name and phone following the address
  public static final int DSFLAG_NO_NAME_PHONE = 0x80;
  
  private static final Pattern LEAD_PTN = Pattern.compile("^[\\w\\.]+:");
  private static final Pattern NAKED_TIME_PTN = Pattern.compile("([ ,;]) *(\\d\\d:\\d\\d:\\d\\d)(?:\\1|$)");
  private static final Pattern ID_PTN = Pattern.compile("\\b\\d{2,4}-?\\d{4,8}$");
  private static final Pattern CALL_PTN = Pattern.compile("^([A-Z0-9\\- /]+)\\b[ \\.,-]*");
  private static final Pattern PHONE_PTN = Pattern.compile("\\b\\d{10}\\b");
  private static final Pattern CALL_BRK_PTN = Pattern.compile(" +/+ *");

  private boolean leadDispatch;
  private boolean optDispatch;
  private boolean unitId;
  private boolean idOptional;
  private boolean inclPlace;
  private boolean inclCross;
  private boolean inclCrossNamePhone;
  private boolean noNamePhone;
  private CodeSet callSet;
  
  public DispatchSouthernParser(String[] cityList, String defCity, String defState) {
    this(null, cityList, defCity, defState, DSFLAG_DISPATCH_ID);
  }
  
  public DispatchSouthernParser(String[] cityList, String defCity, String defState, int flags) {
    this(null, cityList, defCity, defState, flags);
  }
  
  public DispatchSouthernParser(CodeSet callSet, String[] cityList, String defCity, String defState, int flags) {
    super(cityList, defCity, defState, "");
    this.callSet = callSet;
    this.leadDispatch = (flags & DSFLAG_DISPATCH_ID) != 0;
    this.optDispatch = (flags & DSFLAG_OPT_DISPATCH_ID) != 0;
    this.unitId = (flags & DSFLAG_UNIT) != 0;
    this.idOptional = (flags & DSFLAG_ID_OPTIONAL) != 0;
    this.inclPlace = (flags &  DSFLAG_LEAD_PLACE) != 0;
    this.inclCross = (flags & DSFLAG_FOLLOW_CROSS) != 0;
    this.inclCrossNamePhone = (flags & DSFLAG_CROSS_NAME_PHONE) != 0;
    this.noNamePhone = (flags & DSFLAG_NO_NAME_PHONE) != 0;
    
    // Program string needs to be built at run time
    StringBuilder sb = new StringBuilder();
    sb.append("ADDR/S");
    if (inclPlace) sb.append('P');
    if (inclCross || inclCrossNamePhone) sb.append(" X?");
    if (!inclCross && !noNamePhone) sb.append(" NAME+? PHONE");
    sb.append(" CODE+? PARTCODE?");
    sb.append(" ID");
    if (idOptional) sb.append('?');
    sb.append(" TIME");
    sb.append(" INFO+ OCA:ID2");
    String program = sb.toString();
    setProgram(program, 0);
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
    Matcher match = NAKED_TIME_PTN.matcher(body);
    if (!match.find()) return false;
    String delim = match.group(1);
    if (delim.charAt(0) != ' ') {
      body = body.replace(" OCA:", delim + "OCA:");
      return parseFields(body.split(delim), data);
    }
    
    // Blank delimited fields get complicated
    // We already found a time field.  Use that to split the message 
    // into and address and extra versions 
    
    data.strTime = match.group(2);
    String sAddr = body.substring(0,match.start()).trim();
    String sExtra = body.substring(match.end()).trim();
    
    // See if there is an ID field immediate in front of the time field
    match = ID_PTN.matcher(sAddr);
    if (match.find()) {
      data.strCallId = match.group();
      sAddr = sAddr.substring(0,match.start()).trim();
    } else if (!idOptional) return false;
    
    if (sAddr.length() > 0) {
      parseMain(sAddr, data);
      parseExtra(sExtra, data);
    } else {
      parseExtra2(sExtra, data);
    }
    
    if (data.strCall.length() == 0 && data.strSupp.length() == 0) data.strCall= "ALERT";
    return true;
  }

  protected void parseMain(String sAddr, Data data) {
    // First half contains address, optional place/name, and possibly an MDL call code
    Parser p = new Parser(sAddr);
    data.strCode = p.getLastOptional(" MDL ");
    if (data.strCode.length() == 0) data.strCode = p.getLastOptional(" FDL ");
    if (data.strCode.length() == 0) data.strCode = p.getLastOptional(" LDL ");
    sAddr = p.get();
    StartType st = (inclPlace ? StartType.START_PLACE : StartType.START_ADDR);
    int flags = 0;
    if (inclCross || inclCrossNamePhone) flags |= FLAG_CROSS_FOLLOWS;
    if (noNamePhone && inclPlace) flags |= FLAG_ANCHOR_END;
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
      sLeft = sLeft.replace(" X ", " / ");
      if (sLeft.endsWith(" X")) sLeft = sLeft.substring(0,sLeft.length()-2).trim();
      data.strCross = append(data.strCross, " & ", sLeft);
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
    if (unitId) {
      Parser p = new Parser(sExtra);
      data.strUnit = p.get(' ');
      sExtra = p.get();
    }
    
    if (callSet != null) {
      String call = callSet.getCode(sExtra);
      if (call != null) {
        data.strCall = call;
        data.strSupp = sExtra.substring(call.length()).trim();
        return;
      }
    }

    
    match = CALL_PTN.matcher(sExtra);
    if (match.find() && match.end() > 0 && match.end() < sExtra.length()) {
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
        return;
      }
    }
    
    if (sExtra.length() <= 30) {
      data.strCall = sExtra;
      return;
    }
    
    match = CALL_BRK_PTN.matcher(sExtra);
    if (match.find() && match.start() <= 30) {
      data.strCall = sExtra.substring(0,match.start()).trim();
      data.strSupp = sExtra.substring(match.end()).trim();
      return;
    }
    
    data.strSupp = sExtra;
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
  
  private class MyCrossField extends CrossField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (!field.contains(" X ")) return false;
      parse(field, data);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      field = field.replace(" X ", " / ");
      super.parse(field, data);
    }
  }
  
  private class MyNameField extends NameField {
    @Override
    public void parse(String field, Data data) {
      data.strName = append(data.strName, ", ", field);
    }
  }
  
  private class MyCodeField extends CodeField {
    public MyCodeField() {
      super("[FML]DL *(.*)", true);
    }
    
    @Override
    public void parse(String field, Data data) {
      if (data.strCode.length() == 0) super.parse(field, data);
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      
      if (unitId && data.strUnit.length() == 0) {
        Parser p = new Parser(field);
        data.strUnit = p.get(' ');
        field = p.get();
      }
      
      if (data.strCall.length() == 0) {
        data.strCall = field;
        return;
      }
      
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "UNIT CALL INFO";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CODE"))  return new MyCodeField();
    if (name.equals("PARTCODE")) return new SkipField("[MFL]D?");
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("ID")) return new IdField("\\d\\d(?:\\d\\d)?-?\\d{5,8}", true);
    if (name.equals("NAME")) return new MyNameField();
    if (name.equals("PHONE")) return new PhoneField("\\d{10}");
    if (name.equals("TIME")) return new TimeField("\\d\\d:\\d\\d:\\d\\d", true);
    if (name.equals("INFO")) return new MyInfoField();
    if (name.equals("ID2")) return new IdField("\\d{6}-\\d{4}");
    return super.getField(name);
  }
}
