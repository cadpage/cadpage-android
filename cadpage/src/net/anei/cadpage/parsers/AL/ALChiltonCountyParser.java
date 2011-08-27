
package net.anei.cadpage.parsers.AL;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

/*
Chilton County, AL
Contact: Scott Hooper <evfd1326@gmail.com>
Contact: d w <miswtl@gmail.com>
Sender: dispatch@chiltoncounty.org

120 COUNTY RD 377 BILLINGSLEY 2011040762 18:41:28 MENTAL PERSON/PATIENT CUTTING HIMSELF, ALTERED MENTAL STATUS
COUNTY RD 57 \ COUNTY RD 445 2011039172 06:20:45 WRECK-UNKNOWN INJURIES CALLER STATES ONE VEHICLE OVERTURNED.. ADV THAT THE SUBJECT IS OUT OF THE VEHICLE
120 COUNTY RD 377 BILLINGSLEY 2011040762 18:41:28 MENTAL PERSON/PATIENT CUTTING HIMSELF, ALTERED MENTAL STATUS
100 COUNTY RD 99 LOT 5 VERBENA 2011043298 18:37:55 SHORTNESS OF BREATH GRANDMOTHER ON CHEMO NOT DOING GOOD 
518 COUNTY RD 221 THORSBY 2011046746 06:20:05 DIABETIC RESIDENCE IS A BEIGE DOUBLE WIDE WITH MAROON SHUTTERS. RED TOYOTA AND BLACK DODGE IN THE BACK YARD

Contact: d w <miswtl@gmail.com>
2645 COUNTY RD 37 THORSBY 2011050014 00:31:53 ASSIST OCCUPANT 91 YOM HAS FALLEN; LIFTING ASSISTANCE ONLY
905 COUNTY RD 402 CLANTON 2011050250 05:43:58 GENERAL ILLNESS 57 YO FEMALE // NERVE PROBLEMS // PERMENANT NERVE DAMAGE //

Contact: Scott Hooper <evfd1326@gmail.com>
  / 3669 COUNTY RD 49 CLANTON 2011052209 11:18:28 FALL ELDERLY MALE FELL\n


*/


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
    super(CITY_LIST, "CHILTON COUNTY", "AL", 0);
    
    
  }
  @Override
  public String getFilter() {
    return "dispatch@chiltoncounty.org";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    body = body.replace('\\', '/');
    body = body.replaceAll("\\bCOUNTY RD\\b", "CO");
    if (body.startsWith("/")) body = body.substring(1).trim();
    if (! super.parseMsg(body, data)) return false;
    data.strAddress = data.strAddress.replaceAll("\\bCO\\b", "COUNTY RD");
    return true;
  }
}
