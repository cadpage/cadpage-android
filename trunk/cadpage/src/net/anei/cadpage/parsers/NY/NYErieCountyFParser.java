package net.anei.cadpage.parsers.NY;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class NYErieCountyFParser extends FieldProgramParser {
  
  public NYErieCountyFParser() {
    super(CITY_CODES, "ERIE COUNTY", "NY",
          "PRI CALL ADDR/S! CITY? INFO");
    setupProtectedNames("EAST AND WEST");
  }
  
  @Override
  public String getFilter() {
    return "@alert.erie.gov";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("IRM Message")) return false;
    if (!body.startsWith("*")) return false;
    body = body.substring(1).trim();
    body = body.replace("EAST & WEST", "EAST AND WEST");
    return parseFields(body.split("~",-1), 4, data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("PRI")) return new PriorityField("\\d", true);
    if (name.equals("CITY")) return new MyCityField();
    return super.getField(name);
  }
  
  private class MyCityField extends CityField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (!CITY_SET.contains(field)) return false;
      parse(field, data);
      return true;
    }
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "WSE", "WEST SENECA"
  });
  
  private static final Set<String> CITY_SET = new HashSet<String>();
  static {
    for (Object obj : CITY_CODES.values()) {
      CITY_SET.add((String)obj);
    }
  }
}
