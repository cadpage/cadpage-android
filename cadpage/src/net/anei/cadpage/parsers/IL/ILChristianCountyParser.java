package net.anei.cadpage.parsers.IL;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchEmergitechParser;

/**
 * Christian County, IL
 */
public class ILChristianCountyParser extends DispatchEmergitechParser {
  
  public ILChristianCountyParser() {
    super("ChristianCounty911:", 0, CITY_LIST, "CHRISTIAN COUNTY", "IL");
  }
  
  public String getFilter() {
    return "panafiredepartment@gmail.com";
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
  private class MyAddressField extends BaseAddressField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace('@',  '/');
      super.parse(field, data);
    }
  }

  private static final String[] CITY_LIST = new String[]{
      
      //Cities
      
      "ASSUMPTION",
      "PANA",
      "TAYLORVILLE",

      //Villages

      "BULPITT",
      "EDINBURG",
      "HARVEL",
      "JEISYVILLE",
      "KINCAID",
      "MORRISONVILLE",
      "MOUNT AUBURN",
      "MOWEAQUA",
      "OWANECO",
      "PALMER",
      "STONINGTON",
      "TOVEY",

      //Unincorporated
      "CLARKSDALE",
      "DUNKEL",
      "HEWITTSVILLE",
      "LANGLEYVILLE",
      "MILLERSVILLE",
      "OLD STONINGTON",
      "RADFORD",
      "ROSAMOND",
      "SHARPSBURG",
      "WILLEY STATION",
      
      //Townships
      "ASSUMPTION",
      "BEAR CREEK",
      "BUCKHART",
      "GREENWOOD",
      "JOHNSON",
      "KING",
      "LOCUST",
      "MAY",
      "MOSQUITO",
      "MOUNT AUBURN",
      "PANA TOWNSHIP",
      "PRAIRIETON",
      "RICKS",
      "ROSAMOND",
      "SOUTH FORK",
      "STONINGTON",
      "TAYLORVILLE",
      
      // Montgomery County
      "NOKOMIS"
  };
}
