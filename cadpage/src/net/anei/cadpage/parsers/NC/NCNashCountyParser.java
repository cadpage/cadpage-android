package net.anei.cadpage.parsers.NC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeTable;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;


public class NCNashCountyParser extends SmartAddressParser {
  
  private static final Pattern DATE_TIME_PTN = Pattern.compile(" (\\d\\d/\\d\\d/\\d{4}) (\\d\\d:\\d\\d:\\d\\d) : pos\\d+ : [A-Z0-9]+\\b",Pattern.CASE_INSENSITIVE); 
  private static final Pattern DATE_TIME_PTN2 = Pattern.compile(" (\\d\\d/\\d\\d/\\d{4}) (\\d\\d:\\d\\d:\\d\\d)\\b");
  private static final Pattern DATE_TIME_PTN3 = Pattern.compile(" \\d\\d/[\\d /:]*$");
  
  private static final Pattern UNIT_PTN = Pattern.compile("[\\dA-Z,]*\\d[A-Z]*");
  
  public NCNashCountyParser() {
    super(CITY_LIST, "NASH COUNTY", "NC");
    setFieldList("ADDR APT CITY X CODE CALL NAME UNIT DATE TIME INFO");
  }
  
  @Override
  public String getFilter() {
    return "nash911@nashcountync.gov,9300";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    if (body.startsWith("/ ")) body = body.substring(2).trim();
    if (!body.startsWith("NASH911:")) return false;
    body = body.substring(8).trim();
    
    Matcher match = DATE_TIME_PTN.matcher(body);
    if (match.find()) {
      data.strDate = match.group(1);
      data.strTime = match.group(2);
      data.strSupp = body.substring(match.end()).trim();
      body = body.substring(0,match.start());
    } 
    
    else if ((match = DATE_TIME_PTN2.matcher(body)).find()) {
      data.strDate = match.group(1);
      data.strTime = match.group(2);
      body = body.substring(0,match.start());
    } 
    
    else if ((match = DATE_TIME_PTN3.matcher(body)).find()) {
      body = body.substring(0,match.start());
    } 
    
    body = body.replace("//", "/");
    parseAddress(StartType.START_ADDR, FLAG_RECHECK_APT | FLAG_CROSS_FOLLOWS, body, data);
    if (data.strCity.equals("EDGECOMBE CO")) data.strCity = "EDGECOMBE COUNTY";
    String left = getLeft();
    if (left.length() == 0) return false;
    
    // Last token of what is left is "usually" a unit designation
    // But only if it contains at least one digit
    Parser p =  new Parser(left);
    String unit = p.getLast(' ');
    if (UNIT_PTN.matcher(unit).matches()) {
      data.strUnit = unit;
      left = p.get();
    }
    
    // There may be a  cross street at the start of what is left.  But we
    // will check for a recognized call description first, lest we get tripped
    // up by something like STRUCTURE PAUL LANE being misinterpreted as a 
    // cross street
    CodeTable.Result cRes = CODE_TABLE.getResult(left);
    if (cRes == null) {
      Result res = parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS | FLAG_IMPLIED_INTERSECT, left);
      if (res.isValid()) {
        res.getData(data);
        left = res.getLeft();
        cRes = CODE_TABLE.getResult(left);
      }
    }
    
