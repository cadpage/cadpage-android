package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.PA.PAElkCountyParser;

import org.junit.Test;

/*
Elk County, PA (also dispatches Cameron County and apparently Clearfield County)
Contact: "McAllister, Mike" <mamcallister@elkoes.com>
Sender: alerts@elkcounty911.ealertgov.com
System: Logisys CAD

Inc: DIABETIC PROBLEMS Add: 890 BURNING WELL RD\nCity: JONES\nXSt: OLD KANE RD * ROCKY RUN RD\nAgency: ST MARYS AMB 
Inc: FALLS Add: 185 CENTER ST\nCity: ST_MARYS\nXSt: N SAINT MARYS ST * MCGILL ST\nAgency: ST MARYS AMB 
Inc: SICK PERSON Add: 352 STATE ST\nCity: ST_MARYS\nXSt: ANTHONY RD * RIDGWAY ST MARYS RD\nAgency: ST MARYS AMB 
Inc: TRANSFER/INTERFACILITY Add: 755 JOHNSONBURG RD\nCity: ST_MARYS\nXSt: MAURUS ST * SHERRY RD\nAgency: ST MARYS AMB 
Inc: TRAFFIC ACCIDENT/INJURIES Add: IRISHTOWN RD and MAIN ST\nCity: FOX\nXSt: SKYLINE DR * TAYLOR ST\nAgency: ST MARYS AMB 
Inc: ALARMS-COMMERCIAL Add: 109 JEEP RD\nCity: ST_MARYS\nXSt: S SAINT MARYS ST\nAgency: ST MARYS AMB 
Inc: SICK PERSON Add: 303 CHESTNUT ST\nCity: ST_MARYS\nXSt: E MILL ST * OAK ST\nAgency: ST MARYS AMB

Contact: "Mike Healy" <mike.healy@thefirehall.net>
Sender: alerts@elkcounty911.ealertgov.com
Inc: ELEC HAZ-ELECTRICAL HAZ-WATER Add: 1449 SHAWMUT RD \nCity: HORTON \nXSt: ROUTE 219 * ROCKY LN \nAgency: ELK COMPANY 1 FD \n\n5/29/2012 4:03:58 PM

Contact: Active911
Agency name: Elk County Emergency Services Location: Ridgway, PA 
Sender: "Elk EOS" <alerts@elkcounty911.ealertgov.com>

(Elk County 911 Alerts) Inc Code: FALLS<br/>Address: 759 JOHNSONBURG RD<br/>City: ST_MARYS<br/>Cross Streets: MAURUS ST * SHERRY RD<br/><br>Agency: ST MARYS AMB<br/>9/10/2012 4:40:17 PM
(Elk County 911 Alerts) Inc Code: PUBLIC SERVICE<br/>Address: 600 MAURUS ST<br/>City: ST_MARYS<br/>Cross Streets: LOUIS ST * JOHNSONBURG RD<br/><br>Agency: ST MARYS AMB<br/>9/10/2012 5:17:55 PM
(Elk County 911 Alerts) Inc Code: SICK PERSON<br/>Address: 309 1ST AVE [JOHNSBURG]<br/>City: JOHNSBURG<br/>Cross Streets: SHORT ST * COBB ST<br/><br>Agency: ST MARYS AMB<br/>9/10/2012 5:37:05 PM
(Elk County 911 Alerts) Inc Code: TRAFFIC ACCIDENT/OVERRIDE<br/>Address: W MAIN ST and HAYES RD<br/>City: FOX<br/>Cross Streets: HAYES RD * W MAIN STREET EXT<br/><br>Agency: ST MARYS AMB<br/>9/10/2012 6:31:40 PM
(Elk County 911 Alerts) Inc Code: PREGNANCY/CHILDBIRTH<br/>Address: 217 POWERS AVE<br/>City: JOHNSBURG<br/>Cross Streets: E CENTER ST * JOHNSONBURG RD<br/><br>Agency: ST MARYS AMB<br/>9/11/2012 12:16:13 AM
(Elk County 911 Alerts) Inc Code: SEIZURES<br/>Address: 40 PETERS RD<br/>City: HORTON<br/>Cross Streets: DONAHUE RD<br/><br>Agency: RIDGWAY AMBULANCE<br/>9/11/2012 12:17:39 AM
(Elk County 911 Alerts) Inc Code: TRANSPORT<br/>Address: ERHC TO DRMC-E<br/>City: <br/><br/><br>Agency: EMPORIUM AMBULANCE<br/>9/11/2012 12:20:28 AM
(Elk County 911 Alerts) Inc Code: TRANSFER/INTERFACILITY<br/>Address: 785 JOHNSONBURG RD<br/>City: ST_MARYS<br/>Cross Streets: SHERRY RD * POPE RD<br/><br>Agency: ST MARYS AMB<br/>9/11/2012 11:34:53 AM
(Elk County 911 Alerts) Inc Code: BREATHING PROBLEMS<br/>Address: 515 N BROAD ST<br/>City: RIDGWAY_B<br/>Cross Streets: WILLIAMS ST * RIDGWAY JOHNSONBURG RD<br/><br>Agency: RIDGWAY AMBULANCE<br/>9/11/2012 11:58:35 AM
(Elk County 911 Alerts) Inc Code: UNCONSCIOUS/FAINTING<br/>Address: BROAD<br/>City: <br/><br/><br>Agency: ST MARYS AMB<br/>9/11/2012 12:30:50 PM
(Elk County 911 Alerts) Inc Code: UNCONSCIOUS/FAINTING<br/>Address: BROAD<br/>City: <br/><br/><br>Agency: EMPORIUM AMBULANCE<br/>9/11/2012 12:30:56 PM
(Elk County 911 Alerts) Inc Code: TRANSPORT<br/>Address: RES TO DRMC WEST<br/>City: <br/><br/><br>Agency: RIDGWAY AMBULANCE<br/>9/11/2012 1:28:56 PM
(Elk County 911 Alerts) Inc Code: SICK PERSON<br/>Address: 107 FLOYD LN<br/>City: GROVE<br/>Cross Streets: JERRY RUN RD<br/><br>Agency: EMPORIUM AMBULANCE<br/>9/11/2012 1:43:56 PM
(Elk County 911 Alerts) Inc Code: STRUCTURE FIRE-RESIDENT SINGLE<br/>Address: 129 EAST AVE<br/>City: RIDGWAY_B<br/>Cross Streets: LONG ST * SOUTH ST<br/><br>Agency: ELK COMPANY 4 FD<br/>9/11/2012 1:44:01 PM
(Elk County 911 Alerts) Inc Code: STRUCTURE FIRE-RESIDENT SINGLE<br/>Address: 129 EAST AVE<br/>City: RIDGWAY_B<br/>Cross Streets: LONG ST * SOUTH ST<br/><br>Agency: RIDGWAY AMBULANCE<br/>9/11/2012 1:46:16 PM
(Elk County 911 Alerts) Inc Code: CHEST PAIN<br/>Address: 191 FOUR MILE RD<br/>City: SHIPPEN<br/>Cross Streets: MINARD RD * S DIVIDING RIDGE RD<br/><br>Agency: EMPORIUM AMBULANCE<br/>9/11/2012 3:55:41 PM
(Elk County 911 Alerts) Inc Code: TRANSPORT<br/>Address: ERHC TO SHADYSIDE<br/>City: <br/><br/><br>Agency: ST MARYS AMB<br/>9/11/2012 4:33:35 PM
(Elk County 911 Alerts) Inc Code: TRANSPORT<br/>Address: ERHC TO FELT MNR<br/>City: <br/><br/><br>Agency: EMPORIUM AMBULANCE<br/>9/11/2012 4:35:09 PM
(Elk County 911 Alerts) Inc Code: TRANSPORT<br/>Address: BLS DRMC-E TO PATIENT<br/>City: <br/><br/><br>Agency: RIDGWAY AMBULANCE<br/>9/11/2012 4:51:28 PM
(Elk County 911 Alerts) Inc Code: FALLS<br/>Address: 144 MADISON ST<br/>City: ST_MARYS<br/>Cross Streets: WASHINGTON ST * BANK ST<br/><br>Agency: ST MARYS AMB<br/>9/11/2012 5:01:41 PM
(Elk County 911 Alerts) Inc Code: TRANSPORT<br/>Address: ERHC TO EMP<br/>City: <br/><br/><br>Agency: EMPORIUM AMBULANCE<br/>9/11/2012 6:27:22 PM
(Elk County 911 Alerts) Inc Code: TRANSPORT<br/>Address: ERHC TO DRMC W<br/>City: <br/><br/><br>Agency: ST MARYS AMB<br/>9/11/2012 6:40:29 PM
(Elk County 911 Alerts) Inc Code: TRANSFER/INTERFACILITY<br/>Address: 110 E 4TH ST<br/>City: EMPORIUM<br/>Cross Streets: S CHESTNUT ST * S WALNUT ST<br/><br>Agency: EMPORIUM AMBULANCE<br/>9/11/2012 7:03:23 PM
(Elk County 911 Alerts) Inc Code: FALLS<br/>Address: 94 LINCOLN ST<br/>City: RIDGWAY_B<br/>Cross Streets: SPRUCE ST * EUCLID AVE<br/><br>Agency: RIDGWAY AMBULANCE<br/>9/11/2012 8:42:07 PM
(Elk County 911 Alerts) Inc Code: TRANSPORT<br/>Address: erhc to felt manor<br/>City: <br/><br/><br>Agency: EMPORIUM AMBULANCE<br/>9/11/2012 9:01:24 PM
(Elk County 911 Alerts) Inc Code: FALLS<br/>Address: 195 MADISON ST<br/>City: ST_MARYS<br/>Cross Streets: TREMONT ST * ATLANTIC ST<br/><br>Agency: ST MARYS AMB<br/>9/12/2012 9:50:36 AM
(Elk County 911 Alerts) Inc Code: PHONE CALL<br/>Address: 240 MAIN ST<br/>City: RIDGWAY_B<br/>Cross Streets: COURT ST * S BROAD ST<br/><br>Agency: ELK COMPANY 4 FD<br/>9/12/2012 2:14:02 PM
(Elk County 911 Alerts) Inc Code: OVERDOSE/POISONING<br/>Address: 2981 MAPLE LN<br/>City: JONES<br/>Cross Streets: BUCK RD * SAM RD<br/><br>Agency: ST MARYS AMB<br/>9/12/2012 6:22:57 PM
(Elk County 911 Alerts) Inc Code: BREATHING PROBLEMS<br/>Address: 400 ROCK ST<br/>City: RIDGWAY_B<br/>Cross Streets: WILLIAMS ST<br/><br>Agency: RIDGWAY AMBULANCE<br/>9/12/2012 6:25:29 PM
(Elk County 911 Alerts) Inc Code: ALARMS-HIGH LIFE HAZARD<br/>Address: 426 WATER STREET EXT<br/>City: JOHNSBURG<br/>Cross Streets: WATER ST * VFW RD<br/><br>Agency: ST MARYS AMB<br/>9/12/2012 9:17:13 PM
(Elk County 911 Alerts) Inc Code: TRANSPORT<br/>Address: ERHC TO CHILDREN'S<br/>City: <br/><br/><br>Agency: ST MARYS AMB<br/>9/12/2012 11:45:13 PM

 */

