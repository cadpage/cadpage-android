package net.anei.cadpage.parsers;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser.StartType;

import org.junit.Test;

import static org.junit.Assert.*;


public class SmartAddressParserTest extends BaseParserTest {
  
  private static final StartType ADDR = StartType.START_ADDR;
  private static final StartType CALL = StartType.START_CALL;
  private static final StartType PLACE = StartType.START_PLACE;
  private static final StartType SKIP = StartType.START_SKIP;
  
  private static final int FLAG_AT_BOTH = SmartAddressParser.FLAG_AT_BOTH;
  private static final int FLAG_ANCHOR_END = SmartAddressParser.FLAG_ANCHOR_END;
  
  private static final String[] CITY_LIST = new String[]{"KENSBURG", "KEN TOWN"};
  private static final String DEF_CITY = "STATE OF MIND";
  private static final String DEF_STATE = "XX";

  private TestParser parser;
  
  public SmartAddressParserTest() {
    parser = new TestParser(CITY_LIST, DEF_CITY, DEF_STATE);
    setParser(parser, DEF_CITY, DEF_STATE);
  }

  
  @Test
  public void testProblems() {
    doTest(SKIP, "LA LA LA COUNTRY PLACE CT & W 16TH ST BEYOND",
    "ADDR:COUNTRY PLACE CT & W 16TH ST");
    
    doTest(ADDR, "COUNTRY PLACE CT / RENAISSANCE WOOD CT XENIA TWP",
        "ADDR:COUNTRY PLACE CT & RENAISSANCE WOOD CT");
    
    doTest(ADDR, "22030 OXFORD CT APT KEN TOWN",
        "ADDR:22030 OXFORD CT",
        "CITY:KEN TOWN");
    
    doTest(CALL, FLAG_AT_BOTH,
        "VEHICLE FIRE HARDEES @800 WOODS RD KENSBURG",
        "CALL:VEHICLE FIRE HARDEES",
        "ADDR:800 WOODS RD",
        "CITY:KENSBURG");
   
    doTest(CALL,
        "***SIG 8***  AUTO PIERCE DAY CAMP 37 MINEOLA AVE [ROSLYN] c/s: REGENT PL/GLEN AVE ADTNL: MANSION/NO PERMIT GRID: K-14 TOA: 08:32 12/07/2010",
        "CALL:***SIG 8*** AUTO PIERCE DAY CAMP",
        "ADDR:37 MINEOLA AVE");
    
    doTest(CALL, TestParser.FLAG_START_FLD_REQ, 
        "1073 SMOKE 1421 BEVERLY DR BOSA NONA DRIVE",
        "CALL:1073 SMOKE",
        "ADDR:1421 BEVERLY DR");
  }
  
  @Test
  public void testDoubleRoutes() {

    doTest(ADDR, "134 US HIGHWAY 85 NB EXTRA",
        "ADDR:134 US HIGHWAY 85 NB");
    doTest(ADDR, "US HIGHWAY 85 NB/E 77TH AVE ADAM ADAM",
        "ADDR:US HIGHWAY 85 NB & E 77TH AVE");
    doTest("ADDR", "ST HWY 85 EXTRA",
        "ADDR:ST HWY 85");

    doTest(CALL, "BAD STUFF 134 US HIGHWAY 85 NB EXTRA",
        "CALL:BAD STUFF",
        "ADDR:134 US HIGHWAY 85 NB");
    doTest(CALL, "BAD STUFF US HIGHWAY 85 NB/E 77TH AVE ADAM ADAM",
        "CALL:BAD STUFF",
        "ADDR:US HIGHWAY 85 NB & E 77TH AVE");
    doTest("ADDR", "BAD STUFF ST HWY 85 EXTRA",
        "CALL:BAD STUFF",
        "ADDR:ST HWY 85");

  }
  
  @Test
  public void testTrivialAddress() {
    doTest(ADDR, "MY HOME IN KENSBURG LOOKS NICE", 
        "ADDR:MY HOME IN", 
        "CITY:KENSBURG");
    doTest(ADDR, "My home in Kensburg looks nice",
        "ADDR:My home in",
        "CITY:Kensburg");
    doTest(ADDR, "My home in ken town is better",
        "ADDR:My home in",
        "CITY:ken town");
    doTest(ADDR, "Big st/Lost rd ken town",
        "ADDR:Big st & Lost rd",
        "CITY:ken town");
  }
  
