package net.anei.cadpage.parsers.OR;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class ORDouglasCountyParser extends FieldProgramParser {
  
  public ORDouglasCountyParser() {
    super(CITY_CODES,"DOUGLAS COUNTY", "OR",
          "DATETIME CALL ADDR CITY_APT/Y PLACE INFO!");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@co.douglas.or.us";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    return parseFields(body.split("\n"), data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME")) return new MyDateTimeField();
    if (name.equals("CITY_APT")) return new MyCityAptField();
    return super.getField(name);
  }
  
  private static final Pattern DATE_TIME_PTN = Pattern.compile("(\\d\\d?/\\d\\d?/\\d{4}) (\\d\\d)(\\d\\d)");
  private class MyDateTimeField extends DateTimeField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = DATE_TIME_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strDate = match.group(1);
      data.strTime = match.group(2) + ':' + match.group(3);
    }
  }
  
  private static final Pattern CITY_APT_PTN = Pattern.compile("([A-Z]{2}) #(.*)");
  private class MyCityAptField extends CityField {
    @Override
    public boolean checkParse(String field, Data data) {
      Matcher match = CITY_APT_PTN.matcher(field);
      if (!match.matches()) return false;
      super.parse(match.group(1), data);
      data.strApt = append(data.strApt, "-", match.group(2).trim());
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
    
    @Override
    public String getFieldNames() {
      return "CITY APT";
    }
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "CU", "CURTIN",
      "DR", "DRAIN",
      "EL", "ELKTON",
      "OK", "OAKLAND",
      "YN", "YONCALLA"
  });
}
