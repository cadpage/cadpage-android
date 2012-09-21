package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class OHShelbyCountyParserTest extends BaseParserTest {
  
  public OHShelbyCountyParserTest() {
    setParser(new OHShelbyCountyParser(), "SHELBY COUNTY", "OH");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "11-005105|28 - DRO|CAR CRASHED INTO WATER@11 WATER ST",
        "ID:11-005105",
        "CALL:28 - DRO",
        "INFO:CAR CRASHED INTO WATER",
        "ADDR:11 WATER ST");

    doTest("T2",
        "11-008684|11:09:00|:28 - SF|MICROWAVE ON FIRE @ 301 ELIZABETH ST RUSSIA BETW FIRST ST & CUL DE SAC|PHLIPOT",
        "ID:11-008684",
        "TIME:11:09:00",
        "CALL:28 - SF",
        "INFO:MICROWAVE ON FIRE",
        "ADDR:301 ELIZABETH ST",
        "CITY:RUSSIA",
        "X:FIRST ST & CUL DE SAC",
        "NAME:PHLIPOT");

    doTest("T3",
        "11-008838|05:35:00|:28 - MIS|UKNOWN TYPE FIRE ON EAST SIDE OF ROAD NORTH OF CARDO NEAR LOY RD @ 8000-B SR 66 FT LORAMIE BETW LOY RD & BASINBURG RD|",
        "ID:11-008838",
        "TIME:05:35:00",
        "CALL:28 - MIS",
        "INFO:UKNOWN TYPE FIRE ON EAST SIDE OF ROAD NORTH OF CARDO NEAR LOY RD",
        "ADDR:8000-B SR 66",
        "MADDR:8000 OH 66",
        "CITY:FT LORAMIE",
        "X:LOY RD & BASINBURG RD");

    doTest("T4",
        "11-009441|21:37:00|:29 - EMS|ELDERLY FEMALE FALL VICTIM  NO INJURY NEEDS HELP  GETTING UP @ 7533 HOYING RD ANNA BETW WRIGHT PUTHOFF RD & THAMAN RD|PLAS",
        "ID:11-009441",
        "TIME:21:37:00",
        "CALL:29 - EMS",
        "INFO:ELDERLY FEMALE FALL VICTIM  NO INJURY NEEDS HELP  GETTING UP",
        "ADDR:7533 HOYING RD",
        "CITY:ANNA",
        "X:WRIGHT PUTHOFF RD & THAMAN RD",
        "NAME:PLAS");

    doTest("T5",
        "11-009690|05:32:00|:58 - EMS|SHOT HIMSELF IN THE HEAD, HE IS GONE @ 18590 SR 29 NEW KNOXVILLE BETW BOTKINS RD & WIERWILLE RD|",
        "ID:11-009690",
        "TIME:05:32:00",
        "CALL:58 - EMS",
        "INFO:SHOT HIMSELF IN THE HEAD, HE IS GONE",
        "ADDR:18590 SR 29",
        "MADDR:18590 OH 29",
        "CITY:NEW KNOXVILLE",
        "X:BOTKINS RD & WIERWILLE RD");

    doTest("T6",
        "11-009558|23:34:00|:29 - EMS|FEMALE WITH AN ALLERGIC REACTION @ 202 S VANDEMARK RD SIDNEY BETW SHAWNEE DR & APACHE DR|SAUNDERS",
        "ID:11-009558",
        "TIME:23:34:00",
        "CALL:29 - EMS",
        "INFO:FEMALE WITH AN ALLERGIC REACTION",
        "ADDR:202 S VANDEMARK RD",
        "CITY:SIDNEY",
        "X:SHAWNEE DR & APACHE DR",
        "NAME:SAUNDERS");
     
  }
  
  @Test
  public void testJerryArmes() {

    doTest("T1",
        "(CAD Page) 12-003898|18:00:00|28-MIS|THERE IS A POWER POLE THAT IS ON FIRE @ 6053 DAWSON RD, HOUSTON X OF  STOKER RD &  SR 47|BROWN",
        "ID:12-003898",
        "TIME:18:00:00",
        "CALL:28-MIS",
        "INFO:THERE IS A POWER POLE THAT IS ON FIRE",
        "ADDR:6053 DAWSON RD",
        "CITY:HOUSTON",
        "X:STOKER RD & SR 47",
        "NAME:BROWN");

    doTest("T2",
        "(CAD Page) 12-003885|15:23:00|4-AWI|CAR/MOTORCYCLE @  EILERMAN RD@ FT LORAMIE SWANDERS RD, FT LORAMIE X OF  & |",
        "ID:12-003885",
        "TIME:15:23:00",
        "CALL:4-AWI",
        "INFO:CAR/MOTORCYCLE",
        "ADDR:EILERMAN RD & FT LORAMIE SWANDERS RD",
        "CITY:FT LORAMIE");

    doTest("T3",
        "(CAD Page) 12-003671|04:29:00|28-MIS|HAD A FIRE IN OUR GARAGE, NEED @ 9011 GREENVILLE RD, SIDNEY X OF  HARDIN WAPAKONETA RD &  PATTERSON HALPIN RD|YOUNG",
        "ID:12-003671",
        "TIME:04:29:00",
        "CALL:28-MIS",
        "INFO:HAD A FIRE IN OUR GARAGE, NEED",
        "ADDR:9011 GREENVILLE RD",
        "CITY:SIDNEY",
        "X:HARDIN WAPAKONETA RD & PATTERSON HALPIN RD",
        "NAME:YOUNG");
  }
  
  @Test
  public void testShirleyJones() {

    doTest("T1",
        "(CAD Page) 12-009303|05:27:56|29-EMS|MEDICAL CALL 76 YO MALE NOT FEELING HAVEING STOMACH PAINS  @ 151 S LIBERTY WAY UNIT B, FT LORAMIE X OF ELM ST & CUL",
        "ID:12-009303",
        "TIME:05:27:56",
        "CALL:29-EMS",
        "INFO:MEDICAL CALL 76 YO MALE NOT FEELING HAVEING STOMACH PAINS",
        "ADDR:151 S LIBERTY WAY",
        "APT:B",
        "CITY:FT LORAMIE",
        "X:ELM ST & CUL");

  }
  
  @Test
  public void testActive911() {

    doTest("T1",
        "(CAD Page) 12-003681|12:48:00|29-EMS|76 YOF CHEST PAINS @ 404 W MAIN ST UNIT 3, ANNA X OF  CSX RAILROAD &amp;  BROOKSIDE DR|BEERS",
        "ID:12-003681",
        "TIME:12:48:00",
        "CALL:29-EMS",
        "INFO:76 YOF CHEST PAINS",
        "ADDR:404 W MAIN ST",
        "APT:3",
        "CITY:ANNA",
        "X:CSX RAILROAD & BROOKSIDE DR",
        "NAME:BEERS");

    doTest("T2",
        "(CAD Page) 12-003677|10:19:00|29-|MALE CARDIAC DISTRESS @ 3003 CISCO RD, SIDNEY X OF  KUTHER RD &amp;  SR 29|DOROTHY LOVE",
        "ID:12-003677",
        "TIME:10:19:00",
        "CALL:29-",
        "INFO:MALE CARDIAC DISTRESS",
        "ADDR:3003 CISCO RD",
        "CITY:SIDNEY",
        "X:KUTHER RD & SR 29",
        "NAME:DOROTHY LOVE");

    doTest("T3",
        "(CAD Page) 12-003680|12:00:00|29-|FEMALE FALL @ 2500 N KUTHER RD UNIT COM, SIDNEY X OF  RUSSELL RD &amp;  CISCO RD|DOROTHY LOVE APTS",
        "ID:12-003680",
        "TIME:12:00:00",
        "CALL:29-",
        "INFO:FEMALE FALL",
        "ADDR:2500 N KUTHER RD",
        "APT:COM",
        "CITY:SIDNEY",
        "X:RUSSELL RD & CISCO RD",
        "PLACE:DOROTHY LOVE APTS");

    doTest("T4",
        "(CAD Page) 12-003665|03:43:00|9-|NEIGHBORS ARE RUNNING A DIRT B @ 3989 RUSSIA HOUSTON RD, RUSSIA X OF  RANGELINE RD &amp;  SR 48|MAGOTO",
        "ID:12-003665",
        "TIME:03:43:00",
        "CALL:9-",
        "INFO:NEIGHBORS ARE RUNNING A DIRT B",
        "ADDR:3989 RUSSIA HOUSTON RD",
        "CITY:RUSSIA",
        "X:RANGELINE RD & SR 48",
        "NAME:MAGOTO");

    doTest("T5",
        "(CAD Page) 12-003667|04:02:00|9-|THERE IS A MALE HERE THAT IS DRUNK, REFUSING TO LEAVE @ 215 JAMES ST, JACKSON CENTER X OF S OHIO ST &amp;  ELDER ST|HUDSON",
        "ID:12-003667",
        "TIME:04:02:00",
        "CALL:9-",
        "INFO:THERE IS A MALE HERE THAT IS DRUNK, REFUSING TO LEAVE",
        "ADDR:215 JAMES ST",
        "CITY:JACKSON CENTER",
        "X:S OHIO ST & ELDER ST",
        "NAME:HUDSON");

    doTest("T6",
        "(CAD Page) 12-003668|04:20:00|9-|THERE IS A LARGE DISTURBANCE OUTSIDE, ITS SOUNDS PRETTY HEATED @ 215 JAMES ST, JACKSON CENTER X OF S OHIO ST &amp;  ELDER ST|HUDSON",
        "ID:12-003668",
        "TIME:04:20:00",
        "CALL:9-",
        "INFO:THERE IS A LARGE DISTURBANCE OUTSIDE, ITS SOUNDS PRETTY HEATED",
        "ADDR:215 JAMES ST",
        "CITY:JACKSON CENTER",
        "X:S OHIO ST & ELDER ST",
        "NAME:HUDSON");

    doTest("T7",
        "(CAD Page) 12-003670|04:23:00|29-EMS|50 YOF - PASSED OUT - HX OF CRONES AND VOMITING @ 2433 LORAMIE WASHINGTON RD, HOUSTON X OF  FESSLER BUXTON RD &amp;  TAYLOR RD|KAUFFMAN",
        "ID:12-003670",
        "TIME:04:23:00",
        "CALL:29-EMS",
        "INFO:50 YOF - PASSED OUT - HX OF CRONES AND VOMITING",
        "ADDR:2433 LORAMIE WASHINGTON RD",
        "CITY:HOUSTON",
        "X:FESSLER BUXTON RD & TAYLOR RD",
        "NAME:KAUFFMAN");

    doTest("T8",
        "(CAD Page) 12-003671|04:29:00|28-|HAD A FIRE IN OUR GARAGE, NEED @ 9011 GREENVILLE RD, SIDNEY X OF  HARDIN WAPAKONETA RD &amp;  PATTERSON HALPIN RD|YOUNG ",
        "ID:12-003671",
        "TIME:04:29:00",
        "CALL:28-",
        "INFO:HAD A FIRE IN OUR GARAGE, NEED",
        "ADDR:9011 GREENVILLE RD",
        "CITY:SIDNEY",
        "X:HARDIN WAPAKONETA RD & PATTERSON HALPIN RD",
        "NAME:YOUNG");

    doTest("T9",
        "(CAD Page) 12-003636|16:03:00|28-FF|GRASS FIRE  @ 3000-B SR 48, HOUSTON X OF  RUSSIA VERSAILLES RD &amp;  RUSSIA HOUSTON RD|",
        "ID:12-003636",
        "TIME:16:03:00",
        "CALL:28-FF",
        "INFO:GRASS FIRE",
        "ADDR:3000-B SR 48",
        "MADDR:3000 OH 48",
        "CITY:HOUSTON",
        "X:RUSSIA VERSAILLES RD & RUSSIA HOUSTON RD");

    doTest("T10",
        "(CAD Page) 12-003639|16:59:00|9-|PROBLEMS WITH JUVENILES IN PARK  @ 800 E PIKE ST, JACKSON CENTER X OF  PARKVIEW ST &amp;  CORP LIMITS|JACKSON CENTER SWIMMING POOL",
        "ID:12-003639",
        "TIME:16:59:00",
        "CALL:9-",
        "INFO:PROBLEMS WITH JUVENILES IN PARK",
        "ADDR:800 E PIKE ST",
        "CITY:JACKSON CENTER",
        "X:PARKVIEW ST & CORP LIMITS",
        "PLACE:JACKSON CENTER SWIMMING POOL");

    doTest("T11",
        "(CAD Page) 12-003642|17:20:00|9-|ATV RACING AROUND TOWN  WHI YAMAHA WENT TO 21444 MAPLEWOOD RD  @ 6 EXTRA, MAPLEWOOD X OF  CITY &amp;  CITY|VILLAGE OF MAPLEWOOD",
        "ID:12-003642",
        "TIME:17:20:00",
        "CALL:9-",
        "INFO:ATV RACING AROUND TOWN  WHI YAMAHA WENT TO 21444 MAPLEWOOD RD",
        "ADDR:6 EXTRA",
        "CITY:MAPLEWOOD",
        "X:CITY & CITY",
        "PLACE:VILLAGE OF MAPLEWOOD");

    doTest("T12",
        "(CAD Page) 12-003648|20:14:00|9-|CAR SMOKING DRIVING DOWN ROAD  @ 18000-B SR 47, SIDNEY X OF  CORP LIMITS &amp;  HERRING RD|18000-B SR 47",
        "ID:12-003648",
        "TIME:20:14:00",
        "CALL:9-",
        "INFO:CAR SMOKING DRIVING DOWN ROAD",
        "ADDR:18000-B SR 47",
        "MADDR:18000 OH 47",
        "CITY:SIDNEY",
        "X:CORP LIMITS & HERRING RD",
        "PLACE:18000-B SR 47");

    doTest("T13",
        "(CAD Page) 12-003634|13:34:00|9-|REF ID THEFT @ ,  X OF  &amp; |",
        "ID:12-003634",
        "TIME:13:34:00",
        "CALL:9-",
        "INFO:REF ID THEFT");

    doTest("T14",
        "(CAD Page) 12-003562|20:16:00|9-|MALE IN THE LOBBY REQUESTING TO TALK WITH A DEPUTY ABOUT HIS 34 @ 18288 HERRING RD, SIDNEY X OF  RIVERVIEW PL &amp;  BAKER RD|",
        "ID:12-003562",
        "TIME:20:16:00",
        "CALL:9-",
        "INFO:MALE IN THE LOBBY REQUESTING TO TALK WITH A DEPUTY ABOUT HIS 34",
        "ADDR:18288 HERRING RD",
        "CITY:SIDNEY",
        "X:RIVERVIEW PL & BAKER RD");

    doTest("T15",
        "(CAD Page) 12-003535||9-|INMATE CHAIRED @ 555 GEARHART RD, SIDNEY X OF  CHILDRENS HOME RD &amp;  DOORLEY RD|SHERIFF'S OFFICE",
        "ID:12-003535",
        "CALL:9-",
        "INFO:INMATE CHAIRED",
        "ADDR:555 GEARHART RD",
        "CITY:SIDNEY",
        "X:CHILDRENS HOME RD & DOORLEY RD",
        "NAME:SHERIFF'S OFFICE");

    doTest("T16",
        "(CAD Page) 12-003540||29-EMS|24 YOM, SHOULDER IS OUT OF PLACE @ 10291 TAWAWA MAPLEWOOD RD, MAPLEWOOD X OF  SR 47 &amp;  LEFEVRE RD|KUCK",
        "ID:12-003540",
        "CALL:29-EMS",
        "INFO:24 YOM, SHOULDER IS OUT OF PLACE",
        "ADDR:10291 TAWAWA MAPLEWOOD RD",
        "CITY:MAPLEWOOD",
        "X:SR 47 & LEFEVRE RD",
        "NAME:KUCK");

    doTest("T17",
        "(CAD Page) 12-003530||9-|SON IS TEARING UP MY HOUSE @ 5920 SMITH RD, HOUSTON X OF  JEROME DR &amp;  FOSTER RD|LEE",
        "ID:12-003530",
        "CALL:9-",
        "INFO:SON IS TEARING UP MY HOUSE",
        "ADDR:5920 SMITH RD",
        "CITY:HOUSTON",
        "X:JEROME DR & FOSTER RD",
        "NAME:LEE");

    doTest("T18",
        "(CAD Page) 12-003558||29-EMS|MALE CALLED AND ADVISED THAT HE WAS TOLD TO EVACUATE @ 601 N STOLLE AV, SIDNEY X OF  GLEASON ST &amp;  CUL DE SAC|FRESHWAY FOODS",
        "ID:12-003558",
        "CALL:29-EMS",
        "INFO:MALE CALLED AND ADVISED THAT HE WAS TOLD TO EVACUATE",
        "ADDR:601 N STOLLE AV",
        "MADDR:601 N STOLLE AVE",
        "CITY:SIDNEY",
        "X:GLEASON ST & CUL DE SAC",
        "NAME:FRESHWAY FOODS");

    doTest("T19",
        "(CAD Page) 12-003526||29-| @ 260 OAKWOOD DR, FT LORAMIE X OF  SIOUX ST &amp;  MIAMI ST|BEHR",
        "ID:12-003526",
        "CALL:29-",
        "ADDR:260 OAKWOOD DR",
        "CITY:FT LORAMIE",
        "X:SIOUX ST & MIAMI ST",
        "NAME:BEHR");

    doTest("T20",
        "(CAD Page) 12-003508|06:47:00|28-SR|NEIGHBORS HOUSE IS ON FIRE@17000-B FT LORAMIE SWANDERS RD SIDNEY BETW LOCAHRD RD &amp; AILES RD|",
        "ID:12-003508",
        "TIME:06:47:00",
        "CALL:28-SR",
        "INFO:NEIGHBORS HOUSE IS ON FIRE",
        "ADDR:17000-B FT LORAMIE SWANDERS RD",
        "MADDR:17000 FT LORAMIE SWANDERS RD",
        "CITY:SIDNEY",
        "X:LOCAHRD RD & AILES RD");

    doTest("T21",
        "(CAD Page) 12-003513|08:35:00|:9 - |1 MALE FOR CT\n@ 56 EXTRA TROY BETW  CITY &amp;  CITY|WEST CENTRAL JDC",
        "ID:12-003513",
        "TIME:08:35:00",
        "CALL:9 -",
        "INFO:1 MALE FOR CT",
        "ADDR:56 EXTRA",
        "CITY:TROY",
        "X:CITY & CITY",
        "PLACE:WEST CENTRAL JDC");

    doTest("T22",
        "(CAD Page) 12-003508|06:47:00|:28-SF|NEIGHBORS HOUSE IN ON FIRE @ 17000-B FT LORAMIE SWANDERS RD SIDNEY BETWE LOCHARD RD &amp; AILES RD|",
        "ID:12-003508",
        "TIME:06:47:00",
        "CALL:28-SF",
        "INFO:NEIGHBORS HOUSE IN ON FIRE",
        "ADDR:17000-B FT LORAMIE SWANDERS RD",
        "MADDR:17000 FT LORAMIE SWANDERS RD",
        "CITY:SIDNEY",
        "X:LOCHARD RD & AILES RD");

    doTest("T23",
        "(CAD Page) 12-003620|07:19:00|29-EMS|BE OUT ON A 29 CALL @ 205 FIRST ST, RUSSIA X OF  ELIZABETH ST &amp;  DEADEND|MONNIN",
        "ID:12-003620",
        "TIME:07:19:00",
        "CALL:29-EMS",
        "INFO:BE OUT ON A 29 CALL",
        "ADDR:205 FIRST ST",
        "CITY:RUSSIA",
        "X:ELIZABETH ST & DEADEND",
        "NAME:MONNIN");

    doTest("T24",
        "(CAD Page) 12-003619|06:45:00|29-EMS|50 YOM THROWING UP SHORTNESS OF BREATH @ 3012 SR 66, HOUSTON X OF  SMITH RD &amp;  STILLWATER RD|GOINGS",
        "ID:12-003619",
        "TIME:06:45:00",
        "CALL:29-EMS",
        "INFO:50 YOM THROWING UP SHORTNESS OF BREATH",
        "ADDR:3012 SR 66",
        "MADDR:3012 OH 66",
        "CITY:HOUSTON",
        "X:SMITH RD & STILLWATER RD",
        "NAME:GOINGS");

    doTest("T25",
        "(CAD Page) 12-003607|22:29:00|9-|DEBRIE @  SR 29@ WELLS RD, ANNA X OF  &amp; |",
        "ID:12-003607",
        "TIME:22:29:00",
        "CALL:9-",
        "INFO:DEBRIE",
        "ADDR:SR 29 & WELLS RD",
        "MADDR:OH 29 & WELLS RD",
        "CITY:ANNA");

    doTest("T26",
        "(CAD Page) 12-003614|00:02:00|9-|OUT WITH TWO VEH ON LANE ST. AT THE PARK @ 7 EXTRA, FT LORAMIE X OF  CITY &amp;  CITY|VILLAGE OF FT LORAMIE",
        "ID:12-003614",
        "TIME:00:02:00",
        "CALL:9-",
        "INFO:OUT WITH TWO VEH ON LANE ST. AT THE PARK",
        "ADDR:7 EXTRA",
        "CITY:FT LORAMIE",
        "X:CITY & CITY",
        "PLACE:VILLAGE OF FT LORAMIE");

    doTest("T27",
        "(CAD Page) 12-003598|19:29:00|9-| @ 404 W STATE ST, BOTKINS X OF  OAK ST &amp; N ELM ST|KING",
        "ID:12-003598",
        "TIME:19:29:00",
        "CALL:9-",
        "ADDR:404 W STATE ST",
        "CITY:BOTKINS",
        "X:OAK ST & N ELM ST",
        "NAME:KING");

    doTest("T28",
        "(CAD Page) 12-003604|21:45:00|9-|BUILDING CHECK  @ 401 S PIKE ST, ANNA X OF  YOUNG ST &amp;  DIAMOND DR|ANNA STORE &amp; LOCK",
        "ID:12-003604",
        "TIME:21:45:00",
        "CALL:9-",
        "INFO:BUILDING CHECK",
        "ADDR:401 S PIKE ST",
        "CITY:ANNA",
        "X:YOUNG ST & DIAMOND DR",
        "PLACE:ANNA STORE & LOCK");

    doTest("T29",
        "(CAD Page) 12-003593|15:54:00|29-EMS|SERIOUS INSULIN REACTION  65 YOA FEMALE @ 10377 AMSTERDAM RD, BOTKINS X OF  HARDIN WAPAKONETA RD &amp;  STALEY RD|NOLTE",
        "ID:12-003593",
        "TIME:15:54:00",
        "CALL:29-EMS",
        "INFO:SERIOUS INSULIN REACTION  65 YOA FEMALE",
        "ADDR:10377 AMSTERDAM RD",
        "CITY:BOTKINS",
        "X:HARDIN WAPAKONETA RD & STALEY RD",
        "NAME:NOLTE");

    doTest("T30",
        "(CAD Page) 12-003585|12:00:00|29-EMS|63 SOB, DISORIENTED @ 22013 LOCK TWO RD, JACKSON CENTER X OF  MORRIS ROSE RD &amp;  COUNTY LINE|MYERS",
        "ID:12-003585",
        "TIME:12:00:00",
        "CALL:29-EMS",
        "INFO:63 SOB, DISORIENTED",
        "ADDR:22013 LOCK TWO RD",
        "CITY:JACKSON CENTER",
        "X:MORRIS ROSE RD & COUNTY LINE",
        "NAME:MYERS");

    doTest("T31",
        "(CAD Page) 12-003575|05:01:00|9-| @ 2100 MICHIGAN ST, SIDNEY X OF  FOLKERTH AV &amp; N VANDEMARK RD|KROGERS",
        "ID:12-003575",
        "TIME:05:01:00",
        "CALL:9-",
        "ADDR:2100 MICHIGAN ST",
        "CITY:SIDNEY",
        "X:FOLKERTH AV & N VANDEMARK RD",
        "NAME:KROGERS");

    doTest("T32",
        "(CAD Page) 12-003569|23:49:00|9-|EUGENE GOINGS IS HERE CAUSING  @ 3855 LINDSEY RD, SIDNEY X OF  SCHENK RD &amp;  MILLCREEK RD|",
        "ID:12-003569",
        "TIME:23:49:00",
        "CALL:9-",
        "INFO:EUGENE GOINGS IS HERE CAUSING",
        "ADDR:3855 LINDSEY RD",
        "CITY:SIDNEY",
        "X:SCHENK RD & MILLCREEK RD");

    doTest("T33",
        "(CAD Page) 12-003574|04:52:00|9-| @ 5881 SR 29, SIDNEY X OF  SR 706 &amp;  CSX RAILROAD|PASCO GROCERY",
        "ID:12-003574",
        "TIME:04:52:00",
        "CALL:9-",
        "ADDR:5881 SR 29",
        "MADDR:5881 OH 29",
        "CITY:SIDNEY",
        "X:SR 706 & CSX RAILROAD",
        "NAME:PASCO GROCERY");

    doTest("T34",
        "(CAD Page) 12-003566|21:41:00|9-|PAST COUPLE NIGHTS HAVE BEEN H @ 15435 MORRIS ROSE RD, JACKSON CENTER X OF  WISE RD &amp;  LINKER RD|WEAVER",
        "ID:12-003566",
        "TIME:21:41:00",
        "CALL:9-",
        "INFO:PAST COUPLE NIGHTS HAVE BEEN H",
        "ADDR:15435 MORRIS ROSE RD",
        "CITY:JACKSON CENTER",
        "X:WISE RD & LINKER RD",
        "NAME:WEAVER");
  }
  
  public static void main(String[] args) {
    new OHShelbyCountyParserTest().generateTests("T1");
  }
}