package net.anei.cadpage.parsers.GA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Camden County, GA
Contact: charles <croney@kingslandgeorgia.com>
Contact:  Jeff <kfr438@tds.net>
Contact: Scott Gregory <kfr436@gmail.com>
Contact: "bcarreira tds.net" <bcarreira@tds.net>
Contact: "w1kfr tds.net" <w1kfr@tds.net>
Contact: "Donald M. Doyle" <dmdoyle@co.camden.ga.us>
Sender: astudstill@co.camden.ga.us

astudstill@co.camden.ga.us:2011-101695* HIGHWAY 17 STEFFANS* * * KINGSLAND* * Traffic Stop* TRAFFIC STOP* * * 1128,1140,1150,1152,509,514,523,532,LS3,R3* * Med
astudstill@co.camden.ga.us:2011-104696* 4059 MARTIN LUTHER KING BLVD* N4* * 514,541,546,ENG4,LS4,MED4 KINGSLAND* * INJURY* INJURY* 509,ENG5,LS3* * Medical: No
astudstill@co.camden.ga.us:2011-101995* 405 & HIGHWAY 40 OLD WAFFLE HOUSE* * * KINGSLAND* * ACCIDENT* ACCIDENT* ELAINE* 386-208-4465* 514,541,546,ENG4,LS4,MED4
astudstill@co.camden.ga.us:2011-104843* 429 EAGLE BLVD* * * KINGSLAND* * PERSON SICK* PERSON SICK* * 540,ENG4,LS4* * Medical: No* Haz
214 REDWOOD ST* * * KINGSLAND* * PERSON SICK* PERSON SICK* MS FAGEN*912-269-6157* LS3,R3* * Medical: No* Hazards: No* 
astudstill@co.camden.ga.us:2011-181161* ADVANCE COLLISION CENTER* * * KINGSLAND* * WIRE DOWN* WIRE DOWN* JOHN* 316-258-1559* ENG4,LS4* * Medical: No* Haz
astudstill@co.camden.ga.us:2012-037466* BOONE AND SUMMERBROOK* * * KINGSLAND* * INVESTIGATE* INVESTIGATE SUSPICIOUS PERSON/VEHICLE* JUAN RODRIGUEZ* 912-8
astudstill@co.camden.ga.us:2012-142354* CMC* * * ST MARYS* * * * * TRANSFER* TRANSFER TO ... (MEDICAL OR FIRE)* * * MED3* * Medical: No* Hazards: No* Lin
astudstill@co.camden.ga.us:2012-142422* 119 TERESA LN* * * KINGSLAND* * * * * DOMESTIC* DOMESTIC PROBLEM* HUNTER* 912-576-1327* 525,531,544,LS3,R3* * Med
astudstill@co.camden.ga.us:2012-142419* CMC TO SHANDS* * * KINGSLAND* * * * * TRANSFER* TRANSFER TO ... (MEDICAL OR FIRE)* * * MED4* * Medical: No* Hazar
astudstill@co.camden.ga.us:2012-142755* 102 ALMOND CIR* * * KINGSLAND* * * * * UNCONSCIOUS* UNCONSCIOUS PERSON* * 912-674-6173* 542,ENG4,LS4* * Medical: 
astudstill@co.camden.ga.us:2012-142422* 119 TERESA LN* * * KINGSLAND* * * * * DOMESTIC* DOMESTIC PROBLEM* HUNTER* 912-576-1327* 525,531,544,LS3,R3* * Med
astudstill@co.camden.ga.us:2012-143146* 200 CHESTNUT CT* * * KINGSLAND* * * * * INJURY* INJURY* * 912- -* 511,ENG4,KFD,LS4* * Medical: No* Hazards: No* L
astudstill@co.camden.ga.us:2012-142419* CMC TO SHANDS* * * KINGSLAND* * * * TRANSFER* TRANSFER TO ... (MEDICAL OR FIRE)* * * MED4* * Medical: No* Hazar
astudstill@co.camden.ga.us:2012-142222* STATION 4* * * KINGSLAND* * * * PERSON SICK* PERSON SICK* * * ENG4,LS4* * Medical: No* Hazards: No* Line18=*
astudstill@co.camden.ga.us:2012-142193* 2060 HWY 40 E* * * KINGSLAND* * * * FIRE ALARM* FIRE ALARM* * * ENG4,LS2,FIRE3,FIRE4,Q9,LAD3,ENG3,ENG5* Medic
astudstill@co.camden.ga.us:2012-142755* 102 ALMOND CIR* * * KINGSLAND* * * * UNCONSCIOUS* UNCONSCIOUS PERSON* * 912-674-6173* 542,ENG4,LS4* * Medical:
astudstill@co.camden.ga.us:2012-143345* SATILLA TO CMC* * * KINGSLAND* * * * * TRANSPORT* PICKUP PRISONER/SUBJECT* * * MED3* * Medical: No* Hazards: No* 
astudstill@co.camden.ga.us:2012-143364* CMC* * * ST MARYS* * * * * TRANSPORT* PICKUP PRISONER/SUBJECT* * * MED3* * Medical: No* Hazards: No* Line18=*
astudstill@co.camden.ga.us:2012-143368* 955 S GROVE BLVD* LOT 42* * KINGSLAND* * * * * BREATHING* DIFFICULTY BREATHING* DESTINY* 912- -* 526,542,KFD,LS3,
astudstill@co.camden.ga.us:* 105 MILLERS BRANCH DR* * * ST MARYS* * * * * SMOKE INVEST* SMOKE INVESTIGATION* * 541-231-9242* LS4* * Medical: No* Hazards:
astudstill@co.camden.ga.us:2012-146148* HADDOCK DR // CISCO GAS STATION* * * KINGSLAND* * * * * ACCIDENT* ACCIDENT* * * 539,545,ENG4,LS3* * Medical: No* 
astudstill@co.camden.ga.us:2012-146395* 517 E WILLIAMS AVE* * * KINGSLAND* * * * * BREATHING* DIFFICULTY BREATHING* * * LS3,R3* * Medical: No* Hazards: N
astudstill@co.camden.ga.us:2012-146519* 115 ALMOND CIR* * * KINGSLAND* * * * * UNCONSCIOUS* UNCONSCIOUS PERSON* * * ENG4,KFD,LS4* * Medical: No* Hazards:
astudstill@co.camden.ga.us:2012-146584* 720 S LEE ST* * * KINGSLAND* * * * * WELFARE CHK* WELFARE CHECK* * * 532,LS3,R3* * Medical: No* Hazards: No* Line

