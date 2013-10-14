package net.anei.cadpage.parsers.dispatch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class DispatchShieldwareParser extends FieldProgramParser {
  
  public static final int FLG_NO_UNIT = 1;
  
  protected DispatchShieldwareParser(String defCity, String defState) {
    this(null, defCity, defState, 0);
  }
  
  protected DispatchShieldwareParser(String defCity, String defState, int flags) {
    this(null, defCity, defState, flags);
  }
  
  protected DispatchShieldwareParser(String[] cityList, String defCity, String defState) {
    this(cityList, defCity, defState, 0);
  }
  
  protected DispatchShieldwareParser(String[] cityList, String defCity, String defState, int flags) {
    super(cityList, defCity, defState,
          "( Reported:DATETIME CALL! Loc:ADDRCITY! X/Z PLACE? UNIT% INFO+ | " +
          "CALL Reported:DATETIME? ADDR! X/Z? PLCITY! " +
          ((flags & FLG_NO_UNIT) == 0 ? "UNIT " : "") +
          "END )");
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    return parseFields(body.split("(?: *\n)+"), data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ADDRCITY")) return new MyAddressCityField();
    if (name.equals("PLACE")) return new MyPlaceField();
    if (name.equals("PLCITY")) return new PlaceCityField();
    return super.getField(name);
  }
  
  private static final Pattern CALL_PTN = Pattern.compile("^(\\d\\d-\\d{6}) +");
  private class MyCallField extends CallField {
    @Override
    public boolean canFail() {
      return true;
    }
  
    @Override
    public boolean checkParse(String field, Data data) {
      Matcher match = CALL_PTN.matcher(field);
      if (!match.find()) return false;
      data.strCallId = match.group(1);
      field = field.substring(match.end()).trim();
      super.parse(field, data);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
    
    @Override
    public String getFieldNames() {
      return "ID CALL";
    }
  }
  
  private static final Pattern ADDR_ST_ZIP_PTN = Pattern.compile("([A-Z]{2})( +(\\d{5}))?");
  private class MyAddressCityField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      String city = null;
      if (field.endsWith(",")) field = field.substring(0,field.length()-1).trim();
      int pt = field.indexOf(',');
      if (pt >= 0) {
        city = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
        Matcher match = ADDR_ST_ZIP_PTN.matcher(city);
        if (match.matches()) {
          data.strState = match.group(1);
          if (data.strState.equals(data.defState)) data.strState = "";
          city = match.group(2);
        } else {
          data.strCity = city;
        }
      }
      
      // If we did not find a city, see if there is a slash delimited city
      if (data.strCity.length() == 0) {
        pt = field.lastIndexOf('/');
        if (pt >= 0) {
          city = field.substring(pt+1).trim();
          if (isCity(city)) {
            data.strCity = city;
            field = field.substring(0,pt).trim();
          }
        }
      }
      
      if (data.strCity.length() > 0) {
        parseAddress(field, data);
      } else {
        parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, field, data);
        if (data.strCity.length() == 0 && city != null) data.strCity = city;
      }
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR APT CITY ST";
    }
  }
  
  private static final Pattern PLACE_UNIT_PTN =  Pattern.compile("[A-Z0-9]{1,4}(?: [A-Z0-9]{1,4})+");
  private class MyPlaceField extends PlaceField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override 
    public boolean checkParse(String field, Data data) {
      // If it looks like a unit field, it shouldn't be a place field
      if (PLACE_UNIT_PTN.matcher(field).matches()) return false;
      parse(field, data);
      return true;
    }
  }
  
  private class PlaceCityField extends Field {
    
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      data.strCity = p.getLast("  ");
      data.strPlace = p.get();
    }
    
    @Override
    public String getFieldNames() {
      return "PLACE CITY";
    }
  }
}
