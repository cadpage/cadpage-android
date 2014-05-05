package net.anei.cadpage.parsers.dispatch;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class DispatchA41Parser extends FieldProgramParser {
  
  public static final int A41_FLG_NO_CALL = 1;
  
  private static final Pattern DATE_TIME_PTN = Pattern.compile("(.*) +- From +(?:[A-Z][A-Z0-9]+ +)?(\\d\\d/\\d\\d/\\d{4}) +(\\d\\d:\\d\\d:\\d\\d)");
  
  private Properties cityCodes;
  
  public DispatchA41Parser(Properties cityCodes, String defCity, String defState) {
    this(cityCodes, defCity, defState, 0);
  }
  
  public DispatchA41Parser(Properties cityCodes, String defCity, String defState, int flags) {
    super(cityCodes, defCity, defState, calcProgram(flags));
    this.cityCodes = cityCodes;
  }
  
  private static String calcProgram(int flags) {
    StringBuilder sb = new StringBuilder();
    sb.append("DISPATCH:CODE! ");
    if ((flags & A41_FLG_NO_CALL) == 0) sb.append("CALL ");
    sb.append("( PLACE  CITY/Z AT | ADDRCITY/Z ) CITY?  ( SRC/Z MAPPAGE! | ( PLACE X1 | PLACE INT | X1 | INT | ) PLACE? SRC ( MAP MAPPAGE | MAPPAGE | MAP ) ) INFO+ Unit:UNIT UNIT+");
    return sb.toString();
  }

  @Override
  public boolean parseMsg(String body, Data data) {
    
    Matcher match = DATE_TIME_PTN.matcher(body);
    if (match.matches()) {
      body = match.group(1);
      data.strDate = match.group(2);
      data.strTime = match.group(3);
    } else {
      int pt = body.lastIndexOf(" - From");
      if (pt >= 0) body = body.substring(0,pt).trim();
    }
    body = body.replace(" Units:", " Unit:");
    if (body.endsWith(",")) body = body + ' ';
    return parseFields(body.split(",+ "), data);
  }
  
  @Override
  public String getProgram() {
    return super.getProgram() + " DATE TIME"; 
  }

  @Override
  public Field getField(String name) {
    if (name.equals("ADDRCITY")) return new MyAddressCityField();
    if (name.equals("CITY")) return new MyCityField();
    if (name.equals("AT")) return new AddressField("at +(.*)", true);
    if (name.equals("X1")) return new CrossField("btwn *(.*)", true);
    if (name.equals("INT")) return new SkipField("<.*>", true);
    if (name.equals("SRC")) return new SourceField("[A-Z]{1,3}\\d?", true);
    if (name.equals("MAPPAGE")) return new SkipField("mappage,XXXX", true);
    if (name.equals("INFO")) return new MyInfoField();
    if (name.equals("UNIT")) return new MyUnitField();
    
    if (name.equals("ID")) return new MyIdField();
    if (name.equals("CODE")) return new MyCodeField();
    if (name.equals("ADDR1")) return new MyAddressField(1);
    if (name.equals("ADDR2")) return new MyAddressField(2);
    if (name.equals("ADDR3")) return new MyAddressField(3);
    if (name.equals("X2")) return new CrossField("btwn *(.*)", false);
    return super.getField(name);
  }
  
  private class MyAddressCityField extends AddressCityField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith(")")) {
        int pt = field.indexOf('(');
        if (pt >= 0) field = field.substring(0,pt).trim();
      }
      super.parse(field, data);
    }
  }
  
  private class MyCityField extends CityField {
    
    @Override
    public boolean checkParse(String field, Data data) {
      int pt = field.indexOf('(');
      if (pt >= 0) field = field.substring(0,pt).trim();
      return super.checkParse(field, data);
    }
    
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf('(');
      if (pt >= 0) field = field.substring(0,pt).trim();
      super.parse(field, data);
    }
  }
  
  private static final String PROQA_DISPATCH = "Medical ProQA recommends dispatch at this time";
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith(PROQA_DISPATCH)) field = field.substring(PROQA_DISPATCH.length()).trim();
      else if (PROQA_DISPATCH.startsWith(field)) return;
      super.parse(field, data);
    }
  }
  
  private class MyUnitField extends UnitField {
    @Override
    public void parse(String field, Data data) {
      data.strUnit = append(data.strUnit, " ", field);
    }
  }
  
  private static final Pattern ID_PTN = Pattern.compile("#(\\d{9}) -");
  private class MyIdField extends IdField {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      Matcher match = ID_PTN.matcher(field);
      if (!match.matches()) return false;
      super.parse(match.group(1), data);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
  }
  
  private static final Pattern CODE_PRI_PTN = Pattern.compile("(.*?)(?:P(\\d))?:?");
  private class MyCodeField extends CodeField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = CODE_PRI_PTN.matcher(field);
      if (match.matches()) {
        field = match.group(1).trim();
        data.strPriority = getOptGroup(match.group(2));
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "CODE PRI";
    }
  }
  
  /*
   * Address field comes in three flavors, all of which can determine their state
   * type 1 = call @ place,city
   * type 2 = - at address,city
   * type 3 = call @ address, city
   */
  private class MyAddressField extends AddressField {
    
    private int type;
    
    public MyAddressField(int type) {
      this.type = type;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (type == 2) {
        if (!field.startsWith("- at ")) return false; 
        field = field.substring(5).trim();
      }
      
      else {
        int pt1 = field.lastIndexOf('@');
        if (pt1 < 0) return false;
        data.strCall = field.substring(0,pt1).trim();
        field = field.substring(pt1+1).trim();
      }
      
      int pt = field.lastIndexOf(',');
      if (pt >= 0) {
        String sCity = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
        if (data.strCity.length() == 0) {
          pt = sCity.indexOf('-');
          if (pt >= 0) sCity = sCity.substring(0,pt).trim();
          data.strCity = convertCodes(sCity, cityCodes);
        }
      }
      
      if (type == 1) {
        data.strPlace = field;
      }
      
      else {
        super.parse(field, data);
      }
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
    
    @Override 
    public String getFieldNames() {
      switch (type) {
      case 1:
        return "CALL PLACE CITY";
      case 2:
        return super.getFieldNames() + " CITY";
      case 3:
        return "CALL " + super.getFieldNames() + " CITY";
      default:
        return null;
      }
    }
  }
}
