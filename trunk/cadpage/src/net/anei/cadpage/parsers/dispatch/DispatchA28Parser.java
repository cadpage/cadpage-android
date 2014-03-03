package net.anei.cadpage.parsers.dispatch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class DispatchA28Parser extends FieldProgramParser {
  
  private static final Pattern CALL_ID_PATTERN = Pattern.compile("^\\d\\d-\\d{6} ");
  
  public DispatchA28Parser(String[] cityList, String defCity, String defState) {
    super(cityList, defCity, defState,
           "CALL! Reported:DATETIME! ADDR ( X PLACE! UNIT | CITY? UNIT! ) END");
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    Matcher match = CALL_ID_PATTERN.matcher(body);
    if (! match.find()) return false;
    
    data.strCallId = body.substring(0, match.end()-1);
    body = body.substring(match.end()).trim();
    
    // Calls come in two forms.  The easy one has nice line break delimiters
    String[] flds = body.split("\n");
    if (flds.length == 1) return oldParseMsg(body, data); 
    return parseFields(flds, data);
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }
  
  private class MyCrossField extends CrossField {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (!field.contains("/")) return false;
      parse(field, data);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      field = field.replace("//", "/");
      if (field.endsWith("/")) field = field.substring(0,field.length()-1).trim();
      super.parse(field, data);
    }
  }
  
  private class MyPlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      // Last token is the (possibly abbreviated) city
      int pt = field.lastIndexOf('@');
      if (pt < 0) pt = field.lastIndexOf('/');
      if (pt >= 0) {
        String city = field.substring(pt+1).trim();
        if (isCity(city)) {
          data.strCity = city;
          data.strPlace = field.substring(0,pt).trim();
          return;
        }
      }
      parseAddress(StartType.START_PLACE, FLAG_ONLY_CITY | FLAG_ANCHOR_END, field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "PLACE CITY";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME")) return new DateTimeField("\\d\\d/\\d\\d/\\d{4} \\d\\d:\\d\\d:\\d\\d", true);
    if (name.equals("X")) return new MyCrossField();
    if  (name.equals("PLACE")) return new MyPlaceField();
    return super.getField(name);
  }
  
  private boolean oldParseMsg(String body, Data data) {
    
    setFieldList("CALL DATE TIME ADDR X PLACE APT CITY UNIT");
    
    Matcher match = UNIT_PTN.matcher(body);
    if (match.find()) {
      data.strUnit = match.group().trim();
      body = body.substring(0,match.start());
    }
    
    // Sometimes there is a Reported: date/time between call and address
    // and sometimes there is not
    StartType st = StartType.START_CALL;
    int flags = FLAG_START_FLD_REQ;
    match = DATE_TIME_PTN.matcher(body);
    if (match.find()) {
      st = StartType.START_ADDR;
      flags = 0;
      data.strCall = body.substring(0,match.start());
      body = body.substring(match.end());
    }
    
    // Parse description and address, cross street and place name
    // There is always a trailing city, but we have to use differeng logic
    // if it is separated by a slash
    String left = null;
    int pt = body.lastIndexOf('/');
    if (pt >= 0) {
      String city = body.substring(pt+1).trim();
      if (isCity(city)) {
        data.strCity = city;
        body = body.substring(0,pt);
        parseAddress(st, flags | FLAG_CROSS_FOLLOWS | FLAG_NO_IMPLIED_APT, body, data);
        left = getLeft();
      }
    }
    
    // No slash delimited city found, use the space delimited city logic
    if (left == null) {
      parseAddress(st, flags | FLAG_CROSS_FOLLOWS | FLAG_NO_IMPLIED_APT | FLAG_PAD_FIELD | FLAG_ANCHOR_END, body, data);
      if (data.strCity.length() == 0) return false;
      left = getPadField();
    }
    
    pt = left.lastIndexOf('#');
    if (pt >= 0) {
      data.strApt = append(data.strApt, "-", left.substring(pt+1).trim());
      left = left.substring(0,pt).trim();
    }
    
    pt = left.indexOf('/');
    String cross = "";
    if (pt >= 0) {
      cross = left.substring(0,pt).trim();
      left = left.substring(pt+1).trim();
    }
    parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS, left, data);
    data.strCross = append(cross, " / ", data.strCross);
    data.strPlace = getLeft();
    if (data.strPlace.startsWith("/")) {
      data.strCross = append(data.strCross, " ", data.strPlace);
      data.strPlace = "";
    }
    
    if (data.strPlace.equals("EN") || data.strPlace.equals("ST")) data.strPlace = "";
    
    return true;
  }
  private static final Pattern UNIT_PTN = Pattern.compile("(?:[ /]+\\d[A-Z\\d]{2,3})+$");
  private static final Pattern DATE_TIME_PTN = Pattern.compile(" +Reported: *(\\d\\d/\\d\\d/\\d{4}) +(\\d\\d:\\d\\d:\\d\\d) +");
}
