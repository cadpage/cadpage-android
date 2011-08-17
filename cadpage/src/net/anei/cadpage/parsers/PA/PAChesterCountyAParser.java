package net.anei.cadpage.parsers.PA;
import java.util.Properties;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmsMsgParser;


/* 
 * Chester County, PA
Contact: "buckhunter1113@aol.com" <buckhunter1113@aol.com>
Sender: gallison39@comcast.net

 Initial Type: ACCINJA    Final Type:ACCINJA (ACCIDENT - INJURIES / ALS *) 
 Loc: W BALTIMORE PK/SCARLETT RD ,60    (V) AKA:

 Initial Type: BFALL      Final Type: BFALL   (FALLS - BLS / LIFT ASSIST *)
 Loc: 118 RACE ST ,03 -- RACE PARK APTS btwn E STATE ST & E C

 Initial Type: BSICK      Final Type: BSICK   (SICK PERSON - BLS *) 
 Loc: 415 MEGAN CT ,62  btwn VICTORIA GARDENS DR & AZALEA LA (V)
 AKA

 Initial Type: ACVA       Final Type: ACVA    (CVA/STROKE - ALS *)
 Loc: 509 HAZEL AV ,03  btwn N WALNUT ST & WILSON RD (V)
 AKA:   Munic

 Initial Type: ALARMF     Final Type: ALARMF  (ALARM - FIRE *)
 Loc: 100 E SOUTH ST ,03 -- KENNETT HIGH SCHOOL btwn S BROAD ST & CHURCH A

 Initial Type: AOD        Final Type: AOD     (OVERDOSE - ALS *)
 Loc: 6 WAYS LA ,62  btwn MUNICIPAL BOUNDARY & E CYPRESS ST (V)
 AKA:
 
(Station 24 EMS Call) Initial Type: BSICK      Final Type: BSICK
(SICK PERSON - BLS *)
Loc: 301 VICTORIA GARDENS DR ,62 -- BRANDYWINE ASSISTED LIVNG btwn L

Subject:Station24 Fire Call<br>\n Initial Type: ACCUNK     Final Type: ACCUNK  (ACCIDENT - UNKNOWN INJURIES *)  Loc: SB RT 82 SO E SOUTH ST ,0&#13;<br>

CHIMNEY FIRE **1905 LENAPE UNIONVILLE RD*RED LION RD & MUNICIPAL BOUNDA*POCOPS*21:30*WOOD STOVE IN BASEMENT, F
 */


public class PAChesterCountyAParser extends SmsMsgParser {
  
  public PAChesterCountyAParser() {
    super("CHESTER COUNTY", "PA");
  }
  
  @Override
  public String getFilter() {
    return "gallison39@comcast.net";
  }


  @Override
  protected boolean parseMsg(String body, Data data) {
    
    if (!body.contains("Initial Type:")) return false;

    int pt = body.indexOf("Final Type:"); 
    if (pt < 0) return false;
    body = body.substring(pt+6);

    // Replace key chars for easier parsing
    body = body.replace("\n"," ");
    body = body.replace(" btwn "," btwn:");

    Properties props = parseMessage(body, new String[]{"Type","Loc","btwn","AKA"});
    data.strCall = props.getProperty("Type", "");
    data.strCross = props.getProperty("btwn", "");

    //Get address up to comma
    String sAddress = props.getProperty("Loc", "");
    int ptc = sAddress.indexOf(",");
    if (ptc >= 0) sAddress = sAddress.substring(0,ptc).trim();
    parseAddress(sAddress, data);
    
    data.strSupp = props.getProperty("AKA", "");
    
    return true;
  }
} 
