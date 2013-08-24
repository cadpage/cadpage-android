package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Lenoir County, NC
Contact: Active911
Agency name: Wyse Fork Fire and Rescue
Location: Dover, NC, United States

Communication:HWY 70 // MILE MARKER 397 DOVER L-TRAFFIC AC 131 - TRAFFIC/ TRANSPORTATION ACCIDENT (CRASH) Line16= Line17= Line18=
Communication:1181 NEUSE RD KINSTON GRAY TILGHMAN RD ROBERT E LEE DR 28501 E-UNRESP PER UNRESPONSIVE PERSON Line16= Line17= Line18=
Communication:HWY 70 EAST // MM 394 TRENTON Geo Comment: ...BARON & BEEF L-TRAFFIC AC 131 - TRAFFIC/ TRANSPORTATION ACCIDENT (CRASH) JCEMSALS1,WF06,WFEMS1 Line16= Line17= Line18=07/14/2013 13:32:44 : pos5 : JKENNEDY HP NOTIFIED 07/14/2013 13:28:40 : pos5 : JKENNEDY HWY 70 EAST // MM 394 07/14/2013 13:27:54 : pos5 : JKENNEDY HWY 70 EAST// Geo Comment: ...BARON & BEEF 07/14/2013 13:27:33 : pos5 : JKENNEDY EPD Case Complete 07/14/2013 13:27:30 : pos5 : JKENNEDY EPD Key Questions Finished Key Questions: 10. Nothing is blocking or slowing the flow of traffic. 13. It is not known if alcohol or drugs are involved. 14. The vehicle description is: 15. The exact location of the vehicle(s) is not known. 16. None of the additional response criteria are present. 17. No other property is damaged besides the vehicle(s). VEHICLE 1 Info: type Victim color GOLD make BUICK 07/14/2013 13:26:54 : pos5 : JKENNEDY EPD Recommended Dispatch Response Text: Charlie Dispatch Level: 131C01 CAD Incident Code: 131C0
Communication:CLARK DR KINSTON STRAWBERRY BRANCH DR LOOP RD 28501 F-STRUCTURE 69 - STRUCTURE FIRE Line16= Line17= Line18=
Communication:125 MCDANIEL FORK RD TRENTON F-STRUCTURE 69 - STRUCTURE FIRE Line16= Line17= Line18=
Communication:5913 HWY 58 SOUTH KINSTON F-STRUCTURE 69 - STRUCTURE FIRE Line16= Line17= Line18=
Communication:HWY 58 SOUTH // VINE SWAMP KINSTON VINE SWAMP RD ELM GROVE RD 28504 E-TRAFFIC AC 29 - TRAFFIC /TRANSPORTATION ACCIDENTS Line16= Line17= Line18=
Communication:1455 BRITISH RD KINSTON TILGHMAN ROAD CAUSEY ROAD 28501 E-TRAFFIC AC 29 - TRAFFIC /TRANSPORTATION ACCIDENTS Line16= Line17= Line18=
Communication:2787 HWY 55 EAST KINSTON NEUSE RD BRITISH RD 28501 E-TRAFFIC AC 29 - TRAFFIC /TRANSPORTATION ACCIDENTS Line16= Line17= Line18=
Communication:190 NEUSE RD KINSTON HWY 70 EAST CITY / COUNTY LINE 28501 F-STRUCTURE 69 - STRUCTURE FIRE Line16= Line17= Line18=
Communication:BRITISH RD DOVER F-HAZMAT 61 - HAZMAT Line16= Line17= Line18=
Communication:1630 BONNIE LN KINSTON FAULKNER RD DEAD END 28501 Geo Comment: FAULKNER MHP F-OUTSIDE FI 67 - OUTSIDE FIRE HU32,SH25,WF06 Line16= Line17= Line18=04/13/2013 14:40:16 : pos6 : SHEATH EFD Recommended Dispatch Response Text: Bravo Dispatch Level: 67B01 Suffix: R Residential CAD Incident Code: 67B01R Determinant: SMALL OUTSIDE fire Chief Complaint: Outside Fire Problem Statement: BRUSH FIRE Key Questions: 1. The caller is on scene (1st party). 2. This is a SMALL OUTSIDE fire. 3. The fire has not been extinguished. 4. Residential areas are being threatened by the fire. 5. No hazardous materials are reported. 04/13/2013 14:39:31 : pos6 : SHEATH Cross streets: FAULKNER RD//DEAD END Geo Comment: FAULKNER MHP
Communication:1814 COBB RD KINSTON SILO ROAD STEPHANIE RD 28501 F-STRUCTURE 69 - STRUCTURE FIRE SW24,WF06 Line16= Line17= Line18=04/08/2013 12:44:45 : pos3 : NCOTTON Cross streets: SILO ROAD//STEPHANIE RD HOUSE FIRE
Communication:175 WOODVIEW LN KINSTON BRITISH RD 28501 F-OUTSIDE FI 67 - OUTSIDE FIRE Line16= Line17= Line18=
Communication:1440 BRITISH RD KINSTON TILGHMAN ROAD CAUSEY ROAD 28501 F-STRUCTURE 69 - STRUCTURE FIRE WF06 Line16= Line17= Line18=
Communication:HWY 55 EAST // SETH WEST RD KINSTON SETH WEST RD NEUSE RD 28501 F-OUTSIDE FI 67 - OUTSIDE FIRE Line16= Line17= Line18=
Communication:GRAY TIGHLMAN RD // BRITISH RD DOVER L-ACCUNK ACCUNK - ACCIDENT UNKNOWN PI/PD WF06 Line16= Line17= Line18=
Communication:1508 AVALON DR KINSTON DEANN LN LANAY LN 28504 F-STRUCTURE 69 - STRUCTURE FIRE SW24,WF06 Line16= Line17= Line18=
Communication:1505 NEUSE RD KINSTON HILL ALLEN LN CRAVEN LN 28501 L-TRAFFIC AC 131 - TRAFFIC/ TRANSPORTATION ACCIDENT (CRASH) Line16= Line17= Line18=
Communication:1455 BRITISH RD KINSTON TILGHMAN ROAD CAUSEY ROAD 28501 E-TRAFFIC AC 29 - TRAFFIC /TRANSPORTATION ACCIDENTS MED2,WF06 Line16= Line17= Line18=
Communication:130 S QUEEN ST KINSTON CASWELL ST KING ST L-MENTRANS LAW TRANSPORT TO MENTAL HEALTH LC23,WF06 Line16= Line17= Line18=
Communication:1628 HWY 258 SOUTH KINSTON F-VEHICLE 71 - VEHICLE FIRE Line16= Line17= Line18=
Communication:511 NEUSE RD KINSTON HWY 70 EAST CASEY RD 28501 F-ALARMS 52-FIRE ALARMS Line16= Line17= Line18=
Communication:1039 HWY 58 SOUTH KINSTON STRAWBERRY BRANCH DR WOODINGTON RD 28504 Geo Comment: ... F-STRUCTURE 69 - STRUCTURE FIRE LC32,SW24,WF06 Line16= Line17= Line18=01/25/2013 21:18:02 : pos6 : WMOYE Cross streets: STRAWBERRY BRANCH DR//WOODINGTON RD Geo Comment: ...
Communication:837 CLARK DR KINSTON STRAWBERRY BRANCH DR LOOP RD 28501 F-STRUCTURE 69 - STRUCTURE FIRE SW24,WF06 Line16= Line17= Line18=

*/

public class NCLenoirCountyBParserTest extends BaseParserTest {
  
  public NCLenoirCountyBParserTest() {
    setParser(new DummyParser(), "LENOIR COUNTY", "NC");
  }
  
  @Test
  public void testParser() {
    
 }
  

  public static void main(String[] args) {
    new NCLenoirCountyBParserTest().generateTests("T1");
  }
}

