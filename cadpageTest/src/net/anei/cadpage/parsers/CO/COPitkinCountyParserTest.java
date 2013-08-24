package net.anei.cadpage.parsers.CO;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Pitkin County, CO
Contact: Active911
Agency name: Aspen Pitkin County Communications Center
Location: Aspen, CO, United States
Sender: textpage@pitpage.org

SFD \nGENERAL ALARM\n32 ELK RIDGE LN,SMV\nSFD\nSFALL3\nfryers resd   hall #2 smoke detector  no guard   no call yet
PC  \nSAR\n29000 FRYING PAN RD,MER\nPC\n52\nMIDDLE FORK OF FRYING PAN RIVER FISHING, RP WENT BACK TO CHECK FOR FRIEND AND\nCAN'T FIND HIM. HE HAS BEEN MISSING FOR OVER AN HO
BFD \nSMOKE REPORT\nRUEDI CREEK RD,BAS\nBFD\nBFALL3\nsmoke report given to eagle deputy, was 10 mi south of mt riley, rp was at\nruedi, shannon at 512-718-8390
AFD \nAFOCO1\n13AF00975\nDS   - 15.19.18 06/30/13\nCMPLT- 15.24.16
AFD \nGENERAL ALARM\n406 E HOPKINS AVE; ISIS BLDG,ASP\nAFD\nAFOCO1\nvalid permit, fire from zone 209 which is 2nd floor elevator lobby and general\nfire zone 0\n\nWed Feb 20 1
BFD \nMUTUAL AID\n29000 FRYING PAN RD,MER\nBFD\nBFOCO1\nMIDDLE FORK OF FRYING PAN RIVER FISHING, RP WENT BACK TO CHECK FOR FRIEND AND\nCAN'T FIND HIM. HE HAS BEEN MISSING FO
AA  \nA1CODE\n13AA00707\nENRT - 13.41.28 06/30/13\nCMPLT- 14.02.43
BFD \nBFOCO1\n13BF00590\nENRT - 13.09.36 06/30/13\nFOS  - 13.11.23\nCMPLT- 13.53.57
AA  \nMEDICAL\n69 E AIRPORT RD,ASP\nAA\nA1CODE\nplane coming in, eta 10 min, 66 yom, nausea, fever, bloated stomach\n13:40:07 06/30/2013 - KIMMEL, LINDA F\nProQA Medical Reco
BFD \nINJURY ACCIDENT\nEL JEBEL RD & HWY 82,CAR\nBFD\nBFOCO1\n3 VEHICLES, NO INJURIES\n13:06:27 06/30/2013 - KEITH, AUDRA   \nONE OF THE  WB LANE BLOCKED\n13:06:56 06/30/2013 
SFD \nSFALL3\n13SF00314\nDS   - 09.34.26 06/30/13\nFOS  - 09.45.19\nCMPLT- 10.07.00
SFD \nODOR INVEST\n10 FOX LN,SMV\nSFD\nSFALL3\nSMELLS NATURAL GAS INSIDE HOUSE. 
SFD \nS2CODE\n13SA00392\nDS   - 21.20.45 06/29/13\nOS   - 21.27.58\nFOS  - 21.41.57\nLOCTN- 21.42.13\nCMPLT- 21.52.32
SFD \nMEDICAL\n30 ANDERSON LN; Stonebridge Condos; 642,SMV\nSFD\nS2CODE\nHIS MOM IS ON CHEMO 102.7 FEVER / NEEDS TO BE TRANSPORTED / GO TO BURLINGAME LN\nTO GET TO THIS BLDG
AA  \nINJURY ACCIDENT\n56000 HWY 82,ASP\nAA\nA1CODE\nmotorcycle accident  "people hurt"\n13:28:06 06/29/2013 - BULTMAN, GINN\nProQA Medical Case 242332 Aborted: EMD not neede
AFD \nGAS ALARM\n91 BUCHANAN DR,ASP\nAFD\nAFOCO3\nyeager resd  garage gas detector and general smoke detector  no call yet   yes\nsending a guard unk who
BFD \nODOR INVEST\n523 EMMA RD,BAS\nBFD\nBFOCO3\nbehind the post office thick smell of smoke   now doesnt smell as much
BFD \nFOLLOW UP\n3000 EMMA WEST RD,BAS\nBFD\nBFOCO1\ntractor and baler fire from last night  rp is wondering if it was really\naccidental  have fire officer call
AA  \nSTANDBY\n506 E MAIN ST; APD,ASP\nAA\nAAMBI1\nBACKCOUNTRY MARATHON
AA  \nA1CODE\n13AA00704\nENRT - 23.24.58 06/28/13\nFOS  - 23.35.51\nCMPLT- 00.41.47
AFD \nAFOCO2\n13AF00970\nDS   - 23.56.34 06/28/13\nCMPLT- 00.16.38
AFD \nSMOKE/HEAT ALRM\n103 E HYMAN AVE,ASP\nAFD\nAFOCO2\nHOUSE / RP IS IN BACK APARTMENT / ALARM WENT OFF / SHE WENT INTO DOWNSTAIRS APT \nAND FOUND SOMETHING LEFT ON THE ST
BFD \nBFALL3\n13BF00587\nDS   - 22.42.07 06/28/13\nCMPLT- 23.33.14
AA  \nUNKNOWN\n31350 HWY 82; Aspen Village Light,ASP\nAA\nA1CODE\nLANGUAGE BARRIER / CAN'T TELL WHATS GOING ON / DISCONNENCTED \n23:20:30 06/28/2013 - Rosselot, B.\nFIRST CAL
AFD \nAFOCO1\n13AF00968\nENRT - 22.54.21 06/28/13\nCMPLT- 22.58.45
AFD \nPULL STN ALARM\n4807 ASPEN MTN RD; SUNDECK,ASP\nPFD\nAFOCO1\nSHOWING FIRE AND FIRE MANUAL LEVEL PULL STATION / NO CALL TO SITE / WILL SEND\nGUARD / REF:54188
BFD \nWILDLAND FIRE\nHOOKS LN,BAS\nBFD\nBFALL3\nBETWEEN EMMA AND HOOKS SPUR ON HOOKS LN / WHAT LOOKS LIKE BONFIRE ON EDGE OF\nROAD / SPREADING / CAN SEE FLAMES 
SFD \nSFALL3\n13SF00313\nDS   - 21.29.34 06/28/13\nFOS  - 21.36.46\nCMPLT- 21.45.00
SFD \nSMOKE REPORT\n1022 WOOD RD,SMV\nSFD\nSFALL3\nRP SMELLING A VERY STRONG SMOKE SMELL AT THIS LOCATION / UNKNOWN WHERE IT IS\nCOMING FROM / CAN'T SEE ANY SMOKE OR FLAMES 
AA  \nA1CODE\n13AA00703\nDS   - 17.17.34 06/28/13\nCMPLT- 17.44.50
AA  \nMEDICAL\n315 DEAN ST; ST REGIS;outside,ASP\nAA\nA1CODE\nguest that tripped on stone in front of st regis. \n17:16:43 06/28/2013 - MADRIL,DANIELLE\nProQA Medical Recomme
AFD \nAFOCO1\n13AF00966\nENRT - 16.00.03 06/28/13\nCMPLT- 16.11.54
AFD \nAFOCO1\n13AF00966\nENRT - 16.00.03 06/28/13\nCMPLT- 16.11.54
AFD \nPULL STN ALARM\n4807 ASPEN MTN RD,ASP\nPFD\nAFOCO1\nsundeck restaurant    general fire plus main level pull ph/9704296970  havent\nyet called   no guard
AFD \nPAGE\n43 SAGE WAY; AFD - North Forty Fire Stat,ASP\nAFD\nAFALL1\nJPR rodeo training at the N40 at 8:00 on sat\nCall type f reopened by KIMMEL, LINDA F at 13:09:35 06/2
AFD \nAFOCO2\n13AF00962\nDS   - 08.47.04 06/28/13\nCMPLT- 08.59.46
AFD \nCO ALARM\n718 S MILL ST;unit 4,ASP\nAFD\nAFOCO2\ncarbon monoxide alarm unit 4//not called site//notifying responder\n08:46:02 06/28/2013 - MARTINEZ, RITA \npermit# 700 
BFD \nBFOCO1\n13BF00584\nDS   - 17.26.20 06/27/13\nCMPLT- 17.34.54
BFD \nFOLLOW UP\n20 SCHOOL ST; BFD; VALLEY VIEW HOSPITAL,BAS\nBFD\n424\nSOMONE FROM MEDIC 42 PLEASE CALL 
AFD \nAFOCO2\n13AF00960\nDS   - 17.08.24 06/27/13\nCMPLT- 17.10.22
AFD \nCITIZEN ASSIST\n59 MAGNIFICO RD,ASP\nAFD\nAFOCO2\nFIRE OCO PLEASE CALL / SHE HAS WATER FLOODING HER HOUSE AND DOESN'T KNOW HOW TO\nTURN IT OFF / SHE CAN'T GET AHOLD OF
BFD \nBFOCO2\n13BF00583\nDS   - 16.36.04 06/27/13\nCMPLT- 17.06.53
SFD \nSAMBI2\n13SA00391\nDS   - 16.16.43 06/27/13\nFOS  - 16.22.36\nCMPLT- 16.54.37
BFD \nSMOKE/HEAT ALRM\n147 E HOMESTEAD DR,BAS\nBFD\nBFOCO2\nsmoke detector going off---no apparent reason--come by
SFD \nSEND\nWOOD RD; at fanny hill--pickup,SMV\nSFD\nSAMBI2\n17 yoa male --c&b--ao x1--head injury---eta 10 mins---code
BFD \nBFOCO1\n13BF00582\nENRT - 14.41.18 06/27/13\nCMPLT- 15.15.05
BFD \nMUTUAL AID\n1089 J W DR; BFD Station 42,CAR\nBFD\nBFOCO1\ncfd has been paged out to a smoke check on county rd 102---just want to "let BFD\nknow"---no response asked f
AA  \nA1CODE\n13AA00701\nDS   - 11.51.38 06/27/13\nFOS  - 12.03.48\nCMPLT- 12.11.44
AA  \nMEDICAL\n210 JUNIPER HILL DR; cozy point,ASP\nAA\nA1CODE\noutdoor arena// girl who fell off horse//back pain\n11:50:12 06/27/2013 - MARTINEZ, RITA\nProQA Medical Recomm
SFD \nSFALL3\n13SF00310\nDS   - 11.04.02 06/27/13\nFOS  - 11.18.21\nCMPLT- 11.45.04
BFD \nBFOCO1\n13BF00581\nDS   - 09.53.52 06/27/13\nCMPLT- 11.06.53
SFD \nODOR INVEST\n108 NORTH RIDGE LN,SMV\nSFD\nSFALL3\nSMELL SOMETHING BURNING IN HER HOUSE//SMELLS ELECTRICAL
AFD \nAFOCO1\n13AF00955\nDS   - 09.30.25 06/27/13\nCMPLT- 10.36.46
BFD \nODOR INVEST\n218 E VALLEY RD; blue tent suit 205,CAR\nBFD\nBFOCO1\ngas/sewer smell in the office//so far no symptoms//
AA  \nAMBI TRANSFER\n401 CASTLE CREEK RD; AVH; TO DENVER,ASP\nAA\nM93
AFD \nAFOCO2\n13AF00954\nDS   - 06.19.43 06/27/13\nCMPLT- 06.45.13
AFD \nCO ALARM\n675 S ALPS RD,ASP\nAFD\nAFOCO2\nzuma busn//master bed room//no guard
BFD \nB1NON\n13BA00291\nENRT - 02.03.56 06/27/13\nCMPLT- 02.22.04
BFD \nMEDICAL\n157 BASALT CENTER CIR; 107,BAS\nBFD\nB1NON\nwas in er this morning vomiting, \n02:03:05 06/27/2013 - QUINLAN, LORI A\n30 yoa male, headache, body cramping
SFD \nSFALL3\n13SF00309\nDS   - 23.59.00 06/26/13\nCMPLT- 00.19.08
SFD \nGENERAL ALARM\n1364 HORSE RANCH DR,SMV\nSFD\nSFALL3\nsigler smoke and heat will notify guard no answer on call back
AA  \nAAMBI1\n13AA00698\nENRT - 20.03.40 06/26/13\nCMPLT- 20.13.56
AA  \nPAGE\n401 CASTLE CREEK RD; AVH; er,ASP\nAA\nAAMBI1\npls page medics to come or call er right away
AA  \nA1NON\n13AA00697\nDS   - 17.53.30 06/26/13\nCMPLT- 18.38.18
SFD \nSFALL2\n13SF00308\nDS   - 18.01.40 06/26/13\nCMPLT- 18.17.33
SFD \nSMOKE REPORT\nOAK RIDGE LN,SMV\nSFD\nSFALL2\nWHITE SMOKE, NEAR THE MINCHERS 
AA  \nMEDICAL\n1541 WOODY CREEK RD; house,WDY\nAA\nA1NON\nmother has fallen, may have broken arm or shoulder\n17:51:51 06/26/2013 - QUINLAN, LORI A\nProQA Medical Recommended
AFD \nAFOCO1\n13AF00952\nDS   - 17.03.38 06/26/13\nCMPLT- 17.09.02
AFD \nCO ALARM\n935 E DURANT AVE; RISCOR/ALPINA HOUSE,ASP\nAFD\nAFOCO1\nco alarm from unit 12, call after dispatch, and keyholders\n\n\nKEVIN DECARLO 920-3975, 309-4764. HARRY
AA  \nAAMBI1\n13AA00696\nDS   - 15.54.31 06/26/13\nCMPLT- 16.13.24
SFD \nSFALL1\n13SF00307\nDS   - 15.53.06 06/26/13\nFOS  - 16.05.12\nEN   - 16.05.56\nCMPLT- 16.11.14
AFD \nAFALL1\n5276\nDS   - 15.53.06 06/26/13\nFOS  - 16.06.02\nCMPLT- 16.11.14
AA  \nVEHICLE FIRE\n190 JACK GREDIG LN,ASP\nSFD\nAAMBI1\nall the way in, at top---flatbed dumptruck "on fire"--under bed with hydraulics,\nmostly smoke not flames
SFD \nVEHICLE FIRE\n190 JACK GREDIG LN,ASP\nSFD\nSFALL1\nall the way in, at top---flatbed dumptruck "on fire"--under bed with hydraulics,\nmostly smoke not flames
SFD \nVEHICLE FIRE\n190 JACK GREDIG LN,ASP\nSFD\nSFALL1\nall the way in, at top---flatbed dumptruck "on fire"--under bed with hydraulics,\nmostly smoke not flames
AFD \nAFOCO1\n13AF00950\nDS   - 13.30.44 06/26/13\nFOS  - 13.32.52\nCMPLT- 13.38.30
AFD \nFLOW ALARM\n516 E DURANT AVE;marcus durant galena,ASP\nAFD\nAFOCO1\nno permit---water flow, lower level
BFD \nB1CODE\n13BA00289\nDS   - 13.00.22 06/26/13\nFOS  - 13.12.24\nCMPLT- 13.21.11
BFD \nMEDICAL\n680 E SOPRIS DR; apt 680,BAS\nBFD\nB1CODE\nsister throwing up from pain & hard to breath\n12:59:01 06/26/2013 - MARTINEZ, RITA\nProQA Medical Recommended Dispa
AA  \nA1NON\n13AA00695\nDS   - 10.55.59 06/26/13\nFOS  - 11.06.41\nLOCTN- 11.18.07\nCMPLT- 11.28.41
AA  \nMEDICAL\n1210 RED BUTTE DR,ASP\nAA\nA1NON\n10:54:39 06/26/2013 - MARTINEZ, RITA\nProQA Medical Recommended Dispatch Level = 01A01\n48 year old, Female, Conscious, Breat
AFD \nAFOCO1\n13AF00946\nDS   - 10.18.58 06/26/13\nCMPLT- 10.21.22
AFD \nFLOW ALARM\n983 MOORE DR; FERRARA RESD,ASP\nAFD\nAFOCO1\nvalid permit---sprinkler flow--general---CONTACT: FRANK GOLDSMITH 9255251; 2ND #\n948-5251. 2ND CONTACT SUSAN 
AFD \nAFOCO1\n13AF00945\nDS   - 09.38.57 06/26/13\nCMPLT- 09.41.45
AFD \nPULL STN ALARM\n700 UTE AVE; ASPEN ALPS,ASP\nAFD\nAFOCO1\nfire alarm from 400 bldg left pull station//ref#210//not called site//notifying\nresponder\n\nJOHN CORCOCRAN \n9
SFD \nSFALL1\n13SF00306\nDS   - 23.33.00 06/25/13\nFOS  - 23.37.00\nCMPLT- 00.15.51
SFD \nFLOW ALARM\n5131 OWL CREEK RD ;bld b,SMV\nSFD\nSFALL1\nowl creek grove showing flow alarm//did not call//no guard
SFD \nSFALL1\n13SF00305\nDS   - 21.13.58 06/25/13\nFOS  - 21.21.04\nCMPLT- 22.18.45
SFD \nGENERAL ALARM\n76 SPUR RIDGE LN,SMV\nSFD\nSFALL1\nrobbins residence upper level smoke alarm...no contact on premise...no guard

 */

