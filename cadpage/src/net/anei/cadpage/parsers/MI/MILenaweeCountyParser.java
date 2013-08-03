package net.anei.cadpage.parsers.MI;


import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class MILenaweeCountyParser extends FieldProgramParser {
  
  public MILenaweeCountyParser() {
    super(CITY_LIST, "LENAWEE COUNTY", "MI",
          "CALL_ADDR! Common_Name:INFO");
  }
  
  @Override
  public String getFilter() {
    return "Lenawee@Lenawee.mi";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_PREFER_GPS;
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("!")) return false;
    return super.parseMsg(body, data);
  }
  
  private class CallAddressField extends AddressField {
    @Override 
    public void parse(String field, Data data) {
      StartType st = StartType.START_CALL;
      int flags = FLAG_START_FLD_REQ;
      int pt = field.indexOf("  ");
      if (pt >= 0) {
        st = StartType.START_ADDR;
        flags = 0;
        data.strCall = field.substring(0,pt);
        field = field.substring(pt+2).trim();
      }
      field = setGPSLoc(field, data);
      
      parseAddress(st, FLAG_PAD_FIELD | FLAG_CROSS_FOLLOWS | FLAG_ANCHOR_END | flags, field, data);
      data.strCross = getPadField();
      
      if (data.strCity.equalsIgnoreCase("OUT OF COUNTY")) {
        data.strCity = data.defCity = "";
      }
    }
    
    @Override
    public String getFieldNames() {
      return "CALL ADDR APT X CITY GPS";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL_ADDR")) return new CallAddressField();
    return super.getField(name);
  }
  
  private static final String[] CITY_LIST = new String[]{
    
    // Cities
    "ADRIAN",
    "HUDSON",
    "MORENCI",
    "TECUMSEH",

    // Villages
    "ADDISON",
    "BLISSFIELD",
    "BRITTON",
    "CEMENT CITY",
    "CLAYTON",
    "CLINTON",
    "DEERFIELD",
    "ONSTED",

    // Unincorporated
    "CANANDAIGUA",
    "FAIRFIELD",
    "JASPER",
    "MADISON CENTER",
    "MEDINA",
    "MANITOU BEACH-DEVILS LAKE",
    "NORTH MORENCI",
    "PALMYRA",
    "SAND CREEK",
    "TIPTON",
    "WESTON",

    // Townships
    "ADRIAN CHARTER TWP",
    "BLISSFIELD TWP",
    "CAMBRIDGE TWP",
    "CLINTON TWP",
    "DEERFIELD TWP",
    "DOVER TWP",
    "FAIRFIELD TWP",
    "FRANKLIN TWP",
    "HUDSON TWP",
    "MACON TWP",
    "MADISON CHARTER TWP",
    "MEDINA TWP",
    "OGDEN TWP",
    "PALMYRA TWP",
    "RAISIN CHARTER TWP",
    "RIDGEWAY TWP",
    "RIGA TWP",
    "ROLLIN TWP",
    "ROME TWP",
    "SENECA TWP",
    "TECUMSEH TWP",
    "WOODSTOCK TWP",
    
    // Other
    "OUT OF COUNTY"
  };
}
