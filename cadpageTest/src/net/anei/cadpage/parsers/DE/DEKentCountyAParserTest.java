package net.anei.cadpage.parsers.DE;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Kent County, DE (Variant A)
Contact: John Wothers <eng416res@yahoo.com>
Sender: rc.187@c-msg.net
System: New World Systems

[!]  [K] 12D1 Seizure - Not Breathing 263 MORGANS CHOICE RD Camden Wyoming : Xst's: WILLOW GROVE RD / MUMFIELD LN Caller: COLE JR EARL
[!]  [K] Alarms-Residential (single) 121 BIRKDALE LN Camden Wyoming : TRAYBERN Xst's: BIRKDALE WAY / N HIGH HILL RD, TRAYBERN WAY Caller: ADT
[!]  [K] Structure-Chimney 6871 WILLOW GROVE RD Camden Wyoming : Xst's: HENRY COWGILL RD / WILLOW TREE CIR Caller: PETE
[!]  [K] 31D2 Unconscious/Fainting 10829 WESTVILLE RD Camden Wyoming : Xst's: UNKNOWN / GREENS VILLAGE DR Caller: JOHNSON WANDA
[!]  [K] 29B1 MVC Injuries HENRY COWGILL RD Camden Wyoming : Xst's: Caller:
[!]  [K] Alarms-Residential (single) 233 TOWER RD Camden Wyoming : Xst's: UNKNOWN / DARLING FARM RD Caller: GUARDIAN TINA
[!]  [K] Stand-By,Cover-up 2 N MAIN ST STATION 55 Magnolia : MAGNOLIA Xst's: W WALNUT ST, S MAIN ST, E WALNUT ST / BOOTY DR Caller:
[!]  [K] 17B3G Falls - Unknown 852 STEELES RIDGE RD Camden Wyoming : Xst's: ASHLAND AVE / HENRY COWGILL RD, MAIN ST Caller: GARY
[!]  [K] Alarms-Commercial 1678 S GOVERNORS AVE Dover : Xst's: S DUPONT HWY / GUNNING BEDFORD DR Caller: DAVID
[!]  [K] 29D2L MVC Motorcycle/Bicycle 375 GATEWAY SOUTH BLVD SONIC - SOUTH DOVER Dover : Xst's: DEAD END / DEAD END Caller:
[!]  [K] Structure-Residential Single 241 E CAMDEN WYOMING AVE Camden Wyoming : CAMDEN Xst's: S MAIN ST, N MAIN ST / S WEST ST, N WEST ST Caller: HARRISON THERE'S

Contact: Tom <tw4715@comcast.net>
[CAD]33C1T Transfer/Interfacility 2809 ANDREWVILLE RD Harrington : Xst's: TODDS CHAPEL RD, PROSPECT CHURCH RD / GREENWOOD RD Caller: CAY HOLLY
[47 FIRE/EMS]1C6 Abdominal Pains 46 MAIN ST Greenwood : Xst's: ANDREWVILLE RD, FLAT IRON RD / FARMINGTON RD Caller: MURRAY BOBBY

Contact: Sam Crawford <nremtde@gmail.com>
[K] 17B1G Falls - Possibly Dangerous 2 LAKE CREST DR Milford : HAVEN LAKE ESTATES Xst's: HAVEN LN / WILLIAMSVILLE RD Caller: L MURPHY

Contact: firechief47188@gmail.com
Sender: rc.85@c-msg.net
17A1G Falls - Not Dangerous 1203 MADISON AVE Harrington : Xst's: COLEMAN ST / MASON AVE Caller: HEMER NORA

Contact: Bob Parson <pastchiefparson@gmail.com>
31D3 Unconscious/Fainting 1203 MADISON AVE Harrington : Xst's: COLEMAN ST / MASON AVE Caller: O'DONAL RHONDA\2s
EMS Stand-by 15 W ROBERT F RIDER RD HARRINGTON RACEWAY Harrington : STATE FAIR GROUNDS Xst's: F GARY SIMPSON RD / BENJAMIN I SHAW ST Caller:\r\n
10D4 Chest Pains - Clammy 210 E CENTER ST Harrington : Xst's: DELAWARE AVE / 2ND AVE Caller: JARRELL NORRIS\r\n

 */

