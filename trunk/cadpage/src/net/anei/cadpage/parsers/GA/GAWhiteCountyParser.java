package net.anei.cadpage.parsers.GA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

public class GAWhiteCountyParser extends SmartAddressParser {

  public GAWhiteCountyParser() {
    super("WHITE COUNTY", "GA");
    setFieldList("DATE TIME ID CODE CALL ADDR APT CITY");
    setupMultiWordStreets(MW_STREETS);
    setupCallList(CALL_LIST);
  }

  private static Pattern MASTER = Pattern.compile(":As of (\\d\\d/\\d\\d/\\d\\d) (\\d\\d:\\d\\d:\\d\\d) (\\d{4}-\\d{8}) (.*)");
  private static Pattern CODE_CALL_ADDR_PTN = Pattern.compile("([A-Z\\d]+) - (.*)");

  @Override
  protected boolean parseMsg(String body, Data data) {
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    data.strDate = match.group(1);
    data.strTime = match.group(2);
    data.strCallId = match.group(3);
    String addr = match.group(4).trim();
    
    // Strip off city.  City is usually doubled up
    int pt = addr.lastIndexOf(',');
    if (pt >= 0) {
      String city = addr.substring(pt+1).trim();
      addr = addr.substring(0,pt);
      
      int len = city.length();
      if (len % 2 != 0) {
        pt = len/2;
        if (city.charAt(pt) == ' ') {
          String part1 = city.substring(0,pt);
          if (part1.equals(city.substring(pt+1))) city = part1;
        }
      }
      data.strCity = city;
    }
    
    // Call / address comes in two forms, one with dash and one without
    match = CODE_CALL_ADDR_PTN.matcher(addr);
    if (match.matches()) {
      data.strCode = match.group(1);
      addr = match.group(2).trim();
      parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ | FLAG_ANCHOR_END, addr, data);
    } else {
      pt = addr.indexOf(' ');
      if (pt < 0) return false;
      data.strCode = addr.substring(0,pt);
      addr = addr.substring(pt+1).trim();
      parseAddress(addr, data);
    }
    return true;
  }
  
  private static String[] MW_STREETS = new String[]{
    "AURUM HILL",
    "BARKER TRAIL",
    "BEAR GRASS",
    "BLACK BEAR",
    "COOLEY WOODS",
    "CROOKED PINE",
    "DORSEY BROTHERS",
    "DUKES CREEK FALLS",
    "DUNCAN BRIDGE",
    "EAST KYTLE",
    "GOAT NECK",
    "HERMAN WINKLER",
    "HIGHLAND FOREST",
    "HOLINESS CAMPGROUND",
    "HOOD ACRES",
    "HOOTENANNY HILLS",
    "HORACE FITZPATRICK",
    "JOE FRANKLIN",
    "LAUREL RIDGE",
    "LITTLE HAWK",
    "LITTLE ROCK",
    "LONG MOUNTAIN",
    "MOSSY ACRES",
    "MOSSY CREEK METHODIST CHURCH",
    "NORTH BROOKS",
    "NORTH MAIN",
    "OAK RIDGE",
    "OAK RIDGE",
    "PARADISE VALLEY",
    "PINE BROOK",
    "QUAIL RIDGE",
    "RICHARD RUSSELL SCENIC",
    "RIVER BRIDGE",
    "ROY POWERS",
    "SAM CRAVEN",
    "SKITTS MOUNTAIN",
    "SKUNK HOLLOW",
    "SOUTH MAIN",
    "STEVE LEWIS",
    "TALL PINE",
    "THE PINES",
    "TIN MAN",
    "TOM BELL",
    "TOWN CREEK",
    "TRAY MOUNTAIN",
    "TWIN LAKES",
    "WEST FARM",
    "WHITE OAK"
  };
  
  private static CodeSet CALL_LIST = new CodeSet(new String[]{
      "ABDOMINAL PAIN",
      "ACCIDENT / UNKNOWN INJURY",
      "ALTERED LEVEL OF CONCIOUSNESS",
      "APPARENT DEATH",
      "BRUSH / GRASS / WOODS FIRE",
      "CANCER PATIENT",
      "DIFFICULTY IN BREATHING",
      "EVALUATE PATIENT",
      "FRACTURE",
      "GROUND LEVEL FALL",
      "PATIENT FELL 6FT OR MORE",
      "PATIENT WITH HEART PROBLEMS",
      "RESIDENTIAL FIRE",
      "RESIDENTIAL FIRE ALARM",
      "SEIZURES",
      "STROKE",
      "SYNCOPAL EPISODE (FAINTING)",
      "UNCONSCIOUS PATIENT",
      "UNRESPONSIVE PATIENT",
      
  });
}
