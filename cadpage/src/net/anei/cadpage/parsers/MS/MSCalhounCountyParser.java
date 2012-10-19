package net.anei.cadpage.parsers.MS;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class MSCalhounCountyParser extends FieldProgramParser {

  public MSCalhounCountyParser() {
    super("CALHOUN COUNTY", "MS",
          "Call_Type:CALL! City:CITY! Address:ADDR!");
  }
  
  @Override
  public String getFilter() {
    return "cadalerts@eforcesoftware.com";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Dispatch Alert")) return false;
    return parseFields(body.split("\n"), 3, data);
  }
}
