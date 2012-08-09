
package net.anei.cadpage.parsers.AL;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgParser;

/*
Baldwin County, AL
Contact: Josh Hines <josh36530@gmail.com>
Sender: cad@baldwin911.org

- E911 Notification - Elberta VFD - 05-20-12 13:43: Station STA31 dispatched to Incident ID 290161 (Stroke) at 25855 WILLOW RIDGE R
- E911 Notification - Elberta VFD - 05-21-12 15:35: Station STA31 dispatched to Incident ID 290600 (Fire - Grass) at 17305 JOE GOTTLER RD
- E911 Notification - Elberta VFD - 05-24-12 08:48: Station STA31 dispatched to Incident ID 291543 (Auto Accident) at 14850 87\n
- E911 Notification - Elberta VFD - 05-26-12 08:04: Station STA31 dispatched to Incident ID 292420 (Auto Accident) at US HWY 98 @ SANDY LN
- E911 Notification - Elberta VFD - 05-26-12 16:24: Station STA31 dispatched to Incident ID 292625 (Auto Accident) at HWY98 @ CORD9

Contact: Active911
Agency name: Daphne Fire Dept. Location: Daphne, AL 
Sender: messaging@iamresponding.com

(DA) 07-27-12 22:54: Station STA66 dispatched to Incident ID 318501 (Suicide) at 8764 DRIFTON CT
(DA) 07-28-12 01:58: Station STA66 dispatched to Incident ID 318559 (Chest Pain) at 29793 WOODROW LN
(DA) 07-28-12 13:44: Station STA66 dispatched to Incident ID 318716 (General Illness) at 131 RIDGEWOOD DR (0)
(DA) 07-28-12 14:11: Station STA66 dispatched to Incident ID 318728 (Auto Accident) at HWY181 NB I-10
(DA) 07-28-12 19:56: Station STA66 dispatched to Incident ID 318908 (Fire Alarm) at 29758 FREDERICK BLVD
(DA) 07-28-12 20:52: Station STA66 dispatched to Incident ID 318944 (General Illness) at 27642 HWY 98
(DA) 07-28-12 22:42: Station STA66 dispatched to Incident ID 318990 (Chest Pain) at MCDONALDS STATE HWY 181
(DA) 07-29-12 03:22: Station STA66 dispatched to Incident ID 319047 (Abdominal Pain) at 29960 SAINT SIMON ST
(DA) 07-29-12 06:52: Station STA66 dispatched to Incident ID 319067 (Unknown Medical) at 9020 ASHLEY CT (0)
(DA) 07-29-12 09:06: Station STA66 dispatched to Incident ID 319086 (Unconscious) at 200 PARMA DR
(DA) 07-29-12 11:38: Station STA66 dispatched to Incident ID 319128 (Fire Alarm) at 27642 US HWY 98
(DA) 07-29-12 14:03: Station STA66 dispatched to Incident ID 319179 (Stroke) at 28480 BAY CLIFF LN
(DA) 07-29-12 15:23: Station STA66 dispatched to Incident ID 319200 (Suicide Threat) at 8764 DRIFTON CT
(DA) 07-30-12 06:56: Station STA66 dispatched to Incident ID 319399 (Structure Fire) at PARK DR
(DA) 07-30-12 08:19: Station STA66 dispatched to Incident ID 319417 (Unconscious) at 27434 STRATFORD GLEN DR
(DA) 07-30-12 08:51: Station STA66 dispatched to Incident ID 319429 (Fall) at 29951 ST BARBARA ST
(DA) 07-30-12 10:21: Station STA66 dispatched to Incident ID 319457 (Suicide Threat) at 133 LAKE FRONT DR
(DA) 07-30-12 10:40: Station STA66 dispatched to Incident ID 319466 (Unknown Medical) at 27961 U S HWY 98
(DA) 07-30-12 11:26: Station STA66 dispatched to Incident ID 319479 (Auto Accident) at CO RD 64/ FRIENDSHIP RD
(DA) 07-30-12 11:53: Station STA66 dispatched to Incident ID 319486 (Bleeding) at 7411 REEDS LN
(DA) 07-30-12 13:12: Station STA66 dispatched to Incident ID 319521 (Fire - Grass) at I-10 WB J E OF EX35
(DA) 07-30-12 17:47: Station STA66 dispatched to Incident ID 319685 (Auto Accident) at I-10 EB EXIT RAMP AT EXIT 35
(DA) 07-30-12 19:44: Station STA66 dispatched to Incident ID 319730 (Bleeding) at 7878 PINE RUN
(DA) 07-30-12 20:34: Station STA66 dispatched to Incident ID 319744 (Unknown Medical) at 27440 COUNTY RD 13
(DA) 07-30-12 22:55: Station STA66 dispatched to Incident ID 319780 (Fall) at 1105 WHISPERING PINES RD (0)
(DA) 07-31-12 11:10: Station STA66 dispatched to Incident ID 319906 (Cardiac Arrest) at 101 VILLA DR (36526)
(DA) 07-31-12 12:47: Station STA66 dispatched to Incident ID 319931 (Seizure) at 29249 U S HWY 98
(DA) 07-31-12 22:11: Station STA66 dispatched to Incident ID 320132 (Chest Pain) at 27522 HARBOR CV
(DA) 08-01-12 07:39: Station STA66 dispatched to Incident ID 320217 (Auto Accident) at HWY 181 @ I10
(DA) 08-01-12 11:32: Station STA66 dispatched to Incident ID 320275 (General Illness) at 107 CALVERDALE CIR (0)
(DA) 08-01-12 12:23: Station STA66 dispatched to Incident ID 320292 (Unknown Medical) at 912 VAN AV
(DA) 08-01-12 12:57: Station STA66 dispatched to Incident ID 320307 (Fracture) at 148 ROLLING HILL DR
(DA) 08-01-12 13:24: Station STA66 dispatched to Incident ID 320320 (Fire Alarm) at 1506 MAIN ST
(DA) 08-01-12 13:46: Station STA66 dispatched to Incident ID 320330 (Fire Alarm) at 29645 FREDERICK BLVD
(DA) 08-01-12 15:39: Station STA66 dispatched to Incident ID 320366 (Auto Accident) at TARGET PKING LOT NEAR THE BANK
(DA) 08-01-12 15:47: Station STA66 dispatched to Incident ID 320374 (General Illness) at 1705 MAIN ST
(DA) 08-01-12 16:18: Station STA66 dispatched to Incident ID 320386 (Chest Pain) at 501 OAK RIDGE CT E (0)
(DA) 08-01-12 16:37: Station STA66 dispatched to Incident ID 320396 (Chest Pain) at 7443 REEDS LN (36526)
(DA) 08-02-12 07:25: Station STA66 dispatched to Incident ID 320597 (Fall) at 29919 WOODROW LN
(DA) 08-02-12 09:25: Station STA66 dispatched to Incident ID 320625 (Assistance) at 27250 U S HWY 98
(DA) 08-02-12 13:50: Station STA66 dispatched to Incident ID 320720 (Fall) at 26210 EQUITY DR (0)
(DA) 08-02-12 18:11: Station STA66 dispatched to Incident ID 320842 (Unconscious) at 201  DAPHMONT DR EXT
(DA) 08-02-12 18:47: Station STA66 dispatched to Incident ID 320857 (Fall) at 27296 COUNTY RD 13
(DA) 08-03-12 10:01: Station STA66 dispatched to Incident ID 321053 (Fire Alarm) at 7101 U S HWY 90
(DA) 08-03-12 12:06: Station STA66 dispatched to Incident ID 321109 (Chest Pain) at 2603 98
(DA) 08-03-12 13:19: Station STA66 dispatched to Incident ID 321144 (Welfare concern) at 27434 STRATFORD GLEN DR
(DA) 08-03-12 15:07: Station STA66 dispatched to Incident ID 321192 (General Weakness) at 101 VILLA DR (36526)
(DA) 08-03-12 19:02: Station STA66 dispatched to Incident ID 321282 (Bleeding) at 28611 U S HWY 98
(DA) 08-03-12 20:20: Station STA66 dispatched to Incident ID 321327 (Back Pain) at MCDONALD'S HWY98 DAPHNE,AL
(DA) 08-03-12 20:35: Station STA66 dispatched to Incident ID 321335 (Fire Alarm) at 28788 N MAIN ST
(DA) 08-04-12 04:21: Station STA66 dispatched to Incident ID 321481 (Neck Injury) at 104 CHATWOOD CIR
(DA) 08-04-12 06:52: Station STA66 dispatched to Incident ID 321496 (Auto Accident) at I-10 EB MALBIS EX
(DA) 08-04-12 11:04: Station STA66 dispatched to Incident ID 321564 (Auto Accident) at HWY181 SB @ I-10 ON RAMP
(DA) 08-04-12 12:24: Station STA66 dispatched to Incident ID 321599 (Auto Accident) at HWY181 SB  @ DUNMORE SUB
(DA) 08-04-12 12:41: Station STA66 dispatched to Incident ID 321607 (Fall) at 10171 PAPAGEORGE ST (0)
(DA) 08-04-12 12:58: Station STA66 dispatched to Incident ID 321614 (Unknown Medical) at 3075 U S HWY 98 (0)
(DA) 08-04-12 17:22: Station STA66 dispatched to Incident ID 321719 (Personal Assist) at 27440 COUNTY RD 13
(DA) 08-04-12 22:21: Station STA66 dispatched to Incident ID 321867 (Unknown Medical) at WALMART IN DAPHNE
(DA) 08-04-12 23:21: Station STA66 dispatched to Incident ID 321886 (Chest Pain) at 26920 POLLARD RD
(DA) 08-05-12 00:18: Station STA66 dispatched to Incident ID 321914 (Unknown Medical) at 504 CHURCH AV
(DA) 08-05-12 01:28: Station STA66 dispatched to Incident ID 321944 (Unknown Medical) at 504 CHURCH AV
(DA) 08-05-12 03:49: Station STA66 dispatched to Incident ID 321963 (Difficulty Breathing) at 28509 2ND ST (36526)
(DA) 08-05-12 09:55: Station STA66 dispatched to Incident ID 322005 (Headache) at 10171 PAPAGEORGE ST (0)
(DA) 08-05-12 11:24: Station STA66 dispatched to Incident ID 322056 (Fall) at 27296 CO RD 13
(DA) 08-05-12 16:50: Station STA66 dispatched to Incident ID 322183 (Auto Accident) at HWY 98/ BEFORE I-10 OVERPASS
(DA) 08-05-12 17:08: Station STA66 dispatched to Incident ID 322192 (Mental Person) at 28609 CASCADES CT
(DA) 08-05-12 17:31: Station STA66 dispatched to Incident ID 322206 (Auto Accident) at I10 EB MM35B
(DA) 08-05-12 20:57: Station STA66 dispatched to Incident ID 322288 (Fall) at 112 BUENA VISTA DR (0)
(DA) 08-05-12 21:41: Station STA66 dispatched to Incident ID 322306 (Diabetic) at 702 ADAMS AV S
(DA) 08-05-12 23:36: Station STA66 dispatched to Incident ID 322343 (Fall) at 2200 EAST BAY DR
(DA) 08-06-12 08:16: Station STA66 dispatched to Incident ID 322409 (Fire Alarm) at 6840 U S HWY 90
(DA) 08-06-12 11:54: Station STA66 dispatched to Incident ID 322474 (Fire Alarm) at 101 VILLA DR
(DA) 08-06-12 12:09: Station STA66 dispatched to Incident ID 322480 (Unknown Medical) at 27961 U S HWY 98
(DA) 08-06-12 12:19: Station STA66 dispatched to Incident ID 322485 (Fire Alarm) at 1506 MAIN ST
(DA) 08-06-12 15:20: Station STA66 dispatched to Incident ID 322538 (Auto Accident) at I-65 SB ON BRIDGE
(DA) 08-06-12 15:24: Station STA66 dispatched to Incident ID 322543 (General Illness) at 2505 POLLARD RD
(DA) 08-06-12 17:38: Station STA66 dispatched to Incident ID 322590 (Auto Accident) at 64 AND 181
(DA) 08-06-12 18:32: Station STA66 dispatched to Incident ID 322610 (Structure Fire) at 806 N GREENO RD
(DA) 08-06-12 18:37: Station STA66 dispatched to Incident ID 322615 (General Illness) at 2301 POLLARD RD (36526)
(DA) 08-07-12 09:34: Station STA66 dispatched to Incident ID 322791 (Back Pain) at 507 TRACE CROSSING
(DA) 08-07-12 16:40: Station STA66 dispatched to Incident ID 322947 (Fall) at 10291 FIONN LOOP
(DA) 08-08-12 09:16: Station STA66 dispatched to Incident ID 323184 (Fire Alarm) at 101 VILLA DR
(DA) 08-08-12 09:37: Station STA66 dispatched to Incident ID 323188 (Vehicle Fire) at US HWY 98 @ I 10
(DA) 08-08-12 12:06: Station STA66 dispatched to Incident ID 323215 (Difficulty Breathing) at 11626 U S HWY 90 (0)
(DA) 08-08-12 15:36: Station STA66 dispatched to Incident ID 323304 (Fire Alarm) at 27440 13
(DA) 08-08-12 15:41: Station STA66 dispatched to Incident ID 323308 (Unknown Medical) at 2200 EAST BAY DR
(DA) 08-08-12 15:44: Station STA66 dispatched to Incident ID 323313 (Fall) at DAPHNE JAIL

*/


