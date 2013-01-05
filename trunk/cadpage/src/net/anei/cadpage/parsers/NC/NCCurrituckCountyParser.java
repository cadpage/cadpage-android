package net.anei.cadpage.parsers.NC;

import java.util.Properties;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;



public class NCCurrituckCountyParser extends DispatchOSSIParser {
  
  public NCCurrituckCountyParser() {
    super(CITY_CODES, "CURRITUCK COUNTY", "NC",
           "F6? CALL ADDR/S! CITY? PLACENAME PHONE");
  }
  
  @Override
  public String getFilter() {
    return "CAD@co.currituck.nc.us";
  }
  
  private class MyPlaceNameField extends PlaceNameField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("(S)") && field.endsWith("(N)")) {
        data.strPlace = field.substring(3,field.length()-3).trim();
      } else {
        data.strName = field;
      }
    }
  }
  
  @Override
  protected Field getField(String name) {
    if (name.equals("F6")) return new SkipField("F6");
    if (name.equals("PLACENAME")) return new MyPlaceNameField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "CRLA", "COROLLA",
      "DUCK", "DUCK",
  });
}
