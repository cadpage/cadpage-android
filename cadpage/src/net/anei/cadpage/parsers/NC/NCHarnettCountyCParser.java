package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Harnett County, NC
 * 
 * Replaces NCHarnetCountyA
 */
public class NCHarnettCountyCParser extends FieldProgramParser {
  
  String select;
  
  public NCHarnettCountyCParser() {
    super(NCHarnettCountyParser.CITY_LIST, "HARNETT COUNTY", "NC",
           "( SELECT/DASHFMT ID ADDR APT+? CITY/Y X/Z+? EMPTY EMPTY+? CALL EMPTY+? UNIT " +
           "| CITY/Y X X EMPTY EMPTY CALL! EMPTY EMPTY EMPTY UNIT% INFO+ " +
           "| ID ADDR EMPTY+? CITY/Y X/Z+? ( EMPTY EMPTY+? CALL UNIT END | CALL UNIT! END ) )");
  
  }
  
  @Override
  public String getFilter() {
    return "cadpage@harnett.org";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    select = "";
    String[] flds = body.split("\n");
    if (flds.length == 1) {
      select = "DASHFMT";
      if (body.endsWith("-")) body += ' ';
      flds = body.split(" - ");
    }
    return parseFields(flds, data);
  }
  
  
  
  @Override
  protected String getSelectValue() {
    return select;
  }

  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new IdField("\\d{4}-\\d{6}", true);
    return super.getField(name);
  }
}
