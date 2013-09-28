package net.anei.cadpage.parsers.UT;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class UTSaltLakeCountyParser extends FieldProgramParser {

  public UTSaltLakeCountyParser() {
    super("SALT LAKE COUNTY", "UT", "ID! DATETIME! CALL! PLACE? ADDR/Z X/Z SRC!");
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    int pi = subject.indexOf("ALERT -");
    if (pi >= 0) data.strUnit = subject.substring(pi + 8);
    else return false;

    return parseFields(body.split("\n"), data);
  }

  @Override
  public String getProgram() {
    return "UNIT " + super.getProgram();
  }

  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new IdField("[A-Z]{2,3}\\d+", true);
    if (name.equals("DATETIME")) return new DateTimeField("\\d{2}/\\d{2}/\\d{4} \\d{2}:\\d{2}:\\d{2}", true);
    if (name.equals("SRC")) return new SourceField("CF", true);
    return super.getField(name);
  }

}