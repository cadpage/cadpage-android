package net.anei.cadpage.parsers.dispatch;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class DispatchA16Parser extends FieldProgramParser {
  
  private static final DateFormat DATE_TIME_FMT = new SimpleDateFormat("MM/dd/yyyy hh:mmaa");  
  
  public DispatchA16Parser(String[] cityList, String defCity, String defState) {
    super(cityList, defCity, defState,
          "CALL ( DATETIME2!  UNIT? PLACE? ADDR/Z! CITY | ( PLACENAME ADDR/Z CITY | ADDR/ZS CITY | PLACENAME? ADDR! ) INFO+? ( UNIT DATETIME1? | DATETIME1 ) ) INFO+");
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
  
  private static final Pattern CITY_ST_PTN = Pattern.compile("(.*), *([A-Z]{2})");
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
      Matcher match = CITY_ST_PTN.matcher(field);
      if (match.matches()) {
        super.parse(match.group(1).trim(), data);;
        data.strState = match.group(2);
        return true;
      }
      if (force) {
        super.parse(field, data);
        return true;
      } 
      
      return super.checkParse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "CITY ST";
    }
  }
}