Contact: Active911
Agency name: Camden County Fire Rescue Location: Kingsland, GA 
Sender: astudstill@co.camden.ga.us,messaging@iamresponding.com

(Message Forwarded by PageGate) 2012-150182*\n115 SPINNAKER CIR*\n*\n*\n*\n*\n*\n*\n*\nPERSON SICK*\nPERSON SICK*\n*\n*\nLS4*\n*\nMedical: No*\nHazards: No*\nLine18=*
(Message Forwarded by PageGate) 2012-150236*\n99 KINLAW RD*\n*\n*\nWOODBINE*\n*\n*\n*\n*\nGAS LEAK*\nHAZ-MAT INCIDENT*\n*\n*\n1132,LS3*\n*\nMedical: No*\nHazards: No*\nLine18=*
(Message Forwarded by PageGate) 2012-150237*\n590 BURNT FORT RD*\n*\n*\nWHITE OAK*\n*\n*\n*\n*\nBREATHING*\nDIFFICULTY BREATHING*\n*\n*\nLS1*\n*\nMedical: No*\nHazards: No*\nLine18=*
(Message Forwarded by PageGate) 2012-150239*\n405 NB 23*\n*\n*\nWOODBINE*\n*\n*\n*\n*\nINVESTIGATE*\nINVESTIGATE SUSPICIOUS PERSON/VEHICLE*\n*\n*\n1160,LS7*\n*\nMedical: No*\nHazards: No*\nLine18=*
(Message Forwarded by PageGate) 2012-150245*\n1385 SCRUBBY BLUFF RD*\n*\n*\nKINGSLAND*\n*\n*\n*\n*\nPERSON SICK*\nPERSON SICK*\n*\n*\nLS2*\n*\nMedical: No*\nHazards: No*\nLine18=*
(Message Forwarded by PageGate) 2012-150294*\nHWY 17 NB BLUE BRIDGE*\n*\n*\nKINGSLAND*\n*\n*\n*\n*\nINVESTIGATE*\nINVESTIGATE SUSPICIOUS PERSON/VEHICLE*\n*\n*\nLS3*\n*\nMedical: No*\nHazards: No*\nLine18=*
(Message Forwarded by PageGate) 2012-150378*\nHILL TOP TERRACE*\nR-2*\n*\nKINGSLAND*\n*\n*\n*\n*\nPERSON SICK*\nPERSON SICK*\nPENNIE GODWIN*\n904-405-5153*\nLS3*\n*\nMedical: No*\nHazards: No*\nLine18=*
(Message Forwarded by PageGate) 2012-150550*\n805 DILWORTH ST*\n*\n*\nST MARYS*\n*\n*\n*\n*\nBREATHING*\nDIFFICULTY BREATHING*\nSHIRLEY*\n912-882-4281*\nLS2*\n*\nMedical: No*\nHazards: No*\nLine18=*
(Message Forwarded by PageGate) 2012-150608*\n10-61*\n*\n*\n*\n*\n*\n*\n*\nSECURITY CHK*\nSECURITY CHECK*\n*\n*\nLS4,513*\n*\nMedical: No*\nHazards: No*\nLine18=*
(Message Forwarded by PageGate) 2012-150614*\nMISSION FOREST APTS*\n*\n*\n*\n*\n*\n*\n*\nFIRE*\nFIRE*\n*\n*\nLS4,Q9*\n*\nMedical: No*\nHazards: No*\nLine18=*
(CCFR) 2012-150818*\n\n1351 BOONE ST*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\nINJURY*\n\nINJURY*\n\n*\n\n*\n\nLS4*\n\n*\n\nMedical: No*\n\nHazards: No*
(CCFR) 2012-150893*\n\nHWY 40 ARBYS*\n\n*\n\n*\n\nST MARYS*\n\n*\n\n*\n\n*\n\n*\n\nACCIDENT*\n\nACCIDENT*\n\n*\n\n*\n\n118,119,LS2*\n\n*\n\nMedical: No*\n\nHazards: No*
(CCFR) 2012-150894*\n\n1119 DOUGLAS DR*\n\n122*\n\n*\n\nST MARYS*\n\n*\n\n*\n\n*\n\n*\n\nFIRE*\n\nFIRE*\n\n*\n\n*\n\nLS4*\n\n*\n\nMedical: No*\n\nHazards: No*
(CCFR) 2012-150922*\n\n1106 OLD JEFFERSON HWY*\n\n*\n\n*\n\nWOODBINE*\n\n*\n\n*\n\n*\n\n*\n\nPERSON SICK*\n\nPERSON SICK*\n\n*\n\n*\n\nLS1*\n\n*\n\nMedical: No*\n\nHazards: No*
(CCFR) 2012-151031*\n\nLUCKY DAWG*\n\n*\n\n*\n\nST MARYS*\n\n*\n\n*\n\n*\n\n*\n\nUNCONSCIOUS*\n\nUNCONSCIOUS PERSON*\n\n*\n\n*\n\nLS2*\n\n*\n\nMedical: No*\n\nHazards: No*
(CCFR) 2012-151141*\n\n27 PINEHURST DR*\n\n*\n\n*\n\nST MARYS*\n\n*\n\n*\n\n*\n\n*\n\nPERSON SICK*\n\nPERSON SICK*\n\n*\n\n*\n\nLS2*\n\n*\n\nMedical: No*\n\nHazards: No*
(CCFR) 2012-151227*\n\nHWY 17 // CATFISH CREEK BRIDGE*\n\n*\n\n*\n\nKINGSLAND*\n\n*\n\n*\n\n*\n\n*\n\nACCIDENT INJ*\n\nACCIDENT WITH INJURIES*\n\n*\n\n*\n\nLS4*\n\n*\n\nMedical: No*\n\nHazards: No*
(CCFR) 2012-151288*\n\n4059 MARTIN LUTHER KING BLVD*\n\nH-3*\n\n*\n\nKINGSLAND*\n\n*\n\n*\n\n*\n\n*\n\nPUBLIC SERV*\n\nPUBLIC SERVICE (FIRE,EMS)*\n\n*\n\n*\n\nLS3*\n\n*\n\nMedical: No*\n\nHazards: No*
(CCFR) 2012-151320*\n\n129 WOODVALLEY DR*\n\n*\n\n*\n\nKINGSLAND*\n\n*\n\n*\n\n*\n\n*\n\nBREATHING*\n\nDIFFICULTY BREATHING*\n\n*\n\n*\n\nLS4*\n\n*\n\nMedical: No*\n\nHazards: No*
(CCFR) 2012-151359*\n\n163 SEXTANT CIR*\n\n*\n\n*\n\nST MARYS*\n\n*\n\n*\n\n*\n\n*\n\nPERSON SICK*\n\nPERSON SICK*\n\n*\n\n*\n\n124,LS2*\n\n*\n\nMedical: No*\n\nHazards: No*
(CCFR) 2012-151365*\n\n377 VICKI LN*\n\n*\n\n*\n\nKINGSLAND*\n\n*\n\n*\n\n*\n\n*\n\nPERSON SICK*\n\nPERSON SICK*\n\n*\n\n*\n\nLS4*\n\n*\n\nMedical: No*\n\nHazards: No*
(CCFR) 2012-151320*\n\n129 WOODVALLEY DR*\n\n*\n\n*\n\nKINGSLAND*\n\n*\n\n*\n\n*\n\n*\n\nBREATHING*\n\nDIFFICULTY BREATHING*\n\n*\n\n*\n\nLS4*\n\n*\n\nMedical: No*\n\nHazards: No*
(CCFR) 2012-151466*\n\n302 FINLEY ST*\n\n*\n\n*\n\nST MARYS*\n\n*\n\n*\n\n*\n\n*\n\nBREATHING*\n\nDIFFICULTY BREATHING*\n\nMS BRADLEY*\n\n912-729-3501*\n\n110,LS2*\n\n*\n\nMedical: No*\n\nHazards: No*
(CCFR) 2012-151483*\n\n1947 COMMERCE DR*\n\n*\n\n*\n\nKINGSLAND*\n\n*\n\n*\n\n*\n\n*\n\nCHOKING*\n\nPERSON CHOKING*\n\n*\n\n912-   -*\n\nLS4*\n\n*\n\nMedical: No*\n\nHazards: No*
(CCFR) 2012-151492*\n\nFIRST DIRT RD BROWNTOWN STORE*\n\n*\n\n*\n\nBROWNTOWN*\n\n*\n\n*\n\n*\n\n*\n\nACCIDENT INJ*\n\nACCIDENT WITH INJURIES*\n\nAMANDA FLEMMING*\n\n912-506-3453*\n\nLS3*\n\n*\n\nMedical: No*\n\nHazards: No*
(CCFR) 2012-151495*\n\n289 LANDING CIR*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\nPERSON SICK*\n\nPERSON SICK*\n\n*\n\n*\n\nLS4*\n\n*\n\nMedical: No*\n\nHazards: No*
(CCFR) 2012-151492*\n\nFIRST DIRT RD BROWNTOWN STORE*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\nACCIDENT INJ*\n\nACCIDENT WITH INJURIES*\n\n*\n\n*\n\n1123,1126,1187,E15,LS3*\n\n*\n\nMedical: No*\n\nHazards: No*
(CCFR) 2012-151500*\n\n594 MUSH BLUFF RD*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\nPERSON SICK*\n\nPERSON SICK*\n\n*\n\n*\n\nE12,LS2*\n\n*\n\nMedical: No*\n\nHazards: No*
(CCFR) 2012-151511*\n\n103 MADISON AVE*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\nINJURY*\n\nINJURY*\n\n*\n\n*\n\nLS2*\n\n*\n\nMedical: No*\n\nHazards: No*
(CCFR) 2012-151531*\n\n7470 HARRIETTS BLUFF RD*\n\nLOT 10*\n\n*\n\nHARRIETTS BLUFF*\n\n*\n\n*\n\n*\n\n*\n\nINJURY*\n\nINJURY*\n\nJIM CLAYTON*\n\n912-390-1280*\n\nLS4*\n\n*\n\nMedical: No*\n\nHazards: No*
(CCFR) 2012-151678*\n\n7470 HARRIETTS BLUFF RD*\n\nLOT 16*\n\n*\n\nHARRIETTS BLUFF*\n\n*\n\n*\n\n*\n\n*\n\nBREATHING*\n\nDIFFICULTY BREATHING*\n\n*\n\n912-   -*\n\nLS4*\n\n*\n\nMedical: No*\n\nHazards: No*

