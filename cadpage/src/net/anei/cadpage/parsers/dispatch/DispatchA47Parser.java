package net.anei.cadpage.parsers.dispatch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class DispatchA47Parser extends FieldProgramParser {
  
  private String subjectMarker;
  
  public DispatchA47Parser(String[] cityList, String defCity, String defState) {
    this(null, cityList, defCity, defState);
  }
  
  public DispatchA47Parser(String subjectMarker, String[] cityList, String defCity, String defState) {
    super(cityList, defCity, defState,
          "( Reported:DATETIME! ID_CALL! Loc:ADDR/S! | ID_CALL! Reported:DATETIME? ADDR/S! ) ( UNIT END | X? PLACE? UNIT% END )");
    this.subjectMarker = subjectMarker;
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (subjectMarker != null && !subject.equals(subjectMarker)) return false;
    return parseFields(body.split("\n"), data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME")) return new DateTimeField("\\d\\d?/\\d\\d/\\d{4} \\d\\d?:\\d\\d:\\d\\d", true);
    if (name.equals("ID_CALL")) return new MyIdCallField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("PLACE")) return new MyPlaceField();
    return super.getField(name);
  }
  
  private static Pattern ID_CALL_PTN = Pattern.compile("(\\d\\d-\\d{6}) +(.*)");
  private class MyIdCallField extends Field {
    @Override
    public void parse(String field, Data data) {
      Matcher match = ID_CALL_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strCallId = match.group(1);
      data.strCall = match.group(2);
    }

    @Override
    public String getFieldNames() {
      return "ID CALL";
    }
  }
  
  private static final Pattern ADDR_CITY_PTN = Pattern.compile("(.*)(?:,| - )(.*)");
  private static final Pattern ST_ZIP_PTN = Pattern.compile("([A-Z]{2})(?: +(\\d{5}))?");
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      field = stripFieldEnd(field, ",");
      Matcher match = ADDR_CITY_PTN.matcher(field);
      String city = null;
      if (match.matches()) {
        field = match.group(1).trim();
        String tmp = match.group(2).trim();
        match = ST_ZIP_PTN.matcher(tmp);
        if (match.matches()) {
          String state = match.group(1);
          city = getOptGroup(match.group(2));
          data.strState = state;
        } else {
          city = tmp;
        }
      }
      super.parse(field, data);
      if (city != null && (data.strCity.length() == 0 || data.strCity.equalsIgnoreCase("COUNTY"))) data.strCity = city;
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " ST";
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public boolean checkParse(String field, Data data) {
      if (!field.contains("/")) return false;
      field = stripFieldStart(field, "/");
      field = stripFieldEnd(field, "/");
      super.parse(field, data);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
  }
  
  private class MyPlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      if (data.strCity.length() == 0) {
        parseAddress(StartType.START_OTHER, FLAG_ONLY_CITY | FLAG_ANCHOR_END, field, data);
        field = getStart();
      }
      super.parse(field, data);
    }
  }
}
