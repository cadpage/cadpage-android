package net.anei.cadpage.parsers.IN;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.HtmlParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class INWayneCountyBParser extends HtmlParser {
  private static final String PROGRAM_STRING = "ID DATE TIME CODE CALL NAME PHONE ADDR APT CITY INFO X PLACE UNIT";
  INWayneCountyBParser (String defCity, String defState) {
    super (defCity, defState, PROGRAM_STRING, LAYOUT);
    translate (TRANSLATE);
  }

  @Override
  public String getProgram() {
    return PROGRAM_STRING;
  }
  
  @Override
  public String getFilter() {
    return "911@wayneco.us";
  }
  
  private static final DateFormat MY_DATE_FMT = new SimpleDateFormat("MM/dd/yy hh:mm:ss");
  private static final Pattern COMPLAINT_PATTERN
    = Pattern.compile("(\\d{2}\\-\\d{2})\\b *(.*)");
  private static final Pattern CALLER_PATTERN
    = Pattern.compile("(.*?)(\\d{3}\\-\\d{3}\\-\\d{4})?");
  private static final Pattern NOTES_PATTERN
    = Pattern.compile(".*?Cross streets: +([^\\[\\n]+).*", Pattern.DOTALL);
  private static final Pattern NOTES_PATTERN_2
    = Pattern.compile(".*?Landmark: +([^\\[\\n]+).*", Pattern.DOTALL);
  @Override
  protected boolean parseHtmlMsg(String subject, String body, Data data) {
    
    if (!getHtmlCleaner (body)) return false;
   
    data.strCallId = getValue("ID");
    setDateTime(MY_DATE_FMT, getValue("DATETIME"), data);
    String call = getValue("COMPLAINT");
    Matcher m = COMPLAINT_PATTERN.matcher (call);
    if (m.matches()) {
      data.strCode = (m.group(1));
      call = m.group(2);
    }
    data.strCall = call;
    
    m = CALLER_PATTERN.matcher(getValue("CALLER"));
    if (!m.matches()) return false;
    data.strName = m.group(1).replaceAll("\\-(?:[\\s0-9\\-]+\\-)?", "").trim();
    data.strPhone = getOptGroup(m.group(2));

    String address = getValue("ADDRESS");
    int pt = address.indexOf('\n');
    if (pt >= 0) address = address.substring(0,pt).trim();
    address = address.replace("//", "/");
    
    pt = address.lastIndexOf(',');
    if (pt >= 0) {
      data.strCity = address.substring(pt+1).trim();
      address = address.substring(0,pt).trim();
    }
    else {
      pt = address.lastIndexOf('/');
      if (pt >= 0) {
        String city = address.substring(pt+1).trim();
        if (CITIES.contains(city.toUpperCase())) {
          data.strCity = city;
          address = address.substring(0,pt).trim();
        }
      }
    }
    parseAddress (StartType.START_ADDR, FLAG_IMPLIED_INTERSECT | FLAG_ANCHOR_END, address, data);
    
    data.strSupp = getValue("NOTES");
    m = NOTES_PATTERN.matcher(data.strSupp);
    if (m.matches()) data.strCross = m.group(1).replace("//", "/").trim();

    m = NOTES_PATTERN_2.matcher(data.strSupp);
    if (m.matches()) data.strPlace = m.group(1);
    
    data.strUnit = getValue("UNITS");
    return true;
  }
  
  private static final String[] LAYOUT = {
    "ID(element=a; offset=0; required)",
    "DATETIME(xpath=///*[normalize-space(.)=\"Date/Time Received:\"]/following-sibling::td[1]/; xJava)",
    "COMPLAINT(xpath=///*[normalize-space(.)=\"Complaint:\"]/following-sibling::td[1]/; xJava)",
    "CALLER(xpath=///*[normalize-space(.)=\"Caller:\"]/following-sibling::td[1]/; xJava)",
    "ADDRESS(xpath=///*[normalize-space(.)=\"Address:\"]/following-sibling::td[1]/; xJava)",
    "NOTES(xpath=///*[normalize-space(.)=\"Units Assigned\"]/preceding-sibling::p/; separator=/ /; xJava)",
    "UNITS(xpath=///*[normalize-space(.)=\"Units Assigned\"]/following-sibling::table/tbody/tr/td[1]/; xJava)"
  };
  
  private static final Set<String> CITIES = new HashSet<String>(Arrays.asList(new String[]{
      
    // Counties  
    "RANDOLPH",
    "DARKE",
    "PREBLE",
    "UNION",
    "FAYETTE",
    "HENRY",
    
    // Cities and towns
    "BOSTON",
    "CAMBRIDGE CITY",
    "CENTERVILLE",
    "DUBLIN",
    "EAST GERMANTOWN",
    "ECONOMY",
    "FOUNTAIN CITY",
    "GREENS FORK",
    "HAGERSTOWN",
    "MILTON",
    "RICHMOND",
    "SPRING GROVE",
    "WHITEWATER",
    
    // Unincorporated towns
    "ABINGTON",
    "BETHEL",
    "JACKSONBURG",
    "MIDDLEBORO",
    "PENNVILLE",
    "WEBSTER",
    "WILLIAMSBURG",
    
    // Townships
    "ABINGTON",
    "BOSTON",
    "CENTER",
    "CLAY",
    "DALTON",
    "FRANKLIN",
    "GREEN",
    "HARRISON",
    "JACKSON",
    "JEFFERSON",
    "NEW GARDEN",
    "PERRY",
    "WASHINGTON",
    "WAYNE",
    "WEBSTER",
  }));
  
  private static final String[] TRANSLATE = {
    "&amp;", "&"
  };
}
