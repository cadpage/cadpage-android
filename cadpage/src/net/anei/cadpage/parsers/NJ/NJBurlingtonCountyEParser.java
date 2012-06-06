package net.anei.cadpage.parsers.NJ;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/*
Burlington County, Evesham, NJ 
Contact: 
Sender: 

EMS E EMS Call 3690 NJTP VENUE : NJTP MALE INTOXICATED 16:01:53 05/12/2012
FIRE F Fire Call N CROPWELL  RD  VENUE : WASH DOWN/MVA 08:06:57 05/07/2012
EMS E EMS Call 422 SEDGEWICK LA VENUE : Evesham MALE SWEATY SLURRED SPEECH POSS STROKE CARDIA 08:16:51 05/23/2012
EMS E EMS Call 360 s RT73 VENUE : Evesham MALE?ALLEGRIC REACTION 12:22:28 06/04/2012
117 E Falls 803 JONATHAN LA VENUE : Evesham SUBJECT FELL 00:34:25 05/16/2012

*/

public class NJBurlingtonCountyEParser extends SmartAddressParser {
  
  private static final Pattern MASTER = Pattern.compile("(.*) VENUE : (.*) (\\d\\d:\\d\\d:\\d\\d) (\\d\\d/\\d\\d/\\d{4})");
  
  public NJBurlingtonCountyEParser() {
    super("BURLINGTON COUNTY", "NJ");
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    
    String sAddr = match.group(1).trim();
    String sExtra  = match.group(2).trim();
    data.strTime = match.group(3);
    data.strDate = match.group(4);
    
    // Address contains call and address
    parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ | FLAG_ANCHOR_END, sAddr, data);
    
    // Info portion may start with a city
    Parser p = new Parser(sExtra);
    String sCity = p.get(' ');
    if (CITY_SET.contains(sCity.toUpperCase())) {
      data.strCity = sCity;
      sExtra = p.get();
    }
    data.strSupp = sExtra;
    
    return true;
  }
  
  
  private static final Set<String> CITY_SET = new HashSet<String>(Arrays.asList(new String[]{
      "EVESHAM"
  }));
  
}
