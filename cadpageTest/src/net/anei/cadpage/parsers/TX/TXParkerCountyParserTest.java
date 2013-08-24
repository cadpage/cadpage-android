package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/* 
Parker County, TX
Contact: Active911
Agency name: Parker County ESD 1
Location: Springtown, TX, United States
Sender: "Fire Dispatch" <Fire.Dispatch@parkercountytx.com>

 \n\n\nTitle\n\n46 SEIZURES\n\n\nStation\n\n46\n\n\nPlace Name\n\n \n\n\nAddress\n\n1170 FM 1885\n\n\nCross Street\n\n \n\n\nCity\n\nPEASTER\n\n\nLat/Long\n\n \n\n\nMap\n\n21J\n\n\nDetails\n\nSTA 46 WITH MEDIC 13 SEIZURES. ADDRESS ON MAILBOX. LARGE TOWER IN\nBACKYARD. LOG CABIN HOUSE\n\n \n\n \n\n \n\n \n\n 
 \n\n\nTitle\n\nGRASS FIRE NEAR STRUCTURES, STA 46\n\n\nStation\n\n46\n\n\nPlace Name\n\n \n\n\nAddress\n\n2340 RUSSELL BEND RD\n\n\nCross Street\n\n \n\n\nCity\n\nSPRINGTOWN\n\n\nLat/Long\n\n \n\n\nMap\n\n \n\n\nDetails\n\n \n\n \n\n \n\n \n\n \n\n 
 \n\n\nTitle\n\nEMS CALL\n\n\nStation\n\n51\n\n\nPlace Name\n\n \n\n\nAddress\n\n4501 E HWY 199 LOT 77\n\n\nCross Street\n\n \n\n\nCity\n\nLA JUNTA\n\n\nLat/Long\n\n \n\n\nMap\n\n \n\n\nDetails\n\nGENERAL MEDICINE CALL LIFECARE ENROUTE\n\n \n\n \n\n \n\n \n\n 
 \n\n\nTitle\n\nABDOMINAL PAIN\n\n\nStation\n\n51\n\n\nPlace Name\n\n \n\n\nAddress\n\n680 NEW HOPE RD\n\n\nCross Street\n\n \n\n\nCity\n\nLA JUNTA\n\n\nLat/Long\n\n \n\n\nMap\n\n405J\n\n\nDetails\n\nABD PAIN LIFECARE ENROUTE\n\n \n\n \n\n \n\n \n\n 
 \n\n\nTitle\n\nPOSS STRUCTURE FIRE\n\n\nStation\n\n51 48\n\n\nPlace Name\n\n \n\n\nAddress\n\n200BLK SANDY OAKS RD\n\n\nCross Street\n\n \n\n\nCity\n\n \n\n\nLat/Long\n\n \n\n\nMap\n\n428N\n\n\nDetails\n\nPOSS STRUCTURE FIRE SMOKE FROM A RESIDENCE\n\n \n\n \n\n \n\n \n\n 
 \n\n\nTitle\n\nVEHICLE UNLOCK\n\n\nStation\n\n48\n\n\nPlace Name\n\nCHADWELL AND SON GAS CO\n\n\nAddress\n\n608 HWY 199\n\n\nCross Street\n\nHILLTOP DR\n\n\nCity\n\nSPRINGTOWN\n\n\nLat/Long\n\n \n\n\nMap\n\n402Y\n\n\nDetails\n\nBLK CHEVY TRK, NOT RUNNING- DOG INSIDE\n\n \n\n \n\n \n\n \n\n 
 \n\n\nTitle\n\nEMS GEN MED\n\n\nStation\n\n51\n\n\nPlace Name\n\n \n\n\nAddress\n\n5724 MIDWAY RD\n\n\nCross Street\n\n \n\n\nCity\n\nSPRINGTOWN\n\n\nLat/Long\n\n \n\n\nMap\n\n427T\n\n\nDetails\n\nMEDIC 21\n\n \n\n \n\n \n\n \n\n 
 \n\n\nTitle\n\nFALL\n\n\nStation\n\n54\n\n\nPlace Name\n\n \n\n\nAddress\n\n200 REESE LN\n\n\nCross Street\n\n \n\n\nCity\n\nSILVERCREEK\n\n\nLat/Long\n\n \n\n\nMap\n\n477L\n\n\nDetails\n\nFALL LIFECARE ENROUTE\n\n \n\n \n\n \n\n \n\n 
 \n\n\nTitle\n\nFALL\n\n\nStation\n\n51\n\n\nPlace Name\n\n \n\n\nAddress\n\n118 GILLEY LN\n\n\nCross Street\n\n \n\n\nCity\n\nLA JUNTA\n\n\nLat/Long\n\n \n\n\nMap\n\n452D\n\n\nDetails\n\nFALL LIFECARE ENROUTE\n\n \n\n \n\n \n\n \n\n 
 \n\n\nTitle\n\nCANCEL MVA\n\n\nStation\n\n48\n\n\nPlace Name\n\n \n\n\nAddress\n\n1815 199 E\n\n\nCross Street\n\nNA\n\n\nCity\n\nNA\n\n\nLat/Long\n\n \n\n\nMap\n\nNA\n\n\nDetails\n\nAll 48 companies can cancel MVA, Will be Reno FD district- BRADY PCFA\n\n \n\n \n\n \n\n \n\n 
 \n\n\nTitle\n\nMVA\n\n\nStation\n\n48\n\n\nPlace Name\n\n \n\n\nAddress\n\n1815 E HWY 199\n\n\nCross Street\n\nNA\n\n\nCity\n\nNA\n\n\nLat/Long\n\n \n\n\nMap\n\nNA\n\n\nDetails\n\n \n\n \n\n \n\n \n\n \n\n 
 \n\n\nTitle\n\nGrass Fire\n\n\nStation\n\n48\n\n\nPlace Name\n\n \n\n\nAddress\n\nMcVoid Rd\n\n\nCross Street\n\nKnob Rd\n\n\nCity\n\nSpringtown\n\n\nLat/Long\n\n \n\n\nMap\n\n404 E\n\n\nDetails\n\nNearing Structure\n\n \n\n \n\n \n\n \n\n 
 \n\n\nTitle\n\nODOR INVESTIGATION\n\n\nStation\n\n51\n\n\nPlace Name\n\n \n\n\nAddress\n\n301 PINE BLUFF LN\n\n\nCross Street\n\n \n\n\nCity\n\n \n\n\nLat/Long\n\n \n\n\nMap\n\n \n\n\nDetails\n\n \n\n \n\n \n\n \n\n \n\n 
 \n\n\nTitle\n\n \n\n\nStation\n\nSTA 51\n\n\nPlace Name\n\n \n\n\nAddress\n\nALICE SPRINGS/KURANDA\n\n\nCross Street\n\n \n\n\nCity\n\nLAJUNTA\n\n\nLat/Long\n\n \n\n\nMap\n\n428T\n\n\nDetails\n\nGRASS FIRE ALONG SIDE THE ROAD\n\n \n\n \n\n \n\n \n\n 
 \n\n\nTitle\n\nMVA\n\n\nStation\n\n48\n\n\nPlace Name\n\n \n\n\nAddress\n\nSH 199 & OLD AGNES\n\n\nCross Street\n\n \n\n\nCity\n\n \n\n\nLat/Long\n\n \n\n\nMap\n\n21D\n\n\nDetails\n\nMVA FROM PCSO NO FURTHER DETAILS\n\n \n\n \n\n \n\n \n\n 
 \n\n\nTitle\n\nGRASS FIRE\n\n\nStation\n\n48\n\n\nPlace Name\n\n \n\n\nAddress\n\n511 BLUE SKY CT\n\n\nCross Street\n\n \n\n\nCity\n\nSPRINGTOWN\n\n\nLat/Long\n\n \n\n\nMap\n\n22J\n\n\nDetails\n\nMULTIPLE CALLS GRASS FIRE NEXT DOOR\n\n \n\n \n\n \n\n \n\n 
 \n\n\nTitle\n\nEMS\n\n\nStation\n\n51\n\n\nPlace Name\n\n \n\n\nAddress\n\n117 OAK MEADOW DR\n\n\nCross Street\n\n \n\n\nCity\n\n \n\n\nLat/Long\n\n \n\n\nMap\n\n \n\n\nDetails\n\nPR. 1 POSS. MI\n\n \n\n \n\n \n\n \n\n 
 \n\n\nTitle\n\nMVC\n\n\nStation\n\n48\n\n\nPlace Name\n\n \n\n\nAddress\n\n2600 W 199\n\n\nCross Street\n\n \n\n\nCity\n\n \n\n\nLat/Long\n\n \n\n\nMap\n\n \n\n\nDetails\n\n6 VEHICLES\n\n \n\n \n\n \n\n \n\n 
 \n\n\nTitle\n\nUNAUTHORIZED BURN\n\n\nStation\n\n54\n\n\nPlace Name\n\n \n\n\nAddress\n\n114 BAUGHMAN HILL RD\n\n\nCross Street\n\nFLAT ROCK RD\n\n\nCity\n\n \n\n\nLat/Long\n\n \n\n\nMap\n\n453Q\n\n\nDetails\n\n \n\n \n\n \n\n \n\n \n\n 
 \n\n\nTitle\n\nSMOKE INVESTIGATION\n\n\nStation\n\n51\n\n\nPlace Name\n\n \n\n\nAddress\n\nVEAL STATION & TUCKER\n\n\nCross Street\n\n \n\n\nCity\n\n \n\n\nLat/Long\n\n \n\n\nMap\n\n451Q\n\n\nDetails\n\nCALLER REPORTS LARGE AMOUNT OF SMOKE NW OF THAT LOCATION\n\n \n\n \n\n \n\n \n\n 
 \n\n\nTitle\n\nEMS\n\n\nStation\n\n51\n\n\nPlace Name\n\n \n\n\nAddress\n\n801 ROSS \n\n\nCross Street\n\n \n\n\nCity\n\n \n\n\nLat/Long\n\n \n\n\nMap\n\n \n\n\nDetails\n\nFALL \n\n \n\n \n\n \n\n \n\n 
(MUTIAL AID WITH CENTRAL FRIENDSHIP RD)  \n\n\nTitle\n\n \n\n\nStation\n\nSILVER CREEK\n\n\nPlace Name\n\n \n\n\nAddress\n\nFRIENDSHIP RD \n\n\nCross Street\n\n1 MILE EAST FM 51 N\n\n\nCity\n\nWEATHERFORD\n\n\nLat/Long\n\n \n\n\nMap\n\n472D\n\n\nDetails\n\nMUTIAL AID WITH CENTRAL POSS STRUCTURE FIRE\n\n \n\n \n\n \n\n \n\n 
(2nd tone for structure fire)                                 \n\n\nTitle\n\nStructure fire mutual aide with Tarrant county\n\n\nStation\n\nLaJunta \n\n\nPlace Name\n\nResidential\n\n\nAddress\n\n6113 Blue Leaf Ct.\n\n\nCross Street\n\nTenderfoot Tr\n\n\nCity\n\n \n\n\nLat/Long\n\n \n\n\nMap\n\n454Z\n\n\nDetails\n\nTarrant county is needing a tanker for 1st alarm on a residential\nstructure fire.\n\n \n\n \n\n \n\n \n\n 
(6113 Blue Leaf Ct structure fire mutual aide Tarrant co)  \n\n\nTitle\n\nMutual aide with Tarrant Co structure fire\n\n\nStation\n\nLaJunta\n\n\nPlace Name\n\nResidential\n\n\nAddress\n\n6113 Blue Leaf Ct\n\n\nCross Street\n\nTenderfoot Tr\n\n\nCity\n\n \n\n\nLat/Long\n\n \n\n\nMap\n\n454Z\n\n\nDetails\n\nTanker requested on structure fire mutual aide 1st alarm with Tarrant\nCo.\n\n \n\n \n\n \n\n \n\n 
 \n\n\nTitle\n\nEMS\n\n\nStation\n\n48\n\n\nPlace Name\n\n \n\n\nAddress\n\nPeel Rd no numerics avalible\n\n\nCross Street\n\nOld Cottondale Rd\n\n\nCity\n\nNA\n\n\nLat/Long\n\n \n\n\nMap\n\n402 F\n\n\nDetails\n\nReported Hit and run Toned by LC - Brady PCFA\n\n \n\n \n\n \n\n \n\n 
 \n\n\nTitle\n\nDifficulty Breathing\n\n\nStation\n\n48\n\n\nPlace Name\n\nResidence\n\n\nAddress\n\n313 W. 3rd Terrace\n\n\nCross Street\n\nN. Birch St.\n\n\nCity\n\nSpringtown\n\n\nLat/Long\n\n \n\n\nMap\n\n402 T\n\n\nDetails\n\nToned by LC, Caller requesting silent approach - Brady PCFA\n\n \n\n \n\n \n\n \n\n 
 \n\n\nTitle\n\nAssist Officers/Missing Children\n\n\nStation\n\n48\n\n\nPlace Name\n\nResidence\n\n\nAddress\n\n206 Walnut Bend\n\n\nCross Street\n\nAsh St. N\n\n\nCity\n\nSpringtown\n\n\nLat/Long\n\n \n\n\nMap\n\n402 T\n\n\nDetails\n\nMissing Children, last seen playing with walkie talkie, 7yof wearing\ngreenish/gray shirt with stars on it, No description of 12 yof. Respond\non TAC 1 - Brady PCFA\n\n \n\n \n\n \n\n \n\n 
 \n\n\nTitle\n\nLIFT ASSIST\n\n\nStation\n\n51\n\n\nPlace Name\n\n \n\n\nAddress\n\n317 CEDARWOOD ST\n\n\nCross Street\n\n \n\n\nCity\n\n \n\n\nLat/Long\n\n \n\n\nMap\n\n429U\n\n\nDetails\n\nMALE ON THE GROUND NEEDING LIFT ASSIST NO INJURIES\n\n \n\n \n\n \n\n \n\n 
 \n\n\nTitle\n\nUNK TYPE FIRE\n\n\nStation\n\n48\n\n\nPlace Name\n\n \n\n\nAddress\n\n1700BLK HWY 199\n\n\nCross Street\n\n \n\n\nCity\n\nSPRINGTOWN\n\n\nLat/Long\n\n \n\n\nMap\n\n22B\n\n\nDetails\n\nUNK TYPE FIRE IN THE AREA POSSIBLE CONTROLLED BURN\n\n \n\n \n\n \n\n \n\n 
 \n\n\nTitle\n\nLock Out\n\n\nStation\n\n48\n\n\nPlace Name\n\nPark\n\n\nAddress\n\nPark behind Brookshires\n\n\nCross Street\n\n \n\n\nCity\n\nSpringtown\n\n\nLat/Long\n\n \n\n\nMap\n\n22C\n\n\nDetails\n\n18 Month old inside, not running, Maroon Tahoe - Brady PCFA\n\n \n\n \n\n \n\n \n\n 
 
Contact: Active911
Agency name: Parker County ESD #6
Location: Weatherford, TX, United States
Sender: "Fire Dispatch" <Fire.Dispatch@parkercountytx.com>

\nTitle\n\nUNKNOWN TYPE FIRE\n\n\nStation\n\n44\n\n\nPlace Name\n\nRESIDENTIAL\n\n\nAddress\n\n336 SANTA FE TRAIL\n\n\nCross Street\n\nWESTERN LAKE DR\n\n\nCity\n\nNA\n\n\nLat/Long\n\nNA\n\n\nMap\n\n566R\n\n\nDetails\n\nREPORTED TO BE BEHIND THE RESIDENCE ACROSS FROM LISTED LOCATION. RESPOND\nON TAC1-BRADY PCFA\n\n 
\nTitle\n\nEMS\n\n\nStation\n\n44\n\n\nPlace Name\n\n \n\n\nAddress\n\n4832 Horseshoe Drive\n\n\nCross Street\n\nWestern Lake Drive\n\n\nCity\n\nN/A\n\n\nLat/Long\n\n \n\n\nMap\n\n567 N\n\n\nDetails\n\nP1 Chest Pain. Toned by Lifecare.\n\n 
\nTitle\n\nPri. 2 sick person\n\n\nStation\n\nSpring Creek\n\n\nPlace Name\n\nResidence\n\n\nAddress\n\n424 lipan trail \n\n\nCross Street\n\nN/A\n\n\nCity\n\nN/A\n\n\nLat/Long\n\nN/A\n\n\nMap\n\n589J\n\n\nDetails\n\nPri. 2 sick person with medic 13.\n\n-Brady PCFA\n\n 
\nTitle\n\nP1 Seizures \n\n\nStation\n\n44\n\n\nPlace Name\n\nResidence\n\n\nAddress\n\n220 Gina Cr\n\n\nCross Street\n\nLois Ct\n\n\nCity\n\nLake Country Acres\n\n\nLat/Long\n\n \n\n\nMap\n\n591 R\n\n\nDetails\n\nToned by LC - Brady PCFA\n\n 
\nTitle\n\nP2 general Medicine\n\n\nStation\n\n44\n\n\nPlace Name\n\n \n\n\nAddress\n\n6401 Granbury Hwy\n\n\nCross Street\n\n \n\n\nCity\n\n \n\n\nLat/Long\n\n \n\n\nMap\n\n27 M\n\n\nDetails\n\nToned by LC no details available - Brady PCFA\n\n 
\nTitle\n\nTest Page Only\n\n\nStation\n\n44\n\n\nPlace Name\n\nFire Station\n\n\nAddress\n\n6300 Granbury Hwy\n\n\nCross Street\n\nFM 1708\n\n\nCity\n\nNA\n\n\nLat/Long\n\n \n\n\nMap\n\n27C\n\n\nDetails\n\nCongrats to the Cadets on becoming part of PCESD 6 Spring Creek FD from\nPCFA - Brady\n\n 
 \n\n\nTitle\n\nTest Page\n\n\nStation\n\n44\n\n\nPlace Name\n\nFire Station\n\n\nAddress\n\n6300 Granbury Hwy\n\n\nCross Street\n\nFM 1708\n\n\nCity\n\nNA\n\n\nLat/Long\n\n \n\n\nMap\n\n27 M\n\n\nDetails\n\nTest Page for ESD 6 Active 911 - Brady PCFA\n\n \n\n \n\n \n\n \n\n 
 \n\n\nTitle\n\nTest Page 3 -FINAL TEST\n\n\nStation\n\n44\n\n\nPlace Name\n\nFire Station\n\n\nAddress\n\n6300 Granbury Hwy\n\n\nCross Street\n\nFM 1708\n\n\nCity\n\nNA\n\n\nLat/Long\n\n \n\n\nMap\n\n27 M\n\n\nDetails\n\nTest Page 3 FINAL TEST for ESD 6 Active 911 - Brady PCFA\n\n \n\n \n\n \n\n \n\n 
 \n\n\nTitle\n\nTest Page 2\n\n\nStation\n\n44\n\n\nPlace Name\n\nFire Station\n\n\nAddress\n\n6300 Granbury Hwy\n\n\nCross Street\n\nFM 1708\n\n\nCity\n\nNA\n\n\nLat/Long\n\n \n\n\nMap\n\n27 M\n\n\nDetails\n\nTest Page 2 for ESD 6 Active 911 - Brady PCFA\n\n \n\n \n\n \n\n \n\n 

*/
public class TXParkerCountyParserTest extends BaseParserTest {
  
