package net.anei.cadpage.parsers.dispatch;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;

import net.anei.cadpage.parsers.MsgInfo.Data;

public class DispatchA16Parser extends FieldProgramParser {
  
  public DispatchA16Parser(String[] cityList, String defCity, String defState) {
    super(cityList, defCity, defState,
          "CALL PLACENAME? ADDR/S! CITY? INFO+");
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Imc Solutions Page")) return false;
    body = body.replace("\nFire District:", "\nDistrict:");
    return parseFields(body.split("\n"), 4, data);
  }
  
  private static final Pattern INFO_DATE_TIME_PTN = Pattern.compile("(\\d\\d?/\\d\\d?/\\d{4}) +(\\d\\d:\\d\\d)");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("District:")) {
        data.strUnit = append(data.strUnit, " ", field.substring(9).trim());
        return;
      }
      
      Matcher match = INFO_DATE_TIME_PTN.matcher(field);
      if (match.matches()) {
        data.strDate = match.group(1);
        data.strTime = match.group(2);
        return;
      }
      
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "INFO UNIT DATE TIME";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
}
