package net.anei.cadpage.parsers.VA;


import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmsMsgParser;

/*Prince William County, VA (class I)
Contact: Rodney Fielding <rfielding@d-trs.com>
Sender: cc_message_notification@usamobility.net
29-Oct-2010/11:07:25/OUTF/15742 DUMFRIES RD / 15726 CARRS BROOKE WY ,PWC /17/E517 STA17 /ON NB  DUMFRIES RD  / BTW CARRS BROOK AND TODDBURY
29-Oct-2010/10:38:09/FALARM/15750 NORRIS POINT WY ,PWC /23/E510B STA23 TW512 /LANDING AT MARKHAM  /// 703-580-8121 /  GENERAL ALARM [72]
29-Oct-2010/09:41:32/INVEST/18911 FULLER HEIGHTS RD ,PWC /03F/E503B STA03F /CABLE LYING ON THE ROUND - BOTH ENDS ARE CONNECTED TO POLES - NO
29-Oct-2010/02:17:37/SICA/17428 KAGERA DR ,PWC /03R/E503B M503 STA03R /DAD HAVING POSS HEART ATTACK/ [60]
29-Oct-2010/09:21:10/UNC/18303 OLD TRIANGLE RD ,PWC /03R/E503B E523 M503 STA03R female screaming something is wrong w male in t he house .
28-Oct-2010/18:35:32/OUTF/CARBOROUGH ST / 19140 WINDSOR RD ,PWC /03R/E503B STA03R /BRUSH ON FIRE BESIDES THE HIGHWAY [53]
05-Nov-2010/10:08:33/FALARM/19043 FULLER HEIGHTS RD ,PWC (INSPIRATION > HOUSE DAY CARE)/03F/E503B STA03F TW512 /busn / 703 441 0997 / aud / ge
*/


public class VAPrinceWilliamCountyParser extends SmsMsgParser {
  
  public VAPrinceWilliamCountyParser() {
    super("PRINCE WILLIAM COUNTY", "VA");
  }


  private boolean isPageMsg(String body) {
    return body.length() > 20 && body.charAt(11) == '/' && body.charAt(20) == '/';
  } 


  @Override
  protected boolean parseMsg(String body, Data data) {
    
    if (!isPageMsg(body)) return false;
    
    String[] lines = body.split("/");
    int ndx = 0;
    for (String line : lines) {
      line = line.trim();
      switch (ndx++) {
      
      case 2:
        // Call description
        data.strCall = line;
        break;
        
      case 3:
        // Address line
        int pt = line.indexOf(',');
        if (pt >= 0) line = line.substring(0, pt).trim();
        parseAddress(line, data);
        break;
      
      case 4:
        // optional cross street or box number
        // if cross street, loop back looking for box number
        if (! isBox(line)){
          if (data.strCross.length() > 0) data.strCross += " & ";
          pt = line.indexOf(',');
          if (pt >= 0) line = line.substring(0, pt).trim();
          data.strCross += line;
          ndx--;
          break;
        }
        data.strBox = line;
        break;

      case 5:
        // Unit
        data.strUnit = line;
        break;
        
      case 6: 
        // supp info, repeats till end of msg
        if (line.length() > 0) {
          if (data.strSupp.length() > 0) data.strSupp += " / ";
          data.strSupp += line;
        }
        ndx--;
        break;
      }
    }
    return true;
  }
  
  // See if this is an address termination field
  // must be 2 or 3 characters long of which the first two
  // are digits
  private boolean isBox(String line) {
    if (line.length() != 2 && line.length() != 3) return false;
    return (Character.isDigit(line.charAt(0)) && Character.isDigit(line.charAt(1)));
  }
}