package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Davie County, NC
Contact: Michael Wilson <fireman1700@gmail.com>  (obsolete)

911:Call #110619-2932* Address:866 ANGELL RD* * * City:MOCKSVILLE* * Type:HC* HAZARDOUS CONDITION* HILL JOEL* PH#:336-940-2303* Units:17* IRA:* Medical: No* Haza.
911:Call #110622-3347* Address:2388 LIBERTY CHURCH RD* * * City:MOCKSVILLE* * Type:19D4* HEART PROBLEMS* HALL GENE* PH#:336-492-5114* Units:17,34,ST4,YC24* IRA:*
911:Call #110622-3355* Address:389 LIBERTY CHURCH RD* * * City:MOCKSVILLE* * Type:MED* MEDICAL CALL* CULLER C O* PH#:336-492-7249* Units:17* IRA:* Medical: No* H
911:Call #110623-3420* Address:261 COOPER CREEK DR* * * City:MOCKSVILLE* Geo Comment: BUSINESSES IN CITY LIMITS NBH: OFF 1734 US HWY 601 N Landmark Comment: KNOX
911:Call #110624-3510* Address:3868 US HWY 601 N* * * City:MOCKSVILLE* * Type:YEL* CARDIAC PROBLEM* HOHFF, EARL V* PH#:336-492-3017* Units:17* IRA:* Medical: No*
911:Call #110627-3974* Address:NC HWY 801 N // BONKIN LAKE RD* * * City:MOCKSVILLE* * Type:GWB* GRASS/WOODS/BRUSH FIRE* PAUL TONY* PH#:336-575-4524* Units:17,23*
911:Call #110630-4406* Address:284 BRANGUS WAY* * * City:MOCKSVILLE* NBH: OFF 2386 CANA RD* Type:VF* VEHICLE FIRE* MEADER CORTLAND J* PH#:336-940-2666* Units:17
911:Call #110628-4171* Address:700 RICHIE RD* * * City:MOCKSVILLE* NBH: FROM 444 EATONS CHURCH RD TO 3558 US HWY 601 N NBH: I40 TO FARMSTEAD LN* Type:HC* HAZARDO

Contact: Kenneth Wheeler <wheelerk1411@yahoo.com> (obsolete)
Sender: From:911@co.davie.nc.us
911:Call #111107-2492* Address:100 SUN BURST LN* * * City:MOCKSVILLE* NBH: OFF 1627 JUNCTION RD NEAR NOLLEY RD* Type:HC* HAZARDOUS CONDITION* *
911:Call #111108-2718* Address:255 NEELY RD* * * City:COOLEEMEE* * Type:SF* STRUCTURE FIRE* FOWLER ANSLO* PH#:336-284-4275* Units:14* IRA:* Me
911:Call #120201-4100* Address:1407 JUNCTION RD* * * City:MOCKSVILLE* * Type:50PD* ACCIDENT/DAMAGE* INNES* PH#:704-640-5463* Units:14* IRA:*

Contact: John Gallimore <john.gallimore@co.davie.nc.us> (dispatch IT)
Call#130326-0212* \nAddress:298 E DEPOT ST* \nLine3=* \nLine4=* \nCity:MOCKSVILLE* \nLine6=* \nLine7=* \nLine8=* \nLocCmmt:* \nComp:TEST* \nDesc:TEST* \nCaller:JOHNG - TEST PAGE CALL* \nPh#:336-753-6050* \nUnits:704,9901* \nLine15=* \nMed:Medical: No* \nHaz:Hazards: No* \nNarr:03/26/2013 13:56:33 : pos12 : JGALLIMORE   TEST NARRATIVE....     03/26/2013 13:34:43 : pos12 : JGALLIMORE   Landmark: DAVIE COUNTY PUBLIC UTILITIES  Cross streets: CHAFFIN ST//NEELY ST* 

Contact: Brent Crotts <jvfd2110@gmail.com>
Sender: 911@co.davie.nc.us
911:Call #130324-9973* Address:629 BEAUCHAMP RD* * * City:ADVANCE* WINDEMERE DR* Type:MEADOWS EDGE DR* * NBH: OFF 4900 BLOCK US HWY 158* PH#:5A1* Units:BACK PAIN
911:Call #130324-9989* Address:191 SPRY LN* * * City:MOCKSVILLE* CORNATZER RD* Type:DEADEND* * * PH#:1A1* Units:ABDOMINAL PAIN/PROBLEMS* IRA:WILMOTH MELISSA LAMB

Contact: adoubdsd@aol.com <adoubdsd@aol.com>
Sender: 911@co.davie.nc.us 
911:Call #130307-7878* Address:146 DR SLATE DR* * * City:MOCKSVILLE* NBH: OFF 221 MERONEY ST BESIDE DAVIE HOSPITAL* Type:MI* MISCELLANEOUS* * PH#:336-751-0897* U
911:Call #130305-7702* Address:156 DUARD REAVIS RD* * * City:MOCKSVILLE* NBH: OFF 795 BEAR CREEK CHURCH* Type:MED* MEDICAL CALL* VERIZON WIRELESS* PH#:336-409-81
911:Call #130315-8831* Address:197 PEPPERSTONE DR* * * City:MOCKSVILLE* DANNER RD* Type:PEPPERSTONE PL* * NBH: OFF 176 DANNER RD OFF 2469 US HWY 601 N* PH#:UNR*
911:Call #130322-9715* Address:301 OLLIE HARKEY RD* * * City:YADKINVILLE* LIBERTY CHURCH RD* Type:AMBER HILL RD* * NBH: OFF 2448 LIBERTY CHURCH RD* PH#:FA* Units

Contact: Active911
Agency name: Advance Fire Department
Location: Advance, NC, United States
Sender: 911@co.davie.nc.us

