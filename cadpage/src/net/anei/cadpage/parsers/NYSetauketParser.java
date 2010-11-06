package net.anei.cadpage.parsers;

import java.util.Properties;
import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser.StartType;

/* Sample Pages.
AMBULANCE, CONVULSIONS / SEIZURES: 12-D-2 44 YOF SEIZURES at 43 NEAL PATH, SETAUKET   O: FAIRFIELD GABLES            TRUSS . . 19:39:51
AMBULANCE, SICK PERSON (SPECIFIC DIAGNOSIS): 56 YOF SICK 26-A-5 IFO BUILDING at 5000 ROUTE 347, East Setauket  c/s: ARROWHEAD LN SOUTH   O: KOHLS . . 14:54:20
MISC CALL, CHIEFS INVESTIGATION: GENERAL FIRE ALARM 52C04 Residential (multiple) at 700H HEALTH SCIENCES DR, STONY BROOK  c/s: NICOLLS RD   O: CHAPIN APTS - S: 26-A-16 at 20 FAWN LN W, SOUTH SETAUKET  c/s: LONGBOW LN . . 00:20:06
AMBULANCE, HEMORRHAGE / LACERATIONS: 21-A-1 - 61 YOM - CUT TO HAND at 8 HOLLY LN, EAST SETAUKET  c/s: CRANE NECK RD . . 16:57:21
MISC CALL WITH RESCUE, MVA: 29-B-1U - INJURIES at C/O, Setauket  c/s: WIRELESS RD . . 16:08:02
 */

public class NYSetauketParser extends SmartAddressParser {

  private static String[] citiesCodes = new String[]{"SETAUKET", "SOUTH SETAUKET", "EAST SETAUKET", "WEST SETAUKET", "NORTH SETAUKET"};
  

  
  public NYSetauketParser() {
    super(citiesCodes);
  }

  @Override
  public boolean isPageMsg(String body) {
    body = body.toUpperCase();
    return body.contains("SETAUKET") ;
  }

  @Override
  protected void parse(String body, Data data) {
  
    data.defState="NY";
    data.defCity="Setauket";

    body = body.replace(" at ", " LOC: ");
    body = "CALL: " + body;
    body = body.replace("c/s", "CROSS");
    Properties props = parseMessage(body, new String[]{"CALL","LOC","CROSS","O",});
    //data.strCall = body.substring(0,body.indexOf(":"));
    // Call Info is two parts all before the word at which we made into LOC
    
    String sAddress = props.getProperty("LOC");
    if (sAddress.contains(",")){
      int indx = sAddress.indexOf(",");
      data.strAddress = sAddress.substring(0,indx);
      data.strCity = sAddress.substring(indx + 1);
    } else {
      data.strAddress = sAddress;
    }
    String sCall = props.getProperty("CALL");
    if ( sCall.contains(":")){ 
      data.strCall= sCall.substring(0,sCall.indexOf(":"));
      data.strSupp= sCall.substring(sCall.indexOf(":")+1);
    } else {
      data.strCall = sCall;
    }
    data.strCross = props.getProperty("CROSS", "");

  }
}
