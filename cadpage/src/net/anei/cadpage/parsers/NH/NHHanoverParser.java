package net.anei.cadpage.parsers.NH;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class NHHanoverParser extends FieldProgramParser {
  
  public NHHanoverParser() {
    super(CITY_LIST, "HANOVER","NH",
           "CALL PLACE? ADDR/Z CITY! INFO? DATETIME/Z! END");
  }
  
  @Override
  public String getFilter() {
    return "DISPATCH@HANOVER.PD";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("_")) return false;
    String[] flds = body.split("\n");
    if (flds.length < 4 || flds.length > 6) return false;
    if (!parseFields(flds, data)) return false;
    if (data.strCity.equals("BRADFORD")) data.defState = "VT";
    return true;
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME")) return new DateTimeField("\\d{1,2}/\\d{1,2}/\\d{4} \\d\\d:\\d\\d", true);
    return super.getField(name);
  }
  
  private static final String[] CITY_LIST = new String[]{
    "BRADFORD",
    "HANOVER",
    "HAVERHILL"
  };
}
