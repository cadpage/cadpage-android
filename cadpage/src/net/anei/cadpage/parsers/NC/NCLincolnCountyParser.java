package net.anei.cadpage.parsers.NC;

import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/* 
Lincoln County, NC
Contact: Jason Reed <jreed@denverfd.com>
Sender: cad@lincolnsheriff.org
System: OSSI CAD

4567:CAD:KFD-26D01-26-D-1 SICK PERSON-9999 PALMETTO LN-PANORAMIC LN-TODD LN-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: You are responding to a patient who is sick (or has a current medical condition). The patient is a <REMOVED PT DATA>, who is conscious and
4568:CAD:KFD3-06D04-6-D-4 BREATHING PROBLEMS-8888 N NC 16 HWY-DELLING COMMUNICATIONS-CHARTER LN-HAGERS HOLLOW DR-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: <REMOVED PT DATA>, Conscious, Breathing. Breathing Problems. Clammy. 1.He is completely alert (responding appropriately). 2.He does not have
4569:CAD:KFD-06D02-6-D-2 BREATHING PROBLEMS-7777 DICK WILSON RD-CAMPGROUND RD-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: <REMOVED PT DATA>, Conscious, Breathing. Breathing Problems. DIFFICULTY SPEAKING BETWEEN BREATHS. Caller Statement: DIFFICULTY BREATHING AND
4570:CAD:KLF-201101460-SMOKE INVESTIGATION-N LITTLE EGYPT RD/NC 73 HWY-near the ball field [03/22/11 10:13:09 DISPATCHER] blk smoke near track unkn source [03/22/11 10:12:22]
4571:CAD:KFD-201101410-67D02-OUTSIDE FIRE-1111 SAILVIEW DR-CREPE RIDGE DR-CHAPEL CREEK DR-[Fire Priority Info] RESPONSE: Delta RESPONDER SCRIPT: Outside Fire. Brush/grass fire.Caller Statement: burning brush . 2.The caller is safe and out of danger. 3.Everyone else is safe and out of
1221:CAD:DFD-201101274-ASSIST MOTORIST AGENCY OFFICER-5555 KING WILKINSON RD-CALVARY BAPTIST CHURCH-MOUNTAINBROOK LN-DELLING DOWNS DR-Event spawned from LOG CALL FOR RECORDS. [03/10/2011 20:03:33 SAM] TREE ACROSS THE ROAD [03/10/11 20:03:06 SAM]
1873:CAD:JLFD-201101315-52C03U-ALARMS FOR FIRE-888 OPTIMIST CLUB RD-WOODMONT CARE CENTER-FORNEY CREEK PKWY-WOODS LN-[Fire Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: Alarms. COMMERCIAL structure (Unknown).Caller Statement: FIRE ALARM . 1.The caller is an alarm

*/

public class NCLincolnCountyParser extends DispatchOSSIParser {
  
  private static Pattern CODE_PTN = Pattern.compile("\\b\\d{1,2}-[A-Z]-\\d\\b");
  
  public NCLincolnCountyParser() {
    super("LINCOLN COUNTY", "NC",
           "ID: ( CODE | SRC ID CODE?) CALL ADDR PLACE? X X? INFO+");
  }
  
  @Override
  public String getFilter() {
    return "cad@lincolnsheriff.org";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    // For medical call, the code is duplicated and the one in the call
    // description has dashes, which we are going to use a field separators
    // Easy solution is to just get rid of it.
    body = CODE_PTN.matcher(body).replaceFirst("");
    if (! super.parseMsg(body, data)) return false;
    return true;
  }
  
  private class MyCodeField extends CodeField {
    public MyCodeField() {
      setPattern(Pattern.compile("\\d{2}[A-Z]\\d{2}"));
    }
  }
  
  @Override
  protected Field getField(String name) {
    if (name.equals("CODE")) return new MyCodeField();
    return super.getField(name);
  }
}
