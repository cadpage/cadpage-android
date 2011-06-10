/*
Chilton County, AL
Contact: Scott Hooper <evfd1326@gmail.com>
Contact: d w <miswtl@gmail.com>
Sender: dispatch@chiltoncounty.org
Use DispatchSouthernParser
120 COUNTY RD 377 BILLINGSLEY 2011040762 18:41:28 MENTAL PERSON/PATIENT CUTTING HIMSELF, ALTERED MENTAL STATUS
COUNTY RD 57 \ COUNTY RD 445 2011039172 06:20:45 WRECK-UNKNOWN INJURIES CALLER STATES ONE VEHICLE OVERTURNED.. ADV THAT THE SUBJECT IS OUT OF THE VEHICLE
120 COUNTY RD 377 BILLINGSLEY 2011040762 18:41:28 MENTAL PERSON/PATIENT CUTTING HIMSELF, ALTERED MENTAL STATUS
100 COUNTY RD 99 LOT 5 VERBENA 2011043298 18:37:55 SHORTNESS OF BREATH GRANDMOTHER ON CHEMO NOT DOING GOOD 
518 COUNTY RD 221 THORSBY 2011046746 06:20:05 DIABETIC RESIDENCE IS A BEIGE DOUBLE WIDE WITH MAROON SHUTTERS. RED TOYOTA AND BLACK DODGE IN THE BACK YARD

*/

package net.anei.cadpage.parsers.AL;

import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;


public class ALChiltonCountyParser extends DispatchSouthernParser {
  
  private static final String[] CITY_LIST = new String[]{
    "CLANTON",
    "ISABELLA",
    "JEMISON",
    "MAPLESVILLE",
    "MOUNTAIN CREEK",
    "STANTON",
    "THORSBY",
    "VERBENA",
    "BILLINGSLEY", 
  };

  public ALChiltonCountyParser() {
    super(CITY_LIST, "CHILTON COUNTY", "AL");
    
    
  }
  @Override
  public String getFilter() {
    return "3365043576";
  }
  

}
