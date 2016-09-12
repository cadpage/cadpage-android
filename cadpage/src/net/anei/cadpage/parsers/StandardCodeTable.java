package net.anei.cadpage.parsers;

import java.util.Properties;

/**
 * Code table containing the predefined standard MPDS medical and fire codes
 * 
 * The information used to build this table is copyrighted by
 * Priority Dispatch Corporation
 * http://www.prioritydispatch.net/
 * 
 * 
 */
public class StandardCodeTable extends CodeTable {
  
  public StandardCodeTable(String ... table) {
    super(
        
        // 1. Abdominal Pain/Problems
        "01",       "Abdominal pain - Prealert",
        "01D01",    "Abdominal Pain - Not alert",
        "01D02",    "Abdominal Pain - Ashen or gray >= 50",
        "01C01",    "Abdominal Pain - Suspected aortic aneurysm",
        "01C02",    "Abdominal Pain - Diagnosd aortic aneurysm",
        "01C03",    "Abdominal Pain - Fainting or near fainting >= 50",
        "01C04",    "Abdominal Pain - Females with fainting or near faingtin 12-50",
        "01C05",    "Abdominal Pain - Males with pain above navel > 35",
        "01C06",    "Abdominal Pain - Females with pain above navel > 45",
        "01A01",    "Abdominal Pain",
        "01A02",    "Abdominal Pain - Testicle or groin pain (male)",
        
        /// 2. Allergies(Reactions)/Envenomations (Stings/Bites) 
        "02",       "Alergic reaction - Prealert",
        "02E01",    "Allergic reaction - Ineffective breathing",
        "02D01",    "Allergic reaction - Not alert",
        "02D02",    "Allergic reaction - Difficulty speaking between breaths",
        "02D03",    "Swarming attack (bee, wasp, hornet)",
        "02D04",    "Snakebite",
        "02C01",    "Allergic reaction - Difficulty breathing or swallowing",
        "02C02",    "Allergic reaction - History of severe alergic reaction",
        "02B01",    "Allergic reaction - Unknown status",
        "02A01",    "Allergic reaction - No difficulty breathing/swallowing",
        "02A02",    "Spider bite",
        
        // 3. Animal Bites/Attacks 
        "03",       "Animal bite - Prealert",
        "03D01",    "Animal bite - Arrest",
        "03D02",    "Animal bite - Unconscious",
        "03D03",    "Animal bite - Not alert",
        "03D04",    "Animal bite - Chest or neck injury (with difficulty breathing)",
        "03D05",    "Animal bite - Dangerous body area",
        "03D06",    "Animal bite - Large animal",
        "03D07",    "Animal bite - Exotic animal",
        "03D08",    "Animal bite - Mauling or multiple animals",
        "03B01",    "Animal bite - Possibly dangerous body area",
        "03B02",    "Animal bite - Serous hemorrhage",
        "03B03",    "Animal bite - Unknown status",
        "03A01",    "Animal bite - Not dangerous body area",
        "03A02",    "Animal bite - Non-recent injuries (≥6 hours)",
        "03A03",    "Animal bite - Superficial injuries",

        //4. Assault/Sexual Assault 
        "04",       "Assault - Prealert",
        "04D01",    "Assault - Arrest",
        "04D02",    "Assault - Unconscious",
        "04D03",    "Assault - Not alert",
        "04D04",    "Assault - Chest or neck injury (with difficulty breathing)",
        "04D05",    "Assault - Multiple victims",
        "04B01",    "Assault - Possibly dangerous body area",
        "04B02",    "Assault - Serious hemorrhage",
        "04B03",    "Assault - Unknown status",
        "04A01",    "Assault - Not dangerous body area with deformity",
        "04A02",    "Assault - Not dangerous body area",
        "04A03",    "Assault - Non-recent injuries (≥6 hours)",
        
        // 5. Back Pain (Non-Traumatic or Non-Recent Trauma) 
        "05",       "Back pain - Prealert",
        "05D01",    "Back Pain - Not alert",
        "05D02",    "Back Pain - Ashen or gray color reported >= 50",
        "05C01",    "Back Pain - Suspected aortic aneuryism >= 50",
        "05C02",    "Back Pain - Diagnosed aortic aneuysm",
        "05C03",    "Back Pain - Fainting or near fainting >= 50",
        "05A01",    "Back Pain - Non-traumatic",
        "05A02",    "Non-recent traumatic back pain (≥6 hours)",
        
        // 6. Breathing Problems 
        "06",       "Breathing Problems - Prealert",
        "06E01",    "Breathing Problems - Ineffective breathing",
        "06D01",    "Breathing Problems - Not alert",
        "06D02",    "Breathing Problems - Difficulty speaking between breaths",
        "06D03",    "Breathing Problems - Changing color",
        "06D04",    "Breathing Problems - Clammy or cold sweats",
        "06D05",    "Breathing Problems - Tracheostomy (obvious distress)",
        "06C01",    "Breathing Problems - Abnormal breathing",
        "06C02",    "Breathing Problems - Tracheostomy (no obvious distress)",
        
        // 7. Burns (Scalds)/Explosions 
        "07",       "Burns - Prealert",
        "07E01",    "Burns - Person on fire",
        "07D01",    "Burns - Multiple victims",
        "07D02",    "Burns - Arrest",
        "07D03",    "Burns - Unconscioius",
        "07D04",    "Burns - Not alert",
        "07D05",    "Burns - Difficulty speaking between breaths",
        "07C01",    "Building fire with persons reported inside",
        "07C02",    "Burns - Difficulty breathing",
        "07C03",    "Burns - ≥ 18% body area",
        "07C04",    "Burns - Significant facial burns",
        "07B01",    "Burns - Blast Injuries (w/o priority symptons)",
        "07B02",    "Burns - Unknown status",
        "07A01",    "Burns - <18% body area",
        "07A02",    "Burns - Fire alarm (unknown situation)",
        "07A03",    "Burns - Minor burns",
        "07A04",    "Burns - Sunburn",
        "07A05",    "Burns - Non-recent (>= 6 hours)",
        
        //8. Carbon Monoxide/Inhalation/Hazmat 
        "08",       "Carbon Monoxide - Prealert",
        "08D01",    "Carbon Monoxide - Unconscious",
        "08D02",    "Carbon Monoxide - Arrest",
        "08D03",    "Carbon Monoxide - Not alert",
        "08D04",    "Carbon Monoxide - Difficulty speaking between breaths",
        "08D05",    "Carbon Monoxide - Multiple victims",
        "08D06",    "Carbon Monoxide - Unknown status",
        "08C01",    "Carbon Monoxide - Alert with difficulty breathing",
        "08B01",    "Carbon Monoxide - Alert without difficulty breathing",
        "08O01",    "CO detector alarm (without priority symptoms)",
        "08O02",    "CO detector alarm (no scene contact)",
        
        /// 9. Cardiac or Respiratory Arrest/Death 
        "09",       "Cardiac or Respiratory Arrest - Prealert",
        "09E01",    "Suspected workable arrest – Not breathing at all",
        "09E02",    "Suspected workable arrest – Uncertain Breathing",
        "09E03",    "Suspected workable arrest – Hanging",
        "09E04",    "Suspected workable arrest – Strangulation",
        "09E05",    "Suspected workable arrest – Suffocation",
        "09E06",    "Suspected workable arrest – Underwater",
        "09E07",    "Expected death",
        "09D01",    "Ineffective breathing",
        "09D02",    "Obvious death or expected death questionable",
        "09B01",    "Obvious death (unquestionable)",
        "09B01A",   "Obvious death: Cold and stiff in a warm environment",
        "09B01B",   "Obvious death: Decapitation",
        "09B01C",   "Obvious death: Decomposition",
        "09B01D",   "Obvious death: Incineration",
        "09B01E",   "Obvious death: Non-recent death",
        "09B01F",   "Obvious death: Severe injuries incompatible w/ life",
        "09B01G",   "Obvious death: User defined",
        "09B01H",   "Obvious death: User defined",
        "09B01I",   "Obvious death: User defined",
        "09O01",    "Expected death (unquestionable)",
        "09O01X",   "Expected death: Terminal illness",
        "09O01Y",   "Expected death: DNR",
        
        // 10. Chest pain 
        "10",        "Chest Pain - Prealert",
        "10D01",     "Chest Pain - Not alert",
        "10D02",     "Chest Pain - Difficulty speaking between breaths",
        "10D03",     "Chest Pain - Changing color",
        "10D04",     "Chest Pain - Clammy or cold sweats",
        "10D05",     "Chest Pain - Heart attack or angina history",
        "10C01",     "Chest Pain - Abnormal breathing",
        "10C02",     "Chest Pain - Cocaine",
        "10C03",     "Chest Pain - Breathing normally ≥35",
        "10A01",     "Chest Pain - Breathing normally <35",

        ///11. Choking 
        "11",        "Choking - Prealert",
        "11E01",     "Choking - Complete obstruction/inefective breathing",
        "11D01",     "Choking - Abnormal breathing (partial obstruction)",
        "11D02",     "Choking - Not alert",
        "11A01",     "Choking - Not choking now",

        // 12. Convulsions/Seizures 
        "12",        "Convulsions/Seizure - Prealert",
        "12D01",     "Convulsions/Seizure - Not breathing",
        "12D02",     "Convulsions/Seizure - Continuous or multiple seizures",
        "12D03",     "Convulsions/Seizure - Agonal/ineffective breathing",
        "12D04",     "Convulsions/Seizure - Effective breathing not verified ≥35",
        "12C01",     "Convulsions/Seizure - Focal/absence seizure (not alert)",
        "12C02",     "Convulsions/Seizure - Pregnancy",
        "12C03",     "Convulsions/Seizure - Diabetic",
        "12C04",     "Convulsions/Seizure - Not seizing new and effective breathing verified",
        "12C05",     "Convulsions/Seizure - History of stroke or brain tumor",
        "12C06",     "Convulsions/Seizure - Overdose/poisoning (ingestion)",
        "12C07",     "Convulsions/Seizure - Atypical seizure",
        "12B01",     "Convulsions/Seizure - Effective breathing not verified <35",
        "12A01",     "Convulsions/Seizure - Not seizing now (known seizure disorder)",
        "12A02",     "Convulsions/Seizure - Not seizing now (unknown seizure disorder)",
        "12A03",     "Convulsions/Seizure - Not seizing now (confirmed no seizure disorder)",
        "12A04",     "Convulsions/Seizure - Focal/absence seizure (alert)",
        "12A05",     "Convulsions/Seizure - Impending seizure (aura)",

        // 13. Diabetic Problems 
        "13",        "Diabetic Problem - Prealert",
        "13D01",     "Diabetic Problem - Unconscious",
        "13C01",     "Diabetic Problem - Not alert",
        "13C02",     "Diabetic Problem - Abnormal behavior",
        "13C03",     "Diabetic Problem - Abnormal breathing",
        "13A01",     "Diabetic Problem - Alert and behaving normally",

        // 14. Drowning (Near)/Diving/Scuba Accident 
        "14",        "Drowning - Prealert",
        "14E01",     "Drowning - Arrest (out of water)",
        "14E02",     "Drowning - Underwater (domestic rescue)",
        "14D01",     "Drowning - Unconscious",
        "14D02",     "Drowning - Underwater (specialized rescue)",
        "14D03",     "Drowning - Stranded (specialized rescue)",
        "14D04",     "Drowning - Just resuscitated and/or defibrillated",
        "14D05",     "Drowning - Not alert",
        "14D06",     "Diving or suspected neck injury",
        "14C01",     "Drowning - Alert with abnormal breathing",
        "14B01",     "Drowning - Alert and breathing normally (injuries or in water)",
        "14B02",     "Drowning - Obvious death (submersion >= 6 hours)",
        "14B03",     "Drowning - Unknown status",
        "14A01",     "Drowning - Alert and breathing normally (no injuries and out of water)",

        // 15. Electrocution/Lightning 
        "15",        "Electrocution - Prealert",
        "15E01",     "Electrocution - Not breathing/ineffective breathing",
        "15D01",     "Electrocution - Multiple victims",
        "15D02",     "Electrocution - Unconscious",
        "15D03",     "Electrocution - Not disconnected from power",
        "15D04",     "Electrocution - Power not off or hazard present",
        "15D05",     "Electrocution - Extreme fall (≥30 feet)",
        "15D06",     "Electrocution - Long fall",
        "15D07",     "Electrocution - Not alert",
        "15D08",     "Electrocution - Abnormal breathing",
        "15D09",     "Electrocution - Unknown status",
        "15C01",     "Electrocution - Alert and breathing normally",

        // 16. Eye Problems/Injuries 
        "16",        "Eye Injury - Prealert",
        "16D01",     "Eye Injuries - Not alert",
        "16B01",     "Eye Injuries - Severe",
        "16A01",     "Eye Injuries - Moderate",
        "16A02",     "Eye Injuries - Minor",
        "16A03",     "Eye Injuries - Medical problem",
        
        // 17. Falls 
        "17",        "Fall - Prealert",
        "17D01",     "Fall - Extreme fall (>30ft)",
        "17D02",     "Fall - Arrest",
        "17D03",     "Fall - Unconscious",
        "17D04",     "Fall - Not alert",
        "17D05",     "Fall - Chest or neck injury (with difficulty breathing)",
        "17D06",     "Fall - Long fall",
        "17B01",     "Fall - Possibly dangerous body area",
        "17B02",     "Fall - Serious hemorrhage",
        "17B03",     "Fall - Unknown status",
        "17A01",     "Fall - Not dangerous body area with deformity",
        "17A02",     "Fall - Not dangerous body area",
        "17A03",     "Fall - Not recent (>= 6 hours)",
        "17A04",     "Fall - Public assist (no injuries and no priority symptoms)",
        
        // 18. Headache 
        "18",        "Headache - Prealert",
        "18C01",     "Headache - Not alert",
        "18C02",     "Headache - Abnormal breathing",
        "18C03",     "Headache - Speech problems",
        "18C04",     "Headache - Sudden onset of severe pain",
        "18C05",     "Headache - Numbness",
        "18C06",     "Headache - Paralysis",
        "18C07",     "Headache - Change in behavior (≤3 hours)",
        "18B01",     "Headache - Unknown status",
        "18A01",     "Headache - Breathing normally",

        // 19. Heart Problems/AICD (Automatic Implanted Cardiac Defibrillator) 
        "19",        "Heart Problem - Prealert",
        "19D01",     "Heart Problem - Not alert",
        "19D02",     "Heart Problem - Difficulty speaking between breaths",
        "19D03",     "Heart Problem - Changing Color",
        "19D04",     "Heart Problem - Clammy or cold sweats",
        "19D05",     "Heart Problem - Just resuscitated and/or defibrillated",
        "19C01",     "Heart Problem - Firing of AICD",
        "19C02",     "Heart Problem - Abnormal breathing",
        "19C03",     "Heart Problem - Chest pain/discomfort ≥35",
        "19C04",     "Heart Problem - Cardiac history",
        "19C05",     "Heart Problem - Cocaine",
        "19C06",     "Heart Problem - Heart rate <50 or ≥130",
        "19C07",     "Heart Problem - Unknown status",
        "19A01",     "Heart Problem - Heart rate >= 50 and < 130",
        "19A02",     "Heart Problem - Chest pain/discomfort < 35",

        // 20. Heat/Cold Exposure 
        "20",        "Exposure - Prealert",
        "20D01",     "Exposure - Not alert",
        "20D02",     "Exposure - Multiple victims (w/ priority symptoms)",
        "20C01",     "Exposure - Heart attack or angina history",
        "20B01",     "Exposure - Change in skin color",
        "20B02",     "Exposure - Unknown status",
        "20A01",     "Exposure - Alert",

        // 21. Hemorrhage/Lacerations 
        "21",        "Hemorrhage/Laceration - Prealert",
        "21D01",     "Hemorrhage/Laceration - Arrest",
        "21D02",     "Hemorrhage/Laceration - Unconscioius",
        "21D03",     "Hemorrhage/Laceration - Not alert",
        "21D04",     "Hemorrhage/Laceration - Dangerous Hemorrhage",
        "21D05",     "Hemorrhage/Laceration - Abnormal breathing",
        "21C01",     "Hemorrhage through tubes",
        "21C02",     "Hemorrhage through dialysis fistula",
        "21C02",     "Hemorrhage through varicose veins",
        "21B01",     "Possibly dangerous hemorrhage",
        "21B02",     "Serious hemorrhage",
        "21B03",     "Bleeding disorder",
        "21B04",     "Hemorrhage -  blood thinners",
        "21A01",     "Not dangerous hemorrhage",
        "21A02",     "Minor hemorrhage",

        // 22. Industrial/Machinery Accidents 
        "22",        "Industrial/Machinery Accident - Prealert",
        "22D01",     "Industrial/Machinery Accident - Entrapment",
        "22D02",     "Industrial/Machinery Accident - Trench collapse",
        "22D03",     "Industrial/Machinery Accident - Structure collapse",
        "22D04",     "Industrial/Machinery Accident - Confined space entrapment",
        "22D05",     "Industrial/Machinery Accident - Inaccessibel terrain situation",
        "22D06",     "Industrial/Machinery Accident - Mudslide/Avalanche",
        "22B01",     "Industrial/Machinery Accident - No longer trapped (unk inj)",
        "22B02",     "Industrial/Machinery Accident - Peripheral entrapment only",
        "22B03",     "Industrial/Machinery Accident - Unknown status",
        "22A01",     "Industrial/Machinery Accident - No longer trapped (no inj)",

        // 23. Overdose/Poisoning (Ingestion) 
        "23",        "Poisoning - Prealert",
        "23D01",     "Overdose/Poisoning - Unconscious",
        "23D02",     "Overdose/Poisoning - Changing color",
        "23C01",     "Overdose/Poisoning - Not alert",
        "23C02",     "Overdose/Poisoning - Abnormal breathing",
        "23C03",     "Overdose/Poisoning - Antidepressants (tricyclic)",
        "23C04",     "Overdose/Poisoning - Cocaine, methamphetamine (or derivatives)",
        "23C05",     "Overdose/Poisoning - Narcotics (heroin, morphine, methadone, OxyContin, etc)",
        "23C06",     "Poisoning - Acid or alkali (lye)",
        "23C07",     "Overdose/Poisoning - Unknown status",
        "23C08",     "Overdose/Poisoning - Poison Control request for response",
        "23B01",     "Overdose (without priority symptoms)",
        "23O01",     "Poisoning (without priority symptoms)",

        // 24. Pregnancy/Childbirth/Miscarriage 
        "24",        "Pregnancy/Childbirth - Prealert",
        "24D01",     "Childbirth - Breech or cord",
        "24D02",     "Childbirth - Head visible or out",
        "24D03",     "Childbirth - Imminent birth (≥6 months/24 weeks)",
        "24D04",     "Pregnancy - 3rd trimester hemorrhage",
        "24D05",     "Pregnancy - High-risk complications",
        "24D06",     "Childbirth - Baby born (complications with baby)",
        "24D07",     "Childbirth - Baby born (complications with mother)",
        "24C01",     "Pregnancy - 2nd trimester hemorrhage or miscarriage",
        "24C02",     "Pregnancy - 1st trimester serious hemorrhage",
        "24C03",     "Pregnancy - Abdominal paid/cramping (< 6 months/24 weeks)",
        "24C04",     "Childbirth - Baby born - No complications",
        "24B01",     "Pregnancy - Labor (delivery not imminent, ≥5 months/20 weeks)",
        "24B02",     "Pregnancy - Unknown status",
        "24A01",     "Pregnancy - 1 st trimester hemorrhage or miscarriage",
        "24O01",     "Pregnancy - Waters broken",

        // 25. Psychiatric/Abnormal Behavior/Suicide Attempt 
        "25",        "Psychiatric/Suicide - Prealert",
        "25D01",     "Psychiatric/Suicide - Not alert",
        "25D02",     "Psychiatric/Suicide - Dangerous hemorrhage",
        "25D03",     "Psychiatric/Suicide - Near hanging, strangulation, or suffocation (alert w/ diff breathing)",
        "25B01",     "Psychiatric/Suicide - Serious hemorrhage",
        "25B02",     "Psychiatric/Suicide - Non-serioius or minor hemorrhage",
        "25B03",     "Psychiatric/Suicide - Threatening suicide",
        "25B04",     "Psychiatric/Suicide - Jumper (threatening)",
        "25B05",     "Psychiatric/Suicide - Near hanging, strangulation or suffocation (alert)",
        "25B06",     "Psychiatric/Suicide - Unknown status",
        "25A01",     "Psychiatric/Suicide - Non-suicidal and alert",
        "25A02",     "Psychiatric/Suicide - Suicidal (non threatening) and alert",
        
        // 26. Sick Person (Specific Diagnosis) 
        "26",        "Sick - Prealert",
        "26D01",     "Sick - Not alert",
        "26C01",     "Sick - Altered level of conciousness",
        "26C02",     "Sick - Abnormal breathing",
        "26C03",     "Sick - Sickle Cell Crisis/Thalassemia",
        "26B01",     "Sick - Unknown status",
        "26A01",     "Sick - No priority symptoms",
        "26A02",     "Sick - Blood pressure abnormallity",
        "26A03",     "Sick - Dizziness/vertigo",
        "26A04",     "Sick - Fever/chills",
        "26A05",     "Sick - General weakness",
        "26A06",     "Sick - Nausea",
        "26A07",     "Sick - New onset of immobillity",
        "26A08",     "Sick - Other pain",
        "26A09",     "Sick - Transportation only",
        "26A10",     "Sick - Unwell/ill",
        "26A11",     "Sick - Vomitting",
        "26A11",     "Sick - Possible meningitis",
        "26O02",     "Sick - Boils",
        "26O03",     "Sick - Bumps (non-traumatic)",
        "26O04",     "Sick - Can't sleep",
        "26O05",     "Sick - Can't urinate (w/o abdominal pain)",
        "26O06",     "Sick - Catheter (in/out w/o hemorrhage)",
        "26O07",     "Sick - Constipation",
        "26O08",     "Sick - Cramps/spasm/joint pain",
        "26O09",     "Sick - Cut-off ring request",
        "26O10",     "Sick - Deafness",
        "26O11",     "Sick - Defecation/diarrhea",
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
        "27",        "Penetrating Trauma - Prealert",
        "27D01",     "Penetrating Trauma - Arrest",
        "27D02",     "Penetrating Trauma - Unconscious",
        "27D03",     "Penetrating Trauma - Not alert",
        "27D04",     "Penetrating Trauma - Central wounds",
        "27D05",     "Penetrating Trauma - Multiple wounds",
        "27D06",     "Penetrating Trauma - Multiple victims",
        "27B01",     "Penetrating Trauma - Non-recent (≥6 hours) single central wound",
        "27B02",     "Penetrating Trauma - Known single peripheral wound",
        "27B03",     "Penetrating Trauma - Serious hemorrhage",
        "27B04",     "Penetrating Trauma - Unknown status",
        "27B05",     "Penetrating Trauma - Obvious death",
        "27A01",     "Penetrating Trauma - Non-recent (≥6 hours) peripheral wounds",

        //28. Stroke (CVA) 
        "28",        "Stroke - Prealert",
        "28C01",     "Stroke - Not alert",
        "28C02",     "Stroke - Abnormal breathing",
        "28C03",     "Stroke - Sudden speech problems",
        "28C04",     "Stroke - Sudden sweakness or numbness (one side)",
        "28C05",     "Stroke - Sudden paralysis or facial droop (one side)",
        "28C06",     "Stroke - Sudden loss of balance or coordination",
        "28C07",     "Stroke - Sudden vision problems",
        "28C08",     "Stroke - Sudden onset of severe headache",
        "28C09",     "Stroke - Stroke history",
        "28C10",     "Stroke - TIA (mini stroke) history",
        "28C11",     "Stroke - Breathing normally >=35",
        "28C12",     "Stroke - Unknown status",
        "28A01",     "Stroke - Breathing normally <35",

        // 29. Traffic/Transportation Accidents 
        "29",        "MVA - Prealert",
        "29D01",     "Major incident",
        "29D01A",    "Major incident: Aircraft",
        "29D01B",    "Major incident: Bus",
        "29D01C",    "Major incident: Subway/Metro",
        "29D01D",    "Major incident: Train",
        "29D01E",    "Major incident: Watercraft",
        "29D01F",    "Major incident: Multi-vehicle (>10) pile-up",
        "29D01G",    "Major incident: Street car/Tram/Light rail",
        "29D01H",    "Major incident: Vehicle vs. building",
        "29D02",     "MVA - High mechanism",
        "29D02K",    "MVA - High mechanism: All-Terrain/Snowmobile",
        "29D02L",    "MVA - High mechanism: Auto vs Bicycle/Motorcycle",
        "29D02M",    "MVA - High mechanism: Auto vs Pedestrian",
        "29D02N",    "MVA - High mechanism: Ejection",
        "29D02O",    "MVA - High mechanism: Personal Watercrafat",
        "29D02P",    "MVA - High mechanism: Rollovers",
        "29D02Q",    "MVA - High mechanism: Vehicle of bridge/height",
        "29D02R",    "MVA - High mechanism: Possible death at scene",
        "29D02S",    "MVA - High mechanism: Sinking vehicle",
        "29D02T",    "MVA - Train/Light rail vs. pedestrian",
        "29D03",     "MVA - High velocity impact",
        "29D04",     "MVA - Hazmat",
        "29D05",     "MVA - Pinned (trapped) victim",
        "29D06",     "MVA - Arrest",
        "29D07",     "MVA - Unconscioius",
        "29D08",     "MVA - Not alert with noisy breathing",
        "29D09",     "MVA - Not alert with normal breathing",
        "29B01",     "MVA - Injuries",
        "29B02",     "MVA - Serious hemorrhage",
        "29B03",     "MVA - Other hazards",
        "29B04",     "MVA - Low mechanism",
        "29B05",     "MVA - Unknown status",
        "29A01",     "MVA - 1st party caller with injury to not dangerous part of body",
        "29A02",     "MVA - No injuries reported (unconfirmed or >= 5 persons involved",
        "29O01",     "MVA - No injuries (confirmed for up to 4 persons)",

        // 30. Traumatic Injuries (Specific) 
        "30",        "Trauma - Prealert",
        "30D01",     "Trauma - Arrest",
        "30D02",     "Trauma - Unconscious",
        "30D03",     "Trauma - Not alert",
        "30D04",     "Trauma - Chest or neck injury (w/ difficult breating)",
        "30D05",     "Trauma - High velocity impact/mass injury",
        "30B01",     "Trauma - Possibly dangerous body area",
        "30B02",     "Trauma - Serious hemorrhage",
        "30B03",     "Trauma - Unknown body area (remote patient location)",
        "30A01",     "Trauma - Not dangerous body area with deformity",
        "30A02",     "Trauma - Not dangerous body area",
        "30A03",     "Trauma - Non-recent injuries (≥6 hours)",
        
        // 31. Unconscious/Fainting (Near) 
        "31",        "Unconscious/Fainting - Prealert",
        "31E01",     "Unconscious - Ineffective breathing",
        "31D01",     "Unconscious - Agonal/Ineffective breathing",
        "31D02",     "Unconscious - Effective breathing",
        "31D03",     "Unconscious - Not alert",
        "31D04",     "Unconscious - Changing color",
        "31C01",     "Unconscious - Alert with abnormal breathing",
        "31C02",     "Unconscious - Fainting episodes(s) and alert > 35 (w/cardiac history)",
        "31C03",     "Unconscious - Females 12-50 with abdominal pains",
        "31A01",     "Unconscious - Fainting episode(s) and alert >35 (w/o cardiac history)",
        "31A02",     "Unconscious - Fainting episode(s) and alert <35 (with cardiac history)",
        "31A03",     "Unconscious - Fainting episode(s) and alert <35 (w/o cardiac history)",

        // 32. Medical Nature Unknown
        "32",        "Medical Nature Unknown - Prealert",
        "32D01",     "Medical Nature Unknown - Life status questionable",
        "32B01",     "Medical Nature Unknown - Standing, moving, sitting, or talking",
        "32B02",     "Medical Nature Unknown - Medical alert notification",
        "32B03",     "Medical Nature Unknown",
        "32B04",     "Medical Nature Unknown - Callers language not understood",
        
        //33. Transfer/Interfacility/Palliative Care 
        "33",        "Transfer - Prealert",
        "33D01",     "Transfer - Suspected cardiac or respiratory arrest",
        "33D02",     "Transfer - Just resuscitated and/or defibrillated (external)",
        "33C01",     "Transfer - Not alert (acute change)",
        "33C02",     "Transfer - Abnormal breathing (acute onset)",
        "33C03",     "Transfer - Significant hemorrhage ",
        "33C04",     "Transfer - Shock",
        "33C05",     "Transfer - Possible acute heart problems or MI (heart attack)",
        "33C06",     "Transfer - Acute severe pain",
        "33C07",     "Transfer - Emergency response requested",
        "33A01",     "Transfer - Acuity I (no priority symptoms)",
        "33A02",     "Transfer - Acuity II (no priority symptoms)",
        "33A03",     "Transfer - Acuity III (no priority symptoms)",
        
        //34. ACN (Automatic crash notification)
        "34",        "ACN - Prealert",
        "34D01",     "ACN - High mechanism",
        "34D01H",    "ACN - High mechanism - Auto vs bicycle",
        "34D01I",    "ACN - High mechanism - Auto vs motorcycle",
        "34D01J",    "ACN - High mechanism - Auto vs pedestrian",
        "34D01K",    "ACN - High mechanism - Ejection",
        "34D01L",    "ACN - High mechanism - Pinned",
        "34D01M",    "ACN - High mechanism - Rollovers",
        "34D01N",    "ACN - High mechanism - Vehicle off bridge/height",
        "34D02",     "ACN - Unconscious or not alert",
        "34D03",     "ACN - Not breathing/ineffective breathing",
        "34D04",     "ACN - Life status questionable",
        "34B01",     "ACN - Injuries involved",
        "34B02",     "ACN - Multiple victims (one unit)",
        "34B03",     "ACN - Multiple victims (additional units)",
        "34B04",     "ACN - Airbag/Other automatic sensor (no voice)",
        "34B05",     "ACN - Unknown situation",
        "34A01",     "ACN - Not dangerous injuries",
        "34O01",     "ACN - No injuries",
        
        //36. Pandemic/Epidemic/Outbreak
        "36D01",     "Epidemic - Ineffective breathing with flu symptoms",
        "36D02",     "Epidemic - Difficulty speaking between breaths with flu symptoms",
        "36D03",     "Epidemic - Not alert with flu symptoms",
        "36D04",     "Epidemic - Changing color with flu symptoms",
        "36C01",     "Epidemic - Abnormal breathing with single flu symptom",
        "36C02",     "Epidemic - Abnormal breathing with multiple flu symptom",
        "36C03",     "Epidemic - Chest pain/discomfort >=35 with single flu smymptom",
        "36C04",     "Epidemic - Chest pain/discomfort >=35 with multiple flu smymptoms",
        "36C05",     "Epidemic - High risk conditions",
        "36A01",     "Epidemic - Chest pain/discomfort <35 with single flu smymptom",
        "36A02",     "Epidemic - Chest pain/discomfort <35 with multiple flu smymptoms",
        "36A03",     "Epidemic - Flue symptoms only",
        
        //37. Interfacility Evaluation/Transfer 
        "37",        "Evaluation - Prealert",
        "37D01",     "Evaluation - Not breathing/ineffective breathing",
        "37D02",     "Evaluation - Evaluation",
        "37D03",     "Evaluation - Transfer",
        "37C01",     "Evaluation - Acute onset of priority symptoms",
        "37C02",     "Evaluation - Suspected acute heart problems or MI (heart attack)",
        "37C03",     "Evaluation - Suspected Stroke (<= T hours)",
        "37C04",     "Evaluation - Medication management required",
        "37C05",     "Evaluation - Emergency response requested",
        "37C06",     "Evaluation - Evaluation",
        "37C07",     "Evaluation - Transfer level I",
        "37C08",     "Evaluation - Transfer level II",
        "37C09",     "Evaluation - Transfer level III",
        "37B01",     "Evaluation - Evaluation",
        "37B02",     "Evaluation - Transfer",
        "37A01",     "Evaluation - Evaluation",
        "37A02",     "Evaluation - Transfer level I",
        "37A03",     "Evaluation - Transfer level II",
        "37A04",     "Evaluation - Transfer level III",
        
        // 51. Aircraft Emergency
        "51",     "Aircraft Emergency - Prealert",
        "51O01",  "Aircraft Emergency - Airborne Aircraft",
        "51A00",  "Aircraft Emergency",
        "51A01",  "Aircraft Emergency - Standby",
        "51B00",  "Aircraft Emergency",
        "51B01",  "Aircraft Emergency - Unknown situation",
        "51C00",  "Aircraft Emergency",
        "51C01",  "Aircraft Emergency - Aircraft incoming - full emergency",
        "51C02",  "Aircraft Emergency - Aircraft incoming - minor emergency",
        "51D00",  "Aircraft Emergency",
        "51D01",  "Aircraft Emergency - Aircraft Crash on Land",
        "51D02",  "Aircraft Emergency - Aircraft Crash involving building",
        "51D03",  "Aircraft Emergency - Aircraft fire/recovery on ground",
        "51D04",  "Aircraft Emergency - Coastal water aircraft emergency",
        "51D05",  "Aircraft Emergency - Inland water aircraft emergency",
        "51D06",  "Aircraft Emergency - Oceanic water aircraft emergency",
        
        // 52. Alarms
        "52",     "Alarms - Prealert",
        "52O01",  "Alarms - Burglary/intrusion, etc",
        "52O02",  "Alarms - Medical alarm",
        "52B00",  "Alarms",
        "52B01",  "Alarms - Residential (single)",
        "52B02",  "Alarms - Non-dwelling building/structure",
        "52B03",  "Alarms - Mobile home, house trailer, portable office",
        "52B04",  "Alarms - Unknown situation",
        "52C00",  "Alarms",
        "52C00C", "Alarms - Carbon Monoxide",
        "52C00G", "Alarms - General/Fire",
        "52C00H", "Alarms - Heat Detector",
        "52C00I", "Alarms - Industrial Gas/Hazmat",
        "52C00K", "Alarms - Keypad (manual)",
        "52C00O", "Alarms - Other",
        "52C00P", "Alarms - Pull Station",
        "52C00S", "Alarms - Smoke Detector",
        "52C00T", "Alarms - Trouble/Tamper",
        "52C00U", "Alarms - Unknown",
        "52C00W", "Alarms - Waterflow/Sprinkler",
        "52C01",  "Alarms - High Life Hazard",
        "52C02",  "Alarms - High Rise",
        "52C03",  "Alarms - Commercial/industrial building",
        "52C04",  "Alarms - Residential (multiple)",
        
        // 53. Citizen assist/service call
        "53",     "Citizen assist/service call - Prealert",
        "53O01",  "Citizen assist/service call - Locked out of vehicle (unoccupied)",
        "53O02",  "Citizen assist/service call - Down trees and objects",
        "53O03",  "Citizen assist/service call - Hydrant problem",
        "53O04",  "Citizen assist/service call - Sewer problem",
        "53O05",  "Citizen assist/service call - Water main break;",
        "53O06",  "Citizen assist/service call - Outside resource complaints",
        "53A00",  "Citizen assist/service call",
        "53A01",  "Citizen assist/service call - Locked in/out of building (non-medical assistance)",
        "53A02",  "Citizen assist/service call - Citizen assist (non-medical assistance)",
        "53A03",  "Citizen assist/service call - Animal rescue",
        "53A04",  "Citizen assist/service call - Water problem",
        "53A05",  "Citizen assist/service call - Service call",
        "53A06",  "Citizen assist/service call - Unknow/other situation (investigation)",
        "53B00",  "Citizen assist/service call",
        "53B01",  "Citizen assist/service call - Locked in vehicle",
        "53B02",  "Citizen assist/service call - Locked in/out of building (medical assistance)",
        "53B03",  "Citizen assist/service call - Locked in/out of building (unknown medical assistance)",
        "53B04",  "Citizen assist/service call - Citizen assist (medical assisance)",
        "53B05",  "Citizen assist/service call - Service call (medical assistance)",
        "53B06",  "Citizen assist/service call - Unknown/other situation (medical assistance)",
        "53C00",  "Citizen assist/service call",
        "53C01",  "Citizen assist/service call - Water problem with electrical hazard",
        "53C02",  "Citizen assist/service call - Service call (multiple units)",
        
        // 54. Confined Space/structure collapse
        "54",     "Confined space/structure collapse - Prealert",
        "54B01",  "Confined space/structure collapse - Entrapment (unconfirmed)",
        "54B02",  "Confined space/structure collapse - No one trapped",
        "54C00",  "Confined Space/structure collapse",
        "54C01",  "Confined Space/structure collapse - Entrapment (unconfirmed) w/ hazardous materials",
        "54D00",  "Confined Space/structure collapse",
        "54D01",  "Confined Space/structure collapse - Entrapment (confirmed)",
        "54D02",  "Confined Space/structure collapse - Entrapment (confirmed) w/ hazardous materials",
        
        // 55. Electrical Hazard
        "55",     "Electrical Hazard - Prealert",
        "55A01",  "Electrical Hazard - Transformer Outside",
        "55A02",  "Electrical Hazard - Appliance with no odor present",
        "55B00",  "Electrical Hazard",
        "55B01",  "Electrical Hazard - Electrical Arcing",
        "55B02",  "Electrical Hazard - Wires down with no smoke or Arcing",
        "55B03",  "Electrical Hazard - Appliance with odor present",
        "55B04",  "Electrical Hazard - Electrical odor",
        "55B05",  "Electrical Hazard - Unknown situation",
        "55C00",  "Electrical Hazard",
        "55C01",  "Electrical Hazard - Electrical hazard with or near water",
        "55C02",  "Electrical Hazard - Wires down with smoke or arcing",
        
        // 56. Elevator/Escalator Rescue
        "56",     "Elevator/Escalator Rescue - Prealert",
        "56O01",  "Elevator/Escalator Rescue - Elevator malfunction - no occupants inside",
        "56O02",  "Elevator/Escalator Rescue - Escalator incident (not trapped) - with or without injuries",
        "56A00",  "Elevator/Escalator Rescue",
        "56A01",  "Elevator/Escalator Rescue - Elevator malfunction - occupants inside",
        "56B00",  "Elevator/Escalator Rescue",
        "56B01",  "Elevator/Escalator Rescue - Elevator malfunction - occupants inside (medical condition)",
        "56B02",  "Elevator/Escalator Rescue - Escalator entrapment without injuries",
        "56B03",  "Elevator/Escalator Rescue - Unknown situation",
        "56D00",  "Elevator/Escalator Rescue",
        "56D01",  "Elevator/Escalator Rescue - Escalator entrapment with injuries",
        "56D02",  "Elevator/Escalator Rescue - Elevator accident",
        
        // 57. Explosion
        "57",     "Explosion - Prealert",
        "57B01",  "Explosion - Vehicle explosion",
        "57B02",  "Explosion - Other Explosion",
        "57B03",  "Explosion - Unknown situation",
        "57D00",  "Explosion",
        "57D01",  "Explosion - High life hazard",
        "57D02",  "Explosion - High rise",
        "57D03",  "Explosion - Govenment building",
        "57D04",  "Explosion - Commercial/industrial building",
        "57D05",  "Explosion - Residential (multiple)",
        "57D06",  "Explosion - Residential (single)",
        "57D07",  "Explosion - Large non-dwelling building/structure",
        "57D08",  "Explosion - Small non-dwelling building/structure",
        "57D09",  "Explosion - Commercial vehicle",
        "57D10",  "Explosion - Large fuel/fire load vehicle",
        "57D11",  "Explosion - Mobile home, house trailer, portable office",
        
        // 58. Extrication/Entrapped
        "58",     "Extrication/Entrapped (Machinery, Veh) - Prealert",
        "58O01",  "Extrication/Entrapped (Machinery, Veh) - No longer trapped",
        "58A00",  "Extrication/Entrapped (Machinery, Veh)",
        "58A01",  "Extrication/Entrapped (Machinery, Veh) - Finger or toe",
        "58B00",  "Extrication/Entrapped (Machinery, Veh)",
        "58B01",  "Extrication/Entrapped (Machinery, Veh) - Entrapment (peripheral only)",
        "58B02",  "Extrication/Entrapped (Machinery, Veh) - Unknown situation",
        "58D00",  "Extrication/Entrapped (Machinery, Veh)",
        "58D01",  "Extrication/Entrapped (Machinery, Veh) - Entrapment (except peripheral)",
        
        // 59. Fuel Spill
        "59",     "Fuel Spill - Prealert",
        "59O01",  "Fuel Spill - Minor Spill",
        "59B00",  "Fuel Spill",
        "59B01",  "Fuel Spill - Uncontained small spill",
        "59B02",  "Fuel Spill - Contained small spill",
        "59B03",  "Fuel Spill - Fuel odor",
        "59C00",  "Fuel Spill",
        "59C01",  "Fuel Spill - Uncontained large spill",
        "59C02",  "Fuel Spill - Contained large spill",
        "59C03",  "Fuel Spill - Unknown situation",
        "59D00",  "Fuel Spill",
        "59D01",  "Fuel Spill - Coastal water",
        "59D02",  "Fuel Spill - Inland water",
        "59D03",  "Fuel Spill - Oceanic water",
        "59D04",  "Fuel Spill - Sewer/Drain",
        
        // 60. Gas leak/Gas odor
        "60",     "Gas leak/Gas odor - Prealert",
        "60B01",  "Gas leak/Gas odor - Outside residential line",
        "60B02",  "Gas leak/Gas odor - Outside tank <= 5 gal",
        "60B03",  "Gas leak/Gas odor - Outside oder (unknown source)",
        "60C00",  "Gas leak/Gas odor",
        "60C01",  "Gas leak/Gas odor - Residential (single)",
        "60C02",  "Gas leak/Gas odor - Outside commercial line",
        "60C03",  "Gas leak/Gas odor - Outside tank > 5 gal",
        "60D00",  "Gas leak/Gas odor",
        "60D01",  "Gas leak/Gas odor - High life hazard",
        "60D02",  "Gas leak/Gas odor - High rise",
        "60D03",  "Gas leak/Gas odor - Commercial/industrial building",
        "60D04",  "Gas leak/Gas odor - Residential (multiple)",
        
        // 61. HazMat
        "61",     "HazMat - Prealert",
        "61A01",  "HazMat - Abaondoned waste",
        "61B00",  "HazMat",
        "61B01",  "HazMat - Small spill (<=5 gallons)",
        "61C00",  "HazMat",
        "61C01",  "HazMat - Contained hazmat",
        "61C02",  "HazMat - Contained illegal drug lab",
        "61C03",  "HaxMat - Contained chemical suicide",
        "61D00",  "HazMat",
        "61D01",  "HazMat - In or near waterway",
        "61D02",  "HazMat - Uncontained hazmat",
        "61D03",  "HazMat - Uncontained illegal drug lab",
        "61D04",  "HazMat - Uncontained chemical suicide",
        
        // 62. High Angle Rescue
        "62",     "High Angle Rescue - Prealert",
        "62B01",  "High Angle Rescue - Unknown situation",
        "62D00",  "High Angle Rescue",
        "62D01",  "High Angle Rescue - High angle rescue",
        "62D02",  "High Angle Rescue - High angle rescue (suicidal person)",
        "62D03",  "High Angle Rescue - High angle w/ single injured person",
        "62D04",  "High Angle Rescue - High angle w/ multiple injured persons",
        
        // 63. Lightning Strike
        "63",     "Lightning Strike - Prealert",
        "63B01",  "Lightning Strike - Residential (single)",
        "63B02",  "Lightning Strike - Large non-dwelling Bldg/structure",
        "63B03",  "Lightning Strike - Small non-dwelling Bldg/structure",
        "63B04",  "Lightning Strike - Mobile home, house trailer, portable office",
        "63B05",  "Lightning Strike - Outside lightning strike",
        "63B06",  "Lightning Strike - Vehicle",
        "63B07",  "Lightning Strike - Unknown situation",
        "63C00",  "Lightning Strike",
        "63C01",  "Lightning Strike - High life hazard",
        "63C02",  "Lightning Strike - High rise",
        "63C03",  "Lightning Strike - Commercial/ industrial building",
        "63C04",  "Lightning Strike - Residential (multiple)",
        
        // 64. Marine Fire
        "64",     "Marine Fire - Prealert",
        "64B01",  "Marine Fire - Extinguished fire",
        "64D00",  "Marine Fire",
        "64D01",  "Marine Fire - Threatened building/structure or other boats",
        "64D02",  "Marine Fire - Docked in coastal water",
        "64D03",  "Marine Fire - Docked in inland water",
        "64D04",  "Marine Fire - Beached in coastal water",
        "64D05",  "Marine Fire - Beached in inland water",
        "64D06",  "Marine Fire - Coastal water",
        "64D07",  "Marine Fire - Oceanic water",
        "64D08",  "Marine Fire - Inland water",
        "64D09",  "Marine Fire - Dry dock/on land",
        
        // 65. Mutual aid/Assist outside agency
        "65",     "Mutual aid/Assist outside agency - Prealert",
        "65A01",  "Mutual aid/Assist outside agency - Mutual aid to incident (multiple units - cold)",
        "65A02",  "Mutual aid/Assist outside agency - Assist outside agency (multiple units - cold)",
        "65A03",  "Mutual aid/Assist outside agency - Mutual aid to incident (single unit - cold)",
        "65A04",  "Mutual aid/Assist outside agency - Assist outside agency (single unit - cold)",
        "65A05",  "Mutual aid/Assist outside agency - Mutual aid move-up/cover",
        "65A06",  "Mutual aid/Assist outside agency - Mutual aid to staging area (station assignment)",
        "65B00",  "Mutual aid/Assist outside agency",
        "65B01",  "Mutual aid/Assist outside agency - Mutual aid to incident (single unit - hot)",
        "65B02",  "Mutual aid/Assist outside agency - Assist outside agency (single unit - hot)",
        "65D00",  "Mutual aid/Assist outside agency",
        "65D01",  "Mutual aid/Assist outside agency - Mutual aide to incident (multiple units - hot)",
        "65D02",  "Mutual aid/Assist outside agency - Assist outside agency (multiple units - hot)",
        
        // 66. Odor
        "66",     "Odor - Prealert",
        "66A01",  "Odor - Odor inside",
        "66A02",  "Odor - Odor outside",
        "66C00",  "Odor",
        "66C01",  "Odor - Odor inside single sick person",
        "66C02",  "Odor - Odor inside with multiple sick persons",
        "66C03",  "Odor - Odor outside with single sick person",
        "66C04",  "Odor - Odor outside with multiple sick persons",
        
        // 67. Outside Fire
        "67",     "Outside Fire - Prealert",
        "67O01",  "Outside Fire - Controlled Burn",
        "67A00",  "Outside Fire",
        "67A01",  "Outside Fire - Transformer",
        "67A02",  "Outside Fire - Extinguished fire",
        "67B00",  "Outside Fire",
        "67B01",  "Outside Fire - Smal outside fire",
        "67B02",  "Outside Fire - Small outside fire with hazardous materials",
        "67B03",  "Outside Fire - Unknown situation",
        "67C00",  "Outside Fire",
        "67C01",  "Outside Fire - Small brush/grass fire",
        "67D00",  "Outside Fire",
        "67D01",  "Outside Fire - Wildland fire",
        "67D02",  "Outside Fire - Large brush/grass fire",
        "67D03",  "Outside Fire - Large outside fire",
        "67D04",  "Outside Fire - Large outside fire with hazardous materials",
        "67D05",  "Outside Fire - Refinery/Tank farm/Fuel storage",
        "67E00",  "Outside Fire",
        "67E01",  "Outside Fire - Person on fire (outside)",
        
        // 68. Smoke Investigation
        "68",     "Smoke Investigation - Prealert",
        "68A01",  "Smoke Investigation (outside) - Light smoke",
        "68A02",  "Smoke Investigation (outside) - Odor of smoke",
        "68C00",  "Smoke Investigation (outside)",
        "68C01",  "Smoke Investigation (outside) - Heavy smoke",
        
        // 69. Structure Fire
        "69",     "Structure Fire - Prealert",
        "69C01",  "Structure Fire - Appliance (contained)",
        "69C02",  "Structure Fire - Extinguished fire",
        "69D00",  "Structure Fire",
        "69D01",  "Structure Fire - High life hazard",
        "69D02",  "Structure Fire - High rise",
        "69D03",  "Structure Fire - Commercial/industrial building",
        "69D04",  "Structure Fire - Comercial/industrial build with hazmat",
        "69D05",  "Structure Fire - Residential (multiple)",
        "69D06",  "Structure Fire - Residential (single)",
        "69D07",  "Structure Fire - Chimney",
        "69D08",  "Structure Fire - Large non-dwelling Bldg/structure",
        "69D09",  "Structure Fire - Small non-dwelling Bldg/structure",
        "69D10",  "Structure Fire - Mobile home, house trailer, portable office",
        "69D11",  "Structure Fire - Building/structure over water",
        "69D12",  "Structure Fire - Unknown building/structure type",
        "69E00",  "Structure Fire",
        "69E01",  "Sturcture Fire - High life hazard",
        "69E02",  "Sturcture Fire - High rise",
        "69E03",  "Sturcture Fire - Commercial/industrial building",
        "69E04",  "Structure Fire - Commercial/industrial building w/ hazmat",
        "69E05",  "Structure Fire - Residential (multiple)",
        "69E06",  "Structure Fire - Residential (single)",
        "69E07",  "Structure Fire - Chimney",
        "69E08",  "Structure Fire - Large non-dewlling building/structure",
        "69E09",  "Structure Fire - Small non-dewlling building/structure",
        "69E10",  "Structure Fire - Mobile home, house trailer portable office",
        "69E11",  "Structure Fire - Building/Structure over water",
        "69E12",  "Structure Fire - Unknown building/structure type",
        
        // 70. Trail and Rail collision/derailment
        "70",     "Trail and Rail collision/derailment - Prealert",
        "70C01",  "Trail and Rail collision/derailment - Large fuel/fire load vehicle on tracks",
        "70C02",  "Trail and Rail collision/derailment - Commercial vehicle on tracks",
        "70C03",  "Trail and Rail collision/derailment - Other vehicle on tracks",
        "70C04",  "Trail and Rail collision/derailment - Unknown situation",
        "70D00",  "Trail and Rail collision/derailment",
        "70D01",  "Trail and Rail collision/derailment - person trapped by train (no collision/derailment)",
        "70D02",  "Trail and Rail collision/derailment - Collision/derailment involving buildings/structures",
        "70D03",  "Trail and Rail collision/derailment - Collision/derailment involving vehicles",
        "70D04",  "Trail and Rail collision/derailment - Collision/derailment below ground level",
        "70D05",  "Trail and Rail collision/derailment - Collision/derailment above ground level",
        "70D06",  "Trail and Rail collision/derailment - Collision/derailment at ground level",
        "70D07",  "Trail and Rail collision/derailment - Collision/derailment in tunnel",
        "70D08",  "Trail and Rail collision/derailment - Collision/derailment on bridge/trestle",
        "70D09",  "Trail and Rail collision/derailment - Collision/derailment into/over water",
        
        // 71. Vehicle Fire
        "71",     "Vehicle Fire - Prealert",
        "71A01",  "Vehicle Fire - Vehicle fire (extinguished)",
        "71B00",  "Vehicle Fire",
        "71B01",  "Vehicle Fire - Vehicle fire",
        "71B02",  "Vehicle Fire - Commercial or large fuel/fire load vehicle (extinguished)",
        "71C00",  "Vehicle Fire",
        "71C01",  "Vehicle Fire - Vehicle fire threatening non-structure object",
        "71C02",  "Vehicle Fire - Vehicle fire in parking garage",
        "71C03",  "Vehicle Fire - Delivery vehicle",
        "71D00",  "Vehicle Fire",
        "71D01",  "Vehicle Fire - Vehicle fire (occupants trapped)",
        "71D02",  "Vehicle Fire - Vehicle fire in tunnel",
        "71D03",  "Vehicle Fire - Vehicle fire with threatened building/structure",
        "71D04",  "Vehicle Fire - Commercial vehicle",
        "71D05",  "Vehicle Fire - Large fuel",
        "71D06",  "Vehicle Fire - Agricultural/Farm/Excavation machinery",
        
        // 72. Water Rescue
        "72",     "Water Rescue - Prealert",
        "72A01",  "Water Rescue - Animal rescue",
        "72A02",  "Water Rescue - Body recovery",
        "72B00",  "Water Rescue",
        "72B01",  "Water Rescue - Stranded person (non-threatened)",
        "72B02",  "Water Rescue - Unknown situation",
        "72C00",  "Water Rescue",
        "72C01",  "Vehichle in floodwater (non-treatened)",
        "72D00",  "Water Rescue",
        "72D01",  "Water Rescue - Ice rescue",
        "72D02",  "Water Rescue - Swift water rescue",
        "72D03",  "Water Rescue - Scuba dive accident",
        "72D04",  "Water Rescue - Swimming pool rescue",
        "72D05",  "Water Rescue - Coastal water rescue",
        "72D06",  "Water Rescue - Inland water rescue",
        "72D07",  "Water Rescue - Oceanic water rescue",
        "72D08",  "Water Rescue - Surf rescue",
        "72D09",  "Water Rescue - Large flood water rescue",
        "72D10",  "Water Rescue - Small flood water rescue",
        "72D11",  "Water Rescue - Quicksand/marsh/ mud rescue",
        "72E00",  "Water Rescue",
        "72E01",  "Water Rescue - Sinking vehicle",
        "72E02",  "Water Rescue - Vehicle in floodwater (threatened)",
        
        // 73. Watercraft in distress
        "73",     "Watercraft in distress - Prealert",
        "73A01",  "Watercraft in distress - Watercraft welfare check",
        "73B01",  "Watercraft in distress - Watercraft disabled",
        "73B02",  "Watercraft in distress - Medical emergency on board",
        "73B03",  "Watercraft in distress - Enginen will not start",
        "73B04",  "Watercraft in distress - Run aground",
        "73B05",  "Watercraft in distress - Flare sighting (other than orange or red)",
        "73D00",  "Watercraft in distress",
        "73D01",  "Watercraft in distress - People in water",
        "73D02",  "Watercraft in distress - Taking on water",
        "73D03",  "Watercraft in distress - Flare sighting (red or orange)",
        "73D04",  "Watercraft in distress - Collision",
        "73D05",  "Watercraft in distress - Unknown situation",
        
        // 74. Suspicious package/bomb thread
        "74",     "Suspicious package/bomb threat - Prealert",
        "74A01",  "Suspicious package/bomb threat - Ordnance/Explosives found",
        "74B00",  "Suspicious package/bomb threat",
        "74B01",  "Suspicious package/bomb threat - Military ordinance",
        "74B02",  "Suspicious package/bomb threat - Explosives",
        "74C00",  "Suspicious package/bomb threat",
        "74C01",  "Suspicious package/bomb threat - Suspicious package with leakage/residue",
        "74C02",  "Suspicious package/bomb threat - Suspicious package",
        "74C03",  "Suspicious package/bomb threat - Bomb threat (suspect caller)",
        "74D00",  "Suspicious package/bomb threat",
        "74D01",  "Suspicious package/bomb threat - Suspicious package w/ leakage/residue & single sick/injured person",
        "74D02",  "Suspicious package/bomb threat - Suspicious package w/ leakage/residue & multiple sick/injured persons",
        "74D03",  "Suspicious package/bomb threat - Suspicious package w/ single sick/injured person",
        "74D04",  "Suspicious package/bomb threat - Suspicious package w/ multiple sick/injured persons",
        "74D05",  "Suspicious package/bomb threat - Military ordnance/explosives found with single sick/injured person",
        "74D06",  "Suspicious package/bomb threat - Military ordnance/explosives found with multiple sick/injured persons",
        
        // 75. Train and rail fire
        "75",     "Train and rail fire - Prealert",
        "75O01",  "Train and rail fire - Moving train",
        "75C00",  "Train and rail fire",
        "75C01",  "Train and rail fire - Unknown situation",
        "75D00",  "Train and rail fire",
        "75D01",  "Train and rail fire - Train fire involving buildings/structures",
        "75D02",  "Train and rail fire - Train fire involving vehicles",
        "75D03",  "Train and rail fire - Train fire below ground level",
        "75D04",  "Train and rail fire - Train fire above ground level",
        "75D05",  "Train and rail fire - Train fire at ground level",
        "75D06",  "Train and rail fire - Train fire in tunnel",
        "75D07",  "Train and rail fire - Train fire on bridge/trestle",
        "75D08",  "Train and rail fire - Train fire into/over water",
        
        // 76. Bomb threat
        "76",     "Bomb Threat - Prealert",
        "76B01",  "Bomb Threat",
        "76C00",  "Bomb Threat",
        "76C01",  "Bomb Threat - Suspect caller",
        
        // 77. Motor Vehicle Collisioin
        "77O01",  "Motor vehicle collision - Vehicle blocking traffic",
        "77O02",  "Motor vehicle collision - No injuries and no hazard",
        "77A00",  "Motor vehicle collision",
        "77A01",  "Motor vehicle collision - Low mechanism",
        "77A02",  "Motor vehicle collision - No injuries with hazard",
        "77B00",  "Motor vehicle collision",
        "77B01",  "Motor vehicle collision - Injuries",
        "77B02",  "Motor vehicle collision - Unknown situation",
        "77C00",  "Motor vehicle collision",
        "77C01",  "Motor vehicle collision - Injuries with hazard",
        "77C01",  "Motor vehicle collision - Fuel/fluid leak",
        "77D00",  "Motor vehicle collision",
        "77D01",  "Motor vehicle collision - High occupancy vehicle (high mechanism)",
        "77D02",  "Motor vehicle collision - High mechanism",
        "77D03",  "Motor vehicle collision - Multiple vehicle pile up",
        "77D04",  "Motor vehicle collision - Pinned (trapped) victim",
        "77D05",  "Motor vehicle collision - Ejection",
        "77D06",  "Motor vehicle collision - Vehicle vs. pedestrian/bicycle/motorcycle",
        "77D07",  "Motor vehicle collision - Vehicle vs. building",
        "77D08",  "Motor vehicle collision - Unstable vehicle",
        "77D09",  "Motor vehicle collision - Commercial vehicle",
        
        "90",     "Cardiac/Respiratory Arrest - Not breathing",
        "900",    "Cardiac/Respiratory Arrest - Breathing uncertain",
        "9000",   "Cardiac/Respiratory Arrest - Hanging",
        "90000",  "Cardiac/Respiratory Arrest - Strangulation",
        "900000", "Cardiac/Respiratory Arrest - Suffocation",
        "9000000","Cardiac/Respiratory Arrest - Underwater"
        
    );
    
    // Append any parser specific codes
    if (table.length % 2 != 0) {
      throw new RuntimeException("CodeTable constructor must have even number of of entries");
    }
    for (int ndx = 0; ndx < table.length; ndx += 2) {
      put(expand(table[ndx]), table[ndx+1]);
    }
  }