public class PAElkCountyParserTest extends BaseParserTest {
  
  public PAElkCountyParserTest() {
    setParser(new PAElkCountyParser(), "ELK COUNTY", "PA");
  }
  
  @Test
  public void testElkCounty() {
    
    doTest("T1",
          "Inc: DIABETIC PROBLEMS Add: 890 BURNING WELL RD\nCity: JONES\nXSt: OLD KANE RD * ROCKY RUN RD\nAgency: ST MARYS AMB",
          "CALL:DIABETIC PROBLEMS",
          "ADDR:890 BURNING WELL RD",
          "CITY:JONES",
          "X:OLD KANE RD * ROCKY RUN RD",
          "SRC:ST MARYS AMB");

    doTest("T2",
          "Inc: FALLS Add: 185 CENTER ST\nCity: ST_MARYS\nXSt: N SAINT MARYS ST * MCGILL ST\nAgency: ST MARYS AMB", 
          "CALL:FALLS",
          "ADDR:185 CENTER ST",
          "CITY:ST MARYS",
          "X:N SAINT MARYS ST * MCGILL ST",
          "SRC:ST MARYS AMB");
    
    doTest("T3",
          "Inc: SICK PERSON Add: 352 STATE ST\nCity: ST_MARYS\nXSt: ANTHONY RD * RIDGWAY ST MARYS RD\nAgency: ST MARYS AMB", 
          "CALL:SICK PERSON",
          "ADDR:352 STATE ST",
          "CITY:ST MARYS",
          "X:ANTHONY RD * RIDGWAY ST MARYS RD",
          "SRC:ST MARYS AMB");
  }
  
