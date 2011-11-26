package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

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

 */


public class OHWayneCountyBParser extends FieldProgramParser {
  
  public OHWayneCountyBParser() {
    super("WAYNE COUNTY", "OH",
           "CALL ADDR/i INFO+");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@ohiomuni.net";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Dispatch Message")) return false;
    return parseFields(body.split("\n"), data);
  }
}