public class DEKentCountyAParserTest extends BaseParserTest {
  
  public DEKentCountyAParserTest() {
    setParser(new DEKentCountyAParser(), "KENT COUNTY", "DE");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "[!]  [K] 12D1 Seizure - Not Breathing 263 MORGANS CHOICE RD Camden Wyoming : Xst's: WILLOW GROVE RD / MUMFIELD LN Caller: COLE JR EARL",
        "CALL:12D1 Seizure - Not Breathing",
        "ADDR:263 MORGANS CHOICE RD",
        "CITY:Camden Wyoming",
        "X:WILLOW GROVE RD / MUMFIELD LN");

    doTest("T2",
        "[!]  [K] Alarms-Residential (single) 121 BIRKDALE LN Camden Wyoming : TRAYBERN Xst's: BIRKDALE WAY / N HIGH HILL RD, TRAYBERN WAY Caller: ADT",
        "CALL:Alarms-Residential (single)",
        "ADDR:121 BIRKDALE LN",
        "CITY:Camden Wyoming",
        "X:BIRKDALE WAY / N HIGH HILL RD, TRAYBERN WAY");

    doTest("T3",
        "[!]  [K] Structure-Chimney 6871 WILLOW GROVE RD Camden Wyoming : Xst's: HENRY COWGILL RD / WILLOW TREE CIR Caller: PETE",
        "CALL:Structure-Chimney",
        "ADDR:6871 WILLOW GROVE RD",
        "CITY:Camden Wyoming",
        "X:HENRY COWGILL RD / WILLOW TREE CIR");

    doTest("T4",
        "[!]  [K] 31D2 Unconscious/Fainting 10829 WESTVILLE RD Camden Wyoming : Xst's: UNKNOWN / GREENS VILLAGE DR Caller: JOHNSON WANDA",
        "CALL:31D2 Unconscious/Fainting",
        "ADDR:10829 WESTVILLE RD",
        "CITY:Camden Wyoming",
        "X:UNKNOWN / GREENS VILLAGE DR");

    doTest("T5",
        "[!]  [K] 29B1 MVC Injuries HENRY COWGILL RD Camden Wyoming : Xst's: Caller:",
        "CALL:29B1 MVC Injuries HENRY",
        "ADDR:COWGILL RD",
        "CITY:Camden Wyoming");

    doTest("T6",
        "[!]  [K] Alarms-Residential (single) 233 TOWER RD Camden Wyoming : Xst's: UNKNOWN / DARLING FARM RD Caller: GUARDIAN TINA",
        "CALL:Alarms-Residential (single)",
        "ADDR:233 TOWER RD",
        "CITY:Camden Wyoming",
        "X:UNKNOWN / DARLING FARM RD");

    doTest("T7",
        "[!]  [K] Stand-By,Cover-up 2 N MAIN ST STATION 55 Magnolia : MAGNOLIA Xst's: W WALNUT ST, S MAIN ST, E WALNUT ST / BOOTY DR Caller:",
        "CALL:Stand-By,Cover-up",
        "ADDR:2 N MAIN ST",
        "CITY:Magnolia",
        "X:W WALNUT ST, S MAIN ST, E WALNUT ST / BOOTY DR");

    doTest("T8",
        "[!]  [K] 17B3G Falls - Unknown 852 STEELES RIDGE RD Camden Wyoming : Xst's: ASHLAND AVE / HENRY COWGILL RD, MAIN ST Caller: GARY",
        "CALL:17B3G Falls - Unknown",
        "ADDR:852 STEELES RIDGE RD",
        "CITY:Camden Wyoming",
        "X:ASHLAND AVE / HENRY COWGILL RD, MAIN ST");

    doTest("T9",
        "[!]  [K] Alarms-Commercial 1678 S GOVERNORS AVE Dover : Xst's: S DUPONT HWY / GUNNING BEDFORD DR Caller: DAVID",
        "CALL:Alarms-Commercial",
        "ADDR:1678 S GOVERNORS AVE",
        "CITY:Dover",
        "X:S DUPONT HWY / GUNNING BEDFORD DR");

