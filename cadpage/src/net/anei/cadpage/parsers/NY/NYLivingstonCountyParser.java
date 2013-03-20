package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA5Parser;
import java.util.regex.*;

public class NYLivingstonCountyParser extends DispatchA5Parser {
  
  public NYLivingstonCountyParser() {
    super("LIVINGSTON COUNTY", "NY");
  }
  
  @Override
  public String getFilter() {
    return "@CO.LIVINGSTON.NY.US";
  }
  
  @Override 
  public boolean parseMsg(String subject, String body, Data data) {
    
    if(!super.parseMsg(subject, body, data))
      return false;
    else {
      int slash = data.strCity.indexOf("/");
      if(0 <= slash) {
        data.strCity = data.strCity.substring(slash+1);
      }
    }
    return true;
  }
  
  @Override
  public String adjustMapAddress(String sAddress) {
    
    sAddress = MA_PTN.matcher(sAddress).replaceAll("MANOR");
    sAddress = IFO_PTN.matcher(sAddress).replaceAll("");
    return sAddress;
  }
  private static final Pattern MA_PTN = Pattern.compile("\\bMA\\b", Pattern.CASE_INSENSITIVE);
  private static final Pattern IFO_PTN = Pattern.compile(" +IFO$", Pattern.CASE_INSENSITIVE);
  
} // NYLivingstonCountyParser
