package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Prince William County
Contact: Judi Miller <jmiller@srxa.com>
Sender: PWRSAN
1 of 3\nFRM:PWRSAN\nMSG:Trauma Flyout  \nInc. Address: 13909 Smoketown Rd  \nBox Number: 2090  \nRadio Channel: 5C  \nCommand: E510  \nLanding\n(Con't) 2 of 3\nZone: Golansky BLVD./ Noble Pond Way  \nComments: Units on the scene requesting a helicopter for a 6 year old with head a injury. \n(Con't) 3 of 3\nMedstar 2 is in route with a 10 min ETA.i(End)

Contact: Active911
Agency name: Nokesville Vol. Fire Rescue Location: Bristow, VA 
Sender: @rsan.pwcgov.org>

(Flyout) (Trauma) Flyout  \nInc. Address: 18903 Miata Ln  \nBox Number: 0329  \nRadio Channel: 5C  \nCommand: N/A  \nLanding Zone: 3615 Lions Field Rd. Triangle ES  \nComments: Injuries to a pediatric from a fall. Life Evac 2 with E503B on 5C for ground contact.\n\nSent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n--\n\n- update your account at https://rsan1.rsan.pwcgov.org
(Flyout) (Trauma) Flyout  \nInc. Address: I-95 North 156 MM  \nBox Number: 2382  \nRadio Channel: 5D  \nCommand: N/A  \nLanding Zone: I-95 North 156 MM  \nComments: ALS injuries for adult male. E520 is ground contact for Med Star 2 on 5D.\n\nSent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n--\n\n- update your account at https://rsan1.rsan.pwcgov.org
(Flyout) (Trauma) Flyout  \nInc. Address: 9427 Taney Rd  \nBox Number: 8126   \nRadio Channel: 5C  \nCommand: N/A  \nLanding Zone: 9005 Tudor Rd - Osborn HS  \nComments: Adult with injuries from an assault. E501B is ground contact for Air Care 1 on 5C.\n\nSent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n--\n\n- update your account at https://rsan1.rsan.pwcgov.org
(Flyout - I-66) (Trauma) Flyout  \nInc. Address: I-66 W 43.9 MM  \nBox Number: 1187  \nRadio Channel: 5C   \nCommand: BC501 I-66 CMD  \nLanding Zone: I-66 W   \nComments: Medivac for injuries from an MVA. E524 is ground contact for Air Care 2 on 5C.\n\nSent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n--\n\n- update your account at https://rsan1.rsan.pwcgov.org
(Flyout - Dale Blvd) (Trauma) Flyout  \nInc. Address: 4719 Kellog Dr.   \nBox Number: 1311  \nRadio Channel: 5D  \nCommand: N/A  \nLanding Zone: 4901 Dale Blvd - Beville MS  \nComments: Medivac for adult from injuries from a fall. E518 is ground contact for Air Care 2 on 5D\n\nSent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n--\n\n- update your account at https://rsan1.rsan.pwcgov.org
(Flyout - McGrath Rd) (Trauma) Flyout  \nInc. Address: 8498 McGrath Rd  \nBox Number: 0701  \nRadio Channel: 5C  \nCommand: N/A  \nLanding Zone: 10628 Dumfries Rd - National Guard Armory  \nComments: Medivac for adult trauma pt. E507 is ground contact for Life Evac 2 on 5C.\n\nSent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n--\n\n- update your account at https://rsan1.rsan.pwcgov.org
(Flyout Box 0243) Trauma Flyout  \nInc. Address: 12836 Tumbling Brook Lane  \nBox Number: 0243  \nRadio Channel: 5C  \nCommand: E514  \nLanding Zone: Woodbridge HS  \nComments: Units on scene of patient who fell down some steps and struck head on concrete.  Requested helicopter.  HMS-2 enroute to LZ.\n\nSent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n--\n\n- update your account at https://rsan1.rsan.pwcgov.org
(Flyout Box 1492) (Trauma) Flyout  \nInc. Address: 3001 Old Bridge Road  \nBox Number: 1492  \nRadio Channel: 5C  \nCommand: E514  \nLanding Zone: Woodbridge High School 3001 Old Bridge Road  \nComments: Infant fell and is in/out of cons. E514 ground contact. Medstar 2 responding with a 8 minute ETA\n\nSent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n--\n\n- update your account at https://rsan1.rsan.pwcgov.org
(Flyout Box 1122) (Trauma) Flyout  \nInc. Address: 8005 Sudley Road  \nBox Number: 1122  \nRadio Channel: 5C  \nCommand: AC511  \nLanding Zone: Sinclair Elem. 7801 Garner Dr  \nComments: Injuries from an auto accident (Vehicle into a building)Aircare 1 responding with a 13 minute ETA\n\nSent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n--\n\n- update your account at https://rsan1.rsan.pwcgov.org
(Flyout Box 0707) Trauma Flyout  \nInc. Address: Prince William Parkway / Brentsville Rd.  \nBox Number: 0707  \nRadio Channel: 5C  \nCommand: BC504Z (Jordan)  \nLanding Zone: Bennett Elememtary 8800 Old Dominion Dr.  \nComments: Units on scene of ACCX requesting helicopter.  HAC-1 on scene.\n\nSent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n--\n\n- update your account at https://rsan1.rsan.pwcgov.org
(Flyout - Box 0707) (Medical/Trauma) Flyout  \nInc. Address: Prince Wm Pkway/Brentsville Rd  \nBox Number: 0707  \nRadio Channel: 5C  \nCommand: BC504Z (Jordan)  \nLanding Zone: Bennett ES @8800 Old Dominion Dr  \nComments: 1 Pt CPR in progress, 1 being extr. Total 3 pts.\n\nSent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n--\n\n- update your account at https://rsan1.rsan.pwcgov.org

