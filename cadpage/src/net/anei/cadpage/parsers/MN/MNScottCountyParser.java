package net.anei.cadpage.parsers.MN;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class MNScottCountyParser extends FieldProgramParser {
  
  public MNScottCountyParser() {
    super("SCOTT COUNTY", "MN",
          "CALL:CALL! PLACE:PLACE? ADDR:ADDR! CITY:CITY! ID:ID! PRI:PRI!");
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    return parseFields(body.split(";"), data);
  }
}
