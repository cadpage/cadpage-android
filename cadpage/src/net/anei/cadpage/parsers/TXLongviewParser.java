package net.anei.cadpage.parsers;

import java.util.Properties;

import net.anei.cadpage.SmsMsgInfo.Data;

/* Sample Longview Page
 * 
RC:Run# 30209/ *Non Life Emergency P/2/ Sick Person (Specific Diagnosis)/ 1102 FRANCIS/ EASTON/ 18:21/ <Unknown>/ bp issues-- dizzy spells-- P
RC:Run# 30209/*Non Life Emergency P/1/Sick Person (Specific Diagnosis)/1102 FRANCIS///EASTON/18:21/////<Unknown>/bp issues-- dizzy spells--
RC:Run# 29907/PR Event/Public Service/CRYSTAL FARMS RD///TATUM/19:15/////PR EVENT/ TATUM/Tatum vs Harmony////
RC:Run# 29793/*Non Life Emergency P/1/Falls/301 B FORREST ACRES///TATUM/22:18/////<Unknown>/////
RC:Run# 29764/*Non Life Emergency P/1/Overdose / Poisoning (Ingestion)/1100 S ADAMS ST//Panola Apts: 32/CARTHAGE/17:23/////<Unknown>/////

 */

public class TXLongviewParser extends SmartAddressParser {

  @Override
  public boolean isPageMsg(String body) {
    return body.startsWith("RC:Run# ");
  }

  @Override
  protected void parse(String body, Data data) {

    data.defState="TX";
    data.defCity="Longview";
    // Skip everything up to first colon
    int ipt = body.indexOf(':');
    if (ipt >= 0) body = body.substring(ipt+1).trim();

    // Replace # with :
    body = body.replace("Run#", "Call:");

    Properties props = parseMessage(body, new String[]{"CALL","CITY"});
    // Now try to find call description and address
    parseAddress(StartType.START_CALL,  body, data);
    body = getLeft();
    
  }
}
