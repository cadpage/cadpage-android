package net.anei.cadpage.parsers.PA;


import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;



public class PAJuniataCountyParser extends DispatchB2Parser {
 
  public PAJuniataCountyParser() {
    super("JUNIATA911:", CITY_LIST, "JUNIATA COUNTY", "PA");
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    body = stripFieldStart(body, "JUNIATA911@juniatapa ");
    // TODO Auto-generated method stub
    return super.parseMsg(body, data);
  }

  @Override
  public String getFilter() {
    return "UNIATA911@Juniata.PA";
  }
  
  public static final String[] CITY_LIST = new String[]{
    // Boroughs
    "MIFFLIN",
    "MIFFLINTOWN",
    "PORT ROYAL",
    "THOMPSONTOWN",
    
    //Townships
    "BEALE",
    "DELAWARE",
    "FAYETTE",
    "FERMANAGH",
    "GREENWOOD",
    "LACK",
    "MILFORD",
    "MONROE",
    "SPRUCE HILL",
    "SUSQUEHANNA",
    "TURBETT",
    "TUSCARORA",
    "WALKER"
  };

}