(Working Incident) Event Type: Structure Fire Townhouse  \nInc. Address: 14357 Newbern Lp.   \nBox Number: 0402  \nRadio Channel: 5C  \nCommand: BC501 Newbern CMD  \nComments: Units arrived nothing showing mid unit townhouse. T5504  reports fire in the basement.\n\nSent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n--\n\n- update your account at https://rsan1.rsan.pwcgov.org
(Working Incident) Event Type: HOUSE  \nInc. Address: 14440 COLONY CREEK CT  \nBox Number: 1749  \nRadio Channel: 5C  \nCommand: BC502 (BC LITTLE)  \nComments: E517 ON SCENE WITH SMOKE SHOWING FROM SIDE A,C,D AND FROM THE ROOF//ALL OCCUPANTS ARE OUT OF THE BUILDING//STRETCHING A LINE TO SIDE B TO ACCESS THE BASEMENT\n\nSent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n--\n\n- update your account at https://rsan1.rsan.pwcgov.org
(Working Incident (Update)) Event Type: HOUSE  \nInc. Address: 14440 COLONY CREEK CT  \nBox Number: 1749  \nRadio Channel: 5C//5D  \nCommand: BC502 (BC LITTLE)  \nComments: FIRE IS KNOCKED DOWN//CHECKING FOR EXTENSION//AND MOPPING UP\n\nSent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n--\n\n- update your account at https://rsan1.rsan.pwcgov.org
(Working Incident) Event Type: HOUSE  \nInc. Address: STEPPING STONE DR  \nBox Number: 2427  \nRadio Channel: 5C  \nCommand: CAPT SMITH (E524)  \nComments: UNITS ON SCENE WITH A STRUCTURE FULLY INVOLVED\n\nSent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n--\n\n- update your account at https://rsan1.rsan.pwcgov.org
(Working Incident (Update)) Event Type: HOUSE  \nInc. Address: 6100 JAMES MADISON (CORRECTED ADDRESS)  \nBox Number: 2427  \nRadio Channel: 5C  \nCommand:  \nComments: FIRE IS KNOCKED DOWN//FM523 IS ENROUTE//E524,E515,E504,T504 REMAINING ON SCENE FOR OVERHAUL FOR APPROX 1 HOUR  \n  \nE505 FILLING FS524\n\nSent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n--\n\n- update your account at https://rsan1.rsan.pwcgov.org
(Working Incident Box 2437) Event Type: House Fire  \nInc. Address: 7315 James Madison Highway  \nBox Number: 2437  \nRadio Channel: 5C  \nCommand: E524  \nComments: E524 on the scene with smoke showing from the roof of a single family house.  \nUFRO Klimtzak\n\nSent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n--\n\n- update your account at https://rsan1.rsan.pwcgov.org
(Working Incident Box 8170) Event Type: House Fire  \nInc. Address: 9318 Main Street  \nBox Number: 8170  \nRadio Channel: 5C  \nCommand:   \nComments: Units on the scene with with smoke showing from a single fmaily house\n\nSent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n--\n\n- update your account at https://rsan1.rsan.pwcgov.org
(Working Incident - MVA Extrication) Event Type: Auto Acc with extrication  \n Inc. Address: I-95 South 156.2 MM   \n Box Number: 2087  \n Radio Channel: 5C   \n Command: E512   \n Comments: Auto accident involving several vehicles and a Tanker Placard 1993, no active leaks. One pt. needing extrication.\n \n Sent by PW Alert to FSIGEVENT through Prince William County RSAN\n \n --\n \n - update your account at https://rsan1.rsan.pwcgov.org
(Working Incident) Event Type: ACCX  \n Inc. Address: I95 SB 152MM  \n Box Number: 1087  \n Radio Channel: 5C  \n Command: 5D//BC507 (BAUM)  \n Comments: UNITS ON SCENE REPORTING 1 DOA//5 ALS//1 BLS//2 PT REFUSALS\n \n Sent by PW Alert to FSIGEVENT through Prince William County RSAN\n \n --\n \n - update your account at https://rsan1.rsan.pwcgov.org