public class COPitkinCountyParserTest extends BaseParserTest {
  
  public COPitkinCountyParserTest() {
    setParser(new COPitkinCountyParser(), "PITKIN COUNTY", "CO");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "SFD \nGENERAL ALARM\n32 ELK RIDGE LN,SMV\nSFD\nSFALL3\nfryers resd   hall #2 smoke detector  no guard   no call yet",
        "SRC:SFD",
        "CALL:GENERAL ALARM",
        "ADDR:32 ELK RIDGE LN",
        "CITY:SNOWMASS VILLAGE",
        "UNIT:SFALL3",
        "INFO:fryers resd   hall #2 smoke detector  no guard   no call yet");

    doTest("T2",
        "PC  \n" +
        "SAR\n" +
        "29000 FRYING PAN RD,MER\n" +
        "PC\n" +
        "52\n" +
        "MIDDLE FORK OF FRYING PAN RIVER FISHING, RP WENT BACK TO CHECK FOR FRIEND AND\n" +
        "CAN'T FIND HIM. HE HAS BEEN MISSING FOR OVER AN HO",

        "SRC:PC",
        "CALL:SAR",
        "ADDR:29000 FRYING PAN RD",
        "CITY:MEREDITH",
        "UNIT:52",
        "INFO:MIDDLE FORK OF FRYING PAN RIVER FISHING, RP WENT BACK TO CHECK FOR FRIEND AND / CAN'T FIND HIM. HE HAS BEEN MISSING FOR OVER AN HO");