*/

public class GACamdenCountyParserTest extends BaseParserTest {
  
  public GACamdenCountyParserTest() {
    setParser(new GACamdenCountyParser(), "CAMDEN COUNTY", "GA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "astudstill@co.camden.ga.us:2011-101695* HIGHWAY 17 STEFFANS* * * KINGSLAND* * Traffic Stop* TRAFFIC STOP* * * 1128,1140,1150,1152,509,514,523,532,LS3,R3* * Med",
        "ID:2011-101695",
        "ADDR:HIGHWAY 17",
        "MADDR:STEFFANS,HIGHWAY 17",
        "CITY:KINGSLAND",
        "PLACE:STEFFANS",
        "CALL:TRAFFIC STOP",
        "UNIT:1128,1140,1150,1152,509,514,523,532,LS3,R3",
        "INFO:Med");

    doTest("T2",
        "astudstill@co.camden.ga.us:2011-104696* 4059 MARTIN LUTHER KING BLVD* N4* * 514,541,546,ENG4,LS4,MED4 KINGSLAND* * INJURY* INJURY* 509,ENG5,LS3* * Medical: No",
        "ID:2011-104696",
        "ADDR:4059 MARTIN LUTHER KING BLVD",
        "APT:N4",
        "CITY:KINGSLAND",
        "CALL:INJURY",
        "UNIT:509,ENG5,LS3",
        "INFO:Medical: No");

    doTest("T3",
        "astudstill@co.camden.ga.us:2011-101995* 405 & HIGHWAY 40 OLD WAFFLE HOUSE* * * KINGSLAND* * ACCIDENT* ACCIDENT* ELAINE* 386-208-4465* 514,541,546,ENG4,LS4,MED4",
        "ID:2011-101995",
        "ADDR:405 & HIGHWAY 40",
        "CITY:KINGSLAND",
        "PLACE:OLD WAFFLE HOUSE",
        "CALL:ACCIDENT",
        "NAME:ELAINE",
        "PHONE:386-208-4465",
        "UNIT:514,541,546,ENG4,LS4,MED4");

    doTest("T4",
        "astudstill@co.camden.ga.us:2011-104843* 429 EAGLE BLVD* * * KINGSLAND* * PERSON SICK* PERSON SICK* * 540,ENG4,LS4* * Medical: No* Haz",
        "ID:2011-104843",
        "ADDR:429 EAGLE BLVD",
        "CITY:KINGSLAND",
        "CALL:PERSON SICK",
        "UNIT:540,ENG4,LS4",
        "INFO:Medical: No / Haz");

    doTest("T5",
        "214 REDWOOD ST* * * KINGSLAND* * PERSON SICK* PERSON SICK* MS FAGEN*912-269-6157* LS3,R3* * Medical: No* Hazards: No*",
        "ADDR:214 REDWOOD ST",
        "CITY:KINGSLAND",
        "CALL:PERSON SICK",
        "NAME:MS FAGEN",
        "PHONE:912-269-6157",
        "UNIT:LS3,R3",
        "INFO:Medical: No / Hazards: No");

    doTest("T6",
        "astudstill@co.camden.ga.us:2011-181161* ADVANCE COLLISION CENTER* * * KINGSLAND* * WIRE DOWN* WIRE DOWN* JOHN* 316-258-1559* ENG4,LS4* * Medical: No* Haz",
        "ID:2011-181161",
        "ADDR:ADVANCE COLLISION CENTER",
        "CITY:KINGSLAND",
        "CALL:WIRE DOWN",
        "NAME:JOHN",
        "PHONE:316-258-1559",
        "UNIT:ENG4,LS4",
        "INFO:Medical: No / Haz");

    doTest("T7",
        "astudstill@co.camden.ga.us:2012-037466* BOONE AND SUMMERBROOK* * * KINGSLAND* * INVESTIGATE* INVESTIGATE SUSPICIOUS PERSON/VEHICLE* JUAN RODRIGUEZ* 912-8",
        "ID:2012-037466",
        "ADDR:BOONE AND SUMMERBROOK",
        "CITY:KINGSLAND",
        "CALL:INVESTIGATE SUSPICIOUS PERSON/VEHICLE",
        "NAME:JUAN RODRIGUEZ",
        "PHONE:912-8");

    doTest("T8",
        "astudstill@co.camden.ga.us:2012-142354* CMC* * * ST MARYS* * * * * TRANSFER* TRANSFER TO ... (MEDICAL OR FIRE)* * * MED3* * Medical: No* Hazards: No* Lin",
        "ID:2012-142354",
        "ADDR:CMC",
        "CITY:ST MARYS",
        "CALL:TRANSFER TO ... (MEDICAL OR FIRE)",
        "UNIT:MED3",
        "INFO:Medical: No / Hazards: No / Lin");

    doTest("T9",
        "astudstill@co.camden.ga.us:2012-142422* 119 TERESA LN* * * KINGSLAND* * * * * DOMESTIC* DOMESTIC PROBLEM* HUNTER* 912-576-1327* 525,531,544,LS3,R3* * Med",
        "ID:2012-142422",
        "ADDR:119 TERESA LN",
        "CITY:KINGSLAND",
        "CALL:DOMESTIC PROBLEM",
        "UNIT:525,531,544,LS3,R3",
        "NAME:HUNTER",
        "PHONE:912-576-1327",
        "INFO:Med");

    doTest("T10",
        "astudstill@co.camden.ga.us:2012-142419* CMC TO SHANDS* * * KINGSLAND* * * * * TRANSFER* TRANSFER TO ... (MEDICAL OR FIRE)* * * MED4* * Medical: No* Hazar",
        "ID:2012-142419",
        "ADDR:CMC TO SHANDS",
        "CITY:KINGSLAND",
        "CALL:TRANSFER TO ... (MEDICAL OR FIRE)",
        "UNIT:MED4",
        "INFO:Medical: No / Hazar");

    doTest("T11",
        "astudstill@co.camden.ga.us:2012-142755* 102 ALMOND CIR* * * KINGSLAND* * * * * UNCONSCIOUS* UNCONSCIOUS PERSON* * 912-674-6173* 542,ENG4,LS4* * Medical: ",
        "ID:2012-142755",
        "ADDR:102 ALMOND CIR",
        "CITY:KINGSLAND",
        "CALL:UNCONSCIOUS PERSON",
        "UNIT:542,ENG4,LS4",
        "PHONE:912-674-6173",
        "INFO:Medical:");

    doTest("T12",
        "astudstill@co.camden.ga.us:2012-142422* 119 TERESA LN* * * KINGSLAND* * * * * DOMESTIC* DOMESTIC PROBLEM* HUNTER* 912-576-1327* 525,531,544,LS3,R3* * Med",
        "ID:2012-142422",
        "ADDR:119 TERESA LN",
        "CITY:KINGSLAND",
        "CALL:DOMESTIC PROBLEM",
        "UNIT:525,531,544,LS3,R3",
        "NAME:HUNTER",
        "PHONE:912-576-1327",
        "INFO:Med");

    doTest("T13",
        "astudstill@co.camden.ga.us:2012-143146* 200 CHESTNUT CT* * * KINGSLAND* * * * * INJURY* INJURY* * 912- -* 511,ENG4,KFD,LS4* * Medical: No* Hazards: No* L",
        "ID:2012-143146",
        "ADDR:200 CHESTNUT CT",
        "CITY:KINGSLAND",
        "CALL:INJURY",
        "UNIT:511,ENG4,KFD,LS4",
        "PHONE:912- -",
        "INFO:Medical: No / Hazards: No / L");

    doTest("T14",
        "astudstill@co.camden.ga.us:2012-142419* CMC TO SHANDS* * * KINGSLAND* * * * TRANSFER* TRANSFER TO ... (MEDICAL OR FIRE)* * * MED4* * Medical: No* Hazar",
        "ID:2012-142419",
        "ADDR:CMC TO SHANDS",
        "CITY:KINGSLAND",
        "CALL:TRANSFER TO ... (MEDICAL OR FIRE)",
        "UNIT:MED4",
        "INFO:Medical: No / Hazar");

    doTest("T15",
        "astudstill@co.camden.ga.us:2012-142222* STATION 4* * * KINGSLAND* * * * PERSON SICK* PERSON SICK* * * ENG4,LS4* * Medical: No* Hazards: No* Line18=*",
        "ID:2012-142222",
        "ADDR:STATION 4",
        "CITY:KINGSLAND",
        "CALL:PERSON SICK",
        "UNIT:ENG4,LS4",
        "INFO:Medical: No / Hazards: No");

    doTest("T16",
        "astudstill@co.camden.ga.us:2012-142193* 2060 HWY 40 E* * * KINGSLAND* * * * FIRE ALARM* FIRE ALARM* * * ENG4,LS2,FIRE3,FIRE4,Q9,LAD3,ENG3,ENG5* Medic",
        "ID:2012-142193",
        "ADDR:2060 HWY 40 E",
        "CITY:KINGSLAND",
        "CALL:FIRE ALARM",
        "UNIT:ENG4,LS2,FIRE3,FIRE4,Q9,LAD3,ENG3,ENG5",
        "INFO:Medic");

    doTest("T17",
        "astudstill@co.camden.ga.us:2012-142755* 102 ALMOND CIR* * * KINGSLAND* * * * UNCONSCIOUS* UNCONSCIOUS PERSON* * 912-674-6173* 542,ENG4,LS4* * Medical:",
        "ID:2012-142755",
        "ADDR:102 ALMOND CIR",
        "CITY:KINGSLAND",
        "CALL:UNCONSCIOUS PERSON",
        "UNIT:542,ENG4,LS4",
        "PHONE:912-674-6173",
        "INFO:Medical:");

    doTest("T18",
        "astudstill@co.camden.ga.us:2012-143345* SATILLA TO CMC* * * KINGSLAND* * * * * TRANSPORT* PICKUP PRISONER/SUBJECT* * * MED3* * Medical: No* Hazards: No* ",
        "ID:2012-143345",
        "ADDR:SATILLA TO CMC",
        "CITY:KINGSLAND",
        "CALL:PICKUP PRISONER/SUBJECT",
        "UNIT:MED3",
        "INFO:Medical: No / Hazards: No");

    doTest("T19",
        "astudstill@co.camden.ga.us:2012-143364* CMC* * * ST MARYS* * * * * TRANSPORT* PICKUP PRISONER/SUBJECT* * * MED3* * Medical: No* Hazards: No* Line18=*",
        "ID:2012-143364",
        "ADDR:CMC",
        "CITY:ST MARYS",
        "CALL:PICKUP PRISONER/SUBJECT",
        "UNIT:MED3",
        "INFO:Medical: No / Hazards: No");

    doTest("T20",
        "astudstill@co.camden.ga.us:2012-143368* 955 S GROVE BLVD* LOT 42* * KINGSLAND* * * * * BREATHING* DIFFICULTY BREATHING* DESTINY* 912- -* 526,542,KFD,LS3,",
        "ID:2012-143368",
        "ADDR:955 S GROVE BLVD",
        "APT:LOT 42",
        "CITY:KINGSLAND",
        "CALL:DIFFICULTY BREATHING",
        "UNIT:526,542,KFD,LS3,",
        "NAME:DESTINY",
        "PHONE:912- -");

    doTest("T21",
        "astudstill@co.camden.ga.us:* 105 MILLERS BRANCH DR* * * ST MARYS* * * * * SMOKE INVEST* SMOKE INVESTIGATION* * 541-231-9242* LS4* * Medical: No* Hazards:",
        "ADDR:105 MILLERS BRANCH DR",
        "CITY:ST MARYS",
        "CALL:SMOKE INVESTIGATION",
        "UNIT:LS4",
        "PHONE:541-231-9242",
        "INFO:Medical: No / Hazards:");

    doTest("T22",
        "astudstill@co.camden.ga.us:2012-146148* HADDOCK DR // CISCO GAS STATION* * * KINGSLAND* * * * * ACCIDENT* ACCIDENT* * * 539,545,ENG4,LS3* * Medical: No* ",
        "ID:2012-146148",
        "ADDR:HADDOCK DR",
        "MADDR:CISCO GAS STATION,HADDOCK DR",
        "CITY:KINGSLAND",
        "PLACE:CISCO GAS STATION",
        "CALL:ACCIDENT",
        "UNIT:539,545,ENG4,LS3",
        "INFO:Medical: No");

    doTest("T23",
        "astudstill@co.camden.ga.us:2012-146395* 517 E WILLIAMS AVE* * * KINGSLAND* * * * * BREATHING* DIFFICULTY BREATHING* * * LS3,R3* * Medical: No* Hazards: N",
        "ID:2012-146395",
        "ADDR:517 E WILLIAMS AVE",
        "CITY:KINGSLAND",
        "CALL:DIFFICULTY BREATHING",
        "UNIT:LS3,R3",
        "INFO:Medical: No / Hazards: N");

    doTest("T24",
        "astudstill@co.camden.ga.us:2012-146519* 115 ALMOND CIR* * * KINGSLAND* * * * * UNCONSCIOUS* UNCONSCIOUS PERSON* * * ENG4,KFD,LS4* * Medical: No* Hazards:",
        "ID:2012-146519",
        "ADDR:115 ALMOND CIR",
        "CITY:KINGSLAND",
        "CALL:UNCONSCIOUS PERSON",
        "UNIT:ENG4,KFD,LS4",
        "INFO:Medical: No / Hazards:");

    doTest("T25",
        "astudstill@co.camden.ga.us:2012-146584* 720 S LEE ST* * * KINGSLAND* * * * * WELFARE CHK* WELFARE CHECK* * * 532,LS3,R3* * Medical: No* Hazards: No* Line",
        "ID:2012-146584",
        "ADDR:720 S LEE ST",
        "CITY:KINGSLAND",
        "CALL:WELFARE CHECK",
        "UNIT:532,LS3,R3",
        "INFO:Medical: No / Hazards: No / Line");

  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "(Message Forwarded by PageGate) 2012-150182*\n" +
        "115 SPINNAKER CIR*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "PERSON SICK*\n" +
        "PERSON SICK*\n" +
        "*\n" +
        "*\n" +
        "LS4*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        "Line18=*",

        "ID:2012-150182",
        "ADDR:115 SPINNAKER CIR",
        "CALL:PERSON SICK",
        "UNIT:LS4",
        "INFO:Medical: No / Hazards: No");

