package net.anei.cadpage.parsers.MO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchGlobalDispatchParser;



public class MOWarrenCountyParser extends DispatchGlobalDispatchParser {

  public MOWarrenCountyParser() {
    super(CITY_TABLE, "WARREN COUNTY", "MO", DispatchGlobalDispatchParser.PLACE_FOLLOWS_ADDR);
    setupCallList(CALL_LIST);
    setupMultiWordStreets(
        "ARROW STAR",
        "ASPEN LAKE",
        "AUGUSTA BOTTOM",
        "BELAIRE TRLR",
        "BLUE HERON",
        "BLUE JAY",
        "BLUFF RIDGE",
        "BOONE MONUMENT",
        "CHARRETTE CREEK",
        "CHESTNUT RIDGE",
        "CHURCH HILL",
        "CONCORD HILL",
        "COON HOLLOW",
        "COUNTRY COVE",
        "COUNTRY LAKE",
        "COUNTRY VIEW",
        "CUMBERLAND GAP",
        "DANIEL BOONE INDUSTRIAL",
        "DRY FORK",
        "EAST WOODS",
        "FALCONS WING",
        "FIR TREE",
        "GOLDEN VICARY",
        "HAT TRICK",
        "HERITAGE LANDING",
        "HICKORY LICK",
        "HICKORY TRAILS",
        "HILLTOP TRAILS",
        "LAKE TUCCI",
        "LAKEVIEW ESTS",
        "LEGION HALL",
        "LOST CREEK",
        "MACEDONIA CHURCH",
        "NORTH RIDGE",
        "OPEN RANGE",
        "ORCHARD FARM",
        "PEAR ORCHARD",
        "PENDLETON FOREST",
        "PENDLETON LOST CREEK",
        "PIN OAK",
        "PINE FOREST",
        "PINE RIDGE",
        "QUAIL CREEK",
        "REVEREND THOMAS S HIGGINS",
        "SANTA MARIA",
        "SCUDDER RANCH",
        "SLEEPY HOLLOW",
        "SMITH CREEK",
        "SPLIT RAIL",
        "ST CATHERINE",
        "ST FRANCIS",
        "STRACKS CHURCH",
        "SWEET GUM",
        "TROTTERS CREEK",
        "TWIN OAKS",
        "VETERANS MEMORIAL",
        "VILLA DUSCHENE"        
    );
  }
  
