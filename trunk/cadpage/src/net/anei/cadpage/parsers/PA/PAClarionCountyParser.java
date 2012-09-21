package net.anei.cadpage.parsers.PA;


import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchBParser;


/*
Clarion County, PA
Contact: chris cochran <topher55@yahoo.com>
Sender: 911-CENTER@oes.clarion.pa.us
System: Interact
911-CENTER:52C03 >FIRE ALARM COMMERCIAL/INDUST 101 MAPLE DR XS: ROUTE 322 ELK TWP MC ALARMS 6077869897 Map: Grids:G-10, Cad: 2012-0000012260
911-CENTER:67D05 >REFINERY/TANK FARM/FUEL STORAG 180 E STATE ST XS: POPETOWN RD KNOX BORO LORRY 7245043418 Map: Grids:H-07, Cad: 2012-0000011908
911-CENTER:ELECHZ>ELECTRICAL HAZARD KLINE RD&ROUTE 322 XS: ROUTE 322 ASHLAND TWP MILLIRON, DAVE Cad: 2012-0000011794
911-CENTER:29B01 >ACCIDENT INJURIES 5024 ROUTE 208 XS: KLINE RD SALEM TWP DAUGHERTY , JOHN 8147581955 Map: Grids:H-05, Cad: 2012-0000011605
911-CENTER:61D01 >UNCONTAINED HAZMAT 53400 INTERSTATE 80 EB XS: MP 53 BEAVER TWP RUSS 2165489760 Map: Grids:J-06, Cad: 2012-0000011327
911-CENTER:TRAFCO>TRAFFIC CONTROL RT 338 WENTLINGS CORS Cad: 2012-0000011317

*/

public class PAClarionCountyParser extends DispatchBParser {
 
  public PAClarionCountyParser() {
    super(CITY_LIST, "CLARION COUNTY", "PA");
  }
  
  @Override
  public String getFilter() {
    return "911-CENTER@oes.clarion.pa.us";
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return body.startsWith("911-CENTER:");
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    if (data.strCity.toUpperCase().endsWith(" BORO")) {
      data.strCity = data.strCity.substring(0,data.strCity.length()-5).trim();
    }
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{
    "CALLENSBURG BORO",
    "CLARION BORO",
    "EAST BRADY BORO",
    "EMLENTON BORO",
    "FOXBURG BORO",
    "HAWTHORN BORO",
    "KNOX BORO",
    "NEW BETHLEHEM BORO",
    "RIMERSBURG BORO",
    "SHIPPENVILLE BORO",
    "SLIGO BORO",
    "ST PETERSBURG BORO",
    "STRATTANVILLE BORO",
    
    "ASHLAND TWP",
    "BEAVER TWP",
    "BRADY TWP",
    "CLARION TWP",
    "ELK TWP",
    "FARMINGTON TWP",
    "HIGHLAND TWP",
    "KNOX TWP",
    "LICKING TWP",
    "LIMESTONE TWP",
    "MADISON TWP",
    "MILLCREEK TWP",
    "MONROE TWP",
    "PAINT TWP",
    "PERRY TWP",
    "PINEY TWP",
    "PORTER TWP",
    "REDBANK TWP",
    "RICHLAND TWP",
    "SALEM TWP",
    "TOBY TWP",
    "WASHINGTON TWP"
  };
}