    doTest("T3",
        "BFD \n" +
        "SMOKE REPORT\n" +
        "RUEDI CREEK RD,BAS\n" +
        "BFD\n" +
        "BFALL3\n" +
        "smoke report given to eagle deputy, was 10 mi south of mt riley, rp was at\n" +
        "ruedi, shannon at 512-718-8390",

        "SRC:BFD",
        "CALL:SMOKE REPORT",
        "ADDR:RUEDI CREEK RD",  // Not mapping
        "CITY:BASALT",
        "UNIT:BFALL3",
        "INFO:smoke report given to eagle deputy, was 10 mi south of mt riley, rp was at / ruedi, shannon at 512-718-8390");

    doTest("T4",
        "AFD \nAFOCO1\n13AF00975\nDS   - 15.19.18 06/30/13\nCMPLT- 15.24.16",
        "CALL:RUN REPORT",
        "SRC:AFD",
        "ID:13AF00975",
        "UNIT:AFOCO1",
        "INFO:DS   - 15.19.18 06/30/13\nCMPLT- 15.24.16");

    doTest("T5",
        "AFD \n" +
        "GENERAL ALARM\n" +
        "406 E HOPKINS AVE; ISIS BLDG,ASP\n" +
        "AFD\n" +
        "AFOCO1\n" +
        "valid permit, fire from zone 209 which is 2nd floor elevator lobby and general\n" +
        "fire zone 0\n\n" +
        "Wed Feb 20 1",

        "SRC:AFD",
        "CALL:GENERAL ALARM",
        "ADDR:406 E HOPKINS AVE",
        "PLACE:ISIS BLDG",
        "CITY:ASPEN",
        "UNIT:AFOCO1",
        "INFO:valid permit, fire from zone 209 which is 2nd floor elevator lobby and general / fire zone 0 / Wed Feb 20 1");

