package net.anei.cadpage.parsers.dispatch;

import java.util.Properties;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class DispatchCiscoParser extends FieldProgramParser {
  
  public DispatchCiscoParser(String defCity, String defState) {
    this(null, defCity, defState);
  }
  
  public DispatchCiscoParser(Properties cityCodes, String defCity, String defState) {
    super(cityCodes, defCity, defState,
           "Ct:CALL! Loc:ADDR/S! Apt:APT XSt:X? Grid:MAP Units:UNIT Rmk:INFO");
  }
  
  private class MyUnitField extends UnitField {
    @Override 
    public void parse(String field, Data data) {
      super.parse(field.replaceAll(" +", " "), data);
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      super.parse(field.replaceAll("  +", " & "), data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("UNIT")) return new MyUnitField();
    if (name.equals("X")) return new MyCrossField();
    return super.getField(name);
  }
}
