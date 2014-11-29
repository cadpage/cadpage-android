package net.anei.cadpage.parsers.dispatch;

import java.util.Properties;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Cuyahoga County, OH
 */
public class DispatchA39Parser extends FieldProgramParser {

  private static final String PROGRAM_STR = "( ADDR CALLINFO | CALL ADDR/iS5XXa! ) INFO+";

  public DispatchA39Parser(Properties cityCodes, String defCity, String defState) {
    super(cityCodes, defCity, defState, PROGRAM_STR);
  }

  public DispatchA39Parser(String[] cityList, String defCity, String defState) {
    super(cityList, defCity, defState, PROGRAM_STR);
  }

  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Dispatch Message")) return false;
    return parseFields(body.split("\n"), 2, data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALLINFO")) return new BaseCallInfoField();
    return super.getField(name);
  }
  
  private class BaseCallInfoField extends CallField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(',');
      if (pt >= 0) {
        data.strSupp = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "CALL INFO";
    }
  }
}