    doTest("T6",
        "BFD \n" +
        "MUTUAL AID\n" +
        "29000 FRYING PAN RD,MER\n" +
        "BFD\n" +
        "BFOCO1\n" +
        "MIDDLE FORK OF FRYING PAN RIVER FISHING, RP WENT BACK TO CHECK FOR FRIEND AND\n" +
        "CAN'T FIND HIM. HE HAS BEEN MISSING FO",

        "SRC:BFD",
        "CALL:MUTUAL AID",
        "ADDR:29000 FRYING PAN RD",
        "CITY:MEREDITH",
        "UNIT:BFOCO1",
        "INFO:MIDDLE FORK OF FRYING PAN RIVER FISHING, RP WENT BACK TO CHECK FOR FRIEND AND / CAN'T FIND HIM. HE HAS BEEN MISSING FO");

    doTest("T7",
        "AA  \nA1CODE\n13AA00707\nENRT - 13.41.28 06/30/13\nCMPLT- 14.02.43",
        "CALL:RUN REPORT",
        "SRC:AA",
        "ID:13AA00707",
        "UNIT:A1CODE",
        "INFO:ENRT - 13.41.28 06/30/13\nCMPLT- 14.02.43");

    doTest("T8",
        "BFD \nBFOCO1\n13BF00590\nENRT - 13.09.36 06/30/13\nFOS  - 13.11.23\nCMPLT- 13.53.57",
        "CALL:RUN REPORT",
        "SRC:BFD",
        "ID:13BF00590",
        "UNIT:BFOCO1",
        "INFO:ENRT - 13.09.36 06/30/13\nFOS  - 13.11.23\nCMPLT- 13.53.57");

    doTest("T9",
        "AA  \n" +
        "MEDICAL\n" +
        "69 E AIRPORT RD,ASP\n" +
        "AA\n" +
        "A1CODE\n" +
        "plane coming in, eta 10 min, 66 yom, nausea, fever, bloated stomach\n" +
        "13:40:07 06/30/2013 - KIMMEL, LINDA F\n" +
        "ProQA Medical Reco",

        "SRC:AA",
        "CALL:MEDICAL",
        "ADDR:69 E AIRPORT RD",
        "CITY:ASPEN",
        "UNIT:A1CODE",
        "INFO:plane coming in, eta 10 min, 66 yom, nausea, fever, bloated stomach / 13:40:07 06/30/2013 - KIMMEL, LINDA F / ProQA Medical Reco");