911:Call #130312-8543* Address:117 CUMBERLAND CT* * * City:ADVANCE* COVINGTON DR* Type:DEADEND* * Geo Comment: COVINGTON CREEK DEV NBH: 290 BLOCK COVINGTON DR OFF 2400 BLOCK NC HWY 801 S* PH#:RD* Units:RESPIRATORY DISTRESS* IRA:COLEY BECKY* 336-998-2732* 12* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/12/2013 21:08:18 : pos2 : MCROWE Cross streets: COVINGTON DR//DEADEND Geo Comment: COVINGTON CREEK DEV NBH: 290 BLOCK COVINGTON DR OFF 2400 BLOCK NC HWY 801 S*
911:Call #130311-8376* Address:376 UNDERPASS RD* * * City:ADVANCE* KEN HOOTS LN* Type:BAILEY RD* * NBH: OFF 2000 BLOCK NC HWY 801 S* PH#:50PI* Units:ACCIDENT/INJURY* IRA:VERIZON* 336-817-1952* 12,34* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/11/2013 16:15:27 : pos4 : SFRYE Cross streets: KEN HOOTS LN//BAILEY RD Landmark: PINEY GROVE METHODIST CHURCH NBH: OFF 2000 BLOCK NC HWY 801 S Cross streets: RABBIT FARM TR//ORRELL TR*
911:Call #130311-8317* Address:1630 NC HWY 801 S* * * City:ADVANCE* PLYLER LN* Type:POTTS RD* * * PH#:MED* Units:MEDICAL CALL* IRA:VERIZON* 336-909-3919* 12* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/11/2013 09:18:15 : pos2 : MCROWE Cross streets: PLYLER LN//POTTS RD Cross streets: RABBIT FARM TR//ORRELL TR*
911:Call #130310-8293* Address:308 KLICKITAT TR* * * City:MOCKSVILLE* WORKMANS WA* Type:DEADEND* * NBH: OFF 500 HOWARDTOWN RD* PH#:FA* Units:FIRE ALARM* IRA:SMITH BARBARA D* 336-998-4299* 19,24,12* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/10/2013 21:22:53 : pos1 : TWMYERS Cross streets: WORKMANS WA//DEADEND NBH: OFF 500 HOWARDTOWN RD HER SMOKE ALARM HAS ACTIVATED, NO SMOKE OR FIRE CONDITIONS*
911:Call #130309-8130* Address:301 GRANADA DR* * * City:ADVANCE* GALADRIM WA* Type:DEADEND* * NBH: OFF 100 BLOCK SONORA DR OFF 300 BLOCK LA QUINTA DR* PH#:MED* Units:MEDICAL CALL* IRA:glen myers* 336-998-3956* 12* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/09/2013 10:09:10 : pos4 : JBYERLY Cross streets: GALADRIM WA//DEADEND NBH: OFF 100 BLOCK SONORA DR OFF 300 BLOCK LA QUINTA DR*
911:Call #130308-8086* Address:204 GRANADA DR* * * City:ADVANCE* SONORA DR* Type:SAN CARLOS CT* * NBH: OFF 100 BLOCK SONORA DR OFF 300 BLOCK LA QUINTA DR* PH#:MED* Units:MEDICAL CALL* IRA:katie* 336-998-8325* 12* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/08/2013 21:30:12 : pos2 : DBLACKBURN Cross streets: SONORA DR//SAN CARLOS CT NBH: OFF 100 BLOCK SONORA DR OFF 300 BLOCK LA QUINTA DR*
911:Call #130307-7898* Address:129 ORCHARD PARK DR* * * City:ADVANCE* NC HWY 801 S* Type:CEDAR LN* * Geo Comment: BERMUDA RUN WEST NBH: OFF 360 BLOCK NC HWY 801 S Landmark Comment: SEE MORE COMPLETE LIST IN LANDMARK BOOK* PH#:50PI* Units:ACCIDENT/INJURY* IRA:* 336-998-8001* 12* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/07/2013 11:13:56 : pos4 : MCROWE Cross streets: NC HWY 801 S//CEDAR LN Landmark: BERMUDA RUN WEST CLUB HOUSE Geo Comment: BERMUDA RUN WEST NBH: OFF 360 BLOCK NC HWY 801 S Landmark Comment: SEE MORE COMPLETE LIST IN LANDMARK BOOK*
911:Call #130307-7883* Address:146 DR SLATE DR* * * City:MOCKSVILLE* MERONEY ST* Type:HOSPITAL ST* * NBH: OFF 221 MERONEY ST BESIDE DAVIE HOSPITAL* PH#:TEST* Units:TEST* IRA:* 336-751-0897* 12* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/07/2013 10:18:07 : pos1 : SFRYE Landmark: DAVIE COUNTY 911 COMMUNICATIONS Cross streets: MERONEY ST//HOSPITAL ST NBH: OFF 221 MERONEY ST BESIDE DAVIE HOSPITAL*

Contact: Active911
Agency name: Jerusalem Fire Department
Location: Mocksville, NC, United States
Sender: 911@co.davie.nc.us

911:Call #130314-8812* Address:137 DRAUGHN LN* * * City:MOCKSVILLE* WILL BOONE RD* Type:DEADEND* * NBH: OFF 680 WILLBOONE RD* PH#:CVA* Units:STROKE* IRA:REECE DAMON L* 336-998-1047* 21* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/14/2013 20:29:32 : pos2 : TWMYERS ** EMD Case Entry Finished ** Chief Complaint Number: 28 Key Questions: 65 year old, Female, Conscious, Breathing. Stroke (CVA) / Transient Ischemic Attack (TIA). Caller Statement: SIGNS OF STROKE. 03/14/2013 20:29:13 : pos2 : TWMYERS Cross streets: WILL BOONE RD//DEADEND NBH: OFF 680 WILLBOONE RD*
911:Call #130314-8714* Address:176 MCCULLOUGH RD* * * City:MOCKSVILLE* US HWY 601 S* Type:DANIEL RD* * NBH: OFF 1674 US HWY 601 S* PH#:MED* Units:MEDICAL CALL* IRA:MCSWAIM, CATHERINE* 336-751-7421* 21* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/14/2013 04:52:15 : pos1 : TWMYERS Cross streets: US HWY 601 S//DANIEL RD NBH: OFF 1674 US HWY 601 S*
911:Call #130313-8682* Address:1490 DEADMON RD* * * City:MOCKSVILLE* RED FERN LN* Type:MOORE TR* * * PH#:YEL* Units:CARDIAC PROBLEM* IRA:ANGELL LARRY* 336-998-7454* 21* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/13/2013 18:59:41 : pos4 : ABURTON Cross streets: RED FERN LN//MOORE TR Cross streets: NC HWY 801 S//DEADEND NBH: OFF 5636 NC HWY 801 S CINDY SAWYER*
911:Call #130313-8637* Address:1700 US HWY 601 S* * * City:MOCKSVILLE* MCCULLOUGH RD* Type:HINKLE DR* * * PH#:50PI* Units:ACCIDENT/INJURY* IRA:MELINDA CONN* 336-251-3878* 21* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/13/2013 13:51:07 : pos4 : ABURTON Cross streets: MCCULLOUGH RD//HINKLE DR Cross streets: LIBERTY CR//DEADEND NBH: OFF 153 LIBERTY CIR OFF TO 168 GLADSTONE RD BLACK 4DR CAR SITTING IN FIELD WITH FLASHERS ON DOSENT KNOW IF IT WRECKED*
911:Call #130312-8482* Address:132 BECKTOWN RD* * * City:MOCKSVILLE* US HWY 601 S* Type:KENT LN* * Landmark Comment: GATE ACCESS-OPEN RED FIRE BOX - FLIP SWITCH NBH: OFF 3208 US HWY 601 S* PH#:FA* Units:FIRE ALARM* IRA:LPS* 336-284-4443* 21* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/12/2013 15:02:27 : pos4 : JALLGOOD Landmark Comment: GATE ACCESS-OPEN RED FIRE BOX - FLIP SWITCH Landmark: BOXWOOD LODGE Cross streets: US HWY 601 S//KENT LN NBH: OFF 3208 US HWY 601 S*
911:Call #130312-8435* Address:315 PINE RIDGE RD* * * City:MOCKSVILLE* GREEN GRASS RD* Type:MILLER RD* * NBH: OFF 3506 US HWY 601 S* PH#:MED* Units:MEDICAL CALL* IRA:CORRELL HOWARD* 336-284-2198* 21* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/12/2013 06:47:06 : pos4 : JALLGOOD Cross streets: GREEN GRASS RD//MILLER RD NBH: OFF 3506 US HWY 601 S*
911:Call #130311-8362* Address:170 TATUM RD* * * City:MOCKSVILLE* PINE RIDGE RD* Type:DEADEND* * NBH: OFF 448 PINE RIDGE RD* PH#:26D1* Units:SICK PERSON (SPECIFIC DIAGNOSIS)* IRA:ADAMS CAROL* 336-284-2809* 21* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/11/2013 15:10:34 : pos4 : SFRYE ** EMD Recommended Dispatch ** Response Text: Delta Dispatch Level: 26D01 CAD Incident Code: 26D1 Key Questions: Not alert. * 1.She is not completely alert (not responding appropriately). 03/11/2013 15:10:12 : pos4 : SFRYE ** EMD Case Entry Finished ** Chief Complaint Number: 26 Key Questions: 43 year old, Female, Conscious, Breathing. Sick Person (Specific Diagnosis). Caller Statement: sick. 03/11/2013 15:09:42 : pos4 : SFRYE Cross streets: PINE RIDGE RD//DEADEND NBH: OFF 448 PINE RIDGE RD*
911:Call #130310-8221* Address:373 CHERRY HILL RD* * * City:MOCKSVILLE* NC HWY 801 S* Type:BECKTOWN RD* * NBH: OFF 6286 NC HWY 801 S TO 702 BECKTOWN RD* PH#:RD* Units:RESPIRATORY DISTRESS* IRA:BURTON TERRY R & PAM* 336-998-9491* 21* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/10/2013 01:57:15 : pos4 : SFRYE Cross streets: NC HWY 801 S//BECKTOWN RD NBH: OFF 6286 NC HWY 801 S TO 702 BECKTOWN RD*
911:Call #130309-8176* Address:111 CPP GLOBAL DR* * * City:MOCKSVILLE* SALISBURY RD* Type:DEADEND* * Landmark Comment: FORMERLY KAYDON CORP NBH: OFF 1098 SALISBURY RD* PH#:FA* Units:FIRE ALARM* IRA:SEC CENT- 7042* 800-230-6975* 21,22* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/09/2013 17:37:35 : pos2 : MKIRKPATRICK Landmark Comment: FORMERLY KAYDON CORP Landmark: CPP GLOBAL Cross streets: SALISBURY RD//AVGOL DR NBH: OFF 1098 SALISBURY RD*
911:Call #130309-8097* Address:3464 US HWY 601 S* * * City:MOCKSVILLE* BEAN RD* Type:FREESTONE RD* * * PH#:FD* Units:FIRE DRILL* IRA:SANDRA* 336-284-4010* 21* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/09/2013 00:02:50 : pos1 : JALLGOOD ALARM COMPANY CALLED IN 03/09/2013 00:00:08 : pos1 : JALLGOOD Landmark: BOXWOOD GROUP HOME Cross streets: BEAN RD//FREESTONE LN*

