package net.anei.cadpage.parsers.TX;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.Message;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/**
 * Cy Creek Comm Center
 */
public class TXCyCreekCommCenterParser extends SmartAddressParser {
  
  private static final Pattern PART_MARKER = Pattern.compile("^\\d\\d:\\d\\d ");
  private static final Pattern DATE_PTN = Pattern.compile("(\\d+)/(\\d+)");
  private static final Pattern MARKER = Pattern.compile("^(?:(\\d\\d/\\d\\d) )?(?:(\\d\\d:\\d\\d) )?");
  private static final Pattern TRAILER = Pattern.compile(" +(\\d{8,}) *$");
  private static final Pattern VAL_PTN = Pattern.compile("\\bVAL\\b", Pattern.CASE_INSENSITIVE);
  
  public TXCyCreekCommCenterParser() {
    super("HARRIS COUNTY", "TX");
    setFieldList("SRC DATE TIME PHONE ADDR APT CITY MAP PLACE CALL UNIT X ID");
  }
  
  @Override
  public String getFilter() {
    return "CommCenter@ccems.com,93001,777,888,messaging@iamresponding.com";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }

  @Override
  protected Data parseMsg(Message msg, int parseFlags) {
    
    // Sometimes the date is include in parenthesis, where it will be
    // missinterpreted as a subject or message index :(
    String body = msg.getMessageBody();
    if  (PART_MARKER.matcher(body).find()) {
      int month = -1;
      int day = -1;
      String subject = msg.getSubject();
      if (subject.length() > 0) {
        Matcher match = DATE_PTN.matcher(subject);
        if (match.matches()) {
          month = Integer.parseInt(match.group(1));
          day = Integer.parseInt(match.group(2));
        }
      } else {
        if (msg.getMsgCount() >= 0) {
          month = msg.getMsgIndex();
          day = msg.getMsgCount();
        }
      }
      if (month >= 0) {
        subject = String.format("%02d/%02d", month, day);
        body = subject + ' ' + body;
      }
      msg.setMessageBody(body);
    }
    return super.parseMsg(msg, parseFlags);
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // Strip message prefix
    
    data.strSource = subject;
    
    if (body.startsWith("/ ")) body = body.substring(2).trim();
    
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;  // Never happens anymore
    data.strDate = getOptGroup(match.group(1));
    data.strTime = getOptGroup(match.group(2));
    body = body.substring(match.end()).trim();
    if (data.strDate.length() == 0 && data.strTime.length() == 0) return false;
    
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
    String cross = props.getProperty("X-St", "");
    if (cross.contains("/") || cross.contains("&")) {
      data.strCross = cross;
    } else {
      Result res = parseAddress(StartType.START_ADDR, FLAG_CHECK_STATUS | FLAG_ONLY_CROSS | FLAG_ANCHOR_END | FLAG_IMPLIED_INTERSECT, cross);
      if (res.getStatus() > 0) {
        res.getData(data);
      } else {
        parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS | FLAG_CROSS_FOLLOWS, cross, data);
        data.strCross = append(data.strCross, " / ", getLeft());
      }
    }
    
    if (data.strCity.length() == 0 && data.strCall.contains("MA-MUTUAL AID")) data.strCity = "HOUSTON";
    return true;
  }
}