    doTest("T10",
        "BFD \n" +
        "INJURY ACCIDENT\n" +
        "EL JEBEL RD & HWY 82,CAR\n" +
        "BFD\n" +
        "BFOCO1\n" +
        "3 VEHICLES, NO INJURIES\n" +
        "13:06:27 06/30/2013 - KEITH, AUDRA   \n" +
        "ONE OF THE  WB LANE BLOCKED\n" +
        "13:06:56 06/30/2013 ",

        "SRC:BFD",
        "CALL:INJURY ACCIDENT",
        "ADDR:EL JEBEL RD & HWY 82",  // Can't find this
        "CITY:CARBONDALE",
        "UNIT:BFOCO1",
        "INFO:3 VEHICLES, NO INJURIES / 13:06:27 06/30/2013 - KEITH, AUDRA / ONE OF THE  WB LANE BLOCKED / 13:06:56 06/30/2013");

    doTest("T11",
        "SFD \nSFALL3\n13SF00314\nDS   - 09.34.26 06/30/13\nFOS  - 09.45.19\nCMPLT- 10.07.00",
        "CALL:RUN REPORT",
        "SRC:SFD",
        "ID:13SF00314",
        "UNIT:SFALL3",
        "INFO:DS   - 09.34.26 06/30/13\nFOS  - 09.45.19\nCMPLT- 10.07.00");

    doTest("T12",
        "SFD \nODOR INVEST\n10 FOX LN,SMV\nSFD\nSFALL3\nSMELLS NATURAL GAS INSIDE HOUSE. ",
        "SRC:SFD",
        "CALL:ODOR INVEST",
        "ADDR:10 FOX LN",
        "CITY:SNOWMASS VILLAGE",
        "UNIT:SFALL3",
        "INFO:SMELLS NATURAL GAS INSIDE HOUSE.");

    doTest("T13",
        "SFD \nS2CODE\n13SA00392\nDS   - 21.20.45 06/29/13\nOS   - 21.27.58\nFOS  - 21.41.57\nLOCTN- 21.42.13\nCMPLT- 21.52.32",
        "CALL:RUN REPORT",
        "SRC:SFD",
        "ID:13SA00392",
        "UNIT:S2CODE",
        "INFO:DS   - 21.20.45 06/29/13\nOS   - 21.27.58\nFOS  - 21.41.57\nLOCTN- 21.42.13\nCMPLT- 21.52.32");

    doTest("T14",
        "SFD \n" +
        "MEDICAL\n" +
        "30 ANDERSON LN; Stonebridge Condos; 642,SMV\n" +
        "SFD\n" +
        "S2CODE\n" +
        "HIS MOM IS ON CHEMO 102.7 FEVER / NEEDS TO BE TRANSPORTED / GO TO BURLINGAME LN\n" +
        "TO GET TO THIS BLDG",

        "SRC:SFD",
        "CALL:MEDICAL",
        "ADDR:30 ANDERSON LN",
        "PLACE:Stonebridge Condos",
        "APT:642",
        "CITY:SNOWMASS VILLAGE",
        "UNIT:S2CODE",
        "INFO:HIS MOM IS ON CHEMO 102.7 FEVER / NEEDS TO BE TRANSPORTED / GO TO BURLINGAME LN / TO GET TO THIS BLDG");

    doTest("T15",
        "AA  \n" +
        "INJURY ACCIDENT\n" +
        "56000 HWY 82,ASP\n" +
        "AA\n" +
        "A1CODE\n" +
        "motorcycle accident  \"people hurt\"\n" +
        "13:28:06 06/29/2013 - BULTMAN, GINN\n" +
        "ProQA Medical Case 242332 Aborted: EMD not neede",

        "SRC:AA",
        "CALL:INJURY ACCIDENT",
        "ADDR:56000 HWY 82",
        "CITY:ASPEN",
        "UNIT:A1CODE",
        "INFO:motorcycle accident  \"people hurt\" / 13:28:06 06/29/2013 - BULTMAN, GINN / ProQA Medical Case 242332 Aborted: EMD not neede");

    doTest("T16",
        "AFD \n" +
        "GAS ALARM\n" +
        "91 BUCHANAN DR,ASP\n" +
        "AFD\n" +
        "AFOCO3\n" +
        "yeager resd  garage gas detector and general smoke detector  no call yet   yes\n" +
        "sending a guard unk who",

        "SRC:AFD",
        "CALL:GAS ALARM",
        "ADDR:91 BUCHANAN DR",
        "CITY:ASPEN",
        "UNIT:AFOCO3",
        "INFO:yeager resd  garage gas detector and general smoke detector  no call yet   yes / sending a guard unk who");

    doTest("T17",
        "BFD \nODOR INVEST\n523 EMMA RD,BAS\nBFD\nBFOCO3\nbehind the post office thick smell of smoke   now doesnt smell as much",
        "SRC:BFD",
        "CALL:ODOR INVEST",
        "ADDR:523 EMMA RD",
        "CITY:BASALT",
        "UNIT:BFOCO3",
        "INFO:behind the post office thick smell of smoke   now doesnt smell as much");

    doTest("T18",
        "BFD \n" +
        "FOLLOW UP\n" +
        "3000 EMMA WEST RD,BAS\n" +
        "BFD\n" +
        "BFOCO1\n" +
        "tractor and baler fire from last night  rp is wondering if it was really\n" +
        "accidental  have fire officer call",

        "SRC:BFD",
        "CALL:FOLLOW UP",
        "ADDR:3000 EMMA WEST RD",
        "CITY:BASALT",
        "UNIT:BFOCO1",
        "INFO:tractor and baler fire from last night  rp is wondering if it was really / accidental  have fire officer call");

    doTest("T19",
        "AA  \nSTANDBY\n506 E MAIN ST; APD,ASP\nAA\nAAMBI1\nBACKCOUNTRY MARATHON",
        "SRC:AA",
        "CALL:STANDBY",
        "ADDR:506 E MAIN ST",
        "PLACE:APD",
        "CITY:ASPEN",
        "UNIT:AAMBI1",
        "INFO:BACKCOUNTRY MARATHON");