*/

public class VAPrinceWilliamCountyBParserTest extends BaseParserTest {
  
  public VAPrinceWilliamCountyBParserTest() {
    setParser(new VAPrinceWilliamCountyBParser(), "PRINCE WILLIAM COUNTY", "VA");
  }
  
  @Test
  public void testJudyMiller() {

    doTest("T1",
        "1 of 3\n" +
        "FRM:PWRSAN\n" +
        "MSG:Trauma Flyout  \n" +
        "Inc. Address: 13909 Smoketown Rd  \n" +
        "Box Number: 2090  \n" +
        "Radio Channel: 5C  \n" +
        "Command: E510  \n" +
        "Landing\n" +
        "(Con't) 2 of 3\n" +
        "Zone: Golansky BLVD./ Noble Pond Way  \n" +
        "Comments: Units on the scene requesting a helicopter for a 6 year old with head a injury. \n" +
        "(Con't) 3 of 3\n" +
        "Medstar 2 is in route with a 10 min ETA.i(End)",

        "CALL:Trauma Flyout",
        "ADDR:13909 Smoketown Rd",
        "BOX:2090",
        "CH:5C",
        "INFO:Cmd: E510\nLZ: Golansky BLVD./ Noble Pond Way\nUnits on the scene requesting a helicopter for a 6 year old with head a injury.  Medstar 2 is in route with a 10 min ETA.i");
   
  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "(Flyout) (Trauma) Flyout  \n" +
        "Inc. Address: 18903 Miata Ln  \n" +
        "Box Number: 0329  \n" +
        "Radio Channel: 5C  \n" +
        "Command: N/A  \n" +
        "Landing Zone: 3615 Lions Field Rd. Triangle ES  \n" +
        "Comments: Injuries to a pediatric from a fall. Life Evac 2 with E503B on 5C for ground contact.\n\n" +
        "Sent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n" +
        "--\n\n" +
        "- update your account at https://rsan1.rsan.pwcgov.org",

        "CALL:Flyout",
        "ADDR:18903 Miata Ln",  // Only maps if TRIANGLE is specified :(
        "BOX:0329",
        "CH:5C",
        "INFO:LZ: 3615 Lions Field Rd. Triangle ES\nInjuries to a pediatric from a fall. Life Evac 2 with E503B on 5C for ground contact.");

    doTest("T2",
        "(Flyout) (Trauma) Flyout  \n" +
        "Inc. Address: I-95 North 156 MM  \n" +
        "Box Number: 2382  \n" +
        "Radio Channel: 5D  \n" +
        "Command: N/A  \n" +
        "Landing Zone: I-95 North 156 MM  \n" +
        "Comments: ALS injuries for adult male. E520 is ground contact for Med Star 2 on 5D.\n\n" +
        "Sent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n" +
        "--\n\n" +
        "- update your account at https://rsan1.rsan.pwcgov.org",

        "CALL:Flyout",
        "ADDR:I-95 North 156 MM",
        "MADDR:I 95 North 156 MM",
        "BOX:2382",
        "CH:5D",
        "INFO:LZ: I-95 North 156 MM\nALS injuries for adult male. E520 is ground contact for Med Star 2 on 5D.");

