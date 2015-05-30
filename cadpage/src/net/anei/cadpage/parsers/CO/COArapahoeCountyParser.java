package net.anei.cadpage.parsers.CO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.ReverseCodeSet;

public class COArapahoeCountyParser extends FieldProgramParser {
  
  public COArapahoeCountyParser() {
    super("ARAPAHOE COUNTY", "CO",
           "HEAD? ID ( MAP ( GPS1 | ADDR/Z GPS1 ) | ADDR/Z? MAP GPS1 ) GPS2 APT BLDG PLACE CALL UNIT! INFO+");
  }
  
  @Override
  public String getFilter() {
    return "metcomdispatch@metcom911.org";
  }
  
  private static final Pattern MASTER = Pattern.compile("(?:(?:Comment: (.*) )?Info Only: )?(?:([A-Z]{1,2}-\\d{2}-[A-Z](?:-[A-Z])?) )?(.*?) *([A-Z][,A-Z0-9]+)");
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    // We have two different page formats
    // Check for the pipe delimited field format
    String[] flds = body.split("\\|");
    if (flds.length >= 10) return parseFields(flds, data);
    
    // No go. Check for the undelimited field format
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    
    setFieldList("INFO MAP ADDR APT CALL UNIT");
    data.strSupp = getOptGroup(match.group(1));
    data.strMap = getOptGroup(match.group(2));
    body = match.group(3).trim();
    data.strUnit = match.group(4);
    
