package net.anei.cadpage.parsers.KY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;

public class KYLaRueCountyParser extends DispatchB2Parser {
  
  private static final Pattern CALL_ID_PTN = Pattern.compile("(\\d{3}):(.*)");
  
  public KYLaRueCountyParser() {
    super("LARUECO911:",CITY_LIST, "LARUE COUNTY", "KY");
  }
  
  @Override
  public String getFilter() {
    return "LARUECO911@otelco.net,315@otelco.net";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    Matcher match = CALL_ID_PTN.matcher(body);
    if (!match.matches()) return false;
    data.strCallId = match.group(1);
    body = match.group(2);
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }

  private static final String[] CITY_LIST = new String[]{
    "ATHERTONVILLE",
    "BUFFALO",
    "HODGENVILLE",
    "LYONS",
    "MAGNOLIA",
    "MOUNT SHERMAN",
    "TONIEVILLE",
    "UPTON"
    };
  
  @Override
  protected CodeSet buildCallList() {
    return new CodeSet(
        "CARDIAC/CHEST PAINS",
        "FIRE-A FIRE - ALARM",
        "FIRE - ALARM",
        "FIRE - FIELD / BRUSH",
        "FIRE REKINDLE",
        "FIRE-S FIRE - STRUCTURE",
        "FIRE - STRUCTURE",
        "GENERAL ALERT",
        "ILLNESS",
        "MVA WITH INJURIES",
        "UNRESPONSIVE PERSON"  
    );
  }
}
