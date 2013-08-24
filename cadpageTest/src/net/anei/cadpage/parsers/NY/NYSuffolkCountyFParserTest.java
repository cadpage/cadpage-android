package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Suffolk County, NY (variant F)
Contact: Hank Messana <emtp217@gmail.com>
Sender: Paging1@firerescuesystems.xohost.com

** 16 Rescue \n** TOA: 12:04 05-07-13 \n** 26-A-10 \n** 3 EAGLE RD\n** CS: FAIRWAY DR ** 2013-000367 \n** AF\n** LOI search completed at 05/07/
** AA Automatic Alarm \n** TOA: 17:22 05-07-13 \n** 52-B-1 \n** 81 HIGH HILL RD\n** CS: REMSEN RD / E WOODLAND DR \n** 2013-000368 \n** KITCHEN
** MV Motor Vehicle Accident \n** TOA: 18:25 05-07-13 \n** 29-D-2L \n** MAIDSTONE LN\n** CS: CANTERBURY DR ** 2013-000369 \n** ** LOI search co
** AA Automatic Alarm \n** TOA: 10:47 05-08-13 \n** 52-C-1 \n** 283 ROUTE 25A\n** CS: DEERFIELD DR / GATEWAY DR \n** 2013-000370 \n** GENERAL F
** 16 Rescue \n** TOA: 15:45 05-08-13 \n** 3-A-1 \n** 1503 N COUNTRY RD\n** CS: N WADING RIVER RD / JACOBS LN \n** 2013-000371 \n** 50 YOF CAT
** AA Automatic Alarm \n** TOA: 12:48 05-09-13 \n** 52-C-3G \n** 2450 N WADING RIVER RD\n** CS: NORTHSIDE RD / CARRIE CT \n** 2013-000373
** AA Automatic Alarm \n** TOA: 15:43 05-10-13 \n** 52-C-3C \n** 5720 ROUTE 25A\n** CS: SOUND AVE / E WIND DR \n** 2013-000377 \n** ALARM\nBody:** 16 Rescue \n** TOA: 20:28 05-10-13 \n** 26-A-8 \n** 364 REMSEN RD\n** CS: ROCKLEIN RD / HIGH HILL RD \n** 2013-000378 \n** AF PAIN\nNumber o
** 16 Rescue \r\n** TOA: 11:23 05-12-13 \r\n** 21-B-1 \r\n** 53 HOWARD ST\r\n** CS: SYLVAN DR / OAKWOOD DR \r\n** 2013-000382 \r\n** RPD 203\r\nNOSE BLEED\r\nN
** 16 Rescue \r\n** TOA: 10:43 05-12-13 \r\n** 30-B-1 \r\n** 703 FRESH POND AV\r\n** CS: 1ST ST / 8TH ST \r\n** 2013-000381 \r\n** HIP INJURY\r\nNumber of pa
** MV Motor Vehicle Accident \n** TOA: 06:21 05-17-13 \n** 29-D-4 \n** WADING RIVER MANOR RD\n** CS: RT 25A / WADING RIVER MANOR RD \n** 2013-0
** 16 Rescue \n** TOA: 11:58 05-17-13 \n** 31-C-2 \n** NB WILLIAM FLOYD PKWY** 2013-000395 \n** A/M\n** LOI search completed at 05/17/13 11:50:
 
Contact: H H <stupman97@gmail.com>
Sender: masticambco@optonline.net
** 16-6 Respiratory \n** TOA: 18:36 05-17-13 \n** 6-D-2 \n** 22 CONCORD RD** CS: STUART RD / TUDOR RD \n** 2013-000925 \n**6-D-2**\r

 */

public class NYSuffolkCountyFParserTest extends BaseParserTest {
  
  public NYSuffolkCountyFParserTest() {
    setParser(new NYSuffolkCountyFParser(), "SUFFOLK COUNTY", "NY");
  }
  
