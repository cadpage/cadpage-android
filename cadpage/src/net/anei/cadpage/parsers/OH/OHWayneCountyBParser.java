package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Wayne County, OH (variant B)
Contact: "Troy Shaum " <t-roy730@live.com>
Sender: dispatch@ohiomuni.net

(Dispatch Message) TRAFFIC DETAIL/COMPLAINT  \n94 BAUMGARTNER RD \nBIG TRUCK WITH BROKEN DRIVE TRAIN ADV NEEDING TRAFFIC CONTROL  \nON 94 JUST SOUTH OF BAUMGARTN
(Dispatch Message) SQUAD: CARDIAC/CHEST PAIN \n110 WEST LEBANON RD N 40\n33 YEAR OLD MALE CHEST PAINS\nHAS MITROVALVE PROLASPE
(Dispatch Message) FIRE: GRASS/TREES/BRUSH   \nHACKETT RD KANSAS RD S \nFIELD FIRE AT S. KANSAS AND HACKETT.
(Dispatch Message) MISCELLANEOUS             \n  \nTUESD NOV 15TH AT 1800 HRS SHARP, A SHORT WORK DETAIL TO GET ENGINE 71 READY TO GO TO TWINSBURG TUES EVENING
(Dispatch Message) SQUAD: FALLS              \n14765 LINCOLN WAY E \n911 CALL LUCY INDORF 89 YOF FALL VICTIM - LIFT ASSIST - NO INJURY- FD HAS KEY\nCROSS KURZEN
(Dispatch Message) SQUAD: FRACTURES          \n22 KING \n50 YR OLD MALE, BROKEN LEG
(Dispatch Message) SQUAD: (FREE TEXT)        \n1 ARLINGTON CT 1\n51 YOM SEVERE HEADACHE  BLDG 3
(Dispatch Message) SQUAD: (FREE TEXT)        \n15028 OLD LINCOLN WAY \nPATIENT PULLED TRAC OUT NEEDS TO GO TO DUNLAP ER, USE BACK DOOR DOGWOOD

Contact:  Jackie Elkins <elk607@gmail.com>
Sender: dispatch@orrville.com
(Dispatch Message) MUTUAL AID REQUESTED BY US\r961 ROSELAND \rNORTH LAWRENCE REQ RIT TEAM FOR STRUCTURE FIRE, NORTH OF 172, EAST OF KENYON

 */


public class OHWayneCountyBParser extends FieldProgramParser {
  
  public OHWayneCountyBParser() {
    super("WAYNE COUNTY", "OH",
           "CALL ADDR/i INFO+");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@ohiomuni.net,dispatch@orrville.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Dispatch Message")) return false;
    if (!parseFields(body.split("\n"), data)) return false;
    String info = data.strSupp.toUpperCase();
    for (String city : CITY_LIST) {
      if (info.contains(city)) {
        data.strCity = city;
        break;
      }
    }
    return true;
  }
  
  private static final String[] CITY_LIST = new String[] {
    "NORTH LAWRENCE"
  };
}
