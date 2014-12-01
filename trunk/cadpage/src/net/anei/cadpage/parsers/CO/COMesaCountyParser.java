package net.anei.cadpage.parsers.CO;

import net.anei.cadpage.parsers.FieldProgramParser;


public class COMesaCountyParser extends FieldProgramParser {
  
  public COMesaCountyParser() {
    super("MESA COUNTY", "CO",
          "ID! Call_Type:CALL! Location:ADDR/SXx! Call_Time:DATETIME! Narrative:INFO");
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new IdField("\\d{4}-\\d{8}", true);
    if (name.equals("DATETIME")) return new DateTimeField("\\d\\d/\\d\\d/\\d\\d \\d\\d:\\d\\d", true);
    return super.getField(name);
  }
}
