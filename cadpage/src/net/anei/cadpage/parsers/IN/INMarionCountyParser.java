package net.anei.cadpage.parsers.IN;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class INMarionCountyParser extends MsgParser {
  
  private static final Pattern MASTER = Pattern.compile("([^,]+), *([A-Z]{3}) (?:#(?:APT|RM|ROOM|SUIT) *(\\d+[A-Z]?) )?(?:([NS]\\d{5} [EW]\\d{5}|[NS] [EW]) )?(.*)");
  private static final Pattern CALL_ID_PTN = Pattern.compile("\\b(I\\d{5})\\.?$");
  private static final Pattern UNIT_PTN = Pattern.compile("^(?:[A-Z]+[0-9]+|\\d+GRP|IPAGE|MEDIA|CSTF)\\b");
  
  public INMarionCountyParser() {
    super("MARION COUNTY", "IN");
    setFieldList("ADDR CITY APT MAP CALL UNIT INFO ID INFO");
  }
  
  @Override
  public String getFilter() {
    return "CAD@pager.mecagov.org,777,888";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    int pt = body.indexOf('\n');
    if (pt >= 0) body = body.substring(0,pt).trim();
    if (body.startsWith("CAD:")) body = body.substring(4).trim();
    
    if (subject.endsWith(" MAJOR PAGE FYI")) {
      data.strSupp = body;
      body = subject.substring(0,subject.length()-15).trim();
    }
    
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    parseAddress(match.group(1).trim(), data);
    data.strCity = convertCodes(match.group(2), CITY_CODES);
    data.strApt = append(data.strApt, "-", getOptGroup(match.group(3)));
    data.strMap = getOptGroup(match.group(4));
    String sExtra = match.group(5).trim();
    String call = CODE_SET.getCode(sExtra);
    if (call != null) {
      data.strCall = call;
      sExtra = sExtra.substring(call.length()).trim();
    } else {
      Parser p = new Parser(sExtra);
      data.strCall = p.get(' ');
      sExtra = p.get();
    }
    match = CALL_ID_PTN.matcher(sExtra);
    if (match.find()) {
      data.strCallId = match.group(1);
      sExtra = sExtra.substring(0,match.start()).trim();
    }
    if (UNIT_PTN.matcher(sExtra).find()) {
      data.strUnit = sExtra;
    } else {
      data.strSupp = append(sExtra, " / ", data.strSupp);
    }
    return true;
  }
  
  private static final CodeSet CODE_SET = new CodeSet(
      "APARTMNT/WORKI",
      "BLDG/HR/WORKING",
      "BUILDING",
      "BUILDING/WORKI",
      "CARD/ARREST/WRKG",
      "CIV/FATALITY",
      "CIV/SLIGHT/INJ",
      "DOUBLE RESI/WRK",
      "DROWN/RESCUE",
      "EMER TRANSFER",
      "FIELD",
      "GARAGE/WORKI",
      "LARGE SPILL",
      "MASS CASUALTY 1",
      "PI TACTICAL",
      "PI/TACTICAL",
      "PI TACTICAL/WORK",
      "PI W/ENTRAPMENT",
      "PI W/ ENTRAPMENT",
      "PI W/EXTRAPMENT",
      "PI WORK/ENTRAP",
      "RESIDENCE/WORKIN",
      "S E PI W/ENTRAPMENT",
      "SEMI/RV/MOTHM",
      "STRUCT/COLLAPSE",
      "UNKNOWN SUBST"
  );
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "HOM", "Homecroft",
      "IND", "Indianapolis",
      "PLF", "Plainfield",
      
      "LWR", "Lawrence TWP",
      "PIK", "Pike TWP",
      "SPD", "Speedway",
      "PER", "Perry TWP",
      "DEC", "Decatur TWP",
      "WAR", "Warren TWP",
      "WAS", "Washington TWP",
      "WAY", "Wayne TWP",
      
      "HAM", "Hamilton County"
  });
}
