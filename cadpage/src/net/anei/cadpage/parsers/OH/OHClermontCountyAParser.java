package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchBParser;

/**
 * Clermont county, OH
 */
public class OHClermontCountyAParser extends DispatchBParser {

  public OHClermontCountyAParser() {
    super(CITY_CODES, "CLERMONT COUNTY", "OH");
  }
  
  @Override
  public String getFilter() {
    return "911-CENTER@clermontcountyohio.gov,777,888";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    body = body.replace("CAD#","Cad:");
  
    if (body.startsWith("/ ")) body = body.substring(2).trim();
    return super.parseMsg(body, data);
  }

  @Override
  protected boolean isPageMsg(String body) {
    return body.contains(" Cad:") || body.contains("CAD#") && !body.startsWith("EVENT: ");
    
  }
  
  private static final String[] CITY_CODES = new String[]{
    "BATAVIA TOWNSHIP", "FRANKLIN TOWNSHIP", "GOSHEN TOWNSHIP", 
    "JACKSON TOWNSHIP", "MIAMI TOWNSHIP", "MONROE TOWNSHIP", "OHIO TOWNSHIP", 
    "PIERCE TOWNSHIP", "STONELICK TOWNSHIP", "TATE TOWNSHIP", "UNION TOWNSHIP",
    "WASHINGTON TOWNSHIP", "WAYNE TOWNSHIP", "WILLIAMSBURG TOWNSHIP",
    
    "BATAVIA TWP", "FRANKLIN TWP", "GOSHEN TWP", 
    "JACKSON TWP", "MIAMI TWP", "MONROE TWP", "OHIO TWP", 
    "PIERCE TWP", "STONELICK TWP", "TATE TWP", "UNION TWP",
    "WASHINGTON TWP", "WAYNE TWP", "WILLIAMSBURG TWP",
    
    "AFTON", "AMELIA", "BANTAM", "BATAVIA", "BELFAST", "BETHEL", "BRANCH HILL",
    "CHILO", "CLERMONTVILLE", "EDENTON", "FELICITY", "GLEN ESTE", "GOSHEN",
    "HAMLET", "HULINGTON", "LAUREL", "LERADO", "LINDALE", "LOCUST CORNER",
    "LOVELAND", "MARATHON", "MIAMIVILLE", "MILFORD", "MONTEREY", "MOSCOW",
    "MOUNT CARMEL", "MOUNT HOLLY", "MOUNT PISGAH", "MOUNT REPOSE", "MULBERRY",
    "NEVILLE", "NEW RICHMOND", "NEWTONSVILLE", "NICHOLSVILLE", "OLIVE BRANCH",
    "OWENSVILLE", "PALESTINE", "PERINTOWN", "POINT ISABEL", "POINT PLEASANT", 
    "SALTAIR", "SUMMERSIDE", "TOBASCO", "UTOPIA", "WIGGONSVILLE", "WILLIAMSBURG",
    "WITHAMSVILLE", "WOODVILLE"
  };

}