  @Override
  public Result getResult(String code, boolean reqSpace) {
    String expCode = expand(code);
    Result res =  super.getResult(expCode, false);
    if (res == null) return null;
    
    // Prealert codes don't count unless they are an exact match
    String resCode =  res.getCode();
    if (resCode.length() <= 2 && !code.equals(resCode)) return null;
    
    // If the code found did not include a suffix, see if the following
    // character matches something in the expanded determinate table
    if (resCode.length() == 5 && expCode.length() > 5) {
      char extra = expCode.charAt(5);
      if (extra >= 'A' && extra <= 'Z') {
        String suffix = EXPANDED_DETERMINATE_CODES.getProperty(expCode.substring(0,2) + extra);
        if (suffix != null) {
          resCode += extra;
          res.setDescription(res.getDescription() + " - " + suffix);
          res.setRemainder(res.getRemainder().substring(1).trim());
        }
      }
    }
    
    // Check that code is properly terminated
    int resLen = resCode.length();
    if (reqSpace) {
      if (expCode.length() != resLen && expCode.charAt(resLen) == ' ') return null;
    }
    
    int codeLength = resLen - (expCode.length() - code.length());
    res.setCode(code.substring(0,codeLength));
    return res;
  }

  /**
   * Expand shortened version of standard medical codes by adding zeros in the appropriate places
   * @param code possibly shortened code
   * @return expanded code
   */
  private String expand(String code) {
    
    // Start by removing spurious dashes
    code = code.replace("-",  "");
        
    if (code.length() == 0 || !Character.isDigit(code.charAt(0))) return code;
    
    if (code.length() < 3) {
      if (code.length() == 1) return '0' + code; 
      char chr2 = Character.toUpperCase(code.charAt(1));
      if (chr2 < 'A' || chr2 > 'Z') return code;
      return "0" + code.charAt(0) + chr2;
    }

    int ndx = 0;
    StringBuilder sb = new StringBuilder();
    char chr1, chr2, chr3;
    chr1 = code.charAt(ndx++);
    chr2 = code.charAt(ndx++);
    
    if (Character.isDigit(chr2)) {
      chr3 = code.charAt(ndx++);
    } else {
      chr3 = chr2;
      chr2 = chr1;
      chr1 = '0';
    }
    chr3 = Character.toUpperCase(chr3);
    if (chr3 < 'A' || chr3 > 'Z') return code;
    sb.append(chr1);
    sb.append(chr2);
    sb.append(chr3);
    
    if (ndx >= code.length()) return code;
    chr1 = code.charAt(ndx++);
    if (!Character.isDigit(chr1)) return code;
    chr2 = (ndx < code.length() ? code.charAt(ndx++) : 0);
    if (Character.isDigit(chr2)) {
      chr3 = (ndx < code.length() ? code.charAt(ndx++) : 0);
    } else {
      chr3 = chr2;
      chr2 = chr1;
      chr1 = '0';
    }
    sb.append(chr1);
    sb.append(chr2);
    if (chr3 > 0) sb.append(Character.toUpperCase(chr3));
    
    return sb.toString() + code.substring(ndx);
  }

