package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
York County, PA
Contact: "Freistat, Brandon" <brandon.freistat@fairviewfire.net>
Sender: messaging@iamresponding.com

(Station 68) : 203 LOCUST DR \n  FAIRVIEW TWP\n  \nLONGVIEW AVE / PLEASANT VIEW RD\nDistrict: 68-02\n\n    FIRE STRUCT RESID\nUnits Sent: 2\nFIRESTA68, 52-03
(Station 68) : 378 PLEASANT VIEW RD \n  FAIRVIEW TWP\n  \nGURTNER RD / LANE\nDistrict: 68-02\n\n    FIRE STRUCT RESID\nUnits Sent: 2\nFIRESTA68, 52-12 \n\n   
(Station 68) : 6000 LEWISBERRY RD \nAdditional Location Information:BLK\n  CONEWAGO TWP\n  \nBREMER RD / ANDERSONTOWN RD\nCOPENHAFFER RD\nDistrict: 26-09

Contact: Matthew Russ <smokeater841@gmail.com>
Sender: messaging@iamresponding.com
Subject:Station 41\n  752 OLD COMMONS RD \r\n   LOWER WINDSOR TWP\r\n  \r\nWINTERS RD / ADAIR RD\r\n    3638\r\n     FIRE STRUCT ENTRAP\r\n\r\n\r
Subject:Station 41\n  295 FRYSVILLE RD \r\n   HALLAM BORO\r\n  \r\nPRINCE MHP / VALLEY ACRES RD\r\n    5813\r\n     RESC WATER CL 2\r\n\r\n\r
Subject:Station 41\n  340 HELLAM ST \r\nCommon Name  TURKEY HILL WRIGHTSVILLE BORO\r\n   \r\n\r\n     FIRE WIRES\r\n\r\n\r
Subject:Station 41\n  1675 NEW BRIDGEVILLE RD \r\n   CHANCEFORD TWP\r\n  \r\nWHITE OAK RD / BURKHOLDER RD\r\nFURNACE RD\r\n    6294\r\n     FIR\r
Subject:Station 41\n  2266 SPANGLER CIR \r\n   SPRINGETTSBURY TWP\r\n  \r\nPOSES PL / ST JOHNS CT\r\n    6277\r\n     FIRE STRUCT RESID\r\n\r\n\r
Subject:Station 41\n  1972 W  PHILADELPHIA ST \r\nCommon Name  STOUGH DENTAL LAB\r\n   \r\n\r\n     FIRE STRUCT RESID\r\n\r\n\r
Subject:Station 41\n  163 COOL CREEK MANOR DR \r\n\3sHELLAM TWP\r\n  \r\nKENNETH WAY / SETH CT\r\n    3134\r\n     SICK PERSON CL 1\r\n\r\n\r

Contact: Active911
Agency name: Wrightsville Fire Rescue 41
Location: Wrightsville, PA, United States
Sender: messaging@iamresponding.com

