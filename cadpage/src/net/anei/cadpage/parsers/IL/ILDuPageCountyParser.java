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
    if (addr.startsWith("0N025 ")) addr = "25 N " + addr.substring(6);
    parseAddress(addr, data);
    data.strSource = substring(body,70,72);
    data.strUnit = substring(body, 72, 76);
    data.strCall = substring(body, 76, 96);
    data.strPlace = substring(body, 96, 141);
    data.strCross = append(substring(body, 141, 161), " & ", substring(body, 161, 181));
    data.strCity = convertCodes(substring(body, 347, 350), CITY_CODES);
    return true;
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "AD",     "ADDISON",
      "ADU",    "ADDISON",
      "ANL",    "ARGONNE",
      "AU",     "AURORA",
      "AUU",    "AURORA",
      "BA",     "BARTLETT",
      "BAU",    "BARTLETT",
      "BE",     "BENSENVILLE",
      "BEU",    "BENSENVILLE",
      "BL",     "BLOOMINGDALE",
      "BLU",    "BLOOMINGDALE",
      "BO",     "BOLINGBROOK",
      "BR",     "BURR RIDGE",
      "BRU",    "BURR RIDGE",
      "BV",     "BATAVIA",
      "CG",     "CHICAGO",
      "CH",     "CLARENDON HILLS",
      "CHU",    "CLARENDON HILLS",
      "CK",     "COOK COUNTY",
      "CS",     "CAROL STREAM",
      "CSU",    "CAROL STREAM",
      "DA",     "DARIEN",
      "DAU",    "DARIEN",
      "DG",     "DOWNERS GROVE",
      "DGU",    "DOWNERS GROVE",
      "EG",     "ELK GROVE VILLAGE",
      "EL",     "ELMHURST",
      "ELU",    "ELMHURST",
      "EOL",    "EOLA",
      "FML",    "BATAVIA",
      "GE",     "GLEN ELLYN",
      "GEU",    "GLEN ELLYN",
      "GL",     "GLENDALE HEIGHTS",
      "GLU",    "GLENDALE HEIGHTS",
      "HI",     "HINSDALE",
      "HIU",    "HINSDALE",
      "HP",     "HANOVER PARK",
      "HPU",    "HANOVER PARK",
      "IT",     "ITASCA",
      "ITU",    "ITASCA",
      "KC",     "KANE COUNTY",
      "KE",     "KENDALL COUNTY",
      "LE",     "LEMONT",
      "LEU",    "LEMONT",
      "LI",     "LISLE",
      "LIU",    "LISLE",
      "LO",     "LOMBARD",
      "LOU",    "LOMBARD",
      "MED",    "MEDINAH",
      "NA",     "NAPERVILLE",
      "NAU",    "NAPERVILLE",
      "OB",     "OAKBROOK",
      "OBU",    "OAKBROOK",
      "OT",     "OAKBROOK TERRACE",
      "OTU",    "OAKBROOK TERRACE",
      "RO",     "ROSELLE",
      "ROU",    "ROSELLE",
      "SC",     "SAINT CHARLES",
      "SH",     "SHAUMBURG",
      "VP",     "VILLA PARK",
      "VPU",    "VILLA PARK",
      "WA",     "WAYNE",
      "WC",     "WEST CHICAGO",
      "WCU",    "WEST CHICAGO",
      "WD",     "WOOD DALE",
      "WDU",    "WOOD DALE",
      "WH",     "WHEATON",
      "WHU",    "WHEATON",
      "WI",     "WINFIELD",
      "WIU",    "WINFIELD",
      "WL",     "WILLOWBROOK",
      "WLU",    "WILLOWBROOK",
      "WO",     "WOODRIDGE",
      "WOU",    "WOODRIDGE",
      "WR",     "WARRENVILLE",
      "WRU",    "WARRENVILLE",
      "WS",     "WESTMONT",
      "WSU",    "WESTMONT",
      "WY",     "WILL COUNTY"
  });
}
