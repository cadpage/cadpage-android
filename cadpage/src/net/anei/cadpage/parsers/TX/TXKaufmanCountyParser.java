
package net.anei.cadpage.parsers.TX;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;


public class TXKaufmanCountyParser extends DispatchSouthernParser {

  public TXKaufmanCountyParser() {
    super(CITY_LIST, "KAUFMAN COUNTY", "TX", DSFLAG_NO_IMPLIED_APT | DSFLAG_NO_NAME_PHONE | DSFLAG_NO_PLACE);
  }
  
  private static final Pattern VZ_PTN = Pattern.compile("\\bVZ(?= ?C[OR]\\b)");
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    body = stripFieldStart(body, "Dispatch:");
    body = stripFieldStart(body, "kaufmancotx911:");
    int pt = body.indexOf("\n");
    if (pt >= 0) body = body.substring(0,pt).trim();
    body = body.replace('@', '&');
    if (!super.parseMsg(body, data)) return false;
    if (data.strCity.equals("VZCO") || data.strCity.equals("VAN ZANDT CO")) data.strCity = "VAN ZANDT COUNTY";
    if (data.strCity.length() == 0 && VZ_PTN.matcher(data.strAddress).find()) data.strCity = "VAN ZANDT COUNTY";
    return true;
  }

  private static final Pattern DIR_OF_PTN = Pattern.compile("\\b[NSEW]O +OF\\b", Pattern.CASE_INSENSITIVE);
  private static final Pattern SVC_RD_NN_PTN = Pattern.compile("\\b(?:SVC|SERVICE) RD (\\d+)", Pattern.CASE_INSENSITIVE);

  @Override
  public String adjustMapAddress(String addr) {
    addr = DIR_OF_PTN.matcher(addr).replaceAll("&");
    addr = SVC_RD_NN_PTN.matcher(addr).replaceAll("I $1 FRONTAGE RD");
    addr = VZ_PTN.matcher(addr).replaceAll("").trim();
    return super.adjustMapAddress(addr);
  }

  private static final String[] CITY_LIST = new String[]{

    "ABLES SPRINGS",
    "CANTON",
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
    "POST OAK BEND",
    "POST OAK BEND CITY",
    "ROSSER",
    "SCURRY",
    "SEAGOVILLE",
    "SEVEN POINTS",
    "TALTY",
    "TERRELL",
    "TRAVIS RANCH",

    "VAN ZANDT COUNTY",
    "VAN ZANDT CO",
    "VZCO",
    "KAUFMAN COUNTY",
    "DALLAS COUNTY",

  };
}
