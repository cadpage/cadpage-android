package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.dispatch.DispatchA1Parser;

/*
Morrow County, OH
Contact: Joseph Coil <mgfd1924@gmail.com>,"Joseph & Jeanette Coil" <firefightercoil@yahoo.com>
Sender: mc911@rrohio.com

(Alert: MVA) ALRM LVL: 1\nLOC:\n3556 RD 145\nGILEAD TWP\nBTWN: RD 9 & RD 30\n\nCOM:\nCAR FLIPPED\n1 CAR\n\nCT:\nBRM at POS 02
(Alert: Fire Occupied Structure) ALRM LVL: 1\nLOC:\n2681 RD 254\nLINCOLN TWP\nBTWN: RD 155 & DEAD END\n\nRCVD AS 911\n\nCOM:\nCHIMNEY FIRE\nGETTING EVERYONE OUT OF THE HOUSE
(Alert: MVA) ALRM LVL: 1\nLOC:\n156 I-71\nPERRY TWP\nBTWN: MM 156 & MM 158\n\nRCVD AS 911\n\nCOM:\nNB\n2 SEMI\nUNK IF OTHER SEMI IS CARRYING ANY HAZMAT\nACCIDENT IS SPREAD OUT
(Alert: MVA - Non Injury) ALRM LVL: 1\nLOC:\n5475 RD 9\nGILEAD TWP\nBTWN: RD 127 & EDISON VILLAGE\n\nRCVD AS 911\n\nCOM:\nGUY STANDING ON TOP OF HIS TRUCK\nSURROUNDED BY WAT
(Alert: Gas Smell) ALRM LVL: 1\nLOC:\n6803 RD 30\nGILEAD TWP\nBTWN: RD 75 & RD 61\n\nRCVD AS 911\n\nCOM:\nSMELL OF GAS\nCALLED FROM MARION\nCALLED IN FROM A PASSING CAR\nSMELL
(Alert: MVA) ALRM LVL: 1\nLOC:\n5957 RD 28\nCANAAN TWP\nBTWN: RD 135 & ST RT 95\n\nRCVD AS 911\n\nCOM:\nIN CAR CANNOT GET OUT NEEDS HELP UNABLE TO GET OUT DUE TO SOME UNKNO

*/
public class OHMorrowCountyParser extends DispatchA1Parser {

  public OHMorrowCountyParser() {
    super("MORROW COUNTY", "OH"); 
  }
  
  @Override
  public String getFilter() {
    return "mc911@rrohio.com";
  }
}