  @Override
  public String getFilter() {
    return "warrencounty911@warrencounty911.org";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    if(!subject.equals("Dispatch")) return false;
    
    if (!super.parseMsg(subject, body, data)) return false;
    
    if (data.strApt.equalsIgnoreCase("STE")) {
      data.strApt = data.strPlace;
      data.strPlace = "";
    }
    
    Matcher match = NUMBER_ZERO_PTN.matcher(data.strAddress);
    if (match.matches()) {
      data.strAddress = match.group(1) + ' ' + match.group(2);
    }
    else if ((match = BLDG_APT_PTN.matcher(data.strAddress)).matches()) {
      String apt = match.group(1);
      data.strAddress = match.group(2);
      String apt2 = match.group(3);
      if (apt2 != null && !apt.equals(apt2)) apt = apt + "-" + apt2;
      data.strApt = apt;
    }
    
    match = INTERNAL_STE_PTN.matcher(data.strAddress);
    if (match.matches()) {
      data.strAddress = match.group(1) + ' ' + match.group(3);
      String apt = match.group(2);
      if (!apt.equals(data.strApt)) {
        data.strApt = append(data.strApt, "-", apt);
      }
    }
    
    int pt = data.strCross.indexOf('\n');
    if (pt >= 0) {
      data.strPlace = append(data.strPlace, " - ", data.strCross.substring(pt+1).trim());
      data.strCross = data.strCross.substring(0,pt).trim();
    }
    return true;
  }
  private static final Pattern NUMBER_ZERO_PTN = Pattern.compile("(\\d+) +0 +(.*)");
  private static final Pattern BLDG_APT_PTN = Pattern.compile("BLDG +([^ ]+) +APT +(.*?)(?: +APT +([^ ]+))?", Pattern.CASE_INSENSITIVE);
  private static final Pattern INTERNAL_STE_PTN = Pattern.compile("(\\d+) +(?:STE|APT) +([^ ]+) +(.*)", Pattern.CASE_INSENSITIVE);
  
  
  private static final Pattern LINE_BREAK_PTN = Pattern.compile("[\\. ]*\n+");
  private class MyInfoField extends BaseInfoField {
    @Override
    public void parse(String field, Data data) {
      field = LINE_BREAK_PTN.matcher(field).replaceAll(". ");
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  @Override
  protected int getExtraParseAddressFlags() {
    return FLAG_ALLOW_DUAL_DIRECTIONS;
  }
  
  private static final CodeSet CALL_LIST = new CodeSet(
      "911 HANG-UP",
      "ABDOMINAL PAIN/PROBLEMS",
      "ABDUCTION HOSTAGE",
      "ALARM COMMERCIAL",
      "ALARM RESIDENTIAL",
      "ANIMAL COMPLAINT",
      "ASSAULT EMS",
      "ASSAULT LAW",
      "ASSIST CITIZEN",
      "ASSIST MOTORIST",
      "ASSIST OTHER AGENCY",
      "BACK PAIN",
      "BREATHING PROBLEM",
      "BURNS",
      "BUSINESS CHECK",
      "CARDIAC ARREST",
      "CHEST PAIN",
      "CHILD ABUSE",
      "CHOKING",
      "CIVIL",
      "CIVIL PROCESS",
      "COMMUNITY PATROL",
      "CONTROL BURN",
      "DANGEROUS DRUGS",
      "DIRECTED PATROL",
      "DOMESTIC",
      "ELECTRICAL FIRE",
      "ELECTRICAL HAZARD",
      "EXPLOSION",
      "EXTRA PATROL",
      "FALL",
      "FIRE ALARM COMMERCIAL",
      "FIRE ALARM RESID",
      "FIRE ASSIST EMS LAW MOTORIST",
      "FOLLOW UP",
      "GAS LEAK OUTSIDE",
      "HAZMAT",
      "HEART PROBLEMS",
      "HEMORRHAGE/LACERATION",
      "INFORMATION",
      "LIFT ASSIST",
      "LZ LANDING ZONE",
      "MEDICAL ALARM",
      "MISSING PERSON",
      "MOVE UP",
      "MUTUAL AID",
      "MVA",
      "MVA LAW",
      "NATURAL COVER FIRE",
      "ODOR",
      "OVERDOSE/POISIONING",
      "PEACE DISTURBANCE",
      "PREGNANCY PROBLEMS",
      "PROPERTY DAMAGE",
      "PROWLER",
      "PSYCH/ABNORMAL BEHAVIOR",
      "READY FOR PICK UP",
      "ROAD CLOSURES & HAZARDS",
      "ROBBERY",
      "ROUTINE TRANSFER",
      "SECURITY CHECK",
      "SEIZURES",
      "SEVERE WEATHER",
      "SEX OFFENSE",
      "SEXUAL ASSAULT LAW",
      "SICK PERSON",
      "SMOKE INVESTIGATION",
      "STEALING",
      "STROKE (CVA)",
      "STRUCT FIRE COMMERCIAL",
      "STRUCT FIRE RESID",
      "SUDDEN DEATH",
      "SUICIDE LAW",
      "SUSP CIRCUMSTANCE",
      "SUSP PERSON",
      "SUSP VEHICLE",
      "TONE TEST MESSAGE",
      "TRAFFIC COMPLAINT",
      "TRAFFIC STOP",
      "TRESPASSING",
      "UNAUTHORIZED BURN",
      "UNCONSCIOUS/FAINTING",
      "UNKNOWN PROBLEM",
      "UTILITY HAZARD",
      "VEHICLE FIRE",
      "WATER RESCUE",
      "WEAPONS OFFENSE"
   );
  
  private static final String[] CITY_TABLE = new String[]{
    "WARREN COUNTY",
    
    "ASPENHOFF",
    "DUTZOW",
    "FORISTELL",
    "INNSBROOK",
    "MARTHASVILLE",
    "MINDEN",
    "PENDLETON",
    "TRELOAR",
    "TRUESDALE",
    "WARRENTON",
    "WRIGHT CITY",
    
    // Franklin County
    "WASHINGTON",
    
    // Lincoln County
    "HAWK POINT",
    "TROY",
    "TRUXTON",
    
    // St Charles County
    "WENTZVILLE"
  };
}
