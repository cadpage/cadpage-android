package net.anei.cadpage.parsers;

import net.anei.cadpage.Log;
import net.anei.cadpage.SmsMsgInfo.Data;

/* 
Sample Herkimer Pages
Contact: Robert Tucker <mobilewlightn@gmail.com>
Sender: HC911@herkimercounty.org <From%3AHC911@herkimercounty.org>
(EMS   >EMS CALL) 185 GUIDEBOARD RD XS: DAIRY HILL RD NORWAY AAAAAAA AAAAAAA 3150000000 Map: Grids:, Cad: 2010-0000049305
(MVA   >MOTOR VEHICLE ACCIDENT) 5781 STHY 28 XS: TOWN LINE NEWPORT AAAAAA AAAAA 3150000000 Map: Grids:, Cad: 2010-0000049651
(EMS   >EMS CALL) 808 OLD STATE RD NEWPORT AAAAAAAA 8880000000 Map: Grids:, Cad: 2010-0000049432
(EMS   >EMS CALL) 3141 MECHANIC ST XS: MAIN ST NEWPORT VILLAGE JOHN 3157179999 Map: Grids:, Cad: 2010-0000058093
These may be new herkimer county pages that are not compatible with the previous ones.  Further information
has been requested.
Reporting email: Chris Conover <conovercj@ntcnet.com>
Sender: HC911@herkimercounty.org
(EMS>EMS CALL) 112 N Main St\nGrids:,, NY X:Fairfield St\nMiddleville Village Paula, Wayne\n5419991234 MAP:
(EMS>EMS CALL) 54 Fairfield St\nGrids:,, NY X:Fairfield St\nMiddleville Village Willoughby, Ruby\n5419991234 MAP:
(LIFT>LIFT ASSIST/NON EMER EMS)\n112 N Main St Grids:,, NY\nX:Fairfield St Jones, Ronald\n5419991234 MAP:
*/

public class NYHerkimerCountyParser extends SmsMsgParser {

  @Override
  public boolean isPageMsg(String body) {
    return body.contains("Cad:");
  }

  @Override
  protected void parse(String body, Data data) {
    
    Log.v("DecodeHerkimerPage: Message Body of:" + body);
    data.defState="NY";
    
    body = body.trim();
    if (body.charAt(0) == '(') {
      int pt = body.indexOf(')');
      if (pt >= 1) {
        data.strCall = body.substring(1, pt);
        data.strCall = data.strCall.replaceAll("\\s*>", ">");
        body = body.substring(pt+1).trim();
      }
    }
    
    // Strip CAD number off end of message
    int pt = body.indexOf(" Cad:");
    if (pt >= 0) {
      data.strCallId = body.substring(pt+5).trim();
      body = body.substring(0, pt).trim();
    }
    
    // Address formatting is very strange.
    // There isn't a clear end of address delimiter.  Best we can do is
    // terminate when we recognize an known city.
    // And any tokens after an "XS:" token are added to the cross rather
    // than the address
    boolean cross = false;
    for (String token : body.split("\\s+")) {
      if (token.equals("NORWAY") || token.equals("NEWPORT")) {
        data.strCity = token;
        break;
      }
      if (token.equals("XS:")) {
        cross = true;
      } else {
        if (!cross) {
          if (data.strAddress.length() > 0) data.strAddress += " ";
          data.strAddress += token;
        } else {
          if (data.strCross.length() > 0) data.strCross += " ";
          data.strCross += token;
        }
      }
    }
  }
}
