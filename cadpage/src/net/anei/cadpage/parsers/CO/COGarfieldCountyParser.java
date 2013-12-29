package net.anei.cadpage.parsers.CO;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;




public class COGarfieldCountyParser extends SmartAddressParser {
  
  private static final Pattern ID_PTN = Pattern.compile(" +(\\d{4} \\d{8})$");
  private static final Pattern APT_PTN = Pattern.compile(" (?:APT|RM|UNIT|#) *([^ ]+)$");
  private static final Pattern BLK_PTN = Pattern.compile("\\bblk\\b");
  private static final Pattern PLACE_PTN = Pattern.compile("^.*[a-z]");
  private static final Pattern PLACE2_PTN = Pattern.compile("^.*[A-Z]{2}(?=\\d)");
  private static final Pattern LEGAL_ADDR_PTN = Pattern.compile(".*[A-Z].*");
  private static final Pattern FOREST_PTN = Pattern.compile("FOREST(?: SERVICE)?", Pattern.CASE_INSENSITIVE);
  private static final Pattern ROAD_START_PTN = Pattern.compile("^(?:RD|ROAD) ", Pattern.CASE_INSENSITIVE);
  
  public COGarfieldCountyParser() {
    super("GARFIELD COUNTY", "CO");
    setupCallList(CALL_LIST);
    setupMultiWordStreets("CHAIR BAR");
    setFieldList("CALL PLACE ADDR APT CITY MAP ID");
  }
  
  @Override
  public String getFilter() {
    return "GCECA@call3n.com,@everbridge.net";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.endsWith("CAD Page")) return false;
    
    // Remove optional call ID
    Matcher match = ID_PTN.matcher(body);
    if (match.find()) {
      data.strCallId = match.group(1);
      body = body.substring(0,match.start());
    }
    
    // Remove apt from address before checking for city/map zone
    match = APT_PTN.matcher(body);
    if (match.find()) {
      data.strApt = match.group(1);
      body = body.substring(0,match.start()).trim();
    }
    
    // The is usually a trailing city code at this point.
    // Unfortunately dispatch is pretty sloppy about separating
    // these fields with blanks, so we won't count on blank separators.
    for (int len = 2; len<=4; len++) {
      int pt = body.length() - len;
      if (pt >= 0) {
        String city = CITY_CODES.getProperty(body.substring(pt));
        if (city != null) {
          if (city.startsWith("Z")) data.strMap = city;
          else data.strCity = city;
          body = body.substring(0,pt).trim();
          break;
        }
      }
    }
    
    // Usually, but not always, the word "Location marks the end off the
    // call description.  If it isn't there, we will have to count on the
    // smart address parser to sort it out
    StartType st = StartType.START_CALL_PLACE;
    int flags = FLAG_START_FLD_REQ;
    int pt = body.indexOf(" Location ");
    if (pt >= 0) {
      data.strCall = body.substring(0,pt).trim();
      body = body.substring(pt+10).trim();
      st = StartType.START_PLACE;
      flags = 0;
    }
    
    // Once again, dispatch is rather careless about blank separators between the call/place and address
    // Call descriptions and place names are (usually) cammel case while address 
    // is usually upper case (except for an occasional "blk" term that we need to capitialize)
    // So we split them at the last lower case character
    body = BLK_PTN.matcher(body).replaceAll("BLK");
    match = PLACE_PTN.matcher(body);
    boolean found = match.find();
    if (!found) {
      match = PLACE2_PTN.matcher(body);
      found = match.find();
    }
    if (found) {
      String place = match.group();
      String addr = body.substring(match.end()).trim();
      
      // Some addresses are entered in lower case now :(
      // If what was left for an address does not contain
      // at least one upper case letter, abandon this effort
      if (LEGAL_ADDR_PTN.matcher(addr).matches()) {
        if (st == StartType.START_CALL_PLACE) {
          String call = CALL_LIST.getCode(place.toUpperCase());
          if (call != null) {
            data.strCall = place.substring(0,call.length());
            data.strPlace = place.substring(call.length()).trim();
          } else {
            data.strCall = place;
          }
        } else {
          data.strPlace = place;
        }
        body = body.substring(match.end()).trim();
        st = StartType.START_ADDR;
        flags = 0;
      }
    }
    
    parseAddress(st, flags | FLAG_ANCHOR_END | FLAG_IMPLIED_INTERSECT, body, data);
    
    if (FOREST_PTN.matcher(data.strPlace).matches() &&
        ROAD_START_PTN.matcher(data.strAddress).find()) {
      data.strAddress = data.strPlace + " " + data.strAddress;
      data.strPlace = "";
    }
    
    if (data.strAddress.length() == 0) {
      data.strAddress = data.strPlace;
      data.strPlace = "";
    }
    return true;
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "GS",   "GLENWOOD SPRINGS",
      "NC",   "NEW CASTLE",
      "PARA", "PARACHUTE",
      "RIF",  "RIFLE",
      "SIL",  "SILT",
      "SILT", "SILT",
      "Z1",   "Z1",
      "Z2",   "Z2",
      "Z3",   "Z3"
  });
  
  private static final CodeSet CALL_LIST = new CodeSet(
      "Accident",
      "ACCIDENT",
      "Code",
      "CODE",
      
      "EAbdominal",
      "EABDOMINAL",
      "EAllergic Reaction ",
      "EALLERGIC REACTION ",
      "EAssault",
      "EASSAULT",
      "EBack Pain",
      "EBACK PAIN",
      "EBleeding Non traumatic",
      "EBLEEDING NON TRAUMATIC",
      "EBreathing Difficulty",
      "EBREATHING DIFFICULTY",
      "EChest Pain",
      "ECHEST PAIN",
      "EChoking",
      "ECHOKING",
      "EDiabetic",
      "EDIABETIC",
      "EFalls",
      "EFALLS",
      "EGynecology Childbirth",
      "EGYNECOLOGY CHILDBIRTH",
      "EMedical Alarm",
      "EMEDICAL ALARM",
      "EMental Emotional Psych",
      "EMENTAL EMOTIONAL PSYCH",
      "EOverdose Poisoning",
      "EOVERDOSE POISONING",
      "ESeizures",
      "ESEIZURES",
      "ESick Unknown",
      "ESICK UNKNOWN",
      "EStabbing Gunshot",
      "ESTABBING GUNSHOT",
      "ETrauma with Injury",
      "ETRAUMA WITH INJURY",
      "EUnconscious Syncope",
      "EUNCONSCIOUS SYNCOPE",
      
      "FAlarm",
      "FALARM",
      "FBrush",
      "FBRUSH",
      "FGas Leak",
      "FGAS LEAK",
      "FOdor Check",
      "FODOR CHECK",
      "FRiver Rescue",
      "FRIVER RESCUE",
      "FSmoke Check",
      "FSMOKE CHECK",
      "FStructure",
      "FSTRUCTURE",
      "FVehicle Fire",
      "FVEHICLE FIRE"
  );
}
