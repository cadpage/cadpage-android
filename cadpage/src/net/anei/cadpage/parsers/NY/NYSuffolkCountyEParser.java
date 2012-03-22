package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/*
Suffolk County, NY (alternate)
Contact: Brandon Tishim <tishimb@gmail.com>
Sender: Bob@relaycom.com
(FROM RELAY) 33 BAY RUN OFF OF HERRICKS LN JAMESPORT\nELDERLY MALE SICK
(FROM RELAY) 415 OSTRANDER AVE, INJURY FROM A FALL
(FROM RELAY) 95 OSTRANDER AVE, DIFFICULTY BREATHING

Contact: Bill Wilkinson <billthemedic@gmail.com>
Sender: Bob@relaycom.com
(FROM RELAY) 236 MAIN RD AQUEBOGUE; DIRECTLY ACROSS FROM FEDUN REALITY 92 Y/O FEMALE \nCHEST PAINS
(FROM RELAY) 2185 SPLISH SPLASH DRIVE FEMALE POSSIBLE STROKE
(FROM RELAY) 178  PECONIC BAY BLVD IN AQUEBOGUE   AT THE  REEVE RESIDENCE SUBJECT \nSEIZURES
(FROM RELAY) 1053 OLD COUNTRY RD PEARLE VISION CENTER  FEMALE HEAD INJURY FROM A FALL
(FROM RELAY) 70 SCHULTZ RD MALE HEAD INJURY FROM A FALL ,, ACROSS FROM THE SPORTSMAN \nKENNEL IN MANORVILLE
(FROM RELAY) 1272 EAST MAIN ST  DR. BROOK'S OFC  MALE  FAINTING EPISODES
(MSG FROM RELAY) MICHAEL'S 1440 OLD COUNTRY RD. FEMALE. GENERAL WEAKNESS.

 */

public class NYSuffolkCountyEParser extends SmartAddressParser {
  
  public NYSuffolkCountyEParser() {
    super(CITY_LIST, "SUFFOLK COUNTY","NY");
  }

  @Override
  public String getFilter() {
    return "Bob@relaycom.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.contains("FROM RELAY")) return false;
    
    // Punctuation is too unreliable to count on
    body = body.replaceAll("[\n;,]", " ").replaceAll("  +", " ");
    body = body.replaceAll("\\bOFF OF\\b", "XS:");
    
    // Feed everything to smart parser
    parseAddress(StartType.START_PLACE, FLAG_IGNORE_AT, body, data);
    data.strSupp = getLeft();
    
    // Clean up loose ends
    String sAddr = data.strAddress;
    if (sAddr.endsWith(" IN")) data.strAddress = sAddr.substring(0, sAddr.length()-3).trim();
    
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{
      "AQUEBOGUE",
      "JAMESPORT"
  };
}
