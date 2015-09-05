package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class TXOvertonParser extends FieldProgramParser {
  
  public TXOvertonParser() {
    super("OVERTON", "TX", 
          "EVENT:ID! TIME:DATETIME! TYPE:CALL! LOC:ADDR! TXT:INFO! INFO/N+");
  }
  
  @Override
  public String getFilter() {
    return "overtonpd@ci.overton.tx.us";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("CAD")) return false;
    return parseFields(body.split("\n"), data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new IdField("\\d{4}", true);
    if (name.equals("DATETIME")) return new DateTimeField("\\d\\d/\\d\\d/\\d{4} \\d\\d:\\d\\d:\\d\\d", true);
    return super.getField(name);
  }

}
