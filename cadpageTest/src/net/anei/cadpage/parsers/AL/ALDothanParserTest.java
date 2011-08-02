package net.anei.cadpage.parsers.AL;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.AL.ALDothanParserTest;

import org.junit.Test;


public class ALDothanParserTest extends BaseParserTest {
  
  public ALDothanParserTest() {
    setParser(new ALDothanParser(), "DOTHAN", "AL");
  }
  
  @Test
  public void testParser() {
    doTest("T1",
        "15:49:38/SC-Service Call Non-Emergency/801 E LAFAYETTE ST/DOTHAN/14523968/ref lines fell at front door, see c404/",
        "ID:14523968",
        "CALL:SC-Service Call Non-Emergency",
        "ADDR:801 E LAFAYETTE ST",
        "CITY:DOTHAN",
        "UNIT:ref lines fell at front door, see c404");

    doTest("T2",
        "16:31:23/SC-Service Call Non-Emergency/401 W INEZ RD/DOTHAN/TANGLEWOOD APARTMENTS/24135869/POWER LINES DOWN AT ENTRANCE, POSS SPARKING, RELAYED BY/",
        "CALL:SC-Service Call Non-Emergency",
        "ADDR:401 W INEZ RD",
        "CITY:DOTHAN",
        "UNIT:TANGLEWOOD APARTMENTS",
        "INFO:24135869 / POWER LINES DOWN AT ENTRANCE, POSS SPARKING, RELAYED BY");

    doTest("T3",
        "18:35:57/MAID-Mutual Aid Request/5499 MONTGOMERY HWY INTERSECTN/DOTHAN/JOHN D ODOM RD/63981245/ECHO RESCUE --/",
        "CALL:MAID-Mutual Aid Request",
        "ADDR:5499 MONTGOMERY HWY INTERSECTN",
        "CITY:DOTHAN",
        "UNIT:JOHN D ODOM RD",
        "INFO:63981245 / ECHO RESCUE --");

    doTest("T4",
        "18:43:58/S38B-Medical Call-Code III-Emergy/107 RIDGE RD/DOTHAN/95163482/63 YOM HEAD INJURY, S24/",
        "ID:95163482",
        "CALL:S38B-Medical Call-Code III-Emergy",
        "ADDR:107 RIDGE RD",
        "CITY:DOTHAN",
        "UNIT:63 YOM HEAD INJURY, S24");

    doTest("T5",
        "19:03:20/S22CF-Assault-Code II/1486 KINSEY RD/DOTHAN/51943628/ARM HURT, WAS PUSHED/",
        "ID:51943628",
        "CALL:S22CF-Assault-Code II",
        "ADDR:1486 KINSEY RD",
        "CITY:DOTHAN",
        "UNIT:ARM HURT, WAS PUSHED");

    doTest("T6",
        "19:08:26/S38B-Medical Call-Code III-Emergy/1303 SUMMIT ST/DOTHAN/14529368/WEAKNESS, PAIN/",
        "ID:14529368",
        "CALL:S38B-Medical Call-Code III-Emergy",
        "ADDR:1303 SUMMIT ST",
        "CITY:DOTHAN",
        "UNIT:WEAKNESS, PAIN");

    doTest("T7",
        "19:17:49/OF-Outdoor Fire-Level 1/1241 KINSEY RD APT186/DOTHAN/JOHNSON 186/51943628/SPARKS SHOOTING FROM POLE/",
        "CALL:OF-Outdoor Fire-Level 1",
        "ADDR:1241 KINSEY RD APT186",
        "CITY:DOTHAN",
        "UNIT:JOHNSON 186",
        "INFO:51943628 / SPARKS SHOOTING FROM POLE");

    doTest("T8",
        "19:58:39/SC-Service Call Non-Emergency/175 BUFORD LN/DOTHAN/LAKEWOOD FIRE STATION/24318569/A/O -- DO NOT RESPOND/",
        "CALL:SC-Service Call Non-Emergency",
        "ADDR:175 BUFORD LN",
        "CITY:DOTHAN",
        "UNIT:LAKEWOOD FIRE STATION",
        "INFO:24318569 / A / O -- DO NOT RESPOND");

    doTest("T9",
        "20:11:48/S8BF-MVC-Code III/2299 JOHN D ODOM RD INTERSECTN/DOTHAN/MURPHY MILL RD/63891245/unk further~~ pr disconnected/",
        "CALL:S8BF-MVC-Code III",
        "ADDR:2299 JOHN D ODOM RD INTERSECTN",
        "CITY:DOTHAN",
        "UNIT:MURPHY MILL RD",
        "INFO:63891245 / unk further~~ pr disconnected");

    doTest("T10",
        "20:15:39/S38B-Medical Call-Code III-Emergy/403 S APPLETREE ST APTJ31/DOTHAN/MARVIN LEWIS J31/14523968/pt low sugar/",
        "CALL:S38B-Medical Call-Code III-Emergy",
        "ADDR:403 S APPLETREE ST APTJ31",
        "CITY:DOTHAN",
        "UNIT:MARVIN LEWIS J31",
        "INFO:14523968 / pt low sugar");

    doTest("T11",
        "20:14:11/S38B-Medical Call-Code III-Emergy/210 N SAINT ANDREWS ST/DOTHAN/CRIMINAL JUSTICE BUILDING/15439268/INMATE -- 31 YOM CP -- HX: 2 HEART SURGERIES/",
        "CALL:S38B-Medical Call-Code III-Emergy",
        "ADDR:210 N SAINT ANDREWS ST",
        "CITY:DOTHAN",
        "UNIT:CRIMINAL JUSTICE BUILDING",
        "INFO:15439268 / INMATE -- 31 YOM CP -- HX: 2 HEART SURGERIES");
   
  }
  
  
  public static void main(String[] args) {
    new ALDothanParserTest().generateTests("T11");
  }
}