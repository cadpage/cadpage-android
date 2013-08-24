package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Armstrong County, PA
Contact: larry umbaugh <lumbaugh17@gmail.com>
Sender: 911dispatch@co.armstrong.pa.us

473 TROY HILL RD AIRPORT RD / MCGREGOR RD FMISC 39992 05:40 7245453398
11878 STATE ROUTE 85 ARMSDALE RD / CRYTZER RD ORPHANS OF THE STORM VAENT 40313 19:09 7247120225
141 ADAMS RD STATE ROUTE 85 / BALLOCK LN FMISC 40720 09:07 7247837418
[Dispatch]  580 N CHERRY ST HOOKS LN / SPRUCE LN FSTR2 41628 13:58 7246640045
[Dispatch]  868 STATE ROUTE 28/66 MECHLING RD / SLOAN HILL RD VAENT 42068 15:55 7248597657

Contact: brandon kilgore <firefghter10@gmail.com>
Sender: 911Dispatch@co.armstrong.pa.us
(Dispatch) FREEPORT RD, US ROUTE 422 / PONY FARM RD, US ROUTE 422 VAENT 3706 06:42
(Dispatch) 13 HILLTOP PLAZA COMMERCE DR / FRANKLIN HILL RD HOLIDAY INNFAFALR 5238 15:39 8887467539
(Dispatch) 592 TARRTOWN RD FURNACE RUN RD / STATE ROUTE 1038, BUTLER RD PJ GRECOFVEH 5258 17:45 7249548780

Contact: Jacob Dively <jpdively@gmail.com>
Sender: 911Dispatch@co.armstrong.pa.us
(Dispatch) 105 ELM DR MAPLE LN / LOCUST LN FCOALM 4524 14:11 8003643616
(Dispatch) 571 EAST BRADY RD ROLLING HILLS RD / CORNMAN DR VAINJ 4360 01:41 7245451228

Contact: Evan Keener <keener530@hotmail.com>
Sender: 911dispatch@co.armstrong.pa.us
209 S POPLAR ST SPRUCE AVE / W SOUTH AVE EFALL1 38534 03:52 8142578971
241 PIPELINE RD MAPLE LEAF RD / DAYTON RD MCMEANS BUS COMPANY ESICK1 38440 09:09 8142578245
311 RIDGE RD WOODS RD/ CREEK RD FMVA 33541 02:43 7244484701
(Dispatch) 217 E MAIN ST N REBECCA ST / S SCHOOL ST, N SCHOOL ST EFALL1 38682 13:28 8142578148

Contact: Jake Martin Acct <martin13975@gmail.com>
Sender: 911Dispatch@co.armstrong.pa.us
(Dispatch) 1346 STATE ROUTE 4007 BERNARD RD / STATE ROUTE 268 19898 11:02 7243093328 FSTR1

Contact: East Franklin & Applewold VFD <eastfranklinfire@yahoo.com>
Sender: 911Dispatch@co.armstrong.pa.us
(Dispatch) 610 EAST BRADY RD ROLLING HILLS RD / BOLTZ RD 19932 17:03 7248598547 VAENT

Contact: brandon kilgore <b53klz@gmail.com>
Sender: 911Dispatch@co.armstrong.pa.us
(Dispatch) TEST AUTOMATIC FIRE ALARM  EAST FRANKLIN FIRE DEPARTMENT MAIN 165 EAST BRADY RD FIREHOUSE LN / SHERWOOD DR 19974 23:17
(Dispatch) E1 CHEST DISCOMFORT  128 E  RAILROAD AVE N SCHOOL ST / PENN AVE 20067 16:35

*/

public class PAArmstrongCountyParserTest extends BaseParserTest {
  
