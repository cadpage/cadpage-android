package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Montgomery County, PA (version E)
Contact: Active911
Agency name: VMSC of Lansdale
Location: Lansdale, PA, United States
Sender: 345pager@gmail.com

CARDIAC EMERGENCY ** 890 WEDGEWOOD DR ** LANS ** 345-6 **  ** ANDOVER RD AND TREMONT DR ** 12:32 **  ** WIFE HAVING HEART ATTACK\r\n ** E1262826 ** 11/22/12 **  **  ** \r\n
SEIZURES ** 815 SCOTT WAY ** UGWY ** NC345B **  ** LAFAYETTE RD ** 11:20 **  ** CALLERS BROTHER HAVING SEIZURE\r\n ** E1262819 ** 11/22/12 **  **  ** \r\n
RESPIRATORY EMERGENCY ** 1001 VALLEY FORGE RD  Apt# 13B ** UGWY ** 345-27 **  ** BOYD AVE AND BRITTANY PT ** 11:08 **  ** SPECIAL ADDRESS COMMENT:\r\nOBTAIN ROOM NUMBER\r\nSPECIAL ADDRESS COMMENT:\r\nOBTAIN ROOM NUMBER\r\n93 Y/O F ** E1262815 ** 11/22/12 **  **  ** \r\n
UNCONSCIOUS SUBJECT ** 428 MAIN ST S ** NWAL ** QX62  345-27 **  ** HIGHLAND AVE AND E PROSPE ** 09:28 **  ** FEMALE PASSED OUT IN CHURCH AT....\r\nIS BREATHING OK\r\n ** E1262798 ** 11/22/12 **  **  ** \r\n
CARDIAC EMERGENCY ** 113 ASPEN PL ** MONT ** 345-12 **  ** WINTER DR ** 08:03 **  ** CALLERS MOTHER IN LAW SOB AND FEELS FAINT\r\n85/F\r\n ** E1262792 ** 11/22/12 **  **  ** \r\n
VEHICLE ACCIDENT INJURIES ** SUMNEYTOWN PIKE AND WEST POINT PIKE ** UGWY ** QX80  345-27 **  ** SUMNEYTOWN PIKE AND WEST ** 05:44 **  ** ONE MALE W/ HEAD INJURY\r\n ** E1262779 ** 11/22/12 **  **  ** \r\n
SUBJECT IN PAIN ** 1397 FAIRGROUNDS RD ** HTFT ** 345-6 **  ** JEAN DR AND DENBEIGH DR ** 02:56 **  ** 36/M\r\nHAND PAIN FROM A FIGHT THAT OCCURRED 2 HRS AGO\r\nCHARGES AND GO TO HOSP\r\nC/A\r\nCALLR SAYS AN OFF ** E1262765 ** 11/22/12 **  **  ** \r\n
LACERATIONS ** W 8TH ST AND N CANNON AVE ** LANS ** 345-6 **  ** W 8TH ST AND N CANNON AVE ** 02:19 **  ** SUBJECTS OUT THERE SCREAMING\r\nAT THE APARTMENT BUILDING\r\nTHERE IS NO NAME ON THE APARTMENT BUILDING\r ** E1262763 ** 11/22/12 **  **  ** \r\n
FALL VICTIM NON-TRAUMA ** 1001 VALLEY FORGE RD  Apt# 221 ** UGWY ** 345-6  NC345B **  ** BOYD AVE AND BRITTANY PT ** 20:57 **  ** PAIN IN RIGHT HIP\r\nSPECIAL ADDRESS COMMENT:\r\nOBTAIN ROOM NUMBER\r\n93/M FELL\r\nMEDICAL BLDG, 2ND FL\r\nBR ** E1262724 ** 11/21/12 **  **  ** \r\n
FEVER (BLS) ** 600 MAIN ST E Apt# 1 ** LANS **  **  ** HIGHLAND AVE AND GREENWOO ** 20:08 **  ** 14/M C+A\r\nTEMP 103\r\nALSO THROWING UP\r\nHAS ADHD\r\n ** E1262713 ** 11/21/12 **  **  ** \r\n
FALL VICTIM NON-TRAUMA(BLS) ** 513 8TH ST W Apt# A ** LANS **  **  ** N CANNON AVE AND MOYERS R **  **  ** CALLER NEEDS HELP LIFTING HIS GIRLFRIEND BACK INTO HER WHEEL CHAIR\r\nCALLER DECLINED EMS, NO INJ\r\n533 **  **  **  **  ** \r\n
OVERDOSE ** 219 YORK AVE  Apt# G3 ** LANS ** 345-27 **  ** GREEN ST AND SUSQUEHANNA ** 18:18 **  ** 32 Y/O\r\nMAY HAVE TAKEN OXYCOTIN\r\nTHIRD PARTY CALLER\r\n ** E1262700 ** 11/21/12 **  **  ** \r\n
DIABETIC EMERGENCY ** 604 KARENS CT ** MONT **  **  ** EMERSON DR AND EMERSON DR ** 17:03 **  **  ** E1262684 ** 11/21/12 **  **  ** \r\n
SUBJECT IN PAIN ** 1001 VALLEY FORGE RD  Apt# 127 ** UGWY ** 345-27 **  ** BOYD AVE AND BRITTANY PT ** 16:57 **  ** SPECIAL ADDRESS COMMENT:\r\nOBTAIN ROOM NUMBER\r\nSPECIAL ADDRESS COMMENT:\r\nSTARTING VOMITING AT 1620\r\n8 ** E1262681 ** 11/21/12 **  **  ** \r\n
SUBJECT IN PAIN ** 223 WOODS DR ** TWMC ** NC345B  345-68 **  ** DETWILER RD AND COMMUNITY ** 16:13 **  ** 88/F IN PAIN AFTER A FALLTHIS MORNING\r\nC/A\r\n **  ** 11/21/12 **  **  ** \r\n
RESPIRATORY EMERGENCY (ALS) ** 1091 HORSHAM RD  Apt# A4 ** MONT **  **  ** PHEASANT RUN AND HARTMAN **  **  ** SPECIAL ADDRESS COMMENT:\r\nSPECIAL ADDRESS COMMENT:\r\n88/M C/A DIFF BREATHING AND SWEATING\r\nMED HX - M **  **  **  **  ** \r\n
VEHICLE ACCIDENT INJURIES ** 570 DEKALB PIKE ** UGWY ** NC345A  QX62 **  ** HANCOCK RD AND WELSH RD ** 15:45 **  ** NO VOICE CONCT\r\nON CALL BACK SPOKE CLARA\r\nUNK AWARE OF ANY EMERGENCY\r\n`\r\nPOSSIBLE VEHICLE ACCIDENT A ** E1262665 ** 11/21/12 **  **  ** \r\n
ALTERED MENTAL STATUS ** 801 BETHLEHEM PIKE  Apt# 34 ** MONT ** NC345A  4A134 **  ** NORTH WALES RD AND UPPER ** 15:43 **  ** SPECIAL ADDRESS COMMENT:\r\n78/F C/NOT ALERT\r\nINSIDE ..\r\n+ AIRPORT SQUARE SHOPPING CENTER\r\n ** E1262663 ** 11/21/12 **  **  ** \r\n
FRACTURE ** 136 CHURCH RD ** UGWY ** QX80  345-6  NC **  ** BECKER RD AND KNEEDLER RD **  **  ** BICYCLE HIT MAIL BOX, BROKE ARM\r\nWEARING HELEMT\r\n73/M\r\nC/A\r\nBREATHING OK\r\nBLEEDING FROM HEAD AS WELL **  **  **  **  ** \r\n
CARDIAC EMERGENCY ** 38 MARKET ST N Apt# D ** HTFB ** 345-27  NC345 **  ** FRETZ AVE AND UNION ST ** 12:55 **  ** -075.289736 +040.276737\r\n61/F WITH CHEST PAIN\r\nC/A\r\nSOB\r\n ** E1262628 ** 11/21/12 **  **  ** \r\n
VEHICLE ACCIDENT RESCUE ** STUMP RD AND HORSHAM RD ** MONT ** R18  SD62  R345 **  ** STUMP RD AND HORSHAM RD ** 12:48 **  ** 2 OR 3 VEH\r\n1 WITH NECK  and  HEAD PAIN\r\nBLOCKING\r\nON HORSHAM RD\r\n345-12 - WILL NEED RESCUE HERE\r\n47 ** F1228875 ** 11/21/12 **  **  ** \r\n
VEHICLE ACCIDENT INJURIES ** STUMP RD AND HORSHAM RD ** MONT ** 345-12 **  ** STUMP RD AND HORSHAM RD ** 12:43 **  ** 2 OR 3 VEH\r\n1 WITH NECK  and  HEAD PAIN\r\nBLOCKING\r\n ** E1262625 ** 11/21/12 **  **  ** \r\n
SUBJECT IN PAIN ** 20 BLAINE AVE ** HTFB ** 345-6  345-68 **  ** S MAIN ST AND S WAYNE AVE ** 12:31 **  ** 45/M C/A PAIN AT THE SURGICAL SITE\r\nPOSSIBLE INFECTION\r\nNO MED HX\r\n5547 - POLICE NOT RESPONDING UNLE ** E1262624 ** 11/21/12 **  **  ** \r\n
CVA/STROKE ** 724 CHERRY ST ** LANS ** 345-6 **  ** WADE AVE AND CYPRESS ST ** 11:21 **  ** SOME DIFF BREAHING\r\n80'S/M C/A SLURRING HIS SPEACH\r\n ** E1262606 ** 11/21/12 **  **  ** \r\n
CARDIAC EMERGENCY ** 1010 HORSHAM RD  Apt# 110 ** MONT ** NC345A **  ** UPPER STATE RD AND RT202 ** 10:59 **  ** 71 Y/O WITH GROSSLY POSITIVE STRESS TEST\r\n@CARDIAC STRESS TEST CENTER\r\n ** E1262603 ** 11/21/12 **  **  ** \r\n

 */

public class PAMontgomeryCountyEParserTest extends BaseParserTest {
  
  public PAMontgomeryCountyEParserTest() {
    setParser(new PAMontgomeryCountyEParser(), "MONTGOMERY COUNTY", "PA");
  }
  
  @Test
  public void testLandsdaleVSMC() {

    doTest("T1",
        "CARDIAC EMERGENCY ** 890 WEDGEWOOD DR ** LANS ** 345-6 **  ** ANDOVER RD AND TREMONT DR ** 12:32 **  ** WIFE HAVING HEART ATTACK\r\n" +
        " ** E1262826 ** 11/22/12 **  **  ** \r\n",

        "CALL:CARDIAC EMERGENCY",
        "ADDR:890 WEDGEWOOD DR",
        "CITY:LANSDALE",
        "UNIT:345-6",
        "X:ANDOVER RD AND TREMONT DR",
        "TIME:12:32",
        "INFO:WIFE HAVING HEART ATTACK",
        "ID:E1262826",
        "DATE:11/22/12");

    doTest("T2",
        "SEIZURES ** 815 SCOTT WAY ** UGWY ** NC345B **  ** LAFAYETTE RD ** 11:20 **  ** CALLERS BROTHER HAVING SEIZURE\r\n" +
        " ** E1262819 ** 11/22/12 **  **  ** \r\n",

        "CALL:SEIZURES",
        "ADDR:815 SCOTT WAY",
        "CITY:UPPER GWYNEDD TWP",
        "UNIT:NC345B",
        "X:LAFAYETTE RD",
        "TIME:11:20",
        "INFO:CALLERS BROTHER HAVING SEIZURE",
        "ID:E1262819",
        "DATE:11/22/12");

    doTest("T3",
        "RESPIRATORY EMERGENCY ** 1001 VALLEY FORGE RD  Apt# 13B ** UGWY ** 345-27 **  ** BOYD AVE AND BRITTANY PT ** 11:08 **  ** SPECIAL ADDRESS COMMENT:\r\n" +
        "OBTAIN ROOM NUMBER\r\n" +
        "SPECIAL ADDRESS COMMENT:\r\n" +
        "OBTAIN ROOM NUMBER\r\n" +
        "93 Y/O F ** E1262815 ** 11/22/12 **  **  ** \r\n",

        "CALL:RESPIRATORY EMERGENCY",
        "ADDR:1001 VALLEY FORGE RD",
        "APT:13B",
        "CITY:UPPER GWYNEDD TWP",
        "UNIT:345-27",
        "X:BOYD AVE AND BRITTANY PT",
        "TIME:11:08",
        "INFO:SPECIAL ADDRESS COMMENT: OBTAIN ROOM NUMBER SPECIAL ADDRESS COMMENT: OBTAIN ROOM NUMBER 93 Y/O F",
        "ID:E1262815",
        "DATE:11/22/12");

    doTest("T4",
        "UNCONSCIOUS SUBJECT ** 428 MAIN ST S ** NWAL ** QX62  345-27 **  ** HIGHLAND AVE AND E PROSPE ** 09:28 **  ** FEMALE PASSED OUT IN CHURCH AT....\r\n" +
        "IS BREATHING OK\r\n" +
        " ** E1262798 ** 11/22/12 **  **  ** \r\n",

        "CALL:UNCONSCIOUS SUBJECT",
        "ADDR:428 MAIN ST S",
        "CITY:NORTH WALES",
        "UNIT:QX62  345-27",
        "X:HIGHLAND AVE AND E PROSPE",
        "TIME:09:28",
        "INFO:FEMALE PASSED OUT IN CHURCH AT.... IS BREATHING OK",
        "ID:E1262798",
        "DATE:11/22/12");

    doTest("T5",
        "CARDIAC EMERGENCY ** 113 ASPEN PL ** MONT ** 345-12 **  ** WINTER DR ** 08:03 **  ** CALLERS MOTHER IN LAW SOB AND FEELS FAINT\r\n" +
        "85/F\r\n" +
        " ** E1262792 ** 11/22/12 **  **  ** \r\n",

        "CALL:CARDIAC EMERGENCY",
        "ADDR:113 ASPEN PL",
        "CITY:MONTGOMERY TWP",
        "UNIT:345-12",
        "X:WINTER DR",
        "TIME:08:03",
        "INFO:CALLERS MOTHER IN LAW SOB AND FEELS FAINT 85/F",
        "ID:E1262792",
        "DATE:11/22/12");

    doTest("T6",
        "VEHICLE ACCIDENT INJURIES ** SUMNEYTOWN PIKE AND WEST POINT PIKE ** UGWY ** QX80  345-27 **  ** SUMNEYTOWN PIKE AND WEST ** 05:44 **  ** ONE MALE W/ HEAD INJURY\r\n" +
        " ** E1262779 ** 11/22/12 **  **  ** \r\n",

        "CALL:VEHICLE ACCIDENT INJURIES",
        "ADDR:SUMNEYTOWN PIKE AND WEST POINT PIKE",
        "MADDR:SUMNEYTOWN PIKE & WEST POINT PIKE",
        "CITY:UPPER GWYNEDD TWP",
        "UNIT:QX80  345-27",
        "X:SUMNEYTOWN PIKE AND WEST",
        "TIME:05:44",
        "INFO:ONE MALE W/ HEAD INJURY",
        "ID:E1262779",
        "DATE:11/22/12");

    doTest("T7",
        "SUBJECT IN PAIN ** 1397 FAIRGROUNDS RD ** HTFT ** 345-6 **  ** JEAN DR AND DENBEIGH DR ** 02:56 **  ** 36/M\r\n" +
        "HAND PAIN FROM A FIGHT THAT OCCURRED 2 HRS AGO\r\n" +
        "CHARGES AND GO TO HOSP\r\n" +
        "C/A\r\n" +
        "CALLR SAYS AN OFF ** E1262765 ** 11/22/12 **  **  ** \r\n",

        "CALL:SUBJECT IN PAIN",
        "ADDR:1397 FAIRGROUNDS RD",
        "CITY:HATFIELD TWP",
        "UNIT:345-6",
        "X:JEAN DR AND DENBEIGH DR",
        "TIME:02:56",
        "INFO:36/M HAND PAIN FROM A FIGHT THAT OCCURRED 2 HRS AGO CHARGES AND GO TO HOSP C/A CALLR SAYS AN OFF",
        "ID:E1262765",
        "DATE:11/22/12");

    doTest("T8",
        "LACERATIONS ** W 8TH ST AND N CANNON AVE ** LANS ** 345-6 **  ** W 8TH ST AND N CANNON AVE ** 02:19 **  ** SUBJECTS OUT THERE SCREAMING\r\n" +
        "AT THE APARTMENT BUILDING\r\n" +
        "THERE IS NO NAME ON THE APARTMENT BUILDING\r ** E1262763 ** 11/22/12 **  **  ** \r\n",

        "CALL:LACERATIONS",
        "ADDR:W 8TH ST AND N CANNON AVE",
        "MADDR:W 8TH ST & N CANNON AVE",
        "CITY:LANSDALE",
        "UNIT:345-6",
        "X:W 8TH ST AND N CANNON AVE",
        "TIME:02:19",
        "INFO:SUBJECTS OUT THERE SCREAMING AT THE APARTMENT BUILDING THERE IS NO NAME ON THE APARTMENT BUILDING",
        "ID:E1262763",
        "DATE:11/22/12");

    doTest("T9",
        "FALL VICTIM NON-TRAUMA ** 1001 VALLEY FORGE RD  Apt# 221 ** UGWY ** 345-6  NC345B **  ** BOYD AVE AND BRITTANY PT ** 20:57 **  ** PAIN IN RIGHT HIP\r\n" +
        "SPECIAL ADDRESS COMMENT:\r\n" +
        "OBTAIN ROOM NUMBER\r\n" +
        "93/M FELL\r\n" +
        "MEDICAL BLDG, 2ND FL\r\n" +
        "BR ** E1262724 ** 11/21/12 **  **  ** \r\n",

        "CALL:FALL VICTIM NON-TRAUMA",
        "ADDR:1001 VALLEY FORGE RD",
        "APT:221",
        "CITY:UPPER GWYNEDD TWP",
        "UNIT:345-6  NC345B",
        "X:BOYD AVE AND BRITTANY PT",
        "TIME:20:57",
        "INFO:PAIN IN RIGHT HIP SPECIAL ADDRESS COMMENT: OBTAIN ROOM NUMBER 93/M FELL MEDICAL BLDG, 2ND FL BR",
        "ID:E1262724",
        "DATE:11/21/12");

    doTest("T10",
        "FEVER (BLS) ** 600 MAIN ST E Apt# 1 ** LANS **  **  ** HIGHLAND AVE AND GREENWOO ** 20:08 **  ** 14/M C+A\r\n" +
        "TEMP 103\r\n" +
        "ALSO THROWING UP\r\n" +
        "HAS ADHD\r\n" +
        " ** E1262713 ** 11/21/12 **  **  ** \r\n",

        "CALL:FEVER (BLS)",
        "ADDR:600 MAIN ST E",
        "APT:1",
        "CITY:LANSDALE",
        "X:HIGHLAND AVE AND GREENWOO",
        "TIME:20:08",
        "INFO:14/M C+A TEMP 103 ALSO THROWING UP HAS ADHD",
        "ID:E1262713",
        "DATE:11/21/12");

    doTest("T11",
        "FALL VICTIM NON-TRAUMA(BLS) ** 513 8TH ST W Apt# A ** LANS **  **  ** N CANNON AVE AND MOYERS R **  **  ** CALLER NEEDS HELP LIFTING HIS GIRLFRIEND BACK INTO HER WHEEL CHAIR\r\n" +
        "CALLER DECLINED EMS, NO INJ\r\n" +
        "533 **  **  **  **  ** \r\n",

        "CALL:FALL VICTIM NON-TRAUMA(BLS)",
        "ADDR:513 8TH ST W",
        "APT:A",
        "CITY:LANSDALE",
        "X:N CANNON AVE AND MOYERS R",
        "INFO:CALLER NEEDS HELP LIFTING HIS GIRLFRIEND BACK INTO HER WHEEL CHAIR CALLER DECLINED EMS, NO INJ 533");

    doTest("T12",
        "OVERDOSE ** 219 YORK AVE  Apt# G3 ** LANS ** 345-27 **  ** GREEN ST AND SUSQUEHANNA ** 18:18 **  ** 32 Y/O\r\n" +
        "MAY HAVE TAKEN OXYCOTIN\r\n" +
        "THIRD PARTY CALLER\r\n" +
        " ** E1262700 ** 11/21/12 **  **  ** \r\n",

        "CALL:OVERDOSE",
        "ADDR:219 YORK AVE",
        "APT:G3",
        "CITY:LANSDALE",
        "UNIT:345-27",
        "X:GREEN ST AND SUSQUEHANNA",
        "TIME:18:18",
        "INFO:32 Y/O MAY HAVE TAKEN OXYCOTIN THIRD PARTY CALLER",
        "ID:E1262700",
        "DATE:11/21/12");

    doTest("T13",
        "DIABETIC EMERGENCY ** 604 KARENS CT ** MONT **  **  ** EMERSON DR AND EMERSON DR ** 17:03 **  **  ** E1262684 ** 11/21/12 **  **  ** \r\n",
        "CALL:DIABETIC EMERGENCY",
        "ADDR:604 KARENS CT",
        "CITY:MONTGOMERY TWP",
        "X:EMERSON DR AND EMERSON DR",
        "TIME:17:03",
        "ID:E1262684",
        "DATE:11/21/12");

    doTest("T14",
        "SUBJECT IN PAIN ** 1001 VALLEY FORGE RD  Apt# 127 ** UGWY ** 345-27 **  ** BOYD AVE AND BRITTANY PT ** 16:57 **  ** SPECIAL ADDRESS COMMENT:\r\n" +
        "OBTAIN ROOM NUMBER\r\n" +
        "SPECIAL ADDRESS COMMENT:\r\n" +
        "STARTING VOMITING AT 1620\r\n" +
        "8 ** E1262681 ** 11/21/12 **  **  ** \r\n",

        "CALL:SUBJECT IN PAIN",
        "ADDR:1001 VALLEY FORGE RD",
        "APT:127",
        "CITY:UPPER GWYNEDD TWP",
        "UNIT:345-27",
        "X:BOYD AVE AND BRITTANY PT",
        "TIME:16:57",
        "INFO:SPECIAL ADDRESS COMMENT: OBTAIN ROOM NUMBER SPECIAL ADDRESS COMMENT: STARTING VOMITING AT 1620 8",
        "ID:E1262681",
        "DATE:11/21/12");

    doTest("T15",
        "SUBJECT IN PAIN ** 223 WOODS DR ** TWMC ** NC345B  345-68 **  ** DETWILER RD AND COMMUNITY ** 16:13 **  ** 88/F IN PAIN AFTER A FALLTHIS MORNING\r\n" +
        "C/A\r\n" +
        " **  ** 11/21/12 **  **  ** \r\n",

        "CALL:SUBJECT IN PAIN",
        "ADDR:223 WOODS DR",
        "CITY:TOWAMENCIN TWP",
        "UNIT:NC345B  345-68",
        "X:DETWILER RD AND COMMUNITY",
        "TIME:16:13",
        "INFO:88/F IN PAIN AFTER A FALLTHIS MORNING C/A",
        "DATE:11/21/12");

    doTest("T16",
        "RESPIRATORY EMERGENCY (ALS) ** 1091 HORSHAM RD  Apt# A4 ** MONT **  **  ** PHEASANT RUN AND HARTMAN **  **  ** SPECIAL ADDRESS COMMENT:\r\n" +
        "SPECIAL ADDRESS COMMENT:\r\n" +
        "88/M C/A DIFF BREATHING AND SWEATING\r\n" +
        "MED HX - M **  **  **  **  ** \r\n",

        "CALL:RESPIRATORY EMERGENCY (ALS)",
        "ADDR:1091 HORSHAM RD",
        "APT:A4",
        "CITY:MONTGOMERY TWP",
        "X:PHEASANT RUN AND HARTMAN",
        "INFO:SPECIAL ADDRESS COMMENT: SPECIAL ADDRESS COMMENT: 88/M C/A DIFF BREATHING AND SWEATING MED HX - M");

    doTest("T17",
        "VEHICLE ACCIDENT INJURIES ** 570 DEKALB PIKE ** UGWY ** NC345A  QX62 **  ** HANCOCK RD AND WELSH RD ** 15:45 **  ** NO VOICE CONCT\r\n" +
        "ON CALL BACK SPOKE CLARA\r\n" +
        "UNK AWARE OF ANY EMERGENCY\r\n" +
        "`\r\n" +
        "POSSIBLE VEHICLE ACCIDENT A ** E1262665 ** 11/21/12 **  **  ** \r\n",

        "CALL:VEHICLE ACCIDENT INJURIES",
        "ADDR:570 DEKALB PIKE",
        "CITY:UPPER GWYNEDD TWP",
        "UNIT:NC345A  QX62",
        "X:HANCOCK RD AND WELSH RD",
        "TIME:15:45",
        "INFO:NO VOICE CONCT ON CALL BACK SPOKE CLARA UNK AWARE OF ANY EMERGENCY ` POSSIBLE VEHICLE ACCIDENT A",
        "ID:E1262665",
        "DATE:11/21/12");

    doTest("T18",
        "ALTERED MENTAL STATUS ** 801 BETHLEHEM PIKE  Apt# 34 ** MONT ** NC345A  4A134 **  ** NORTH WALES RD AND UPPER ** 15:43 **  ** SPECIAL ADDRESS COMMENT:\r\n" +
        "78/F C/NOT ALERT\r\n" +
        "INSIDE ..\r\n" +
        "+ AIRPORT SQUARE SHOPPING CENTER\r\n" +
        " ** E1262663 ** 11/21/12 **  **  ** \r\n",

        "CALL:ALTERED MENTAL STATUS",
        "ADDR:801 BETHLEHEM PIKE",
        "APT:34",
        "CITY:MONTGOMERY TWP",
        "UNIT:NC345A  4A134",
        "X:NORTH WALES RD AND UPPER",
        "TIME:15:43",
        "INFO:SPECIAL ADDRESS COMMENT: 78/F C/NOT ALERT INSIDE .. + AIRPORT SQUARE SHOPPING CENTER",
        "ID:E1262663",
        "DATE:11/21/12");

    doTest("T19",
        "FRACTURE ** 136 CHURCH RD ** UGWY ** QX80  345-6  NC **  ** BECKER RD AND KNEEDLER RD **  **  ** BICYCLE HIT MAIL BOX, BROKE ARM\r\n" +
        "WEARING HELEMT\r\n" +
        "73/M\r\n" +
        "C/A\r\n" +
        "BREATHING OK\r\n" +
        "BLEEDING FROM HEAD AS WELL **  **  **  **  ** \r\n",

        "CALL:FRACTURE",
        "ADDR:136 CHURCH RD",
        "CITY:UPPER GWYNEDD TWP",
        "UNIT:QX80  345-6  NC",
        "X:BECKER RD AND KNEEDLER RD",
        "INFO:BICYCLE HIT MAIL BOX, BROKE ARM WEARING HELEMT 73/M C/A BREATHING OK BLEEDING FROM HEAD AS WELL");

    doTest("T20",
        "CARDIAC EMERGENCY ** 38 MARKET ST N Apt# D ** HTFB ** 345-27  NC345 **  ** FRETZ AVE AND UNION ST ** 12:55 **  ** -075.289736 +040.276737\r\n" +
        "61/F WITH CHEST PAIN\r\n" +
        "C/A\r\n" +
        "SOB\r\n" +
        " ** E1262628 ** 11/21/12 **  **  ** \r\n",

        "CALL:CARDIAC EMERGENCY",
        "ADDR:38 MARKET ST N",
        "APT:D",
        "CITY:HATFIELD",
        "UNIT:345-27  NC345",
        "X:FRETZ AVE AND UNION ST",
        "TIME:12:55",
        "INFO:-075.289736 +040.276737 61/F WITH CHEST PAIN C/A SOB",
        "ID:E1262628",
        "DATE:11/21/12");

    doTest("T21",
        "VEHICLE ACCIDENT RESCUE ** STUMP RD AND HORSHAM RD ** MONT ** R18  SD62  R345 **  ** STUMP RD AND HORSHAM RD ** 12:48 **  ** 2 OR 3 VEH\r\n" +
        "1 WITH NECK  and  HEAD PAIN\r\n" +
        "BLOCKING\r\n" +
        "ON HORSHAM RD\r\n" +
        "345-12 - WILL NEED RESCUE HERE\r\n" +
        "47 ** F1228875 ** 11/21/12 **  **  ** \r\n",

        "CALL:VEHICLE ACCIDENT RESCUE",
        "ADDR:STUMP RD AND HORSHAM RD",
        "MADDR:STUMP RD & HORSHAM RD",
        "CITY:MONTGOMERY TWP",
        "UNIT:R18  SD62  R345",
        "X:STUMP RD AND HORSHAM RD",
        "TIME:12:48",
        "INFO:2 OR 3 VEH 1 WITH NECK  and  HEAD PAIN BLOCKING ON HORSHAM RD 345-12 - WILL NEED RESCUE HERE 47",
        "ID:F1228875",
        "DATE:11/21/12");

    doTest("T22",
        "VEHICLE ACCIDENT INJURIES ** STUMP RD AND HORSHAM RD ** MONT ** 345-12 **  ** STUMP RD AND HORSHAM RD ** 12:43 **  ** 2 OR 3 VEH\r\n" +
        "1 WITH NECK  and  HEAD PAIN\r\n" +
        "BLOCKING\r\n" +
        " ** E1262625 ** 11/21/12 **  **  ** \r\n",

        "CALL:VEHICLE ACCIDENT INJURIES",
        "ADDR:STUMP RD AND HORSHAM RD",
        "MADDR:STUMP RD & HORSHAM RD",
        "CITY:MONTGOMERY TWP",
        "UNIT:345-12",
        "X:STUMP RD AND HORSHAM RD",
        "TIME:12:43",
        "INFO:2 OR 3 VEH 1 WITH NECK  and  HEAD PAIN BLOCKING",
        "ID:E1262625",
        "DATE:11/21/12");

    doTest("T23",
        "SUBJECT IN PAIN ** 20 BLAINE AVE ** HTFB ** 345-6  345-68 **  ** S MAIN ST AND S WAYNE AVE ** 12:31 **  ** 45/M C/A PAIN AT THE SURGICAL SITE\r\n" +
        "POSSIBLE INFECTION\r\n" +
        "NO MED HX\r\n" +
        "5547 - POLICE NOT RESPONDING UNLE ** E1262624 ** 11/21/12 **  **  ** \r\n",

        "CALL:SUBJECT IN PAIN",
        "ADDR:20 BLAINE AVE",
        "CITY:HATFIELD",
        "UNIT:345-6  345-68",
        "X:S MAIN ST AND S WAYNE AVE",
        "TIME:12:31",
        "INFO:45/M C/A PAIN AT THE SURGICAL SITE POSSIBLE INFECTION NO MED HX 5547 - POLICE NOT RESPONDING UNLE",
        "ID:E1262624",
        "DATE:11/21/12");

    doTest("T24",
        "CVA/STROKE ** 724 CHERRY ST ** LANS ** 345-6 **  ** WADE AVE AND CYPRESS ST ** 11:21 **  ** SOME DIFF BREAHING\r\n" +
        "80'S/M C/A SLURRING HIS SPEACH\r\n" +
        " ** E1262606 ** 11/21/12 **  **  ** \r\n",

        "CALL:CVA/STROKE",
        "ADDR:724 CHERRY ST",
        "CITY:LANSDALE",
        "UNIT:345-6",
        "X:WADE AVE AND CYPRESS ST",
        "TIME:11:21",
        "INFO:SOME DIFF BREAHING 80'S/M C/A SLURRING HIS SPEACH",
        "ID:E1262606",
        "DATE:11/21/12");

    doTest("T25",
        "CARDIAC EMERGENCY ** 1010 HORSHAM RD  Apt# 110 ** MONT ** NC345A **  ** UPPER STATE RD AND RT202 ** 10:59 **  ** 71 Y/O WITH GROSSLY POSITIVE STRESS TEST\r\n" +
        "@CARDIAC STRESS TEST CENTER\r\n" +
        " ** E1262603 ** 11/21/12 **  **  ** \r\n",

        "CALL:CARDIAC EMERGENCY",
        "ADDR:1010 HORSHAM RD",
        "APT:110",
        "CITY:MONTGOMERY TWP",
        "UNIT:NC345A",
        "X:UPPER STATE RD AND RT202",
        "TIME:10:59",
        "INFO:71 Y/O WITH GROSSLY POSITIVE STRESS TEST @CARDIAC STRESS TEST CENTER",
        "ID:E1262603",
        "DATE:11/21/12");

  }
  
  public static void main(String[] args) {
    new PAMontgomeryCountyEParserTest().generateTests("T1");
  }
}