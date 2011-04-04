package net.anei.cadpage.parsers.TX;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/* 
Nassau Bay (Harris County, TX?)
Contact: "Robert Hebert /City of Nassau Bay" <robert.hebert@nassaubay.com>
Sender: cad@ossicadpaging

39:CAD:FYI: ;NBFD;FIRE ALARM;18101 POINT LOOKOUT DR;NB;NB;01/12/2011  22:10:16;TRASHROOM 1 SMOKE DETECTOR [01/12/11 22:11:43 NHUGHES] fire alarms going
40:CAD:FYI: ;NBFD;STRUCTURE FIRE;1020-264 W NASA PKWY;WB;WBW;01/13/2011 11:46:25;smoke inside [01/13/11 11:45:40 TSWANSON]
41:CAD:FYI: ;NBFD;ACCIDENT MAJOR;NASA PKWY/ST JOHN BLVD;HO;NB;01/18/2011 12:53:59
CAD:FYI: ;NBFD;UNCONSCIOUS;1427 SAXONY LN;NB;NB;03/06/2011 14:30:40;female down in bathroom [03/06/11 14:30:28 DCOOLEY]
CAD:FYI: ;NBFD;ASSIST BY FIRE;3000 E NASA PKWY;SB;03/06/2011 15:38:43;boat [03/06/11 15:35:58 DCOOLEY]
:CAD:FYI: ;NBFD;VEHICLE FIRE;18100 UPPER BAY RD;NB;NB;03/26/2011 13:36:15

Contact: robert hunter <r.hunter20@gmail.com>
CAD:Update: ;WBFD;FIRE ALARM;450 W MEDICAL CENTER BLVD;WB;WBW;04/02/2011 07:22:55;CALLED THE NUMBER BELOW AND REC ANSWERING SERVICE THEY COULD PROVIDE MORE I
CAD:FYI: ;WBFD;ACCIDENT MAJOR;MAGNOLIA/ S KOBAYSHI;04/03/2011 18:01:07;gry mits eclipse/////18 wheeler [04/03/11 18:00:35 DJOHNSON]
:CAD:FYI: ;WBFD;SMELL OF SMOKE GAS OUTSIDE;18206 EGRET BAY BLVD;WB;WBE;04/04/2011 17:01:45;SMELL OF NATURAL GAS IN AREA - FENCED AREA NEXT TO ICHIBON [04/04/1

 */

public class TXNassauBayParser extends DispatchOSSIParser {
  
  private static final Pattern PREFIX = Pattern.compile("^\\d*:");
  
  public TXNassauBayParser() {
    super("NASSAU BAY", "TX",
          "SKIP SRC CALL! ADDR! INTLS INTLS? SKIP INFO+");
  }
  
  @Override
  public String getFilter() {
    return "cad@ossicadpaging";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    // Strip off option number prefix
    Matcher match = PREFIX.matcher(body);
    if (match.find()) {
      body = body.substring(match.end()).trim();
    }
    return super.parseMsg(body, data);
  }
}
