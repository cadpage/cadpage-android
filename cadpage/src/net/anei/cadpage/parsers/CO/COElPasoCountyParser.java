package net.anei.cadpage.parsers.CO;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgParser;



public class COElPasoCountyParser extends MsgParser {
  
  public COElPasoCountyParser() {
    super("EL PASO COUNTY", "CO");
  }
  
  @Override
  public String getFilter() {
    return "ept@ept911.info";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // There are (at least) three different fixed length formats used by 
    // three different agencies.  So I guess we just have to figure out
    // which one to use
    
    if (body.length() >= 69 &&
        body.charAt(4) == '-' &&
        body.substring(30,34).equals("APT-") &&
        body.substring(65,69).equals("DET-")) {
      
      data.strSource = body.substring(0,4).trim();
      parseAddress(body.substring(5,30).trim(), data);
      data.strApt = body.substring(34,40).trim();
      data.strCall = body.substring(40,65).trim();
      data.strSupp = body.substring(69);
      return true;
    }
    
    
    if (body.length() >= 30 &&
        body.substring(6,9).equals(" - ")) {
      
      data.strSource = body.substring(0,6).trim();
      data.strCall = substring(body, 9, 29);
      parseAddress(substring(body, 29, 59), data);
      data.strPlace = substring(body, 59, 74);
      data.strSupp = substring(body, 74);
      return true;
    }
    
    if (body.length() >= 80 &&
        body.charAt(4) == ' ' && 
        body.charAt(5) == 'D' &&
        Character.isDigit(body.charAt(6)) &&
        body.substring(7,13).trim().length() == 0) {
      
      data.strSource = body.substring(0,4).trim();
      data.strPriority = body.substring(5,7); 
      data.strCall = body.substring(13,43).trim();
      parseAddress(body.substring(43,78).trim(), data);
      data.strSupp = substring(body, 78);
      return true;
    }
    
    return false;
  }
}
