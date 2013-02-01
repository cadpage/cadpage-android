package net.anei.cadpage.parsers.ZSE;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class ZSESwedenParser extends FieldProgramParser {

  public ZSESwedenParser() {
    super("", "", CountryCode.SE,
          "ID CALL CALL CALL ADDR CITY SRC! PositionWGS84:GPS! END");
  }
  
  @Override
  public String getFilter() {
    return "3315,@zenit.sosalarm.se";
  }

  @Override
  public String getLocName() {
    return "Sweden";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_PREFER_GPS;
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!parseFields(body.split("\n"), 8, data)) return false;
    if (data.strCity.equals("-")) data.strCity = "";
    if (data.strPlace.equals(data.strCity)) data.strPlace = "";
    return true;
  };
  
  private static final Pattern APT_MARKER = Pattern.compile("(?: Nr(?= |\\d)|,) *(\\d+[A-Z]?\\b)? *(.*)$");
  private static final Pattern PROPERTY_MARKER = Pattern.compile("\\w+:.*");
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = APT_MARKER.matcher(field);
      if (match.find()) {
        field = field.substring(0,match.start()).trim();
        data.strApt = getOptGroup(match.group(1));
        String place = match.group(2);
        if (place.startsWith(";")) place = place.substring(1).trim();
        if (PROPERTY_MARKER.matcher(place).matches()) {
          data.strSupp = place;
        } else {
          data.strPlace = place;
        }
      }
      data.strAddress = field;
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR APT PLACE INFO";
    }
  }
  
  private static final Pattern GPS_PTN = Pattern.compile("La = (\\d+)(?:º| grader) ([\\d\\.,]+)'([NS]) +Lo = (\\d+)(?:º| grader) ([\\d\\.,]+)'([EW])");
  private class MyGPSField extends GPSField {
    @Override
    public void parse(String field, Data data) {
      if (field.length() == 0) return;
      Matcher match = GPS_PTN.matcher(field);
      if (!match.matches()) abort();
      
      String gpsLoc = (match.group(3).charAt(0) == 'S' ? "-" : "+") + match.group(1) + ' ' + match.group(2) + ' ' +
                      (match.group(6).charAt(0) == 'W' ? "-" : "+") + match.group(4) + ' ' + match.group(5);
      gpsLoc = gpsLoc.replace(',', '.');
      setGPSLoc(gpsLoc, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new IdField("\\d+");
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("GPS")) return new MyGPSField();
    return super.getField(name);
  }
}
