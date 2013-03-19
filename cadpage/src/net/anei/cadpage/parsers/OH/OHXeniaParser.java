package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class OHXeniaParser extends FieldProgramParser {
  
  public OHXeniaParser() {
    super(CITY_LIST, "GREENE COUNTY", "OH",
           "CALL Location:ADDR! Time:SKIP Units:UNIT Common_Name:NAME Info:INFO");
  }
  
  @Override
  public String getFilter() {
    return "psisn_dispatch@ci.xenia.oh.us";
  }
  
  private class MyAddressField extends AddressField {

    @Override
    public void parse(String field, Data data) {
      
      // Make one pass to parser the city from the end of the field
      parseAddress(StartType.START_PLACE, FLAG_ONLY_CITY | FLAG_ANCHOR_END, field, data);
      String city = data.strCity;
      String addr = data.strPlace;
      data.strPlace = "";
      
      // Now that city has been taken care of, we can look for a regular address
      // This call should ignore the defined city list
      parseAddress(StartType.START_ADDR, FLAG_CROSS_FOLLOWS | FLAG_NO_CITY, addr, data);
      
      // Followed by place name and cross street
      Parser p = new Parser(getLeft());
      data.strPlace = p.getOptional(',');
      data.strCross = p.get();
      
      if (city.equals("CAESARCREEK TWP")) city = "CAESARSCREEK TWP";
      data.strCity = city;
    }

    @Override
    public String getFieldNames() {
      return "ADDR PLACE X CITY";
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
  private static final String[] CITY_LIST = new String[]{
    
    // Cities
    "BEAVERCREEK",
    "BELLBROOK",
    "CENTERVILLE",
    "FAIRBORN",
    "HUBER HEIGHTS",
    "KETTERING",
    "XENIA",
    
    // Villages
    "BOWERSVILLE",
    "CEDARVILLE",
    "CLIFTON (PART)",
    "JAMESTOWN",
    "SPRING VALLEY",
    "YELLOW SPRINGS",
    
    // Townships
    "BATH TWP",
    "BEAVERCREEK TWP",
    "CAESARCREEK TWP",
    "CEDARVILLE TWP",
    "JEFFERSON TWP",
    "MIAMI TWP",
    "NEW JASPER TWP",
    "ROSS TWP",
    "SILVERCREEK TWP",
    "SPRING VALLEY TWP",
    "SUGARCREEK TWP",
    "XENIA TWP",

    //Other
    "SHAWNEE HILLS",
    "WILBERFORCE",
    "WRIGHT-PATTERSON AIR FORCE BASE",
    "BYRON",
    "OLDTOWN",

  };
}
