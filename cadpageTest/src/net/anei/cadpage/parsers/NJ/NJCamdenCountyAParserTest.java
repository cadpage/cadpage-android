package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NJCamdenCountyAParserTest extends BaseParserTest {
  
  public NJCamdenCountyAParserTest() {
    setParser(new NJCamdenCountyAParser(), "CAMDEN COUNTY", "NJ");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Dispatch SD45) DWELLING\n312 9TH ST ,14\n#:\nX:CENTER/CHERRY\nZN:14A\nCP:  2011-03-31 10:44:12\nMI#:110073123\nRES#:SD45",
        "CALL:DWELLING",
        "ADDR:312 9TH ST",
        "CITY:Gloucester City",
        "X:CENTER/CHERRY",
        "MAP:14A",
        "DATE:03/31/2011",
        "TIME:10:44:12",
        "ID:110073123",
        "UNIT:SD45");

    doTest("T2",
        "(Dispatch SD45) M.V.A\n" +
        "ROUTE 295 SB RAMP TO 76 SB ALJO CUR ,04\n" +
        "#:\n" +
        "X:/\n" +
        "ZN:04Q\n" +
        "CP:ROUTE 295 SB RAMP T  2011-03-31 09:06:36\n" +
        "MI#:110073062 ",

        "CALL:M.V.A",
        "ADDR:ROUTE 295 SB",
        "MADDR:RAMP TO 76 SB ALJO CUR ROUTE 295 SB RAMP T,ROUTE 295",
        "CITY:Bellmawr",
        "MAP:04Q",
        "PLACE:RAMP TO 76 SB ALJO CUR ROUTE 295 SB RAMP T",
        "DATE:03/31/2011",
        "TIME:09:06:36",
        "ID:110073062",
        "UNIT:SD45");

    doTest("T3",
        "(Dispatch SD45) DIABETIC\n" +
        "217 BLACK HORSE PK N ,25\n" +
        "#:4\n" +
        "X:CARLISLE/LAKEVIEW\n" +
        "ZN:25B\n" +
        "CP:MAX GROUP PHILLY CO  2011-03-30 13:23:26\n" +
        "MI#:11007",

        "CALL:DIABETIC",
        "ADDR:217 BLACK HORSE PK N",
        "MADDR:217 BLACK HORSE PIKE N",
        "CITY:Mount Ephraim",
        "APT:4",
        "X:CARLISLE/LAKEVIEW",
        "MAP:25B",
        "PLACE:MAX GROUP PHILLY CO",
        "DATE:03/30/2011",
        "TIME:13:23:26",
        "ID:11007",
        "UNIT:SD45");

    doTest("T4",
        "(Dispatch SD45) DWELLING\nBURLINGTON ST S/MONMOUTH ST ,14\n#:\nX:/\nZN:14A\nCP:  2011-03-30 10:33:28\nMI#:110072287\nRES#:SD45",
        "CALL:DWELLING",
        "ADDR:BURLINGTON ST S & MONMOUTH ST",
        "CITY:Gloucester City",
        "MAP:14A",
        "DATE:03/30/2011",
        "TIME:10:33:28",
        "ID:110072287",
        "UNIT:SD45");
  }
  
  @Test
  public void testSteveKane() {

    doTest("T1",
        "(Dispatch QT60) APARTMENT  \n" +
        "1800 LAUREL RD ,22   \n" +
        "#:114  \n" +
        "X:BLACKWOOD CLEMENTON/  \n" +
        "ZN:22B  \n" +
        "CP:STONINGTON COURT AP  2012-03-09 07:24:49  \n" +
        "MI#:",

        "CALL:APARTMENT",
        "ADDR:1800 LAUREL RD",
        "CITY:Lindenwold",
        "APT:114",
        "X:BLACKWOOD CLEMENTON/",
        "MAP:22B",
        "PLACE:STONINGTON COURT AP",
        "DATE:03/09/2012",
        "TIME:07:24:49",
        "UNIT:QT60");

  }
 
  @Test
  public void testGuyDietrick() {

    doTest("T1",
        "Subject:Dispatch SD11\n" +
        "INCIDENTAL  \r\n" +
        "260 AUDUBON AV ,01   \r\n" +
        "#:  \r\n" +
        "X:BELOIT/WYOMING  \r\n" +
        "ZN:01A  \r\n" +
        "CP:  2012-03-25 07:29:59  \r\n" +
        "MI#:1200\r",

        "CALL:INCIDENTAL",
        "ADDR:260 AUDUBON AV",
        "MADDR:260 AUDUBON AVE",
        "CITY:Audubon",
        "X:BELOIT/WYOMING",
        "MAP:01A",
        "DATE:03/25/2012",
        "TIME:07:29:59",
        "ID:1200",
        "UNIT:SD11");

  }
  
  @Test
  public void testActive911() {

    doTest("T1",
        "Subject: Dispatch SD379\n" +
        "INCIDENTAL  \n" +
        "217 RUSSELL AV ,03 03;HOUSE NEXT DO  \n" +
        "#:  \n" +
        "X:MOORE/RICHARDS  \n" +
        "ZN:03D  \n" +
        "CP:  2012-05-18 23:01:45  \n" +
        "MI#:120117862  \n" +
        "RES#:SD379",

        "CALL:INCIDENTAL",
        "ADDR:217 RUSSELL AV",
        "MADDR:217 RUSSELL AVE",
        "CITY:Barrington",
        "X:MOORE/RICHARDS",
        "MAP:03D",
        "PLACE:HOUSE NEXT DO",
        "DATE:05/18/2012",
        "TIME:23:01:45",
        "ID:120117862",
        "UNIT:SD379");

    doTest("T2",
        "Subject: Dispatch SD379\n" +
        "M.V.A  \n" +
        "ROUTE 295 EXIT 28 ,18   \n" +
        "#:  \n" +
        "X:/  \n" +
        "ZN:03W  \n" +
        "CP:ROUTE 295 EXIT 28  2012-05-19 02:38:47  \n" +
        "MI#:120118005  \n" +
        "RES#:SD379",

        "CALL:M.V.A",
        "ADDR:ROUTE 295",
        "MADDR:EXIT 28 ROUTE 295 EXIT 28,ROUTE 295",
        "CITY:Haddon Heights",
        "MAP:03W",
        "PLACE:EXIT 28 ROUTE 295 EXIT 28",
        "DATE:05/19/2012",
        "TIME:02:38:47",
        "ID:120118005",
        "UNIT:SD379");

    doTest("T3",
        "Subject: Dispatch R32\n" +
        "APARTMENT  \n" +
        "1306 HANCOCK DR ,03   \n" +
        "#:5  \n" +
        "X:CLEMENTS BRIDGE RD/  \n" +
        "ZN:03D  \n" +
        "CP:WILLOWS APTS  2012-05-20 07:08:50  \n" +
        "MI#:120118985  \n" +
        "RES#:R32",

        "CALL:APARTMENT",
        "ADDR:1306 HANCOCK DR",
        "CITY:Barrington",
        "APT:5",
        "X:CLEMENTS BRIDGE RD/",
        "MAP:03D",
        "PLACE:WILLOWS APTS",
        "DATE:05/20/2012",
        "TIME:07:08:50",
        "ID:120118985",
        "UNIT:R32");

    doTest("T4",
        "Subject: Dispatch R32\n" +
        "RESCUE  \n" +
        "ROUTE 42 EXIT 14 ,04   \n" +
        "#:  \n" +
        "X:/  \n" +
        "ZN:BMA  \n" +
        "CP:ROUTE 42 EXIT 14  2012-05-19 16:47:48  \n" +
        "MI#:120118461  \n" +
        "RES#:R32",

        "CALL:RESCUE",
        "ADDR:ROUTE 42",
        "MADDR:EXIT 14 ROUTE 42 EXIT 14,ROUTE 42",
        "CITY:Bellmawr",
        "MAP:BMA",
        "PLACE:EXIT 14 ROUTE 42 EXIT 14",
        "DATE:05/19/2012",
        "TIME:16:47:48",
        "ID:120118461",
        "UNIT:R32");
   
  }
  
  @Test
  public void testRunReport() {

    doTest("T1",
        "[Free SD379] ROUTE 295 EXIT 28 ,18 18  \n" +
        "MI#:120118005  \n" +
        "Disp:02:38:48  \n" +
        "Enr:  \n" +
        "Arr:  \n" +
        "Enr Hosp:  \n" +
        "Arr Hosp:  \n" +
        "Clr:02:39:15  \n" +
        "RES#:SD379  \n",

        "CALL:RUN REPORT",
        "PLACE:ROUTE 295 EXIT 28 ,18 18  \nMI#:120118005  \nDisp:02:38:48  \nEnr:  \nArr:  \nEnr Hosp:  \nArr Hosp:  \nClr:02:39:15  \nRES#:SD379",
        "UNIT:SD379");
    

    doTest("T2",
        "[Free SD32] 294 ROUTE 295 ,04 04  \n" +
        "MI#:120118005  \n" +
        "Disp:02:39:15  \n" +
        "Enr:02:41:47  \n" +
        "Arr:02:47:43  \n" +
        "Enr Hosp:  \n" +
        "Arr Hosp:  \n" +
        "Clr:02:59:23  \n" +
        "RES#:SD32  \n",

        "CALL:RUN REPORT",
        "PLACE:294 ROUTE 295 ,04 04  \nMI#:120118005  \nDisp:02:39:15  \nEnr:02:41:47  \nArr:02:47:43  \nEnr Hosp:  \nArr Hosp:  \nClr:02:59:23  \nRES#:SD32",
        "UNIT:SD32");

  }
  
  public static void main(String[] args) {
    new NJCamdenCountyAParserTest().generateTests("T1");
  }
}