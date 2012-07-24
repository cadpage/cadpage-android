package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class VALexingtonRockbridgeCountyParserTest extends BaseParserTest {
  
  public VALexingtonRockbridgeCountyParserTest() {
    setParser(new VALexingtonRockbridgeCountyParser(), "", "VA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "[LCAD] Type: EMS-TRNSPORT Loc: 429 W NELSON ST Units: LXRS1, City: LEXINGTON 1/27/2011 2:10:08 PM SPORT. BRUSHY 1\nMessage Created 1/27/2011 2:10:00 PM",
        "CALL:EMS-TRNSPORT",
        "ADDR:429 W NELSON ST",
        "UNIT:LXRS1,",
        "CITY:LEXINGTON",
        "INFO:SPORT. BRUSHY 1");

    doTest("T2",
        "[LCAD] Type: EMS-PAIN Loc: GREEN HILL APT Units: LXRS1, City: LEXINGTON 1/27/2011 1:22:32 AM **Nearest Address: 475 FOREST GROVE RD, LEXINGTON49 YOF HAVING A PANIC ATTACK & CAN`T FEEL LEGS.OPERATE BRUSHY 1\nMessage Created 1/27/2011 1:22:00 AM",
        "CALL:EMS-PAIN",
        "ADDR:475 FOREST GROVE RD",
        "UNIT:LXRS1,",
        "CITY:LEXINGTON",
        "PLACE:GREEN HILL APT",
        "INFO:49 YOF HAVING A PANIC ATTACK & CAN`T FEEL LEGS.OPERATE BRUSHY 1");

    doTest("T3",
        "[LCAD] Type: EMS-FALL Loc: 431 W NELSON ST Units: CO09A,LR17, City: LEXINGTON 1/26/2011 5:39:37 PM **Nearest Address: 1305 ENFIELD RD, LEXINGTON38 YO MALE HIT A ROCK WALL GASHES SWELLING[01/26/2011 17:39:45 : pos1 : LHUCH]SLIDING WITH THE KIDS\nMessage Created 1/26/2011 5:45:00 PM",
        "CALL:EMS-FALL",
        "ADDR:431 W NELSON ST",
        "UNIT:CO09A,LR17,",
        "CITY:LEXINGTON",
        "INFO:38 YO MALE HIT A ROCK WALL GASHES SWELLING SLIDING WITH THE KIDS");

    doTest("T4",
        "[LCAD] Type: EMS-FALL Loc: 431 W NELSON ST Units: LXRS1, City: LEXINGTON 1/26/2011 5:39:37 PM **Nearest Address: 1305 ENFIELD RD, LEXINGTON38 YO MALE HIT A ROCK WALL GASHES SWELLING\nMessage Created 1/26/2011 5:39:00 PM",
        "CALL:EMS-FALL",
        "ADDR:431 W NELSON ST",
        "UNIT:LXRS1,",
        "CITY:LEXINGTON",
        "INFO:38 YO MALE HIT A ROCK WALL GASHES SWELLING");

    doTest("T5",
        "[LCAD] Type: ACCIDENT MVC Loc: 60 WILLOW SPRINGS RD Units: LXRS2, City: LEXINGTON 1/26/2011 2:39:40 PM BLEEDING FROM HEAD AND ARM OTHER SIDE OF DAYS INN D2\nMessage Created 1/26/2011 2:39:00 PM",
        "CALL:ACCIDENT MVC",
        "ADDR:60 WILLOW SPRINGS RD",
        "UNIT:LXRS2,",
        "CITY:LEXINGTON",
        "INFO:BLEEDING FROM HEAD AND ARM OTHER SIDE OF DAYS INN D2");

    doTest("T6",
        "[LCAD] Type: ACCIDENT MVC Loc: MAURY RIVER RD Units: CO09A, City: LEXINGTON 1/26/2011 2:37:32 PM **Nearest Address: 1305 ENFIELD RD, LEXINGTONSINGLE VEHICLE OVERTURNED, APPROX 2 MILES LONGS CAMPGROUND\nMessage Created 1/26/2011 2:37:00 PM",
        "CALL:ACCIDENT MVC",
        "ADDR:MAURY RIVER RD",
        "UNIT:CO09A,",
        "CITY:LEXINGTON",
        "INFO:SINGLE VEHICLE OVERTURNED, APPROX 2 MILES LONGS CAMPGROUND");

    doTest("T7",
        "[LCAD] Type: ACCIDENT MVC Loc: 81 SB 201 SB Units: B75,EM1,LXRS1,R73, City: FAIRFIELD 1/26/2011 2:23:09 PM **Nearest Address: NoneALTIMA GREY FEMALE BACK PAIN\nMessage Created 1/26/2011 2:34:00 PM",
        "CALL:ACCIDENT MVC",
        "ADDR:81 SB 201 SB",
        "MADDR:81 201",
        "UNIT:B75,EM1,LXRS1,R73,",
        "CITY:FAIRFIELD",
        "INFO:ALTIMA GREY FEMALE BACK PAIN");

    doTest("T8",
        "[LCAD] Type: ACCIDENT MVC Loc: 60 W 1/2 W DAYS INN AND SHELL STATION Units: CO09A,LXRS1, City: LEXINGTON 1/26/2011 12:55:37 PM **Nearest Address: NoneSILVER VAN SLID OFF ROAD OVER EMBANKMENT ON IT HIT TREES UNKNOWN INJURIES\nMessage Created 1/26/2011 12:56:00 PM",
        "CALL:ACCIDENT MVC",
        "ADDR:60 W 1/2 W DAYS INN AND SHELL STATION",
        "UNIT:CO09A,LXRS1,",
        "CITY:LEXINGTON",
        "INFO:SILVER VAN SLID OFF ROAD OVER EMBANKMENT ON IT HIT TREES UNKNOWN INJURIES");

    doTest("T9",
        "[LCAD] Type: EMS-HEM Loc: 160 KENDAL DR Units: LXRS1, City: LEXINGTON 1/26/2011 11:00:36 AM D FOR MALE RECTAL BLEED BORDEN CENTER RM106\nMessage Created 1/26/2011 11:00:00 AM",
        "CALL:EMS-HEM",
        "ADDR:160 KENDAL DR",
        "UNIT:LXRS1,",
        "CITY:LEXINGTON",
        "INFO:D FOR MALE RECTAL BLEED BORDEN CENTER RM106");

    doTest("T10",
        "S:LCAD M:[LCAD] Type: ACCIDENT MVC Loc: I-81 N BOUND Units: CO09A,LXRS1, City: LEXINGTON 8/14/2011 2:36:17 PM **Nearest Address: \n\n",
        "CALL:ACCIDENT MVC",
        "ADDR:I-81 N BOUND",
        "MADDR:I 81 N BOUND",
        "UNIT:CO09A,LXRS1,",
        "CITY:LEXINGTON");
  }
  C
  public static void main(String[] args) {
    new VALexingtonRockbridgeCountyParserTest().generateTests("T1");
  }
}