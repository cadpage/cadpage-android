package net.anei.cadpage.parsers.IN;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA6Parser;

/**
 * St Joseph County, IN
 */
public class INStJosephCountyParser extends DispatchA6Parser {
  
  // Pattern we use to try to find the missing space between the cross street and info
  private static Pattern DATE_ADDR_BRK = Pattern.compile(" \\d\\d/\\d\\d/\\d\\d(?<!20)(?=[A-Z0-9])");
  private static Pattern CROSS_BREAK = Pattern.compile("\\)[ A-Z0-9]+? (?:(?:RD|HW)(?! )|(?:ST|AV|TR|DR)(?![AEIOU ]))");
  private static Pattern MAP_PTN = Pattern.compile(" +([A-Z]-\\d+|\\d{2,3}-\\d{2,3})");
  private static Pattern LEAD_DATE_TIME = Pattern.compile("^(\\d\\d?:\\d\\d[AP]M) (\\d\\d/\\d\\d/\\d{4}) ");
  private static Pattern TRAIL_TIME = Pattern.compile(" ([012]\\d)(\\d\\d),?$");
  private static DateFormat TIME_FMT = new SimpleDateFormat("hh:mmaa");;
  
  public INStJosephCountyParser() {
    super(CITY_CODES, "ST JOSEPH COUNTY", "IN");
  }
  
  @Override
  public String getFilter() {
    return "@c-msg.net,alerts@etieline.com";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // This is going to be interesting.  Different departments get radically differnt page formats, 
    // but they all share the same sender space, and all have some features in common.  All of which
    // makes me thing they are originating from the  same dispatch center with some interesting post
    // genreation changes.  We will try to handle them all in one text parser
    
    
    // Check for a run report pattern
    if (body.contains(" ->Inc Addr = ")) {
      data.strCall = "RUN REPORT";
      data.strPlace = body;
      return true;
    }
    
    if (body.startsWith("- ")) body = body.substring(3).trim();
    
    // Now they don't put a space between a date and the address that follows it :(
    Matcher match = DATE_ADDR_BRK.matcher(body);
    if (match.find()) {
      int pt = match.end();
      body = body.substring(0,pt) + " " + body.substring(pt);
    }
    
    // These guys don't put a space between the cross street an info field.
    // So to find where it should be and restore it
    match = CROSS_BREAK.matcher(body);
    if (match.find()) {
      int pt = match.end();
      body = body.substring(0,pt) + " " + body.substring(pt);
    }
    
    match = LEAD_DATE_TIME.matcher(body);
    if (match.find()) {
      setTime(TIME_FMT, match.group(1), data);
      data.strDate = match.group(2);
      body = body.substring(match.end()).trim();
    }
    
    else {
      match = TRAIL_TIME.matcher(body);
      if (match.find()) {
        data.strTime = match.group(1) + ':' + match.group(2);
        body = body.substring(0,match.start()).trim();
      }
    }
    if (! super.parseMsg(body, data)) return false;
    data.strAddress = data.strAddress.replace("*", "");
    match = MAP_PTN.matcher(data.strCall);
    if (match.find()) {
      data.strMap = match.group(1);
      data.strCall = data.strCall.substring(0,match.start());
    }
    return true;
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[] {
      "CE", "CENTRE TWP",
      "CL", "CLAY TWP",
      "GE", "GERMAN TWP",
      "GR", "GREEN TWP",
      "HA", "HARRIS TWP",
      "LI", "LIBERTY TWP",
      "MA", "MADISON TWP",
      "MI", "MISHAWAKA",
      "NC", "NEW CARLISLE",
      "ND", "NOTRE DAME",
      "OS", "OSCEOLA",
      "PE", "PENN TWP",
      "PO", "PORTAGE TWP",
      "SB", "SOUTH BEND",
      "SO", "SW CENTRAL",
      "SW", "",
      "WA", "WARREN TWP",

  });
}
