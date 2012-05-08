package net.anei.cadpage.parsers.TN;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class TNUnionCountyParserTest extends BaseParserTest {
  
  public TNUnionCountyParserTest() {
    setParser(new TNUnionCountyParser(), "UNION COUNTY", "TN");
  }
  
  @Test
  public void test1Parser() {

    doTest("T1",
        "Subject:E911\nACCIDENT\n8654568681\nHIGHWAY 61 W, ANDERSONVILLE",
        "CALL:ACCIDENT",
        "PHONE:8654568681",
        "ADDR:HIGHWAY 61 W",
        "CITY:ANDERSONVILLE");

    doTest("T2",
        "Subject:E911\nFIRE GENERAL\nBRIAN 8653232387\nMONROE RD, MAYNARDVILLE\nBRUSH FIRE",
        "CALL:FIRE GENERAL",
        "NAME:BRIAN",
        "PHONE:8653232387",
        "ADDR:MONROE RD",
        "CITY:MAYNARDVILLE",
        "INFO:BRUSH FIRE");

    doTest("T3",
        "Subject:E911\nFIRE GENERAL\nDAVID FRANKS 8652560768\n372 RACCOON VALLEY RD, Maynardville\nSMOKE IN THE AREA",
        "CALL:FIRE GENERAL",
        "NAME:DAVID FRANKS",
        "PHONE:8652560768",
        "ADDR:372 RACCOON VALLEY RD",
        "CITY:Maynardville",
        "INFO:SMOKE IN THE AREA");

    doTest("T4",
        "Subject:E911\nACCIDENT W/INJURY\nRAYMOND 8652565414\nOLD TAZEWELL PIKE, Corryton",
        "CALL:ACCIDENT W/INJURY",
        "NAME:RAYMOND",
        "PHONE:8652565414",
        "ADDR:OLD TAZEWELL PIKE",
        "CITY:Corryton");

    doTest("T5",
        "Subject:E911\nACCIDENT W/INJURY\nANGIE GATTO 8653605936\nMAYNARDVILLE HWY, MAYNARDVILLE\n4 PEOPLE",
        "CALL:ACCIDENT W/INJURY",
        "NAME:ANGIE GATTO",
        "PHONE:8653605936",
        "ADDR:MAYNARDVILLE HWY",
        "CITY:MAYNARDVILLE",
        "INFO:4 PEOPLE");

    doTest("T6",
        "Subject:E911\nFIRE RESIDENCE\nWILLIAM KRONER 8659925951\n1159 SATTERFIELD RD, MAYNARDVILLE",
        "CALL:FIRE RESIDENCE",
        "NAME:WILLIAM KRONER",
        "PHONE:8659925951",
        "ADDR:1159 SATTERFIELD RD",
        "CITY:MAYNARDVILLE");

    doTest("T7",
        "Subject:E911\nFIRE RESIDENCE\nDAIL CAUGHORN 8652546959\n256 LUCAS LN, Maynardville",
        "CALL:FIRE RESIDENCE",
        "NAME:DAIL CAUGHORN",
        "PHONE:8652546959",
        "ADDR:256 LUCAS LN",
        "CITY:Maynardville");

    doTest("T8",
        "Subject:E911\nTREE IN ROADWAY\nEDDIE SHOFFNER 8653141048\nHINDS CREEK RD, ANDERSONVILLE\nBLOCKING ROAD",
        "CALL:TREE IN ROADWAY",
        "NAME:EDDIE SHOFFNER",
        "PHONE:8653141048",
        "ADDR:HINDS CREEK RD",
        "CITY:ANDERSONVILLE",
        "INFO:BLOCKING ROAD");

    doTest("T9",
        "Subject:E911\nFIRE GENERAL\nSHIRLEY TURNER 4234891893\n116 MAYNARDVILLE HWY, MAYNARDVILLE\nADVISED THE POP MACHINE IS ON FIRE",
        "CALL:FIRE GENERAL",
        "NAME:SHIRLEY TURNER",
        "PHONE:4234891893",
        "ADDR:116 MAYNARDVILLE HWY",
        "CITY:MAYNARDVILLE",
        "INFO:ADVISED THE POP MACHINE IS ON FIRE");

    doTest("T10",
        "Subject:E911\nTREE IN ROADWAY\nSHIRLEY HAMMOCK 9116953536\nOAKLAND RD, Maynardville\nROADWAY IS BLOCKED",
        "CALL:TREE IN ROADWAY",
        "NAME:SHIRLEY HAMMOCK",
        "PHONE:9116953536",
        "ADDR:OAKLAND RD",
        "CITY:Maynardville",
        "INFO:ROADWAY IS BLOCKED");

    doTest("T11",
        "Subject:E911\nTREE IN ROADWAY\nJENNIFER HARMON 8656807375\nBEARD VALLEY RD, MAYNARDVILLE\nTREE BLOCKING ROADWAY DANGEROUS AREA",
        "CALL:TREE IN ROADWAY",
        "NAME:JENNIFER HARMON",
        "PHONE:8656807375",
        "ADDR:BEARD VALLEY RD",
        "CITY:MAYNARDVILLE",
        "INFO:TREE BLOCKING ROADWAY DANGEROUS AREA");

    doTest("T12",
        "Subject:E911\nACCIDENT\nELIZABETH SAVAGE 8653854992\nHIGHWAY 61 W, Maynardville",
        "CALL:ACCIDENT",
        "NAME:ELIZABETH SAVAGE",
        "PHONE:8653854992",
        "ADDR:HIGHWAY 61 W",
        "CITY:Maynardville");

    doTest("T13",
        "Subject:E911\nTREE IN ROADWAY\nMINDY HAWK 8652283331\nBUTCHER HOLLOW RD, MAYNARDVILLE\nTREE IN ROAD",
        "CALL:TREE IN ROADWAY",
        "NAME:MINDY HAWK",
        "PHONE:8652283331",
        "ADDR:BUTCHER HOLLOW RD",
        "CITY:MAYNARDVILLE",
        "INFO:TREE IN ROAD");

    doTest("T14",
        "Subject:E911\nTREE IN ROADWAY\nWADE BRANTLEY 8658064337\nOUSLEY GAP RD, MAYNARDVILLE\nTOTAL ROAD BLOCKAGE",
        "CALL:TREE IN ROADWAY",
        "NAME:WADE BRANTLEY",
        "PHONE:8658064337",
        "ADDR:OUSLEY GAP RD",
        "CITY:MAYNARDVILLE",
        "INFO:TOTAL ROAD BLOCKAGE");

    doTest("T15",
        "Subject:E911\nOTHER\nMILLIE HARTGROVE 8659928378\n1983 HICKORY VALLEY RD, MAYNARDVILLE\nLIGHTENING STRUCK HOUSE",
        "CALL:OTHER",
        "NAME:MILLIE HARTGROVE",
        "PHONE:8659928378",
        "ADDR:1983 HICKORY VALLEY RD",
        "CITY:MAYNARDVILLE",
        "INFO:LIGHTENING STRUCK HOUSE");

    doTest("T16",
        "Subject:E911\nSTORM OR WEATHER RELATED INCIDENTS/DAMAGE\nDAVID SEXTON 8655666873\nHIGHWAY 61 E, MAYNARDVILLE\nPOWER LINES IN ROAD WAY",
        "CALL:STORM OR WEATHER RELATED INCIDENTS/DAMAGE",
        "NAME:DAVID SEXTON",
        "PHONE:8655666873",
        "ADDR:HIGHWAY 61 E",
        "CITY:MAYNARDVILLE",
        "INFO:POWER LINES IN ROAD WAY");

    doTest("T17",
        "Subject:E911\nTREE IN ROADWAY\n\nOAKLAND RD, MAYNARDVILLE\nTREE BLOCKING ROAD",
        "CALL:TREE IN ROADWAY",
        "ADDR:OAKLAND RD",
        "CITY:MAYNARDVILLE",
        "INFO:TREE BLOCKING ROAD");

    doTest("T18",
        "Subject:E911\nTREE IN ROADWAY\nBRENDA MERRITT \nGUYTON DR, MAYNARDVILLE",
        "CALL:TREE IN ROADWAY",
        "NAME:BRENDA MERRITT",
        "ADDR:GUYTON DR",
        "CITY:MAYNARDVILLE");

    doTest("T19",
        "Subject:E911\nTREE IN ROADWAY\nDONNA EKERLY 8658515782\nJERRY HOLLOW RD, ANDERSONVILLE",
        "CALL:TREE IN ROADWAY",
        "NAME:DONNA EKERLY",
        "PHONE:8658515782",
        "ADDR:JERRY HOLLOW RD",
        "CITY:ANDERSONVILLE");

    doTest("T20",
        "Subject:E911\nOTHER\nMARGARET TRENT 8653604629\n311 DOGWOOD LN, MAYNARDVILLE\nPOWER LINES DOWN",
        "CALL:OTHER",
        "NAME:MARGARET TRENT",
        "PHONE:8653604629",
        "ADDR:311 DOGWOOD LN",
        "CITY:MAYNARDVILLE",
        "INFO:POWER LINES DOWN");

    doTest("T21",
        "Subject:E911\nFIRE BUSINESS\nUNION U COUNTY PROPER 4232110400\n901 MAIN ST, STE 115, MAYNARDVILLE\nHIGH VOLTAGE CLOSET",
        "CALL:FIRE BUSINESS",
        "PLACE:UNION U COUNTY PROPER",
        "PHONE:4232110400",
        "ADDR:901 MAIN ST",
        "APT:STE 115",
        "CITY:MAYNARDVILLE",
        "INFO:HIGH VOLTAGE CLOSET");

    doTest("T22",
        "Subject:E911\nTREE IN ROADWAY\n627 8653569465\nCHESTNUT RIDGE RD, MAYNARDVILLE\nBLOCKING THE ENTIRE ROAD",
        "CALL:TREE IN ROADWAY",
        "NAME:627",
        "PHONE:8653569465",
        "ADDR:CHESTNUT RIDGE RD",
        "CITY:MAYNARDVILLE",
        "INFO:BLOCKING THE ENTIRE ROAD");

    doTest("T23",
        "Subject:E911\nACCIDENT W/INJURY\nEDDIE'S AUTO & SALVAGE 8659928151\n565 MAYNARDVILLE HWY, MAYNARDVILLE",
        "CALL:ACCIDENT W/INJURY",
        "PLACE:EDDIE'S AUTO & SALVAGE",
        "PHONE:8659928151",
        "ADDR:565 MAYNARDVILLE HWY",
        "CITY:MAYNARDVILLE");

    doTest("T24",
        "Subject:E911\nTREE IN ROADWAY\nJEREMY 8659926262\n466 HANSARD RD, MAYNARDVILLE",
        "CALL:TREE IN ROADWAY",
        "NAME:JEREMY",
        "PHONE:8659926262",
        "ADDR:466 HANSARD RD",
        "CITY:MAYNARDVILLE");

    doTest("T25",
        "Subject:E911\nTREE IN ROADWAY\nMICHAEL WITH PVFD 8657056703\nHANKINS HOLLOW RD, MAYNARDVILLE\nALREADY ONSCENE DO NOT TONE OUT JUST BUILD C",
        "CALL:TREE IN ROADWAY",
        "PLACE:MICHAEL WITH PVFD",
        "PHONE:8657056703",
        "ADDR:HANKINS HOLLOW RD",
        "MADDR:MICHAEL WITH PVFD,HANKINS HOLLOW RD",
        "CITY:MAYNARDVILLE",
        "INFO:ALREADY ONSCENE DO NOT TONE OUT JUST BUILD C");

    doTest("T26",
        "Subject:E911\nACCIDENT W/INJURY\nKELLY HOLT 8656610782\n248 SATTERFIELD RD, Maynardville\n2 VEHICLE MVA",
        "CALL:ACCIDENT W/INJURY",
        "NAME:KELLY HOLT",
        "PHONE:8656610782",
        "ADDR:248 SATTERFIELD RD",
        "CITY:Maynardville",
        "INFO:2 VEHICLE MVA");

    doTest("T27",
        "Subject:E911\nCHEST PAIN\nTANASI GIRL SCOUT CAMP 8654947470\n123 DARK HOLLOW RD NORTH, ANDERSONVILLE",
        "CALL:CHEST PAIN",
        "PLACE:TANASI GIRL SCOUT CAMP",
        "PHONE:8654947470",
        "ADDR:123 DARK HOLLOW RD NORTH",
        "CITY:ANDERSONVILLE");

    doTest("T28",
        "Subject:E911\nBREATHING DIFFICULTY\nCHAD 8657409487\n1115 BEARD VALLEY RD, LOT-6, MAYNARDVILLE\n14 MONTH OLD FEMALE, LOSING BREATH",
        "CALL:BREATHING DIFFICULTY",
        "NAME:CHAD",
        "PHONE:8657409487",
        "ADDR:1115 BEARD VALLEY RD",
        "APT:LOT-6",
        "CITY:MAYNARDVILLE",
        "INFO:14 MONTH OLD FEMALE, LOSING BREATH");

    doTest("T29",
        "Subject:E911\nFIRE GENERAL\nJANET CABBAGE 4232110397\n830 SATTERFIELD RD, MAYNARDVILLE\nLOG CABIN",
        "CALL:FIRE GENERAL",
        "NAME:JANET CABBAGE",
        "PHONE:4232110397",
        "ADDR:830 SATTERFIELD RD",
        "CITY:MAYNARDVILLE",
        "INFO:LOG CABIN");

    doTest("T30",
        "Subject:E911\nFIRE GENERAL\nROSCOE SANDS 8659920605\n1527 MAIN ST, MAYNARDVILLE",
        "CALL:FIRE GENERAL",
        "NAME:ROSCOE SANDS",
        "PHONE:8659920605",
        "ADDR:1527 MAIN ST",
        "CITY:MAYNARDVILLE");
  }
  
  @Test
  public void test2Parser() {

    doTest("T1",
        "S:E911 M:TREE IN ROADWAY\nSHARON COLLINS 8653567818\n143 RACCOON VALLEY RD, MAYNARDVILLE\n\n",
        "CALL:TREE IN ROADWAY",
        "NAME:SHARON COLLINS",
        "PHONE:8653567818",
        "ADDR:143 RACCOON VALLEY RD",
        "CITY:MAYNARDVILLE");
 
  }
  
  @Test
  public void test() {

    doTest("T1",
        "FRM:dispatch@911email.net\nSUBJ:E911\nMSG:FIRE VEHICLE\r\nAARON WILLIAMS 1162 RACCOON VALLEY RD, MAYNARDVILLE\r\n",
        "CALL:FIRE VEHICLE",
        "NAME:AARON WILLIAMS",
        "ADDR:1162 RACCOON VALLEY RD",
        "CITY:MAYNARDVILLE");

    doTest("T2",
        "FRM:dispatch@911email.net\nSUBJ:E911\nMSG:TREE IN ROADWAY\r\nWELCH DR\r\n",
        "CALL:TREE IN ROADWAY",
        "ADDR:WELCH DR");

    doTest("T3",
        "FRM:dispatch@911email.net\nSUBJ:E911\nMSG:HEART PROBLEM\r\nDESSIE WILLIAMS 431 SATTERFIELD RD, LUTTRELL\r\n",
        "CALL:HEART PROBLEM",
        "NAME:DESSIE WILLIAMS",
        "ADDR:431 SATTERFIELD RD",
        "CITY:LUTTRELL");
   
  }
  

  public static void main(String[] args) {
    new TNUnionCountyParserTest().generateTests("T1");
  }
}