  @Test
  public void testSimpleAddress() {
    doTest(ADDR, "1000 N JACK DANIEL LN MORE JUNK",
        "ADDR:1000 N JACK DANIEL LN");
    doTest(ADDR, "1000 HWY 20 MORE JUNK",
       "ADDR:1000 HWY 20");
    doTest(CALL, "BAD BLOOD HAPPENS 1000 N JACK DANIEL LN MORE JUNK",
        "CALL:BAD BLOOD HAPPENS",
        "ADDR:1000 N JACK DANIEL LN");
    doTest(PLACE, "MARY AND ST JOHNS 1000 N JACK DANIEL LN MORE JUNK",
        "PLACE:MARY AND ST JOHNS",
        "ADDR:1000 N JACK DANIEL LN");
    doTest(SKIP, "MARY AND ST JOHNS 1000 N JACK DANIEL LN MORE JUNK",
        "ADDR:1000 N JACK DANIEL LN");
    doTest(SKIP, "SOME DAY OVER THE RAINBOW 100 BLUEBIRDS SING IN KENSBURG HIGH",
        "ADDR:100 BLUEBIRDS SING IN",
        "CITY:KENSBURG");
    doTest(SKIP, "WHERE 24 BLOOD KEN TOWN STORY",
        "ADDR:24 BLOOD",
        "CITY:KEN TOWN");
    doTest(SKIP, "BAD TOWN KEN AT 100 KEN TOWN RD KENSBURG EXTRA",
        "ADDR:100 KEN TOWN RD",
        "CITY:KENSBURG");
    doTest(SKIP, "BAD TOWN KEN AT 100 KENSBURG RD KEN TOWN EXTRA",
        "ADDR:100 KENSBURG RD",
        "CITY:KEN TOWN");
    doTest(SKIP, "BARK PLACE 500 US-30 DOWNTOWN",
        "ADDR:500 US-30");
    doTest(SKIP, "BARK PLACE 500 st123 downstairs",
        "ADDR:500 st-123");
    doTest(SKIP, "TRY 123 JOHN SMITH ST N FOR SIZE",
        "ADDR:123 JOHN SMITH ST N");
    doTest(SKIP, "OR MAYBE 200 US30 N BACK",
        "ADDR:200 US-30 N");
    doTest(SKIP, "NUMBER 25 MASKING ADDRESS AT 143 N JUNIOR ST DOWNTOWN",
        "ADDR:143 N JUNIOR ST");
    doTest(SKIP, "DRIVING ON 3224 XX 456",
        "ADDR:3224 XX 456");
    doTest(SKIP, "BUT USING 123 N THIRD DR N JUST ISNT RIGHT",
        "ADDR:123 N THIRD DR N");
    doTest(ADDR, "2000 COUNTRY PLACE CT EXTRA", 
        "ADDR:2000 COUNTRY PLACE CT");
    doTest(SKIP, "JUNK STUFF 2000 COUNTRY PLACE CT EXTRA", 
        "ADDR:2000 COUNTRY PLACE CT");
  }
  
  @Test
  public void testCrossStreets() {
    doTest(ADDR, "1000 SUNBURY ONCE XS: ACROSS TOWN KENSBURG JUNK",
        "ADDR:1000 SUNBURY ONCE",
        "X:ACROSS TOWN",
        "CITY:KENSBURG");
    doTest(ADDR, "1000 SUNBURY ONCE XS: ACROSS TOWN KEN TOWN JUNK",
        "ADDR:1000 SUNBURY ONCE",
        "X:ACROSS TOWN",
        "CITY:KEN TOWN");
    doTest(SKIP, "WAIT TILL 500 NORTH LN X: JACKSON ST BELOW SUNDANCE",
        "ADDR:500 NORTH LN",
        "X:JACKSON ST");
    doTest(SKIP, "WAIT TILL 500 NORTH LN X: JACKSON ST & N JOHNSTON RD BELOW SUNDANCE",
        "ADDR:500 NORTH LN",
        "X:JACKSON ST & N JOHNSTON RD");
    doTest(SKIP, "WAIT TILL 500 NORTH LN X: JACKSON ST & N SWEET HILL RD BELOW SUNDANCE",
        "ADDR:500 NORTH LN",
        "X:JACKSON ST & N SWEET HILL RD");
    doTest(SKIP, "WAIT TILL 500 NORTH LN X: JACKSON ST & BAD SWEET HILL RD BELOW SUNDANCE",
        "ADDR:500 NORTH LN",
        "X:JACKSON ST & BAD SWEET HILL RD");
    doTest(SKIP, "WAIT TILL 500 NORTH LN X: JACKSON ST & TOO BAD SWEET HILL RD BELOW SUNDANCE",
        "ADDR:500 NORTH LN",
        "X:JACKSON ST");
  }
  
