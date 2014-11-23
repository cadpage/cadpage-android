package net.anei.cadpage.parsers.KY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;



public class KYStatePoliceParser extends DispatchB2Parser {
  
  private static final Pattern PREFIX_PTN = Pattern.compile("^(?:KSP DRY RIDGE E-911|KSP CAMPBELLSBURG|911-CENTER):");
  
  private boolean srcFound;
  
  public KYStatePoliceParser() {
    this("");
  }
  
  public KYStatePoliceParser(String defCity) {
    super(CITY_LIST, defCity, "KY");
    setupCallList(CALL_LIST);
  }
  
  @Override
  public String getAliasCode() {
    return "KYStatePolice";
  }
  
  @Override
  public String getLocName() {
    return "Kentucky State Police";
  }
  
  @Override
  public String getFilter() {
    return "KSPCAMPBELLSBURG@P05.gov,KSPCAMPBELLSBURG@P05.org,KSPDRYRIDGEE-911@P06.gov,911-CENTER@P13.gov";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    Matcher match = PREFIX_PTN.matcher(body);
    srcFound = match.lookingAt();
    if (srcFound) body = body.substring(match.end());
    if (!super.parseMsg(body, data)) return false;
    if (data.strCity.endsWith(" CO")) data.strCity += "UNTY";
    return true;
  }

  @Override
  protected boolean isPageMsg(String body) {
    if (srcFound) return true;
    if (body.contains(" Cad:")) return true;
    return super.isPageMsg(body);
  }

  @Override
  protected boolean parseAddrField(String field, Data data) {
    field = field.replace('@', '&');
    return super.parseAddrField(field, data);
  }
  
  private static final CodeSet CALL_LIST = new CodeSet(
      "911 HANGUP OR UNVERIFIED",
      "ACCIDENT PROPERTY DAMAGE",
      "ACCIDENT WITH INJURIES",
      "ALARMS",
      "ALL EMS/MEDICAL CALLS",
      "ANIMAL COMPLAINT",
      "ASSAULT",
      "ATV ON HIGHWAY",
      "BOATER ASSISTS",
      "BOATING COMPLAINTS/VIOLATIONS",
      "BURGLARY",
      "CAD ERRORS/PROBLEMS",
      "CIVIL COMPLAINT",
      "CIVIL COMPLAINTS",
      "CO2 ALARMS",
      "COMPLIANCE CHECKS",
      "CRIMINAL ABUSE/CHILD",
      "CUSTODY DISPUTE",
      "DATA DRIVEN ENFORCEMENT PROGRA",
      "DEATH",
      "DISTURBANCE",
      "DOMESTIC",
      "DRIVE OFFS",
      "DRUG INFO",
      "DRUG OVERDOSE",
      "DUI COMPLAINT",
      "EPO/DVO VIOLATION",
      "EXTRA PATROL",
      "FATAL TFC ACCIDENTS",
      "FIGHT",
      "FIRE",
      "FIRE ALARM",
      "FIRE STRUCTURE HOUSE OR BUSINE",
      "FIRE STRUCTURE HOUSE OR BUSN",
      "FORGERY",
      "FOR INFORMATIONAL PURPOSES",
      "GAS LEAK",
      "HARASSMENT",
      "HAZARDOUS MATERIALS",
      "ILLEGAL BURNING INCIDENTS",
      "ILLEGAL GAMBLING",
      "INTOXICATED PERSON",
      "INVESTIGATION FOLLOW-UP",
      "JUVENILE BEYOND CONTROL",
      "LOCKED OUT (CAR & HOME)",
      "LOITERING",
      "MENTALLY ILL PERSON",
      "MISCELLANEOUS COMPLAINT",
      "MISCELLANEOUS EMS CALLS",
      "MISCELLANEOUS TRAFFIC COMPLNTS",
      "MISSING PERSON",
      "MOTORIST ASSIST",
      "NO OPERATORS LICENSE",
      "PROCESS SERVICE",
      "PROPERTY DISPUTE",
      "RAPE",
      "RECKLESS DRIVER",
      "RUN REPORT",
      "SCHOOL VISITS",
      "SEVERE WEATHER REPORTS/DAM",
      "SEX OFFEND REG FAIL TO COMPLY",
      "SEXUAL ABUSE CHILD",
      "SHOOTING",
      "SHOPLIFTING",
      "SOCIAL SERVICE REFERRALS",
      "STALKING",
      "SUICIDE ATTEMPT OR THREAT",
      "SURVEILLANCE/SPEC DETAILS",
      "SUSPICIOUS INCIDENT",
      "SUSPICIOUS PERSON",
      "SUSPICIOUS VEHICLE",
      "SUSP INDIVIDUAL ON SCENE (CLI)",
      "TERRORISTIC THREATENING",
      "THEFT COMPLAINT",
      "THEFT OF MEDICATION",
      "TRAFFIC CHECKPOINT",
      "TRAFFIC HAZARD",
      "TRESPASSING",
      "UTILITY TROUBLE/EMERGENCIES",
      "WANTED PERSON",
      "WARRANT SERVICE",
      "WELFARE CHECK",
      "WOODLAND FIRE INCIDENTS",
      "WOODLAND/WILDFIRE INCIDENTS"
  );

