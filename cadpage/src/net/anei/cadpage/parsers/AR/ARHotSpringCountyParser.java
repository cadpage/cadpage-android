package net.anei.cadpage.parsers.AR;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.ReverseCodeSet;

public class ARHotSpringCountyParser extends FieldProgramParser {
  
  public ARHotSpringCountyParser() {
    super("HOT SPRING COUNTY", "AR", 
          "( CALL:CALL! PLACE:PLACE! ADDR:ADDR! CITY:CITY! DATE:DATETIME! INFO:INFO! INFO/N+ " + 
          "| Category:CALL! Address:ADDR2! Intersection:X? Business_Name:PLACE! Event_#:ID! Date_/_Time:DATETIME! Notes:INFO )");
  }
  
  @Override
  public String getFilter() {
    return "DISPATCH@HOTSPRINGDEM.ORG";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    if (body.startsWith("CALL:")) {
      return super.parseFields(body.split("\n"), data);
    }
    
    if (body.startsWith("Category:")) {
      body = body.replace('\n', ' ');
      return super.parseMsg(body, data);
    }
    
    return false;
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL"))  return new MyCallField();
    if (name.equals("ADDR2"))  return new MyAddress2Field();
    if (name.equals("CITY")) return new MyCityField();
    if (name.equals("DATETIME")) return new MyDateTimeField();
    return super.getField(name);
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      field = stripFieldEnd(field, "/");
      super.parse(field, data);
    }
  }
  
  private class MyCityField extends CityField {
    @Override
    public void parse(String field, Data data) {
      if (field.equalsIgnoreCase("COUNTY")) return;
      super.parse(field, data);
    }
  }
  
  private static final Pattern ADDR_PTN = Pattern.compile("(\\d+)([^ ].*)");
  private class MyAddress2Field extends AddressField {
    @Override
    public void parse(String field, Data data) {
      
      // Extract city from end of field
      String city = CITY_LIST.getCode(field);
      if (city != null) {
        field = field.substring(0, field.length()-city.length()).trim();
        if (!city.equals("COUNTY")) data.strCity = city;
      }
      
      // Replace blank between house number and street name
      Matcher match = ADDR_PTN.matcher(field);
      if (match.matches()) field =  match.group(1) + ' ' + match.group(2);
      
      // parse address
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " CITY";
    }
  }
  
  private static final Pattern DATE_TIME_PTN = Pattern.compile("(\\d\\d?/\\d\\d?/\\d{4}) (\\d\\d?:\\d\\d:\\d\\d [AP]M)");
  private static final DateFormat TIME_FMT = new SimpleDateFormat("hh:mm:ss aa");
  private class MyDateTimeField extends DateTimeField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = DATE_TIME_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strDate = match.group(1);
      setTime(TIME_FMT, match.group(2), data);
    }
  }
  
  private static final ReverseCodeSet CITY_LIST = new ReverseCodeSet(
      
      "COUNTY",

      // Cities
      "MALVERN",
      "ROCKPORT",

      // Towns
      "DONALDSON",
      "FRIENDSHIP",
      "MAGNET COVE",
      "MIDWAY",
      "PERLA",

      //Unincorporated community
      "BISMARCK"
  );
}
