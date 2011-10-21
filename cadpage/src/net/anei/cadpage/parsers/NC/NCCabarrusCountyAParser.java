package net.anei.cadpage.parsers.NC;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/* 
Cabarrus County, NC
Contact: Michael Martocchio <maccaronimartocchio@gmail.com>
Sender: CAD@cabarruscounty.us

CAD:ASSAULT W/ INJURY;2339 ODELL SCHOOL RD;CON;CONCORD HOUSE;HILLSDELL DR;LOCKWOOD RD;RAINTREE, HEALTH CARE OF CONCO
CAD:BREATHING PROBLEMS;5412 ASHBURY LN;DAV;TERRILL RIDGE DR;TERRILL RIDGE DR;BRACEY III JOSEPH O     
CAD:STRUCTURE FIRE;1606 DUCKHORN ST NW;CON;From CPD:;RAVENSCROFT LN NW;INDIAN BEECH AV NW;BUCKELEW, HEATHER     
CAD:LOCAL RESPONSE;509 THREE GREENS DR;HUN;WOODHALL DR;VINTAGE HILL LN
CAD:ASSAULT W/ INJURY;2339 ODELL SCHOOL RD;CON;CONCORD HOUSE;HILLSDELL DR;LOCKWOOD RD;RAINTREE, HEALTH CARE OF CONCO   
CAD:FIRE STANDBY;4240 SHILOH CHURCH RD;DAV;ODELL VFD STATION 2;MARIPOSA PL;ODELL SCHOOL RD;KPD   
CAD:FALL WITH INJURY;1087 ODELL SCHOOL RD;CONCORD;UNTZ RD;ARBOR COMMONS LN 

Contact: "codymac08@yahoo.com" <codymac08@yahoo.com>
CAD:FALL WITH INJURY;8552 INDIAN SUMMER TR;HAR;TOM SAVAGE DR

Contact:  
Travis McGhee <mcgheetp@gmail.com>
CAD:DAVIDSON RD/MOORESVILLE RD;DAV;SUSPICIOUS VEHICLE
CAD:CANCEL;DAVIDSON RD/MOORESVILLE RD; DAV

Contact: ryan sellers <rsellers43@gmail.com>
Sender: 93001015
CAD:ASSAULT W/ INJURY;5048 DAFFODIL LN;CON;BRAXTON DR;SABLE CT;BRITTANY STIREWALT

*/

public class NCCabarrusCountyAParser extends DispatchOSSIParser {
  
  private static Properties CITY_CODES = buildCodeTable(new String[]{
      "HAR",  "HARRISBURG",
      "HUN",  "HUNTERSVILLE",
      "MP",   "MT PLEASANT",
      "CON",  "CONCORD",
      "KAN",  "KANNAPOLIS",
      "DAV",  "DAVIDSON",
      "LOC",  "LOCUST",
      "CLT",  "CHARLOTTE",
      "MID",  "MIDLAND"
  });
  
  @Override
  public String getFilter() {
    return "CAD@cabarruscounty.us, 93001";
  }
  
  public NCCabarrusCountyAParser() {
    super(CITY_CODES, "CABARRUS COUNTY", "NC",
           "CALL! ADDR! CITY PLACE? X X NAME");
  }
}
