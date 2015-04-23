package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class OHFairfieldCountyParser extends FieldProgramParser {

  public OHFairfieldCountyParser() {
    super("FAIRFIELD COUNTY", "OH",
          "CALL ADDR CITY ST? X! INFO/CS+");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@co.fairfield.oh.us";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (body.endsWith(",")) body += ' ';
    return parseFields(body.split(", "), data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new CallField(".* \\([EF]\\)", true);
    if (name.equals("ST")) return new StateField("([A-Z]{2})(?: +\\d{5})?", true);
    if (name.equals("X")) return new MyCrossField();
    return super.getField(name);
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      if (!field.contains("//")) abort();
      field = field.replace("//", "/");
      field = stripFieldStart(field, "/");
      field = stripFieldEnd(field, "/");
      super.parse(field, data);
    }
  }
}
