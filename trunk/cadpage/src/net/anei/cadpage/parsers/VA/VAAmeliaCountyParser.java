package net.anei.cadpage.parsers.VA;

import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchDAPROParser;

/**
 * Amelia County, VA
 */
public class VAAmeliaCountyParser extends DispatchDAPROParser {
  
  private static final Pattern LEAD_ZERO_PTN = Pattern.compile("^0+");
  
  public VAAmeliaCountyParser() {
    super(CITY_CODE_TABLE, "AMELIA COUNTY", "VA");
  }
  
  @Override
  public String getFilter() {
    return "MAILBOX@ameliasheriff.org";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    Parser p = new Parser(subject);
    data.strUnit = p.getLast(' ');
    String source = p.get();
    if (source.length() == 0) return false;
    if (!super.parseMsg(body,  data)) return false;
    data.strBox = data.strSource;
    data.strSource = source;
    data.strAddress = LEAD_ZERO_PTN.matcher(data.strAddress).replaceFirst("").trim();
    return true;
  }
  
  @Override
  public String getProgram() {
    return "SRC UNIT BOX " + super.getProgram();
  }
  
  private static final Properties CITY_CODE_TABLE =
    buildCodeTable(new String[]{
        "AME", "AMELIA COURT HOUSE",
        "CHU", "CHULA"
    });
}