(Station 41)   329 WALNUT ST \n   WRIGHTSVILLE BORO\n  \nN 3RD ST / N 4TH ST\nPhone  \n\n     PUBLIC SERVICE\n 
(Station 41)   221 HELLAM ST \n   WRIGHTSVILLE BORO\n  \nBARNES AVE / S 2ND ST\n N 2ND ST\nPhone  \n\n     FALLS CL 2\n 
(Station 41)   15 W WALNUT ST \n   LANCASTER COUNTY\n  \n \n     FIRE AFA HIGH RISK\n 
(Station 41)    LINCOLN HWY/ ACCOMAC RD\n   HELLAM TWP\n  \n    5793\n     DEBRIS REMOVAL\n 
(Station 41)   791 KREUTZ CREEK RD \n   HELLAM TWP\n  \nFAHRINGER DR / KRUETZ CREEK RD\n ORE BANK RD\n    5495\n     VEH ACC INJ CL 2\n 
(Station 41)   391 VINE ST \n   WRIGHTSVILLE BORO\n  \nN 4TH ST / N 3RD ST\n PAW PAW ALY\n    5491\n     CHEST PAIN CL 1\n 
(Station 41)   1809 LONG LEVEL RD \nCommon Name  LONG LEVEL MARINA\n   \n\n     FIRE POLICE\n 
(Station 41)   21 E MARKET ST \n   LANCASTER COUNTY\n  \n \n     FIRE STRUCT HR\n 
(Station 41)   400 N  FRONT ST \n   WRIGHTSVILLE BORO\n  \nLIMEKILN AVE / WALNUT ST\n    4044\n     FIRE VEHICLE \n 
(Station 41)    LONG LEVEL RD/ HILTS RD\n   LOWER WINDSOR TWP\n  \n    3687\n     VEH ACC INJ CL 1\n 
(Station 41)   753 S  FRONT ST \n   WRIGHTSVILLE BORO\n  \nLOCKWOOD RD / WILLOW ST\n    3643\n     VEH ACC OT NO INJ \n 
(Station 41)    RTE 30 WB/ HELLAM EXIT\n   HELLAM TWP\n  \n    3596\n     VEH ACC UNK INJ\n 
(Station 41)    RTE 30 EB/ SHOE HOUSE RD\nCommon Name  VMS RTE 30\n   \n\n     FIRE POLICE\n 
(Station 41)   90 CHEROKEE DR \n   LOWER WINDSOR TWP\n  \nCHEYENNE DR / CHEYENNE DR\n    3110\n     FIRE STRUCT RESID\n 
(Station 41)   205 BROOKLYN DR \n   HELLAM TWP\n  \nCLOVER DR / CONCORD AVE\n    2583\n     SEIZURES CL 1\n 
(Station 41)   3201 E  MARKET ST \nCommon Name  LAFAYETTE PLAZA SPRINGETTSBURY TWP\n   \n\n     FIRE STRUCT HR\n 
(Station 41)   RTE 30 WB/WRIGHTS FERRY BRIDGE \n   LANCASTER COUNTY\n  \n \n     VEH ACC INJ CL 1\n 
(Station 41)    MT PISGAH RD/ DUCKTOWN RD\n   HELLAM TWP\n  \n    236\n     VEH ACC ENTRAP\n 

*/

public class PAYorkCountyCParserTest extends BaseParserTest {
  
  public PAYorkCountyCParserTest() {
    setParser(new PAYorkCountyCParser(), "YORK COUNTY", "PA");
  }
  
  @Test
  public void testParser1() {

    doTest("T1",
        "(Station 68) : 203 LOCUST DR \n" +
        "  FAIRVIEW TWP\n" +
        "  \n" +
        "LONGVIEW AVE / PLEASANT VIEW RD\n" +
        "District: 68-02\n\n" +
        "    FIRE STRUCT RESID\n" +
        "Units Sent: 2\n" +
        "FIRESTA68, 52-03",

        "SRC:Station 68",
        "ADDR:203 LOCUST DR",
        "CITY:FAIRVIEW TWP",
        "X:LONGVIEW AVE / PLEASANT VIEW RD",
        "MAP:68-02",
        "CALL:FIRE STRUCT RESID",
        "UNIT:FIRESTA68, 52-03");

    doTest("T2",
        "(Station 68) : 378 PLEASANT VIEW RD \n" +
        "  FAIRVIEW TWP\n" +
        "  \n" +
        "GURTNER RD / LANE\n" +
        "District: 68-02\n\n" +
        "    FIRE STRUCT RESID\n" +
        "Units Sent: 2\n" +
        "FIRESTA68, 52-12 \n\n" +
        "   ",

        "SRC:Station 68",
        "ADDR:378 PLEASANT VIEW RD",
        "CITY:FAIRVIEW TWP",
        "X:GURTNER RD / LANE",
        "MAP:68-02",
        "CALL:FIRE STRUCT RESID",
        "UNIT:FIRESTA68, 52-12");

    doTest("T3",
        "(Station 68) : 6000 LEWISBERRY RD \n" +
        "Additional Location Information:BLK\n" +
        "  CONEWAGO TWP\n" +
        "  \n" +
        "BREMER RD / ANDERSONTOWN RD\n" +
        "COPENHAFFER RD\n" +
        "District: 26-09",

        "SRC:Station 68",
        "ADDR:6000 LEWISBERRY RD",
        "PLACE:BLK",
        "CITY:CONEWAGO TWP",
        "X:BREMER RD / ANDERSONTOWN RD & COPENHAFFER RD",
        "MAP:26-09");

  }
  
