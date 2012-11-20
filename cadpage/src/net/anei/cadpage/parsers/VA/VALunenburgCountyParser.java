package net.anei.cadpage.parsers.VA;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchDAPROParser;



public class VALunenburgCountyParser extends DispatchDAPROParser {
  
  public VALunenburgCountyParser() {
    super("LUNENBURG COUNTY", "VA");
    setup();
  }
  
  @Override
  public String getFilter() {
    return "MAILBOX@rushpost.com";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    data.strAddress = TRAILER_PK_PTN.matcher(data.strAddress).replaceAll("TRAILER PARK RD");
    return true;
  }
  private static final Pattern TRAILER_PK_PTN = Pattern.compile("\\bTRAILER PK(?: RD)?\\b", Pattern.CASE_INSENSITIVE);
  
  private void setup() {
    setupCallList(
        "ACCIDENT",
        "ALARM",
        "ALERGIC REACT",
        "ARGUMENT",
        "ASTHMA",
        "BLEEDING",
        "BRUSH FIRE",
        "CHEST PAINS",
        "DIFF BREATHING",
        "DUMPSTER FIRE",
        "FALLEN",
        "FIRE",
        "FIRE ALARM",
        "MUTUAL AID",
        "OTHER",
        "OTHER TRAINING",
        "PASSED OUT",
        "PREGNANCY",
        "PUBLIC SERVICE",
        "RESCUE",
        "SICK",
        "STAND BY",
        "TREE IN ROAD",
        "UNRESPONSIVE"
        );
  }
}
