package net.anei.cadpage.parsers.AR;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Garland County, AR
Contact: Active911
Agency name: 70 West Fire Protection Association
Location: Hot Springs, AR, United States
Sender: dispatch@lifenetems.org

(Dispatch Alert - part 1 of 1) RC:0052-A/Run#48329/11:11/11:12/11:12/11:17\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:0107-A/Run#49057/14:12/14:12/14:12/14:18\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Job# 0054-A/ Run# 50760/ was Canceled: First Responder Only/09:55/09:55/09:57/10:03/10:11\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 50760/1-Emergency-Life Threat/108 CARAWAY ST//a/PEARCY/71964/You are responding to a patient with chest pain.  The patient is a 61-year-old  female/ who is consciousand breathing. Clammy.  Chest Pain (Non-Traumatic).\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 50702/1-Emergency-Life Threat/104 ROLLING ACRES DR///PEARCY/71964/You are responding to a patient involved in a fall.  The patient is a 38-year-old  male/ who is conscious and breathing. Not alert.  Falls.\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 50580/2-Emergency-Non Life Threat/S MOORE RD & AIRPORT RD///HOT SPRINGS/71913/You are responding to a patient injured in a traffic incident.  The patient is of  unknown age and gender/ and is conscious and breathing. Unknown  status/Other codes not applicable.  Traffic / Transportation Incidents.\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 50466/1-Emergency-Life Threat/262 LAKE HARBOR CIR///HOT SPRINGS/71913/You are responding to a patient who is unconscious (or has fainted).  The patient  is a 78-year-old female/ who is conscious and breathing. Not alert.  Unconscious / Fainting (Near).\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 50349/1-Emergency-Life Threat/151 PINEBERRY TRL///HOT SPRINGS/71913/You are responding to a patient with breathing problems.  The patient is of  unknown age and gender/ whose consciousness and breathing is  unknown. Abnormal breathing.\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 50264/3-Immediate/2131 AIRPORT RD///HOT SPRINGS/71913/<PROQA_SCRIPT>\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 50127/1-Emergency-Life Threat/710 OAKGROVE RD///ROYAL/71968/You are responding to a patient with chest pain.  The patient is a 73-year-old  male/ who is conscious and breathing. Breathing normally => 35.  Chest Pain (Non-Traumatic).\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 49914/1-Emergency-Life Threat/578 RUSHFORK RD//15 P/HOT SPRINGS/71913/You are responding to a patient with breathing problems.  The patient is a  56-year-old female/ who is conscious and breathing. Not alert.\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 49899/1-Emergency-Life Threat/4428 MARION ANDERSON RD///HOT SPRINGS/71913/You are responding to a patient who has apparently overdosed/been  poisoned.  The patient is a 42-year-old male/ who is unconscious and  breathing. Unconscious  (Intentional Overdose).  Overdose / Poisoning (Ingestion).\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 49790/1-Emergency-Life Threat/5100 AMITY RD///BONNERDALE/71933/You are responding to a patient with chest pain.  The patient is a 84-year-old  female/ who is conscious and breathing. DIFFICULTY SPEAKING BETWEEN  BREATHS.  Chest Pain (Non-Traumatic).\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 49748/1-Emergency-Life Threat/149 DEER VIEW CIR///HOT SPRINGS/71913/You are responding to a patient who is unconscious (or has fainted).  The patient  is a 56-year-old female/ who is conscious and breathing. Alert with  abnormal breathing.  Unconscious / Fainting (Near).\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 49738/1-Emergency-Life Threat/PEARCY RD//SOUTH 2 MILE DOWN/BONNERDALE/71933/You are responding to a patient injured in a traffic incident.  The patient is a  20-year-old female/ who is conscious and breathing. Pinned (trapped)  victim.  Traffic / Transportation Incidents.\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 49656/1-Emergency-Life Threat/677 TIMBERLAKE DR///PEARCY/71964/You are responding to a patient with breathing problems.  The patient is a  37-year-old male/ who is conscious and breathing. Abnormal breathing.\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 49649/1-Emergency-Life Threat/224 STONEHURST RD///HOT SPRINGS/71913/You are responding to a patient with breathing problems.  The patient is a  70-year-old male/ whois conscious and breathing. Abnormal breathing.\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 49413/3-Immediate/349 HUNTINGTON DR///PEARCY/71964/<PROQA_SCRIPT>\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 49408/2-Emergency-Non Life Threat/AIRPORT RD & MAJESTIC LODGE RD///HOT SPRINGS/71913/You are responding to a patient injured in a traffic incident.  The patient is of  unknown age and gender/ and is conscious and breathing. Injuries.  Traffic / Transportation Incidents.\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 49345/1-Emergency-Life Threat/315 NORTHSHORE DR///HOT SPRINGS/71913/You are responding to a patient with breathing problems.  The patient is a  71-year-old male/ whois conscious and breathing. DIFFICULTY  SPEAKING BETWEEN BREATHS.\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 49323/1-Emergency-Life Threat/204 PARADISE PT///HOT SPRINGS/71913/You are responding to a patient who is unconscious (or has fainted).  The patient  is a 78-year-oldfemale/ who is unconscious and breathing.  Unconscious -- Effective breathing.  Unconscious / Fainting (Near).\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 49323/3-Immediate/204 PARADISE PT///HOT SPRINGS/71913/<PROQA_SCRIPT>\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 49220/1-Emergency-Life Threat/1225 MARION ANDERSON RD///HOT SPRINGS/71913/You are responding to a patient who is unconscious (or has fainted).  The patient  is a 88-year-old male/ who is unconscious and breathing. Unconscious  -- Effective breathing.  Unconscious / Fainting (Near).\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 49057/3-Immediate/203 BROWNING DR///HOT SPRINGS/71913/<PROQA_SCRIPT>\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 48999/1-Emergency-Life Threat/140 COVENTRY TRL///ROYAL/71968/You are responding to a patient who has apparently suffered a stroke.  The patient  is a 35-year-old male/ who is conscious and breathing. Abnormal  breathing  (No test evidence of stroke (< X hours)).  Stroke (CVA) / Transient Ischemic Attack (TIA).\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 48991/1-Emergency-Life Threat/129 WHITFIELD RD///PEARCY/71964/You are responding to a patient with abdominal pain.  The patient is a  77-year-old female/ who is conscious and breathing. Fainting or near  fainting => 50.  Abdominal Pain / Problems.\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 48989/3-Immediate/137 LAKE FOREST SHORES DR///HOT SPRINGS/71913/You are responding to a patient involved in a fall.  The patient is a 84-year-old  male/ who is conscious and breathing. NOT DANGEROUS body area  (On  the ground or floor).  Falls.\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 48758/1-Emergency-Life Threat/224 SOUTHSHORE DR///HOT SPRINGS/71913/You are responding to a patient who has apparently suffered a stroke.  The patient  is a 66-year-old male/ who is conscious and breathing. Unknown  status/Other codes not applicable  (Unknown when the symptoms started).  Stroke (CVA) / Transient Ischemic Attack (TIA).\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 48740/1-Emergency-Life Threat/578 RUSHFORK RD//15 P/HOT SPRINGS/71913/You are responding to a patient with breathing problems.  The patient is a  56-year-old female/who is conscious and breathing. DIFFICULTY  SPEAKING BETWEEN BREATHS.\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 48495/2-Emergency-Non Life Threat/S MOORE RD & AMITY RD///HOT SPRINGS/71913/You are responding to patients involved in a traffic incident.  (If known -- relay  pertinent patient-specific information.) Unknown status/Other codes not  applicable  (Unknown number of patients).  Unknown number of patients involved.  Traffic / Transportation Incidents.\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 48495/2-Emergency-Non Life Threat/S MOORE RD///HOT SPRINGS/71964/<PROQA_SCRIPT>\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 48446/1-Emergency-Life Threat/629 WHITFIELD RD///PEARCY/71964/You are responding to a patient who is unconscious (or has fainted).  The patient  is a 62-year-old male/ who is conscious and breathing. Not alert.  Unconscious / Fainting (Near).\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 48329/3-Immediate/324 KAUFMAN RD///HOT SPRINGS/71913/<PROQA_SCRIPT>\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 48205/1-Emergency-Life Threat/262 CANDLEBERRY CIR///HOT SPRINGS/71913/You are responding to a patient with breathing problems.  The patient is a  68-year-old female/who is conscious and breathing. Not alert.\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 47978/2-Emergency-Non Life Threat/4425 MARION ANDERSON RD///HOT SPRINGS/71913/You are responding to a patient with specifically identified traumatic injuries.  The patient is a 60-year-old male/ who is conscious and breathing.  POSSIBLY DANGEROUS body area.  Traumatic Injuries (Specific).\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 47832/1-Emergency-Life Threat/1119 ROCK CREEK RD///HOT SPRINGS/71913/You are responding to a patient who has apparently suffered a stroke.  The patient  is a 79-year-old male/ who is conscious and breathing. Sudden loss of  balance or coordination  (Partial evidence of stroke (Unknown hours)).  Stroke (CVA) / Transient Ischemic Attack (TIA).\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 47801/1-Emergency-Life Threat/393 RYAN RD///PEARCY/71964/You are responding to a patient with breathing problems.  The patient is a  65-year-old female/ who is conscious and breathing. DIFFICULTY  SPEAKING BETWEEN BREATHS.\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 47782/1-Emergency-Life Threat/165 WAMPUM CIR///HOT SPRINGS/71913/You are responding to a patient with breathing problems.  The patient is a  4-month-old female/ who is conscious and whose breathing is  unknown. CHANGING COLOR.\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 47782/1-Emergency-Life Threat/165 WAMPUM CIR///HOT SPRINGS/71913/You are responding to a patient who is apparently choking.  The patient is a  4-month-old female/ whois conscious and whose breathing is  unknown. Abnormal breathing (PARTIAL obstruction).\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 47727/2-Emergency-Non Life Threat/WESTWEGO TER & AIRPORT RD///PEARCY/71964/You are responding to a patient injured in a traffic incident.  The patient is of  unknownage and gender/ whose consciousness and breathing is  unknown. Injuries.  Traffic / Transportation Incidents.\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 47613/1-Emergency-Life Threat/S MOORE RD & RUSHFORK RD///HOT SPRINGS/71913/<PROQA_SCRIPT>\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 47610/3-Immediate/198 BRIARRIDGE CT///HOT SPRINGS/71913/<PROQA_SCRIPT>\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 47577/3-Immediate/1549 PEARCY RD///PEARCY/71964/<PROQA_SCRIPT>\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 47391/1-Emergency-Life Threat/120 PITTMAN RD///HOT SPRINGS/71913/You are responding to a patient who is unconscious (or has fainted).  The patient  is a 85-year-old female/ who is unconscious and breathing.  Unconscious -- AGONAL/INEFFECTIVE BREATHING.  Unconscious / Fainting (Near).\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 47384/3-Immediate/212 ELYSIAN HILLS DR///HOT SPRINGS/71913/<PROQA_SCRIPT>\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 47183/3-Immediate/3340 AIRPORT RD///PEARCY/71964/<PROQA_SCRIPT>\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 47116/3-Immediate/8 STONEGATE PT///HOT SPRINGS/71913/<PROQA_SCRIPT>\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 47093/3-Immediate/633 ALLISON ST///PEARCY/71964/<PROQA_SCRIPT>\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 47049/3-Immediate/300 ALLISON ST///PEARCY/71964/<PROQA_SCRIPT>\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 46858/1-Emergency-Life Threat/174 JOELLA DR///PEARCY/71964/You are responding to a patient who is sick (or has a current medical condition).  The patient is a 78-year-old male/ who is conscious and breathing. Not  alert.  Sick Person (Specific Diagnosis).\r\n\r\n
(Dispatch Alert - part 1 of 1) RC:Run# 46758/1-Emergency-Life Threat/LOST CREEK RD & CONNELLY RD///PEARCY/71964/\r\n\r\n

