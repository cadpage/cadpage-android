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
      int len = code.length();
      if (len >= 4 && Character.isDigit(code.charAt(0)) && 
          Character.isDigit(code.charAt(len-1)) && code.charAt(len-2) == '0') {
        code = code.substring(0,len-2) + code.substring(len-1);
      }
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
      "1A1",      "Abdominal pain",
      "1C1",      "Abdominal Pain - Fainting/near fainting ≥50",
      "1C2",      "Abdominal Pain - Females fainting/near fainting 12 – 50",
      "1C3",      "Abdominal Pain - Males pain above navel ≥35",
      "1C4",      "Abdominal Pain - Females pain above navel ≥45",
      "1D1",      "Abdominal Pain - Not alert",
      
      /// 2. Allergies(Reactions)/Envenomations (Stings/Bites) 
      "2A1",      "Allergic reaction - No difficulty breathing/swallowing",
      "2A2",      "Spider bite",
      "2B1",      "Allergic reaction - Unknown status (3rd party caller)",
      "2C1",      "Allergic reaction - Difficulty breathing or swallowing",
      "2C2",      "Allergic reaction - Special medications or injections used",
      "2D1",      "Allergic reaction - Severe respiratory distress",
      "2D2",      "Allergic reaction - not alert",
      "2D3",      "Allergic reaction - Condition worsening",
      "2D4",      "Swarming attack (bee, wasp, hornet)",
      "2D5",      "Snakebite",
      "2E1",      "Allergic reaction - Ineffective breathing",
      
      // 3. Animal Bites/Attacks 
      "3A1",      "Animal bite - Not dangerous body area",
      "3A2",      "Animal bite - Non-recent injuries (≥6 hours)",
      "3A3",      "Animal bite - Superficial bites",
      "3B1",      "Animal bite - Possibly dangerous body area",
      "3B2",      "Animal bite - Serous hemorrhage",
      "3B3",      "Animal bite - Unknown status (3rd party caller)",
      "3D1",      "Animal bite - Unconscious or arrest",
      "3D2",      "Animal bite - Not alert",
      "3D3",      "Animal bite - Dangerous body area",
      "3D4",      "Animal bite - Large animal",
      "3D5",      "Animal bite - Exotic animal",
      "3D6",      "Animal bite - Attack or multiple animals",
      
      //4. Assault/Sexual Assault 
      "4A1",      "Assault - Not dangerous body area",
      "4A2",      "Assault - Non-recent injuries (≥6 hours)",
      "4B1",      "Assault - Possibly dangerous body area",
      "4B2",      "Assault - Not alert",
      "4B3",      "Assault - Unknown status (3rd party caller)",
      "4D1",      "Assault - Unconscious or arrest",
      "4D2",      "Assault - Not alert",
      "4D3",      "Assault - Abnormal breathing",
      "4D4",      "Assault - Dangerous body area",
      "4D5",      "Assault - Multiple victims",
      
      // 5. Back Pain (Non-Traumatic or Non-Recent Trauma) 
      "5A1",      "Non-traumatic back pain",
      "5A2",      "Non-recent traumatic back pain (≥6 hours)",
      "5C1",      "Back Pain - Fainting or near fainting ≥50",
      "5D1",      "Back Pain - Not alert",
      
      // 6. Breathing Problems 
      "6C1",      "Abnormal breathing",
      "6C2",      "Breathing Problems - Cardiac history",
      "6D1",      "Severe respiratory distress",
      "6D2",      "Breathing Problems - Not alert",
      "6D3",      "Breathing Problems - Clammy",
      "6E1",      "Ineffective breathing",
      
      // 7. Burns (Scalds)/Explosions 
      "7A1",      "Burns <18% body area",
      "7A2",      "Burns - Fire alarm (unknown situation)",
      "7A3",      "Burns - Sunburn or minor burns (≤ hand size)",
      "7B1",      "Burns - Unknown status (3rd party caller)",
      "7C1",      "Building fire with persons reported inside",
      "7C2",      "Burns - Difficulty breathing",
      "7C3",      "Burns ≥18% body area",
      "7D1",      "Burns - Unconscious or arrest",
      "7D2",      "Burns - Severe respiratory distress",
      "7D3",      "Burns - Not alert",
      "7D4",      "Explosion",
      "7D5",      "Burns - Multiple victims",
      
      //8. Carbon Monoxide/Inhalation/Hazmat 
      "8A1",      "CO detector alarm (without priority symptoms)",
      "8B1",      "Carbon Monoxide - Alert without difficulty breathing",
      "8C1",      "Carbon Monoxide - Alert with difficulty breathing",
      "8D1",      "Carbon Monoxide - Unconscious or arrest",
      "8D2",      "Carbon Monoxide - Severe respiratory distress",
      "8D3",      "Carbon Monoxide - Hazmat",
      "8D4",      "Carbon Monoxide - Not alert",
      "8D5",      "Carbon Monoxide - Multiple victims",
      "8D6",      "Carbon Monoxide - Unknown status (3rd party caller)",
      
      /// 9. Cardiac or Respiratory Arrest/Death 
      "9B1",      "Obvious death (unquestionable)",
      "9D1",      "Ineffective breathing",
      "9E1",      "Suspected workable arrest – not breathing at all",
      "9E2",      "Suspected workable arrest – breathing uncertain (agonal)",
      "9E3",      "Suspected workable arrest – hanging",
      "9E4",      "Suspected workable arrest – strangulation",
      "9E5",      "Suspected workable arrest – suffocation",
      "9E6",      "Suspected workable arrest – underwater",
      "9E7",      "Expected death",
      
      // 10. Chest pain 
      "10A1",      "Chest Pain - Breathing normally <35",
      "10C1",      "Chest Pain - Abnormal breathing",
      "10C2",      "Chest Pain - Cardiac history",
      "10C3",      "Chest Pain - Cocaine",
      "10C4",      "Chest Pain - Breathing normally ≥35",
      "10D1",      "Chest Pain - Severe respiratory distress",
      "10D2",      "Chest Pain - Not alert",
      "10D3",      "Chest Pain - Clammy",
      
      ///11. Choking 
      "11A1",      "Choking - Not choking now (can talk or cry, is alert and breathing normally)",
      "11D1",      "Choking - Not alert",
      "11D2",      "Choking - Abnormal breathing (partial obstruction)",
      "11E1",      "Choking",
      
      // 12. Convulsions/Seizures 
      "12A1",      "Seizure - Not seizing now and breathing regularly (verified)",
      "12B1",      "Seizure - Breathing regularly – not verified <35",
      "12C1",      "Seizure - Pregnancy",
      "12C2",      "Seizure - Diabetic",
      "12C3",      "Seizure - Cardiac history",
      "12D1",      "Seizure - Not breathing",
      "12D2",      "Seizure - Continuous or multiple seizures",
      "12D3",      "Seizure - Irregular breathing",
      "12D4",      "Seizure - Breathing regularly – not verified ≥35",
      
      // 13. Diabetic Problems 
      "13A1",      "Diabetic Problem - Alert",
      "13C1",      "Diabetic Problem - Not alert",
      "13C2",      "Diabetic Problem - Abnormal behavior",
      "13C3",      "Diabetic Problem - Abnormal breathing",
      "13D1",      "Diabetic Problem - Unconscious",
      
      // 14. Drowning (Near)/Diving/Scuba Accident 
      "14A1",      "Drowning - Alert and breathing normally (no injuries and out of water)",
      "14B1",      "Drowning - Alert and breathing normally (injuries or in water)",
      "14B2",      "Drowning - Unknown status (3rd party caller)",
      "14C1",      "Drowning - Alert with abnormal breathing",
      "14D1",      "Drowning - Unconscious",
      "14D2",      "Drowning - Not alert",
      "14D3",      "Diving or suspected neck injury",
      "14D4",      "Scuba accident",
      // 15. Electrocution/Lightning 
      "15C1",      "Electrocution - Alert and breathing normally",
      "15D1",      "Electrocution - Unconscious",
      "15D2",      "Electrocution - Not disconnected from power",
      "15D3",      "Electrocution - Power not off or hazard present",
      "15D4",      "Electrocution - Long fall (≥6 feet)",
      "15D5",      "Electrocution - Not alert",
      "15D6",      "Electrocution - Abnormal breathing",
      "15D7",      "Electrocution - Unknown status (3rd party caller)",
      "15D8",      "Electrocution - Not breathing/ineffective breathing",
      
      // 16. Eye Problems/Injuries 
      "16A1",      "Moderate eye injury",
      "16A2",      "Minor eye injury",
      "16A3",      "Medical eye problem",
      "16B1",      "Severe eye injury",
      "16D1",      "Eye Injuries - Not alert",
      
      // 17. Falls 
      "17A1",      "Fall - Not dangerous body area",
      "17A2",      "Fall - Not recent (≥6 hours) injuries (without priority medical symptoms)",
      "17A3",      "Fall - Public assist (no injuries and no priority symptoms)",
      "17B1",      "Fall - Possibly dangerous body area",
      "17B2",      "Fall - Serious hemorrhage",
      "17B3",      "Fall - Unknown status (3rd party caller)",
      "17D1",      "Fall - Dangerous body area",
      "17D2",      "Fall - Long fall (≥6 feet)",
      "17D3",      "Fall - Not alert",
      "17D4",      "Fall - Abnormal breathing",
      
      // 18. Headache 
      "18A1",      "Headache - Breathing normally",
      "18B1",      "Headache - Unknown status",
      "18C1",      "Headache - Not alert",
      "18C2",      "Headache - Abnormal breathing",
      "18C3",      "Headache - Speech problems",
      "18C4",      "Headache - Sudden onset of severe pain (≤3 hours)",
      "18C5",      "Headache - Numbness or paralysis",
      "18C6",      "Headache - Change in behavior (≤3 hours)",
      
      // 19. Heart Problems/AICD (Automatic Implanted Cardiac Defibrillator) 
      "19A1",      "Heart rate ≥50 bpm and <130 bpm (without priority symptoms)",
      "19A2",      "Chest pain <35 (without priority symptoms)",
      "19B1",      "Heart Problem - Unknown status (3rd party caller)",
      "19C1",      "Heart Problem - Firing of AICD",
      "19C2",      "Heart Problem - Abnormal breathing",
      "19C3",      "Heart Problem - Chest pain ≥35",
      "19C4",      "CHeart Problem - ardiac history",
      "19C5",      "Heart Problem - Cocaine",
      "19C6",      "Heart rate <50 bpm or ≥130 bpm (without priority symptoms)",
      "19D1",      "Heart Problem - Severe respiratory distress",
      "19D2",      "Heart Problem - Not alert",
      "19D3",      "Heart Problem - Clammy",
      
      // 20. Heat/Cold Exposure 
      "20A1",      "Exposure - Alert",
      "20B1",      "Exposure - Change in skin color",
      "20B2",      "Exposure - Unknown status (3rd party caller)",
      "20C1",      "Exposure - Cardiac history",
      "20D1",      "Exposure - Not alert",
      
      // 21. Hemorrhage/Lacerations 
      "21A1",      "Not dangerous hemorrhage",
      "21A2",      "Minor hemorrhage",
      "21B1",      "Possibly dangerous hemorrhage",
      "21B2",      "Serious hemorrhage",
      "21B3",      "Bleeding disorder or blood thinners",
      "21C1",      "Hemorrhage through tubes",
      "21D1",      "Dangerous hemorrhage",
      "21D2",      "Hemorrhage - Not alert",
      "21D3",      "Hemorrhage - Abnormal breathing",
      
      // 22. Industrial/Machinery Accidents 
      "22B1",      "Accident - Unknown situation (not caught in machinery)",
      "22D1",      "Accident - Life status questionable",
      "22D2",      "Accident - Caught in machinery (unknown status)",
      "22D3",      "Accident - Multiple victims",
      
      // 23. Overdose/Poisoning (Ingestion) 
      "23A1",      "Poisoning (without priority symptoms) (EHSF change from 23Ω1)",
      "23B1",      "Overdose (without priority symptoms)",
      "23C1",      "Overdose - Violent (police must rescue)",
      "23C2",      "Overdose - Not alert",
      "23C3",      "Overdose - Abnormal breathing",
      "23C4",      "Overdose - Antidepressants (tricyclic)",
      "23C5",      "Overdose - Cocaine (or derivative)",
      "23C6",      "Overdose - Narcotics (heroin)",
      "23C7",      "Poisoning - Acid or alkali (lye)",
      "23C8",      "Overdose - Unknown status (3rd party caller)",
      "23C9",      "Poison Control request for response",
      "23D1",      "Overdose - Unconscious",
      "23D2",      "Overdose - Severe respiratory distress",
      
      // 24. Pregnancy/Childbirth/Miscarriage 
      "24A1",      "1 st trimester hemorrhage or miscarriage",
      "24B1",      "Labor (delivery not imminent, ≥5 months/20 weeks)",
      "24B2",      "Pregnancy - Unknown status (3rd party caller)",
      "24C1",      "2 nd trimester hemorrhage or miscarriage",
      "24C2",      "1 st trimester serious hemorrhage",
      "24D1",      "Pregnancy - Breech or cord",
      "24D2",      "Pregnancy - Head visible or out",
      "24D3",      "Pregnancy - Imminent birth (≥5 months/20 weeks)",
      "24D4",      "3rd trimester hemorrhage",
      "24D5",      "Pregnancy - High-risk complications",
      "24D6",      "Baby born",
       
      // 25. Psychiatric/Abnormal Behavior/Suicide Attempt 
      "25A1",      "Psychiatric - Non-violent and non-suicidal (alert)",
      "25B1",      "Psychiatric - Violent (police must secure)",
      "25B2",      "Threatening suicide",
      "25B3",      "Near hanging, strangulation or suffocation (alert)",
      "25B4",      "Psychiatric - Unknown status (3rd party caller)",
      
      // 26. Sick Person (Specific Diagnosis) 
      "26A1",      "Sick - No priority symptoms",
      "26A2",      "Sick - Non-priority complaints",
      "26B1",      "Sick - Unknown status (3rd party caller)",
      "26B2",      "Sick - Cardiac history (complaint conditions 2-28 not identified)",
      "26D1",      "Sick - Not alert",
      
      // 27. Stab/Gunshot/Penetrating Trauma 
      "27A1",      "Penetrating Trauma - Non-recent (≥6 hours) peripheral wounds",
      "27B1",      "Penetrating Trauma - Non-recent (≥6 hours) single central wound",
      "27B2",      "Penetrating Trauma - Known single peripheral wound",
      "27B3",      "Penetrating Trauma - Serious hemorrhage",
      "27B4",      "Penetrating Trauma - Unknown status (3rd party caller)",
      "27D1",      "Penetrating Trauma - Unconscious or arrest",
      "27D2",      "Penetrating Trauma - Not alert",
      "27D3",      "Penetrating Trauma - Central wounds",
      "27D4",      "Penetrating Trauma - Multiple wounds",
      "27D5",      "Penetrating Trauma - Multiple victims",
      
      //28. Stroke (CVA) 
      "28A1",      "Stroke - Breathing normally <35",
      "28B1",      "Stroke - Unknown status (3rd party caller)",
      "28C1",      "Stroke - Not alert",
      "28C2",      "Stroke - Abnormal breathing",
      "28C3",      "Stroke - Speech or movement problems",
      "28C4",      "Stroke - Numbness or tingling",
      "28C5",      "Stroke - Stroke history",
      "28C6",      "Stroke - Breathing normally ≥35",
      
      // 29. Traffic/Transportation Accidents 
      "29A1",      "MVA - 1st party caller with injury to not dangerous part of body",
      "29B1",      "MVA - Injuries",
      "29B2",      "MVA - Multiple victims (one unit)",
      "29B3",      "MVA - Multiple victims (additional units)",
      "29B4",      "MVA - Serious hemorrhage",
      "29B5",      "MVA - Unknown status (3rd party caller)",
      "29D1",      "Major incident (aircraft, bus, subway, train, watercraft)",
      "29D2",      "MVA - High mechanism",
      "29D3",      "MVA - Hazmat",
      "29D4",      "MVA - Pinned (trapped) victim",
      "29D5",      "MVA - Not alert",
      
      // 30. Traumatic Injuries (Specific) 
      "30A1",      "Trauma - Not dangerous body area",
      "30A2",      "Trauma - Non-recent injuries (≥6 hours)",
      "30B1",      "Trauma - Possibly dangerous body area",
      "30B2",      "Trauma - Serious hemorrhage",
      "30D1",      "Trauma - Dangerous body area",
      "30D2",      "Trauma - Not alert",
      "30D3",      "Trauma - Breathing abnormal",
      
      // 31. Unconscious/Fainting (Near) 
      "31A1",      "Single or near fainting episode and alert <35",
      "31C1",      "Unconscious - Alert with abnormal breathing",
      "31C2",      "Unconscious - Cardiac history",
      "31C3",      "Multiple fainting episodes",
      "31C4",      "Single or near fainting episode and alert ≥35",
      "31C5",      "Females 12-50 with abdominal pains",
      "31D1",      "Unconscious (at end of interrogation)",
      "31D2",      "Unconscious - Severe respiratory distress",
      "31D3",      "Unconscious - Not alert",
      "31E1",      "Unconscious - Ineffective breathing 32. Unknown Problem",
      "32B1",      "Unconscious - Standing, sitting, moving or talking",
      "32B2",      "Unconscious - Medical alert notifications",
      "32B3",      "Unconscious - Unknown status (3rd party caller)",
      "32D1",      "Unconscious - Life status questionable",
      
      //33. Transfer/Interfacility/Palliative Care 
      "33A1",      "Transfer - Acuity I (no priority symptoms)",
      "33A2",      "Transfer - Acuity II (no priority symptoms)",
      "33A3",      "Transfer - Acuity III (no priority symptoms)",
      "33C1",      "Transfer - Not alert (acute change)",
      "33C2",      "Transfer - Abnormal breathing (acute onset)",
      "33C3",      "Transfer - Significant hemorrhage or shock",
      "33C4",      "Transfer - Possible acute heart problems or MI (heart attack)",
      "33C5",      "Transfer - Acute severe pain",
      "33C6",      "Transfer - Emergency response requested",
      "33D1",      "Transfer - Suspected cardiac or respiratory arrest  CAD Fire Incident Codes",
      
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
	