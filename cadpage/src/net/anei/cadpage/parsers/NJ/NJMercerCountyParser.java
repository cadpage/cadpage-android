package net.anei.cadpage.parsers.NJ;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


/**
 * Mercer County, NJ
 */
public class NJMercerCountyParser extends FieldProgramParser {
  
  private static final Pattern RUN_REPORT_PTN = Pattern.compile("; Disp: ?\\d\\d:\\d\\d;");
  
  private static final Pattern UNIT_PTN = Pattern.compile("^UNIT: *([ A-Z0-9]+?) *; *", Pattern.CASE_INSENSITIVE);
  
  
  public NJMercerCountyParser() {
    super("MERCER COUNTY", "NJ",
           "CALL:CALL! PLACE:PLACE! ADDR:ADDR! BLDG:APT! APT:APT! CITY:CITY! XSTREETS:X ID:ID! DATE:DATE! TIME:TIME! INFO:INFO");
  }
  
  @Override
  public String getFilter() {
    return "noreply_lifecomm@verizon.net";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    if (RUN_REPORT_PTN.matcher(body).find()) {
      data.strCall = "RUN REPORT";
      data.strPlace = body;
      return true;
    }
    
    Matcher match = UNIT_PTN.matcher(body);
    if (!match.find()) return false;
    data.strUnit = match.group(1);
    body = body.substring(match.end());
    
    if (super.parseFields(body.split(";"), data)) return true;
    data.strCall = "GENERAL ALERT";
    data.strPlace = body;
    return true;
  }
  
  @Override
  public String getProgram() {
    return "UNIT " + super.getProgram();
  }
  
  private class MyTimeField extends TimeField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf('(');
      if (pt >= 0) field = field.substring(0,pt).trim();
      super.parse(field, data);
    }
  }
  
  private static final Pattern INFO_GPS_PTN = Pattern.compile("^Longitude: ([+-]\\d+\\.\\d+),Latitude: ([+-]\\d+\\.\\d+),");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = INFO_GPS_PTN.matcher(field);
      if (match.find()) {
        setGPSLoc(match.group(1) + ',' + match.group(2), data);
        field = field.substring(match.end()).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "GPS INFO";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("TIME")) return new MyTimeField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
}