  @Test
  public void testMatthewRuss() {

    doTest("T1",
        "Subject:Station 41\n  752 OLD COMMONS RD \r\n   LOWER WINDSOR TWP\r\n  \r\nWINTERS RD / ADAIR RD\r\n    3638\r\n     FIRE STRUCT ENTRAP\r\n\r\n\r",
        "SRC:Station 41",
        "ADDR:752 OLD COMMONS RD",
        "CITY:LOWER WINDSOR TWP",
        "X:WINTERS RD / ADAIR RD",
        "MAP:3638",
        "CALL:FIRE STRUCT ENTRAP");

    doTest("T2",
        "Subject:Station 41\n  295 FRYSVILLE RD \r\n   HALLAM BORO\r\n  \r\nPRINCE MHP / VALLEY ACRES RD\r\n    5813\r\n     RESC WATER CL 2\r\n\r\n\r",
        "SRC:Station 41",
        "ADDR:295 FRYSVILLE RD",
        "CITY:HALLAM",
        "X:PRINCE MHP / VALLEY ACRES RD",
        "MAP:5813",
        "CALL:RESC WATER CL 2");

    doTest("T3",
        "Subject:Station 41\n  340 HELLAM ST \r\nCommon Name  TURKEY HILL WRIGHTSVILLE BORO\r\n   \r\n\r\n     FIRE WIRES\r\n\r\n\r",
        "SRC:Station 41",
        "ADDR:340 HELLAM ST",
        "PLACE:TURKEY HILL",
        "CITY:WRIGHTSVILLE",
        "CALL:FIRE WIRES");

    doTest("T4",
        "Subject:Station 41\n" +
        "  1675 NEW BRIDGEVILLE RD \r\n" +
        "   CHANCEFORD TWP\r\n" +
        "  \r\n" +
        "WHITE OAK RD / BURKHOLDER RD\r\n" +
        "FURNACE RD\r\n" +
        "    6294\r\n" +
        "     FIR\r",

        "SRC:Station 41",
        "ADDR:1675 NEW BRIDGEVILLE RD",
        "CITY:CHANCEFORD TWP",
        "X:WHITE OAK RD / BURKHOLDER RD & FURNACE RD",
        "MAP:6294",
        "CALL:FIR");

    doTest("T5",
        "Subject:Station 41\n  2266 SPANGLER CIR \r\n   SPRINGETTSBURY TWP\r\n  \r\nPOSES PL / ST JOHNS CT\r\n    6277\r\n     FIRE STRUCT RESID\r\n\r\n\r",
        "SRC:Station 41",
        "ADDR:2266 SPANGLER CIR",
        "CITY:SPRINGETTSBURY TWP",
        "X:POSES PL / ST JOHNS CT",
        "MAP:6277",
        "CALL:FIRE STRUCT RESID");

    doTest("T6",
        "Subject:Station 41\n  1972 W  PHILADELPHIA ST \r\nCommon Name  STOUGH DENTAL LAB\r\n   \r\n\r\n     FIRE STRUCT RESID\r\n\r\n\r",
        "SRC:Station 41",
        "ADDR:1972 W  PHILADELPHIA ST",
        "PLACE:STOUGH DENTAL LAB",
        "CALL:FIRE STRUCT RESID");

    doTest("T7",
        "Subject:Station 41\n  163 COOL CREEK MANOR DR \r\nHELLAM TWP\r\n  \r\nKENNETH WAY / SETH CT\r\n    3134\r\n     SICK PERSON CL 1\r\n\r\n\r",
        "SRC:Station 41",
        "ADDR:163 COOL CREEK MANOR DR",
        "CITY:HELLAM TWP",
        "X:KENNETH WAY / SETH CT",
        "MAP:3134",
        "CALL:SICK PERSON CL 1");

  }
  
