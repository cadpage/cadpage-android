package net.anei.cadpage.parsers.NJ;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

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

Contact: Active911.com
[CAD] S432 RESPOND: #12-0074884 Ridgewood *223 N Van Dien Ave *The Valley Hospital *P4E-4310/D*Linwood Ave/Meadowbrook Ave *Trans/Interfacility/Palliative09:15 Code:\n
[CAD] S432 CANCEL: #12-0074884 Ridgewood *223 N Van Dien Ave Paged:09:15 Enrte:09:18 Scene:09:54 Avail: Cxl Rsn: Cancelled By RN Code:\n
[CAD] S432 RESPOND: #12-0074958 Ridgewood *223 N Van Dien Ave *The Valley Hospital *P3E-3322/D*Linwood Ave/Meadowbrook Ave *Trans/Interfacility/Palliative11:35 Code:\n
[CAD] S432 @ # 12-0074958 Disp 11:35 Enrt 11:42 Scen 11:49 Tran 12:08 Hosp 12:22\n
[CAD] S432 RESPOND: #12-0075072 Ridgewood *223 N Van Dien Ave *The Valley Hospital *B2B-2231/P*Linwood Ave/Meadowbrook Ave *Trans/Interfacility/Palliative15:17 Code:\n
[CAD] S432 @ Oradell Health Care Center # 12-0075072 Disp 15:17 Enrt 15:26 Scen 15:40 Tran 15:59 Hosp 16:12\n
[CAD] S432 RESPOND: #12-0076085 Ridgewood *223 N Van Dien Ave *The Valley Hospital *2W/2337W *Linwood Ave/Meadowbrook Ave *Trans/Interfacility/Palliative09:46 Code:\n
[CAD] S432 @ # 12-0076085 Disp 09:46 Enrt 09:55 Scen 10:32 Tran 11:04 Hosp 11:20\n
[CAD] S432 RESPOND: #12-0076157 Ridgewood *223 N Van Dien Ave *The Valley Hospital *4B-4127 *Linwood Ave/Meadowbrook Ave *Trans/Interfacility/Palliative12:21 Code:\n
[CAD] S432 @ # 12-0076157 Disp 12:21 Enrt 12:23 Scen 12:56 Tran 13:28 Hosp 13:48\n
[CAD] S432 RESPOND: #12-0076225 Ridgewood *223 N Van Dien Ave *The Valley Hospital *4E-4309 *Linwood Ave/Meadowbrook Ave *Trans/Interfacility/Palliative14:10 Code:\n
[CAD] S432 @ # 12-0076225 Disp 14:10 Enrt 14:11 Scen 14:34 Tran 15:04 Hosp 15:36\n
[CAD] S432 RESPOND: #12-0076286 Ridgewood *223 N Van Dien Ave *The Valley Hospital *2A-2218 *Linwood Ave/Meadowbrook Ave *Trans/Interfacility/Palliative16:03 Code:\n
[CAD] S432 @ Kessler (Saddle Brook) # 12-0076286 Disp 16:03 Enrt 16:11 Scen 17:03 Tran 17:03 Hosp 17:53\n
[CAD] S432 RESPOND: #12-0076501 Ridgewood *223 N Van Dien Ave *The Valley Hospital *3W-3339 *Linwood Ave/Meadowbrook Ave *Trans/Interfacility/Palliative09:17 Code:\n
[CAD] S432 @ # 12-0076501 Disp 09:17 Enrt 09:19 Scen 09:52 Tran 10:12 Hosp 10:19\n
[CAD] S432 RESPOND: #12-0076551 Ridgewood *223 N Van Dien Ave *The Valley Hospital *4E-4307 *Linwood Ave/Meadowbrook Ave *Trans/Interfacility/Palliative10:43 Code:\n
[CAD] S432 @ # 12-0076551 Disp 10:43 Enrt 10:51 Scen 11:03 Tran 11:27 Hosp 11:40\n
[CAD] S432 RESPOND: #12-0076653 Ridgewood *223 N Van Dien Ave *The Valley Hospital *3E-3302 *Linwood Ave/Meadowbrook Ave *Trans/Interfacility/Palliative14:17 Code:\n
[CAD] S432 @ # 12-0076653 Disp 14:17 Enrt 14:19 Scen 14:42 Tran 15:14 Hosp 15:47\n
[CAD] S432 RESPOND: #12-0076703 Ridgewood *223 N Van Dien Ave *The Valley Hospital *3E-3318W *Linwood Ave/Meadowbrook Ave *Trans/Interfacility/Palliative15:53 Code:\n
[CAD] S432 @ Care One at Valley (Westwood) # 12-0076703 Disp 15:53 Enrt 15:55 Scen 16:35 Tran 16:35 Hosp 16:54\n

 */


public class NJMICOMParser extends MsgParser {
  
  private static final Pattern CALL_DELIM = Pattern.compile("(?:-[AB]LS *)?\\d\\d:\\d\\d");
  
  public NJMICOMParser() {
    super("", "NJ");
  }
  
  @Override
  public String getFilter() {
    return "miccom@nnjmicu.org";
  }
  
  @Override
  public String getLocName() {
    return "MICOM (northern NJ), NJ";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("CAD")) return false;
    
    Parser p = new Parser(body);
    String type = p.get(' ');
    if (!type.equals("CANCEL:") && !type.equals("RESPOND:")  && !type.equals("@")) {
      data.strUnit = type;
      type = p.get(' ');
    }
    if (! type.equals("RESPOND:")) {
      if (!type.equals("CANCEL:") && !type.equals("@")) return false;
      data.strCall = "RUN REPORT";
      data.strPlace = type + " " + p.get();
      return true;
    }
    p.get('#');
    data.strCallId = p.get(' ');
    data.strCity = p.get('*');
    
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
