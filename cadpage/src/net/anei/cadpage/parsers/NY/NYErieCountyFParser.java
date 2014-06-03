package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class NYErieCountyFParser extends FieldProgramParser {
  
  public NYErieCountyFParser() {
    super("ERIE COUNTY", "NY",
          "PRI CALL ADDR CITY! INFO");
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
    return parseFields(body.split("~"), 4, data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("PRI")) return new PriorityField("\\d", true);
    return super.getField(name);
  }
}
