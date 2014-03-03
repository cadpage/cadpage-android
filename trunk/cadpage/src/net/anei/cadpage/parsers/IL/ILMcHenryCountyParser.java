package net.anei.cadpage.parsers.IL;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class ILMcHenryCountyParser extends FieldProgramParser {
  
  public ILMcHenryCountyParser() {
    super("MCHENRY COUNTY", "IL",
           "OCA:ID? Type:CALL! OCA:ID? Date:DATETIME! Loca:ADDR! Apt:APT? City:CITY! Cros:X INFO+");
  }
  
  @Override
  public String getFilter() {
    return "DoNotReply@mcetsb.org";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.endsWith(" Dispatch")) return false;
    data.strSource = subject.substring(0,subject.length()-9).trim();
    if (!body.startsWith("#\n")) return false;
    body = body.substring(2).trim();
    return parseFields(body.split("\n"), data);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME")) return new DateTimeField("\\d\\d?/\\d\\d?/\\d{4} \\d\\d:\\d\\d:\\d\\d", true);
    return super.getField(name);
    
  }
}
