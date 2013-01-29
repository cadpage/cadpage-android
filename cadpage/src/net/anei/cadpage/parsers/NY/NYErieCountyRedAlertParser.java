package net.anei.cadpage.parsers.NY;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchRedAlertParser;



public class NYErieCountyRedAlertParser extends DispatchRedAlertParser {
  
  private static final Pattern TRAILER_MARK = Pattern.compile("(?<= \\d\\d:\\d\\d:\\d\\d)\n");
  
  public NYErieCountyRedAlertParser() {
    super("ERIE COUNTY","NY");
    setupMultiWordStreets(
        "BOSTON STATE",
        "LOWER EAST HILL"
    );
  }

  @Override
  public String getFilter() {
    return "dispatch@townofhamburgny.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (body.startsWith("Erie_Alert ")) return false;
    if (body.startsWith("*2")) body = body.substring(2).trim();
    
    Matcher match = TRAILER_MARK.matcher(body);
    if (match.find()) body = body.substring(0,match.start()).trim();
    body = body.replace('\n', ' ');
    return super.parseMsg(subject, body, data);
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    return TW_PTN.matcher(addr).replaceAll("THRUWAY");
  }
  private static final Pattern TW_PTN = Pattern.compile("\\bTW\\b", Pattern.CASE_INSENSITIVE);
}