  @Test
  public void testIntersections() {
    doTest(ADDR, "BLACK ST & WEST HILLS RD AFTER HOURS",
        "ADDR:BLACK ST & WEST HILLS RD");
    doTest(ADDR, "COUNTRY PLACE CT & W 16TH ST BEYOND",
        "ADDR:COUNTRY PLACE CT & W 16TH ST");
    doTest(SKIP, "CAN WE FIND HWY 20 AND WEST HILLS RD KENSBURG BLACK",
        "ADDR:HWY 20 AND WEST HILLS RD",
        "CITY:KENSBURG");
    doTest(SKIP, "CAN WE FIND W HILLS RD AND HWY 20 KENSBURG",
        "ADDR:W HILLS RD AND HWY 20",
        "CITY:KENSBURG");
    doTest(SKIP, "NOW SEE IF CAN WE FIND HWY 20 AND WEST HILLS RD WITHOUT A CITY",
        "ADDR:HWY 20 AND WEST HILLS RD");
    doTest(SKIP, "NOW SEE IF CAN WE FIND W HILLS RD/HWY 20 WITHOUT A CITY",
        "ADDR:W HILLS RD & HWY 20");
    doTest(SKIP, "LOOKING FOR I-90 & US231 SOMEWHERE",
        "ADDR:I-90 & US-231");
    doTest(SKIP, "WHAT ABOUT BLACK ST N & W SOMERSET RD ANYONE",
        "ADDR:BLACK ST N & W SOMERSET RD");
    doTest(SKIP, "SOMEWHERE NEAR US50 N & BLACK ST DOWN",
        "ADDR:US-50 N & BLACK ST");
    doTest(SKIP, "THIS IS N JOHNSON AVE S & BLACK ST VERY BAD FORM",
        "ADDR:N JOHNSON AVE S & BLACK ST");
    doTest(SKIP, "ACCIDENT W/INJURY SRT24&SAINT MARYS RD KEN TOWN UNDER",
        "ADDR:ST-24 & SAINT MARYS RD",
        "CITY:KEN TOWN");
    doTest(CALL, "MVA-UKN INJURY SW TUALATIN VALLEY HW/SW331ST AV",
        "CALL:MVA-UKN INJURY",
        "ADDR:SW TUALATIN VALLEY HW & SW331ST AV");
    doTest(SKIP, "LA LA LA COUNTRY PLACE CT & W 16TH ST BEYOND",
        "ADDR:COUNTRY PLACE CT & W 16TH ST");
  }
  
