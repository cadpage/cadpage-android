package net.anei.cadpage.parsers.CT;


import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class CTBrookfieldParser extends FieldProgramParser {
  
  public CTBrookfieldParser() {
    super(CITY_LIST, "BROOKFIELD","CT",
          "CALL PLACE? ADDR/Z CITY/Y! District:MAP? DATETIME!");
  }
  
  @Override
  public String getFilter() {
    return "policedispatch@brookfieldct.gov";
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
  
  private static final String[] CITY_LIST = new String[]{
    "BROOKFIELD",
    "DANBURY"
  };
}
