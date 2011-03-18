package net.anei.cadpage.parsers.GA;

import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/*
Smyrna, GA
Contact: "Dustin Davey" <ddavey@ci.smyrna.ga.us>
Sender: cad@ci.smyrna.ga.us
CAD:FYI: ;STRUCTURE FIRE;2501 WOODLANDS DR SE;FLAMES INSIDE FUSE BOX INSIDE CALLERS APARTMENT. SMELLS WIRES BURNING. [08/08/10 22:53:28 DTHACKER];103157
CAD:Update: ;VEHICLE FIRE;S COBB DR SE/BOURNE DR SE;METRO PCS;OWNER OF VEH CALLED --- ADV ON 280 AT WH [10/11/10 17:46:52 ABERRY] blk dodge charger on fire [10/
CAD:FYI: ;VEHICLE FIRE;WINDY HILL RD SE/S COBB DR SE;METRO PCS;blk dodge charger on fire [10/11/10 17:46:16 DSNIVELY] ;104107
CAD:Update: ;STRUCTURE FIRE;501 WALTON WAY SE;S COBB DR SE;apt 501 [09/23/10 15:17:59 MBAGNATO] ;103832
CAD:FYI: ;FIRE GENERAL;4586-W VALLEY PKWY SE;S COBB DR SE;ASHLEY;heavy smoke [10/09/10 03:49:27 SMAHAMA] smoke coming from the unit below her [10/09/10 03:48:51

*/
public class GASmyrnaParser extends DispatchOSSIParser {
  
  public GASmyrnaParser() {
    super("SMYRNA", "GA",
           "SKIP CALL ADDR! X+? INFO+? ID");
  }
  
  @Override
  public String getFilter() {
    return "cad@ci.smyrna.ga.us";
  }
}
