package net.anei.cadpage.parsers.dispatch;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class DispatchA32Parser extends FieldProgramParser {
  
  public DispatchA32Parser(String[] cityList, String defCity, String defState) {
    super(cityList, defCity, defState,
          "CALL ( DATETIME2 District:MAP! NAME? ADDR/Z CITY_ST! | ( PLACE ADDR/Z CITY! | ADDR/Z CITY! | PLACE ADDR! INFO | ADDR! INFO ) District:MAP? INFO+? DATETIME! ) INFO+");
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Perform Page")) return false;
    return parseFields(body.split("\n"), data);
  }
  
  public Field getField(String name) {
    if (name.equals("DATETIME")) return new DateTimeField("\\d\\d?/\\d\\d?/\\d{4} +\\d\\d:\\d\\d");
    if (name.equals("DATETIME2")) return new MyDateTime2Field();
    if (name.equals("CITY_ST")) return new MyCityStateField();
    return super.getField(name);
  }
  
  private static final Pattern DATETIME2_PTN = Pattern.compile("(\\d\\d?/\\d\\d?/\\d{4}) +(\\d\\d?:\\d\\d[AP]M)");
  private static final DateFormat DATETIME2_FMT = new SimpleDateFormat("hh:mmaa");
  private class MyDateTime2Field extends DateTimeField {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      Matcher match = DATETIME2_PTN.matcher(field);
      if (!match.matches()) return false;
      data.strDate = match.group(1);
      setTime(DATETIME2_FMT, match.group(2), data);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
  }
  
  private static final Pattern CITY_ST_PTN = Pattern.compile("([A-Za-z ]+), +([A-Z]{2})");
  private class MyCityStateField extends Field {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      Matcher match = CITY_ST_PTN.matcher(field);
      if (!match.matches()) return false;
      data.strCity = match.group(1).trim();
      data.strState = match.group(2);
      return true;
    }

    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }

    @Override
    public String getFieldNames() {
      return "CITY ST";
    }
  }
}
