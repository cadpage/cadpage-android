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
    return parseFields(body.split("\n"), 8, data);
  };
  
  private static final Pattern APT_MARKER = Pattern.compile(" Nr(?= |\\d)");
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      data.strAddress = p.get(APT_MARKER);
      data.strApt = p.get(' ');
      data.strPlace = p.get();
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR APT PLACE";
    }
  }
  
  private static final Pattern GPS_PTN = Pattern.compile("La = (\\d+)(?:Âº| grader) ([\\d\\.,]+)'([NS]) +Lo = (\\d+)(?:Âº| grader) ([\\d\\.,]+)'([EW])");
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
