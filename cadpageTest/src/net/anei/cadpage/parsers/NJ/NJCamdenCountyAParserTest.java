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
        "ID:120118005",
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
        "ID:120118005",
        "UNIT:SD32");

    doTest("T3",
        "[Free R32] ROUTE 295 EXIT 26 ,04 04  \n" +
        "MI#:120140280  \n" +
        "Disp:18:32:56  \n" +
        "Enr:18:33:27  \n" +
        "Arr:18:35:41  \n" +
        "Enr Hosp:  \n" +
        "Arr Hosp:  \n" +
        "Clr:18:51:43  \n" +
        "RES#:R32  \n",

        "CALL:RUN REPORT",
        "PLACE:ROUTE 295 EXIT 26 ,04 04  \nMI#:120140280  \nDisp:18:32:56  \nEnr:18:33:27  \nArr:18:35:41  \nEnr Hosp:  \nArr Hosp:  \nClr:18:51:43  \nRES#:R32",
        "ID:120140280",
        "UNIT:R32");

  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "[Free SD63] MAPLE AV E/WALNUT AV ,22 22  \r\n" +
        "MI#:120188119  \r\n" +
        "Disp:18:55:46  \r\n" +
        "Enr:18:58:16  \r\n" +
        "Arr:18:59:24  \r\n" +
        "Enr Hosp:  \r\n" +
        "Arr Hosp:  \r\n" +
        "Clr:19:08:14  \r\n" +
        "RES#:SD63  \r\n\n",

        "CALL:RUN REPORT",
        "PLACE:MAPLE AV E/WALNUT AV ,22 22  \nMI#:120188119  \nDisp:18:55:46  \nEnr:18:58:16  \nArr:18:59:24  \nEnr Hosp:  \nArr Hosp:  \nClr:19:08:14  \nRES#:SD63",
        "ID:120188119",
        "UNIT:SD63");

    doTest("T2",
        "[Dispatch SD63] WIRES/BURNING  \r\n" +
        "LOWELL AV S/CHESTNUT AV ,22   \r\n" +
        "#:  \r\n" +
        "X:/  \r\n" +
        "ZN:22A  \r\n" +
        "CP:  2012-08-05 21:25:36  \r\n" +
        "MI#:120188244  \r\n" +
        "RES#:SD63\r\n\n",

        "CALL:WIRES/BURNING",
        "ADDR:LOWELL AV S & CHESTNUT AV",
        "MADDR:LOWELL AVE S & CHESTNUT AVE",
        "CITY:Lindenwold",
        "MAP:22A",
        "DATE:08/05/2012",
        "TIME:21:25:36",
        "ID:120188244",
        "UNIT:SD63");

    doTest("T3",
        "[Dispatch F6302] WIRES  \r\n" +
        "LOWELL AV S/CHESTNUT AV ,22   \r\n" +
        "#:  \r\n" +
        "X:/  \r\n" +
        "ZN:22A  \r\n" +
        "CP:  2012-08-05 21:25:36  \r\n" +
        "MI#:120188244  \r\n" +
        "RES#:F6302\r\n\n",

        "CALL:WIRES",
        "ADDR:LOWELL AV S & CHESTNUT AV",
        "MADDR:LOWELL AVE S & CHESTNUT AVE",
        "CITY:Lindenwold",
        "MAP:22A",
        "DATE:08/05/2012",
        "TIME:21:25:36",
        "ID:120188244",
        "UNIT:F6302");

    doTest("T4",
        "[Free SD63] LOWELL AV S/CHESTNUT AV ,22 22  \r\n" +
        "MI#:120188244  \r\n" +
        "Disp:21:25:36  \r\n" +
        "Enr:21:33:08  \r\n" +
        "Arr:21:34:52  \r\n" +
        "Enr Hosp:  \r\n" +
        "Arr Hosp:  \r\n" +
        "Clr:22:12:54  \r\n" +
        "RES#:SD63  \r\n\n",

        "CALL:RUN REPORT",
        "PLACE:LOWELL AV S/CHESTNUT AV ,22 22  \nMI#:120188244  \nDisp:21:25:36  \nEnr:21:33:08  \nArr:21:34:52  \nEnr Hosp:  \nArr Hosp:  \nClr:22:12:54  \nRES#:SD63",
        "ID:120188244",
        "UNIT:SD63");

    doTest("T5",
        "[Free F6302] LOWELL AV S/CHESTNUT AV ,22 22  \r\n" +
        "MI#:120188244  \r\n" +
        "Disp:21:28:53  \r\n" +
        "Enr:21:28:54  \r\n" +
        "Arr:21:33:33  \r\n" +
        "Enr Hosp:  \r\n" +
        "Arr Hosp:  \r\n" +
        "Clr:22:12:55  \r\n" +
        "RES#:F6302  \r\n\n",

        "CALL:RUN REPORT",
        "PLACE:LOWELL AV S/CHESTNUT AV ,22 22  \nMI#:120188244  \nDisp:21:28:53  \nEnr:21:28:54  \nArr:21:33:33  \nEnr Hosp:  \nArr Hosp:  \nClr:22:12:55  \nRES#:F6302",
        "ID:120188244",
        "UNIT:F6302");

    doTest("T6",
        "[Dispatch TF632] APARTMENT  \r\n" +
        "800 CHEWS LANDING RD ,22   \r\n" +
        "#:2E  \r\n" +
        "X:LAUREL/BORO LINE  \r\n" +
        "ZN:22B  \r\n" +
        "CP:LAUREL HILL APTS  2012-08-07 04:06:52  \r\n" +
        "MI#:120189349  \r\n" +
        "RES#:TF632\r\n\n",

        "CALL:APARTMENT",
        "ADDR:800 CHEWS LANDING RD",
        "CITY:Lindenwold",
        "APT:2E",
        "X:LAUREL/BORO LINE",
        "MAP:22B",
        "PLACE:LAUREL HILL APTS",
        "DATE:08/07/2012",
        "TIME:04:06:52",
        "ID:120189349",
        "UNIT:TF632");

    doTest("T7",
        "[Dispatch S632] APARTMENT  \r\n" +
        "800 CHEWS LANDING RD ,22   \r\n" +
        "#:2E  \r\n" +
        "X:LAUREL/BORO LINE  \r\n" +
        "ZN:22B  \r\n" +
        "CP:LAUREL HILL APTS  2012-08-07 04:06:52  \r\n" +
        "MI#:120189349  \r\n" +
        "RES#:S632\r\n\n",

        "CALL:APARTMENT",
        "ADDR:800 CHEWS LANDING RD",
        "CITY:Lindenwold",
        "APT:2E",
        "X:LAUREL/BORO LINE",
        "MAP:22B",
        "PLACE:LAUREL HILL APTS",
        "DATE:08/07/2012",
        "TIME:04:06:52",
        "ID:120189349",
        "UNIT:S632");

    doTest("T8",
        "[Dispatch L63] APARTMENT  \r\n" +
        "800 CHEWS LANDING RD ,22   \r\n" +
        "#:2E  \r\n" +
        "X:LAUREL/BORO LINE  \r\n" +
        "ZN:22B  \r\n" +
        "CP:LAUREL HILL APTS  2012-08-07 04:06:52  \r\n" +
        "MI#:120189349  \r\n" +
        "RES#:L63\r\n\n",

        "CALL:APARTMENT",
        "ADDR:800 CHEWS LANDING RD",
        "CITY:Lindenwold",
        "APT:2E",
        "X:LAUREL/BORO LINE",
        "MAP:22B",
        "PLACE:LAUREL HILL APTS",
        "DATE:08/07/2012",
        "TIME:04:06:52",
        "ID:120189349",
        "UNIT:L63");

    doTest("T9",
        "[Dispatch SD63] APARTMENT  \r\n" +
        "800 CHEWS LANDING RD ,22   \r\n" +
        "#:2E  \r\n" +
        "X:LAUREL/BORO LINE  \r\n" +
        "ZN:22B  \r\n" +
        "CP:LAUREL HILL APTS  2012-08-07 04:06:52  \r\n" +
        "MI#:120189349  \r\n" +
        "RES#:SD63\r\n\n",

        "CALL:APARTMENT",
        "ADDR:800 CHEWS LANDING RD",
        "CITY:Lindenwold",
        "APT:2E",
        "X:LAUREL/BORO LINE",
        "MAP:22B",
        "PLACE:LAUREL HILL APTS",
        "DATE:08/07/2012",
        "TIME:04:06:52",
        "ID:120189349",
        "UNIT:SD63");

    doTest("T10",
        "[Dispatch SQ63] APARTMENT  \r\n" +
        "800 CHEWS LANDING RD ,22   \r\n" +
        "#:2E  \r\n" +
        "X:LAUREL/BORO LINE  \r\n" +
        "ZN:22B  \r\n" +
        "CP:LAUREL HILL APTS  2012-08-07 04:06:52  \r\n" +
        "MI#:120189349  \r\n" +
        "RES#:SQ63\r\n\n",

        "CALL:APARTMENT",
        "ADDR:800 CHEWS LANDING RD",
        "CITY:Lindenwold",
        "APT:2E",
        "X:LAUREL/BORO LINE",
        "MAP:22B",
        "PLACE:LAUREL HILL APTS",
        "DATE:08/07/2012",
        "TIME:04:06:52",
        "ID:120189349",
        "UNIT:SQ63");

    doTest("T11",
        "[Dispatch E63] APARTMENT  \r\n" +
        "800 CHEWS LANDING RD ,22   \r\n" +
        "#:2E  \r\n" +
        "X:LAUREL/BORO LINE  \r\n" +
        "ZN:22B  \r\n" +
        "CP:LAUREL HILL APTS  2012-08-07 04:06:52  \r\n" +
        "MI#:120189349  \r\n" +
        "RES#:E63\r\n\n",

        "CALL:APARTMENT",
        "ADDR:800 CHEWS LANDING RD",
        "CITY:Lindenwold",
        "APT:2E",
        "X:LAUREL/BORO LINE",
        "MAP:22B",
        "PLACE:LAUREL HILL APTS",
        "DATE:08/07/2012",
        "TIME:04:06:52",
        "ID:120189349",
        "UNIT:E63");

    doTest("T12",
        "[Free SQ63] 800 CHEWS LANDING RD ,22 22  \r\n" +
        "MI#:120189349  \r\n" +
        "Disp:04:17:38  \r\n" +
        "Enr:04:17:40  \r\n" +
        "Arr:  \r\n" +
        "Enr Hosp:  \r\n" +
        "Arr Hosp:  \r\n" +
        "Clr:04:19:52  \r\n" +
        "RES#:SQ63  \r\n\n",

        "CALL:RUN REPORT",
        "PLACE:800 CHEWS LANDING RD ,22 22  \nMI#:120189349  \nDisp:04:17:38  \nEnr:04:17:40  \nArr:  \nEnr Hosp:  \nArr Hosp:  \nClr:04:19:52  \nRES#:SQ63",
        "ID:120189349",
        "UNIT:SQ63");

    doTest("T13",
        "[Free E63] 800 CHEWS LANDING RD ,22 22  \r\n" +
        "MI#:120189349  \r\n" +
        "Disp:04:18:09  \r\n" +
        "Enr:04:18:10  \r\n" +
        "Arr:  \r\n" +
        "Enr Hosp:  \r\n" +
        "Arr Hosp:  \r\n" +
        "Clr:04:19:52  \r\n" +
        "RES#:E63  \r\n\n",

        "CALL:RUN REPORT",
        "PLACE:800 CHEWS LANDING RD ,22 22  \nMI#:120189349  \nDisp:04:18:09  \nEnr:04:18:10  \nArr:  \nEnr Hosp:  \nArr Hosp:  \nClr:04:19:52  \nRES#:E63",
        "ID:120189349",
        "UNIT:E63");

    doTest("T14",
        "[Free SD63] 800 CHEWS LANDING RD ,22 22  \r\n" +
        "MI#:120189349  \r\n" +
        "Disp:04:15:28  \r\n" +
        "Enr:04:15:29  \r\n" +
        "Arr:  \r\n" +
        "Enr Hosp:  \r\n" +
        "Arr Hosp:  \r\n" +
        "Clr:04:19:52  \r\n" +
        "RES#:SD63  \r\n\n",

        "CALL:RUN REPORT",
        "PLACE:800 CHEWS LANDING RD ,22 22  \nMI#:120189349  \nDisp:04:15:28  \nEnr:04:15:29  \nArr:  \nEnr Hosp:  \nArr Hosp:  \nClr:04:19:52  \nRES#:SD63",
        "ID:120189349",
        "UNIT:SD63");

    doTest("T15",
        "[Free L63] 800 CHEWS LANDING RD ,22 22  \r\n" +
        "MI#:120189349  \r\n" +
        "Disp:04:13:02  \r\n" +
        "Enr:04:13:03  \r\n" +
        "Arr:  \r\n" +
        "Enr Hosp:  \r\n" +
        "Arr Hosp:  \r\n" +
        "Clr:04:19:52  \r\n" +
        "RES#:L63  \r\n\n",

        "CALL:RUN REPORT",
        "PLACE:800 CHEWS LANDING RD ,22 22  \nMI#:120189349  \nDisp:04:13:02  \nEnr:04:13:03  \nArr:  \nEnr Hosp:  \nArr Hosp:  \nClr:04:19:52  \nRES#:L63",
        "ID:120189349",
        "UNIT:L63");

    doTest("T16",
        "[Free S632] 800 CHEWS LANDING RD ,22 22  \r\n" +
        "MI#:120189349  \r\n" +
        "Disp:04:06:53  \r\n" +
        "Enr:  \r\n" +
        "Arr:  \r\n" +
        "Enr Hosp:  \r\n" +
        "Arr Hosp:  \r\n" +
        "Clr:  \r\n" +
        "RES#:S632  \r\n\n",

        "CALL:RUN REPORT",
        "PLACE:800 CHEWS LANDING RD ,22 22  \nMI#:120189349  \nDisp:04:06:53  \nEnr:  \nArr:  \nEnr Hosp:  \nArr Hosp:  \nClr:  \nRES#:S632",
        "ID:120189349",
        "UNIT:S632");

    doTest("T17",
        "[Dispatch L63] APARTMENT  \r\n" +
        "800 CHEWS LANDING RD ,22   \r\n" +
        "#:2E  \r\n" +
        "X:LAUREL/BORO LINE  \r\n" +
        "ZN:22B  \r\n" +
        "CP:LAUREL HILL APTS  2012-08-07 04:06:52  \r\n" +
        "MI#:120189349  \r\n" +
        "RES#:L63\r\n\n",

        "CALL:APARTMENT",
        "ADDR:800 CHEWS LANDING RD",
        "CITY:Lindenwold",
        "APT:2E",
        "X:LAUREL/BORO LINE",
        "MAP:22B",
        "PLACE:LAUREL HILL APTS",
        "DATE:08/07/2012",
        "TIME:04:06:52",
        "ID:120189349",
        "UNIT:L63");

    doTest("T18",
        "[Free TF632] 800 CHEWS LANDING RD ,22 22  \r\n" +
        "MI#:120189349  \r\n" +
        "Disp:04:06:53  \r\n" +
        "Enr:  \r\n" +
        "Arr:04:17:52  \r\n" +
        "Enr Hosp:  \r\n" +
        "Arr Hosp:  \r\n" +
        "Clr:05:06:23  \r\n" +
        "RES#:TF632  \r\n\n",

        "CALL:RUN REPORT",
        "PLACE:800 CHEWS LANDING RD ,22 22  \nMI#:120189349  \nDisp:04:06:53  \nEnr:  \nArr:04:17:52  \nEnr Hosp:  \nArr Hosp:  \nClr:05:06:23  \nRES#:TF632",
        "ID:120189349",
        "UNIT:TF632");

    doTest("T19",
        "[Free L63] 800 CHEWS LANDING RD ,22 22  \r\n" +
        "MI#:120189349  \r\n" +
        "Disp:04:13:02  \r\n" +
        "Enr:04:13:03  \r\n" +
        "Arr:04:45:24  \r\n" +
        "Enr Hosp:  \r\n" +
        "Arr Hosp:  \r\n" +
        "Clr:05:06:25  \r\n" +
        "RES#:L63  \r\n\n",

        "CALL:RUN REPORT",
        "PLACE:800 CHEWS LANDING RD ,22 22  \nMI#:120189349  \nDisp:04:13:02  \nEnr:04:13:03  \nArr:04:45:24  \nEnr Hosp:  \nArr Hosp:  \nClr:05:06:25  \nRES#:L63",
        "ID:120189349",
        "UNIT:L63");

    doTest("T20",
        "[Dispatch SQ63] ALARM SYSTEM  \r\n" +
        "900 GIBBSBORO RD ,22   \r\n" +
        "#:  \r\n" +
        "X:WILSON/HILLIARDS  \r\n" +
        "ZN:22A  \r\n" +
        "CP:LINDENWOLD SCHOOL 4  2012-08-08 07:37:16  \r\n" +
        "MI#:120190307  \r\n" +
        "RES#:SQ63\r\n\n",

        "CALL:ALARM SYSTEM",
        "ADDR:900 GIBBSBORO RD",
        "CITY:Lindenwold",
        "X:WILSON/HILLIARDS",
        "MAP:22A",
        "PLACE:LINDENWOLD SCHOOL 4",
        "DATE:08/08/2012",
        "TIME:07:37:16",
        "ID:120190307",
        "UNIT:SQ63");

    doTest("T21",
        "[Dispatch L63] ALARM SYSTEM  \r\n" +
        "900 GIBBSBORO RD ,22   \r\n" +
        "#:  \r\n" +
        "X:WILSON/HILLIARDS  \r\n" +
        "ZN:22A  \r\n" +
        "CP:LINDENWOLD SCHOOL 4  2012-08-08 07:37:16  \r\n" +
        "MI#:120190307  \r\n" +
        "RES#:L63\r\n\n",

        "CALL:ALARM SYSTEM",
        "ADDR:900 GIBBSBORO RD",
        "CITY:Lindenwold",
        "X:WILSON/HILLIARDS",
        "MAP:22A",
        "PLACE:LINDENWOLD SCHOOL 4",
        "DATE:08/08/2012",
        "TIME:07:37:16",
        "ID:120190307",
        "UNIT:L63");

    doTest("T22",
        "[Dispatch F6301] ALARM SYSTEM  \r\n" +
        "900 GIBBSBORO RD ,22   \r\n" +
        "#:  \r\n" +
        "X:WILSON/HILLIARDS  \r\n" +
        "ZN:22A  \r\n" +
        "CP:LINDENWOLD SCHOOL 4  2012-08-08 07:37:16  \r\n" +
        "MI#:120190307  \r\n" +
        "RES#:F6301\r\n\n",

        "CALL:ALARM SYSTEM",
        "ADDR:900 GIBBSBORO RD",
        "CITY:Lindenwold",
        "X:WILSON/HILLIARDS",
        "MAP:22A",
        "PLACE:LINDENWOLD SCHOOL 4",
        "DATE:08/08/2012",
        "TIME:07:37:16",
        "ID:120190307",
        "UNIT:F6301");

    doTest("T23",
        "[Free SQ63] 900 GIBBSBORO RD ,22 22  \r\n" +
        "MI#:120190307  \r\n" +
        "Disp:07:37:16  \r\n" +
        "Enr:  \r\n" +
        "Arr:  \r\n" +
        "Enr Hosp:  \r\n" +
        "Arr Hosp:  \r\n" +
        "Clr:07:51:45  \r\n" +
        "RES#:SQ63  \r\n\n",

        "CALL:RUN REPORT",
        "PLACE:900 GIBBSBORO RD ,22 22  \nMI#:120190307  \nDisp:07:37:16  \nEnr:  \nArr:  \nEnr Hosp:  \nArr Hosp:  \nClr:07:51:45  \nRES#:SQ63",
        "ID:120190307",
        "UNIT:SQ63");

  }
  
  public static void main(String[] args) {
    new NJCamdenCountyAParserTest().generateTests("T1");
  }
}