  @Test
  public void testAmmityvilleFire() {

    doTest("T1",
        "** 16 Rescue \n" +
        "** TOA: 12:04 05-07-13 \n" +
        "** 26-A-10 \n" +
        "** 3 EAGLE RD\n" +
        "** CS: FAIRWAY DR ** 2013-000367 \n" +
        "** AF\n" +
        "** LOI search completed at 05/07/",

        "CALL:16 Rescue",
        "TIME:12:04",
        "DATE:05/07/13",
        "CODE:26-A-10",
        "ADDR:3 EAGLE RD",
        "X:FAIRWAY DR",
        "ID:2013-000367",
        "INFO:AF / LOI search completed at 05/07/");

    doTest("T2",
        "** AA Automatic Alarm \n" +
        "** TOA: 17:22 05-07-13 \n" +
        "** 52-B-1 \n" +
        "** 81 HIGH HILL RD\n" +
        "** CS: REMSEN RD / E WOODLAND DR \n" +
        "** 2013-000368 \n" +
        "** KITCHEN",

        "CALL:AA Automatic Alarm",
        "TIME:17:22",
        "DATE:05/07/13",
        "CODE:52-B-1",
        "ADDR:81 HIGH HILL RD",
        "X:REMSEN RD / E WOODLAND DR",
        "ID:2013-000368",
        "INFO:KITCHEN");

    doTest("T3",
        "** MV Motor Vehicle Accident \n" +
        "** TOA: 18:25 05-07-13 \n" +
        "** 29-D-2L \n" +
        "** MAIDSTONE LN\n" +
        "** CS: CANTERBURY DR ** 2013-000369 \n" +
        "** ** LOI search co",

        "CALL:MV Motor Vehicle Accident",
        "TIME:18:25",
        "DATE:05/07/13",
        "CODE:29-D-2L",
        "ADDR:MAIDSTONE LN",
        "MADDR:MAIDSTONE LN & CANTERBURY DR",
        "X:CANTERBURY DR",
        "ID:2013-000369",
        "INFO:LOI search co");

    doTest("T4",
        "** AA Automatic Alarm \n" +
        "** TOA: 10:47 05-08-13 \n" +
        "** 52-C-1 \n" +
        "** 283 ROUTE 25A\n" +
        "** CS: DEERFIELD DR / GATEWAY DR \n" +
        "** 2013-000370 \n" +
        "** GENERAL F",

        "CALL:AA Automatic Alarm",
        "TIME:10:47",
        "DATE:05/08/13",
        "CODE:52-C-1",
        "ADDR:283 ROUTE 25A",
        "X:DEERFIELD DR / GATEWAY DR",
        "ID:2013-000370",
        "INFO:GENERAL F");

    doTest("T5",
        "** 16 Rescue \n" +
        "** TOA: 15:45 05-08-13 \n" +
        "** 3-A-1 \n" +
        "** 1503 N COUNTRY RD\n" +
        "** CS: N WADING RIVER RD / JACOBS LN \n" +
        "** 2013-000371 \n" +
        "** 50 YOF CAT",

        "CALL:16 Rescue",
        "TIME:15:45",
        "DATE:05/08/13",
        "CODE:3-A-1",
        "ADDR:1503 N COUNTRY RD",
        "X:N WADING RIVER RD / JACOBS LN",
        "ID:2013-000371",
        "INFO:50 YOF CAT");

    doTest("T6",
        "** AA Automatic Alarm \n" +
        "** TOA: 12:48 05-09-13 \n" +
        "** 52-C-3G \n" +
        "** 2450 N WADING RIVER RD\n" +
        "** CS: NORTHSIDE RD / CARRIE CT \n" +
        "** 2013-000373",

        "CALL:AA Automatic Alarm",
        "TIME:12:48",
        "DATE:05/09/13",
        "CODE:52-C-3G",
        "ADDR:2450 N WADING RIVER RD",
        "X:NORTHSIDE RD / CARRIE CT",
        "ID:2013-000373");

    doTest("T7",
        "** AA Automatic Alarm \n" +
        "** TOA: 12:48 05-09-13 \n" +
        "** 52-C-3G \n" +
        "** 2450 N WADING RIVER RD\n" +
        "** CS: NORTHSIDE RD / CARRIE CT \n" +
        "** 2013-000373",

        "CALL:AA Automatic Alarm",
        "TIME:12:48",
        "DATE:05/09/13",
        "CODE:52-C-3G",
        "ADDR:2450 N WADING RIVER RD",
        "X:NORTHSIDE RD / CARRIE CT",
        "ID:2013-000373");

    doTest("T8",
        "** AA Automatic Alarm \n" +
        "** TOA: 15:43 05-10-13 \n" +
        "** 52-C-3C \n" +
        "** 5720 ROUTE 25A\n" +
        "** CS: SOUND AVE / E WIND DR \n" +
        "** 2013-000377 \n" +
        "** ALARM\n" +
        "Body:** 16 Rescue \n" +
        "** TOA: 20:28 05-10-13 \n" +
        "** 26-A-8 \n" +
        "** 364 REMSEN RD\n" +
        "** CS: ROCKLEIN RD / HIGH HILL RD \n" +
        "** 2013-000378 \n" +
        "** AF PAIN\n" +
        "Number o",

        "CALL:AA Automatic Alarm",
        "TIME:15:43",
        "DATE:05/10/13",
        "CODE:52-C-3C",
        "ADDR:5720 ROUTE 25A",
        "X:SOUND AVE / E WIND DR",
        "ID:2013-000377",
        "INFO:ALARM\nBody: / 16 Rescue / TOA: 20:28 05-10-13 / 26-A-8 / 364 REMSEN RD / CS: ROCKLEIN RD / HIGH HILL RD / 2013-000378 / AF PAIN\nNumber o");

    doTest("T9",
        "** 16 Rescue \r\n" +
        "** TOA: 11:23 05-12-13 \r\n" +
        "** 21-B-1 \r\n" +
        "** 53 HOWARD ST\r\n" +
        "** CS: SYLVAN DR / OAKWOOD DR \r\n" +
        "** 2013-000382 \r\n" +
        "** RPD 203\r\n" +
        "NOSE BLEED\r\n" +
        "N",

        "CALL:16 Rescue",
        "TIME:11:23",
        "DATE:05/12/13",
        "CODE:21-B-1",
        "ADDR:53 HOWARD ST",
        "X:SYLVAN DR / OAKWOOD DR",
        "ID:2013-000382",
        "INFO:RPD 203\nNOSE BLEED\nN");

    doTest("T10",
        "** 16 Rescue \r\n" +
        "** TOA: 10:43 05-12-13 \r\n" +
        "** 30-B-1 \r\n" +
        "** 703 FRESH POND AV\r\n" +
        "** CS: 1ST ST / 8TH ST \r\n" +
        "** 2013-000381 \r\n" +
        "** HIP INJURY\r\n" +
        "Number of pa",

        "CALL:16 Rescue",
        "TIME:10:43",
        "DATE:05/12/13",
        "CODE:30-B-1",
        "ADDR:703 FRESH POND AV",
        "MADDR:703 FRESH POND AVE",
        "X:1ST ST / 8TH ST",
        "ID:2013-000381",
        "INFO:HIP INJURY\nNumber of pa");

    doTest("T11",
        "** MV Motor Vehicle Accident \n" +
        "** TOA: 06:21 05-17-13 \n" +
        "** 29-D-4 \n" +
        "** WADING RIVER MANOR RD\n" +
        "** CS: RT 25A / WADING RIVER MANOR RD \n" +
        "** 2013-0",

        "CALL:MV Motor Vehicle Accident",
        "TIME:06:21",
        "DATE:05/17/13",
        "CODE:29-D-4",
        "ADDR:WADING RIVER MANOR RD",
        "MADDR:WADING RIVER MANOR RD & RT 25A",
        "X:RT 25A / WADING RIVER MANOR RD");

    doTest("T12",
        "** 16 Rescue \n" +
        "** TOA: 11:58 05-17-13 \n" +
        "** 31-C-2 \n" +
        "** NB WILLIAM FLOYD PKWY** 2013-000395 \n" +
        "** A/M\n" +
        "** LOI search completed at 05/17/13 11:50:",

        "CALL:16 Rescue",
        "TIME:11:58",
        "DATE:05/17/13",
        "CODE:31-C-2",
        "ADDR:NB WILLIAM FLOYD PKWY",
        "MADDR:WILLIAM FLOYD PKWY",
        "ID:2013-000395",
        "INFO:A/M / LOI search completed at 05/17/13 11:50:");

  }
  
  @Test
  public void testHH() {

    doTest("T1",
        "** 16-6 Respiratory \n** TOA: 18:36 05-17-13 \n** 6-D-2 \n** 22 CONCORD RD** CS: STUART RD / TUDOR RD \n** 2013-000925 \n**6-D-2**\r",
        "CALL:16-6 Respiratory",
        "TIME:18:36",
        "DATE:05/17/13",
        "CODE:6-D-2",
        "ADDR:22 CONCORD RD",
        "X:STUART RD / TUDOR RD",
        "ID:2013-000925");

  }
  
  public static void main(String[] args) {
    new NYSuffolkCountyFParserTest().generateTests("T1");
  }
}