public class ALBaldwinCountyParser extends MsgParser {
  
  private static final Pattern MASTER = Pattern.compile("(?:- E911 Notification - ([^-]+) - )?(\\d\\d-\\d\\d-\\d\\d) (\\d\\d:\\d\\d): Station ([A-Z0-9]+) dispatched to Incident ID (\\d+) \\(([^\\)]*?)\\) at (.*?)(?:\\(.*\\))?");
  private static final DateFormat DATE_FMT = new SimpleDateFormat("MM-dd-yy");
  private static final Pattern DOUBLE_NUMBER_PTN = Pattern.compile("(\\d+) +(\\d+)");

  public ALBaldwinCountyParser() {
    super("BALDWIN COUNTY", "AL");
  }
    
  @Override
  public String getFilter() {
    return "cad@baldwin911.org";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    data.strSource = getOptGroup(match.group(1));
    setDate(DATE_FMT, match.group(2), data);
    data.strTime = match.group(3);
    data.strUnit = match.group(4);
    data.strCallId = match.group(5);
    data.strCall = match.group(6).trim();
    
    String sAddr = match.group(7).trim().replace('@', '&');
    match = DOUBLE_NUMBER_PTN.matcher(sAddr);
    if (match.matches()) sAddr = match.replaceFirst("$1 RT $2");
    parseAddress(sAddr, data);
    
    return true;
  }
}
