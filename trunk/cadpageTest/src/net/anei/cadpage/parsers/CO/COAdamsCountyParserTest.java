package net.anei.cadpage.parsers.CO;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.CO.COAdamsCountyParser;

import org.junit.Test;


public class COAdamsCountyParserTest extends BaseParserTest {
  
  public COAdamsCountyParserTest() {
    setParser(new COAdamsCountyParser(), "ADAMS COUNTY", "CO");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "Subject:IPS I/Page Notification E 64TH AVE/MONACO ST ADAM CCPD 09:51:48 TYPE CODE: ACCI CALLER NAME: TIME: 09:51:48 Comments: -104.90947",
        "ADDR:E 64TH AVE & MONACO ST",
        "CITY:COMMERCE CITY",
        "TIME:09:51:48",
        "CALL:ACCI",
        "INFO:-104.90947");
    
    doTest("T2",
        "Subject:IPS I/Page Notification 6950 NIAGARA ST ADAM CCPD 11:04:10 TYPE CODE: EMS CALLER NAME: FELIX - 13YO TIME: 11:04:10 Comments: 15YO",
        "ADDR:6950 NIAGARA ST",
        "CITY:COMMERCE CITY",
        "TIME:11:04:10",
        "CALL:EMS",
        "NAME:FELIX - 13YO",
        "INFO:15YO");
    
    doTest("T3",
        "Subject:IPS I/Page Notification 10220 BRIGHTON RD ADAM CCPD:DIVERSIFIES TRUCK AND RV 17:22:11 TYPE CODE: NONSTR CALLER NAME: BOB TIME: 17:",
        "ADDR:10220 BRIGHTON RD",
        "CITY:COMMERCE CITY",
        "PLACE:DIVERSIFIES TRUCK AND RV",
        "TIME:17:22:11",
        "CALL:NONSTR",
        "NAME:BOB");
      
    doTest("T4",
        "Subject:IPS I/Page Notification US HIGHWAY 85 NB/E 77TH AVE ADAM ADAM 03:34:04 TYPE CODE: NONSTR CALLER NAME: ASHLEY TIME: 03:34:04 Commen",
        "ADDR:US HIGHWAY 85 NB & E 77TH AVE",
        "MADDR:US 85 & E 77TH AVE",
        "TIME:03:34:04",
        "CALL:NONSTR",
        "NAME:ASHLEY");
    
    doTest("T5",
        "Subject:IPS I/Page Notification 9900 E 102ND AVE ADAM CCPD:USF 06:06:49 TYPE CODE: FRALRM CALLER NAME: ADT TIME: 06:06:49 Comments: WATER",
        "ADDR:9900 E 102ND AVE",
        "CITY:COMMERCE CITY",
        "PLACE:USF",
        "TIME:06:06:49",
        "CALL:FRALRM",
        "NAME:ADT",
        "INFO:WATER");
    
    doTest("T6",
        "Subject:IPS I/Page Notification\n26900 E COLFAX AVE ARAP ARAP,454: @FOX RIDGE FARMS 17:19:15 TYPE CODE: EMS CALLER NAME:  TIME: 17:19:15 Co",
        "ADDR:26900 E COLFAX AVE",
        "CITY:ARAPAHOE COUNTY",
        "APT:454",
        "PLACE:FOX RIDGE FARMS",
        "TIME:17:19:15",
        "CALL:EMS");

    doTest("T7",
        "IPS I/Page Notification / 10433 SALIDA ST ADAM CCPD 06:51:58 TYPE CODE: FRALRM CALLER NAME:  TIME: 06:51:58\n\n\n",
        "ADDR:10433 SALIDA ST",
        "CITY:COMMERCE CITY",
        "TIME:06:51:58",
        "CALL:FRALRM");

    doTest("T8",
        "(IPS I/Page Notification) E 470 EB ADAM ADAM: @E 470 EB/E 56TH AVE 22:58:36 TYPE CODE: NONSTR CALLER NAME:  TIME: 22:58:36 Comments:  -104.701552 +39.798521 WH",
        "ADDR:E-470 EB & E 56TH AVE",
        "MADDR:E-470 & E 56TH AVE",
        "TIME:22:58:36",
        "CALL:NONSTR",
        "INFO:-104.701552 +39.798521 WH");
    
    doTest("T9",
        "Subject:IPS I/Page Notification\n510.5 S 2nd Ave major incident-- hazmat  no additional equip needed at this time\r\n\r\n\r",
        "ADDR:510.5 S 2nd Ave",
        "CALL:major incident-- hazmat no additional equip needed at this time");

