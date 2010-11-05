package net.anei.cadpage.parsers;

import java.util.Properties;

import net.anei.cadpage.Log;
import net.anei.cadpage.SmsMsgInfo.Data;

/* Sample Suffolk Page
Contact: Jason Pedota <jpedota805@gmail.com>
Sender: 6317967579
TYPE: GAS LEAKS / GAS ODOR (NATURAL / L.P.G.) LOC: 11 BRENTWOOD PKWY BRENTW HOMELESS SHELTER CROSS: PENNSYLVANIA AV / SUFFOLK AV CODE: 60-B-2 TIME: 12:54:16
TYPE: STRUCTURE FIRE LOC: 81 NEW HAMPSHIRE AV NBAYSH  CROSS: E FORKS RD / E 3 AV CODE: 69-D-10 TIME: 16:36:48
TYPE: OPEN BURNING LOC: 65 GRANT AVE BRENTW CROSS: SUFFOLK AVE 18:39:20 CODE: 54-C-6
*/

public class NYSuffolkCountyParser extends SmsMsgParser {

  private static String[] SuffolkCityCodes = new String[]{
    "BRENTW", "Brentwood",
    "NBAYSH", "Bay Shore",
    "BAYSHO", "Bay Shore"
  };

  @Override
  public boolean isPageMsg(String body) {
    return body.startsWith("TYPE:");
  }

  @Override
  protected void parse(String body, Data data) {
  
    Log.v("DecodeSuffolkPage: Message Body of:" + body);
    data.defState="NY";
    data.defCity="SUFFOLK COUNTY";

    Properties props = parseMessage(body, new String[]{"LOC", "CROSS", "CODE", "TIME"});
    data.strCall = props.getProperty("TYPE", "");
    parseAddress(props.getProperty("LOC", ""), data);
    data.strCross = props.getProperty("CROSS", "");
    
    for (int ndx = 0; ndx<SuffolkCityCodes.length-1; ndx+= 2) {
      int ipt = data.strAddress.lastIndexOf(" " + SuffolkCityCodes[ndx]);
      if (ipt >= 0) {
        data.strAddress = data.strAddress.substring(0, ipt);
        data.strCity = SuffolkCityCodes[ndx+1];
        break;
      }
    }
  }
}
