package net.anei.cadpage.parsers.WI;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class WIEauClaireParserTest extends BaseParserTest {
  
  public WIEauClaireParserTest() {
    setParser(new WIEauClaireParser(), "EAU CLAIRE", "WI");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "[Case# 11-253]  @5:23:16 AM // Brunswick // W2250 Rim Rock Rd // Vehicle Fire // vehicle fire, no exposures",
        "ID:11-253",
        "TIME:05:23:16",
        "CITY:Brunswick",
        "ADDR:W2250 Rim Rock Rd",
        "CALL:Vehicle Fire",
        "INFO:vehicle fire, no exposures");

    doTest("T2",
        "[Case# 11-252]  @7:21:18 PM // Washington // 4940 Meadowbrook Ln // Sounding Fire Alarm // sounding fire alarm, showing 1st & 2nd floor smoke detector",
        "ID:11-252",
        "TIME:19:21:18",
        "CITY:Washington",
        "ADDR:4940 Meadowbrook Ln",
        "CALL:Sounding Fire Alarm",
        "INFO:sounding fire alarm, showing 1st & 2nd floor smoke detector");

    doTest("T3",
        "[Case# 11-251]  @4:03:35 PM // Washington // 4400 blk South Lowes creek  rd // Fire //",
        "ID:11-251",
        "TIME:16:03:35",
        "CITY:Washington",
        "ADDR:4400 blk South Lowes creek rd",
        "MADDR:4400  South Lowes creek rd",
        "CALL:Fire");

    doTest("T4",
        "[Case# 11-250]  @12:48:10 PM // Union // HWY 12 & N. Crossing // Motorvehicle Collision // 10/50 PI",
        "ID:11-250",
        "TIME:12:48:10",
        "CITY:Union",
        "ADDR:HWY 12 & N Crossing",
        "CALL:Motorvehicle Collision",
        "INFO:10/50 PI");

    doTest("T5",
        "[Case# 11-249]  @1:04:04 PM // Brunswick // W2601 HWY 37 // Electrical/Powerline Emergency // powerline is down and pole is on fire",
        "ID:11-249",
        "TIME:13:04:04",
        "CITY:Brunswick",
        "ADDR:W2601 HWY 37",
        "CALL:Electrical/Powerline Emergency",
        "INFO:powerline is down and pole is on fire");

    doTest("T6",
        "[Case# 11-248]  @4:48:14 PM // Union // I-94, 59mm, Westbound // Motorvehicle Collision // 10/50 PI",
        "ID:11-248",
        "TIME:16:48:14",
        "CITY:Union",
        "ADDR:I-94, 59mm, Westbound",
        "MADDR:I 94, 59mm, Westbound",
        "CALL:Motorvehicle Collision",
        "INFO:10/50 PI");

    doTest("T7",
        "[Case# 11-244]  @1:01:11 PM // Brunswick // Jopke Rd & HWY 37 // Motorvehicle Collision // 10/50 PI",
        "ID:11-244",
        "TIME:13:01:11",
        "CITY:Brunswick",
        "ADDR:Jopke Rd & HWY 37",
        "CALL:Motorvehicle Collision",
        "INFO:10/50 PI");

    doTest("T8",
        "[Case# 11-241]  @10:25:42 AM // Washington // I94 WB Mile Marke 65 // Rescue/Medical Assist // 61 y/o male poss stroke",
        "ID:11-241",
        "TIME:10:25:42",
        "CITY:Washington",
        "ADDR:I94 WB Mile Marke 65",
        "MADDR:I 94 Mile Marke 65",
        "CALL:Rescue/Medical Assist",
        "INFO:61 y/o male poss stroke");
   
  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "@4:38:53 PM // Rock Creek (Dunn) // HWY 85 & 870th // Motorvehicle\nCollision // 3 vehicle 10/50 PI, no extrication, Station 5 requested for\nassistance",
        "TIME:16:38:53",
        "CITY:Rock Creek, Dunn",
        "ADDR:HWY 85 & 870th",
        "CALL:Motorvehicle Collision",
        "INFO:3 vehicle 10/50 PI, no extrication, Station 5 requested for assistance");

  }
  
  @Test
  public void testParserCody() {

    doTest("T1",
        "(Case# 12-099) @2:45:18 AM // Seymour // Peterson Ave & Olson Dr. // MVC Extrication //\n10/50 PI with Extrication needed",
        "ID:12-099",
        "TIME:02:45:18",
        "CITY:Seymour",
        "ADDR:Peterson Ave & Olson Dr",
        "CALL:MVC Extrication",
        "INFO:10/50 PI with Extrication needed");

  }
  
  @Test
  public void testChrisHedlund() {

    doTest("T1",
        "(Case# 12-117) @2:40:48 PM // Washington // henry at pamona // Motorvehicle Collision\n//",
        "ID:12-117",
        "TIME:14:40:48",
        "CITY:Washington",
        "ADDR:henry at pamona",  // <<< Google says this is Pomona
        "CALL:Motorvehicle Collision");

    doTest("T2",
        "(Case# 12-116) @1:51:32 PM // Washington // 500 block Deerfield RD  //\nIllegal/Attempted Burn // large brush pile",
        "ID:12-116",
        "TIME:13:51:32",
        "CITY:Washington",
        "ADDR:500 BLK Deerfield RD",
        "MADDR:500  Deerfield RD",
        "CALL:Illegal/Attempted Burn",
        "INFO:large brush pile");

    doTest("T3",
        "(Case# 12-115) @10:31:26 PM // Seymour // 13034 Rossman Dr. // Electrical/Powerline\nEmergency // wires arcing",
        "ID:12-115",
        "TIME:22:31:26",
        "CITY:Seymour",
        "ADDR:13034 Rossman Dr",
        "CALL:Electrical/Powerline Emergency",
        "INFO:wires arcing");

    doTest("T4",
        "(Case# 12-114) @6:32:48 PM // Union // 2211 Sherman Creek Rd // Service Call // Tree\nhas fallen into a house",
        "ID:12-114",
        "TIME:18:32:48",
        "CITY:Union",
        "ADDR:2211 Sherman Creek Rd",
        "CALL:Service Call",
        "INFO:Tree has fallen into a house");

    doTest("T5",
        "(Case# 12-112) @5:58:51 AM // Tiffany Twp (Dunn) // N11504 280th St // Search Call //\n" +
        "Search for hunter missing for 26+hours.  Request is for Manpower and\n" +
        "possi",

        "ID:12-112",
        "TIME:05:58:51",
        "CITY:Tiffany, Dunn",
        "ADDR:N11504 280th St",
        "CALL:Search Call",
        "INFO:Search for hunter missing for 26+hours. Request is for Manpower and possi");

    doTest("T6",
        "(Case# 12-110) @1:10:09 PM // Brunswick // 4800 Karissa Dr. // Motorvehicle Collision\n// 10/50 PI",
        "ID:12-110",
        "TIME:13:10:09",
        "CITY:Brunswick",
        "ADDR:4800 Karissa Dr",
        "CALL:Motorvehicle Collision",
        "INFO:10/50 PI");

    doTest("T7",
        "(Case# 12-107) @8:14:11 AM // Seymour // Freeway 53 92mm Southbound // Vehicle Fire //\nvehicle fire",
        "ID:12-107",
        "TIME:08:14:11",
        "CITY:Seymour",
        "ADDR:Freeway 53 92mm Southbound",
        "CALL:Vehicle Fire",
        "INFO:vehicle fire");

    doTest("T8",
        "(Case# 12-104) @11:13:39 AM // Brunswick // S8725 County Line Rd // Brush/Wildland Fire\n" +
        "// possible out of control burn/brush fire in a field",

        "ID:12-104",
        "TIME:11:13:39",
        "CITY:Brunswick",
        "ADDR:S8725 County Line Rd",  // <<< DOesn't map if S is separated
        "CALL:Brush/Wildland Fire",
        "INFO:possible out of control burn/brush fire in a field");

    doTest("T9",
        "(Case# 12-099) @2:45:18 AM // Seymour // Peterson Ave & Olson Dr. // MVC Extrication //\n10/50 PI with Extrication needed",
        "ID:12-099",
        "TIME:02:45:18",
        "CITY:Seymour",
        "ADDR:Peterson Ave & Olson Dr",
        "CALL:MVC Extrication",
        "INFO:10/50 PI with Extrication needed");

    doTest("T10",
        "(Case# 12-100) @1:33:50 PM // Pleasant Valley // S10700 Hwy 93 // Brush/Wildland Fire\n// grass fire",
        "ID:12-100",
        "TIME:13:33:50",
        "CITY:Pleasant Valley",
        "ADDR:S10700 Hwy 93",  // <<< Maps if S is separated
        "CALL:Brush/Wildland Fire",
        "INFO:grass fire");

  }
  
  public static void main(String[] args) {
    new WIEauClaireParserTest().generateTests("T1");
  }
}