Contact: Active911
Agency name: Mocksville Center Fire Department
Location: Mocksville, NC, United States
Sender: 911@co.davie.nc.us

911:Call #130323-9889* Address:266 EDWARDS RD* * * City:MOCKSVILLE* PEACH FARM TR* Type:DEADEND* * NBH: OFF 1550 COUNTY LINE RD OFF 1894 SHEFFIELD RD* PH#:SF* Units:STRUCTURE FIRE* IRA:CHRIS* 336-679-9578* 13,16,18,34* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/23/2013 15:14:36 : pos4 : ABURTON Cross streets: PEACH FARM TR//DEADEND NBH: OFF 1550 COUNTY LINE RD OFF 1894 SHEFFIELD RD Cross streets: DAVIE FARMS TR//WOOD VALE DR MOBILE HOME*
911:Call #130320-9497* Address:2265 US HWY 64 W* * * City:MOCKSVILLE* PARKER RD* Type:SHEFFIELD RD* * * PH#:STBY* Units:STAND BY* IRA:* 336-492-7649* 13* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/20/2013 13:47:24 : pos2 : JALLGOOD Cross streets: PARKER RD//SHEFFIELD RD Landmark: CENTER FIRE DEPT*
911:Call #130317-9178* Address:133 WILLHAVEN DR* * * City:MOCKSVILLE* N MOCKSVILLE CT* Type:BOXWOOD VILLAGE DR* * Landmark Comment: 2 OTHER UNITS @ 121 WILLHAVEN & 109 WILLHAVEN NBH: OFF 163 N MOCKSVILLE CT OFF 846 VALLEY RD* PH#:FA* Units:FIRE ALARM* IRA:BEARDEN, AUSTIN* 336-608-2252* 22,13* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/17/2013 22:59:48 : pos1 : SPHILLIPS Cross streets: N MOCKSVILLE CT//BOXWOOD VILLAGE DR NBH: OFF 163 N MOCKSVILLE CT OFF 846 VALLEY RD Cross streets: N MOCKSVILLE CT//BOXWOOD VILLAGE DR Landmark: ROWAN POINT APARTMENTS NBH: OFF 163 N MOCKSVILLE CT OFF 846 VALLEY RD Landmark Comment: 2 OTHER UNITS @ 121 WILLHAVEN & 109 WILLHAVEN Cross streets: US HWY 601 N//THEODORE DR*
911:Call #130317-9120* Address:300 CAMPGROUND RD* * * City:MOCKSVILLE* MIDWAY DR* Type:DEADEND* * NBH: OFF MIDWAY DR IN IREDELL COUNTY OFF HWY 64 W* PH#:FA* Units:FIRE ALARM* IRA:LPS* 336-766-7698* 13,18* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/17/2013 10:15:42 : pos1 : JALLGOOD Cross streets: MIDWAY DR//DEADEND NBH: OFF MIDWAY DR IN IREDELL COUNTY OFF HWY 64 W HERB BROUDAUF GENERAL*
911:Call #130316-9072* Address:138 CENTER CIR* * * City:MOCKSVILLE* SHEFFIELD RD* Type:US HWY 64 W* * NBH: OFF 164 SHEFFIELD RD TO 2400 HWY 64 W* PH#:YEL* Units:CARDIAC PROBLEM* IRA:SAM FRYE* 336-909-4588* 13* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/16/2013 22:26:46 : pos2 : SSPEER Cross streets: SHEFFIELD RD//US HWY 64 W NBH: OFF 164 SHEFFIELD RD TO 2400 HWY 64 W*
911:Call #130315-8828* Address:2265 US HWY 64 W* * * City:MOCKSVILLE* PARKER RD* Type:SHEFFIELD RD* * * PH#:SF* Units:STRUCTURE FIRE* IRA:* 336-492-7649* 13* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/15/2013 00:53:59 : pos1 : MGORDY Cross streets: PARKER RD//SHEFFIELD RD Landmark: CENTER FIRE DEPT*
911:Call #130314-8749* Address:127 WILLHAVEN DR* * * City:MOCKSVILLE* N MOCKSVILLE CT* Type:BOXWOOD VILLAGE DR* * NBH: OFF 163 N MOCKSVILLE CT OFF 846 VALLEY RD* PH#:FA* Units:FIRE ALARM* IRA:sec central* 800-230-6975* 13,22* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/14/2013 12:50:01 : pos2 : DBLACKBURN Cross streets: N MOCKSVILLE CT//BOXWOOD VILLAGE DR NBH: OFF 163 N MOCKSVILLE CT OFF 846 VALLEY RD fire water flow alarm*
911:Call #130309-8208* Address:1349 US HWY 64 W* * * City:MOCKSVILLE* DARTMOUTH LN* Type:GREENHILL RD* * * PH#:SF* Units:STRUCTURE FIRE* IRA:TERESA GUSSEY* 704-402-9927* 13* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/09/2013 23:02:40 : pos4 : SFRYE Cross streets: DARTMOUTH LN//GREENHILL RD Cross streets: US HWY 601 N//THEODORE DR FG-1 POSSIBLE ELECTRICAL FIRE*
911:Call #130309-8162* Address:166 CENTER CIR* * * City:MOCKSVILLE* SHEFFIELD RD* Type:US HWY 64 W* * NBH: OFF 164 SHEFFIELD RD TO 2400 HWY 64 W* PH#:17B1* Units:FALLS/BACK INJURIES(TRAUMATIC)* IRA:SHAW FELIX H* 336-492-2121* 13* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/09/2013 14:33:15 : pos2 : TJONES ** EMD Recommended Dispatch ** Response Text: Bravo Dispatch Level: 17B01 CAD Incident Code: 17B1 Key Questions: POSSIBLY DANGEROUS body area. * 1.This happened now (less than 6hrs ago). * 2.It's reported that she fell at ground level. * 3.The fall was accidental. * 4.There is no bleeding now. * 5.She is completely alert (responding appropriately). * 6.The injury is to a POSSIBLY DANGEROUS area. * 7.She is no longer on the floor (ground). 03/09/2013 14:32:16 : pos2 : TJONES ** EMD Case Entry Finished ** Chief Complaint Number: 17 Key Questions: 83 year old, Female, Conscious, Breathing. Falls. Caller Statement: FALL. 03/09/2013 14:31:45 : pos4 : JBYERLY Cross streets: SH
911:Call #130307-7878* Address:146 DR SLATE DR* * * City:MOCKSVILLE* NBH: OFF 221 MERONEY ST BESIDE DAVIE HOSPITAL* Type:MI* MISCELLANEOUS* * PH#:336-751-0897* Units:12,13,22* IRA:* Medical: No* Hazards: No* NARR:03/07/2013 09:08:25 : pos1 : SFRYE Landmark: DAVIE COUNTY 911 COMMUNICATIONS Cross streets: MERONEY ST//HOSPITAL ST NBH: OFF 221 MERONEY ST BESIDE DAVIE HOSPITAL THE CAD IS GOING TO BE DOWN AND NO PAGING*

 */

public class NCDavieCountyAParserTest extends BaseParserTest {
  
  public NCDavieCountyAParserTest() {
    setParser(new NCDavieCountyAParser(), "DAVIE COUNTY", "NC");
  }
  
