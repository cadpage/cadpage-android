package net.anei.cadpage.parsers.VA;

import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchDAPROParser;

/**
 * Warren County, VA
 */
public class VAWarrenCountyParser extends DispatchDAPROParser {
  
  private static final Pattern LEAD_ZERO_PTN = Pattern.compile("^0+");
  
  public VAWarrenCountyParser() {
    super(CITY_CODE_TABLE, "WARREN COUNTY", "VA");
  }
  
  @Override
  public String getFilter() {
    return "mailbox@warrencountysheriff.org";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!super.parseMsg(body,  data)) return false;
    data.strAddress = LEAD_ZERO_PTN.matcher(data.strAddress).replaceFirst("").trim();
    return true;
  }
  
  @Override
  public String getProgram() {
    return "SRC UNIT BOX " + super.getProgram();
  }
  
  private static final Properties CITY_CODE_TABLE =
    buildCodeTable(new String[]{
        "BEN", "BENTONVILLE",
        "FRO", "FRONT ROYAL",
        "LIN", "LINDEN"
    });
}