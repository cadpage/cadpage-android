package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/* 
Madison County, NC
Contact: "Teresa Ogle" <e911@madisoncountync.org>  (911 director), 8282060911@email.uscc.net

S: M:TERESA:1 MANOR RD MARS HILL 2011046591 14:24:27 TEST test page
S: M:Randy:16 A AVE HOT SPRINGS 2011046589 13:32:14 STROKE 80 y/o female possible stroke has history
S: M:Randy:590 MEDICAL PARK DR MARSHALL 2011046583 11:27:50 DIFFICULTY IN BREATHING 63 y/o female with copd with difficult
S: M:JOEY:6266 US 25-70 HWY MARSHALL 2011046522 23:38:41 CHEST PAIN 50 Y/O FEMALE CHEST PAINS
S: M:JOEY:31 TWEED RD MARSHALL 2011046509 00:21:13 WILDFIRE SOME TYPE OF FIRE ON TWEED ROAD. THIS IS A THIRD PARTY CALL
S: M:BRETT:717 HENRY TREADWAY RD MARSHALL 2011046457 20:00:32 ROUTINE TRANSPORT 84 y/o female
S: M:BRETT:150 BERRY WILLS RD HOT SPRINGS 2011046451 18:00:17 FALL-WITH INJURIES
S: M:ROBIN:127 MOUNTAIN HAVEN DR MARS HILL 2011046543 10:06:25 SICK CALL MALE LOWER BOWEL INFECTION ( C-DIF ) 64 YOA 1ST D
S: M:ROBIN:193 LUTHER DR MARS HILL 2011046538 06:28:43 IRREGULAR HEART RATE FEMALE 98 YOA LOW BP//IRREGULAR HEART RATE
S: M:AVA:89 NEWGROUND RD MARS HILL 2011046496 15:21:14 LEG PAIN recent  hip surgery complaining of increase in leg pain

Contact: Active911
Agency name: Ebbs Chapel Fire Department
Location: Mars Hill, NC, United States

2091 FOSTER CREEK RD MARSHALL 2013005989 16:48:09 FALL-WITH INJURIES 83 Y/O FEMALE FALL WITH A HEAD INJURY
85 I-26 MARS HILL 2013005983 13:35:12 VEHICLE FIRE PICK UP TRUCK ON FIRE
272 HYLTON HOLLOW RD MARSHALL 2013005928 05:01:21 HEART ATTACK 62 M chest pain for about an hour having trouble breathing ..clammy and throwing up .. has taken hea
14084 US 23 HWY MARS HILL 2013005891 10:45:54 UNKNOWN MEDICAL medical alert : unknown medical
12200 BIG LAUREL RD MARSHALL 2013005850 09:25:10 DECREASED LEVEL OF CONSCIOUSNESS 825 yo male decreased loc
10998 BIG LAUREL RD MARSHALL 2013005769 08:38:24 CHEST PAIN 70 M chest pain in the center of his chest since 5:30 am took an asprin no relief
680 PUNCHEON FORK RD MARS HILL 2013005703 18:40:55 SEARCH SEARCH MEET AT STATION PER 600
9029 US 23 HWY MARS HILL 2013005638 20:45:57 SUICIDE female has cut herself on her arms
32 PETERS COVE RD MARSHALL 2013005530 06:52:17 FALL-UNKNOWN INJURIES 68 Y/O FEMALE FALL UNKNOWN INJURIES
10325 US 23 HWY MARS HILL 2013005453 13:05:24 FIRE ALARM ACTIVATION upper level smoke sensor fire alarm activation

*/

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
  
  @Test
  public void testEbbsChappelFire() {

    doTest("T1",
        "2091 FOSTER CREEK RD MARSHALL 2013005989 16:48:09 FALL-WITH INJURIES 83 Y/O FEMALE FALL WITH A HEAD INJURY",
        "ADDR:2091 FOSTER CREEK RD",
        "CITY:MARSHALL",
        "ID:2013005989",
        "TIME:16:48:09",
        "INFO:FALL-WITH INJURIES 83 Y/O FEMALE FALL WITH A HEAD INJURY");

    doTest("T2",
        "85 I-26 MARS HILL 2013005983 13:35:12 VEHICLE FIRE PICK UP TRUCK ON FIRE",
        "ADDR:85 I-26",
        "MADDR:85 I 26",
        "CITY:MARS HILL",
        "ID:2013005983",
        "TIME:13:35:12",
        "INFO:VEHICLE FIRE PICK UP TRUCK ON FIRE");

    doTest("T3",
        "272 HYLTON HOLLOW RD MARSHALL 2013005928 05:01:21 HEART ATTACK 62 M chest pain for about an hour having trouble breathing ..clammy and throwing up .. has taken hea",
        "ADDR:272 HYLTON HOLLOW RD",  // Not mapping
        "CITY:MARSHALL",
        "ID:2013005928",
        "TIME:05:01:21",
        "CALL:HEART ATTACK 62 M",
        "INFO:chest pain for about an hour having trouble breathing ..clammy and throwing up .. has taken hea");

    doTest("T4",
        "14084 US 23 HWY MARS HILL 2013005891 10:45:54 UNKNOWN MEDICAL medical alert : unknown medical",
        "ADDR:14084 US 23 HWY",
        "MADDR:14084 US 23",
        "CITY:MARS HILL",
        "ID:2013005891",
        "TIME:10:45:54",
        "CALL:UNKNOWN MEDICAL",
        "INFO:medical alert : unknown medical");

    doTest("T5",
        "12200 BIG LAUREL RD MARSHALL 2013005850 09:25:10 DECREASED LEVEL OF CONSCIOUSNESS 825 yo male decreased loc",
        "ADDR:12200 BIG LAUREL RD",
        "CITY:MARSHALL",
        "ID:2013005850",
        "TIME:09:25:10",
        "INFO:DECREASED LEVEL OF CONSCIOUSNESS 825 yo male decreased loc");

    doTest("T6",
        "10998 BIG LAUREL RD MARSHALL 2013005769 08:38:24 CHEST PAIN 70 M chest pain in the center of his chest since 5:30 am took an asprin no relief",
        "ADDR:10998 BIG LAUREL RD",
        "CITY:MARSHALL",
        "ID:2013005769",
        "TIME:08:38:24",
        "CALL:CHEST PAIN 70 M",
        "INFO:chest pain in the center of his chest since 5:30 am took an asprin no relief");

    doTest("T7",
        "680 PUNCHEON FORK RD MARS HILL 2013005703 18:40:55 SEARCH SEARCH MEET AT STATION PER 600",
        "ADDR:680 PUNCHEON FORK RD",
        "CITY:MARS HILL",
        "ID:2013005703",
        "TIME:18:40:55",
        "INFO:SEARCH SEARCH MEET AT STATION PER 600");

    doTest("T8",
        "9029 US 23 HWY MARS HILL 2013005638 20:45:57 SUICIDE female has cut herself on her arms",
        "ADDR:9029 US 23 HWY",
        "MADDR:9029 US 23",
        "CITY:MARS HILL",
        "ID:2013005638",
        "TIME:20:45:57",
        "CALL:SUICIDE",
        "INFO:female has cut herself on her arms");

    doTest("T9",
        "32 PETERS COVE RD MARSHALL 2013005530 06:52:17 FALL-UNKNOWN INJURIES 68 Y/O FEMALE FALL UNKNOWN INJURIES",
        "ADDR:32 PETERS COVE RD",
        "CITY:MARSHALL",
        "ID:2013005530",
        "TIME:06:52:17",
        "INFO:FALL-UNKNOWN INJURIES 68 Y/O FEMALE FALL UNKNOWN INJURIES");

    doTest("T10",
        "10325 US 23 HWY MARS HILL 2013005453 13:05:24 FIRE ALARM ACTIVATION upper level smoke sensor fire alarm activation",
        "ADDR:10325 US 23 HWY",
        "MADDR:10325 US 23",
        "CITY:MARS HILL",
        "ID:2013005453",
        "TIME:13:05:24",
        "CALL:FIRE ALARM ACTIVATION",
        "INFO:upper level smoke sensor fire alarm activation");
    
  }

  public static void main(String[] args) {
    new NCMadisonCountyParserTest().generateTests("T1");
  }
}
