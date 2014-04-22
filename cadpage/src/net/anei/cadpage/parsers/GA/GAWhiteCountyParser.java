package net.anei.cadpage.parsers.GA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

public class GAWhiteCountyParser extends SmartAddressParser {

  public GAWhiteCountyParser() {
    super("WHITE COUNTY", "GA");
    setFieldList("CODE CALL ADDR PHONE X");
    setupMultiWordStreets(MW_STREETS);
    setupCallList(CALL_LIST);
  }

  private static Pattern MASTER = Pattern.compile("(\\d{2}[A-Z])?\\b(.*?)(?: (\\d{7}) (.*?))?");

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!body.startsWith("WHITE_CO_E911:")) return false;
    body = body.substring(14);

    Matcher mat = MASTER.matcher(body);
    if (!mat.matches()) return false;

    data.strCode = getOptGroup(mat.group(1));
    parseAddress(StartType.START_CALL, mat.group(2).trim(), data);
    data.strPhone = getOptGroup(mat.group(3));
    data.strCross = getOptGroup(mat.group(4));
    return true;
  }
  
  private static String[] MW_STREETS = new String[]{
    "BARKER TRAIL",
    "BEAR GRASS",
    "COOLEY WOODS",
    "CROOKED PINE",
    "DUKES CREEK FALLS",
    "DUNCAN BRIDGE",
    "EAST KYTLE",
    "GOAT NECK",
    "HERMAN WINKLER",
    "HIGHLAND FOREST",
    "HOLINESS CAMPGROUND",
    "HORACE FITZPATRICK",
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
    "RICHARD RUSSELL SCENIC",
    "RIVER BRIDGE",
    "SAM CRAVEN",
    "SKITTS MOUNTAIN",
    "SKUNK HOLLOW",
    "SOUTH MAIN",
    "STEVE LEWIS",
    "TALL PINE",
    "TIN MAN",
    "TOM BELL",
    "TOWN CREEK",
    "TRAY MOUNTAIN",
    "TWIN LAKES",
    "WHITE OAK"
  };
  
  private static CodeSet CALL_LIST = new CodeSet(new String[]{
    "ACCIDENT / ENTRAPMENT",
    "ACCIDENT / INJURIES",
    "ACCIDENT / UNKNOWN INJURY",
    "ALLERG ALLERGIC REACTION",
    "ALRMCM COMMERCIAL FIRE ALARM",
    "BRUSH / GRASS / WOODS FIRE",
    "CHOKIN CHOKING PATIENT",
    "COMMERCIAL FIRE",
    "DEATH APPARENT DEATH",
    "FAINT SYNCOPAL EPISODE (FAINTING)",
    "FIRE ALARM",
    "FIRE-MISCELLANEOUS / UNKNOWN",
    "INJURY INJURY",
    "LACER LACERATION/PUNCTURE INTENTIONA",
    "RESIDENTIAL FIRE",
    "UNCON UNCONSCIOUS PATIENT",
    "VEHICLE FIRE"
  });
}
