package net.anei.cadpage.parsers.IL;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Kane County, IL
Contact:  Anthony P. <appompa255@gmail.com>
Sender: Quad Com
STIL - Still Alarm 01:16 08/10/13 455 E MAIN ST RT 72 / LINDEN AVE East Dundee T-10 QC-3738 SEVEN HILLS HEATH CARE
STIL - Still Alarm 08:31 08/10/13 BONNIE DUNDEE RD WILMETTE East Dundee T-10 SMELL OF THE NATURAL GAS IN THE AREA / WHEN CALLER WAS DRIVING ON BOTH STREETS
AMBU - Ambulance Request 17:55 08/10/13 642 DEERPATH RD ABERDEEN DR / KIMBERLY RD East Dundee T-10 BREATH OK 81YOF HELP FOR MOTHER TRYING TO GET A TX FOR HIS DAUGHTER TO GET HER HELP ELDERLY MALE SAYING WIFE IS OUT OF IT
GENR - General Alarm 10:28 08/10/13 102 S 2ND ST N 2ND ST, W MAIN ST / OREGON AVE West Dundee S-10 WD VILLAGE HALL
AMBU - Ambulance Request 18:48 08/10/13 ROCK ROAD DR E MAIN ST East Dundee U-11 DIFF BREATH 9 WEEK OLD SUBUIRU FORESTER NAVY BLU ON ROACK RD BY SHELL 

*/

public class ILKaneCountyParserTest extends BaseParserTest {
  
  public ILKaneCountyParserTest() {
    setParser(new ILKaneCountyParser(), "KANE COUNTY", "IL");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "STIL - Still Alarm 01:16 08/10/13 455 E MAIN ST RT 72 / LINDEN AVE East Dundee T-10 QC-3738 SEVEN HILLS HEATH CARE",
        "CODE:STIL",
        "CALL:Still Alarm",
        "TIME:01:16",
        "DATE:08/10/13",
        "ADDR:455 E MAIN ST",
        "X:RT 72 / LINDEN AVE",
        "CITY:East Dundee",
        "UNIT:T-10 QC-3738",
        "INFO:SEVEN HILLS HEATH CARE");

    doTest("T2",
        "STIL - Still Alarm 08:31 08/10/13 BONNIE DUNDEE RD WILMETTE East Dundee T-10 SMELL OF THE NATURAL GAS IN THE AREA / WHEN CALLER WAS DRIVING ON BOTH STREETS",
        "CODE:STIL",
        "CALL:Still Alarm",
        "TIME:08:31",
        "DATE:08/10/13",
        "ADDR:BONNIE DUNDEE RD",
        "MADDR:BONNIE DUNDEE RD & WILMETTE",
        "X:WILMETTE",
        "CITY:East Dundee",
        "UNIT:T-10",
        "INFO:SMELL OF THE NATURAL GAS IN THE AREA / WHEN CALLER WAS DRIVING ON BOTH STREETS");

    doTest("T3",
        "AMBU - Ambulance Request 17:55 08/10/13 642 DEERPATH RD ABERDEEN DR / KIMBERLY RD East Dundee T-10 BREATH OK 81YOF HELP FOR MOTHER TRYING TO GET A TX FOR HIS DAUGHTER TO GET HER HELP ELDERLY MALE SAYING WIFE IS OUT OF IT",
        "CODE:AMBU",
        "CALL:Ambulance Request",
        "TIME:17:55",
        "DATE:08/10/13",
        "ADDR:642 DEERPATH RD",
        "X:ABERDEEN DR / KIMBERLY RD",
        "CITY:East Dundee",
        "UNIT:T-10",
        "INFO:BREATH OK 81YOF HELP FOR MOTHER TRYING TO GET A TX FOR HIS DAUGHTER TO GET HER HELP ELDERLY MALE SAYING WIFE IS OUT OF IT");

    doTest("T4",
        "GENR - General Alarm 10:28 08/10/13 102 S 2ND ST N 2ND ST, W MAIN ST / OREGON AVE West Dundee S-10 WD VILLAGE HALL",
        "CODE:GENR",
        "CALL:General Alarm",
        "TIME:10:28",
        "DATE:08/10/13",
        "ADDR:102 S 2ND ST",
        "X:N 2ND ST, W MAIN ST / OREGON AVE",
        "CITY:West Dundee",
        "UNIT:S-10",
        "INFO:WD VILLAGE HALL");

    doTest("T5",
        "AMBU - Ambulance Request 18:48 08/10/13 ROCK ROAD DR E MAIN ST East Dundee U-11 DIFF BREATH 9 WEEK OLD SUBUIRU FORESTER NAVY BLU ON ROACK RD BY SHELL ",
        "CODE:AMBU",
        "CALL:Ambulance Request",
        "TIME:18:48",
        "DATE:08/10/13",
        "ADDR:ROCK ROAD DR",
        "MADDR:ROCK ROAD DR & E MAIN ST",
        "X:E MAIN ST",
        "CITY:East Dundee",
        "UNIT:U-11",
        "INFO:DIFF BREATH 9 WEEK OLD SUBUIRU FORESTER NAVY BLU ON ROACK RD BY SHELL");

  }
  
  public static void main(String[] args) {
    new ILKaneCountyParserTest().generateTests("T1");
  }
}