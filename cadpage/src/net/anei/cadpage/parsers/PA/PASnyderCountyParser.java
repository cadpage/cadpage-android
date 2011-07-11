package net.anei.cadpage.parsers.PA;

import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchBParser;

/*
Snyder County, PA
Contact: Jonathan <knightsgk01@yahoo.com>

SNYDER911:IMMTRA>IMMEDIATE TRANSPORT 308 S MARKET ST XS:SASSAFRAS ST SELINSGROVE BORO YOUNG, AMBER Map:Grids:00000,000 CAD:2011-0000005449
SNYDER911:CARSY>CARDIAC SYMPTOMS 2084 ROUTE 522 PENN TWP HUFFNAGLE, CRYSTAL Map:Grids:00000,000 CAD:2011-0000005448
SNYDER911:ILLPER>ILLPERSON 620 UNIVERSITY AVE SELINSGROVE BORO ESHENAUR, MOLLY Map:Grids:00000,000 CAD:2011-0000005444
SNYDER911:GASOUT>GAS ODOR/OUTSIDE 1011 SUNRISE DR SELINSGROVE BORO UGI/SAND Map:Grids:00000,000 CAD 2011-0000005999
SNYDER911:AUTONI>AUTO ACCIDENT/NO INJURY 1769 N SUSQUEHANNA TRL MONROE TWP Map:Grids:00000,000 CAD 2011-0000006003
SNYDER911:FIREWI>FIRE/WILDFIRE 1035 N SUSQUEHANNA TRL XS:SUSQUEHANNA VALLEY MALL DR MONROE TWP DUN, SCOTT Map:00000,000 CAD:2011-0000005987
SYNDER911:AAFIRE>AUTO ALARM/FIRE 111 MARKETPLACE BLVD MONROE TWP SECURITY SERVICE  CO., 8717 Map:Grids: CAD:2011-0000005983
SYNDER911:AUTOIN>AUTO ACCIDENT/INJURY 892 ROUTE 522 PENN TWP Map:Grids:00000,000 Cad:2011-0000005857

*/

public class PASnyderCountyParser extends DispatchBParser {
  
  private static final Pattern CAD_PTN = Pattern.compile(" C[Aa][Dd][ :](?=\\d)");
  
  private static final String[] CITY_LIST = new String[]{
    "BEAVERTOWN BORO",
    "FREEBURG BORO",
    "MCCLURE BORO",
    "MIDDLEBURG BORO",
    "SELINSGROVE BORO",
    "SHAMOKIN DAM BORO",
    
    "ADAMS TWP",
    "BEAVER TWP",
    "CENTER TWP",
    "CHAPMAN TWP",
    "FRANKLIN TWP",
    "JACKSON TWP",
    "MIDDLECREEK TWP",
    "MONROE TWP",
    "PENN TWP",
    "PERRY TWP",
    "SPRING TWP",
    "UNION TWP",
    "WASHINGTON TWP",
    "WEST BEAVER TWP",
    "WEST PERRY TWP"
 };

  public PASnyderCountyParser() {
    super(CITY_LIST, "SNYDER COUNTY", "PA");
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return body.startsWith("SNYDER911:") || body.startsWith("SYNDER911:");
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    body = CAD_PTN.matcher(body).replaceAll(" Cad:");
    body = body.replace(" MAP:", "Map:");
    body = body.replace(" Map:Grids:", " Map: Grids:");
    if (! super.parseMsg(body, data)) return false;
    if (data.strCity.endsWith(" BORO")) {
      data.strCity = data.strCity.substring(0, data.strCity.length()-5);
    }
    return true;
  }
}
