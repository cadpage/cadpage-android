package net.anei.cadpage.parsers.NY;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA13Parser;




public class NYStLawrenceCountyParser extends DispatchA13Parser {
  
  private static final Pattern ROUTE_PTN = Pattern.compile("\\b[A-Z]+ +(\\d+)");
  
  public NYStLawrenceCountyParser() {
    super(CITY_LIST, "ST LAWRENCE COUNTY", "NY");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@stlawco.org";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.endsWith("911 DISPATCH")) return false;
    if (! super.parseMsg(body, data)) return false;
    
    // If call contains a response code expand it to full description
    // The last part of the code may contain a leading zero which
    // will need to be removed.
    if (data.strCall.startsWith("Response Type ")) {
      String code = data.strCall.substring(14).trim();
      String call = CALL_CODES.getProperty(code);
      if (call != null) {
        data.strCode = code;
        data.strCall = call;
      }
    }
    
    // More strangeness.  Cities are often followed a dash and something that might be
    // a place name, but is usually a restatement of a previous ROUTE number, this time
    // adding some qualifiers as to what kind of highway it is.
    int pt = data.strCity.indexOf('-');
    if (pt >= 0) {
      String extra = data.strCity.substring(pt+1).trim();
      if (!extra.equals("WINTHROP")) {
        data.strCity = data.strCity.substring(0,pt).trim();
        
        Matcher match = ROUTE_PTN.matcher(extra);
        if (match.matches()) {
          String searchRoute = "ROUTE " + match.group(1);
          pt = data.strAddress.indexOf(searchRoute);
          if (pt >= 0) {
            data.strAddress = data.strAddress.substring(0,pt) + match.group(0) + data.strAddress.substring(pt+searchRoute.length());
            extra = null;
          }
        }
      }
      if (extra != null) data.strPlace = extra;
    }
    
    // Dispatch sprinkles a lot of #NY terms after addresses for no apparent reason
    if (data.strApt.startsWith("NY")) data.strApt = data.strApt.substring(2).trim();
    
    if (data.strCity.equals("OGD")) {
      data.strCity = "OGDENSBURG";
    }
    
    // Trim VILLAGE off of city names
    else if (data.strCity.endsWith(" VILLAGE")) {
      data.strCity = data.strCity.substring(0,data.strCity.length()-8).trim();
    }
    
    else if (data.strCity.endsWith(" CITY")) {
      data.strCity = data.strCity.substring(0,data.strCity.length()-5).trim();
    }
    
    // More special cases
    else if (NUMERIC.matcher(data.strAddress).matches() && data.strCity.contains(" ")) {
      data.strAddress = data.strAddress + " " + data.strCity;
      data.strCity = "";
    }
    
    else if (data.strCity.endsWith(" DORM")) {
      data.strPlace = append(data.strPlace, " - ", data.strCity);
      data.strCity = "";
    }
    
    else if (data.strCity.equalsIgnoreCase("CLARKSON UNIVERSITY")) {
      data.strPlace = append(data.strPlace, " - ", data.strAddress);
      data.strAddress = data.strCity;
      data.strCity = "POTSDAM";
    }
    
    return true;
  }
  
  @Override
  public String getProgram() {
    return super.getProgram() + " PLACE";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_ADD_PLACE;
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    addr = MAP_CLEAN_PTN.matcher(addr).replaceAll("");
    return addr.trim();
  }
  private static final Pattern MAP_CLEAN_PTN = Pattern.compile("\\bV[AI]CINITY\\b");
  
  private static final String[] CITY_LIST = new String[]{
    "BRASHER",
    "BRASHER FALLS-WINTHROP",
    "CANTON",
    "CLARE",
    "CLIFTON",
    "COLTON",
    "DE KALB",
    "DE PEYSTER",
    "EDWARDS",
    "FINE",
    "FOWLER",
    "GOUVERNEUR",
    "HAMMOND",
    "HERMON",
    "HEUVELTON",
    "HOPKINTON",
    "LAWRENCE",
    "LISBON",
    "LOUISVILLE",
    "MACOMB",
    "MADRID",
    "MASSENA",
    "MORRISTOWN",
    "NORFOLK",
    "NORWOOD",
    "OGD",
    "OGDENSBURG",
    "OSWEGATCHIE",
    "PARISHVILLE",
    "PIERCEFIELD",
    "PIERREPONT",
    "PITCAIRN",
    "POTSDAM",
    "RENSSELAER FALLS",
    "RICHVILLE",
    "ROSSIE",
    "RUSSELL",
    "STAR LAKE",
    "STOCKHOLM",
    "WADDINGTON"
  };
  