  @Test
  public void testBrentCrotts() {

    doTest("T1",
        "911:Call #130324-9973* Address:629 BEAUCHAMP RD* * * City:ADVANCE* WINDEMERE DR* Type:MEADOWS EDGE DR* * NBH: OFF 4900 BLOCK US HWY 158* PH#:5A1* Units:BACK PAIN",
        "ID:130324-9973",
        "ADDR:629 BEAUCHAMP RD",
        "CITY:ADVANCE",
        "X:WINDEMERE DR & MEADOWS EDGE DR",
        "PLACE:OFF 4900 BLOCK US HWY 158",
        "CODE:5A1",
        "CALL:BACK PAIN");

    doTest("T2",
        "911:Call #130324-9989* Address:191 SPRY LN* * * City:MOCKSVILLE* CORNATZER RD* Type:DEADEND* * * PH#:1A1* Units:ABDOMINAL PAIN/PROBLEMS* IRA:WILMOTH MELISSA LAMB",
        "ID:130324-9989",
        "ADDR:191 SPRY LN",
        "CITY:MOCKSVILLE",
        "X:CORNATZER RD & DEADEND",
        "CODE:1A1",
        "CALL:ABDOMINAL PAIN/PROBLEMS",
        "NAME:WILMOTH MELISSA LAMB");
  
  }
  
  @Test
  public void testAdoubdsd() {

    doTest("T1",
        "911:Call #130307-7878* Address:146 DR SLATE DR* * * City:MOCKSVILLE* NBH: OFF 221 MERONEY ST BESIDE DAVIE HOSPITAL* Type:MI* MISCELLANEOUS* * PH#:336-751-0897* U",
        "ID:130307-7878",
        "ADDR:146 DR SLATE DR",
        "CITY:MOCKSVILLE",
        "PLACE:OFF 221 MERONEY ST BESIDE DAVIE HOSPITAL",
        "CODE:MI",
        "CALL:MISCELLANEOUS",
        "PHONE:336-751-0897");

    doTest("T2",
        "911:Call #130305-7702* Address:156 DUARD REAVIS RD* * * City:MOCKSVILLE* NBH: OFF 795 BEAR CREEK CHURCH* Type:MED* MEDICAL CALL* VERIZON WIRELESS* PH#:336-409-81",
        "ID:130305-7702",
        "ADDR:156 DUARD REAVIS RD",
        "CITY:MOCKSVILLE",
        "PLACE:OFF 795 BEAR CREEK CHURCH",
        "CODE:MED",
        "CALL:MEDICAL CALL",
        "INFO:VERIZON WIRELESS",
        "PHONE:336-409-81");

    doTest("T3",
        "911:Call #130315-8831* Address:197 PEPPERSTONE DR* * * City:MOCKSVILLE* DANNER RD* Type:PEPPERSTONE PL* * NBH: OFF 176 DANNER RD OFF 2469 US HWY 601 N* PH#:UNR*",
        "ID:130315-8831",
        "ADDR:197 PEPPERSTONE DR",
        "CITY:MOCKSVILLE",
        "X:DANNER RD & PEPPERSTONE PL",
        "PLACE:OFF 176 DANNER RD OFF 2469 US HWY 601 N",
        "CODE:UNR");

    doTest("T4",
        "911:Call #130322-9715* Address:301 OLLIE HARKEY RD* * * City:YADKINVILLE* LIBERTY CHURCH RD* Type:AMBER HILL RD* * NBH: OFF 2448 LIBERTY CHURCH RD* PH#:FA* Units",
        "ID:130322-9715",
        "ADDR:301 OLLIE HARKEY RD",
        "CITY:YADKINVILLE",
        "X:LIBERTY CHURCH RD & AMBER HILL RD",
        "PLACE:OFF 2448 LIBERTY CHURCH RD",
        "CODE:FA");

  }
  
