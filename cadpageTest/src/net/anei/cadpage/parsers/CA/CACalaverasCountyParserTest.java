package net.anei.cadpage.parsers.CA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Calaveras County, CA
Contact: "Allendorf, Ed" <Ed.Allendorf@fire.ca.gov>
Sender: tcucad@FIRE.CA.GOV

Inc# 001514: MEDICAL: OAK SHADOWS MHP @ 1330 CALAVERITAS RD #2 ,CALAVERAS_COUNTY :Map 467/19D_024: LAT/LONG X: -120 39.6354 Y: 38 11.1991: 85 YO F POSS HEART: 16 D4494: <a href="http://maps.google.com/?q=38.186653,-120.660590">Map;</a>
Inc# 001513: MEDICAL: 251 MAIN ST S ,ANGELS_CAMP :Map 508/30C_016: LAT/LONG X: -120 33.3059 Y: 38 4.79166: 33 YO CHEST PAIN: D4494: <a href="http://maps.google.com/?q=38.079861,-120.555099">Map;</a>
Inc# 008348: MEDICAL: 18000 BUTTONDOWN LN / 19228 SHAWNEE TRL ,MT_RANCH :Map 428/21A_005: LAT/LONG X: -120 31.3046 Y: 38 16.9120: WOMAN THROWN FROM HORSE LOST CONCIOUSNESS: D4494: <a href="http://maps.google.com/?q=38.281867,-120.521744">Map;</a>
Inc# 008521: MED, TRAFFIC COLLISION: CARSON HILL @ =L(38.027576,-120.507124) ,CALAVERAS_COUNTY :Map 529/37B_016: LAT/LONG X: -120 30.4274 Y: 38 1.65456: : 22 21 E4472: <a href="http://maps.google.com/?q=38.027576,-120.507124">Map;</a>
Inc# 001511: MEDICAL: 13077 BECKWITH RD #B ,SONORA :Map 3247: LAT/LONG X: -120 21.5158 Y: 37 59.214: STAGE CUT WITH KNIFE: D4494: <a href="http://maps.google.com/?q=37.986900,-120.358598">Map;</a>

 */

public class CACalaverasCountyParserTest extends BaseParserTest {
  
  public CACalaverasCountyParserTest() {
    setParser(new CACalaverasCountyParser(), "CALAVERAS COUNTY", "CA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Inc# 001514: MEDICAL: OAK SHADOWS MHP @ 1330 CALAVERITAS RD #2 ,CALAVERAS_COUNTY :Map 467/19D_024: LAT/LONG X: -120 39.6354 Y: 38 11.1991: 85 YO F POSS HEART: 16 D4494: <a href=\"http://maps.google.com/?q=38.186653,-120.660590\">Map;</a>",
        "ID:001514",
        "CALL: MEDICAL",
        "PLACE:OAK SHADOWS MHP",
        "ADDR:1330 CALAVERITAS RD",
        "APT:2",
        "CITY:CALAVERAS COUNTY",
        "MAP:467/19D_024",
        "GPS:+38.186652,-120.660590",
        "INFO:85 YO F POSS HEART",
        "UNIT:16 D4494");

    doTest("T2",
        "Inc# 001513: MEDICAL: 251 MAIN ST S ,ANGELS_CAMP :Map 508/30C_016: LAT/LONG X: -120 33.3059 Y: 38 4.79166: 33 YO CHEST PAIN: D4494: <a href=\"http://maps.google.com/?q=38.079861,-120.555099\">Map;</a>",
        "ID:001513",
        "CALL: MEDICAL",
        "ADDR:251 MAIN ST S",
        "CITY:ANGELS CAMP",
        "MAP:508/30C_016",
        "GPS:+38.079861,-120.555098",
        "INFO:33 YO CHEST PAIN",
        "UNIT:D4494");

    doTest("T3",
        "Inc# 008348: MEDICAL: 18000 BUTTONDOWN LN / 19228 SHAWNEE TRL ,MT_RANCH :Map 428/21A_005: LAT/LONG X: -120 31.3046 Y: 38 16.9120: WOMAN THROWN FROM HORSE LOST CONCIOUSNESS: D4494: <a href=\"http://maps.google.com/?q=38.281867,-120.521744\">Map;</a>",
        "ID:008348",
        "CALL: MEDICAL",
        "ADDR:18000 BUTTONDOWN LN & 19228 SHAWNEE TRL",
        "MADDR:18000 BUTTONDOWN LN",
        "CITY:MT RANCH",
        "MAP:428/21A_005",
        "GPS:+38.281867,-120.521743",
        "INFO:WOMAN THROWN FROM HORSE LOST CONCIOUSNESS",
        "UNIT:D4494");

    doTest("T4",
        "Inc# 008521: MED, TRAFFIC COLLISION: CARSON HILL @ =L(38.027576,-120.507124) ,CALAVERAS_COUNTY :Map 529/37B_016: LAT/LONG X: -120 30.4274 Y: 38 1.65456: : 22 21 E4472: <a href=\"http://maps.google.com/?q=38.027576,-120.507124\">Map;</a>",
        "ID:008521",
        "CALL: MED, TRAFFIC COLLISION",
        "PLACE:CARSON HILL",
        "ADDR:=L(38.027576,-120.507124)",
        "MADDR:+38.027576,-120.507124",
        "CITY:CALAVERAS COUNTY",
        "MAP:529/37B_016",
        "GPS:+38.027576,-120.507123",
        "UNIT:22 21 E4472");

    doTest("T5",
        "Inc# 001511: MEDICAL: 13077 BECKWITH RD #B ,SONORA :Map 3247: LAT/LONG X: -120 21.5158 Y: 37 59.214: STAGE CUT WITH KNIFE: D4494: <a href=\"http://maps.google.com/?q=37.986900,-120.358598\">Map;</a>",
        "ID:001511",
        "CALL: MEDICAL",
        "ADDR:13077 BECKWITH RD",
        "APT:B",
        "CITY:SONORA",
        "MAP:3247",
        "GPS:+37.986900,-120.358597",
        "INFO:STAGE CUT WITH KNIFE",
        "UNIT:D4494");

  }
  
  public static void main(String[] args) {
    new CACalaverasCountyParserTest().generateTests("T1");
  }
}