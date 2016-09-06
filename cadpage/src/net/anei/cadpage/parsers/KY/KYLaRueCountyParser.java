package net.anei.cadpage.parsers.KY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;

public class KYLaRueCountyParser extends DispatchB2Parser {
  
  private static final Pattern CALL_ID_PTN = Pattern.compile("(\\d+):(.*)");
  private static final Pattern MISSING_GT_PTN = Pattern.compile("(FIRE(?:-[A-Z])?) (FIRE)");
  private static final Pattern AUTOMATED_MSG_PTN = Pattern.compile("/?(.*\\b(?:FIRE ALARM|FIRE) IN (?:YOUR AREA\\.? )?(?:THIS IS AN )?AUTOMATED (?:MSG|MESSAGE)\\.?)");
  
  public KYLaRueCountyParser() {
    super("LARUECO911:",CITY_LIST, "LARUE COUNTY", "KY", B2_CROSS_FOLLOWS);
    setupMultiWordStreets(
        "BALL HOLLOW",
        "BOUNDARY OAKS",
        "BUDS LAKE",
        "CISSAL HILL",
        "DAN DUNN",
        "EARL JONES",
        "JESSE ABELL",
        "LINCOLN FARM",
        "LYONS STATION",
        "MARTIN MEADOW",
        "MT SHERMAN WARD",
        "MT TABOR",
        "OAK HILL",
        "PARKER GROVE",
        "PARKER GROVE SPUR",
        "PLEASANT CHURCH",
        "SALEM LAKE",
        "SAND RIDGE",
        "SPENCER SCHOOL",
        "STILES FORD",
        "THOMPSON HILL",
        "UNION CHUCH",
        "UPTON TALLEY",
        "MARTIN MEADOW",
        "YOUNGERS CREEK"
    );
    removeWords("TURNPIKE");
  }
  
  @Override
  public String getFilter() {
    return "LARUECO911@otelco.net,315@otelco.net";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    Matcher match = CALL_ID_PTN.matcher(body);
    if (!match.matches()) return false;
    data.strCallId = match.group(1);
    body = match.group(2);
    body = MISSING_GT_PTN.matcher(body).replaceFirst("$1>$2");
    if (!super.parseMsg(body, data)) return false;
    
    // Cross street may have ended in with name, in which case it was
    // misinterpreted as the actual city name and a duplicate city name
    // ended up in the name field
    if (data.strCross.length() > 0 && 
          (data.strCross.endsWith(" IN") || data.strCross.endsWith(" OF")) &&
        data.strCity.length() > 0 && 
        data.strName.startsWith(data.strCity)) {
      data.strCross = data.strCross + ' ' + data.strCity;
      data.strName = data.strName.substring(data.strCity.length()).trim();
    }

    // And sometimes what pops up in the name field is really a cross street
    // and automated alert message
    match = AUTOMATED_MSG_PTN.matcher(data.strName);
    if (match.matches()) {
      data.strSupp = append(match.group(1).trim(), " / ", data.strSupp);
      data.strName = "";
    }
    
    return true;
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }

  private static final String[] CITY_LIST = new String[]{
      "ATHERTONVILLE",
      "BUFFALO",
      "HODGENVILLE",
      "LYONS",
      "MAGNOLIA",
      "MT SHERMAN",
      "TONIEVILLE",
      "UPTON",
      
      // Hardin County
      "SONORA",
      
      // Nelson County
      "NEW HAVEN",
      
    };
  
  @Override
  protected CodeSet buildCallList() {
    return new CodeSet(
        "2ND CALL ON ANY EVENT",
        "BREATHING DIFFICULTIES",
        "CARDIAC/CHEST PAINS",
        "FALL",
        "FIRE - ALARM",
        "FIRE - FIELD / BRUSH",
        "FIRE - UNDEFINED",
        "FIRE - STRUCTURE",
        "FIRE - VEHICLE",
        "FIRE REKINDLE",
        "GENERAL ALERT",
        "ILLNESS",
        "INCOMPLETE 911 CALL",
        "INJURY ANY TYPE",
        "MISSING PERSON",
        "MVA NON INJURY",
        "MVA WITH INJURIES",
        "ROAD OBSTRUCTION",
        "ROUTINE TRANSFER",
        "UNRESPONSIVE PERSON"  
    );
  }
}
