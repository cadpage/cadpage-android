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

Contact: Active911
Agency name: Camden County Fire Rescue
Location: Kingsland, GA, United States
Sender: messaging@iamresponding.com

(CCFR) 2013-121446*\n607 MARGARET ST*\n*\n*\nST MARYS*\n*\n*\n*\n*\nUNCONSCIOUS*\nMEDICAL EMERGENCY*\n*\n*\nLS2*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-121383*\n1220 BOONE ST*\n135*\n*\nKINGSLAND*\n*\n*\n*\n*\nSEIZURES*\nMEDICAL EMERGENCY*\n*\n*\nENG3,LS4*\n*\nMedical: No*\nHazards: Yes*\n 
(CCFR) 2013-121391*\n35 WILLIAMS CT*\n*\n*\nST MARYS*\n*\n*\n*\n*\nPERSON SICK*\nMEDICAL EMERGENCY*\n*\n*\nLS2*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-121387*\n506 N CAMDEN ST*\n*\n*\nKINGSLAND*\n*\n*\n*\n*\nANIMAL*\nANIMAL CONTROL*\n*\n*\n527,KFD,LS2,R3*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-121383*\n1220 BOONE ST*\n135*\n*\nKINGSLAND*\n*\n*\n*\n*\nSEIZURES*\nMEDICAL EMERGENCY*\n*\n*\nLS4*\n*\nMedical: No*\nHazards: Yes*\n 
(CCFR) 2013-121379*\n112 E FARMER AVE*\n*\n*\nKINGSLAND*\n*\n*\n*\n*\nPERSON SICK*\nMEDICAL EMERGENCY*\n*\n*\nLS3*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-121353*\n365 S SPRINGHILL RD S*\n*\n*\nKINGSLAND*\n*\n*\n*\n*\nSUICIDE*\nMEDICAL EMERGENCY*\n*\n*\nLS3*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-121297*\n183 RHONE RD*\n*\n*\nST MARYS*\n*\n*\n*\n*\nPUBLIC SERV*\nPUBLIC SERVICE (FIRE,EMS)*\n*\n*\nLS2*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-121274*\n603 SANDBAR DR*\n150*\n*\nST MARYS*\n*\n*\n*\n*\nINVESTIGATE*\nINVESTIGATE SUSPICIOUS PERSON/VEHICLE*\n*\n*\n103,LS2*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-121209*\n1076 HWY 40 E*\n*\n*\nKINGSLAND*\n*\n*\n*\n*\nINJURY*\nTRAUMA EMERGENCY*\n*\n*\nLS3*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-121180*\n1973 HADDOCK RD*\n*\n*\nST MARYS*\n*\n*\n*\n*\nCHEST PAIN*\nMEDICAL EMERGENCY*\n*\n*\nLS4*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-121178*\n808 ANN ST*\n*\n*\nST MARYS*\n*\n*\n*\n*\nPERSON SICK*\nMEDICAL EMERGENCY*\nZACHARY MYZELL*\n912-322-5895*\nLS2*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-121133*\n102 MERIDIAN DR*\n*\n*\nKINGSLAND*\n*\n*\n*\n*\nINJURY*\nTRAUMA EMERGENCY*\n*\n*\n*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-121077*\n1900 HWY 17*\n*\n*\nWHITE OAK*\n*\n*\n*\n*\nINJURY*\nTRAUMA EMERGENCY*\nJOSEPH POWELL*\n912-464-1705*\nE18,LS1*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-121077*\nTHE OLD POST OFFICE*\n*\n*\nWHITE OAK*\n*\n*\n*\n*\nINJURY*\nTRAUMA EMERGENCY*\nJOSEPH POWELL*\n912-464-1705*\nLS7*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-120941*\n176 LONESOME PINE DR*\n*\n*\nST MARYS*\n*\n*\n*\n*\nCHEST PAIN*\nMEDICAL EMERGENCY*\n*\n*\n*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-120912*\n307 W LAWNWOOD AVE*\n*\n*\n*\n*\n*\n*\n*\nBREATHING*\n*\n*\n*\n*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-120901*\n32 COVE WAY*\n*\n*\n*\n*\n*\n*\n*\nINJURY*\n*\n*\n*\n*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-120848*\nPILOT // X1*\n*\n*\n*\n*\n*\n*\n*\nUNCONSCIOUS*\n*\n*\n*\n*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-120703*\n95 NB 13*\n*\n*\nWOODBINE*\n*\n*\n*\n*\nACCIDENT*\nTRAUMA EMERGENCY*\n*\n912-   -*\n1167,E11,LS1*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-120703*\n95 NB 14*\n*\n*\nWOODBINE*\n*\n*\n*\n*\nACCIDENT*\nTRAUMA EMERGENCY*\n*\n912-   -*\n1167,E11*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-120688*\n307 W LAWNWOOD AV*\n*\n*\nKINGSLAND*\n*\n*\n*\n*\nINJURY*\nTRAUMA EMERGENCY*\nMELISSA*\n912-729-5227*\n532,LS3*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-120683*\n264 LIZA RUDOLPH RD*\n*\n*\nWOODBINE*\n*\n*\n*\n*\nPERSON SICK*\nMEDICAL EMERGENCY*\nLAFORTUNE, MARY*\n912-882-0567*\nLS1*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-120636*\n2507 OSBORNE RD*\n*\n*\nST MARYS*\n*\n*\n*\n*\nINJURY*\nTRAUMA EMERGENCY*\nANGELA COWART*\n912-658-7600*\n106,LS2*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-120615*\n102 WOODHAVEN CT*\n*\n*\nKINGSLAND*\n*\n*\n*\n*\nPERSON SICK*\nMEDICAL EMERGENCY*\nNEOMI COOPER*\n912-552-9838*\nLS1,R3*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-120612*\n112 CROOKED RIVER DR*\n*\n*\nHARRIETTS BLUFF*\n*\n*\n*\n*\nSEIZURES*\nMEDICAL EMERGENCY*\nSPRINT PCS                      912*\n912-322-9338*\nLS4*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-120561*\n2040 DAN PROCTOR DR*\n220*\n*\nST MARYS*\n*\n*\n*\n*\nUNCONSCIOUS*\nMEDICAL EMERGENCY*\n*\n*\nLS4*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-120539*\n101B COMMERCIAL DR*\n*\n*\nHARRIETTS BLUFF*\n*\n*\n*\n*\nFIRE ALARM*\nFIRE*\n*\n*\nLS3*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-120505*\n119 W PINE BLUFF BLVD*\n*\n*\nKINGSLAND*\n*\n*\n*\n*\nPERSON SICK*\nMEDICAL EMERGENCY*\nMIRAENDA, CYNTHIA*\n912-729-3356*\nLS3*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-120495*\n54 BERMUDA ST*\n*\n*\nKINGSLAND*\n*\n*\n*\n*\nUNCONSCIOUS*\nMEDICAL EMERGENCY*\nVERIZON                         912*\n912-856-0656*\nLS3*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-120375*\n132 CANEY HEIGHTS*\n*\n*\n*\n*\n*\n*\n*\nINJURY*\n*\n*\n*\n*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-120370*\nDOVER BLUFF RD*\n*\n*\n*\n*\n*\n*\n*\nVEHICLE FIRE*\n*\n*\n*\n*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-120263*\n45 BERMUDA ST*\n*\n*\nKINGSLAND*\n*\n*\n*\n*\nCHEST PAIN*\nMEDICAL EMERGENCY*\n*\n*\n*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-120265*\n573 HENRIETTA ST*\n*\n*\nKINGSLAND*\n*\n*\n*\n*\nSUICIDE*\nMEDICAL EMERGENCY*\n*\n*\n*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-120263*\n45 BERMUDA ST*\n*\n*\nKINGSLAND*\n*\n*\n*\n*\nCHEST PAIN*\nMEDICAL EMERGENCY*\n*\n*\n*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-120260*\n32 COVE WAY*\n*\n*\nWOODBINE*\n*\n*\n*\n*\nFIGHT*\nFIGHT*\n*\n*\n*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-120248*\n448 HICKORY RIDGE CT*\n*\n*\nWOODBINE*\n*\n*\n*\n*\nHEART PROB*\nMEDICAL EMERGENCY*\n*\n*\nE11,LS1*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-120243*\n56 HIGHTOWER ST*\nLOT 9*\n*\nST MARYS*\n*\n*\n*\n*\nINVESTIGATE*\nINVESTIGATE SUSPICIOUS PERSON/VEHICLE*\n*\n*\n1116,1117,1122,1123,1127,1151,1154,1165,1173,1175,LS2*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-120248*\n448 HICKORY RIDGE CT*\n*\n*\nWOODBINE*\n*\n*\n*\n*\nHEART PROB*\nMEDICAL EMERGENCY*\n*\n*\nLS1*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-120247*\n238 W DAWSON AVE*\n*\n*\nKingsland*\n*\n*\n*\n*\nHAZ-MAT*\nHAZ-MAT INCIDENT*\n*\n*\nLS3*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-120234*\n103 RIVERBEND DR*\n*\n*\n*\n*\n*\n*\n*\nSUICIDE*\nMEDICAL EMERGENCY*\n*\n*\nLS4*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-120203*\nGREEN CEDAR COELRAIN AND SPUR 40*\n*\n*\n*\n*\n*\n*\n*\nSPECIAL DUTY*\nSPECIAL DUTY*\n*\n*\nENG21,LS2*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-120068*\n201 LAKE SHORE DR*\n*\n*\nST MARYS*\n*\n*\n*\n*\nCHEST PAIN*\nMEDICAL EMERGENCY*\nTERESA JACKSON  B*\n912-576-4087*\nLS2*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-120056*\n6586 E HWY 40*\n*\n*\nST MARYS*\n*\n*\n*\n*\nUNCONSCIOUS*\nMEDICAL EMERGENCY*\nWAL MART SUPERCENTER*\n912-510-9220*\nLS3*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-120029*\n213 CYPRESS DR*\n*\n*\n*\n*\n*\n*\n*\nSEIZURES*\nMEDICAL EMERGENCY*\nDOROTHY*\n*\n*\n*\nMedical: Yes*\nHazards: Yes*\n 
(CCFR) 2013-120007*\n501 S LEE ST*\n109*\n*\n*\n*\n*\n*\n*\nSUICIDE*\nMEDICAL EMERGENCY*\nECONOMY INN*\n*\n*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-119997*\n466 PELICAN CIR*\n*\n*\nHARRIETTS BLUFF*\n*\n*\n*\n*\nPERSON SICK*\nMEDICAL EMERGENCY*\nJEAN WOODS*\n912-   -*\nLS4*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-119978*\n205 7 TH ST*\n*\n*\nWOODBINE*\n*\n*\n*\n*\nINJURY*\nTRAUMA EMERGENCY*\n*\n912-856-8794*\nLS1*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-119937*\nWALMART // KINGSBAY RD*\n*\n*\nKINGSLAND*\n*\n*\n*\n*\nACCIDENT*\nTRAUMA EMERGENCY*\n*\n*\n125,513,524,LS4*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-119882*\nBACHLOTT RD*\n*\n*\nST MARYS*\n*\n*\n*\n*\nSMOKE INVEST*\nFIRE*\n*\n*\n*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-119867*\n40 // LIGHTHOUSE RADIO*\n*\n*\nST MARYS*\n*\n*\n*\n*\nACCIDENT*\nTRAUMA EMERGENCY*\n*\n912-   -*\nLS4*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-119864*\n25399 HWY 17 N*\n*\n*\nWAVERLY*\n*\n*\n*\n*\nPERSON SICK*\nMEDICAL EMERGENCY*\n*\n*\nE17*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-119802*\n505 ANN ST*\n*\n*\nST MARYS*\n*\n*\n*\n*\nMED ALARM*\nMEDICAL EMERGENCY*\nJASMIN XFINITI HOME*\n800-633-2677*\n125,LS2*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-119722*\n756 KINLAW RD*\n*\n*\nKINGSLAND*\n*\n*\n*\n*\nUNCONSCIOUS*\nMEDICAL EMERGENCY*\n*\n*\nLS3*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-119663*\n8260 BURNT FORT RD*\n*\n*\nWHITE OAK*\n*\n*\n*\n*\nPERSON SICK*\nMEDICAL EMERGENCY*\n*\n*\nLS1*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-119636*\nW BRYANT // BARTLETT*\n*\n*\nST MARYS*\n*\n*\n*\n*\nSMOKE INVEST*\nFIRE*\n*\n*\nLS2*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-119541*\nHWY 40 KMART*\n*\n*\nKINGSLAND*\n*\n*\n*\n*\nACCIDENT*\nTRAUMA EMERGENCY*\n*\n*\n503,533,537,LS4*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-119542*\n6011 CHARLIE SMITH SR HWY*\n*\n*\nST MARYS*\n*\n*\n*\n*\nINJURY*\nTRAUMA EMERGENCY*\n*\n*\nLS4*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-119517*\n404 THOROUGHBRED RD*\n*\n*\nST MARYS*\n*\n*\n*\n*\nWELFARE CHK*\nWELFARE CHECK*\n*\n*\nLS2*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-119331*\n284 HICKORY BLUFF RD*\n*\n*\nWAVERLY*\n*\n*\n*\n*\nWIRE DOWN*\nFIRE*\n*\n*\nLS7*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-119330*\n250 GROSS RD*\n1D*\n*\nKINGSLAND*\n*\n*\n*\n*\nCHEST PAIN*\nMEDICAL EMERGENCY*\nSHINKLE, SARAH                  APT*\n912-673-1924*\nLS4*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-119297*\n650 BILLYVILLE RD*\n*\n*\nWOODBINE*\n*\n*\n*\n*\nBREATHING*\nMEDICAL EMERGENCY*\n*\n*\nLS1*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-119248*\n20930 W HWY 40*\nLOT 18*\n*\nKINGSLAND*\n*\n*\n*\n*\nUNCONSCIOUS*\nMEDICAL EMERGENCY*\nFOX, GRACE*\n912-576-4656*\n1138,LS3*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-119237*\n309 PAPER PL*\n*\n*\nST MARYS*\n*\n*\n*\n*\nPERSON SICK*\nMEDICAL EMERGENCY*\n*\n*\nLS2*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-119215*\n141 N GROVE BLVD*\n*\n*\nKINGSLAND*\n*\n*\n*\n*\nPERSON SICK*\nMEDICAL EMERGENCY*\n*\n*\nLS3*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-119108*\nST MARYS DOCK*\n*\n*\nST MARYS*\n*\n*\n*\n*\nPERSON SICK*\nMEDICAL EMERGENCY*\nELIZABETH YEE - RANGER*\n912-409-0357*\nLS2*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-119081*\n95 SB 1MM*\n*\n*\nKINGSLAND*\n*\n*\n*\n*\nACCIDENT*\nTRAUMA EMERGENCY*\nDAN FRAZIER*\n717-715-3130*\n1126,1145,LS4*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-119022*\n790 E KING AVE*\n*\n*\nKINGSLAND*\nGROVE BLVD*\nWILLIAMS ST*\n*\nLandmark Comment: LS3 DIST3*\nHAZ-MAT*\nHAZ-MAT INCIDENT*\n*\n912-   -*\n535,LS3*\n*\nMedical: No*\nHazards: Yes*\n 
(CCFR) 2013-118995*\n1032 HAYNOR RD*\n*\n*\nWAVERLY*\n*\n*\n*\n*\nCHEST PAIN*\nMEDICAL EMERGENCY*\n*\n*\nLS7*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-118897*\n103 BILOXI CT*\n*\n*\nST MARYS*\n*\n*\n*\n*\nPERSON SICK*\nMEDICAL EMERGENCY*\n*\n*\nLS2*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-118872*\n230 N GROSS RD*\n1109*\n*\nKINGSLAND*\n*\n*\n*\n*\nPERSON SICK*\nMEDICAL EMERGENCY*\n*\n*\nLS4*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-118842*\n4059 MARTIN LUTHER KING BLVD*\nN2*\n*\nKINGSLAND*\n*\n*\n*\n*\nRUOK*\nRUOK*\n*\n*\nLS3*\n*\nMedical: No*\nHazards: No*\n 
(CCFR) 2013-118804*\n5792 HARRIETTS BLUFF RD*\n*\n*\nWOODBINE*\n*\n*\n*\n*\nUNCONSCIOUS*\nMEDICAL EMERGENCY*\n*\n*\nE16,LS4*\n*\nMedical: No*\nHazards: No*\n 

