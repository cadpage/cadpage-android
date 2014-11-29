package net.anei.cadpage.parsers.NJ;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgParser;


public class NJHunterdonCountyParser extends MsgParser {
  
  private static final Pattern MASTER = Pattern.compile("([A-Z0-9]+):([-A-Z /0-9]+): *\\((\\d+)\\) *(.*?) (?:NEAR: *(.*?) )?(\\d{8})\\b *(.*?)");
  
  public NJHunterdonCountyParser() {
    super("HUNTERDON COUNTY", "NJ");
    setFieldList("UNIT CALL SRC PLACE ADDR APT X ID INFO");
  }
  
  @Override
  public String getFilter() {
    return "hces@hunterdon.co.nj.us,messaging@iamresponding.com";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    data.strUnit = match.group(1);
    data.strCall = match.group(2);
    data.strSource = convertCodes(match.group(3), SOURCE_CODES);
    Parser p = new Parser(match.group(4));
    data.strPlace = p.getOptional(" / ");
    parseAddress(p.get().replace(" NO ", " "), data);
    data.strCross = getOptGroup(match.group(5));
    data.strCallId = match.group(6);
    data.strSupp = match.group(7);
    return true;
  }
  
  private static final Properties SOURCE_CODES = buildCodeTable(new String[]{
      "11", "Frenchtown",
      "12", "Glen Gardner",
      "13", "Hampton",
      "14", "High Bridge",
      "15", "Holland Twp",
      "16", "Kingwood",
      "17", "Lambertville",
      "18", "Lebanon",
      "19", "Lebanon Twp",
      "21", "Raritan Twp",
      "22", "Readington Twp",
      "23", "Stockton",
      "24", "Tewksbury",
      "25", "Pattenburg",
      "26", "West Amwell Twp",
      "31", "East Whitehouse",
      "32", "Readington",
      "33", "Three Bridges",
      "34", "Fairmount",
      "43", "Bloomsbury",
      "41", "Quakertown",
      "44", "Califon",
      "45", "Clinton",
      "46", "Annandale",
      "47", "Sergeantsville",
      "48", "Amwell Valley",
      "49", "Flemington",
      "52", "Asbury",
      "57", "Pottersville",
      "74", "Branchburg",
      "79", "Hillsborough",
      "91", "Quakertown",
      "92", "Milford",
      "93", "Country Hills",
      "94", "Delaware Valley",
      "95", "Upper Black Eddy",
      "96", "New Hope Eagle"

  });
}