    doTest("T2",
        "(Message Forwarded by PageGate) 2012-150236*\n" +
        "99 KINLAW RD*\n" +
        "*\n" +
        "*\n" +
        "WOODBINE*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "GAS LEAK*\n" +
        "HAZ-MAT INCIDENT*\n" +
        "*\n" +
        "*\n" +
        "1132,LS3*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        "Line18=*",

        "ID:2012-150236",
        "ADDR:99 KINLAW RD",
        "CITY:WOODBINE",
        "CALL:HAZ-MAT INCIDENT",
        "UNIT:1132,LS3",
        "INFO:Medical: No / Hazards: No");

    doTest("T3",
        "(Message Forwarded by PageGate) 2012-150237*\n" +
        "590 BURNT FORT RD*\n" +
        "*\n" +
        "*\n" +
        "WHITE OAK*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "BREATHING*\n" +
        "DIFFICULTY BREATHING*\n" +
        "*\n" +
        "*\n" +
        "LS1*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        "Line18=*",

        "ID:2012-150237",
        "ADDR:590 BURNT FORT RD",
        "CITY:WHITE OAK",
        "CALL:DIFFICULTY BREATHING",
        "UNIT:LS1",
        "INFO:Medical: No / Hazards: No");

    doTest("T4",
        "(Message Forwarded by PageGate) 2012-150239*\n" +
        "405 NB 23*\n" +
        "*\n" +
        "*\n" +
        "WOODBINE*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "INVESTIGATE*\n" +
        "INVESTIGATE SUSPICIOUS PERSON/VEHICLE*\n" +
        "*\n" +
        "*\n" +
        "1160,LS7*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        "Line18=*",

        "ID:2012-150239",
        "ADDR:405 NB 23",  // Not mapping
        "MADDR:405 23",
        "CITY:WOODBINE",
        "CALL:INVESTIGATE SUSPICIOUS PERSON/VEHICLE",
        "UNIT:1160,LS7",
        "INFO:Medical: No / Hazards: No");

