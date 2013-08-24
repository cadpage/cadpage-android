package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Johnson County, MO
Contact: Ken Jennings <kj8111@hotmail.com>
Sender: cadpage@joco911.org

[ 911 Page ] Dispatch: 7/19/2011 17:44:07 80 - Carbon Monoxide/Hazmat 1064 NE 75 RD, Apt. 112 JOHNSON COUNTY
[ 911 Page ] Dispatch: 7/20/2011 19:24:58 FIRE VEHCILE 793 NE 101 RD JOHNSON COUNTY MO
[ 911 Page ] Dispatch: 7/18/2011 22:25:03 FIRE GRASS SE DD HWY & SE 341 RD JOHNSON COUNTY
[ Subject: 911 Page ] 7/17/2011 21:02:06 FIRE STRUCTURE 1072 NW 475 RD JOHNSON COUNTY

Contact: Dustin Moore <firefighter.8115@gmail.com>
Sender: cadpage@joco911.org
911 Page / Dispatch: 2/11/2012 18:06:31 FIRE STRUCTURE 18 SE 135 RD JOHNSON COUNTY\n

Contact: Rick Johnson <rickjohnson435@gmail.com>
Sender: cadpage@joco911.org
911 Page / JCSO MVC PROPERTY DAMAGE NE FF HWY & NE 50 HWY JOHNSON COUNTY Dispatch: 6/2/2013 22:33:12\n
911 Page / JCF LINES DOWN-ELECTRIC/PHONE/CABLE 500 SE 23 HWY JOHNSON COUNTY Dispatch: 5/20/2013 17:30:59\n
911 Page / JCSO MVC PROPERTY DAMAGE SE DD HWY & SE 23 HWY JOHNSON COUNTY Dispatch: 5/25/2013 03:00:22\n
911 Page / JCF FIRE STRUCTURE 944 NE 23 HWY JOHNSON COUNTY Dispatch: 6/10/2013 12:50:45\n

*/

public class MOJohnsonCountyParserTest extends BaseParserTest {
  
  public MOJohnsonCountyParserTest() {
    setParser(new MOJohnsonCountyParser(), "JOHNSON COUNTY", "MO");
  }

 
  
  @Test
  public void testParser() {

    doTest("T1",
        "[ 911 Page ] Dispatch: 7/19/2011 17:44:07 80 - Carbon Monoxide/Hazmat 1064 NE 75 RD, Apt. 112 JOHNSON COUNTY",
        "DATE:7/19/2011",
        "TIME:17:44:07",
        "CALL:80 - Carbon Monoxide/Hazmat",
        "ADDR:1064 NE 75 RD",
        "APT:112");

    doTest("T2",
        "[ 911 Page ] Dispatch: 7/20/2011 19:24:58 FIRE VEHCILE 793 NE 101 RD JOHNSON COUNTY MO",
        "DATE:7/20/2011", 
        "TIME:19:24:58",
        "CALL:FIRE VEHCILE",
        "ADDR:793 NE 101 RD");

    doTest("T3",
        "[ 911 Page ] Dispatch: 7/18/2011 22:25:03 FIRE GRASS SE DD HWY & SE 341 RD JOHNSON COUNTY",
        "DATE:7/18/2011",
        "TIME:22:25:03",
        "CALL:FIRE GRASS",
        "ADDR:SE DD HWY & SE 341 RD",
        "MADDR:SE HWY DD & SE 341 RD");

    doTest("T4",
        "[ Subject: 911 Page ] 7/17/2011 21:02:06 FIRE STRUCTURE 1072 NW 475 RD JOHNSON COUNTY",
        "DATE:7/17/2011", 
        "TIME:21:02:06",
        "CALL:FIRE STRUCTURE",
        "ADDR:1072 NW 475 RD");

    doTest("T5",
        "911 Page / Dispatch: 2/11/2012 18:06:31 FIRE STRUCTURE 18 SE 135 RD JOHNSON COUNTY\n",
        "DATE:2/11/2012", 
        "TIME:18:06:31",
        "CALL:FIRE STRUCTURE",
        "ADDR:18 SE 135 RD");

    doTest("T6",
        "911 Page / JCSO MVC PROPERTY DAMAGE NE FF HWY & NE 50 HWY JOHNSON COUNTY Dispatch: 6/2/2013 22:33:12\n",
        "CALL:JCSO MVC PROPERTY DAMAGE",
        "ADDR:NE FF HWY & NE 50 HWY",
        "MADDR:NE HWY FF & NE HWY 50",
        "DATE:6/2/2013",
        "TIME:22:33:12");

    doTest("T7",
        "911 Page / JCF LINES DOWN-ELECTRIC/PHONE/CABLE 500 SE 23 HWY JOHNSON COUNTY Dispatch: 5/20/2013 17:30:59\n",
        "CALL:JCF LINES DOWN-ELECTRIC/PHONE/CABLE",
        "ADDR:500 SE 23 HWY",
        "MADDR:500 SE HWY 23",
        "DATE:5/20/2013",
        "TIME:17:30:59");

    doTest("T8",
        "911 Page / JCSO MVC PROPERTY DAMAGE SE DD HWY & SE 23 HWY JOHNSON COUNTY Dispatch: 5/25/2013 03:00:22\n",
        "CALL:JCSO MVC PROPERTY DAMAGE",
        "ADDR:SE DD HWY & SE 23 HWY",
        "MADDR:SE HWY DD & SE HWY 23",
        "DATE:5/25/2013",
        "TIME:03:00:22");

    doTest("T9",
        "911 Page / JCF FIRE STRUCTURE 944 NE 23 HWY JOHNSON COUNTY Dispatch: 6/10/2013 12:50:45\n",
        "CALL:JCF FIRE STRUCTURE",
        "ADDR:944 NE 23 HWY",
        "MADDR:944 NE HWY 23",
        "DATE:6/10/2013",
        "TIME:12:50:45");

  }
  
  public static void main(String[] args) {
    new MOJohnsonCountyParserTest().generateTests("T1");
  }
}