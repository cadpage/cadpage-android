package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Clearfield County, PA
Contact: "csatterlee@hallstromconstruction.com" <csatterlee@hallstromconstruction.com>,8145908933@vtext.com
Sender: alerts@clearfieldalerts.com

(Clearfield Alert) Inc: Facility Transfer-Routine\nAdd: 100 HOSPITAL AVE\nCity: DUBOIS\nUnits: 4353\n43EMS\n10/14/2012 7:15:40 AM
(Clearfield Alert) Inc: Sick Person BLS\r\nAdd: 137 OKLAHOMA CEMETERY RD\r\nCity: SANDY\r\nUnits: 4352\r\n43EMS\r\n10/17/2012 12:05:24 PM
(Clearfield Alert) Inc: Breathing Probs ALS\r\nAdd: 817 GREEN GLEN DR\r\nCity: DUBOIS\r\nUnits: 4352\r\n43EMS\r\n10/17/2012 2:43:57 PM
(Clearfield Alert) Inc: Facility Transfer-Routine\r\nAdd: 212 S 8TH ST\r\nCity: SANDY\r\nUnits: 4351\r\n43EMS\r\n10/17/2012 2:45:20 PM
(Clearfield Alert) Inc: Sick Person ALS\r\nAdd: 33 SHORT ST\r\nCity: FALLS_JEF\r\nUnits: 4353\r\n43EMS\r\n10/17/2012 2:58:14 PM
(Clearfield Alert) Inc: EMS Standby\r\nAdd: 404 LIBERTY BLVD\r\nCity: DUBOIS\r\nUnits: 4353\r\n43EMS\r\n10/17/2012 5:53:35 PM
(Clearfield Alert) Inc: Psychological Emer BLS\r\nAdd: 212 S 8TH ST\r\nCity: SANDY\r\nUnits: EMS43 814\r\n43EMS\r\n10/17/2012 7:15:19 PM
(Clearfield Alert) Inc: OD-Poison ALS\r\nAdd: 502 JUNIATA ST\r\nCity: DUBOIS\r\nUnits: EMS43 312\r\n43EMS\r\n10/17/2012 9:15:45 PM
(Clearfield Alert) Inc: Heart Problems-AICD ALS\r\nAdd: 145 ATHENA DR\r\nCity: SANDY\r\nUnits: 4354\r\n43EMS\r\n10/17/2012 8:11:31 PM
(Clearfield Alert) Inc: Facility Transfer-Routine\r\nAdd: 100 HOSPITAL AVE\r\nCity: DUBOIS\r\nUnits: 4354\r\n43EMS\r\n10/18/2012 4:29:08 PM
(Clearfield Alert) Inc: Automatic Fire Alarm\r\nAdd: 300 ASPEN WAY\r\nCity: DUBOIS\r\n
(Clearfield Alert) Inc: Sick Person BLS\r\nAdd: 1100 W LONG AVE\r\nCity: SANDY\r\nUnits: 4354\r\n43EMS\r\n10/18/2012 11:22:33 AM

 */
public class PAClearfieldCountyParserTest extends BaseParserTest {
  