  @Test
  public void testAdvanceFireDepartment() {

    doTest("T1",
        "911:Call #130312-8543* Address:117 CUMBERLAND CT* * * City:ADVANCE* COVINGTON DR* Type:DEADEND* * Geo Comment: COVINGTON CREEK DEV NBH: 290 BLOCK COVINGTON DR OFF 2400 BLOCK NC HWY 801 S* PH#:RD* Units:RESPIRATORY DISTRESS* IRA:COLEY BECKY* 336-998-2732* 12* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/12/2013 21:08:18 : pos2 : MCROWE Cross streets: COVINGTON DR//DEADEND Geo Comment: COVINGTON CREEK DEV NBH: 290 BLOCK COVINGTON DR OFF 2400 BLOCK NC HWY 801 S*",
        "ID:130312-8543",
        "ADDR:117 CUMBERLAND CT",
        "CITY:ADVANCE",
        "X:COVINGTON DR & DEADEND",
        "DATE:03/12/2013",
        "TIME:21:08:18",
        "INFO:COVINGTON CREEK DEV / Medical: No / Hazards: No",
        "PLACE:290 BLOCK COVINGTON DR OFF 2400 BLOCK NC HWY 801 S",
        "CODE:RD",
        "CALL:RESPIRATORY DISTRESS",
        "NAME:COLEY BECKY",
        "PHONE:336-998-2732",
        "UNIT:12");

    doTest("T2",
        "911:Call #130311-8376* Address:376 UNDERPASS RD* * * City:ADVANCE* KEN HOOTS LN* Type:BAILEY RD* * NBH: OFF 2000 BLOCK NC HWY 801 S* PH#:50PI* Units:ACCIDENT/INJURY* IRA:VERIZON* 336-817-1952* 12,34* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/11/2013 16:15:27 : pos4 : SFRYE Cross streets: KEN HOOTS LN//BAILEY RD Landmark: PINEY GROVE METHODIST CHURCH NBH: OFF 2000 BLOCK NC HWY 801 S Cross streets: RABBIT FARM TR//ORRELL TR*",
        "ID:130311-8376",
        "ADDR:376 UNDERPASS RD",
        "CITY:ADVANCE",
        "X:KEN HOOTS LN & BAILEY RD",
        "DATE:03/11/2013",
        "TIME:16:15:27",
        "PLACE:PINEY GROVE METHODIST CHURCH OFF 2000 BLOCK NC HWY 801 S",
        "INFO:Medical: No / Hazards: No",
        "CODE:50PI",
        "CALL:ACCIDENT/INJURY",
        "PHONE:336-817-1952",
        "UNIT:12,34");

    doTest("T3",
        "911:Call #130311-8317* Address:1630 NC HWY 801 S* * * City:ADVANCE* PLYLER LN* Type:POTTS RD* * * PH#:MED* Units:MEDICAL CALL* IRA:VERIZON* 336-909-3919* 12* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/11/2013 09:18:15 : pos2 : MCROWE Cross streets: PLYLER LN//POTTS RD Cross streets: RABBIT FARM TR//ORRELL TR*",
        "ID:130311-8317",
        "ADDR:1630 NC HWY 801 S",
        "MADDR:1630 STATE 801 S",
        "CITY:ADVANCE",
        "X:PLYLER LN & POTTS RD",
        "DATE:03/11/2013",
        "TIME:09:18:15",
        "INFO:Medical: No / Hazards: No",
        "CODE:MED",
        "CALL:MEDICAL CALL",
        "PHONE:336-909-3919",
        "UNIT:12");

    doTest("T4",
        "911:Call #130310-8293* Address:308 KLICKITAT TR* * * City:MOCKSVILLE* WORKMANS WA* Type:DEADEND* * NBH: OFF 500 HOWARDTOWN RD* PH#:FA* Units:FIRE ALARM* IRA:SMITH BARBARA D* 336-998-4299* 19,24,12* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/10/2013 21:22:53 : pos1 : TWMYERS Cross streets: WORKMANS WA//DEADEND NBH: OFF 500 HOWARDTOWN RD HER SMOKE ALARM HAS ACTIVATED, NO SMOKE OR FIRE CONDITIONS*",
        "ID:130310-8293",
        "ADDR:308 KLICKITAT TR",
        "CITY:MOCKSVILLE",
        "X:WORKMANS WA & DEADEND",
        "PLACE:OFF 500 HOWARDTOWN RD",
        "DATE:03/10/2013",
        "TIME:21:22:53",
        "INFO:Medical: No / Hazards: No\nHER SMOKE ALARM HAS ACTIVATED, NO SMOKE OR FIRE CONDITIONS",
        "CODE:FA",
        "CALL:FIRE ALARM",
        "NAME:SMITH BARBARA D",
        "PHONE:336-998-4299",
        "UNIT:19,24,12");

    doTest("T5",
        "911:Call #130309-8130* Address:301 GRANADA DR* * * City:ADVANCE* GALADRIM WA* Type:DEADEND* * NBH: OFF 100 BLOCK SONORA DR OFF 300 BLOCK LA QUINTA DR* PH#:MED* Units:MEDICAL CALL* IRA:glen myers* 336-998-3956* 12* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/09/2013 10:09:10 : pos4 : JBYERLY Cross streets: GALADRIM WA//DEADEND NBH: OFF 100 BLOCK SONORA DR OFF 300 BLOCK LA QUINTA DR*",
        "ID:130309-8130",
        "ADDR:301 GRANADA DR",
        "CITY:ADVANCE",
        "X:GALADRIM WA & DEADEND",
        "PLACE:OFF 100 BLOCK SONORA DR OFF 300 BLOCK LA QUINTA DR",
        "DATE:03/09/2013",
        "TIME:10:09:10",
        "INFO:Medical: No / Hazards: No",
        "CODE:MED",
        "CALL:MEDICAL CALL",
        "NAME:glen myers",
        "PHONE:336-998-3956",
        "UNIT:12");

    doTest("T6",
        "911:Call #130308-8086* Address:204 GRANADA DR* * * City:ADVANCE* SONORA DR* Type:SAN CARLOS CT* * NBH: OFF 100 BLOCK SONORA DR OFF 300 BLOCK LA QUINTA DR* PH#:MED* Units:MEDICAL CALL* IRA:katie* 336-998-8325* 12* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/08/2013 21:30:12 : pos2 : DBLACKBURN Cross streets: SONORA DR//SAN CARLOS CT NBH: OFF 100 BLOCK SONORA DR OFF 300 BLOCK LA QUINTA DR*",
        "ID:130308-8086",
        "ADDR:204 GRANADA DR",
        "CITY:ADVANCE",
        "X:SONORA DR & SAN CARLOS CT",
        "DATE:03/08/2013",
        "TIME:21:30:12",
        "INFO:Medical: No / Hazards: No",
        "PLACE:OFF 100 BLOCK SONORA DR OFF 300 BLOCK LA QUINTA DR",
        "CODE:MED",
        "CALL:MEDICAL CALL",
        "NAME:katie",
        "PHONE:336-998-8325",
        "UNIT:12");

    doTest("T7",
        "911:Call #130307-7898* Address:129 ORCHARD PARK DR* * * City:ADVANCE* NC HWY 801 S* Type:CEDAR LN* * Geo Comment: BERMUDA RUN WEST NBH: OFF 360 BLOCK NC HWY 801 S Landmark Comment: SEE MORE COMPLETE LIST IN LANDMARK BOOK* PH#:50PI* Units:ACCIDENT/INJURY* IRA:* 336-998-8001* 12* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/07/2013 11:13:56 : pos4 : MCROWE Cross streets: NC HWY 801 S//CEDAR LN Landmark: BERMUDA RUN WEST CLUB HOUSE Geo Comment: BERMUDA RUN WEST NBH: OFF 360 BLOCK NC HWY 801 S Landmark Comment: SEE MORE COMPLETE LIST IN LANDMARK BOOK*",
        "ID:130307-7898",
        "ADDR:129 ORCHARD PARK DR",
        "CITY:ADVANCE",
        "X:NC HWY 801 S & CEDAR LN",
        "DATE:03/07/2013",
        "TIME:11:13:56",
        "PLACE:BERMUDA RUN WEST CLUB HOUSE OFF 360 BLOCK NC HWY 801 S",
        "INFO:SEE MORE COMPLETE LIST IN LANDMARK BOOK / Medical: No / Hazards: No\nBERMUDA RUN WEST",
        "CODE:50PI",
        "CALL:ACCIDENT/INJURY",
        "PHONE:336-998-8001",
        "UNIT:12");

    doTest("T8",
        "911:Call #130307-7883* Address:146 DR SLATE DR* * * City:MOCKSVILLE* MERONEY ST* Type:HOSPITAL ST* * NBH: OFF 221 MERONEY ST BESIDE DAVIE HOSPITAL* PH#:TEST* Units:TEST* IRA:* 336-751-0897* 12* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/07/2013 10:18:07 : pos1 : SFRYE Landmark: DAVIE COUNTY 911 COMMUNICATIONS Cross streets: MERONEY ST//HOSPITAL ST NBH: OFF 221 MERONEY ST BESIDE DAVIE HOSPITAL*",
        "ID:130307-7883",
        "ADDR:146 DR SLATE DR",
        "CITY:MOCKSVILLE",
        "X:MERONEY ST & HOSPITAL ST",
        "DATE:03/07/2013",
        "TIME:10:18:07",
        "PLACE:DAVIE COUNTY 911 COMMUNICATIONS OFF 221 MERONEY ST BESIDE DAVIE HOSPITAL",
        "INFO:Medical: No / Hazards: No",
        "CODE:TEST",
        "CALL:TEST",
        "PHONE:336-751-0897",
        "UNIT:12");
   
  }
  
