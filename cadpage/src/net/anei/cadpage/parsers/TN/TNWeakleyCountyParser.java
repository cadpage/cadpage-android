package net.anei.cadpage.parsers.TN;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchEmergitechParser;

public class TNWeakleyCountyParser extends DispatchEmergitechParser {
  
  public TNWeakleyCountyParser() {
    super((String)null, 0, CITY_LIST, "WEAKLEY COUNTY", "TN");
    setupProtectedNames("D AND C SUBDIVISION");
  }
  
  private static final Pattern[] RUN_NUMBER_PTNS = new Pattern[]{
    Pattern.compile("^RUN ?# +(\\d+)\\s+"),
    Pattern.compile("^(?:\\d{2}(?: +|\\.))?(\\d+)\\s+"),
    Pattern.compile(" LOCATION:\\d{2}\\.(\\d+) +"),
    Pattern.compile(" +(?:\\d{2}\\.)?(\\d+)\\s+LOCATION:"),
    Pattern.compile(" LOCATION *(?:\\d{2}\\.)?(\\d+) : ")
  };
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    data.strSource = subject;
    
    // There are several ways they slip an call ID into the alert message that 
    // need to be removed
    body = stripFieldStart(body, ":");
    for (Pattern ptn : RUN_NUMBER_PTNS) {
      Matcher match = ptn.matcher(body);
      if (match.find()) {
        data.strCallId = match.group(1);
        if (match.start() == 0) {
          body = body.substring(match.end()).trim();
        } else {
          body = body.substring(0,match.start()) + " LOCATION: " + body.substring(match.end()).trim();
        }
        break;
      }
    }
    
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return "SRC ID " + super.getProgram();
  }

  private static String[] CITY_LIST = new String[]{
    "DRESDEN",
    "DUKEDOM",
    "GARDNER",
    "GLEASON",
    "GREENFIELD",
    "LATHAM",
    "MARTIN",
    "MCKENZIE",
    "PALMERSVILLE",
    "SHARON"
  };

}
