package net.anei.cadpage.parsers.PA;

import java.util.Properties;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Washington County, PA
 */
public class PAWashingtonCountyParser extends FieldProgramParser {
  
  public PAWashingtonCountyParser() {
    super("WASHINGTON COUNTY", "PA",
           "Loc:ADDR/S? Xsts:X? Type:CALL! Time:TIME Loc_Com:INFO Comments:INFO");
  }
  
  @Override
  public String getFilter() {
    return "company10paging,mptfire,WashCo911";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_REMOVE_EXT;
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    int pt = body.indexOf("\n\n");
    if (pt >= 0) body = body.substring(0,pt).trim();
    body = body.replace("Location:", "Loc:").replace("Xstreet:", "Xsts:").replace("TYPE:", "Type:").replace("TIME:", "Time:");
    return super.parseMsg(body, data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new MyCrossField();
    return super.getField(name);
  }
  
  // Call description field parser
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      field = convertCodes(field, CALL_CODES);
      super.parse(field, data);
    }
  }
  
  // Address field parser
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String fld, Data data) {
      Parser p = new Parser(fld);
      while (true) {
        String place = p.getLastOptional(':');
        if (place.length() == 0) break;
        if (place.startsWith("@")) place = place.substring(1).trim();
        data.strPlace = append(place, " - ", data.strPlace);
      }
      data.strCity = convertCodes(p.getLast(' '), CITY_CODES); 
      fld = p.get();
      super.parse(fld, data);
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR CITY PLACE";
    }
  }
  
  // Cross street field
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      int flags = FLAG_ANCHOR_END | FLAG_IMPLIED_INTERSECT;
      if (data.strAddress.length() > 0) flags |= FLAG_ONLY_CROSS;
      parseAddress(StartType.START_ADDR, flags, field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR APT CITY X";
    }
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "ALLE", "ALLENPORT",
      "AMWE", "AMWELL TWP",
      "BEAL", "BEALLSVILLE",
      "BENT", "BENTLEYVILLE",
      "BLAN", "BLAINE TWP",
      "BUFF", "BUFFALO TWP",
      "BURG", "BURGETTSTOWN",
      "CALI", "CALIFORNIA",
      "CANO", "CANONSBURG",
      "CANT", "CANTON TWP",
      "CARR", "CARROLL TWP",
      "CECI", "CECIL TWP",
      "CENT", "CENTERVILLE",
      "CHRT", "CHARTIERS TWP",
      "CLAY", "CLAYSVILLE",
      "COAL", "COAL CENTER",
      "COKE", "COKEBURG",
      "CROI", "CHARLEROI",
      "CROS", "CROSS CREEK TWP",
      "DEEM", "DEEMSTON",
      "DONE", "DONEGAL TWP",
      "DONO", "DONORA",
      "DUNL", "DUNLEVY",
      "EBET", "EAST BETHLEHEM TWP",
      "EFIN", "EAST FINLEY TWP",
      "ELCO", "ELCO",
      "ELLS", "ELLSWORTH",
      "EWAS", "EAST WASHINGTON",
      "FALL", "FALLOWFIELD TWP",
      "FINL", "FINLEYVILLE",
      "GREE", "GREEN HILLS",
      "HANO", "HANOVER TWP",
      "HOPE", "HOPEWELL TWP",
      "HOUS", "HOUSTON",
      "INDP", "INDEPENDENCE TWP",
      "JEFF", "JEFFERSON TWP",
      "LONG", "LONG BRANCH",
      "MARI", "MARIANNA",
      "MCDO", "MCDONALD",
      "MIDW", "MIDWAY",
      "MONO", "MONONGAHELA",
      "MORR", "MORRIS TWP",
      "MTPL", "MT PLEASANT TWP",
      "NBET", "NORTH BETHLEHEM TWP",
      "NCHA", "NORTH CHARLEROI",
      "NEWE", "NEW EAGLE",
      "NFRA", "NORTH FRANKLIN TWP",
      "NOTT", "NOTTINGHAM TWP",
      "NSTR", "NORTH STRABANE TWP",
      "PETE", "PETERS TWP",
      "ROBI", "ROBINSON TWP",
      "ROSC", "ROSCOE",
      "SFRA", "SOUTH FRANKLIN TWP",
      "SMIT", "SMITH TWP",
      "SOME", "SOMERSET TWP",
      "SPEE", "SPEERS",
      "SSTR", "SOUTH STRABANE TWP",
      "STOC", "STOCKDALE",
      "TWIL", "TWILIGHT",
      "UNIO", "UNION TWP",
      "WALE", "WEST ALEXANDER",
      "WASH", "WASHINGTON",
      "WBET", "WEST BETHLEHEM TWP",
      "WBRO", "WEST BROWNSVILLE",
      "WFIN", "WEST FINLEY TWP",
      "WMID", "WEST MIDDLETOWN",
      "WPIK", "WEST PIKE RUN TWP"
  });
  
  private static final Properties CALL_CODES = buildCodeTable(new String[]{
                  
      "302",    "INVOLUNTARY COMMITMENT",
      "911AB",  "911 ABUSE",
      "911IN",  "911 INCIDENT",
      "ABDP",   "ABDOMINAL PAIN",
      "ABDUC",  "ABDUCTION",
      "ACC",    "ACCIDENT NO INJURIES",
      "ACCCHR", "ACCIDENT HIT AND RUN",
      "ACCEN",  "ACCIDENT W/ENTRAPMENT",
      "ACCFA",  "ACCIDENT W/FATALITY",
      "ACCIN",  "ACCIDENT W/INJURIES",
      "ACCRB",  "ACCIDENT BLOCKING RDWY",
      "ACCUN",  "ACCIDENT W/UNK INJURIES",
      "AID",    "NON-EMERGENCY ASSISTANCE",
      "AIR",    "AIRCRAFT INCIDENT",
      "ALARM",  "ALARM ACTIVATION",
      "ALAUD",  "AUDIBLE ALARM",
      "ALFAL",  "FALSE ALARM",
      "ALLHOL", "HOLDUP ALARM",
      "ALLR",   "ALLERGIC REACTION",
      "ALMED",  "MEDICAL ALARM",
      "ALSIL",  "SILENT ALARM",
      "ALSPK",  "SPRINKLER ALARM",
      "ALVEH",  "VEHICLE ALARM",
      "ANI",    "ANIMAL COMPLAINT",
      "ARR",    "ARREST WARRANT",
      "ASS",    "ASSAULT",
      "AUTAB",  "ABANDONED VEHICLE",
      "AUTRE",  "RECOVERED VEHICLE",
      "AUTTH",  "STOLEN VEHICLE",
      "BACK",   "BACK INJURY",
      "BARGE",  "LOOSE BARGE",
      "BITE",   "BITE W/INJURIES",
      "BLACK",  "HOSPITAL CODE BLACK",
      "BLE",    "UNCONTROLLED BLEEDING",
      "BOAT",   "WATER EMERGENCY",
      "BOLO",   "BE ON THE LOOK OUT",
      "BOMB",   "EXPLOSIVE DEVICE",
      "BRE",    "BREATHING DIFFICULTIES",
      "BUR",    "BURGLARY",
      "BURAT",  "BURGLARY ATTEMPT",
      "BURN",   "BURN VICTIM",
      "CARMO",  "CO ALARM",
      "CAVE",   "CAVE IN",
      "CBURN",  "CONTROLLED BURN",
      "CHECK",  "BAD CHECK",
      "CHILD",  "UNATTENDED CHILD",
      "CHKHZ",  "CHECK HAZARD",
      "CHKWB",  "CHECK WELFARE",
      "CHO",    "CHOKING",
      "CHP",    "CHEST PAIN",
      "CIVIL",  "CIVIL COMPLAINT",
      "COL",    "COLLAPSE",
      "CONST",  "ASSIST STATE CONSTABLE",
      "COURT",  "COURT/MAGISTRATE",
      "CRIMI",  "CRIMINAL MISCHIEF TO PROPERTY",
      "CUSTR",  "CUSTOMER TROUBLE",
      "DET",    "DETAIL",
      "DIA",    "DIABETIC EMERGENCY",
      "DISCO",  "DISORDERLY CONDUCT",
      "DISVE",  "DISABLED VEHICLE",
      "DOA",    "DEAD ON ARRIVAL",
      "DOM",    "DOMESTIC DISPUTE",
      "DRILL",  "DRILL",
      "DRUGS",  "DRUG RELATED OFFENSES",
      "DRWN",   "DROWNING",
      "ELEEM",  "ELEVATOR EMERGENCY",
      "ESCOR",  "ESCORT FOR BUSINESS",
      "EXPLO",  "EXPLOSION",
      "EXPOS",  "INDECENT EXPOSURE",
      "EYE",    "EYE EMERGENCY",
      "FALL",   "FALL",
      "FIGHT",  "FIGHT",
      "FIRAL",  "FIRE ALARM",
      "FIRCH",  "CHEMICAL FIRE",
      "FIRE",   "FIRE",
      "FIREN",  "STRUCTURE FIRE W/ENTRAPMENT",
      "FIRGR",  "BRUSH FIRE",
      "FIRST",  "STRUCTURE FIRE",
      "FIRVE",  "VEHICLE FIRE",
      "FLOOD",  "FLOODING",
      "FOOT",   "FOOT PATROL",
      "FORGE",  "FORGERY",
      "FRAUD",  "FRAUD",
      "FUEL",   "OUT FOR FUEL",
      "GANG",   "GANG RELATED INCIDENT",
      "GARAG",  "OUT FOR SERVICE",
      "GASOD",  "GAS ODOR",
      "HARAS",  "HARASSMENT",
      "HAZMA",  "HAZMAT INCIDENT",
      "HEAD",   "HEADACHE",
      "HEART",  "HEART PROBLEMS",
      "HEAT",   "HEAT EMERGENCY",
      "HELP",   "EMERGENCY ASSISTANCE",
      "HOMIC",  "HOMICIDE",
      "HOSTA",  "PERSON HELD AGAINST WILL",
      "HUNT",   "ILLEGAL HUNTING",
      "HYDOP",  "OPEN HYDRANT",
      "HYPO",   "HYPOTHERMIA",
      "INJP",   "INJURED PERSON",
      "INSHY",  "HYDRANT INSPECTION",
      "INSPE",  "INSPECTION",
      "INTOX",  "INTOXICATED PERSON",
      "INVAL",  "INVALID ASSIST",
      "JUMP",   "JUMPER",
      "JUVPR",  "JUVENILE PROBLEMS",
      "LOCIN",  "LOCKED INSIDE",
      "LOCK",   "KEYS LOCKED INSIDE VEHICLE",
      "LOGIN",  "LOG ON DUTY",
      "LOGOU",  "LOG OFF DUTY",
      "LOIT",   "LOITERING COMPLAINT",
      "LZ",     "LANDING ZONE",
      "MANDN",  "MAN DOWN",
      "MASCA",  "MASS CASUALTY",
      "MINAC",  "MINE ACCIDENT",
      "MISC",   "MISCELLANEOUS INCIDENT",
      "MOL",    "MOLESTATION",
      "MUTAE",  "MUTUAL AID REQUEST",
      "MUTAF",  "REQUEST ASSISTANCE",
      "MUTAP",  "MUTUAL AID REQUEST",
      "NUCIN",  "NUCLEAR INCIDENT",
      "OBGY",   "OBGYN EMERGENCY",
      "ODPOI",  "OVERDOSE",
      "OOS",    "OUT OF SERVICE",
      "OPEN",   "OPEN DOOR ORDINANCE",
      "ORD",    "ORDINANCE VIOLATION",
      "OSP",    "ON STREET PARKING REQUEST",
      "PAGE",   "PAGE/NOTIFY",
      "PARK",   "PARKING COMPLAINT",
      "PERFO",  "PERSON MISSING FOUND",
      "PERMI",  "MISSING PERSON",
      "PRI",    "PRIORITY DISPATCH",
      "PROBU",  "UNKNOWN PROBLEM",
      "PROP",   "PROPERTY FOUND/LOST",
      "PROWL",  "PROWLER",
      "PSYC",   "PSYCHIATRIC EMERGENCY",
      "PUB",    "PUBLIC SERVICE",
      "PUR",    "PURSUIT",
      "PURSE",  "STOLEN/LOST PURSE",
      "RAPE",   "SEXUAL ASSAULT",
      "RDCLS",  "ROAD CLOSURE",
      "RDHAZ",  "ROAD HAZARD",
      "RECK",   "RECKLESS/CARELESS DRIVING",
      "RED",    "HOSPITAL CODE RED",
      "REMOV",  "REMOVAL OF A PERSON",
      "REPO",   "REPOSESSION",
      "ROB",    "ROBBERY",
      "ROBAN",  "BANK ROBBERY",
      "SCRIP",  "FALSE PRESCRIPTION",
      "SEIZE",  "SEIZURE",
      "SHOP",   "SHOPLIFTING",
      "SHOT",   "PERSON SHOT",
      "SHOTS",  "REPORT OF SHOTS FIRED",
      "SICK",   "GENERAL SICKNESS",
      "SMOKE",  "SMOKE INVESTIGATION",
      "SOL",    "SOLICITATION",
      "SPEED",  "SPEEDING VEHICLE",
      "SPILL",  "SPILL",
      "SR",     "SEARCH AND RESCUE",
      "STAB",   "PERSON STABBED",
      "STILL",  "STILL ALARM",
      "STROK",  "STROKE",
      "SUIC",   "PERSON THREATENING SUICIDE",
      "SUIC",   "SUICIDE",
      "SUS",    "SUSPICIOUS ACTIVITY",
      "TAG",    "TAG/TICKET",
      "TERTH",  "TERRORISTIC THREATS",
      "TEST",   "TESTING",
      "THEFT",  "THEFT",
      "TIP",    "INFORMATION",
      "TOW",    "TOW A VEHICLE",
      "TRACO",  "TRAFFIC CONTROL",
      "TRAF",   "OFFICER INITIATED TRAFFIC STOP",
      "TRAN",   "TRANSFER",
      "TRES",   "TRESSPASSING",
      "UNAUT",  "UNAUTHORIZED USE OF VEHICLE",
      "UNCON",  "UNCONSCIOUS PATIENT",
      "UNKTR",  "UNKNOWN TROUBLE",
      "VICE",   "VICE ACTIVITY",
      "WATCO",  "WATER LINE BREAK",
      "WEA",    "WEAPON",
      "WEATH",  "WEATHER UPDATES",
      "WIRES",  "DOWNED/LOW HANGING WIRE",
      "YELLO",  "HOSPITAL CODE YELLOW"
      
      // Unidentified codes
      // DIS
      // NCIC
  });
}
