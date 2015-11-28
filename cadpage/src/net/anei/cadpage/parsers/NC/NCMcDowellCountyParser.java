
package net.anei.cadpage.parsers.NC;

import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SplitMsgOptions;
import net.anei.cadpage.parsers.SplitMsgOptionsCustom;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

public class NCMcDowellCountyParser extends DispatchSouthernParser {

  public NCMcDowellCountyParser() {
    super(CITY_LIST, "MCDOWELL COUNTY", "NC", DSFLAG_OPT_DISPATCH_ID |   DSFLAG_LEAD_PLACE | DSFLAG_ID_OPTIONAL | DSFLAG_FOLLOW_CROSS);
  }
  
  @Override
  public SplitMsgOptions getActive911SplitMsgOptions() {
    return new SplitMsgOptionsCustom();
  }

  @Override
  public boolean parseMsg(String body, Data data) {
    if (! super.parseMsg(body, data)) return false;
    data.strCall = stripFieldEnd(data.strCall, "-");
    if (data.strCity.equalsIgnoreCase("MARION AREA") || data.strCity.equalsIgnoreCase("MARION CITY")) {
      data.strCity = "MARION";
    }
    return true;
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    addr = PK_PTN.matcher(addr).replaceAll("PARK");
    return super.adjustMapAddress(addr);
  }
  private static final Pattern PK_PTN = Pattern.compile("\\bPK\\b", Pattern.CASE_INSENSITIVE);
  
  @Override
  public String adjustMapCity(String city) {
    city = city.toUpperCase();
    city = stripFieldEnd(city, " AREA");
    return convertCodes(city, MAP_CITY_TABLE);
  }
  
  private static final Properties MAP_CITY_TABLE = buildCodeTable(new String[]{
      "HANKINS NORTH FORK", "MARION",
      "PG",                 "MARION",
      "PLEASANT GARDEN",    "MARION",
      "WOODLAWN",           "MARION"
  });
  
  private static final String[] CITY_LIST = new String[]{
    //cities
    "MARION",
    "MARION AREA",
    "MARION CITY",
    
    "HANKINS NORTH FORK",
    "WOODLAWN",
    
    //towns
    "OLD FORT",
    "OLD FORT AREA",
    "OLD FORT TOWN",
    
    //Census-designated place
    "WEST MARION",
    
    //Unincorporated communities

    "GLENWOOD",
    "LINVILLE FALLS",
    "LITTLE SWITZERLAND",
    "NEBO",
    "NORTH COVE",
    "PG",
    "PLEASANT GARDENS",
    "PROVIDENCE",

    //townships
    "CROOKED CREEK",
    "DYSARTSVILLE",
    "MONTFORD COVE",
    "PLEASANT GARDENS",
    "WOODLAWN-SEVIER",
    "SUGAR HILL",
    
    // Buncombe County
    "ASHEVILLE",
    "BLACK MOUNTAIN"
  };
}