    doTest("T3",
        "(Flyout) (Trauma) Flyout  \n" +
        "Inc. Address: 9427 Taney Rd  \n" +
        "Box Number: 8126   \n" +
        "Radio Channel: 5C  \n" +
        "Command: N/A  \n" +
        "Landing Zone: 9005 Tudor Rd - Osborn HS  \n" +
        "Comments: Adult with injuries from an assault. E501B is ground contact for Air Care 1 on 5C.\n\n" +
        "Sent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n" +
        "--\n\n" +
        "- update your account at https://rsan1.rsan.pwcgov.org",

        "CALL:Flyout",
        "ADDR:9427 Taney Rd",
        "BOX:8126",
        "CH:5C",
        "INFO:LZ: 9005 Tudor Rd - Osborn HS\nAdult with injuries from an assault. E501B is ground contact for Air Care 1 on 5C.");

    doTest("T4",
        "(Flyout - I-66) (Trauma) Flyout  \n" +
        "Inc. Address: I-66 W 43.9 MM  \n" +
        "Box Number: 1187  \n" +
        "Radio Channel: 5C   \n" +
        "Command: BC501 I-66 CMD  \n" +
        "Landing Zone: I-66 W   \n" +
        "Comments: Medivac for injuries from an MVA. E524 is ground contact for Air Care 2 on 5C.\n\n" +
        "Sent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n" +
        "--\n\n" +
        "- update your account at https://rsan1.rsan.pwcgov.org",

        "CALL:Flyout",
        "ADDR:I-66 W 43.9 MM",
        "MADDR:I 66 W 43.9 MM",
        "BOX:1187",
        "CH:5C",
        "INFO:Cmd: BC501 I-66 CMD\nLZ: I-66 W\nMedivac for injuries from an MVA. E524 is ground contact for Air Care 2 on 5C.");

    doTest("T5",
        "(Flyout - Dale Blvd) (Trauma) Flyout  \n" +
        "Inc. Address: 4719 Kellog Dr.   \n" +
        "Box Number: 1311  \n" +
        "Radio Channel: 5D  \n" +
        "Command: N/A  \n" +
        "Landing Zone: 4901 Dale Blvd - Beville MS  \n" +
        "Comments: Medivac for adult from injuries from a fall. E518 is ground contact for Air Care 2 on 5D\n\n" +
        "Sent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n" +
        "--\n\n" +
        "- update your account at https://rsan1.rsan.pwcgov.org",

        "CALL:Flyout",
        "ADDR:4719 Kellog Dr",  // Google calls this Kellogg Dr
        "BOX:1311",
        "CH:5D",
        "INFO:LZ: 4901 Dale Blvd - Beville MS\nMedivac for adult from injuries from a fall. E518 is ground contact for Air Care 2 on 5D");

    doTest("T6",
        "(Flyout - McGrath Rd) (Trauma) Flyout  \n" +
        "Inc. Address: 8498 McGrath Rd  \n" +
        "Box Number: 0701  \n" +
        "Radio Channel: 5C  \n" +
        "Command: N/A  \n" +
        "Landing Zone: 10628 Dumfries Rd - National Guard Armory  \n" +
        "Comments: Medivac for adult trauma pt. E507 is ground contact for Life Evac 2 on 5C.\n\n" +
        "Sent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n" +
        "--\n\n" +
        "- update your account at https://rsan1.rsan.pwcgov.org",

        "CALL:Flyout",
        "ADDR:8498 McGrath Rd",
        "BOX:0701",
        "CH:5C",
        "INFO:LZ: 10628 Dumfries Rd - National Guard Armory\nMedivac for adult trauma pt. E507 is ground contact for Life Evac 2 on 5C.");

