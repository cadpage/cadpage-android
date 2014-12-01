package net.anei.cadpage.parsers.NY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class NYNassauCountyElmontParser extends FieldProgramParser {
  
  private static final String[] CITY_LIST = new String[]{
    "ELMONT", "NO VALLEY STREAM", "ALDEN MANOR", "FLORAL PARK", "SO FLORAL PARK", 
    "STEWART MANOR", "MALVERNE", "FRANKLIN SQUARE", "WEST HEMPSTEAD", "HEMPSTEAD",
    "LYNBROOK", "BELLEROSE", "BELLEROSE TERRACE", "VALLEY STREAM"
  };

  public NYNassauCountyElmontParser() {
    super(CITY_LIST, "NASSAU COUNTY", "NY", 
           "Call:ID_CALL! ( SELNEW Sub:CALL! Address:ADDR1! Cross:X Info:INFO| Sub:ADDR/SC! Cross:INFO )" );
  }
  
  @Override
  public String getFilter() {
    return "Elmont@Alarms.com";
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ID_CALL")) return new MyIdCallField();
    if (name.equals("SELNEW")) return new MySelNewField();
    if (name.equals("ADDR1")) return new MyAddress1Field();
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private class MyIdCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      if (NUMERIC.matcher(field).matches()) {
        data.strCallId = field;
      } else {
        data.strCall = field;
      }
    }
    
    @Override
    public String getFieldNames() {
      return "ID CALL";
    }
  }
  
  private class MySelNewField extends SelectField {
    @Override
    public boolean checkParse(String field, Data data) {
      return data.strCallId.length() > 0;
    }
  }
  
  private class MyAddress1Field extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      String city = p.getLastOptional(',');
      if (city.equals("NY")) city = p.getLastOptional(',');
      parseAddress(p.get(), data);
      data.strCity = city;
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR APT CITY";
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith("&")) field = field.substring(0,field.length()-1).trim();
      if (field.startsWith("&")) field = field.substring(1).trim();
      super.parse(field, data);
    }
  }
  
  private static final Pattern INFO_ZONE_PTN = Pattern.compile(", (ZONE \\d)$");
  
  private static final Pattern INFO_MAP_PTN = 
      Pattern.compile(" +(MAP +\\d+|\\d+-[A-Z]\\d)$");
  
  private class MyInfoField extends InfoField {
    
    @Override
    public void parse(String field, Data data) {
      Matcher match = INFO_ZONE_PTN.matcher(field);
      if (match.find()) {
        data.strUnit = match.group(1);
        field = field.substring(0,match.start()).trim();
      } else {
        int pt = field.lastIndexOf(',');
        if (pt >= 0) {
          if ("ZONE ".startsWith(field.substring(pt+1).trim())) {
            field = field.substring(0,pt).trim();
          }
        }
      }
      match = INFO_MAP_PTN.matcher(field);
      if (match.find()) {
        data.strMap = match.group(1);
        field = field.substring(0, match.start()).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "INFO MAP UNIT";
    }
    
  }
}
