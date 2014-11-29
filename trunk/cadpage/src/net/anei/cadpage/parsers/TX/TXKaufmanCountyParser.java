
package net.anei.cadpage.parsers.TX;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;


public class TXKaufmanCountyParser extends DispatchSouthernParser {

  public TXKaufmanCountyParser() {
    super(CITY_LIST, "KAUFMAN COUNTY", "TX", DSFLAG_NO_IMPLIED_APT | DSFLAG_NO_NAME_PHONE);
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    body = body.replace('@', '&');
    return super.parseMsg(body, data);
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    return DIR_OF_PTN.matcher(addr).replaceAll("&");
  }
  private static final Pattern DIR_OF_PTN = Pattern.compile("\\b[NSEW]O +OF\\b", Pattern.CASE_INSENSITIVE);

  private static final String[] CITY_LIST = new String[]{

    "ABLES SPRINGS",
    "COMBINE",
    "COTTONWOOD",
    "CRANDALL",
    "DALLAS",
    "ELMO",
    "FORNEY",
    "GRAYS PRAIRIE",
    "HEARTLAND",
    "KAUFMAN",
    "KEMP",
    "MABANK",
    "MESQUITE",
    "OAK GROVE",
    "OAK RIDGE",
    "POETRY",
    "POST OAK BEND CITY",
    "ROSSER",
    "SCURRY",
    "SEAGOVILLE",
    "SEVEN POINTS",
    "TALTY",
    "TERRELL",
    "TRAVIS RANCH",

    "KAUFMAN COUNTY",
    "DALLAS COUNTY"
  };
}
