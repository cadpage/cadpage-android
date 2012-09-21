package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.NY.NYErieCountyCParserTest;

import org.junit.Test;


public class NYErieCountyCParserTest extends BaseParserTest {
  
  public NYErieCountyCParserTest() {
    setParser(new NYErieCountyCParser(), "ERIE COUNTY", "NY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Erie_Alert EDEN 2097 SHERMAN- 1 YOA MALE CHOKING 15 TO HALL NEED 1 ADD'L  <NOREPLY>",
        "CALL:GENERAL ALERT",
        "PLACE:EDEN 2097 SHERMAN- 1 YOA MALE CHOKING 15 TO HALL NEED 1 ADD'L");

    doTest("T2",
        "Erie_Alert MES/NCEMS: ALL MEMBERS PARTICIPATING IN THE MEMORIAL DAY PARADE MEET @ HALL ON MON 5/28 @ 0815 HRS IN FULL DRESS UNIFORM  <NOREPLY>",
        "CALL:GENERAL ALERT",
        "PLACE:MES/NCEMS: ALL MEMBERS PARTICIPATING IN THE MEMORIAL DAY PARADE MEET @ HALL ON MON 5/28 @ 0815 HRS IN FULL DRESS UNIFORM");

    doTest("T3",
        "Erie_Alert ANIMAL INJURY  TN OF EDEN EDEN 805+707 TO REESPOND COLD TO 2880 BELKNAP FOR INJURED ANIMAL EXTRACTION  <NOREPLY>",
        "CALL:GENERAL ALERT",
        "PLACE:ANIMAL INJURY  TN OF EDEN EDEN 805+707 TO REESPOND COLD TO 2880 BELKNAP FOR INJURED ANIMAL EXTRACTION");

    doTest("T4",
        "Erie_Alert FIRST AID 2209 EDEN EVANS CNTR RD EDEN 76/F TROUBLE BREATHING CONCIOUS AND ALERT 55+13+M1 TO HALL  <NOREPLY>",
        "CALL:FIRST AID",
        "ADDR:2209 EDEN EVANS CNTR RD",
        "INFO:EDEN 76 / F TROUBLE BREATHING CONCIOUS AND ALERT 55+13+M1 TO HALL");

    doTest("T5",
        "Erie_Alert EMS: MHL 9.41 transport - Assemble a crew at the squad hall & wait for patrol to secure the scene - BLS cold response - 11, 27, 37, 55 ",
        "CALL:GENERAL ALERT",
        "PLACE:EMS: MHL 9.41 transport - Assemble a crew at the squad hall & wait for patrol to secure the scene - BLS cold response - 11, 27, 37, 55");

    doTest("T6",
        "Erie_Alert Working  Fire: working structure fire front of house on fire across from 2833 e church st at 2833 E CHURCH ST, Eden  c/s: HAMMOND DR . . ... ",
        "CALL:Working Fire",
        "ADDR:2833 e church st",
        "INFO:working structure fire front of house on fire across from / at 2833 E CHURCH ST, Eden",
        "X:HAMMOND DR");

    doTest("T7",
        "Erie_Alert FIRST AID 2724 W CHURCH ST EDEN 60/F FELL INSIDE THE BUILDING. CONSCIOUS AND ALERT. 49 TO THE HALL. MEDIC ONE TO THE SCE  <NOREPLY>",
        "CALL:FIRST AID",
        "ADDR:2724 W CHURCH ST",
        "INFO:EDEN 60 / F FELL INSIDE THE BUILDING CONSCIOUS AND ALERT 49 TO THE HALL MEDIC ONE TO THE SCE");

    doTest("T8",
        "Erie_Alert FIRST AID. MEET WITH PATROL FOR A 20/F ARM INJ FROM AN ACCIDENT CLARKSBURG/NEW OREGON 63/72 TO THE HALL  <NOREPLY>",
        "CALL:GENERAL ALERT",
        "PLACE:FIRST AID. MEET WITH PATROL FOR A 20/F ARM INJ FROM AN ACCIDENT CLARKSBURG/NEW OREGON 63/72 TO THE HALL");

    doTest("T9",
        "Erie_Alert 8202 E EDEN RD APT: 3 EDEN UPPER- USE DOOR ON LEFT SIDE OF BLDG,  FEMALE- BREATHING BUT UNRESPONSIVE-35, 41 TO HALL NEE  <NOREPLY>",
        "ADDR:8202 E EDEN RD",
        "APT:3",
        "INFO:EDEN UPPER- USE DOOR ON LEFT SIDE OF BLDG, FEMALE- BREATHING BUT UNRESPONSIVE-35, 41 TO HALL NEE");
  
  }
  
  public static void main(String[] args) {
    new NYErieCountyCParserTest().generateTests("T1", "CALL ADDR APT INFO X PLACE");
  }
}