  public TXParkerCountyParserTest() {
    setParser(new TXParkerCountyParser(), "PARKER COUNTY", "TX");
  }
  
  @Test
  public void testParkerCountyESD1() {

    doTest("T1",
        "\n\n\nTitle\n\n" +
        "46 SEIZURES\n\n\n" +
        "Station\n\n" +
        "46\n\n\n" +
        "Place Name\n\n" +
        " \n\n\n" +
        "Address\n\n" +
        "1170 FM 1885\n\n\n" +
        "Cross Street\n\n" +
        " \n\n\n" +
        "City\n\n" +
        "PEASTER\n\n\n" +
        "Lat/Long\n\n" +
        " \n\n\n" +
        "Map\n\n" +
        "21J\n\n\n" +
        "Details\n\n" +
        "STA 46 WITH MEDIC 13 SEIZURES. ADDRESS ON MAILBOX. LARGE TOWER IN\n" +
        "BACKYARD. LOG CABIN HOUSE\n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " ",

        "CALL:46 SEIZURES",
        "SRC:46",
        "ADDR:1170 FM 1885",
        "CITY:PEASTER",
        "MAP:21J",
        "INFO:STA 46 WITH MEDIC 13 SEIZURES. ADDRESS ON MAILBOX. LARGE TOWER IN / BACKYARD. LOG CABIN HOUSE");

    doTest("T2",
        " \n\n\n" +
        "Title\n\n" +
        "GRASS FIRE NEAR STRUCTURES, STA 46\n\n\n" +
        "Station\n\n" +
        "46\n\n\n" +
        "Place Name\n\n" +
        " \n\n\n" +
        "Address\n\n" +
        "2340 RUSSELL BEND RD\n\n\n" +
        "Cross Street\n\n" +
        " \n\n\n" +
        "City\n\n" +
        "SPRINGTOWN\n\n\n" +
        "Lat/Long\n\n" +
        " \n\n\n" +
        "Map\n\n" +
        " \n\n\n" +
        "Details\n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " ",

        "CALL:GRASS FIRE NEAR STRUCTURES, STA 46",
        "SRC:46",
        "ADDR:2340 RUSSELL BEND RD",
        "CITY:SPRINGTOWN");  // Google says this is in POOLVILLE

    doTest("T3",
        " \n\n\n" +
        "Title\n\n" +
        "EMS CALL\n\n\n" +
        "Station\n\n" +
        "51\n\n\n" +
        "Place Name\n\n" +
        " \n\n\n" +
        "Address\n\n" +
        "4501 E HWY 199 LOT 77\n\n\n" +
        "Cross Street\n\n" +
        " \n\n\n" +
        "City\n\n" +
        "LA JUNTA\n\n\n" +
        "Lat/Long\n\n" +
        " \n\n\n" +
        "Map\n\n" +
        " \n\n\n" +
        "Details\n\n" +
        "GENERAL MEDICINE CALL LIFECARE ENROUTE\n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " ",

        "CALL:EMS CALL",
        "SRC:51",
        "ADDR:4501 E HWY 199",
        "APT:77",
        "CITY:LA JUNTA",
        "INFO:GENERAL MEDICINE CALL LIFECARE ENROUTE");

    doTest("T4",
        " \n\n\n" +
        "Title\n\n" +
        "ABDOMINAL PAIN\n\n\n" +
        "Station\n\n" +
        "51\n\n\n" +
        "Place Name\n\n" +
        " \n\n\n" +
        "Address\n\n" +
        "680 NEW HOPE RD\n\n\n" +
        "Cross Street\n\n" +
        " \n\n\n" +
        "City\n\n" +
        "LA JUNTA\n\n\n" +
        "Lat/Long\n\n" +
        " \n\n\n" +
        "Map\n\n" +
        "405J\n\n\n" +
        "Details\n\n" +
        "ABD PAIN LIFECARE ENROUTE\n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " ",

        "CALL:ABDOMINAL PAIN",
        "SRC:51",
        "ADDR:680 NEW HOPE RD",  // Google says this is in BOYD
        "CITY:LA JUNTA",
        "MAP:405J",
        "INFO:ABD PAIN LIFECARE ENROUTE");

    doTest("T5",
        " \n\n\n" +
        "Title\n\n" +
        "POSS STRUCTURE FIRE\n\n\n" +
        "Station\n\n" +
        "51 48\n\n\n" +
        "Place Name\n\n" +
        " \n\n\n" +
        "Address\n\n" +
        "200BLK SANDY OAKS RD\n\n\n" +
        "Cross Street\n\n" +
        " \n\n\n" +
        "City\n\n" +
        " \n\n\n" +
        "Lat/Long\n\n" +
        " \n\n\n" +
        "Map\n\n" +
        "428N\n\n\n" +
        "Details\n\n" +
        "POSS STRUCTURE FIRE SMOKE FROM A RESIDENCE\n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " ",

        "CALL:POSS STRUCTURE FIRE",
        "SRC:51 48",
        "ADDR:200BLK SANDY OAKS RD",
        "MADDR:200 SANDY OAKS RD",
        "MAP:428N",
        "INFO:POSS STRUCTURE FIRE SMOKE FROM A RESIDENCE");

    doTest("T6",
        " \n\n\n" +
        "Title\n\n" +
        "VEHICLE UNLOCK\n\n\n" +
        "Station\n\n" +
        "48\n\n\n" +
        "Place Name\n\n" +
        "CHADWELL AND SON GAS CO\n\n\n" +
        "Address\n\n" +
        "608 HWY 199\n\n\n" +
        "Cross Street\n\n" +
        "HILLTOP DR\n\n\n" +
        "City\n\n" +
        "SPRINGTOWN\n\n\n" +
        "Lat/Long\n\n" +
        " \n\n\n" +
        "Map\n\n" +
        "402Y\n\n\n" +
        "Details\n\n" +
        "BLK CHEVY TRK, NOT RUNNING- DOG INSIDE\n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " ",

        "CALL:VEHICLE UNLOCK",
        "SRC:48",
        "PLACE:CHADWELL AND SON GAS CO",
        "ADDR:608 HWY 199",
        "X:HILLTOP DR",
        "CITY:SPRINGTOWN",
        "MAP:402Y",
        "INFO:BLK CHEVY TRK, NOT RUNNING- DOG INSIDE");

    doTest("T7",
        " \n\n\n" +
        "Title\n\n" +
        "EMS GEN MED\n\n\n" +
        "Station\n\n" +
        "51\n\n\n" +
        "Place Name\n\n" +
        " \n\n\n" +
        "Address\n\n" +
        "5724 MIDWAY RD\n\n\n" +
        "Cross Street\n\n" +
        " \n\n\n" +
        "City\n\n" +
        "SPRINGTOWN\n\n\n" +
        "Lat/Long\n\n" +
        " \n\n\n" +
        "Map\n\n" +
        "427T\n\n\n" +
        "Details\n\n" +
        "MEDIC 21\n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " ",

        "CALL:EMS GEN MED",
        "SRC:51",
        "ADDR:5724 MIDWAY RD",
        "CITY:SPRINGTOWN",
        "MAP:427T",
        "INFO:MEDIC 21");

    doTest("T8",
        " \n\n\n" +
        "Title\n\n" +
        "FALL\n\n\n" +
        "Station\n\n" +
        "54\n\n\n" +
        "Place Name\n\n" +
        " \n\n\n" +
        "Address\n\n" +
        "200 REESE LN\n\n\n" +
        "Cross Street\n\n" +
        " \n\n\n" +
        "City\n\n" +
        "SILVERCREEK\n\n\n" +
        "Lat/Long\n\n" +
        " \n\n\n" +
        "Map\n\n" +
        "477L\n\n\n" +
        "Details\n\n" +
        "FALL LIFECARE ENROUTE\n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " ",

        "CALL:FALL",
        "SRC:54",
        "ADDR:200 REESE LN",
        "PLACE:SILVERCREEK",
        "CITY:AZLE",
        "MAP:477L",
        "INFO:FALL LIFECARE ENROUTE");

    doTest("T9",
        " \n\n\n" +
        "Title\n\n" +
        "FALL\n\n\n" +
        "Station\n\n" +
        "51\n\n\n" +
        "Place Name\n\n" +
        " \n\n\n" +
        "Address\n\n" +
        "118 GILLEY LN\n\n\n" +
        "Cross Street\n\n" +
        " \n\n\n" +
        "City\n\n" +
        "LA JUNTA\n\n\n" +
        "Lat/Long\n\n" +
        " \n\n\n" +
        "Map\n\n" +
        "452D\n\n\n" +
        "Details\n\n" +
        "FALL LIFECARE ENROUTE\n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " ",

        "CALL:FALL",
        "SRC:51",
        "ADDR:118 GILLEY LN",
        "CITY:LA JUNTA",
        "MAP:452D",
        "INFO:FALL LIFECARE ENROUTE");

    doTest("T10",
        " \n\n\n" +
        "Title\n\n" +
        "CANCEL MVA\n\n\n" +
        "Station\n\n" +
        "48\n\n\n" +
        "Place Name\n\n" +
        " \n\n\n" +
        "Address\n\n" +
        "1815 199 E\n\n\n" +
        "Cross Street\n\n" +
        "NA\n\n\n" +
        "City\n\n" +
        "NA\n\n\n" +
        "Lat/Long\n\n" +
        " \n\n\n" +
        "Map\n\n" +
        "NA\n\n\n" +
        "Details\n\n" +
        "All 48 companies can cancel MVA, Will be Reno FD district- BRADY PCFA\n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " ",

        "CALL:CANCEL MVA",
        "SRC:48",
        "ADDR:1815 199 E",
        "INFO:All 48 companies can cancel MVA, Will be Reno FD district- BRADY PCFA");

    doTest("T11",
        " \n\n\n" +
        "Title\n\n" +
        "MVA\n\n\n" +
        "Station\n\n" +
        "48\n\n\n" +
        "Place Name\n\n" +
        " \n\n\n" +
        "Address\n\n" +
        "1815 E HWY 199\n\n\n" +
        "Cross Street\n\n" +
        "NA\n\n\n" +
        "City\n\n" +
        "NA\n\n\n" +
        "Lat/Long\n\n" +
        " \n\n\n" +
        "Map\n\n" +
        "NA\n\n\n" +
        "Details\n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " ",

        "CALL:MVA",
        "SRC:48",
        "ADDR:1815 E HWY 199");

    doTest("T12",
        " \n\n\n" +
        "Title\n\n" +
        "Grass Fire\n\n\n" +
        "Station\n\n" +
        "48\n\n\n" +
        "Place Name\n\n" +
        " \n\n\n" +
        "Address\n\n" +
        "McVoid Rd\n\n\n" +
        "Cross Street\n\n" +
        "Knob Rd\n\n\n" +
        "City\n\n" +
        "Springtown\n\n\n" +
        "Lat/Long\n\n" +
        " \n\n\n" +
        "Map\n\n" +
        "404 E\n\n\n" +
        "Details\n\n" +
        "Nearing Structure\n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " ",

        "CALL:Grass Fire",
        "SRC:48",
        "ADDR:McVoid Rd",
        "MADDR:McVoid Rd & Knob Rd",
        "X:Knob Rd",
        "CITY:Springtown",
        "MAP:404 E",
        "INFO:Nearing Structure");

    doTest("T13",
        " \n\n\n" +
        "Title\n\n" +
        "ODOR INVESTIGATION\n\n\n" +
        "Station\n\n" +
        "51\n\n\n" +
        "Place Name\n\n" +
        " \n\n\n" +
        "Address\n\n" +
        "301 PINE BLUFF LN\n\n\n" +
        "Cross Street\n\n" +
        " \n\n\n" +
        "City\n\n" +
        " \n\n\n" +
        "Lat/Long\n\n" +
        " \n\n\n" +
        "Map\n\n" +
        " \n\n\n" +
        "Details\n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " ",

        "CALL:ODOR INVESTIGATION",
        "SRC:51",
        "ADDR:301 PINE BLUFF LN");

    doTest("T14",
        " \n\n\n" +
        "Title\n\n" +
        " \n\n\n" +
        "Station\n\n" +
        "STA 51\n\n\n" +
        "Place Name\n\n" +
        " \n\n\n" +
        "Address\n\n" +
        "ALICE SPRINGS/KURANDA\n\n\n" +
        "Cross Street\n\n" +
        " \n\n\n" +
        "City\n\n" +
        "LAJUNTA\n\n\n" +
        "Lat/Long\n\n" +
        " \n\n\n" +
        "Map\n\n" +
        "428T\n\n\n" +
        "Details\n\n" +
        "GRASS FIRE ALONG SIDE THE ROAD\n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " ",

        "SRC:STA 51",
        "ADDR:ALICE SPRINGS & KURANDA",
        "CITY:LAJUNTA", // Google says this is in PARKER COUNTY
        "MAP:428T",
        "INFO:GRASS FIRE ALONG SIDE THE ROAD");

    doTest("T15",
        " \n\n\n" +
        "Title\n\n" +
        "MVA\n\n\n" +
        "Station\n\n" +
        "48\n\n\n" +
        "Place Name\n\n" +
        " \n\n\n" +
        "Address\n\n" +
        "SH 199 & OLD AGNES\n\n\n" +
        "Cross Street\n\n" +
        " \n\n\n" +
        "City\n\n" +
        " \n\n\n" +
        "Lat/Long\n\n" +
        " \n\n\n" +
        "Map\n\n" +
        "21D\n\n\n" +
        "Details\n\n" +
        "MVA FROM PCSO NO FURTHER DETAILS\n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " ",

        "CALL:MVA",
        "SRC:48",
        "ADDR:SH 199 & OLD AGNES",
        "MADDR:TX 199 & OLD AGNES",
        "MAP:21D",
        "INFO:MVA FROM PCSO NO FURTHER DETAILS");

    doTest("T16",
        " \n\n\n" +
        "Title\n\n" +
        "GRASS FIRE\n\n\n" +
        "Station\n\n" +
        "48\n\n\n" +
        "Place Name\n\n" +
        " \n\n\n" +
        "Address\n\n" +
        "511 BLUE SKY CT\n\n\n" +
        "Cross Street\n\n" +
        " \n\n\n" +
        "City\n\n" +
        "SPRINGTOWN\n\n\n" +
        "Lat/Long\n\n" +
        " \n\n\n" +
        "Map\n\n" +
        "22J\n\n\n" +
        "Details\n\n" +
        "MULTIPLE CALLS GRASS FIRE NEXT DOOR\n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " ",

        "CALL:GRASS FIRE",
        "SRC:48",
        "ADDR:511 BLUE SKY CT",
        "CITY:SPRINGTOWN",
        "MAP:22J",
        "INFO:MULTIPLE CALLS GRASS FIRE NEXT DOOR");

    doTest("T17",
        " \n\n\n" +
        "Title\n\n" +
        "EMS\n\n\n" +
        "Station\n\n" +
        "51\n\n\n" +
        "Place Name\n\n" +
        " \n\n\n" +
        "Address\n\n" +
        "117 OAK MEADOW DR\n\n\n" +
        "Cross Street\n\n" +
        " \n\n\n" +
        "City\n\n" +
        " \n\n\n" +
        "Lat/Long\n\n" +
        " \n\n\n" +
        "Map\n\n" +
        " \n\n\n" +
        "Details\n\n" +
        "PR. 1 POSS. MI\n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " ",

        "CALL:EMS",
        "SRC:51",
        "ADDR:117 OAK MEADOW DR",
        "INFO:PR. 1 POSS. MI");

    doTest("T18",
        " \n\n\n" +
        "Title\n\n" +
        "MVC\n\n\n" +
        "Station\n\n" +
        "48\n\n\n" +
        "Place Name\n\n" +
        " \n\n\n" +
        "Address\n\n" +
        "2600 W 199\n\n\n" +
        "Cross Street\n\n" +
        " \n\n\n" +
        "City\n\n" +
        " \n\n\n" +
        "Lat/Long\n\n" +
        " \n\n\n" +
        "Map\n\n" +
        " \n\n\n" +
        "Details\n\n" +
        "6 VEHICLES\n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " ",

        "CALL:MVC",
        "SRC:48",
        "ADDR:2600 W 199",
        "INFO:6 VEHICLES");

    doTest("T19",
        " \n\n\n" +
        "Title\n\n" +
        "UNAUTHORIZED BURN\n\n\n" +
        "Station\n\n" +
        "54\n\n\n" +
        "Place Name\n\n" +
        " \n\n\n" +
        "Address\n\n" +
        "114 BAUGHMAN HILL RD\n\n\n" +
        "Cross Street\n\n" +
        "FLAT ROCK RD\n\n\n" +
        "City\n\n" +
        " \n\n\n" +
        "Lat/Long\n\n" +
        " \n\n\n" +
        "Map\n\n" +
        "453Q\n\n\n" +
        "Details\n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " ",

        "CALL:UNAUTHORIZED BURN",
        "SRC:54",
        "ADDR:114 BAUGHMAN HILL RD",
        "X:FLAT ROCK RD",
        "MAP:453Q");

    doTest("T20",
        " \n\n\n" +
        "Title\n\n" +
        "SMOKE INVESTIGATION\n\n\n" +
        "Station\n\n" +
        "51\n\n\n" +
        "Place Name\n\n" +
        " \n\n\n" +
        "Address\n\n" +
        "VEAL STATION & TUCKER\n\n\n" +
        "Cross Street\n\n" +
        " \n\n\n" +
        "City\n\n" +
        " \n\n\n" +
        "Lat/Long\n\n" +
        " \n\n\n" +
        "Map\n\n" +
        "451Q\n\n\n" +
        "Details\n\n" +
        "CALLER REPORTS LARGE AMOUNT OF SMOKE NW OF THAT LOCATION\n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " ",

        "CALL:SMOKE INVESTIGATION",
        "SRC:51",
        "ADDR:VEAL STATION & TUCKER",
        "MAP:451Q",
        "INFO:CALLER REPORTS LARGE AMOUNT OF SMOKE NW OF THAT LOCATION");

    doTest("T21",
        " \n\n\n" +
        "Title\n\n" +
        "EMS\n\n\n" +
        "Station\n\n" +
        "51\n\n\n" +
        "Place Name\n\n" +
        " \n\n\n" +
        "Address\n\n" +
        "801 ROSS \n\n\n" +
        "Cross Street\n\n" +
        " \n\n\n" +
        "City\n\n" +
        " \n\n\n" +
        "Lat/Long\n\n" +
        " \n\n\n" +
        "Map\n\n" +
        " \n\n\n" +
        "Details\n\n" +
        "FALL \n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " ",

        "CALL:EMS",
        "SRC:51",
        "ADDR:801 ROSS",
        "INFO:FALL");

    doTest("T22",
        "(MUTIAL AID WITH CENTRAL FRIENDSHIP RD)  \n\n\n" +
        "Title\n\n" +
        " \n\n\n" +
        "Station\n\n" +
        "SILVER CREEK\n\n\n" +
        "Place Name\n\n" +
        " \n\n\n" +
        "Address\n\n" +
        "FRIENDSHIP RD \n\n\n" +
        "Cross Street\n\n" +
        "1 MILE EAST FM 51 N\n\n\n" +
        "City\n\n" +
        "WEATHERFORD\n\n\n" +
        "Lat/Long\n\n" +
        " \n\n\n" +
        "Map\n\n" +
        "472D\n\n\n" +
        "Details\n\n" +
        "MUTIAL AID WITH CENTRAL POSS STRUCTURE FIRE\n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " ",

        "SRC:SILVER CREEK",
        "ADDR:FRIENDSHIP RD",
        "MADDR:FRIENDSHIP RD & 1 MILE EAST FM 51 N",
        "X:1 MILE EAST FM 51 N",
        "CITY:WEATHERFORD",
        "MAP:472D",
        "INFO:MUTIAL AID WITH CENTRAL POSS STRUCTURE FIRE");

    doTest("T23",
        "(2nd tone for structure fire)                                 \n\n\n" +
        "Title\n\n" +
        "Structure fire mutual aide with Tarrant county\n\n\n" +
        "Station\n\n" +
        "LaJunta \n\n\n" +
        "Place Name\n\n" +
        "Residential\n\n\n" +
        "Address\n\n" +
        "6113 Blue Leaf Ct.\n\n\n" +
        "Cross Street\n\n" +
        "Tenderfoot Tr\n\n\n" +
        "City\n\n" +
        " \n\n\n" +
        "Lat/Long\n\n" +
        " \n\n\n" +
        "Map\n\n" +
        "454Z\n\n\n" +
        "Details\n\n" +
        "Tarrant county is needing a tanker for 1st alarm on a residential\n" +
        "structure fire.\n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " ",

        "CALL:Structure fire mutual aide with Tarrant county",
        "SRC:LaJunta",
        "PLACE:Residential",
        "ADDR:6113 Blue Leaf Ct",
        "X:Tenderfoot Tr",
        "MAP:454Z",
        "INFO:Tarrant county is needing a tanker for 1st alarm on a residential / structure fire.");

    doTest("T24",
        "(6113 Blue Leaf Ct structure fire mutual aide Tarrant co)  \n\n\n" +
        "Title\n\n" +
        "Mutual aide with Tarrant Co structure fire\n\n\n" +
        "Station\n\n" +
        "LaJunta\n\n\n" +
        "Place Name\n\n" +
        "Residential\n\n\n" +
        "Address\n\n" +
        "6113 Blue Leaf Ct\n\n\n" +
        "Cross Street\n\n" +
        "Tenderfoot Tr\n\n\n" +
        "City\n\n" +
        " \n\n\n" +
        "Lat/Long\n\n" +
        " \n\n\n" +
        "Map\n\n" +
        "454Z\n\n\n" +
        "Details\n\n" +
        "Tanker requested on structure fire mutual aide 1st alarm with Tarrant\n" +
        "Co.\n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " ",

        "CALL:Mutual aide with Tarrant Co structure fire",
        "SRC:LaJunta",
        "PLACE:Residential",
        "ADDR:6113 Blue Leaf Ct",
        "X:Tenderfoot Tr",
        "MAP:454Z",
        "INFO:Tanker requested on structure fire mutual aide 1st alarm with Tarrant / Co.");

    doTest("T25",
        " \n\n\n" +
        "Title\n\n" +
        "EMS\n\n\n" +
        "Station\n\n" +
        "48\n\n\n" +
        "Place Name\n\n" +
        " \n\n\n" +
        "Address\n\n" +
        "Peel Rd no numerics avalible\n\n\n" +
        "Cross Street\n\n" +
        "Old Cottondale Rd\n\n\n" +
        "City\n\n" +
        "NA\n\n\n" +
        "Lat/Long\n\n" +
        " \n\n\n" +
        "Map\n\n" +
        "402 F\n\n\n" +
        "Details\n\n" +
        "Reported Hit and run Toned by LC - Brady PCFA\n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " ",

        "CALL:EMS",
        "SRC:48",
        "ADDR:Peel Rd no numerics avalible",
        "MADDR:Peel Rd & numerics avalible",
        "X:Old Cottondale Rd",  // Not mapping
        "MAP:402 F",
        "INFO:Reported Hit and run Toned by LC - Brady PCFA");

    doTest("T26",
        " \n\n\n" +
        "Title\n\n" +
        "Difficulty Breathing\n\n\n" +
        "Station\n\n" +
        "48\n\n\n" +
        "Place Name\n\n" +
        "Residence\n\n\n" +
        "Address\n\n" +
        "313 W. 3rd Terrace\n\n\n" +
        "Cross Street\n\n" +
        "N. Birch St.\n\n\n" +
        "City\n\n" +
        "Springtown\n\n\n" +
        "Lat/Long\n\n" +
        " \n\n\n" +
        "Map\n\n" +
        "402 T\n\n\n" +
        "Details\n\n" +
        "Toned by LC, Caller requesting silent approach - Brady PCFA\n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " ",

        "CALL:Difficulty Breathing",
        "SRC:48",
        "PLACE:Residence",
        "ADDR:313 W 3rd Terrace",
        "X:N. Birch St.",
        "CITY:Springtown",
        "MAP:402 T",
        "INFO:Toned by LC, Caller requesting silent approach - Brady PCFA");

    doTest("T27",
        " \n\n\n" +
        "Title\n\n" +
        "Assist Officers/Missing Children\n\n\n" +
        "Station\n\n" +
        "48\n\n\n" +
        "Place Name\n\n" +
        "Residence\n\n\n" +
        "Address\n\n" +
        "206 Walnut Bend\n\n\n" +
        "Cross Street\n\n" +
        "Ash St. N\n\n\n" +
        "City\n\n" +
        "Springtown\n\n\n" +
        "Lat/Long\n\n" +
        " \n\n\n" +
        "Map\n\n" +
        "402 T\n\n\n" +
        "Details\n\n" +
        "Missing Children, last seen playing with walkie talkie, 7yof wearing\n" +
        "greenish/gray shirt with stars on it, No description of 12 yof. Respond\n" +
        "on TAC 1 - Brady PCFA\n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " ",

        "CALL:Assist Officers/Missing Children",
        "SRC:48",
        "PLACE:Residence",
        "ADDR:206 Walnut Bend",
        "X:Ash St. N",
        "CITY:Springtown",
        "MAP:402 T",
        "INFO:Missing Children, last seen playing with walkie talkie, 7yof wearing / greenish/gray shirt with stars on it, No description of 12 yof. Respond / on TAC 1 - Brady PCFA");

    doTest("T28",
        " \n\n\n" +
        "Title\n\n" +
        "LIFT ASSIST\n\n\n" +
        "Station\n\n" +
        "51\n\n\n" +
        "Place Name\n\n" +
        " \n\n\n" +
        "Address\n\n" +
        "317 CEDARWOOD ST\n\n\n" +
        "Cross Street\n\n" +
        " \n\n\n" +
        "City\n\n" +
        " \n\n\n" +
        "Lat/Long\n\n" +
        " \n\n\n" +
        "Map\n\n" +
        "429U\n\n\n" +
        "Details\n\n" +
        "MALE ON THE GROUND NEEDING LIFT ASSIST NO INJURIES\n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " ",

        "CALL:LIFT ASSIST",
        "SRC:51",
        "ADDR:317 CEDARWOOD ST",
        "MAP:429U",
        "INFO:MALE ON THE GROUND NEEDING LIFT ASSIST NO INJURIES");

    doTest("T29",
        " \n\n\n" +
        "Title\n\n" +
        "UNK TYPE FIRE\n\n\n" +
        "Station\n\n" +
        "48\n\n\n" +
        "Place Name\n\n" +
        " \n\n\n" +
        "Address\n\n" +
        "1700BLK HWY 199\n\n\n" +
        "Cross Street\n\n" +
        " \n\n\n" +
        "City\n\n" +
        "SPRINGTOWN\n\n\n" +
        "Lat/Long\n\n" +
        " \n\n\n" +
        "Map\n\n" +
        "22B\n\n\n" +
        "Details\n\n" +
        "UNK TYPE FIRE IN THE AREA POSSIBLE CONTROLLED BURN\n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " ",

        "CALL:UNK TYPE FIRE",
        "SRC:48",
        "ADDR:1700BLK HWY 199",
        "MADDR:1700 HWY 199",
        "CITY:SPRINGTOWN",
        "MAP:22B",
        "INFO:UNK TYPE FIRE IN THE AREA POSSIBLE CONTROLLED BURN");

    doTest("T30",
        " \n\n\n" +
        "Title\n\n" +
        "Lock Out\n\n\n" +
        "Station\n\n" +
        "48\n\n\n" +
        "Place Name\n\n" +
        "Park\n\n\n" +
        "Address\n\n" +
        "Park behind Brookshires\n\n\n" +
        "Cross Street\n\n" +
        " \n\n\n" +
        "City\n\n" +
        "Springtown\n\n\n" +
        "Lat/Long\n\n" +
        " \n\n\n" +
        "Map\n\n" +
        "22C\n\n\n" +
        "Details\n\n" +
        "18 Month old inside, not running, Maroon Tahoe - Brady PCFA\n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " ",

        "CALL:Lock Out",
        "SRC:48",
        "PLACE:Park",
        "ADDR:Park behind Brookshires",
        "CITY:Springtown",
        "MAP:22C",
        "INFO:18 Month old inside, not running, Maroon Tahoe - Brady PCFA");

  }
  