  public PAClearfieldCountyParserTest() {
    setParser(new PAClearfieldCountyParser(), "CLEARFIELD COUNTY", "PA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Clearfield Alert) Inc: Facility Transfer-Routine\nAdd: 100 HOSPITAL AVE\nCity: DUBOIS\nUnits: 4353\n43EMS\n10/14/2012 7:15:40 AM",
        "CALL:Facility Transfer-Routine",
        "ADDR:100 HOSPITAL AVE",
        "CITY:DUBOIS",
        "UNIT:4353",
        "SRC:43EMS",
        "DATE:10/14/2012",
        "TIME:07:15:40");

    doTest("T2",
        "(Clearfield Alert) Inc: Sick Person BLS\r\nAdd: 137 OKLAHOMA CEMETERY RD\r\nCity: SANDY\r\nUnits: 4352\r\n43EMS\r\n10/17/2012 12:05:24 PM",
        "CALL:Sick Person BLS",
        "ADDR:137 OKLAHOMA CEMETERY RD", // Not mapping
        "CITY:SANDY",
        "UNIT:4352",
        "SRC:43EMS",
        "DATE:10/17/2012",
        "TIME:12:05:24");

    doTest("T3",
        "(Clearfield Alert) Inc: Breathing Probs ALS\r\nAdd: 817 GREEN GLEN DR\r\nCity: DUBOIS\r\nUnits: 4352\r\n43EMS\r\n10/17/2012 2:43:57 PM",
        "CALL:Breathing Probs ALS",
        "ADDR:817 GREEN GLEN DR",
        "CITY:DUBOIS",
        "UNIT:4352",
        "SRC:43EMS",
        "DATE:10/17/2012",
        "TIME:14:43:57");

    doTest("T4",
        "(Clearfield Alert) Inc: Facility Transfer-Routine\r\nAdd: 212 S 8TH ST\r\nCity: SANDY\r\nUnits: 4351\r\n43EMS\r\n10/17/2012 2:45:20 PM",
        "CALL:Facility Transfer-Routine",
        "ADDR:212 S 8TH ST",
        "CITY:SANDY",
        "UNIT:4351",
        "SRC:43EMS",
        "DATE:10/17/2012",
        "TIME:14:45:20");

    doTest("T5",
        "(Clearfield Alert) Inc: Sick Person ALS\r\nAdd: 33 SHORT ST\r\nCity: FALLS_JEF\r\nUnits: 4353\r\n43EMS\r\n10/17/2012 2:58:14 PM",
        "CALL:Sick Person ALS",
        "ADDR:33 SHORT ST",
        "CITY:FALLS CREEK", 
        "UNIT:4353",
        "SRC:43EMS",
        "DATE:10/17/2012",
        "TIME:14:58:14");

    doTest("T6",
        "(Clearfield Alert) Inc: EMS Standby\r\nAdd: 404 LIBERTY BLVD\r\nCity: DUBOIS\r\nUnits: 4353\r\n43EMS\r\n10/17/2012 5:53:35 PM",
        "CALL:EMS Standby",
        "ADDR:404 LIBERTY BLVD",
        "CITY:DUBOIS",
        "UNIT:4353",
        "SRC:43EMS",
        "DATE:10/17/2012",
        "TIME:17:53:35");

    doTest("T7",
        "(Clearfield Alert) Inc: Psychological Emer BLS\r\nAdd: 212 S 8TH ST\r\nCity: SANDY\r\nUnits: EMS43 814\r\n43EMS\r\n10/17/2012 7:15:19 PM",
        "CALL:Psychological Emer BLS",
        "ADDR:212 S 8TH ST",
        "CITY:SANDY",
        "UNIT:EMS43 814",
        "SRC:43EMS",
        "DATE:10/17/2012",
        "TIME:19:15:19");

    doTest("T8",
        "(Clearfield Alert) Inc: OD-Poison ALS\r\nAdd: 502 JUNIATA ST\r\nCity: DUBOIS\r\nUnits: EMS43 312\r\n43EMS\r\n10/17/2012 9:15:45 PM",
        "CALL:OD-Poison ALS",
        "ADDR:502 JUNIATA ST",
        "CITY:DUBOIS",
        "UNIT:EMS43 312",
        "SRC:43EMS",
        "DATE:10/17/2012",
        "TIME:21:15:45");

    doTest("T9",
        "(Clearfield Alert) Inc: Heart Problems-AICD ALS\r\nAdd: 145 ATHENA DR\r\nCity: SANDY\r\nUnits: 4354\r\n43EMS\r\n10/17/2012 8:11:31 PM",
        "CALL:Heart Problems-AICD ALS",
        "ADDR:145 ATHENA DR",
        "CITY:SANDY",
        "UNIT:4354",
        "SRC:43EMS",
        "DATE:10/17/2012",
        "TIME:20:11:31");

    doTest("T10",
        "(Clearfield Alert) Inc: Facility Transfer-Routine\r\nAdd: 100 HOSPITAL AVE\r\nCity: DUBOIS\r\nUnits: 4354\r\n43EMS\r\n10/18/2012 4:29:08 PM",
        "CALL:Facility Transfer-Routine",
        "ADDR:100 HOSPITAL AVE",
        "CITY:DUBOIS",
        "UNIT:4354",
        "SRC:43EMS",
        "DATE:10/18/2012",
        "TIME:16:29:08");

    doTest("T11",
        "(Clearfield Alert) Inc: Automatic Fire Alarm\r\nAdd: 300 ASPEN WAY\r\nCity: DUBOIS\r\n",
        "CALL:Automatic Fire Alarm",
        "ADDR:300 ASPEN WAY",
        "CITY:DUBOIS");

    doTest("T12",
        "(Clearfield Alert) Inc: Sick Person BLS\r\nAdd: 1100 W LONG AVE\r\nCity: SANDY\r\nUnits: 4354\r\n43EMS\r\n10/18/2012 11:22:33 AM",
        "CALL:Sick Person BLS",
        "ADDR:1100 W LONG AVE",
        "CITY:SANDY",
        "UNIT:4354",
        "SRC:43EMS",
        "DATE:10/18/2012",
        "TIME:11:22:33");

  }
  
  public static void main(String[] args) {
    new PAClearfieldCountyParserTest().generateTests("T1");
  }
}