package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class OHUnionCountyParser extends FieldProgramParser {
  
  public OHUnionCountyParser() {
    super(CITY_LIST, "UNION COUNTY", "OH",
           "CALL ADDR/S X X INFO+");
  }
  
  @Override
  public String getFilter() {
    return "idnetworks@co.union.oh.us";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    return parseFields(body.split(","), data);
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf("//");
      if (pt >= 0) field = field.substring(pt+2).trim();
      super.parse(field, data);
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (data.strCity.startsWith(field)) return;
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private static final String[] CITY_LIST = new String[]{
    
    // Cities
    "DUBLIN",
    "MARYSVILLE",
    "[EDIT]VILLAGES",
    "MAGNETIC SPRINGS",
    "MILFORD CENTER",
    "PLAIN CITY",
    "RICHWOOD",
    "UNIONVILLE CENTER",
    
    // Unincorporated communities
    "ALLEN CENTER",
    "ARNOLD",
    "BRIDGEPORT",
    "BROADWAY",
    "BYHALIA",
    "CHUCKERY",
    "CLAIBOURNE",
    "DIPPLE",
    "ESSEX",
    "IRWIN",
    "JEROME",
    "LUNDA",
    "NEW CALIFORNIA",
    "NEW DOVER",
    "PEORIA",
    "PHARISBURG",
    "POTTERSBURG",
    "RAYMOND",
    "SOMERSVILLE",
    "WATKINS",
    "WOODLAND",
    "YORK CENTER",
    
    // Townships
    "ALLEN TWP",
    "CLAIBOURNE TWP",
    "DARBY TWP",
    "DOVER TWP",
    "JACKSON TWP",
    "JEROME TWP",
    "LEESBURG TWP",
    "LIBERTY TWP",
    "MILLCREEK TWP",
    "PARIS TWP",
    "TAYLOR TWP",
    "UNION TWP",
    "WASHINGTON TWP",
    "YORK TWP"
  };
}
