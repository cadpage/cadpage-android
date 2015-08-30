package net.anei.cadpage.parsers.AR;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class ARHotSpringCountyParser extends FieldProgramParser {
  
  public ARHotSpringCountyParser() {
    super("HOT SPRING COUNTY", "AR", 
          "CALL:CALL! PLACE:PLACE! ADDR:ADDR! CITY:CITY! DATE:DATETIME! INFO:INFO! INFO/N+");
  }
  
  @Override
  public String getFilter() {
    return "DISPATCH@HOTSPRINGDEM.ORG";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    return super.parseFields(body.split("\n"), data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CITY")) return new MyCityField();
    if (name.equals("DATETIME")) return new MyDateTimeField();
    return super.getField(name);
  }
  
  private class MyCityField extends CityField {
    @Override
    public void parse(String field, Data data) {
      if (field.equalsIgnoreCase("COUNTY")) return;
      super.parse(field, data);
    }
  }
  
  private static final Pattern DATE_TIME_PTN = Pattern.compile("(\\d\\d?/\\d\\d?/\\d{4}) (\\d\\d?:\\d\\d:\\d\\d [AP]M)");
  private static final DateFormat TIME_FMT = new SimpleDateFormat("hh:mm:ss aa");
  private class MyDateTimeField extends DateTimeField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = DATE_TIME_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strDate = match.group(1);
      setTime(TIME_FMT, match.group(2), data);
    }
  }
}
