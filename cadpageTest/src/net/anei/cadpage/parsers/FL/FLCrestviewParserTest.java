package net.anei.cadpage.parsers.FL;

                                                                                                                                                                                                                                                                                                                                                                                                           

import net.anei.cadpage.parsers.BaseParserTest;
import org.junit.Test;


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
        "MADDR:Adams (100-748),Adams DR",
        "BOX:1",
        "DATE:06/25/2012",
        "TIME:01:47:29",
        "INFO:305 adams dr near bob sikes school");
    
  }
  
  public static void main(String[] args) {
    new FLCrestviewParserTest().generateTests("T1");
  }
}
  