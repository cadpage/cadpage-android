package net.anei.cadpage.parsers.dispatch;

import java.util.Properties;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class DispatchCiscoParser extends FieldProgramParser {
  
  public DispatchCiscoParser(String defCity, String defState) {
    this((String[])null, defCity, defState);
  }
  
  public DispatchCiscoParser(Properties cityCodes, String defCity, String defState) {
    super(cityCodes, defCity, defState, PROGRAM_STR);
  }
  
  public DispatchCiscoParser(String[] cityList, String defCity, String defState) {
    super(cityList, defCity, defState, PROGRAM_STR);
  }
  private static final String PROGRAM_STR = "Ct:CALL! Loc:ADDR/S! Apt:APT XSt:X? Grid:MAP Units:UNIT Rmk:INFO";

  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (subject.length() > 0 && !body.startsWith("Ct:")) {
      body = "Ct: " + subject + ' ' + body;
    }
    return super.parseMsg(body, data);
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
