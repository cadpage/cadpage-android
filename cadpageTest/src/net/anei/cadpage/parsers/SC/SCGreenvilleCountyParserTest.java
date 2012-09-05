package net.anei.cadpage.parsers.SC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class SCGreenvilleCountyParserTest extends BaseParserTest {
  
  public SCGreenvilleCountyParserTest() {
    setParser(new SCGreenvilleCountyParser(), "GREENVILLE COUNTY", "SC");
  }
  
  @Test
  public void testJrrichards() {

    doTest("T1",
        "CAD:ACKNOWLEDGE CALL;105 CRIMSON GLORY WAY; TRAV;(S) (N)19V",
        "CALL:ACKNOWLEDGE CALL",
        "ADDR:105 CRIMSON GLORY WAY",
        "CITY:TRAVELERS REST",
        "MAP:19V");

    doTest("T2",
        "CAD:FALLS;105 CRIMSON GLORY WAY;TRAV;MIRANDY CT;TINEKE WAY;(S) (N)19V;NG1",
        "CALL:FALLS",
        "ADDR:105 CRIMSON GLORY WAY",
        "CITY:TRAVELERS REST",
        "X:MIRANDY CT & TINEKE WAY",
        "MAP:19V",
        "INFO:NG1");

    doTest("T3",
        "CAD:FIRE ALARM;8 ANDERS RD;GRVL;OLD MCELHANEY RD;(S) (N)24F;Kristy- AOA: sprinkler trip [04/26/11 12:28:12 THILL] ;NG1",
        "CALL:FIRE ALARM",
        "ADDR:8 ANDERS RD",
        "CITY:GREENVILLE",
        "X:OLD MCELHANEY RD",
        "MAP:24F",
        "INFO:Kristy- AOA: sprinkler trip / NG1",
        "DATE:04/26/11",
        "TIME:12:28:12");

    doTest("T4",
        "CAD:ACKNOWLEDGE CALL;8 ANDERS RD; GRVL;(S) (N)24F",
        "CALL:ACKNOWLEDGE CALL",
        "ADDR:8 ANDERS RD",
        "CITY:GREENVILLE",
        "MAP:24F");

    doTest("T5",
        "CAD:FIRE ALARM;32 HUNT ST;TRAV;ELIZABETH LN;ELIZABETH LN;(S) (N)17O;NAME: CHARLA SMITH, [04/26/11 13:34:03 THILL] SMOKE ALARM GOING OFF [04/26/11 13:33:49",
        "CALL:FIRE ALARM",
        "ADDR:32 HUNT ST",
        "CITY:TRAVELERS REST",
        "X:ELIZABETH LN & ELIZABETH LN",
        "MAP:17O",
        "NAME:CHARLA SMITH,",
        "INFO:SMOKE ALARM GOING OFF",
        "DATE:04/26/11",
        "TIME:13:34:03");

    doTest("T6",
        "CAD:ACKNOWLEDGE CALL;32 HUNT ST; TRAV;(S) (N)17O",
        "CALL:ACKNOWLEDGE CALL",
        "ADDR:32 HUNT ST",
        "CITY:TRAVELERS REST",
        "MAP:17O");

    doTest("T7",
        "CAD:ACKNOWLEDGE CALL;32 HUNT ST; TRAV;(S) (N)17O",
        "CALL:ACKNOWLEDGE CALL",
        "ADDR:32 HUNT ST",
        "CITY:TRAVELERS REST",
        "MAP:17O");

    doTest("T8",
        "CAD:FALLS;124 JAMISON RD;TRAV;FARMINGTON TRL;WEBB CREEK CT;(S) (N)18F;NG1",
        "CALL:FALLS",
        "ADDR:124 JAMISON RD",
        "CITY:TRAVELERS REST",
        "X:FARMINGTON TRL & WEBB CREEK CT",
        "MAP:18F",
        "INFO:NG1");
  }
  
  @Test
  public void testKennethGosnell() {

    doTest("T1",
        "CAD:DIABETIC PROBLEM;518 GOFORTH RD;LAND;BUTTER ST;BUTTER ST;(S) (N)4H;GM1",
        "CALL:DIABETIC PROBLEM",
        "ADDR:518 GOFORTH RD",
        "CITY:LANDRUM",
        "X:BUTTER ST & BUTTER ST",
        "MAP:4H",
        "INFO:GM1");

    doTest("T2",
        "CAD:ABDOMINAL PAIN;178 DUFFS MOUNTAIN RD;MARI;DIST: 63.24 FT (S) (N)7H;GM1",
        "CALL:ABDOMINAL PAIN",
        "ADDR:178 DUFFS MOUNTAIN RD",
        "CITY:MARIETTA",
        "INFO:DIST: 63.24 FT / GM1",
        "MAP:7H");
  }
  
  @Test
  public void testTareKenedy() {

    doTest("T1",
        "CAD:FALLS;70 LATIMER RIDGE RD;HONE;CORN RD;(S) (N)86O;[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 76 year old, Male, Conscious, Breathing. Falls.",
        "CALL:FALLS",
        "ADDR:70 LATIMER RIDGE RD",
        "CITY:HONES PATH",
        "X:CORN RD",
        "MAP:86O",
        "INFO:76 year old, Male, Conscious, Breathing. Falls.");

    doTest("T2",
        "CAD:STROKE OR TIA;271 GREY RD;PELZ;DIST: 280.66 ft (S) (N)80V;243-3091 [01/04/12 06:30:45 CCHILDRESS] [Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT",
        "CALL:STROKE OR TIA",
        "ADDR:271 GREY RD",
        "CITY:PELZER",
        "INFO:DIST: 280.66 ft / 243-3091",
        "MAP:80V",
        "DATE:01/04/12",
        "TIME:06:30:45");

    doTest("T2",
        "CAD:OUTSIDE FIRE;419 CEDAR FALLS RD;FOUN;SWEET WATER RD;DUNKLIN BRIDGE RD;DIST: 86.71 ft (S) (N)80R;DK1",
        "CALL:OUTSIDE FIRE",
        "ADDR:419 CEDAR FALLS RD",
        "CITY:FOUNTAIN INN",
        "X:SWEET WATER RD & DUNKLIN BRIDGE RD",
        "INFO:DIST: 86.71 ft / DK1",
        "MAP:80R");

    doTest("T3",
        "CAD:STRUCTURE FIRE;10612 AUGUSTA RD;BELT;BOYS HOME OF THE SOUTH;DAVENTON RD;KERMIT WATSON BLVD;DIST: 715.97 ft (S) (N)86A;DK1",
        "CALL:STRUCTURE FIRE",
        "ADDR:10612 AUGUSTA RD",
        "CITY:BELTON",
        "X:BOYS HOME OF THE SOUTH & DAVENTON RD & KERMIT WATSON BLVD",
        "INFO:DIST: 715.97 ft / DK1",
        "MAP:86A");
   
  }
  
  @Test
  public void testActive911() {

    doTest("T1",
        "[] CAD:ELECTRICAL HAZARD;16 MOUNTAIN VISTA RD;TAYL;GROCE MEADOW RD;(S) (N)20J;LC1\n" +
        "CONFIDENTIALITY NOTICE: This e-mail and any files transmitted with it are confidential and may contain information which is legally privileged or otherwise exempt from disclosure. They are intended solely for the use of the individual or entity to whom this e-mail is addressed. If you are not one of the named recipients or otherwise have reason to believe that you have received this message in error, please immediately notify the sender and delete this message immediately from your computer. Any other use, retention, dissemination, forwarding, printing, or copying of this e-mail is strictly prohibited.\n",

        "CALL:ELECTRICAL HAZARD",
        "ADDR:16 MOUNTAIN VISTA RD",
        "CITY:TAYLORS",
        "X:GROCE MEADOW RD",
        "INFO:LC1",
        "MAP:20J");

    doTest("T2",
        "[] CAD:FIRE ALARM;3000 E GAP CREEK RD;GRER;GREER HIGH SCHOOL;N HOWELL RD;OLD WAGON RD;(S) (N)22Q;general fire alarm [04/06/12 01:25:05 WFULLER] ;LC1\n" +
        "CONFIDENTIALITY NOTICE: This e-mail and any files transmitted with it are confidential and may contain information which is legally privileged or otherwise exempt from disclosure. They are intended solely for the use of the individual or entity to whom this e-mail is addressed. If you are not one of the named recipients or otherwise have reason to believe that you have received this message in error, please immediately notify the sender and delete this message immediately from your computer. Any other use, retention, dissemination, forwarding, printing, or copying of this e-mail is strictly prohibited.\n",

        "CALL:FIRE ALARM",
        "ADDR:3000 E GAP CREEK RD",
        "CITY:GREER",
        "X:GREER HIGH SCHOOL & N HOWELL RD & OLD WAGON RD",
        "INFO:general fire alarm / LC1",
        "MAP:22Q",
        "DATE:04/06/12",
        "TIME:01:25:05");

    doTest("T3",
        "[] CAD:FIRE ALARM;4221 N 14 HWY;GRER;SKYLAND ELEMENTARY SCHOOL;SKYLAND DR;SKYLAND SCHOOL RD;(S) (N)15I;LC1\n" +
        "CONFIDENTIALITY NOTICE: This e-mail and any files transmitted with it are confidential and may contain information which is legally privileged or otherwise exempt from disclosure. They are intended solely for the use of the individual or entity to whom this e-mail is addressed. If you are not one of the named recipients or otherwise have reason to believe that you have received this message in error, please immediately notify the sender and delete this message immediately from your computer. Any other use, retention, dissemination, forwarding, printing, or copying of this e-mail is strictly prohibited.\n",

        "CALL:FIRE ALARM",
        "ADDR:4221 N 14 HWY",
        "CITY:GREER",
        "X:SKYLAND ELEMENTARY SCHOOL & SKYLAND DR & SKYLAND SCHOOL RD",
        "INFO:LC1",
        "MAP:15I");

    doTest("T4",
        "[] CAD:FIRE ALARM;3192 N MCELHANEY RD;GRER;LAKE CUNNINGHAM RD;N JAMES RD;(S) (N)21N;HALLWAY [04/06/12 18:49:53 TVINSON] HALLWAY SMOKE DETECTOR [04/06/12 18:50:09 TVINSON] ;LC1\n" +
        "CONFIDENTIALITY NOTICE: This e-mail and any files transmitted with it are confidential and may contain information which is legally privileged or otherwise exempt from disclosure. They are intended solely for the use of the individual or entity to whom this e-mail is addressed. If you are not one of the named recipients or otherwise have reason to believe that you have received this message in error, please immediately notify the sender and delete this message immediately from your computer. Any other use, retention, dissemination, forwarding, printing, or copying of this e-mail is strictly prohibited.\n",

        "CALL:FIRE ALARM",
        "ADDR:3192 N MCELHANEY RD",
        "CITY:GREER",
        "X:LAKE CUNNINGHAM RD & N JAMES RD",
        "INFO:HALLWAY / HALLWAY SMOKE DETECTOR / LC1",
        "MAP:21N",
        "DATE:04/06/12",
        "TIME:18:49:53");

    doTest("T5",
        "[] CAD:CANCEL;3192 N MCELHANEY RD; GRER;(S) (N)21N\n" +
        "CONFIDENTIALITY NOTICE: This e-mail and any files transmitted with it are confidential and may contain information which is legally privileged or otherwise exempt from disclosure. They are intended solely for the use of the individual or entity to whom this e-mail is addressed. If you are not one of the named recipients or otherwise have reason to believe that you have received this message in error, please immediately notify the sender and delete this message immediately from your computer. Any other use, retention, dissemination, forwarding, printing, or copying of this e-mail is strictly prohibited.\n",

        "CALL:CANCEL",
        "ADDR:3192 N MCELHANEY RD",
        "CITY:GREER",
        "MAP:21N");

    doTest("T6",
        "[] CAD:FALLS;153 BROOKE LEE CIR;TAYL;HALBROOK DR;PEARLE BROOK LN;DIST: 52.83 FT (S) (N)20I;LC1\n" +
        "CONFIDENTIALITY NOTICE: This e-mail and any files transmitted with it are confidential and may contain information which is legally privileged or otherwise exempt from disclosure. They are intended solely for the use of the individual or entity to whom this e-mail is addressed. If you are not one of the named recipients or otherwise have reason to believe that you have received this message in error, please immediately notify the sender and delete this message immediately from your computer. Any other use, retention, dissemination, forwarding, printing, or copying of this e-mail is strictly prohibited.\n",

        "CALL:FALLS",
        "ADDR:153 BROOKE LEE CIR",
        "CITY:TAYLORS",
        "X:HALBROOK DR & PEARLE BROOK LN",
        "INFO:DIST: 52.83 FT / LC1",
        "MAP:20I");

    doTest("T7",
        "[] CAD:MEDTRANS ON STANDBY;153 BROOKE LEE CIR; TAYL;DIST: 52.83 FT (S) (N)20I\n" +
        "CONFIDENTIALITY NOTICE: This e-mail and any files transmitted with it are confidential and may contain information which is legally privileged or otherwise exempt from disclosure. They are intended solely for the use of the individual or entity to whom this e-mail is addressed. If you are not one of the named recipients or otherwise have reason to believe that you have received this message in error, please immediately notify the sender and delete this message immediately from your computer. Any other use, retention, dissemination, forwarding, printing, or copying of this e-mail is strictly prohibited.\n",

        "CALL:MEDTRANS ON STANDBY",
        "ADDR:153 BROOKE LEE CIR",
        "CITY:TAYLORS",
        "INFO:DIST: 52.83 FT",
        "MAP:20I");

    doTest("T8",
        "[] CAD:MEDTRANS LAUNCHED;153 BROOKE LEE CIR; TAYL;DIST: 52.83 FT (S) (N)20I\n" +
        "CONFIDENTIALITY NOTICE: This e-mail and any files transmitted with it are confidential and may contain information which is legally privileged or otherwise exempt from disclosure. They are intended solely for the use of the individual or entity to whom this e-mail is addressed. If you are not one of the named recipients or otherwise have reason to believe that you have received this message in error, please immediately notify the sender and delete this message immediately from your computer. Any other use, retention, dissemination, forwarding, printing, or copying of this e-mail is strictly prohibited.\n",

        "CALL:MEDTRANS LAUNCHED",
        "ADDR:153 BROOKE LEE CIR",
        "CITY:TAYLORS",
        "INFO:DIST: 52.83 FT",
        "MAP:20I");

    doTest("T9",
        "[] CAD:STRUCTURE FIRE;2 BLUEGRASS CT;TAYL;SPLITRAIL DR;DIST: 60.52 FT (S) (N)14V;LC1\n" +
        "CONFIDENTIALITY NOTICE: This e-mail and any files transmitted with it are confidential and may contain information which is legally privileged or otherwise exempt from disclosure. They are intended solely for the use of the individual or entity to whom this e-mail is addressed. If you are not one of the named recipients or otherwise have reason to believe that you have received this message in error, please immediately notify the sender and delete this message immediately from your computer. Any other use, retention, dissemination, forwarding, printing, or copying of this e-mail is strictly prohibited.\n",

        "CALL:STRUCTURE FIRE",
        "ADDR:2 BLUEGRASS CT",
        "CITY:TAYLORS",
        "X:SPLITRAIL DR",
        "INFO:DIST: 60.52 FT / LC1",
        "MAP:14V");

    doTest("T10",
        "[] CAD:WORKING FIRE;2 BLUEGRASS CT; TAYL;DIST: 60.52 FT (S) (N)14V\n" +
        "CONFIDENTIALITY NOTICE: This e-mail and any files transmitted with it are confidential and may contain information which is legally privileged or otherwise exempt from disclosure. They are intended solely for the use of the individual or entity to whom this e-mail is addressed. If you are not one of the named recipients or otherwise have reason to believe that you have received this message in error, please immediately notify the sender and delete this message immediately from your computer. Any other use, retention, dissemination, forwarding, printing, or copying of this e-mail is strictly prohibited.\n",

        "CALL:WORKING FIRE",
        "ADDR:2 BLUEGRASS CT",
        "CITY:TAYLORS",
        "INFO:DIST: 60.52 FT",
        "MAP:14V");

    doTest("T11",
        "[] CAD:LAW ENFORCEMENT NOTIFIED;2 BLUEGRASS CT; TAYL;DIST: 60.52 FT (S) (N)14V\n" +
        "CONFIDENTIALITY NOTICE: This e-mail and any files transmitted with it are confidential and may contain information which is legally privileged or otherwise exempt from disclosure. They are intended solely for the use of the individual or entity to whom this e-mail is addressed. If you are not one of the named recipients or otherwise have reason to believe that you have received this message in error, please immediately notify the sender and delete this message immediately from your computer. Any other use, retention, dissemination, forwarding, printing, or copying of this e-mail is strictly prohibited.\n",

        "CALL:LAW ENFORCEMENT NOTIFIED",
        "ADDR:2 BLUEGRASS CT",
        "CITY:TAYLORS",
        "INFO:DIST: 60.52 FT",
        "MAP:14V");

    doTest("T12",
        "[] CAD:FIRE UNDER CONTROL;2 BLUEGRASS CT; TAYL;DIST: 60.52 FT (S) (N)14V\n" +
        "CONFIDENTIALITY NOTICE: This e-mail and any files transmitted with it are confidential and may contain information which is legally privileged or otherwise exempt from disclosure. They are intended solely for the use of the individual or entity to whom this e-mail is addressed. If you are not one of the named recipients or otherwise have reason to believe that you have received this message in error, please immediately notify the sender and delete this message immediately from your computer. Any other use, retention, dissemination, forwarding, printing, or copying of this e-mail is strictly prohibited.\n",

        "CALL:FIRE UNDER CONTROL",
        "ADDR:2 BLUEGRASS CT",
        "CITY:TAYLORS",
        "INFO:DIST: 60.52 FT",
        "MAP:14V");

    doTest("T13",
        "[] CAD:SERVICE CALL;1798 N 25 HWY/SKYVIEW DR;TRAV;(S) (N)12I;no need for tones [08/28/12 10:21:26 AHINTON] ;TV1\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n" +
        "CONFIDENTIALITY NOTICE: This e-mail and any files transmitted with it are confidential and may contain information which is legally privileged or otherwise exempt from disclosure. They are intended solely for the use of the individual or entity to whom this e-mail is addressed. If you are not one of the named recipients or otherwise have reason to believe that you have received this message in error, please immediately notify the sender and delete this message immediately from your computer. Any other use, retention, dissemination, forwarding, printing, or copying of this e-mail is strictly prohibited.\r\n" +
        "\r\n\n",

        "CALL:SERVICE CALL",
        "ADDR:1798 N 25 HWY & SKYVIEW DR",
        "MADDR:1798 N 25 HWY",
        "CITY:TRAVELERS REST",
        "INFO:no need for tones / TV1",
        "MAP:12I",
        "DATE:08/28/12",
        "TIME:10:21:26");

  }
  
  public static void main(String[] args) {
    new SCGreenvilleCountyParserTest().generateTests("T1");
  }
}