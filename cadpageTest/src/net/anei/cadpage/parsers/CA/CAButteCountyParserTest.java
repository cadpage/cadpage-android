package net.anei.cadpage.parsers.CA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Butte County, CA
Contact: "McLean, Scott" <Scott.McLean@fire.ca.gov>
Sender: btucad@fire.ca.gov

(CAD Page) MEDICAL; 1759 12TH ST ,THERMALITO ; ; 1200 BLK TEHAMA AVE; Map: 6683; Inc# 002759; Date-Time: 21-Mar-2012/20:55:59; CARDIAC;
(CAD Page) MEDICAL; 14897 DEL ORO DR ,MGLA ; ;  DEAD-END; Map: 5633; Inc# 002916; Date-Time: 26-Mar-2012/09:00:57; CARDIAC;
(CAD Page) OTH,REFERRAL; 7540 OROVILLE BANGOR HWY / 2 BANGOR PARK RD ,BNGR ; ; ; Map: 6985; Inc# ; Date-Time: 28-Mar-2012/09:29:18; LOOSE HORSE ON BANGOR PARK RD

Contact: chip fowler <chipfowler86@gmail.com>
Sender: btucad@fire.ca.gov
FRM:btucad@fire.ca.gov\nSUBJ:CAD Page\nMSG:MEDICAL; 6423 JACK HILL DR ,KELLY_RDGE ; ; 5499 BLK HIGH ROCKS CT; Map:6534; Inc# 003098;\n(Con't) 2 of 2\nDate-Time: 31-Mar-2012/22:38:02; ILL MALE; (End)

Contact: jeff harter <jeff.harter2113@gmail.com>
Sender: btucad@fire.ca.gov
(CAD Page) LEVEL 1 HAZ-MAT; BANK OF THE WEST @ 2626 OROVILLE DAM BLVD E ,ORO ; ; 2499 BLK WASHINGTON AVE; Map: 6683/6683; Inc# 004468; Date-Time: 10-May-2012/12:

Contact: "Harter, Jeff" <Jeff.Harter@fire.ca.gov>
Sender: btucad@fire.ca.gov
(CAD Page) T/C HIGHWAY/HIGH SPD; STA 37 @ 3595 SHUMAN LN ,CONCOW ; WHT PU VS HYDRANT; 11400 BLK CONCOW RD; Map: 5934; Inc# 004582; Date-Time: 12-May-2012/23:53:0

 */


public class CAButteCountyParserTest extends BaseParserTest {
  
  public CAButteCountyParserTest() {
    setParser(new CAButteCountyParser(), "BUTTE COUNTY", "CA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(CAD Page) MEDICAL; 1759 12TH ST ,THERMALITO ; ; 1200 BLK TEHAMA AVE; Map: 6683; Inc# 002759; Date-Time: 21-Mar-2012/20:55:59; CARDIAC;",
        "CALL:MEDICAL / CARDIAC",
        "ADDR:1759 12TH ST",
        "CITY:THERMALITO",
        "X:1200 BLK TEHAMA AVE",
        "MAP:6683",
        "ID:002759",
        "DATE:21-Mar-2012",
        "TIME:20:55:59");

    doTest("T2",
        "(CAD Page) MEDICAL; 14897 DEL ORO DR ,MGLA ; ;  DEAD-END; Map: 5633; Inc# 002916; Date-Time: 26-Mar-2012/09:00:57; CARDIAC;",
        "CALL:MEDICAL / CARDIAC",
        "ADDR:14897 DEL ORO DR",
        "CITY:MAGALIA",
        "X:DEAD-END",
        "MAP:5633",
        "ID:002916",
        "DATE:26-Mar-2012",
        "TIME:09:00:57");

    doTest("T3",
        "(CAD Page) OTH,REFERRAL; 7540 OROVILLE BANGOR HWY / 2 BANGOR PARK RD ,BNGR ; ; ; Map: 6985; Inc# ; Date-Time: 28-Mar-2012/09:29:18; LOOSE HORSE ON BANGOR PARK RD",
        "CALL:OTH,REFERRAL / LOOSE HORSE ON BANGOR PARK RD",
        "ADDR:7540 OROVILLE BANGOR HWY & 2 BANGOR PARK RD",
        "MADDR:7540 OROVILLE BANGOR HWY",
        "CITY:BANGOR",
        "MAP:6985",
        "DATE:28-Mar-2012",
        "TIME:09:29:18");
 }
  
  @Test
  public void testChipFowler() {

    doTest("T1",
        "FRM:btucad@fire.ca.gov\n" +
        "SUBJ:CAD Page\n" +
        "MSG:MEDICAL; 6423 JACK HILL DR ,KELLY_RDGE ; ; 5499 BLK HIGH ROCKS CT; Map:6534; Inc# 003098;\n" +
        "(Con't) 2 of 2\n" +
        "Date-Time: 31-Mar-2012/22:38:02; ILL MALE; (End)",

        "CALL:MEDICAL / ILL MALE",
        "ADDR:6423 JACK HILL DR",
        "PLACE:KELLY RIDGE",
        "CITY:OROVILLE",
        "X:5499 BLK HIGH ROCKS CT",
        "MAP:6534",
        "ID:003098",
        "DATE:31-Mar-2012",
        "TIME:22:38:02");

  }
  
  @Test
  public void testJeffHarter() {

    doTest("T1",
        "(CAD Page) LEVEL 1 HAZ-MAT; BANK OF THE WEST @ 2626 OROVILLE DAM BLVD E ,ORO ; ; 2499 BLK WASHINGTON AVE; Map: 6683/6683; Inc# 004468; Date-Time: 10-May-2012/12:",
        "CALL:LEVEL 1 HAZ-MAT",
        "PLACE:BANK OF THE WEST",
        "ADDR:2626 OROVILLE DAM BLVD E",
        "CITY:OROVILLE",
        "X:2499 BLK WASHINGTON AVE",
        "MAP:6683/6683",
        "ID:004468",
        "DATE:10-May-2012",
        "TIME:12:");

  }
  
  @Test
  public void test() {

    doTest("T1",
        "(CAD Page) T/C HIGHWAY/HIGH SPD; STA 37 @ 3595 SHUMAN LN ,CONCOW ; WHT PU VS HYDRANT; 11400 BLK CONCOW RD; Map: 5934; Inc# 004582; Date-Time: 12-May-2012/23:53:0",
        "CALL:T/C HIGHWAY/HIGH SPD",
        "PLACE:STA 37",
        "ADDR:3595 SHUMAN LN",
        "CITY:CONCOW",
        "X:WHT PU VS HYDRANT & 11400 BLK CONCOW RD",
        "MAP:5934",
        "ID:004582",
        "DATE:12-May-2012",
        "TIME:23:53:0");

  }
  
  public static void main(String[] args) {
    new CAButteCountyParserTest().generateTests("T1");
  }
}