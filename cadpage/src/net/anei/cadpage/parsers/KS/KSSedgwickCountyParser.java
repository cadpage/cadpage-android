package net.anei.cadpage.parsers.KS;

import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA21Parser;


public class KSSedgwickCountyParser extends DispatchA21Parser {
  
  public KSSedgwickCountyParser() {
    super(CITY_CODES, CALL_CODES, "SEDGWICK COUNTY", "KS");
  }
  
  @Override
  public String getFilter() {
    return "cad_admin@sedgwick.gov";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    String[] parts = subject.split("\\|");
    if (parts.length != 2 || !parts[0].equals("CommandPoint CAD Message")) return false;
    return super.parseMsg(parts[1], body, data);
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    addr = KNN_PTN.matcher(addr).replaceAll("STATE $1");
    return addr;
  }
  private static final Pattern KNN_PTN = Pattern.compile("\\bK(\\d+)\\b");
  
  private static final Properties CALL_CODES = buildCodeTable(new String[]{
      "48HZ",     "Vehicle accident with Haz Mat",
      "48T",      "Vehicle Accident with Pin",
      "ABDOM",    "Abdominal Pain",
      "ABDUCT",   "Abduction",
      "ALRGY",    "Allergic Reaction",
      "ANBIT",    "Animal Bite",
      "ANBITE",   "Animal Bite",
      "APT",      "Apartment Fire",
      "APTT",     "Apartment Fire with Person Trapped",
      "ASLT",     "Assault",
      "ASSTP",    "Assist Law Enforcement",
      "AUD",      "Audible Alarm",
      "BACK",     "Back Pain",
      "BARN",     "Barn Fire",
      "BLDG",     "Building Fire",
      "BLDGH",    "Building Fire with Haz Mat",
      "BLDGHZ",   "Building Fire with Haz Mat",
      "BLDGP",    "Building Fire with Person Trapped",
      "BLDGPT",   "Building Fire with Person Trapped",
      "BLUE",     "Code Blue",
      "BURN",     "Burn victim",
      "BUS",      "Bus Fire",
      "CAVEI",    "Cave in",
      "CAVEIN",   "Cave in",
      "CHEST",    "Chest Pain",
      "CHOKE",    "Choking",
      "CKCLUB",   "Check a Club",
      "CLUB",     "Clubbing",
      "COALM",    "Carbon Monoxide Alarm",
      "COLD",     "Cold or Heat exposure",
      "CUTTIN",   "Cutting",
      "CUTTING",  "Cutting",
      "DEATH",    "Possible Death",
      "DIABE",    "Diabetic Emergency",
      "DIABET",   "Diabetic Emergency",
      "DIFFB",    "Difficulty Breathing",
      "DIFFBR",   "Difficulty Breathing",
      "EYE",      "Eye Injury",
      "FALL",     "Fall",
      "FIROUT",   "Check a fire that is out",
      "GARAG",    "Garage Fire",
      "GARAGE",   "Garage Fire",
      "GASIN",    "Check Gas in a Building",
      "HEAD",     "Head Injury",
      "HEART",    "Heart Attack",
      "HEAT",     "Heat related emergency",
      "HEMOR",    "Hemorrhage",
      "HIRIS",    "High Rise Fire",
      "HIRISE",   "High Rise Fire",
      "HIRIST",   "High Rise Fire with person trapped",
      "HOUSE",    "House Fire",
      "HOUSET",   "House Fire with person trapped",
      "HZ2",      "Haz Mat Level 2",
      "HZ3",      "Haz Mat Level 3",
      "HZ6",      "Haz Mat Level 6",
      "HZSM",     "Haz Mat Smell",
      "ICTAI",    "Airport Emergency",
      "ICTAIR",   "Airport Emergency",
      "INDAC",    "Industrial Accident",
      "INDACC",   "Industrial Accident",
      "LACER",    "Laceration",
      "LOSTJ",   "Lost Juvenile",
      "MA",       "Medical Alarm",
      "MISCF",    "Miscellaneous Service",
      "MSGF",     "Message for Fire Service",
      "MSGP",     "Message for Law Enforcement",
      "NOTBR",    "Patient not breathing",
      "OB",       "Obstetrical Emergency",
      "OD",       "Overdose",
      "PLANE",    "Plane Accident",
      "POISO",    "Poison",
      "POISON",   "Poison",
      "POLE",     "Pole on Fire",
      "RV",       "RV Fire",
      "SA",       "System Alarm",
      "SC",       "Suspicious Character",
      "SEIZU",    "Seizure",
      "SEIZUR",   "Seizure",
      "SEMI",     "Semi Fire",
      "SHED",     "Shed Fire",
      "SHOCK",    "Shock Victim",
      "SHOOT",    "Shooting",
      "SICK",     "Sick Person",
      "SMKIN",    "Check Smoke Inside",
      "STROK",   "Stroke",
      "STROKE",   "Stroke",
      "SUB",      "Submersion",
      "SUICI",    "Suicide",
      "SUICID",   "Suicide",
      "SYSB",     "System Alarm on a Business",
      "SYSR",     "System Alarm on a Residence",
      "TRAFIC",   "Traffic Incident",
      "TRAIN",    "Train Fire",
      "TRAP",     "Person Trapped",
      "TRAUM",    "Trauma",
      "TRAUMA",   "Trauma",
      "UNCON",    "Unconscious",
      "UNKE",     "Unknown Emergency",
      "UNKF",     "Unknown Fire",
      "WHEAT",    "Standing Wheat Fire",
      "XFER",     "Emergency Medical Transfer - Non emergency"

  });
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "AN", "ANDALE",
      "BA", "BEL AIRE",
      "BE", "BENTLEY",
      "CH", "CHENEY",
      "CL", "CLEARWATER",
      "CO", "COLWICH",
      "DE", "DERBY",
      "EB", "EASTBOROUGH",
      "FU", "FURLEY",
      "GP", "GARDEN PLAIN",
      "GR", "GREENWICH",
      "HA", "HAYSVILLE",
      "KE", "KECHI",
      "MA", "MAIZE",
      "MC", "MCCONNELL",
      "MH", "MT HOPE",
      "MU", "MULVANE",
      "PC", "PARK CITY",
      "PE", "PECK",
      "SC", "",          // SEDGWICK COUNTY???
      "SH", "SCHULTE",
      "VC", "VALLEY CENTER",
      "VI", "VIOLA",
      "WI", "WICHITA",

  });
}
