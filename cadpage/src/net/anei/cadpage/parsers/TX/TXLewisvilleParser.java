package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class TXLewisvilleParser extends FieldProgramParser {
  
  public TXLewisvilleParser() {
    super("LEWISVILLE", "TX",
        "ID ADDR CALL UNIT");
  }
  
  public String getFilter() {
    return "6245,lpd@[10.10.1.64]";
  }
  
  public boolean parseMsg(String body, Data data) {
    String[] flds = body.split("\\*+");
    if (flds.length < 4) return false;
    return parseFields(flds, data);
  }
}
