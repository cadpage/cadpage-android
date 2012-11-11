package net.anei.cadpage.parsers.OR;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class ORKlamathCountyParser extends FieldProgramParser {
  
  private static Pattern KEYWORD_PTN = Pattern.compile("(?<=\n(?:EVENT #|PRIORITY|LOCATION|CITY|APT|PREMISE|COMMENT))");

  private static Properties CITY_CODES = buildCodeTable(new String[]{
      "KF", "KLAMATH FALLS"
  });
  
  public ORKlamathCountyParser() {
    super(CITY_CODES, "KLAMATH COUNTY", "OR",
           "DATEID! EVENT_#:IDUNIT! CALL! PRIORITY:PRI! LOCATION:ADDR! CITY:CITY! APT:APT! PREMISE:PLACE? COMMENT:INFO+");
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
  
  private class MyDateIdField extends SkipField {
    
    public MyDateIdField() {
      setPattern(Pattern.compile("\\d{1,2}/\\d{1,2}/\\d{4} \\d+"), true);
    }
  }
  
  private static final Pattern ID_UNIT_PTN = Pattern.compile("(\\d{10}) (.*)");
  private class MyIdUnitField extends Field {
    
    @Override
    public void parse(String field, Data data) {
      Matcher match = ID_UNIT_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strCallId = match.group(1).trim();
      data.strUnit =  match.group(2).trim();
    }
    
    @Override
    public String getFieldNames() {
      return "ID UNIT";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATEID")) return new MyDateIdField();
    if (name.equals("IDUNIT")) return new MyIdUnitField();
    return super.getField(name);
  }
}
