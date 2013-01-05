package net.anei.cadpage.parsers.PA;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/***
 * Clinton County, PA
 */

public class PAClintonCountyParser extends FieldProgramParser {
  
  private static final Pattern DELIM = Pattern.compile(" {3,}");
  
  public PAClintonCountyParser() {
    super("CLINTON COUNTY", "PA",
          "UNIT? SKIP ADDR CITY CALL ID! INFO");
  }
  
  @Override
  public String getFilter() {
    return "Message.CC_PSAP@clintoncountypa.com";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (body.startsWith("'")) body = body.substring(1).trim();
    if (body.endsWith("'")) body = body.substring(0,body.length()-1).trim();
    return parseFields(DELIM.split(body), 5, data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("UNIT")) return new UnitField("\\d+", true);
    if (name.equals("ID")) return new IdField("\\d{4}-\\d{8}", true);
    return super.getField(name);
  }
}