    doTest("T10",
        "Subject:IPS I/Page Notification\n" +
        "40200 E QUINCY AVE 18:40:46 TYPE CODE: NONSTR CALLER NAME:  TIME: 18:40:46 Comments:  WILL BE HOUSE NUMBER\r",

        "ADDR:40200 E QUINCY AVE",
        "CALL:NONSTR",
        "TIME:18:40:46",
        "INFO:WILL BE HOUSE NUMBER");
  }
  
  @Test
  public void testActive911() {
    
    doTest("T1",
        "(IPS I/Page Notification) 8055 WASHINGTON ST ADAM ADAM: @STATION 31 13:45:48 TYPE CODE: EMS CALLER NAME: FIL MARTINEZ TIME: 13:45:48 Comments:  TEST CARD",
        "ADDR:8055 WASHINGTON ST",
        "PLACE:STATION 31",
        "CALL:EMS",
        "NAME:FIL MARTINEZ",
        "TIME:13:45:48",
        "INFO:TEST CARD");

    doTest("T2",
        "[IPS I/Page Notification] I 70 WB/MM 317 01:47:54 TYPE CODE: STANDBY CALLER NAME: ARAP TIME: 01:47:54 Comments:  ** LOI search completed at 08/13/12 01:45:25 WB LANES .. EAST OF MM 317 REQ STRASBURG STANDBY FOR ALS FOR BYERS FIRE ROLLOVER VEH .. 1 PTY PINNED .. 1 EJECTED CHOPPER ON GROUND STAND BY PER TIFFANY .. ARAP COUNTY 800 AKN -- TONE BENN -- ALS UNAVAIL 711 REQ BENN START TONED 900 MED71 ENRT ON BYERS PRIM REQ TONE FOR DRIVER 2ND TONES FOR DRIVER 958 I / S 711 WILL HAVE COMMAND AIRLIFE IS AIRBORN STANDBY WILL BE LANDING STAC D 711 -- 2ND ROLLOVER ACCIDENT HALF MILE AWAY CRX ... 1 1 / 2 MILE AMB701 ENRT TO 711 LOCATION NEED EXTRICATION AND AN ALS AMB ** Cross Referenced to Event # BFD12000590 at: 08/13/12 01:45:25 ** >>>> by: JENNIFER WATTS on terminal: dp9 NEED 2 ALS AMB TONED 800 AMB81 - ENRT ALS X 3 BYERS-- NEED 2 AMB TO RESPOND ALS SAYING THEY NEED ALL AMB AVAIL AMB81 - 2ND TONES FOR ACCIDENT\r\n" +
        "\r\n" +
        "\r\n",

        "ADDR:I 70 WB & MM 317",
        "MADDR:I 70 & MM 317",
        "CALL:STANDBY",
        "NAME:ARAP",
        "TIME:01:47:54",
        "INFO:** LOI search completed at 08/13/12 01:45:25 WB LANES .. EAST OF MM 317 REQ STRASBURG STANDBY FOR ALS FOR BYERS FIRE ROLLOVER VEH .. 1 PTY PINNED .. 1 EJECTED CHOPPER ON GROUND STAND BY PER TIFFANY .. ARAP COUNTY 800 AKN -- TONE BENN -- ALS UNAVAIL 711 REQ BENN START TONED 900 MED71 ENRT ON BYERS PRIM REQ TONE FOR DRIVER 2ND TONES FOR DRIVER 958 I / S 711 WILL HAVE COMMAND AIRLIFE IS AIRBORN STANDBY WILL BE LANDING STAC D 711 -- 2ND ROLLOVER ACCIDENT HALF MILE AWAY CRX ... 1 1 / 2 MILE AMB701 ENRT TO 711 LOCATION NEED EXTRICATION AND AN ALS AMB ** Cross Referenced to Event # BFD12000590 at: 08/13/12 01:45:25 ** >>>> by: JENNIFER WATTS on terminal: dp9 NEED 2 ALS AMB TONED 800 AMB81 - ENRT ALS X 3 BYERS-- NEED 2 AMB TO RESPOND ALS SAYING THEY NEED ALL AMB AVAIL AMB81 - 2ND TONES FOR ACCIDENT");

  }
  
  public static void main(String[] args) {
    new COAdamsCountyParserTest().generateTests("T1");
  }
}