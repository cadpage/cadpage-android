package net.anei.cadpage.parsers.OR;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class ORKlamathCountyParser extends FieldProgramParser {
  
  private static Pattern KEYWORD_PTN = Pattern.compile("(?<=\n(?:UNITS|EVENT #|PRIORITY|LOCATION|CITY|APT|PREMISE|COMMENT))");

  private static Properties CITY_CODES = buildCodeTable(new String[]{
      "KF", "KLAMATH FALLS"
  });
  
  public ORKlamathCountyParser() {
    super(CITY_CODES, "KLAMATH COUNTY", "OR",
           "DATETIME! UNITS:UNIT? EVENT_#:IDUNIT! CALL! PRIORITY:PRI! LOCATION:ADDR! CITY:CITY! APT:APT! PREMISE:PLACE? COMMENT:INFO+");
  }
  
  @Override
  public String getFilter() {
    return "kc-911@kc911.us";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    body = KEYWORD_PTN.matcher(body).replaceAll(":");
    return parseFields(body.split("\n"), data);
  }
  
  private static final Pattern DATE_TIME_PTN = Pattern.compile("(\\d{1,2}/\\d{1,2}/\\d{4}) (\\d{4})");
  private class MyDateTimeField extends DateTimeField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = DATE_TIME_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strDate = match.group(1);
      String time = match.group(2);
      data.strTime = time.substring(0,2) + ':' + time.substring(2,4);
    }
  }
  
  private static final Pattern ID_SRC_PTN = Pattern.compile("(\\d{10}) (.*)");
  private class MyIdSourceField extends Field {
    
    @Override
    public void parse(String field, Data data) {
      Matcher match = ID_SRC_PTN.matcher(field);
      if (!match.matches()) abort();
      
      data.strCallId = match.group(1).trim();
      data.strSource =  match.group(2).trim();
    }
    
    @Override
    public String getFieldNames() {
      return "ID SRC";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME")) return new MyDateTimeField();
    if (name.equals("IDUNIT")) return new MyIdSourceField();
    return super.getField(name);
  }
}