  @Test
  public void testMikeHealy() {

    doTest("T1",
        "Inc: ELEC HAZ-ELECTRICAL HAZ-WATER Add: 1449 SHAWMUT RD \n" +
        "City: HORTON \n" +
        "XSt: ROUTE 219 * ROCKY LN \n" +
        "Agency: ELK COMPANY 1 FD \n\n" +
        "5/29/2012 4:03:58 PM",

        "CALL:ELEC HAZ-ELECTRICAL HAZ-WATER",
        "ADDR:1449 SHAWMUT RD",
        "CITY:HORTON",
        "X:ROUTE 219 * ROCKY LN",
        "SRC:ELK COMPANY 1 FD",
        "DATE:05/29/2012",
        "TIME:16:03:58");
   
  }
  
  @Test
  public void testActive911() {

    doTest("T1",
        "(Elk County 911 Alerts) Inc Code: FALLS<br/>Address: 759 JOHNSONBURG RD<br/>City: ST_MARYS<br/>Cross Streets: MAURUS ST * SHERRY RD<br/><br>Agency: ST MARYS AMB<br/>9/10/2012 4:40:17 PM",
        "CALL:FALLS",
        "ADDR:759 JOHNSONBURG RD",
        "CITY:ST MARYS",
        "X:MAURUS ST * SHERRY RD",
        "SRC:ST MARYS AMB",
        "DATE:09/10/2012",
        "TIME:16:40:17");

    doTest("T2",
        "(Elk County 911 Alerts) Inc Code: PUBLIC SERVICE<br/>Address: 600 MAURUS ST<br/>City: ST_MARYS<br/>Cross Streets: LOUIS ST * JOHNSONBURG RD<br/><br>Agency: ST MARYS AMB<br/>9/10/2012 5:17:55 PM",
        "CALL:PUBLIC SERVICE",
        "ADDR:600 MAURUS ST",
        "CITY:ST MARYS",
        "X:LOUIS ST * JOHNSONBURG RD",
        "SRC:ST MARYS AMB",
        "DATE:09/10/2012",
        "TIME:17:17:55");

    doTest("T3",
        "(Elk County 911 Alerts) Inc Code: SICK PERSON<br/>Address: 309 1ST AVE [JOHNSBURG]<br/>City: JOHNSBURG<br/>Cross Streets: SHORT ST * COBB ST<br/><br>Agency: ST MARYS AMB<br/>9/10/2012 5:37:05 PM",
        "CALL:SICK PERSON",
        "ADDR:309 1ST AVE [JOHNSBURG]",
        "CITY:JOHNSBURG",
        "X:SHORT ST * COBB ST",
        "SRC:ST MARYS AMB",
        "DATE:09/10/2012",
        "TIME:17:37:05");

    doTest("T4",
        "(Elk County 911 Alerts) Inc Code: TRAFFIC ACCIDENT/OVERRIDE<br/>Address: W MAIN ST and HAYES RD<br/>City: FOX<br/>Cross Streets: HAYES RD * W MAIN STREET EXT<br/><br>Agency: ST MARYS AMB<br/>9/10/2012 6:31:40 PM",
        "CALL:TRAFFIC ACCIDENT/OVERRIDE",
        "ADDR:W MAIN ST and HAYES RD",
        "MADDR:W MAIN ST & HAYES RD",
        "CITY:FOX",
        "X:HAYES RD * W MAIN STREET EXT",
        "SRC:ST MARYS AMB",
        "DATE:09/10/2012",
        "TIME:18:31:40");

    doTest("T5",
        "(Elk County 911 Alerts) Inc Code: PREGNANCY/CHILDBIRTH<br/>Address: 217 POWERS AVE<br/>City: JOHNSBURG<br/>Cross Streets: E CENTER ST * JOHNSONBURG RD<br/><br>Agency: ST MARYS AMB<br/>9/11/2012 12:16:13 AM",
        "CALL:PREGNANCY/CHILDBIRTH",
        "ADDR:217 POWERS AVE",
        "CITY:JOHNSBURG",
        "X:E CENTER ST * JOHNSONBURG RD",
        "SRC:ST MARYS AMB",
        "DATE:09/11/2012",
        "TIME:00:16:13");

    doTest("T6",
        "(Elk County 911 Alerts) Inc Code: SEIZURES<br/>Address: 40 PETERS RD<br/>City: HORTON<br/>Cross Streets: DONAHUE RD<br/><br>Agency: RIDGWAY AMBULANCE<br/>9/11/2012 12:17:39 AM",
        "CALL:SEIZURES",
        "ADDR:40 PETERS RD",
        "CITY:HORTON",
        "X:DONAHUE RD",
        "SRC:RIDGWAY AMBULANCE",
        "DATE:09/11/2012",
        "TIME:00:17:39");

    doTest("T7",
        "(Elk County 911 Alerts) Inc Code: TRANSPORT<br/>Address: ERHC TO DRMC-E<br/>City: <br/><br/><br>Agency: EMPORIUM AMBULANCE<br/>9/11/2012 12:20:28 AM",
        "CALL:TRANSPORT",
        "ADDR:ERHC TO DRMC-E",
        "SRC:EMPORIUM AMBULANCE",
        "DATE:09/11/2012",
        "TIME:00:20:28");

    doTest("T8",
        "(Elk County 911 Alerts) Inc Code: TRANSFER/INTERFACILITY<br/>Address: 785 JOHNSONBURG RD<br/>City: ST_MARYS<br/>Cross Streets: SHERRY RD * POPE RD<br/><br>Agency: ST MARYS AMB<br/>9/11/2012 11:34:53 AM",
        "CALL:TRANSFER/INTERFACILITY",
        "ADDR:785 JOHNSONBURG RD",
        "CITY:ST MARYS",
        "X:SHERRY RD * POPE RD",
        "SRC:ST MARYS AMB",
        "DATE:09/11/2012",
        "TIME:11:34:53");

    doTest("T9",
        "(Elk County 911 Alerts) Inc Code: BREATHING PROBLEMS<br/>Address: 515 N BROAD ST<br/>City: RIDGWAY_B<br/>Cross Streets: WILLIAMS ST * RIDGWAY JOHNSONBURG RD<br/><br>Agency: RIDGWAY AMBULANCE<br/>9/11/2012 11:58:35 AM",
        "CALL:BREATHING PROBLEMS",
        "ADDR:515 N BROAD ST",
        "CITY:RIDGEWAY",
        "X:WILLIAMS ST * RIDGWAY JOHNSONBURG RD",
        "SRC:RIDGWAY AMBULANCE",
        "DATE:09/11/2012",
        "TIME:11:58:35");

    doTest("T10",
        "(Elk County 911 Alerts) Inc Code: UNCONSCIOUS/FAINTING<br/>Address: BROAD<br/>City: <br/><br/><br>Agency: ST MARYS AMB<br/>9/11/2012 12:30:50 PM",
        "CALL:UNCONSCIOUS/FAINTING",
        "ADDR:BROAD",
        "SRC:ST MARYS AMB",
        "DATE:09/11/2012",
        "TIME:12:30:50");

    doTest("T11",
        "(Elk County 911 Alerts) Inc Code: UNCONSCIOUS/FAINTING<br/>Address: BROAD<br/>City: <br/><br/><br>Agency: EMPORIUM AMBULANCE<br/>9/11/2012 12:30:56 PM",
        "CALL:UNCONSCIOUS/FAINTING",
        "ADDR:BROAD",
        "SRC:EMPORIUM AMBULANCE",
        "DATE:09/11/2012",
        "TIME:12:30:56");

    doTest("T12",
        "(Elk County 911 Alerts) Inc Code: TRANSPORT<br/>Address: RES TO DRMC WEST<br/>City: <br/><br/><br>Agency: RIDGWAY AMBULANCE<br/>9/11/2012 1:28:56 PM",
        "CALL:TRANSPORT",
        "ADDR:RES TO DRMC WEST",
        "SRC:RIDGWAY AMBULANCE",
        "DATE:09/11/2012",
        "TIME:13:28:56");

    doTest("T13",
        "(Elk County 911 Alerts) Inc Code: SICK PERSON<br/>Address: 107 FLOYD LN<br/>City: GROVE<br/>Cross Streets: JERRY RUN RD<br/><br>Agency: EMPORIUM AMBULANCE<br/>9/11/2012 1:43:56 PM",
        "CALL:SICK PERSON",
        "ADDR:107 FLOYD LN",
        "CITY:GROVE",
        "X:JERRY RUN RD",
        "SRC:EMPORIUM AMBULANCE",
        "DATE:09/11/2012",
        "TIME:13:43:56");

    doTest("T14",
        "(Elk County 911 Alerts) Inc Code: STRUCTURE FIRE-RESIDENT SINGLE<br/>Address: 129 EAST AVE<br/>City: RIDGWAY_B<br/>Cross Streets: LONG ST * SOUTH ST<br/><br>Agency: ELK COMPANY 4 FD<br/>9/11/2012 1:44:01 PM",
        "CALL:STRUCTURE FIRE-RESIDENT SINGLE",
        "ADDR:129 EAST AVE",
        "CITY:RIDGEWAY",
        "X:LONG ST * SOUTH ST",
        "SRC:ELK COMPANY 4 FD",
        "DATE:09/11/2012",
        "TIME:13:44:01");

    doTest("T15",
        "(Elk County 911 Alerts) Inc Code: STRUCTURE FIRE-RESIDENT SINGLE<br/>Address: 129 EAST AVE<br/>City: RIDGWAY_B<br/>Cross Streets: LONG ST * SOUTH ST<br/><br>Agency: RIDGWAY AMBULANCE<br/>9/11/2012 1:46:16 PM",
        "CALL:STRUCTURE FIRE-RESIDENT SINGLE",
        "ADDR:129 EAST AVE",
        "CITY:RIDGEWAY",
        "X:LONG ST * SOUTH ST",
        "SRC:RIDGWAY AMBULANCE",
        "DATE:09/11/2012",
        "TIME:13:46:16");

    doTest("T16",
        "(Elk County 911 Alerts) Inc Code: CHEST PAIN<br/>Address: 191 FOUR MILE RD<br/>City: SHIPPEN<br/>Cross Streets: MINARD RD * S DIVIDING RIDGE RD<br/><br>Agency: EMPORIUM AMBULANCE<br/>9/11/2012 3:55:41 PM",
        "CALL:CHEST PAIN",
        "ADDR:191 FOUR MILE RD",
        "CITY:SHIPPEN",
        "X:MINARD RD * S DIVIDING RIDGE RD",
        "SRC:EMPORIUM AMBULANCE",
        "DATE:09/11/2012",
        "TIME:15:55:41");

    doTest("T17",
        "(Elk County 911 Alerts) Inc Code: TRANSPORT<br/>Address: ERHC TO SHADYSIDE<br/>City: <br/><br/><br>Agency: ST MARYS AMB<br/>9/11/2012 4:33:35 PM",
        "CALL:TRANSPORT",
        "ADDR:ERHC TO SHADYSIDE",
        "SRC:ST MARYS AMB",
        "DATE:09/11/2012",
        "TIME:16:33:35");

    doTest("T18",
        "(Elk County 911 Alerts) Inc Code: TRANSPORT<br/>Address: ERHC TO FELT MNR<br/>City: <br/><br/><br>Agency: EMPORIUM AMBULANCE<br/>9/11/2012 4:35:09 PM",
        "CALL:TRANSPORT",
        "ADDR:ERHC TO FELT MNR",
        "SRC:EMPORIUM AMBULANCE",
        "DATE:09/11/2012",
        "TIME:16:35:09");

    doTest("T19",
        "(Elk County 911 Alerts) Inc Code: TRANSPORT<br/>Address: BLS DRMC-E TO PATIENT<br/>City: <br/><br/><br>Agency: RIDGWAY AMBULANCE<br/>9/11/2012 4:51:28 PM",
        "CALL:TRANSPORT",
        "ADDR:BLS DRMC-E TO PATIENT",
        "SRC:RIDGWAY AMBULANCE",
        "DATE:09/11/2012",
        "TIME:16:51:28");

    doTest("T20",
        "(Elk County 911 Alerts) Inc Code: FALLS<br/>Address: 144 MADISON ST<br/>City: ST_MARYS<br/>Cross Streets: WASHINGTON ST * BANK ST<br/><br>Agency: ST MARYS AMB<br/>9/11/2012 5:01:41 PM",
        "CALL:FALLS",
        "ADDR:144 MADISON ST",
        "CITY:ST MARYS",
        "X:WASHINGTON ST * BANK ST",
        "SRC:ST MARYS AMB",
        "DATE:09/11/2012",
        "TIME:17:01:41");

    doTest("T21",
        "(Elk County 911 Alerts) Inc Code: TRANSPORT<br/>Address: ERHC TO EMP<br/>City: <br/><br/><br>Agency: EMPORIUM AMBULANCE<br/>9/11/2012 6:27:22 PM",
        "CALL:TRANSPORT",
        "ADDR:ERHC TO EMP",
        "SRC:EMPORIUM AMBULANCE",
        "DATE:09/11/2012",
        "TIME:18:27:22");

    doTest("T22",
        "(Elk County 911 Alerts) Inc Code: TRANSPORT<br/>Address: ERHC TO DRMC W<br/>City: <br/><br/><br>Agency: ST MARYS AMB<br/>9/11/2012 6:40:29 PM",
        "CALL:TRANSPORT",
        "ADDR:ERHC TO DRMC W",
        "SRC:ST MARYS AMB",
        "DATE:09/11/2012",
        "TIME:18:40:29");

    doTest("T23",
        "(Elk County 911 Alerts) Inc Code: TRANSFER/INTERFACILITY<br/>Address: 110 E 4TH ST<br/>City: EMPORIUM<br/>Cross Streets: S CHESTNUT ST * S WALNUT ST<br/><br>Agency: EMPORIUM AMBULANCE<br/>9/11/2012 7:03:23 PM",
        "CALL:TRANSFER/INTERFACILITY",
        "ADDR:110 E 4TH ST",
        "CITY:EMPORIUM",
        "X:S CHESTNUT ST * S WALNUT ST",
        "SRC:EMPORIUM AMBULANCE",
        "DATE:09/11/2012",
        "TIME:19:03:23");

    doTest("T24",
        "(Elk County 911 Alerts) Inc Code: FALLS<br/>Address: 94 LINCOLN ST<br/>City: RIDGWAY_B<br/>Cross Streets: SPRUCE ST * EUCLID AVE<br/><br>Agency: RIDGWAY AMBULANCE<br/>9/11/2012 8:42:07 PM",
        "CALL:FALLS",
        "ADDR:94 LINCOLN ST",
        "CITY:RIDGEWAY",
        "X:SPRUCE ST * EUCLID AVE",
        "SRC:RIDGWAY AMBULANCE",
        "DATE:09/11/2012",
        "TIME:20:42:07");

    doTest("T25",
        "(Elk County 911 Alerts) Inc Code: TRANSPORT<br/>Address: erhc to felt manor<br/>City: <br/><br/><br>Agency: EMPORIUM AMBULANCE<br/>9/11/2012 9:01:24 PM",
        "CALL:TRANSPORT",
        "ADDR:erhc to felt manor",
        "SRC:EMPORIUM AMBULANCE",
        "DATE:09/11/2012",
        "TIME:21:01:24");

    doTest("T26",
        "(Elk County 911 Alerts) Inc Code: FALLS<br/>Address: 195 MADISON ST<br/>City: ST_MARYS<br/>Cross Streets: TREMONT ST * ATLANTIC ST<br/><br>Agency: ST MARYS AMB<br/>9/12/2012 9:50:36 AM",
        "CALL:FALLS",
        "ADDR:195 MADISON ST",
        "CITY:ST MARYS",
        "X:TREMONT ST * ATLANTIC ST",
        "SRC:ST MARYS AMB",
        "DATE:09/12/2012",
        "TIME:09:50:36");

    doTest("T27",
        "(Elk County 911 Alerts) Inc Code: PHONE CALL<br/>Address: 240 MAIN ST<br/>City: RIDGWAY_B<br/>Cross Streets: COURT ST * S BROAD ST<br/><br>Agency: ELK COMPANY 4 FD<br/>9/12/2012 2:14:02 PM",
        "CALL:PHONE CALL",
        "ADDR:240 MAIN ST",
        "CITY:RIDGEWAY",
        "X:COURT ST * S BROAD ST",
        "SRC:ELK COMPANY 4 FD",
        "DATE:09/12/2012",
        "TIME:14:14:02");

    doTest("T28",
        "(Elk County 911 Alerts) Inc Code: OVERDOSE/POISONING<br/>Address: 2981 MAPLE LN<br/>City: JONES<br/>Cross Streets: BUCK RD * SAM RD<br/><br>Agency: ST MARYS AMB<br/>9/12/2012 6:22:57 PM",
        "CALL:OVERDOSE/POISONING",
        "ADDR:2981 MAPLE LN",
        "CITY:JONES",
        "X:BUCK RD * SAM RD",
        "SRC:ST MARYS AMB",
        "DATE:09/12/2012",
        "TIME:18:22:57");

    doTest("T29",
        "(Elk County 911 Alerts) Inc Code: BREATHING PROBLEMS<br/>Address: 400 ROCK ST<br/>City: RIDGWAY_B<br/>Cross Streets: WILLIAMS ST<br/><br>Agency: RIDGWAY AMBULANCE<br/>9/12/2012 6:25:29 PM",
        "CALL:BREATHING PROBLEMS",
        "ADDR:400 ROCK ST",
        "CITY:RIDGEWAY",
        "X:WILLIAMS ST",
        "SRC:RIDGWAY AMBULANCE",
        "DATE:09/12/2012",
        "TIME:18:25:29");

    doTest("T30",
        "(Elk County 911 Alerts) Inc Code: ALARMS-HIGH LIFE HAZARD<br/>Address: 426 WATER STREET EXT<br/>City: JOHNSBURG<br/>Cross Streets: WATER ST * VFW RD<br/><br>Agency: ST MARYS AMB<br/>9/12/2012 9:17:13 PM",
        "CALL:ALARMS-HIGH LIFE HAZARD",
        "ADDR:426 WATER STREET EXT",
        "MADDR:426 WATER STREET",
        "CITY:JOHNSBURG",
        "X:WATER ST * VFW RD",
        "SRC:ST MARYS AMB",
        "DATE:09/12/2012",
        "TIME:21:17:13");

    doTest("T31",
        "(Elk County 911 Alerts) Inc Code: TRANSPORT<br/>Address: ERHC TO CHILDREN'S<br/>City: <br/><br/><br>Agency: ST MARYS AMB<br/>9/12/2012 11:45:13 PM",
        "CALL:TRANSPORT",
        "ADDR:ERHC TO CHILDREN'S",
        "SRC:ST MARYS AMB",
        "DATE:09/12/2012",
        "TIME:23:45:13");

  }
  
  public static void main(String[] args) {
    new PAElkCountyParserTest().generateTests("T1");
  }
}