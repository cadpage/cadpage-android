package net.anei.cadpage.parsers;

import net.anei.cadpage.Log;
import net.anei.cadpage.SmsMsgInfo.Data;

/* Sample Oconee Page
 * 
 * OCSO E911:Return Phone: 7060000000 S28 SICK PERSON 4047 COLHAM FERRY RD 8583046 
 * OCSO E911:Return Phone: 7060000000 S28 SICK PERSON 385 JEFFERSON AVE 2029728 
 * OCSO E911:1090F FIRE ALARM 1021 WOOD HOLLOW LN 5482767 CRYSTAL HILLS DR
 * OCSO E911:1073 SMOKE 1421 BEVERLY DR 5495253 NONA DRIVE
 * OCSO E911:1070 FIRE 1280 ASHLAND DR 7250300 HWY 53
 */

public class GAOconeeCountyParser extends SmsMsgParser {

  @Override
  public boolean isPageMsg(String body) {
    return body.startsWith("OCSO E911:");
  }

  @Override
  protected void parse(String body, Data data) {

    Log.v("DecodeOconeePage: Message Body of:" + body);
    data.defState="GA";
    data.defCity="Oconee";

    // Skip everything up to first colon
    int ipt = body.indexOf(':');
    if (ipt >= 0) body = body.substring(ipt+1).trim();

    // Skip phone number
    boolean phoneFlg = false;
    int mode = 0;
    int callCnt = 0;
    for (String token : body.split("\\s+")) {
      switch (mode) {
      
      // Processing call
      // Ignore phone number, terminated by numeric token which is assumed to
      // be start of address
      case 0:
        if (phoneFlg) {
          phoneFlg = false;
          data.strPhone = token;
          continue;
        }
        if (token.equalsIgnoreCase("Phone:")) {
          data.strCall = "";
          callCnt = 0;
          phoneFlg = true;
          continue;
        }
        
        if (callCnt >= 3 || callCnt > 0 && token.matches("\\d{2,}")) {
          mode++;
          // no break, fall through to address processing
        } else {
          callCnt++;
          if (data.strCall.length() > 0) data.strCall += " ";
          data.strCall += token;
          break;
        }
        
      // Processing address
      // terminated by 7 digit call ID (We think)
      case 1:
        if (token.matches("\\d{7}")) {
          data.strCallId = token;
          mode++;
          break;
        }
        if (data.strAddress.length() > 0) data.strAddress += " ";
        data.strAddress += token;
        break;
        
      // Cross street processing
      // This actually looks more like an approach street, but assigning it
      // to cross will at least get it to display
      case 2:
        if (data.strCross.length() > 0) data.strCross += " ";
        data.strCross += token;
        break;
      }
    }
  }
}
