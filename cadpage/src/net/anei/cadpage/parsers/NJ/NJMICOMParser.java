package net.anei.cadpage.parsers.NJ;

import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmsMsgParser;

/*
Bergen County, NJ
Contact: "jces9063@aol.com" <jces9063@aol.com>
Sender: miccom@nnjmicu.org

(CAD)  RESPOND: #10-0092 ENGLEWOOD CLIFFS BOR*580 Sylvan Ave * *SUITE B *DEMAREST AVE/UNNAMED STREET *Unknown Problem (Man Down)-BLS08:23 Code:31B01
(CAD) S332 RESPOND: #10-0090603 ENGLEWOOD CITY *143 Engle St * * *E DEMAREST AVE/CHESTNUT ST *Falls-BLS 10:46 Code:17b01 
(CAD) S332 CANCEL: #10-0090603 ENGLEWOOD CITY *143 Engle St Paged:10:46 Enrte:10:48 Scene:10:54 Avail:11:33 Cxl Rsn: Refused Medical Aid Code:17b01
(CAD) S2 RESPOND: #10-0092818 FORT LEE BORO *0 - 0 Bridge Plz N *WALGREENS * *LEMOINE AVE/LEMOINE AVE *Traumatic Injuries-BLS 16:01 Code:30bt1

Contact: NICHOLAS RANDISI <nicholas.randisi@gmail.com>
(CAD) S1041 RESPOND: #11-0074384 Garfield City *57 Spring St * *2 *Belmont Ave/Botany St *Unconscious/Fainting-ALS 22:01 Code:

Morris County, NJ
Contact: rod smith <bravo2247@gmail.com>
(CAD) T541 RESPOND: #11-0071085 Denville Twp *21 Pocono Rd *Fransiscan Oaks Health Ce*303B *Unnamed Street/Unnamed Street *Trans/Interfacility/Palliative14:05 Co

 */


public class NJMICOMParser extends SmsMsgParser {
  
  private static final Pattern CALL_DELIM = Pattern.compile("(?:-[AB]LS *)?\\d\\d:\\d\\d");
  
  public NJMICOMParser() {
    super("", "NJ");
  }
  
  @Override
  public String getFilter() {
    return "miccom@nnjmicu.org";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("CAD")) return false;
    
    Parser p = new Parser(body);
    String type = p.get(' ');
    if (!type.equals("CANCEL:") && !type.equals("RESPOND:")) {
      data.strUnit = type;
      type = p.get(' ');
    }
    p.get('#');
    data.strCallId = p.get(' ');
    data.strCity = p.get('*');
    
    if (! type.equals("RESPOND:")) return false;
    parseAddress(p.get('*'), data);
    if (data.strAddress.length() == 0) return false;
    
    data.strPlace = p.get('*');
    data.strApt = p.get('*');
    data.strCross = p.get('*');
    data.strCall = p.get(CALL_DELIM);
    
    for (String suffix : new String[]{" BOR", " BORO"}) {
      if (data.strCity.endsWith(suffix)) {
        data.strCity = data.strCity.substring(0, data.strCity.length()-suffix.length());
      }
    }
    
    return true;
  }
}