    doTest("T20",
        "AA  \nA1CODE\n13AA00704\nENRT - 23.24.58 06/28/13\nFOS  - 23.35.51\nCMPLT- 00.41.47",
        "CALL:RUN REPORT",
        "SRC:AA",
        "ID:13AA00704",
        "UNIT:A1CODE",
        "INFO:ENRT - 23.24.58 06/28/13\nFOS  - 23.35.51\nCMPLT- 00.41.47");

    doTest("T21",
        "AFD \nAFOCO2\n13AF00970\nDS   - 23.56.34 06/28/13\nCMPLT- 00.16.38",
        "CALL:RUN REPORT",
        "SRC:AFD",
        "ID:13AF00970",
        "UNIT:AFOCO2",
        "INFO:DS   - 23.56.34 06/28/13\nCMPLT- 00.16.38");

    doTest("T22",
        "AFD \n" +
        "SMOKE/HEAT ALRM\n" +
        "103 E HYMAN AVE,ASP\n" +
        "AFD\n" +
        "AFOCO2\n" +
        "HOUSE / RP IS IN BACK APARTMENT / ALARM WENT OFF / SHE WENT INTO DOWNSTAIRS APT \n" +
        "AND FOUND SOMETHING LEFT ON THE ST",

        "SRC:AFD",
        "CALL:SMOKE/HEAT ALRM",
        "ADDR:103 E HYMAN AVE",
        "CITY:ASPEN",
        "UNIT:AFOCO2",
        "INFO:HOUSE / RP IS IN BACK APARTMENT / ALARM WENT OFF / SHE WENT INTO DOWNSTAIRS APT / AND FOUND SOMETHING LEFT ON THE ST");

    doTest("T23",
        "BFD \nBFALL3\n13BF00587\nDS   - 22.42.07 06/28/13\nCMPLT- 23.33.14",
        "CALL:RUN REPORT",
        "SRC:BFD",
        "ID:13BF00587",
        "UNIT:BFALL3",
        "INFO:DS   - 22.42.07 06/28/13\nCMPLT- 23.33.14");

    doTest("T24",
        "AA  \n" +
        "UNKNOWN\n" +
        "31350 HWY 82; Aspen Village Light,ASP\n" +
        "AA\n" +
        "A1CODE\n" +
        "LANGUAGE BARRIER / CAN'T TELL WHATS GOING ON / DISCONNENCTED \n" +
        "23:20:30 06/28/2013 - Rosselot, B.\n" +
        "FIRST CAL",

        "SRC:AA",
        "CALL:UNKNOWN",
        "ADDR:31350 HWY 82",
        "PLACE:Aspen Village Light",
        "CITY:ASPEN",
        "UNIT:A1CODE",
        "INFO:LANGUAGE BARRIER / CAN'T TELL WHATS GOING ON / DISCONNENCTED / 23:20:30 06/28/2013 - Rosselot, B. / FIRST CAL");

    doTest("T25",
        "AFD \nAFOCO1\n13AF00968\nENRT - 22.54.21 06/28/13\nCMPLT- 22.58.45",
        "CALL:RUN REPORT",
        "SRC:AFD",
        "ID:13AF00968",
        "UNIT:AFOCO1",
        "INFO:ENRT - 22.54.21 06/28/13\nCMPLT- 22.58.45");

    doTest("T26",
        "AFD \n" +
        "PULL STN ALARM\n" +
        "4807 ASPEN MTN RD; SUNDECK,ASP\n" +
        "PFD\n" +
        "AFOCO1\n" +
        "SHOWING FIRE AND FIRE MANUAL LEVEL PULL STATION / NO CALL TO SITE / WILL SEND\n" +
        "GUARD / REF:54188",

        "SRC:AFD-PFD",
        "CALL:PULL STN ALARM",
        "ADDR:4807 ASPEN MTN RD",
        "PLACE:SUNDECK",
        "CITY:ASPEN",
        "UNIT:AFOCO1",
        "INFO:SHOWING FIRE AND FIRE MANUAL LEVEL PULL STATION / NO CALL TO SITE / WILL SEND / GUARD / REF:54188");

    doTest("T27",
        "BFD \n" +
        "WILDLAND FIRE\n" +
        "HOOKS LN,BAS\n" +
        "BFD\n" +
        "BFALL3\n" +
        "BETWEEN EMMA AND HOOKS SPUR ON HOOKS LN / WHAT LOOKS LIKE BONFIRE ON EDGE OF\n" +
        "ROAD / SPREADING / CAN SEE FLAMES ",

        "SRC:BFD",
        "CALL:WILDLAND FIRE",
        "ADDR:HOOKS LN",
        "CITY:BASALT",
        "UNIT:BFALL3",
        "INFO:BETWEEN EMMA AND HOOKS SPUR ON HOOKS LN / WHAT LOOKS LIKE BONFIRE ON EDGE OF / ROAD / SPREADING / CAN SEE FLAMES");

    doTest("T28",
        "SFD \nSFALL3\n13SF00313\nDS   - 21.29.34 06/28/13\nFOS  - 21.36.46\nCMPLT- 21.45.00",
        "CALL:RUN REPORT",
        "SRC:SFD",
        "ID:13SF00313",
        "UNIT:SFALL3",
        "INFO:DS   - 21.29.34 06/28/13\nFOS  - 21.36.46\nCMPLT- 21.45.00");

