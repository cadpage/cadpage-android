package net.anei.cadpage.parsers.TX;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/* 
Collin County, TX
Contact: Jeremy Sexton <jeremy80xx@yahoo.com>
Sender: ccsodispatch@co.collin.tx.us

11048794  FIRE PUBLIC ASSIST  2701 ASPEN CT IN COLLIN COUNTY  COUNTY ROAD 392  [LCFD DIST: LCF1 GRID: 1322]  UNITS: LCF1  ST RMK: 7K4  CFS RMK 22:10 REQ FD TO CHECK BP...40 YRO FEMALE.   {CAD001 22:13}
11031079 First Responders 3274 Almeta LN in Collin County FM 546 [LCFD DIST: LCF1 GRID: 1331]
11047502 INJURED PERSON 3610 FM 546 IN COLLIN COUNTY COUNTY ROAD 398 / COUNTY RO;16AD 394 [LCFD DIST: LCF1 GRID: 1322] UNITS: AMRP LCF1 ST RMK: <NONE> CFS RMK 19:16 MALE SUB BLEEDING FROM HIS THROAT {CAD004 19:17} 
11047405 FISRT RESPONDERS 2897 COUNTY ROAD 914 IN COLLIN COUNTY COUNTY ROAD 392 [LCFD DIST: LCF1 GRID: 1322] UNITS: LCF1 AMRP ST RMK: DUTCH ACRES CFS RMK 12:59 68 YOA FALLEN IN FRONT YARD UNABLE T {CAD001 13:00}
11046597 MAJOR ACCIDENT 10/50 COUNTY ROAD 393 / FM 546 IN COLLIN COUNTY [LCFD DIST: LCF1 GRID: 1322] UNITS: LCF1 ST RMK: 8J1 CFS RMK 21:40 SOMEONE HAS FALLEN OUT OF A TRUCK {CAD004 21:40}
11044587 FIRST RESPONDERS 730 CROSS TIMBERS DR IN LOWRY CROSSING CROSS TRAIL LN [LCFD DIST: LCF1 GRID: 3100] UNITS: LCF1 AMRP ST RMK: <NONE> CFS RMK 13:14 37 YOA MALE / FELL YESTERDAY AND IS {CAD004 13:14}

*/

public class TXCollinCountyParser extends SmartAddressParser {
  
  private static final Pattern MASTER = Pattern.compile("(\\d{8}) (.*)\\[([A-Z]+) DIST: .* GRID: (\\d+) *\\] *(?:UNITS:(.*?))?(?: ST RMK:(.*) CFS RMK (.*))?");
  
  private static final String[] CITY_LIST = new String[] {
    "COLLIN COUNTY",
    "ALLEN",
    "ANNA",
    "BLUE RIDGE",
    "CARROLLTON",
    "CELINA",
    "COPEVILLE ",
    "DALLAS",
    "FAIRVIEW",
    "FARMERSVILLE",
    "FRISCO",
    "GARLAND",
    "JOSEPHINE",
    "LAVON",
    "LOWRY CROSSING",
    "LUCAS",
    "MCKINNEY",
    "MELISSA",
    "MURPHY",
    "NEVADA",
    "NEW HOPE",
    "PARKER",
    "PLANO",
    "PRINCETON",
    "PROSPER",
    "RICHARDSON",
    "ROYSE CITY",
    "SACHSE",
    "ST PAUL",
    "VAN ALSTYNE",
    "WESTMINSTER ",
    "WESTON",
    "WYLIE"
  };
  
  public TXCollinCountyParser() {
    super(CITY_LIST, "COLLIN COUNTY", "TX");
  }
  
  @Override
  public String getFilter() {
    return "ccsodispatch@co.collin.tx.us";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {

    int pt = body.lastIndexOf('{');
    if (pt >= 0) body = body.substring(0,pt).trim();
    
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    
    data.strCallId = match.group(1).trim();
    String sAddr = match.group(2).trim();
    data.strSource = match.group(3).trim();
    data.strMap = match.group(4).trim();
    data.strUnit = getOptGroup(match.group(5)).trim();
    data.strSupp = append(getOptGroup(match.group(6)).trim(), " / ", getOptGroup(match.group(7)).trim());
    
    sAddr = sAddr.replace(" IN ", " ").replace(" in ", " ");
    parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ, sAddr, data);
    if (data.strCity.equalsIgnoreCase("COLLIN COUNTY")) data.strCity = "";
    data.strCross = getLeft();
    
    return true;
  }
}
