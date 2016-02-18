package net.anei.cadpage.parsers.PA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class PAColumbiaCountyBParser extends FieldProgramParser {
  
  public PAColumbiaCountyBParser() {
    super(CITY_CODES, "COLUMBIA COUNTY", "PA", 
          "( DATETIME1! Inc_Addr:ADDRCITY! Apt:APT! Cross_Streets:X1! GPS! Inc_Code:CALL! SubType:CALL/SDS! Dispatch_Time:DATETIME Responding_Unit(s):EMPTY! UNIT! CFS#:ID! DR_ID+? " + 
          "| DR_ID+? ADDRCITY GPS CALL! Disp_Time:DATETIME! Responding_Unit(s):EMPTY! UNIT! ) Comments:INFO/N+");
    setupProtectedNames("TWO AND ONE HALF");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@columbiapa.org";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_PREFER_GPS;
  }
  
  private static final Pattern SUBJECT_PTN = Pattern.compile("CAD Page for CFS (\\d{6}-\\d{1,2})");
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    Matcher match = SUBJECT_PTN.matcher(subject);
    if (!match.matches()) return false;
    data.strCallId = match.group(1);
    
    if (!parseFields(body.split("\n"), data)) return false;
    
    data.strCity = stripFieldEnd(data.strCity, " B");
    if (data.strCity.endsWith(" T")) data.strCity += "WP";
    return true;
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME1")) return new SkipField("[A-Z][a-z]{2} [A-Z][a-z]{2} \\d\\d \\d{4} \\d\\d:\\d\\d", true);
    if (name.equals("X1")) return new MyCrossField();
    if (name.equals("GPS")) return new MyGPSField();
    if (name.equals("DATETIME")) return new DateTimeField("\\d\\d/\\d\\d/\\d\\d \\d\\d:\\d\\d:\\d\\d", true);
    if (name.equals("DR_ID")) return new SkipField("DR#:.*", true);
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }

  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace(" * ", " / ");
      super.parse(field, data);
    }
  }
  
  private static final Pattern GPS_PTN = Pattern.compile("http://maps.google.com/maps\\?q=(.*?)%20(.*?)");
  private class MyGPSField extends GPSField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = GPS_PTN.matcher(field);
      if (!match.matches()) return;
      setGPSLoc(match.group(1)+','+match.group(2), data);
    }
  }
  
  private static final Pattern INFO_JUNK_PTN = Pattern.compile("\\[\\d\\d:\\d\\d:\\d\\d [A-Za-z ]+\\] *");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = INFO_JUNK_PTN.matcher(field);
      if (match.lookingAt()) field = field.substring(match.end());
      super.parse(field, data);
    }
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "GRW TWP", "GREENWOOD TWP"
  });

}
