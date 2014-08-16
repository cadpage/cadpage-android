package net.anei.cadpage.parsers.NJ;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.HtmlParser;


/**
 * Mercer County, NJ
 */
public class NJMercerCountyBParser extends HtmlParser {
  
  public NJMercerCountyBParser() {
    super(CITY_LIST,
        "MERCER COUNTY", 
        "NJ",
        "CALL! NUMBER? ADDR! UNIT! DATETIME",
        // For some reason this only works with the bulk format - I can't get the conditional
        // branches to work.  Also The address parsing is not getting the city.  Don't know why not.
        LAYOUT);
    translate(TRANSLATE_LIST);
  }
  
  @Override
  public String getProgram() {
    return append(getOptGroup(super.getProgram()), " ", "ADDR X CITY APT PLACE MAP UNIT CALL PRI");
  }
  
  @Override
  public String getFilter() {
    return "DoNotReplyCAD@mercercounty.org";
  }
  
  private static final Pattern BULK_PATTERN
    = Pattern.compile("(?i).*?body>(.*?)<p.*", Pattern.DOTALL);

  //  private static int ct = 1;
  @Override
  protected boolean parseHtmlMsg(String subject, String msg, Data data) {
    String[] flds;
    if (!getHtmlCleaner(msg)) {
      Matcher m = BULK_PATTERN.matcher(msg);
      if (m.matches()) {
        String bulk = m.group(1);
        flds = translate(bulk).split("(?i)(?:<br.*?> *)+");
        return parseFields(flds, data);
      }
      return false;
    }

    parseLocation(getValue("LOCATION"), data);
    data.strCall = getValue("CALL");
    if (getValue("UNIT").equals("")) {
      data.strMap = getValue("MAP2");
      data.strUnit = getValue("UNIT2");
    }
    else {
      data.strMap = getValue("MAP");
      if (getValue("UNIT").equals(""))
        return false;
      data.strUnit = getValue("UNIT");
    }
    return true;
//    return data.strAddress.length() > 0 && data.strCall.length() > 0 && data.strUnit.length() > 0;
  }
  
  private void parseLocation(String loc, Data data) {
    int lparen, rparen;
    String paren = "";
    
    lparen = loc.indexOf('(');
    if (lparen > -1) {
      rparen = loc.indexOf(')', lparen+1);
      if (rparen > -1) {
        paren = loc.substring(lparen+1, rparen);
        loc = loc.substring(0, lparen-1)+loc.substring(rparen+1);
      }
    }
    if (loc.charAt(0) == '&') {
      data.strPlace = loc = loc.substring(1).trim();
      Result r = parseAddress(StartType.START_ADDR, paren);
      if (r.getStatus() > 1)
        r.getData(data);
      if (data.strCity.equals(""))
        parseAddress(StartType.START_PLACE, FLAG_ONLY_CITY, loc, data);
    }
    else {
      parseAddress(StartType.START_ADDR, loc, data);
      if (data.strCity.equals(""))
        parseAddress(StartType.START_OTHER, FLAG_ONLY_CITY, paren, data);
      data.strCross = paren.replace(',', '/');
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("NUMBER")) return new NumberField("(\\d)", true);
    return super.getField(name);
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String f, Data data) {
      parseLocation(f, data);
    }
    
    @Override
    public String getFieldNames() {
      return append(super.getFieldNames(), " ", "PLACE X");
    }
  }
  
  private class NumberField extends Field {
    NumberField(String p, boolean h) {
      super(p, h);
    }
    
    @Override
    public String getFieldNames() {
      return "";
    }
    
    @Override
    public void parse(String f, Data data) {}
  }
  
  private static final String[] LAYOUT = {
    "LOCATION(ELEMENT=TD;LABEL=/Location:/;REMOVE_LABEL; REQUIRED)",
    "CALL(ELEMENT=TD;LABEL=/Response Type:/;REMOVE_LABEL; REQUIRED)",
    "MAP(ELEMENT=TD;LABEL=/Zone Name:/;REMOVE_LABEL)",
    "UNIT(ELEMENT=TD;LABEL=/Name:/;REMOVE_LABEL;/;EXCLUDE=/Zone Name:/;MULTIPLE)",
    "MAP2(ELEMENT=TD;LABEL=/Zone:/;REMOVE_LABEL)",
    "UNIT2(TABLE=1;ROW=*;COL=*;EXCLUDE=/Name:/)",
    "PRIORITY(ELEMENT=TD;LABEL=/AlarmLevel:/;REMOVE_LABEL)"
  };
  
  private static final String[] CITY_LIST = {
    "WEST WINDSOR",
    "WEST WINDSOR TWP",
    "EWING",
    "EWING TWP",
    "HAMILTON",
    "HAMILTON TWP",
    "EAST WINDSOR",
    "EAST WINDSOR TWP",
    "CRANBURY",
    "CRANBURY TWP",
    "ROBBINSVILLE",
    "ROBBINSVILLE TWP",
    "LAWRENCE",
    "LAWRENCE TWP",
    "HIGHTSTOWN",
    "HOPEWELL",
    "PENNINGTON",
    "PRINCETON",
    "TRENTON"
  };
  
  private static final String[] TRANSLATE_LIST = {
    "&amp;",   "&",
    "& amp;",  "&",
    "&lt;",    "<",
    "& lt;",   "<",
    "&gt;",    ">",
    "& gt;",   ">"
  };
 }
