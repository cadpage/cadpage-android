package net.anei.cadpage.parsers.IA;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA28Parser;


public class IABlackHawkCountyParser extends DispatchA28Parser {
  
  public IABlackHawkCountyParser() {
    super(CITY_LIST, "BLACK HAWK COUNTY", "IA");
  }
  
  @Override
  public String getFilter() {
    return "Swmail@bhcso.org,Xmail@connectingyou.com";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    if (data.strCity.equals("RAYMO")) data.strCity = "RAYMOND";
    return true;
  }


  private static final String[] CITY_LIST =new String[]{
      // Incorporated cities
      "CEDAR FALLS",
      "DUNKERTON",
      "ELK RUN HEIGHTS",
      "EVANSDALE",
      "GILBERTVILLE",
      "HUDSON",
      "JANESVILLE",
      "JESUP",
      "LA PORTE CITY",
      "RAYMOND",
      "RAYMO",
      "WATERLOO",
      
      // Unincorporated areas
      "DEWAR",
      "EAGLE CENTER",
      "FINCHFORD",
      "GLASGOW",
      "VOORHIES",
      "WASHBURN",
      
      // Townships
      "BARCLAY",
      "BENNINGTON",
      "BIG CREEK",
      "BLACK HAWK",
      "CEDAR",
      "CEDAR FALLS",
      "EAGLE",
      "EAST WATERLOO",
      "FOX",
      "LESTER",
      "LINCOLN",
      "MOUNT VERNON",
      "ORANGE",
      "POYNER",
      "SPRING CREEK",
      "UNION",
      "WASHINGTON",

  };
}
