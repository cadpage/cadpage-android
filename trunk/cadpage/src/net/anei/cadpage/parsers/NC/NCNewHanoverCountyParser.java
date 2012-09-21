package net.anei.cadpage.parsers.NC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/* 
New Hanover County, NC
Contact: Alan Griffin <cbfirechief@gmail.com>
Sender: messaging@iamresponding.com

(Station 21) CAD:ST21;RESIDENTIAL SINGLE ALARM;1107 CANAL DR;****TAC3*****;resd altrm... kitchen heat [04/11/12 14:19:37 LLA] *****tac3***** [04/11/12 1
CAD:ST21;ELEVATOR MALFUN OCCUPANTS IN;1109 BOWFIN LN;2522580313;stoke in elevator [05/10/12 05:59:33 ANL] [Fire Priority Info] RESPONSE: Alpha RESPONDER SCRIPT: Elevator / Escalator Rescue. Elevator malfunction -- occupants inside
CAD:ST21;WATER PROBLEM;501 S DOW RD;DOG PARK;broken water pipe gushing water [05/07/12 20:21:48 LAM] PRE ALERT GIVEN [05/07/12 20:22:42 KDN] [Fire Priority Info] RESPONSE: Alpha RESPONDER SCRIPT: Citizen Assist / Service Call. Water probl;M
CAD:ST21;HAZMAT UNCONTAINED;78 MYRTLE AVE;****TAC2****;sewage problem [05/05/12 11:24:02 MLM] [Fire Priority Info] RESPONSE: Delta RESPONDER SCRIPT: HAZMAT. UNCONTAINED HAZMAT (Biological). 1.The caller is on scene (1st party).
CAD:ST21;LARGE OUTSIDE FIRE;100 FREEMAN PARK;NORTH END;caller adv she is at the north end on carolina beach...a large group has a bonfire going..... [05/04/12 23:15:17 EEB] *******PRE ALRET*******OUTSIDE FIRE [05/04/12 23:15:59 EEB]
CAD:ST21;RESIDENTIAL SINGLE STRUCTURE;1300 CANAL DR;fire under the house [05/04/12 19:46:14 MJL] [Fire Priority Info] RESPONSE: Delta RESPONDER SCRIPT: Structure Fire. Residential (single). 1.The caller is on scene (1st party). 2.Smoke is v

*/

public class NCNewHanoverCountyParser extends DispatchOSSIParser {
  
  public NCNewHanoverCountyParser() {
    super("NEW HANOVER COUNTY", "NC",
           "SRC CALL ADDR EXTRA! INFO+");
  }
  
  @Override
  public String getFilter() {
    return "messaging@iamresponding.com";
  }
  
  private static final Pattern ASTERISK_PTN = Pattern.compile("\\*\\*+");
  private static final Pattern CHANNEL_PTN = Pattern.compile("\\*(TAC\\d+)\\*", Pattern.CASE_INSENSITIVE);
  private static final Pattern ID_PTN = Pattern.compile("\\d{5,}");
  private static final Pattern PLACE_PTN = Pattern.compile("[A-Z ]+");
  private class MyExtraField extends Field {
    @Override
    public void parse(String field, Data data) {
      field = ASTERISK_PTN.matcher(field).replaceAll("*");
      Matcher match = CHANNEL_PTN.matcher(field);
      if (match.matches()) {
        data.strChannel = match.group(1).toUpperCase();
        return;
      }
      
      match = ID_PTN.matcher(field);
      if (match.matches()) {
        data.strCallId = field;
        return;
      }
      
      match = PLACE_PTN.matcher(field);
      if (match.matches()) {
        data.strPlace = field;
        return;
      }
      
      data.strSupp = field;
    }
    
    @Override
    public String getFieldNames() {
      return "CH ID PLACE INFO";
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      field = ASTERISK_PTN.matcher(field).replaceAll("*");
      super.parse(field, data);
    }
  }
  
  @Override
  protected Field getField(String name) {
    if (name.equals("SRC")) return new SourceField("ST\\d+", true);
    if (name.equals("EXTRA")) return new MyExtraField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
}
