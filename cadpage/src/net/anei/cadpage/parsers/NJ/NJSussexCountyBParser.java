package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Sussex County, NJ
 */
public class NJSussexCountyBParser extends FieldProgramParser {
  
  
  public NJSussexCountyBParser() {
    super("SUSSEX COUNTY", "NJ",
          "SRC CALL PAGED ADDR UNIT UNIT INFO+");
  }
  
  @Override
  public String getFilter() {
    return "paging@sussexcountysheriff.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    return parseFields(body.split("\n"), 6, data);
  }
  
  private class MyUnitField extends UnitField {
    @Override
    public void parse(String field, Data data) {
      data.strUnit = append(data.strUnit, " ", field);
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("SRC")) return new SourceField("[A-Z]+", true);
    if (name.equals("PAGED")) return new SkipField("PAGED", true);
    if (name.equals("UNIT")) return new MyUnitField();
    return super.getField(name);
  }
  
  
}