    // Now things get sticky.
    // What is left is either specific call code (which may be multiple words)
    // followed by a name.  Or is all call description :(
    if (cRes != null) {
      data.strCode = cRes.getCode();
      data.strCall  = cRes.getDescription();
      data.strName = cleanWirelessCarrier(cRes.getRemainder());
    } else {
      data.strCall = left;
    }
    return true;
  }
  
  private static final CodeTable CODE_TABLE = new CodeTable(
      
        // Fire:
        "SERV CALL",  "SERVICE CALL",
        "MVA PI-H",   "MVA PERSON INJURED",
        "OUTSIDE FI", "OUTSIDE FIRE",
        "MVA PIN-H",  "MVA PERSON PINNED",
        "MVA PIN-C",  "MVA PERSON PINNED",
        "STRUCTURE",  "STRUCTURE FIRE",
        "ALARM-FIRE", "FIRE ALARM",
        "MVA PI-C",   "MVA PERSON INJURED",
        "PUBL SER-C", "SERVICE CALL",
        "PUBL SER-H", "SERVICE CALL",
        "VEH FIRE S", "SMALL VEHICLE FIRE",
        "GAS LEAK",   "GAS LEAK",
        "MVA PD",     "MVA PROPERTY DAMAGE",
        "ADMIN-C",    "SERVICE CALL",
        "ADMIN-H",    "SERVICE CALL",
        "FUEL SPILL", "FUEL SPILL",
        "MISS PER-H", "MISSING PERSON",
        "MISS PER-C", "MISSING PERSON",
        "MVA PD/OT",  "MVA OTHER",
        "TRAF/V/H-H", "MVA UNKNOWN",
        "TRAF/V/H-C", "MVA UNKNOWN",
        "WATER RESC", "WATER RESCUE",
        "ALARMS-H",   "UNKNOWN ALARM",
        "ALARMS-C",   "UNKNOWN ALARM",
        "VEH FIRE-L", "LARGE VEHICLE FIRE",
        "SMOKE INVE", "SMOKE INVESTIGATION",

        // Medical:
        "UNK PROB-H", "UNKNOWN MEDICAL",
        "UNK PROB-C", "UNKNOWN MEDICAL",
        "BREATH-H",   "BREATHING DIFFICULTY",
        "BREATH-C",   "BREATHING DIFFICULTY",
        "UNCONSC-H",  "UNRESPONSIVE PERSON",
        "UNCONSC-C",  "UNRESPONSIVE PERSON",
        "CHEST-H",    "CHEST PAIN",
        "CHEST-C",    "CHEST PAIN",
        "HEMORRHA-H", "SUBJECT HEMORRHAGING",
        "HEMORRHA-C", "SUBJECT HEMORRHAGING",
        "DIABETIC-H", "DIABETIC EMERGENCY",
        "DIABETIC-C", "DIABETIC EMERGENCY",
        "SICK-H",     "SICK CALL",
        "SICK-C",     "SICK CALL",
        "FALLS-H",    "SUBJECT FALLEN",
        "FALLS-C",    "SUBJECT FALLEN",
        "OVERDOSE-H", "OVERDOSE",
        "OVERDOSE-C", "OVERDOSE",
        "STROKE-H",   "STROKE/ CVA",
        "STROKE-C",   "STROKE/ CVA",
        "HEADACHE-H", "HEADACHE",
        "HEADACHE-C", "HEADACHE",
        "ABD-H",      "ABDOMINAL PAIN",
        "ABD-C",      "ABDOMINAL PAIN",
        "TRAUMA-H",   "INJURED PERSON",
        "TRAUMA-C",   "INJURED PERSON",
        "CARDIAC-H",  "CODE BLUE",
        "CARDIAC-C",  "CODE BLUE",
        "HEART PR-H", "HEART PROBLEMS",
        "HEART PR-C", "HEART PROBLEMS",
        "ALLERGY-H",  "ALLERGIC REACTION",
        "ALLERGY-C",  "ALLERGIC REACTION",
        "ANIMAL-M-L", "ANIMAL BITE",
        "BK PAIN-H",  "BACK PAIN",
        "BK PAIN-C",  "BACK PAIN",
        "SEIZURES-H", "SEIZURES",
        "SEIZURES-C", "SEIZURES",
        "SUSPWANT-H", "ASSIST LAW",
        "SUSPWANT-C", "ASSIST LAW",
        "ASSALT-M-H", "INJURED PERSON",
        "ASSALT-M-C", "INJURED PERSON",
        "PSYC/SUI-H", "PSYCHIATRIC PROBLEM",
        "PSYC/SUI-C", "PSYCHIATRIC PROBLEM",
        "SHOTSTAB-H", "SHOOTING/ STABBING",
        "SHOTSTAB-C", "SHOOTING/ STABBING",
        "BURNS-H",    "SUBJECT BURNED",
        "BURNS-C",    "SUBJECT BURNED",
        "CARD/ARR-H", "CODE BLUE",
        "CARD/ARR-C", "CODE BLUE",
        "HEAT/CLD-H", "HEAT EMERGENCY",
        "HEAT/CLD-C", "HEAT EMERGENCY",
        "TRANSFER-H", "TRANSFER ASST",
        "TRANSFER-C", "TRANSFER ASST",
        "CARBON-H",   "CO INHALATION",
        "CARBON-C",   "CO INHALATION",
        "MEDICAL",    "MEDICAL"

  );
  
  private static final String[] CITY_LIST = new String[]{
      "BAILEY",
      "CASTALIA",
      "DORTCHES",
      "ELM CITY",
      "MIDDLESEX",
      "MOMEYER",
      "NASHVILLE",
      "RED OAK",
      "ROCKY MOUNT",
      "SPRING HOPE",
      "WHITAKERS",
      "BAILEY",
      "BATTLEBORO",
      "CASTALIA",
      "COOPERS",
      "DRY WELLS",
      "FERRELLS",
      "GRIFFINS",
      "JACKSON",
      "MANNINGS",
      "NASHVILLE",
      "NORTH WHITAKERS",
      "OAK LEVEL",
      "RED OAK",
      "ROCKY MOUNT",
      "SPRING HOPE",
      "SOUTH WHITAKERS",
      "STONY CREEK",
      
      "EDGECOMBE CO"
  };
}
