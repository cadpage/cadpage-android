package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


/*
New York City, NY
Contact: Danny Ackerman <danny.ackerman@gmail.com>
Contact: drummer12r <drummer12r@aol.com>, 3474208675@messaging.sprintpcs.com
Contact: Eli Frankel <ezf22@yahoo.com>
Sender: f_callid@hatzalah.org

331 W 24th St - Bet: W 24th St / 8th Ave & W 24th St - Apt: 10F - 1st floor - Call ID: 250-9851
6910 Ave U - Bet: E 69Th St & E 70Th St - Apt: 5J - 5th floor - Call ID: 894-1440
2915 Brighton 6Th St - Bet: Neptune Ave & Brighton 6Th Ct - Call ID: 893-5600
564 Ave Y - Bet: Ocean Pkwy & E 6Th St - 1st floor - Call ID: 935-8221
1735 E 4Th St - Bet: Avenue P & Quentin Rd - 2nd floor - Call ID: 940-6881
2662 Ocean Ave - Bet: Avenue V & Gravesend Neck Rd - Apt: B10 - 2nd floor - Call ID: 940-2331
872 E 14Th St - Bet: Avenue H / Rugby Rd & Avenue I - 2nd floor - Call ID: 934-7261
477 E 9Th St - Bet: Cortelyou Rd & Ditmas Ave - 1st floor - Call ID: 933-3561
Ave M - Bet: E 18Th St & E 18Th St - Call ID: 933-3131
202 Ave F - Bet: E 2Nd St & E 3Rd St - Apt: F8 - Call ID: 933-5211
18Th Ave - Bet: Ocean Pkwy & Ocean Pkwy - Call ID: 934-7401
1737 E 7Th St - Bet: Avenue P & Quentin Rd / Avenue Q - Fl: Pvt - Call ID: 937-3021
515 E 7Th St - Bet: Avenue C & Cortelyou Rd - Apt: 1F - 1st floor - Call ID: 940-8131
1735 E 4Th St - Bet: Avenue P & Quentin Rd - 2nd floor - Call ID: 940-6881
2499 Ocean Ave - Bet: Avenue T & Avenue U - Call ID: 937-7551
703 Kings Hwy - Bet: E 7Th St & E 8Th St - Call ID: 933-2631
609 Ocean Pkwy - Bet: 18Th Ave & Ditmas Ave - 1st floor - Call ID: 933-4081
1579 E 5Th St - Bet: Ryder Ave / Roder Ave & Avenue O - 1st floor - Call ID: 942-8371

Contact: Aaron Rothman <flatbush97@gmail.com>
Sender: vtext.com@gmail.com
flatbush97+caf_=9179688745=vtext.com@gmail.com 2078 E 19Th St - Bet: Avenue T & Avenue U - 1st floor - Call ID: 957-5211

Contact: BRYAN KESSLER <hatzq17@gmail.com>
Sender: hatzq17+caf_=7187571701=vtext.com@gmail.com
117-01 84Th Ave - Bet: 117Th St & 118Th St / 84Th Ave - Apt: 409 - 4th floor - Call ID: 10021301

Contact: Evan M. Rapp <evan.rapp@rpgny.com>
Sender: rl_callid@hatzalah.org
1390 Broadway - Apt: 214 - 2nd floor - Call ID: 102-551-40\n

*/

public class NYNewYorkCityParserTest extends BaseParserTest {
  
  public NYNewYorkCityParserTest() {
    setParser(new NYNewYorkCityParser(), "NEW YORK CITY", "NY");
  }
  
