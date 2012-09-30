package net.anei.cadpage.parsers.CA;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Butte County, CA
 */
public class CAOrovilleParser extends FieldProgramParser {
  
  public CAOrovilleParser() {
    super("OROVILLE", "CA",
           "ADDRCITY PLACE X APT SRC! EMPTY INFO");
  }
  
  @Override
  public String getFilter() {
    return "@OROPD.ORG";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.startsWith("Dispatched Call")) return false;
    return parseFields(body.split(" \\* "), 5, data);
  }
}