  @Test
  public void testWrightsvilleFireRescue41() {

    doTest("T1",
        "(Station 41)   329 WALNUT ST \n   WRIGHTSVILLE BORO\n  \nN 3RD ST / N 4TH ST\nPhone  \n\n     PUBLIC SERVICE\n ",
        "SRC:Station 41",
        "ADDR:329 WALNUT ST",
        "CITY:WRIGHTSVILLE",
        "X:N 3RD ST / N 4TH ST",
        "CALL:PUBLIC SERVICE");

    doTest("T2",
        "(Station 41)   221 HELLAM ST \n   WRIGHTSVILLE BORO\n  \nBARNES AVE / S 2ND ST\n N 2ND ST\nPhone  \n\n     FALLS CL 2\n ",
        "SRC:Station 41",
        "ADDR:221 HELLAM ST",
        "CITY:WRIGHTSVILLE",
        "X:BARNES AVE / S 2ND ST & N 2ND ST",
        "CALL:FALLS CL 2");

    doTest("T3",
        "(Station 41)   15 W WALNUT ST \n   LANCASTER COUNTY\n  \n \n     FIRE AFA HIGH RISK\n ",
        "SRC:Station 41",
        "ADDR:15 W WALNUT ST",
        "CITY:LANCASTER COUNTY",
        "CALL:FIRE AFA HIGH RISK");

    doTest("T4",
        "(Station 41)    LINCOLN HWY/ ACCOMAC RD\n   HELLAM TWP\n  \n    5793\n     DEBRIS REMOVAL\n ",
        "SRC:Station 41",
        "ADDR:LINCOLN HWY & ACCOMAC RD",
        "CITY:HELLAM TWP",
        "MAP:5793",
        "CALL:DEBRIS REMOVAL");

    doTest("T5",
        "(Station 41)   791 KREUTZ CREEK RD \n   HELLAM TWP\n  \nFAHRINGER DR / KRUETZ CREEK RD\n ORE BANK RD\n    5495\n     VEH ACC INJ CL 2\n ",
        "SRC:Station 41",
        "ADDR:791 KREUTZ CREEK RD",
        "CITY:HELLAM TWP",
        "X:FAHRINGER DR / KRUETZ CREEK RD & ORE BANK RD",
        "MAP:5495",
        "CALL:VEH ACC INJ CL 2");

    doTest("T6",
        "(Station 41)   391 VINE ST \n   WRIGHTSVILLE BORO\n  \nN 4TH ST / N 3RD ST\n PAW PAW ALY\n    5491\n     CHEST PAIN CL 1\n ",
        "SRC:Station 41",
        "ADDR:391 VINE ST",
        "CITY:WRIGHTSVILLE",
        "X:N 4TH ST / N 3RD ST & PAW PAW ALY",
        "MAP:5491",
        "CALL:CHEST PAIN CL 1");

    doTest("T7",
        "(Station 41)   1809 LONG LEVEL RD \nCommon Name  LONG LEVEL MARINA\n   \n\n     FIRE POLICE\n ",
        "SRC:Station 41",
        "ADDR:1809 LONG LEVEL RD",
        "PLACE:LONG LEVEL MARINA",
        "CALL:FIRE POLICE");

    doTest("T8",
        "(Station 41)   21 E MARKET ST \n   LANCASTER COUNTY\n  \n \n     FIRE STRUCT HR\n ",
        "SRC:Station 41",
        "ADDR:21 E MARKET ST",
        "CITY:LANCASTER COUNTY",
        "CALL:FIRE STRUCT HR");

    doTest("T9",
        "(Station 41)   400 N  FRONT ST \n   WRIGHTSVILLE BORO\n  \nLIMEKILN AVE / WALNUT ST\n    4044\n     FIRE VEHICLE \n ",
        "SRC:Station 41",
        "ADDR:400 N  FRONT ST",
        "CITY:WRIGHTSVILLE",
        "X:LIMEKILN AVE / WALNUT ST",
        "MAP:4044",
        "CALL:FIRE VEHICLE");

    doTest("T10",
        "(Station 41)    LONG LEVEL RD/ HILTS RD\n   LOWER WINDSOR TWP\n  \n    3687\n     VEH ACC INJ CL 1\n ",
        "SRC:Station 41",
        "ADDR:LONG LEVEL RD & HILTS RD",
        "CITY:LOWER WINDSOR TWP",
        "MAP:3687",
        "CALL:VEH ACC INJ CL 1");

    doTest("T11",
        "(Station 41)   753 S  FRONT ST \n   WRIGHTSVILLE BORO\n  \nLOCKWOOD RD / WILLOW ST\n    3643\n     VEH ACC OT NO INJ \n ",
        "SRC:Station 41",
        "ADDR:753 S  FRONT ST",
        "CITY:WRIGHTSVILLE",
        "X:LOCKWOOD RD / WILLOW ST",
        "MAP:3643",
        "CALL:VEH ACC OT NO INJ");

    doTest("T12",
        "(Station 41)    RTE 30 WB/ HELLAM EXIT\n   HELLAM TWP\n  \n    3596\n     VEH ACC UNK INJ\n ",
        "SRC:Station 41",
        "ADDR:RTE 30 WB & HELLAM EXIT",
        "MADDR:RTE 30 & HELLAM EXIT",
        "CITY:HELLAM TWP",
        "MAP:3596",
        "CALL:VEH ACC UNK INJ");

    doTest("T13",
        "(Station 41)    RTE 30 EB/ SHOE HOUSE RD\nCommon Name  VMS RTE 30\n   \n\n     FIRE POLICE\n ",
        "SRC:Station 41",
        "ADDR:RTE 30 EB & SHOE HOUSE RD",
        "MADDR:RTE 30 & SHOE HOUSE RD",
        "PLACE:VMS RTE 30",
        "CALL:FIRE POLICE");

    doTest("T14",
        "(Station 41)   90 CHEROKEE DR \n   LOWER WINDSOR TWP\n  \nCHEYENNE DR / CHEYENNE DR\n    3110\n     FIRE STRUCT RESID\n ",
        "SRC:Station 41",
        "ADDR:90 CHEROKEE DR",
        "CITY:LOWER WINDSOR TWP",
        "X:CHEYENNE DR / CHEYENNE DR",
        "MAP:3110",
        "CALL:FIRE STRUCT RESID");

    doTest("T15",
        "(Station 41)   205 BROOKLYN DR \n   HELLAM TWP\n  \nCLOVER DR / CONCORD AVE\n    2583\n     SEIZURES CL 1\n ",
        "SRC:Station 41",
        "ADDR:205 BROOKLYN DR",
        "CITY:HELLAM TWP",
        "X:CLOVER DR / CONCORD AVE",
        "MAP:2583",
        "CALL:SEIZURES CL 1");

    doTest("T16",
        "(Station 41)   3201 E  MARKET ST \nCommon Name  LAFAYETTE PLAZA SPRINGETTSBURY TWP\n   \n\n     FIRE STRUCT HR\n ",
        "SRC:Station 41",
        "ADDR:3201 E  MARKET ST",
        "PLACE:LAFAYETTE PLAZA",
        "CITY:SPRINGETTSBURY TWP",
        "CALL:FIRE STRUCT HR");

    doTest("T17",
        "(Station 41)   RTE 30 WB/WRIGHTS FERRY BRIDGE \n   LANCASTER COUNTY\n  \n \n     VEH ACC INJ CL 1\n ",
        "SRC:Station 41",
        "ADDR:RTE 30 WB & WRIGHTS FERRY BRIDGE",
        "MADDR:RTE 30 & WRIGHTS FERRY BRIDGE",
        "CITY:LANCASTER COUNTY",
        "CALL:VEH ACC INJ CL 1");

    doTest("T18",
        "(Station 41)    MT PISGAH RD/ DUCKTOWN RD\n   HELLAM TWP\n  \n    236\n     VEH ACC ENTRAP\n ",
        "SRC:Station 41",
        "ADDR:MT PISGAH RD & DUCKTOWN RD",
        "CITY:HELLAM TWP",
        "MAP:236",
        "CALL:VEH ACC ENTRAP");
  }
  
  public static void main(String[] args) {
    new PAYorkCountyCParserTest().generateTests("T1");
  }
}
