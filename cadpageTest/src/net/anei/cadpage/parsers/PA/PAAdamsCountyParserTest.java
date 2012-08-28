package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class PAAdamsCountyParserTest extends BaseParserTest {
  
  public PAAdamsCountyParserTest() {
    setParser(new PAAdamsCountyParser(), "ADAMS COUNTY", "PA");
  }
  
  @Test
  public void testTimTyler() {

    doTest("T1",
        "Subject:Alert: Traffic Accident - 1\nALRM LVL: 1\nLOC:\n274 HANOVER ST\nOXFORD TWP\nBTWN: COMMERCE ST & TROUT LN",
        "CALL:Traffic Accident - 1",
        "PRI:1",
        "ADDR:274 HANOVER ST",
        "CITY:OXFORD TWP",
        "X:COMMERCE ST & TROUT LN");

    doTest("T2",
        "Subject:Alert: Fire - Residential\nALRM LVL: 1\nLOC:\n80 HUNTER CIR\nHAMILTON TWP\nBTWN: FOX DEN LN & FOX MEADOW",
        "CALL:Fire - Residential",
        "PRI:1",
        "ADDR:80 HUNTER CIR",
        "CITY:HAMILTON TWP",
        "X:FOX DEN LN & FOX MEADOW");

    doTest("T3",
        "Subject:Alert: Diabetic Emergency - 1\nALRM LVL: 1\nLOC:\nLINCOLNWAY W/TRACY AVE\nNEW OXFORD BORO\nBTWN: TRACY AVE & KOHLER MILL RD",
        "CALL:Diabetic Emergency - 1",
        "PRI:1",
        "ADDR:LINCOLNWAY W & TRACY AVE",
        "CITY:NEW OXFORD",
        "X:TRACY AVE & KOHLER MILL RD");

    doTest("T4",
        "Subject:Alert: Traffic Accident - 2\nALRM LVL: 1\nLOC:\nYORK RD/FLESHMAN MILL RD\nMOUNT PLEASANT TWP\nBTWN: FLESHMAN MILL RD",
        "CALL:Traffic Accident - 2",
        "PRI:1",
        "ADDR:YORK RD & FLESHMAN MILL RD",
        "CITY:MOUNT PLEASANT TWP",
        "X:FLESHMAN MILL RD");

    doTest("T5",
        "Subject:Alert: Fire - Residential\nALRM LVL: 1\nLOC:\n2315 HUNTERSTOWN-HAMPTON RD\nSTRABAN TWP\nBTWN: ALLEY & CONEWAGO RD",
        "CALL:Fire - Residential",
        "PRI:1",
        "ADDR:2315 HUNTERSTOWN-HAMPTON RD",
        "CITY:STRABAN TWP",
        "X:ALLEY & CONEWAGO RD");

    doTest("T6",
        "Subject:Alert: Traffic Accident - 2\nALRM LVL: 1\nLOC:\n760 NEW CHESTER RD\nSTRABAN TWP\nBTWN: SWIFT RUN RD & BRICKCRAFTERS RD",
        "CALL:Traffic Accident - 2",
        "PRI:1",
        "ADDR:760 NEW CHESTER RD",
        "CITY:STRABAN TWP",
        "X:SWIFT RUN RD & BRICKCRAFTERS RD");

  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "(Alert: Sick Person - 3) ALRM LVL: 1\n" +
        "LOC:\n" +
        "20 RINGNECK TRL\n" +
        "CARROLL VALLEY BORO\n" +
        "BTWN: WINTER TRL & FINCH TRL\n\n\n\n" +
        "COM:\n" +
        "HANG UP BEFORE ANSWER\n" +
        "77-year-old, female, conscious, breathing.\n" +
        "She is completely alert (responding appropriately).\n" +
        "She is breathing normally.\n" +
        "She does not have any pain.\n" +
        "She is not bleeding (or vomiting blood).\n" +
        "She is unwell/ill.\n" +
        "Determinant: 26A10, Suffix: , Response: Class 3\n" +
        "77-year-old, female, conscious, breathing.   Code: 26-A-10: Unwell/ill\n" +
        "She is completely alert (responding appropriately).\n" +
        "She is breathing normally.\n" +
        "She does not have any pain.\n" +
        "She is not bleeding (or vomiting blood).\n" +
        "She is unwell/ill.\n\n" +
        "CT:\n" +
        "NBCOOK at POS 04",

        "CALL:Sick Person - 3",
        "PRI:1",
        "ADDR:20 RINGNECK TRL",
        "CITY:CARROLL VALLEY",
        "X:WINTER TRL & FINCH TRL",
        "INFO:HANG UP BEFORE ANSWER\n77-year-old, female, conscious, breathing.\nShe is completely alert (responding appropriately).\nShe is breathing normally.\nShe does not have any pain.\nShe is not bleeding (or vomiting blood).\nShe is unwell/ill.\nDeterminant: 26A10, Suffix: , Response: Class 3\n77-year-old, female, conscious, breathing.   Code: 26-A-10: Unwell/ill\nShe is completely alert (responding appropriately).\nShe is breathing normally.\nShe does not have any pain.\nShe is not bleeding (or vomiting blood).\nShe is unwell/ill.\nNBCOOK at POS 04");

    doTest("T2",
        "(Alert: Sick Person - 3) ALRM LVL: 1\n" +
        "LOC:\n" +
        "24 DEEP POWDER TRL\n" +
        "B\n" +
        "CARROLL VALLEY BORO\n" +
        "BTWN: SNOW BIRD TRL & SUNFISH TRL\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "21-year-old, female, conscious, breathing.\n" +
        "She is completely alert (responding appropriately).\n" +
        "She is breathing normally.\n" +
        "She has other pain: MOUTH\n" +
        "She is not bleeding (or vomiting blood).\n" +
        "No priority symptoms (ALPHA conditions 2<128,147>11 not identified).\n" +
        "No priority symptoms (OMEGA conditions 2<128,147>28 not identified).\n" +
        "PROQA Comment: MOUTH\n" +
        "Determinant: 26A01, Suffix: , Response: Class 3\n" +
        "21-year-old, female, conscious, breathing.   Code: 26-A-1: No priority symptoms (complaint conditions 2€“11 not identified)\n" +
        "She is completely alert (responding appropriately).\n" +
        "She is breathing normally.\n" +
        "She has other pain: MOUTH\n" +
        "She is not bleeding (or vomiting blood).\n" +
        "No priority symptoms (ALPHA conditions 2<128,147>11 not identified).\n" +
        "No priority symptoms (OMEGA conditions 2<128,147>28 not identified).\n" +
        "PROQA Comment: MOUTH\n\n" +
        "CT:\n" +
        "MDGROF at POS 03",

        "CALL:Sick Person - 3",
        "PRI:1",
        "ADDR:24 DEEP POWDER TRL",
        "APT:B",
        "CITY:CARROLL VALLEY",
        "X:SNOW BIRD TRL & SUNFISH TRL",
        "INFO:21-year-old, female, conscious, breathing.\nShe is completely alert (responding appropriately).\nShe is breathing normally.\nShe has other pain: MOUTH\nShe is not bleeding (or vomiting blood).\nNo priority symptoms (ALPHA conditions 2<128,147>11 not identified).\nNo priority symptoms (OMEGA conditions 2<128,147>28 not identified).\nPROQA Comment: MOUTH\nDeterminant: 26A01, Suffix: , Response: Class 3\n21-year-old, female, conscious, breathing.   Code: 26-A-1: No priority symptoms (complaint conditions 2€“11 not identified)\nShe is completely alert (responding appropriately).\nShe is breathing normally.\nShe has other pain: MOUTH\nShe is not bleeding (or vomiting blood).\nNo priority symptoms (ALPHA conditions 2<128,147>11 not identified).\nNo priority symptoms (OMEGA conditions 2<128,147>28 not identified).\nPROQA Comment: MOUTH\nMDGROF at POS 03");

    doTest("T3",
        "(Alert: Breathing Problems - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "DOLLAR GENERAL-FAIRFIELD\n" +
        "4910 FAIRFIELD RD\n" +
        "HAMILTONBAN TWP\n" +
        "BTWN: IRON SPRINGS RD & MCGLAUGHLIN LN\n\n\n\n" +
        "COM:\n" +
        "WHT LIMO\n" +
        "47-year-old, male, conscious, breathing.\n" +
        "He is completely alert (responding appropriately).\n" +
        "He does not have any difficulty speaking between breaths.\n" +
        "He is not changing color.\n" +
        "It''s not known if he is clammy.\n" +
        "He does not have asthma.\n" +
        "N/A\n" +
        "Determinant: 06C01, Suffix: , Response: Class 1\n" +
        "47-year-old, male, conscious, breathing.   Code: 6-C-1: Abnormal breathing\n" +
        "He is completely alert (responding appropriately).\n" +
        "He does not have any difficulty speaking between breaths.\n" +
        "He is not changing color.\n" +
        "It''s not known if he is clammy.\n" +
        "He does not have asthma.\n" +
        "N/A\n\n" +
        "CT:\n" +
        "PLPETR at POS 04",

        "CALL:Breathing Problems - 1",
        "PRI:1",
        "PLACE:DOLLAR GENERAL-FAIRFIELD",
        "ADDR:4910 FAIRFIELD RD",
        "CITY:HAMILTONBAN TWP",
        "X:IRON SPRINGS RD & MCGLAUGHLIN LN",
        "INFO:WHT LIMO\n47-year-old, male, conscious, breathing.\nHe is completely alert (responding appropriately).\nHe does not have any difficulty speaking between breaths.\nHe is not changing color.\nIt''s not known if he is clammy.\nHe does not have asthma.\nN/A\nDeterminant: 06C01, Suffix: , Response: Class 1\n47-year-old, male, conscious, breathing.   Code: 6-C-1: Abnormal breathing\nHe is completely alert (responding appropriately).\nHe does not have any difficulty speaking between breaths.\nHe is not changing color.\nIt''s not known if he is clammy.\nHe does not have asthma.\nN/A\nPLPETR at POS 04");

    doTest("T4",
        "(Alert: Heart Problems - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "7 HILLTOP TRL\n" +
        "CARROLL VALLEY BORO\n" +
        "BTWN: FAIRFIELD RD & CROSS TRL\n\n\n\n" +
        "COM:\n" +
        "60-year-old, male, conscious, breathing.\n" +
        "He is not completely alert (not responding appropriately).\n" +
        "He is not breathing normally.\n" +
        "He has difficulty speaking between breaths.\n" +
        "Determinant: 19D01, Suffix: , Response: Class 1\n" +
        "He is not completely alert (not responding appropriately).\n" +
        "He is not breathing normally.\n" +
        "He has difficulty speaking between breaths.\n" +
        "He is changing color.\n" +
        "His color change is pale.\n" +
        "He is clammy.\n" +
        "He has a history of heart problems: STENTS CARDIAC\n" +
        "He does not have chest pain.\n" +
        "He took a prescribed medication in the past 12 hrs: NEW PILLS AND 1 NITRO\n" +
        "The caller was unable to reach the patient to check the pulse rate.\n" +
        "The caller tried but was unable to determine his pulse rate.\n" +
        "60-year-old, male, conscious, breathing.   Code: 19-D-1: Not alert\n" +
        "He is not completely alert (not responding appropriately).\n" +
        "He is not breathing normally.\n" +
        "He has difficulty speaking between breaths.\n" +
        "He is changing color.\n" +
        "His color change is pale.\n" +
        "He is clammy.\n" +
        "He has a history of heart problems: STENTS CARDIAC\n" +
        "He does not have chest pain.\n" +
        "He took a prescribed medication in the past 12 hrs: NEW PILLS AND 1 NITRO\n" +
        "The caller was unable to reach the patient to check the pulse rate.\n" +
        "The caller tried but was unable to determine his pulse rate.\n" +
        "PROQA Comment: STENTS CARDIAC\n" +
        "PROQA Comment: NEW PILLS AND 1 NITRO\n\n" +
        "CT:\n" +
        "TATYLE at POS 04",

        "CALL:Heart Problems - 1",
        "PRI:1",
        "ADDR:7 HILLTOP TRL",
        "CITY:CARROLL VALLEY",
        "X:FAIRFIELD RD & CROSS TRL",
        "INFO:60-year-old, male, conscious, breathing.\nHe is not completely alert (not responding appropriately).\nHe is not breathing normally.\nHe has difficulty speaking between breaths.\nDeterminant: 19D01, Suffix: , Response: Class 1\nHe is not completely alert (not responding appropriately).\nHe is not breathing normally.\nHe has difficulty speaking between breaths.\nHe is changing color.\nHis color change is pale.\nHe is clammy.\nHe has a history of heart problems: STENTS CARDIAC\nHe does not have chest pain.\nHe took a prescribed medication in the past 12 hrs: NEW PILLS AND 1 NITRO\nThe caller was unable to reach the patient to check the pulse rate.\nThe caller tried but was unable to determine his pulse rate.\n60-year-old, male, conscious, breathing.   Code: 19-D-1: Not alert\nHe is not completely alert (not responding appropriately).\nHe is not breathing normally.\nHe has difficulty speaking between breaths.\nHe is changing color.\nHis color change is pale.\nHe is clammy.\nHe has a history of heart problems: STENTS CARDIAC\nHe does not have chest pain.\nHe took a prescribed medication in the past 12 hrs: NEW PILLS AND 1 NITRO\nThe caller was unable to reach the patient to check the pulse rate.\nThe caller tried but was unable to determine his pulse rate.\nPROQA Comment: STENTS CARDIAC\nPROQA Comment: NEW PILLS AND 1 NITRO\nTATYLE at POS 04");

    doTest("T5",
        "(Alert: Diabetic Emergency - 3) ALRM LVL: 1\n" +
        "LOC:\n" +
        "62 WEIKERT RD\n" +
        "HIGHLAND TWP\n" +
        "BTWN: FAIRFIELD RD & STOOPS RD\n\n\n\n" +
        "COM:\n" +
        "85-year-old, female, conscious, breathing.\n" +
        "She is completely alert (responding appropriately).\n" +
        "She is behaving normally now.\n" +
        "She is breathing normally.\n" +
        "Determinant: 13A01, Suffix: , Response: Class 3\n" +
        "85-year-old, female, conscious, breathing.   Code: 13-A-1: Alert and behaving normally\n" +
        "She is completely alert (responding appropriately).\n" +
        "She is behaving normally now.\n" +
        "She is breathing normally.\n\n" +
        "CT:\n" +
        "KEWHIT at POS 04",

        "CALL:Diabetic Emergency - 3",
        "PRI:1",
        "ADDR:62 WEIKERT RD",
        "CITY:HIGHLAND TWP",
        "X:FAIRFIELD RD & STOOPS RD",
        "INFO:85-year-old, female, conscious, breathing.\nShe is completely alert (responding appropriately).\nShe is behaving normally now.\nShe is breathing normally.\nDeterminant: 13A01, Suffix: , Response: Class 3\n85-year-old, female, conscious, breathing.   Code: 13-A-1: Alert and behaving normally\nShe is completely alert (responding appropriately).\nShe is behaving normally now.\nShe is breathing normally.\nKEWHIT at POS 04");

    doTest("T6",
        "(Alert: Traffic Accident - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "1 MEADOW TRL\n" +
        "CARROLL VALLEY BORO\n" +
        "BTWN: VALLEY VIEW TRL & END\n\n\n\n" +
        "COM:\n\n\n" +
        "CT:\n" +
        "KEWHIT at POS 04",

        "CALL:Traffic Accident - 1",
        "PRI:1",
        "ADDR:1 MEADOW TRL",
        "CITY:CARROLL VALLEY",
        "X:VALLEY VIEW TRL & END",
        "INFO:KEWHIT at POS 04");

    doTest("T7",
        "(Alert: Traumatic Injury - 3) ALRM LVL: 1\n" +
        "LOC:\n" +
        "13 NOVICE RUN TRL\n" +
        "CARROLL VALLEY BORO\n" +
        "BTWN: SNOW BIRD TRL & END\n\n" +
        "RCVD AS Officer Initiated\n\n" +
        "COM:\n\n\n" +
        "CT:\n" +
        "TATYLE at POS 03",

        "CALL:Traumatic Injury - 3",
        "PRI:1",
        "ADDR:13 NOVICE RUN TRL",
        "CITY:CARROLL VALLEY",
        "X:SNOW BIRD TRL & END",
        "INFO:TATYLE at POS 03");

    doTest("T8",
        "(Alert: Psych / Suicide - 2) ALRM LVL: 1\n" +
        "LOC:\n" +
        "HILLSIDE REST HOME\n" +
        "1175 OLD WAYNESBORO RD\n" +
        "HAMILTONBAN TWP\n" +
        "BTWN: TUNNEL LN & LILAC LN\n\n\n\n" +
        "COM:\n" +
        "61-year-old, male, conscious, breathing.\n" +
        "He is not violent.\n" +
        "He does not have a weapon.\n" +
        "The patient is inside the same structure.\n" +
        "This is not a suicide attempt.\n" +
        "It''s not known if he is thinking about committing suicide.\n" +
        "He is completely alert (responding appropriately).\n" +
        "Determinant: 25B06, Suffix: , Response: Class 2\n" +
        "61-year-old, male, conscious, breathing.   Code: 25-B-6: Unknown status/Other codes not applicable\n" +
        "He is not violent.\n" +
        "He does not have a weapon.\n" +
        "The patient is inside the same structure.\n" +
        "This is not a suicide attempt.\n" +
        "It''s not known if he is thinking about committing suicide.\n" +
        "He is completely alert (responding appropriately).\n\n" +
        "CT:\n" +
        "JLSHEN at POS 04",

        "CALL:Psych / Suicide - 2",
        "PRI:1",
        "PLACE:HILLSIDE REST HOME",
        "ADDR:1175 OLD WAYNESBORO RD",
        "CITY:HAMILTONBAN TWP",
        "X:TUNNEL LN & LILAC LN",
        "INFO:61-year-old, male, conscious, breathing.\nHe is not violent.\nHe does not have a weapon.\nThe patient is inside the same structure.\nThis is not a suicide attempt.\nIt''s not known if he is thinking about committing suicide.\nHe is completely alert (responding appropriately).\nDeterminant: 25B06, Suffix: , Response: Class 2\n61-year-old, male, conscious, breathing.   Code: 25-B-6: Unknown status/Other codes not applicable\nHe is not violent.\nHe does not have a weapon.\nThe patient is inside the same structure.\nThis is not a suicide attempt.\nIt''s not known if he is thinking about committing suicide.\nHe is completely alert (responding appropriately).\nJLSHEN at POS 04");

    doTest("T9",
        "(Alert: Hemorrhage / Laceration - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "15 WATER ST\n" +
        "FAIRFIELD BORO\n" +
        "BTWN: WORTZ DR & POLLY DR\n\n\n\n" +
        "COM:\n" +
        "21-year-old, female, conscious, breathing.\n" +
        "The cause of the bleeding is traumatic.\n" +
        "The bleeding is from a DANGEROUS area.\n" +
        "She is completely alert (responding appropriately).\n" +
        "She is breathing normally.\n" +
        "There is no blood spurting or pouring out.\n" +
        "Determinant: 21D03, Suffix: , Response: Class 1\n" +
        "The cause of the bleeding is traumatic.\n" +
        "The bleeding is from a DANGEROUS area.\n" +
        "She is completely alert (responding appropriately).\n" +
        "She is breathing normally.\n" +
        "There is no blood spurting or pouring out.\n" +
        "She has a bleeding disorder.\n" +
        "21-year-old, female, conscious, breathing.   Code: 21-D-3: DANGEROUS hemorrhage\n" +
        "The cause of the bleeding is traumatic.\n" +
        "The bleeding is from a DANGEROUS area.\n" +
        "She is completely alert (responding appropriately).\n" +
        "She is breathing normally.\n" +
        "There is no blood spurting or pouring out.\n" +
        "She has a bleeding disorder.\n" +
        "2A-Switch Status-15 WATER ST, FAIRFIELD BORO\n" +
        "2A-Dispatched-15 WATER ST, FAIRFIELD BORO\n\n" +
        "CT:\n" +
        "JLSHEN at POS 04",

        "CALL:Hemorrhage / Laceration - 1",
        "PRI:1",
        "ADDR:15 WATER ST",
        "CITY:FAIRFIELD",
        "X:WORTZ DR & POLLY DR",
        "INFO:21-year-old, female, conscious, breathing.\nThe cause of the bleeding is traumatic.\nThe bleeding is from a DANGEROUS area.\nShe is completely alert (responding appropriately).\nShe is breathing normally.\nThere is no blood spurting or pouring out.\nDeterminant: 21D03, Suffix: , Response: Class 1\nThe cause of the bleeding is traumatic.\nThe bleeding is from a DANGEROUS area.\nShe is completely alert (responding appropriately).\nShe is breathing normally.\nThere is no blood spurting or pouring out.\nShe has a bleeding disorder.\n21-year-old, female, conscious, breathing.   Code: 21-D-3: DANGEROUS hemorrhage\nThe cause of the bleeding is traumatic.\nThe bleeding is from a DANGEROUS area.\nShe is completely alert (responding appropriately).\nShe is breathing normally.\nThere is no blood spurting or pouring out.\nShe has a bleeding disorder.\n2A-Switch Status-15 WATER ST, FAIRFIELD BORO\n2A-Dispatched-15 WATER ST, FAIRFIELD BORO\nJLSHEN at POS 04");

    doTest("T10",
        "(Alert: Psych / Suicide - 2) ALRM LVL: 1\n" +
        "LOC:\n" +
        "HILLSIDE REST HOME\n" +
        "1175 OLD WAYNESBORO RD\n" +
        "HAMILTONBAN TWP\n" +
        "BTWN: TUNNEL LN & LILAC LN\n\n\n\n" +
        "COM:\n" +
        "61-year-old, male, conscious, breathing.\n" +
        "He is not violent.\n" +
        "He does not have a weapon.\n" +
        "The patient is inside the same structure.\n" +
        "This is not a suicide attempt.\n" +
        "It''s not known if he is thinking about committing suicide.\n" +
        "He is completely alert (responding appropriately).\n" +
        "Determinant: 25B06, Suffix: , Response: Class 2\n" +
        "61-year-old, male, conscious, breathing.   Code: 25-B-6: Unknown status/Other codes not applicable\n" +
        "He is not violent.\n" +
        "He does not have a weapon.\n" +
        "The patient is inside the same structure.\n" +
        "This is not a suicide attempt.\n" +
        "It''s not known if he is thinking about committing suicide.\n" +
        "He is completely alert (responding appropriately).\n" +
        "2A-1-Switch Status-(HILLSIDE REST HOME) 1175 OLD WAYNESBORO RD, HAMILTONBAN TWP\n" +
        "2A-1-Dispatched-(HILLSIDE REST HOME) 1175 OLD WAYNESBORO RD, HAMILTONBAN TWP\n\n" +
        "CT:\n" +
        "JLSHEN at POS 04",

        "CALL:Psych / Suicide - 2",
        "PRI:1",
        "PLACE:HILLSIDE REST HOME",
        "ADDR:1175 OLD WAYNESBORO RD",
        "CITY:HAMILTONBAN TWP",
        "X:TUNNEL LN & LILAC LN",
        "INFO:61-year-old, male, conscious, breathing.\nHe is not violent.\nHe does not have a weapon.\nThe patient is inside the same structure.\nThis is not a suicide attempt.\nIt''s not known if he is thinking about committing suicide.\nHe is completely alert (responding appropriately).\nDeterminant: 25B06, Suffix: , Response: Class 2\n61-year-old, male, conscious, breathing.   Code: 25-B-6: Unknown status/Other codes not applicable\nHe is not violent.\nHe does not have a weapon.\nThe patient is inside the same structure.\nThis is not a suicide attempt.\nIt''s not known if he is thinking about committing suicide.\nHe is completely alert (responding appropriately).\n2A-1-Switch Status-(HILLSIDE REST HOME) 1175 OLD WAYNESBORO RD, HAMILTONBAN TWP\n2A-1-Dispatched-(HILLSIDE REST HOME) 1175 OLD WAYNESBORO RD, HAMILTONBAN TWP\nJLSHEN at POS 04");

    doTest("T11",
        "(Alert: Traffic Accident - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "608 POPLAR SPRINGS RD\n" +
        "FRANKLIN TWP\n" +
        "BTWN: RAGGED EDGE RD & ORCHARD RD\n\n\n\n" +
        "COM:\n" +
        "31-year-old, male, conscious, breathing.\n" +
        "The incident involves an all-terrain vehicle or snowmobile.\n" +
        "Determinant: 29D02, Suffix: k, Response: Class 1\n\n" +
        "CT:\n" +
        "MMSHAN at POS 01",

        "CALL:Traffic Accident - 1",
        "PRI:1",
        "ADDR:608 POPLAR SPRINGS RD",
        "CITY:FRANKLIN TWP",
        "X:RAGGED EDGE RD & ORCHARD RD",
        "INFO:31-year-old, male, conscious, breathing.\nThe incident involves an all-terrain vehicle or snowmobile.\nDeterminant: 29D02, Suffix: k, Response: Class 1\nMMSHAN at POS 01");

    doTest("T12",
        "(Alert: Traffic Accident - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "608 POPLAR SPRINGS RD\n" +
        "FRANKLIN TWP\n" +
        "BTWN: RAGGED EDGE RD & ORCHARD RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "31-year-old, male, conscious, breathing.\n" +
        "The incident involves an all-terrain vehicle or snowmobile.\n" +
        "Determinant: 29D02, Suffix: k, Response: Class 1\n" +
        "The incident involves an all-terrain vehicle or snowmobile.\n" +
        "Chemicals or other hazards are not involved.\n" +
        "There is no one pinned.\n" +
        "Everyone appears to be completely awake (alert).\n" +
        "His injuries are described as other than to a NOT DANGEROUS area.\n" +
        "There is SERIOUS bleeding.\n" +
        "31-year-old, male, conscious, breathing.   Code: 29-D-2-k: HIGH MECHANISM (k through s) (All-terrain/snowmobile)\n" +
        "The incident involves an all-terrain vehicle or snowmobile.\n" +
        "Chemicals or other hazards are not involved.\n" +
        "There is no one pinned.\n" +
        "Everyone appears to be completely awake (alert).\n" +
        "His injuries are described as other than to a NOT DANGEROUS area.\n" +
        "There is SERIOUS bleeding.\n" +
        "CH 4\n" +
        "LIFE NET ON STANBY 10 MIN FLIGHT TIME\n" +
        "ASST 4 REQUESTED 2ND BLS\n\n" +
        "CT:\n" +
        "JLSHEN at POS 01",

        "CALL:Traffic Accident - 1",
        "PRI:1",
        "ADDR:608 POPLAR SPRINGS RD",
        "CITY:FRANKLIN TWP",
        "X:RAGGED EDGE RD & ORCHARD RD",
        "INFO:31-year-old, male, conscious, breathing.\nThe incident involves an all-terrain vehicle or snowmobile.\nDeterminant: 29D02, Suffix: k, Response: Class 1\nThe incident involves an all-terrain vehicle or snowmobile.\nChemicals or other hazards are not involved.\nThere is no one pinned.\nEveryone appears to be completely awake (alert).\nHis injuries are described as other than to a NOT DANGEROUS area.\nThere is SERIOUS bleeding.\n31-year-old, male, conscious, breathing.   Code: 29-D-2-k: HIGH MECHANISM (k through s) (All-terrain/snowmobile)\nThe incident involves an all-terrain vehicle or snowmobile.\nChemicals or other hazards are not involved.\nThere is no one pinned.\nEveryone appears to be completely awake (alert).\nHis injuries are described as other than to a NOT DANGEROUS area.\nThere is SERIOUS bleeding.\nCH 4\nLIFE NET ON STANBY 10 MIN FLIGHT TIME\nASST 4 REQUESTED 2ND BLS\nJLSHEN at POS 01");

    doTest("T13",
        "(Alert: Breathing Problems - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "20 RINGNECK TRL\n" +
        "CARROLL VALLEY BORO\n" +
        "BTWN: WINTER TRL & FINCH TRL\n\n\n\n" +
        "COM:\n" +
        "75-year-old, female, conscious, breathing.\n" +
        "She is not completely alert (not responding appropriately).\n" +
        "She does not have any difficulty speaking between breaths.\n" +
        "Determinant: 06D01, Suffix: , Response: Class 1\n" +
        "She is not completely alert (not responding appropriately).\n" +
        "She does not have any difficulty speaking between breaths.\n" +
        "She is not changing color.\n" +
        "She is not clammy.\n" +
        "She does not have asthma.\n" +
        "She has special equipment or instructions to treat this.\n" +
        "The special equipment or instructions have been used.\n" +
        "75-year-old, female, conscious, breathing.   Code: 6-D-1: Not alert\n" +
        "She is not completely alert (not responding appropriately).\n" +
        "She does not have any difficulty speaking between breaths.\n" +
        "She is not changing color.\n" +
        "She is not clammy.\n" +
        "She does not have asthma.\n" +
        "She has special equipment or instructions to treat this.\n" +
        "The special equipment or instructions have been used.\n\n" +
        "CT:\n" +
        "LMBYER at POS 04",

        "CALL:Breathing Problems - 1",
        "PRI:1",
        "ADDR:20 RINGNECK TRL",
        "CITY:CARROLL VALLEY",
        "X:WINTER TRL & FINCH TRL",
        "INFO:75-year-old, female, conscious, breathing.\nShe is not completely alert (not responding appropriately).\nShe does not have any difficulty speaking between breaths.\nDeterminant: 06D01, Suffix: , Response: Class 1\nShe is not completely alert (not responding appropriately).\nShe does not have any difficulty speaking between breaths.\nShe is not changing color.\nShe is not clammy.\nShe does not have asthma.\nShe has special equipment or instructions to treat this.\nThe special equipment or instructions have been used.\n75-year-old, female, conscious, breathing.   Code: 6-D-1: Not alert\nShe is not completely alert (not responding appropriately).\nShe does not have any difficulty speaking between breaths.\nShe is not changing color.\nShe is not clammy.\nShe does not have asthma.\nShe has special equipment or instructions to treat this.\nThe special equipment or instructions have been used.\nLMBYER at POS 04");

    doTest("T14",
        "(Alert: Sick Person - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "215 OLD MILL RD\n" +
        "CUMBERLAND TWP\n" +
        "BTWN: LAKE VIEW DR & PARK AVE\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "64-year-old, female, conscious, breathing.\n" +
        "She is delirious.\n" +
        "She is breathing normally.\n" +
        "She has other pain: NECK AND SHOULDER\n" +
        "She is not bleeding (or vomiting blood).\n" +
        "PROQA Comment: NECK AND SHOULDER\n" +
        "Determinant: 26C01, Suffix: , Response: Class 1\n" +
        "She is delirious.\n" +
        "She is breathing normally.\n" +
        "She has other pain: NECK AND SHOULDER\n" +
        "She is not bleeding (or vomiting blood).\n" +
        "No priority symptoms (ALPHA conditions 2<128,147>11 not identified).\n" +
        "No priority symptoms (OMEGA conditions 2<128,147>28 not identified).\n" +
        "64-year-old, female, conscious, breathing.   Code: 26-C-1: ALTERED LEVEL OF CONSCIOUSNESS\n" +
        "She is delirious.\n" +
        "She is breathing normally.\n" +
        "She has other pain: NECK AND SHOULDER\n" +
        "She is not bleeding (or vomiting blood).\n" +
        "No priority symptoms (ALPHA conditions 2<128,147>11 not identified).\n" +
        "No priority symptoms (OMEGA conditions 2<128,147>28 not identified).\n" +
        "PROQA Comment: NECK AND SHOULDER\n\n" +
        "CT:\n" +
        "GABRET at POS 04",

        "CALL:Sick Person - 1",
        "PRI:1",
        "ADDR:215 OLD MILL RD",
        "CITY:CUMBERLAND TWP",
        "X:LAKE VIEW DR & PARK AVE",
        "INFO:64-year-old, female, conscious, breathing.\nShe is delirious.\nShe is breathing normally.\nShe has other pain: NECK AND SHOULDER\nShe is not bleeding (or vomiting blood).\nPROQA Comment: NECK AND SHOULDER\nDeterminant: 26C01, Suffix: , Response: Class 1\nShe is delirious.\nShe is breathing normally.\nShe has other pain: NECK AND SHOULDER\nShe is not bleeding (or vomiting blood).\nNo priority symptoms (ALPHA conditions 2<128,147>11 not identified).\nNo priority symptoms (OMEGA conditions 2<128,147>28 not identified).\n64-year-old, female, conscious, breathing.   Code: 26-C-1: ALTERED LEVEL OF CONSCIOUSNESS\nShe is delirious.\nShe is breathing normally.\nShe has other pain: NECK AND SHOULDER\nShe is not bleeding (or vomiting blood).\nNo priority symptoms (ALPHA conditions 2<128,147>11 not identified).\nNo priority symptoms (OMEGA conditions 2<128,147>28 not identified).\nPROQA Comment: NECK AND SHOULDER\nGABRET at POS 04");

    doTest("T15",
        "(Alert: Unconscious - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "ACNB BANK - FAIRFIELD\n" +
        "4910 FAIRFIELD RD\n" +
        "A\n" +
        "HAMILTONBAN TWP\n" +
        "BTWN: IRON SPRINGS RD & MCGLAUGHLIN LN\n\n\n\n" +
        "COM:\n" +
        "30-year-old, male, conscious, breathing.\n" +
        "His breathing is not completely normal.\n" +
        "He is not completely alert (not responding appropriately).\n" +
        "He is changing color.\n" +
        "His color change is purple.\n" +
        "Determinant: 31D03, Suffix: , Response: Class 1\n" +
        "PROQA has reconfigured the response\n" +
        "30-year-old, male, conscious, breathing.   Code: 31-D-4: CHANGING COLOR\n" +
        "His breathing is not completely normal.\n" +
        "He is not completely alert (not responding appropriately).\n" +
        "He is changing color.\n" +
        "His color change is purple.\n" +
        "It''s not known if he has a history of heart problems.\n" +
        "Reconfigured determinant: 31D04, Suffix: , Response: Class 1\n" +
        "30-year-old, male, conscious, breathing.   Code: 31-D-4: CHANGING COLOR\n" +
        "His breathing is not completely normal.\n" +
        "He is not completely alert (not responding appropriately).\n" +
        "He is changing color.\n" +
        "His color change is purple.\n" +
        "It''s not known if he has a history of heart problems.\n\n" +
        "CT:\n" +
        "GABRET at POS 04",

        "CALL:Unconscious - 1",
        "PRI:1",
        "PLACE:ACNB BANK - FAIRFIELD",
        "ADDR:4910 FAIRFIELD RD",
        "APT:A",
        "CITY:HAMILTONBAN TWP",
        "X:IRON SPRINGS RD & MCGLAUGHLIN LN",
        "INFO:30-year-old, male, conscious, breathing.\nHis breathing is not completely normal.\nHe is not completely alert (not responding appropriately).\nHe is changing color.\nHis color change is purple.\nDeterminant: 31D03, Suffix: , Response: Class 1\nPROQA has reconfigured the response\n30-year-old, male, conscious, breathing.   Code: 31-D-4: CHANGING COLOR\nHis breathing is not completely normal.\nHe is not completely alert (not responding appropriately).\nHe is changing color.\nHis color change is purple.\nIt''s not known if he has a history of heart problems.\nReconfigured determinant: 31D04, Suffix: , Response: Class 1\n30-year-old, male, conscious, breathing.   Code: 31-D-4: CHANGING COLOR\nHis breathing is not completely normal.\nHe is not completely alert (not responding appropriately).\nHe is changing color.\nHis color change is purple.\nIt''s not known if he has a history of heart problems.\nGABRET at POS 04");

    doTest("T16",
        "(Alert: Chest Pain - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "2006 COLD SPRINGS RD\n" +
        "HAMILTONBAN TWP\n" +
        "BTWN: DUG LN & MORITZ RD\n\n\n\n" +
        "COM:\n" +
        "14 YO MALE\n\n" +
        "CT:\n" +
        "WEHERR at POS 04",

        "CALL:Chest Pain - 1",
        "PRI:1",
        "ADDR:2006 COLD SPRINGS RD",
        "CITY:HAMILTONBAN TWP",
        "X:DUG LN & MORITZ RD",
        "INFO:14 YO MALE\nWEHERR at POS 04");

    doTest("T17",
        "(Alert: Chest Pain - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "2006 COLD SPRINGS RD\n" +
        "HAMILTONBAN TWP\n" +
        "BTWN: DUG LN & MORITZ RD\n\n\n\n" +
        "COM:\n" +
        "14 YO MALE\n" +
        "IS ALERT COMPLAINING OF CHEST PAIN AND A HIGH HEART RATE\n" +
        "IS BREATHING  NORMALLY IS NOT CHANGING COLOR\n" +
        "IS CLAMMY\n" +
        "PROQA Abort Text: WOULD NOT COME UP ON ORGINAL CALL EMD BY CARD\n\n" +
        "CT:\n" +
        "WEHERR at POS 04",

        "CALL:Chest Pain - 1",
        "PRI:1",
        "ADDR:2006 COLD SPRINGS RD",
        "CITY:HAMILTONBAN TWP",
        "X:DUG LN & MORITZ RD",
        "INFO:14 YO MALE\nIS ALERT COMPLAINING OF CHEST PAIN AND A HIGH HEART RATE\nIS BREATHING  NORMALLY IS NOT CHANGING COLOR\nIS CLAMMY\nPROQA Abort Text: WOULD NOT COME UP ON ORGINAL CALL EMD BY CARD\nWEHERR at POS 04");

    doTest("T18",
        "(Alert: Hemorrhage / Laceration - 2) ALRM LVL: 1\n" +
        "LOC:\n" +
        "HILLSIDE REST HOME\n" +
        "1175 OLD WAYNESBORO RD\n" +
        "HAMILTONBAN TWP\n" +
        "BTWN: TUNNEL LN & LILAC LN\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "83-year-old, male, conscious, breathing.\n" +
        "The cause of the bleeding is non-traumatic.\n" +
        "The bleeding is from a NOT DANGEROUS area.\n" +
        "He is completely alert (responding appropriately).\n" +
        "He is breathing normally.\n" +
        "There is SERIOUS bleeding.\n" +
        "He does not have a bleeding disorder or is taking blood thinners.\n" +
        "Determinant: 21B02, Suffix: , Response: Class 2\n" +
        "83-year-old, male, conscious, breathing.   Code: 21-B-2: SERIOUS hemorrhage\n" +
        "The cause of the bleeding is non-traumatic.\n" +
        "The bleeding is from a NOT DANGEROUS area.\n" +
        "He is completely alert (responding appropriately).\n" +
        "He is breathing normally.\n" +
        "There is SERIOUS bleeding.\n" +
        "He does not have a bleeding disorder or is taking blood thinners.\n\n" +
        "CT:\n" +
        "REEIKE at POS 03",

        "CALL:Hemorrhage / Laceration - 2",
        "PRI:1",
        "PLACE:HILLSIDE REST HOME",
        "ADDR:1175 OLD WAYNESBORO RD",
        "CITY:HAMILTONBAN TWP",
        "X:TUNNEL LN & LILAC LN",
        "INFO:83-year-old, male, conscious, breathing.\nThe cause of the bleeding is non-traumatic.\nThe bleeding is from a NOT DANGEROUS area.\nHe is completely alert (responding appropriately).\nHe is breathing normally.\nThere is SERIOUS bleeding.\nHe does not have a bleeding disorder or is taking blood thinners.\nDeterminant: 21B02, Suffix: , Response: Class 2\n83-year-old, male, conscious, breathing.   Code: 21-B-2: SERIOUS hemorrhage\nThe cause of the bleeding is non-traumatic.\nThe bleeding is from a NOT DANGEROUS area.\nHe is completely alert (responding appropriately).\nHe is breathing normally.\nThere is SERIOUS bleeding.\nHe does not have a bleeding disorder or is taking blood thinners.\nREEIKE at POS 03");

    doTest("T19",
        "(Alert: Chest Pain - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "3585 CHAMBERSBURG RD\n" +
        "FRANKLIN TWP\n" +
        "BTWN: FLOHRS CHURCH RD & HILLTOWN RD\n\n\n\n" +
        "COM:\n" +
        "18-year-old, female, conscious, breathing.\n" +
        "She is completely alert (responding appropriately).\n" +
        "She is not breathing normally.\n" +
        "She does not have any difficulty speaking between breaths.\n" +
        "She is clammy.\n" +
        "Determinant: 10D04, Suffix: , Response: Class 1\n" +
        "She is completely alert (responding appropriately).\n" +
        "She is not breathing normally.\n" +
        "She does not have any difficulty speaking between breaths.\n" +
        "She is clammy.\n" +
        "She has not had a heart attack or angina (heart pains) before.\n" +
        "She took a prescribed medication in the past 12 hrs: NORMAL MEDS\n" +
        "18-year-old, female, conscious, breathing.   Code: 10-D-4: Clammy\n" +
        "She is completely alert (responding appropriately).\n" +
        "She is not breathing normally.\n" +
        "She does not have any difficulty speaking between breaths.\n" +
        "She is clammy.\n" +
        "She has not had a heart attack or angina (heart pains) before.\n" +
        "She took a prescribed medication in the past 12 hrs: NORMAL MEDS\n" +
        "PROQA Comment: NORMAL MEDS\n\n" +
        "CT:\n" +
        "MDGROF at POS 04",

        "CALL:Chest Pain - 1",
        "PRI:1",
        "ADDR:3585 CHAMBERSBURG RD",
        "CITY:FRANKLIN TWP",
        "X:FLOHRS CHURCH RD & HILLTOWN RD",
        "INFO:18-year-old, female, conscious, breathing.\nShe is completely alert (responding appropriately).\nShe is not breathing normally.\nShe does not have any difficulty speaking between breaths.\nShe is clammy.\nDeterminant: 10D04, Suffix: , Response: Class 1\nShe is completely alert (responding appropriately).\nShe is not breathing normally.\nShe does not have any difficulty speaking between breaths.\nShe is clammy.\nShe has not had a heart attack or angina (heart pains) before.\nShe took a prescribed medication in the past 12 hrs: NORMAL MEDS\n18-year-old, female, conscious, breathing.   Code: 10-D-4: Clammy\nShe is completely alert (responding appropriately).\nShe is not breathing normally.\nShe does not have any difficulty speaking between breaths.\nShe is clammy.\nShe has not had a heart attack or angina (heart pains) before.\nShe took a prescribed medication in the past 12 hrs: NORMAL MEDS\nPROQA Comment: NORMAL MEDS\nMDGROF at POS 04");

    doTest("T20",
        "(Alert: Traffic Accident - 3) ALRM LVL: 1\n" +
        "LOC:\n" +
        "OLD ROUTE 30/ORRTANNA RD\n" +
        "FRANKLIN TWP\n" +
        "BTWN: ORRTANNA RD & HIGH ST\n\n\n\n" +
        "COM:\n" +
        "VEHICLE ACCIDENT\n" +
        "2 VEHICLES\n" +
        "UNKNOWN INJURIES\n" +
        "BOTH VEHICLES OFF THE ROADWAY\n\n" +
        "CT:\n" +
        "SNCROU at POS 01",

        "CALL:Traffic Accident - 3",
        "PRI:1",
        "ADDR:OLD ROUTE 30 & ORRTANNA RD",
        "CITY:FRANKLIN TWP",
        "X:ORRTANNA RD & HIGH ST",
        "INFO:VEHICLE ACCIDENT\n2 VEHICLES\nUNKNOWN INJURIES\nBOTH VEHICLES OFF THE ROADWAY\nSNCROU at POS 01");

    doTest("T21",
        "(Alert: Traumatic Injury - 3) ALRM LVL: 1\n" +
        "LOC:\n" +
        "JACKS MOUNTAIN RD/WAYNESBORO PIKE\n" +
        "HAMILTONBAN TWP\n" +
        "BTWN: OLD WAYNESBORO RD & WAYNESBORO PIKE\n\n\n\n" +
        "COM:\n\n\n" +
        "CT:\n" +
        "SNCROU at POS 04",

        "CALL:Traumatic Injury - 3",
        "PRI:1",
        "ADDR:JACKS MOUNTAIN RD & WAYNESBORO PIKE",
        "CITY:HAMILTONBAN TWP",
        "X:OLD WAYNESBORO RD & WAYNESBORO PIKE",
        "INFO:SNCROU at POS 04");

    doTest("T22",
        "(Alert: Unconscious - 3) ALRM LVL: 1\n" +
        "LOC:\n" +
        "329 HIGH ST\n" +
        "FRANKLIN TWP\n" +
        "BTWN: HILLTOWN RD & OLD ROUTE 30\n\n\n\n" +
        "COM:\n" +
        "10-year-old, female, conscious, breathing.\n" +
        "Her breathing is completely normal.\n" +
        "She is completely alert (responding appropriately).\n" +
        "She is not changing color.\n" +
        "She has no history of heart problems.\n" +
        "Determinant: 31A03, Suffix: , Response: Class 3\n" +
        "10-year-old, female, conscious, breathing.   Code: 31-A-3: Fainting episode(s) and alert < 35 (without cardiac history)\n" +
        "Her breathing is completely normal.\n" +
        "She is completely alert (responding appropriately).\n" +
        "She is not changing color.\n" +
        "She has no history of heart problems.\n\n" +
        "CT:\n" +
        "CAHAGE at POS 04",

        "CALL:Unconscious - 3",
        "PRI:1",
        "ADDR:329 HIGH ST",
        "CITY:FRANKLIN TWP",
        "X:HILLTOWN RD & OLD ROUTE 30",
        "INFO:10-year-old, female, conscious, breathing.\nHer breathing is completely normal.\nShe is completely alert (responding appropriately).\nShe is not changing color.\nShe has no history of heart problems.\nDeterminant: 31A03, Suffix: , Response: Class 3\n10-year-old, female, conscious, breathing.   Code: 31-A-3: Fainting episode(s) and alert < 35 (without cardiac history)\nHer breathing is completely normal.\nShe is completely alert (responding appropriately).\nShe is not changing color.\nShe has no history of heart problems.\nCAHAGE at POS 04");

    doTest("T23",
        "(Alert: Heart Problems - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "GRANITE HILL CAMPGROUND & ADVENTURE GOLF\n" +
        "3340 FAIRFIELD RD\n" +
        "HIGHLAND TWP\n" +
        "BTWN: CARR HILL RD & COLD SPRINGS RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "59-year-old, male, conscious, breathing.\n" +
        "He is completely alert (responding appropriately).\n" +
        "He is breathing normally.\n" +
        "He is not clammy.\n" +
        "He has a history of heart problems: 8 STINTS\n" +
        "He has chest pain.\n" +
        "He took a prescribed medication in the past 12 hrs: 3 NITRO PILLS TO RELIEVE CHEST PAINS\n" +
        "PROQA Comment: 8 STINTS\n" +
        "PROQA Comment: 3 NITRO PILLS TO RELIEVE CHEST PAINS\n" +
        "Determinant: 19C03, Suffix: , Response: Class 1\n" +
        "He is completely alert (responding appropriately).\n" +
        "He is breathing normally.\n" +
        "He is not clammy.\n" +
        "He has a history of heart problems: 8 STINTS\n" +
        "He has chest pain.\n" +
        "He took a prescribed medication in the past 12 hrs: 3 NITRO PILLS TO RELIEVE CHEST PAINS\n" +
        "Instructions for taking a pulse have been given.\n" +
        "His pulse is between 50 and 129 beats per minute.\n\n" +
        "CT:\n" +
        "REEIKE at POS 04",

        "CALL:Heart Problems - 1",
        "PRI:1",
        "PLACE:GRANITE HILL CAMPGROUND & ADVENTURE GOLF",
        "ADDR:3340 FAIRFIELD RD",
        "CITY:HIGHLAND TWP",
        "X:CARR HILL RD & COLD SPRINGS RD",
        "INFO:59-year-old, male, conscious, breathing.\nHe is completely alert (responding appropriately).\nHe is breathing normally.\nHe is not clammy.\nHe has a history of heart problems: 8 STINTS\nHe has chest pain.\nHe took a prescribed medication in the past 12 hrs: 3 NITRO PILLS TO RELIEVE CHEST PAINS\nPROQA Comment: 8 STINTS\nPROQA Comment: 3 NITRO PILLS TO RELIEVE CHEST PAINS\nDeterminant: 19C03, Suffix: , Response: Class 1\nHe is completely alert (responding appropriately).\nHe is breathing normally.\nHe is not clammy.\nHe has a history of heart problems: 8 STINTS\nHe has chest pain.\nHe took a prescribed medication in the past 12 hrs: 3 NITRO PILLS TO RELIEVE CHEST PAINS\nInstructions for taking a pulse have been given.\nHis pulse is between 50 and 129 beats per minute.\nREEIKE at POS 04");

    doTest("T24",
        "(Alert: Falls - 2) ALRM LVL: 1\n" +
        "LOC:\n" +
        "47 SNOW BIRD TRL\n" +
        "CARROLL VALLEY BORO\n" +
        "BTWN: NOVICE RUN TRL & END\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n\n\n" +
        "CT:\n" +
        "REEIKE at POS 04",

        "CALL:Falls - 2",
        "PRI:1",
        "ADDR:47 SNOW BIRD TRL",
        "CITY:CARROLL VALLEY",
        "X:NOVICE RUN TRL & END",
        "INFO:REEIKE at POS 04");

    doTest("T25",
        "(Alert: Falls - 2) ALRM LVL: 1\n" +
        "LOC:\n" +
        "205 CARROLLS TRACT RD\n" +
        "HAMILTONBAN TWP\n" +
        "BTWN: BULLFROG RD & SUGAR LOAF LN\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "EMD CALL\n" +
        "94-year-old, female, conscious, breathing.\n" +
        "This happened now (less than 6hrs ago).\n" +
        "It''s reported that she fell at ground level.\n" +
        "The fall was accidental.\n" +
        "There is no bleeding now.\n" +
        "She is completely alert (responding appropriately).\n" +
        "The injury is to the chest.\n" +
        "She is not having difficulty breathing.\n" +
        "She is no longer on the floor (ground).\n" +
        "Determinant: 17B01, Suffix: , Response: Class 2\n" +
        "94-year-old, female, conscious, breathing.   Code: 17-B-1: POSSIBLY DANGEROUS body area\n" +
        "This happened now (less than 6hrs ago).\n" +
        "It''s reported that she fell at ground level.\n" +
        "The fall was accidental.\n" +
        "There is no bleeding now.\n" +
        "She is completely alert (responding appropriately).\n" +
        "The injury is to the chest.\n" +
        "She is not having difficulty breathing.\n" +
        "She is no longer on the floor (ground).\n\n" +
        "CT:\n" +
        "TATYLE at POS 04",

        "CALL:Falls - 2",
        "PRI:1",
        "ADDR:205 CARROLLS TRACT RD",
        "CITY:HAMILTONBAN TWP",
        "X:BULLFROG RD & SUGAR LOAF LN",
        "INFO:EMD CALL\n94-year-old, female, conscious, breathing.\nThis happened now (less than 6hrs ago).\nIt''s reported that she fell at ground level.\nThe fall was accidental.\nThere is no bleeding now.\nShe is completely alert (responding appropriately).\nThe injury is to the chest.\nShe is not having difficulty breathing.\nShe is no longer on the floor (ground).\nDeterminant: 17B01, Suffix: , Response: Class 2\n94-year-old, female, conscious, breathing.   Code: 17-B-1: POSSIBLY DANGEROUS body area\nThis happened now (less than 6hrs ago).\nIt''s reported that she fell at ground level.\nThe fall was accidental.\nThere is no bleeding now.\nShe is completely alert (responding appropriately).\nThe injury is to the chest.\nShe is not having difficulty breathing.\nShe is no longer on the floor (ground).\nTATYLE at POS 04");

    doTest("T26",
        "(Alert: Traumatic Injury - 2) ALRM LVL: 1\n" +
        "LOC:\n" +
        "45 ORRTANNA RD\n" +
        "FRANKLIN TWP\n" +
        "BTWN: OLD ROUTE 30 & GREENFIELD LN\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "LOWER BACK AND HEAD INJURY\n\n" +
        "CT:\n" +
        "LRSORD at POS 04",

        "CALL:Traumatic Injury - 2",
        "PRI:1",
        "ADDR:45 ORRTANNA RD",
        "CITY:FRANKLIN TWP",
        "X:OLD ROUTE 30 & GREENFIELD LN",
        "INFO:LOWER BACK AND HEAD INJURY\nLRSORD at POS 04");

    doTest("T27",
        "(Alert: Traffic Accident - 2) ALRM LVL: 1\n" +
        "LOC:\n" +
        "GRANITE HILL CAMPGROUND & ADVENTURE GOLF\n" +
        "3340 FAIRFIELD RD\n" +
        "HIGHLAND TWP\n" +
        "BTWN: CARR HILL RD & COLD SPRINGS RD\n\n\n\n" +
        "COM:\n" +
        "3 CARS ONE PERSON STILL IN THE VEHICLE\n\n" +
        "CT:\n" +
        "KEDEHO at POS 04",

        "CALL:Traffic Accident - 2",
        "PRI:1",
        "PLACE:GRANITE HILL CAMPGROUND & ADVENTURE GOLF",
        "ADDR:3340 FAIRFIELD RD",
        "CITY:HIGHLAND TWP",
        "X:CARR HILL RD & COLD SPRINGS RD",
        "INFO:3 CARS ONE PERSON STILL IN THE VEHICLE\nKEDEHO at POS 04");

    doTest("T28",
        "(Alert: Convulsions - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "6475 FAIRFIELD RD\n" +
        "CARROLL VALLEY BORO\n" +
        "BTWN: STINE TRL & WAYNESBORO PIKE\n\n\n\n" +
        "COM:\n" +
        "19-year-old, female, conscious, breathing.\n" +
        "This is apparently a generalized (grand mal) seizure.\n" +
        "She has not had more than one seizure in a row.\n" +
        "She is not pregnant.\n" +
        "It''s not known if she is diabetic.\n" +
        "She is not an epileptic and has not had seizures before.\n" +
        "The jerking (twitching) has not stopped.\n" +
        "Determinant: 12D02, Suffix: , Response: Class 1\n\n" +
        "CT:\n" +
        "MDGROF at POS 03",

        "CALL:Convulsions - 1",
        "PRI:1",
        "ADDR:6475 FAIRFIELD RD",
        "CITY:CARROLL VALLEY",
        "X:STINE TRL & WAYNESBORO PIKE",
        "INFO:19-year-old, female, conscious, breathing.\nThis is apparently a generalized (grand mal) seizure.\nShe has not had more than one seizure in a row.\nShe is not pregnant.\nIt''s not known if she is diabetic.\nShe is not an epileptic and has not had seizures before.\nThe jerking (twitching) has not stopped.\nDeterminant: 12D02, Suffix: , Response: Class 1\nMDGROF at POS 03");

    doTest("T29",
        "(Alert: Traffic Accident - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "PNC BANK-ZORA\n" +
        "815 WAYNESBORO PIKE\n" +
        "CARROLL VALLEY BORO\n" +
        "BTWN: FAIRFIELD RD & AUTUMN TRL\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n\n\n" +
        "CT:\n" +
        "KNPARR at POS 04",

        "CALL:Traffic Accident - 1",
        "PRI:1",
        "PLACE:PNC BANK-ZORA",
        "ADDR:815 WAYNESBORO PIKE",
        "CITY:CARROLL VALLEY",
        "X:FAIRFIELD RD & AUTUMN TRL",
        "INFO:KNPARR at POS 04");

    doTest("T30",
        "(Alert: Traffic Accident - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "CHAMBERSBURG RD/HIGH ST\n" +
        "FRANKLIN TWP\n" +
        "BTWN: HIGH ST & SHORT CUT RD\n\n\n\n" +
        "COM:\n\n\n" +
        "CT:\n" +
        "KNPARR at POS 04",

        "CALL:Traffic Accident - 1",
        "PRI:1",
        "ADDR:CHAMBERSBURG RD & HIGH ST",
        "CITY:FRANKLIN TWP",
        "X:HIGH ST & SHORT CUT RD",
        "INFO:KNPARR at POS 04");

    doTest("T31",
        "(Alert: Alarm Fire - Residential) ALRM LVL: 1\n" +
        "LOC:\n" +
        "451 STOOPS RD\n" +
        "HIGHLAND TWP\n" +
        "BTWN: CAMP GETTYSBURG RD & WEIKERT RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "GEN FIRE ALARM\n\n" +
        "CT:\n" +
        "MDGROF at POS 04",

        "CALL:Alarm Fire - Residential",
        "PRI:1",
        "ADDR:451 STOOPS RD",
        "CITY:HIGHLAND TWP",
        "X:CAMP GETTYSBURG RD & WEIKERT RD",
        "INFO:GEN FIRE ALARM\nMDGROF at POS 04");

    doTest("T32",
        "(Alert: Unconscious - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "121 W MAIN ST\n" +
        "SECOND FLOOR\n" +
        "FAIRFIELD BORO\n" +
        "BTWN: SIXTH AVE & SEVENTH ST\n\n\n\n" +
        "COM:\n" +
        "50-year-old, female, not conscious, breathing.\n" +
        "Her breathing is not completely normal.\n" +
        "Her breathing is abnormal but effective.\n" +
        "She is still unconscious.\n" +
        "PROQA Comment: Rate  = 10 breaths per minute\n" +
        "PROQA Comment: Abnormal or Irregular*\n" +
        "Determinant: 31D02, Suffix: , Response: Class 1\n" +
        "50-year-old, female, not conscious, breathing.   Code: 31-D-2: Unconscious €“ Effective breathing\n" +
        "Her breathing is not completely normal.\n" +
        "Her breathing is abnormal but effective.\n" +
        "She is still unconscious.\n" +
        "PROQA Comment: Rate  = 10 breaths per minute\n" +
        "PROQA Comment: Abnormal or Irregular*\n" +
        "FOUND MOTHER IN BATHROOM UNCONSCIOUS\n" +
        "BUT BREATHING\n" +
        "UNKN HOW LONG SHE HAS BEEN UNCONSCIOUS\n\n" +
        "CT:\n" +
        "PAHAGE at POS 02",

        "CALL:Unconscious - 1",
        "PRI:1",
        "ADDR:121 W MAIN ST",
        "PLACE:SECOND FLOOR",
        "CITY:FAIRFIELD",
        "X:SIXTH AVE & SEVENTH ST",
        "INFO:50-year-old, female, not conscious, breathing.\nHer breathing is not completely normal.\nHer breathing is abnormal but effective.\nShe is still unconscious.\nPROQA Comment: Rate  = 10 breaths per minute\nPROQA Comment: Abnormal or Irregular*\nDeterminant: 31D02, Suffix: , Response: Class 1\n50-year-old, female, not conscious, breathing.   Code: 31-D-2: Unconscious €“ Effective breathing\nHer breathing is not completely normal.\nHer breathing is abnormal but effective.\nShe is still unconscious.\nPROQA Comment: Rate  = 10 breaths per minute\nPROQA Comment: Abnormal or Irregular*\nFOUND MOTHER IN BATHROOM UNCONSCIOUS\nBUT BREATHING\nUNKN HOW LONG SHE HAS BEEN UNCONSCIOUS\nPAHAGE at POS 02");

    doTest("T33",
        "(Alert: Sick Person - 3) ALRM LVL: 1\n" +
        "LOC:\n" +
        "932 ORCHARD RD\n" +
        "FRANKLIN TWP\n" +
        "BTWN: RODNEY LEE DR & POPLAR SPRINGS RD\n\n\n\n" +
        "COM:\n" +
        "75-year-old, female, conscious, breathing.\n" +
        "She is completely alert (responding appropriately).\n" +
        "She is breathing normally.\n" +
        "She does not have any pain.\n" +
        "She is not bleeding (or vomiting blood).\n" +
        "Her primary problem is nausea.\n" +
        "Determinant: 26A06, Suffix: , Response: Class 3\n\n" +
        "CT:\n" +
        "PAHAGE at POS 04",

        "CALL:Sick Person - 3",
        "PRI:1",
        "ADDR:932 ORCHARD RD",
        "CITY:FRANKLIN TWP",
        "X:RODNEY LEE DR & POPLAR SPRINGS RD",
        "INFO:75-year-old, female, conscious, breathing.\nShe is completely alert (responding appropriately).\nShe is breathing normally.\nShe does not have any pain.\nShe is not bleeding (or vomiting blood).\nHer primary problem is nausea.\nDeterminant: 26A06, Suffix: , Response: Class 3\nPAHAGE at POS 04");

    doTest("T34",
        "(Alert: Hemorrhage / Laceration - 2) ALRM LVL: 1\n" +
        "LOC:\n" +
        "6 BLACK BASS TRL\n" +
        "CARROLL VALLEY BORO\n" +
        "BTWN: SKI RUN TRL & BLUE GILL TRL\n\n\n\n" +
        "COM:\n" +
        "89-year-old, female, conscious, breathing.\n" +
        "The cause of the bleeding is non-traumatic.\n" +
        "The bleeding is from a NOT DANGEROUS area.\n" +
        "She is completely alert (responding appropriately).\n" +
        "She is breathing normally.\n" +
        "There is SERIOUS bleeding.\n" +
        "She takes blood thinners.\n" +
        "Determinant: 21B02, Suffix: , Response: Class 2\n" +
        "89-year-old, female, conscious, breathing.   Code: 21-B-2: SERIOUS hemorrhage\n" +
        "The cause of the bleeding is non-traumatic.\n" +
        "The bleeding is from a NOT DANGEROUS area.\n" +
        "She is completely alert (responding appropriately).\n" +
        "She is breathing normally.\n" +
        "There is SERIOUS bleeding.\n" +
        "She takes blood thinners.\n\n" +
        "CT:\n" +
        "PAHAGE at POS 04",

        "CALL:Hemorrhage / Laceration - 2",
        "PRI:1",
        "ADDR:6 BLACK BASS TRL",
        "CITY:CARROLL VALLEY",
        "X:SKI RUN TRL & BLUE GILL TRL",
        "INFO:89-year-old, female, conscious, breathing.\nThe cause of the bleeding is non-traumatic.\nThe bleeding is from a NOT DANGEROUS area.\nShe is completely alert (responding appropriately).\nShe is breathing normally.\nThere is SERIOUS bleeding.\nShe takes blood thinners.\nDeterminant: 21B02, Suffix: , Response: Class 2\n89-year-old, female, conscious, breathing.   Code: 21-B-2: SERIOUS hemorrhage\nThe cause of the bleeding is non-traumatic.\nThe bleeding is from a NOT DANGEROUS area.\nShe is completely alert (responding appropriately).\nShe is breathing normally.\nThere is SERIOUS bleeding.\nShe takes blood thinners.\nPAHAGE at POS 04");

    doTest("T35",
        "(Alert: Traumatic Injury - 2) ALRM LVL: 1\n" +
        "LOC:\n" +
        "4 MILE TRL\n" +
        "CARROLL VALLEY BORO\n" +
        "BTWN: RANCH TRL & PALOMINO TRL\n\n\n\n" +
        "COM:\n" +
        "4-year-old, female, conscious, breathing.\n" +
        "This happened now (less than 6hrs ago).\n" +
        "There is SERIOUS bleeding.\n" +
        "She is completely alert (responding appropriately).\n" +
        "The injury is to a POSSIBLY DANGEROUS area.\n" +
        "Determinant: 30B01, Suffix: , Response: Class 2\n" +
        "4-year-old, female, conscious, breathing.   Code: 30-B-1: POSSIBLY DANGEROUS body area\n" +
        "This happened now (less than 6hrs ago).\n" +
        "There is SERIOUS bleeding.\n" +
        "She is completely alert (responding appropriately).\n" +
        "The injury is to a POSSIBLY DANGEROUS area.\n\n" +
        "CT:\n" +
        "PAHAGE at POS 04",

        "CALL:Traumatic Injury - 2",
        "PRI:1",
        "ADDR:4 MILE TRL",
        "CITY:CARROLL VALLEY",
        "X:RANCH TRL & PALOMINO TRL",
        "INFO:4-year-old, female, conscious, breathing.\nThis happened now (less than 6hrs ago).\nThere is SERIOUS bleeding.\nShe is completely alert (responding appropriately).\nThe injury is to a POSSIBLY DANGEROUS area.\nDeterminant: 30B01, Suffix: , Response: Class 2\n4-year-old, female, conscious, breathing.   Code: 30-B-1: POSSIBLY DANGEROUS body area\nThis happened now (less than 6hrs ago).\nThere is SERIOUS bleeding.\nShe is completely alert (responding appropriately).\nThe injury is to a POSSIBLY DANGEROUS area.\nPAHAGE at POS 04");

    doTest("T36",
        "(Alert: Alarm Fire - Residential) ALRM LVL: 1\n" +
        "LOC:\n" +
        "451 STOOPS RD\n" +
        "HIGHLAND TWP\n" +
        "BTWN: CAMP GETTYSBURG RD & WEIKERT RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n\n\n" +
        "CT:\n" +
        "LMBYER at POS 04",

        "CALL:Alarm Fire - Residential",
        "PRI:1",
        "ADDR:451 STOOPS RD",
        "CITY:HIGHLAND TWP",
        "X:CAMP GETTYSBURG RD & WEIKERT RD",
        "INFO:LMBYER at POS 04");

    doTest("T37",
        "(Alert: Alarm Fire - Residential) ALRM LVL: 1\n" +
        "LOC:\n" +
        "451 STOOPS RD\n" +
        "HIGHLAND TWP\n" +
        "BTWN: CAMP GETTYSBURG RD & WEIKERT RD\n\n" +
        "RCVD AS 911\n\n" +
        "COM:\n" +
        "DISP CH 3\n" +
        "GENERAL FIRE ALARM\n" +
        "ALARM CO ADV NO CONTACT\n" +
        "SU2-Switch Status-451 STOOPS RD, HIGHLAND TWP\n" +
        "SU2-Enroute-451 STOOPS RD, HIGHLAND TWP\n\n" +
        "CT:\n" +
        "LMBYER at POS 04",

        "CALL:Alarm Fire - Residential",
        "PRI:1",
        "ADDR:451 STOOPS RD",
        "CITY:HIGHLAND TWP",
        "X:CAMP GETTYSBURG RD & WEIKERT RD",
        "INFO:DISP CH 3\nGENERAL FIRE ALARM\nALARM CO ADV NO CONTACT\nSU2-Switch Status-451 STOOPS RD, HIGHLAND TWP\nSU2-Enroute-451 STOOPS RD, HIGHLAND TWP\nLMBYER at POS 04");

    doTest("T38",
        "(Alert: Chest Pain - 1) ALRM LVL: 1\n" +
        "LOC:\n" +
        "11 PECAN TRL\n" +
        "CARROLL VALLEY BORO\n" +
        "BTWN: PEACH TREE TRL & END\n\n\n\n" +
        "COM:\n" +
        "78-year-old, male, conscious, breathing.\n" +
        "He is completely alert (responding appropriately).\n" +
        "He is breathing normally.\n" +
        "He is changing color.\n" +
        "His color change is pale.\n" +
        "He is clammy.\n" +
        "Determinant: 10D04, Suffix: , Response: Class 1\n" +
        "He is completely alert (responding appropriately).\n" +
        "He is breathing normally.\n" +
        "He is changing color.\n" +
        "His color change is pale.\n" +
        "He is clammy.\n" +
        "He has had a heart attack before.\n" +
        "He took a prescribed medication in the past 12 hrs: REGULAR MEDS\n" +
        "78-year-old, male, conscious, breathing.   Code: 10-D-4: Clammy\n" +
        "He is completely alert (responding appropriately).\n" +
        "He is breathing normally.\n" +
        "He is changing color.\n" +
        "His color change is pale.\n" +
        "He is clammy.\n" +
        "He has had a heart attack before.\n" +
        "He took a prescribed medication in the past 12 hrs: REGULAR MEDS\n" +
        "PROQA Comment: REGULAR MEDS\n\n" +
        "CT:\n" +
        "KEDEHO at POS 04",

        "CALL:Chest Pain - 1",
        "PRI:1",
        "ADDR:11 PECAN TRL",
        "CITY:CARROLL VALLEY",
        "X:PEACH TREE TRL & END",
        "INFO:78-year-old, male, conscious, breathing.\nHe is completely alert (responding appropriately).\nHe is breathing normally.\nHe is changing color.\nHis color change is pale.\nHe is clammy.\nDeterminant: 10D04, Suffix: , Response: Class 1\nHe is completely alert (responding appropriately).\nHe is breathing normally.\nHe is changing color.\nHis color change is pale.\nHe is clammy.\nHe has had a heart attack before.\nHe took a prescribed medication in the past 12 hrs: REGULAR MEDS\n78-year-old, male, conscious, breathing.   Code: 10-D-4: Clammy\nHe is completely alert (responding appropriately).\nHe is breathing normally.\nHe is changing color.\nHis color change is pale.\nHe is clammy.\nHe has had a heart attack before.\nHe took a prescribed medication in the past 12 hrs: REGULAR MEDS\nPROQA Comment: REGULAR MEDS\nKEDEHO at POS 04");

  }
  
  public static void main(String[] args) {
    new PAAdamsCountyParserTest().generateTests("T1");
  }
  
}
