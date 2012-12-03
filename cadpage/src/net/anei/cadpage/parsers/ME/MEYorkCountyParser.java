package net.anei.cadpage.parsers.ME;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class MEYorkCountyParser extends FieldProgramParser {
  
  public MEYorkCountyParser() {
    super(CITY_LIST, "YORK COUNTY", "ME",
           "CALL PLACE? ADDR/Z CITY District:SRC DATETIME!");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@sanfordmaine.org";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("Sanford RCC Page")) return false;
    body = body.replace("\nFire District:", "\nDistrict:");
    return parseFields(body.split("\n"), data);
  }
  
  @Override
  protected Field getField(String name) {
    if (name.equals("DATETIME")) return new DateTimeField("\\d\\d?/\\d\\d?/\\d{4} \\d\\d:\\d\\d", true);
    return super.getField(name);
  }

  private static final String[] CITY_LIST = new String[]{
    "ACTON",
    "ALFRED",
    "ARUNDEL",
    "BERWICK",
    "BIDDEFORD",
    "BUXTON",
    "CORNISH",
    "DAYTON",
    "ELIOT",
    "HOLLIS",
    "KENNEBUNK",
    "KENNEBUNKPORT",
    "KITTERY",
    "LEBANON",
    "LIMERICK",
    "LIMINGTON",
    "LYMAN",
    "NEWFIELD",
    "NORTH BERWICK",
    "OGUNQUIT",
    "OLD ORCHARD BEACH",
    "PARSONSFIELD",
    "SACO",
    "SANFORD",
    "SHAPLEIGH",
    "SOUTH BERWICK",
    "WATERBORO",
    "WELLS",
    "YORK"
  };
}
