package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class TXHarrisCountyESD1BParserTest extends BaseParserTest {
  
  public TXHarrisCountyESD1BParserTest() {
    setParser(new TXHarrisCountyESD1BParser(), "HARRIS COUNTY", "TX");
  }
  
  @Test
  public void testRunReport() {

    doTest("T11",
        "ID#:11-08-29436 - UNIT:L32 - DISP: 21:06:25 - ER: - OUT: - TO: - AT: - AIR: 21:0",
        "CALL:RUN REPORT",
        "PLACE:ID#:11-08-29436 - UNIT:L32 - DISP: 21:06:25 - ER: - OUT: - TO: - AT: - AIR: 21:0");

    doTest("T12",
        "FRM:cadnoreply@proxy.hcec.com\nMSG:ID#:12-06-21170- UNIT:E13 - DISP: 11:19:11 - ER: - OUT: - AIR: 11:23:42",
        "CALL:RUN REPORT",
        "PLACE:ID#:12-06-21170- UNIT:E13 - DISP: 11:19:11 - ER: - OUT: - AIR: 11:23:42");

    doTest("T13",
        "FRM:cadnoreply@proxy.hcec.com\nMSG:ID#:12-06-21170- UNIT:BRU23 - DISP: 10:57:35 - ER: - OUT: - AIR: 11:23:56",
        "CALL:RUN REPORT",
        "PLACE:ID#:12-06-21170- UNIT:BRU23 - DISP: 10:57:35 - ER: - OUT: - AIR: 11:23:56");

  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "ID#:11-06-20685 - - TRASH FIRE - 111 Bayou Dr - Apt:C - Bldg: - Key Map: 498D - Cross Streets:EAST FWY/MARKET - Box #:2002",
        "ID:11-06-20685",
        "CALL:TRASH FIRE",
        "ADDR:111 Bayou Dr",
        "APT:C",
        "MAP:498D",
        "X:EAST FWY/MARKET",
        "BOX:2002");

    doTest("T2",
        "ID#:11-06-20710 - - FIRE - PreAlert - 16217 Ridlon - Apt: - Bldg: intra SERVICES - Key Map: 498C - Cross Streets:SHEILA LN/WOODLAND D",
        "ID:11-06-20710",
        "CALL:FIRE - PreAlert",
        "ADDR:16217 Ridlon",
        "APT:intra SERVICES",
        "MAP:498C",
        "X:SHEILA LN/WOODLAND D");

    doTest("T3",
        "ID#:11-06-20658 - - 29A1 MOTOR VEHICLE A - East Fwy / Delldale - Apt: - Bldg: - Key Map: 498E - Cross Streets: - Box #:2004",
        "ID:11-06-20658",
        "CALL:29A1 MOTOR VEHICLE A",
        "ADDR:East Fwy & Delldale",
        "MAP:498E",
        "BOX:2004");

    doTest("T4",
        "ID#:11-06-20627 - - 29A1 MOTOR VEHICLE A - 16410 Ave D - Apt:1 - Bldg: AVE D APTS - Key Map: 498D - Cross Streets:WOODLAND DR/CEDAR L",
        "ID:11-06-20627",
        "CALL:29A1 MOTOR VEHICLE A",
        "ADDR:16410 Ave D",
        "APT:AVE D APTS-1",
        "MAP:498D",
        "X:WOODLAND DR/CEDAR L");
  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "ID#:11-07-25331 - - ALARMS - 1518 Great Dover Cir - Apt: - Bldg: - Key Map: 458W",
        "ID:11-07-25331",
        "CALL:ALARMS",
        "ADDR:1518 Great Dover Cir",
        "MAP:458W");

    doTest("T2",
        "ID#:11-07-25341 - 06D02 - 6D1 RESPIRATORY - 11870 Greenloch Ln - Apt: - Bldg: - Key Map: 416K - Cross Streets:GREENCANYON DR/GREENROC",
        "ID:11-07-25341",
        "CODE:06D02",
        "CALL:6D1 RESPIRATORY",
        "ADDR:11870 Greenloch Ln",
        "MAP:416K",
        "X:GREENCANYON DR/GREENROC");

    doTest("T3",
        "ID#:11-07-25342 - 25A01 - PSYCHIATRIC - 15215 S Brentwood Dr - Apt: - Bldg: - Key Map: 498E - Cross Streets:Dead End/DELLDALE - Box #:2004",
        "ID:11-07-25342",
        "CODE:25A01",
        "CALL:PSYCHIATRIC",
        "ADDR:15215 S Brentwood Dr",
        "MAP:498E",
        "X:Dead End/DELLDALE",
        "BOX:2004");

    doTest("T4",
        "ID#:11-07-25378 - - Stroke (CVA) - 11715 Greenglen Dr - Apt: - Bldg: - Key Map: 416K - Cross Streets:JOHN RALSTON RD/GREENROCK LN - B",
        "ID:11-07-25378",
        "CALL:Stroke (CVA)",
        "ADDR:11715 Greenglen Dr",
        "MAP:416K",
        "X:JOHN RALSTON RD/GREENROCK LN");

    doTest("T5",
        "ID#:11-07-25416 - - HEMORRHAGE/LACERATIO - 12370 S San Circle Dr - Apt: - Bldg: UNK TRAILER PARK - Key Map: 456C - Cross Streets:BARK",
        "ID:11-07-25416",
        "CALL:HEMORRHAGE/LACERATIO",
        "ADDR:12370 S San Circle Dr",
        "APT:UNK TRAILER PARK",
        "MAP:456C",
        "X:BARK");

    doTest("T6",
        "ID#:11-08-25733 - 55B04 - ELECTRICAL HAZARD - 16102 E Ih 10 - Apt: - Bldg: OLD RIVER CHURCH DAY - Key Map: 498G - Cross Streets:IH 10 EAST BAYOU RAMP/IH 10 SH -",
        "ID:11-08-25733",
        "CODE:55B04",
        "CALL:ELECTRICAL HAZARD",
        "ADDR:16102 E Ih 10",
        "APT:OLD RIVER CHURCH DAY",
        "MAP:498G",
        "X:IH 10 EAST BAYOU RAMP/IH 10 SH");

    doTest("T7",
        "ID#:11-08-25969 - 29D02m - 29D5 MOTOR VEHICLE A - 539 S Sheldon Rd - Apt: - Bldg: - Key Map: 498K - Cross Streets:JACINTO PORT BLVD/MARKET - Box #:2001",
        "ID:11-08-25969",
        "CODE:29D02m",
        "CALL:29D5 MOTOR VEHICLE A",
        "ADDR:539 S Sheldon Rd",
        "MAP:498K",
        "X:JACINTO PORT BLVD/MARKET",
        "BOX:2001");

    doTest("T8",
        "ID#:11-08-25936 - 29B04 - Traffic/Trans Incide - E BW 8 N / WOODFOREST BW 8 NB - Apt: - Bldg: - Key Map: 457Y - Cross Streets: - Box #:2005",
        "ID:11-08-25936",
        "CODE:29B04",
        "CALL:Traffic/Trans Incide",
        "ADDR:E BW 8 N & WOODFOREST BW 8 NB",
        "MADDR:E BW 8 N & WOODFOREST BW 8",
        "MAP:457Y",
        "BOX:2005");


    doTest("T9",
        "ID#:11-08-26006 - - Citizen Assist - 5500 E Bw 8 N - Apt: - Bldg: big tex storage - Key Map: 457Y - Cross Streets:BW 8 NB WALLISVILLE EXIT RAMP/ - Box #:2005",
        "ID:11-08-26006",
        "CALL:Citizen Assist",
        "ADDR:5500 E Bw 8 N",
        "APT:big tex storage",
        "MAP:457Y",
        "X:BW 8 NB WALLISVILLE EXIT RAMP/",
        "BOX:2005");

    doTest("T10",
        "ID#:11-08-28674 - Units:M151 - 32B01 - 32B1 UNKNOWN PROBLEM - 606 Commons Vista Dr - Apt: - Bldg: - Key Map: 298Q - Cross Streets:COM",
        "ID:11-08-28674",
        "UNIT:M151",
        "CODE:32B01",
        "CALL:32B1 UNKNOWN PROBLEM",
        "ADDR:606 Commons Vista Dr",
        "MAP:298Q",
        "X:COM");

    doTest("T11",
        "ID#:11-08-29430 - - FALLS - 17015 Faring Rd - Apt: - Bldg: - Key Map: 418X - Cro",
        "ID:11-08-29430",
        "CALL:FALLS",
        "ADDR:17015 Faring Rd",
        "MAP:418X");

    doTest("T12",
        "ID#:11-08-29436 - - ALARMS - 1714 Hidden Terrace Dr - Apt: - Bldg: - Key Map: 458S - Cross Streets:HIDDEN CREST DR/HIDDEN MANOR D - Box #:2005",
        "ID:11-08-29436",
        "CALL:ALARMS",
        "ADDR:1714 Hidden Terrace Dr",
        "MAP:458S",
        "X:HIDDEN CREST DR/HIDDEN MANOR D",
        "BOX:2005");

    doTest("T13",
        "ID#:11-08-26039 - - FUEL SPILL - 15880 Wallisville Rd - Apt: - Bldg: LEGEND OAKS - EAST - Key Map: 457V - Cross Streets:HIDDEN PARK DR/HYACINTH PATH W - Box #:2005",
        "ID:11-08-26039",
        "CALL:FUEL SPILL",
        "ADDR:15880 Wallisville Rd",
        "APT:LEGEND OAKS",
        "MAP:457V",
        "X:HIDDEN PARK DR/HYACINTH PATH W",
        "BOX:2005");

    doTest("T14",
        "ID#:11-08-26105 - 21B01 - HEMORRHAGE/LACERATIO - 11803 Greenmesa Dr - Apt: - Bld",
        "ID:11-08-26105",
        "CODE:21B01",
        "CALL:HEMORRHAGE/LACERATIO",
        "ADDR:11803 Greenmesa Dr");

    doTest("T15",
        "ID#:11-08-26080 - 13D01 - DIABETIC PROBLEMS - 10710 Green River Dr - Apt: - Bldg",
        "ID:11-08-26080",
        "CODE:13D01",
        "CALL:DIABETIC PROBLEMS",
        "ADDR:10710 Green River Dr");

    doTest("T16",
        "ID#:11-08-26159 - - Stab / GSW (B) - 919 Holbech - Apt: - Bldg: - Key Map: 497D",
        "ID:11-08-26159",
        "CALL:Stab / GSW (B)",
        "ADDR:919 Holbech",
        "MAP:497D");

    doTest("T17",
        "ID#:11-08-26160 - - HEART PROBLEMS - 9402 Abbotshall Ln - Apt: - Bldg: - Key Map: 456D - Cross Streets:ARBOR FIELD LN/STONEFIELD MANO - Box #:3304",
        "ID:11-08-26160",
        "CALL:HEART PROBLEMS",
        "ADDR:9402 Abbotshall Ln",
        "MAP:456D",
        "X:ARBOR FIELD LN/STONEFIELD MANO",
        "BOX:3304");
  }
  
  @Test
  public void testParser3() {

    doTest("T1",
        " 1 of 2\n" +
        "FRM:cadnoreply@proxy.hcec.com\n" +
        "MSG:ID#:12-06-21170 - 67D02 - 67D2 LG GRASS AND WO - US 90 / SHELDON US 90 RAMP - Apt: - Bldg: - Key Map:\n" +
        "(Con't) 2 of 2\n" +
        "458C - Cross Streets: - Box #:3304(End)",

        "ID:12-06-21170",
        "ADDR:US 90 & SHELDON US 90 RAMP",
        "MAP:458C",
        "CODE:67D02",
        "CALL:67D2 LG GRASS AND WO",
        "BOX:3304");

  }
  
  @Test
  public void testAddrChangeParser() {

    doTest("T1",
        "ID#:11-08-29410 - Address changed to:uvalde/kinsman - Cross Streets: - Key Map:NOT F",
        "ID:11-08-29410",
        "ADDR:uvalde & kinsman",
        "MAP:NOT F");

    doTest("T2",
        "ID#:11-08-26067 - Address changed to:620 SHELDON RD - Cross Streets:AVE C/RIDLON - Key Map:498B",
        "ID:11-08-26067",
        "ADDR:620 SHELDON RD",
        "X:AVE C/RIDLON",
        "MAP:498B");

    doTest("T3",
        "ID#:11-08-26080 - Address changed to:10710 Greens Crossing Blvd - Cross Streets",
        "ID:11-08-26080",
        "ADDR:10710 Greens Crossing Blvd");

  }

  public static void main(String[] args) {
    new TXHarrisCountyESD1BParserTest().generateTests("T11");
  }

}