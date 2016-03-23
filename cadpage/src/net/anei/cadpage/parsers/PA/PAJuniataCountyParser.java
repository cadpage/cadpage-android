package net.anei.cadpage.parsers.PA;


import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA48Parser;


public class PAJuniataCountyParser extends DispatchA48Parser {
 
  public PAJuniataCountyParser() {
    super(CITY_LIST, "JUNIATA COUNTY", "PA", FieldType.X_NAME, A48_OPT_ONE_WORD_CODE);
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    body = stripFieldStart(body, "@co.juniata.pa.us,@juniata.pa");
    return super.parseMsg(subject, body, data);
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