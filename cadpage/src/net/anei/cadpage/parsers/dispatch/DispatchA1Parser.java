package net.anei.cadpage.parsers.dispatch;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

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

Monroeville, PA (in Allegheny County)
[Alert: Sick Person]  ALRM LVL: 1\nLOC:\n538 FIRETHORN DR\nMONROEVILLE\nBTWN: FIELDSTONE DR & N/A\n\nRCVD AS Phone\n\nCOM:\n23Y/O FEMALE SICK / ALPHA\n\nCT:\nMD103 at
[Alert: Breathing]  ALRM LVL: 1\nLOC:\n721 HEARTWOOD DR\nMONROEVILLE\nBTWN: COTTONWOOD DR & COTTONWOOD DR\n\nRCVD AS Phone\n\nCOM:\n94 YO FEMALE/DIFF BREATHING/3RD
[Alert: Fire-Alarm Activation]  ALRM LVL: 1\nLOC:\n245 AZALEA DR\nMONROEVILLE\nBTWN: GARDEN CITY DR & N/A\n\nRCVD AS Phone\n\nCOM:\n2ND FLOOR PULL STATION\n\nCT:\nMD10
[Alert: Sick Person]  ALRM LVL: 1\nLOC:\n540 FIRETHORN DR\nMONROEVILLE\nBTWN: FIELDSTONE DR & N/A\n\nRCVD AS Phone\n\nCOM:\n79 YOF HIGH TEMP, CHILLS, LETHARGIC. BRAvo
[Alert: Sick Person]  ALRM LVL: 1\nLOC:\n3912 BARBARA ANN DR\nMONROEVILLE\nBTWN: EVERGREEN DR & N/A\n\nCOM:\n90Y/O MALE - FAMILY NOW WANTS PT TRANSPORTED TO HOS
[Alert: Abdominal Pain]  ALRM LVL: 1\nLOC:\n166 KEEFER\nPENN HILLS\nBTWN: N/A & N/A\n\nRCVD AS 911\n\nCOM:\n86Y/O MALE ABD PAIN / CHARLIE\n\nCT:\nMD103 at POS 01
[Alert: Fall]  ALRM LVL: 1\nLOC:\n3912 BARBARA ANN DR\nMONROEVILLE\nBTWN: EVERGREEN DR & N/A\n\nRCVD AS Phone\n\nCOM:\n92 YO MALE/FELL/NOT BELIEVED TO BE INJURED/3R
[Alert: Heart Problem]  ALRM LVL: 1\nLOC:\n205 HEATHER DR\nMONROEVILLE\nBTWN: DUFF RD & N/A\n\nRCVD AS Phone\n\nCOM:\nRAPID HEART BEAT\n87 YOF CARDIAC HX. CHARLIE