  @Test
  public void testNakedRoad() {
    doTest(ADDR, "BLAKSLY CREEK RD IN CHICAGO",
    		"ADDR:BLAKSLY CREEK RD");
    doTest(SKIP, "WHERE CAN I FIND BLAKSLY CREEK RD IN CHICAGO",
        "ADDR:CREEK RD");
    doTest(SKIP, "WHERE CAN I FIND N BLAKSLY CREEK RD IN KENSBURG",
        "ADDR:N BLAKSLY CREEK RD IN",
        "CITY:KENSBURG");
    doTest(SKIP, "WHERE CAN I FIND N SWEET BLAKSLY CREEK RD IN KENSBURG",
        "ADDR:N SWEET BLAKSLY CREEK RD IN",
        "CITY:KENSBURG");
    doTest(SKIP, "WHERE CAN I FIND N BIG SWEET BLAKSLY CREEK RD IN KENSBURG",
        "ADDR:CREEK RD IN",
        "CITY:KENSBURG");
    doTest(ADDR, "US 26 IN CHICAGO",
        "ADDR:US 26");
    doTest(ADDR, "COUNTRY PLACE CT DOWNTOWN",
        "ADDR:COUNTRY PLACE CT");
    doTest(SKIP, "WHERE CAN I FIND I 506 IN CHICAGO",
        "ADDR:I 506");
    doTest(SKIP, "WHERE CAN I FIND ST 101 SOMEWHERE OUT WEST",
        "ADDR:ST 101");
    doTest(SKIP, "WHERE IS BLAKSLY CREED RD X: BLUE LN IN KENSBURG",
        "ADDR:CREED RD",
        "X:BLUE LN IN",
        "CITY:KENSBURG");
    doTest(SKIP, "WHERE IS ST 345 X: PINE ST IN CHICAGO",
        "ADDR:ST 345",
        "X:PINE ST");
    doTest(SKIP, "CAN YOU FIND I-25 OUT THERE SOMEWHERE",
        "ADDR:I-25");
    doTest(SKIP, "WHAT ABOUT us123 PERHAPS",
        "ADDR:us-123");
    doTest(SKIP, "MAYBE BLACK ST N WILL WORK",
        "ADDR:BLACK ST N");
    doTest(SKIP, "HOW ABOUT US-150 N DUDE",
        "ADDR:US-150 N");
    doTest(SKIP, "BAD BOY N BIGHILL RD S BOB",
        "ADDR:N BIGHILL RD S");
    doTest(SKIP, "LOGSTON COUNTRY PLACE CT DOWNTOWN",
        "ADDR:COUNTRY PLACE CT");
  }
  
  @Test
  public void testParseFallback() {
    doTest(ADDR, "SOMETIMES THINGS JUST DONT WORK",
        "ADDR:SOMETIMES THINGS JUST DONT WORK");
    doTest(SKIP, "SOMETIMES THINGS JUST DONT WORK",
        "ADDR:SOMETIMES THINGS JUST DONT WORK");
    doTest(CALL, "SOMETIMES THINGS JUST DONT WORK",
        "CALL:SOMETIMES THINGS JUST DONT WORK");
    doTest(PLACE, "SOMETIMES THINGS JUST DONT WORK",
        "PLACE:SOMETIMES THINGS JUST DONT WORK");
  }
  
  @Test
  public void testAtAddress() {
    doTest(PLACE, "BIG HOME AT KENS LAST HOUSE KEN TOWN",
        "PLACE:BIG HOME",
        "ADDR:KENS LAST HOUSE",
        "CITY:KEN TOWN");
    doTest(PLACE, "BIG HOME @BAD 1000 N THIRD AVE",
        "PLACE:BIG HOME",
        "ADDR:BAD 1000 N THIRD AVE");
    doTest(PLACE, "BIG HOME @ BAD JACKSON RD & HAVEL DR AWAY",
        "PLACE:BIG HOME",
        "ADDR:BAD JACKSON RD & HAVEL DR");
    doTest(CALL, "BIG FIRE REPORTED AT BAD 200 NE JOHNSON DR",
        "CALL:BIG FIRE",
        "ADDR:BAD 200 NE JOHNSON DR");
    doTest(CALL, "Not breathing at all at 258 GLEN DR SOMEWHERE",
        "CALL:Not breathing at all",
        "ADDR:258 GLEN DR");
    doTest(CALL, "EMERGENCY RUN 31 SCROGGS RD XS: LOUISA CHAPEL @ 1020 KENSBURG EXTRA",
        "CALL:EMERGENCY RUN",
        "ADDR:31 SCROGGS RD",
        "X:LOUISA CHAPEL @ 1020",
        "CITY:KENSBURG");
  }
  
