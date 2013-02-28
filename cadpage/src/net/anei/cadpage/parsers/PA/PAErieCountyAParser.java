package net.anei.cadpage.parsers.PA;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;



public class PAErieCountyAParser extends DispatchB2Parser {
  
  private static final Pattern MARKER2 = Pattern.compile("^[0-9A-Z]+ ?>");
  private static final Pattern CITY_SUFFIX = Pattern.compile("^(?:BORO|VILLAGE|TWP)\\b *");
 
  public PAErieCountyAParser() {
    super(PAErieCountyParser.CITY_LIST, "ERIE COUNTY", "PA");
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return true;
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // Dummy do loop
    do {
      if (body.startsWith("ERIE911:")) {
        data.strSource = "ERIE911";
        body = body.substring(8).trim();
        break;
      }
      
      if (subject.length() > 0) {
        if (MARKER2.matcher(body).find()) {
          data.strSource = subject;
          break;
        }
      }
      
      return false;
    } while (false);
    
    boolean result = super.parseMsg(body, data);
    if (result) {
      Matcher match = CITY_SUFFIX.matcher(data.strName);
      if (match.find()) data.strName = data.strName.substring(match.end());
      result =  
          (data.strCross.length() > 0 || 
           data.strCallId.length() > 0);
      if (!result) {
        int pt = body.indexOf('>');
        result = (pt >= 0 && pt <= 20);
      }
    }
    if (!result && data.strSource.equals("ERIE911")) {
      data.parseGeneralAlert(body.trim());
      data.strSource = "ERIE911";
      result = true;
    }
    return result;
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
}