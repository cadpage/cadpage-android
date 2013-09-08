package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class VABedfordCountyParser extends FieldProgramParser {
  
  public VABedfordCountyParser() {
    super(CITY_LIST, "BEDFORD COUNTY", "VA",
           "CALL#:ID! LOC:ADDR/S! COMP:CALL!");
  }
  
  @Override
  public String getFilter() {
    return "Bedford";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (!body.startsWith("Bedford911:")) return false;
    body = body.substring(11).trim();
    body = body.replace('\n', ' ');
    return super.parseMsg(body, data);
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("ID")) return new IdField("\\**(\\d+)\\**", true);
    return super.getField(name);
  }
  
  private static final String[] CITY_LIST = new String[]{
    "BEDFORD",
    "LYNCHBURG",
    "BIG ISLAND",
    "CHAMBLISSBURG",
    "FOREST",
    "GOODE",
    "HARDY",
    "HUDDLESTON",
    "MONETA",
    "MONTVALE",
    "NEW LONDON",
    "STEWARTSVILLE",
    "THAXTON"
  };
}
