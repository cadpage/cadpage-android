package net.anei.cadpage.parsers.CA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeTable;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.StandardCodeTable;

/**
 * Amador County, CA
 */
public class CASacramentoCountyParser extends MsgParser {
  
  private static final Pattern MASTER = Pattern.compile("([A-Z0-9]+)/([A-Z0-9]+)/([A-Z0-9]+)/([A-Z0-9]*,[A-Z0-9]*)\\(([^,\\)]+),([A-Z]+)\\)\\((.*?)(?:\\).*)?");
  
  public CASacramentoCountyParser() {
    super("SACRAMENTO COUNTY", "CA");
    setFieldList("SRC CODE CALL MAP MAP ADDR APT CITY UNIT");
  }
  
  @Override
  public String getFilter() {
    return "@CAD.GOV";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("CAD PAGE-Do not reply")) return false;
    
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) {
      data.strCall = "GENERAL ALERT";
      data.strPlace = body;
      return true;
    }
    
    data.strSource = match.group(1);
    data.strCode = match.group(2);
    data.strCall = CALL_CODES.getCodeDescription(data.strCode);
    if (data.strCall == null) data.strCall = data.strCode;
    data.strMap = match.group(3);
    String map = match.group(4);
    if (!map.equals(",")) data.strMap = data.strMap + '-' + map;
    parseAddress(match.group(5).replace('.', ' ').trim(), data);
    data.strCity = convertCodes(match.group(6), CITY_CODES);
    data.strUnit = match.group(7).trim();
    return true;
  }
  
  private static CodeTable CALL_CODES = new StandardCodeTable(
      "AN",   "Animal Rescue",
      "CS1",  "Commercial Structure Fire",
      "CS2",  "Commercial Structure Fire",
      "CS3",  "Commercial Structure Fire",
      "G",    "Grass Fire",
      "GRF",  "Grass Fire / Red Flag",
      "IAC",  "Internal Alarm Commercial",
      "IAR",  "Internal Resident Alarm",
      "LO",   "Lock Out",
      "OT",   "Other",
      "PA",   "Public Assist",
      "S1",   "Structure Fire",
      "S2",   "Structure Fire",
      "S3",   "Structure Fire",
      "VF",   "Vehicle Fire",
      "WD",   "Wires Down"
  );
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "ARD", "ARDEN-ARCADE",
      "CIT", "CITRUS HEIGHTS",
      "CLF", "SACRAMENTO",           // ????
      "ELK", "ELK GROVE",
      "FOL", "FOLSOM",
      "GCY", "GALT",
      "HER", "HERALD",
      "LAG", "HOOD",                // ???
      "NHI", "NORTH HIGHLANDS",
      "RCO", "RANCHO CORDOVA",
      "RI",  "WALNUT GROVE",        // ????
      "RMU", "RANCHO MURIETA",
      "SAC", "SACRAMENTO",
      "SSC", "SACRAMENTO",          // ????
      "VIN", "VINEYARD",
      "WAL", "WALNUT GROVE",
      "WLT", "WILTON"
  });
}