  public PAArmstrongCountyParserTest() {
    setParser(new PAArmstrongCountyParser(), "ARMSTRONG COUNTY", "PA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "473 TROY HILL RD AIRPORT RD / MCGREGOR RD FMISC 39992 05:40 7245453398",
        "ADDR:473 TROY HILL RD",
        "X:AIRPORT RD / MCGREGOR RD",
        "CALL:FMISC",
        "ID:39992",
        "TIME:05:40",
        "PHONE:7245453398");

    doTest("T2",
        "11878 STATE ROUTE 85 ARMSDALE RD / CRYTZER RD ORPHANS OF THE STORM VAENT 40313 19:09 7247120225",
        "ADDR:11878 STATE ROUTE 85",
        "MADDR:11878 STATE 85",
        "X:ARMSDALE RD / CRYTZER RD",
        "PLACE:ORPHANS OF THE STORM",
        "CALL:VAENT",
        "ID:40313",
        "TIME:19:09",
        "PHONE:7247120225");

    doTest("T3",
        "141 ADAMS RD STATE ROUTE 85 / BALLOCK LN FMISC 40720 09:07 7247837418",
        "ADDR:141 ADAMS RD",
        "X:STATE ROUTE 85 / BALLOCK LN",
        "CALL:FMISC",
        "ID:40720",
        "TIME:09:07",
        "PHONE:7247837418");

    doTest("T4",
        "[Dispatch]  580 N CHERRY ST HOOKS LN / SPRUCE LN FSTR2 41628 13:58 7246640045",
        "ADDR:580 N CHERRY ST",
        "X:HOOKS LN / SPRUCE LN",
        "CALL:FSTR2",
        "ID:41628",
        "TIME:13:58",
        "PHONE:7246640045");

    doTest("T5",
        "[Dispatch]  868 STATE ROUTE 28/66 MECHLING RD / SLOAN HILL RD VAENT 42068 15:55 7248597657",
        "ADDR:868 STATE ROUTE 28",
        "MADDR:868 STATE 28",
        "X:66 MECHLING RD / SLOAN HILL RD",
        "CALL:VAENT",
        "ID:42068",
        "TIME:15:55",
        "PHONE:7248597657");
  }
  
  @Test
  public void testParserBrandon() {

//    doTest("T1",
//        "(Dispatch) FREEPORT RD, US ROUTE 422 / PONY FARM RD, US ROUTE 422 VAENT 3706 06:42",
//        "ADDR:FREEPORT RD & US ROUTE 422",
//        "MADDR:FREEPORT RD & US 422",
//        "X:PONY FARM RD / US ROUTE 422",
//        "CALL:VAENT",
//        "ID:3706",
//        "TIME:06:42");

    doTest("T2",
        "(Dispatch) 13 HILLTOP PLAZA COMMERCE DR / FRANKLIN HILL RD HOLIDAY INNFAFALR 5238 15:39 8887467539",
        "ADDR:13 HILLTOP PLAZA",
        "X:COMMERCE DR / FRANKLIN HILL RD",
        "PLACE:HOLIDAY",
        "CALL:INNFAFALR",
        "ID:5238",
        "TIME:15:39",
        "PHONE:8887467539");

    doTest("T3",
        "(Dispatch) 592 TARRTOWN RD FURNACE RUN RD / STATE ROUTE 1038, BUTLER RD PJ GRECOFVEH 5258 17:45 7249548780",
        "ADDR:592 TARRTOWN RD",
        "X:FURNACE RUN RD / STATE ROUTE 1038 / BUTLER RD",
        "PLACE:PJ",
        "CALL:GRECOFVEH",
        "ID:5258",
        "TIME:17:45",
        "PHONE:7249548780");

  }
  
  @Test
  public void testParser3() {

    doTest("T1",
        "(Dispatch) 105 ELM DR MAPLE LN / LOCUST LN FCOALM 4524 14:11 8003643616",
        "ADDR:105 ELM DR",
        "X:MAPLE LN / LOCUST LN",
        "CALL:FCOALM",
        "ID:4524",
        "TIME:14:11",
        "PHONE:8003643616");

    doTest("T2",
        "(Dispatch) 571 EAST BRADY RD ROLLING HILLS RD / CORNMAN DR VAINJ 4360 01:41 7245451228",
        "ADDR:571 EAST BRADY RD",
        "X:ROLLING HILLS RD / CORNMAN DR",
        "CALL:VAINJ",
        "ID:4360",
        "TIME:01:41",
        "PHONE:7245451228");

  }
  
