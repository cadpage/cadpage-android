package net.anei.cadpage.parsers.GA;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.GA.GAMartinezParser;

import org.junit.Test;

/*
Martinez, GA (Martinez Columbia Fire Rescue
Contact: "Brent Willis" <bwillis@mvfd.net>
Sender: no-reply@mvfd.net
 
Working structure fire!  Assistance is needed if available.\nAddress: 611 KETTLE CREEK DR\nDO NOT CALL DISPATCH!!!! (Reported on 11/21/2010 @ 12:39:39 AM)
Working structure fire!  Assistance is needed if available.\n330 HACKAMORE TRL\nDO NOT CALL DISPATCH!!!! (Reported on 10/22/2010 @ 9:50:55 PM)
Working structure fire!  Assistance is needed if available.\nAddress:298 Ashbrook dr\nDO NOT CALL DISPATCH!!!! (Reported on 09/14/2010 @ 2:20:07 PM)
Working structure fire! Assistance is needed if available.\nAddress:ACROSS FROM 3736 CATUS TRAIL\nDO NOT CALL DISPATCH!!!! (Reported on 09/08/2010 @ 3:53:59 PM)
Working structure fire! Assistance is needed if available.\nAddress:711 HIDDEN PL OFF HWY 28\nDO NOT CALL DISPATCH!!!! (Reported on 8/12/2010 @ 9:24:21 AM)
 */

public class GAMartinezParserTest extends BaseParserTest {
  
  public GAMartinezParserTest() {
    setParser(new GAMartinezParser(), "MARTINEZ", "GA");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "Working structure fire!  Assistance is needed if available.\nAddress: 611 KETTLE CREEK DR\nDO NOT CALL DISPATCH!!!! (Reported on 11/21/2010 @ 12:39:39 AM)",
        "CALL:Working structure fire!  Assistance is needed if available.",
        "ADDR:611 KETTLE CREEK DR");
    
    doTest("T2",
        "Working structure fire!  Assistance is needed if available.\n330 HACKAMORE TRL\nDO NOT CALL DISPATCH!!!! (Reported on 10/22/2010 @ 9:50:55 PM)",
        "CALL:Working structure fire!  Assistance is needed if available.",
        "ADDR:330 HACKAMORE TRL");
    
    doTest("T3",
        "Working structure fire!  Assistance is needed if available.\nAddress:298 Ashbrook dr\nDO NOT CALL DISPATCH!!!! (Reported on 09/14/2010 @ 2:20:07 PM)",
        "CALL:Working structure fire!  Assistance is needed if available.",
        "ADDR:298 Ashbrook dr");
    
    doTest("T4",
        "Working structure fire! Assistance is needed if available.\nAddress:ACROSS FROM 3736 CATUS TRAIL\nDO NOT CALL DISPATCH!!!! (Reported on 09/08/2010 @ 3:53:59 PM)",
        "CALL:Working structure fire! Assistance is needed if available.",
        "PLACE:ACROSS FROM",
        "ADDR:3736 CATUS TRAIL");
    
    doTest("T5",
        "Working structure fire! Assistance is needed if available.\nAddress:711 HIDDEN PL OFF HWY 28\nDO NOT CALL DISPATCH!!!! (Reported on 8/12/2010 @ 9:24:21 AM)",
        "CALL:Working structure fire! Assistance is needed if available.",
        "ADDR:711 HIDDEN PL",
        "X:OFF HWY 28");

  }
}