  @Test
  public void testParkerCountyESD6() {

    doTest("T1",
        "\nTitle\n\n" +
        "UNKNOWN TYPE FIRE\n\n\n" +
        "Station\n\n" +
        "44\n\n\n" +
        "Place Name\n\n" +
        "RESIDENTIAL\n\n\n" +
        "Address\n\n" +
        "336 SANTA FE TRAIL\n\n\n" +
        "Cross Street\n\n" +
        "WESTERN LAKE DR\n\n\n" +
        "City\n\n" +
        "NA\n\n\n" +
        "Lat/Long\n\n" +
        "NA\n\n\n" +
        "Map\n\n" +
        "566R\n\n\n" +
        "Details\n\n" +
        "REPORTED TO BE BEHIND THE RESIDENCE ACROSS FROM LISTED LOCATION. RESPOND\n" +
        "ON TAC1-BRADY PCFA\n\n" +
        " ",

        "CALL:UNKNOWN TYPE FIRE",
        "SRC:44",
        "PLACE:RESIDENTIAL",
        "ADDR:336 SANTA FE TRAIL",
        "X:WESTERN LAKE DR",
        "MAP:566R",
        "INFO:REPORTED TO BE BEHIND THE RESIDENCE ACROSS FROM LISTED LOCATION. RESPOND / ON TAC1-BRADY PCFA");

    doTest("T2",
        "\nTitle\n\n" +
        "EMS\n\n\n" +
        "Station\n\n" +
        "44\n\n\n" +
        "Place Name\n\n" +
        " \n\n\n" +
        "Address\n\n" +
        "4832 Horseshoe Drive\n\n\n" +
        "Cross Street\n\n" +
        "Western Lake Drive\n\n\n" +
        "City\n\n" +
        "N/A\n\n\n" +
        "Lat/Long\n\n" +
        " \n\n\n" +
        "Map\n\n" +
        "567 N\n\n\n" +
        "Details\n\n" +
        "P1 Chest Pain. Toned by Lifecare.\n\n" +
        " ",

        "CALL:EMS",
        "SRC:44",
        "ADDR:4832 Horseshoe Drive",
        "X:Western Lake Drive",
        "MAP:567 N",
        "INFO:P1 Chest Pain. Toned by Lifecare.");

    doTest("T3",
        "\nTitle\n\n" +
        "Pri. 2 sick person\n\n\n" +
        "Station\n\n" +
        "Spring Creek\n\n\n" +
        "Place Name\n\n" +
        "Residence\n\n\n" +
        "Address\n\n" +
        "424 lipan trail \n\n\n" +
        "Cross Street\n\n" +
        "N/A\n\n\n" +
        "City\n\n" +
        "N/A\n\n\n" +
        "Lat/Long\n\n" +
        "N/A\n\n\n" +
        "Map\n\n" +
        "589J\n\n\n" +
        "Details\n\n" +
        "Pri. 2 sick person with medic 13.\n\n" +
        "-Brady PCFA\n\n" +
        " ",

        "CALL:Pri. 2 sick person",
        "SRC:Spring Creek",
        "PLACE:Residence",
        "ADDR:424 lipan trail",
        "MAP:589J",
        "INFO:Pri. 2 sick person with medic 13. / -Brady PCFA");

    doTest("T4",
        "\nTitle\n\n" +
        "P1 Seizures \n\n\n" +
        "Station\n\n" +
        "44\n\n\n" +
        "Place Name\n\n" +
        "Residence\n\n\n" +
        "Address\n\n" +
        "220 Gina Cr\n\n\n" +
        "Cross Street\n\n" +
        "Lois Ct\n\n\n" +
        "City\n\n" +
        "Lake Country Acres\n\n\n" +
        "Lat/Long\n\n" +
        " \n\n\n" +
        "Map\n\n" +
        "591 R\n\n\n" +
        "Details\n\n" +
        "Toned by LC - Brady PCFA\n\n" +
        " ",

        "CALL:P1 Seizures",
        "SRC:44",
        "PLACE:Lake Country Acres - Residence",
        "ADDR:220 Gina Cr",
        "MADDR:220 Gina Cir",
        "X:Lois Ct",
        "MAP:591 R",
        "INFO:Toned by LC - Brady PCFA");

    doTest("T5",
        "\nTitle\n\n" +
        "P2 general Medicine\n\n\n" +
        "Station\n\n" +
        "44\n\n\n" +
        "Place Name\n\n" +
        " \n\n\n" +
        "Address\n\n" +
        "6401 Granbury Hwy\n\n\n" +
        "Cross Street\n\n" +
        " \n\n\n" +
        "City\n\n" +
        " \n\n\n" +
        "Lat/Long\n\n" +
        " \n\n\n" +
        "Map\n\n" +
        "27 M\n\n\n" +
        "Details\n\n" +
        "Toned by LC no details available - Brady PCFA\n\n" +
        " ",

        "CALL:P2 general Medicine",
        "SRC:44",
        "ADDR:6401 Granbury Hwy",
        "MAP:27 M",
        "INFO:Toned by LC no details available - Brady PCFA");

    doTest("T6",
        "\nTitle\n\n" +
        "Test Page Only\n\n\n" +
        "Station\n\n" +
        "44\n\n\n" +
        "Place Name\n\n" +
        "Fire Station\n\n\n" +
        "Address\n\n" +
        "6300 Granbury Hwy\n\n\n" +
        "Cross Street\n\n" +
        "FM 1708\n\n\n" +
        "City\n\n" +
        "NA\n\n\n" +
        "Lat/Long\n\n" +
        " \n\n\n" +
        "Map\n\n" +
        "27C\n\n\n" +
        "Details\n\n" +
        "Congrats to the Cadets on becoming part of PCESD 6 Spring Creek FD from\n" +
        "PCFA - Brady\n\n" +
        " ",

        "CALL:Test Page Only",
        "SRC:44",
        "PLACE:Fire Station",
        "ADDR:6300 Granbury Hwy",
        "X:FM 1708",
        "MAP:27C",
        "INFO:Congrats to the Cadets on becoming part of PCESD 6 Spring Creek FD from / PCFA - Brady");

    doTest("T7",
        " \n\n\n" +
        "Title\n\n" +
        "Test Page\n\n\n" +
        "Station\n\n" +
        "44\n\n\n" +
        "Place Name\n\n" +
        "Fire Station\n\n\n" +
        "Address\n\n" +
        "6300 Granbury Hwy\n\n\n" +
        "Cross Street\n\n" +
        "FM 1708\n\n\n" +
        "City\n\n" +
        "NA\n\n\n" +
        "Lat/Long\n\n" +
        " \n\n\n" +
        "Map\n\n" +
        "27 M\n\n\n" +
        "Details\n\n" +
        "Test Page for ESD 6 Active 911 - Brady PCFA\n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " ",

        "CALL:Test Page",
        "SRC:44",
        "PLACE:Fire Station",
        "ADDR:6300 Granbury Hwy",
        "X:FM 1708",
        "MAP:27 M",
        "INFO:Test Page for ESD 6 Active 911 - Brady PCFA");

    doTest("T8",
        " \n\n\n" +
        "Title\n\n" +
        "Test Page 3 -FINAL TEST\n\n\n" +
        "Station\n\n" +
        "44\n\n\n" +
        "Place Name\n\n" +
        "Fire Station\n\n\n" +
        "Address\n\n" +
        "6300 Granbury Hwy\n\n\n" +
        "Cross Street\n\n" +
        "FM 1708\n\n\n" +
        "City\n\n" +
        "NA\n\n\n" +
        "Lat/Long\n\n" +
        " \n\n\n" +
        "Map\n\n" +
        "27 M\n\n\n" +
        "Details\n\n" +
        "Test Page 3 FINAL TEST for ESD 6 Active 911 - Brady PCFA\n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " ",

        "CALL:Test Page 3 -FINAL TEST",
        "SRC:44",
        "PLACE:Fire Station",
        "ADDR:6300 Granbury Hwy",
        "X:FM 1708",
        "MAP:27 M",
        "INFO:Test Page 3 FINAL TEST for ESD 6 Active 911 - Brady PCFA");

    doTest("T9",
        " \n\n\n" +
        "Title\n\n" +
        "Test Page 2\n\n\n" +
        "Station\n\n" +
        "44\n\n\n" +
        "Place Name\n\n" +
        "Fire Station\n\n\n" +
        "Address\n\n" +
        "6300 Granbury Hwy\n\n\n" +
        "Cross Street\n\n" +
        "FM 1708\n\n\n" +
        "City\n\n" +
        "NA\n\n\n" +
        "Lat/Long\n\n" +
        " \n\n\n" +
        "Map\n\n" +
        "27 M\n\n\n" +
        "Details\n\n" +
        "Test Page 2 for ESD 6 Active 911 - Brady PCFA\n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " \n\n" +
        " ",

        "CALL:Test Page 2",
        "SRC:44",
        "PLACE:Fire Station",
        "ADDR:6300 Granbury Hwy",
        "X:FM 1708",
        "MAP:27 M",
        "INFO:Test Page 2 for ESD 6 Active 911 - Brady PCFA");

  }
  
  public static void main(String[] args) {
    new TXParkerCountyParserTest().generateTests("T1");
  }
}
