package net.anei.cadpage.parsers.VA;


import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Prince William County, VA base class
*/


abstract class VAPrinceWilliamCountyBaseParser extends FieldProgramParser {
  
  protected VAPrinceWilliamCountyBaseParser(String program) {
    this(null, program);
  }
  
  protected VAPrinceWilliamCountyBaseParser(Properties cityCodes, String program) {
    super(cityCodes, "PRINCE WILLIAM COUNTY", "VA", program);
  }

  @Override
  public String getFilter() {
    return "cc_message_notification@usamobility.net,@rsan.pwcgov.org";
  }
  
  @Override
  public String adjustMapAddress(String sAddress) {
    return TN_PTN.matcher(sAddress).replaceAll("TURN");
  }
  private static final Pattern TN_PTN = Pattern.compile("\\bTN\\b", Pattern.CASE_INSENSITIVE);
  
  private class BaseCodeField extends CodeField {
    @Override
    public void parse(String field, Data data) {
      data.strCode = field;
      data.strCall = convertCodes(field, CALL_CODES);
    }
    
    @Override
    public String getFieldNames() {
      return "CODE CALL";
    }
  }
  
  private class BaseCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      super.parse(convertCodes(field, CALL_CODES), data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CODE")) return new BaseCodeField();
    if (name.equals("CALL")) return new BaseCallField();
    return super.getField(name);
  }
  
  private static final Properties CALL_CODES = buildCodeTable(new String[]{
    "ACCA",     "Motor Vehicle Accident/ALS",
    "ACCAIR",   "Aircraft Crash/Fire/Distress/Leak",
    "ACCX",     "Auto Accident with Entrapment",
    "ACCB",     "Motor Vehicle Accident/BLS",
    "AIRHAZ",   "Aircraft Hazard",
    "APPA",     "Appliance Fire in an Apartment",
    "APPH",     "Appliance Fire in an House",
    "APPT",     "Appliance Fire in an Townhouse",
    "APT",      "Apartment Fire",
    "ASSA",     "ALS - Assault",
    "ASSB",     "BLS - Assault",
    "ATTA",     "ALS - Attempted Suicide",
    "ATTB",     "BLS - Attempt Suicide",
    "BLDGA",    "Building Collapse Apartment",
    "BLDGC",    "Building Collapse in a Commercial Building",
    "BLDGCOM",  "Building Collapse Commercial",
    "BLDGH",    "Building Collapse Single Family Dwelling",
    "BLDGT",    "Building Collapse in a Townhouse",
    "BLDGTH",   "Building Collapse Townhouse",
    "BOATL",    "Boat Fire Lake",
    "BOATR",    "Boat Fire River",
    "BRUSH",    "Brush Fire",
    "CHIM",     "Chimney Fire",
    "CHOA",     "ALS - Choking",
    "CHOB",     "BLS - Choking",
    "CO",       "Carbon Monoxide Alarm Sounding",
    "COMM",     "Commercial Fire",
    "CSPACE",   "Confined Space",
    "DROA",     "ALS - Drowning",
    "DROB",     "BLS - Drowning",
    "ESERV",    "EMS Service Call",
    "ESERVICE", "BLS - EMS Service",
    "FALARM",   "Fire Alarm Sounding",
    "FOUT",     "Fire Reported Out",
    "FSERV",    "Fire Service Call",
    "FSERVICE", "Fire Service",
    "HANGLE",   "High Angle Rescue",
    "HAZARD",   "Hazardous Situation",
    "HAZMAT",   "HazMat Incident",
    "HOUSE",    "House Fire",
    "INGASA",   "Inside Gas Leak Apartment",
    "INGASC",   "Inside Gas Leak Commercial Building",
    "INGASH",   "Inside Gas Leak Single Family Dwelling",
    "INGAST",   "Inside Gas Leak Townhouse",
    "INJA",     "ALS - Injury",
    "INJB",     "BLS - Injury",
    "INVEST",   "Investigation",
    "INVESTIG", "Investigation",
    "LAKRES",   "Lake Rescue",
    "LOCKOUT",  "Lockout",
    "ODA",      "ALS - Overdose",
    "ODB",      "Overdose BLS",
    "OUTF",     "Outside Fire",
    "OUTGAS",   "Outside Odor of Gas",
    "RESCUE",   "Rescue Incident Non-Vehiclular",
    "RIVRES",   "River Rescue",
    "SICA",     "ALS - Sickness",
    "SICB",     "BLS - Sickness",
    "SMELL",    "Odor of Smoke",
    "STOP",     "Stoppage Of Breathing",
    "STRUCT",   "Structure Fire - All Types",
    "STRUCT-2", "Structure Fire - 2nd Alarm or Greater",
    "SWRES",    "Swift Water Rescue",
    "TH",       "Townhouse Fire",
    "THR",      "BLS - Threatened Suicide",
    "TRANSF",   "Mutual Aid Transfer",
    "TRANSP",   "Emergency Transport",
    "TRENCH",   "Trench Space",
    "TRUCK",    "Vehicle Fire (large vehicles)",
    "UALARM",   "Unknown Alarm Sounding",
    "UNC",      "Unconscious",
    "UNKSIT",   "Unknown Situation",
    "VEH",      "Vehicle Fire (small vehicles)"
  });
}