package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


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
        "CITY:North East",
        "X:MECHANICS VALLEY RD",
        "INFO:DR SCHADEV'S OFFICE[P CHEST ;41 YEAR OLD, FEMALE, CONSCIOUS");

    doTest("T2",
        "31A01 (UNC\nUNCON/SYNCOPAL\n161 WILLARD DR\nNE\nSTITES LN\n06/13/11\n08:53:56\n[P MOM FELL ;76 YEAR OLD, FEMALE, CONSCIOUS, BREATHING. UNCONSCIOUS/FAINTING (NE",
        "CODE:31A01",
        "CALL:UNCON/SYNCOPAL",
        "ADDR:161 WILLARD DR",
        "CITY:North East",
        "X:STITES LN",
        "INFO:[P MOM FELL ;76 YEAR OLD, FEMALE, CONSCIOUS, BREATHING. UNCONSCIOUS/FAINTING (NE");

    doTest("T3",
        "AUTO (AUTO\nAUTOMOBILE FIRE\n98.5 I95 NB HWY\nNE\nRED TOAD RD\n06/13/11\n14:13:17\nAUTO ON FIRE//CAN SEE FLAMES AND SMOKE\nOPS 6   0495S\n04",
        "CALL:AUTOMOBILE FIRE",
        "ADDR:98.5 I95 NB HWY",
        "CITY:North East",
        "X:RED TOAD RD",
        "INFO:AUTO ON FIRE//CAN SEE FLAMES AND SMOKE",
        "CH:OPS 6",
        "MAP:0495S",
        "UNIT:04");

    doTest("T4",
        "HOUSE (HOU\nHOUSE FIRE\n354 W MAIN ST\nELK\nBLUEBALL AVE\n06/13/11\n19:20:42\nFIRE IN THE STOVE WAS FULLY INVOLVED COULD BE OUT SMOKE IN THE RESIDENCE\nOPS 7",
        "CALL:HOUSE FIRE",
        "ADDR:354 W MAIN ST",
        "CITY:Elkton",
        "X:BLUEBALL AVE",
        "INFO:FIRE IN THE STOVE WAS FULLY INVOLVED COULD BE OUT SMOKE IN THE RESIDENCE",
        "CH:OPS 7");

    doTest("T5",
        "HOUSE (HOU\nHOUSE FIRE\n122 WHITEHALL RD\nELK\nCHESSMAN CIR\n06/13/11\n15:44:45\nSMOKE FROM BASEMENT//BLACK\nOPS 6   0304\n03\n",
        "CALL:HOUSE FIRE",
        "ADDR:122 WHITEHALL RD",
        "CITY:Elkton",
        "X:CHESSMAN CIR",
        "INFO:SMOKE FROM BASEMENT//BLACK",
        "CH:OPS 6",
        "MAP:0304",
        "UNIT:03");
  }
  
  @Test
  public void testParser2() {


    doTest("T1",
        "DIABETIC\n254 N MAIN ST\nVANNORT DR\nGRANITE AVE\nPD\n08:00:00\n[P DIABETIC ;81 YEAR OLD, FEMALE, CONSCIOUS, BREATHING.  DIABETICPROBLEMS.\n11021185\nEMS OPS",
        "CODE:DIABETIC",
        "CALL:254 N MAIN ST",
        "ADDR:VANNORT DR",
        "CITY:GRANITE AVE",
        "X:PD",
        "INFO:11021185",
        "CH:EMS OPS");


  }
  
  public static void main(String[] args) {
    new MDNorthEastParserOldTest().generateTests("T1");
  }
}