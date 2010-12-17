package net.anei.cadpage.parsers;

import net.anei.cadpage.SmsMsgInfo.Data;

/*
Livingston County, MI
CAD:FYI: ;ALARMF;11555 PLEASANT VIEW DR;INDIAN TRL;SMOKE ALARMS GOING OFF IN THE HOUSE FOR THE LAST 30 MIN ON AND OFF/ NO SMOKE OR SMOKE SHOWING [09/24/10 04:17:07 ECOOK]
CAD:FYI: ;UNKACC;E M36/PETTYS RD;VEHICLE HIT A POLE/ MALE RUNNING E/B FROM SCENE [09/23/10 21:45:06 ECOOK]
CAD:FYI: ;CHSTPN;8422 PAWNEE TRL;SHOSHONI PASS;[Medical Priority Info] RESPONSE: P1 STA 1 4 5 6 7 8 FC FT RESPONDER SCRIPT: 72 year old, Female, Conscious, Breathing. Chest Pain (Non-Traumatic). Abnormal breathing. Cal
CAD:FYI: ;UNCON;8732 RIVER VALLEY RD;[Medical Priority Info] RESPONSE: P1 STA 1 2 3 4 5 6 7 8 FC FT RESPONDER SCRIPT: 63 year old, Female, Conscious, Breathing. Unconscious / Fainting (Near). Not alert. Caller Statement: UNCON.
CAD:FYI: ;HEMLAC;SHEHAN RD/WHITEWOOD RD;[Medical Priority Info]RESPONSE: P1 STA 1 4 5 6 7 8 FC FT RESPONDER SCRIPT: 35 year old, Female, Conscious, Brea

Pagecopy-Fr:CAD@lc911\nCAD:FYI: ;CHSTPN;7251 HAMBURG RD;WELLE RD;[Medical Priority Info] RESPONSE: P1 STA 1 3 4 5 6 7 8 FC FT RESPONDER S

Contact: John Masek <john.sta33@gmail.com>
1 of 3\nFRM:CAD@livingstoncounty.livco\nMSG:CAD:FYI: ;CITAF;5579 E GRAND RIVER;WILDWOOD DR;Event spawned from CITIZEN ASSIST LAW. [12/10/10\n(Con't) 2 of 3\n20:08:59 SPHILLIPS] CALLER LIVES NEXT DOOR TO THE ADDRESS OF THE WATER MAINBREAK [12/10/10 20:04:40 HROSSNER] CALLER ADV OF A WATER MAIN\n(Con 3 of 3\nBREAK(End)
1 of 3\nFRM:CAD@livingstoncounty.livco\nMSG:CAD:FYI: ;UNCON;SANCTURY OF WOODLAND;7533 W GRAND RIVER;COURT\nST;[Medical Priority Info] RESPONSE: P1\n(Con't 2 of 3\nSTA 1 2 3 4 5 6 7 8 FC FT RESPONDER SCRIPT: 80 year old, Female,\nUnconscious, Breathing. Unconscious / Fainting (Near). Unconscious --\n(Con't) 3 of 3\nEff(End)
*/

public class MILivingstonCountyParser extends DispatchAParser {
  
  public MILivingstonCountyParser() {
    super("LIVINGSTON COUNTY", "MI");
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // There is some kind of front end that is really mangling messages
    // That we will try to recover from
    String[] lines = body.split("\n");
    if (lines.length > 1) {
      StringBuilder sb = new StringBuilder();
      boolean start = false;
      for (String line : lines) {
        if (! start) {
          if (line.contains("CAD:")) {
            start = true;
            sb.append(line);
          }
        } else {
          if (!line.startsWith("(Con") && !line.contains("(End)")) {
            sb.append(line);
          }
        }
      }
      if (!start) return false;
      body = sb.toString();
    }
    
    return super.parseMsg(body, data);
  }
}
