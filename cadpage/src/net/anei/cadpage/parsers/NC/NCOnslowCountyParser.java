package net.anei.cadpage.parsers.NC;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;



public class NCOnslowCountyParser extends DispatchOSSIParser {
  
  private static final Pattern CODE_PTN = Pattern.compile("\\d{1,2}[A-Z]\\d{1,2}[A-Z]?"); 
  
  private String selectValue;
  
  public NCOnslowCountyParser() {
    super("ONSLOW COUNTY", "NC",
           "ADDR ( SELECT/EMS UNIT+? CALL CODE | PLACE? CALL SRC UNIT2! )");
  }
  
  @Override
  public String getFilter() {
    return "CAD@onslowcountync.gov";
  }
  
  @Override
  protected boolean parseFields(String[] fields, Data data) {
    if (fields.length == 0) return false;
    selectValue = (CODE_PTN.matcher(fields[fields.length-1]).matches() ? "EMS" : "FIRE");
    return super.parseFields(fields, data);
  }

  @Override
  protected String getSelectValue() {
    return selectValue;
  }
  
  private class MyUnitField extends UnitField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("UNIT ")) field = field.substring(5).trim();
      data.strUnit = append(data.strUnit, "-", field);
    }
  }
  
  private class MyCodeField extends CodeField {
    public MyCodeField() {
      setPattern(CODE_PTN, true);
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("SRC")) return new SourceField("[A-Z]{1,2}FD", true);
    if (name.equals("UNIT")) return new MyUnitField();
    if (name.equals("CODE")) return new MyCodeField();
    if (name.equals("UNIT2")) return new UnitField("\\d{1,2}[A-Z]", true);
    return super.getField(name);
  }
}
