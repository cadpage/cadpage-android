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
        "MADDR:8000 SR 66",
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
  public void testActive911() {

    doTest("T1",
        "(CAD Page) 12-003526||29-| @ 260 OAKWOOD DR, FT LORAMIE X OF  SIOUX ST &amp;  MIAMI ST|BEHR",
        "ID:12-003526",
        "CALL:29-",
        "ADDR:260 OAKWOOD DR",
        "CITY:FT LORAMIE",
        "X:SIOUX ST & MIAMI ST",
        "NAME:BEHR");

    doTest("T2",
        "(CAD Page) 12-003508|06:47:00|28-SR|NEIGHBORS HOUSE IS ON FIRE@17000-B FT LORAMIE SWANDERS RD SIDNEY BETW LOCAHRD RD &amp; AILES RD|",
        "ID:12-003508",
        "TIME:06:47:00",
        "CALL:28-SR",
        "INFO:NEIGHBORS HOUSE IS ON FIRE",
        "ADDR:17000-B FT LORAMIE SWANDERS RD",
        "MADDR:17000 FT LORAMIE SWANDERS RD",
        "CITY:SIDNEY",
        "X:LOCAHRD RD & AILES RD");

    doTest("T3",
        "(CAD Page) 12-003513|08:35:00|:9 - |1 MALE FOR CT\n@ 56 EXTRA TROY BETW  CITY &amp;  CITY|WEST CENTRAL JDC",
        "ID:12-003513",
        "TIME:08:35:00",
        "CALL:9 -",
        "INFO:1 MALE FOR CT",
        "ADDR:56 EXTRA",
        "CITY:TROY",
        "X:CITY & CITY",
        "PLACE:WEST CENTRAL JDC");

    doTest("T4",
        "(CAD Page) 12-003508|06:47:00|:28-SF|NEIGHBORS HOUSE IN ON FIRE @ 17000-B FT LORAMIE SWANDERS RD SIDNEY BETWE LOCHARD RD &amp; AILES RD|",
        "ID:12-003508",
        "TIME:06:47:00",
        "CALL:28-SF",
        "INFO:NEIGHBORS HOUSE IN ON FIRE",
        "ADDR:17000-B FT LORAMIE SWANDERS RD",
        "MADDR:17000 FT LORAMIE SWANDERS RD",
        "CITY:SIDNEY",
        "X:LOCHARD RD & AILES RD");

    doTest("T5",
        "(CAD Page) 12-003620|07:19:00|29-EMS|BE OUT ON A 29 CALL @ 205 FIRST ST, RUSSIA X OF  ELIZABETH ST &amp;  DEADEND|MONNIN",
        "ID:12-003620",
        "TIME:07:19:00",
        "CALL:29-EMS",
        "INFO:BE OUT ON A 29 CALL",
        "ADDR:205 FIRST ST",
        "CITY:RUSSIA",
        "X:ELIZABETH ST & DEADEND",
        "NAME:MONNIN");

    doTest("T6",
        "(CAD Page) 12-003619|06:45:00|29-EMS|50 YOM THROWING UP SHORTNESS OF BREATH @ 3012 SR 66, HOUSTON X OF  SMITH RD &amp;  STILLWATER RD|GOINGS",
        "ID:12-003619",
        "TIME:06:45:00",
        "CALL:29-EMS",
        "INFO:50 YOM THROWING UP SHORTNESS OF BREATH",
        "ADDR:3012 SR 66",
        "CITY:HOUSTON",
        "X:SMITH RD & STILLWATER RD",
        "NAME:GOINGS");

    doTest("T7",
        "(CAD Page) 12-003607|22:29:00|9-|DEBRIE @  SR 29@ WELLS RD, ANNA X OF  &amp; |",
        "ID:12-003607",
        "TIME:22:29:00",
        "CALL:9-",
        "INFO:DEBRIE",
        "ADDR:SR 29 & WELLS RD",
        "CITY:ANNA");

    doTest("T8",
        "(CAD Page) 12-003614|00:02:00|9-|OUT WITH TWO VEH ON LANE ST. AT THE PARK @ 7 EXTRA, FT LORAMIE X OF  CITY &amp;  CITY|VILLAGE OF FT LORAMIE",
        "ID:12-003614",
        "TIME:00:02:00",
        "CALL:9-",
        "INFO:OUT WITH TWO VEH ON LANE ST. AT THE PARK",
        "ADDR:7 EXTRA",
        "CITY:FT LORAMIE",
        "X:CITY & CITY",
        "PLACE:VILLAGE OF FT LORAMIE");

    doTest("T9",
        "(CAD Page) 12-003598|19:29:00|9-| @ 404 W STATE ST, BOTKINS X OF  OAK ST &amp; N ELM ST|KING",
        "ID:12-003598",
        "TIME:19:29:00",
        "CALL:9-",
        "ADDR:404 W STATE ST",
        "CITY:BOTKINS",
        "X:OAK ST & N ELM ST",
        "NAME:KING");

    doTest("T10",
        "(CAD Page) 12-003604|21:45:00|9-|BUILDING CHECK  @ 401 S PIKE ST, ANNA X OF  YOUNG ST &amp;  DIAMOND DR|ANNA STORE &amp; LOCK",
        "ID:12-003604",
        "TIME:21:45:00",
        "CALL:9-",
        "INFO:BUILDING CHECK",
        "ADDR:401 S PIKE ST",
        "CITY:ANNA",
        "X:YOUNG ST & DIAMOND DR",
        "PLACE:ANNA STORE & LOCK");

    doTest("T11",
        "(CAD Page) 12-003593|15:54:00|29-EMS|SERIOUS INSULIN REACTION  65 YOA FEMALE @ 10377 AMSTERDAM RD, BOTKINS X OF  HARDIN WAPAKONETA RD &amp;  STALEY RD|NOLTE",
        "ID:12-003593",
        "TIME:15:54:00",
        "CALL:29-EMS",
        "INFO:SERIOUS INSULIN REACTION  65 YOA FEMALE",
        "ADDR:10377 AMSTERDAM RD",
        "CITY:BOTKINS",
        "X:HARDIN WAPAKONETA RD & STALEY RD",
        "NAME:NOLTE");

    doTest("T12",
        "(CAD Page) 12-003585|12:00:00|29-EMS|63 SOB, DISORIENTED @ 22013 LOCK TWO RD, JACKSON CENTER X OF  MORRIS ROSE RD &amp;  COUNTY LINE|MYERS",
        "ID:12-003585",
        "TIME:12:00:00",
        "CALL:29-EMS",
        "INFO:63 SOB, DISORIENTED",
        "ADDR:22013 LOCK TWO RD",
        "CITY:JACKSON CENTER",
        "X:MORRIS ROSE RD & COUNTY LINE",
        "NAME:MYERS");

    doTest("T13",
        "(CAD Page) 12-003575|05:01:00|9-| @ 2100 MICHIGAN ST, SIDNEY X OF  FOLKERTH AV &amp; N VANDEMARK RD|KROGERS",
        "ID:12-003575",
        "TIME:05:01:00",
        "CALL:9-",
        "ADDR:2100 MICHIGAN ST",
        "CITY:SIDNEY",
        "X:FOLKERTH AV & N VANDEMARK RD",
        "NAME:KROGERS");

    doTest("T14",
        "(CAD Page) 12-003569|23:49:00|9-|EUGENE GOINGS IS HERE CAUSING  @ 3855 LINDSEY RD, SIDNEY X OF  SCHENK RD &amp;  MILLCREEK RD|",
        "ID:12-003569",
        "TIME:23:49:00",
        "CALL:9-",
        "INFO:EUGENE GOINGS IS HERE CAUSING",
        "ADDR:3855 LINDSEY RD",
        "CITY:SIDNEY",
        "X:SCHENK RD & MILLCREEK RD");

    doTest("T15",
        "(CAD Page) 12-003574|04:52:00|9-| @ 5881 SR 29, SIDNEY X OF  SR 706 &amp;  CSX RAILROAD|PASCO GROCERY",
        "ID:12-003574",
        "TIME:04:52:00",
        "CALL:9-",
        "ADDR:5881 SR 29",
        "CITY:SIDNEY",
        "X:SR 706 & CSX RAILROAD",
        "NAME:PASCO GROCERY");

    doTest("T16",
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