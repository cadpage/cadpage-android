package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.NY.NYErieCountyBParserTest;

import org.junit.Test;


public class NYErieCountyBParserTest extends BaseParserTest {
  
  public NYErieCountyBParserTest() {
    setParser(new NYErieCountyBParser(), "ERIE COUNTY", "NY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "NYK| Erie County (Lancaster)| Technical Rescue| | Como Park|PD O/S reporting pedestrian walk bridge collapse- 1 victim with leg trapped- request FD with saws| NYK109| 16:54",
        "SRC:NYK",
        "CITY:Lancaster",
        "CALL:Technical Rescue",
        "ADDR:Como Park",
        "INFO:PD O/S reporting pedestrian walk bridge collapse- 1 victim with leg trapped- request FD with saws",
        "UNIT:NYK109",
        "TIME:16:54");

    doTest("T2",
        "NYK / NYK| Buffalo| 1 Alarm Fire| | 63 Crestwood Ave|F20 O/S reporting fire in a dwelling-victims rescued-ACW| NYK109| 12:13\n\n",
        "SRC:NYK / NYK",
        "CITY:Buffalo",
        "CALL:1 Alarm Fire",
        "ADDR:63 Crestwood Ave",
        "INFO:F20 O/S reporting fire in a dwelling-victims rescued-ACW",
        "UNIT:NYK109",
        "TIME:12:13");

    doTest("T3",
        "NYK| Erie County (Lancaster)| 1 Alarm Fire| 453.500| 17 E Drullard Ave|Lancaster FD O/S Rep Fire in a 2 Story Occ Brick Apt Bldg. AHW| NYK004| 22:29",
        "SRC:NYK",
        "CITY:Lancaster",
        "CALL:1 Alarm Fire",
        "PLACE:453.500",
        "ADDR:17 E Drullard Ave",
        "INFO:Lancaster FD O/S Rep Fire in a 2 Story Occ Brick Apt Bldg. AHW",
        "UNIT:NYK004",
        "TIME:22:29");

    doTest("T4",
        "NYK| Erie County (Concord)| Major Accident| | New York 39 & Mortons Corners|ECSD / NYSP O/S Rollover MVA with Entrapment. Veh Rep on Fire. Mercy Flight Enroute.| NYK004| 13:42",
        "SRC:NYK",
        "CITY:Concord",
        "CALL:Major Accident",
        "ADDR:New York 39 & Mortons Corners",
        "INFO:ECSD / NYSP O/S Rollover MVA with Entrapment. Veh Rep on Fire. Mercy Flight Enroute.",
        "UNIT:NYK004",
        "TIME:13:42");

    doTest("T5",
        "NYK / NYK| Buffalo| 1 Alarm Fire| | 63 Crestwood Ave|F20 O/S reporting fire in a dwelling-victims rescued-ACW| NYK109| 12:13\n\n",
        "SRC:NYK / NYK",
        "CITY:Buffalo",
        "CALL:1 Alarm Fire",
        "ADDR:63 Crestwood Ave",
        "INFO:F20 O/S reporting fire in a dwelling-victims rescued-ACW",
        "UNIT:NYK109",
        "TIME:12:13");

    doTest("T6",
        "NYK| Buffalo| 1 Alarm Fire| 424.350| 63 Crestwood ave|U/D: E-38 updated size up 2.5 story dwelling. Heavy Fire 2nd floor and attic. Extra 2 & 1 req.| NYK016| 12:17",
        "SRC:NYK",
        "CITY:Buffalo",
        "CALL:1 Alarm Fire",
        "PLACE:424.350",
        "ADDR:63 Crestwood ave",
        "INFO:U/D: E-38 updated size up 2.5 story dwelling. Heavy Fire 2nd floor and attic. Extra 2 & 1 req.",
        "UNIT:NYK016",
        "TIME:12:17");
  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "NYK| Erie County (Lancaster)| Technical Rescue| | Como Park|PD O/S reporting pedestrian walk bridge collapse- 1 victim with leg trapped- request FD with saws| NYK109| 16:54",
        "SRC:NYK",
        "CITY:Lancaster",
        "CALL:Technical Rescue",
        "ADDR:Como Park",
        "INFO:PD O/S reporting pedestrian walk bridge collapse- 1 victim with leg trapped- request FD with saws",
        "UNIT:NYK109",
        "TIME:16:54");

    doTest("T2",
        "NYK| Buffalo| 1 Alarm Fire| 424.350| 77 Theodore St|E31 O/S reporting fire in a 1 story vacant dwelling- smoke showing- laying in line- ACW| NYK109| 22:08",
        "SRC:NYK",
        "CITY:Buffalo",
        "CALL:1 Alarm Fire",
        "PLACE:424.350",
        "ADDR:77 Theodore St",
        "INFO:E31 O/S reporting fire in a 1 story vacant dwelling- smoke showing- laying in line- ACW",
        "UNIT:NYK109",
        "TIME:22:08");

    doTest("T3",
        "NYK| Erie County (W Seneca)| Major Accident| 423.9875| Rte 90 E @ Exit 53 ramp|Seneca Hose 9 o/s TT overturned, with part hanging over edge of bridge. unknown injuries| NYK091| 14:51",
        "SRC:NYK",
        "CITY:W Seneca",
        "CALL:Major Accident",
        "PLACE:423.9875",
        "ADDR:Rte 90 E @ Exit 53 ramp",
        "MADDR:423.9875,Rte 90 E @ Exit 53 ramp",
        "INFO:Seneca Hose 9 o/s TT overturned, with part hanging over edge of bridge. unknown injuries",
        "UNIT:NYK091",
        "TIME:14:51");
   
  }
  
  public static void main(String[] args) {
    new NYErieCountyBParserTest().generateTests("T1");
  }
}