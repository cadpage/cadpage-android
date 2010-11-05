package net.anei.cadpage.parsers;


import net.anei.cadpage.Log;
import net.anei.cadpage.SmsMsgInfo.Data;

/*Prince William County, VA (class I)
Contact: Rodney Fielding <rfielding@d-trs.com>
Sender: cc_message_notification@usamobility.net
29-Oct-2010/11:07:25/OUTF/15742 DUMFRIES RD / 15726 CARRS BROOKE WY ,PWC /17/E517 STA17 /ON NB  DUMFRIES RD  / BTW CARRS BROOK AND TODDBURY
29-Oct-2010/10:38:09/FALARM/15750 NORRIS POINT WY ,PWC /23/E510B STA23 TW512 /LANDING AT MARKHAM  /// 703-580-8121 /  GENERAL ALARM [72]
29-Oct-2010/09:41:32/INVEST/18911 FULLER HEIGHTS RD ,PWC /03F/E503B STA03F /CABLE LYING ON THE ROUND - BOTH ENDS ARE CONNECTED TO POLES - NO
29-Oct-2010/02:17:37/SICA/17428 KAGERA DR ,PWC /03R/E503B M503 STA03R /DAD HAVING POSS HEART ATTACK/ [60]
29-Oct-2010/09:21:10/UNC/18303 OLD TRIANGLE RD ,PWC /03R/E503B E523 M503 STA03R female screaming something is wrong w male in t he house .
28-Oct-2010/18:35:32/OUTF/CARBOROUGH ST / 19140 WINDSOR RD ,PWC /03R/E503B STA03R /BRUSH ON FIRE BESIDES THE HIGHWAY [53]*/


public class VAPrinceWilliamCountyParser extends SmsMsgParser {

  @Override
  public boolean isPageMsg(String body) {
    return body.contains(",PWC");
  } 


  @Override
  protected void parse(String body, Data data) {
    Log.v("DecodePrinceWilliamCountyPage: Message Body of:" + body);
    data.defState="VA";
    data.defCity = "Prince William COUNTY";

    String[] lines = body.split("/");  
    data.strCall = lines[2];  
    if (lines.length <= 1) return;  
    parseAddress(lines[3], data);  
    if (lines.length <= 3) return;  

    //Determine if there is a XS present
    if (lines[3].contains("PWC"))//No cross street included
    {
      int ptc = data.strAddress.indexOf(",");
      if (ptc >= 0) data.strAddress = data.strAddress.substring(0,ptc).trim();
      if (lines.length <= 4) return;
      data.strBox = lines[4];
      if (lines.length <= 5) return;
      data.strUnit = lines[5];
      if (lines.length <= 6) return;
      data.strSupp = lines[6];
    }
    else// Cross street present
    {
      if (lines.length <= 4) return;
      data.strCross = lines[4];
      int ptc = data.strCross.indexOf(",");
      if (ptc >= 0) data.strCross = data.strCross.substring(0,ptc).trim();
      if (lines.length <= 5) return;
      data.strBox = lines[5];
      if (lines.length <= 6) return;
      data.strUnit = lines[6];
      if (lines.length <= 7) return;
      data.strSupp = lines[7];
      if (lines.length <= 8) return;
      data.strSupp = lines[7] + lines[8];
      if (lines.length <= 9) return;
      data.strSupp = lines[7] + lines[8] + lines[9];
    }


  }

}