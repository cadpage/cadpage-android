package net.anei.cadpage.parsers.dispatch;


import java.text.DateFormat;
import java.text.SimpleDateFormat;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class DispatchA16Parser extends FieldProgramParser {
  
  private static final DateFormat DATE_TIME_FMT = new SimpleDateFormat("MM/dd/yyyy hh:mmaa");  
  
  public DispatchA16Parser(String[] cityList, String defCity, String defState) {
    super(cityList, defCity, defState,
          "CALL ( DATETIME2!  UNIT? PLACE? ADDR/ZS! CITY | PLACENAME? ADDR/S! CITY? INFO+? ( UNIT DATETIME1? | DATETIME1 ) INFO+ )");
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Imc Solutions Page")) return false;
    return parseFields(body.split("\n"), 4, data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME1")) return new DateTimeField("\\d\\d?/\\d\\d?/\\d{4} \\d{2}:\\d{2}", true);
    if (name.equals("DATETIME2")) return new DateTimeField("\\d\\d?/\\d\\d?/\\d{4} \\d\\d?:\\d\\d[AP]M", DATE_TIME_FMT, true);
    if (name.equals("UNIT")) return new UnitField("(?:Fire )?District: *(.*)");
    if (name.equals("CITY")) return new MyCityField();
    return super.getField(name);
  }
  
  private class MyCityField extends CityField {
    @Override
    public boolean checkParse(String field, Data data) {
      return doParse(field, data, false);
    }
    
    @Override
    public void parse(String field, Data data) {
      doParse(field, data, true);
    }
    
    public boolean doParse(String field, Data data, boolean force) {
      String state = null;
      int pt = field.indexOf(',');
      if (pt >= 0) {
        state = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
      }
      if (force) {
        super.parse(field, data);
      } else {
        if (!super.checkParse(field, data)) return false;
      }
      if (state != null) data.strState = state;
      return true;
    }
    
    @Override
    public String getFieldNames() {
      return "CITY ST";
    }
  }
}
