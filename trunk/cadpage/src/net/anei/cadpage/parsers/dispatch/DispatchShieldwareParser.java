package net.anei.cadpage.parsers.dispatch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class DispatchShieldwareParser extends FieldProgramParser {
  
  public static final int FLG_NO_UNIT = 1;
  
  private static final Pattern CALL_PTN = Pattern.compile("^(\\d\\d-\\d{6}) +");
  
  protected DispatchShieldwareParser(String defCity, String defState) {
    this(defCity, defState, 0);
  }
  
  protected DispatchShieldwareParser(String defCity, String defState, int flags) {
    super(defCity, defState,
           (flags & FLG_NO_UNIT) == 0 ? "CALL DATETIME? ADDR X/Z? PLCITY! UNIT END"
                                      : "CALL DATETIME? ADDR X/Z? PLCITY! END");
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    Matcher match = CALL_PTN.matcher(body);
    if (!match.find()) return false;
    data.strCallId = match.group(1);
    body = body.substring(match.end());
    return parseFields(body.split("(?: *\n)+"), data);
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }
  
  private class MyDateTimeField extends DateTimeField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (!field.startsWith("Reported: ")) return false;
      return super.checkParse(field.substring(10).trim(), data);
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
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME")) return new MyDateTimeField();
    if (name.equals("PLCITY")) return new PlaceCityField();
    return super.getField(name);
    
  }
}
