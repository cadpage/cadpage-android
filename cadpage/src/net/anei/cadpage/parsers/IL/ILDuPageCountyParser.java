package net.anei.cadpage.parsers.IL;

import java.util.Properties;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class ILDuPageCountyParser extends MsgParser {
  
  public ILDuPageCountyParser() {
    super("DUPAGE COUNTY", "IL");
    setFieldList("ID ADDR SRC UNIT CALL PLACE X CITY");
  }
  
  @Override
  public String getFilter() {
    return "DU-COMM@ducomm.org";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!body.startsWith("INC01 1.0 EV-XXX 0       ")) return false;
    data.strCallId = substring(body, 25, 40);
    String addr = substring(body, 40, 70);
    int pt = addr.indexOf("...");
    if (pt >= 0) addr = addr.substring(0,pt).trim();
    if (addr.startsWith("0N025 ")) addr = addr.substring(1).trim();
    parseAddress(addr, data);
    data.strSource = substring(body,70,72);
    data.strUnit = substring(body, 72, 76);
    data.strCall = substring(body, 76, 96);
    data.strPlace = substring(body, 96, 141);
    data.strCross = append(substring(body, 141, 161), " & ", substring(body, 161, 181));
    String city = substring(body, 347, 350);
    if (city.endsWith("2") ||
        city.length() > 2 && city.endsWith("U")) {
      city = city.substring(0,city.length()-1);
    }
    data.strCity = convertCodes(city, CITY_CODES);
    return true;
  }
  
  @Override
  public String postAdjustMapAddress(String addr) {
    if (addr.startsWith("N025 ")) {
      int pt = addr.indexOf('&');
      if (pt >= 0) addr = addr.substring(0,pt).trim();
    }
    return addr;
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "AD",     "ADDISON",
      "AF",     "ADDISON",
      "AH",     "ARLINGTON HEIGHTS",
      "AL",     "ALGONQUIN",
      "ANL",    "ARGONNE",
      "AR",     "ARGONNE",
      "AU",     "AURORA",
      "BA",     "BARTLETT",
      // "BA",     "BARRINGTON",   // Conflict
      "BB",     "BOLINGBROOK",
      "BD",     "BLOOMINGDALE",
      "BE",     "BENSENVILLE",
      "BF",     "BROOKFIELD",
      "BG",     "BUFFALO GROVE",
      "BK",     "BERKLEY",
      "BL",     "BLOOMINGDALE",
      // "BL",     "BELLWOOD",     // Conflict
      "BO",     "BOLINGBROOK",
      "BR",     "BURR RIDGE",
      // "BR",     "BARTLETT",
      "BT",     "BATAVIA",
      "BV",     "BATAVIA",
      // "BV",     "BENSENVILLE",
      "BW",     "BROADVIEW",
      "CA",     "CARY",
      "CG",     "CHICAGO",
      "CH",     "CLARENDON HILLS",
      "CK",     "COOK COUNTY",
      "CL",     "CLAREDON HILLS",
      "CR",     "CAROL STREAM",
      "CS",     "CAROL STREAM",
      "CV",     "CARPENTERSVILLE",
      "DA",     "DARIEN",
      "DG",     "DOWNERS GROVE",
      "DP",     "DES PLAINES",
      "DW",     "DARIEN-WOODRIDGE",
      "DW",     "DARIEN-WOODRIDGE",
      "EB",     "ELBURN",
      "ED",     "EAST DUNDEE",
      "EF",     "ELMHURST",
      "EG",     "ELK GROVE VILLAGE",
      "EK",     "ELK GROVE VILLAGE",
      "EL",     "ELMHURST",
      // "EL",     "ELGIN",       // Conflict
      "EOL",    "EOLA",
      "ET",     "ELK GROVE TOWNSHIP",
      "FML",    "BATAVIA",
      "FP",     "FRANKLIN PARK",
      "FR",     "FERMI LAB",
      "FX",     "FOX RIVER",
      "GE",     "GLEN ELLYN",
      "GF",     "GLEN ELLYN",
      "GL",     "GLENDALE HEIGHTS",
      "GS",     "GLENSIDE",
      "GV",     "GENEVA",
      "HA",     "HANOVER PARK",
      "HF",     "HOFFMAN ESTATES",
      "HI",     "HINSDALE",
      "HM",     "HAMPSHIRE",
      "HN",     "HINSDALE",
      "HP",     "HANOVER PARK",
      "HS",     "HILLSIDE",
      "IF",     "ITASCA",
      "IT",     "ITASCA",
      "KC",     "KANE COUNTY",
      "KE",     "KENDALL COUNTY",
      "LB",     "fLOCKPORT",
      "LE",     "LEMONT",
      "LG",     "LAGRANGE",
      "LI",     "LISLE",
      "LM",     "LEMONT",
      "LO",     "LOMBARD",
      "LP",     "LAGRANGE PARK",
      "LW",     "LISLE- WOODRIDGE",
      "LY",     "LEYDEN",
      "LZ",     "LAKE ZURICH",
      "MED",    "MEDINAH",
      "MK",     "MAPLE PARK",
      "MP",     "MELROSE PARK",
      "MT",     "MOUNT PROSPECT",
      "MW",     "MAYWOOD",
      "NA",     "NAPERVILLE",   
      // "NA",     "NORTH AURORA",
      "NL",     "NORHTLAKE",
      "NV",     "NAPERVILLE",
      "OB",     "OAK BROOK",
      // "OB",     "OAK BROOK TERRACE",
      "OK",     "OAK BROOK",
      "OP",     "OAK BROOK",
      "OT",     "OAK BROOK TERRACE",
      "PF",     "PLAINFIELD",
      "PG",     "PINGREE GROVE",
      "PH",     "PROSPECT HEIGHTS",
      "PR",     "PALATINE RURAL",
      "PT",     "PALATINE",
      "PV",     "PLEASANTVIEW",
      "RD",     "RUTLAND DUNDEE",
      "RF",     "ROSELLE",
      "RM",     "ROLLING MEADOWS",
      "RO",     "ROSELLE",
      // "RO",     "ROSEMONT",    // Conflict
      "RS",     "ROSELEE",
      "RV",     "ROMEOVILLE",
      "SC",     "ST CHARLES",
      "SE",     "SOUTH ELGIN",
      "SH",     "SCHAUMBURG",
      "SP",     "SCHILLER PARK",
      "SW",     "STREAMWOOD",
      "TS",     "TRI-STATE",
      "VF",     "VILLA PARK",
      "VP",     "VILLA PARK",
      "WA",     "WAYNE",
      "WC",     "WEST CHICAGO",
      // "WC",     "WESTCHESTER",    // Conflict
      "WD",     "WOOD DALE",
      // "WD",     "WEST DUNDEE",    // Conflict
      "WF",     "WINFIELD",
      "WG",     "WEST CHICAGO",
      "WH",     "WHEATON",
      "WI",     "WINFIELD",
      "WL",     "WILLOWBROOK",
      "WM",     "WESTMONT",
      "WN",     "WINFIELD",
      "WO",     "WOODRIDGE",
      "WR",     "WARRENVILLE",
      "WS",     "WESTMONT",
      // "WS",     "WESTERN SPRINGS",
      "WT",     "WHEATON",
      "WT",     "WHEELING",
      "WV",     "WARRENVILLE",
      "WY",     "WILL COUNTY",
      "YC",     "YORK CENTER"
  });
}