Brown County, OH
[Alert: SMOKE IN THE AREA] ALRM LVL: 1 \nLOC: \n13101 PURDY RD\nWASHINGTON \nBTWN: N/A & N/A\n\nRCVD AS Phone\n\nCOM: CALLER ADV MAN BURNING SOMETHING ABOUT TWO HO
(Alert: SICK PERSON (SPECIFIC DIAG)) \nALRM LVL: 1 \nLOC: DEERFIELD TOWNHOUSE \nAPARTMENTS \n455 W MAIN ST \nAPT 703 \nMT ORAB \nBTWN: N/A & N/A\n\nRCVD AS Phone\n\nCOM
[Alert: SMOKE IN THE AREA]  ALRM LVL: 1 (not sure what level is for)\nLOC:\n13101 PURDY RD (address)\nWASHINGTON   (this is the township or village name)\nBTWN: N/A & N/A (intersections)\n\nRCVD AS Phone\n\nCOM:\nCALLER ADV MAN BURNING SOMETHING ABOUT TWO HO (comments)
(Alert: SICK PERSON (SPECIFIC DIAG)) ALRM LVL: 1\nLOC:\nDEERFIELD TOWNHOUSE APARTMENTS\n455 W MAIN ST\nAPT 703\nMT ORAB\nBTWN: N/A & N/A\n\nRCVD AS Phone\n\nCOM:
(Alert: BREATHING PROBLEMS) ALRM LVL: 1\nLOC:\n14885 EASTWOOD RD\nSTERLING\nBTWN: TRI-COUNTY HWY & N/A\n\nRCVD AS 911\n\nCOM:\n60 YOF\n\nCT:\n6D0013 at POS 03
(Alert: PSYCH/ABNRML BEHVR/SUICIDE ATT) ALRM LVL: 1\nLOC:\n14964 HILL CREST RD\nGREEN\nBTWN: BARDWELL-BUFORD RD & GREENBUSH EAST RD\n\nRCVD AS Phone\n\nCOM:\nCAL
(Alert: BREATHING PROBLEMS) ALRM LVL: 1\nLOC:\n1871 CROSSTOWN ROAD\nSTERLING TWP\nBTWN: N/A & N/A\n\n\n\nCOM:\n78 Y O F\nHAVING TROUBLE BRAETHING\nCOPD\nDIFFICULTY
(Alert: CHEST PAIN (NON TRAUMATIC)) ALRM LVL: 1\nLOC:\n7703 GARDNER RD\nLEWIS\nBTWN: OAK GROVE RD & N/A\n\nRCVD AS Phone\n\nCOM:\nSEVERE CHEST PAINS\n77 Y O M\nPA
(Alert: PSYCH/ABNRML BEHVR/SUICIDE ATT) ALRM LVL: 1\nLOC:\n200 COLUMBIA ST\nHIGGINSPORT\nBTWN: OLIVE ST & JOHN ST\n\nRCVD AS Phone\n\nCOM:\nBOYFRIEND WENT TO CHE
(Alert: SICK PERSON (SPECIFIC DIAG)) ALRM LVL: 1\nLOC:\nDEERFIELD TOWNHOUSE APARTMENTS\n455 W MAIN ST\nAPT 703\nMT ORAB\nBTWN: N/A & N/A\n\nRCVD AS Phone\n\nCOM:
(Alert: STRUCTURE FIRE UNCONFIRMED) ALRM LVL: 1\nLOC:\n2567 US RTE 134\nBTWN: N/A & N/A\n\nRCVD AS PHONE\n\nCOM: ADVISED SMOKE WAS COMING OUT OF THE WINDOWS CA
(Alert: FIRE ALARM) ALARM LVL: 1\nLOC:\n11519 US RTE 62\nEAGLE\nBTWN: N/A & MAPLE DR\n\nRCVD AS PHONE\n\nCOM: FIRE ALARM EASTERN MIDDLE SCHOOL DUCT SMOKE D

*/
public class DispatchA1Parser extends FieldProgramParser {

  public DispatchA1Parser(String defCity, String defState) {
    super(defCity, defState, 
           "ALRM_LVL:PRI LOC:SKIP PLACE? ADDR! APT? CITY BTWN:X COM:INFO INFO+ CT:INFO INFO+");
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (! subject.startsWith("Alert: ")) return false;
    data.strCall = subject.substring(7).trim();
    return parseFields(body.split("\\n"), data);
  }
  
  private class MyPlaceField extends PlaceField {

    @Override
    public boolean canFail() {
      return true;
    }

    @Override
    public boolean checkParse(String field, Data data) {

      // If first or second following field starts with BTWN: this must be an address
      // followed by a city
      if (getRelativeField(1).startsWith("BTWN:")) return false;
      if (getRelativeField(2).startsWith("BTWN:")) return false;
      
      // If next field looks like an apartment, and third field starts with BTWN:, 
      // then this must be an address followed by apartment and city
      if ((getRelativeField(1).length()<=3 || getRelativeField(1).startsWith("APT"))&& 
           getRelativeField(3).startsWith("BTWN:")) return false;
      
      // Otherwise, we can be a place field
      parse(field, data);
      return true;
    }
  }
  
  private class MyAptField extends AptField {

    @Override
    public boolean canFail() {
      return true;
    }

    @Override
    public boolean checkParse(String field, Data data) {
      if (field.startsWith("APT")) {
        field = field.substring(3).trim();
      } 
      else if (field.length() > 3) return false; 
      parse(field, data);
      return true;
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("PLACE")) return new MyPlaceField();
    if (name.equals("APT")) return new MyAptField();
    return super.getField(name);
  }
  
  @Override
  public String getProgram() {
    return "CALL " + super.getProgram();
  }
}