    doTest("T29",
        "SFD \n" +
        "SMOKE REPORT\n" +
        "1022 WOOD RD,SMV\n" +
        "SFD\n" +
        "SFALL3\n" +
        "RP SMELLING A VERY STRONG SMOKE SMELL AT THIS LOCATION / UNKNOWN WHERE IT IS\n" +
        "COMING FROM / CAN'T SEE ANY SMOKE OR FLAMES ",

        "SRC:SFD",
        "CALL:SMOKE REPORT",
        "ADDR:1022 WOOD RD",
        "CITY:SNOWMASS VILLAGE",
        "UNIT:SFALL3",
        "INFO:RP SMELLING A VERY STRONG SMOKE SMELL AT THIS LOCATION / UNKNOWN WHERE IT IS / COMING FROM / CAN'T SEE ANY SMOKE OR FLAMES");

    doTest("T30",
        "AA  \nA1CODE\n13AA00703\nDS   - 17.17.34 06/28/13\nCMPLT- 17.44.50",
        "CALL:RUN REPORT",
        "SRC:AA",
        "ID:13AA00703",
        "UNIT:A1CODE",
        "INFO:DS   - 17.17.34 06/28/13\nCMPLT- 17.44.50");

    doTest("T31",
        "AA  \n" +
        "MEDICAL\n" +
        "315 DEAN ST; ST REGIS;outside,ASP\n" +
        "AA\n" +
        "A1CODE\n" +
        "guest that tripped on stone in front of st regis. \n" +
        "17:16:43 06/28/2013 - MADRIL,DANIELLE\n" +
        "ProQA Medical Recomme",

        "SRC:AA",
        "CALL:MEDICAL",
        "ADDR:315 DEAN ST",
        "PLACE:ST REGIS",
        "APT:outside",
        "CITY:ASPEN",
        "UNIT:A1CODE",
        "INFO:guest that tripped on stone in front of st regis. / 17:16:43 06/28/2013 - MADRIL,DANIELLE / ProQA Medical Recomme");

    doTest("T32",
        "AFD \nAFOCO1\n13AF00966\nENRT - 16.00.03 06/28/13\nCMPLT- 16.11.54",
        "CALL:RUN REPORT",
        "SRC:AFD",
        "ID:13AF00966",
        "UNIT:AFOCO1",
        "INFO:ENRT - 16.00.03 06/28/13\nCMPLT- 16.11.54");

    doTest("T33",
        "AFD \nAFOCO1\n13AF00966\nENRT - 16.00.03 06/28/13\nCMPLT- 16.11.54",
        "CALL:RUN REPORT",
        "SRC:AFD",
        "ID:13AF00966",
        "UNIT:AFOCO1",
        "INFO:ENRT - 16.00.03 06/28/13\nCMPLT- 16.11.54");

    doTest("T34",
        "AFD \n" +
        "PULL STN ALARM\n" +
        "4807 ASPEN MTN RD,ASP\n" +
        "PFD\n" +
        "AFOCO1\n" +
        "sundeck restaurant    general fire plus main level pull ph/9704296970  havent\n" +
        "yet called   no guard",

        "SRC:AFD-PFD",
        "CALL:PULL STN ALARM",
        "ADDR:4807 ASPEN MTN RD",
        "CITY:ASPEN",
        "UNIT:AFOCO1",
        "INFO:sundeck restaurant    general fire plus main level pull ph/9704296970  havent / yet called   no guard");

    doTest("T35",
        "AFD \n" +
        "PAGE\n" +
        "43 SAGE WAY; AFD - North Forty Fire Stat,ASP\n" +
        "AFD\n" +
        "AFALL1\n" +
        "JPR rodeo training at the N40 at 8:00 on sat\n" +
        "Call type f reopened by KIMMEL, LINDA F at 13:09:35 06/2",

        "SRC:AFD",
        "CALL:PAGE",
        "ADDR:43 SAGE WAY",
        "PLACE:AFD - North Forty Fire Stat",
        "CITY:ASPEN",
        "UNIT:AFALL1",
        "INFO:JPR rodeo training at the N40 at 8:00 on sat / Call type f reopened by KIMMEL, LINDA F at 13:09:35 06/2");

    doTest("T36",
        "AFD \nAFOCO2\n13AF00962\nDS   - 08.47.04 06/28/13\nCMPLT- 08.59.46",
        "CALL:RUN REPORT",
        "SRC:AFD",
        "ID:13AF00962",
        "UNIT:AFOCO2",
        "INFO:DS   - 08.47.04 06/28/13\nCMPLT- 08.59.46");

    doTest("T37",
        "AFD \n" +
        "CO ALARM\n" +
        "718 S MILL ST;unit 4,ASP\n" +
        "AFD\n" +
        "AFOCO2\n" +
        "carbon monoxide alarm unit 4//not called site//notifying responder\n" +
        "08:46:02 06/28/2013 - MARTINEZ, RITA \n" +
        "permit# 700 ",

        "SRC:AFD",
        "CALL:CO ALARM",
        "ADDR:718 S MILL ST",
        "APT:4",
        "CITY:ASPEN",
        "UNIT:AFOCO2",
        "INFO:carbon monoxide alarm unit 4//not called site//notifying responder / 08:46:02 06/28/2013 - MARTINEZ, RITA / permit# 700");

    doTest("T38",
        "BFD \nBFOCO1\n13BF00584\nDS   - 17.26.20 06/27/13\nCMPLT- 17.34.54",
        "CALL:RUN REPORT",
        "SRC:BFD",
        "ID:13BF00584",
        "UNIT:BFOCO1",
        "INFO:DS   - 17.26.20 06/27/13\nCMPLT- 17.34.54");

    doTest("T39",
        "BFD \nFOLLOW UP\n20 SCHOOL ST; BFD; VALLEY VIEW HOSPITAL,BAS\nBFD\n424\nSOMONE FROM MEDIC 42 PLEASE CALL ",
        "SRC:BFD",
        "CALL:FOLLOW UP",
        "ADDR:20 SCHOOL ST",
        "PLACE:VALLEY VIEW HOSPITAL",
        "CITY:BASALT",
        "UNIT:424",
        "INFO:SOMONE FROM MEDIC 42 PLEASE CALL");

