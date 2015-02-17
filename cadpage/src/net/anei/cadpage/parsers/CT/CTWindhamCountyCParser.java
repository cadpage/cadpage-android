package net.anei.cadpage.parsers.CT;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class CTWindhamCountyCParser extends FieldProgramParser {

  public CTWindhamCountyCParser() {
    super("WINDHAM COUNTY", "CT",
          "CITY ADDR CALL X! INFO/N+");
  }
  
  @Override
  public String getFilter() {
    return "wpdpaging@gmail.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    return parseFields(body.split(" \\\\ "), data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("X")) return new MyCrossField();
    return super.getField(name);
  }
  
  private static final Pattern CROSS_PTN = Pattern.compile("\\(X-STS +(?:Map ([^ ]+) +)?(.*)\\)");
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = CROSS_PTN.matcher(field);
      if (!match.matches()) abort();
      String map = match.group(1);
      if (map != null && !map.equals("-1")) data.strMap = map;
      data.strCross = match.group(2).replace('\\', '/').replace(".", "").trim();
    }
    
    @Override
    public String getFieldNames() {
      return "MAP X";
    }
  }
  
  @Override
  public String adjustMapCity(String city) {
    if (city.equalsIgnoreCase("WINDHAM CENTER")) city = "WINDHAM";
    return city;
  }
}
