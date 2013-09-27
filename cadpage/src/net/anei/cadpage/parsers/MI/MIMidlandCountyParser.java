package net.anei.cadpage.parsers.MI;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class MIMidlandCountyParser extends FieldProgramParser {
  
  private static final Pattern MARKER = Pattern.compile("CAD Page for CFS ([-A-Z0-9]+)(?:[ ,]+(.*))?", Pattern.DOTALL);
  
  public MIMidlandCountyParser() {
    super("MIDLAND COUNTY", "MI",
           "BUS:PLACE! ADDX:ADDR! APT:APT! CODE:CALL! http:GPS");
  }
  
  @Override
  public String getFilter() {
    return "@midland911.org";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    Matcher match = MARKER.matcher(subject);
    if (match.matches()) {
      data.strCallId = match.group(1);
    } else {
      match = MARKER.matcher(body);
      if (!match.matches()) return false;
      data.strCallId = match.group(1);
      body = match.group(2);
      if (body == null) return false;
    }
    
    body = body.replace(" APT:", "\nAPT:");
    return parseFields(body.split("\n"), data);
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }
  
  private static final Pattern GPS_PTN = Pattern.compile("//maps.google.com/maps\\?q=([+-]\\d+\\.\\d{5})(?: +|%20)([+-]\\d+\\.\\d{5})");
  private class MyGPSField extends GPSField {
    public void parse(String field, Data data) {
      Matcher match = GPS_PTN.matcher(field);
      if (!match.matches()) return;
      setGPSLoc(match.group(1) + ',' + match.group(2), data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("GPS")) return new MyGPSField();
    return super.getField(name);
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_PREFER_GPS;
  }
}
