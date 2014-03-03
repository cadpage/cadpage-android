package net.anei.cadpage.parsers.NJ;

import java.text.SimpleDateFormat;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class NJPassaicCountyParser extends FieldProgramParser {

  public NJPassaicCountyParser() {
    super("PASSAIC COUNTY", "NJ", "ID! DATETIME! CALL! ADDRCITY! INFO+");
  }
  
  @Override protected boolean parseMsg(String subject, String body, Data data) {
    boolean success = parseFields(body.split("\n"), data);
    if (subject.length() > 0 && success) data.strCall = append(data.strCall, " / ", subject);
    return success;
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new IdField("\\d{2}-\\d{5}");
    if (name.equals("DATETIME")) return new DateTimeField(new SimpleDateFormat("M/d/yyyy h:mm:ss a"));
    return super.getField(name);
  }
 
}
