package net.anei.cadpage.parsers.IN;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class INPorterCountyParser extends FieldProgramParser {
  
  private static final Pattern DATE_TIME_PTN = Pattern.compile("(.*) +- From +(\\d\\d/\\d\\d/\\d{4}) +(\\d\\d:\\d\\d:\\d\\d)");
  private static final Pattern MISSING_LF_PTN = Pattern.compile("(?<=[^\n])(?=GRP:)");
  private static final Pattern MUT_AID_CALL_PTN = Pattern.compile("MUT.AID.*?(?: ([A-Z]{3}))?");
  
  private String select;
  
  public INPorterCountyParser() {
    super(CITY_CODES, "PORTER COUNTY", "IN",
          "( SELECT/1 DISPATCH:CODE! CALL ( PLACE  CITY/Z AT | ADDRCITY/Z ) CITY?  ( SRC/Z MAPPAGE! | PLACE? ( X1 | INT ) PLACE? SRC MAP? MAPPAGE! ) INFO+ Unit:UNIT UNIT+ | " +
           "ID? CODE ( ADDR1/Z ADDR2 | ADDR3! ) CROSS:X2? GRP:UNIT? PRI:PRI comment:INFO )");
  }
  
  @Override
  public String getFilter() {
    return "pcdisp@porterco-ps.org";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_ADD_DEFAULT_CNTY; 
  }

  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    // Two different formats
    if (subject.equals("Porter SMTP Provider")) {
      select = "1";
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
      if (!parseFields(body.split(",+ "), data)) return false;
    }
    
    // Second older format is no longer used
    else {
      do {
        if (subject.equals("CAD Page")) break;
        if (subject.endsWith("FS")) {
          data.strSource = subject;
          break;
        }
        return false;
      } while (false);
      
      select = "2";
      
      body = MISSING_LF_PTN.matcher(body).replaceAll("\n");
      if (!parseFields(body.split("\n"), 4, data)) return false;
      String sAddr = data.strAddress;
      data.strAddress = "";
      parseAddress(sAddr, data);
    }
    
    // Winfield TWP is in Lake county
    if (data.strCity.equals("Crown Point") ||
        data.strCity.equals("Winfield Twp")) data.defCity = "LAKE COUNTY";
    else if (data.strCity.equals("OOC")) {
      data.defCity = "";
      data.strCity = "";
    }
    
    // If we don't have a city specified, and this is a mutual aid call
    // Change the default county to match the destination department
    if (data.strCity.length() == 0) {
      Matcher match = MUT_AID_CALL_PTN.matcher(data.strCall);
      if (match.matches()) {
        data.defCity = "";
        String dest = match.group(1);
        if (dest != null) {
          if (dest.equals("SCN")) data.defCity = "LAKE COUNTY";
          else if (dest.equals("OWN")) data.defCity = "LAKE COUNTY";
        }
      }
    }
    return true;
  }
  
  @Override
  public String getProgram() {
    if (select.equals("1")) return super.getProgram() + " DATE TIME"; 
    else return ("SRC " + super.getProgram());
  }
  
  @Override
  protected String getSelectValue() {
    return select;
  }

  @Override
  public Field getField(String name) {
    if (name.equals("ADDRCITY")) return new MyAddressCityField();
    if (name.equals("CITY")) return new MyCityField();
    if (name.equals("AT")) return new AddressField("at +(.*)", true);
    if (name.equals("X1")) return new CrossField("btwn *(.*)", true);
    if (name.equals("INT")) return new SkipField("<.*>", true);
    if (name.equals("SRC")) return new SourceField("[A-Z]{2,3}", true);
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
          data.strCity = convertCodes(sCity, CITY_CODES);
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
  
  @Override
  public String adjustMapAddress(String addr) {
    return EST_PTN.matcher(addr).replaceAll("ESTATES");
  }
  private static final Pattern EST_PTN = Pattern.compile("\\bEST\\b", Pattern.CASE_INSENSITIVE);
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "BHB", "Burns Harbor",
      "BSH", "Beverly Shores",
      "CHE", "Chesterton",
      "DAC", "Dune Acres",
      "HEB", "Hebron",
      "KTS", "Kouts",
      "OGD", "Ogden Dunes",
      "PTG", "Portage",
      "PTR", "Porter",
      "VAL", "Valparaiso",
              
      "BNT", "Boone Twp",
      "CCT", "Center Twp",
      "CTT", "Center Twp",
      "ECT", "Eagle Creek Twp",
      "JKT", "Jackson Twp",
      "LBT", "Liberty Twp",
      "MGT", "Morgan Twp",
      "PGT", "Portage Twp",
      "PLT", "Pleasant Twp",
      "PNT", "Pine Twp",
      "POT", "Porter Twp",
      "UNT", "Union Twp",
      "WCT", "Westchester Twp",
      "WGT", "Washington Twp",
      
      // Lake County
      "CPT", "Crown Point",
      "WNT", "Winfield Twp",
      
      // OUT OF COUNTY
      "OOC",      "OOC"
  });
}
