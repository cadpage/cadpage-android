package net.anei.cadpage.parsers.IN;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchCiscoParser;

/***
Howard County, IN
Contact: Michael Kaelin <mdkaelin@gmail.com>
Sender: cisco.paging@co.howard.in.us

Subject:BREATHING PROBLEM\nLoc:1103 N 1100E XSt:200N 100N Grid:E300 Units:A11 Rmk:68 YOA FEMALE, DIZZY, BREATHING HARD, REAL RESTLE
Subject:BREATHING PROBLEM\nLoc:221 S HOWARD ST XSt:MAIN ST G HOLIDAY LN Grid:D210 Units:AGTFD Rmk:CANCER PATIENT DIFFICULTY BREATHI
Subject:BREATHING PROBLEM\nLoc:1401 SUNFLOWER CT XSt:MEADOW DR Grid:D210 Units:AGTFD Rmk:
Subject:TRANSPORTION\nLoc:705 N MERIDIAN ST Grid:D205 Units:A11 Rmk:RETURN TRANSPORT FROM HOWARD COMM
Subject:RESIDENTIAL FIRE\nLoc:10269 E 300S XSt:1100E 980E Grid:A400 Units:E11 A11 Rmk:SMOKE COMING FROM THE UTILITY CLOSET
Subject:BREATHING PROBLEM\nLoc:6348 E 200N XSt:700E 600E Grid:D400 Units:AGTFD A11 Rmk:
Subject:ABDOM/BACK PAIN\nLoc:705 N MERIDIAN ST Grid:D205 Units:A11 Rmk:ROOM 406 95 YOA FEMALE
Subject:GAS ODOR\nLoc:325 S MAPLE ST G XSt:MAIN ST G HALL ST Grid:D210 Units:E11 A11 Rmk:SMELLS NATURAL GAS INSIDE HER RESIDENCE

***/

public class INHowardCountyParser extends DispatchCiscoParser {
  
  public INHowardCountyParser() {
    super("HOWARD COUNTY", "IN");
  }
  
  @Override
  public String getFilter() {
    return "cisco.paging@co.howard.in.us";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (subject.length() == 0) return false;
    body = "Ct:" + subject + " " + body;
    return super.parseMsg(body, data);
  }
}
