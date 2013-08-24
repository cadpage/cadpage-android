package net.anei.cadpage.parsers.FL;

                                                                                                                                                                                                                                                                                                                                                                                                           

import net.anei.cadpage.parsers.BaseParserTest;
import org.junit.Test;

/*
Crestview, FL
Contact: "David Maxey" <dmaxey09@vt.edu>
Sender: @c-msg.net

Call_Number: 1806 | Inc_Number:  | Units: CFD,Engine 2, | Complaint: MUTUAL AID | Location: Second Ave | Address: 481    | Disposition:  | Box:  | Time_Dispatched: 2012-06-25 07:20:20 | Narrative: stump on fire 10 ft from a residence actual site is across | This_Unit: Engine 2
Call_Number: 1805 | Inc_Number:  | Units: CFD,Rescue 3, | Complaint: EMS DELTA | Location: Adams (100-748) | Address:  Adams DR  | Disposition:  | Box: 1 | Time_Dispatched: 2012-06-25 01:47:29 | Narrative: 305 adams dr near bob sikes school | This_Unit: Rescue 3
Call_Number: 1871 | Inc_Number: 1536 | Units: CFD,Rescue 3, | Complaint: EMS DELTA | Location: Lloyd -N (100-1708) | Address: 966 NLloyd ST  | Disposition:  | Box: 1 | Time_Dispatched: 2012-07-01 14:14:13 | Narrative: unknown aged male possible stroke | This_Unit: Rescue 3
Call_Number: 1869 | Inc_Number:  | Units: CFD,Rescue 3, | Complaint: EMS DELTA | Location: Griffith -E Avenue    (200-664) | Address: 503 EGriffith AVE  | Disposition:  | Box: 1 | Time_Dispatched: 2012-07-01 13:16:45 | Narrative: 53 yo male having seizures | This_Unit: Rescue 3
Call_Number: 2278 | Inc_Number:  | Units: CFD,Ladder 3, | Complaint: EMS DELTA | Location: Walnut -E Ave  (100-901) | Address:  EWalnut AVE  | Disposition:  | Box: 1 | Time_Dispatched: 2012-08-14 21:17:37 | Narrative: 645 E Walnut Ave for unconscious pt | This_Unit: Ladder 3 

*/

public class FLCrestviewParserTest extends BaseParserTest {
  
  public FLCrestviewParserTest() {
    setParser(new FLCrestviewParser(), "Crestview", "FL");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Call_Number: 1806 | Inc_Number:  | Units: CFD,Engine 2, | Complaint: MUTUAL AID | Location: Second Ave | Address: 481    | Disposition:  | Box:  | Time_Dispatched: 2012-06-25 07:20:20 | Narrative: stump on fire 10 ft from a residence actual site is across | This_Unit: Engine 2",
        "ID:1806",
        "UNIT:CFD,Engine 2",
        "CALL:MUTUAL AID",
        "ADDR:481 Second Ave",
        "DATE:06/25/2012",
        "TIME:07:20:20",
        "INFO:stump on fire 10 ft from a residence actual site is across");

    doTest("T2",
        "Call_Number: 1805 | Inc_Number:  | Units: CFD,Rescue 3, | Complaint: EMS DELTA | Location: Adams (100-748) | Address:  Adams DR  | Disposition:  | Box: 1 | Time_Dispatched: 2012-06-25 01:47:29 | Narrative: 305 adams dr near bob sikes school | This_Unit: Rescue 3",
        "ID:1805",
        "UNIT:CFD,Rescue 3",
        "CALL:EMS DELTA",
        "PLACE:Adams (100-748)",
        "ADDR:Adams DR",
        "BOX:1",
        "DATE:06/25/2012",
        "TIME:01:47:29",
        "INFO:305 adams dr near bob sikes school");

    doTest("T3",
        "Call_Number: 1871 | Inc_Number: 1536 | Units: CFD,Rescue 3, | Complaint: EMS DELTA | Location: Lloyd -N (100-1708) | Address: 966 NLloyd ST  | Disposition:  | Box: 1 | Time_Dispatched: 2012-07-01 14:14:13 | Narrative: unknown aged male possible stroke | This_Unit: Rescue 3",
        "ID:1871",
        "UNIT:CFD,Rescue 3",
        "CALL:EMS DELTA",
        "PLACE:Lloyd -N (100-1708)",
        "ADDR:966 NLloyd ST",
        "BOX:1",
        "DATE:07/01/2012",
        "TIME:14:14:13",
        "INFO:unknown aged male possible stroke");

    doTest("T4",
        "Call_Number: 1869 | Inc_Number:  | Units: CFD,Rescue 3, | Complaint: EMS DELTA | Location: Griffith -E Avenue    (200-664) | Address: 503 EGriffith AVE  | Disposition:  | Box: 1 | Time_Dispatched: 2012-07-01 13:16:45 | Narrative: 53 yo male having seizures | This_Unit: Rescue 3",
        "ID:1869",
        "UNIT:CFD,Rescue 3",
        "CALL:EMS DELTA",
        "PLACE:Griffith -E Avenue    (200-664)",
        "ADDR:503 EGriffith AVE",
        "BOX:1",
        "DATE:07/01/2012",
        "TIME:13:16:45",
        "INFO:53 yo male having seizures");

    doTest("T5",
        "Call_Number: 2278 | Inc_Number:  | Units: CFD,Ladder 3, | Complaint: EMS DELTA | Location: Walnut -E Ave  (100-901) | Address:  EWalnut AVE  | Disposition:  | Box: 1 | Time_Dispatched: 2012-08-14 21:17:37 | Narrative: 645 E Walnut Ave for unconscious pt | This_Unit: Ladder 3 ",
        "ID:2278",
        "UNIT:CFD,Ladder 3",
        "CALL:EMS DELTA",
        "PLACE:Walnut -E Ave  (100-901)",
        "ADDR:EWalnut AVE",
        "BOX:1",
        "DATE:08/14/2012",
        "TIME:21:17:37",
        "INFO:645 E Walnut Ave for unconscious pt");
   
  }
  
  public static void main(String[] args) {
    new FLCrestviewParserTest().generateTests("T1");
  }
}
  