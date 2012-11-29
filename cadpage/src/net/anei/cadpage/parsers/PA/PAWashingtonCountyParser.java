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
  protected boolean parseMsg(String body, Data data) {
    
    // Regular parseMsg processing, but return failure if we didn't get an address
    // from either a Location or Xstreet
    body = body.replace("Location:", "Loc:").replace("Xstreet:", "Xsts:").replace("TYPE:", "Type:").replace("TIME:", "Time:");
    if (!super.parseMsg(body, data)) return false;
    if (data.strAddress.length() == 0)  return false;
    return true;
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
      data.strPlace = p.getLastOptional(":");
      if (data.strPlace.startsWith("@")) data.strPlace = data.strPlace.substring(1).trim(); 
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
      String saveAddr = data.strAddress;
      parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END | FLAG_IMPLIED_INTERSECT, field, data);
      if (saveAddr.length() > 0) {
        data.strCross = data.strAddress;
        data.strAddress = saveAddr;
      }
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new MyCrossField();
    return super.getField(name);
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
      "ABDP",   "ABDOMINAL PAIN",
      "ACC",    "ACCIDENT NO INJURIES",
      "ACCEN",  "ACCIDENT W/ENTRAPMENT",
      "ACCFA",  "ACCIDENT W/FATALITY",
      "ACCCHR", "ACCIDENT HIT AND RUN",
      "ACCIN",  "ACCIDENT W/INJURIES",
      "ACCRB",  "ACCIDENT BLOCKING RDWY",
      "ACCUN",  "ACCIDENT W/UNK INJURIES",
      "AIR",    "AIRCRAFT INCIDENT",
      "ALLR",   "ALLERGIC REACTION",
      "ALMED",  "MEDICAL ALARM",
      "ALSPK",  "SPRINKLER ALARM",
      "ASS",    "ASSAULT",
      "BACK",   "BACK INJURY",
      "BARGE",  "LOOSE BARGE",
      "BITE",   "BITE W/INJURIES",
      "BLE",    "UNCONTROLLED BLEEDING",
      "BOAT",   "WATER EMERGENCY",
      "BOMB",   "EXPLOSIVE DEVICE",
      "BRE",    "BREATHING DIFFICULTIES",
      "BURN",   "BURN VICTIM",
      "CARMO",  "CO ALARM",
      "CAVE",   "CAVE IN",
      "CBURN",  "CONTROLLED BURN",
      "CHKHZ",  "CHECK HAZARD",
      "CHKWB",  "CHECK WELFARE",
      "CHO",    "CHOKING",
      "CHP",    "CHEST PAIN",
      "COL",    "COLLAPSE",
      "DIA",    "DIABETIC EMERGENCY",
      "DOA",    "DEAD ON ARRIVAL",
      "DOM",    "DOMESTIC DISPUTE",
      "DRILL",  "DRILL",
      "DRWN",   "DROWNING",
      "ELEEM",  "ELEVATOR EMERGENCY",
      "EXPLO",  "EXPLOSION",
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
      "GASOD",  "GAS ODOR",
      "HAZMA",  "HAZMAT INCIDENT",
      "HEAD",   "HEADACHE",
      "HEART",  "HEART PROBLEMS",
      "HEAT",   "HEAT EMERGENCY",
      "HOMIC",  "HOMICIDE",
      "HYDOP",  "OPEN HYDRANT",
      "HYPO",   "HYPOTHERMIA",
      "INJP",   "INJURED PERSON",
      "INSHY",  "HYDRANT INSPECTION",
      "INSPE",  "INSPECTION",
      "INVAL",  "INVALID ASSIST",
      "JUMP",   "JUMPER",
      "LOCIN",  "LOCKED INSIDE",
      "LZ",     "LANDING ZONE",
      "MANDN",  "MAN DOWN",
      "MASCA",  "MASS CASUALTY",
      "MINAC",  "MINE ACCIDENT",
      "MUTAF",  "REQUEST ASSISTANCE",
      "NUCIN",  "NUCLEAR INCIDENT",
      "OBGY",   "OBGYN EMERGENCY",
      "ODPOI",  "OVERDOSE",
      "OOS",    "OUT OF SERVICE",
      "PRI",    "PRIORITY DISPATCH",
      "PROBU",  "UNKNOWN PROBLEM",
      "PSYC",   "PSYCHIATRIC EMERGENCY",
      "PUB",    "PUBLIC SERVICE",
      "RAPE",   "SEXUAL ASSAULT",
      "RDCLS",  "ROAD CLOSURE",
      "RDHAZ",  "ROAD HAZARD",
      "SEIZE",  "SEIZURE",
      "SHOT",   "PERSON SHOT",
      "SICK",   "GENERAL SICKNESS",
      "SMOKE",  "SMOKE INVESTIGATION",
      "SPILL",  "SPILL",
      "SR",     "SEARCHY DETAIL",
      "STAB",   "PERSON STABBED",
      "STILL",  "STILL ALARM",
      "STROK",  "STROKE",
      "SUIC",   "SUICIDE",
      "TEST",   "TESTING",
      "UNCON",  "UNCONSCIOUS PATIENT",
      "WEATH",  "WEATHER UPDATES",
      "WIRES",  "DOWNED/LOW HANGING WIRE"
  });
}
