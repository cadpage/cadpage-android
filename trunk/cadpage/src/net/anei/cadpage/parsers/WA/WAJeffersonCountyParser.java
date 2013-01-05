package net.anei.cadpage.parsers.WA;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class WAJeffersonCountyParser extends FieldProgramParser {
  
  public WAJeffersonCountyParser() {
    super("JEFFERSON COUNTY", "WA",
           "CALL UNIT PLACE ADDR CITY X DATETIME! NARRATIVE INFO+");
  }
  
  @Override
  public String getFilter() {
    return "messaging@iamresponding.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (subject.length() == 0) return false;
    data.strSource = subject;
    return parseFields(body.split(" : "), 7, data);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
  
  private class NarrativeField extends SkipField {
    @Override
    public void parse(String field, Data data) {
      if (!"Narrative".startsWith(field)) abort();
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("NARRATIVE")) return new NarrativeField();
    return super.getField(name);
  }
}
