package net.anei.cadpage.parsers.KY;

import net.anei.cadpage.parsers.dispatch.DispatchA1Parser;

/*
Erlanger Dispatch, KY (in Kenton County)
Contact: "Jeremy Sheehan" <jsheehan@elsmerefd.com>
Sender: pscc@ci.erlanger.ky.us

(Alert: Fire Structure) ALRM LVL: 1\nLOC:\n709 ORCHARD ST\nELSMERE\nBTWN: MAIN ST & LYTLE AV\n\nRCVD AS E-911 Call\n\nCOM:\nSMOKE FILLED BASEMENT\nHEARD A POP\n\nCT:\n22-
(Alert: Fire Structure) ALRM LVL: 1\nLOC:\n3812 HARVEST WY\nELSMERE\nBTWN: HARVEST LN & N/A
(Alert: Fire Structure) ALRM LVL: 1\nLOC:\n416 ELKEN PL\nELSMERE\nBTWN: MAPLE AV & CALDWELL DR
(Alert: Fire Structure) ALRM LVL: 1\nLOC:\n1028 CAPITOL AV\n1\nELSMERE\nBTWN: GALVIN ST & N/A
(Alert: Fire Structure) ALRM LVL: 1\nLOC:\nELSMERE FIRE DEPARTMENT\n401 GARVEY AV\nELSMERE\nBTWN: ASH ST & PALACE AV
(Alert: Fire Structure) ALRM LVL: 1\nLOC:\nLANIGAN'S\n4409 DIXIE HW\nELSMERE\nBTWN: N/A & N/A
(Alert: Fire Structure) ALRM LVL: 1\nLOC:\n631 WILLOW ST\nELSMERE\nBTWN: KENTON ST & MAIN ST
(Alert: Fire Structure) ALRM LVL: 1\nLOC:\nWOODCREST MANOR CARE CENTER\n3876 TURKEYFOOT RD\nELSMERE\nBTWN: TURKEYFOOT RD & INDUSTRIAL RD
(Alert: Fire Structure) ALRM LVL: 1\nLOC:\n120 SPARROW DR\nELSMERE\nBTWN: N/A & ROBIN DR
(Alert: Fire Structure) ALRM LVL: 1\nLOC:\n430 FOX ST\nELSMERE\nBTWN: GARVEY AV & MAIN ST
(Alert: Fire Structure) ALRM LVL: 1\nLOC:\nSIGNODE PLASTIC RECYCLING ALLIANCE\n7080 INDUSTRIAL RD\nELSMERE\nBTWN: NEW BUFFINGTON RD & VULACN DR
(Alert: Fire Structure) ALRM LVL: 1\nLOC:\nALLENDALE MOBILE HOME PARK\n1150 EDWARDS RD\nELSMERE\nBTWN: LYTLE AV & N/A

pscc@ci.erlanger.ky.us\nSUBJ:Alert: Unconscious / Unresponsive\nMSG:\nALRM LVL: 1\nLOC:\n32 DUDLEY RD\nEDGEWOOD\nBTWN: MAPLE LN & WILDROSE DR\n\nRCVD AS E-911 Call\n\nCOM:\nSUBJ FELL IN BATHROOM\nUNK IF BREATHING\nBETWEEN THE TOILET AND BATH TUB\n\nCT:\n22-RCA at POS 03\n

*/
public class KYErlangerDispatchParser extends DispatchA1Parser {

  public KYErlangerDispatchParser() {
    super("KENTON COUNTY", "KY"); 
  }
  
  @Override
  public String getFilter() {
    return "pscc@ci.erlanger.ky.us";
  }
}