  @Test
  public void testJerusulemFireDepartment() {

    doTest("T1",
        "911:Call #130314-8812* Address:137 DRAUGHN LN* * * City:MOCKSVILLE* WILL BOONE RD* Type:DEADEND* * NBH: OFF 680 WILLBOONE RD* PH#:CVA* Units:STROKE* IRA:REECE DAMON L* 336-998-1047* 21* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/14/2013 20:29:32 : pos2 : TWMYERS ** EMD Case Entry Finished ** Chief Complaint Number: 28 Key Questions: 65 year old, Female, Conscious, Breathing. Stroke (CVA) / Transient Ischemic Attack (TIA). Caller Statement: SIGNS OF STROKE. 03/14/2013 20:29:13 : pos2 : TWMYERS Cross streets: WILL BOONE RD//DEADEND NBH: OFF 680 WILLBOONE RD*",
        "ID:130314-8812",
        "ADDR:137 DRAUGHN LN",
        "CITY:MOCKSVILLE",
        "X:WILL BOONE RD & DEADEND",
        "DATE:03/14/2013",
        "TIME:20:29:32",
        "INFO:Medical: No / Hazards: No\nChief Complaint Number: 28 / 65 year old, Female, Conscious, Breathing. Stroke (CVA) / Transient Ischemic Attack (TIA). Caller Statement: SIGNS OF STROKE.",
        "PLACE:OFF 680 WILLBOONE RD",
        "CODE:CVA",
        "CALL:STROKE",
        "NAME:REECE DAMON L",
        "PHONE:336-998-1047",
        "UNIT:21");

    doTest("T2",
        "911:Call #130314-8714* Address:176 MCCULLOUGH RD* * * City:MOCKSVILLE* US HWY 601 S* Type:DANIEL RD* * NBH: OFF 1674 US HWY 601 S* PH#:MED* Units:MEDICAL CALL* IRA:MCSWAIM, CATHERINE* 336-751-7421* 21* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/14/2013 04:52:15 : pos1 : TWMYERS Cross streets: US HWY 601 S//DANIEL RD NBH: OFF 1674 US HWY 601 S*",
        "ID:130314-8714",
        "ADDR:176 MCCULLOUGH RD",
        "CITY:MOCKSVILLE",
        "X:US HWY 601 S & DANIEL RD",
        "DATE:03/14/2013",
        "TIME:04:52:15",
        "INFO:Medical: No / Hazards: No",
        "PLACE:OFF 1674 US HWY 601 S",
        "CODE:MED",
        "CALL:MEDICAL CALL",
        "NAME:MCSWAIM, CATHERINE",
        "PHONE:336-751-7421",
        "UNIT:21");

    doTest("T3",
        "911:Call #130313-8682* Address:1490 DEADMON RD* * * City:MOCKSVILLE* RED FERN LN* Type:MOORE TR* * * PH#:YEL* Units:CARDIAC PROBLEM* IRA:ANGELL LARRY* 336-998-7454* 21* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/13/2013 18:59:41 : pos4 : ABURTON Cross streets: RED FERN LN//MOORE TR Cross streets: NC HWY 801 S//DEADEND NBH: OFF 5636 NC HWY 801 S CINDY SAWYER*",
        "ID:130313-8682",
        "ADDR:1490 DEADMON RD",
        "CITY:MOCKSVILLE",
        "X:RED FERN LN & MOORE TR",
        "DATE:03/13/2013",
        "TIME:18:59:41",
        "INFO:Medical: No / Hazards: No\nNBH: OFF 5636 NC HWY 801 S CINDY SAWYER",
        "CODE:YEL",
        "CALL:CARDIAC PROBLEM",
        "NAME:ANGELL LARRY",
        "PHONE:336-998-7454",
        "UNIT:21");

    doTest("T4",
        "911:Call #130313-8637* Address:1700 US HWY 601 S* * * City:MOCKSVILLE* MCCULLOUGH RD* Type:HINKLE DR* * * PH#:50PI* Units:ACCIDENT/INJURY* IRA:MELINDA CONN* 336-251-3878* 21* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/13/2013 13:51:07 : pos4 : ABURTON Cross streets: MCCULLOUGH RD//HINKLE DR Cross streets: LIBERTY CR//DEADEND NBH: OFF 153 LIBERTY CIR OFF TO 168 GLADSTONE RD BLACK 4DR CAR SITTING IN FIELD WITH FLASHERS ON DOSENT KNOW IF IT WRECKED*",
        "ID:130313-8637",
        "ADDR:1700 US HWY 601 S",
        "MADDR:1700 US 601 S",
        "CITY:MOCKSVILLE",
        "X:MCCULLOUGH RD & HINKLE DR",
        "DATE:03/13/2013",
        "TIME:13:51:07",
        "INFO:Medical: No / Hazards: No\nNBH: OFF 153 LIBERTY CIR OFF TO 168 GLADSTONE RD BLACK 4DR CAR SITTING IN FIELD WITH FLASHERS ON DOSENT KNOW IF IT WRECKED",
        "CODE:50PI",
        "CALL:ACCIDENT/INJURY",
        "NAME:MELINDA CONN",
        "PHONE:336-251-3878",
        "UNIT:21");

    doTest("T5",
        "911:Call #130312-8482* Address:132 BECKTOWN RD* * * City:MOCKSVILLE* US HWY 601 S* Type:KENT LN* * Landmark Comment: GATE ACCESS-OPEN RED FIRE BOX - FLIP SWITCH NBH: OFF 3208 US HWY 601 S* PH#:FA* Units:FIRE ALARM* IRA:LPS* 336-284-4443* 21* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/12/2013 15:02:27 : pos4 : JALLGOOD Landmark Comment: GATE ACCESS-OPEN RED FIRE BOX - FLIP SWITCH Landmark: BOXWOOD LODGE Cross streets: US HWY 601 S//KENT LN NBH: OFF 3208 US HWY 601 S*",
        "ID:130312-8482",
        "ADDR:132 BECKTOWN RD",
        "CITY:MOCKSVILLE",
        "X:US HWY 601 S & KENT LN",
        "DATE:03/12/2013",
        "TIME:15:02:27",
        "PLACE:BOXWOOD LODGE OFF 3208 US HWY 601 S",
        "INFO:GATE ACCESS-OPEN RED FIRE BOX - FLIP SWITCH / Medical: No / Hazards: No",
        "CODE:FA",
        "CALL:FIRE ALARM",
        "NAME:LPS",
        "PHONE:336-284-4443",
        "UNIT:21");

    doTest("T6",
        "911:Call #130312-8435* Address:315 PINE RIDGE RD* * * City:MOCKSVILLE* GREEN GRASS RD* Type:MILLER RD* * NBH: OFF 3506 US HWY 601 S* PH#:MED* Units:MEDICAL CALL* IRA:CORRELL HOWARD* 336-284-2198* 21* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/12/2013 06:47:06 : pos4 : JALLGOOD Cross streets: GREEN GRASS RD//MILLER RD NBH: OFF 3506 US HWY 601 S*",
        "ID:130312-8435",
        "ADDR:315 PINE RIDGE RD",
        "CITY:MOCKSVILLE",
        "X:GREEN GRASS RD & MILLER RD",
        "DATE:03/12/2013",
        "TIME:06:47:06",
        "INFO:Medical: No / Hazards: No",
        "PLACE:OFF 3506 US HWY 601 S",
        "CODE:MED",
        "CALL:MEDICAL CALL",
        "NAME:CORRELL HOWARD",
        "PHONE:336-284-2198",
        "UNIT:21");

    doTest("T7",
        "911:Call #130311-8362* Address:170 TATUM RD* * * City:MOCKSVILLE* PINE RIDGE RD* Type:DEADEND* * NBH: OFF 448 PINE RIDGE RD* PH#:26D1* Units:SICK PERSON (SPECIFIC DIAGNOSIS)* IRA:ADAMS CAROL* 336-284-2809* 21* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/11/2013 15:10:34 : pos4 : SFRYE ** EMD Recommended Dispatch ** Response Text: Delta Dispatch Level: 26D01 CAD Incident Code: 26D1 Key Questions: Not alert. * 1.She is not completely alert (not responding appropriately). 03/11/2013 15:10:12 : pos4 : SFRYE ** EMD Case Entry Finished ** Chief Complaint Number: 26 Key Questions: 43 year old, Female, Conscious, Breathing. Sick Person (Specific Diagnosis). Caller Statement: sick. 03/11/2013 15:09:42 : pos4 : SFRYE Cross streets: PINE RIDGE RD//DEADEND NBH: OFF 448 PINE RIDGE RD*",
        "ID:130311-8362",
        "ADDR:170 TATUM RD",
        "CITY:MOCKSVILLE",
        "X:PINE RIDGE RD & DEADEND",
        "DATE:03/11/2013",
        "TIME:15:10:12",
        "INFO:Medical: No / Hazards: No\nDelta Dispatch Level: 26D01 CAD Incident Code: 26D1 / Not alert.\n1.She is not completely alert (not responding appropriately).\nChief Complaint Number: 26 / 43 year old, Female, Conscious, Breathing. Sick Person (Specific Diagnosis). Caller Statement: sick.",
        "PLACE:OFF 448 PINE RIDGE RD",
        "CODE:26D1",
        "CALL:SICK PERSON (SPECIFIC DIAGNOSIS)",
        "NAME:ADAMS CAROL",
        "PHONE:336-284-2809",
        "UNIT:21");

    doTest("T8",
        "911:Call #130310-8221* Address:373 CHERRY HILL RD* * * City:MOCKSVILLE* NC HWY 801 S* Type:BECKTOWN RD* * NBH: OFF 6286 NC HWY 801 S TO 702 BECKTOWN RD* PH#:RD* Units:RESPIRATORY DISTRESS* IRA:BURTON TERRY R & PAM* 336-998-9491* 21* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/10/2013 01:57:15 : pos4 : SFRYE Cross streets: NC HWY 801 S//BECKTOWN RD NBH: OFF 6286 NC HWY 801 S TO 702 BECKTOWN RD*",
        "ID:130310-8221",
        "ADDR:373 CHERRY HILL RD",
        "CITY:MOCKSVILLE",
        "X:NC HWY 801 S & BECKTOWN RD",
        "DATE:03/10/2013",
        "TIME:01:57:15",
        "INFO:Medical: No / Hazards: No",
        "PLACE:OFF 6286 NC HWY 801 S TO 702 BECKTOWN RD",
        "CODE:RD",
        "CALL:RESPIRATORY DISTRESS",
        "NAME:BURTON TERRY R & PAM",
        "PHONE:336-998-9491",
        "UNIT:21");

    doTest("T9",
        "911:Call #130309-8176* Address:111 CPP GLOBAL DR* * * City:MOCKSVILLE* SALISBURY RD* Type:DEADEND* * Landmark Comment: FORMERLY KAYDON CORP NBH: OFF 1098 SALISBURY RD* PH#:FA* Units:FIRE ALARM* IRA:SEC CENT- 7042* 800-230-6975* 21,22* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/09/2013 17:37:35 : pos2 : MKIRKPATRICK Landmark Comment: FORMERLY KAYDON CORP Landmark: CPP GLOBAL Cross streets: SALISBURY RD//AVGOL DR NBH: OFF 1098 SALISBURY RD*",
        "ID:130309-8176",
        "ADDR:111 CPP GLOBAL DR",   // Still Kaydon Drive to Google
        "CITY:MOCKSVILLE",
        "X:SALISBURY RD & DEADEND",
        "DATE:03/09/2013",
        "TIME:17:37:35",
        "PLACE:CPP GLOBAL OFF 1098 SALISBURY RD",
        "INFO:FORMERLY KAYDON CORP / Medical: No / Hazards: No",
        "CODE:FA",
        "CALL:FIRE ALARM",
        "NAME:SEC CENT- 7042",
        "PHONE:800-230-6975",
        "UNIT:21,22");

    doTest("T10",
        "911:Call #130309-8097* Address:3464 US HWY 601 S* * * City:MOCKSVILLE* BEAN RD* Type:FREESTONE RD* * * PH#:FD* Units:FIRE DRILL* IRA:SANDRA* 336-284-4010* 21* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/09/2013 00:02:50 : pos1 : JALLGOOD ALARM COMPANY CALLED IN 03/09/2013 00:00:08 : pos1 : JALLGOOD Landmark: BOXWOOD GROUP HOME Cross streets: BEAN RD//FREESTONE LN*",
        "ID:130309-8097",
        "ADDR:3464 US HWY 601 S",
        "MADDR:3464 US 601 S",
        "CITY:MOCKSVILLE",
        "X:BEAN RD & FREESTONE RD",
        "DATE:03/09/2013",
        "TIME:00:02:50",
        "PLACE:BOXWOOD GROUP HOME",
        "INFO:Medical: No / Hazards: No\nALARM COMPANY CALLED IN",
        "CODE:FD",
        "CALL:FIRE DRILL",
        "NAME:SANDRA",
        "PHONE:336-284-4010",
        "UNIT:21");

  }
  