    doTest("T7",
        "(Flyout Box 0243) Trauma Flyout  \n" +
        "Inc. Address: 12836 Tumbling Brook Lane  \n" +
        "Box Number: 0243  \n" +
        "Radio Channel: 5C  \n" +
        "Command: E514  \n" +
        "Landing Zone: Woodbridge HS  \n" +
        "Comments: Units on scene of patient who fell down some steps and struck head on concrete.  Requested helicopter.  HMS-2 enroute to LZ.\n\n" +
        "Sent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n" +
        "--\n\n" +
        "- update your account at https://rsan1.rsan.pwcgov.org",

        "CALL:Trauma Flyout",
        "ADDR:12836 Tumbling Brook Lane",
        "BOX:0243",
        "CH:5C",
        "INFO:Cmd: E514\nLZ: Woodbridge HS\nUnits on scene of patient who fell down some steps and struck head on concrete.  Requested helicopter.  HMS-2 enroute to LZ.");

    doTest("T8",
        "(Flyout Box 1492) (Trauma) Flyout  \n" +
        "Inc. Address: 3001 Old Bridge Road  \n" +
        "Box Number: 1492  \n" +
        "Radio Channel: 5C  \n" +
        "Command: E514  \n" +
        "Landing Zone: Woodbridge High School 3001 Old Bridge Road  \n" +
        "Comments: Infant fell and is in/out of cons. E514 ground contact. Medstar 2 responding with a 8 minute ETA\n\n" +
        "Sent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n" +
        "--\n\n" +
        "- update your account at https://rsan1.rsan.pwcgov.org",

        "CALL:Flyout",
        "ADDR:3001 Old Bridge Road",
        "BOX:1492",
        "CH:5C",
        "INFO:Cmd: E514\nLZ: Woodbridge High School 3001 Old Bridge Road\nInfant fell and is in/out of cons. E514 ground contact. Medstar 2 responding with a 8 minute ETA");

    doTest("T9",
        "(Flyout Box 1122) (Trauma) Flyout  \n" +
        "Inc. Address: 8005 Sudley Road  \n" +
        "Box Number: 1122  \n" +
        "Radio Channel: 5C  \n" +
        "Command: AC511  \n" +
        "Landing Zone: Sinclair Elem. 7801 Garner Dr  \n" +
        "Comments: Injuries from an auto accident (Vehicle into a building)Aircare 1 responding with a 13 minute ETA\n\n" +
        "Sent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n" +
        "--\n\n" +
        "- update your account at https://rsan1.rsan.pwcgov.org",

        "CALL:Flyout",
        "ADDR:8005 Sudley Road",
        "BOX:1122",
        "CH:5C",
        "INFO:Cmd: AC511\nLZ: Sinclair Elem. 7801 Garner Dr\nInjuries from an auto accident (Vehicle into a building)Aircare 1 responding with a 13 minute ETA");

    doTest("T10",
        "(Flyout Box 0707) Trauma Flyout  \n" +
        "Inc. Address: Prince William Parkway / Brentsville Rd.  \n" +
        "Box Number: 0707  \n" +
        "Radio Channel: 5C  \n" +
        "Command: BC504Z (Jordan)  \n" +
        "Landing Zone: Bennett Elememtary 8800 Old Dominion Dr.  \n" +
        "Comments: Units on scene of ACCX requesting helicopter.  HAC-1 on scene.\n\n" +
        "Sent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n" +
        "--\n\n" +
        "- update your account at https://rsan1.rsan.pwcgov.org",

        "CALL:Trauma Flyout",
        "ADDR:Prince William Parkway & Brentsville Rd",
        "BOX:0707",
        "CH:5C",
        "INFO:Cmd: BC504Z (Jordan)\nLZ: Bennett Elememtary 8800 Old Dominion Dr.\nUnits on scene of ACCX requesting helicopter.  HAC-1 on scene.");

