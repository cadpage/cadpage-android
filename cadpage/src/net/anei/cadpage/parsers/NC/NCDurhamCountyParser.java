package net.anei.cadpage.parsers.NC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/* 
Durham County, NC
Contact: "Greg Parrott" <gregp@pvfd.com>,9196674642@vzwpix.com
System: OSSI
CAD:TRANSPORTATION ACCIDENT;2399 S ALSTON AVE/RIDDLE RD;{M8} CODE 2 RESPONSE [06/30/11 15:48:22 GRIFFINT] {M8} SEND ADDTL MEDIC UNIT [06/30/11 15:46:11 GRIFFINT] [
CAD:BACK PAIN;5499 SUTTERIDGE CT/LYON FARM DR;[Medical Priority Info] PROBLEM: back pain # PATS: 1 AGE: 50 Years SEX: Male CONSCIOUS: Yes BREATHING: Yes [07/05/11
CAD:PREGNANCY;5438 NEW HOPE COMMONS DR;MT MORIAH RD;HOFFLER LN
CAD:CHEST PAIN;8210 RENAISSANCE PKWY;CHEST PAIN .. [07/05/11 12:37:45 GARRETTG] EMPLOYEE INJ .. [07/05/11 12:37:15 GARRETTG] ;KNOLL CIR;LEONARDO DR
CAD:CHEST PAIN;2238 W NC 54 HWY;CELESTE CIR
CAD:TRANSPORTATION ACCIDENT;4117 EMPEROR BLVD;**************OPS1 [07/05/11 06:06:46 ARCH] ;S MIAMI BLVD;SWABIA CT
CAD:TRANSPORTATION ACCIDENT;28163 I40 E/EXIT 283;BLK 4DR VOLVO, BLK VW JETTER, BLK 2 DR JETTA [07/04/11 20:06:12 GAY]
CAD:SICK PERSON;101 GREEN CEDAR LN;[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: Unknown status/Other codes not applicable (Unknown when the symptoms
CAD:TRANSPORTATION ACCIDENT;6405 FAYETTEVILLE RD;THE CALLER WORKS INSIDE AND WAS NOT INVOLVED [07/04/11 14:35:13 BELLD] in the parking lot involving a gold toyota
CAD:FALL;1101 EXCHANGE PL;[Medical Priority Info] PROBLEM: fell # PATS: 1 AGE: 80 Years SEX: Female CONSCIOUS: Yes BREATHING: Yes [07/02/11 13:35:49 HINESLEY] ;MER
CAD:DIABETIC PROBLEM;5219 PAGE RD;CREEKSTONE DR;TERRACE PINE DR

Contact: Jeff Howard <parkwood151@gmail.com>
From: CAD@durhamnc.gov
(CAD:) ASST PD SEIZURE;1125 W NC 54 HWY;[LAW] {A324} CON BREATHING AND ALERT [09/10/11 01:52:07 MITCHELLM] Event spawned from INTOXICATED DRIVER. [09/10/2011 01:51

*/

public class NCDurhamCountyParser extends DispatchOSSIParser {
  
  public NCDurhamCountyParser() {
    super("DURHAM COUNTY", "NC",
           "CALL ADDR CH? X? X? INFO+");
  }
  
  @Override
  public String getFilter() {
    return "CAD@durhamnc.gov";
  }
  
  private static final Pattern UNIT_PTN = Pattern.compile("^\\{(.*?)\\}");
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (subject.equals("CAD:")) body = subject + body;
    if (!super.parseMsg(body, data)) return false;
    Matcher match = UNIT_PTN.matcher(data.strSupp);
    if (match.find()) {
      data.strUnit = match.group(1);
      data.strSupp = data.strSupp.substring(match.end()).trim();
    }
    return true;
  }
  
  private static final Pattern CH_PTN = Pattern.compile("\\**(OP.*)");
  private class MyChannelField extends ChannelField {

    @Override
    public boolean canFail() {
      return true;
    }

    @Override
    public boolean checkParse(String field, Data data) {
      Matcher  match = CH_PTN.matcher(field);
      if (!match.matches()) return false;
      super.parse(match.group(1), data);
      return true;
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CH")) return new MyChannelField();
    return super.getField(name);
  }
}