  private static final Properties CALL_CODES = buildCodeTable(new String[]{
      
      // 1. Abdominal Pain/Problems 
      "01A01",    "Abdominal pain",
      "01C01",    "Abdominal Pain - Fainting/near fainting ≥50",
      "01C02",    "Abdominal Pain - Females fainting/near fainting 12 – 50",
      "01C03",    "Abdominal Pain - Males pain above navel ≥35",
      "01C04",    "Abdominal Pain - Females pain above navel ≥45",
      "01D01",    "Abdominal Pain - Not alert",
      
      /// 2. Allergies(Reactions)/Envenomations (Stings/Bites) 
      "02A01",    "Allergic reaction - No difficulty breathing/swallowing",
      "02A02",    "Spider bite",
      "02B01",    "Allergic reaction - Unknown status (3rd party caller)",
      "02C01",    "Allergic reaction - Difficulty breathing or swallowing",
      "02C02",    "Allergic reaction - Special medications or injections used",
      "02D01",    "Allergic reaction - Severe respiratory distress",
      "02D02",    "Allergic reaction - not alert",
      "02D03",    "Allergic reaction - Condition worsening",
      "02D04",    "Swarming attack (bee, wasp, hornet)",
      "02D05",    "Snakebite",
      "02E01",    "Allergic reaction - Ineffective breathing",
      
      // 3. Animal Bites/Attacks 
      "03A01",    "Animal bite - Not dangerous body area",
      "03A02",    "Animal bite - Non-recent injuries (≥6 hours)",
      "03A03",    "Animal bite - Superficial bites",
      "03B01",    "Animal bite - Possibly dangerous body area",
      "03B02",    "Animal bite - Serous hemorrhage",
      "03B03",    "Animal bite - Unknown status (3rd party caller)",
      "03D01",    "Animal bite - Unconscious or arrest",
      "03D02",    "Animal bite - Not alert",
      "03D03",    "Animal bite - Dangerous body area",
      "03D04",    "Animal bite - Large animal",
      "03D05",    "Animal bite - Exotic animal",
      "03D06",    "Animal bite - Attack or multiple animals",
      
      //4. Assault/Sexual Assault 
      "04A01",    "Assault - Not dangerous body area",
      "04A02",    "Assault - Non-recent injuries (≥6 hours)",
      "04B01",    "Assault - Possibly dangerous body area",
      "04B02",    "Assault - Not alert",
      "04B03",    "Assault - Unknown status (3rd party caller)",
      "04D01",    "Assault - Unconscious or arrest",
      "04D02",    "Assault - Not alert",
      "04D03",    "Assault - Abnormal breathing",
      "04D04",    "Assault - Dangerous body area",
      "04D05",    "Assault - Multiple victims",
      
      // 5. Back Pain (Non-Traumatic or Non-Recent Trauma) 
      "05A01",    "Non-traumatic back pain",
      "05A02",    "Non-recent traumatic back pain (≥6 hours)",
      "05C01",    "Back Pain - Fainting or near fainting ≥50",
      "05D01",    "Back Pain - Not alert",
      
      // 6. Breathing Problems 
      "06C01",    "Abnormal breathing",
      "06C02",    "Breathing Problems - Cardiac history",
      "06D01",    "Severe respiratory distress",
      "06D02",    "Breathing Problems - Not alert",
      "06D03",    "Breathing Problems - Clammy",
      "06E01",    "Ineffective breathing",
      
      // 7. Burns (Scalds)/Explosions 
      "07A01",    "Burns <18% body area",
      "07A02",    "Burns - Fire alarm (unknown situation)",
      "07A03",    "Burns - Sunburn or minor burns (≤ hand size)",
      "07B01",    "Burns - Unknown status (3rd party caller)",
      "07C01",    "Building fire with persons reported inside",
      "07C02",    "Burns - Difficulty breathing",
      "07C03",    "Burns ≥18% body area",
      "07D01",    "Burns - Unconscious or arrest",
      "07D02",    "Burns - Severe respiratory distress",
      "07D03",    "Burns - Not alert",
      "07D04",    "Explosion",
      "07D05",    "Burns - Multiple victims",
      
      //8. Carbon Monoxide/Inhalation/Hazmat 
      "08A01",    "CO detector alarm (without priority symptoms)",
      "08B01",    "Carbon Monoxide - Alert without difficulty breathing",
      "08C01",    "Carbon Monoxide - Alert with difficulty breathing",
      "08D01",    "Carbon Monoxide - Unconscious or arrest",
      "08D02",    "Carbon Monoxide - Severe respiratory distress",
      "08D03",    "Carbon Monoxide - Hazmat",
      "08D04",    "Carbon Monoxide - Not alert",
      "08D05",    "Carbon Monoxide - Multiple victims",
      "08D06",    "Carbon Monoxide - Unknown status (3rd party caller)",
      
      /// 9. Cardiac or Respiratory Arrest/Death 
      "09B01",    "Obvious death (unquestionable)",
      "09D01",    "Ineffective breathing",
      "09E01",    "Suspected workable arrest – not breathing at all",
      "09E02",    "Suspected workable arrest – breathing uncertain (agonal)",
      "09E03",    "Suspected workable arrest – hanging",
      "09E04",    "Suspected workable arrest – strangulation",
      "09E05",    "Suspected workable arrest – suffocation",
      "09E06",    "Suspected workable arrest – underwater",
      "09E07",    "Expected death",
      
      // 10. Chest pain 
      "10A01",     "Chest Pain - Breathing normally <35",
      "10C01",     "Chest Pain - Abnormal breathing",
      "10C02",     "Chest Pain - Cardiac history",
      "10C03",     "Chest Pain - Cocaine",
      "10C04",     "Chest Pain - Breathing normally ≥35",
      "10D01",     "Chest Pain - Severe respiratory distress",
      "10D02",     "Chest Pain - Not alert",
      "10D03",     "Chest Pain - Clammy",
      
      ///11. Choking 
      "11A01",     "Choking - Not choking now (can talk or cry, is alert and breathing normally)",
      "11D01",     "Choking - Not alert",
      "11D02",     "Choking - Abnormal breathing (partial obstruction)",
      "11E01",     "Choking",
      
      // 12. Convulsions/Seizures 
      "12A01",     "Seizure - Not seizing now and breathing regularly (verified)",
      "12B01",     "Seizure - Breathing regularly – not verified <35",
      "12C01",     "Seizure - Pregnancy",
      "12C02",     "Seizure - Diabetic",
      "12C03",     "Seizure - Cardiac history",
      "12D01",     "Seizure - Not breathing",
      "12D02",     "Seizure - Continuous or multiple seizures",
      "12D03",     "Seizure - Irregular breathing",
      "12D04",     "Seizure - Breathing regularly – not verified ≥35",
      
      // 13. Diabetic Problems 
      "13A01",     "Diabetic Problem - Alert",
      "13C01",     "Diabetic Problem - Not alert",
      "13C02",     "Diabetic Problem - Abnormal behavior",
      "13C03",     "Diabetic Problem - Abnormal breathing",
      "13D01",     "Diabetic Problem - Unconscious",
      
      // 14. Drowning (Near)/Diving/Scuba Accident 
      "14A01",     "Drowning - Alert and breathing normally (no injuries and out of water)",
      "14B01",     "Drowning - Alert and breathing normally (injuries or in water)",
      "14B02",     "Drowning - Unknown status (3rd party caller)",
      "14C01",     "Drowning - Alert with abnormal breathing",
      "14D01",     "Drowning - Unconscious",
      "14D02",     "Drowning - Not alert",
      "14D03",     "Diving or suspected neck injury",
      "14D04",     "Scuba accident",
      // 15. Electrocution/Lightning 
      "15C01",     "Electrocution - Alert and breathing normally",
      "15D01",     "Electrocution - Unconscious",
      "15D02",     "Electrocution - Not disconnected from power",
      "15D03",     "Electrocution - Power not off or hazard present",
      "15D04",     "Electrocution - Long fall (≥6 feet)",
      "15D05",     "Electrocution - Not alert",
      "15D06",     "Electrocution - Abnormal breathing",
      "15D07",     "Electrocution - Unknown status (3rd party caller)",
      "15D08",     "Electrocution - Not breathing/ineffective breathing",
      
      // 16. Eye Problems/Injuries 
      "16A01",     "Moderate eye injury",
      "16A02",     "Minor eye injury",
      "16A03",     "Medical eye problem",
      "16B01",     "Severe eye injury",
      "16D01",     "Eye Injuries - Not alert",
      
      // 17. Falls 
      "17A01",     "Fall - Not dangerous body area",
      "17A02",     "Fall - Not recent (≥6 hours) injuries (without priority medical symptoms)",
      "17A03",     "Fall - Public assist (no injuries and no priority symptoms)",
      "17B01",     "Fall - Possibly dangerous body area",
      "17B02",     "Fall - Serious hemorrhage",
      "17B03",     "Fall - Unknown status (3rd party caller)",
      "17D01",     "Fall - Dangerous body area",
      "17D02",     "Fall - Long fall (≥6 feet)",
      "17D03",     "Fall - Not alert",
      "17D04",     "Fall - Abnormal breathing",
      
      // 18. Headache 
      "18A01",     "Headache - Breathing normally",
      "18B01",     "Headache - Unknown status",
      "18C01",     "Headache - Not alert",
      "18C02",     "Headache - Abnormal breathing",
      "18C03",     "Headache - Speech problems",
      "18C04",     "Headache - Sudden onset of severe pain (≤3 hours)",
      "18C05",     "Headache - Numbness or paralysis",
      "18C06",     "Headache - Change in behavior (≤3 hours)",
      
      // 19. Heart Problems/AICD (Automatic Implanted Cardiac Defibrillator) 
      "19A01",     "Heart rate ≥50 bpm and <130 bpm (without priority symptoms)",
      "19A02",     "Chest pain <35 (without priority symptoms)",
      "19B01",     "Heart Problem - Unknown status (3rd party caller)",
      "19C01",     "Heart Problem - Firing of AICD",
      "19C02",     "Heart Problem - Abnormal breathing",
      "19C03",     "Heart Problem - Chest pain ≥35",
      "19C04",     "CHeart Problem - ardiac history",
      "19C05",     "Heart Problem - Cocaine",
      "19C06",     "Heart rate <50 bpm or ≥130 bpm (without priority symptoms)",
      "19D01",     "Heart Problem - Severe respiratory distress",
      "19D02",     "Heart Problem - Not alert",
      "19D03",     "Heart Problem - Clammy",
      
      // 20. Heat/Cold Exposure 
      "20A01",     "Exposure - Alert",
      "20B01",     "Exposure - Change in skin color",
      "20B02",     "Exposure - Unknown status (3rd party caller)",
      "20C01",     "Exposure - Cardiac history",
      "20D01",     "Exposure - Not alert",
      
      // 21. Hemorrhage/Lacerations 
      "21A01",     "Not dangerous hemorrhage",
      "21A02",     "Minor hemorrhage",
      "21B01",     "Possibly dangerous hemorrhage",
      "21B02",     "Serious hemorrhage",
      "21B03",     "Bleeding disorder or blood thinners",
      "21C01",     "Hemorrhage through tubes",
      "21D01",     "Dangerous hemorrhage",
      "21D02",     "Hemorrhage - Not alert",
      "21D03",     "Hemorrhage - Abnormal breathing",
      
      // 22. Industrial/Machinery Accidents 
      "22B01",     "Accident - Unknown situation (not caught in machinery)",
      "22D01",     "Accident - Life status questionable",
      "22D02",     "Accident - Caught in machinery (unknown status)",
      "22D03",     "Accident - Multiple victims",
      
      // 23. Overdose/Poisoning (Ingestion) 
      "23A01",     "Poisoning (without priority symptoms) (EHSF change from 23Ω1)",
      "23B01",     "Overdose (without priority symptoms)",
      "23C01",     "Overdose - Violent (police must rescue)",
      "23C02",     "Overdose - Not alert",
      "23C03",     "Overdose - Abnormal breathing",
      "23C04",     "Overdose - Antidepressants (tricyclic)",
      "23C05",     "Overdose - Cocaine (or derivative)",
      "23C06",     "Overdose - Narcotics (heroin)",
      "23C07",     "Poisoning - Acid or alkali (lye)",
      "23C08",     "Overdose - Unknown status (3rd party caller)",
      "23C09",     "Poison Control request for response",
      "23D01",     "Overdose - Unconscious",
      "23D02",     "Overdose - Severe respiratory distress",
      
      // 24. Pregnancy/Childbirth/Miscarriage 
      "24A01",     "1 st trimester hemorrhage or miscarriage",
      "24B01",     "Labor (delivery not imminent, ≥5 months/20 weeks)",
      "24B02",     "Pregnancy - Unknown status (3rd party caller)",
      "24C01",     "2 nd trimester hemorrhage or miscarriage",
      "24C02",     "1 st trimester serious hemorrhage",
      "24D01",     "Pregnancy - Breech or cord",
      "24D02",     "Pregnancy - Head visible or out",
      "24D03",     "Pregnancy - Imminent birth (≥5 months/20 weeks)",
      "24D04",     "3rd trimester hemorrhage",
      "24D05",     "Pregnancy - High-risk complications",
      "24D06",     "Baby born",
       
      // 25. Psychiatric/Abnormal Behavior/Suicide Attempt 
      "25A01",     "Psychiatric - Non-violent and non-suicidal (alert)",
      "25B01",     "Psychiatric - Violent (police must secure)",
      "25B02",     "Threatening suicide",
      "25B03",     "Near hanging, strangulation or suffocation (alert)",
      "25B04",     "Psychiatric - Unknown status (3rd party caller)",
      
      // 26. Sick Person (Specific Diagnosis) 
      "26A01",     "Sick - No priority symptoms",
      "26A02",     "Sick - Non-priority complaints",
      "26B01",     "Sick - Unknown status (3rd party caller)",
      "26B02",     "Sick - Cardiac history (complaint conditions 2-28 not identified)",
      "26D01",     "Sick - Not alert",
      
      // 27. Stab/Gunshot/Penetrating Trauma 
      "27A01",     "Penetrating Trauma - Non-recent (≥6 hours) peripheral wounds",
      "27B01",     "Penetrating Trauma - Non-recent (≥6 hours) single central wound",
      "27B02",     "Penetrating Trauma - Known single peripheral wound",
      "27B03",     "Penetrating Trauma - Serious hemorrhage",
      "27B04",     "Penetrating Trauma - Unknown status (3rd party caller)",
      "27D01",     "Penetrating Trauma - Unconscious or arrest",
      "27D02",     "Penetrating Trauma - Not alert",
      "27D03",     "Penetrating Trauma - Central wounds",
      "27D04",     "Penetrating Trauma - Multiple wounds",
      "27D05",     "Penetrating Trauma - Multiple victims",
      
      //28. Stroke (CVA) 
      "28A01",     "Stroke - Breathing normally <35",
      "28B01",     "Stroke - Unknown status (3rd party caller)",
      "28C01",     "Stroke - Not alert",
      "28C02",     "Stroke - Abnormal breathing",
      "28C03",     "Stroke - Speech or movement problems",
      "28C04",     "Stroke - Numbness or tingling",
      "28C05",     "Stroke - Stroke history",
      "28C06",     "Stroke - Breathing normally ≥35",
      
      // 29. Traffic/Transportation Accidents 
      "29A01",     "MVA - 1st party caller with injury to not dangerous part of body",
      "29B01",     "MVA - Injuries",
      "29B02",     "MVA - Multiple victims (one unit)",
      "29B03",     "MVA - Multiple victims (additional units)",
      "29B04",     "MVA - Serious hemorrhage",
      "29B05",     "MVA - Unknown status (3rd party caller)",
      "29D01",     "Major incident (aircraft, bus, subway, train, watercraft)",
      "29D02",     "MVA - High mechanism",
      "29D03",     "MVA - Hazmat",
      "29D04",     "MVA - Pinned (trapped) victim",
      "29D05",     "MVA - Not alert",
      
      // 30. Traumatic Injuries (Specific) 
      "30A01",     "Trauma - Not dangerous body area",
      "30A02",     "Trauma - Non-recent injuries (≥6 hours)",
      "30B01",     "Trauma - Possibly dangerous body area",
      "30B02",     "Trauma - Serious hemorrhage",
      "30D01",     "Trauma - Dangerous body area",
      "30D02",     "Trauma - Not alert",
      "30D03",     "Trauma - Breathing abnormal",
      
      // 31. Unconscious/Fainting (Near) 
      "31A01",     "Single or near fainting episode and alert <35",
      "31C01",     "Unconscious - Alert with abnormal breathing",
      "31C02",     "Unconscious - Cardiac history",
      "31C03",     "Multiple fainting episodes",
      "31C04",     "Single or near fainting episode and alert ≥35",
      "31C05",     "Females 12-50 with abdominal pains",
      "31D01",     "Unconscious (at end of interrogation)",
      "31D02",     "Unconscious - Severe respiratory distress",
      "31D03",     "Unconscious - Not alert",
      "31E01",     "Unconscious - Ineffective breathing 32. Unknown Problem",
      "32B01",     "Unconscious - Standing, sitting, moving or talking",
      "32B02",     "Unconscious - Medical alert notifications",
      "32B03",     "Unconscious - Unknown status (3rd party caller)",
      "32D01",     "Unconscious - Life status questionable",
      
      //33. Transfer/Interfacility/Palliative Care 
      "33A01",     "Transfer - Acuity I (no priority symptoms)",
      "33A02",     "Transfer - Acuity II (no priority symptoms)",
      "33A03",     "Transfer - Acuity III (no priority symptoms)",
      "33C01",     "Transfer - Not alert (acute change)",
      "33C02",     "Transfer - Abnormal breathing (acute onset)",
      "33C03",     "Transfer - Significant hemorrhage or shock",
      "33C04",     "Transfer - Possible acute heart problems or MI (heart attack)",
      "33C05",     "Transfer - Acute severe pain",
      "33C06",     "Transfer - Emergency response requested",
      "33D01",     "Transfer - Suspected cardiac or respiratory arrest  CAD Fire Incident Codes",
      
      // Fire calls
      "FAFA",      "Automatic Fire Alarm",
      "FAFARD",    "Automatic Fire Alarm – reduced response",
      "FAIRCR",    "Aircraft Fire",
      "FBARN1",    "Barn Fire – first alarm",
      "FBARN2",    "Barn Fire – second alarm",
      "FBARN3",    "Barn Fire – third alarm",
      "FBARN4",    "Barn Fire – fourth alarm",
      "FCB",       "Controlled Burn",
      "FCODET",    "Carbon Monoxide Detector",
      "FHMINI",    "Hazardous Materials Incident – inside investigation",
      "FHMNS",     "Hazardous Materials Incident – non-structure",
      "FHMOUI",    "Hazardous Materials Incident – outside investigation",
      "FHMSTR",    "Hazardous Materials Incident – structure fire",
      "FLZ",       "Helicopter Landing Zone",
      "FMASTN",    "Mass Transportation Incident",
      "FMA",       "Fire Department Medical Assist", 
      "FMISC",     "Miscellaneous Incident",
      "FOTRES",    "Miscellaneous Rescue",
      "FOUI",      "Outside Investigation",
      "FSTR1",     "Structure Fire – first alarm",
      "FSTR2",     "Structure Fire – second alarm",
      "FSTR3",     "Structure Fire – third alarm",
      "FSTR4",     "Structure Fire – fourth alarm",
      "FVEHSM",    "Motor Vehicle Fire – car or small truck",
      "FVEHLG",    "Motor Vehicle Fire – large truck",
      "FVSNI",     "Motor Vehicle Versus Structure – no injuries",
      "FWARES",    "Water Rescue",
      "FWF",       "Wild Fire",
      "FWFVEH",    "Wild Fire Involving Vehicle",
      "FWFSTR",    "Wild Fire Endangering Structure",
      "FXFER1",    "Transfer Assignment – first alarm",
      "FXFER2",    "Transfer Assignment – second alarm",
      "FXFER3",    "Transfer Assignment – third alarm",
      "FXFER4",    "Transfer Assignment – fourth alarm",
      "MUTAID",    "Mutual Aid Response",
      "XFER",      "Transfer"    
  });
}
	