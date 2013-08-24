package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*    
North East, MD (in Cecil County)
Contact: Dave Simmons <acdave0911@gmail.com>
Sender: nefc911@nefc.com

10C04 (CHE\nCHEST PAIN\n322 E CECIL AVE @NORTH BAY MED\nNE\nMECHANICS VALLEY RD\n06/14/11\n11:21:54\nDR SCHADEV'S OFFICE[P CHEST ;41 YEAR OLD, FEMALE, CONSCIOUS
31A01 (UNC\nUNCON/SYNCOPAL\n161 WILLARD DR\nNE\nSTITES LN\n06/13/11\n08:53:56\n[P MOM FELL ;76 YEAR OLD, FEMALE, CONSCIOUS, BREATHING. UNCONSCIOUS/FAINTING (NE
AUTO (AUTO\nAUTOMOBILE FIRE\n98.5 I95 NB HWY\nNE\nRED TOAD RD\n06/13/11\n14:13:17\nAUTO ON FIRE//CAN SEE FLAMES AND SMOKE\nOPS 6   0495S\n04
HOUSE (HOU\nHOUSE FIRE\n354 W MAIN ST\nELK\nBLUEBALL AVE\n06/13/11\n19:20:42\nFIRE IN THE STOVE WAS FULLY INVOLVED COULD BE OUT SMOKE IN THE RESIDENCE\nOPS 7
HOUSE (HOU\nHOUSE FIRE\n122 WHITEHALL RD\nELK\nCHESSMAN CIR\n06/13/11\n15:44:45\nSMOKE FROM BASEMENT//BLACK\nOPS 6   0304\n03\n

*/

public class MDNorthEastParserOldTest extends BaseParserTest {
  
  public MDNorthEastParserOldTest() {
    setParser(new MDNorthEastParser(), "NORTH EAST", "MD");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "10C04 (CHE\nCHEST PAIN\n322 E CECIL AVE @NORTH BAY MED\nNE\nMECHANICS VALLEY RD\n06/14/11\n11:21:54\nDR SCHADEV'S OFFICE[P CHEST ;41 YEAR OLD, FEMALE, CONSCIOUS",
        "CODE:10C04",
        "CALL:CHEST PAIN",
        "ADDR:322 E CECIL AVE",
        "PLACE:NORTH BAY MED",
        "X:MECHANICS VALLEY RD",
        "CITY:North East",
        "DATE:06/14/11",
        "TIME:11:21:54",
        "INFO:DR SCHADEV'S OFFICE[P CHEST ;41 YEAR OLD, FEMALE, CONSCIOUS");

    doTest("T2",
        "31A01 (UNC\nUNCON/SYNCOPAL\n161 WILLARD DR\nNE\nSTITES LN\n06/13/11\n08:53:56\n[P MOM FELL ;76 YEAR OLD, FEMALE, CONSCIOUS, BREATHING. UNCONSCIOUS/FAINTING (NE",
        "CODE:31A01",
        "CALL:UNCON/SYNCOPAL",
        "ADDR:161 WILLARD DR",
        "X:STITES LN",
        "CITY:North East",
        "DATE:06/13/11",
        "TIME:08:53:56",
        "INFO:[P MOM FELL ;76 YEAR OLD, FEMALE, CONSCIOUS, BREATHING. UNCONSCIOUS/FAINTING (NE");

    doTest("T3",
        "AUTO (AUTO\nAUTOMOBILE FIRE\n98.5 I95 NB HWY\nNE\nRED TOAD RD\n06/13/11\n14:13:17\nAUTO ON FIRE//CAN SEE FLAMES AND SMOKE\nOPS 6   0495S\n04",
        "CALL:AUTOMOBILE FIRE",
        "ADDR:98.5 I95 NB HWY",
        "MADDR:98.5 I 95 & RED TOAD RD",
        "X:RED TOAD RD",
        "CITY:North East",
        "DATE:06/13/11",
        "TIME:14:13:17",
        "INFO:AUTO ON FIRE//CAN SEE FLAMES AND SMOKE",
        "CH:OPS 6",
        "MAP:0495S",
        "UNIT:04");

    doTest("T4",
        "HOUSE (HOU\nHOUSE FIRE\n354 W MAIN ST\nELK\nBLUEBALL AVE\n06/13/11\n19:20:42\nFIRE IN THE STOVE WAS FULLY INVOLVED COULD BE OUT SMOKE IN THE RESIDENCE\nOPS 7",
        "CALL:HOUSE FIRE",
        "ADDR:354 W MAIN ST",
        "X:BLUEBALL AVE",
        "CITY:Elkton",
        "DATE:06/13/11",
        "TIME:19:20:42",
        "INFO:FIRE IN THE STOVE WAS FULLY INVOLVED COULD BE OUT SMOKE IN THE RESIDENCE",
        "CH:OPS 7");

    doTest("T5",
        "HOUSE (HOU\nHOUSE FIRE\n122 WHITEHALL RD\nELK\nCHESSMAN CIR\n06/13/11\n15:44:45\nSMOKE FROM BASEMENT//BLACK\nOPS 6   0304\n03\n",
        "CALL:HOUSE FIRE",
        "ADDR:122 WHITEHALL RD",
        "X:CHESSMAN CIR",
        "CITY:Elkton",
        "DATE:06/13/11",
        "TIME:15:44:45",
        "INFO:SMOKE FROM BASEMENT//BLACK",
        "CH:OPS 6",
        "MAP:0304",
        "UNIT:03");
  }
  
  public static void main(String[] args) {
    new MDNorthEastParserOldTest().generateTests("T1");
  }
}