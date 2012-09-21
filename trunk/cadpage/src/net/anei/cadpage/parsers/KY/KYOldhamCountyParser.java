package net.anei.cadpage.parsers.KY;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchEmergitechParser;

/*
Oldham County, KY
Contact: Michael Thompson <Michael.Thompson@ballardsvillefire.com>
Sender: dispatch@oldhamcountyky.gov
Sender: textmsg@ballardsvillefire.com

[081890]- NATURE: FIRE,ILLEGAL BURNING LOCATION: 2015 CLARKE POINTE DR LAGRANGE BETWEEN QUARRY CT / LAKE RIDGE WAY ACC ESS BY S HWY 53
[239952]- NATURE: EMS CALL LOCATION: 5325 BROOKSWOOD RD CRES TWOOD BETWEEN BROOKSWOOD CT / BROOKSWOOD LOOP RD ACCESS BY WOODSBORO RD COMMENTS: 78 YOM
[133685]- NATURE: FIRE,STRUCTURE LOCATION: 3001 W HWY 146 LA GRANGE BETWEEN KINGS LN / PARKER (KSR ENTRANCE) DR COMMENTS : HEAVY SMOKE IN DORM ONE
[072502]- NATURE: FIRE,ALARM RESIDENTIAL LOCATION: 6908 COLT ON RD CRESTWOOD BETWEEN COLTON CT / DEAD END ACCESS BY CRO SS RUN DR COMMENTS: FIRE ALARM
[106873]- NATURE: FIRE,STRUCTURE LOCATION: 1025 NEW MOODY LN LAGRANGE BETWEEN EDEN PKWY / SANIBEL WAY ACCESS BY S 1ST
[031438]- NATURE: EMS CALL LOCATION: 3016 ANN TRESE CV LAGRA NGE BETWEEN DEAD END / S HWY 53 ACCESS BY E HWY 22 OR S HW Y 53 COMMENTS: 55YOM ACTIVE SZ

Contact: Active911
Agency name: Ballardsville Fire Rescue Location: Crestwood, KY 
[133685]- NATURE: EMS CALL LOCATION: 1202 WEIBLE RD CRESTWOO D BETWEEN PAYTON LN / DEAD END ACCESS BY PAYTON LN COMMENT S: 74 YOM NUMBNESS AND TINGLING ON RIGHT SIDE

 */


public class KYOldhamCountyParser extends DispatchEmergitechParser {
  
  public KYOldhamCountyParser() {
    super("", 60, CITY_LIST, "OLDHAM COUNTY", "KY");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@oldhamcountyky.gov,textmsg@ballardsvillefire.com";
  }
  
  
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // If preparser removed the dispatch unit, put it back
    if (subject.length() > 0) body = '[' + subject + "]" + body; 
    if (!super.parseMsg(body, data)) return false;
    if (data.strCity.equalsIgnoreCase("LAGRANGE")) data.strCity =  "LA GRANGE";
    return true;
  }



  private static final String[] CITY_LIST = new String[]{
    "BALLARDSVILLE",
    "BROWNSBORO",
    "BUCKNER",
    "CENTERFIELD",
    "CRESTWOOD",
    "FLOYDSBURG",
    "GOSHEN",
    "LAGRANGE",
    "LA GRANGE",
    "ORCHARD GRASS HILLS",
    "PARK LAKE",
    "PEWEE VALLEY",
    "PROSPECT",
    "RIVER BLUFF",
    "WESTPORT"
  };
}
