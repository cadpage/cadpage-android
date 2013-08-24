package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Suffolk County, NY (Firetracker)
Contact: Devin McGuinness <radio5390@aol.com>
Sender: dispatch@firetracker.net 
System: Firetracker

(FirePage) ** MASTIC BEACH VAC ** [7-A-2 FI] 340 W DOGWOOD RD Mastic Beach C/S:LYNBROOK DR AND WOODSIDE DR Add't Info: Responde
(FirePage) ** MASTIC BEACH VAC ** [6-C-1 AB] 154 BAYVIEW DR Mastic Beach C/S:MAPLE RD W AND NARCISSUS RD W Add't Info: ........
(FirePage) ** MASTIC BEACH VAC ** [29-D-2M ] ORCHID DR Mastic Beach C/S:ORCHID DR AND CEDAR RD E Add't Info: MVA Number of pati
(FirePage) ** MASTIC BEACH VAC ** [17-B-1 P] 69 ARGYLE DR Shirley C/S:SB WILLIAM FLOYD PKWY AND PINETREE DR Add't Info: 53 YOM 
(FirePage) ** MASTIC BEACH VAC ** [9-E-1 NO] 241 BAYVIEW DR Mastic Beach C/S:CEDAR RD W AND VICTORIA PL Add't Info: AF CARDIAC 
(FirePage) ** MASTIC BEACH VAC ** [26-A-1 N] GRANDVIEW DR Shirley C/S:WESTMINSTER DR AND ARGYLE DR Add't Info: SCPD ECO # 894 5
(FirePage) ** MASTIC BEACH VAC ** [4-B-3A U] 197 LONGFELLOW DR Mastic Beach C/S:PINE RD Add't Info: VICTIM OF AN ASSAULT Number
(FirePage) ** MASTIC BEACH VAC ** [17-D-3 N] 1631 MONTAUK HWY Mastic Beach C/S:GUNTER PL AND ETNA PL Add't Info: AM FELL DOWN S
Subject:FirePage\n** MASTIC BEACH VAC ** [31-D-2 U] SMITH POINT PARK PAVILLION Smith Point\r\n7/29/2012 TOA:21:46 [FireTracker]\r
Subject:FirePage\n** MASTIC BEACH VAC ** [5-A-1 NO] 24 OLD CHURCH RD Mastic Beach Add't\r\nInfo: Number of patients: 1 Responder script: \r

Contact: Kevin Barrett <mbfd478@optonline.net>
Sender: dispatch@firetracker.net
(FirePage) **MASTIC BEACH FD** [52-C-3S ] 97 RIVIERA DR Mastic Beach Add't Info:\nZONE A/A Responder script: Alarms. COMMERCIAL/INDUSTRIAL building (Smoke

*/

public class NYSuffolkCountyFiretrackerParserTest extends BaseParserTest {
  
