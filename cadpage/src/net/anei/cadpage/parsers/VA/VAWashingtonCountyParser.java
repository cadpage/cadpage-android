package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

/*
Washington County, VA
Contact: Chris Bryant <cbryant@bdsarco.org>
Contact: Mike White <cwwilliamsfire@comcast.net> (historical)
System: Southeastern Software (PageGate)
Sender: NSCOTT@washcova.com

NSCOTT:13604 PRICES BRIDGE RD GLADE SPRING SANTANA GALLIHER 2766080200 1220015 23:27:05 MVA IVE BEEN IN A WRECK, I HIT A TREE, MY CAR IS TOTALLED, THE VEHICLE I
LSTRINGER:215 SWEET BRIER ST GLADE SPRING JASON 2764518304 1219928 09:15:17 SICK CALL 30YO FEMALE IS VOMITING, HAS BACK PAIN, FEELS FAINT.
BDULA:228 MIMOSA ST APT A GLADE SPRING SPRINT NEXTEL - CDMA 2764926648 1219900 00:21:44 SICK CALL HE IS STILL SICK AND THROWING UP
LSTRINGER:PETRO TRUCK CENTER 12433 MAPLE ST GLADE SPRING CARDINAL TRAVEL CENTER/JONATHAN 2764296000 1219922 07:26:55 AMBULANCE NEEDED INCOHERENT FEMALE, POSS.
MEVANS:11585 MOUNT CALM DR APT 8 GLADE SPRING WEBB,CYNTHIA 2766950260 1219667 14:52:22 SICK CALL 62 YO MALE SHORT OF BREATH AND HURTS TO COUGH
NSCOTT:13604 PRICES BRIDGE RD GLADE SPRING SANTANA GALLIHER 2766080200 1220015 23:27:05 MVA IVE BEEN IN A WRECK, I HIT A TREE, MY CAR IS TOTALLED, THE VEHICLE I
TRAINEE_1:33137 LIGHTHOUSE HILL GLADE SPRING MILLER, BRENDA 2764964267 1219961 15:38:46 TREE DOWN CALLER ADVISED THAT A TREE HAS FALLEN ON THE POWER LINE AND BDULA:228 MIMOSA ST GLADE SPRING SPRINT NEXTEL - CDMA 1219760 01:25:30 SICK CALL HE IS THROWING UP HE IS 51 YEARS OLD
DHARTSOCK:304 EVERGREEN ST GLADE SPRING SMITH, P N 2764295639 1219281 09:38:45 AMBULANCE NEEDED 73 Y/O FEMALE HIGH BP AND HAVING CHANGES IN VISION NEEDS TO G
JMARTIN:32497 CLINCHBURG RD MEADOWVIEW CRUEY, JANE S 2769445787 1218968 09:18:26 STROKE CALLER STATES HIS DAD IS HAVING A STROKE
DHARTSOCK:30077 HILLMAN HWY MEADOWVIEW ASSISTED LVNG,SERENITY 2769444300 1218276 07:15:01 SEIZURES 39 Y/O FEMALE SEIZURES NEED AN AMBULAN
OARNOLD:12433 MAPLE ST GLADE SPRING CARDINAL TRAVEL CENTER 2764296000 1215775 11:35:56 SEIZURES HAVE A MALE IN THE BATH ROOM HAVING A SEIZURES NP
OARNOLD:13168 MEADOWVIEW SQ MEADOWVIEW SOUTHWEST VIRGINIA COMMUNITY/DONNA KENESTER 2765251632 1212903 16:11:00 HEADACHE BAD HEAD ACHE NP
MEVANS:33573 CROWEVILLE DR GLADE SPRING BAILEY, JOHNNY C 2764295596 1218704 20:34:45 SICK CALL 83YO MALE BAD STOMACH ISSUES AND HURTING IN H

GGROSS:530 SHENANDOAH DR GLADE SPRING ALLEN STANLEY 1222084 00:25:28 SICK CALL MY DAD CAME HOME YESTERDAY FROM A PROCEDURE AT THE HOSP. HIS BLOOD PRESSURE IS VE
JMARTIN:29059 RIVERMONT DR MEADOWVIEW BRIAN 2762745374 1221351 10:08:52 SMOKE COMPLAINT CALLER STATED THERE IS BLACK SMOKE COMING FROM A BARN AT THIS ADDRESS.
GGROSS:223 MIMOSA ST GLADE SPRING GOLDY FLETCHER 2766145930 1218892 15:55:06 DIFFICULTY BREATHING MY MOTHER HAS SHORTNESS OF BREATH, SHE IS

*/

public class VAWashingtonCountyParser extends DispatchSouthernParser {
  
  public VAWashingtonCountyParser() {
    super(CITY_LIST, "WASHINGTON COUNTY", "VA", DSFLAG_DISPATCH_ID | DSFLAG_LEAD_PLACE);
  }

  @Override
  public String getFilter() {
    return "NSCOTT@washcova.com";
  }
  
  private static final String[] CITY_LIST = new String[]{
    "ABINGDON",
    "DAMASCUS",
    "GLADE SPRING",
    "MEADOWVIEW",
    "SALTVILLE",
    "EMORY-MEADOWVIEW",
    "MENDOTA"
  }; 
}
