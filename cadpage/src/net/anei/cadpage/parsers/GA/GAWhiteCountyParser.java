package net.anei.cadpage.parsers.GA;

import java.util.Properties;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA48Parser;

public class GAWhiteCountyParser extends DispatchA48Parser {

  public GAWhiteCountyParser() {
    super(CITY_LIST, "WHITE COUNTY", "GA", FieldType.X,  A48_OPT_ONE_WORD_CODE);
    setupMultiWordStreets(MW_STREETS);
    setupCallList(CALL_LIST);
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!super.parseMsg(subject, body, data)) return false;
    if (data.strCode.length() == 0) {
      String call = CALL_CODES.getProperty(data.strCall);
      if (call !=  null) {
        data.strCode = data.strCall;
        data.strCall = call;
      }
    }
    return true;
  }

  private static String[] MW_STREETS = new String[]{
    "ADAIR MILL",
    "AURUM HILL",
    "BARKER TRAIL",
    "BEAR GRASS",
    "BEAVER CREEK",
    "BLACK BEAR",
    "CENTER BAPTIST CHURCH",
    "COOLEY WOODS",
    "CROOKED PINE",
    "DEAN MOUNTAIN",
    "DEER PATH",
    "DOCK DORSEY",
    "DORSEY BROTHERS",
    "DOUG ALLISON",
    "DUKES CREEK FALLS",
    "DUNCAN BRIDGE",
    "EAST KYTLE",
    "GARLAND BRISTOL",
    "GOAT NECK",
    "HAWKS BLUFF",
    "HERMAN WINKLER",
    "HICKORY HILL",
    "HIDDEN VALLEY",
    "HIGHLAND FOREST",
    "HOLINESS CAMPGROUND",
    "HOOD ACRES",
    "HOOTENANNY HILLS",
    "HORACE FITZPATRICK",
    "HORSE HILL",
    "HUDSON QUARRY",
    "J BROWN",
    "JOE BLACK",
    "JOE FRANKLIN",
    "LAUREL RIDGE",
    "LITTLE HAWK",
    "LITTLE ROCK",
    "LOGANS RIDGE",
    "LONG MOUNTAIN",
    "MISTY CREEK",
    "MOBILE HOME",
    "MOSSY ACRES",
    "MOSSY CREEK METHODIST CHURCH",
    "MOUNT PLEASANT CHURCH",
    "MOUNTAIN SHADOWS",
    "MYRA BRANCH",
    "NORTH BROOKS",
    "NORTH MAIN",
    "OAK RIDGE",
    "OAK RIDGE",
    "PARADISE VALLEY",
    "PETES PARK",
    "PINE BROOK",
    "QUAIL RIDGE",
    "RICHARD RUSSELL SCENIC",
    "RIVER BRIDGE",
    "ROLLER RINK",
    "ROLLING MEADOWS",
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
    "TURKEY FLATS",
    "TWIN LAKES",
    "UNDERWOOD FARM",
    "WEBB WEST",
    "WEST FARM",
    "WHISKEY STILL",
    "WHITE OAK",
    "WHITEHALL COMMONS"

  };
  
  private static final Properties CALL_CODES = buildCodeTable(new String[]{
      "44A",    "SUICIDE ATTEMPT BY __________",
      "50I",    "ACCIDENT / INJURIES",
      "50U",    "ACCIDENT / UNKNOWN INJURY",
      "ABDOM",  "ABDOMINAL PAIN",
      "ALRMM",  "MEDICAL ALARM ACTIVATION",
      "ALTLOC", "ALTERED LEVEL OF CONCIOUSNESS",
      "BP",     "BLOOD PRESSURE PROBLEMS",
      "CHDIB",  "CHEST PAIN & DIFF BREATHING",
      "CHEST",  "CHEST PAIN",
      "CHOKIN", "CHOKING PATIENT",
      "DIABET", "DIABETIC PATIENT",
      "DIB",    "DIFFICULTY IN BREATHING",
      "EVAL",   "EVALUATE PATIENT",
      "GASLK",  "GAS LEAK",
      "GFALL",  "GROUND LEVEL FALL",
      "HEART",  "PATIENT WITH HEART PROBLEMS",
      "HFALL",  "PATIENT FELL 6FT OR MORE",
      "LACERA", "LACERATION/PUNCTURE ACCIDENTAL",
      "OB",     "OB PATIENT",
      "OD",     "OVERDOSE OR POISONING",
      "SEIZUR", "SEIZURES",
      "SICKNV", "SICK PERSON NAUSEA VOMITING",
      "SICK",   "SICK PERSON",
      "SMOKE",  "SMOKE INVESTIGATION",
      "UNCON",  "UNCONSCIOUS PATIENT",
      "UNRESP", "UNRESPONSIVE PATIENT"
  });
  
  private static final CodeSet CALL_LIST = new CodeSet(new String[]{
      "16R",
      "50E",
      "50NI",
      "70B",
      "70BE",
      "70M",
      "70R",
      "70V",
      "911 HANG UP CALL",
      "911 OPEN LINE",
      "ABANDONED VEHICLE",
      "ABANDONMENT OF CHILD/FAMILY",
      "ABDOMINAL PAIN",
      "ABUSE CASE",
      "ACCIDENT / ENTRAPMENT",
      "ACCIDENT / INJURIES",
      "ACCIDENT / UNKNOWN INJURY",
      "ACTIVE SHOOTER",
      "AIRPLANE CRASH",
      "ALARM ON TEST MODE",
      "ALRMCO",
      "ALCOHOL POSSESSION",
      "ALLERGIC REACTION",
      "ALRMCM",
      "ALRMRS",
      "ALTERED LEVEL OF CONCIOUSNESS",
      "AMBER/LEVI ALERTS/MATTIES CALL",
      "AMBULANCE REQUESTED",
      "ANIMAL CALL IN PROGRESS",
      "ANIMAL CALL REPORT ONLY",
      "ANIMAL CRUELTY CALL",
      "ANIMAL INJURIED",
      "ANIMAL/SNAKE/INSECT BITE",
      "APPARENT DEATH",
      "ARMED ROBBERY ALARM",
      "ARMED ROBBERY REPORT",
      "ASSAULT REPORT",
      "ASSIST FIRE DEPT. REFERENCE __",
      "ASSIST LAW ENFORCEMENT ____",
      "ASSIST MOTORIST",
      "ASSISTANCE NEEDED",
      "ATTEMPTING TO STOP",
      "BACK INJURY",
      "BANK ALARM",
      "BE ON THE LOOKOUT",
      "BIOLOGICAL HAZARD",
      "BLOOD PRESSURE PROBLEMS",
      "BOATING ACCIDENT",
      "BOMB THREAT",
      "BOND OUT SUBJECT FROM JAIL",
      "BOOKING IN SUBJECT",
      "BRUSH / GRASS / WOODS FIRE",
      "BRUSH FIRE WITH EXPOSURES",
      "BURGLARY ALARM",
      "BURGLARY IN PROGRESS",
      "BURGLARY REPORT",
      "BURGLARY",
      "BURN PATIENT",
      "CALL BY PHONE",
      "CALLS FOR WATER DEPT PROBLEMS",
      "CANCER PATIENT",
      "CAR JACKING",
      "CARDIAC ARREST",
      "CHASE IN PROGRESS",
      "CHEST PAIN & DIFF BREATHING",
      "CHEST PAIN & DIFF. BREATHING",
      "CHEST PAIN",
      "CHILD ABUSE/MOLESTATION",
      "CHOKING PATIENT",
      "CITY ORDINANCE VIOLATION",
      "CIVIL PROCESS EVICTION",
      "CIVIL PROCESS",
      "CO ALARM ACTIVIATION",
      "COMMERCIAL FIRE ALARM",
      "COMMERCIAL FIRE",
      "COUNTY ORDINANCE VIOLATION",
      "COURT DETAIL",
      "CRIMINAL TRESPASS",
      "DAMAGE TO PROPERTY",
      "DEBRIS IN ROADWAY",
      "DEFACS CALL",
      "DELIVER MESSAGE",
      "DIABETIC PATIENT",
      "DIFFICULTY IN BREATHING",
      "DIRECT TRAFFIC FOR",
      "DISPUTE (INDICATE TYPE)",
      "DISTURBANCE",
      "DIVING FROM BRIDGE OR OTHER",
      "DOG CALL",
      "DOMESTIC IN-PROGRESS/PHYSICAL",
      "DOMESTIC IN-PROGRESS/VERBAL",
      "DOMESTIC REPORT ONLY",
      "DOMESTIC",
      "DRIVERS LICENSE INFO",
      "DRIVERS/CRIMINAL HISTROY REQ.",
      "DROWNING",
      "DRUG SUSPECT",
      "DUPLICATE CALL",
      "ELECTRIC OR POWER PROBELEMS",
      "ELEVATOR CALL",
      "EMERGENCY ROAD REPAIR",
      "ENTERING AUTO",
      "ENTRAPMENT - MACHINERY",
      "ESCORT",
      "EVALUATE PATIENT",
      "EXPLOSION",
      "EXTRA PATROL",
      "FAINT",
      "FALSE CALL OR REPORT",
      "FIGHT",
      "FIRE ALARM",
      "FIRE INVESTIGATION",
      "FIRE",
      "FIRE-MISCELLANEOUS / UNKNOWN",
      "FLAGGED DOWN BY....",
      "FLOODING",
      "FOLLOW UP REPORT",
      "FOOT PATROL",
      "FOR YOUR INFORMATION",
      "FORGERY",
      "FOUND ITEM OR PERSON",
      "FRACTURE",
      "FRAUD",
      "FUNERAL ESCORT",
      "FYI",
      "GAS LEAK",
      "GROUND LEVEL FALL",
      "GUNMAN",
      "GUNSHOT WOUND",
      "HARRASSMENT",
      "HAZARDOUS MATERIALS INCIDENT",
      "HAZARDOUS MATERIALS",
      "HEMORRHAGING",
      "HIT & RUN NO INJURIES",
      "HIT & RUN UNKNOWN INJURIES",
      "HIT & RUN WITH INJURIES",
      "HOLD EVIDENCE",
      "HOSITAGE SITUATION",
      "ILLEGAL DUMPING",
      "ILLEGAL",
      "ILLEGBRN",
      "IMPROPERLY PARKED VEHICLE",
      "IN THE AREA",
      "INDECENT EXPOSURE",
      "INFORMATION PURPOSES ONLY",
      "INJURY",
      "INTOXICATED DRIVER",
      "INTOXICATED PEDESTRIAN",
      "JUVENILE PROBLEM",
      "KEYS LOCKED IN VEH W/ OCCUPANT",
      "KIDNAPPING",
      "LACERATION/PUNCTURE ACCIDENTAL",
      "LACERATION/PUNCTURE INTENTIONA",
      "LINES DOWN",
      "LIVESTOCK / CARCASS",
      "LOCKED",
      "LOITERING",
      "LOST ITEM",
      "LOST PERSON",
      "MA",
      "MECHANICAL BREAKDOWN",
      "MEDICAL ALARM ACTIVATION",
      "MEET IN PERSON",
      "MENTAL DISORDER PATIENT",
      "MENTAL PATIENT TRANSP. BY OFC",
      "MENTAL SUBJECT",
      "MISSING PERSON",
      "MOUNTAIN RESCUE",
      "MULTI-INJURY INCIDENT",
      "MURDER REPORTED",
      "MUTUAL AID",
      "MVA LARGE PASSENGER VEHICLE",
      "NEGLECT",
      "NOT OTHERWISE SPECIFIED",
      "NURSELINE CALLS",
      "OB PATIENT",
      "OBSCENE CALL",
      "OBSTRUCTION OF OFFICER",
      "ODOR",
      "ODOR OF",
      "OPEN DOOR BUSINESS/RESIDENCE",
      "OVERDOSE OR POISONING",
      "OVERDUE",
      "PANDERING",
      "PANIC ATTACK",
      "PATIENT ELECTROCUTED",
      "PATIENT FELL 6FT OR MORE",
      "PATIENT W/ FLU LIKE SYMPTOMS",
      "PATIENT WITH HEART PROBLEMS",
      "PEASON WITH WEAPON",
      "PICKUP PRISONER / SUBJECT",
      "POSSIABLE DAM FAILURE",
      "PRISON / JAIL ESCAPE",
      "PRISONER / SUBJECT IN CUSTODY",
      "PROSTITUTION",
      "PROWLER REPORT",
      "PUBLIC ASSIST",
      "RALLY/PUBLIC DEMONSTRATION",
      "RECKLESS DRIVING / CONDUCT",
      "RECOVERY REPORT",
      "REFUSE - SUBJECT REFUSING...",
      "REGISTRY CHECK FOR SEX OFFENDE",
      "REKINDLE FIRE",
      "RELAY",
      "REPEAT CALL",
      "REPOSSESSION",
      "RESIDENCE CHECK",
      "RESIDENTIAL FIRE ALARM",
      "RESIDENTIAL FIRE",
      "RIOT",
      "ROAD BLOCKED",
      "ROAD RAGE",
      "RUNAWAY JUVENILE",
      "SANITATION PROBLEM",
      "SCHOOL CROSSING / TRAFFIC",
      "SEARCH WARRANT",
      "SECURE CRIME SCENE",
      "SECURITY CHECK/BUSINESS CHECK",
      "SEIZURES",
      "SEXUAL ASSAULT REPORTED",
      "SHOTS FIRED CALL",
      "SICK PERSON NAUSEA VOMITING",
      "SICK PERSON RUNNING A FEVER",
      "SICK PERSON",
      "SMOKE INVESTIGATION",
      "SNAKE - ADVISE LOCATION",
      "SOLICITATION",
      "SPECIAL DETAIL",
      "SPEEDING VEHICLE",
      "STALKING",
      "STROKE",
      "SUBJECT PERSUIT (CLI)",
      "SUBJECT SCREAMING",
      "SUICIDE ATTEMPT BY __",
      "SUICIDE ATTEMPT BY __________",
      "SUICIDE THREAT",
      "SUICIDE",
      "SURVELLIANCE",
      "SUSPICIOUS PERSON ",
      "SUSPICIOUS PERSON/VEHICLE",
      "SUSPICIOUS SUBJECT STOP (CLI)",
      "SUSPICIOUS VEHICLE",
      "SYNCOPAL EPISODE (FAINTING)",
      "TAKING REPORT",
      "TEST CALL",
      "THEFT REPORT",
      "THREATS",
      "TRAFFIC ACCIDENT NO INJURIES",
      "TRAFFIC HAZARD",
      "TRAFFIC LIGHT OUT",
      "TRAFFIC SAFETY CHECK",
      "TRAFFIC STOP",
      "TRAILER INSPECTION",
      "TRANSFER CALL TO OTHER AGENCY",
      "TRANSPORT PATIENT",
      "TREE DOWN /  TREE ACC RDWAY",
      "TRESPASSING REPORT",
      "UNCONSCIOUS PATIENT",
      "UNK",
      "UNKNOWN PROBLEM",
      "UNRESPONSIVE PATIENT",
      "VANDALISM REPORT",
      "VEHICLE FIRE",
      "VEHICLE REGISTRATION INFO",
      "VEHICLE TAKEN W/O PERMISSION",
      "VIN VERIFICATION",
      "VIOLATION OF GA CONTROLLED SUB",
      "WALK IN REPORT",
      "WALK THRU",
      "WANTED / STOLEN INDICATED",
      "WANTED PERSON/WARRANT",
      "WARRANT SERVICE ATTEMPT",
      "WEATHER ACTIVITY",
      "WELFARE CHECK",
      "WILD ANIMAL CALLS",
      "WRECKER NEEDED"
  });
  
  private static final String[] CITY_LIST = new String[]{

    // Cities
    "CLEVELAND",
    "HELEN",

    // Unincorporated Communities
    "MOSSY CREEK",
    "NACOOCHEEE",
    "ROBERTSTOWN",
    "SAUTEE",
    "SAUTEE-NACOOCHEE",
    "SCORPION HOLLOW",
    "SHOAL CREEK"
    
  };
}
