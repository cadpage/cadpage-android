package net.anei.cadpage.parsers.OR;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class ORJacksonCountyParser extends FieldProgramParser {
  
  private static final Pattern SRC_DATE_TIME_PTN = Pattern.compile(" - From +([A-Z0-9]+) +(\\d\\d/\\d\\d/\\d{4}) +(\\d\\d:\\d\\d:\\d\\d)$");
  
  public ORJacksonCountyParser() {
    super(CITY_CODES, "JACKSON COUNTY", "OR",
          "CODE CALL ADDR CITY! PRI:PRI! Unit:UNIT! UNIT+");
  }
  
  @Override
  public String getFilter() {
    return "Messaging@ecso911.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (! subject.equals("CAD Page")) return false;
    if (!body.startsWith("DISPATCH:")) return false;
    body = body.substring(9).trim();
    
    Matcher match = SRC_DATE_TIME_PTN.matcher(body);
    if (!match.find()) return false;
    data.strSource = match.group(1);
    data.strDate = match.group(2);
    data.strTime = match.group(3);
    body = body.substring(0,match.start()).trim();
    
    body = body.replace("Units:", "Unit:");
    return parseFields(body.split(","), 6, data);
  }
  
  @Override
  public String getProgram() {
    return super.getProgram() + " SRC DATE TIME";
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      parseAddress(p.get('['), data);
      data.strCity = p.get(']');
    }
  }
  
  private class MyUnitField extends UnitField {
    @Override
    public void parse(String field, Data data) {
      data.strUnit = append(data.strUnit, ",", field);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("UNIT")) return new MyUnitField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "AS", "ASHLAND",
      "MF", "MEDFORD",
      "PH", "PHOENIX",
      "TA", "TALENT"
  });
}
