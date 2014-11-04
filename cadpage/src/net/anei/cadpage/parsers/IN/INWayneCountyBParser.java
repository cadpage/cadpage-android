package net.anei.cadpage.parsers.IN;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.HtmlParser;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA3Parser;

public class INWayneCountyBParser extends DispatchA3Parser {
  
  private HtmlParser htmlParser;
  
  INWayneCountyBParser (String defCity, String defState) {
    super("WAYNE COUNTY", "IN", 
           "ID DATETIME CALL NAME_PHONE ADDR INFO UNIT");
    htmlParser = new HtmlParser(LAYOUT);
    htmlParser.translate(TRANSLATE);
  }
  
  @Override
  public String getFilter() {
    return "911@wayneco.us";
  }
  
  @Override
  protected boolean parseHtmlMsg(String subject, String body, Data data) {
    if (!subject.startsWith("911 Dispatch: ")) return false;
    if (!htmlParser.getHtmlCleaner (body)) return false;
    return parseFields(htmlParser.getValueArray(), data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME")) return new DateTimeField("\\d\\d/\\d\\d/\\d{4} \\d\\d:\\d\\d:\\d\\d", true);
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("NAME_PHONE")) return new MyNamePhoneField();
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
  private static final Pattern CALL_PATTERN  = Pattern.compile("(\\d{2}\\-\\d{2})\\b *(.*)");
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = CALL_PATTERN.matcher(field);
      if (match.matches()) {
        data.strCode = match.group(1);
        field = match.group(2).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "CODE CALL";
    }
  }
  
  private static final Pattern NAME_PHONE_PATTERN = Pattern.compile("(.*?)\\b(\\d{3}\\-\\d{3}\\-\\d{4})");
  private static final Pattern JUNK_PHONE_PATTERN = Pattern.compile("[- \\d]+$");
  private class MyNamePhoneField extends NameField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = NAME_PHONE_PATTERN.matcher(field);
      if (match.matches()) {
        field = match.group(1).trim();
        data.strPhone = match.group(2);
      }
      field = JUNK_PHONE_PATTERN.matcher(field).replaceFirst("");
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "NAME PHONE";
    }
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {

      int pt = field.indexOf('\n');
      if (pt >= 0) field = field.substring(0,pt).trim();
      field = field.replace("//", "/");
      
      pt = field.lastIndexOf(',');
      if (pt >= 0) {
        data.strCity = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
      }
      else {
        pt = field.lastIndexOf('/');
        if (pt >= 0) {
          String city = field.substring(pt+1).trim();
          if (CITIES.contains(city.toUpperCase())) {
            data.strCity = city;
            field = field.substring(0,pt).trim();
          }
        }
      }
      parseAddress (StartType.START_ADDR, FLAG_IMPLIED_INTERSECT | FLAG_ANCHOR_END, field, data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " CITY";
    }
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
