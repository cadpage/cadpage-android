package net.anei.cadpage.parsers.FL;

import net.anei.cadpage.parsers.dispatch.DispatchPrintrakParser;

/*
Citrus County, FL
Contact: "Martin Giles" <mgiles@crystalriverfl.org>
Sender: CC_Message_Notification@usamobility.net

FDF01 TYP: MISC FIRE AD: 8038 W PURVIS CT CTY: CRYSTAL RIVER CN: PHILIP CMT1: TREE ON POWERLINE SMOKING. PROGRESS ENERGY FDCA07 FDSTA1 XST2:
FDF01 TYP: VEHICLE FIRE AD: 1035 S SUNCOAST BLVD CTY: HOMOSASSA LOC: CRYSTAL CHEVROLET CMT1: Original Location : CRYSTAL CHEVROLET CMT2: S/B
FDF01 TYP: BRUSH FIRE AD: N BASSWOOD AVE&W CHECKERBERRY CTY: CRYSTAL RIVER CMT1: BRUSHFIRE 1/2 ACRE IN THE AREA OF THE ABOVE FDSTA9 FDSTA1 [
FDF01 TYP: STRUCTURE FIRE AD: 2525 S PINE RIDGE AVE CTY: HOMOSASSA CN: MCKELVEY, JOHN CMT1: SMOKE COMING FROM THE BACK OF THE AREA FDCA03 FD

 */

public class FLCitrusCountyParser extends DispatchPrintrakParser {
  
  public FLCitrusCountyParser() {
    super("CITRUS COUNTY", "FL");
  }
  
  @Override
  public String getFilter() {
    return "CC_Message_Notification@usamobility.net";
  }
}
