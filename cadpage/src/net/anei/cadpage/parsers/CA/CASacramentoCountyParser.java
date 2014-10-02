package net.anei.cadpage.parsers.CA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeTable;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.StandardCodeTable;

/**
 * Sacramento County, CA
 */
public class CASacramentoCountyParser extends MsgParser {
  
  private static final Pattern MASTER = Pattern.compile("([A-Z0-9]+)/([A-Z0-9]+)/([A-Z0-9]+)/([A-Z0-9]*,[A-Z0-9]*)\\(([^,\\)]+),([A-Z]+)\\)\\((.*?)(?:\\).*)?");
  
  public CASacramentoCountyParser() {
    super("SACRAMENTO COUNTY", "CA");
    setFieldList("SRC CODE CALL MAP MAP ADDR APT CITY UNIT");
  }
  
  @Override
  public String getFilter() {
    return "@CAD.GOV";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("CAD PAGE-Do not reply")) return false;
    
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) {
      data.strCall = "GENERAL ALERT";
      data.strPlace = body;
      return true;
    }
    
    data.strSource = match.group(1);
    data.strCode = match.group(2);
    data.strCall = CALL_CODES.getCodeDescription(data.strCode);
    if (data.strCall == null) data.strCall = data.strCode;
    data.strMap = match.group(3);
    String map = match.group(4);
    if (!map.equals(",")) data.strMap = data.strMap + '-' + map;
    parseAddress(match.group(5).replace('.', ' ').trim(), data);
    data.strCity = convertCodes(match.group(6), CITY_CODES);
    data.strUnit = match.group(7).trim();
    return true;
  }
  
  private static CodeTable CALL_CODES = new StandardCodeTable(
      "1",    "ABDOMINAL PAIN",
      "10",   "CHEST PAIN",
      "11",   "CHOKING",
      "12",   "SEIZURE",
      "13",   "DIABETIC PROBLEM",
      "14",   "DROWNING, NEAR DROWNING",
      "15",   "ELECTROCUTION, LIGHTNING",
      "16",   "EYE INJURY",
      "17",   "FALL",
      "18",   "HEADACHE",
      "19",   "HEART PROBLEMS",
      "2",    "ALLERGIC REACTION, ENVENOMATION",
      "20",   "EXPOSURE, HYPERTHERMIA, HYPOTHERMIA",
      "21",   "HEMORRAGE, BLEEDING",
      "22",   "INACCESSIBLE ENTRAPMENT (NON-MVA)",
      "23",   "OVERDOSE",
      "24",   "GYNECOLOGICAL",
      "25",   "PSYCHIATRIC - 5150",
      "26",   "SICK PERSON",
      "27",   "STABBING, SHOOTING, OTHER PENETRATING TRAUMA",
      "28",   "STROKE, CVA, TIA",
      "29",   "MVA, TRAFFIC RELATED",
      "3",    "ANIMAL BITE",
      "30",   "TRAUMA, AMPUTATION, ETC.",
      "31",   "SYNCOPE",
      "32",   "UNKNOWN (MAN DOWN, ETC.)",
      "4",    "ASSAULT, SEXUAL ASSAULT",
      "5",    "BACK PAIN",
      "6",    "BREATHING DIFFICULTY",
      "7",    "BURN",
      "8",    "CARBON MONOXIDE, INHALATION, HAZMAT",
      "9",    "CARDIAC OR RESPIRATORY ARREST",
      "AC1",  "MINOR IN FLIGHT EMERGENCY",
      "AC2",  "MAJOR IN FLIGHT EMERGENCY",
      "AC3",  "AIRCRAFT ACCIDENT",
      "AN",   "ANIMAL RESCUE",
      "CS",   "COMMERCIAL STRUCTURE",
      "CS1",  "COMMERCIAL STRUCTURE FIRE",
      "CS2",  "COMMERCIAL STRUCTURE FIRE",
      "CS3",  "COMMERCIAL STRUCTURE FIRE",
      "CSA",  "COMMERCIAL STRUCTURE APT",
      "CSH",  "HOSPITAL",
      "CSP",  "CONFINED SPACE RESCUE",
      "CSS",  "SCHOOL",
      "DUMP", "DUMPSTER FIRE",
      "ELV",  "ELEVATOR RESCUE",
      "EMI",  "ELEC MOTOR INSIDE",
      "EMO",  "ELEC MOTOR OUTSIDE",
      "EXP",  "EXPLOSION",
      "FC",   "FIRECRACKER",
      "FEN",  "FENCE FIRE",
      "FGI",  "FLAM. GAS LEAK INSIDE",
      "FGO",  "FLAM GAS LEAK OUTSIDE",
      "FL",   "FLOODING",
      "G",    "GRASS",
      "GRF",  "GRASS -- RED FLAG",
      "GS",   "GRASS STRUCTURE",
      "HM1",  "HAZ MAT LEVEL 1",
      "HM2",  "HAZ MAT LEVEL 2",
      "HM3",  "HAZ MAT LEVEL 3",
      "IAC",  "INTERNAL ALARM COMMERCIAL",
      "IAR",  "INTERNAL ALARM RESIDENTIAL",
      "IB",   "ILLEGAL BURN",
      "LAW",  "LAW ENFORCEMENT ASSIST",
      "LO",   "LOCK OUT",
      "LQ1",  "LIQUID SPILL",
      "LQ2",  "LIQUID SPILL",
      "M2",   "MEDICAL AID CODE 2",
      "M3",   "MEDICAL AID",
      "MA",   "MEDICAL AID LEVEL A",
      "MB",   "MEDICAL AID LEVEL B",
      "MC",   "MEDICAL AID LEVEL C",
      "MCI",  "MULTI CASUALTY INC",
      "MD",   "MEDICAL AID LEVEL D",
      "OT",   "OTHER",
      "PA",   "PUBLIC ASSISTANCE",
      "RC",   "RAIL CAR",
      "S",    "STRUCTURE",
      "S1",   "OUTBUILDING FIRE",
      "S2",   "STRUCTURE FIRE",
      "S3",   "STRUCTURE FIRE",
      "SD",   "SPECIAL DUTY",
      "SPR",  "SPECIAL RESCUE",
      "TCR",  "TECHNICAL RESCUE",
      "TRA",  "TRASH FIRE",
      "TRANS","TRANSFORMER",
      "TREE", "TREE FIRE",
      "VCS",  "VEH INTO COMM BLDG",
      "VF",   "VEHICLE FIRE",
      "VFC",  "COMM VEHICLE FIRE",
      "VFP",  "VEH FIRE PKG GARAGE",
      "VFT",  "TANKER FIRE",
      "VR",   "VERTICAL RESCUE",
      "VRS",  "VEH INTO HOUSE",
      "WD",   "WIRES DOWN",
      "WR1",  "STILL WATER RESCUE",
      "WR2",  "FLOWING WATER RESCUE"
  );
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "ARD", "ARDEN-ARCADE",
      "CIT", "CITRUS HEIGHTS",
      "CLF", "SACRAMENTO",           // ????
      "ELK", "ELK GROVE",
      "FOL", "FOLSOM",
      "GCY", "GALT",
      "HER", "HERALD",
      "LAG", "HOOD",                // ???
      "NHI", "NORTH HIGHLANDS",
      "RCO", "RANCHO CORDOVA",
      "RI",  "WALNUT GROVE",        // ????
      "RMU", "RANCHO MURIETA",
      "SAC", "SACRAMENTO",
      "SSC", "SACRAMENTO",          // ????
      "VIN", "VINEYARD",
      "WAL", "WALNUT GROVE",
      "WLT", "WILTON"

  });
}
