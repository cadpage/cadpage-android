package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class OHWayneCountyDParser extends FieldProgramParser {
  
  public OHWayneCountyDParser() {
    super("WAYNE COUNTY", "OH", 
          "CALL:CALL! PLACE:PLACE! ADDR:ADDR! CITY:CITY! ID:ID! UNIT:UNIT! INFO:INFO! INFO/N+");
  }
  
  @Override
  public String getFilter() {
    return "info@sundance-sys.com";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("From: WarCOGUser")) return false;
    return parseFields(body.split("\n"), data);
  }

}
