package net.anei.cadpage.parsers.OR;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeTable;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA3Parser;

public class ORYamhillCountyParser extends DispatchA3Parser {

  public ORYamhillCountyParser() {
    super("CAD:", CITY_LIST, "YAMHILL COUNTY", "OR", "INFO");
  }

  @Override
  public String getProgram() {
    return "ADDR APT CITY CODE CALL PRI UNIT " + super.getProgram();
  }

  private static Pattern MASTER = Pattern.compile("CAD:(.*?) (\\d{2}/\\d{2}/\\d{4} \\d{2}:\\d{2}:\\d{2} : pos\\d .*?)");
  private static Pattern PRI_UNIT = Pattern.compile("(\\d) +(.*?)");

  @Override
  public boolean parseMsg(String body, Data data) {

    Matcher mat = MASTER.matcher(body);
    if (!mat.matches()) return false;

    // address etc
    parseAddress(StartType.START_ADDR, FLAG_RECHECK_APT, mat.group(1).replace("//", "&"), data);
    String whatsLeft = getLeft();

    // code and call. if code isn't found then whole string is passed to call
    CodeTable.Result res = CODE_TABLE.getResult(whatsLeft);
    if (res == null) data.strCall = whatsLeft;
    else {
      data.strCode = res.getCode();
      data.strCall = res.getDescription();
      whatsLeft = whatsLeft.substring(data.strCode.length());
      // separate priority from unit, if pat doesn't match then pass whole string to unit
      Matcher puMat = PRI_UNIT.matcher(whatsLeft);
      if (puMat.matches()) {
        data.strPriority = puMat.group(1);
        data.strCode += data.strPriority;
        data.strUnit = puMat.group(2);
      } else data.strUnit = whatsLeft.trim();
    }

    return super.parseFields(new String[] { mat.group(2) }, data);
  }

  private static String[] CITY_LIST = {
    "AMITY",
    "CARLTON",
    "DAYTON",
    "DUNDEE",
    "LAFAYETTE",
    "HILLSBORO",
    "MCMINVILLE",
    "NEWBERG",
    "SHERIDAN",
    "SHERWOOD",
    "WILLAMINA",
    "WILSONVILLE",
    "YAMHILL"};
  
  private static CodeTable CODE_TABLE = new CodeTable(
      "FIRE AIRCRFT",         "Aircraft Crash",
      "FIRE ALARM",           "Fire Alarm",
      "FIRE AL-CO",           "CO Alarm",
      "FIRE AL-ELEV",         "Elevator Alarm",
      "FIRE AL-MED",          "Medical Alarm",
      "FIRE ASSIST",          "Public Assist",
      "FIRE BARK",            "Barkdust Fire",
      "FIRE BARN",            "Barn Fire",
      "FIRE BOAT",            "Boat Fire",
      "FIRE CAR",             "Vehicle Fire",
      "FIRE CHIMNEY",         "Chimney Fire",
      "FIRE COLAPSE",         "Building Collapse",
      "FIRE COMM",            "Commercial Fire",
      "FIRE ELEC",            "Electrical Fire",
      "FIRE EXPLOS",          "Explosion",
      "FIRE GAS",             "Gas Fire",
      "FIRE GASLEAK",         "Natural Gas/LPG Leak",
      "FIRE GRASS",           "Grass Fire",
      "FIRE HAZMAT",          "Spill",
      "FIRE ILLEGAL",         "Burn Complaint",
      "FIRE INVEST",          "Fire Investigation",
      "FIRE LRG TK",          "Large Truck Fire",
      "FIRE MOVEUP",          "Fire Move-UP",
      "FIRE MUTUAL",          "Fire Mutual Aid",
      "FIRE OTHER",           "MISC/Unknown Fire",
      "FIRE POLE",            "Pole Fire",
      "FIRE RES",             "Residential Fire",
      "FIRE SMLBLDG",         "Small Building Fire",
      "FIRE SMOKE",           "Smoke/Odor Investigation",
      "FIRE SPILL",           "Small HazMat Spill",
      "FIRE STANDBY",         "NFD Personnel Station Standby",
      "FIRE TRASH",           "Dumpster/Trash Fire",
      "FIRE TREE",            "Tree Down",
      "FIRE WATER",           "Water Problem",
      "FIRE WILDLAN",         "Wildland Fire",
      "FIRE WIRES",           "Wires Down",
      "MVC BOAT",             "Boat Crash",
      "MVC TRAIN",            "Train Crash",
      "MVCI",                 "Motor Vehicle Crash",
      "RES ELEV",             "Elevator Entrapment",
      "RES OTHER MISC",       "Rescue",
      "RES ROPE",             "Rope Rescue",
      "RES SEARCH",           "Search and Rescue",
      "RES TRENCH",           "Confined Space/Trench Rescue",
      "RES WATER MA",         "Water Rescue Mutual Aid",
      "ABDOM",                "Abdominal Pain",
      "ALREAC",               "Allergic Reaction",
      "ANIMAL",               "Animal Bite",
      "ASSAULT",              "Assault",
      "BACK",                 "Back Pain",
      "BLEED",                "Bleeding Problem",
      "BREATH",               "Breathing Problem",
      "BURN",                 "Burn Patient",
      "CHEST",                "Chest Pain",
      "CHOKE",                "Choking",
      "DIAB",                 "Diabetic Problem",
      "DROWN",                "Drowning",
      "EXPOSE",               "Environmental Exposure",
      "FALL",                 "FALL",
      "GSW",                  "Gun Shot Wound",
      "HA",                   "Headache",
      "INDUSTACC",            "Industrial Accident",
      "MENTAL",               "Mental Problem",
      "OB",                   "OB Emergency",
      "OD",                   "Overdose",
      "SEIZURE",              "Seizure",
      "SICKPERS",             "Sick Person",
      "STROKE",               "Stroke",
      "TOXIC",                "Toxic",
      "TRAUMA",               "Traumatic Injury",
      "UNCON",                "Unconscious",
      "UNKMED",               "Unknown Medical",
      "WATER RESCU",          "Water Rescue",
      "MED MA",               "Medical Mutual Aid",
      "TRANSFER",             "Interfacility Hospital Transfer",
      "MOVE UP",              "Medical Move Up",
      "LOCK OUT",             "Lock out");
}