  @Test
  public void testFlexAtAddress() {
    doTest(CALL, FLAG_AT_BOTH, "BIG HOME @ KENS LAST HOUSE @ BIG RED KEN TOWN",
        "CALL:BIG HOME",
        "ADDR:KENS LAST HOUSE",
        "PLACE:BIG RED",
        "CITY:KEN TOWN");
    doTest(CALL, FLAG_AT_BOTH, "BIG HOME @KENS LAST HOUSE @BIG RED KEN TOWN",
        "CALL:BIG HOME",
        "ADDR:KENS LAST HOUSE",
        "PLACE:BIG RED",
        "CITY:KEN TOWN");
    doTest(CALL, FLAG_AT_BOTH, "BIG HOME @1000 N THIRD AVE",
        "CALL:BIG HOME",
        "ADDR:1000 N THIRD AVE");
    doTest(CALL, FLAG_AT_BOTH, "BIG HOME @JACKSON RD & HAVEL DR AWAY",
        "CALL:BIG HOME",
        "ADDR:JACKSON RD & HAVEL DR");
    doTest(CALL, FLAG_AT_BOTH, "BIG HOME @N JEFFERSON ST AWAY",
        "CALL:BIG HOME",
        "ADDR:N JEFFERSON ST");
    doTest(CALL, FLAG_AT_BOTH, "PROBLEM 250 N 28TH ST @COLUMBIA PICTURES APT 5 AWAY",
        "CALL:PROBLEM",
        "ADDR:250 N 28TH ST",
        "PLACE:COLUMBIA PICTURES",
        "APT:5");
    doTest(CALL, FLAG_AT_BOTH, "PROBLEM 250 N 28TH ST @ COLUMBIA PICTURES APT 5 AWAY",
        "CALL:PROBLEM",
        "ADDR:250 N 28TH ST",
        "PLACE:COLUMBIA PICTURES",
        "APT:5");
    doTest(CALL, FLAG_AT_BOTH, "MY PROBLEM ANDERSON RD/PETER ST @BIG TOP XS: JOHN RD AND JILL ST AWAY",
        "CALL:MY PROBLEM",
        "ADDR:ANDERSON RD & PETER ST",
        "PLACE:BIG TOP",
        "X:JOHN RD AND JILL ST");
    doTest(CALL, FLAG_AT_BOTH, "MY PROBLEM ANDERSON RD/PETER ST @ BIG TOP XS: JOHN RD AND JILL ST AWAY",
        "CALL:MY PROBLEM",
        "ADDR:ANDERSON RD & PETER ST",
        "PLACE:BIG TOP",
        "X:JOHN RD AND JILL ST");
    doTest(CALL, FLAG_AT_BOTH, "YOUR PROBLEM N GREEN HILL RD @CLEMINTINE JOHNSON",
        "CALL:YOUR PROBLEM",
        "ADDR:N GREEN HILL RD",
        "PLACE:CLEMINTINE");
    doTest(CALL, FLAG_AT_BOTH, "YOUR PROBLEM N GREEN HILL RD @ CLEMINTINE JOHNSON",
        "CALL:YOUR PROBLEM",
        "ADDR:N GREEN HILL RD",
        "PLACE:CLEMINTINE");
  }
  
  @Test
  public void testEndAnchor() {
    doTest(PLACE, FLAG_ANCHOR_END, "BLACK STREET 500 W TOWNSEND BLOCK APT 50",
    		"PLACE:BLACK STREET",
    		"ADDR:500 W TOWNSEND BLOCK",
    		"APT:50");
    doTest(PLACE, FLAG_ANCHOR_END, "BLACK STREET 500 W TOWNSEND BLOCK KEN TOWN",
        "PLACE:BLACK STREET",
        "ADDR:500 W TOWNSEND BLOCK",
        "CITY:KEN TOWN");
    doTest(PLACE, FLAG_ANCHOR_END, "BLACK STREET 500 W TOWNSEND BLOCK KEN TOWN WEST",
        "PLACE:BLACK STREET",
        "ADDR:500 W TOWNSEND BLOCK KEN TOWN WEST");
  }
  
  @Test
  public void testAptNumbers() {
    doTest(ADDR, "1500 BLACK ST APT: 10J XX XS: JOHN & MARY KENSBURG HOME",
        "ADDR:1500 BLACK ST",
        "APT:10J XX",
        "X:JOHN & MARY",
        "CITY:KENSBURG");
    
    doTest(ADDR, "1500 BLACK ST APT: 6XX BELOW",
        "ADDR:1500 BLACK ST",
        "APT:6XX");
    
    doTest(ADDR, "1500 BLACK ST 44A BELOW",
        "ADDR:1500 BLACK ST",
        "APT:44A");
    
    doTest(ADDR, "1500 BLACK ST #20 BELOW",
        "ADDR:1500 BLACK ST",
        "APT:#20");
  }
  
