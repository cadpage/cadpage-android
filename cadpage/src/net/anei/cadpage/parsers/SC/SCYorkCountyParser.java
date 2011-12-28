package net.anei.cadpage.parsers.SC;

import java.util.Properties;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
York County, SC 
Contact: "Carter, John" <john.carter@yorkcountygov.com>
(unit) F212  (priority)P: 2  (location) LOC: 375 STARLIGHT DR (cross streets) X: CAUSE WAY LN / ZENITH AV * *(venue/town) Fort Mill * * (call type)Trauma * (channel)MED OPS 2//FALL W/INJURY * (caller) RYAN CORNWEL (narrative)NAR:  FRONT OF MOTEL CALLER WILL FLAG THEM DOWN  RM 374/53 YOM FELL OFF SCAFFOLDING LAST WEEK FELL AGAIN TODAY/HIP PAIN  (incident number) INC#: 2010-00009042

F212  P: 2 LOC: 375 STARLIGHT DR X: CAUSE WAY LN / ZENITH AV * * Fort Mill * * Trauma * MED OPS 2//FALL W/INJURY * RYAN CORNWEL NAR:  FRONT OF MOTEL CALLER WILL FLAG THEM DOWN  RM 374/53 YOM FELL OFF SCAFFOLDING LAST WEEK FELL AGAIN TODAY/HIP PAIN  INC#: 2010-00009042 
FM2  P: 1 LOC: 9657 BLACK HORSE RUN X: * * * * Structure Fire * YCF OPS 2/STR FIRE * LANCASTER CNTY NAR:  HWY 521 CHARLOTTE HWY  FT MILL ASSIST ON MUTUAL AIDE  INC#: 2010-00000702 
RFE1 RFE5 RFE2 RFL1 RFB1  P: 1 LOC: 229 BLANCHE CIR X: STROUPE ST / CRAWFORD RD * CRAWFORD PARK * Rock Hill * * Structure Fire * RHF OPS 2/ STRUCT FIRE * NAR:  ABANDONED HOUSE ON FIRE, FLAMES VISIBLE  INC#: 2010-00005928 
P: 1 LOC: E  MAIN ST X: S  ANDERSON RD * * Rock Hill * * Vehicle Fire * YCF OPS 2/VEHICLE FIRE * STANLEY YOUNG NAR:  SMOKE COMING FROM HIS CAR//IN THE PARKING LOT ROCK TAVERN AND BAR NUMBER 2  INC#: 2010-00000439
EMS2  P: 2 LOC: 831 MCDOW DR X: ALABAMA CT / CHARLOTTE AV * * Rock Hill * * Medical * MED OPS 2/RENAL PROBLEMS * WESTMINSTER HEALTH & NAR:  82YOF/BLEEDING FROM HER CATHATER AND HAS A KIDNEY INFECTION  INC#: 2010-00023193
RFE4 RFE2 RFL1 RFB1  P: 1 LOC: 1830 W  MAIN ST X: CARDINAL POINTE DR / BRITTANY RIDGE PL, FINCHER RD * * Rock Hill * * Fire Alarm * RHF OPS2 / COMM FIRE ALARM * NAR:  INC#: 2010-00005938 
YRS1 EMS6  P: 1 LOC: 24 CANNON CT X: DEAD END / ROSS CANNON ST * * York * * Medical Emergency * MED OPS 2 / GI BLEED * NAR:  INC#: 2010-00002884
CRS1 EMS5  P: 1 LOC: 2715 FILBERT HWY X: GOOD RD / SOUTHBEND RD * * Clover * * Medical Emergency * MED OPS 3/TROUBLE BREATHING * DEBBIE MITCHEL NAR:  INC#: 2010-00001750 
EMS1 RFE3  P: 1 LOC: 227 LONE OAK CIR X: INDIA HOOK RD / INDIA HOOK RD * VILLAGE AT INDIA HOOK * Rock Hill VILLAGE AT IND * * Medical Emergency * MED OPS 2 / DIABETIC  * LINDEMANN C DR NAR:  INC#: 2010-00023236 
EMS9  P: 1 LOC: 101 SEDGEWOOD DR X: EBENEZER RD / WINTHROP DR * * Rock Hill * * Trauma Emergency * MED OPS 2/SUICIDE ATTEMPT * SAUNDRA WHITE NAR:  RHPD ADVISED  18 YOM/TIED SHIRT AROUND HIS NECK/STUCK HEAD IN TOILET/COMBATIVE/HAS BEEN GIVEN MEDS TO HELP HIM CALM DOWN/BANGING HEAD ON WALL/ENTER AT FRONT OF FACILITY BEHIND FOUNDERS  INC#: 2010-00023234

"Domenic Manera" <dmanera@yorkcitysc.com>  (York fire chief)
Sender: <paging@yorkcountygov.com>
YK1  P: 2 LOC: 5700 WYLIE AV X: BELT ST / CHURCH ST * * Hickory Grove * HICKORY GROVE FIRE DEPT* ZZTest Call * TEST CALL ONLY / NO RESPONSE NEEDED * CANDIE NAR:  TESTING FOR YORK FIRE DEPT / NO RESPONSE NEEDED INC#: 2011-00000973
 
 */


public class SCYorkCountyParser extends MsgParser {
  
  private static final String[] KEYWORDS = new String[]{"UNIT", "P", "LOC", "X", "NAR", "INC#"}; 

  public SCYorkCountyParser() {
    super("YORK COUNTY", "SC");
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    Properties props = parseMessage("UNIT: " + body, KEYWORDS);
    if (props.getProperty("P") == null) return false;
    
    data.strUnit = props.getProperty("UNIT", "");
    String sAddr = props.getProperty("LOC");
    if (sAddr == null) return false;
    parseAddress(sAddr, data);
    
    body = props.getProperty("X");
    if (body == null) return false;
    
    Parser p = new Parser(body);
    data.strCross = p.get('*');
    data.strPlace = p.get('*');
    data.strCity = p.get('*');
    data.strPlace = append(data.strPlace, " - ", p.get('*'));
    data.strCall = p.get('*') + " - " + p.get('*');
    
    data.strSupp = props.getProperty("NAR", "");
    data.strCallId = props.getProperty("INC#", "");

    if (data.strPlace.length() > 0) {
      String tmp = new Parser(data.strPlace).get(' ');
      int ipt = data.strCity.indexOf(" " + tmp);
      if (ipt >= 0) data.strCity = data.strCity.substring(0,ipt).trim();
    }

    return true;
  }
}
