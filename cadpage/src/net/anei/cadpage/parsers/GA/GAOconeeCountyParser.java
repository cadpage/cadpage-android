package net.anei.cadpage.parsers.GA;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/* Sample Oconee Page
 * 
 * OCSO E911:Return Phone: 7060000000 S28 SICK PERSON 4047 COLHAM FERRY RD 8583046 
 * OCSO E911:Return Phone: 7060000000 S28 SICK PERSON 385 JEFFERSON AVE 2029728 
 * OCSO E911:1090F FIRE ALARM 1021 WOOD HOLLOW LN 5482767 CRYSTAL HILLS DR
 * OCSO E911:1073 SMOKE 1421 BEVERLY DR 5495253 NONA DRIVE
 * OCSO E911:1070 FIRE 1280 ASHLAND DR 7250300 HWY 53
 
Contact: Jeffrey Jones <jljones87@gmail.com>
Sender: 93001033
JACKSONE911:SIG16 >STROKE/CVA PATIENT 87 BEND DR XS: COMMERCE RD JEFFERSON FLOYD PAULSON 7066148432 Map:H6 Grids:0,0 Cad: 2012-0000053376
 
 */

public class GAOconeeCountyParser extends SmartAddressParser {
  
  public GAOconeeCountyParser() {
    super("OCONEE COUNTY", "GA");
  }

  @Override
  protected boolean parseMsg(String body, Data data) {

    if (!body.startsWith("OCSO E911:")) return false;

    // Skip everything up to first colon
    int ipt = body.indexOf(':');
    if (ipt >= 0) body = body.substring(ipt+1).trim();

    // Skip return phone number if there is one
    if (body.toUpperCase().startsWith("RETURN PHONE:")) {
      body = body.substring(13).trim();
      ipt = body.indexOf(' ');
      if (ipt <= 0) return false;
      data.strPhone = body.substring(0, ipt);
      body = body.substring(ipt+1).trim();
    }
    
    // Now try to find call description and address
    parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ, body, data);
    body = getLeft();
    
    // Next should be a 7 digit numeric value that we want to skip
    ipt = body.indexOf(' ');
    if (ipt < 0) return true;
    if (NUMERIC.matcher(body.substring(0,ipt)).matches()) {
      body = body.substring(ipt+1).trim();
    }
    
    // Everything else is a cross street
    data.strCross = body;
    
    return true;
  }
}
