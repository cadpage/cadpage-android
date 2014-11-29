package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Harnett County, NC
 * 
 * Replaces NCHarnetCountyA
 */
public class NCHarnettCountyCParser extends FieldProgramParser {
  
  public NCHarnettCountyCParser() {
    super(NCHarnettCountyParser.CITY_LIST, "HARNETT COUNTY", "NC",
           "CITY/Y X X EMPTY EMPTY CALL! EMPTY EMPTY EMPTY UNIT%");
  }
  
  @Override
  public String getFilter() {
    return "cadpage@harnett.org";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    return parseFields(body.split("\n"), data);
  }
}
