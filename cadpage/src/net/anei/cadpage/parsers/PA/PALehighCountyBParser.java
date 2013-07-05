package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Lehigh County PA
 */
public class PALehighCountyBParser extends FieldProgramParser {
  
  public PALehighCountyBParser() {
    super("LEHIGH COUNTY", "PA",
          "CALL ADDR APT! INFO+");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@lvh.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!body.startsWith("RC:")) return false;
    body = body.substring(3).trim();
    return parseFields(body.split("/", -1), data);
  }
}
