package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Northumberland County, PA
Contact: Kyle Rudy <rescuengine41@yahoo.com>
Contact: Chris Yetter <co50ffyetter@gmail.com>
Contact: Terry Wolford <terrywolford@gmail.com>
Sender: @northumberland.alertpa.org

desc STHY 147 & BRUSH VALLEY RD * UPA * ACCIDENT - MVA WITH UNKNOWN INJURY(S) * Dispatch: CH 503,TK 542,MICU 545,ENG 721,CH 723,SQ 723,CH 721,ENG 541,SQ 553,SQ 581,RES 552,AMB 547,CH 722,CH 505,BR 724 affected loc AMB 547,MICU 545,ENG 541,RES 552,SQ 581,CH 721,CH 722,CH 723,ENG 721,SQ 723,CH 503,CH 505,BR 724,TK 542,SQ 553
desc 202 E PINE ST * YSE * FIRE - DWELLING - 2ND ALARM * Dispatch: ENG 561,TK 542,RES 735,MICU 545,ENG 572,SQ 563,UN 548,CH 505,RH 544 affected loc UN 548
LINCOLN ST & MEMORIAL DR * SUN * CARBON MONOXIDE INCIDENT * Dispatch: CH 503,CH 504,TK 542,ENG 531,SQ 581,MICU 91,ENG 572,CH 501,CH 502
330 S SHAMOKIN ST * SHA * FIRE - VEHICLE (CAR/SUV/VAN/ETC...) * Dispatch: FP 80,ENG 41,S/CH 4,ENG 11,S/CH 1 ,SH 21,S/CH 3,RES 62 ENG 11,SH 21,S/CH 3,RES 62,FP 80
S ANTHRACITE ST & W HIGH ST * SHA * FIRE - BRUSH * Dispatch: FP 80,ENG 41,BR 153,S/CH 4,SQ 21,ENG 11,S/CH 1 ,SH 21,S/CH 3,S/CH 2,RES 62 SH 21
204 MAIN ST * COA * STAND-BY ASSIGNMENT * Dispatch: ENG 141,ENG 41,ENG1,TK 32,AT 21,MICU 90,UT 195,SQ 66,ENG 294,A/L 36,ENG 161,SH 21,RES 62,AMB 923 AMB 923,MICU 90,AT 21,ENG 141,ENG 161,UT 195,ENG1,ENG 294,SH 21,TK 32,ENG 41,RES 62
19 N GRANT ST * SHA * FIRE - DWELLING - 1ST ALARM * Dispatch: FP 80,ENG 41,TK 32,S/CH 4,SQ 21,SQ 11,ENG 11,S/CH 1 ,ENG 51,SQ 66,AMB 919,SH 21,S/CH 3,S/CH 2,RES 62 ENG 11,SH 21,TK 32,ENG 41,ENG 51,RES 62,FP 80
123 N FRANKLIN ST * SHA * FIRE - DWELLING - 1ST ALARM * Dispatch: FP 80,ENG 41,TK 32,S/CH 4,SQ 21,SQ 11,MICU 90\r
581 DUKE ST * NOB * ACCIDENT - MVA WITH FLUIDS DOWN * Dispatch: RES 735,CH 731,SQ 747,ENG 731,SQ 737
940 HOOKIES GROVE RD * POI * CARBON MONOXIDE INCIDENT * Dispatch: ENG 741,RES 735,CH 742,AT 749,SQ 746,MICU 91,SQ 747,ENG 742,CH 741

*DO NOT INSERT BLANK BETWEEN MESSAGES!!

Contact: Active911
Agency name: Northumberland Fire Department
Location: Northumberland, PA, United States
Sender: @northumberland.alertpa.org

