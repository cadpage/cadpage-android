package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchShieldwareParser;

/*
Winchester, VA
Contact: Chris & Scott Kensinger <kensingerllc@gmail.com>
Sender: winecc@ci.winchester.va.us

(Winchester ECC info) 11-041989 INSIDE SMELL OR SMOKE\n336 GRAY AVE\nNATIONAL AVE / VIRGI/NIA AVE\nWINCHESTER\nBAT6 E4 E5 EC18 M41 TK2 W1 E
(Winchester ECC info) 11-042157 INSIDE FIRE STRUCT/ELEC/CHIMN\n122-1 E PALL MALL ST\nS CAMERON ST / S KEN/T ST\nWINCHESTER\nBAT6 E1 E4 E5 EC21 M51 TK2
(Winchester ECC info) 11-042110 FIRE ALARM\n1890 AMHERST ST\nWESTSIDE STATION DR// CITY LIMITS\nADULT PSYCH CENTER  WINCHESTER\nE1 E4 EC15 TK2
(Winchester ECC info) 11-042059 OUTSIDE FIRES WITH NO EXPOSURE\n1029 ALLEN DR\nMOLDEN DR / KINZEL D/R\nTINAS QUALITY CLEANING  WINCHESTER\nE1

 */


public class VAWinchesterParser extends DispatchShieldwareParser {
    
  
  public VAWinchesterParser() {
    super("WINCHESTER", "VA");
  }
  
  @Override
  public String getFilter() {
    return "winecc@ci.winchester.va.us";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (! subject.equals("Winchester ECC info")) return false;
    return super.parseMsg(body, data);
  }
}
