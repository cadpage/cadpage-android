package net.anei.cadpage.parsers.TX;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Cy Creek Comm Center
 */
public class TXCyCreekCommCenterParser extends MsgParser {
  
  private static final Pattern MARKER = Pattern.compile("^(\\d\\d/\\d\\d) (?:(\\d\\d:\\d\\d) )?");
  private static final Pattern TRAILER = Pattern.compile(" +(\\d{8,}) *$");
  private static final Pattern VAL_PTN = Pattern.compile("\\bVAL\\b", Pattern.CASE_INSENSITIVE);
  
  public TXCyCreekCommCenterParser() {
    super("HARRIS COUNTY", "TX");
  }
  
  @Override
  public String getFilter() {
    return "CommCenter@ccems.com,93001,777,888,messaging@iamresponding.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // Strip message prefix
    
    data.strSource = subject;
    
    if (body.startsWith("/ ")) body = body.substring(2).trim();
    
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    data.strDate = match.group(1);
    data.strTime = getOptGroup(match.group(2));
    body = body.substring(match.end()).trim();
    
    match = TRAILER.matcher(body);
    if (match.find()) {
      data.strCallId = match.group(1);
      body = body.substring(0,match.start());
    }
    
    if (body.startsWith("Repage:")) body = body.substring(7).trim();
    
    body = "Loc:" + body;
    
    Properties props = parseMessage(body, new String[]{"Loc", "Map", "Sub", "Nat", "Units", "X-St"});
    String sAddr = props.getProperty("Loc", "");
    Parser p = new Parser(sAddr);
    sAddr = p.get(',');
    sAddr = VAL_PTN.matcher(sAddr).replaceAll("VALLEY");
    parseAddressCity(sAddr, data);
    if (data.strCity.equals("HC")) data.strCity = "";
    if (data.strCity.equals("MC")) data.strCity = "MONTGOMERY COUNTY";
    if (data.strCity.equals("H")) data.strCity = "HOUSTON";
    data.strPlace = p.get(';');
    data.strApt = p.get();
    
    data.strMap = props.getProperty("Map", "");
    String sPlace = props.getProperty("Sub", "");
    if (sPlace.length() > 0) data.strPlace = sPlace;
    data.strCall = props.getProperty("Nat", "");
    data.strUnit = props.getProperty("Units", "");
    data.strCross = props.getProperty("X-St", "");
    
    if (data.strCity.length() == 0 && data.strCall.contains("MA-MUTUAL AID")) data.strCity = "HOUSTON";
    return true;
  }
}
