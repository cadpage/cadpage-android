package net.anei.cadpage.parsers.VA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class VAGloucesterCountyParser extends FieldProgramParser {
  
  private static final Pattern RUN_REPORT_PTN = Pattern.compile("Event Number: ([-0-9]+)\n.*\nArrival Date / Time: *\\d+.*", Pattern.DOTALL);
  public VAGloucesterCountyParser() {
    super(CITIES, "GLOUCESTER COUNTY", "VA", 
        "Event_Number:ID! Category:CALL! Sub_Category:SKIP! Description:INFO! INFO+ Address:ADDR/S! ZIP? Opened_Date_/_Time:DATETIME!");
    allowBadChars("()");  
  }
  
  @Override
  public String getFilter() {
    return "GCSO@GLOUCESTERVA.INFO";
  }

  @Override
  public boolean parseMsg(String head, String body, Data data) {
    Matcher match = RUN_REPORT_PTN.matcher(body);
    if (match.matches()) {
      data.strCall = "RUN REPORT";
      data.strPlace = body;
      data.strCallId = match.group(1);
      return true;
    }
      
    return parseFields(body.split("\n"), data);    
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("ZIP")) return new MyZipField();
    return super.getField(name);
  }

  private static final Pattern ADDR_ZIP_PATTERN = Pattern.compile("(.*), *(\\d{5})");
  private static final Pattern ROUTE_PATTERN = Pattern.compile("- *\\(?(RT +\\d+\\b)\\)?");
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      String zip = null;
      Matcher match = ADDR_ZIP_PATTERN.matcher(field);
      if (match.matches()) {
        field = match.group(1).trim();
        zip = match.group(2);
      } else {
        field = stripFieldEnd(field, ",");
      }
      field = ROUTE_PATTERN.matcher(field).replaceAll("($1)");
      super.parse(field, data);
      if (data.strCity.length() == 0 && zip != null) data.strCity = zip;
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames()+" CITY";
    }
  }
  
  private static final Pattern ZIP_PATTERN = Pattern.compile("\\d{5}");
  private class MyZipField extends CityField {
    @Override
    public void parse(String field, Data data) {
      if (data.strCity.length() == 0 && ZIP_PATTERN.matcher(field).matches()) {
        data.strCity = field;
      }
    }
  }
  
  private static final String[] CITIES = {
    "GLOUCESTER POINT",
    "GLOUCESTER",
    "HAYES",
    "JAMES STORE",
    "WHITE MARSH",
    "ORDINARY",
    "WICOMICO"
  };
}
