package net.anei.cadpage.parsers.PA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class PABlairCountyParser extends FieldProgramParser {
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "DUNCANSVI",  "DUNCANSVILLE",
      "SNYDER TW",  "SNYDER TWP",
      "TAYLOR TW",  "TAYLOR TWP",
      "TYRONE BO",  "TYRONE"
  });
  
  public PABlairCountyParser() {
    super(CITY_CODES, "BLAIR COUNTY", "PA",
           "Inc:CALL! Add:ADDR! City:CITY! Units:UNIT! ( Agency:SRC Map:GPS2 | Lat/Lon:GPS DR_#:ID )");
  }
  
  @Override
  public String getFilter() {
    return "28403,alerts@blairalerts.com";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    body = body.replace('\n', ' ');
    return super.parseMsg(body, data);
  }
  
  private static final Pattern DATE_MARK = Pattern.compile(" \\d");
  private class MyGPSField extends GPSField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = DATE_MARK.matcher(field);
      if (match.find()) field = field.substring(0,match.start()).trim();
      super.parse(field, data);
    }
  }
  
  private static final Pattern MAP_URL = Pattern.compile("http://maps.google.com/maps\\?q=([-+][\\d\\.]+)%20([-+][\\d\\.]+)");
  private class MyGPS2Field extends GPSField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = MAP_URL.matcher(field);
      if (match.find()) {
        super.parse(match.group(1) + "," + match.group(2), data);
      }
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("GPS")) return new MyGPSField();
    if (name.equals("GPS2")) return new MyGPS2Field();
    return super.getField(name);
  }
}