    doTest("T5",
        "(Message Forwarded by PageGate) 2012-150245*\n" +
        "1385 SCRUBBY BLUFF RD*\n" +
        "*\n" +
        "*\n" +
        "KINGSLAND*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "PERSON SICK*\n" +
        "PERSON SICK*\n" +
        "*\n" +
        "*\n" +
        "LS2*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        "Line18=*",

        "ID:2012-150245",
        "ADDR:1385 SCRUBBY BLUFF RD",
        "CITY:KINGSLAND",
        "CALL:PERSON SICK",
        "UNIT:LS2",
        "INFO:Medical: No / Hazards: No");

    doTest("T6",
        "(Message Forwarded by PageGate) 2012-150294*\n" +
        "HWY 17 NB BLUE BRIDGE*\n" +
        "*\n" +
        "*\n" +
        "KINGSLAND*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "INVESTIGATE*\n" +
        "INVESTIGATE SUSPICIOUS PERSON/VEHICLE*\n" +
        "*\n" +
        "*\n" +
        "LS3*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        "Line18=*",

        "ID:2012-150294",
        "ADDR:HWY 17 NB",
        "MADDR:BLUE BRIDGE,HWY 17",
        "CITY:KINGSLAND",
        "PLACE:BLUE BRIDGE",
        "CALL:INVESTIGATE SUSPICIOUS PERSON/VEHICLE",
        "UNIT:LS3",
        "INFO:Medical: No / Hazards: No");

