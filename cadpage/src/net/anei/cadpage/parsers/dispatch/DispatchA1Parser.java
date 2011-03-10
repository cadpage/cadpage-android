package net.anei.cadpage.parsers.dispatch;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

/*
Handles parser for some as yet unidentified CAD vendor

Deleware County, OH
(Alert: Service Run-Fire) ALRM LVL: 1\nLOC:\n210 BIG RUN RD\nBERLIN TWP\nBTWN: STATE ROUTE 37 E & SOUTH END\nRCVD AS Radio\n\nCOM:\n\nCT:\n9961 at POS 05
(Alert: Unresponsive / Unconscious) ALRM LVL: 1\nLOC:\n4114 CURVE RD\nBERLIN TWP\nBTWN: WINDING CREEK LN & LACKEY OLD STATE RD\nRCVD AS E-911 Call\nCOM:\nPROQA Urg
(Alert: Gas Leak-Residential) ALRM LVL: 1\nLOC:\n210 BIG RUN RD\nBERLIN TWP\nBTWN: STATE ROUTE 37 E & SOUTH END\n\nCOM:\nPROQA Urgent Message: basement\nPROQA Urgen
(Alert: Fire-Vehicle) ALRM LVL: 1\nLOC:\nALUM CREEK BIG RUN PARKING LOT NORTH (UPPER)\n606 BIG RUN RD\nBERLIN TWP\nBTWN: STATE ROUTE 37 E & SOUTH END\n\nCOM:\nVEHIC
(Alert: Auto Accident Injuries) ALRM LVL: 1\nLOC:\nSHANAHAN RD/COLUMBUS PIKE\nBERLIN TWP\nBTWN: COLUMBUS PIKE & NORTH RD IN ORANGE TWP\n\nRCVD AS Cellular 911\nCOM:
  
Morrow County, OH
(Alert: MVA) ALRM LVL: 1\nLOC:\n3556 RD 145\nGILEAD TWP\nBTWN: RD 9 & RD 30\n\nCOM:\nCAR FLIPPED\n1 CAR\n\nCT:\nBRM at POS 02
(Alert: Fire Occupied Structure) ALRM LVL: 1\nLOC:\n2681 RD 254\nLINCOLN TWP\nBTWN: RD 155 & DEAD END\n\nRCVD AS 911\n\nCOM:\nCHIMNEY FIRE\nGETTING EVERYONE OUT OF THE HOUSE
(Alert: MVA) ALRM LVL: 1\nLOC:\n156 I-71\nPERRY TWP\nBTWN: MM 156 & MM 158\n\nRCVD AS 911\n\nCOM:\nNB\n2 SEMI\nUNK IF OTHER SEMI IS CARRYING ANY HAZMAT\nACCIDENT IS SPREAD OUT
(Alert: MVA - Non Injury) ALRM LVL: 1\nLOC:\n5475 RD 9\nGILEAD TWP\nBTWN: RD 127 & EDISON VILLAGE\n\nRCVD AS 911\n\nCOM:\nGUY STANDING ON TOP OF HIS TRUCK\nSURROUNDED BY WAT
(Alert: Gas Smell) ALRM LVL: 1\nLOC:\n6803 RD 30\nGILEAD TWP\nBTWN: RD 75 & RD 61\n\nRCVD AS 911\n\nCOM:\nSMELL OF GAS\nCALLED FROM MARION\nCALLED IN FROM A PASSING CAR\nSMELL
(Alert: MVA) ALRM LVL: 1\nLOC:\n5957 RD 28\nCANAAN TWP\nBTWN: RD 135 & ST RT 95\n\nRCVD AS 911\n\nCOM:\nIN CAR CANNOT GET OUT NEEDS HELP UNABLE TO GET OUT DUE TO SOME UNKNO

*/
public class DispatchA1Parser extends FieldProgramParser {

  public DispatchA1Parser(String defCity, String defState) {
    super(defCity, defState, 
           "ALARM_LVL:SKIP LOC:SKIP PLACE? ADDR! APT? CITY! BTWN:X COM:SKIP INFO+ CT:SKIP INFO+");
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (! subject.startsWith("Alert: ")) return false;
    data.strCall = subject.substring(7).trim();
    return parseFields(body.split("\\n"), data);
  }
  
  private class MyAptField extends AptField {

    @Override
    public boolean canFail() {
      return true;
    }

    @Override
    public boolean checkParse(String field, Data data) {
      if (field.length() > 3) return false; 
      parse(field, data);
      return true;
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("APT")) return new MyAptField();
    return super.getField(name);
  }
  
  @Override
  public String getProgram() {
    return "CALL " + super.getProgram();
  }
}