*/

public class GACamdenCountyAParserTest extends BaseParserTest {
  
  public GACamdenCountyAParserTest() {
    setParser(new GACamdenCountyAParser(), "CAMDEN COUNTY", "GA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "astudstill@co.camden.ga.us:2011-101695* HIGHWAY 17 STEFFANS* * * KINGSLAND* * Traffic Stop* TRAFFIC STOP* * * 1128,1140,1150,1152,509,514,523,532,LS3,R3* * Med",
        "ID:2011-101695",
        "ADDR:HIGHWAY 17",
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
        "MADDR:BOONE & SUMMERBROOK",
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
        "CALL:GAS LEAK",
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
        "MADDR:HWY 17",
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
  
  @Test
  public void testCamdenCountyFireRescue2() {

    doTest("T1",
        "(CCFR) 2013-121446*\n607 MARGARET ST*\n*\n*\nST MARYS*\n*\n*\n*\n*\nUNCONSCIOUS*\nMEDICAL EMERGENCY*\n*\n*\nLS2*\n*\nMedical: No*\nHazards: No*\n ",
        "ID:2013-121446",
        "ADDR:607 MARGARET ST",
        "CITY:ST MARYS",
        "CALL:UNCONSCIOUS",
        "UNIT:LS2",
        "INFO:Medical: No / Hazards: No");

    doTest("T2",
        "(CCFR) 2013-121383*\n" +
        "1220 BOONE ST*\n" +
        "135*\n" +
        "*\n" +
        "KINGSLAND*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "SEIZURES*\n" +
        "MEDICAL EMERGENCY*\n" +
        "*\n" +
        "*\n" +
        "ENG3,LS4*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: Yes*\n" +
        " ",

        "ID:2013-121383",
        "ADDR:1220 BOONE ST",
        "APT:135",
        "CITY:KINGSLAND",
        "CALL:SEIZURES",
        "UNIT:ENG3,LS4",
        "INFO:Medical: No / Hazards: Yes");

    doTest("T3",
        "(CCFR) 2013-121391*\n35 WILLIAMS CT*\n*\n*\nST MARYS*\n*\n*\n*\n*\nPERSON SICK*\nMEDICAL EMERGENCY*\n*\n*\nLS2*\n*\nMedical: No*\nHazards: No*\n ",
        "ID:2013-121391",
        "ADDR:35 WILLIAMS CT",
        "CITY:ST MARYS",
        "CALL:PERSON SICK",
        "UNIT:LS2",
        "INFO:Medical: No / Hazards: No");

    doTest("T4",
        "(CCFR) 2013-121387*\n" +
        "506 N CAMDEN ST*\n" +
        "*\n" +
        "*\n" +
        "KINGSLAND*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "ANIMAL*\n" +
        "ANIMAL CONTROL*\n" +
        "*\n" +
        "*\n" +
        "527,KFD,LS2,R3*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        " ",

        "ID:2013-121387",
        "ADDR:506 N CAMDEN ST",
        "CITY:KINGSLAND",
        "CALL:ANIMAL CONTROL",
        "UNIT:527,KFD,LS2,R3",
        "INFO:Medical: No / Hazards: No");

    doTest("T5",
        "(CCFR) 2013-121383*\n1220 BOONE ST*\n135*\n*\nKINGSLAND*\n*\n*\n*\n*\nSEIZURES*\nMEDICAL EMERGENCY*\n*\n*\nLS4*\n*\nMedical: No*\nHazards: Yes*\n ",
        "ID:2013-121383",
        "ADDR:1220 BOONE ST",
        "APT:135",
        "CITY:KINGSLAND",
        "CALL:SEIZURES",
        "UNIT:LS4",
        "INFO:Medical: No / Hazards: Yes");

    doTest("T6",
        "(CCFR) 2013-121379*\n" +
        "112 E FARMER AVE*\n" +
        "*\n" +
        "*\n" +
        "KINGSLAND*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "PERSON SICK*\n" +
        "MEDICAL EMERGENCY*\n" +
        "*\n" +
        "*\n" +
        "LS3*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        " ",

        "ID:2013-121379",
        "ADDR:112 E FARMER AVE",
        "CITY:KINGSLAND",
        "CALL:PERSON SICK",
        "UNIT:LS3",
        "INFO:Medical: No / Hazards: No");

    doTest("T7",
        "(CCFR) 2013-121353*\n" +
        "365 S SPRINGHILL RD S*\n" +
        "*\n" +
        "*\n" +
        "KINGSLAND*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "SUICIDE*\n" +
        "MEDICAL EMERGENCY*\n" +
        "*\n" +
        "*\n" +
        "LS3*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        " ",

        "ID:2013-121353",
        "ADDR:365 S SPRINGHILL RD S",
        "CITY:KINGSLAND",
        "CALL:SUICIDE",
        "UNIT:LS3",
        "INFO:Medical: No / Hazards: No");

    doTest("T8",
        "(CCFR) 2013-121297*\n" +
        "183 RHONE RD*\n" +
        "*\n" +
        "*\n" +
        "ST MARYS*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "PUBLIC SERV*\n" +
        "PUBLIC SERVICE (FIRE,EMS)*\n" +
        "*\n" +
        "*\n" +
        "LS2*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        " ",

        "ID:2013-121297",
        "ADDR:183 RHONE RD",
        "CITY:ST MARYS",
        "CALL:PUBLIC SERVICE (FIRE,EMS)",
        "UNIT:LS2",
        "INFO:Medical: No / Hazards: No");

    doTest("T9",
        "(CCFR) 2013-121274*\n" +
        "603 SANDBAR DR*\n" +
        "150*\n" +
        "*\n" +
        "ST MARYS*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "INVESTIGATE*\n" +
        "INVESTIGATE SUSPICIOUS PERSON/VEHICLE*\n" +
        "*\n" +
        "*\n" +
        "103,LS2*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        " ",

        "ID:2013-121274",
        "ADDR:603 SANDBAR DR",
        "APT:150",
        "CITY:ST MARYS",
        "CALL:INVESTIGATE SUSPICIOUS PERSON/VEHICLE",
        "UNIT:103,LS2",
        "INFO:Medical: No / Hazards: No");

    doTest("T10",
        "(CCFR) 2013-121209*\n1076 HWY 40 E*\n*\n*\nKINGSLAND*\n*\n*\n*\n*\nINJURY*\nTRAUMA EMERGENCY*\n*\n*\nLS3*\n*\nMedical: No*\nHazards: No*\n ",
        "ID:2013-121209",
        "ADDR:1076 HWY 40 E",
        "CITY:KINGSLAND",
        "CALL:INJURY",
        "UNIT:LS3",
        "INFO:Medical: No / Hazards: No");

    doTest("T11",
        "(CCFR) 2013-121180*\n1973 HADDOCK RD*\n*\n*\nST MARYS*\n*\n*\n*\n*\nCHEST PAIN*\nMEDICAL EMERGENCY*\n*\n*\nLS4*\n*\nMedical: No*\nHazards: No*\n ",
        "ID:2013-121180",
        "ADDR:1973 HADDOCK RD",
        "CITY:ST MARYS",
        "CALL:CHEST PAIN",
        "UNIT:LS4",
        "INFO:Medical: No / Hazards: No");

    doTest("T12",
        "(CCFR) 2013-121178*\n" +
        "808 ANN ST*\n" +
        "*\n" +
        "*\n" +
        "ST MARYS*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "PERSON SICK*\n" +
        "MEDICAL EMERGENCY*\n" +
        "ZACHARY MYZELL*\n" +
        "912-322-5895*\n" +
        "LS2*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        " ",

        "ID:2013-121178",
        "ADDR:808 ANN ST",
        "CITY:ST MARYS",
        "CALL:PERSON SICK",
        "NAME:ZACHARY MYZELL",
        "PHONE:912-322-5895",
        "UNIT:LS2",
        "INFO:Medical: No / Hazards: No");

    doTest("T13",
        "(CCFR) 2013-121133*\n102 MERIDIAN DR*\n*\n*\nKINGSLAND*\n*\n*\n*\n*\nINJURY*\nTRAUMA EMERGENCY*\n*\n*\n*\n*\nMedical: No*\nHazards: No*\n ",
        "ID:2013-121133",
        "ADDR:102 MERIDIAN DR",
        "CITY:KINGSLAND",
        "CALL:INJURY",
        "INFO:Medical: No / Hazards: No");

    doTest("T14",
        "(CCFR) 2013-121077*\n" +
        "1900 HWY 17*\n" +
        "*\n" +
        "*\n" +
        "WHITE OAK*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "INJURY*\n" +
        "TRAUMA EMERGENCY*\n" +
        "JOSEPH POWELL*\n" +
        "912-464-1705*\n" +
        "E18,LS1*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        " ",

        "ID:2013-121077",
        "ADDR:1900 HWY 17",
        "CITY:WHITE OAK",
        "CALL:INJURY",
        "NAME:JOSEPH POWELL",
        "PHONE:912-464-1705",
        "UNIT:E18,LS1",
        "INFO:Medical: No / Hazards: No");

    doTest("T15",
        "(CCFR) 2013-121077*\n" +
        "THE OLD POST OFFICE*\n" +
        "*\n" +
        "*\n" +
        "WHITE OAK*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "INJURY*\n" +
        "TRAUMA EMERGENCY*\n" +
        "JOSEPH POWELL*\n" +
        "912-464-1705*\n" +
        "LS7*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        " ",

        "ID:2013-121077",
        "ADDR:THE OLD POST OFFICE",
        "CITY:WHITE OAK",
        "CALL:INJURY",
        "NAME:JOSEPH POWELL",
        "PHONE:912-464-1705",
        "UNIT:LS7",
        "INFO:Medical: No / Hazards: No");

    doTest("T16",
        "(CCFR) 2013-120941*\n" +
        "176 LONESOME PINE DR*\n" +
        "*\n" +
        "*\n" +
        "ST MARYS*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "CHEST PAIN*\n" +
        "MEDICAL EMERGENCY*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        " ",

        "ID:2013-120941",
        "ADDR:176 LONESOME PINE DR",
        "CITY:ST MARYS",
        "CALL:CHEST PAIN",
        "INFO:Medical: No / Hazards: No");

    doTest("T17",
        "(CCFR) 2013-120912*\n307 W LAWNWOOD AVE*\n*\n*\n*\n*\n*\n*\n*\nBREATHING*\n*\n*\n*\n*\n*\nMedical: No*\nHazards: No*\n ",
        "ID:2013-120912",
        "ADDR:307 W LAWNWOOD AVE",
        "CALL:BREATHING",
        "INFO:Medical: No / Hazards: No");

    doTest("T18",
        "(CCFR) 2013-120901*\n32 COVE WAY*\n*\n*\n*\n*\n*\n*\n*\nINJURY*\n*\n*\n*\n*\n*\nMedical: No*\nHazards: No*\n ",
        "ID:2013-120901",
        "ADDR:32 COVE WAY",
        "CALL:INJURY",
        "INFO:Medical: No / Hazards: No");

    doTest("T19",
        "(CCFR) 2013-120848*\nPILOT // X1*\n*\n*\n*\n*\n*\n*\n*\nUNCONSCIOUS*\n*\n*\n*\n*\n*\nMedical: No*\nHazards: No*\n ",
        "ID:2013-120848",
        "ADDR:PILOT & X1",
        "CALL:UNCONSCIOUS",
        "INFO:Medical: No / Hazards: No");

    doTest("T20",
        "(CCFR) 2013-120703*\n" +
        "95 NB 13*\n" +
        "*\n" +
        "*\n" +
        "WOODBINE*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "ACCIDENT*\n" +
        "TRAUMA EMERGENCY*\n" +
        "*\n" +
        "912-   -*\n" +
        "1167,E11,LS1*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        " ",

        "ID:2013-120703",
        "ADDR:95 NB 13",
        "MADDR:95 13",
        "CITY:WOODBINE",
        "CALL:ACCIDENT",
        "PHONE:912-   -",
        "UNIT:1167,E11,LS1",
        "INFO:Medical: No / Hazards: No");

    doTest("T21",
        "(CCFR) 2013-120703*\n" +
        "95 NB 14*\n" +
        "*\n" +
        "*\n" +
        "WOODBINE*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "ACCIDENT*\n" +
        "TRAUMA EMERGENCY*\n" +
        "*\n" +
        "912-   -*\n" +
        "1167,E11*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        " ",

        "ID:2013-120703",
        "ADDR:95 NB 14",
        "MADDR:95 14",
        "CITY:WOODBINE",
        "CALL:ACCIDENT",
        "PHONE:912-   -",
        "UNIT:1167,E11",
        "INFO:Medical: No / Hazards: No");

    doTest("T22",
        "(CCFR) 2013-120688*\n" +
        "307 W LAWNWOOD AV*\n" +
        "*\n" +
        "*\n" +
        "KINGSLAND*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "INJURY*\n" +
        "TRAUMA EMERGENCY*\n" +
        "MELISSA*\n" +
        "912-729-5227*\n" +
        "532,LS3*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        " ",

        "ID:2013-120688",
        "ADDR:307 W LAWNWOOD AV",
        "MADDR:307 W LAWNWOOD AVE",
        "CITY:KINGSLAND",
        "CALL:INJURY",
        "NAME:MELISSA",
        "PHONE:912-729-5227",
        "UNIT:532,LS3",
        "INFO:Medical: No / Hazards: No");

    doTest("T23",
        "(CCFR) 2013-120683*\n" +
        "264 LIZA RUDOLPH RD*\n" +
        "*\n" +
        "*\n" +
        "WOODBINE*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "PERSON SICK*\n" +
        "MEDICAL EMERGENCY*\n" +
        "LAFORTUNE, MARY*\n" +
        "912-882-0567*\n" +
        "LS1*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        " ",

        "ID:2013-120683",
        "ADDR:264 LIZA RUDOLPH RD",
        "CITY:WOODBINE",
        "CALL:PERSON SICK",
        "NAME:LAFORTUNE, MARY",
        "PHONE:912-882-0567",
        "UNIT:LS1",
        "INFO:Medical: No / Hazards: No");

    doTest("T24",
        "(CCFR) 2013-120636*\n" +
        "2507 OSBORNE RD*\n" +
        "*\n" +
        "*\n" +
        "ST MARYS*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "INJURY*\n" +
        "TRAUMA EMERGENCY*\n" +
        "ANGELA COWART*\n" +
        "912-658-7600*\n" +
        "106,LS2*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        " ",

        "ID:2013-120636",
        "ADDR:2507 OSBORNE RD",
        "CITY:ST MARYS",
        "CALL:INJURY",
        "NAME:ANGELA COWART",
        "PHONE:912-658-7600",
        "UNIT:106,LS2",
        "INFO:Medical: No / Hazards: No");

    doTest("T25",
        "(CCFR) 2013-120615*\n" +
        "102 WOODHAVEN CT*\n" +
        "*\n" +
        "*\n" +
        "KINGSLAND*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "PERSON SICK*\n" +
        "MEDICAL EMERGENCY*\n" +
        "NEOMI COOPER*\n" +
        "912-552-9838*\n" +
        "LS1,R3*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        " ",

        "ID:2013-120615",
        "ADDR:102 WOODHAVEN CT",
        "CITY:KINGSLAND",
        "CALL:PERSON SICK",
        "NAME:NEOMI COOPER",
        "PHONE:912-552-9838",
        "UNIT:LS1,R3",
        "INFO:Medical: No / Hazards: No");

    doTest("T26",
        "(CCFR) 2013-120612*\n" +
        "112 CROOKED RIVER DR*\n" +
        "*\n" +
        "*\n" +
        "HARRIETTS BLUFF*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "SEIZURES*\n" +
        "MEDICAL EMERGENCY*\n" +
        "SPRINT PCS                      912*\n" +
        "912-322-9338*\n" +
        "LS4*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        " ",

        "ID:2013-120612",
        "ADDR:112 CROOKED RIVER DR",
        "CITY:HARRIETTS BLUFF",
        "CALL:SEIZURES",
        "PHONE:912-322-9338",
        "UNIT:LS4",
        "INFO:Medical: No / Hazards: No");

    doTest("T27",
        "(CCFR) 2013-120561*\n" +
        "2040 DAN PROCTOR DR*\n" +
        "220*\n" +
        "*\n" +
        "ST MARYS*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "UNCONSCIOUS*\n" +
        "MEDICAL EMERGENCY*\n" +
        "*\n" +
        "*\n" +
        "LS4*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        " ",

        "ID:2013-120561",
        "ADDR:2040 DAN PROCTOR DR",
        "APT:220",
        "CITY:ST MARYS",
        "CALL:UNCONSCIOUS",
        "UNIT:LS4",
        "INFO:Medical: No / Hazards: No");

    doTest("T28",
        "(CCFR) 2013-120539*\n101B COMMERCIAL DR*\n*\n*\nHARRIETTS BLUFF*\n*\n*\n*\n*\nFIRE ALARM*\nFIRE*\n*\n*\nLS3*\n*\nMedical: No*\nHazards: No*\n ",
        "ID:2013-120539",
        "ADDR:101B COMMERCIAL DR",
        "CITY:HARRIETTS BLUFF",
        "CALL:FIRE ALARM",
        "UNIT:LS3",
        "INFO:Medical: No / Hazards: No");

    doTest("T29",
        "(CCFR) 2013-120505*\n" +
        "119 W PINE BLUFF BLVD*\n" +
        "*\n" +
        "*\n" +
        "KINGSLAND*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "PERSON SICK*\n" +
        "MEDICAL EMERGENCY*\n" +
        "MIRAENDA, CYNTHIA*\n" +
        "912-729-3356*\n" +
        "LS3*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        " ",

        "ID:2013-120505",
        "ADDR:119 W PINE BLUFF BLVD",
        "CITY:KINGSLAND",
        "CALL:PERSON SICK",
        "NAME:MIRAENDA, CYNTHIA",
        "PHONE:912-729-3356",
        "UNIT:LS3",
        "INFO:Medical: No / Hazards: No");

    doTest("T30",
        "(CCFR) 2013-120495*\n" +
        "54 BERMUDA ST*\n" +
        "*\n" +
        "*\n" +
        "KINGSLAND*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "UNCONSCIOUS*\n" +
        "MEDICAL EMERGENCY*\n" +
        "VERIZON                         912*\n" +
        "912-856-0656*\n" +
        "LS3*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        " ",

        "ID:2013-120495",
        "ADDR:54 BERMUDA ST",
        "CITY:KINGSLAND",
        "CALL:UNCONSCIOUS",
        "PHONE:912-856-0656",
        "UNIT:LS3",
        "INFO:Medical: No / Hazards: No");

    doTest("T31",
        "(CCFR) 2013-120375*\n132 CANEY HEIGHTS*\n*\n*\n*\n*\n*\n*\n*\nINJURY*\n*\n*\n*\n*\n*\nMedical: No*\nHazards: No*\n ",
        "ID:2013-120375",
        "ADDR:132 CANEY HEIGHTS",
        "CALL:INJURY",
        "INFO:Medical: No / Hazards: No");

    doTest("T32",
        "(CCFR) 2013-120370*\nDOVER BLUFF RD*\n*\n*\n*\n*\n*\n*\n*\nVEHICLE FIRE*\n*\n*\n*\n*\n*\nMedical: No*\nHazards: No*\n ",
        "ID:2013-120370",
        "ADDR:DOVER BLUFF RD",
        "CALL:VEHICLE FIRE",
        "INFO:Medical: No / Hazards: No");

    doTest("T33",
        "(CCFR) 2013-120263*\n45 BERMUDA ST*\n*\n*\nKINGSLAND*\n*\n*\n*\n*\nCHEST PAIN*\nMEDICAL EMERGENCY*\n*\n*\n*\n*\nMedical: No*\nHazards: No*\n ",
        "ID:2013-120263",
        "ADDR:45 BERMUDA ST",
        "CITY:KINGSLAND",
        "CALL:CHEST PAIN",
        "INFO:Medical: No / Hazards: No");

    doTest("T34",
        "(CCFR) 2013-120265*\n573 HENRIETTA ST*\n*\n*\nKINGSLAND*\n*\n*\n*\n*\nSUICIDE*\nMEDICAL EMERGENCY*\n*\n*\n*\n*\nMedical: No*\nHazards: No*\n ",
        "ID:2013-120265",
        "ADDR:573 HENRIETTA ST",
        "CITY:KINGSLAND",
        "CALL:SUICIDE",
        "INFO:Medical: No / Hazards: No");

    doTest("T35",
        "(CCFR) 2013-120263*\n45 BERMUDA ST*\n*\n*\nKINGSLAND*\n*\n*\n*\n*\nCHEST PAIN*\nMEDICAL EMERGENCY*\n*\n*\n*\n*\nMedical: No*\nHazards: No*\n ",
        "ID:2013-120263",
        "ADDR:45 BERMUDA ST",
        "CITY:KINGSLAND",
        "CALL:CHEST PAIN",
        "INFO:Medical: No / Hazards: No");

    doTest("T36",
        "(CCFR) 2013-120260*\n32 COVE WAY*\n*\n*\nWOODBINE*\n*\n*\n*\n*\nFIGHT*\nFIGHT*\n*\n*\n*\n*\nMedical: No*\nHazards: No*\n ",
        "ID:2013-120260",
        "ADDR:32 COVE WAY",
        "CITY:WOODBINE",
        "CALL:FIGHT",
        "INFO:Medical: No / Hazards: No");

    doTest("T37",
        "(CCFR) 2013-120248*\n" +
        "448 HICKORY RIDGE CT*\n" +
        "*\n" +
        "*\n" +
        "WOODBINE*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "HEART PROB*\n" +
        "MEDICAL EMERGENCY*\n" +
        "*\n" +
        "*\n" +
        "E11,LS1*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        " ",

        "ID:2013-120248",
        "ADDR:448 HICKORY RIDGE CT",
        "CITY:WOODBINE",
        "CALL:HEART PROB",
        "UNIT:E11,LS1",
        "INFO:Medical: No / Hazards: No");

    doTest("T38",
        "(CCFR) 2013-120243*\n" +
        "56 HIGHTOWER ST*\n" +
        "LOT 9*\n" +
        "*\n" +
        "ST MARYS*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "INVESTIGATE*\n" +
        "INVESTIGATE SUSPICIOUS PERSON/VEHICLE*\n" +
        "*\n" +
        "*\n" +
        "1116,1117,1122,1123,1127,1151,1154,1165,1173,1175,LS2*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        " ",

        "ID:2013-120243",
        "ADDR:56 HIGHTOWER ST",
        "APT:LOT 9",
        "CITY:ST MARYS",
        "CALL:INVESTIGATE SUSPICIOUS PERSON/VEHICLE",
        "UNIT:1116,1117,1122,1123,1127,1151,1154,1165,1173,1175,LS2",
        "INFO:Medical: No / Hazards: No");

    doTest("T39",
        "(CCFR) 2013-120248*\n" +
        "448 HICKORY RIDGE CT*\n" +
        "*\n" +
        "*\n" +
        "WOODBINE*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "HEART PROB*\n" +
        "MEDICAL EMERGENCY*\n" +
        "*\n" +
        "*\n" +
        "LS1*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        " ",

        "ID:2013-120248",
        "ADDR:448 HICKORY RIDGE CT",
        "CITY:WOODBINE",
        "CALL:HEART PROB",
        "UNIT:LS1",
        "INFO:Medical: No / Hazards: No");

    doTest("T40",
        "(CCFR) 2013-120247*\n238 W DAWSON AVE*\n*\n*\nKingsland*\n*\n*\n*\n*\nHAZ-MAT*\nHAZ-MAT INCIDENT*\n*\n*\nLS3*\n*\nMedical: No*\nHazards: No*\n ",
        "ID:2013-120247",
        "ADDR:238 W DAWSON AVE",
        "CITY:Kingsland",
        "CALL:HAZ-MAT",
        "UNIT:LS3",
        "INFO:Medical: No / Hazards: No");

    doTest("T41",
        "(CCFR) 2013-120234*\n103 RIVERBEND DR*\n*\n*\n*\n*\n*\n*\n*\nSUICIDE*\nMEDICAL EMERGENCY*\n*\n*\nLS4*\n*\nMedical: No*\nHazards: No*\n ",
        "ID:2013-120234",
        "ADDR:103 RIVERBEND DR",
        "CALL:SUICIDE",
        "UNIT:LS4",
        "INFO:Medical: No / Hazards: No");

    doTest("T42",
        "(CCFR) 2013-120203*\n" +
        "GREEN CEDAR COELRAIN AND SPUR 40*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "SPECIAL DUTY*\n" +
        "SPECIAL DUTY*\n" +
        "*\n" +
        "*\n" +
        "ENG21,LS2*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        " ",

        "ID:2013-120203",
        "ADDR:GREEN CEDAR COELRAIN AND SPUR 40",
        "MADDR:GREEN CEDAR COELRAIN & SPUR 40",
        "CALL:SPECIAL DUTY",
        "UNIT:ENG21,LS2",
        "INFO:Medical: No / Hazards: No");

    doTest("T43",
        "(CCFR) 2013-120068*\n" +
        "201 LAKE SHORE DR*\n" +
        "*\n" +
        "*\n" +
        "ST MARYS*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "CHEST PAIN*\n" +
        "MEDICAL EMERGENCY*\n" +
        "TERESA JACKSON  B*\n" +
        "912-576-4087*\n" +
        "LS2*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        " ",

        "ID:2013-120068",
        "ADDR:201 LAKE SHORE DR",
        "CITY:ST MARYS",
        "CALL:CHEST PAIN",
        "NAME:TERESA JACKSON  B",
        "PHONE:912-576-4087",
        "UNIT:LS2",
        "INFO:Medical: No / Hazards: No");

    doTest("T44",
        "(CCFR) 2013-120056*\n" +
        "6586 E HWY 40*\n" +
        "*\n" +
        "*\n" +
        "ST MARYS*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "UNCONSCIOUS*\n" +
        "MEDICAL EMERGENCY*\n" +
        "WAL MART SUPERCENTER*\n" +
        "912-510-9220*\n" +
        "LS3*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        " ",

        "ID:2013-120056",
        "ADDR:6586 E HWY 40",
        "CITY:ST MARYS",
        "CALL:UNCONSCIOUS",
        "NAME:WAL MART SUPERCENTER",
        "PHONE:912-510-9220",
        "UNIT:LS3",
        "INFO:Medical: No / Hazards: No");

    doTest("T45",
        "(CCFR) 2013-120029*\n213 CYPRESS DR*\n*\n*\n*\n*\n*\n*\n*\nSEIZURES*\nMEDICAL EMERGENCY*\nDOROTHY*\n*\n*\n*\nMedical: Yes*\nHazards: Yes*\n ",
        "ID:2013-120029",
        "ADDR:213 CYPRESS DR",
        "CALL:SEIZURES",
        "NAME:DOROTHY",
        "INFO:Medical: Yes / Hazards: Yes");

    doTest("T46",
        "(CCFR) 2013-120007*\n501 S LEE ST*\n109*\n*\n*\n*\n*\n*\n*\nSUICIDE*\nMEDICAL EMERGENCY*\nECONOMY INN*\n*\n*\n*\nMedical: No*\nHazards: No*\n ",
        "ID:2013-120007",
        "ADDR:501 S LEE ST",
        "APT:109",
        "CALL:SUICIDE",
        "NAME:ECONOMY INN",
        "INFO:Medical: No / Hazards: No");

    doTest("T47",
        "(CCFR) 2013-119997*\n" +
        "466 PELICAN CIR*\n" +
        "*\n" +
        "*\n" +
        "HARRIETTS BLUFF*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "PERSON SICK*\n" +
        "MEDICAL EMERGENCY*\n" +
        "JEAN WOODS*\n" +
        "912-   -*\n" +
        "LS4*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        " ",

        "ID:2013-119997",
        "ADDR:466 PELICAN CIR",
        "CITY:HARRIETTS BLUFF",
        "CALL:PERSON SICK",
        "NAME:JEAN WOODS",
        "PHONE:912-   -",
        "UNIT:LS4",
        "INFO:Medical: No / Hazards: No");

    doTest("T48",
        "(CCFR) 2013-119978*\n" +
        "205 7 TH ST*\n" +
        "*\n" +
        "*\n" +
        "WOODBINE*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "INJURY*\n" +
        "TRAUMA EMERGENCY*\n" +
        "*\n" +
        "912-856-8794*\n" +
        "LS1*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        " ",

        "ID:2013-119978",
        "ADDR:205 7 TH ST",
        "CITY:WOODBINE",
        "CALL:INJURY",
        "PHONE:912-856-8794",
        "UNIT:LS1",
        "INFO:Medical: No / Hazards: No");

    doTest("T49",
        "(CCFR) 2013-119937*\n" +
        "WALMART // KINGSBAY RD*\n" +
        "*\n" +
        "*\n" +
        "KINGSLAND*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "ACCIDENT*\n" +
        "TRAUMA EMERGENCY*\n" +
        "*\n" +
        "*\n" +
        "125,513,524,LS4*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        " ",

        "ID:2013-119937",
        "ADDR:WALMART & KINGSBAY RD",
        "CITY:KINGSLAND",
        "CALL:ACCIDENT",
        "UNIT:125,513,524,LS4",
        "INFO:Medical: No / Hazards: No");

    doTest("T50",
        "(CCFR) 2013-119882*\nBACHLOTT RD*\n*\n*\nST MARYS*\n*\n*\n*\n*\nSMOKE INVEST*\nFIRE*\n*\n*\n*\n*\nMedical: No*\nHazards: No*\n ",
        "ID:2013-119882",
        "ADDR:BACHLOTT RD",
        "CITY:ST MARYS",
        "CALL:SMOKE INVEST",
        "INFO:Medical: No / Hazards: No");

    doTest("T51",
        "(CCFR) 2013-119867*\n" +
        "40 // LIGHTHOUSE RADIO*\n" +
        "*\n" +
        "*\n" +
        "ST MARYS*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "ACCIDENT*\n" +
        "TRAUMA EMERGENCY*\n" +
        "*\n" +
        "912-   -*\n" +
        "LS4*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        " ",

        "ID:2013-119867",
        "ADDR:40",
        "CITY:ST MARYS",
        "PLACE:LIGHTHOUSE RADIO",
        "CALL:ACCIDENT",
        "PHONE:912-   -",
        "UNIT:LS4",
        "INFO:Medical: No / Hazards: No");

    doTest("T52",
        "(CCFR) 2013-119864*\n25399 HWY 17 N*\n*\n*\nWAVERLY*\n*\n*\n*\n*\nPERSON SICK*\nMEDICAL EMERGENCY*\n*\n*\nE17*\n*\nMedical: No*\nHazards: No*\n ",
        "ID:2013-119864",
        "ADDR:25399 HWY 17 N",
        "CITY:WAVERLY",
        "CALL:PERSON SICK",
        "UNIT:E17",
        "INFO:Medical: No / Hazards: No");

    doTest("T53",
        "(CCFR) 2013-119802*\n" +
        "505 ANN ST*\n" +
        "*\n" +
        "*\n" +
        "ST MARYS*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "MED ALARM*\n" +
        "MEDICAL EMERGENCY*\n" +
        "JASMIN XFINITI HOME*\n" +
        "800-633-2677*\n" +
        "125,LS2*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        " ",

        "ID:2013-119802",
        "ADDR:505 ANN ST",
        "CITY:ST MARYS",
        "CALL:MED ALARM",
        "NAME:JASMIN XFINITI HOME",
        "PHONE:800-633-2677",
        "UNIT:125,LS2",
        "INFO:Medical: No / Hazards: No");

    doTest("T54",
        "(CCFR) 2013-119722*\n756 KINLAW RD*\n*\n*\nKINGSLAND*\n*\n*\n*\n*\nUNCONSCIOUS*\nMEDICAL EMERGENCY*\n*\n*\nLS3*\n*\nMedical: No*\nHazards: No*\n ",
        "ID:2013-119722",
        "ADDR:756 KINLAW RD",
        "CITY:KINGSLAND",
        "CALL:UNCONSCIOUS",
        "UNIT:LS3",
        "INFO:Medical: No / Hazards: No");

    doTest("T55",
        "(CCFR) 2013-119663*\n" +
        "8260 BURNT FORT RD*\n" +
        "*\n" +
        "*\n" +
        "WHITE OAK*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "PERSON SICK*\n" +
        "MEDICAL EMERGENCY*\n" +
        "*\n" +
        "*\n" +
        "LS1*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        " ",

        "ID:2013-119663",
        "ADDR:8260 BURNT FORT RD",
        "CITY:WHITE OAK",
        "CALL:PERSON SICK",
        "UNIT:LS1",
        "INFO:Medical: No / Hazards: No");

    doTest("T56",
        "(CCFR) 2013-119636*\nW BRYANT // BARTLETT*\n*\n*\nST MARYS*\n*\n*\n*\n*\nSMOKE INVEST*\nFIRE*\n*\n*\nLS2*\n*\nMedical: No*\nHazards: No*\n ",
        "ID:2013-119636",
        "ADDR:W BRYANT & BARTLETT",
        "CITY:ST MARYS",
        "CALL:SMOKE INVEST",
        "UNIT:LS2",
        "INFO:Medical: No / Hazards: No");

    doTest("T57",
        "(CCFR) 2013-119541*\n" +
        "HWY 40 KMART*\n" +
        "*\n" +
        "*\n" +
        "KINGSLAND*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "ACCIDENT*\n" +
        "TRAUMA EMERGENCY*\n" +
        "*\n" +
        "*\n" +
        "503,533,537,LS4*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        " ",

        "ID:2013-119541",
        "ADDR:HWY 40",
        "CITY:KINGSLAND",
        "PLACE:KMART",
        "CALL:ACCIDENT",
        "UNIT:503,533,537,LS4",
        "INFO:Medical: No / Hazards: No");

    doTest("T58",
        "(CCFR) 2013-119542*\n" +
        "6011 CHARLIE SMITH SR HWY*\n" +
        "*\n" +
        "*\n" +
        "ST MARYS*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "INJURY*\n" +
        "TRAUMA EMERGENCY*\n" +
        "*\n" +
        "*\n" +
        "LS4*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        " ",

        "ID:2013-119542",
        "ADDR:6011 CHARLIE SMITH SR HWY",
        "MADDR:6011 CHARLIE SMITH ST HWY",
        "CITY:ST MARYS",
        "CALL:INJURY",
        "UNIT:LS4",
        "INFO:Medical: No / Hazards: No");

    doTest("T59",
        "(CCFR) 2013-119517*\n404 THOROUGHBRED RD*\n*\n*\nST MARYS*\n*\n*\n*\n*\nWELFARE CHK*\nWELFARE CHECK*\n*\n*\nLS2*\n*\nMedical: No*\nHazards: No*\n ",
        "ID:2013-119517",
        "ADDR:404 THOROUGHBRED RD",
        "CITY:ST MARYS",
        "CALL:WELFARE CHECK",
        "UNIT:LS2",
        "INFO:Medical: No / Hazards: No");

    doTest("T60",
        "(CCFR) 2013-119331*\n284 HICKORY BLUFF RD*\n*\n*\nWAVERLY*\n*\n*\n*\n*\nWIRE DOWN*\nFIRE*\n*\n*\nLS7*\n*\nMedical: No*\nHazards: No*\n ",
        "ID:2013-119331",
        "ADDR:284 HICKORY BLUFF RD",
        "CITY:WAVERLY",
        "CALL:WIRE DOWN",
        "UNIT:LS7",
        "INFO:Medical: No / Hazards: No");

    doTest("T61",
        "(CCFR) 2013-119330*\n" +
        "250 GROSS RD*\n" +
        "1D*\n" +
        "*\n" +
        "KINGSLAND*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "CHEST PAIN*\n" +
        "MEDICAL EMERGENCY*\n" +
        "SHINKLE, SARAH                  APT*\n" +
        "912-673-1924*\n" +
        "LS4*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        " ",

        "ID:2013-119330",
        "ADDR:250 GROSS RD",
        "APT:1D",
        "CITY:KINGSLAND",
        "CALL:CHEST PAIN",
        "NAME:SHINKLE, SARAH                  APT",
        "PHONE:912-673-1924",
        "UNIT:LS4",
        "INFO:Medical: No / Hazards: No");

    doTest("T62",
        "(CCFR) 2013-119297*\n650 BILLYVILLE RD*\n*\n*\nWOODBINE*\n*\n*\n*\n*\nBREATHING*\nMEDICAL EMERGENCY*\n*\n*\nLS1*\n*\nMedical: No*\nHazards: No*\n ",
        "ID:2013-119297",
        "ADDR:650 BILLYVILLE RD",
        "CITY:WOODBINE",
        "CALL:BREATHING",
        "UNIT:LS1",
        "INFO:Medical: No / Hazards: No");

    doTest("T63",
        "(CCFR) 2013-119248*\n" +
        "20930 W HWY 40*\n" +
        "LOT 18*\n" +
        "*\n" +
        "KINGSLAND*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "UNCONSCIOUS*\n" +
        "MEDICAL EMERGENCY*\n" +
        "FOX, GRACE*\n" +
        "912-576-4656*\n" +
        "1138,LS3*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        " ",

        "ID:2013-119248",
        "ADDR:20930 W HWY 40",
        "APT:LOT 18",
        "CITY:KINGSLAND",
        "CALL:UNCONSCIOUS",
        "NAME:FOX, GRACE",
        "PHONE:912-576-4656",
        "UNIT:1138,LS3",
        "INFO:Medical: No / Hazards: No");

    doTest("T64",
        "(CCFR) 2013-119237*\n309 PAPER PL*\n*\n*\nST MARYS*\n*\n*\n*\n*\nPERSON SICK*\nMEDICAL EMERGENCY*\n*\n*\nLS2*\n*\nMedical: No*\nHazards: No*\n ",
        "ID:2013-119237",
        "ADDR:309 PAPER PL",
        "CITY:ST MARYS",
        "CALL:PERSON SICK",
        "UNIT:LS2",
        "INFO:Medical: No / Hazards: No");

    doTest("T65",
        "(CCFR) 2013-119215*\n" +
        "141 N GROVE BLVD*\n" +
        "*\n" +
        "*\n" +
        "KINGSLAND*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "PERSON SICK*\n" +
        "MEDICAL EMERGENCY*\n" +
        "*\n" +
        "*\n" +
        "LS3*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        " ",

        "ID:2013-119215",
        "ADDR:141 N GROVE BLVD",
        "CITY:KINGSLAND",
        "CALL:PERSON SICK",
        "UNIT:LS3",
        "INFO:Medical: No / Hazards: No");

    doTest("T66",
        "(CCFR) 2013-119108*\n" +
        "ST MARYS DOCK*\n" +
        "*\n" +
        "*\n" +
        "ST MARYS*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "PERSON SICK*\n" +
        "MEDICAL EMERGENCY*\n" +
        "ELIZABETH YEE - RANGER*\n" +
        "912-409-0357*\n" +
        "LS2*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        " ",

        "ID:2013-119108",
        "ADDR:ST MARYS DOCK",
        "CITY:ST MARYS",
        "CALL:PERSON SICK",
        "NAME:ELIZABETH YEE - RANGER",
        "PHONE:912-409-0357",
        "UNIT:LS2",
        "INFO:Medical: No / Hazards: No");

    doTest("T67",
        "(CCFR) 2013-119081*\n" +
        "95 SB 1MM*\n" +
        "*\n" +
        "*\n" +
        "KINGSLAND*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "ACCIDENT*\n" +
        "TRAUMA EMERGENCY*\n" +
        "DAN FRAZIER*\n" +
        "717-715-3130*\n" +
        "1126,1145,LS4*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        " ",

        "ID:2013-119081",
        "ADDR:95 SB 1MM",
        "MADDR:95 1MM",
        "CITY:KINGSLAND",
        "CALL:ACCIDENT",
        "NAME:DAN FRAZIER",
        "PHONE:717-715-3130",
        "UNIT:1126,1145,LS4",
        "INFO:Medical: No / Hazards: No");

    doTest("T68",
        "(CCFR) 2013-119022*\n" +
        "790 E KING AVE*\n" +
        "*\n" +
        "*\n" +
        "KINGSLAND*\n" +
        "GROVE BLVD*\n" +
        "WILLIAMS ST*\n" +
        "*\n" +
        "Landmark Comment: LS3 DIST3*\n" +
        "HAZ-MAT*\n" +
        "HAZ-MAT INCIDENT*\n" +
        "*\n" +
        "912-   -*\n" +
        "535,LS3*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: Yes*\n" +
        " ",

        "ID:2013-119022",
        "ADDR:790 E KING AVE",
        "CITY:KINGSLAND",
        "CALL:WILLIAMS ST",
        "PHONE:Landmark Comment: LS3 DIST3",
        "UNIT:HAZ-MAT",
        "INFO:HAZ-MAT INCIDENT / 912-   - / 535,LS3 / Medical: No / Hazards: Yes");

    doTest("T69",
        "(CCFR) 2013-118995*\n1032 HAYNOR RD*\n*\n*\nWAVERLY*\n*\n*\n*\n*\nCHEST PAIN*\nMEDICAL EMERGENCY*\n*\n*\nLS7*\n*\nMedical: No*\nHazards: No*\n ",
        "ID:2013-118995",
        "ADDR:1032 HAYNOR RD",
        "CITY:WAVERLY",
        "CALL:CHEST PAIN",
        "UNIT:LS7",
        "INFO:Medical: No / Hazards: No");

    doTest("T70",
        "(CCFR) 2013-118897*\n103 BILOXI CT*\n*\n*\nST MARYS*\n*\n*\n*\n*\nPERSON SICK*\nMEDICAL EMERGENCY*\n*\n*\nLS2*\n*\nMedical: No*\nHazards: No*\n ",
        "ID:2013-118897",
        "ADDR:103 BILOXI CT",
        "CITY:ST MARYS",
        "CALL:PERSON SICK",
        "UNIT:LS2",
        "INFO:Medical: No / Hazards: No");

    doTest("T71",
        "(CCFR) 2013-118872*\n" +
        "230 N GROSS RD*\n" +
        "1109*\n" +
        "*\n" +
        "KINGSLAND*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "PERSON SICK*\n" +
        "MEDICAL EMERGENCY*\n" +
        "*\n" +
        "*\n" +
        "LS4*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        " ",

        "ID:2013-118872",
        "ADDR:230 N GROSS RD",
        "APT:1109",
        "CITY:KINGSLAND",
        "CALL:PERSON SICK",
        "UNIT:LS4",
        "INFO:Medical: No / Hazards: No");

    doTest("T72",
        "(CCFR) 2013-118842*\n4059 MARTIN LUTHER KING BLVD*\nN2*\n*\nKINGSLAND*\n*\n*\n*\n*\nRUOK*\nRUOK*\n*\n*\nLS3*\n*\nMedical: No*\nHazards: No*\n ",
        "ID:2013-118842",
        "ADDR:4059 MARTIN LUTHER KING BLVD",
        "APT:N2",
        "CITY:KINGSLAND",
        "CALL:RUOK",
        "UNIT:LS3",
        "INFO:Medical: No / Hazards: No");

    doTest("T73",
        "(CCFR) 2013-118804*\n" +
        "5792 HARRIETTS BLUFF RD*\n" +
        "*\n" +
        "*\n" +
        "WOODBINE*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "*\n" +
        "UNCONSCIOUS*\n" +
        "MEDICAL EMERGENCY*\n" +
        "*\n" +
        "*\n" +
        "E16,LS4*\n" +
        "*\n" +
        "Medical: No*\n" +
        "Hazards: No*\n" +
        " ",

        "ID:2013-118804",
        "ADDR:5792 HARRIETTS BLUFF RD",
        "CITY:WOODBINE",
        "CALL:UNCONSCIOUS",
        "UNIT:E16,LS4",
        "INFO:Medical: No / Hazards: No");

  }
  
  public static void main(String[] args) {
    new GACamdenCountyAParserTest().generateTests("T1");
  }
}