  @Test
  public void testMocksvilleCenterFire() {

    doTest("T1",
        "911:Call #130323-9889* Address:266 EDWARDS RD* * * City:MOCKSVILLE* PEACH FARM TR* Type:DEADEND* * NBH: OFF 1550 COUNTY LINE RD OFF 1894 SHEFFIELD RD* PH#:SF* Units:STRUCTURE FIRE* IRA:CHRIS* 336-679-9578* 13,16,18,34* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/23/2013 15:14:36 : pos4 : ABURTON Cross streets: PEACH FARM TR//DEADEND NBH: OFF 1550 COUNTY LINE RD OFF 1894 SHEFFIELD RD Cross streets: DAVIE FARMS TR//WOOD VALE DR MOBILE HOME*",
        "ID:130323-9889",
        "ADDR:266 EDWARDS RD",
        "CITY:MOCKSVILLE",
        "X:PEACH FARM TR & DEADEND",
        "DATE:03/23/2013",
        "TIME:15:14:36",
        "INFO:Medical: No / Hazards: No\nMOBILE HOME",
        "PLACE:OFF 1550 COUNTY LINE RD OFF 1894 SHEFFIELD RD",
        "CODE:SF",
        "CALL:STRUCTURE FIRE",
        "NAME:CHRIS",
        "PHONE:336-679-9578",
        "UNIT:13,16,18,34");

    doTest("T2",
        "911:Call #130320-9497* Address:2265 US HWY 64 W* * * City:MOCKSVILLE* PARKER RD* Type:SHEFFIELD RD* * * PH#:STBY* Units:STAND BY* IRA:* 336-492-7649* 13* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/20/2013 13:47:24 : pos2 : JALLGOOD Cross streets: PARKER RD//SHEFFIELD RD Landmark: CENTER FIRE DEPT*",
        "ID:130320-9497",
        "ADDR:2265 US HWY 64 W",
        "MADDR:2265 US 64 W",
        "CITY:MOCKSVILLE",
        "X:PARKER RD & SHEFFIELD RD",
        "DATE:03/20/2013",
        "TIME:13:47:24",
        "PLACE:CENTER FIRE DEPT",
        "INFO:Medical: No / Hazards: No",
        "CODE:STBY",
        "CALL:STAND BY",
        "PHONE:336-492-7649",
        "UNIT:13");

    doTest("T3",
        "911:Call #130317-9178* Address:133 WILLHAVEN DR* * * City:MOCKSVILLE* N MOCKSVILLE CT* Type:BOXWOOD VILLAGE DR* * Landmark Comment: 2 OTHER UNITS @ 121 WILLHAVEN & 109 WILLHAVEN NBH: OFF 163 N MOCKSVILLE CT OFF 846 VALLEY RD* PH#:FA* Units:FIRE ALARM* IRA:BEARDEN, AUSTIN* 336-608-2252* 22,13* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/17/2013 22:59:48 : pos1 : SPHILLIPS Cross streets: N MOCKSVILLE CT//BOXWOOD VILLAGE DR NBH: OFF 163 N MOCKSVILLE CT OFF 846 VALLEY RD Cross streets: N MOCKSVILLE CT//BOXWOOD VILLAGE DR Landmark: ROWAN POINT APARTMENTS NBH: OFF 163 N MOCKSVILLE CT OFF 846 VALLEY RD Landmark Comment: 2 OTHER UNITS @ 121 WILLHAVEN & 109 WILLHAVEN Cross streets: US HWY 601 N//THEODORE DR*",
        "ID:130317-9178",
        "ADDR:133 WILLHAVEN DR",
        "CITY:MOCKSVILLE",
        "X:N MOCKSVILLE CT & BOXWOOD VILLAGE DR",
        "DATE:03/17/2013",
        "TIME:22:59:48",
        "PLACE:ROWAN POINT APARTMENTS OFF 163 N MOCKSVILLE CT OFF 846 VALLEY RD",
        "INFO:2 OTHER UNITS @ 121 WILLHAVEN & 109 WILLHAVEN / Medical: No / Hazards: No",
        "CODE:FA",
        "CALL:FIRE ALARM",
        "NAME:BEARDEN, AUSTIN",
        "PHONE:336-608-2252",
        "UNIT:22,13");

    doTest("T4",
        "911:Call #130317-9120* Address:300 CAMPGROUND RD* * * City:MOCKSVILLE* MIDWAY DR* Type:DEADEND* * NBH: OFF MIDWAY DR IN IREDELL COUNTY OFF HWY 64 W* PH#:FA* Units:FIRE ALARM* IRA:LPS* 336-766-7698* 13,18* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/17/2013 10:15:42 : pos1 : JALLGOOD Cross streets: MIDWAY DR//DEADEND NBH: OFF MIDWAY DR IN IREDELL COUNTY OFF HWY 64 W HERB BROUDAUF GENERAL*",
        "ID:130317-9120",
        "ADDR:300 CAMPGROUND RD",
        "CITY:MOCKSVILLE",
        "X:MIDWAY DR & DEADEND",
        "DATE:03/17/2013",
        "TIME:10:15:42",
        "INFO:Medical: No / Hazards: No\nHERB BROUDAUF GENERAL",
        "PLACE:OFF MIDWAY DR IN IREDELL COUNTY OFF HWY 64 W",
        "CODE:FA",
        "CALL:FIRE ALARM",
        "NAME:LPS",
        "PHONE:336-766-7698",
        "UNIT:13,18");

    doTest("T5",
        "911:Call #130316-9072* Address:138 CENTER CIR* * * City:MOCKSVILLE* SHEFFIELD RD* Type:US HWY 64 W* * NBH: OFF 164 SHEFFIELD RD TO 2400 HWY 64 W* PH#:YEL* Units:CARDIAC PROBLEM* IRA:SAM FRYE* 336-909-4588* 13* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/16/2013 22:26:46 : pos2 : SSPEER Cross streets: SHEFFIELD RD//US HWY 64 W NBH: OFF 164 SHEFFIELD RD TO 2400 HWY 64 W*",
        "ID:130316-9072",
        "ADDR:138 CENTER CIR",
        "CITY:MOCKSVILLE",
        "X:SHEFFIELD RD & US HWY 64 W",
        "DATE:03/16/2013",
        "TIME:22:26:46",
        "INFO:Medical: No / Hazards: No",
        "PLACE:OFF 164 SHEFFIELD RD TO 2400 HWY 64 W",
        "CODE:YEL",
        "CALL:CARDIAC PROBLEM",
        "NAME:SAM FRYE",
        "PHONE:336-909-4588",
        "UNIT:13");

    doTest("T6",
        "911:Call #130315-8828* Address:2265 US HWY 64 W* * * City:MOCKSVILLE* PARKER RD* Type:SHEFFIELD RD* * * PH#:SF* Units:STRUCTURE FIRE* IRA:* 336-492-7649* 13* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/15/2013 00:53:59 : pos1 : MGORDY Cross streets: PARKER RD//SHEFFIELD RD Landmark: CENTER FIRE DEPT*",
        "ID:130315-8828",
        "ADDR:2265 US HWY 64 W",
        "MADDR:2265 US 64 W",
        "CITY:MOCKSVILLE",
        "X:PARKER RD & SHEFFIELD RD",
        "DATE:03/15/2013",
        "TIME:00:53:59",
        "PLACE:CENTER FIRE DEPT",
        "INFO:Medical: No / Hazards: No",
        "CODE:SF",
        "CALL:STRUCTURE FIRE",
        "PHONE:336-492-7649",
        "UNIT:13");

    doTest("T7",
        "911:Call #130314-8749* Address:127 WILLHAVEN DR* * * City:MOCKSVILLE* N MOCKSVILLE CT* Type:BOXWOOD VILLAGE DR* * NBH: OFF 163 N MOCKSVILLE CT OFF 846 VALLEY RD* PH#:FA* Units:FIRE ALARM* IRA:sec central* 800-230-6975* 13,22* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/14/2013 12:50:01 : pos2 : DBLACKBURN Cross streets: N MOCKSVILLE CT//BOXWOOD VILLAGE DR NBH: OFF 163 N MOCKSVILLE CT OFF 846 VALLEY RD fire water flow alarm*",
        "ID:130314-8749",
        "ADDR:127 WILLHAVEN DR",
        "CITY:MOCKSVILLE",
        "X:N MOCKSVILLE CT & BOXWOOD VILLAGE DR",
        "DATE:03/14/2013",
        "TIME:12:50:01",
        "INFO:Medical: No / Hazards: No\nfire water flow alarm",
        "PLACE:OFF 163 N MOCKSVILLE CT OFF 846 VALLEY RD",
        "CODE:FA",
        "CALL:FIRE ALARM",
        "NAME:sec central",
        "PHONE:800-230-6975",
        "UNIT:13,22");

    doTest("T8",
        "911:Call #130309-8208* Address:1349 US HWY 64 W* * * City:MOCKSVILLE* DARTMOUTH LN* Type:GREENHILL RD* * * PH#:SF* Units:STRUCTURE FIRE* IRA:TERESA GUSSEY* 704-402-9927* 13* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/09/2013 23:02:40 : pos4 : SFRYE Cross streets: DARTMOUTH LN//GREENHILL RD Cross streets: US HWY 601 N//THEODORE DR FG-1 POSSIBLE ELECTRICAL FIRE*",
        "ID:130309-8208",
        "ADDR:1349 US HWY 64 W",
        "MADDR:1349 US 64 W",
        "CITY:MOCKSVILLE",
        "X:DARTMOUTH LN & GREENHILL RD",
        "DATE:03/09/2013",
        "TIME:23:02:40",
        "INFO:Medical: No / Hazards: No\nFG-1 POSSIBLE ELECTRICAL FIRE",
        "CODE:SF",
        "CALL:STRUCTURE FIRE",
        "NAME:TERESA GUSSEY",
        "PHONE:704-402-9927",
        "UNIT:13");

    doTest("T9",
        "911:Call #130309-8162* Address:166 CENTER CIR* * * City:MOCKSVILLE* SHEFFIELD RD* Type:US HWY 64 W* * NBH: OFF 164 SHEFFIELD RD TO 2400 HWY 64 W* PH#:17B1* Units:FALLS/BACK INJURIES(TRAUMATIC)* IRA:SHAW FELIX H* 336-492-2121* 13* NARR:* Line16=Medical: No* Line17=Hazards: No* Line18=03/09/2013 14:33:15 : pos2 : TJONES ** EMD Recommended Dispatch ** Response Text: Bravo Dispatch Level: 17B01 CAD Incident Code: 17B1 Key Questions: POSSIBLY DANGEROUS body area. * 1.This happened now (less than 6hrs ago). * 2.It's reported that she fell at ground level. * 3.The fall was accidental. * 4.There is no bleeding now. * 5.She is completely alert (responding appropriately). * 6.The injury is to a POSSIBLY DANGEROUS area. * 7.She is no longer on the floor (ground). 03/09/2013 14:32:16 : pos2 : TJONES ** EMD Case Entry Finished ** Chief Complaint Number: 17 Key Questions: 83 year old, Female, Conscious, Breathing. Falls. Caller Statement: FALL. 03/09/2013 14:31:45 : pos4 : JBYERLY Cross streets: SH",
        "ID:130309-8162",
        "ADDR:166 CENTER CIR",
        "CITY:MOCKSVILLE",
        "X:SHEFFIELD RD & US HWY 64 W",
        "DATE:03/09/2013",
        "TIME:14:32:16",
        "INFO:Medical: No / Hazards: No\nBravo Dispatch Level: 17B01 CAD Incident Code: 17B1 / POSSIBLY DANGEROUS body area. / 1.This happened now (less than 6hrs ago). / 2.It's reported that she fell at ground level. / 3.The fall was accidental. / 4.There is no bleeding now. / 5.She is completely alert (responding appropriately). / 6.The injury is to a POSSIBLY DANGEROUS area.\n7.She is no longer on the floor (ground).\nChief Complaint Number: 17 / 83 year old, Female, Conscious, Breathing. Falls. Caller Statement: FALL.",
        "CODE:17B1",
        "CALL:FALLS/BACK INJURIES(TRAUMATIC)",
        "PLACE:OFF 164 SHEFFIELD RD TO 2400 HWY 64 W",
        "NAME:SHAW FELIX H",
        "PHONE:336-492-2121",
        "UNIT:13");

    doTest("T10",
        "911:Call #130307-7878* Address:146 DR SLATE DR* * * City:MOCKSVILLE* NBH: OFF 221 MERONEY ST BESIDE DAVIE HOSPITAL* Type:MI* MISCELLANEOUS* * PH#:336-751-0897* Units:12,13,22* IRA:* Medical: No* Hazards: No* NARR:03/07/2013 09:08:25 : pos1 : SFRYE Landmark: DAVIE COUNTY 911 COMMUNICATIONS Cross streets: MERONEY ST//HOSPITAL ST NBH: OFF 221 MERONEY ST BESIDE DAVIE HOSPITAL THE CAD IS GOING TO BE DOWN AND NO PAGING*",
        "ID:130307-7878",
        "ADDR:146 DR SLATE DR",
        "CITY:MOCKSVILLE",
        "INFO:IRA: / Medical: No / Hazards: No\nTHE CAD IS GOING TO BE DOWN AND NO PAGING",
        "CODE:MI",
        "CALL:MISCELLANEOUS",
        "PHONE:336-751-0897",
        "UNIT:12,13,22",
        "DATE:03/07/2013",
        "TIME:09:08:25",
        "X:MERONEY ST / HOSPITAL ST",
        "PLACE:DAVIE COUNTY 911 COMMUNICATIONS OFF 221 MERONEY ST BESIDE DAVIE HOSPITAL");
    
  }
  

  public static void main(String[] args) {
    new NCDavieCountyAParserTest().generateTests("T1");
  }
}
