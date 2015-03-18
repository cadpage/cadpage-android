package net.anei.cadpage.parsers.AL;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchB3Parser;

/**
 * St Clair County, AL
 */
public class ALStClairCountyParser extends DispatchB3Parser {

  public ALStClairCountyParser() {
    super("911CENTRAL:", CITY_LIST, "ST CLAIR COUNTY", "AL");
    setupCallList(CALL_LIST);
    setupMultiWordStreets(MSTREET_LIST);
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (subject.startsWith("9-1-1CENTRAL:")) {
      subject = "911CENTRAL:" + subject.substring(13);
    }
    if (body.startsWith("9-1-1CENTRAL:")) {
      body = "911CENTRAL:" + body.substring(13);
    }
    body = body.replace('@', '&');
    return super.parseMsg(subject, body, data);
  }
  
  private static final String[] MSTREET_LIST = new String[]{
    "ANDERSON HILL",
    "ARGO MARGARET",
    "BEASON COVE",
    "BEAVER CREEK",
    "BEAVER RIDGE",
    "BERRY HILL",
    "BILL SMITH",
    "BLACK JACK",
    "BLAIR FARM",
    "BROWN HILL",
    "BUCKS VALLEY",
    "CAMP CREEK",
    "CAMP WINNATASKA",
    "CANOE CREEK",
    "CANOE LAKE",
    "CEDAR CREEK",
    "COOK SPRINGS",
    "COOK SPRINGS CUT OFF",
    "COPPER SPRINGS",
    "COUNTRY LIVING",
    "COUNTRY VIEW",
    "CRAWFORDS COVE",
    "CROOKED CREEK",
    "CURT JARRETT",
    "DOUBLE BRIDGE",
    "EARLY SPRINGS",
    "EDDIE HOUTS",
    "FERN CREEK",
    "FOUR SEASONS",
    "FREEZE MOUNTAIN",
    "FREEZE MT",
    "FROST HOLLOW",
    "G B SANDERS",
    "GENE GLENN",
    "GEORGE CROWE",
    "GREEN BRIAR",
    "HAPPY KNOLL",
    "HAWKS BEND",
    "HICKORY VALLEY",
    "HILL TOP",
    "HONOR KEITH",
    "HOYT HILL",
    "IRA HANKS MEMORIAL",
    "JEAN RIDGE",
    "JOHN OWENS",
    "JOHN RANDALL",
    "KELLY CREEK",
    "LYNCH LAKE",
    "MADDOS FARM",
    "MAJESTIC PINES",
    "MEADOW RIDGE",
    "MINERAL SPRINGS",
    "MISTY PINES",
    "MOUNTAIN VIEW",
    "MT OAKS",
    "MURPHREES VALLEY",
    "NEAL HOUSTON",
    "NELSIE ANN",
    "OAK GROVE",
    "OAK HILL",
    "PARK HILL",
    "PEACEFUL VALLEY",
    "PEARL LAKE",
    "PEBBLE BEACH",
    "PIN OAK",
    "PINEY WOODS",
    "PLEASANT HILLS",
    "PLEASANT VALLEY",
    "RAY WYATT",
    "ROBERTS MILL PND",
    "ROBERTS MILL POND",
    "ROCK CRUSHER",
    "ROCK HAVEN",
    "ROCKY TOP",
    "SHOAL CREEK",
    "SMITH GLEN",
    "SMITH RIDGE",
    "SOUTHERN OAKS",
    "SPORTSMAN LAKE",
    "SPRINGVILLE STATION",
    "SULFUR SPRINGS",
    "SWEET APPLE",
    "TIMBER RIDGE",
    "TOM L SMITH",
    "TOOT HOLDER",
    "VALLEY VIEW",
    "VILLAGE SPRINGS",
    "WASHINGTON VALLEY",
    "WEST AFTER SHANGHAI",
    "WEST JONES VILLAGE",
    "WHITE OAK",
    "WILL KEITH",
    "WOLF CREEK",
    "WOODEN TRACE",
    "WOODY ACRES"
  };
  
  private static final CodeSet CALL_LIST = new CodeSet(
    "911 HANGUP/OPEN LINE",
    "ALARM",
    "ASSAULT",
    "ASSIST MOTORIST",
    "ASSIST OCCUPANT",
    "ATTEMPTED SUICIDE",
    "CALL BY PHONE",
    "CALL BY PHONE FOR",
    "CHECK WELFARE",
    "DEATH",
    "DISTURBANCE",
    "FIRE ALARM",
    "FIRE, OTHER",
    "HAZARDOUS MATERIAL",
    "HIT AND RUN",
    "INVESTIGATE SMOKE",
    "KEYS IN VEHICLE",
    "MEDICAL CALL",
    "MEET COMPLAINANT",
    "MENTAL PATIENT",
    "OVERDOSE",
    "PASS ALONG INFORMATION",
    "PATIENT TRANSPORT",
    "PURSUIT",
    "PUBLIC SERVICE",
    "STRUCTURE FIRE",
    "SUSPICIOUS VEHICLE",
    "TEST CAD EVENT",
    "TRAFFIC STOP",
    "TREE DOWN",
    "VEHICLE FIRE",
    "VERBAL DOMESTIC DISTURBANCE",
    "WATER OUTAGE/SEWER PROBLEM",
    "WILD FIRE",
    "WIRE DOWN",
    "WRECK"
  );
 
  private static final String[] CITY_LIST = new String[]{
    "ARGO",
    "ASHVILLE",
    "BRANCHVILLE",
    "COOL SPRINGS",
    "LEEDS",
    "MARGARET",
    "MOODY",
    "ODENVILLE",
    "PELL CITY",
    "PINEDALE SHORES",
    "RAGLAND",
    "RIVERSIDE",
    "SPRINGVILLE",
    "STEELE",
    "TRUSSVILLE",
    "VINCENT"
  };
}
