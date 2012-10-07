package net.anei.cadpage.parsers.GA;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class GAHenryCountyParser extends FieldProgramParser {
  
  public GAHenryCountyParser() {
    super("HENRY COUNTY", "GA",
           "CALL! ADDR! INFO+? UNIT TIME");
  }
  
  @Override
  public String getFilter() {
    return "93001";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    return parseFields(body.split("/"), data);
  }
  
  private class MyAddressField extends AddressField{
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith(" INTERSECTN")) field = field.substring(0, field.length()-11).trim();
      super.parse(field, data);
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      data.strSupp = append(data.strSupp, "/", field);
    }
  }
  
  private class TimeField extends SkipField {
    public TimeField() {
      setPattern(Pattern.compile("\\d\\d:\\d\\d:\\d\\d"), true);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("INFO")) return new MyInfoField();
    if (name.equals("TIME")) return new TimeField();
    return super.getField(name);
  }
}
