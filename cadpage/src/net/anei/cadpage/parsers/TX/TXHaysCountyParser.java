package net.anei.cadpage.parsers.TX;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgParser;


public class TXHaysCountyParser extends MsgParser {
  
  private static final Pattern SUBJECT_PTN = Pattern.compile("Alarm - (.*?) - (.*)");
  private static final Pattern MASTER = Pattern.compile("([A-Z0-9]+) RESPOND TO (.*?) (?:\\[(.*) )?FOR (.*?) DET CODE: (.*?)");
  
  public TXHaysCountyParser() {
    super("HAYS COUNTY", "TX");
  }
  
  public String getFilter() {
    return "dispatch@smhcems.com";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    Matcher match = SUBJECT_PTN.matcher(subject);
    if (!match.matches()) return false;
    data.strSource = match.group(1).trim();
    data.strCall = match.group(2).trim();
    
    match = MASTER.matcher(body);
    if (!match.matches()) return false;
    data.strUnit = match.group(1).trim();
    parseAddress(match.group(2).trim(), data);
    data.strCity = getOptGroup(match.group(3));
    data.strCall = match.group(4).trim();
    data.strCode = match.group(5).trim();
    if (data.strCode.length() < 2) data.strCode = "";
    return true;
  }

  @Override
  public String adjustMapAddress(String sAddress) {
    return RR_PTN.matcher(sAddress).replaceAll("RT");
  }
  private static final Pattern RR_PTN = Pattern.compile("\\bRR\\b");
}
