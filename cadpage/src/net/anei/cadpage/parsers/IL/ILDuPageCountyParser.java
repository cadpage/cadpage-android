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
      "AD",        "ADDISON",
      "ANL",       "ARGONNE NATL LABS",
      "AU",        "AURORA",
      "BA",        "BARTLETT",
      "BE",        "BENSENVILLE",
      "BL",        "BLOOMINGDALE",
      "BO",        "BOLINGBROOK",
      "BR",        "BURR RIDGE",
      "BV",        "BATAVIA",
      "CG",        "CHICAGO",
      "CH",        "CLARENDON HILLS",
      "CK",        "COOK COUNTY",
      "CS",        "CAROL STREAM",
      "DA",        "DARIEN",
      "DG",        "DOWNERS GROVE",
      "EG",        "ELK GROVE VILLAGE",
      "EL",        "ELMHURST",
      "EOL",       "EOLA",
      "FML",       "FERMILAB",
      "GE",        "GLEN ELLYN",
      "GL",        "GLENDALE HEIGHTS",
      "HI",        "HINSDALE",
      "HP",        "HANOVER PARK",
      "IM",        "(empty)",
      "IT",        "ITASCA",
      "KC",        "KANE COUNTY",
      "KE",        "KENDALL COUNTY",
      "KNV",       "(empty)",
      "LE",        "LEMONT",
      "LI",        "LISLE",
      "LO",        "LOMBARD",
      "MED",       "MEDINAH",
      "NA",        "NAPERVILLE",
      "OB",        "OAKBROOK",
      "OT",        "OAKBROOK TERRACE",
      "RO",        "ROSELLE",
      "SC",        "SAINT CHARLES",
      "SH",        "SHAUMBURG",
      "VP",        "VILLA PARK",
      "WA",        "WAYNE",
      "WC",        "WEST CHICAGO",
      "WD",        "WOOD DALE",
      "WH",        "WHEATON",
      "WI",        "WINFIELD",
      "WL",        "WILLOWBROOK",
      "WO",        "WOODRIDGE",
      "WR",        "WARRENVILLE",
      "WS",        "WESTMONT",
      "WY",        "WILL COUNTY"
  });
}