    doTest("T7",
        "(Message Forwarded by PageGate) 2012-150378*\n" +
        "HILL TOP TERRACE*\n" +
        "R-2*\n" +
        "*\n" +
        "KINGSLAND*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "PERSON SICK*\n" +
        "PERSON SICK*\n" +
        "PENNIE GODWIN*\n" +
        "904-405-5153*\n" +
        "LS3*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        "Line18=*",

        "ID:2012-150378",
        "ADDR:HILL TOP TERRACE",
        "APT:R-2",
        "CITY:KINGSLAND",
        "CALL:PERSON SICK",
        "UNIT:LS3",
        "NAME:PENNIE GODWIN",
        "PHONE:904-405-5153",
        "INFO:Medical: No / Hazards: No");

    doTest("T8",
        "(Message Forwarded by PageGate) 2012-150550*\n" +
        "805 DILWORTH ST*\n" +
        "*\n" +
        "*\n" +
        "ST MARYS*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "BREATHING*\n" +
        "DIFFICULTY BREATHING*\n" +
        "SHIRLEY*\n" +
        "912-882-4281*\n" +
        "LS2*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        "Line18=*",

        "ID:2012-150550",
        "ADDR:805 DILWORTH ST",
        "CITY:ST MARYS",
        "CALL:DIFFICULTY BREATHING",
        "UNIT:LS2",
        "NAME:SHIRLEY",
        "PHONE:912-882-4281",
        "INFO:Medical: No / Hazards: No");

    doTest("T9",
        "(Message Forwarded by PageGate) 2012-150608*\n" +
        "10-61*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "SECURITY CHK*\n" +
        "SECURITY CHECK*\n" +
        "*\n" +
        "*\n" +
        "LS4,513*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        "Line18=*",

        "ID:2012-150608",
        "ADDR:10-61",
        "MADDR:10",
        "CALL:SECURITY CHECK",
        "UNIT:LS4,513",
        "INFO:Medical: No / Hazards: No");

    doTest("T10",
        "(Message Forwarded by PageGate) 2012-150614*\n" +
        "MISSION FOREST APTS*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "FIRE*\n" +
        "FIRE*\n" +
        "*\n" +
        "*\n" +
        "LS4,Q9*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        "Line18=*",

        "ID:2012-150614",
        "ADDR:MISSION FOREST APTS",
        "CALL:FIRE",
        "UNIT:LS4,Q9",
        "INFO:Medical: No / Hazards: No");

    doTest("T11",
        "(CCFR) 2012-150818*\n\n1351 BOONE ST*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\nINJURY*\n\nINJURY*\n\n*\n\n*\n\nLS4*\n\n*\n\nMedical: No*\n\nHazards: No*",
        "ID:2012-150818",
        "ADDR:1351 BOONE ST",
        "CALL:INJURY",
        "UNIT:LS4",
        "INFO:Medical: No / Hazards: No");

    doTest("T12",
        "(CCFR) 2012-150893*\n\n" +
        "HWY 40 ARBYS*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "ST MARYS*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "ACCIDENT*\n\n" +
        "ACCIDENT*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "118,119,LS2*\n\n" +
        "*\n\n" +
        "Medical: No*\n\n" +
        "Hazards: No*",

        "ID:2012-150893",
        "ADDR:HWY 40",
        "MADDR:ARBYS,HWY 40",
        "CITY:ST MARYS",
        "PLACE:ARBYS",
        "CALL:ACCIDENT",
        "UNIT:118,119,LS2",
        "INFO:Medical: No / Hazards: No");

