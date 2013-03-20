package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA5Parser;

import java.util.Properties;
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
    
    if(!super.parseMsg(subject, body, data)) return false;
    int slash = data.strCity.indexOf("/");
    if(0 <= slash) {
      data.strCity = data.strCity.substring(slash+1);
    }
    data.strCity = convertCodes(data.strCity, CITY_CODES);
    if (data.strCity.equals("COUNTY OUT")) {
      data.strCity = "";
      data.defCity = "";
    }
    return true;
  }
  
  @Override
  public String adjustMapAddress(String sAddress) {
    
    sAddress = MA_PTN.matcher(sAddress).replaceAll("MANOR");
    sAddress = EX_PTN.matcher(sAddress).replaceAll("EXPY");
    sAddress = IFO_PTN.matcher(sAddress).replaceAll("");
    return sAddress;
  }
  private static final Pattern MA_PTN = Pattern.compile("\\bMA\\b", Pattern.CASE_INSENSITIVE);
  private static final Pattern EX_PTN = Pattern.compile("\\bEX\\b", Pattern.CASE_INSENSITIVE);
  private static final Pattern IFO_PTN = Pattern.compile(" +IFO$", Pattern.CASE_INSENSITIVE);
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "GROVELAN",   "GROVELAND",
      "SPRINGWA",   "SPRINGWATER",
  });
  
}
