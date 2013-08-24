package net.anei.cadpage.parsers.MI;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


/*
Bay County, MI
Contact: Kyle Martin <bangorfirephoto@gmail.com>
Sender: 911@baycounty.net

FIRE ALARM  200 ATHLONE BCH, Bangor Twp    robert lee residence- gen fire alarm4/30/2013 9:34:32 PM
STRUCTURE  1012 N CHILSON ST, Bangor Twp  DRYER FIRE IN THE GARAGE WHICH IS ATTACHED TO THE HOUSE5/18/2013 3:31:35 PM
FIRE ALARM  4101 E WILDER RD, Bangor Twp    gen fire alarm5/20/2013 10:06:48 AM
STRUCTURE   3337 W DOUGLAS DR, Bangor Twp    Attached garage on fire Vehicle inside\nmmr standy5/21/2013 11:37:49 AM

Contact: Active911
Agency name: Mount Forest Twp. Volunteer Fire Department
Location: Pinconning, MI, United States
Sender: 911@baycounty.net

MED 7204 STANDISH RD, Gibson Twp  62YO FEMALE DIABETIC DIZZINESS, CONFUSION7/8/2013 2:29:36 AM 
SUICIDE 2240 GRIM RD, Gibson Twp corner of grim and standish callers sister has taken lots of pills\n52 yo female\ntrying ..7/7/2013 12:30:36 AM

SUICIDE 1977 SAGANING RD, Gibson Twp  30YO FEMALE POSS TOOK MUSHROOMS AND IS HALLUCINATING   CALL..7/4/2013 2:41:07 PM
MED 760 W WIRBEL RD, Mt. Forest Twp  Difficulty breathing.  60 yr old female\n7 yr old child home7/1/2013 12:29:43 PM 
MED 3898 N CARTER RD, Mt. Forest Twp  49 yo male, stretched and injured his stomach, has partial ..6/20/2013 3:06:03 PM 
MED BROWN RD@ BAY GLADWIN LINE RD , Gibson Twp  at the end of brown road.....17 yo male dislocated shoulder..6/16/2013 1:01:40 PM 
MED BROWN RD@ STANDISH RD , Gibson Twp  at the end of brown road.....17 yo male dislocated shoulder..6/16/2013 1:01:40 PM 
MED 636 SAGANING RD, Gibson Twp  x's are 9 mile garfield  out in barn\n56 yo male laceration ..6/15/2013 9:21:29 AM 

*/

public class MIBayCountyParserTest extends BaseParserTest {
  
  public MIBayCountyParserTest() {
	  setParser(new MIBayCountyParser(), "BAY COUNTY", "MI");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "FIRE ALARM  200 ATHLONE BCH, Bangor Twp    robert lee residence- gen fire alarm4/30/2013 9:34:32 PM",
        "CALL:FIRE ALARM",
        "ADDR:200 ATHLONE BCH",
        "CITY:Bangor Twp",
        "INFO:robert lee residence- gen fire alarm",
        "DATE:04/30/2013",
        "TIME:21:34:32");

    doTest("T2",
        "STRUCTURE  1012 N CHILSON ST, Bangor Twp  DRYER FIRE IN THE GARAGE WHICH IS ATTACHED TO THE HOUSE5/18/2013 3:31:35 PM",
        "CALL:STRUCTURE",
        "ADDR:1012 N CHILSON ST",
        "CITY:Bangor Twp",
        "INFO:DRYER FIRE IN THE GARAGE WHICH IS ATTACHED TO THE HOUSE",
        "DATE:05/18/2013",
        "TIME:15:31:35");

    doTest("T3",
        "FIRE ALARM  4101 E WILDER RD, Bangor Twp    gen fire alarm5/20/2013 10:06:48 AM",
        "CALL:FIRE ALARM",
        "ADDR:4101 E WILDER RD",
        "CITY:Bangor Twp",
        "INFO:gen fire alarm",
        "DATE:05/20/2013",
        "TIME:10:06:48");

