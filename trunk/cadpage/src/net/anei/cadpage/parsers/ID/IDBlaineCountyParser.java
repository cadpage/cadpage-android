package net.anei.cadpage.parsers.ID;

import net.anei.cadpage.parsers.dispatch.DispatchA4Parser;

/*
Blaine County, ID
Contact: Jamie Hoover <hooverj18@gmail.com>
Contact: Kelland Wolf <krswolf@gmail.com>
Sender: ldispatch@co.blaine.id.us

(CAD Page for CFS BC012512-12) FIRE ALARM\n314 S 7TH ST\nApt:\nBELLEVUE\nCross Streets : PINE ST * POPLAR ST
(CAD Page for CFS BC013012-62) GAS LEAK-ODOR NO INJURY\n119 S MAIN ST\nApt:\nBELLEVUE\nCross Streets : ELM ST * OAK ST
(CAD Page for CFS BC120311-14) STRUCTURE FIRE\n313 N 2ND AVE\nApt:\nHAILEY\nCross Streets : E GALENA ST * E SILVER ST
(CAD Page for CFS BC111611-42) HAZMAT NO INJURY INCIDENT\n516 N MAIN ST\nApt:\nBELLEVUE\nCross Streets : BEECH ST * ASH ST
(CAD Page for CFS BC072511-60) FIRE-STRUCTURE\nCEDAR ST and N 4TH ST\nApt:\nBELLEVUE\nCross Streets : ELM ST * CEDAR ST
(CAD Page for CFS BC021212-61) Convulsions-Seizures\n1160 ECHO HILL DR\nApt: \nHAILEY\nCross Streets : BUTTERFLY DR * BERRYCREEK DR

*/


public class IDBlaineCountyParser extends DispatchA4Parser {
  
  public IDBlaineCountyParser() {
    super("BLAINE COUNTY", "ID");
  }

  @Override
  public String getFilter() {
    return "ldispatch@co.blaine.id.us";
  }
 
}
