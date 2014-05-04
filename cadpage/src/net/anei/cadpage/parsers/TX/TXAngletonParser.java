
package net.anei.cadpage.parsers.TX;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.HtmlParser;

public class TXAngletonParser extends HtmlParser {
  public TXAngletonParser() {
    super(CITY_CODE, "ANGLETON", "TX",
        "Date:DATETIME Nature:CALL Business:PLACE Address:ADDR/S Notes:INFO+ Units:UNIT",
        LAYOUT);
  }
  
  @Override
  public String getProgram() {
    return "ID CALL ADDR APT CITY PLACE X DATE TIME UNIT INFO";
  }
  
  @Override
  public String getFilter() {
    return "nealmorton@bcffa.us";
  }

  private static final Pattern HEADER_PATTERN
    = Pattern.compile("(.*?)Incident #(\\d{10})");
  @Override
  protected boolean parseHtmlMsg(String header, String msg, Data data) {
    msg=msg.replace("\\t", "");
    if (!getHtmlCleaner(msg))
      return false;
    Matcher m = HEADER_PATTERN.matcher(header);
    if (!m.matches()) return false;
    data.strCallId = m.group(2);
    if (m.group(1).contains("Clear")) {
      data.strCall = "CLEAR";
      data.strSupp = clean(getOptGroup(getElementValue("pre", 0)));
      return true;
    }
    else
      return parseFields(getValue("EVERYTHING").split("\n"), data);
  }
 
  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME"))
      return new MyDateTimeField();
    if (name.equals("CALL"))
      return new CallField("(.*?)MP\\:", false);
    if (name.equals("ADDR"))
      return new MyAddressField();
    return super.getField(name);
  }
  
  private static final Pattern DATE_TIME_PATTERN
    = Pattern.compile ("(.*?)Time Out\\:(.*)");
  private class MyDateTimeField extends DateTimeField {
    @Override
    public void parse(String field, Data data) {
      Matcher m = DATE_TIME_PATTERN.matcher(field);
      if (m.matches()) {
        data.strDate = m.group(1).trim();
        data.strTime = m.group(2).trim();
      }
    }
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      super.parse(field.replace("City:",  " ").trim(), data);
    }
  }
  
  private static final String[] LAYOUT = {
    "EVERYTHING(ELEMENT=PRE;REMOVE=/\\t/)"
// That's right, everything of interest is in one preformatted chunk of text
    // with a bunch of extra tabs, which
    // begs the question:  Why even use html????
  };
  
  private static final Properties CITY_CODE = buildCodeTable(new String[]{
        // Cities    
        "ALVIN",              "ALVIN",
        "ANGL",               "ANGLETON",
        "BRAZ",               "BRAZORIA",
        "BROOKSIDE VILLAGE",  "BROOKSIDE VILLAGE",
        "CLUTE",              "CLUTE",
        "DANBURY",            "DANBURY",
        "FREEPORT",           "FREEPORT",
        "LAKE JACKSON",       "LAKE JACKSON",
        "LIVERPOOL",          "LIVERPOOL",
        "MANVEL",             "MANVEL",
        "OYSTER CREEK",       "OYSTER CREEK",
        "PEARLAND",           "PEARLAND",
        "RICHWOOD",           "RICHWOOD",
        "SANDY POINT",        "SANDY POINT",
        "SURFSIDE BEACH",     "SURFSIDE BEACH",
        "SWEENY",             "SWEENY",
        "WEST COLUMBIA",      "WEST COLUMBIA",
    
        // Towns
        "HOLIDAY LAKES",      "HOLIDAY LAKES",
        "QUINTANA",           "QUINTANA",
    
        // Villages
        "BAILEYS PRAIRIE",    "BAILEYS PRAIRIE",
        "BONNEY",             "BONNEY",
        "HILLCREST",          "HILLCREST",
        "IOWA COLONY",        "IOWA COLONY",
        "JONES CREEK",        "JONES CREEK",
    
        // CDPs
        "DAMON",              "DAMON",
        "WILD PEACH VILLAGE", "WILD PEACH VILLAGE",
        
        // Other areas
        "AMSTERDAM",          "AMSTERDAM",
        "ANCHOR",             "ANCHOR",
        "CHENANGO",           "CHENANGO",
        "CHINA GROVE",        "CHINA GROVE",
        "CHOCOLATE BAYOU",    "CHOCOLATE BAYOU",
        "DANCIGER",           "DANCIGER",
        "EAST COLUMBIA",      "EAST COLUMBIA",
        "ENGLISH",            "ENGLISH",
        "OLD OCEAN",          "OLD OCEAN",
        "OTEY",               "OTEY",
        "ROSHARON",           "ROSHARON",
        "SNIPE",              "SNIPE",
        "SILVERLAKE",         "SILVERLAKE",
        "TURTLE COVE",        "TURTLE COVE",
        "MCBETH",             "MCBETH"

  });
}