    doTest("T4",
        "STRUCTURE   3337 W DOUGLAS DR, Bangor Twp    Attached garage on fire Vehicle inside\nmmr standy5/21/2013 11:37:49 AM",
        "CALL:STRUCTURE",
        "ADDR:3337 W DOUGLAS DR",
        "CITY:Bangor Twp",
        "INFO:Attached garage on fire Vehicle inside mmr standy",
        "DATE:05/21/2013",
        "TIME:11:37:49");

  }
  
  @Test
  public void testMountForestTownshipFire() {

    doTest("T1",
        "MED 7204 STANDISH RD, Gibson Twp  62YO FEMALE DIABETIC DIZZINESS, CONFUSION7/8/2013 2:29:36 AM ",
        "CALL:MED",
        "ADDR:7204 STANDISH RD",
        "CITY:Gibson Twp",
        "INFO:62YO FEMALE DIABETIC DIZZINESS, CONFUSION",
        "DATE:07/08/2013",
        "TIME:02:29:36");

    doTest("T2",
        "SUICIDE 2240 GRIM RD, Gibson Twp corner of grim and standish callers sister has taken lots of pills\n" +
        "52 yo female\n" +
        "trying ..7/7/2013 12:30:36 AM",

        "CALL:SUICIDE",
        "ADDR:2240 GRIM RD",
        "CITY:Gibson Twp",
        "INFO:corner of grim and standish callers sister has taken lots of pills 52 yo female trying ..",
        "DATE:07/07/2013",
        "TIME:00:30:36");

    doTest("T3",
        "SUICIDE 1977 SAGANING RD, Gibson Twp  30YO FEMALE POSS TOOK MUSHROOMS AND IS HALLUCINATING   CALL..7/4/2013 2:41:07 PM",
        "CALL:SUICIDE",
        "ADDR:1977 SAGANING RD",
        "CITY:Gibson Twp",
        "INFO:30YO FEMALE POSS TOOK MUSHROOMS AND IS HALLUCINATING   CALL..",
        "DATE:07/04/2013",
        "TIME:14:41:07");

    doTest("T4",
        "MED 760 W WIRBEL RD, Mt. Forest Twp  Difficulty breathing.  60 yr old female\n7 yr old child home7/1/2013 12:29:43 PM ",
        "CALL:MED",
        "ADDR:760 W WIRBEL RD", // Not mapping
        "CITY:Mt. Forest Twp",
        "INFO:Difficulty breathing.  60 yr old female 7 yr old child home",
        "DATE:07/01/2013",
        "TIME:12:29:43");

    doTest("T5",
        "MED 3898 N CARTER RD, Mt. Forest Twp  49 yo male, stretched and injured his stomach, has partial ..6/20/2013 3:06:03 PM ",
        "CALL:MED",
        "ADDR:3898 N CARTER RD",
        "CITY:Mt. Forest Twp",
        "INFO:49 yo male, stretched and injured his stomach, has partial ..",
        "DATE:06/20/2013",
        "TIME:15:06:03");

    doTest("T6",
        "MED BROWN RD@ BAY GLADWIN LINE RD , Gibson Twp  at the end of brown road.....17 yo male dislocated shoulder..6/16/2013 1:01:40 PM ",
        "CALL:MED",
        "ADDR:BROWN RD & BAY GLADWIN LINE RD",
        "CITY:Gibson Twp",
        "INFO:at the end of brown road.....17 yo male dislocated shoulder..",
        "DATE:06/16/2013",
        "TIME:13:01:40");

    doTest("T7",
        "MED BROWN RD@ STANDISH RD , Gibson Twp  at the end of brown road.....17 yo male dislocated shoulder..6/16/2013 1:01:40 PM ",
        "CALL:MED",
        "ADDR:BROWN RD & STANDISH RD",
        "CITY:Gibson Twp",
        "INFO:at the end of brown road.....17 yo male dislocated shoulder..",
        "DATE:06/16/2013",
        "TIME:13:01:40");

    doTest("T8",
        "MED 636 SAGANING RD, Gibson Twp  x's are 9 mile garfield  out in barn\n56 yo male laceration ..6/15/2013 9:21:29 AM ",
        "CALL:MED",
        "ADDR:636 SAGANING RD",
        "CITY:Gibson Twp",
        "INFO:x's are 9 mile garfield  out in barn 56 yo male laceration ..",
        "DATE:06/15/2013",
        "TIME:09:21:29");
 
  }
  
  
  public static void main(String[] args) {
    new MIBayCountyParserTest().generateTests("T1");
  }
}
