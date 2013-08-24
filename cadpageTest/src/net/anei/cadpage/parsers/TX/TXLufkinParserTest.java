package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Lufkin, TX (in Angelina County)
Contact: Active911
Agency name: City of Lufkin
Location: Lufkin, TX, United States
Sender: samhouston@cityoflufkin.com

(F Motor Vehicle Accident) \nF Motor Vehicle Accident\n--  PERSHING AVE, \n//\n Fire Box =\n\nDisclaimer: This electronic message may contain information that is Proprietary, Confidential, or legally privileged or protected. It is intended only for the use of the individual(s) and entity named in the message. If you are not an intended recipient of this message, please notify the sender immediately and delete the material from your computer. Do not deliver, distribute or copy this message and do not disclose its contents or take any action in reliance on the information it contains.
(F Active Fire alarm) \nF Active Fire alarm\n-- 1906 REDBUD LN, Lufkin\nS JOHN REDDITT DR//MEDICAL CENTER BLVD\n Fire Box = 402\n\nDisclaimer: This electronic message may contain information that is Proprietary, Confidential, or legally privileged or protected. It is intended only for the use of the individual(s) and entity named in the message. If you are not an intended recipient of this message, please notify the sender immediately and delete the material from your computer. Do not deliver, distribute or copy this message and do not disclose its contents or take any action in reliance on the information it contains.
(F Smoke in area) \nF Smoke in area\n--  Fm/1818/ 844, \n//\n Fire Box =\n\nDisclaimer: This electronic message may contain information that is Proprietary, Confidential, or legally privileged or protected. It is intended only for the use of the individual(s) and entity named in the message. If you are not an intended recipient of this message, please notify the sender immediately and delete the material from your computer. Do not deliver, distribute or copy this message and do not disclose its contents or take any action in reliance on the information it contains.
(F Poweline/Transformer) \nF Poweline/Transformer\n-- 602 JOYCE LN, Lufkin\nE DENMAN AVE//OAKWOOD DR\n Fire Box = 601\n\nDisclaimer: This electronic message may contain information that is Proprietary, Confidential, or legally privileged or protected. It is intended only for the use of the individual(s) and entity named in the message. If you are not an intended recipient of this message, please notify the sender immediately and delete the material from your computer. Do not deliver, distribute or copy this message and do not disclose its contents or take any action in reliance on the information it contains.
(F Unknown Odor) \nF Unknown Odor\n--  Fm841/loves, \n//\n Fire Box =\n\nDisclaimer: This electronic message may contain information that is Proprietary, Confidential, or legally privileged or protected. It is intended only for the use of the individual(s) and entity named in the message. If you are not an intended recipient of this message, please notify the sender immediately and delete the material from your computer. Do not deliver, distribute or copy this message and do not disclose its contents or take any action in reliance on the information it contains.
(F Unknown Odor) \nF Unknown Odor\n-- 807 PICARDY LN, Lufkin\nSOUTHWOOD DR//ROSENEATH ST\n Fire Box = 401\n\nDisclaimer: This electronic message may contain information that is Proprietary, Confidential, or legally privileged or protected. It is intended only for the use of the individual(s) and entity named in the message. If you are not an intended recipient of this message, please notify the sender immediately and delete the material from your computer. Do not deliver, distribute or copy this message and do not disclose its contents or take any action in reliance on the information it contains.
(F Smoke in area) \nF Smoke in area\n-- 1335 Fm 3124/monterey Park, \n//\n Fire Box =\n\nDisclaimer: This electronic message may contain information that is Proprietary, Confidential, or legally privileged or protected. It is intended only for the use of the individual(s) and entity named in the message. If you are not an intended recipient of this message, please notify the sender immediately and delete the material from your computer. Do not deliver, distribute or copy this message and do not disclose its contents or take any action in reliance on the information it contains.
(F HAZMAT Incident) \nF HAZMAT Incident\n-ANGELINA COLLEGE- 3500 S FIRST ST, Lufkin\nDANIEL MCCALL DR//COLLEGE DR\n Fire Box = 602\n\nDisclaimer: This electronic message may contain information that is Proprietary, Confidential, or legally privileged or protected. It is intended only for the use of the individual(s) and entity named in the message. If you are not an intended recipient of this message, please notify the sender immediately and delete the material from your computer. Do not deliver, distribute or copy this message and do not disclose its contents or take any action in reliance on the information it contains.
(F Active Fire alarm) \nF Active Fire alarm\n-- 607 VIVION ST, Lufkin\nJORDAN AVE//JOHNSON AVE\n Fire Box = 402\n\nDisclaimer: This electronic message may contain information that is Proprietary, Confidential, or legally privileged or protected. It is intended only for the use of the individual(s) and entity named in the message. If you are not an intended recipient of this message, please notify the sender immediately and delete the material from your computer. Do not deliver, distribute or copy this message and do not disclose its contents or take any action in reliance on the information it contains.
(F Vehicle Fire) \nF Vehicle Fire\n-- 107 OKLAHOMA ST, \n//\n Fire Box =\n\nDisclaimer: This electronic message may contain information that is Proprietary, Confidential, or legally privileged or protected. It is intended only for the use of the individual(s) and entity named in the message. If you are not an intended recipient of this message, please notify the sender immediately and delete the material from your computer. Do not deliver, distribute or copy this message and do not disclose its contents or take any action in reliance on the information it contains.

