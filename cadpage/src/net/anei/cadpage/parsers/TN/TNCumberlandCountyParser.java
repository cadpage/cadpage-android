package net.anei.cadpage.parsers.TN;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/* 
Cumberland County, TN
Contact: Jeremy <fyrboy55@gmail.com>
Sender: 911-CENTER@cumberlandtn911.org

911-CENTER:1046 INJURY ACCIDENT LANTANA AT STORIE 7656250985 COUNTY
911-CENTER:1072A FIRE ALARM 912 GERONIMO LN 9317470058 COUNTY WIDE
911-CENTER:1072B FIRE, BRUSH/WOODS 18 JASPER DR 931 COUNTY WIDE
911-CENTER:1072S FIRE, STRUCTURE 171 RED FOX DR 931 COUNTY WIDE
911-CENTER:1046 INJURY ACCIDENT 3173 GENESIS RD 9312108439 COUNTY WIDE
911-CENTER:1072S FIRE, STRUCTURE 4503 CRESTON RD 9317071052 COUNTY WIDE
911-CENTER:1072 FIRE 110 NORTHRIDGE DR 931 COUNTY WIDE
911-CENTER:1072S FIRE, STRUCTURE 261 FLORIDA AVE 9317885007 COUNTY WIDE
911-CENTER:1046 INJURY ACCIDENT 217 SNEAD DR 9315290123 COUNTY WIDE

 */

public class TNCumberlandCountyParser extends SmartAddressParser {
  
  private static final Pattern MASTER = Pattern.compile("911-CENTER:([A-Z0-9]+) +(.+?) +(\\d{3}(?:\\d{7})?)([ A-Z]+)*");
  
  public TNCumberlandCountyParser() {
    super("CUMBERLAND COUNTY", "TN");
  }
  
  @Override
  public String getFilter() {
    return "911-CENTER@cumberlandtn911.org";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    
    data.strCode = match.group(1);
    String sAddr = match.group(2).trim();
    parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ | FLAG_ANCHOR_END, sAddr, data);
    data.strPhone = match.group(3);
    String city = match.group(4).trim();
    if (city.equals("COUNTY") || city.equals("COUNTY WIDE")) city = "";
    data.strCity = city;
    
    return true;
  }
}
