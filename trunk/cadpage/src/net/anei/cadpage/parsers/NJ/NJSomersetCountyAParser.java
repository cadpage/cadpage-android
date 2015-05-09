package net.anei.cadpage.parsers.NJ;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


/**
 * Somerset County, NJ
 */
public class NJSomersetCountyAParser extends MsgParser {
  
  private static final Pattern MARKER = Pattern.compile("^(?:(?:/ [A-Z0-9 ]* / )?(?:[A-Za-z]+:)?(?:[[^:]*]:)?)?(?:([^: ]+):)?(\\d{8}) *:(\\d\\d/\\d\\d/\\d\\d\\d\\d) (\\d\\d:\\d\\d:\\d\\d):");
  private static final Pattern MASTER = Pattern.compile("(.*?): ([A-Z ]+)-(?! )(?:(.*) / +)?([^\\(]*)(?:\\((.*)\\))?");
  private static final Pattern ROUTE_HWY_PTN = Pattern.compile("\\b(STATE|COUNTY|US) (?:ROUTE|ROAD|HWY)(?: NO)? (\\d+)(?: HWY)?\\b");
  private static final Pattern APT_PTN = Pattern.compile(" +((?:APT|FL|FLR|BLDG) +[-A-Z0-9]+)$");
  
  public NJSomersetCountyAParser() {
    super("SOMERSET COUNTY", "NJ");
    setFieldList("SRC ID DATE TIME CALL CITY PLACE ADDR APT INFO");
  }
  
  @Override
  public String getFilter() {
    return "rc.502@c-msg.net,messaging@iamresponding.com,@co.somerset.nj.us";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {

    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    data.strSource = getOptGroup(match.group(1));
    data.strCallId = match.group(2);
    data.strDate = match.group(3);
    data.strTime = match.group(4);
    body = body.substring(match.end()).trim();
    
    int pt = body.indexOf('\n');
    if (pt >= 0) body = body.substring(0,pt).trim();
    
    match = MASTER.matcher(body);
    if (!match.matches()) return false;
    data.strCall = match.group(1).trim();
    data.strCity = convertCodes(match.group(2).trim(), CITY_CODES);
    data.strPlace = null2empty(match.group(3));
    String sAddr = match.group(4).trim();
    data.strSupp = null2empty(match.group(5));
    
    match = ROUTE_HWY_PTN.matcher(sAddr);
    if (match.find()) {
      sAddr = sAddr.substring(0,match.start()) +
              match.group(1).substring(0,2) + " " + match.group(2) +
              sAddr.substring(match.end());
    }
    match = APT_PTN.matcher(sAddr);
    if (match.find()) {
      data.strApt = match.group(1);
      if (data.strApt.startsWith("APT ")) {
        data.strApt = data.strApt.substring(4).trim();
      }
      sAddr = sAddr.substring(0,match.start());
    }
    sAddr = stripFieldEnd(sAddr, " FL %");
    parseAddress(sAddr, data);
    data.strAddress = ROUTE_HWY_PTN.matcher(data.strAddress).replaceFirst("$1 $2");
    return true;
  }
  
  @Override
  public String adjustMapAddress(String sAddr) {
    sAddr = US_PTN.matcher(sAddr).replaceAll("US");
    sAddr = NO_PTN.matcher(sAddr).replaceAll(" ").trim();
    return sAddr;
  }
  private static final Pattern US_PTN = Pattern.compile("\\bU +S\\b");
  private static final Pattern NO_PTN = Pattern.compile(" *\\bNO\\b *");

  private String null2empty(String str) {
    return str == null ? "" : str.trim();
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "BERNARD", "BERNARD",
      "BOUND B", "BOUND BROOK",
      "BRANCHB", "BRANCHBURG",
      "BRIDGEW", "BRIDGEWATER TWP",
      "EAST AM", "EAST AMWELL TWP",
      "FRANKLI", "FRANKLIN TWP",
      "HILLSBO", "HILLSBOROUGH TWP",
      "HOPEWEL", "HOPEWELL TWP",
      "MANVILL", "MANVILLE",
      "MILLSTO", "MILLSTONE",
      "MONTGOM", "MONTGOMERY TWP",
      "PRINCET", "PRINCETON TWP",
      "RARITAN", "RARITAN",
      "ROCKY H", "ROCKY HILL",
      "SOMERVI", "SOMERVILLE",
      "SOUTH B", "SOUTH BOUND BROOK"
  });
}
