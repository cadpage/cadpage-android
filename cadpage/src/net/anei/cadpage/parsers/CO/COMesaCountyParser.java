package net.anei.cadpage.parsers.CO;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class COMesaCountyParser extends FieldProgramParser {
  
  public COMesaCountyParser() {
    super("MESA COUNTY", "CO",
          "ID Call_Type:CALL! Location:ADDR/SXx! Apt/Unit:APT? Lat/Long:GPS? Closest_Intersection:X? Call_Time:DATETIME! Narrative:INFO");
  }
  
  @Override
  public String getFilter() {
    return "Dispatch@ci.grandjct.co.us";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Dispatch")) return false;
    return super.parseMsg(body, data);
  }

  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new IdField("\\d{4}-\\d{8}", true);
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("DATETIME")) return new DateTimeField("\\d\\d/\\d\\d/\\d\\d \\d\\d:\\d\\d", true);
    return super.getField(name);
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace("UNKNOWN", "").trim();
      field = stripFieldStart(field, "/");
      field = stripFieldEnd(field, "/");
      super.parse(field, data);
    }
  }
  
}
