package net.anei.cadpage.parsers.dispatch;


import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class DispatchA32Parser extends FieldProgramParser {
  
  public DispatchA32Parser(String[] cityList, String defCity, String defState) {
    super(cityList, defCity, defState,
          "CALL ( PLACE ADDR/Z CITY! | ADDR/Z CITY! | PLACE ADDR! INFO | ADDR! INFO ) District:MAP? DATETIME! INFO+");
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Perform Page")) return false;
    return parseFields(body.split("\n"), data);
  }
  
  public Field getField(String name) {
    if (name.equals("DATETIME")) return new DateTimeField("\\d\\d?/\\d\\d?/\\d{4} +\\d\\d:\\d\\d");
    return super.getField(name);
  }
}