  private static final Properties EXPANDED_DETERMINATE_CODES = MsgParser.buildCodeTable(new String[]{
      "02I", "Injection recomended",
      "02M", "Medication recomended",
      
      "04A", "Assault",
      "04S", "Sexual assault",
      "04T", "Stun gun",
      
      "06A", "Asthma",
      "06E", "COPD",
      "06O", "Other lung prob",
      
      "07E", "Explosion",
      "07F", "Fire present",
      "07W", "Fireworks",
      
      "08C", "Chemical",
      "08B", "Biological",
      "08R", "Radiological",
      "08N", "Nuclear",
      "08G", "Smell of gas/fumes",
      "08M", "Carbon monoxide",
      "08S", "Suicide attempt(CO)",
      "08T", "Suicide attempt(not CO)",
      "08U", "Unknown",
      
      "11F", "Food",
      "11O", "Object/toy",
      "11C", "Candy/Sweets/Gum",
      "11M", "Milk",
      "11U", "Unknown",
      
      "12E", "Epileptic or previous seizure",
      
      "13C", "Combative",
      
      "14D", "Diving injury",
      "14F", "Flood rescue",
      "14I", "Ice rescue",
      "14S", "SCUBA accident",
      "14W", "Swift water rescue",
      
      "15E", "Electrocution",
      "15L", "Lightning",
      
      "17A", "Acceessibility concern",
      "17E", "Environmental problems",
      "17G", "On ground or floor",
      "17J", "Jumper",
      "17P", "Public place",
      
      "20H", "Heat exposure",
      "20C", "Cold exposure",
      
      "21M", "Medical",
      "21T", "Trauma",
      
      "22A", "Above ground",
      "22B", "Below ground",
      "22M", "Multiple victims",
      "22X", "Above ground multiple victims",
      "22Y", "Below ground multiple victims",
      
      "23A", "Accidental",
      "23I", "Intentional",
      "23V", "Violent or combative",
      "23W", "Weapons",
      
      "24M", "Multiple Birth",
      
      "25V", "Violent",
      "25W", "Weapons",
      "25B", "Violent and weapons",
      
      "27S", "Stab",
      "27G", "Gunshot",
      "27P", "Penetrating wound",
      "27I", "Impalled",
      "27X", "Self inflicted GSW",
      "27Y", "Self inflicted stab",
      
      "29V", "Multiple patients",
      "29U", "Unknown # patients",
      "29Y", "Multipel pts and response reqd",
      "29X", "Unknown # pts and response reqd",
      
      "33T", "Transfer",
      "33P", "Pallative Care",
      
      "37A", "Additional personnel",
      "37S", "Special equipment",
      "37B", "Additional personel and special equip",
      
      "51L", "Large",
      "51S", "Small",
      "51C", "Cargo",
      "51M", "Military",
      "51U", "Unknown",
      
      "52C", "Carbon Monoxide",
      "52G", "General/Fire",
      "52H", "Heat Detector",
      "52I", "Industrial Gas/Hazmat",
      "52K", "Keypad (manual)",
      "52O", "Other",
      "52P", "Pull Station",
      "52S", "Smoke Detector",
      "52T", "Trouble/Tamper",
      "52U", "Unknown",
      "52W", "Waterflow/Sprinkler",
      "52X", "CO/Industrial gas with single sick person",
      "52Y", "CO/Industrial gas with multiple sick persons",
      
      "54A", "Avalanche",
      "54C", "Confined Space",
      "54H", "Sinkhole",
      "54L", "Large building/structure collapse",
      "54M", "Mudslide",
      "54S", "Small building/structure collapse",
      "54T", "Trench (collapse/rescue)",
      "54U", "Unknown",
      "54W", "Building/structure collapse into water",

      "55P", "Power disconnected",
      "55X", "Single injured person",
      "55Y", "Multiple injured persons",
      
      "57F", "Fire",
      "57G", "Fire w/ single injured person",
      "57H", "Fire w/ multiple injured perons",
      "57X", "Single injured person",
      "57Y", "Multiple injured persons",
      
      "58H", "Hazmat",
      
      "59I", "Inside",
      "59O", "Outside",
      "59U", "Unknown",
      "59V", "Inside and sick/injured person",
      "59W", "Inside and multiple sick/injured perons",
      "59X", "Outside and sick/injured person",
      "59Y", "Outside and multiple sick/injured persons",
      
      "60O", "Odor only",
      "60V", "Odor with single sick/injured person",
      "60W", "Odor with multiple sick/injured persons",
      "60X", "Single sick/injured person",
      "60Y", "Multiple sick/injured persons",
      
      "61B", "Biological",
      "61C", "Chemical",
      "61N", "Nuclear",
      "61R", "Radiological",
      "61U", "Unknown",
      
      "62A", "Above grade",
      "62B", "Below grade",
      "62W", "Above water",
      
      "63X", "Single injured person",
      "63Y", "Multiple injured persons",
      
      "64L", "Large (>= 50 ft)",
      "64M", "Medium (25-49 feet)",
      "64S", "Small (< 25 ft)",
      "64T", "Large and single injured person",
      "64U", "Large and multple injured persons",
      "64V", "Medium and single injured persons",
      "64W", "Medium and multiple injured persons",
      "64X", "Small and single injured person",
      "64Y", "Small and multiple injured persons",
      
      "67A", "Threatening animals",
      "67B", "Threatening buildings",
      "67O", "Threatening other",
      "67P", "Threatening people",
      "67R", "Threatening residential",
      "67U", "Threatening unknown",
      "67V", "Threatening vehicle",
      "67X", "Single injured person",
      "67Y", "Multiple injured persons",
      
      "69R", "Trapped person(s)",
      "69O", "Odor of smoke",
      "69I", "Single injured person",
      "69J", "Multiple injured persons",
      "69K", "Light smoke (1st party)",
      "69F", "Burned food (1st party)",
      "69T", "Trapped in building fire",
      "69P", "Person on fire (inside)",
      
      "70C", "Cable car",
      "70F", "Freight train",
      "70L", "Light rail",
      "70M", "Monorail",
      "70O", "Other",
      "70P", "Passenger train",
      "70S", "Subway",
      "70T", "Trolley",
      "70U", "Unknown",
      
      "71A", "Alternative fuel",
      "71H", "Hazmat",
      "71M", "Alternative fuel and hazmat",
      "71R", "Alternative fuel with single injured person",
      "71S", "Alternative fuel with multiple injured persons",
      "71T", "Hazmat with single injured person",
      "71U", "Hazmat with multiple injured persons",
      "71V", "Alternative fuel and hazmat with single injured person",
      "71W", "Alternative fuel and hazmat with mutliple injured persons",
      "71X", "Single injured person",
      "71Y", "Multiple injured persons",
      
      "72M", "Multiple peson rescue",
      "72X", "Single injured person",
      "72Y", "Multiple injured persons",
      
      "73C", "Costal",
      "73I", "Inland",
      "73O", "Oceanic",
      "73T", "Costal with single sick/injured person",
      "73U", "Costal with multiple sick/injured persons",
      "73V", "Inland with single sick/injured person",
      "73W", "Inland with multiple sick/injured persons",
      "73X", "Oceanic with single sick/injured person",
      "73Y", "Oceanic with multiple sick/injured persons",
      
      "74C", "Commercial/industrial building",
      "74G", "Govenrment building",
      "74H", "High life hazard/high rise",
      "74N", "Non-dwelling building/structure",
      "74O", "Open area",
      "74R", "Reidential building",
      
      "75C", "Cable car",
      "75F", "Freight train",
      "75L", "Light rail",
      "75M", "Monorail",
      "75O", "Other",
      "75P", "Passenger train",
      "75S", "Subway",
      "75T", "Trolley",
      "75U", "Unknown",
      
      "76C", "Commercial/industrial building",
      "76G", "Government building",
      "76H", "High life hazard/high rise",
      "76N", "Non-dwelling building/structure",
      "76O", "Open area",
      "76R", "Residential building",
      
      "77M", "Multiple vehicles",
      "77F", "Fire",
      "77H", "Hazmat",
      "77N", "Multiple vehicles and fire",
      "77O", "Multiple vehicles and hazmat",
      "77P", "Fire and hazmat",
      "77Q", "Multiple, fire and hazmat",
      
  });
}
