package net.anei.cadpage.parsers.NJ;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA24Parser;


/**
 * Mercer County, NJ
 */
public class NJMercerCountyAParser extends DispatchA24Parser {
  
  public NJMercerCountyAParser() {
    super("MERCER COUNTY", "NJ");
  }
  
  @Override
  public String getFilter() {
    return "noreply_lifecomm@verizon.net";
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
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }

}