    doTest("T40",
        "AFD \nAFOCO2\n13AF00960\nDS   - 17.08.24 06/27/13\nCMPLT- 17.10.22",
        "CALL:RUN REPORT",
        "SRC:AFD",
        "ID:13AF00960",
        "UNIT:AFOCO2",
        "INFO:DS   - 17.08.24 06/27/13\nCMPLT- 17.10.22");

    doTest("T41",
        "AFD \n" +
        "CITIZEN ASSIST\n" +
        "59 MAGNIFICO RD,ASP\n" +
        "AFD\n" +
        "AFOCO2\n" +
        "FIRE OCO PLEASE CALL / SHE HAS WATER FLOODING HER HOUSE AND DOESN'T KNOW HOW TO\n" +
        "TURN IT OFF / SHE CAN'T GET AHOLD OF",

        "SRC:AFD",
        "CALL:CITIZEN ASSIST",
        "ADDR:59 MAGNIFICO RD",
        "CITY:ASPEN",
        "UNIT:AFOCO2",
        "INFO:FIRE OCO PLEASE CALL / SHE HAS WATER FLOODING HER HOUSE AND DOESN'T KNOW HOW TO / TURN IT OFF / SHE CAN'T GET AHOLD OF");

    doTest("T42",
        "BFD \nBFOCO2\n13BF00583\nDS   - 16.36.04 06/27/13\nCMPLT- 17.06.53",
        "CALL:RUN REPORT",
        "SRC:BFD",
        "ID:13BF00583",
        "UNIT:BFOCO2",
        "INFO:DS   - 16.36.04 06/27/13\nCMPLT- 17.06.53");

    doTest("T43",
        "SFD \nSAMBI2\n13SA00391\nDS   - 16.16.43 06/27/13\nFOS  - 16.22.36\nCMPLT- 16.54.37",
        "CALL:RUN REPORT",
        "SRC:SFD",
        "ID:13SA00391",
        "UNIT:SAMBI2",
        "INFO:DS   - 16.16.43 06/27/13\nFOS  - 16.22.36\nCMPLT- 16.54.37");

    doTest("T44",
        "BFD \nSMOKE/HEAT ALRM\n147 E HOMESTEAD DR,BAS\nBFD\nBFOCO2\nsmoke detector going off---no apparent reason--come by",
        "SRC:BFD",
        "CALL:SMOKE/HEAT ALRM",
        "ADDR:147 E HOMESTEAD DR",
        "CITY:BASALT",
        "UNIT:BFOCO2",
        "INFO:smoke detector going off---no apparent reason--come by");

    doTest("T45",
        "SFD \nSEND\nWOOD RD; at fanny hill--pickup,SMV\nSFD\nSAMBI2\n17 yoa male --c&b--ao x1--head injury---eta 10 mins---code",
        "SRC:SFD",
        "CALL:SEND",
        "ADDR:WOOD RD",
        "PLACE:at fanny hill--pickup",
        "CITY:SNOWMASS VILLAGE",
        "UNIT:SAMBI2",
        "INFO:17 yoa male --c&b--ao x1--head injury---eta 10 mins---code");

    doTest("T46",
        "BFD \nBFOCO1\n13BF00582\nENRT - 14.41.18 06/27/13\nCMPLT- 15.15.05",
        "CALL:RUN REPORT",
        "SRC:BFD",
        "ID:13BF00582",
        "UNIT:BFOCO1",
        "INFO:ENRT - 14.41.18 06/27/13\nCMPLT- 15.15.05");

    doTest("T47",
        "BFD \n" +
        "MUTUAL AID\n" +
        "1089 J W DR; BFD Station 42,CAR\n" +
        "BFD\n" +
        "BFOCO1\n" +
        "cfd has been paged out to a smoke check on county rd 102---just want to \"let BFD\n" +
        "know\"---no response asked f",

        "SRC:BFD",
        "CALL:MUTUAL AID",
        "ADDR:1089 J W DR",
        "PLACE:BFD Station 42",
        "CITY:CARBONDALE",   // Can't figure this one out
        "UNIT:BFOCO1",
        "INFO:cfd has been paged out to a smoke check on county rd 102---just want to \"let BFD / know\"---no response asked f");

    doTest("T48",
        "AA  \nA1CODE\n13AA00701\nDS   - 11.51.38 06/27/13\nFOS  - 12.03.48\nCMPLT- 12.11.44",
        "CALL:RUN REPORT",
        "SRC:AA",
        "ID:13AA00701",
        "UNIT:A1CODE",
        "INFO:DS   - 11.51.38 06/27/13\nFOS  - 12.03.48\nCMPLT- 12.11.44");

    doTest("T49",
        "AA  \n" +
        "MEDICAL\n" +
        "210 JUNIPER HILL DR; cozy point,ASP\n" +
        "AA\n" +
        "A1CODE\n" +
        "outdoor arena// girl who fell off horse//back pain\n" +
        "11:50:12 06/27/2013 - MARTINEZ, RITA\n" +
        "ProQA Medical Recomm",

        "SRC:AA",
        "CALL:MEDICAL",
        "ADDR:210 JUNIPER HILL DR",
        "PLACE:cozy point",
        "CITY:ASPEN",
        "UNIT:A1CODE",
        "INFO:outdoor arena// girl who fell off horse//back pain / 11:50:12 06/27/2013 - MARTINEZ, RITA / ProQA Medical Recomm");

    doTest("T50",
        "SFD \nSFALL3\n13SF00310\nDS   - 11.04.02 06/27/13\nFOS  - 11.18.21\nCMPLT- 11.45.04",
        "CALL:RUN REPORT",
        "SRC:SFD",
        "ID:13SF00310",
        "UNIT:SFALL3",
        "INFO:DS   - 11.04.02 06/27/13\nFOS  - 11.18.21\nCMPLT- 11.45.04");

  }
  
  public static void main(String[] args) {
    new COPitkinCountyParserTest().generateTests("T1");
  }
}