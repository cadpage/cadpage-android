package net.anei.cadpage.parsers.ME;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
York County, ME (replacement)
Contact: Sean Perkins <sperkins@waterborofire.org>
Sender: dispatch@sanfordmaine.org

(Sanford RCC Page) MEDICAL EMERGENCY\n47\nGOODWINS ACRES \nDAYTON\nFire District: DAY\n4/25/2012 08:26
(Sanford RCC Page) MOTOR VEHICLE ACCIDENT-PI/HAZ\n47\nGOODWINS ACRES \nDAYTON\nFire District: DAY\n4/25/2012 07:18
(Sanford RCC Page) MEDICAL EMERGENCY\n2 EVERGREEN DR \nWaterboro\nFire District: WATF3\n4/24/2012 20:22
(Sanford RCC Page) MEDICAL EMERGENCY\n22 COYNE RD \nWaterboro\nFire District: WATF4\n4/24/2012 10:37
(Sanford RCC Page) MEDICAL EMERGENCY\n10 HUMMINGBIRD LN \nWaterboro\nFire District: WATF\n4/24/2012 07:29

*/

public class MEYorkCountyParser extends FieldProgramParser {
  
  public MEYorkCountyParser() {
    super(CITY_LIST, "YORK COUNTY", "ME",
           "CALL PLACE? ADDR/Z CITY Fire_District:SRC DATETIME!");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@sanfordmaine.org";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("Sanford RCC Page")) return false;
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
