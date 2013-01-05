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
      "01C05",    "Abdominal Pain - Males w/ pain above navel > 45",
      "01C06",    "Abdominal Pain - Females w/ pain above navel > 45",
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
      "03D03",    "Animal bite - Chest or neck injury (with difficulty breathing)",
      "03D03",    "Animal bite - Dangerous body area",
      "03D05",    "Animal bite - Large animal",
      "03D06",    "Animal bite - Exotic animal",
      "03D07",    "Animal bite - Attack or multiple animals",
      
      //4. Assault/Sexual Assault 
      "04A01",    "Assault - Not dangerous body area",
      "04A02",    "Assault - Non-recent injuries (≥6 hours)",
      "04B01",    "Assault - Possibly dangerous body area",
      "04B02",    "Assault - Not alert",
      "04B03",    "Assault - Unknown status (3rd party caller)",
      "04D01",    "Assault - Unconscious or arrest",
      "04D02",    "Assault - Not alert",
      "04D03",    "Assault - Chest or neck injury (with difficulty breathing)",
      "04D04",    "Assault - Multiple victims",
      
      // 5. Back Pain (Non-Traumatic or Non-Recent Trauma) 
      "05A01",    "Non-traumatic back pain",
      "05A02",    "Non-recent traumatic back pain (≥6 hours)",
      "05C01",    "Back Pain - Suspected aortic aneuryism >50",
      "05C02",    "Back Pain - Known aortic aneuysm",
      "05C03",    "Back Pain - Fainting or near fainting >50",
      "05D01",    "Back Pain - Not alert",
      
      // 6. Breathing Problems 
      "06C01",    "Abnormal breathing",
      "06C02",    "Breathing Problems - Cardiac history",
      "06D01",    "Breathing Problems - Not alert",
      "06D02",    "Breathing Problems - Unconcious or arrest",
      "06D03",    "Breathing Problems - Changing color",
      "06D04",    "Breathing Problems - Clammy",
      "06E01",    "Ineffective breathing",
      
      // 7. Burns (Scalds)/Explosions 
      "07A01",    "Burns <18% body area",
      "07A02",    "Burns - Fire alarm (unknown situation)",
      "07A03",    "Burns - Sunburn or minor burns (≤ hand size)",
      "07B01",    "Burns - Blast Injuries (w/o priority symptons)",
      "07B02",    "Burns - Unknown status",
      "07C01",    "Building fire with persons reported inside",
      "07C02",    "Burns - Difficulty breathing",
      "07C03",    "Burns ≥18% body area",
      "07C04",    "Significant facial burns",
      "07D01",    "Burns - Multiple victims",
      "07D02",    "Burns - Unconscious or arrest",
      "07D03",    "Burns - Not alert",
      "07D04",    "Burns - Difficulty speaking between breaths",
      
      //8. Carbon Monoxide/Inhalation/Hazmat 
      "08A01",    "CO detector alarm (without priority symptoms)",
      "08B01",    "Carbon Monoxide - Alert without difficulty breathing",
      "08C01",    "Carbon Monoxide - Alert with difficulty breathing",
      "08D01",    "Carbon Monoxide - Unconscious or arrest",
      "08D02",    "Carbon Monoxide - Not alert",
      "08D03",    "Carbon Monoxide - Difficulty speaking between breaths",
      "08D04",    "Carbon Monoxide - Multiple victims",
      "08D05",    "Carbon Monoxide - Unknown status",
      
      /// 9. Cardiac or Respiratory Arrest/Death 
      "09B01",    "Obvious death (unquestionable)",
      "09B01a",   "Obvious death: Cold & stiff in a warm environment",
      "09B01b",   "Obvious death: Decapitation",
      "09B01c",   "Obvious death: Decomposition",
      "09B01d",   "Obvious death: Incineration",
      "09B01e",   "Obvious death: Non-recent death",
      "09B01g",   "Obvious death: Severe injuries incompatible w/ life",
      "09B01g",   "Obvious death: Submersion (>6 hours)",
      "09B01h",   "Obvious death: User defined",
      "09B01i",   "Obvious death: User defined",
      "09D01",    "Ineffective breathing",
      "09D02",    "Obvious death or expected death questionable",
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
      "10D01",     "Chest Pain - Not alert",
      "10D02",     "Chest Pain - Difficulty speaking between breaths",
      "10D03",     "Chest Pain - Changing color",
      "10D04",     "Chest Pain - Clammy",
      
      ///11. Choking 
      "11A01",     "Choking - Not choking now (can talk or cry, is alert and breathing normally)",
      "11D01",     "Choking - Abnormal breathing (partial obstruction)",
      "11D02",     "Choking - Not alert",
      "11E01",     "Choking verified",
      
      // 12. Convulsions/Seizures 
      "12A01",     "Seizure - Not seizing now and breathing regularly (verified)",
      "12A02",     "Seizure - Focal seizure (alert)",
      "12A03",     "Seizure - Impending seizure (aura)",
      "12B01",     "Seizure - Effective breathing not verified <35",
      "12C01",     "Seizure - Focal seizure (not alert)",
      "12C02",     "Seizure - Pregnancy",
      "12C03",     "Seizure - Diabetic",
      "12D01",     "Seizure - Not breathing",
      "12D02",     "Seizure - Continuous or multiple seizures",
      "12D03",     "Seizure - Agonal/ineffective breathing",
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
      "14B02",     "Drowning - Unknown status",
      "14C01",     "Drowning - Alert with abnormal breathing",
      "14D01",     "Drowning - Unconscious or arrest",
      "14D02",     "Drowning - Not alert",
      "14D03",     "Diving or suspected neck injury",
      "14D04",     "SCUBA accident",
      // 15. Electrocution/Lightning 
      "15C01",     "Electrocution - Alert and breathing normally",
      "15D01",     "Electrocution - Unconscious",
      "15D02",     "Electrocution - Not disconnected from power",
      "15D03",     "Electrocution - Power not off or hazard present",
      "15D04",     "Electrocution - Extreme fall (≥30 feet)",
      "15D05",     "Electrocution - Long fall",
      "15D06",     "Electrocution - Not alert",
      "15D07",     "Electrocution - Abnormal breathing",
      "15D08",     "Electrocution - Unknown status",
      "15E01",     "Electrocution - Not breathing/ineffective breathing",
      
      // 16. Eye Problems/Injuries 
      "16A01",     "Moderate eye injury",
      "16A02",     "Minor eye injury",
      "16A03",     "Medical eye problem",
      "16B01",     "Severe eye injury",
      "16D01",     "Eye Injuries - Not alert",
      
      // 17. Falls 
      "17A01",     "Fall - Not dangerous body area",
      "17A02",     "Fall - Not recent w/o priority symptoms)",
      "17A03",     "Fall - Public assist (no injuries and no priority symptoms)",
      "17B01",     "Fall - Possibly dangerous body area",
      "17B02",     "Fall - Serious hemorrhage",
      "17B03",     "Fall - Unknown status",
      "17D01",     "Fall - Extreme fall (>30ft)",
      "17D02",     "Fall - Unconscious or arrest",
      "17D03",     "Fall - Not alert",
      "17D04",     "Fall - Chest or neck injury (with difficulty breathing)",
      "17D04",     "Fall - Long fall",
      
      // 18. Headache 
      "18A01",     "Headache - Breathing normally",
      "18B01",     "Headache - Unknown status",
      "18C01",     "Headache - Not alert",
      "18C02",     "Headache - Abnormal breathing",
      "18C03",     "Headache - Speech problems",
      "18C04",     "Headache - Sudden onset of severe pain (≤3 hours)",
      "18C05",     "Headache - Numbness",
      "18C06",     "Headache - Paralysis",
      "18C07",     "Headache - Change in behavior (≤3 hours)",
      
      // 19. Heart Problems/AICD (Automatic Implanted Cardiac Defibrillator) 
      "19A01",     "Heart rate ≥50 bpm and <130 bpm (without priority symptoms)",
      "19A02",     "Chest pain <35 (without priority symptoms)",
      "19C01",     "Heart Problem - Firing of AICD",
      "19C02",     "Heart Problem - Abnormal breathing",
      "19C03",     "Heart Problem - Chest pain ≥35",
      "19C04",     "Heart Problem - Cardiac history",
      "19C05",     "Heart Problem - Cocaine",
      "19C06",     "Heart rate <50 bpm or ≥130 bpm (without priority symptoms)",
      "19C07",     "Heart Problem - Unknown status",
      "19D01",     "Heart Problem - Not alert",
      "19D02",     "Heart Problem - Difficulty speaking between breaths",
      "19D03",     "Heart Problem - Changing Color",
      "19D04",     "Heart Problem - Clammy",
      "19D05",     "Heart Problem - Just resuscitated and/or defibrillated",
      
      // 20. Heat/Cold Exposure 
      "20A01",     "Exposure - Alert",
      "20B01",     "Exposure - Change in skin color",
      "20B02",     "Exposure - Unknown status",
      "20C01",     "Exposure - Heart attack or angina history",
      "20D01",     "Exposure - Not alert",
      "20D02",     "Exposure - Multiple victims (w/ priority symptoms)",
      
      // 21. Hemorrhage/Lacerations 
      "21A01",     "Not dangerous hemorrhage",
      "21A02",     "Minor hemorrhage",
      "21B01",     "Possibly dangerous hemorrhage",
      "21B02",     "Serious hemorrhage",
      "21B03",     "Bleeding disorder or",
      "21B04",     "Hemorrhage -  blood thinners",
      "21C01",     "Hemorrhage through tubes",
      "21C02",     "Hemorrhage through dialysis fistula",
      "21D01",     "Hemorrhage - Unconscioius or arrest",
      "21D02",     "Hemorrhage - Not alert",
      "21D03",     "Hemorrhage - Dangerous Hemorrhage",
      "21D04",     "Hemorrhage - Abnormal breathing",
      
      // 22. Industrial/Machinery Accidents 
      "22A01",     "Accident - No longer trapped (no inj)",
      "22B01",     "Accident - No longer trapped (unk inj)",
      "22B02",     "Accident - Peripheral entrapment only",
      "22B03",     "Accident - Unknown status",
      "22D01",     "Accident - Mechanical/Machinery Entrapment",
      "22D02",     "Accident - Trench collapse",
      "22D03",     "Accident - Structure collapse",
      "22D04",     "Accident - Confined space entrapment",
      "22D05",     "Accident - Inaccessibel terrain situation",
      "22D06",     "Accident - Mudslide/Avalanche",
      
      // 23. Overdose/Poisoning (Ingestion) 
      "23A01",     "Poisoning (without priority symptoms) (EHSF change from 23Ω1)",
      "23B01",     "Overdose (without priority symptoms)",
      "23C01",     "Overdose - Not alert",
      "23C02",     "Overdose - Abnormal breathing",
      "23C03",     "Overdose - Antidepressants (tricyclic)",
      "23C04",     "Overdose - Cocaine (or derivative)",
      "23C05",     "Overdose - Narcotics (heroin)",
      "23C06",     "Poisoning - Acid or alkali (lye)",
      "23C07",     "Overdose - Unknown status",
      "23C08",     "Poison Control request for response",
      "23D01",     "Overdose - Unconscious",
      "23D02",     "Overdose - Severe respiratory distress",
      
      // 24. Pregnancy/Childbirth/Miscarriage 
      "24A01",     "1 st trimester hemorrhage or miscarriage",
      "24B01",     "Labor (delivery not imminent, ≥5 months/20 weeks)",
      "24B02",     "Pregnancy - Unknown status",
      "24C01",     "2 nd trimester hemorrhage or miscarriage",
      "24C02",     "1 st trimester serious hemorrhage",
      "24C03",     "Baby born - No complications",
      "24D01",     "Pregnancy - Breech or cord",
      "24D02",     "Pregnancy - Head visible or out",
      "24D03",     "Pregnancy - Imminent birth (≥5 months/20 weeks)",
      "24D04",     "3rd trimester hemorrhage",
      "24D05",     "Pregnancy - High-risk complications",
      "24D06",     "Baby born (complications with baby)",
      "24D07",     "Baby born (complications with mother)",
       
      // 25. Psychiatric/Abnormal Behavior/Suicide Attempt 
      "25A01",     "Psychiatric - Non-suicidal and alert",
      "25A02",     "Suicidal (non threatening) and alert",
      "25B01",     "Psychiatric - Serious hemorrhage",
      "25B02",     "Psychiatric - Non-serioius or minor hemorrhage",
      "25B03",     "Threatening suicide",
      "25B04",     "Psychiatric - Jumpber (thratening)",
      "25B05",     "Near hanging, strangulation or suffocation (alert)",
      "25B06",     "Psychiatric - Unknown status (3rd party caller)",
      
      // 26. Sick Person (Specific Diagnosis) 
      "26A01",     "Sick - No priority symptoms",
      "26A02",     "Sick - Blood pressure abnormallity",
      "26A03",     "Sick - Dizziness/vertigo",
      "26A04",     "Sick - Fever/chills",
      "26A05",     "Sick - General weakness",
      "26A06",     "Sick - Nausea",
      "26A07",     "Sick - New onset of immobillity",
      "26A08",     "Sick - Other paind",
      "26A09",     "Sick - Transportation only",
      "26A10",     "Sick - Unwell/ill",
      "26A11",     "Sick - Vomitting",
      "26B01",     "Sick - Unknown status",
      "26C01",     "Sick - Altered level of conciousness",
      "26C02",     "Sick - Abnormal breathing",
      "26C03",     "Sick - Sickle Cell Crisis/Thalassemia",
      "26D01",     "Sick - Not alert",
      "26O02",     "Sick - Boils",
      "26O03",     "Sick - Bumps (non-traumatic)",
      "26O04",     "Sick - Can't sleep",
      "26O05",     "Sick - Can't urinate (w/o abdominal pain)",
      "26O06",     "Sick - Catheter (in/out w/o hemorrhage)",
      "26O07",     "Sick - Constipation",
      "26O08",     "Sick - Cramps/spasm/joint pain",
      "26O09",     "Sick - Cut-off ring request",
      "26O10",     "Sick - Deafness",
      "26O11",     "Sick - Defecatino/diarrhea",
      "26O12",     "Sick - Earache",
      "26O13",     "Sick - Enema",
      "26O14",     "Sick - Gout",
      "26O15",     "Sick - Hemorrhoids/piles",
      "26O16",     "Sick - Hepatitis",
      "26O17",     "Sick - Hiccups",
      "26O18",     "Sick - Itching",
      "26O19",     "Sick - Nervous",
      "26O20",     "Sick - Object stuck (nose, ear vagina,rectum,penis)",
      "26O21",     "Sick - Object swallowed",
      "26O22",     "Sick - Painful Urination",
      "26O23",     "Sick - Penis problems /pain",
      "26O24",     "Sick - Rash/skip disorder",
      "26O25",     "Sick - Sexually transmitted disease (STD)",
      "26O26",     "Sick - Sore throat",
      "26O27",     "Sick - Toothache",
      "26O28",     "Sick - Wound infected",
      
      // 27. Stab/Gunshot/Penetrating Trauma 
      "27A01",     "Penetrating Trauma - Non-recent (≥6 hours) peripheral wounds",
      "27B01",     "Penetrating Trauma - Non-recent (≥6 hours) single central wound",
      "27B02",     "Penetrating Trauma - Known single peripheral wound",
      "27B03",     "Penetrating Trauma - Serious hemorrhage",
      "27B04",     "Penetrating Trauma - Unknown status",
      "27B05",     "Penetrating Trauma - Obvious death (explosive GSW to head)",
      "27D01",     "Penetrating Trauma - Unconscious or arrest",
      "27D02",     "Penetrating Trauma - Not alert",
      "27D03",     "Penetrating Trauma - Central wounds",
      "27D04",     "Penetrating Trauma - Multiple wounds",
      "27D05",     "Penetrating Trauma - Multiple victims",
      
      //28. Stroke (CVA) 
      "28A01",     "Stroke - Breathing normally <35",
      "28B01",     "Stroke - Unknown status",
      "28C01",     "Stroke - Not alert",
      "28C02",     "Stroke - Abnormal breathing",
      "28C03",     "Stroke - Speech or movement problems",
      "28C04",     "Stroke - Numbness, paralysis, or movement problems",
      "28C05",     "Stroke - Stroke history",
      "28C06",     "Stroke - Sudden onset of severe headache",
      "28C07",     "Stroke - Stroke history",
      "28C08",     "Stroke - Breathing normally ≥35",
      
      // 29. Traffic/Transportation Accidents 
      "29A01",     "MVA - 1st party caller with injury to not dangerous part of body",
      "29B01",     "MVA - Injuries",
      "29B02",     "MVA - Serious hemorrhage",
      "29B03",     "MVA - Other hazards",
      "29B04",     "MVA - Unknown status",
      "29D01",     "Major incident",
      "29D01a",    "Major incident: Aircraft",
      "29D01b",    "Major incident: Bus",
      "29D01c",    "Major incident: Subway/Metro",
      "29D01d",    "Major incident: Train",
      "29D01e",    "Major incident: Watercraft",
      "29D01f",    "Major incident: Multi-vehicle (>10) pile-up",
      "29D02",     "MVA - High mechanism",
      "29D02k",    "MVA - High mechanism: All-Terrain",
      "29D02l",    "MVA - High mechanism: Auto-Bicycle/Motorcycle",
      "29D02m",    "MVA - High mechanism: Auto-Pedestrian",
      "29D02n",    "MVA - High mechanism: Ejection",
      "29D02o",    "MVA - High mechanism: Personal Watercrafat",
      "29D02p",    "MVA - High mechanism: Rollovers",
      "29D02q",    "MVA - High mechanism: Vehicle of bridge/height",
      "29D02r",    "MVA - High mechanism: Possible death at scene",
      "29D02s",    "MVA - High mechanism: Sinking vehicle",
      "29D03",     "MVA - Hazmat",
      "29D04",     "MVA - Pinned (trapped) victim",
      "29D05",     "MVA - Not alert",
      
      // 30. Traumatic Injuries (Specific) 
      "30A01",     "Trauma - Not dangerous body area",
      "30A02",     "Trauma - Non-recent injuries (≥6 hours)",
      "30B01",     "Trauma - Possibly dangerous body area",
      "30B02",     "Trauma - Serious hemorrhage",
      "30D01",     "Trauma - Unconsciouis or arrest",
      "30D02",     "Trauma - Not alert",
      "30D03",     "Trauma - Chest or neck injury (w/ difficult breating)",
      
      // 31. Unconscious/Fainting (Near) 
      "31A01",     "Fainting episode(s) and alert >35 (w/o cardiac history)",
      "31A02",     "Fainting episode(s) and alert <35 (with cardiac history)",
      "31A03",     "Fainting episode(s) and alert <35 (w/o cardiac history)",
      "31C01",     "Unconscious - Alert with abnormal breathing",
      "31C02",     "Fainting episodes(s) and alert > 35 (w/cardiac history)",
      "31C03",     "Females 12-50 with abdominal pains",
      "31D01",     "Unconscious - Agonal/Ineffective breathing",
      "31D02",     "Unconscious - Effective breathing",
      "31D03",     "Unconscious - Not alert",
      "31D04",     "Unconscious - Changing color",
      "31E01",     "Unconscious - Ineffective breathing",
      
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
      "33D01",     "Transfer - Suspected cardiac or respiratory arrest",
      "33D02",     "Transfer - Just resuscitated and/or defibrillated (external)",
      
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
	