(NorryCAD) 58 NEITZ RD * POI * AFA - NURSING HOME * Dispatch: ENG 741,RES 735,CH 742,AT 749,SQ 746,MICU 91,SQ 747,ENG 742,CH 741\r\nMICU 91,RES 735,ENG 741,ENG 742\n\nSent by the Northumberland County Department of Public Safety to ST732 \r\n\r\nTell a friend/co-worker about Northumberland County and have them register for this free service at https://northumberland.alertpa.org.\r\n\r
(North'd County Test to NHL Members) Test #3 - No need to respond. Thank you for your patience\n\nSent by the Northumberland County Department of Public Safety to Northumberland Hook & Ladder \r\n\r\nTell a friend/co-worker about Northumberland County and have them register for this free service at https://northumberland.alertpa.org.\r\n\r
(Test for NHL Memebers) Test # 2 for NHL Members\n\nSent by the Northumberland County Department of Public Safety to Northumberland Hook & Ladder \r\n\r\nTell a friend/co-worker about Northumberland County and have them register for this free service at https://northumberland.alertpa.org.\r\n\r
(test) test\n\nSent by the Northumberland County Department of Public Safety to Northumberland Hook & Ladder \r\n\r\nTell a friend/co-worker about Northumberland County and have them register for this free service at https://northumberland.alertpa.org.\r\n\r

 */

public class PANorthumberlandCountyParserTest extends BaseParserTest {
  
  public PANorthumberlandCountyParserTest() {
    setParser(new PANorthumberlandCountyParser(), "NORTHUMBERLAND COUNTY", "PA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "desc STHY 147 & BRUSH VALLEY RD * UPA * ACCIDENT - MVA WITH UNKNOWN INJURY(S) * Dispatch: CH 503,TK 542,MICU 545,ENG 721,CH 723,SQ 723,CH 721,ENG 541,SQ 553,SQ 581,RES 552,AMB 547,CH 722,CH 505,BR 724 affected loc AMB 547,MICU 545,ENG 541,RES 552,SQ 581,CH 721,CH 722,CH 723,ENG 721,SQ 723,CH 503,CH 505,BR 724,TK 542,SQ 553",
        "ADDR:STHY 147 & BRUSH VALLEY RD",
        "MADDR:PA 147 & BRUSH VALLEY RD",
        "CITY:UPPER AUGUSTA",
        "CALL:ACCIDENT - MVA WITH UNKNOWN INJURY(S)",
        "UNIT:CH_503,TK_542,MICU_545,ENG_721,CH_723,SQ_723,CH_721,ENG_541,SQ_553,SQ_581,RES_552,AMB_547,CH_722,CH_505,BR_724 affected loc AMB_547,MICU_545,ENG_541,RES_552,SQ_581,CH_721,CH_722,CH_723,ENG_721,SQ_723,CH_503,CH_505,BR_724,TK_542,SQ_553");

    doTest("T2",
        "desc 202 E PINE ST * YSE * FIRE - DWELLING - 2ND ALARM * Dispatch: ENG 561,TK 542,RES 735,MICU 545,ENG 572,SQ 563,UN 548,CH 505,RH 544 affected loc UN 548",
        "ADDR:202 E PINE ST",
        "CITY:SELINGSGROVE",
        "CALL:FIRE - DWELLING - 2ND ALARM",
        "UNIT:ENG_561,TK_542,RES_735,MICU_545,ENG_572,SQ_563,UN_548,CH_505,RH_544 affected loc UN_548");

    doTest("T3",
        "LINCOLN ST & MEMORIAL DR * SUN * CARBON MONOXIDE INCIDENT * Dispatch: CH 503,CH 504,TK 542,ENG 531,SQ 581,MICU 91,ENG 572,CH 501,CH 502",
        "ADDR:LINCOLN ST & MEMORIAL DR",
        "CITY:SUNBURY",
        "CALL:CARBON MONOXIDE INCIDENT",
        "UNIT:CH_503,CH_504,TK_542,ENG_531,SQ_581,MICU_91,ENG_572,CH_501,CH_502");

    doTest("T4",
        "330 S SHAMOKIN ST * SHA * FIRE - VEHICLE (CAR/SUV/VAN/ETC...) * Dispatch: FP 80,ENG 41,S/CH 4,ENG 11,S/CH 1 ,SH 21,S/CH 3,RES 62 ENG 11,SH 21,S/CH 3,RES 62,FP 80",
        "ADDR:330 S SHAMOKIN ST",
        "CITY:SHAMOKIN",
        "CALL:FIRE - VEHICLE (CAR/SUV/VAN/ETC...)",
        "UNIT:FP_80,ENG_41,S/CH_4,ENG_11,S/CH_1 ,SH_21,S/CH_3,RES_62 ENG_11,SH_21,S/CH_3,RES_62,FP_80");

    doTest("T5",
        "S ANTHRACITE ST & W HIGH ST * SHA * FIRE - BRUSH * Dispatch: FP 80,ENG 41,BR 153,S/CH 4,SQ 21,ENG 11,S/CH 1 ,SH 21,S/CH 3,S/CH 2,RES 62 SH 21",
        "ADDR:S ANTHRACITE ST & W HIGH ST",
        "CITY:SHAMOKIN",
        "CALL:FIRE - BRUSH",
        "UNIT:FP_80,ENG_41,BR_153,S/CH_4,SQ_21,ENG_11,S/CH_1 ,SH_21,S/CH_3,S/CH_2,RES_62 SH_21");

    doTest("T6",
        "204 MAIN ST * COA * STAND-BY ASSIGNMENT * Dispatch: ENG 141,ENG 41,ENG1,TK 32,AT 21,MICU 90,UT 195,SQ 66,ENG 294,A/L 36,ENG 161,SH 21,RES 62,AMB 923 AMB 923,MICU 90,AT 21,ENG 141,ENG 161,UT 195,ENG1,ENG 294,SH 21,TK 32,ENG 41,RES 62",
        "ADDR:204 MAIN ST",
        "CITY:COAL",
        "CALL:STAND-BY ASSIGNMENT",
        "UNIT:ENG_141,ENG_41,ENG1,TK_32,AT_21,MICU_90,UT_195,SQ_66,ENG_294,A/L_36,ENG_161,SH_21,RES_62,AMB_923 AMB_923,MICU_90,AT_21,ENG_141,ENG_161,UT_195,ENG1,ENG_294,SH_21,TK_32,ENG_41,RES_62");

    doTest("T7",
        "19 N GRANT ST * SHA * FIRE - DWELLING - 1ST ALARM * Dispatch: FP 80,ENG 41,TK 32,S/CH 4,SQ 21,SQ 11,ENG 11,S/CH 1 ,ENG 51,SQ 66,AMB 919,SH 21,S/CH 3,S/CH 2,RES 62 ENG 11,SH 21,TK 32,ENG 41,ENG 51,RES 62,FP 80",
        "ADDR:19 N GRANT ST",
        "CITY:SHAMOKIN",
        "CALL:FIRE - DWELLING - 1ST ALARM",
        "UNIT:FP_80,ENG_41,TK_32,S/CH_4,SQ_21,SQ_11,ENG_11,S/CH_1 ,ENG_51,SQ_66,AMB_919,SH_21,S/CH_3,S/CH_2,RES_62 ENG_11,SH_21,TK_32,ENG_41,ENG_51,RES_62,FP_80");

    doTest("T8",
        "123 N FRANKLIN ST * SHA * FIRE - DWELLING - 1ST ALARM * Dispatch: FP 80,ENG 41,TK 32,S/CH 4,SQ 21,SQ 11,MICU 90\r",
        "ADDR:123 N FRANKLIN ST",
        "CITY:SHAMOKIN",
        "CALL:FIRE - DWELLING - 1ST ALARM",
        "UNIT:FP_80,ENG_41,TK_32,S/CH_4,SQ_21,SQ_11,MICU_90");

    doTest("T9",
        "581 DUKE ST * NOB * ACCIDENT - MVA WITH FLUIDS DOWN * Dispatch: RES 735,CH 731,SQ 747,ENG 731,SQ 737",
        "ADDR:581 DUKE ST",
        "CITY:NORTHUMBERLAND",
        "CALL:ACCIDENT - MVA WITH FLUIDS DOWN",
        "UNIT:RES_735,CH_731,SQ_747,ENG_731,SQ_737");

    doTest("T10",
        "940 HOOKIES GROVE RD * POI * CARBON MONOXIDE INCIDENT * Dispatch: ENG 741,RES 735,CH 742,AT 749,SQ 746,MICU 91,SQ 747,ENG 742,CH 741",
        "ADDR:940 HOOKIES GROVE RD",
        "CITY:POINT TWP",
        "CALL:CARBON MONOXIDE INCIDENT",
        "UNIT:ENG_741,RES_735,CH_742,AT_749,SQ_746,MICU_91,SQ_747,ENG_742,CH_741");
  
  }
  
  @Test
  public void testNorthumberlandFire() {

    doTest("T1",
        "(NorryCAD) 58 NEITZ RD * POI * AFA - NURSING HOME * Dispatch: ENG 741,RES 735,CH 742,AT 749,SQ 746,MICU 91,SQ 747,ENG 742,CH 741\r\n" +
        "MICU 91,RES 735,ENG 741,ENG 742\n\n" +
        "Sent by the Northumberland County Department of Public Safety to ST732 \r\n" +
        "\r\n" +
        "Tell a friend/co-worker about Northumberland County and have them register for this free service at https://northumberland.alertpa.org.\r\n" +
        "\r",

        "ADDR:58 NEITZ RD",
        "CITY:POINT TWP",
        "CALL:AFA - NURSING HOME",
        "UNIT:ENG_741,RES_735,CH_742,AT_749,SQ_746,MICU_91,SQ_747,ENG_742,CH_741 MICU_91,RES_735,ENG_741,ENG_742");

  }
  
  public static void main(String[] args) {
    new PANorthumberlandCountyParserTest().generateTests("T1");
  }
}