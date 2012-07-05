package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.NJ.NJMICOMParser;

import org.junit.Test;


public class NJMICOMParserTest extends BaseParserTest {
  
  public NJMICOMParserTest() {
    setParser(new NJMICOMParser(), "", "NJ");
  }
  
  @Test
  public void testBergenParser() {
    
    doTest("T1",
        "(CAD)  RESPOND: #10-0092 ENGLEWOOD CLIFFS BOR*580 Sylvan Ave * *SUITE B *DEMAREST AVE/UNNAMED STREET *Unknown Problem (Man Down)-BLS08:23 Code:31B01",
        "ID:10-0092",
        "CITY:ENGLEWOOD CLIFFS",
        "ADDR:580 Sylvan Ave",
        "APT:SUITE B",
        "X:DEMAREST AVE/UNNAMED STREET",
        "CALL:Unknown Problem (Man Down)");

    doTest("T2",
        "(CAD) S332 RESPOND: #10-0090603 ENGLEWOOD CITY *143 Engle St * * *E DEMAREST AVE/CHESTNUT ST *Falls-BLS 10:46 Code:17b01",
        "UNIT:S332",
        "ID:10-0090603",
        "CITY:ENGLEWOOD CITY",
        "ADDR:143 Engle St",
        "X:E DEMAREST AVE/CHESTNUT ST",
        "CALL:Falls");

    doTest("T4",
        "(CAD) S2 RESPOND: #10-0092818 FORT LEE BORO *0 - 0 Bridge Plz N *WALGREENS * *LEMOINE AVE/LEMOINE AVE *Traumatic Injuries-BLS 16:01 Code:30bt1",
        "UNIT:S2",
        "ID:10-0092818",
        "CITY:FORT LEE",
        "ADDR:0 - 0 Bridge Plz N",
        "PLACE:WALGREENS",
        "X:LEMOINE AVE/LEMOINE AVE",
        "CALL:Traumatic Injuries");
  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "(CAD) S1041 RESPOND: #11-0074384 Garfield City *57 Spring St * *2 *Belmont Ave/Botany St *Unconscious/Fainting-ALS 22:01 Code:",
        "UNIT:S1041",
        "ID:11-0074384",
        "CITY:Garfield City",
        "ADDR:57 Spring St",
        "APT:2",
        "X:Belmont Ave/Botany St",
        "CALL:Unconscious/Fainting");
   
  }
  
  @Test
  public void testMorrisParser() {

    doTest("T1",
        "(CAD) T541 RESPOND: #11-0071085 Denville Twp *21 Pocono Rd *Fransiscan Oaks Health Ce*303B *Unnamed Street/Unnamed Street *Trans/Interfacility/Palliative14:05 Co",
        "UNIT:T541",
        "ID:11-0071085",
        "CITY:Denville Twp",
        "ADDR:21 Pocono Rd",
        "PLACE:Fransiscan Oaks Health Ce",
        "APT:303B",
        "X:Unnamed Street/Unnamed Street",
        "CALL:Trans/Interfacility/Palliative");
   
  }
  
  @Test
  public void testActive911() {

    doTest("T1",
        "[CAD] S432 RESPOND: #12-0074884 Ridgewood *223 N Van Dien Ave *The Valley Hospital *P4E-4310/D*Linwood Ave/Meadowbrook Ave *Trans/Interfacility/Palliative09:15 Code:\n",
        "UNIT:S432",
        "ID:12-0074884",
        "CITY:Ridgewood",
        "ADDR:223 N Van Dien Ave",
        "PLACE:The Valley Hospital",
        "APT:P4E-4310/D",
        "X:Linwood Ave/Meadowbrook Ave",
        "CALL:Trans/Interfacility/Palliative");

    doTest("T2",
        "[CAD] S432 CANCEL: #12-0074884 Ridgewood *223 N Van Dien Ave Paged:09:15 Enrte:09:18 Scene:09:54 Avail: Cxl Rsn: Cancelled By RN Code:\n",
        "UNIT:S432",
        "PLACE:CANCEL: #12-0074884 Ridgewood *223 N Van Dien Ave Paged:09:15 Enrte:09:18 Scene:09:54 Avail: Cxl Rsn: Cancelled By RN Code:",
        "CALL:RUN REPORT");

    doTest("T3",
        "[CAD] S432 RESPOND: #12-0074958 Ridgewood *223 N Van Dien Ave *The Valley Hospital *P3E-3322/D*Linwood Ave/Meadowbrook Ave *Trans/Interfacility/Palliative11:35 Code:\n",
        "UNIT:S432",
        "ID:12-0074958",
        "CITY:Ridgewood",
        "ADDR:223 N Van Dien Ave",
        "PLACE:The Valley Hospital",
        "APT:P3E-3322/D",
        "X:Linwood Ave/Meadowbrook Ave",
        "CALL:Trans/Interfacility/Palliative");

    doTest("T4",
        "[CAD] S432 @ # 12-0074958 Disp 11:35 Enrt 11:42 Scen 11:49 Tran 12:08 Hosp 12:22\n",
        "UNIT:S432",
        "PLACE:@ # 12-0074958 Disp 11:35 Enrt 11:42 Scen 11:49 Tran 12:08 Hosp 12:22",
        "CALL:RUN REPORT");

    doTest("T5",
        "[CAD] S432 RESPOND: #12-0075072 Ridgewood *223 N Van Dien Ave *The Valley Hospital *B2B-2231/P*Linwood Ave/Meadowbrook Ave *Trans/Interfacility/Palliative15:17 Code:\n",
        "UNIT:S432",
        "ID:12-0075072",
        "CITY:Ridgewood",
        "ADDR:223 N Van Dien Ave",
        "PLACE:The Valley Hospital",
        "APT:B2B-2231/P",
        "X:Linwood Ave/Meadowbrook Ave",
        "CALL:Trans/Interfacility/Palliative");

    doTest("T6",
        "[CAD] S432 @ Oradell Health Care Center # 12-0075072 Disp 15:17 Enrt 15:26 Scen 15:40 Tran 15:59 Hosp 16:12\n",
        "UNIT:S432",
        "PLACE:@ Oradell Health Care Center # 12-0075072 Disp 15:17 Enrt 15:26 Scen 15:40 Tran 15:59 Hosp 16:12",
        "CALL:RUN REPORT");

    doTest("T7",
        "[CAD] S432 RESPOND: #12-0076085 Ridgewood *223 N Van Dien Ave *The Valley Hospital *2W/2337W *Linwood Ave/Meadowbrook Ave *Trans/Interfacility/Palliative09:46 Code:\n",
        "UNIT:S432",
        "ID:12-0076085",
        "CITY:Ridgewood",
        "ADDR:223 N Van Dien Ave",
        "PLACE:The Valley Hospital",
        "APT:2W/2337W",
        "X:Linwood Ave/Meadowbrook Ave",
        "CALL:Trans/Interfacility/Palliative");

    doTest("T8",
        "[CAD] S432 @ # 12-0076085 Disp 09:46 Enrt 09:55 Scen 10:32 Tran 11:04 Hosp 11:20\n",
        "UNIT:S432",
        "PLACE:@ # 12-0076085 Disp 09:46 Enrt 09:55 Scen 10:32 Tran 11:04 Hosp 11:20",
        "CALL:RUN REPORT");

    doTest("T9",
        "[CAD] S432 RESPOND: #12-0076157 Ridgewood *223 N Van Dien Ave *The Valley Hospital *4B-4127 *Linwood Ave/Meadowbrook Ave *Trans/Interfacility/Palliative12:21 Code:\n",
        "UNIT:S432",
        "ID:12-0076157",
        "CITY:Ridgewood",
        "ADDR:223 N Van Dien Ave",
        "PLACE:The Valley Hospital",
        "APT:4B-4127",
        "X:Linwood Ave/Meadowbrook Ave",
        "CALL:Trans/Interfacility/Palliative");

    doTest("T10",
        "[CAD] S432 @ # 12-0076157 Disp 12:21 Enrt 12:23 Scen 12:56 Tran 13:28 Hosp 13:48\n",
        "UNIT:S432",
        "PLACE:@ # 12-0076157 Disp 12:21 Enrt 12:23 Scen 12:56 Tran 13:28 Hosp 13:48",
        "CALL:RUN REPORT");

    doTest("T11",
        "[CAD] S432 RESPOND: #12-0076225 Ridgewood *223 N Van Dien Ave *The Valley Hospital *4E-4309 *Linwood Ave/Meadowbrook Ave *Trans/Interfacility/Palliative14:10 Code:\n",
        "UNIT:S432",
        "ID:12-0076225",
        "CITY:Ridgewood",
        "ADDR:223 N Van Dien Ave",
        "PLACE:The Valley Hospital",
        "APT:4E-4309",
        "X:Linwood Ave/Meadowbrook Ave",
        "CALL:Trans/Interfacility/Palliative");

    doTest("T12",
        "[CAD] S432 @ # 12-0076225 Disp 14:10 Enrt 14:11 Scen 14:34 Tran 15:04 Hosp 15:36\n",
        "UNIT:S432",
        "PLACE:@ # 12-0076225 Disp 14:10 Enrt 14:11 Scen 14:34 Tran 15:04 Hosp 15:36",
        "CALL:RUN REPORT");

    doTest("T13",
        "[CAD] S432 RESPOND: #12-0076286 Ridgewood *223 N Van Dien Ave *The Valley Hospital *2A-2218 *Linwood Ave/Meadowbrook Ave *Trans/Interfacility/Palliative16:03 Code:\n",
        "UNIT:S432",
        "ID:12-0076286",
        "CITY:Ridgewood",
        "ADDR:223 N Van Dien Ave",
        "PLACE:The Valley Hospital",
        "APT:2A-2218",
        "X:Linwood Ave/Meadowbrook Ave",
        "CALL:Trans/Interfacility/Palliative");

    doTest("T14",
        "[CAD] S432 @ Kessler (Saddle Brook) # 12-0076286 Disp 16:03 Enrt 16:11 Scen 17:03 Tran 17:03 Hosp 17:53\n",
        "UNIT:S432",
        "PLACE:@ Kessler (Saddle Brook) # 12-0076286 Disp 16:03 Enrt 16:11 Scen 17:03 Tran 17:03 Hosp 17:53",
        "CALL:RUN REPORT");

    doTest("T15",
        "[CAD] S432 RESPOND: #12-0076501 Ridgewood *223 N Van Dien Ave *The Valley Hospital *3W-3339 *Linwood Ave/Meadowbrook Ave *Trans/Interfacility/Palliative09:17 Code:\n",
        "UNIT:S432",
        "ID:12-0076501",
        "CITY:Ridgewood",
        "ADDR:223 N Van Dien Ave",
        "PLACE:The Valley Hospital",
        "APT:3W-3339",
        "X:Linwood Ave/Meadowbrook Ave",
        "CALL:Trans/Interfacility/Palliative");

    doTest("T16",
        "[CAD] S432 @ # 12-0076501 Disp 09:17 Enrt 09:19 Scen 09:52 Tran 10:12 Hosp 10:19\n",
        "UNIT:S432",
        "PLACE:@ # 12-0076501 Disp 09:17 Enrt 09:19 Scen 09:52 Tran 10:12 Hosp 10:19",
        "CALL:RUN REPORT");

    doTest("T17",
        "[CAD] S432 RESPOND: #12-0076551 Ridgewood *223 N Van Dien Ave *The Valley Hospital *4E-4307 *Linwood Ave/Meadowbrook Ave *Trans/Interfacility/Palliative10:43 Code:\n",
        "UNIT:S432",
        "ID:12-0076551",
        "CITY:Ridgewood",
        "ADDR:223 N Van Dien Ave",
        "PLACE:The Valley Hospital",
        "APT:4E-4307",
        "X:Linwood Ave/Meadowbrook Ave",
        "CALL:Trans/Interfacility/Palliative");

    doTest("T18",
        "[CAD] S432 @ # 12-0076551 Disp 10:43 Enrt 10:51 Scen 11:03 Tran 11:27 Hosp 11:40\n",
        "UNIT:S432",
        "PLACE:@ # 12-0076551 Disp 10:43 Enrt 10:51 Scen 11:03 Tran 11:27 Hosp 11:40",
        "CALL:RUN REPORT");

    doTest("T19",
        "[CAD] S432 RESPOND: #12-0076653 Ridgewood *223 N Van Dien Ave *The Valley Hospital *3E-3302 *Linwood Ave/Meadowbrook Ave *Trans/Interfacility/Palliative14:17 Code:\n",
        "UNIT:S432",
        "ID:12-0076653",
        "CITY:Ridgewood",
        "ADDR:223 N Van Dien Ave",
        "PLACE:The Valley Hospital",
        "APT:3E-3302",
        "X:Linwood Ave/Meadowbrook Ave",
        "CALL:Trans/Interfacility/Palliative");

    doTest("T20",
        "[CAD] S432 @ # 12-0076653 Disp 14:17 Enrt 14:19 Scen 14:42 Tran 15:14 Hosp 15:47\n",
        "UNIT:S432",
        "PLACE:@ # 12-0076653 Disp 14:17 Enrt 14:19 Scen 14:42 Tran 15:14 Hosp 15:47",
        "CALL:RUN REPORT");

    doTest("T21",
        "[CAD] S432 RESPOND: #12-0076703 Ridgewood *223 N Van Dien Ave *The Valley Hospital *3E-3318W *Linwood Ave/Meadowbrook Ave *Trans/Interfacility/Palliative15:53 Code:\n",
        "UNIT:S432",
        "ID:12-0076703",
        "CITY:Ridgewood",
        "ADDR:223 N Van Dien Ave",
        "PLACE:The Valley Hospital",
        "APT:3E-3318W",
        "X:Linwood Ave/Meadowbrook Ave",
        "CALL:Trans/Interfacility/Palliative");

    doTest("T22",
        "[CAD] S432 @ Care One at Valley (Westwood) # 12-0076703 Disp 15:53 Enrt 15:55 Scen 16:35 Tran 16:35 Hosp 16:54\n",
        "UNIT:S432",
        "PLACE:@ Care One at Valley (Westwood) # 12-0076703 Disp 15:53 Enrt 15:55 Scen 16:35 Tran 16:35 Hosp 16:54",
        "CALL:RUN REPORT");

  }
  
  public static void main(String[] args) {
    new NJMICOMParserTest().generateTests("T1", "UNIT ID CITY ADDR PLACE APT X CALL");
  }
}