    doTest("T10",
        "[!]  [K] 29D2L MVC Motorcycle/Bicycle 375 GATEWAY SOUTH BLVD SONIC - SOUTH DOVER Dover : Xst's: DEAD END / DEAD END Caller:",
        "CALL:29D2L MVC Motorcycle/Bicycle",
        "ADDR:375 GATEWAY SOUTH BLVD",
        "CITY:Dover",
        "X:DEAD END / DEAD END");

    doTest("T11",
        "[!]  [K] Structure-Residential Single 241 E CAMDEN WYOMING AVE Camden Wyoming : CAMDEN Xst's: S MAIN ST, N MAIN ST / S WEST ST, N WEST ST Caller: HARRISON THERE'S",
        "CALL:Structure-Residential Single",
        "ADDR:241 E CAMDEN WYOMING AVE",
        "CITY:Camden Wyoming",
        "X:S MAIN ST, N MAIN ST / S WEST ST, N WEST ST");
  }
  
  @Test
  public void testTom() {

    doTest("T1",
        "[CAD]33C1T Transfer/Interfacility 2809 ANDREWVILLE RD Harrington : Xst's: TODDS CHAPEL RD, PROSPECT CHURCH RD / GREENWOOD RD Caller: CAY HOLLY",
        "CALL:33C1T Transfer/Interfacility",
        "ADDR:2809 ANDREWVILLE RD",
        "CITY:Harrington",
        "X:TODDS CHAPEL RD, PROSPECT CHURCH RD / GREENWOOD RD");

    doTest("T2",
        "[47 FIRE/EMS]1C6 Abdominal Pains 46 MAIN ST Greenwood : Xst's: ANDREWVILLE RD, FLAT IRON RD / FARMINGTON RD Caller: MURRAY BOBBY",
        "CALL:1C6 Abdominal Pains",
        "ADDR:46 MAIN ST",
        "X:ANDREWVILLE RD, FLAT IRON RD / FARMINGTON RD");
  }
  
  @Test
  public void testSamCrawford() {

    doTest("T1",
        "[K] 17B1G Falls - Possibly Dangerous 2 LAKE CREST DR Milford : HAVEN LAKE ESTATES Xst's: HAVEN LN / WILLIAMSVILLE RD Caller: L MURPHY  ",
        "CALL:17B1G Falls - Possibly Dangerous",
        "ADDR:2 LAKE CREST DR",
        "CITY:Milford",
        "X:HAVEN LN / WILLIAMSVILLE RD");

  }
  
  @Test
  public void testFireChief() {

    doTest("T1",
        "17A1G Falls - Not Dangerous 1203 MADISON AVE Harrington : Xst's: COLEMAN ST / MASON AVE Caller: HEMER NORA",
        "CALL:17A1G Falls - Not Dangerous",
        "ADDR:1203 MADISON AVE",
        "CITY:Harrington",
        "X:COLEMAN ST / MASON AVE");

  }
  
  @Test
  public void testBobParson() {

    doTest("T1",
        "31D3 Unconscious/Fainting 1203 MADISON AVE Harrington : Xst's: COLEMAN ST / MASON AVE Caller: O'DONAL RHONDA\\2s",
        "CALL:31D3 Unconscious/Fainting",
        "ADDR:1203 MADISON AVE",
        "CITY:Harrington",
        "X:COLEMAN ST / MASON AVE");

    doTest("T2",
        "EMS Stand-by 15 W ROBERT F RIDER RD HARRINGTON RACEWAY Harrington : STATE FAIR GROUNDS Xst's: F GARY SIMPSON RD / BENJAMIN I SHAW ST Caller:\r\n",
        "CALL:EMS Stand-by",
        "ADDR:15 W ROBERT F RIDER RD",  // GOogle can't map
        "CITY:Harrington",
        "X:F GARY SIMPSON RD / BENJAMIN I SHAW ST");

    doTest("T3",
        "10D4 Chest Pains - Clammy 210 E CENTER ST Harrington : Xst's: DELAWARE AVE / 2ND AVE Caller: JARRELL NORRIS\r\n",
        "CALL:10D4 Chest Pains - Clammy",
        "ADDR:210 E CENTER ST",
        "CITY:Harrington",
        "X:DELAWARE AVE / 2ND AVE");
    
  }
  
  public static void main(String[] args) {
    new DEKentCountyAParserTest().generateTests("T1");
  }
}
    		