  private static final String[] CITY_LIST = new String[]{
    
    // Boone County
    "BOONE",
    "BOONE CO",
    "BOONE COUNTY",
    "FLORENCE",
    "UNION",
    "WALTON",
    "BURLINGTON",
    "OAKBROOK",
    "BIG BONE",
    "BULLITTSVILLE",
    "HAMILTON",
    "HEBRON",
    "PETERSBURG",
    "RABBIT HASH",
    "RICHWOOD",
    "VERONA",
    
    // Bourbon County
    "BOURBON",
    "BOURBON CO",
    "BOURBON COUNTY",
    "CANE RIDGE",
    "CENTERVILLE",
    "CLITONVILLE",
    "LITTLE ROCK",
    "MILLERSBURG",
    "NORTH MIDDLETOWN",
    "PARIS",

    // Bracken County
    "BRACKEN",
    "BRACKEN CO",
    "BRACKEN COUNTY",
    "AUGUSTA",
    "BROOKSVILLE",
    "GERMANTOWN",
    "FOSTER",
    "MILFORD",
    
    // Carroll County
    "CARROLL",
    "CARROLL CO",
    "CARROLL COUNTY",
    "CARROLLTON",
    "ENGLISH",
    "GHENT",
    "PRESTONVILLE",
    "SANDERS",
    "WORTHVILLE",
    
    // Franklin County
    "FRANKLIN",
    "FRANKLIN CO",
    "FRANKLIN COUNTY",
    "BRIDGEPORT",
    "FORKS OF ELKHORN",
    "FRANKFORT",
    "JETT",
    "SWITZER",

    // Gallatin COunty
    "GALLATIN",
    "GALLATIN CO",
    "GALLATIN COUNTY",
    "GLENCOE",
    "SPARTA",
    "WARSAW",
    
    // Grant County
    "GRANT",
    "GRANT CO",
    "GRANT COUNTY",
    "CORINTH",
    "CRITTENDEN",
    "DRY RIDGE",
    "JONESVILLE",
    "WILLIAMSTOWN",
    
    // Graves County
    "GRAVES",
    "GRAVES CO",
    "FELICIANA",
    "BELL CITY",
    "BOAZ",
    "CLEAR SPRINGS",
    "CUBA",
    "DOGWOOD",
    "DUBLIN",
    "DUKEDOM",
    "FOLSOMDALE",
    "HICKORY",
    "FANCY FARM",
    "FARMINGTON",
    "FELICIANA",
    "KALER",
    "LOWES",
    "LYNNVILLE",
    "MAYFIELD",
    "MELBER",
    "POTTSVILLE",
    "SEDALIA",
    "SYMSONIA",
    "VIOLA",
    "WATER VALLEY",
    "WEST VIOLA",
    "WESTPLAINS",
    "WINGO",
    
    // Harrison County
    "HARRISON",
    "HARRISON CO",
    "HARRISON COUNTY",
    "BERRY",
    "CYNTHIANA",
    "BRECKINRIDGE",
    "BROADWELL",
    "BUENA VISTA",
    "COLVILLE",
    "CONNERSVILLE",
    "HOOKTOWN",
    "LAIR",
    "LEES LICK",
    "LEESBURG",
    "KELAT",
    "MORNINGGLORY",
    "ODDVILLE",
    "POINDEXTER",
    "RUDDELS MILLS",
    "RUTLAND",
    "SHADYNOOK",
    "SHAWHAN",
    "SUNRISE",
    
    // Hart County
    "HART",
    "HART COUNTY",
    "BONNIEVILLE",
    "CANMER",
    "CUB RUN",
    "HAMMONVILLE",
    "HARDYVILLE",
    "HORSE CAVE",
    "LEGRANDE",
    "MONROE",
    "MUNFORDVILLE",
    "PRICEVILLE",
    "ROWLETTS",
    "UNO",

    // Henry County
    "HENRY",
    "HENRY CO",
    "HENRY COUNTY",
    "BETHLEHEM",
    "CAMPBELLSBURG",
    "DEFOE",
    "EMINENCE",
    "FRANKLINTON",
    "LOCKPORT",
    "NEW CASTLE",
    "PENDLETON",
    "PLEASUREVILLE",
    "PORT ROYAL",
    "SMITHFIELD",
    "SULPHUR",
    "TURNERS STATION",
    
    // Lyon County
    "LYON",
    "LYON COUNTY",
    "EDDYVILLE",
    "KUTTAWA",

    // Oldham County
    "OLDHAM",
    "OLDHAM CO",
    "OLDHAM COUNTY",
    "BALLARDSVILLE",
    "BROWNSBORO",
    "BUCKNER",
    "CENTERWOOD",
    "CRESTWOOD",
    "FLODSBURG",
    "GOSHEN",
    "LA GRANGE",
    "LAGRANGE",
    "ORCHARD GRASS HILLS",
    "PEWEE VALLEY",
    "PROSPECT",
    "RIVER BLUFF",
    "WESTPORT",
    
    // Owen County
    "OWEN",
    "OWEN CO",
    "OWEN COUNTY",
    "GRATZ",
    "MONTEREY",
    "OWENTON",
    "HESLER",
    "LONG RIDGE",
    "LUSBYS MILL",
    "NEW LIBERTY",
    "PERRY PARK",
    "PLEASANT HOME",
    "SQUIRESVILLE",
    "WHEATLEY",

    // Pendleton County
    "PENDLETON",
    "PENDLETON CO",
    "PENDLETON COUNTY",
    "BUTLER",
    "DEMOSSVILLE",
    "FALMOUTH",

    // Scott County
    "SCOTT",
    "SCOTT CO",
    "SCOTT COUNTY",
    "GEORGETOWN",
    "SADIEVILLE",
    "STAMPING GROUND",
    
    // Trimble County
    "TRIMBLE",
    "TRIMBLE CO",
    "TRIMBLE COUNTY",
    "BEDFORD",
    "LOCUST",
    "MILTON",
    "WISES LANDING",
    
    // Robertson county
    "ROBERTSON",
    "ROBERTSON CO",
    "ROBERTSON COUNTY",
    "KENTONTOWN",
    "MOUNT OLIVET",
    "PIQUA",
    
    
    //COUNTIES
    "JEFFERSON COUNTY",
    
    "SHELBY",
    "POPLAR GROVE"
    
  };


}
