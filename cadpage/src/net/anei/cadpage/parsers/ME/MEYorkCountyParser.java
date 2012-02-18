package net.anei.cadpage.parsers.ME;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
York County, ME (replacement)
Contact: Sean Perkins <sperkins@waterborofire.org>
Sender: dispatch@sanfordmaine.org

(Sanford RCC Page) MEDICAL EMERGENCY\nGOODALL HOSPITAL URGENT CARE/PHARMACY\n10 GOODALL DR \nWaterboro\n2/13/2012 16:59
(Sanford RCC Page) MEDICAL EMERGENCY\n22 COYNE RD \nWaterboro\n2/13/2012 10:51
(Sanford RCC Page) FIRE, OTHER\n23 BACK ST \nWaterboro\n2/13/2012 18:58
(Sanford RCC Page) MEDICAL EMERGENCY\n50 SANFORD RD \nWaterboro\n2/14/2012 14:53
(Sanford RCC Page) MEDICAL EMERGENCY\n77 SOKOKIS TRL \nWaterboro\n2/14/2012 20:07
(Sanford RCC Page) MEDICAL EMERGENCY\n22 MILL POND RD \nWaterboro\n2/15/2012 09:19
(Sanford RCC Page) MEDICAL EMERGENCY\nGOODALL HOSPITAL URGENT CARE/PHARMACY\n10 GOODALL DR \nWaterboro\n2/15/2012 10:30
(Sanford RCC Page) MEDICAL EMERGENCY\nLAKE ARROWHEAD\nWaterboro\n2/16/2012 14:53
(Sanford RCC Page) MEDICAL EMERGENCY\n1331 SOKOKIS TRL \nWaterboro\n2/17/2012 05:41
(Sanford RCC Page) FIRE, OTHER\n26 LOGAN CIRCLE EXT \nWaterboro\n2/17/2012 11:29

*/

public class MEYorkCountyParser extends FieldProgramParser {
  
  public MEYorkCountyParser() {
    super(CITY_LIST, "YORK COUNTY", "ME",
           "CALL PLACE? ADDR/Z CITY DATETIME!");
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
