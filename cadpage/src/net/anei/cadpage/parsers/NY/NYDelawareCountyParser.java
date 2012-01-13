package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchBParser;

/*
Delaware County, NY
Contact: "Fleischmanns 1st. Asst. Chief" <ffd1302@gmail.com>
Sender: delco911@co.delaware.ny.us

DELCO911:MVA >MOTOR VEHICLE ACCIDENT 2460 BIG RED KILL RD XS: WOOLHEATER RD MIDDLETOWN MACK, BONNIE LEE Map:54,54CC Grids:0,0 Cad: 2012-0000000256
DELCO911:WIRE >WIRE(S) DOWN 635 STREETER HILL RD MIDDLETOWN ANDERSON, DONALD E Map: Grids:0,0 Cad: 2011-0000016430
DELCO911:RD HAZ>ROAD HAZARD STATE HIGHWAY 28 MIDDLETOWN FINCH, FELICIA Cad: 2011-0000015967
DELCO911:ALMACT>ALARM ACTIVATION LOWER WAGNER AVE FLEISCHMANN Cad: 2011-0000015508
DELCO911:EMS >MEDICAL EMERGENCY 1141 MAIN ST XS: OLD HALCOTT RD FLEISCHMANNS VILLAGE WIRELESS-AT&T MOBILITY(TCS) Map:54CD Grids:0,0 Cad: 2011-0000015068
DELCO911:09D01 >CARDIAC/RESPIRATORY ARREST 451 BARLEY RD XS: COUNTY LINE MIDDLETOWN AJONDEAU, ARMAND Map:55 Grids:0,0 Cad: 2011-0000013362
DELCO911:09E01 >CARDIAC/RESPIRATORY ARREST 1050 MAIN ST XS: REDKILL RD FLEISCHMANNS VILLAGE PATEL MANISHA Map:54CD Grids:0,0 Cad: 2011-0000013284
DELCO911:ALMACT>ALARM ACTIVATION LOWER WAGNER AVE FLEISCHMANN Cad: 2011-0000015508

**** Should not parse ****
DELCO911:EFFECTIVE IMMEDIATELY - THE SEASONAL SECTION OF TODD MTN ROAD IN FLEISCHMANNS WILL BE CLOSED AND BARRICADED UNTIL 4/1/2012.

*/

public class NYDelawareCountyParser extends DispatchBParser {
  
  public NYDelawareCountyParser() {
    super(CITY_CODES, "DELAWARE COUNTY", "NY");
  }
  
  @Override
  public String getFilter() {
    return "delco911@co.delaware.ny.us";
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    if (!body.startsWith("DELCO911:")) return false;
    int pt = body.indexOf('>', 10);
    if (pt < 0 || pt > 20) return false;
    return true;
  }
  
  @Override
  protected boolean parseAddrField(String field, Data data) {
    if (!super.parseAddrField(field, data)) return false;
    if (data.strCity.equals("FLEISCHMANN")) data.strCity = "FLEISCHMANNS";
    return true;
  }



  private static final String[] CITY_CODES = new String[]{
    "ANDES",
    "BOVINA",
    "COLCHESTER",
    "DAVENPORT",
    "DELHI",
    "DEPOSIT",
    "DOWNSVILLE",
    "FLEISCHMANN",
    "FLEISCHMANNS",
    "FRANKLIN",
    "HAMDEN",
    "HANCOCK",
    "HARPERSFIELD",
    "HOBART",
    "KORTRIGHT",
    "MARGARETVILLE",
    "MASONVILLE",
    "MEREDITH",
    "MIDDLETOWN",
    "ROXBURY",
    "SIDNEY",
    "STAMFORD",
    "TOMPKINS",
    "WALTON"
  };
}
