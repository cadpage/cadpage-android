package net.anei.cadpage.parsers.OH;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchEmergitechParser;



public class OHFranklinParser extends DispatchEmergitechParser {
  
  private static final Pattern ID_DATE_TIME_PTN = Pattern.compile(" +-(\\d{7})\\((\\d\\d?/\\d\\d?/\\d{4}) +(\\d\\d?:\\d\\d?:\\d\\d? [AP]M)\\)$");
  private static final Pattern GPS_PTN = Pattern.compile("^X([-+]\\d+\\.\\d{4,}) +Y([-+]\\d+\\.\\d{4,})\\b");
  
  private static DateFormat TIME_FMT = new SimpleDateFormat("hh:mm:ss aa");
  
  public OHFranklinParser() {
    super("", 60, CITY_LIST, "FRANKLIN", "OH");
    addSpecialWords("ASHGROVE", "MISSION", "THOMAS");
  }
  
  @Override
  public String getFilter() {
    return "@cmsg.net,@alert.active911.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (subject.length() == 7 && NUMERIC.matcher(subject).matches()) {
      body = '[' + subject + ']' + body;
    } else if (subject.startsWith("CAD")) {
      body = "[0000000]- NATURE: " + body;
    }
    
    Matcher match = ID_DATE_TIME_PTN.matcher(body);
    if (match.find()) {
      data.strCallId = match.group(1);
      data.strDate = match.group(2);
      setTime(TIME_FMT, match.group(3), data);
      body = body.substring(0,match.start());
    }
    
    if (!super.parseMsg(body, data)) return false;
    
    data.strUnit = "";
    
    match = GPS_PTN.matcher(data.strSupp);
    if (match.find()) {
      setGPSLoc(match.group(1) + ' ' + match.group(2), data);
      data.strSupp = data.strSupp.substring(match.end()).trim();
    }
    return true;
  }
  
  @Override
  public String getProgram() {
    return super.getProgram().replace("INFO", "GPS INFO") + " ID DATE TIME";
  }
  
  private static final String[] CITY_LIST = new String[]{
    "FRANKLIN",
    "FRANKLIN TWP",
    "LEBANON",
    "MIDDLETOWN"
  };
}