*/

public class TXLufkinParserTest extends BaseParserTest {
  
  public TXLufkinParserTest() {
    setParser(new TXLufkinParser(), "ANGELINA COUNTY", "TX");
  }
  
  @Test
  public void testCityOfLufkin() {

    doTest("T1",
        "(F Motor Vehicle Accident) \n" +
        "F Motor Vehicle Accident\n" +
        "--  PERSHING AVE, \n" +
        "//\n" +
        " Fire Box =\n\n" +
        "Disclaimer: This electronic message may contain information that is Proprietary, Confidential, or legally privileged or protected. It is intended only for the use of the individual(s) and entity named in the message. If you are not an intended recipient of this message, please notify the sender immediately and delete the material from your computer. Do not deliver, distribute or copy this message and do not disclose its contents or take any action in reliance on the information it contains.",

        "CALL:F Motor Vehicle Accident",
        "ADDR:PERSHING AVE");

    doTest("T2",
        "(F Active Fire alarm) \n" +
        "F Active Fire alarm\n" +
        "-- 1906 REDBUD LN, Lufkin\n" +
        "S JOHN REDDITT DR//MEDICAL CENTER BLVD\n" +
        " Fire Box = 402\n\n" +
        "Disclaimer: This electronic message may contain information that is Proprietary, Confidential, or legally privileged or protected. It is intended only for the use of the individual(s) and entity named in the message. If you are not an intended recipient of this message, please notify the sender immediately and delete the material from your computer. Do not deliver, distribute or copy this message and do not disclose its contents or take any action in reliance on the information it contains.",

        "CALL:F Active Fire alarm",
        "ADDR:1906 REDBUD LN",
        "CITY:Lufkin",
        "X:S JOHN REDDITT DR/MEDICAL CENTER BLVD",
        "BOX:402");

    doTest("T3",
        "(F Smoke in area) \n" +
        "F Smoke in area\n" +
        "--  Fm/1818/ 844, \n" +
        "//\n" +
        " Fire Box =\n\n" +
        "Disclaimer: This electronic message may contain information that is Proprietary, Confidential, or legally privileged or protected. It is intended only for the use of the individual(s) and entity named in the message. If you are not an intended recipient of this message, please notify the sender immediately and delete the material from your computer. Do not deliver, distribute or copy this message and do not disclose its contents or take any action in reliance on the information it contains.",

        "CALL:F Smoke in area",
        "ADDR:Fm & 1818 & 844");

    doTest("T4",
        "(F Poweline/Transformer) \n" +
        "F Poweline/Transformer\n" +
        "-- 602 JOYCE LN, Lufkin\n" +
        "E DENMAN AVE//OAKWOOD DR\n" +
        " Fire Box = 601\n\n" +
        "Disclaimer: This electronic message may contain information that is Proprietary, Confidential, or legally privileged or protected. It is intended only for the use of the individual(s) and entity named in the message. If you are not an intended recipient of this message, please notify the sender immediately and delete the material from your computer. Do not deliver, distribute or copy this message and do not disclose its contents or take any action in reliance on the information it contains.",

        "CALL:F Poweline/Transformer",
        "ADDR:602 JOYCE LN",
        "CITY:Lufkin",
        "X:E DENMAN AVE/OAKWOOD DR",
        "BOX:601");

    doTest("T5",
        "(F Unknown Odor) \n" +
        "F Unknown Odor\n" +
        "--  Fm841/loves, \n" +
        "//\n" +
        " Fire Box =\n\n" +
        "Disclaimer: This electronic message may contain information that is Proprietary, Confidential, or legally privileged or protected. It is intended only for the use of the individual(s) and entity named in the message. If you are not an intended recipient of this message, please notify the sender immediately and delete the material from your computer. Do not deliver, distribute or copy this message and do not disclose its contents or take any action in reliance on the information it contains.",

        "CALL:F Unknown Odor",
        "ADDR:Fm841 & loves",
        "MADDR:Fm 841 & loves");  // Not mapping

    doTest("T6",
        "(F Unknown Odor) \n" +
        "F Unknown Odor\n" +
        "-- 807 PICARDY LN, Lufkin\n" +
        "SOUTHWOOD DR//ROSENEATH ST\n" +
        " Fire Box = 401\n\n" +
        "Disclaimer: This electronic message may contain information that is Proprietary, Confidential, or legally privileged or protected. It is intended only for the use of the individual(s) and entity named in the message. If you are not an intended recipient of this message, please notify the sender immediately and delete the material from your computer. Do not deliver, distribute or copy this message and do not disclose its contents or take any action in reliance on the information it contains.",

        "CALL:F Unknown Odor",
        "ADDR:807 PICARDY LN",
        "CITY:Lufkin",
        "X:SOUTHWOOD DR/ROSENEATH ST",
        "BOX:401");

    doTest("T7",
        "(F Smoke in area) \n" +
        "F Smoke in area\n" +
        "-- 1335 Fm 3124/monterey Park, \n" +
        "//\n" +
        " Fire Box =\n\n" +
        "Disclaimer: This electronic message may contain information that is Proprietary, Confidential, or legally privileged or protected. It is intended only for the use of the individual(s) and entity named in the message. If you are not an intended recipient of this message, please notify the sender immediately and delete the material from your computer. Do not deliver, distribute or copy this message and do not disclose its contents or take any action in reliance on the information it contains.",

        "CALL:F Smoke in area",
        "ADDR:1335 Fm 3124 & monterey Park",
        "MADDR:1335 Fm 3124");

    doTest("T8",
        "(F HAZMAT Incident) \n" +
        "F HAZMAT Incident\n" +
        "-ANGELINA COLLEGE- 3500 S FIRST ST, Lufkin\n" +
        "DANIEL MCCALL DR//COLLEGE DR\n" +
        " Fire Box = 602\n\n" +
        "Disclaimer: This electronic message may contain information that is Proprietary, Confidential, or legally privileged or protected. It is intended only for the use of the individual(s) and entity named in the message. If you are not an intended recipient of this message, please notify the sender immediately and delete the material from your computer. Do not deliver, distribute or copy this message and do not disclose its contents or take any action in reliance on the information it contains.",

        "CALL:F HAZMAT Incident",
        "PLACE:ANGELINA COLLEGE",
        "ADDR:3500 S FIRST ST",
        "CITY:Lufkin",
        "X:DANIEL MCCALL DR/COLLEGE DR",
        "BOX:602");

    doTest("T9",
        "(F Active Fire alarm) \n" +
        "F Active Fire alarm\n" +
        "-- 607 VIVION ST, Lufkin\n" +
        "JORDAN AVE//JOHNSON AVE\n" +
        " Fire Box = 402\n\n" +
        "Disclaimer: This electronic message may contain information that is Proprietary, Confidential, or legally privileged or protected. It is intended only for the use of the individual(s) and entity named in the message. If you are not an intended recipient of this message, please notify the sender immediately and delete the material from your computer. Do not deliver, distribute or copy this message and do not disclose its contents or take any action in reliance on the information it contains.",

        "CALL:F Active Fire alarm",
        "ADDR:607 VIVION ST",
        "CITY:Lufkin",
        "X:JORDAN AVE/JOHNSON AVE",
        "BOX:402");

    doTest("T10",
        "(F Vehicle Fire) \n" +
        "F Vehicle Fire\n" +
        "-- 107 OKLAHOMA ST, \n" +
        "//\n" +
        " Fire Box =\n\n" +
        "Disclaimer: This electronic message may contain information that is Proprietary, Confidential, or legally privileged or protected. It is intended only for the use of the individual(s) and entity named in the message. If you are not an intended recipient of this message, please notify the sender immediately and delete the material from your computer. Do not deliver, distribute or copy this message and do not disclose its contents or take any action in reliance on the information it contains.",

        "CALL:F Vehicle Fire",
        "ADDR:107 OKLAHOMA ST");
  
  }
  
  public static void main(String[] args) {
    new TXLufkinParserTest().generateTests("T1");
  }
}