    doTest("T13",
        "(CCFR) 2012-150894*\n\n1119 DOUGLAS DR*\n\n122*\n\n*\n\nST MARYS*\n\n*\n\n*\n\n*\n\n*\n\nFIRE*\n\nFIRE*\n\n*\n\n*\n\nLS4*\n\n*\n\nMedical: No*\n\nHazards: No*",
        "ID:2012-150894",
        "ADDR:1119 DOUGLAS DR",
        "APT:122",
        "CITY:ST MARYS",
        "CALL:FIRE",
        "UNIT:LS4",
        "INFO:Medical: No / Hazards: No");

    doTest("T14",
        "(CCFR) 2012-150922*\n\n" +
        "1106 OLD JEFFERSON HWY*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "WOODBINE*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "PERSON SICK*\n\n" +
        "PERSON SICK*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "LS1*\n\n" +
        "*\n\n" +
        "Medical: No*\n\n" +
        "Hazards: No*",

        "ID:2012-150922",
        "ADDR:1106 OLD JEFFERSON HWY",
        "CITY:WOODBINE",
        "CALL:PERSON SICK",
        "UNIT:LS1",
        "INFO:Medical: No / Hazards: No");

    doTest("T15",
        "(CCFR) 2012-151031*\n\n" +
        "LUCKY DAWG*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "ST MARYS*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "UNCONSCIOUS*\n\n" +
        "UNCONSCIOUS PERSON*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "LS2*\n\n" +
        "*\n\n" +
        "Medical: No*\n\n" +
        "Hazards: No*",

        "ID:2012-151031",
        "ADDR:LUCKY DAWG",
        "CITY:ST MARYS",
        "CALL:UNCONSCIOUS PERSON",
        "UNIT:LS2",
        "INFO:Medical: No / Hazards: No");

    doTest("T16",
        "(CCFR) 2012-151141*\n\n" +
        "27 PINEHURST DR*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "ST MARYS*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "PERSON SICK*\n\n" +
        "PERSON SICK*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "LS2*\n\n" +
        "*\n\n" +
        "Medical: No*\n\n" +
        "Hazards: No*",

        "ID:2012-151141",
        "ADDR:27 PINEHURST DR",
        "CITY:ST MARYS",
        "CALL:PERSON SICK",
        "UNIT:LS2",
        "INFO:Medical: No / Hazards: No");

    doTest("T17",
        "(CCFR) 2012-151227*\n\n" +
        "HWY 17 // CATFISH CREEK BRIDGE*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "KINGSLAND*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "ACCIDENT INJ*\n\n" +
        "ACCIDENT WITH INJURIES*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "LS4*\n\n" +
        "*\n\n" +
        "Medical: No*\n\n" +
        "Hazards: No*",

        "ID:2012-151227",
        "ADDR:HWY 17",
        "MADDR:CATFISH CREEK BRIDGE,HWY 17",
        "CITY:KINGSLAND",
        "PLACE:CATFISH CREEK BRIDGE",
        "CALL:ACCIDENT WITH INJURIES",
        "UNIT:LS4",
        "INFO:Medical: No / Hazards: No");

    doTest("T18",
        "(CCFR) 2012-151288*\n\n" +
        "4059 MARTIN LUTHER KING BLVD*\n\n" +
        "H-3*\n\n" +
        "*\n\n" +
        "KINGSLAND*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "PUBLIC SERV*\n\n" +
        "PUBLIC SERVICE (FIRE,EMS)*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "LS3*\n\n" +
        "*\n\n" +
        "Medical: No*\n\n" +
        "Hazards: No*",

        "ID:2012-151288",
        "ADDR:4059 MARTIN LUTHER KING BLVD",
        "APT:H-3",
        "CITY:KINGSLAND",
        "CALL:PUBLIC SERVICE (FIRE,EMS)",
        "UNIT:LS3",
        "INFO:Medical: No / Hazards: No");

    doTest("T19",
        "(CCFR) 2012-151320*\n\n" +
        "129 WOODVALLEY DR*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "KINGSLAND*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "BREATHING*\n\n" +
        "DIFFICULTY BREATHING*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "LS4*\n\n" +
        "*\n\n" +
        "Medical: No*\n\n" +
        "Hazards: No*",

        "ID:2012-151320",
        "ADDR:129 WOODVALLEY DR",
        "CITY:KINGSLAND",
        "CALL:DIFFICULTY BREATHING",
        "UNIT:LS4",
        "INFO:Medical: No / Hazards: No");

    doTest("T20",
        "(CCFR) 2012-151359*\n\n" +
        "163 SEXTANT CIR*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "ST MARYS*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "PERSON SICK*\n\n" +
        "PERSON SICK*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "124,LS2*\n\n" +
        "*\n\n" +
        "Medical: No*\n\n" +
        "Hazards: No*",

        "ID:2012-151359",
        "ADDR:163 SEXTANT CIR",
        "CITY:ST MARYS",
        "CALL:PERSON SICK",
        "UNIT:124,LS2",
        "INFO:Medical: No / Hazards: No");

    doTest("T21",
        "(CCFR) 2012-151365*\n\n" +
        "377 VICKI LN*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "KINGSLAND*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "PERSON SICK*\n\n" +
        "PERSON SICK*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "LS4*\n\n" +
        "*\n\n" +
        "Medical: No*\n\n" +
        "Hazards: No*",

        "ID:2012-151365",
        "ADDR:377 VICKI LN",
        "CITY:KINGSLAND",
        "CALL:PERSON SICK",
        "UNIT:LS4",
        "INFO:Medical: No / Hazards: No");

    doTest("T22",
        "(CCFR) 2012-151320*\n\n" +
        "129 WOODVALLEY DR*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "KINGSLAND*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "BREATHING*\n\n" +
        "DIFFICULTY BREATHING*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "LS4*\n\n" +
        "*\n\n" +
        "Medical: No*\n\n" +
        "Hazards: No*",

        "ID:2012-151320",
        "ADDR:129 WOODVALLEY DR",
        "CITY:KINGSLAND",
        "CALL:DIFFICULTY BREATHING",
        "UNIT:LS4",
        "INFO:Medical: No / Hazards: No");

