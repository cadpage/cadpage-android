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
          "( Reported:DATETIME CALL! Loc:ADDRCITY! X/Z? SRC UNIT END | " +
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
  
  private class MyAddressCityField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(',');
      if (pt >= 0) {
        data.strCity = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
      }
      
      if (data.strCity.length() > 0) {
        parseAddress(field, data);
      } else {
        parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, field, data);
      }
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR APT CITY";
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