  @Test
  public void testDany() {

    doTest("T1",
        "331 W 24th St - Bet: W 24th St / 8th Ave & W 24th St - Apt: 10F - 1st floor - Call ID: 250-9851",
        "ADDR:331 W 24th St",
        "APT:10F",
        "X:W 24th St / 8th Ave & W 24th St",
        "PLACE:1st floor",
        "ID:250-9851");

    doTest("T2",
        "6910 Ave U - Bet: E 69Th St & E 70Th St - Apt: 5J - 5th floor - Call ID: 894-1440",
        "ADDR:6910 Ave U",
        "APT:5J",
        "X:E 69Th St & E 70Th St",
        "PLACE:5th floor",
        "ID:894-1440");

    doTest("T3",
        "2915 Brighton 6Th St - Bet: Neptune Ave & Brighton 6Th Ct - Call ID: 893-5600",
        "ADDR:2915 Brighton 6Th St",
        "X:Neptune Ave & Brighton 6Th Ct",
        "ID:893-5600");

    doTest("T4",
        "564 Ave Y - Bet: Ocean Pkwy & E 6Th St - 1st floor - Call ID: 935-8221",
        "ADDR:564 Ave Y",
        "X:Ocean Pkwy & E 6Th St",
        "PLACE:1st floor",
        "ID:935-8221");

    doTest("T5",
        "1735 E 4Th St - Bet: Avenue P & Quentin Rd - 2nd floor - Call ID: 940-6881",
        "ADDR:1735 E 4Th St",
        "X:Avenue P & Quentin Rd",
        "PLACE:2nd floor",
        "ID:940-6881");

    doTest("T6",
        "2662 Ocean Ave - Bet: Avenue V & Gravesend Neck Rd - Apt: B10 - 2nd floor - Call ID: 940-2331",
        "ADDR:2662 Ocean Ave",
        "APT:B10",
        "X:Avenue V & Gravesend Neck Rd",
        "PLACE:2nd floor",
        "ID:940-2331");

    doTest("T7",
        "872 E 14Th St - Bet: Avenue H / Rugby Rd & Avenue I - 2nd floor - Call ID: 934-7261",
        "ADDR:872 E 14Th St",
        "X:Avenue H / Rugby Rd & Avenue I",
        "PLACE:2nd floor",
        "ID:934-7261");

    doTest("T8",
        "477 E 9Th St - Bet: Cortelyou Rd & Ditmas Ave - 1st floor - Call ID: 933-3561",
        "ADDR:477 E 9Th St",
        "X:Cortelyou Rd & Ditmas Ave",
        "PLACE:1st floor",
        "ID:933-3561");

    doTest("T9",
        "Ave M - Bet: E 18Th St & E 18Th St - Call ID: 933-3131",
        "ADDR:Ave M",
        "MADDR:Ave M & E 18Th St",
        "X:E 18Th St & E 18Th St",
        "ID:933-3131");

    doTest("T10",
        "202 Ave F - Bet: E 2Nd St & E 3Rd St - Apt: F8 - Call ID: 933-5211",
        "ADDR:202 Ave F",
        "APT:F8",
        "X:E 2Nd St & E 3Rd St",
        "ID:933-5211");

    doTest("T11",
        "18Th Ave - Bet: Ocean Pkwy & Ocean Pkwy - Call ID: 934-7401",
        "ADDR:18Th Ave",
        "MADDR:18Th Ave & Ocean Pkwy",
        "X:Ocean Pkwy & Ocean Pkwy",
        "ID:934-7401");

    doTest("T12",
        "1737 E 7Th St - Bet: Avenue P & Quentin Rd / Avenue Q - Fl: Pvt - Call ID: 937-3021",
        "ADDR:1737 E 7Th St",
        "X:Avenue P & Quentin Rd / Avenue Q",
        "PLACE:Fl: Pvt",
        "ID:937-3021");

    doTest("T13",
        "515 E 7Th St - Bet: Avenue C & Cortelyou Rd - Apt: 1F - 1st floor - Call ID: 940-8131",
        "ADDR:515 E 7Th St",
        "APT:1F",
        "X:Avenue C & Cortelyou Rd",
        "PLACE:1st floor",
        "ID:940-8131");

    doTest("T14",
        "1735 E 4Th St - Bet: Avenue P & Quentin Rd - 2nd floor - Call ID: 940-6881",
        "ADDR:1735 E 4Th St",
        "X:Avenue P & Quentin Rd",
        "PLACE:2nd floor",
        "ID:940-6881");

    doTest("T15",
        "2499 Ocean Ave - Bet: Avenue T & Avenue U - Call ID: 937-7551",
        "ADDR:2499 Ocean Ave",
        "X:Avenue T & Avenue U",
        "ID:937-7551");

    doTest("T16",
        "703 Kings Hwy - Bet: E 7Th St & E 8Th St - Call ID: 933-2631",
        "ADDR:703 Kings Hwy",
        "X:E 7Th St & E 8Th St",
        "ID:933-2631");

    doTest("T17",
        "609 Ocean Pkwy - Bet: 18Th Ave & Ditmas Ave - 1st floor - Call ID: 933-4081",
        "ADDR:609 Ocean Pkwy",
        "X:18Th Ave & Ditmas Ave",
        "PLACE:1st floor",
        "ID:933-4081");

    doTest("T18",
        "1579 E 5Th St - Bet: Ryder Ave / Roder Ave & Avenue O - 1st floor - Call ID: 942-8371",
        "ADDR:1579 E 5Th St",
        "X:Ryder Ave / Roder Ave & Avenue O",
        "PLACE:1st floor",
        "ID:942-8371");

    doTest("T19",
        "flatbush97+caf_=9179688745=vtext.com@gmail.com 2078 E 19Th St - Bet: Avenue T & Avenue U - 1st floor - Call ID: 957-5211",
        "ADDR:2078 E 19Th St",
        "X:Avenue T & Avenue U",
        "PLACE:1st floor",
        "ID:957-5211");

  }
  
  @Test
  public void testBryanKessler() {

    doTest("T1",
        "117-01 84Th Ave - Bet: 117Th St & 118Th St / 84Th Ave - Apt: 409 - 4th floor - Call ID: 10021301",
        "ADDR:117-01 84Th Ave",
        "MADDR:117 84Th Ave",
        "APT:409",
        "X:117Th St & 118Th St / 84Th Ave",
        "PLACE:4th floor",
        "ID:10021301");
    
  }
  
  @Test
  public void testEvanMRapp() {

    doTest("T1",
        "1390 Broadway - Apt: 214 - 2nd floor - Call ID: 102-551-40\n",
        "ADDR:1390 Broadway",
        "APT:214",
        "PLACE:2nd floor",
        "ID:102-551-40");
   
  }
  
  public static void main(String[] args) {
    new NYNewYorkCityParserTest().generateTests("T1");
  }
}