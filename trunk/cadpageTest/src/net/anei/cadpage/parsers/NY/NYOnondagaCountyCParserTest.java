package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NYOnondagaCountyCParserTest extends BaseParserTest {
  
  public NYOnondagaCountyCParserTest() {
    setParser(new NYOnondagaCountyCParser(), "ONONDAGA COUNTY", "NY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Dispatch) Dispatch ** 07:06:07 ** E-PERSONAL INJURY ** 916 STATE FAIR BLVD ** SNOWBIRDS LANDING II-NEAR THE **  ** (315) 460-0168 **  **  ** MALE FELL APPEARS UNSTABLE\n" +
        "Number of patients: 1\n" +
        "Responder script: 86 year old, Male, Conscious, Breathing. Falls. Caller\n" +
        "Statement: MALE FELL APPEARS UNSTABLE .\n" +
        "MALE FELL APPEARS UNSTABLE\n" +
        "Respon ** 05/26/12 ** PINJ ** WVE128700889 ** WVE ** Fire Station Dispatch Report   Dispatch Time:  05-26-2012  07:06:07\n" +
        "Agency: GBE \n" +
        "    Event: E12052600040\n\n" +
        "Case Number: WVE128700889\n" +
        "Event Type Code: PINJ PERSONAL INJURY\n" +
        "Event Subtype Code:         \n\n" +
        "Address:\n" +
        "SNOWBIRDS LANDING II\n" +
        "916  STATE FAIR BLVD \n" +
        "Location Info: NEAR THE ST IFO THIS LOCATION \n\n" +
        "Municipality: TGD\n" +
        "Cross Street: CONKLIN ST AND SENECA ST\n\n" +
        "Caller Information:\n\n" +
        "  Caller Name: \n" +
        "  Caller Phone Number: (315) 460-0168\n" +
        "  Caller Address: \n\n" +
        "Responding Units:\n\n" +
        "  87A3  WVE1  EMS\n" +
        " ** TGD **  ** GB **  ** CONKLIN ST AND SENECA ST **  ** A3, ** ",

        "TIME:07:06:07",
        "CALL:E-PERSONAL INJURY",
        "ADDR:916 STATE FAIR BLVD",
        "PLACE:SNOWBIRDS LANDING II-NEAR THE",
        "PHONE:(315) 460-0168",
        "INFO:MALE FELL APPEARS UNSTABLE",
        "SRC:GBE",
        "CITY:GEDDES",
        "X:CONKLIN ST AND SENECA ST",
        "UNIT:87A3  WVE1  EMS");

    doTest("T2",
        "(Dispatch) Dispatch ** 12:02:25 ** E-DIFFICULTY BREATHING ** 700 EAGLE LN ** -APT 9 ** TOLBERT,SHAVON ** (315) 876-1934 **  **  ** TIGHTNESS IN CHEST\n" +
        "Number of patients: 1\n" +
        "Responder script: 30 year old, Female, Conscious, Breathing. Breathing Problems.\n" +
        "Caller Statement: TIGHTNESS IN CHEST .\n" +
        "SAYS SHE HAS ASTHMA\n" +
        "SCRATCHY THROA ** 05/26/12 ** DIFB ** WVE128700893 ** WVE ** Fire Station Dispatch Report   Dispatch Time:  05-26-2012  12:02:25\n" +
        "Agency: WVE \n" +
        "    Event: E12052600094\n\n" +
        "Case Number: WVE128700893\n" +
        "Event Type Code: DIFB DIFFICULTY BREATHING\n" +
        "Event Subtype Code:         \n\n" +
        "Address:\n\n" +
        "700  EAGLE LN \n" +
        "Location Info: APT 9 \n\n" +
        "Municipality: TCM\n" +
        "Cross Street: ARLINGTON SQ AND ARLINGTON SQ\n\n" +
        "Caller Information:\n\n" +
        "  Caller Name: TOLBERT,SHAVON\n" +
        "  Caller Phone Number: (315) 876-1934\n" +
        "  Caller Address: \n\n" +
        "Responding Units:\n\n" +
        "  87A4  WVE1  EMS\n" +
        "  \n\n" +
        "Event Comments:\n" +
        "TIGHT ** TCM **  ** WV **  ** ARLINGTON SQ AND ARLINGTO **  ** A4, ** ",

        "TIME:12:02:25",
        "CALL:E-DIFFICULTY BREATHING",
        "ADDR:700 EAGLE LN",
        "APT:9",
        "NAME:TOLBERT,SHAVON",
        "PHONE:(315) 876-1934",
        "INFO:TIGHTNESS IN CHEST",
        "SRC:WVE",
        "CITY:CAMILLUS",
        "X:ARLINGTON SQ AND ARLINGTON SQ",
        "UNIT:87A4  WVE1  EMS");

    doTest("T3",
        "(Dispatch) Dispatch ** 22:11:48 ** E-DIABETIC EMERGENCY ** 2 WALLACE AVE ** - ** NARUSKY, ROBERT J ** (315) 672-3455 **  **  ** NARUSKY, ROBERT J RESD 05/26 22:09:55\n" +
        "LOW BLOOD SUGAR\n" +
        "LOW BLOOD SUGAR OF 73\n" +
        "Number of patients: 1\n" +
        "Responder script: 86 year old, Male, Conscious, Breathing. Diabetic Problems.\n" +
        "Caller Statement: L ** 05/26/12 ** DIAB ** WVE128700894 ** WVE ** Fire Station Dispatch Report  Dispatch Time:  05-26-2012  22:11:48\n" +
        "Agency: WVE \n" +
        "    Event: E12052600217\n\n" +
        "Case Number: WVE128700894\n" +
        "Event Type Code: DIAB DIABETIC EMERGENCY\n" +
        "Event Subtype Code:         \n\n" +
        "Address:\n\n" +
        "2  WALLACE AVE \n" +
        "Location Info: \n\n" +
        "Municipality: VCM\n" +
        "Cross Street: ELDERKIN AVE AND KASTOR AVE\n\n" +
        "Caller Information:\n\n" +
        "  Caller Name: NARUSKY, ROBERT J\n" +
        "  Caller Phone Number: (315) 672-3455\n" +
        "  Caller Address: 2 WALLACE AV CAMILLUS_VILLAGE\n\n" +
        "Responding Units:\n\n" +
        "  87A4  WVE1  EMS\n" +
        "  \n\n" +
        " ** VCM **  ** WV **  ** ELDERKIN AVE AND KASTOR A **  ** A4, ** ",

        "TIME:22:11:48",
        "CALL:E-DIABETIC EMERGENCY",
        "ADDR:2 WALLACE AVE",
        "NAME:NARUSKY, ROBERT J",
        "PHONE:(315) 672-3455",
        "INFO:NARUSKY, ROBERT J RESD 05/26 22:09:55",
        "SRC:WVE",
        "CITY:CAMILLUS",
        "X:ELDERKIN AVE AND KASTOR AVE",
        "UNIT:87A4  WVE1  EMS");

    doTest("T4",
        "(Dispatch) Dispatch ** 11:23:30 ** E-DIABETIC EMERGENCY ** 4611 W GENESEE ST ** FAIRMOUNT FD- **  **  **  **  ** PER 19 BASE\n" +
        " ** 05/26/12 ** DIAB ** WVE128700892 ** WVE ** Fire Station Dispatch Report   Dispatch Time:  05-26-2012  11:23:30\n" +
        "Agency: WVE \n" +
        "    Event: E12052600088\n\n" +
        "Case Number: WVE128700892\n" +
        "Event Type Code: DIAB DIABETIC EMERGENCY\n" +
        "Event Subtype Code:         \n\n" +
        "Address:\n" +
        "FAIRMOUNT FD\n" +
        "4611 W GENESEE ST \n" +
        "Location Info: \n\n" +
        "Municipality: TCM\n" +
        "Cross Street: MALE AVE AND TURNER AVE\n\n" +
        "Caller Information:\n\n" +
        "  Caller Name: \n" +
        "  Caller Phone Number: \n" +
        "  Caller Address: \n\n" +
        "Responding Units:\n\n" +
        "  87A4  WVE1  EMS\n" +
        "  \n\n" +
        "Event Comments:\n" +
        "PER 19 BASE\n" +
        "** Case number SHP ** TCM **  ** WV **  ** MALE AVE AND TURNER AVE **  ** A4, ** ",

        "TIME:11:23:30",
        "CALL:E-DIABETIC EMERGENCY",
        "ADDR:4611 W GENESEE ST",
        "PLACE:FAIRMOUNT FD",
        "INFO:PER 19 BASE",
        "SRC:WVE",
        "CITY:CAMILLUS",
        "X:MALE AVE AND TURNER AVE",
        "UNIT:87A4  WVE1  EMS");

    doTest("T5",
        "(Dispatch) Dispatch ** 11:00:32 ** E-CHEST PAIN POSSIBLE HEART ** 5101 W GENESEE ST ** -ST. JOSEPH DYALIS UNIT ** VELANTI,ELIZABETH ** (315) 488-2979 **  **  ** ST JOSEPH'S HOSPITAL HEALTH PBXb 05/26 10:55:50\n" +
        "SPECIAL ADDRESS COMMENT:\n" +
        "This record created by the CADAVU (Address Verification Utility) program.\n" +
        "IRREGULAR HEART RATE\n" +
        "Number of patients: 1\n" +
        "Respo ** 05/26/12 ** CARD ** WVE128700891 ** WVE ** Fire Station Dispatch Report  Dispatch Time:  05-26-2012  11:00:32\n" +
        "Agency: WVE \n" +
        "    Event: E12052600082\n\n" +
        "Case Number: WVE128700891\n" +
        "Event Type Code: CARD CHEST PAIN-POSS HEART\n" +
        "Event Subtype Code:         \n\n" +
        "Address:\n\n" +
        "5101 W GENESEE ST \n" +
        "Location Info: ST. JOSEPH DYALIS UNIT\n\n" +
        "Municipality: TCM\n" +
        "Cross Street: DUNNING DR AND STONEHEDGE RD\n\n" +
        "Caller Information:\n\n" +
        "  Caller Name: VELANTI,ELIZABETH\n" +
        "  Caller Phone Number: (315) 488-2979\n" +
        "  Caller Address: 5101 W GENESEE CAMILLUS_TOWN\n\n" +
        "Responding Un ** TCM **  ** WV **  ** DUNNING DR AND STONEHEDGE **  ** A3, ** ",

        "TIME:11:00:32",
        "CALL:E-CHEST PAIN POSSIBLE HEART",
        "ADDR:5101 W GENESEE ST",
        "PLACE:ST. JOSEPH DYALIS UNIT",
        "NAME:VELANTI,ELIZABETH",
        "PHONE:(315) 488-2979",
        "INFO:ST JOSEPH'S HOSPITAL HEALTH PBXb 05/26 10:55:50",
        "SRC:WVE",
        "CITY:CAMILLUS",
        "X:DUNNING DR AND STONEHEDGE RD");

    doTest("T6",
        "(Dispatch) Dispatch ** 10:07:49 ** E-MOTOR VEHICLE COLLISION-WITH INJURIES ** 5399 W GENESEE ST ** WALMART- **  ** (315) 406-0904 **  **  ** SPECIAL ADDRESS COMMENT:\n" +
        "CROSS STREETS ARE VANIDA DR AND KASSON RD\n" +
        "M911 CC IS EMPLOYEE SAYS 60'S FEMALE HIT A LIGHT POLE IN LOT-STATES NO INJ BUT\n" +
        "APPEARS SHAKEN\n" +
        " ** 05/26/12 ** MVC-I ** WVE128700890 ** WVE ** Fire Station Dispatch Report  Dispatch Time:  05-26-2012  10:07:49\n" +
        "Agency: WVE \n" +
        "    Event: E12052600068\n\n" +
        "Case Number: WVE128700890\n" +
        "Event Type Code: MVC  MOTOR VEHICLE COLLISION\n" +
        "Event Subtype Code: IB        INJURIES PRESENTED\n\n" +
        "Address:\n" +
        "WALMART\n" +
        "5399 W GENESEE ST \n" +
        "Location Info: \n\n" +
        "Municipality: TCM\n" +
        "Cross Street: VANIDA DR AND CAMILLUS COMMONS\n\n" +
        "Caller Information:\n\n" +
        "  Caller Name: \n" +
        "  Caller Phone Number: (315) 406-0904\n" +
        "  Caller Address: \n\n" +
        "Responding Units:\n\n" +
        "  87A3  WVE1  EMS\n" +
        "  \n\n" +
        "Event Co ** TCM **  ** WV **  ** VANIDA DR AND CAMILLUS CO **  ** A3, ** ",

        "TIME:10:07:49",
        "CALL:E-MOTOR VEHICLE COLLISION-WITH INJURIES",
        "ADDR:5399 W GENESEE ST",
        "PLACE:WALMART",
        "PHONE:(315) 406-0904",
        "INFO:SPECIAL ADDRESS COMMENT:",
        "SRC:WVE",
        "CITY:CAMILLUS",
        "X:VANIDA DR AND CAMILLUS COMMONS",
        "UNIT:87A3  WVE1  EMS");

    doTest("T7",
        "(Dispatch) Dispatch ** 22:00:39 ** E-EXPOSURE TO HEAT-Heat ** 1500 ELM CIR ** -APT 10 , ELM HILL ESTATES ** LAMONTAGNE,REIS ** (315) 382-6668 **  **  ** N SECTOR -076.270115 043.050849 CAUTION: WIRELESS CALL 05/27 21:57:20\n" +
        "HEART WAS RACING,SHAKY,LITTLE DISO\n" +
        "Number of patients: 1\n" +
        "Responder script: 27 year old, Male, Conscious, Breathing. Heat / Cold ** 05/27/12 ** EXPO-H ** WVE128700897 ** WVE ** Fire Station Dispatch Report   Dispatch Time:  05-27-2012  22:00:39\n" +
        "Agency: WVE \n" +
        "    Event: E12052700172\n\n" +
        "Case Number: WVE128700897\n" +
        "Event Type Code: EXPO EXPOSURE\n" +
        "Event Subtype Code: H       Heat\n\n" +
        "Address:\n\n" +
        "1500  ELM CIR \n" +
        "Location Info: APT 10 , ELM HILL ESTATES \n\n" +
        "Municipality: TCM\n" +
        "Cross Street: ARLINGTON SQ \n\n" +
        "Caller Information:\n\n" +
        "  Caller Name: LAMONTAGNE,REIS\n" +
        "  Caller Phone Number: (315) 382-6668\n" +
        "  Caller Address: \n\n" +
        "Responding Units:\n\n" +
        "  87A3  WVE1  EMS\n" +
        "  \n\n" +
        "Event Comments:\n" +
        "N SECTO ** TCM **  ** WV **  ** ARLINGTON SQ **  ** A3, ** ",

        "TIME:22:00:39",
        "CALL:E-EXPOSURE TO HEAT-Heat",
        "ADDR:1500 ELM CIR",
        "APT:10",
        "PLACE:ELM HILL ESTATES",
        "NAME:LAMONTAGNE,REIS",
        "PHONE:(315) 382-6668",
        "INFO:N SECTOR -076.270115 043.050849 CAUTION: WIRELESS CALL 05/27 21:57:20",
        "SRC:WVE",
        "CITY:CAMILLUS",
        "X:ARLINGTON SQ",
        "UNIT:87A3  WVE1  EMS");

    doTest("T8",
        "(Dispatch) Dispatch ** 10:35:32 ** E-GENERAL ILLNESS ** 401 ANSONIA CT ** -OFF W GENESEE ** MCINTYRE MARTHA ** (315) 399-4889 **  **  ** TWCBL MCINTYRE MARTHA VOIP 05/27 10:30:15\n" +
        "DRUG WITHDRAWEL\n" +
        "Number of patients: 1\n" +
        "Responder script: 62 year old, Female, Conscious, Breathing. Sick Person\n" +
        "(Specific Diagnosis). Caller Statement: DRU ** 05/27/12 ** GILL ** WVE128700896 ** WVE ** Fire Station Dispatch Report  Dispatch Time:  05-27-2012  10:35:32\n" +
        "Agency: WVE \n" +
        "    Event: E12052700064\n\n" +
        "Case Number: WVE128700896\n" +
        "Event Type Code: GILL GENERAL ILLNESS\n" +
        "Event Subtype Code:         \n\n" +
        "Address:\n\n" +
        "401  ANSONIA CT \n" +
        "Location Info: OFF W GENESEE\n\n" +
        "Municipality: TCM\n" +
        "Cross Street: VANTAGE DR \n\n" +
        "Caller Information:\n\n" +
        "  Caller Name: MCINTYRE MARTHA\n" +
        "  Caller Phone Number: (315) 399-4889\n" +
        "  Caller Address: 401 ANSONIA CT CAMILLUS_TOWN\n\n" +
        "Responding Units:\n\n" +
        "  87A3  WVE1  EMS\n" +
        "  \n\n" +
        "Event C ** TCM **  ** WV **  ** VANTAGE DR **  ** A3, ** ",

        "TIME:10:35:32",
        "CALL:E-GENERAL ILLNESS",
        "ADDR:401 ANSONIA CT",
        "PLACE:OFF W GENESEE",
        "NAME:MCINTYRE MARTHA",
        "PHONE:(315) 399-4889",
        "INFO:TWCBL MCINTYRE MARTHA VOIP 05/27 10:30:15",
        "SRC:WVE",
        "CITY:CAMILLUS",
        "X:VANTAGE DR",
        "UNIT:87A3  WVE1  EMS");

    doTest("T9",
        "(Dispatch) Dispatch ** 23:34:07 ** E-PERSONAL INJURY ** 5731 NORTH ST ** - ** GENDRON, DONALD ** (315) 345-9566 **  **  ** - DISORIENTED -\n" +
        "Number of patients: 1\n" +
        "Responder script: 91 year old, Female, Conscious, Breathing. Falls. Caller\n" +
        "Statement: - DISORIENTED - .\n" +
        "- DISORIENTED -\n" +
        "Response text: Delta\n" +
        "Responder scrip ** 05/26/12 ** PINJ ** WVE128700895 ** WVE ** Fire Station Dispatch Report  Dispatch Time:  05-26-2012  23:34:07\n" +
        "Agency: WVE \n" +
        "    Event: E12052600232\n\n" +
        "Case Number: WVE128700895\n" +
        "Event Type Code: PINJ PERSONAL INJURY\n" +
        "Event Subtype Code:         \n\n" +
        "Address:\n\n" +
        "5731  NORTH ST \n" +
        "Location Info: \n\n" +
        "Municipality: TCM\n" +
        "Cross Street: RYAN WAY \n\n" +
        "Caller Information:\n\n" +
        "  Caller Name: GENDRON, DONALD\n" +
        "  Caller Phone Number: (315) 345-9566\n" +
        "  Caller Address: \n\n" +
        "Responding Units:\n\n" +
        "  87A4  WVE1  EMS\n" +
        "  \n\n" +
        "Event Comments:\n" +
        "- DISORIENTED -\n" +
        "Number of patient ** TCM **  ** WV **  ** RYAN WAY **  ** A4, ** ",

        "TIME:23:34:07",
        "CALL:E-PERSONAL INJURY",
        "ADDR:5731 NORTH ST",
        "NAME:GENDRON, DONALD",
        "PHONE:(315) 345-9566",
        "INFO:- DISORIENTED -",
        "SRC:WVE",
        "CITY:CAMILLUS",
        "X:RYAN WAY",
        "UNIT:87A4  WVE1  EMS");

    doTest("T10",
        "(Dispatch) Dispatch ** 02:15:19 ** E-DIFFICULTY BREATHING ** 133 EAGLE CREST DR ** - ** GRECCO, JAMES ** (315) 672-9739 **  **  ** TWCBL GRECCO, JAMES VOIP 05/28 02:13:59\n" +
        "DIFB\n" +
        "Number of patients: 1\n" +
        "Responder script: 14 year old, Male, Conscious, Breathing. Breathing Problems.\n" +
        "Caller Statement: DIFB.\n" +
        "Response text: Delta\n" +
        "Res ** 05/28/12 ** DIFB ** WVE128700898 ** WVE ** Fire Station Dispatch Report  Dispatch Time:  05-28-2012  02:15:19\n" +
        "Agency: WVE \n" +
        "    Event: E12052800019\n\n" +
        "Case Number: WVE128700898\n" +
        "Event Type Code: DIFB DIFFICULTY BREATHING\n" +
        "Event Subtype Code:         \n\n" +
        "Address:\n\n" +
        "133  EAGLE CREST DR \n" +
        "Location Info: \n\n" +
        "Municipality: TCM\n" +
        "Cross Street: IKE DIXON RD AND RAIL FENCE RD\n\n" +
        "Caller Information:\n\n" +
        "  Caller Name: GRECCO, JAMES\n" +
        "  Caller Phone Number: (315) 672-9739\n" +
        "  Caller Address: 133 EAGLE CREST DR CAMILLUS_TOWN\n\n" +
        "Responding Units:\n\n" +
        "  87A3  WVE1   ** TCM **  ** WV **  ** IKE DIXON RD AND RAIL FEN **  ** A3, ** ",

        "TIME:02:15:19",
        "CALL:E-DIFFICULTY BREATHING",
        "ADDR:133 EAGLE CREST DR",
        "NAME:GRECCO, JAMES",
        "PHONE:(315) 672-9739",
        "INFO:TWCBL GRECCO, JAMES VOIP 05/28 02:13:59",
        "SRC:WVE",
        "CITY:CAMILLUS",
        "X:IKE DIXON RD AND RAIL FENCE RD",
        "UNIT:87A3  WVE1");
 }
  
  public static void main(String[] args) {
    new NYOnondagaCountyCParserTest().generateTests("T1");
  }
}