    doTest("T23",
        "(CCFR) 2012-151466*\n\n" +
        "302 FINLEY ST*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "ST MARYS*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "BREATHING*\n\n" +
        "DIFFICULTY BREATHING*\n\n" +
        "MS BRADLEY*\n\n" +
        "912-729-3501*\n\n" +
        "110,LS2*\n\n" +
        "*\n\n" +
        "Medical: No*\n\n" +
        "Hazards: No*",

        "ID:2012-151466",
        "ADDR:302 FINLEY ST",
        "CITY:ST MARYS",
        "CALL:DIFFICULTY BREATHING",
        "UNIT:110,LS2",
        "NAME:MS BRADLEY",
        "PHONE:912-729-3501",
        "INFO:Medical: No / Hazards: No");

    doTest("T24",
        "(CCFR) 2012-151483*\n\n" +
        "1947 COMMERCE DR*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "KINGSLAND*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "CHOKING*\n\n" +
        "PERSON CHOKING*\n\n" +
        "*\n\n" +
        "912-   -*\n\n" +
        "LS4*\n\n" +
        "*\n\n" +
        "Medical: No*\n\n" +
        "Hazards: No*",

        "ID:2012-151483",
        "ADDR:1947 COMMERCE DR",
        "CITY:KINGSLAND",
        "CALL:PERSON CHOKING",
        "UNIT:LS4",
        "PHONE:912-   -",
        "INFO:Medical: No / Hazards: No");

    doTest("T25",
        "(CCFR) 2012-151492*\n\n" +
        "FIRST DIRT RD BROWNTOWN STORE*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "BROWNTOWN*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "ACCIDENT INJ*\n\n" +
        "ACCIDENT WITH INJURIES*\n\n" +
        "AMANDA FLEMMING*\n\n" +
        "912-506-3453*\n\n" +
        "LS3*\n\n" +
        "*\n\n" +
        "Medical: No*\n\n" +
        "Hazards: No*",

        "ID:2012-151492",
        "ADDR:FIRST DIRT RD",
        "MADDR:BROWNTOWN STORE,FIRST DIRT RD",
        "CITY:BROWNTOWN",
        "PLACE:BROWNTOWN STORE",
        "CALL:ACCIDENT WITH INJURIES",
        "UNIT:LS3",
        "NAME:AMANDA FLEMMING",
        "PHONE:912-506-3453",
        "INFO:Medical: No / Hazards: No");

    doTest("T26",
        "(CCFR) 2012-151495*\n\n289 LANDING CIR*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\nPERSON SICK*\n\nPERSON SICK*\n\n*\n\n*\n\nLS4*\n\n*\n\nMedical: No*\n\nHazards: No*",
        "ID:2012-151495",
        "ADDR:289 LANDING CIR",
        "CALL:PERSON SICK",
        "UNIT:LS4",
        "INFO:Medical: No / Hazards: No");

    doTest("T27",
        "(CCFR) 2012-151492*\n\n" +
        "FIRST DIRT RD BROWNTOWN STORE*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "ACCIDENT INJ*\n\n" +
        "ACCIDENT WITH INJURIES*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "1123,1126,1187,E15,LS3*\n\n" +
        "*\n\n" +
        "Medical: No*\n\n" +
        "Hazards: No*",

        "ID:2012-151492",
        "ADDR:FIRST DIRT RD",
        "MADDR:BROWNTOWN STORE,FIRST DIRT RD",
        "PLACE:BROWNTOWN STORE",
        "CALL:ACCIDENT WITH INJURIES",
        "UNIT:1123,1126,1187,E15,LS3",
        "INFO:Medical: No / Hazards: No");

    doTest("T28",
        "(CCFR) 2012-151500*\n\n" +
        "594 MUSH BLUFF RD*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "PERSON SICK*\n\n" +
        "PERSON SICK*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "E12,LS2*\n\n" +
        "*\n\n" +
        "Medical: No*\n\n" +
        "Hazards: No*",

        "ID:2012-151500",
        "ADDR:594 MUSH BLUFF RD",
        "CALL:PERSON SICK",
        "UNIT:E12,LS2",
        "INFO:Medical: No / Hazards: No");

    doTest("T29",
        "(CCFR) 2012-151511*\n\n103 MADISON AVE*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\nINJURY*\n\nINJURY*\n\n*\n\n*\n\nLS2*\n\n*\n\nMedical: No*\n\nHazards: No*",
        "ID:2012-151511",
        "ADDR:103 MADISON AVE",
        "CALL:INJURY",
        "UNIT:LS2",
        "INFO:Medical: No / Hazards: No");

    doTest("T30",
        "(CCFR) 2012-151531*\n\n" +
        "7470 HARRIETTS BLUFF RD*\n\n" +
        "LOT 10*\n\n" +
        "*\n\n" +
        "HARRIETTS BLUFF*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "INJURY*\n\n" +
        "INJURY*\n\n" +
        "JIM CLAYTON*\n\n" +
        "912-390-1280*\n\n" +
        "LS4*\n\n" +
        "*\n\n" +
        "Medical: No*\n\n" +
        "Hazards: No*",

        "ID:2012-151531",
        "ADDR:7470 HARRIETTS BLUFF RD",
        "APT:LOT 10",
        "CITY:HARRIETTS BLUFF",
        "CALL:INJURY",
        "UNIT:LS4",
        "NAME:JIM CLAYTON",
        "PHONE:912-390-1280",
        "INFO:Medical: No / Hazards: No");

    doTest("T31",
        "(CCFR) 2012-151678*\n\n" +
        "7470 HARRIETTS BLUFF RD*\n\n" +
        "LOT 16*\n\n" +
        "*\n\n" +
        "HARRIETTS BLUFF*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "*\n\n" +
        "BREATHING*\n\n" +
        "DIFFICULTY BREATHING*\n\n" +
        "*\n\n" +
        "912-   -*\n\n" +
        "LS4*\n\n" +
        "*\n\n" +
        "Medical: No*\n\n" +
        "Hazards: No*",

        "ID:2012-151678",
        "ADDR:7470 HARRIETTS BLUFF RD",
        "APT:LOT 16",
        "CITY:HARRIETTS BLUFF",
        "CALL:DIFFICULTY BREATHING",
        "UNIT:LS4",
        "PHONE:912-   -",
        "INFO:Medical: No / Hazards: No");

  }
  
  public static void main(String[] args) {
    new GACamdenCountyParserTest().generateTests("T1");
  }
}