    String call = CALL_LIST.getCode(body, true);
    if (call != null) {
      data.strCall = call;
      parseAddress(body.substring(0,body.length()-call.length()).trim(), data);
    } else {
      parseAddress(StartType.START_ADDR, body, data);
      data.strCall = getLeft();
      if (data.strCall.length() == 0) return false;
    }
    return true;
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("HEAD")) return new SkipField("Incident Location Changed to:?|Response Comments:");
    if (name.equals("ID")) return new IdField("\\d{4}-\\d{7}", true);
    if (name.equals("MAP")) return new MapField("[A-Z]{1,2}-\\d{2}-[A-Z](?:-[A-Z])?", true);
    if (name.equals("GPS1")) return new MyGPSField(1);
    if (name.equals("GPS2")) return new MyGPSField(2);
    if (name.equals("BLDG")) return new MyBuildingField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private class MyGPSField extends GPSField {
    
    public MyGPSField(int type) {
      super(type);
    }
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (!NUMERIC.matcher(field).matches()) return false;
      int pt = field.length() - 6;
      if (pt < 2) return false;
      field = field.substring(0,pt) + '.' + field.substring(pt);
      super.parse(field, data);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
  }
  
  private class MyBuildingField extends AptField {
    @Override
    public void parse(String field, Data data) {
      data.strApt = append(field, "-", data.strApt);
    }
  }
  
  private static final Pattern INFO_CASE_PTN = Pattern.compile(".*\\bAutomatic Case Number\\(s\\) ?issued for ([ \\w]+?): ([-A-Z0-9]+).");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      String delim = "\n";
      for (String part : field.split(",")) {
        part = part.trim();
        if (part.length() == 0) continue;
        Matcher match = INFO_CASE_PTN.matcher(part);
        if (match.matches()) {
          String source = match.group(1).trim();
          if (!data.strSource.contains(source)) {
            data.strSource = append(data.strSource, ",", source);
          }
          String id = match.group(2);
          if (!data.strCallId.contains(id)) {
            data.strCallId = append(data.strCallId, "/", id);
          }
          continue;
        }
        data.strSupp = append(data.strSupp, delim, part);
        delim = ", ";
      }
    }
    
    @Override
    public String getFieldNames() {
      return "INFO SRC ID";
    }
  }
  
  private static final ReverseCodeSet CALL_LIST = new ReverseCodeSet(
      "10 GREENWOOD POINT APTS BLDG 10 Hemorrhage/Lacerations",
      "10 GREENWOOD POINT APTS BLDG 10 x21D-Hemorrhage/Lacerations",
      "(3960 BROADWAY) Alarm-CO No Sick Parties",
      "Abdominal Pain/Problem",
      "A ENGLEWOOD POST ACUTE AND REHAB Medical Assist",
      "A GOLDEN NUGGET APARTMENTS (201 BELLEVIEW) Traumatic Injuries (Specific)",
      "Alarm-CO No Sick Parties",
      "Alarm-Fire Alarm Commercial",
      "Alarm-Fire Alarm Residential",
      "Alarm-Medical Alarm",
      "Alcohol Evaluation",
      "Assault/Sexual Assault",
      "Assist - Lift Assist",
      "Assist - Lock In (Child/Pet)",
      "Assist - Lock Out",
      "Assist - Other Agency Assist",
      "Ave VILLAGE PLAZA LOFTS Resc - Confined Space Rescue",
      "Back Pain (Non-Traumatic)",
      "BANK OF THE WEST (HAMPDEN AVE) Alarm-Fire Alarm Commercial",
      "BLDG 1 KIMBERLY WOODS APTS BLDG 1 Medical Assist",
      "Breathing Problems",
      "Cardiac or Respiratory Arrest",
      "CARMEL PARK APTS (135 BELLEVIEW) Medical Assist",
      "CARMEL PARK Cardiac or Respiratory Arrest",
      "CENTENNIAL AIRPORT-7800 S PEORIA ST Air Alert 2 Inflight Emergency",
      "CH-ENGLEWOOD FIRST ASSEMBLY CHURCH Falls",
      "Chest Pain (Non-Traumatic)",
      "COIT CLEANING SERVICE Alarm-Fire Alarm Commercial",
      "Convulsions/Seizures",
      "COURTNEY DOWNS APTS (JAMISON DR) Fire - Appliance Fire",
      "CRAIG FAMILY HOUSING BUILDING Breathing Problems",
      "CRAIG HOSP PARKING GARAGE Falls",
      "CREATIVE INSTALLATION SOLUTIONS INC. Alarm-Fire Alarm Commercial",
      "Driveway Eye Problems/ Injuries",
      "E470 NB AT 64TH",
      "Electrical Hazard",
      "Element Hotel SF - Comm Str Fire Reported",
      "ELEPHANT BAR SF - Comm Str Fire Reported",
      "ENGLEWOOD POST ACUTE AND REHAB Medical Assist",
      "E RIVERSTONE RESIDENTIAL Cardiac or Respiratory Arrest",
      "E RIVERSTONE RESIDENTIAL x9E-Cardiac/Resp Arrest",
      "EXTENDED STAY AMERICA (YOSEMITE ST) SF1C - Commercial Str Fire",
      "EXTENDED STAY AMERICA (YOSEMITE ST) SF - Comm Str Fire Reported",
      "Falls",
      "Fire - Appliance Fire",
      "Fire - BBQ Grill Fire",
      "Fire - Brush Fire Large",
      "Fire - Brush Fire Small",
      "Fire - Commercial Carrier Fire",
      "Fire - Outside Fire",
      "Fuel Spill Large",
      "Fuel Spill Small",
      "Gas - Commercial Leak/Odor",
      "Gas - Residential Leak/Odor",
      "GATEWAY Medical Assist",
      "GOLDEN NUGGET APARTMENTS (201 BELLEVIEW) Traumatic Injuries (Specific)",
      "GREENWOOD POINT APTS BLDG 10 Hemorrhage/Lacerations",
      "HazMat",
      "Heart Problems/ A.I.C.D",
      "HOSP-SWEDISH MEDICAL CENTER Assist - Public Assist",
      "HOSP-SWEDISH MEDICAL CENTER Sick Person (Spec. Diagnosis)",
      "HOUR FITNESS (OSWEGO ST) Gas - Commercial Leak/Odor",
      "I70 EB AT AIRPARK Chest Pain (Non-Traumatic)",
      "Invest - Lighting Strike",
      "Invest - Odor Outside",
      "Invest - Smoke Inside",
      "Invest - Smoke Outside",
      "JENNIFER JO APARTMENTS Medical Assist",
      "JULIA TEMPLE CENTER Hemorrhage/Lacerations",
      "KIMBERLY WOODS APTS BLDG 1 Hemorrhage/Lacerations",
      "KIMBERLY WOODS APTS BLDG 1 Medical Assist",
      "KING SOOPERS - BELLVIEW & FEDERAL (EFD) Assault/Sexual Assault",
      "LINCOLN SQUARE LOFTS (NORTH BLDG) Gas - Commercial Leak/Odor",
      "Line Down / Transformer",
      "LODGE AT WILLOW CREEK, THE (BLDG 25) Gas - Commercial Leak/Odor",
      "MAGGIANOS Fire - Outside Fire",
      "MEADOW GOLD DAIRY Medical Assist",
      "Medical Assist",
      "METROPOLITAN AT LINCOLN STN APTS (BLDG 3) Gas - Commercial Leak/Odor",
      "MM 313 I70 EB MVA Traffic Pedestrian Acciden",
      "MONTEREY APTS Assist - Lock Out",
      "MVA Extrication",
      "MVA Highway",
      "MVA Injuries",
      "MVA Motorcycle",
      "MVA Rollover",
      "MVA Unknown Injuries",
      "MVA Vehicle Into Building",
      "Overdose/Poisoning (Ingestion)",
      "PARK GUELL CONDOS (BLDG P) SF - Multi-Fam Str Fire Report",
      "Psych/Abn Behavior/Suicide Att",
      "RIVERSTONE RESIDENTIAL Cardiac or Respiratory Arrest",
      "RIVERSTONE RESIDENTIAL Invest - Odor Commercial",
      "SCH-SAINT MARYS ACADEMY SF - Comm Str Fire Reported",
      "SF - Comm Str Fire Reported",
      "SF - Outbuilding Fire",
      "SF - Res Str Fire Reported",
      "Sick Person (Spec. Diagnosis)",
      "SIMON CENTER Falls",
      "Stab/Gunshot/Penetrating Traum",
      "Standby In The Area",
      "STRASBURG FIRE STATION 81 Assist - Other Agency Assist",
      "STRASBURG FIRE STATION 81 Traumatic Injuries (Specific)",
      "Stroke(CVA)",
      "Test Call (Do Not Dispatch )",
      "Traumatic Injuries (Specific)",
      "Unconscious/Fainting (Near)",
      "VILLAGE LOFTS Gas - Commercial Leak/Odor",
      "VIRIDIAN SF - Multi-Fam Str Fire Report",
      "WATERWAY CARWASH (QUEBEC ST) Gas - Commercial Leak/Odor",
      "x1A-Abdominal Pain/Problems",
      "x26A-Sick Person"
  );
}
