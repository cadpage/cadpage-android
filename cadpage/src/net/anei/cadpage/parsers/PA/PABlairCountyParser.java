package net.anei.cadpage.parsers.PA;

import java.text.SimpleDateFormat;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class PABlairCountyParser extends FieldProgramParser {
  
  public PABlairCountyParser() {
    super("BLAIR COUNTY", "PA",
           "UNIT ADDRCITY DATETIME INFO");
  }
  
  @Override
  public String getFilter() {
    return "Blair Alerts";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (subject.length() == 0) return false;
    data.strCall = subject;
    return parseFields(body.split("\n"), data);
  }
  
  @Override
  public String getProgram() {
    return "CALL " + super.getProgram();
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME")) return new DateTimeField(new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa"));
    return super.getField(name);
  }
}