*/

public class ARGarlandCountyParserTest extends BaseParserTest {
  
  public ARGarlandCountyParserTest() {
    setParser(new ARGarlandCountyParser(), "GARLAND COUNTY", "AR");
  }
  
  @Test
  public void testRunReport() {

    doTest("T1",
        "(Dispatch Alert - part 1 of 1) RC:0052-A/Run#48329/11:11/11:12/11:12/11:17\r\n\r\n",
        "ID:48329",
        "CALL:RUN REPORT",
        "PLACE:11:11/11:12/11:12/11:17");

    doTest("T2",
        "(Dispatch Alert - part 1 of 1) RC:0107-A/Run#49057/14:12/14:12/14:12/14:18\r\n\r\n",
        "ID:49057",
        "CALL:RUN REPORT",
        "PLACE:14:12/14:12/14:12/14:18");

    doTest("T3",
        "(Dispatch Alert - part 1 of 1) RC:Job# 0054-A/ Run# 50760/ was Canceled: First Responder Only/09:55/09:55/09:57/10:03/10:11\r\n\r\n",
        "ID:50760",
        "CALL:RUN REPORT",
        "PLACE:was Canceled: First Responder Only/09:55/09:55/09:57/10:03/10:11");

  }
  
  @Test
  public void testHotSprings() {

    doTest("T1",
        "(Dispatch Alert - part 1 of 1) RC:Run# 50760/1-Emergency-Life Threat/108 CARAWAY ST//a/PEARCY/71964/You are responding to a patient with chest pain.  The patient is a 61-year-old  female/ who is consciousand breathing. Clammy.  Chest Pain (Non-Traumatic).\r\n" +
        "\r\n",

        "ID:50760",
        "PRI:1",
        "CALL:Emergency-Life Threat",
        "ADDR:108 CARAWAY ST",
        "APT:a",
        "CITY:PEARCY",
        "INFO:You are responding to a patient with chest pain.  The patient is a 61-year-old  female / who is consciousand breathing. Clammy.  Chest Pain (Non-Traumatic).");

    doTest("T2",
        "(Dispatch Alert - part 1 of 1) RC:Run# 50702/1-Emergency-Life Threat/104 ROLLING ACRES DR///PEARCY/71964/You are responding to a patient involved in a fall.  The patient is a 38-year-old  male/ who is conscious and breathing. Not alert.  Falls.\r\n" +
        "\r\n",

        "ID:50702",
        "PRI:1",
        "CALL:Emergency-Life Threat",
        "ADDR:104 ROLLING ACRES DR",
        "CITY:PEARCY",
        "INFO:You are responding to a patient involved in a fall.  The patient is a 38-year-old  male / who is conscious and breathing. Not alert.  Falls.");

    doTest("T3",
        "(Dispatch Alert - part 1 of 1) RC:Run# 50580/2-Emergency-Non Life Threat/S MOORE RD & AIRPORT RD///HOT SPRINGS/71913/You are responding to a patient injured in a traffic incident.  The patient is of  unknown age and gender/ and is conscious and breathing. Unknown  status/Other codes not applicable.  Traffic / Transportation Incidents.\r\n" +
        "\r\n",

        "ID:50580",
        "PRI:2",
        "CALL:Emergency-Non Life Threat",
        "ADDR:S MOORE RD & AIRPORT RD",
        "CITY:HOT SPRINGS",
        "INFO:You are responding to a patient injured in a traffic incident.  The patient is of  unknown age and gender / and is conscious and breathing. Unknown  status / Other codes not applicable.  Traffic / Transportation Incidents.");

    doTest("T4",
        "(Dispatch Alert - part 1 of 1) RC:Run# 50466/1-Emergency-Life Threat/262 LAKE HARBOR CIR///HOT SPRINGS/71913/You are responding to a patient who is unconscious (or has fainted).  The patient  is a 78-year-old female/ who is conscious and breathing. Not alert.  Unconscious / Fainting (Near).\r\n" +
        "\r\n",

        "ID:50466",
        "PRI:1",
        "CALL:Emergency-Life Threat",
        "ADDR:262 LAKE HARBOR CIR",
        "CITY:HOT SPRINGS",
        "INFO:You are responding to a patient who is unconscious (or has fainted).  The patient  is a 78-year-old female / who is conscious and breathing. Not alert.  Unconscious / Fainting (Near).");

    doTest("T5",
        "(Dispatch Alert - part 1 of 1) RC:Run# 50349/1-Emergency-Life Threat/151 PINEBERRY TRL///HOT SPRINGS/71913/You are responding to a patient with breathing problems.  The patient is of  unknown age and gender/ whose consciousness and breathing is  unknown. Abnormal breathing.\r\n" +
        "\r\n",

        "ID:50349",
        "PRI:1",
        "CALL:Emergency-Life Threat",
        "ADDR:151 PINEBERRY TRL",
        "CITY:HOT SPRINGS",
        "INFO:You are responding to a patient with breathing problems.  The patient is of  unknown age and gender / whose consciousness and breathing is  unknown. Abnormal breathing.");

    doTest("T6",
        "(Dispatch Alert - part 1 of 1) RC:Run# 50264/3-Immediate/2131 AIRPORT RD///HOT SPRINGS/71913/<PROQA_SCRIPT>\r\n\r\n",
        "ID:50264",
        "PRI:3",
        "CALL:Immediate",
        "ADDR:2131 AIRPORT RD",
        "CITY:HOT SPRINGS");

    doTest("T7",
        "(Dispatch Alert - part 1 of 1) RC:Run# 50127/1-Emergency-Life Threat/710 OAKGROVE RD///ROYAL/71968/You are responding to a patient with chest pain.  The patient is a 73-year-old  male/ who is conscious and breathing. Breathing normally => 35.  Chest Pain (Non-Traumatic).\r\n" +
        "\r\n",

        "ID:50127",
        "PRI:1",
        "CALL:Emergency-Life Threat",
        "ADDR:710 OAKGROVE RD",
        "CITY:ROYAL",
        "INFO:You are responding to a patient with chest pain.  The patient is a 73-year-old  male / who is conscious and breathing. Breathing normally => 35.  Chest Pain (Non-Traumatic).");

    doTest("T8",
        "(Dispatch Alert - part 1 of 1) RC:Run# 49914/1-Emergency-Life Threat/578 RUSHFORK RD//15 P/HOT SPRINGS/71913/You are responding to a patient with breathing problems.  The patient is a  56-year-old female/ who is conscious and breathing. Not alert.\r\n" +
        "\r\n",

        "ID:49914",
        "PRI:1",
        "CALL:Emergency-Life Threat",
        "ADDR:578 RUSHFORK RD",
        "APT:15 P",
        "CITY:HOT SPRINGS",
        "INFO:You are responding to a patient with breathing problems.  The patient is a  56-year-old female / who is conscious and breathing. Not alert.");

    doTest("T9",
        "(Dispatch Alert - part 1 of 1) RC:Run# 49899/1-Emergency-Life Threat/4428 MARION ANDERSON RD///HOT SPRINGS/71913/You are responding to a patient who has apparently overdosed/been  poisoned.  The patient is a 42-year-old male/ who is unconscious and  breathing. Unconscious  (Intentional Overdose).  Overdose / Poisoning (Ingestion).\r\n" +
        "\r\n",

        "ID:49899",
        "PRI:1",
        "CALL:Emergency-Life Threat",
        "ADDR:4428 MARION ANDERSON RD",
        "CITY:HOT SPRINGS",
        "INFO:You are responding to a patient who has apparently overdosed / been  poisoned.  The patient is a 42-year-old male / who is unconscious and  breathing. Unconscious  (Intentional Overdose).  Overdose / Poisoning (Ingestion).");

    doTest("T10",
        "(Dispatch Alert - part 1 of 1) RC:Run# 49790/1-Emergency-Life Threat/5100 AMITY RD///BONNERDALE/71933/You are responding to a patient with chest pain.  The patient is a 84-year-old  female/ who is conscious and breathing. DIFFICULTY SPEAKING BETWEEN  BREATHS.  Chest Pain (Non-Traumatic).\r\n" +
        "\r\n",

        "ID:49790",
        "PRI:1",
        "CALL:Emergency-Life Threat",
        "ADDR:5100 AMITY RD",
        "CITY:BONNERDALE",
        "INFO:You are responding to a patient with chest pain.  The patient is a 84-year-old  female / who is conscious and breathing. DIFFICULTY SPEAKING BETWEEN  BREATHS.  Chest Pain (Non-Traumatic).");

    doTest("T11",
        "(Dispatch Alert - part 1 of 1) RC:Run# 49748/1-Emergency-Life Threat/149 DEER VIEW CIR///HOT SPRINGS/71913/You are responding to a patient who is unconscious (or has fainted).  The patient  is a 56-year-old female/ who is conscious and breathing. Alert with  abnormal breathing.  Unconscious / Fainting (Near).\r\n" +
        "\r\n",

        "ID:49748",
        "PRI:1",
        "CALL:Emergency-Life Threat",
        "ADDR:149 DEER VIEW CIR",
        "CITY:HOT SPRINGS",
        "INFO:You are responding to a patient who is unconscious (or has fainted).  The patient  is a 56-year-old female / who is conscious and breathing. Alert with  abnormal breathing.  Unconscious / Fainting (Near).");

    doTest("T12",
        "(Dispatch Alert - part 1 of 1) RC:Run# 49738/1-Emergency-Life Threat/PEARCY RD//SOUTH 2 MILE DOWN/BONNERDALE/71933/You are responding to a patient injured in a traffic incident.  The patient is a  20-year-old female/ who is conscious and breathing. Pinned (trapped)  victim.  Traffic / Transportation Incidents.\r\n" +
        "\r\n",

        "ID:49738",
        "PRI:1",
        "CALL:Emergency-Life Threat",
        "ADDR:PEARCY RD",
        "PLACE:SOUTH 2 MILE DOWN",
        "CITY:BONNERDALE",
        "INFO:You are responding to a patient injured in a traffic incident.  The patient is a  20-year-old female / who is conscious and breathing. Pinned (trapped)  victim.  Traffic / Transportation Incidents.");

    doTest("T13",
        "(Dispatch Alert - part 1 of 1) RC:Run# 49656/1-Emergency-Life Threat/677 TIMBERLAKE DR///PEARCY/71964/You are responding to a patient with breathing problems.  The patient is a  37-year-old male/ who is conscious and breathing. Abnormal breathing.\r\n" +
        "\r\n",

        "ID:49656",
        "PRI:1",
        "CALL:Emergency-Life Threat",
        "ADDR:677 TIMBERLAKE DR", // Google says this is in Hale
        "CITY:PEARCY",
        "INFO:You are responding to a patient with breathing problems.  The patient is a  37-year-old male / who is conscious and breathing. Abnormal breathing.");

    doTest("T14",
        "(Dispatch Alert - part 1 of 1) RC:Run# 49649/1-Emergency-Life Threat/224 STONEHURST RD///HOT SPRINGS/71913/You are responding to a patient with breathing problems.  The patient is a  70-year-old male/ whois conscious and breathing. Abnormal breathing.\r\n" +
        "\r\n",

        "ID:49649",
        "PRI:1",
        "CALL:Emergency-Life Threat",
        "ADDR:224 STONEHURST RD",
        "CITY:HOT SPRINGS",
        "INFO:You are responding to a patient with breathing problems.  The patient is a  70-year-old male / whois conscious and breathing. Abnormal breathing.");

    doTest("T15",
        "(Dispatch Alert - part 1 of 1) RC:Run# 49413/3-Immediate/349 HUNTINGTON DR///PEARCY/71964/<PROQA_SCRIPT>\r\n\r\n",
        "ID:49413",
        "PRI:3",
        "CALL:Immediate",
        "ADDR:349 HUNTINGTON DR",
        "CITY:PEARCY");

    doTest("T16",
        "(Dispatch Alert - part 1 of 1) RC:Run# 49408/2-Emergency-Non Life Threat/AIRPORT RD & MAJESTIC LODGE RD///HOT SPRINGS/71913/You are responding to a patient injured in a traffic incident.  The patient is of  unknown age and gender/ and is conscious and breathing. Injuries.  Traffic / Transportation Incidents.\r\n" +
        "\r\n",

        "ID:49408",
        "PRI:2",
        "CALL:Emergency-Non Life Threat",
        "ADDR:AIRPORT RD & MAJESTIC LODGE RD",
        "CITY:HOT SPRINGS",
        "INFO:You are responding to a patient injured in a traffic incident.  The patient is of  unknown age and gender / and is conscious and breathing. Injuries.  Traffic / Transportation Incidents.");

    doTest("T17",
        "(Dispatch Alert - part 1 of 1) RC:Run# 49345/1-Emergency-Life Threat/315 NORTHSHORE DR///HOT SPRINGS/71913/You are responding to a patient with breathing problems.  The patient is a  71-year-old male/ whois conscious and breathing. DIFFICULTY  SPEAKING BETWEEN BREATHS.\r\n" +
        "\r\n",

        "ID:49345",
        "PRI:1",
        "CALL:Emergency-Life Threat",
        "ADDR:315 NORTHSHORE DR",
        "CITY:HOT SPRINGS",
        "INFO:You are responding to a patient with breathing problems.  The patient is a  71-year-old male / whois conscious and breathing. DIFFICULTY  SPEAKING BETWEEN BREATHS.");

    doTest("T18",
        "(Dispatch Alert - part 1 of 1) RC:Run# 49323/1-Emergency-Life Threat/204 PARADISE PT///HOT SPRINGS/71913/You are responding to a patient who is unconscious (or has fainted).  The patient  is a 78-year-oldfemale/ who is unconscious and breathing.  Unconscious -- Effective breathing.  Unconscious / Fainting (Near).\r\n" +
        "\r\n",

        "ID:49323",
        "PRI:1",
        "CALL:Emergency-Life Threat",
        "ADDR:204 PARADISE PT",
        "CITY:HOT SPRINGS",
        "INFO:You are responding to a patient who is unconscious (or has fainted).  The patient  is a 78-year-oldfemale / who is unconscious and breathing.  Unconscious -- Effective breathing.  Unconscious / Fainting (Near).");

    doTest("T19",
        "(Dispatch Alert - part 1 of 1) RC:Run# 49323/3-Immediate/204 PARADISE PT///HOT SPRINGS/71913/<PROQA_SCRIPT>\r\n\r\n",
        "ID:49323",
        "PRI:3",
        "CALL:Immediate",
        "ADDR:204 PARADISE PT",
        "CITY:HOT SPRINGS");

    doTest("T20",
        "(Dispatch Alert - part 1 of 1) RC:Run# 49220/1-Emergency-Life Threat/1225 MARION ANDERSON RD///HOT SPRINGS/71913/You are responding to a patient who is unconscious (or has fainted).  The patient  is a 88-year-old male/ who is unconscious and breathing. Unconscious  -- Effective breathing.  Unconscious / Fainting (Near).\r\n" +
        "\r\n",

        "ID:49220",
        "PRI:1",
        "CALL:Emergency-Life Threat",
        "ADDR:1225 MARION ANDERSON RD",
        "CITY:HOT SPRINGS",
        "INFO:You are responding to a patient who is unconscious (or has fainted).  The patient  is a 88-year-old male / who is unconscious and breathing. Unconscious  -- Effective breathing.  Unconscious / Fainting (Near).");

    doTest("T21",
        "(Dispatch Alert - part 1 of 1) RC:Run# 49057/3-Immediate/203 BROWNING DR///HOT SPRINGS/71913/<PROQA_SCRIPT>\r\n\r\n",
        "ID:49057",
        "PRI:3",
        "CALL:Immediate",
        "ADDR:203 BROWNING DR",
        "CITY:HOT SPRINGS");

    doTest("T22",
        "(Dispatch Alert - part 1 of 1) RC:Run# 48999/1-Emergency-Life Threat/140 COVENTRY TRL///ROYAL/71968/You are responding to a patient who has apparently suffered a stroke.  The patient  is a 35-year-old male/ who is conscious and breathing. Abnormal  breathing  (No test evidence of stroke (< X hours)).  Stroke (CVA) / Transient Ischemic Attack (TIA).\r\n" +
        "\r\n",

        "ID:48999",
        "PRI:1",
        "CALL:Emergency-Life Threat",
        "ADDR:140 COVENTRY TRL",
        "CITY:ROYAL",
        "INFO:You are responding to a patient who has apparently suffered a stroke.  The patient  is a 35-year-old male / who is conscious and breathing. Abnormal  breathing  (No test evidence of stroke (< X hours)).  Stroke (CVA) / Transient Ischemic Attack (TIA).");

    doTest("T23",
        "(Dispatch Alert - part 1 of 1) RC:Run# 48991/1-Emergency-Life Threat/129 WHITFIELD RD///PEARCY/71964/You are responding to a patient with abdominal pain.  The patient is a  77-year-old female/ who is conscious and breathing. Fainting or near  fainting => 50.  Abdominal Pain / Problems.\r\n" +
        "\r\n",

        "ID:48991",
        "PRI:1",
        "CALL:Emergency-Life Threat",
        "ADDR:129 WHITFIELD RD",
        "CITY:PEARCY",
        "INFO:You are responding to a patient with abdominal pain.  The patient is a  77-year-old female / who is conscious and breathing. Fainting or near  fainting => 50.  Abdominal Pain / Problems.");

    doTest("T24",
        "(Dispatch Alert - part 1 of 1) RC:Run# 48989/3-Immediate/137 LAKE FOREST SHORES DR///HOT SPRINGS/71913/You are responding to a patient involved in a fall.  The patient is a 84-year-old  male/ who is conscious and breathing. NOT DANGEROUS body area  (On  the ground or floor).  Falls.\r\n" +
        "\r\n",

        "ID:48989",
        "PRI:3",
        "CALL:Immediate",
        "ADDR:137 LAKE FOREST SHORES DR",
        "CITY:HOT SPRINGS",
        "INFO:You are responding to a patient involved in a fall.  The patient is a 84-year-old  male / who is conscious and breathing. NOT DANGEROUS body area  (On  the ground or floor).  Falls.");

    doTest("T25",
        "(Dispatch Alert - part 1 of 1) RC:Run# 48758/1-Emergency-Life Threat/224 SOUTHSHORE DR///HOT SPRINGS/71913/You are responding to a patient who has apparently suffered a stroke.  The patient  is a 66-year-old male/ who is conscious and breathing. Unknown  status/Other codes not applicable  (Unknown when the symptoms started).  Stroke (CVA) / Transient Ischemic Attack (TIA).\r\n" +
        "\r\n",

        "ID:48758",
        "PRI:1",
        "CALL:Emergency-Life Threat",
        "ADDR:224 SOUTHSHORE DR", 
        "CITY:HOT SPRINGS",
        "INFO:You are responding to a patient who has apparently suffered a stroke.  The patient  is a 66-year-old male / who is conscious and breathing. Unknown  status / Other codes not applicable  (Unknown when the symptoms started).  Stroke (CVA) / Transient Ischemic Attack (TIA).");

    doTest("T26",
        "(Dispatch Alert - part 1 of 1) RC:Run# 48740/1-Emergency-Life Threat/578 RUSHFORK RD//15 P/HOT SPRINGS/71913/You are responding to a patient with breathing problems.  The patient is a  56-year-old female/who is conscious and breathing. DIFFICULTY  SPEAKING BETWEEN BREATHS.\r\n" +
        "\r\n",

        "ID:48740",
        "PRI:1",
        "CALL:Emergency-Life Threat",
        "ADDR:578 RUSHFORK RD",
        "APT:15 P",
        "CITY:HOT SPRINGS",
        "INFO:You are responding to a patient with breathing problems.  The patient is a  56-year-old female / who is conscious and breathing. DIFFICULTY  SPEAKING BETWEEN BREATHS.");

    doTest("T27",
        "(Dispatch Alert - part 1 of 1) RC:Run# 48495/2-Emergency-Non Life Threat/S MOORE RD & AMITY RD///HOT SPRINGS/71913/You are responding to patients involved in a traffic incident.  (If known -- relay  pertinent patient-specific information.) Unknown status/Other codes not  applicable  (Unknown number of patients).  Unknown number of patients involved.  Traffic / Transportation Incidents.\r\n" +
        "\r\n",

        "ID:48495",
        "PRI:2",
        "CALL:Emergency-Non Life Threat",
        "ADDR:S MOORE RD & AMITY RD",
        "CITY:HOT SPRINGS",
        "INFO:You are responding to patients involved in a traffic incident.  (If known -- relay  pertinent patient-specific information.) Unknown status / Other codes not  applicable  (Unknown number of patients).  Unknown number of patients involved.  Traffic / Transportation Incidents.");

    doTest("T28",
        "(Dispatch Alert - part 1 of 1) RC:Run# 48495/2-Emergency-Non Life Threat/S MOORE RD///HOT SPRINGS/71964/<PROQA_SCRIPT>\r\n\r\n",
        "ID:48495",
        "PRI:2",
        "CALL:Emergency-Non Life Threat",
        "ADDR:S MOORE RD",
        "CITY:HOT SPRINGS");

    doTest("T29",
        "(Dispatch Alert - part 1 of 1) RC:Run# 48446/1-Emergency-Life Threat/629 WHITFIELD RD///PEARCY/71964/You are responding to a patient who is unconscious (or has fainted).  The patient  is a 62-year-old male/ who is conscious and breathing. Not alert.  Unconscious / Fainting (Near).\r\n" +
        "\r\n",

        "ID:48446",
        "PRI:1",
        "CALL:Emergency-Life Threat",
        "ADDR:629 WHITFIELD RD",
        "CITY:PEARCY",
        "INFO:You are responding to a patient who is unconscious (or has fainted).  The patient  is a 62-year-old male / who is conscious and breathing. Not alert.  Unconscious / Fainting (Near).");

    doTest("T30",
        "(Dispatch Alert - part 1 of 1) RC:Run# 48329/3-Immediate/324 KAUFMAN RD///HOT SPRINGS/71913/<PROQA_SCRIPT>\r\n\r\n",
        "ID:48329",
        "PRI:3",
        "CALL:Immediate",
        "ADDR:324 KAUFMAN RD",
        "CITY:HOT SPRINGS");

    doTest("T31",
        "(Dispatch Alert - part 1 of 1) RC:Run# 48205/1-Emergency-Life Threat/262 CANDLEBERRY CIR///HOT SPRINGS/71913/You are responding to a patient with breathing problems.  The patient is a  68-year-old female/who is conscious and breathing. Not alert.\r\n" +
        "\r\n",

        "ID:48205",
        "PRI:1",
        "CALL:Emergency-Life Threat",
        "ADDR:262 CANDLEBERRY CIR",
        "CITY:HOT SPRINGS",
        "INFO:You are responding to a patient with breathing problems.  The patient is a  68-year-old female / who is conscious and breathing. Not alert.");

    doTest("T32",
        "(Dispatch Alert - part 1 of 1) RC:Run# 47978/2-Emergency-Non Life Threat/4425 MARION ANDERSON RD///HOT SPRINGS/71913/You are responding to a patient with specifically identified traumatic injuries.  The patient is a 60-year-old male/ who is conscious and breathing.  POSSIBLY DANGEROUS body area.  Traumatic Injuries (Specific).\r\n" +
        "\r\n",

        "ID:47978",
        "PRI:2",
        "CALL:Emergency-Non Life Threat",
        "ADDR:4425 MARION ANDERSON RD",
        "CITY:HOT SPRINGS",
        "INFO:You are responding to a patient with specifically identified traumatic injuries.  The patient is a 60-year-old male / who is conscious and breathing.  POSSIBLY DANGEROUS body area.  Traumatic Injuries (Specific).");

    doTest("T33",
        "(Dispatch Alert - part 1 of 1) RC:Run# 47832/1-Emergency-Life Threat/1119 ROCK CREEK RD///HOT SPRINGS/71913/You are responding to a patient who has apparently suffered a stroke.  The patient  is a 79-year-old male/ who is conscious and breathing. Sudden loss of  balance or coordination  (Partial evidence of stroke (Unknown hours)).  Stroke (CVA) / Transient Ischemic Attack (TIA).\r\n" +
        "\r\n",

        "ID:47832",
        "PRI:1",
        "CALL:Emergency-Life Threat",
        "ADDR:1119 ROCK CREEK RD",
        "CITY:HOT SPRINGS",
        "INFO:You are responding to a patient who has apparently suffered a stroke.  The patient  is a 79-year-old male / who is conscious and breathing. Sudden loss of  balance or coordination  (Partial evidence of stroke (Unknown hours)).  Stroke (CVA) / Transient Ischemic Attack (TIA).");

    doTest("T34",
        "(Dispatch Alert - part 1 of 1) RC:Run# 47801/1-Emergency-Life Threat/393 RYAN RD///PEARCY/71964/You are responding to a patient with breathing problems.  The patient is a  65-year-old female/ who is conscious and breathing. DIFFICULTY  SPEAKING BETWEEN BREATHS.\r\n" +
        "\r\n",

        "ID:47801",
        "PRI:1",
        "CALL:Emergency-Life Threat",
        "ADDR:393 RYAN RD",
        "CITY:PEARCY",
        "INFO:You are responding to a patient with breathing problems.  The patient is a  65-year-old female / who is conscious and breathing. DIFFICULTY  SPEAKING BETWEEN BREATHS.");

    doTest("T35",
        "(Dispatch Alert - part 1 of 1) RC:Run# 47782/1-Emergency-Life Threat/165 WAMPUM CIR///HOT SPRINGS/71913/You are responding to a patient with breathing problems.  The patient is a  4-month-old female/ who is conscious and whose breathing is  unknown. CHANGING COLOR.\r\n" +
        "\r\n",

        "ID:47782",
        "PRI:1",
        "CALL:Emergency-Life Threat",
        "ADDR:165 WAMPUM CIR",
        "CITY:HOT SPRINGS",
        "INFO:You are responding to a patient with breathing problems.  The patient is a  4-month-old female / who is conscious and whose breathing is  unknown. CHANGING COLOR.");

    doTest("T36",
        "(Dispatch Alert - part 1 of 1) RC:Run# 47782/1-Emergency-Life Threat/165 WAMPUM CIR///HOT SPRINGS/71913/You are responding to a patient who is apparently choking.  The patient is a  4-month-old female/ whois conscious and whose breathing is  unknown. Abnormal breathing (PARTIAL obstruction).\r\n" +
        "\r\n",

        "ID:47782",
        "PRI:1",
        "CALL:Emergency-Life Threat",
        "ADDR:165 WAMPUM CIR",
        "CITY:HOT SPRINGS",
        "INFO:You are responding to a patient who is apparently choking.  The patient is a  4-month-old female / whois conscious and whose breathing is  unknown. Abnormal breathing (PARTIAL obstruction).");

    doTest("T37",
        "(Dispatch Alert - part 1 of 1) RC:Run# 47727/2-Emergency-Non Life Threat/WESTWEGO TER & AIRPORT RD///PEARCY/71964/You are responding to a patient injured in a traffic incident.  The patient is of  unknownage and gender/ whose consciousness and breathing is  unknown. Injuries.  Traffic / Transportation Incidents.\r\n" +
        "\r\n",

        "ID:47727",
        "PRI:2",
        "CALL:Emergency-Non Life Threat",
        "ADDR:WESTWEGO TER & AIRPORT RD",  // Google says this is in Lake Hamilton
        "CITY:PEARCY",
        "INFO:You are responding to a patient injured in a traffic incident.  The patient is of  unknownage and gender / whose consciousness and breathing is  unknown. Injuries.  Traffic / Transportation Incidents.");

    doTest("T38",
        "(Dispatch Alert - part 1 of 1) RC:Run# 47613/1-Emergency-Life Threat/S MOORE RD & RUSHFORK RD///HOT SPRINGS/71913/<PROQA_SCRIPT>\r\n" +
        "\r\n",

        "ID:47613",
        "PRI:1",
        "CALL:Emergency-Life Threat",
        "ADDR:S MOORE RD & RUSHFORK RD",
        "CITY:HOT SPRINGS");

    doTest("T39",
        "(Dispatch Alert - part 1 of 1) RC:Run# 47610/3-Immediate/198 BRIARRIDGE CT///HOT SPRINGS/71913/<PROQA_SCRIPT>\r\n\r\n",
        "ID:47610",
        "PRI:3",
        "CALL:Immediate",
        "ADDR:198 BRIARRIDGE CT",
        "CITY:HOT SPRINGS");

    doTest("T40",
        "(Dispatch Alert - part 1 of 1) RC:Run# 47577/3-Immediate/1549 PEARCY RD///PEARCY/71964/<PROQA_SCRIPT>\r\n\r\n",
        "ID:47577",
        "PRI:3",
        "CALL:Immediate",
        "ADDR:1549 PEARCY RD",
        "CITY:PEARCY");

    doTest("T41",
        "(Dispatch Alert - part 1 of 1) RC:Run# 47391/1-Emergency-Life Threat/120 PITTMAN RD///HOT SPRINGS/71913/You are responding to a patient who is unconscious (or has fainted).  The patient  is a 85-year-old female/ who is unconscious and breathing.  Unconscious -- AGONAL/INEFFECTIVE BREATHING.  Unconscious / Fainting (Near).\r\n" +
        "\r\n",

        "ID:47391",
        "PRI:1",
        "CALL:Emergency-Life Threat",
        "ADDR:120 PITTMAN RD",
        "CITY:HOT SPRINGS",
        "INFO:You are responding to a patient who is unconscious (or has fainted).  The patient  is a 85-year-old female / who is unconscious and breathing.  Unconscious -- AGONAL / INEFFECTIVE BREATHING.  Unconscious / Fainting (Near).");

    doTest("T42",
        "(Dispatch Alert - part 1 of 1) RC:Run# 47384/3-Immediate/212 ELYSIAN HILLS DR///HOT SPRINGS/71913/<PROQA_SCRIPT>\r\n\r\n",
        "ID:47384",
        "PRI:3",
        "CALL:Immediate",
        "ADDR:212 ELYSIAN HILLS DR",
        "CITY:HOT SPRINGS");

    doTest("T43",
        "(Dispatch Alert - part 1 of 1) RC:Run# 47183/3-Immediate/3340 AIRPORT RD///PEARCY/71964/<PROQA_SCRIPT>\r\n\r\n",
        "ID:47183",
        "PRI:3",
        "CALL:Immediate",
        "ADDR:3340 AIRPORT RD",
        "CITY:PEARCY");

    doTest("T44",
        "(Dispatch Alert - part 1 of 1) RC:Run# 47116/3-Immediate/8 STONEGATE PT///HOT SPRINGS/71913/<PROQA_SCRIPT>\r\n\r\n",
        "ID:47116",
        "PRI:3",
        "CALL:Immediate",
        "ADDR:8 STONEGATE PT",
        "CITY:HOT SPRINGS");

    doTest("T45",
        "(Dispatch Alert - part 1 of 1) RC:Run# 47093/3-Immediate/633 ALLISON ST///PEARCY/71964/<PROQA_SCRIPT>\r\n\r\n",
        "ID:47093",
        "PRI:3",
        "CALL:Immediate",
        "ADDR:633 ALLISON ST",
        "CITY:PEARCY");

    doTest("T46",
        "(Dispatch Alert - part 1 of 1) RC:Run# 47049/3-Immediate/300 ALLISON ST///PEARCY/71964/<PROQA_SCRIPT>\r\n\r\n",
        "ID:47049",
        "PRI:3",
        "CALL:Immediate",
        "ADDR:300 ALLISON ST",
        "CITY:PEARCY");

    doTest("T47",
        "(Dispatch Alert - part 1 of 1) RC:Run# 46858/1-Emergency-Life Threat/174 JOELLA DR///PEARCY/71964/You are responding to a patient who is sick (or has a current medical condition).  The patient is a 78-year-old male/ who is conscious and breathing. Not  alert.  Sick Person (Specific Diagnosis).\r\n" +
        "\r\n",

        "ID:46858",
        "PRI:1",
        "CALL:Emergency-Life Threat",
        "ADDR:174 JOELLA DR",
        "CITY:PEARCY",
        "INFO:You are responding to a patient who is sick (or has a current medical condition).  The patient is a 78-year-old male / who is conscious and breathing. Not  alert.  Sick Person (Specific Diagnosis).");

    doTest("T48",
        "(Dispatch Alert - part 1 of 1) RC:Run# 46758/1-Emergency-Life Threat/LOST CREEK RD & CONNELLY RD///PEARCY/71964/\r\n\r\n",
        "ID:46758",
        "PRI:1",
        "CALL:Emergency-Life Threat",
        "ADDR:LOST CREEK RD & CONNELLY RD",
        "CITY:PEARCY");

  }
  
  public static void main(String[] args) {
    new ARGarlandCountyParserTest().generateTests("T1");
  }
}