package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.StandardCodeTable;
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
  public String getProgram() {
    return super.getProgram().replace("CALL", "CODE CALL");
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
    
    // Extract Call information
    Matcher callExtra = CALL_PTN.matcher(data.strCall);
    if(callExtra.matches()) {
      data.strCode = callExtra.group(1);    // Group 1 is the code
      
      if(callExtra.group(2).equals("F")) {
        data.strCall = callExtra.group(3);
      }
      
      if(callExtra.group(2).equals("E")) {
        String desc = STANDARD_CODES.getCodeDescription(callExtra.group(3));
        if(desc != null) {
          data.strCall = desc;
        }
        else {
          data.strCall = callExtra.group(3);
        }
      }
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
  private static final Pattern CALL_PTN = Pattern.compile("([A-Z0-9]+) +([EF]) +(.*)");
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "GROVELAN",   "GROVELAND",
      "SPRINGWA",   "SPRINGWATER",
  });
  
  private static final StandardCodeTable STANDARD_CODES = new StandardCodeTable(); 
}
