package net.anei.cadpage.parsers.NJ;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgParser;


/**
 * JCMC EMS HudCEN, NJ
 */
public class NJJCMCEMSHudCENParser extends MsgParser {
  
  private static final Pattern CANCEL_PTN = Pattern.compile("Call Cancelled: (.*) Cancelled: #([-0-9]+)");
  private static final Pattern RUN_REPORT_PTN = Pattern.compile("Times: (.*?) +Response Number:([-0-9]+)");
  private static final Pattern MASTER_PTN = Pattern.compile("Unit:(\\d+) +(.*?) Resp:(.*?) Apt\\.(.*)/(.*?)S?Cross:(.*)");
  
  public NJJCMCEMSHudCENParser() {
    super("HUDSON COUNTY", "NJ");
  }
  
  @Override
  public String getFilter() {
    return "hudcen@libertyhcs.org";
  }
  
  @Override
  public String getLocName() {
    return "JCMC EMS HudCEN, NJ";
  }

  @Override
  public boolean parseMsg(String body, Data data) {
    Matcher match = CANCEL_PTN.matcher(body);
    if (match.matches()) {
      setFieldList("CALL PLACE ID");
      data.strCall = "Call Cancelled";
      data.strPlace = match.group(1).trim();
      data.strCallId = match.group(2);
      return true;
    }
    
    match = RUN_REPORT_PTN.matcher(body);
    if (match.matches()) {
      data.strCall = "RUN REPORT";
      data.strPlace = match.group(1);
      data.strCallId = match.group(2);
      return true;
    }
    
    match = MASTER_PTN.matcher(body);
    if (match.matches()) {
      setFieldList("UNIT CITY ADDR APT CALL X");
      data.strUnit = match.group(1);
      data.strCity = match.group(2).trim();
      parseAddress(match.group(3).trim(), data);
      data.strApt = match.group(4).trim();
      data.strCall = match.group(5).trim();
      if (data.strCall.length() == 0) data.strCall = "ALERT";
      data.strCross = match.group(6).trim();
      return true;
    }
    
    return false;
  }

}
