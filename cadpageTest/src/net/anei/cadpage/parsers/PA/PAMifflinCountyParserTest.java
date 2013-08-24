package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.PA.PAMifflinCountyParser;

import org.junit.Test;

/*  
Mifflin County, PA
Contact: Eric Moist <emoist@ymail.com>
Sender: cmessages@co.mifflin.pa.us and cadmessages@co.mifflin.pa.us 

(CAD Page for CFS 111710-43) ALS - Uncon/Syncope\n1 DERRY PARK DR\nApt:\nBURNHAM\nCross Streets : 400-412  S LOGAN BLVD
(CAD Page for CFS 111710-42) URG - Ment/Emot/Psych\n41 INDUSTRIAL PARK RD\nApt: A\nGRANVILLE\nCross Streets : 708-924  LOOP RD * 2120-2456 MIDDLE RD
(CAD Page for CFS 111710-37) ALS - Breathing Difficulty\n27 ANDERSON ST\nApt:\nBRATTON\nCross Streets : 1-19  MATTAWANA BLVD
(CAD Page for CFS 111710-2) ALS - Motor Vehicle Accident\nROSEWOOD AVE and US HIGHWAY 522 NORTH\nApt: //\nDERRY\nCross Streets : 1-24  ROSEWOOD AVE
(CAD Page for CFS 111610-52) ALS - Breathing Difficulty\n163 SUMMIT DR\nApt:\nDERRY\nCross Streets : 400-406  SIXTH ST * 1-14 CASTLE CT
(CAD Page for CFS 111510-56) ALS - Diabetic\n7 MAPLE ST\nApt: ////\nKISTLER\nCross Streets : 150-198  N RIVERSIDE DR * 142-148 PARK RD

Contact: justin trego <jtrego77@gmail.com>
FRM:cmessages@co.mifflin.pa.us<Body%3AFRM%3Acmessages@co.mifflin.pa.us>\nSUBJ:CAD Page for CFS 013011-1\nMSG:Residential Fire\n56 RED SHALE LN\nApt:\nBRATTON\nCross Streets : 26-92  CARLISLE GAP RD

Contact: Wendy Varner <wendy.s.varner@gmail.com>
Sender: cmessages@co.mifflin.pa.us
1 of 2\nFRM:cmessages@co.mifflin.pa.us\nSUBJ:CAD Page for CFS 011512-8\nMSG:ALS - Sick Person\n11 SUNSET RD\nApt: \nLEWISTOWN\nhttp://maps.google.c\n(Con't) 2 of 2\nom/maps?q=+40.58788%20-77.56015\nCross Streets : 1-8  E WILSON AVE * 1-8 HARDING AVE \n(End)

Contact: Russ Mcmahon <rmcmahon0@yahoo.com>
Sender: cmessages@co.mifflin.pa.us
Subject:CAD Page for CFS 031012-66\nALS - Breathing Difficulty\r\n204 CORNFIELD CIR\r\nApt: \r\nDERRY\r\nhttp://maps.google.com/maps?q=+40.61\r

Contact: Todd Taylor <todd3772@gmail.com>
Sender: cmessages@co.mifflin.pa.us
1 of 2\nFRM:cmessages@co.mifflin.pa.us\nSUBJ:CAD Page for CFS 062913-41\nMSG:Grass / Brush Fire\n1346 US HIGHWAY 322\nApt: \nLEWISTOWN\nhttp://maps\n(Con't) 2 of 2\n.google.com/maps?q=+40.60906%20-77.56780\nCross Streets : 409-549\2sPARALLEL 322 ON RAMP * 1-31 FERGUSON VALLEY RD 322 W R (End)

*/

public class PAMifflinCountyParserTest extends BaseParserTest {
  
  public PAMifflinCountyParserTest() {
    setParser(new PAMifflinCountyParser(), "MIFFLIN COUNTY", "PA");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "(CAD Page for CFS 111710-43) ALS - Uncon/Syncope\n1 DERRY PARK DR\nApt:\nBURNHAM\nCross Streets : 400-412  S LOGAN BLVD",
        "ID:111710-43",
        "CALL:ALS - Uncon/Syncope",
        "ADDR:1 DERRY PARK DR",
        "CITY:BURNHAM",
        "X:400-412  S LOGAN BLVD");

    doTest("T2",
        "(CAD Page for CFS 111710-42) URG - Ment/Emot/Psych\n41 INDUSTRIAL PARK RD\nApt: A\nGRANVILLE\nCross Streets : 708-924  LOOP RD * 2120-2456 MIDDLE RD",
        "ID:111710-42",
        "CALL:URG - Ment/Emot/Psych",
        "ADDR:41 INDUSTRIAL PARK RD",
        "APT:A",
        "CITY:GRANVILLE TWP",
        "X:708-924  LOOP RD * 2120-2456 MIDDLE RD");
    
