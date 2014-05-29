package net.anei.cadpage.parsers.IL;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA42Parser;


public class ILKaneCountyAParser extends DispatchA42Parser {
  
  private static final Pattern MARKER = Pattern.compile("^([A-Z]+) - (.*?) (\\d\\d:\\d\\d) (\\d\\d/\\d\\d/\\d\\d) +");
  private static final Pattern MAP_PTN = Pattern.compile("(?: +[A-Z]+-\\d+)+\\b *");
  private static final Pattern END_CITY_PTN = Pattern.compile(" [A-Z][a-z]+(  +)[A-Z]+ ");
  private static final Pattern MISSED_BLANK = Pattern.compile("(?<=[a-z])(?=\\d)");
  private static final Pattern NO_CROSS_PTN = Pattern.compile("(.*?) *\\bNo Cross Streets Found");
  private static final Pattern TRAIL_MAP_PTN = Pattern.compile(" +([A-Z]+-\\d+)$");
  private static final Pattern INFO_JUNK_PTN = Pattern.compile(" *(?:Dispatch received by unit ([A-Z0-9]+)|Call Number \\d+ was created from Call Number \\d+\\([^\\)]+?\\)) *");
  
  
  // They have some odd 2 part street numbers that need special handling
  private static final Pattern SPEC_STREET_NBR_PTN1 = Pattern.compile("(\\b\\d{2}[NSEW]) *(\\d+) +");
  private static final Pattern SPEC_STREET_NBR_PTN2 = Pattern.compile("(.*)\\b(\\d{2}[NSEW])");
  
  public ILKaneCountyAParser() {
    super(ILKaneCountyParser.CITY_LIST, "KANE COUNTY", "IL");
    setupMultiWordStreets("ROCK ROAD", "BONNIE DUNDEE");
  }
  
  @Override
  public String getFilter() {
    return "Quad Com,Dispatch@quadcom911.org";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("Dispatch Incident")) return false;
    
    // Check for common tagged format
    if (super.parseMsg(body, data)) {
      
      // A special street number prevents us from recognizing trailing
      // cross streets
      Matcher match = SPEC_STREET_NBR_PTN1.matcher(data.strAddress);
      if (match.lookingAt()) {
        String prefix = match.group(1);
        String addr = data.strAddress.substring(match.start(2));
        data.strAddress = "";
        parseAddress(StartType.START_ADDR, FLAG_CROSS_FOLLOWS, addr, data);
        data.strAddress = prefix + ' ' + data.strAddress;
        data.strCross = getLeft();
      }
      
    } else {
      
      // Otherwise process the untagged format
      Matcher match = MARKER.matcher(body);
      if (match.find()) {
    
        setFieldList("CODE CALL TIME DATE PLACE ADDR APT X CITY MAP UNIT INFO");
        
        data.strCode = match.group(1);
        data.strCall = match.group(2).trim();
        data.strTime = match.group(3);
        data.strDate = match.group(4);
        body = body.substring(match.end());
        
        // If the address is <UNKNOWN> that is all there is to that
        String extra = "";
        if (body.startsWith("<UNKNOWN>")) {
          data.strAddress = "<UNKNOWN>";
          extra = body.substring(9).trim();
        }
        
        // Otherwise things get tricky.  The smart address parser has real problems
        // finding the end of the address, so we will help it any way we can
        // First see if there is an map pattern
        else {
          match = MAP_PTN.matcher(body);
          int flags = 0;
          if (match.find()) {
            flags = FLAG_ANCHOR_END;
            data.strMap = match.group().trim();
            extra = body.substring(match.end());
            body = body.substring(0,match.start());
          }
          
          // No luck there, try looking for a specific mixed case word followed
          // by multiple blanks followed by upper case word signature
          else if ((match = END_CITY_PTN.matcher(body)).find()) {
            flags = FLAG_ANCHOR_END;
            extra = body.substring(match.end(1));
            body = body.substring(0,match.start(1));
          }
          
          body = MISSED_BLANK.matcher(body).replaceFirst(" ");
          body = body.replace("ROCK ROAD", "ROCK-ROAD");
          parseAddress(StartType.START_PLACE, FLAG_PAD_FIELD | FLAG_CROSS_FOLLOWS | flags, body, data);
          data.strAddress = data.strAddress.replace("ROCK-ROAD", "ROCK ROAD");
          data.strCross = getPadField().replace("ROCK-ROAD", "ROCK ROAD");
          match = NO_CROSS_PTN.matcher(data.strCross);
          if (match.matches()) {
            data.strCross = "";
            String apt = match.group(1);
            if (apt.length() == 1 && "NSEW".contains(apt)) {
              data.strAddress = append(data.strAddress, " ", apt);
            } else {
              data.strApt = append(data.strApt, "-", apt);
            }
          }
          if (flags == 0) {
            extra = getLeft();
            if (data.strCity.length() == 0 && extra.length() == 0) return false;
          }
          
          // Here a special street number ends up getting split between the
          // place name and the address
          match = SPEC_STREET_NBR_PTN2.matcher(data.strPlace);
          if (match.matches()) {
            data.strPlace = match.group(1).trim();
            data.strAddress = append(match.group(2), " ", data.strAddress);
          }
        }
    
        // check for second map code at end of info area
        
        match = TRAIL_MAP_PTN.matcher(extra);
        if (match.find()) {
          data.strMap = append(data.strMap, " ", match.group(1));
          extra = extra.substring(0,match.start());
        }
    
        int last = 0;
        match = INFO_JUNK_PTN.matcher(extra);
        while (match.find()) {
          data.strSupp = append(data.strSupp, " / ", extra.substring(last,match.start()));
          last = match.end();
          String unit = match.group(1);
          if (unit != null) data.strUnit = append(data.strUnit, " ", unit);
        }
        data.strSupp = append(data.strSupp, " / ", extra.substring(last));
      }
      
      // One last chance, see if this is a simple address call format
      else {
        setFieldList("ADDR APT CITY CALL");
        parseAddress(StartType.START_ADDR, body, data);
        data.strCall = getLeft();
        if (data.strCall.length() == 0) return false;
      }
    }    
    // common processing
    if (data.strCity.endsWith(" CO")) data.strCity += "UNTY";
    return true;
  }
}
