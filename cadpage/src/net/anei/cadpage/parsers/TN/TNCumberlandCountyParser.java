package net.anei.cadpage.parsers.TN;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class TNCumberlandCountyParser extends FieldProgramParser {
  
  public TNCumberlandCountyParser() {
    super("CUMBERLAND COUNTY", "TN",
           "CALL ADDR INFO");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@911email.net";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("E911")) return false;
    return parseFields(body.split("\n"), 3, data);
  }
}