  @Test
  public void testEvanKeener() {

    doTest("T1",
        "209 S POPLAR ST SPRUCE AVE / W SOUTH AVE EFALL1 38534 03:52 8142578971",
        "ADDR:209 S POPLAR ST",
        "X:SPRUCE AVE / W SOUTH AVE",
        "CALL:EFALL1",
        "ID:38534",
        "TIME:03:52",
        "PHONE:8142578971");

    doTest("T2",
        "241 PIPELINE RD MAPLE LEAF RD / DAYTON RD MCMEANS BUS COMPANY ESICK1 38440 09:09 8142578245",
        "ADDR:241 PIPELINE RD",
        "X:MAPLE LEAF RD / DAYTON RD",
        "PLACE:MCMEANS BUS COMPANY",
        "CALL:ESICK1",
        "ID:38440",
        "TIME:09:09",
        "PHONE:8142578245");

    doTest("T3",
        "311 RIDGE RD WOODS RD/ CREEK RD FMVA 33541 02:43 7244484701",
        "ADDR:311 RIDGE RD",
        "X:WOODS RD / CREEK RD",
        "CALL:FMVA",
        "ID:33541",
        "TIME:02:43",
        "PHONE:7244484701");

    doTest("T4",
        "(Dispatch) 217 E MAIN ST N REBECCA ST / S SCHOOL ST, N SCHOOL ST EFALL1 38682 13:28 8142578148",
        "ADDR:217 E MAIN ST N",
        "X:REBECCA ST / S SCHOOL ST / N SCHOOL ST",
        "CALL:EFALL1",
        "ID:38682",
        "TIME:13:28",
        "PHONE:8142578148");

  }
  
  @Test
  public void testJakeMartin() {

    doTest("T1",
        "(Dispatch) 1346 STATE ROUTE 4007 BERNARD RD / STATE ROUTE 268 19898 11:02 7243093328 FSTR1",
        "ADDR:1346 STATE ROUTE 4007",
        "MADDR:1346 STATE 4007",
        "X:BERNARD RD / STATE ROUTE 268",
        "ID:19898",
        "TIME:11:02",
        "PHONE:7243093328",
        "CALL:FSTR1");
  
  }
  
  @Test
  public void testEastFranklinAndApplewod() {

    doTest("T1",
        "(Dispatch) 610 EAST BRADY RD ROLLING HILLS RD / BOLTZ RD 19932 17:03 7248598547 VAENT",
        "ADDR:610 EAST BRADY RD",
        "X:ROLLING HILLS RD / BOLTZ RD",
        "ID:19932",
        "TIME:17:03",
        "PHONE:7248598547",
        "CALL:VAENT");
   
  }
  
  @Test
  public void testBrandonKilgore2() {

    doTest("T1",
        "(Dispatch) TEST AUTOMATIC FIRE ALARM  EAST FRANKLIN FIRE DEPARTMENT MAIN 165 EAST BRADY RD FIREHOUSE LN / SHERWOOD DR 19974 23:17",
        "CALL:TEST AUTOMATIC FIRE ALARM",
        "PLACE:EAST FRANKLIN FIRE DEPARTMENT MAIN",
        "ADDR:165 EAST BRADY RD",
        "X:FIREHOUSE LN / SHERWOOD DR",
        "ID:19974",
        "TIME:23:17");
    
  }
  
  @Test
  public void testEvanKeener2() {

    doTest("T1",
        "(Dispatch) E1 CHEST DISCOMFORT  128 E  RAILROAD AVE N SCHOOL ST / PENN AVE 20067 16:35",
        "CALL:E1 CHEST DISCOMFORT",
        "ADDR:128 E RAILROAD AVE",
        "X:N SCHOOL ST / PENN AVE",
        "ID:20067",
        "TIME:16:35");

  }
  
  
  public static void main(String[] args) {
    new PAArmstrongCountyParserTest().generateTests("T1");
  }
}