    doTest("T3",
        "(CAD Page for CFS 111710-37) ALS - Breathing Difficulty\n27 ANDERSON ST\nApt:\nBRATTON\nCross Streets : 1-19  MATTAWANA BLVD",
        "ID:111710-37",
        "CALL:ALS - Breathing Difficulty",
        "ADDR:27 ANDERSON ST",
        "CITY:BRATTON TWP",
        "X:1-19  MATTAWANA BLVD");
    
    doTest("T4",
        "(CAD Page for CFS 111710-2) ALS - Motor Vehicle Accident\nROSEWOOD AVE and US HIGHWAY 522 NORTH\nApt: //\nDERRY\nCross Streets : 1-24  ROSEWOOD AVE",
        "ID:111710-2",
        "CALL:ALS - Motor Vehicle Accident",
        "ADDR:ROSEWOOD AVE and US HIGHWAY 522 NORTH",
        "MADDR:ROSEWOOD AVE & US 522 NORTH",
        "CITY:DERRY TWP",
        "X:1-24  ROSEWOOD AVE");
    
    doTest("T5",
        "(CAD Page for CFS 111610-52) ALS - Breathing Difficulty\n163 SUMMIT DR\nApt:\nDERRY\nCross Streets : 400-406  SIXTH ST * 1-14 CASTLE CT",
        "ID:111610-52",
        "CALL:ALS - Breathing Difficulty",
        "ADDR:163 SUMMIT DR",
        "CITY:DERRY TWP",
        "X:400-406  SIXTH ST * 1-14 CASTLE CT");
    
    doTest("T6",
        "(CAD Page for CFS 111510-56) ALS - Diabetic\n7 MAPLE ST\nApt: ////\nKISTLER\nCross Streets : 150-198  N RIVERSIDE DR * 142-148 PARK RD",
        "ID:111510-56",
        "CALL:ALS - Diabetic",
        "ADDR:7 MAPLE ST",
        "CITY:KISTLER",
        "X:150-198  N RIVERSIDE DR * 142-148 PARK RD");
    
    doTest("T7",
        "FRM:cmessages@co.mifflin.pa.us<Body%3AFRM%3Acmessages@co.mifflin.pa.us>\nSUBJ:CAD Page for CFS 013011-1\nMSG:Residential Fire\n56 RED SHALE LN\nApt:\nBRATTON\nCross Streets : 26-92  CARLISLE GAP RD",
        "ID:013011-1",
        "CALL:Residential Fire",
        "ADDR:56 RED SHALE LN",
        "CITY:BRATTON TWP",
        "X:26-92  CARLISLE GAP RD");
  }
  
  @Test
  public void testJuanityCounty() {

    doTest("T1",
        "1 of 2\nFRM:cmessages@co.mifflin.pa.us\nSUBJ:CAD Page for CFS 011512-8\nMSG:ALS - Sick Person\n11 SUNSET RD\nApt: \nLEWISTOWN\nhttp://maps.google.c\n(Con't) 2 of 2\nom/maps?q=+40.58788%20-77.56015\nCross Streets : 1-8  E WILSON AVE * 1-8 HARDING AVE \n(End)",
        "ID:011512-8",
        "CALL:ALS - Sick Person",
        "ADDR:11 SUNSET RD",
        "CITY:LEWISTOWN",
        "X:1-8  E WILSON AVE * 1-8 HARDING AVE");
  }
  
  @Test
  public void testRusMcmahon() {

    doTest("T1",
        "Subject:CAD Page for CFS 031012-66\n" +
        "ALS - Breathing Difficulty\r\n" +
        "204 CORNFIELD CIR\r\n" +
        "Apt: \r\n" +
        "DERRY\r\n" +
        "http://maps.google.com/maps?q=+40.61\r",

        "ID:031012-66",
        "CALL:ALS - Breathing Difficulty",
        "ADDR:204 CORNFIELD CIR",
        "CITY:DERRY TWP");

  }
  
  @Test
  public void testToddTaylor() {

    doTest("T1",
        "1 of 2\n" +
        "FRM:cmessages@co.mifflin.pa.us\n" +
        "SUBJ:CAD Page for CFS 062913-41\n" +
        "MSG:Grass / Brush Fire\n" +
        "1346 US HIGHWAY 322\n" +
        "Apt: \n" +
        "LEWISTOWN\n" +
        "http://maps\n" +
        "(Con't) 2 of 2\n" +
        ".google.com/maps?q=+40.60906%20-77.56780\n" +
        "Cross Streets : 409-549\\2sPARALLEL 322 ON RAMP * 1-31 FERGUSON VALLEY RD 322 W R (End)",

        "ID:062913-41",
        "CALL:Grass / Brush Fire",
        "ADDR:1346 US HIGHWAY 322",
        "MADDR:1346 US 322",
        "CITY:LEWISTOWN",
        "X:409-549\\2sPARALLEL 322 ON RAMP * 1-31 FERGUSON VALLEY RD 322 W R");

  }
  
  public static void main(String args[]) {
    new PAMifflinCountyParserTest().generateTests("T1");
  }
}