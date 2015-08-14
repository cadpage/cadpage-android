package net.anei.cadpage.parsers.GA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

public class GABarrowCountyParser extends SmartAddressParser {
  
  private static final Pattern CALLID_CALL = Pattern.compile("(\\d+[A-Z]+|S9) +(.*)"); //the " +" supports a tab that's been converted to spaces
  private static final Pattern APT_X_PTN = Pattern.compile("(?:Apt:(.*) Bldg(.*) )?XS: *(.*)");
  private static final Pattern NAME = Pattern.compile("([A-Z]+, ?[A-Z]+(?: [A-Z](?=\\s|$))?(?: & [A-Z]+(?: [A-Z](?=\\s|$))?)?)(.*)", Pattern.CASE_INSENSITIVE);
  private static final Pattern CAD_INFO = Pattern.compile("(\\d{4}-\\d+) *(.*)");
  private static final Pattern SUBDIVISION_PTN = Pattern.compile(".*? SUBDIVISION");

  public GABarrowCountyParser() {
      super("BARROW COUNTY", "GA");
      setupCallList(CALL_LIST);
      setupMultiWordStreets(MW_STREETS);
      setupPlaceAddressPtn(SUBDIVISION_PTN, true);
      setFieldList("CODE CALL PLACE ADDR APT X NAME ID INFO");
  }
  
  public boolean parseMsg(String subject, String body, Data data) {
    //check and remove leading tag from body
    if (!body.startsWith("BARROW_COUNTY_911:")) return false;
    body = body.substring(18);
    
    //if there's a subject, parse one of two known formats
    String left;
    if (subject.length() > 0) { //ID CALL
      Matcher mat = CALLID_CALL.matcher(subject);
      if (mat.matches()) {
        data.strCode = mat.group(1);
        data.strCall = mat.group(2);
        //parse address from start, rest goes in name
        parseAddress(StartType.START_PLACE, FLAG_IMPLIED_INTERSECT, body, data);
        //try parsing cross from beginning of getLeft()
        left = getLeft();
        Result res =  parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS, left);
        if (res.getStatus() >= STATUS_STREET_NAME) {
          res.getData(data);
          left = res.getLeft();
        }
      } 
      
      else {
        //check format
        int di = subject.indexOf("     ");
        if (di >= 0) {
          
          //parse subject to CALL ADDR
          data.strCall = subject.substring(0, di);
          parseAddress(subject.substring(di+5).trim(), data);
          
          Matcher match = APT_X_PTN.matcher(body);
          if (!match.matches()) return false;
          String apt = append(getOptGroup(match.group(2)), "-", getOptGroup(match.group(1)));
          data.strApt = append(data.strApt, "-", apt);
          parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS, match.group(3).trim(), data);
          left = getLeft();
        } else {
          data.strCall = subject;
          parseAddress(StartType.START_ADDR, body, data);
          body = getLeft();
          Result res = parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS, body);
          if (res.isValid()) {
            res.getData(data);
            body = getLeft();
          }
          data.strSupp = body;
          return true;
        }
      }
    }
    
    else { 
      //get id if not already parsed and present
      Matcher mat = CALLID_CALL.matcher(body);
      if (mat.matches()) {
        data.strCode = mat.group(1);
        body = mat.group(2);
      } //split body by first XS:
      int xi = body.indexOf("XS: ");
      if (xi > -1) {
        String p1 = body.substring(0, xi);
        String p2 = body.substring(xi+4, body.length());
        parseAddress(StartType.START_CALL_PLACE, FLAG_START_FLD_REQ | FLAG_IMPLIED_INTERSECT | FLAG_ANCHOR_END, p1, data);
        parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS, p2, data);
        left = getLeft();
      } else {
      //parse first part
        parseAddress(StartType.START_CALL_PLACE, FLAG_START_FLD_REQ | FLAG_IMPLIED_INTERSECT, body, data);
        //try parsing cross from beginning of getLeft()
        left = getLeft();
        Result res =  parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS, left);
        if (res.getStatus() >= STATUS_STREET_NAME) {
          res.getData(data);
          left = res.getLeft();
        }
      }
    }
    
    int ci = left.indexOf("Cad:");
    if (ci > -1) {
      data.strName = left.substring(0, ci).trim();
      Matcher mat = CAD_INFO.matcher(left.substring(ci+4).trim());
      if (!mat.matches()) return false;
      data.strCallId = mat.group(1);
      data.strSupp = mat.group(2);
    } else {
      //try to parse name with a pattern
      Matcher mat = NAME.matcher(left);
      if (mat.matches()) {
        data.strName = mat.group(1);
        data.strSupp = mat.group(2);
      } else {
        data.strSupp = left;
      }
    } 
    
    return true;
  }
  
  public static CodeSet CALL_LIST = new CodeSet(
    "AUTO ACCIDENT UNK INJURIES",
    "AUTO ACCIDENT WITH INJURIES",
    "AUTO ACCIDENT WITH PEDESTRIAN",
    "AUTO ACCIDENT/OVERTURNED/INJ",
    "CARDIAC/RESPITORY ARREST",
    "COMMERCIAL FIRE",
    "DEAD PERSON",
    "MULTIFAMILY FIRE",
    "PLANE  AIRCRAFT/PLANE DOWN",
    "PLANEW AIRCRAFT/PLANE DOWN",
    "STRUCTURE FIRE",
    "SWAT CALL OUT",
    "UNKNOWN TYPE FIRE/SITUATION",
    "VEHICLE FIRE",
    "WOODS FIRE"
  );
  
  public static String[] MW_STREETS = new String[]{
    "BARBER CREEK",
    "BARLEY CREEK",
    "BARROW INDUSTRIAL",
    "BEE MAXEY",
    "BETHLEHEM CHURCH",
    "BLDG HAYMON MORRIS",
    "BLDG WADE",
    "BUENA VISTA",
    "BURSON MADDOX",
    "BUSH CHAPEL DR",
    "CARL-CEDAR HILL",
    "CARL-MIDWAY CH",
    "CARSON WAGES",
    "CARTER HILL CH",
    "CEDAR VALLEY",
    "CENTURY OAKS",
    "CHICKENYLE",
    "CORINTH CHURCH",
    "COUNTYINE-AUBURN",
    "COVERED BRIDGE",
    "DOOLEY TOWN",
    "EAST BROAD",
    "EAST NORTHCREST",
    "ED HOGAN",
    "GREEN VALLEY",
    "GREY FOX",
    "HAL JACKSON",
    "HICKORY RIDGE",
    "HIDDEN HAMLET",
    "HILL'S SHOP",
    "HOG MOUNTAIN",
    "LIVE OAK",
    "LOIS KINNEY",
    "MANNING GIN",
    "MT MORIAH",
    "PARKS MILL",
    "PATRICK MILL ",
    "PATRICK MILL",
    "PICKLE SIMON",
    "PINE ROCK",
    "PINKSTON FARM",
    "PLEASANT HILL CH",
    "RAT KINNEY",
    "RED FOX",
    "ROCKWELL CHURCH ",
    "ROCKWELL CHURCH",
    "ROCKY POINT",
    "RUSSELL RIDGE",
    "SAINT IVES",
    "SEVEN OAKS SUBDIVISION",
    "ST ANTHONY",
    "ST GERMAINE",
    "SWEET GUM",
    "TANNERS BRIDGE",
    "THURMOND PLANTATION THURMOND",
    "TOM MILLER",
    "TURTLE CREEK"
  };
}
