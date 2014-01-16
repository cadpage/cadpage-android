package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Cuyahoga County, OH
 */
public class OHCuyahogaCountyAParser extends FieldProgramParser {

  public OHCuyahogaCountyAParser() {
    super(OHCuyahogaCountyParser.CITY_CODES, "CUYAHOGA COUNTY", "OH",
        "CALL ADDR/S5XXa! INFO+");
  }

  @Override
  public String getFilter() {
    return "dispatch@chagrinfallspd.com";
  }

  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Dispatch Message")) return false;
    return parseFields(body.split("\n"), 2, data);

  }
}
