package net.anei.cadpage.parsers.VA;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchDAPROParser;

/* 
Lunenburg County, VA
Contact: Active911
Agency name: Victoria Fire Rescue Location: Victoria, VA 
Sender: MAILBOX@rushpost.com

VFDS-T ACCIDENT 1133 COURT ST CFS# 2012-005551
VRS-T ACCIDENT 1133 COURT ST CFS# 2012-005551
VRS-T CHEST PAINS 2209 LINCOLN AVE CFS# 2012-005569
VRS-T RESCUE 1404 10TH ST CFS# 2012-005571
VFDS-T OTHER TRAINING CFS# 2012-005577
VRS-T ALLERGIC REACT 1849 OLD COURT ST CFS# 2012-005585
VRS-T ASTHMA 215 FOSTER RD CFS# 2012-005606
VRS-T RESCUE 173 TRAILER PK CFS# 2012-005614
VRS-T RESCUE 1609 LUNENBURG AVE CFS# 2012-005626
VRS-T RESCUE 1409 VICTORIA PLACE CFS# 2012-005627
VRS-T FALLEN 2406 MAIN ST CFS# 2012-005645
VRS-T RESCUE CLAY'S ASSISTED LIVING CFS# 2012-005664
VRS-T MUTUAL AID 1810 TURKEY ISLAND CFS# 2012-005672
VRS-T PREGNANCY 1601 5TH ST CFS# 2012-005676
VRS-T ACCIDENT 601 MECKLENBURG AVE CFS# 2012-005687
VRS-T RESCUE 1504 2ND ST CFS# 2012-005698
VRS-T RESCUE 1605 10TH ST CFS# 2012-005719
VRS-T ACCIDENT 500 MAIN ST CFS# 2012-005732
VRS-T PASSED OUT 110 E 7TH AVE CFS# 2012-005733
VRS-T RESCUE 327 K-V RD CFS# 2012-005734
VRS-T SICK 221 N CIRCLE BVD CFS# 2012-005742
VRS-T FALLEN MARKERS TRIFT CFS# 2012-005753
VRS-T RESCUE 1449 MAYFLOWER RD CFS# 2012-005755
VRS-T RESCUE 138 CENTRAL LANE CFS# 2012-005772
VFDS-T BRUSH FIRE 1817 GALLION TOWN RD CFS# 2012-005794
VRS-T BRUSH FIRE 1817 GALLION TOWN RD CFS# 2012-005794
VFDS-T TREE IN ROAD 1900 8TH ST CFS# 2012-005798
VRS-T TREE IN ROAD 1900 8TH ST CFS# 2012-005798
VFDS-T FIRE ALARM MIDDLE SCHOOL CFS# 2012-005811
VFDS-T BRUSH FIRE BATTES RD CFS# 2012-005833
VFDS-T DUMPSTER FIRE 000000 BAILEY RD CFS# 2012-005849
VRS-T BLEEDING 2585 MARSHALLTOWN RD CFS# 2012-005852
VFDS-T ALARM 583 TOMLINSON RD CFS# 2012-005860
VFDS-T FIRE DAVIS LOWGROUND RD CFS# 2012-005862
VRS-T FIRE 000000 COURTHOUSE SQ CFS# 2012-005862
VFDS-T BRUSH FIRE DAVIS LOWGROUND RD CFS# 2012-005869
VFDS-T PUBLIC SERVICE MECKLENBURG AVE CFS# 2012-005902
VRS-T SICK 4242 FALLS RD CFS# 2012-005920
VRS-T FALLEN 12995 PLANK CFS# 2012-005921
VRS-T RESCUE 2209 LINCOLN AVE CFS# 2012-005971
VRS-T STAND BY MEHERRIN CFS# 2012-005988
VRS-T RESCUE CFS# 2012-006003
VFDS-T BRUSH FIRE 4391 POORHOUSE RD CFS# 2012-006022
VRS-T BRUSH FIRE 4391 POORHOUSE RD CFS# 2012-006022
VRS-T UNRESPONSIVE 2952 REEDY CREEK RD CFS# 2012-006027
VRS-T RESCUE 519 MAIN ST 106 CFS# 2012-006034
VFDS-T ACCIDENT FOWLKES RD CFS# 2012-006066
VRS-T ACCIDENT FOWLKES RD CFS# 2012-006066
VRS-T DIFF BREATHING 690 FALLS RD CFS# 2012-006085
VRS-T RESCUE 2574 NUTBUSH RD CFS# 2012-006094
VRS-T RESCUE 1409 TIDEWATER AVE CFS# 2012-006111
VRS-T RESCUE 634 THOMAS ST CFS# 2012-006125
VFDS-T FIRE ALARM 583 THOMLINSON CFS# 2012-006150
VFDS-T FIRE 3374 POORHOUSE RD CFS# 2012-006152
VRS-T RESCUE 476 CLARKS FARM RD CFS# 2012-006206
VRS-T PUBLIC SERVICE NEBLETT FIELD CFS# 2012-006303
VRS-T RESCUE 1413 11TH ST CFS# 2012-006353
VRS-T SICK 391 TRAILER PARK RD CFS# 2012-006354
VRS-T RESCUE 221 N CIRCLE BVD CFS# 2012-006355
VRS-T RESCUE VICTORIA PLACE APTS 302 CFS# 2012-006356
VRS-T OTHER NEBLETT FIELD RD CFS# 2012-006357
VRS-T RESCUE 359 HART RD CFS# 2012-006366
VRS-T ARGUEMENT 1115 MECKLENBURG AVE CFS# 2012-006381

*/

public class VALunenburgCountyParser extends DispatchDAPROParser {
  
  public VALunenburgCountyParser() {
    super("LUNENBURG COUNTY", "VA");
    setup();
  }
  
  @Override
  public String getFilter() {
    return "MAILBOX@rushpost.com";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    data.strAddress = TRAILER_PK_PTN.matcher(data.strAddress).replaceAll("TRAILER PARK RD");
    return true;
  }
  private static final Pattern TRAILER_PK_PTN = Pattern.compile("\\bTRAILER PK(?: RD)?\\b", Pattern.CASE_INSENSITIVE);
  
  private void setup() {
    setupCallList(
        "ACCIDENT",
        "ALARM",
        "ALERGIC REACT",
        "ARGUMENT",
        "ASTHMA",
        "BLEEDING",
        "BRUSH FIRE",
        "CHEST PAINS",
        "DIFF BREATHING",
        "DUMPSTER FIRE",
        "FALLEN",
        "FIRE",
        "FIRE ALARM",
        "MUTUAL AID",
        "OTHER",
        "OTHER TRAINING",
        "PASSED OUT",
        "PREGNANCY",
        "PUBLIC SERVICE",
        "RESCUE",
        "SICK",
        "STAND BY",
        "TREE IN ROAD",
        "UNRESPONSIVE"
        );
  }
}
