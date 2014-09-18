package net.anei.cadpage.parsers.CA;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgParser;


public class CAHaywardCountyParser extends MsgParser {

  public CAHaywardCountyParser() {
    super("HAYWARD COUNTY", "CA");
    setFieldList("ADDR APT GPS PLACE CALL DATE TIME MAP UNIT INFO");
  }

  private static Pattern MASTER = 
      Pattern.compile("(.*?) (?:(\\d+\\.\\d{5,} -\\d+\\.\\d{5,})|-361 -361) (?:(.*?) )?([A-Z]{2,6}) (\\d\\d?/\\d\\d?/\\d{4}) (\\d\\d?:\\d\\d:\\d\\d [AP]M)([A-Za-z]{3} [A-Za-z0-9]{4} \\d{4})(?:  +(.*))?");
  private static DateFormat TIME_FMT = new SimpleDateFormat("hh:mm:ss aa");
  private static Pattern UNIT_PTN = Pattern.compile("Dispatch received by unit ([A-Z0-9]+) *");

  @Override
  public int getMapFlags() {
    return MAP_FLG_PREFER_GPS;
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("Incident Notification")) return false;
    
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    parseAddress(match.group(1).trim(), data);
    String gps = match.group(2);
    if (gps != null) setGPSLoc(gps, data);
    data.strPlace = getOptGroup(match.group(3));
    data.strCall = match.group(4);
    data.strDate = match.group(5);
    setTime(TIME_FMT, match.group(6), data);
    data.strMap = match.group(7);
    String info = getOptGroup(match.group(8));
    
    while ((match = UNIT_PTN.matcher(info)).lookingAt()) {
      data.strUnit = append(data.strUnit, " ", match.group(1));
      info = info.substring(match.end());
    }
    data.strSupp = info;
    return true;
  }
}
