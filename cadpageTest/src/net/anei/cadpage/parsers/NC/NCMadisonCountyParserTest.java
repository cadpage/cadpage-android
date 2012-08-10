package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NCMadisonCountyParserTest extends BaseParserTest {
  
  public NCMadisonCountyParserTest() {
    setParser(new NCMadisonCountyParser(), "MADISON COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "S: M:TERESA:1 MANOR RD MARS HILL 2011046591 14:24:27 TEST test page",
        "ADDR:1 MANOR RD",
        "CITY:MARS HILL",
        "ID:2011046591",
        "TIME:14:24:27",
        "CALL:TEST",
        "INFO:test page");

    doTest("T2",
        "S: M:Randy:16 A AVE HOT SPRINGS 2011046589 13:32:14 STROKE 80 y/o female possible stroke has history",
        "ADDR:16 A AVE",
        "CITY:HOT SPRINGS",
        "ID:2011046589",
        "TIME:13:32:14",
        "CALL:STROKE",
        "INFO:80 y/o female possible stroke has history");

    doTest("T3",
        "S: M:Randy:590 MEDICAL PARK DR MARSHALL 2011046583 11:27:50 DIFFICULTY IN BREATHING 63 y/o female with copd with difficult",
        "ADDR:590 MEDICAL PARK DR",
        "CITY:MARSHALL",
        "ID:2011046583",
        "TIME:11:27:50",
        "CALL:DIFFICULTY IN BREATHING",
        "INFO:63 y/o female with copd with difficult");

    doTest("T4",
        "S: M:JOEY:6266 US 25-70 HWY MARSHALL 2011046522 23:38:41 CHEST PAIN 50 Y/O FEMALE CHEST PAINS",
        "ADDR:6266 US 25-70 HWY",
        "MADDR:6266 US 25",
        "CITY:MARSHALL",
        "ID:2011046522",
        "TIME:23:38:41",
        "INFO:CHEST PAIN 50 Y/O FEMALE CHEST PAINS");

    doTest("T5",
        "S: M:JOEY:31 TWEED RD MARSHALL 2011046509 00:21:13 WILDFIRE SOME TYPE OF FIRE ON TWEED ROAD. THIS IS A THIRD PARTY CALL",
        "ADDR:31 TWEED RD",
        "CITY:MARSHALL",
        "ID:2011046509",
        "TIME:00:21:13",
        "INFO:WILDFIRE SOME TYPE OF FIRE ON TWEED ROAD. THIS IS A THIRD PARTY CALL");

    doTest("T6",
        "S: M:BRETT:717 HENRY TREADWAY RD MARSHALL 2011046457 20:00:32 ROUTINE TRANSPORT 84 y/o female",
        "ADDR:717 HENRY TREADWAY RD",
        "CITY:MARSHALL",
        "ID:2011046457",
        "TIME:20:00:32",
        "CALL:ROUTINE TRANSPORT",
        "INFO:84 y/o female");

    doTest("T7",
        "S: M:BRETT:150 BERRY WILLS RD HOT SPRINGS 2011046451 18:00:17 FALL-WITH INJURIES",
        "ADDR:150 BERRY WILLS RD",
        "CITY:HOT SPRINGS",
        "ID:2011046451",
        "TIME:18:00:17",
        "CALL:FALL-WITH INJURIES");

    doTest("T8",
        "S: M:ROBIN:127 MOUNTAIN HAVEN DR MARS HILL 2011046543 10:06:25 SICK CALL MALE LOWER BOWEL INFECTION ( C-DIF ) 64 YOA 1ST D",
        "ADDR:127 MOUNTAIN HAVEN DR",
        "CITY:MARS HILL",
        "ID:2011046543",
        "TIME:10:06:25",
        "INFO:SICK CALL MALE LOWER BOWEL INFECTION ( C-DIF ) 64 YOA 1ST D");

    doTest("T9",
        "S: M:ROBIN:193 LUTHER DR MARS HILL 2011046538 06:28:43 IRREGULAR HEART RATE FEMALE 98 YOA LOW BP//IRREGULAR HEART RATE",
        "ADDR:193 LUTHER DR",
        "CITY:MARS HILL",
        "ID:2011046538",
        "TIME:06:28:43",
        "INFO:IRREGULAR HEART RATE FEMALE 98 YOA LOW BP//IRREGULAR HEART RATE");

    doTest("T10",
        "S: M:AVA:89 NEWGROUND RD MARS HILL 2011046496 15:21:14 LEG PAIN recent  hip surgery complaining of increase in leg pain",
        "ADDR:89 NEWGROUND RD",
        "CITY:MARS HILL",
        "ID:2011046496",
        "TIME:15:21:14",
        "CALL:LEG PAIN",
        "INFO:recent  hip surgery complaining of increase in leg pain");
  }

  public static void main(String[] args) {
    new NCMadisonCountyParserTest().generateTests("T1", "PLACE ADDR CITY NAME PHONE CODE ID TIME CALL INFO");
  }
}
