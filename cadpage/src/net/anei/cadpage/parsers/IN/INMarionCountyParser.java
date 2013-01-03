package net.anei.cadpage.parsers.IN;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class INMarionCountyParser extends MsgParser {
  
  private static final Pattern MASTER = Pattern.compile("([^,]+), *([A-Z]{3}) ([NS]\\d{5} [EW]\\d{5}) ([^ ]+(?: *W/ *[^ ]+)?) (.*)");
  private static final Pattern CALL_ID_PTN = Pattern.compile("\\bI\\d{5}$");
  private static final Pattern UNIT_PTN = Pattern.compile("^(?:[A-Z]+[0-9]+|IPAGE|MEDIA|CSTF)\\b");
  
  public INMarionCountyParser() {
    super("MARION COUNTY", "IN");
  }
  
  @Override
  public String getFilter() {
    return "CAD@pager.mecagov.org,777,888";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    int pt = body.indexOf('\n');
    if (pt >= 0) body = body.substring(0,pt).trim();
    if (body.startsWith("CAD:")) body = body.substring(4).trim();
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    parseAddress(match.group(1).trim(), data);
    data.strCity = convertCodes(match.group(2), CITY_CODES);
    data.strMap = match.group(3);
    data.strCall = match.group(4);
    String sExtra = match.group(5).trim();
    match = CALL_ID_PTN.matcher(sExtra);
    if (match.find()) {
      data.strCallId = match.group();
      sExtra = sExtra.substring(0,match.start()).trim();
    }
    if (UNIT_PTN.matcher(sExtra).find()) {
      data.strUnit = sExtra;
    } else {
      data.strSupp = sExtra;
    }
    return true;
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "IND", "Indianapolis",
      "LWR", "Lawrence TWP",
      "PIK", "Pike TWP",
      "WAY", "Wayne TWP",
      "SPD", "Speedway",
      "PER", "Perry TWP",
      "DEC", "Decatur TWP",
      "WAR", "Warren TWP",
      "WAS", "Washington TWP",
      "HAM", "Hamilton County"
  });
}
