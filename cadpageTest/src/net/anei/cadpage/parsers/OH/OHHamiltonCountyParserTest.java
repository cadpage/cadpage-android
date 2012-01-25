package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class OHHamiltonCountyParserTest extends BaseParserTest {
  
  public OHHamiltonCountyParserTest() {
    setParser(new OHHamiltonCountyParser(), "HAMILTON COUNTY", "OH");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "HC:STRUCTURE FIRE 8877 DE SOTO DR SPTP NEISHA COOK/NGHBR ** STRUCTURE FIRE ** INV REF.. SMOKE & FLAMES VISIBLE FROM THE ROOF.. RESD POSS UNOCC, COMPL A 22:43 HFE75 HFE74 HFQ79 HFQ78 HFR79 HFS26 HFRAT97 HFFG3 HFIMAT79 XST: 1331 ANGELA AV XST",
        "ADDR:8877 DESOTO DR",
        "CITY:SPRINGFIELD TWP",
        "PLACE:NEISHA COOK / NGHBR",
        "CALL:STRUCTURE FIRE",
        "INFO:INV REF.. SMOKE & FLAMES VISIBLE FROM THE ROOF.. RESD POSS UNOCC, COMPL A",
        "UNIT:HFE75 HFE74 HFQ79 HFQ78 HFR79 HFS26 HFRAT97 HFFG3 HFIMAT79",
        "X:1331 ANGELA AV XST");

    doTest("T2",
        "HC:STRUCTURE FIRE 12135 SPALDING DR COTP MATT GITTERMAN ** STRUCTURE FIRE ** ODOR OF PLASTIC BURNING LIGHT SMOKE FROM AN ATTIC VENT...CEILING IN THE K 06:47 HFE109 HFE102 HFE42 HFL25 HFL42 HFS25 HFRAT25 HFFG3 HFIMAT25 XST: 12037 WESTERLY DR",
        "ADDR:12135 SPALDING DR",
        "CITY:COLERAIN TWP",
        "PLACE:MATT GITTERMAN",
        "CALL:STRUCTURE FIRE",
        "INFO:ODOR OF PLASTIC BURNING LIGHT SMOKE FROM AN ATTIC VENT...CEILING IN THE K",
        "UNIT:HFE109 HFE102 HFE42 HFL25 HFL42 HFS25 HFRAT25 HFFG3 HFIMAT25",
        "X:12037 WESTERLY DR");

    doTest("T3",
        "HC:STRUCTURE FIRE W CRESCENTVILLE RD&SPRINGFIELD SPDL PLANT MAINT ENG WIRELESS-VERIZON WIR ** STRUCTURE FIRE ** ROOF VENT ON FIRE 14:10 HFE90 HFE43 HFT90 HFT86 HFM90 HFFRFDM32 HFRAT96 HFFG5",
        "ADDR:W CRESCENTVILLE RD & SPRINGFIELD",
        "CITY:SPRINGDALE",
        "PLACE:PLANT MAINT ENG WIRELESS-VERIZON WIR",
        "CALL:STRUCTURE FIRE",
        "INFO:ROOF VENT ON FIRE",
        "UNIT:HFE90 HFE43 HFT90 HFT86 HFM90 HFFRFDM32 HFRAT96 HFFG5");

    doTest("T4",
        "HC:A/A - INJURY LEMONTREE DR&MILL RD FRPK INTERSECTION T-MOBILE USA, INC. ** AUTO ACCIDENT / PERSON INJURED ** INV FOR A 2 VEH, MC VS A VEH 14:53 HFM242 HFE42 HFL42 HFFG2",
        "ADDR:LEMONTREE DR & MILL RD",
        "CITY:FOREST PARK",
        "PLACE:INTERSECTION T-MOBILE USA, INC",
        "CALL:AUTO ACCIDENT / PERSON INJURED",
        "INFO:INV FOR A 2 VEH, MC VS A VEH",
        "UNIT:HFM242 HFE42 HFL42 HFFG2");

    doTest("T5",
        "HC:PSYCHIATRIC EMER 5 BELKNAP PL GREN DOROTHY, MOM ** PSYCHIATRIC EMERGENCY ** C C REF 5 YO BEHAVING VIOLENTLY, ACTING OUT. HX OF BEHAVIORAL ISSUES. 16:59 HFS48 XST: 14 BACHMAN ST XST2: 26 BACHMAN ST",
        "ADDR:5 BELKNAP PL",
        "CITY:GREENHILLS",
        "PLACE:DOROTHY, MOM",
        "CALL:PSYCHIATRIC EMERGENCY",
        "INFO:C C REF 5 YO BEHAVING VIOLENTLY, ACTING OUT. HX OF BEHAVIORAL ISSUES.",
        "UNIT:HFS48",
        "X:14 BACHMAN ST & 26 BACHMAN ST");

    doTest("T6",
        "HC:FIRE ALARM 1086 PENNINGTON CT FRPK CHRISTINE ** FIRE ALARM ** INV...NOTHING SHOWING..COMP BELIEVES IT COULD BE A MALFUNTION WITH ALARM. 09:08 HFE43 HFL42 HFFG3 XST2: 11551 PROMENADE DR",
        "ADDR:1086 PENNINGTON CT",
        "CITY:FOREST PARK",
        "PLACE:CHRISTINE",
        "CALL:FIRE ALARM",
        "INFO:INV...NOTHING SHOWING..COMP BELIEVES IT COULD BE A MALFUNTION WITH ALARM.",
        "UNIT:HFE43 HFL42 HFFG3",
        "X:11551 PROMENADE DR");

    doTest("T7",
        "HC:NON-BREATHER 37 GAMBIER CR GREN MICHEAL MARCUM ** NON-BREATHER / CARDIAC ARREST ** M/70'S, COMP CAN SEE M SUBJ LAYING ON THE FLOOR OF THE RESD THRU A WINDOW 20:29 HFS48 HFQ48 HFFG5 XST: 300 INGRAM RD XST2: 300 INGRAM RD",
        "ADDR:37 GAMBIER CR",
        "MADDR:37 GAMBIER CIR",
        "CITY:GREENHILLS",
        "PLACE:MICHEAL MARCUM",
        "CALL:NON-BREATHER / CARDIAC ARREST",
        "INFO:M/70'S, COMP CAN SEE M SUBJ LAYING ON THE FLOOR OF THE RESD THRU A WINDOW",
        "UNIT:HFS48 HFQ48 HFFG5",
        "X:300 INGRAM RD & 300 INGRAM RD");

    doTest("T8",
        "HC:UNCONSCIOUS PERSON 22 JEWEL LN GREN TIM SHEEIN ** PERSON UNCONSCIOUS / NON-RESPONSIVE ** F/46 DISORIENTED, POSS REACTION TO MEDS FOR MIGRANES 20:33 HFM242 HFGRES XST: 158 JUNEFIELD AV XST2: 168 JUNEDALE DR",
        "ADDR:22 JEWEL LN",
        "CITY:GREENHILLS",
        "PLACE:TIM SHEEIN",
        "CALL:PERSON UNCONSCIOUS / NON-RESPONSIVE",
        "INFO:F/46 DISORIENTED, POSS REACTION TO MEDS FOR MIGRANES",
        "UNIT:HFM242 HFGRES",
        "X:158 JUNEFIELD AV & 168 JUNEDALE DR");

    doTest("T9",
        "HC:APPLIANCE FIRE 616 DEWDROP CR FRPK APT C CHRISTINA ** APPLIANCE FIRE ** GREASE FIRE ON THE STOVE 21:03 HFE43 HFE296 HFE97 HFE45 HFT90 HFL97 HFS97 HFRAT79 HFFG2 XST: 599 ASHBURN RD XST2: 601 DINSMORE DR",
        "ADDR:616 DEWDROP CR",
        "MADDR:616 DEWDROP CIR",
        "CITY:FOREST PARK",
        "APT:C",
        "PLACE:CHRISTINA",
        "CALL:APPLIANCE FIRE",
        "INFO:GREASE FIRE ON THE STOVE",
        "UNIT:HFE43 HFE296 HFE97 HFE45 HFT90 HFL97 HFS97 HFRAT79 HFFG2",
        "X:599 ASHBURN RD & 601 DINSMORE DR");

    doTest("T10",
        "HC:STRUCTURE FIRE 70 DAMON RD GREN ALOIS ALZHEIMER CTR STEPHANIE ** STRUCTURE FIRE ** INVS SMOKE FILLING HALLS 05:05 HFQ48 HFE42 HFE109 HFE75 HFR78 HFL42 HFM96 HFRAT74 HFFG2 HFIMAT48 XST: 1200 SPRINGDALE RD XST2: 48 CROMWELL RD",
        "ADDR:70 DAMON RD",
        "CITY:GREENHILLS",
        "PLACE:ALOIS ALZHEIMER CTR STEPHANIE",
        "CALL:STRUCTURE FIRE",
        "INFO:INVS SMOKE FILLING HALLS",
        "UNIT:HFQ48 HFE42 HFE109 HFE75 HFR78 HFL42 HFM96 HFRAT74 HFFG2 HFIMAT48",
        "X:1200 SPRINGDALE RD & 48 CROMWELL RD");
     
  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "HC:FIRE ALARM 6855 ALBERLY LN INDN GENTILE RESD INDN PD ** FIRE ALARM ** GENERAL 02:47 HFE64 HFQ65 HFFG3 XST: 9200 SHAWNEE RUN RD",
        "ADDR:6855 ALBERLY LN",
        "CITY:INDIAN HILL",
        "PLACE:GENTILE RESD INDN PD",
        "CALL:FIRE ALARM",
        "INFO:GENERAL",
        "UNIT:HFE64 HFQ65 HFFG3",
        "X:9200 SHAWNEE RUN RD");

    doTest("T2",
        "HC:FIRE ALARM 7141 MIAMI AV MDRA MDRA PD CAROL/ADT ** FIRE ALARM ** INV GEN FIRE ALARM, ZONE F1 AND SUPERVISORY TRBL SIGNAL ON E1. 01 1:24 HFQ65 XST:",
        "ADDR:7141 MIAMI AV",
        "MADDR:7141 MIAMI AVE",
        "CITY:MADEIRA",
        "PLACE:MDRA PD CAROL / ADT",
        "CALL:FIRE ALARM",
        "INFO:INV GEN FIRE ALARM, ZONE F1 AND SUPERVISORY TRBL SIGNAL ON E1. 01",
        "UNIT:HFQ65");

    doTest("T3",
        "HC:FIRE ALARM 7141 MIAMI AV MDRA MDRA PD ADT..NOTIFING ** FIRE ALARM ** INV FOR..ZONE F1 FIRE ALARM ACTIVATION OPER/BEX 02:00 HF IGH BP WITH SOME",
        "ADDR:7141 MIAMI AV",
        "MADDR:7141 MIAMI AVE",
        "CITY:MADEIRA",
        "PLACE:MDRA PD ADTNOTIFING",
        "CALL:FIRE ALARM",
        "INFO:INV FOR..ZONE F1 FIRE ALARM ACTIVATION OPER/BEX",
        "UNIT:HF IGH BP WITH SOME");

    doTest("T4",
        "HC:FIRE ALARM 7280 TANGLERIDGE LN INDN FELLER RESD RANGERS ** FIRE ALARM ** GENERAL FIRE ALRM 07:41 HFE64 HFQ65 HFFG2 XST: 8300 OLD STABLE",
        "ADDR:7280 TANGLERIDGE LN",
        "CITY:INDIAN HILL",
        "PLACE:FELLER RESD RANGERS",
        "CALL:FIRE ALARM",
        "INFO:GENERAL FIRE ALRM",
        "UNIT:HFE64 HFQ65 HFFG2",
        "X:8300 OLD STABLE");

    doTest("T5",
        "HC:FIRE ALARM 7850 TECUMSEH TL INDN INDN PD ** FIRE ALARM ** INV GEN FIRE ALARM. 02:17 HFE89 HFE92 HFFG3 HFMDRF XST: 4497 MIAMI RD",
        "ADDR:7850 TECUMSEH TL",
        "MADDR:7850 TECUMSEH TRL",
        "CITY:INDIAN HILL",
        "PLACE:INDN PD",
        "CALL:FIRE ALARM",
        "INFO:INV GEN FIRE ALARM.",
        "UNIT:HFE89 HFE92 HFFG3 HFMDRF",
        "X:4497 MIAMI RD");

    doTest("T6",
        "HC:TROUBLE BREATHING 5545 DRAKE RD INDN GLORIA ** TROUBLE BREATHING ** 87YO FEMALE...TRBL BREATHING 11:21 HFM65 XST: 8298 BRILL RD XST2: 8260 GRAVES RD",
        "ADDR:5545 DRAKE RD",
        "CITY:INDIAN HILL",
        "PLACE:GLORIA",
        "CALL:TROUBLE BREATHING",
        "INFO:87YO FEMALE...TRBL BREATHING",
        "UNIT:HFM65",
        "X:8298 BRILL RD & 8260 GRAVES RD");

    doTest("T7",
        "HC:WIRES DOWN 6506 KENWOOD RD MDRA ISSIAH ** WIRES DOWN / ARCING / ON FIRE ** C/COMP REF LOW-HANGING POWER LINES 00:01 HFQ65 XST: 6450 NAVAHO TL XST2: 6400 DAWSON RD",
        "ADDR:6506 KENWOOD RD",
        "CITY:MADEIRA",
        "PLACE:ISSIAH",
        "CALL:WIRES DOWN / ARCING / ON FIRE",
        "INFO:C/COMP REF LOW-HANGING POWER LINES",
        "UNIT:HFQ65",
        "X:6450 NAVAHO TL & 6400 DAWSON RD");
  }
  
  @Test
  public void testParser3() {

    doTest("T1",
        "HC:CO ALARM 1737 HARMON DR WYOM LARRY MEYER ** CARBON MONOXIDE ALARM ** C/COMPL REF CO ALARM SOUNDING INTERMITTENTLY - COMPL IS HOOKED UP TO DIAL 05:28 HFE97 HFFG2 XST: ROLLING HILLS DR XST2: 1799 WOODRUFF LN",
        "ADDR:1737 HARMON DR",
        "CITY:WYOMING",
        "PLACE:LARRY MEYER",
        "CALL:CARBON MONOXIDE ALARM",
        "INFO:C/COMPL REF CO ALARM SOUNDING INTERMITTENTLY - COMPL IS HOOKED UP TO DIAL",
        "UNIT:HFE97 HFFG2",
        "X:ROLLING HILLS DR & 1799 WOODRUFF LN");

    doTest("T2",
        "HC:MEDICAL ALARM 719 OAK AV WYOM RESD WHITE ADT-MVS ** MEDICAL ALARM ** THIRD PARTY FRM THE CITY.ADT CONTACTED THEM FOR A MEDICAL ALARM WITH NO V 11:18 HFE97 XST: 500 DAVID J SAVAGE W XST2: 398 WASHINGTON AV",
        "ADDR:719 OAK AV",
        "MADDR:719 OAK AVE",
        "CITY:WYOMING",
        "PLACE:RESD WHITE ADT-MVS",
        "CALL:MEDICAL ALARM",
        "INFO:THIRD PARTY FRM THE CITY.ADT CONTACTED THEM FOR A MEDICAL ALARM WITH NO V",
        "UNIT:HFE97",
        "X:500 DAVID J SAVAGE W & 398 WASHINGTON AV");

    doTest("T3",
        "HC:ODOR OF GAS 800 OAK AV WYOM WYOMING CITY HALL-1ST FLOOR REILAG 9701 ** SMELL OF GAS ** INV ODOR OF NATURAL GAS ON FIRST FLOOR----C9701 IS ENROUTE..... 09:05 HFE97 HFR97 HFFG2 XST: 398 WASHINGTON AV XST2: 498 PENDERY AV",
        "ADDR:800 OAK AV",
        "MADDR:800 OAK AVE",
        "CITY:WYOMING",
        "PLACE:WYOMING CITY HALL-1ST FLOOR REILAG 9701",
        "CALL:SMELL OF GAS",
        "INFO:INV ODOR OF NATURAL GAS ON FIRST FLOOR----C9701 IS ENROUTE.....",
        "UNIT:HFE97 HFR97 HFFG2",
        "X:398 WASHINGTON AV & 498 PENDERY AV");

    doTest("T4",
        "HC:NON-BREATHER 1227 SPRINGFIELD PI WYOM GRACEWORKS ENHANCED LIVIN LINDA STEELE ** TROUBLE BREATHING ** F/40 04:24 HFE297 XST: 2 CHESTNUT AV XST2: 1 RITCHIE AV",
        "ADDR:1227 SPRINGFIELD PI",
        "MADDR:1227 SPRINGFIELD PIKE",
        "CITY:WYOMING",
        "PLACE:GRACEWORKS ENHANCED LIVIN LINDA STEELE",
        "CALL:TROUBLE BREATHING",
        "INFO:F/40",
        "UNIT:HFE297",
        "X:2 CHESTNUT AV & 1 RITCHIE AV");

    doTest("T5",
        "HC:ODOR OF GAS 61 W SHARON RD GLEN ** SMELL OF GAS ** BR45 ON SCENE 11:50 HFR97 XST: 1001 CHURCH ST XST2: 999 SUMMIT AV:",
        "ADDR:61 W SHARON RD",
        "CITY:GLENDALE",
        "CALL:SMELL OF GAS",
        "INFO:BR45 ON SCENE",
        "UNIT:HFR97",
        "X:1001 CHURCH ST & 999 SUMMIT AV:");
    
  }
  
  public static void main(String[] args) {
    new OHHamiltonCountyParserTest().generateTests("T1", "ADDR CITY APT PLACE CALL INFO UNIT X");
  }
}