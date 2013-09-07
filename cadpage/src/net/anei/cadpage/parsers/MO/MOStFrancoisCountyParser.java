package net.anei.cadpage.parsers.MO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchCiscoParser;



public class MOStFrancoisCountyParser extends DispatchCiscoParser {
  
  private static final Pattern SPECIAL_MSG_PTN = Pattern.compile("Unit: *([A-Z0-9]+) *(.*?) -> (.*)");
  
  public MOStFrancoisCountyParser() {
    super("ST FRANCOIS COUNTY", "MO");
  }
  
  @Override
  public String getFilter() {
    return "IPN.9999900138@ipnpaging.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    Matcher match = SPECIAL_MSG_PTN.matcher(body);
    if (match.matches()) {
      data.strUnit = match.group(1);
      String type = match.group(2).trim();
      String msg =  match.group(3).trim();
      if (type.equals("Is Clearing from")) {
        data.strCall = "RUN REPORT";
        data.strPlace = type + " -> " + msg;
        return true;
      }
      if (type.equals("Notification")) {
        data.strCall = "GENERAL ALERT";
        data.strPlace = msg;
        return true;
      }
      data.strCall = "GENERAL ALERT";
      data.strPlace = type + " -> " + msg;
      return true;
    }
    
    return super.parseMsg(subject, body.replace('\n', ' ').replace("!",""), data);
  }
}