    doTest("T11",
        "(Flyout - Box 0707) (Medical/Trauma) Flyout  \n" +
        "Inc. Address: Prince Wm Pkway/Brentsville Rd  \n" +
        "Box Number: 0707  \n" +
        "Radio Channel: 5C  \n" +
        "Command: BC504Z (Jordan)  \n" +
        "Landing Zone: Bennett ES @8800 Old Dominion Dr  \n" +
        "Comments: 1 Pt CPR in progress, 1 being extr. Total 3 pts.\n\n" +
        "Sent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n" +
        "--\n\n" +
        "- update your account at https://rsan1.rsan.pwcgov.org",

        "CALL:Flyout",
        "ADDR:Prince Wm Pkway & Brentsville Rd",
        "BOX:0707",
        "CH:5C",
        "INFO:Cmd: BC504Z (Jordan)\nLZ: Bennett ES @8800 Old Dominion Dr\n1 Pt CPR in progress, 1 being extr. Total 3 pts.");

  }
  
  @Test
  public void testActive911B() {

    doTest("T1",
        "(Working Incident) Event Type: Structure Fire Townhouse  \n" +
        "Inc. Address: 14357 Newbern Lp.   \n" +
        "Box Number: 0402  \n" +
        "Radio Channel: 5C  \n" +
        "Command: BC501 Newbern CMD  \n" +
        "Comments: Units arrived nothing showing mid unit townhouse. T5504  reports fire in the basement.\n\n" +
        "Sent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n" +
        "--\n\n" +
        "- update your account at https://rsan1.rsan.pwcgov.org",

        "CALL:Structure Fire Townhouse",
        "ADDR:14357 Newbern Lp",
        "BOX:0402",
        "CH:5C",
        "INFO:Cmd: BC501 Newbern CMD\nUnits arrived nothing showing mid unit townhouse. T5504  reports fire in the basement.");

    doTest("T2",
        "(Working Incident) Event Type: HOUSE  \n" +
        "Inc. Address: 14440 COLONY CREEK CT  \n" +
        "Box Number: 1749  \n" +
        "Radio Channel: 5C  \n" +
        "Command: BC502 (BC LITTLE)  \n" +
        "Comments: E517 ON SCENE WITH SMOKE SHOWING FROM SIDE A,C,D AND FROM THE ROOF//ALL OCCUPANTS ARE OUT OF THE BUILDING//STRETCHING A LINE TO SIDE B TO ACCESS THE BASEMENT\n\n" +
        "Sent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n" +
        "--\n\n" +
        "- update your account at https://rsan1.rsan.pwcgov.org",

        "CALL:House Fire",
        "ADDR:14440 COLONY CREEK CT",
        "BOX:1749",
        "CH:5C",
        "INFO:Cmd: BC502 (BC LITTLE)\nE517 ON SCENE WITH SMOKE SHOWING FROM SIDE A,C,D AND FROM THE ROOF//ALL OCCUPANTS ARE OUT OF THE BUILDING//STRETCHING A LINE TO SIDE B TO ACCESS THE BASEMENT");

    doTest("T3",
        "(Working Incident (Update)) Event Type: HOUSE  \n" +
        "Inc. Address: 14440 COLONY CREEK CT  \n" +
        "Box Number: 1749  \n" +
        "Radio Channel: 5C//5D  \n" +
        "Command: BC502 (BC LITTLE)  \n" +
        "Comments: FIRE IS KNOCKED DOWN//CHECKING FOR EXTENSION//AND MOPPING UP\n\n" +
        "Sent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n" +
        "--\n\n" +
        "- update your account at https://rsan1.rsan.pwcgov.org",

        "CALL:House Fire",
        "ADDR:14440 COLONY CREEK CT",
        "BOX:1749",
        "CH:5C//5D",
        "INFO:Cmd: BC502 (BC LITTLE)\nFIRE IS KNOCKED DOWN//CHECKING FOR EXTENSION//AND MOPPING UP");

    doTest("T4",
        "(Working Incident) Event Type: HOUSE  \n" +
        "Inc. Address: STEPPING STONE DR  \n" +
        "Box Number: 2427  \n" +
        "Radio Channel: 5C  \n" +
        "Command: CAPT SMITH (E524)  \n" +
        "Comments: UNITS ON SCENE WITH A STRUCTURE FULLY INVOLVED\n\n" +
        "Sent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n" +
        "--\n\n" +
        "- update your account at https://rsan1.rsan.pwcgov.org",

        "CALL:House Fire",
        "ADDR:STEPPING STONE DR",
        "BOX:2427",
        "CH:5C",
        "INFO:Cmd: CAPT SMITH (E524)\nUNITS ON SCENE WITH A STRUCTURE FULLY INVOLVED");

    doTest("T5",
        "(Working Incident (Update)) Event Type: HOUSE  \n" +
        "Inc. Address: 6100 JAMES MADISON (CORRECTED ADDRESS)  \n" +
        "Box Number: 2427  \n" +
        "Radio Channel: 5C  \n" +
        "Command:  \n" +
        "Comments: FIRE IS KNOCKED DOWN//FM523 IS ENROUTE//E524,E515,E504,T504 REMAINING ON SCENE FOR OVERHAUL FOR APPROX 1 HOUR  \n" +
        "  \n" +
        "E505 FILLING FS524\n\n" +
        "Sent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n" +
        "--\n\n" +
        "- update your account at https://rsan1.rsan.pwcgov.org",

        "CALL:House Fire",
        "ADDR:6100 JAMES MADISON",
        "BOX:2427",
        "CH:5C",
        "INFO:Cmd: \nFIRE IS KNOCKED DOWN//FM523 IS ENROUTE//E524,E515,E504,T504 REMAINING ON SCENE FOR OVERHAUL FOR APPROX 1 HOUR");

    doTest("T6",
        "(Working Incident Box 2437) Event Type: House Fire  \n" +
        "Inc. Address: 7315 James Madison Highway  \n" +
        "Box Number: 2437  \n" +
        "Radio Channel: 5C  \n" +
        "Command: E524  \n" +
        "Comments: E524 on the scene with smoke showing from the roof of a single family house.  \n" +
        "UFRO Klimtzak\n\n" +
        "Sent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n" +
        "--\n\n" +
        "- update your account at https://rsan1.rsan.pwcgov.org",

        "CALL:House Fire",
        "ADDR:7315 James Madison Highway",
        "BOX:2437",
        "CH:5C",
        "INFO:Cmd: E524\nE524 on the scene with smoke showing from the roof of a single family house.");

    doTest("T7",
        "(Working Incident Box 8170) Event Type: House Fire  \n" +
        "Inc. Address: 9318 Main Street  \n" +
        "Box Number: 8170  \n" +
        "Radio Channel: 5C  \n" +
        "Command:   \n" +
        "Comments: Units on the scene with with smoke showing from a single fmaily house\n\n" +
        "Sent by PW Alert to FSIGEVENT through Prince William County RSAN\n\n" +
        "--\n\n" +
        "- update your account at https://rsan1.rsan.pwcgov.org",

        "CALL:House Fire",
        "ADDR:9318 Main Street",
        "BOX:8170",
        "CH:5C",
        "INFO:Cmd: \nUnits on the scene with with smoke showing from a single fmaily house");

    doTest("T8",
        "(Working Incident - MVA Extrication) Event Type: Auto Acc with extrication  \n" +
        " Inc. Address: I-95 South 156.2 MM   \n" +
        " Box Number: 2087  \n" +
        " Radio Channel: 5C   \n" +
        " Command: E512   \n" +
        " Comments: Auto accident involving several vehicles and a Tanker Placard 1993, no active leaks. One pt. needing extrication.\n" +
        " \n" +
        " Sent by PW Alert to FSIGEVENT through Prince William County RSAN\n" +
        " \n" +
        " --\n" +
        " \n" +
        " - update your account at https://rsan1.rsan.pwcgov.org",

        "CALL:Auto Acc with extrication",
        "ADDR:I-95 South 156.2 MM",
        "MADDR:I 95 South 156.2 MM",
        "BOX:2087",
        "CH:5C",
        "INFO:Cmd: E512\nAuto accident involving several vehicles and a Tanker Placard 1993, no active leaks. One pt. needing extrication.");

    doTest("T9",
        "(Working Incident) Event Type: ACCX  \n" +
        " Inc. Address: I95 SB 152MM  \n" +
        " Box Number: 1087  \n" +
        " Radio Channel: 5C  \n" +
        " Command: 5D//BC507 (BAUM)  \n" +
        " Comments: UNITS ON SCENE REPORTING 1 DOA//5 ALS//1 BLS//2 PT REFUSALS\n" +
        " \n" +
        " Sent by PW Alert to FSIGEVENT through Prince William County RSAN\n" +
        " \n" +
        " --\n" +
        " \n" +
        " - update your account at https://rsan1.rsan.pwcgov.org",

        "CALL:Auto Accident with Entrapment",
        "ADDR:I95 SB 152MM",
        "MADDR:I 95 152MM",
        "BOX:1087",
        "CH:5C",
        "INFO:Cmd: 5D//BC507 (BAUM)\nUNITS ON SCENE REPORTING 1 DOA//5 ALS//1 BLS//2 PT REFUSALS");
    
  }
  
  public static void main(String[] args) {
    new VAPrinceWilliamCountyBParserTest().generateTests("T1");
  }

}