  public NYSuffolkCountyFiretrackerParserTest() {
    setParser(new NYSuffolkCountyFiretrackerParser(), "SUFFOLK COUNTY", "NY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(FirePage) ** MASTIC BEACH VAC ** [7-A-2 FI] 340 W DOGWOOD RD Mastic Beach C/S:LYNBROOK DR AND WOODSIDE DR Add't Info: Responde",
        "SRC:MASTIC BEACH VAC",
        "CALL:7-A-2 FI",
        "ADDR:340 W DOGWOOD RD",
        "CITY:Mastic Beach",
        "X:LYNBROOK DR AND WOODSIDE DR",
        "INFO:Responde");

    doTest("T2",
        "(FirePage) ** MASTIC BEACH VAC ** [6-C-1 AB] 154 BAYVIEW DR Mastic Beach C/S:MAPLE RD W AND NARCISSUS RD W Add't Info: ........",
        "SRC:MASTIC BEACH VAC",
        "CALL:6-C-1 AB",
        "ADDR:154 BAYVIEW DR",
        "CITY:Mastic Beach",
        "X:MAPLE RD W AND NARCISSUS RD W",
        "INFO:........");

    doTest("T3",
        "(FirePage) ** MASTIC BEACH VAC ** [29-D-2M ] ORCHID DR Mastic Beach C/S:ORCHID DR AND CEDAR RD E Add't Info: MVA Number of pati",
        "SRC:MASTIC BEACH VAC",
        "CALL:29-D-2M",
        "ADDR:ORCHID DR",
        "MADDR:ORCHID DR & CEDAR RD E",
        "CITY:Mastic Beach",
        "X:ORCHID DR AND CEDAR RD E",
        "INFO:MVA Number of pati");

    doTest("T4",
        "(FirePage) ** MASTIC BEACH VAC ** [17-B-1 P] 69 ARGYLE DR Shirley C/S:SB WILLIAM FLOYD PKWY AND PINETREE DR Add't Info: 53 YOM ",
        "SRC:MASTIC BEACH VAC",
        "CALL:17-B-1 P",
        "ADDR:69 ARGYLE DR",
        "CITY:Shirley",
        "X:SB WILLIAM FLOYD PKWY AND PINETREE DR",
        "INFO:53 YOM");

    doTest("T5",
        "(FirePage) ** MASTIC BEACH VAC ** [9-E-1 NO] 241 BAYVIEW DR Mastic Beach C/S:CEDAR RD W AND VICTORIA PL Add't Info: AF CARDIAC ",
        "SRC:MASTIC BEACH VAC",
        "CALL:9-E-1 NO",
        "ADDR:241 BAYVIEW DR",
        "CITY:Mastic Beach",
        "X:CEDAR RD W AND VICTORIA PL",
        "INFO:AF CARDIAC");

    doTest("T6",
        "(FirePage) ** MASTIC BEACH VAC ** [26-A-1 N] GRANDVIEW DR Shirley C/S:WESTMINSTER DR AND ARGYLE DR Add't Info: SCPD ECO # 894 5",
        "SRC:MASTIC BEACH VAC",
        "CALL:26-A-1 N",
        "ADDR:GRANDVIEW DR",
        "MADDR:GRANDVIEW DR & WESTMINSTER DR",
        "CITY:Shirley",
        "X:WESTMINSTER DR AND ARGYLE DR",
        "INFO:SCPD ECO # 894 5");

    doTest("T7",
        "(FirePage) ** MASTIC BEACH VAC ** [4-B-3A U] 197 LONGFELLOW DR Mastic Beach C/S:PINE RD Add't Info: VICTIM OF AN ASSAULT Number",
        "SRC:MASTIC BEACH VAC",
        "CALL:4-B-3A U",
        "ADDR:197 LONGFELLOW DR",
        "CITY:Mastic Beach",
        "X:PINE RD",
        "INFO:VICTIM OF AN ASSAULT Number");

    doTest("T8",
        "(FirePage) ** MASTIC BEACH VAC ** [17-D-3 N] 1631 MONTAUK HWY Mastic Beach C/S:GUNTER PL AND ETNA PL Add't Info: AM FELL DOWN S",
        "SRC:MASTIC BEACH VAC",
        "CALL:17-D-3 N",
        "ADDR:1631 MONTAUK HWY",  // Not mapping
        "CITY:Mastic Beach",
        "X:GUNTER PL AND ETNA PL",
        "INFO:AM FELL DOWN S");

    doTest("T9",
        "Subject:FirePage\n** MASTIC BEACH VAC ** [31-D-2 U] SMITH POINT PARK PAVILLION Smith Point\r\n7/29/2012 TOA:21:46 [FireTracker]\r",
        "SRC:MASTIC BEACH VAC",
        "CALL:31-D-2 U",
        "ADDR:SMITH POINT PARK PAVILLION",
        "CITY:Smith Point",
        "DATE:7/29/2012",
        "TIME:21:46");

    doTest("T10",
        "Subject:FirePage\n" +
        "** MASTIC BEACH VAC ** [5-A-1 NO] 24 OLD CHURCH RD Mastic Beach Add't\r\n" +
        "Info: Number of patients: 1 Responder script: \r",

        "SRC:MASTIC BEACH VAC",
        "CALL:5-A-1 NO",
        "ADDR:24 OLD CHURCH RD",
        "CITY:Mastic Beach",
        "INFO:Number of patients: 1 Responder script:");
  }
  
  @Test
  public void testKevinBarrett() {

    doTest("T1",
        "(FirePage) **MASTIC BEACH FD** [52-C-3S ] 97 RIVIERA DR Mastic Beach Add't Info:\n" +
        "ZONE A/A Responder script: Alarms. COMMERCIAL/INDUSTRIAL building (Smoke",

        "SRC:MASTIC BEACH FD",
        "CALL:52-C-3S",
        "ADDR:97 RIVIERA DR",
        "CITY:Mastic Beach",
        "INFO:ZONE A/A Responder script: Alarms. COMMERCIAL/INDUSTRIAL building (Smoke");
   
  }
  
  public static void main(String[] args) {
    new NYSuffolkCountyFiretrackerParserTest().generateTests("T1");
  }

}