package net.anei.cadpage.parsers.KS;

import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA21Parser;


public class KSSedgwickCountyParser extends DispatchA21Parser {
  
  public KSSedgwickCountyParser() {
    super(CITY_CODES, "SEDGWICK COUNTY", "KS");
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
      "ALRGY",    "Allergic Reaction",
      "ANBITE",   "Animal Bite",
      "APT",      "Apartment Fire",
      "APTT",     "Apartment Fire with Person Trapped",
      "ASLT",     "Assault ",
      "BACK",     "Back Pain",
      "BARN",     "Barn Fire",
      "BLDG",     "Building Fire",
      "BLDGHZ",   "Building Fire with Haz Mat",
      "BLDGPT",   "Building Fire with Person Trapped",
      "BLUE",     "Code Blue ",
      "BURN",     "Burn victim",
      "BUS",      "Bus Fire",
      "CAVEIN",   "Cave in ",
      "CHEST",    "Chest Pain",
      "CHOKE",    "Choking ",
      "CLUB",     "Clubbing",
      "COLD",     "Cold or Heat exposure",
      "CUTTING",  "Cutting",
      "DEATH",    "Possible Death",
      "DIABET",   "Diabetic Emergency",
      "DIFFBR",   "Difficulty Breathing",
      "EYE",      "Eye Injury",
      "FALL",     "Fall",
      "GARAGE",   "Garage Fire",
      "HEAD",     "Head Injury",
      "HEART",    "Heart Attack",
      "HEAT",     "Heat related emergency",
      "HEMOR",    "Hemorrhage ",
      "HIRISE",   "High Rise Fire",
      "HIRIST",   "High Rise Fire with person trapped",
      "HOUSE",    "House Fire",
      "HOUSET",   "House Fire with person trapped",
      "HZ2",      "Haz Mat Level 2",
      "HZ3",      "Haz Mat Level 3",
      "HZ6",      "Haz Mat Level 6",
      "HZSM",     "Haz Mat Smell",
      "ICTAIR",   "Airport Emergency",
      "INDACC",   "Industrial Accident",
      "LACER",    "Laceration",
      "MA",      "Medical Alarm ",
      "NOTBR",    "Patient not breathing",
      "OB",      "Obstetrical Emergency ",
      "OD",      "Overdose",
      "PLANE",    "Plane Accident",
      "POISON",   "Poison",
      "RV",      "RV Fire",
      "SEIZUR",   "Seizure",
      "SEMI",     "Semi Fire",
      "SHED",     "Shed Fire",
      "SHOCK",    "Shock Victim",
      "SHOOT",    "Shooting",
      "SICK",     "Sick Person",
      "SMKIN",    "Check Smoke Inside",
      "STROKE",   "Stroke",
      "SUB",      "Submersion",
      "SUICID",   "Suicide",
      "SYSB",     "System alarm on a business",
      "TRAIN",    "Train Fire",
      "TRAP",     "Person Trapped",
      "TRAUMA",   "Trauma",
      "UNCON",    "Unconscious",
      "UNKE",     "Unknown Emergency",
      "UNKF",     "Unknown Fire",
      "WHEAT",    "Standing Wheat Fire",

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