  @Test 
  public void testSlashDesc() {
    doTest(CALL, "MVA W/ROLLOVER 500 N SUMMER ST",
        "CALL:MVA W/ROLLOVER",
        "ADDR:500 N SUMMER ST");
  }
  
  @Test
  public void testRoadTokens() {
    doTest(SKIP, "BAD US-30", "ADDR:US-30");
    doTest(SKIP, "BAD us30", "ADDR:us-30");
    doTest(SKIP, "BAD ST30NB", "ADDR:ST-30");
    doTest(SKIP, "BAD I105WB", "ADDR:I-105");
    doTest(SKIP, "BAD CO7", "ADDR:CO-7");
    
    doTest(SKIP, "BAD ST30A", "ADDR:BAD ST30A");
    doTest(SKIP, "BAD ST30NBA", "ADDR:BAD ST30NBA");
  }
  
  @Test
  public void testHouseNumbers() {
    doTest(SKIP, "BAD 100 BLACK ST", "ADDR:100 BLACK ST");
    doTest(SKIP, "BAD 100-A BLACK ST", "ADDR:100-A BLACK ST");
    doTest(SKIP, "BAD 100B BLACK ST", "ADDR:100B BLACK ST");
    doTest(SKIP, "BAD 100AB BLACK ST", "ADDR:BLACK ST");
  }
  
  @Test
  public void testCheckAddress() {
    assertEquals(4, parser.checkAddress("HOW DO WE GET TO KEN TOWN"));
    assertEquals(0, parser.checkAddress("HOW DO WE GET TO KEN TOWN EXTRA"));
    assertEquals(3, parser.checkAddress("400 N BLACK HAWK DR"));
    assertEquals(0, parser.checkAddress("400 N BLACK HAWK DR EXTRA"));
    assertEquals(2, parser.checkAddress("US 50 & SE JEFFERSON ST"));
    assertEquals(0, parser.checkAddress("US 50 & SE JEFFERSON ST EXTRA"));
    assertEquals(1, parser.checkAddress("SMITH RD"));
    assertEquals(0, parser.checkAddress("SMITH RD EXTRA"));
  }

  @Test
  public void testGpsCoords() {
    doTest(CALL, "VEHICLE ACCIDENT LL(-77:23:59.6013,39:21:53.1520) DOWN TOWN",
        "CALL:VEHICLE ACCIDENT",
        "ADDR:LL(-77:23:59.6013,39:21:53.1520)");
    doTest(ADDR, "VEHICLE ACCIDENT LL(-77:23:59.6013 39:21:53.1520) DOWN TOWN",
        "ADDR:VEHICLE ACCIDENT LL(-77:23:59.6013,39:21:53.1520)");
    doTest(CALL, FLAG_ANCHOR_END,
        "VEHICLE ACCIDENT LL(-77.42356013 39.23521520) DOWN TOWN",
        "CALL:VEHICLE ACCIDENT",
        "ADDR:LL(-77.42356013,39.23521520) DOWN TOWN");
  }
  
  @Override
  public void testBadMsg() {
  }
  
  private void doTest(StartType sType, String test, String ... result) {
    doTest(sType, 0, test, result);
  }
  
  private void doTest(StartType sType, int flags, String test, String ... result) {
    parser.setStartTypeFlags(sType, flags);
    doTest("", test, result);
  }
  
  private static class TestParser extends SmartAddressParser {
    
    private StartType startType = StartType.START_ADDR;
    private int flags;
    
    public TestParser(String[] cities, String city,  String state) {
      super(cities, city, state);
    }
    
    public void setStartTypeFlags(StartType startType, int flags) {
      this.startType = startType;
      this.flags = flags;
    }

    @Override
    public boolean parseMsg(String message, Data data) {
      parseAddress(startType, flags, message, data);
      return true;
    }
  }

}
