package net.anei.cadpage.parsers.NY;


import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchRedAlertParser;


public class NYSuffolkCountyCParser extends DispatchRedAlertParser {
  
  private static final Pattern DIR_SLASH_BOUND = Pattern.compile("\\b([NSEW])/B\\b");
  
  public NYSuffolkCountyCParser() {
    super("SUFFOLK COUNTY","NY");
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // Anything starting with TYPE: belongs to variant A
    if (body.startsWith("TYPE:")) return false;
    
    // Anything starting with three asterisks belongs to variant B
    if (body.startsWith("***")) return false;
    
    // They use a strange E/B convention
    return super.parseMsg(subject, DIR_SLASH_BOUND.matcher(body).replaceAll("$1B"), data);
  }
}
