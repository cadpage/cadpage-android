package net.anei.cadpage.parsers.UT;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Summit County, UT
Contact: Active911
Agency name: Summit County Search and Rescue Location: Park City, UT 
Sender: scso911@summitcounty.org

UHP\nTraffic Stop\nN SR224 & N SILVER SPRINGS RD; SILVER SP,PC\nUHP\n563\nTraffic stop                                                                    \n22:30:34 06/07/2012 - Rose A         \n\nState Response:\n\nAlert: REPORTED TO INSURITE SOLD OR REG OUT OF STATE\nLicense Plate: 963KPF, UT\nVIN: F36ZPGH0035\nExpires: --\nColor: \nYe
UHP\nTraffic Stop\nN SR224 & W SUN PEAK DR; OLD RANCH RD,PC\nUHP\nK33\n10-60
UHP\nTraffic Stop\nN SR224 & W SUN PEAK DR; SUN PEAK DR,PC\nUHP\nK18\nTraffic stop
UHP\nTraffic Stop\n11 SR224,PC\nUHP\n563\nTraffic stop
UHP\nTraffic Stop\n144 I80 EASTBOUND,PC\nUHP\n401\nTraffic stop
PCFD\nMedical Aid\n6609 N LANDMARK DR; LANDMARK DR,PC\nPCFD\nA37
SCSO\nTraffic Stop\nW KILBY RD; Ecker Hill,PC\nSCZ5\nK76\n10-60
SCSO\nTraffic Stop\nPINEBROOK BLVD; #1480-1601,1602-1653,165,PC\nSCZ5\nK76\n10-60
UHP\nInjury Accident\n8 SR40 EASTBOUND,HEB\nUHP\n537\nWhite durango,nissan titan alph bravo injuries.
SCSO\nTraffic Stop\npinebrook & point @\nYANK3\nK76\n10-60
SCSO\nTraffic Stop\n3151 W KILBY RD,PC\nSCZ5\nK49\n10-60
SCSO\nTraffic Stop\nN LANDMARK DR,PC\nSCZ5\nK76\n10-60
UHP\nTraffic Stop\n4 SR40 WESTBOUND; ramp,PC\nUHP\n240\n1060
PCFD\nMedical Aid\n199 DALY AVE,PCC\nPCFD\nA37
PCFD\nFire Alrm Comml\n6344 N PROMONTORY RANCH RD; PROMONTORY R,PC\nPCFD\nE37\nMarket place audible zone 7 water flow rp pending dt 1403 inside 465-649-4433
SCSO\nTraffic Stop\nN SILVER SPRINGS RD & N EAST MEADOWS DR,PC\nSCZ3\nK76\n10-60
SCSO\nTraffic Stop\nN SILVER SPRINGS DR & N EAST MEADOWS DR,PC\nSCZ3\nK76\n10-60
SCSO\nTraffic Stop\n@\nYANK3\nK76\n b495le ut
UHP\nTraffic Stop\n146 I80 EASTBOUND,PC\nUHP\n563\n1060
UHP\nTraffic Stop\n7 MIRROR LAKE HWY; U150,KAM\nUHP\n14B22\ntraffic
SCSO\nTraffic Stop\n300 N MAIN ST,COA\nSCZ2\nK64\n traffic
SCSO\nTraffic Stop\n200 N MAIN ST,COA\nSCZ2\nK64\ntraffic
PCFD\nFire Alrm Comml\n8417 N RANCH CLUB TRL,PC\nPCFD\nE37\nPromontory Kids Cabin (435)333-4050 - POA: GENERAL - DT: 19:02 - RP: Pending.
PCFD\nMedical Aid\n7700 STEIN WAY,PCC\nPCFD\nA34\nmale 20 ish face down hotel floor - not breathing\n19:08:06 06/08/2012 - Peterson T B\nProQA Medical Recommended Dispatch Level = 31D02\n20 year old, Male, Unconscious, Breathing.  Unconscious / Fainting (Near).  Unconscious -- Effective breathing.  Caller S
SCSO\nTraffic Stop\nE ECHO DAM RD,COA\nSCZ2\nK64\n10-60 south beach
UHP\nTraffic Stop\nN SR224 & N SILVER SPRINGS DR; SILVER SP,PC\nUHP\nK46\n10-60
PCFD\nMedical Aid\n1776 KEARNS BLVD,PCC\nPCFD\nE31\nApprox 16-17 year old female, c/b/a, struck by a vehicle in front of the high\nschool, she is pinned under the vehicle, bleeding from the nose is the only\nobvious bleeding at this time, caller is unable to get closer to assess\ninjuries.\n18:51:51 06/08/2012
PCFD\nMedical Aid\n516 MARSAC AVE,PCC\nPCFD\nA37\nKenna at the Peace House contacted UNI Crisis hotline - She has an early 20's\nfemale c/b/a that has a severe mental illness, has been in and out of\ninstitutions for 6 years. She has been off meds for an unknown period of time\nand is anxious and paranoid.
SCSO\nTraffic Stop\nE OLD RANCH RD,PC\nSCZ3\nK46\n10-60
SCSO\nTraffic Stop\n600 S MAIN ST,COA\nSCZ2\nK64\ntraffic
UHP\nTraffic Stop\n9 MIRROR LAKE HWY; U150,KAM\nUHP\n14B22\ntraffic
UHP\nTraffic Stop\nN SR224 & N SILVER SPRINGS DR; SILVER SP,PC\nUHP\nK46\n10-60
UHP\nTraffic Stop\n4 SR40 EASTBOUND,PC\nUHP\n401\ntraffic
SCSO\nTraffic Stop\nN CREEKSIDE LN,PC\nSCZ3\nK71\n10-60
UHP\nTraffic Stop\nE MIRROR LAKE; 200 E,KAM\nUHP\n563\ntraffic
UHP\nTraffic Stop\nN SR224 & W UTE BLVD; UTE BLVD,PC\nUHP\nK71\n10-60
UHP\nTraffic Stop\nN SR224 & COVE CANYON DR,PC\nUHP\nK46\n10-60
UHP\nTraffic Stop\n22 MIRROR LAKE HWY; U150,KAM\nUHP\n14B22\ntraffic
UHP\nTraffic Stop\nN SR224 & N SILVER SPRINGS DR,PC\nUHP\nK46\n10-60
UHP\nTraffic Stop\n47 SR40 EASTBOUND,HEB\nUHP\n401\ntraffic
SCSO\nTraffic Stop\n300 N MAIN ST,COA\nSCZ2\n1A68\n10-60
SCSO\nTraffic Stop\nCOVE CANYON DR,PC\nSCZ5\nK62\n1060 sr224
SCSO\nTraffic Stop\nN SR224 & N SILVER SPRINGS DR; SILVER SP,PC\nSCSO\nK45\nK45 advised traffic
SCSO\nTraffic Stop\nsr 302,PEO\nSCSO\nK72\nK72 advised out with a vehicle
SCSO\nTraffic Stop\n23 MIRROR LAKE HWY; U150,EVA\nSCSO\nK80\nK80 advised traffic
SCSO\nTraffic Stop\nQUARRY MOUNTAIN RD,PC\nSCZ3\n420\n1060 Quarry Village Parking lot
SCSO\nTraffic Stop\n6545 N LANDMARK DR,PC\nSCZ5\nK45\nK45 advised traffic
SCSO\nTraffic Stop\nE HIGHLAND DR; Swaner lookout,PC\nSCZ3\nK57\nK57 advised traffic stop.
SCSO\nSAR Training\nS ROCKPORT ASPEN CIR,RKP\nSCZ2\nK10\ncase requested
SCSO\nTraffic Stop\n68 S MAIN ST,COA\nSCZ2\nK71\n 10-60
SCSO\nTraffic Stop\nS 50 E,COA\nSCZ2\nK71\n10-60
SCSO\nTraffic Stop\nN SILVER CREEK DR & N PROMONTORY RANCH R,PC\nSCZ3\nK55\n10-60 whi ford x1
SCSO\nTraffic Stop\nsr32 & oakley downs rd @\nZULU2\nK71\n 10-60
SCSO\nTraffic Stop\n1390 S HOYTSVILLE RD,HOY\nSCZ2\nK71\n 10-60
PCFD\nFire Alrm Comml\n1305 LOWELL AVE,PCC\nPCFD\nE31\nmarriot resorts. POA water flow alarm. 435 940 2000. RP is pending.
PCFD\nMedical Aid\n15 PROSPECTOR DR,PCC\nPCFD\nE38\n82 yo female that has pain in her stomach.
UHP\nInjury Accident\n146 I80 EASTBOUND,PC\nUHP\n563\nfour car accident two black cars, 1 blue car, 1 white car. Non injuries, not\nblocking.\n16:27:06 06/15/2012 - Pyper J\nwhite jetta 21 yof c/b/a complaining of neck pain\n16:28:02 06/15/2012 - Pyper J\ncomp in the white jetta needs a tow 610h9 Matt Strader 435
PCFD\nMedical Aid\n1800 PARK AVE,PCC\nPCFD\nA31\n17:16:46 06/15/2012 - Odenbach T\nProQA Medical Recommended Dispatch Level = 21A01\n23 year old, Female, Conscious, Breathing.  Hemorrhage / Lacerations.  NOT DANGEROUS hemorrhage.  Caller Statement: intoxicated female with blood on her.\n 1. She is complete
PCFD\nMedical Aid\n4045 W HILLTOP CT; HILLTOP CT,PC\nPCFD\nA35\n18:13:13 06/15/2012 - Odenbach T\nProQA Medical Recommended Dispatch Level = 31D02\n32 year old, Male, Unconscious, Breathing.  Unconscious / Fainting (Near).  Unconscious -- Effective breathing.  Caller Statement: siezure.\n 1. His breathing is not complete
PCFD\nFire Alrm Comml\n7620 ROYAL ST E,PCC\nPCFD\nE34\nDeer Valley Resort 615-6395 - POA: GENERAL - DT: 18:32 - RP: Pending
PCFD\nMedical Aid\n373 GILLMOR WAY,PCC\nPCFD\nA31\nlower baseball south east field - near where the diamond and grass meet \n18:49:26 06/15/2012 - Peterson T B\nProQA Medical Recommended Dispatch Level = 30B01\n12 year old, Male, Conscious, Breathing.  Traumatic Injuries (Specific).  POSSIBLY DANGEROUS body
PCFD\nFire Alrm Comml\n710 MAIN ST,PCC\nPCFD\nE38\nMarriott Summit Watch - POA: Ontario Bldg - DT: 19:15 - RP: Pending.
NSFD\nBrush Fire\n169 I80 WESTBOUND,COA\nNSFD\nNSFD\neast of echo on i80 on the tracks\n15:08:50 06/15/2012 - Pyper J\nunion pacific notified they will stop the trains\n15:32:31 06/15/2012 - Pyper J\nfire contained at this time\n17:22:58 06/15/2012 - Pyper J\nhave reopened the railroad at reduced speed rp on scen
PCFD\nMedical Aid\n1010 WOODSIDE AVE,PCC\nPCFD\nA31\n11 yom fell skate boarding - c/dif breathing/ alert
PCFD\nMedical Aid\n1456 W NEWPARK BLVD,PC\nPCFD\nA35
PCFD\nMedical Aid\nW NEWPARK BLVD,PC\nPCFD\nA37\nmale indv votiming c/b/a
UHP\nInjury Accident\nSR189,HEB\nUHP\n448\n22:36:49 06/15/2012 - Harrison S\nProQA Medical Case C12-41360 Aborted: 9. Test case
UHP\nMissing Person\nMIRROR LAKE HWY,EVA\nUHP\nK30\nMale in sil gmc sierra/called evanston saying he has lost his wife and is\ndisoriented and confused/unk if she was in a vehicle or if she is hiking\naround/is somewhere on the road to whitney res near bear river service on mirror\nlake highway
SCSO\nSearch/Rescue\nMIRROR LAKE HWY,KAM\nUHP\nS52
SAR \nSAR Training\nSoapstone Guard Station,KAM\nSCZ4\nS24\nTraining until tomorrow sometime
SCSO\nMissing Person\n9 MIRROR LAKE HWY; U150,KAM\nUHP\nS52\nthree missing teenagers two male, one female that have been missing for three\nhrs.
SAR \nSAR Training\nSoapstone Guard Station,KAM\nSCZ4\nS24\nTraining until tomorrow sometime
SCSO\nMissing Person\n100 E CENTER ST,KAM\nSCSO\nK54\nK54 advised some people rolled up on me and advised their father is missing.  \nLicense Number:  1953549  Sex:  M \nID Number:   Height:  511 \nName:  VERN A CARTER  Weight:  195 \nAddress:  13800 WEST 3800 NORTH\nTABIONA, UT 84072 Eye:  BLU \nLast Address Upda
SCSO\nSearch/Rescue\nHOYTS CANYON,KAM\nSCZ4\nK10\n82 yom missing. Made contact with a friend Don Soyer last night around 00:00 and\nstated he was up Hoyts Peak near the Lost Mine and he was stuck and his phone\nwas going to die.
SCSO\nMissing Person\nCRESTVIEW DR,PC\nSCZ5\nK56\nChristopher Goode been missing for two weeks, last seen a month ago. Has been in\nCalifornia until 2 weeks ago, unable to make contact with him for two weeks,\nphone is shut off. Might still be in California but not known. Working around\nTahoe.
UHP\nMissing Person\nE MIRROR LAKE HWY,KAM\nUHP\nK43\nComp has Tukwila Police Dept in Tukwila Washington have started a report #124572\nCaller stated Summit county pinged the cell phone last night and it came from\nthe great lakes area last night close to midnight.\n\n**It is imperative to get the person's cell
PCFD\nBrush Fire\n2466 MEADOWS DR,PCC\nPCFD\nE31\nBrush fire below Meadows Dr on the west side of Park Meadows, no flames seen\n19:17:40 06/28/2012 - Hewitt H       \nNear Eagle Point

*/

public class UTSummitCountyParserTest extends BaseParserTest {
  
  public UTSummitCountyParserTest() {
    setParser(new UTSummitCountyParser(), "SUMMIT COUNTY", "UT");
  }
  
  @Test
  public void testActive911() {

    doTest("T1",
        "UHP\n" +
        "Traffic Stop\n" +
        "N SR224 & N SILVER SPRINGS RD; SILVER SP,PC\n" +
        "UHP\n" +
        "563\n" +
        "Traffic stop                                                                    \n" +
        "22:30:34 06/07/2012 - Rose A         \n\n" +
        "State Response:\n\n" +
        "Alert: REPORTED TO INSURITE SOLD OR REG OUT OF STATE\n" +
        "License Plate: 963KPF, UT\n" +
        "VIN: F36ZPGH0035\n" +
        "Expires: --\n" +
        "Color: \n" +
        "Ye",

        "SRC:UHP",
        "CALL:Traffic Stop",
        "ADDR:N SR224 & N SILVER SPRINGS RD",
        "MADDR:N UT 224 & N SILVER SPRINGS RD",
        "X:SILVER SP",
        "CITY:PARK CITY",
        "UNIT:563",
        "INFO:Traffic stop / 22:30:34 06/07/2012 - Rose A / State Response: / Alert: REPORTED TO INSURITE SOLD OR REG OUT OF STATE / License Plate: 963KPF, UT / VIN: F36ZPGH0035 / Expires: -- / Color: / Ye");

    doTest("T2",
        "UHP\nTraffic Stop\nN SR224 & W SUN PEAK DR; OLD RANCH RD,PC\nUHP\nK33\n10-60",
        "SRC:UHP",
        "CALL:Traffic Stop",
        "ADDR:N SR224 & W SUN PEAK DR",
        "MADDR:N UT 224 & W SUN PEAK DR",
        "X:OLD RANCH RD",
        "CITY:PARK CITY",
        "UNIT:K33",
        "INFO:10-60");

    doTest("T3",
        "UHP\nTraffic Stop\nN SR224 & W SUN PEAK DR; SUN PEAK DR,PC\nUHP\nK18\nTraffic stop",
        "SRC:UHP",
        "CALL:Traffic Stop",
        "ADDR:N SR224 & W SUN PEAK DR",
        "MADDR:N UT 224 & W SUN PEAK DR",
        "X:SUN PEAK DR",
        "CITY:PARK CITY",
        "UNIT:K18",
        "INFO:Traffic stop");

    doTest("T4",
        "UHP\nTraffic Stop\n11 SR224,PC\nUHP\n563\nTraffic stop",
        "SRC:UHP",
        "CALL:Traffic Stop",
        "ADDR:11 SR224",
        "MADDR:11 UT 224",
        "CITY:PARK CITY",
        "UNIT:563",
        "INFO:Traffic stop");

    doTest("T5",
        "UHP\nTraffic Stop\n144 I80 EASTBOUND,PC\nUHP\n401\nTraffic stop",
        "SRC:UHP",
        "CALL:Traffic Stop",
        "ADDR:144 I80 EB",
        "MADDR:144 I 80",
        "CITY:PARK CITY",
        "UNIT:401",
        "INFO:Traffic stop");

    doTest("T6",
        "PCFD\nMedical Aid\n6609 N LANDMARK DR; LANDMARK DR,PC\nPCFD\nA37",
        "SRC:PCFD",
        "CALL:Medical Aid",
        "ADDR:6609 N LANDMARK DR",
        "X:LANDMARK DR",
        "CITY:PARK CITY",
        "UNIT:A37");

    doTest("T7",
        "SCSO\nTraffic Stop\nW KILBY RD; Ecker Hill,PC\nSCZ5\nK76\n10-60",
        "SRC:SCSO",
        "CALL:Traffic Stop",
        "ADDR:W KILBY RD",
        "MADDR:W KILBY RD & Ecker Hill",
        "X:Ecker Hill",
        "CITY:PARK CITY",
        "UNIT:SCZ5,K76",
        "INFO:10-60");

    doTest("T8",
        "SCSO\nTraffic Stop\nPINEBROOK BLVD; #1480-1601,1602-1653,165,PC\nSCZ5\nK76\n10-60",
        "SRC:SCSO",
        "CALL:Traffic Stop",
        "ADDR:PINEBROOK BLVD",
        "MADDR:PINEBROOK BLVD & #1480-1601",
        "X:#1480-1601,1602-1653,165",
        "CITY:PARK CITY",
        "UNIT:SCZ5,K76",
        "INFO:10-60");

    doTest("T9",
        "UHP\nInjury Accident\n8 SR40 EASTBOUND,HEB\nUHP\n537\nWhite durango,nissan titan alph bravo injuries.",
        "SRC:UHP",
        "CALL:Injury Accident",
        "ADDR:8 SR40 EB",
        "MADDR:8 UT 40",
        "CITY:HEBER",
        "UNIT:537",
        "INFO:White durango,nissan titan alph bravo injuries.");

    doTest("T10",
        "SCSO\nTraffic Stop\npinebrook & point @\nYANK3\nK76\n10-60",
        "SRC:SCSO",
        "CALL:Traffic Stop",
        "ADDR:pinebrook & point",
        "UNIT:YANK3,K76",
        "INFO:10-60");

    doTest("T11",
        "SCSO\nTraffic Stop\n3151 W KILBY RD,PC\nSCZ5\nK49\n10-60",
        "SRC:SCSO",
        "CALL:Traffic Stop",
        "ADDR:3151 W KILBY RD",
        "CITY:PARK CITY",
        "UNIT:SCZ5,K49",
        "INFO:10-60");

    doTest("T12",
        "SCSO\nTraffic Stop\nN LANDMARK DR,PC\nSCZ5\nK76\n10-60",
        "SRC:SCSO",
        "CALL:Traffic Stop",
        "ADDR:N LANDMARK DR",
        "CITY:PARK CITY",
        "UNIT:SCZ5,K76",
        "INFO:10-60");

    doTest("T13",
        "UHP\nTraffic Stop\n4 SR40 WESTBOUND; ramp,PC\nUHP\n240\n1060",
        "SRC:UHP",
        "CALL:Traffic Stop",
        "ADDR:4 SR40 WB",
        "MADDR:4 UT 40",
        "X:ramp",
        "CITY:PARK CITY",
        "UNIT:240,1060");

    doTest("T14",
        "PCFD\nMedical Aid\n199 DALY AVE,PCC\nPCFD\nA37",
        "SRC:PCFD",
        "CALL:Medical Aid",
        "ADDR:199 DALY AVE",
        "CITY:PARK CITY",
        "UNIT:A37");

    doTest("T15",
        "PCFD\n" +
        "Fire Alrm Comml\n" +
        "6344 N PROMONTORY RANCH RD; PROMONTORY R,PC\n" +
        "PCFD\n" +
        "E37\n" +
        "Market place audible zone 7 water flow rp pending dt 1403 inside 465-649-4433",

        "SRC:PCFD",
        "CALL:Fire Alrm Comml",
        "ADDR:6344 N PROMONTORY RANCH RD",
        "X:PROMONTORY R",
        "CITY:PARK CITY",
        "UNIT:E37",
        "INFO:Market place audible zone 7 water flow rp pending dt 1403 inside 465-649-4433");

    doTest("T16",
        "SCSO\nTraffic Stop\nN SILVER SPRINGS RD & N EAST MEADOWS DR,PC\nSCZ3\nK76\n10-60",
        "SRC:SCSO",
        "CALL:Traffic Stop",
        "ADDR:N SILVER SPRINGS RD & N EAST MEADOWS DR",
        "CITY:PARK CITY",
        "UNIT:SCZ3,K76",
        "INFO:10-60");

    doTest("T17",
        "SCSO\nTraffic Stop\nN SILVER SPRINGS DR & N EAST MEADOWS DR,PC\nSCZ3\nK76\n10-60",
        "SRC:SCSO",
        "CALL:Traffic Stop",
        "ADDR:N SILVER SPRINGS DR & N EAST MEADOWS DR",
        "CITY:PARK CITY",
        "UNIT:SCZ3,K76",
        "INFO:10-60");

    doTest("T18",
        "SCSO\nTraffic Stop\n@\nYANK3\nK76\n b495le ut",
        "SRC:SCSO",
        "CALL:Traffic Stop",
        "UNIT:YANK3,K76",
        "INFO:b495le ut");

    doTest("T19",
        "UHP\nTraffic Stop\n146 I80 EASTBOUND,PC\nUHP\n563\n1060",
        "SRC:UHP",
        "CALL:Traffic Stop",
        "ADDR:146 I80 EB",
        "MADDR:146 I 80",
        "CITY:PARK CITY",
        "UNIT:563,1060");

    doTest("T20",
        "UHP\nTraffic Stop\n7 MIRROR LAKE HWY; U150,KAM\nUHP\n14B22\ntraffic",
        "SRC:UHP",
        "CALL:Traffic Stop",
        "ADDR:7 MIRROR LAKE HWY",
        "X:U150",
        "CITY:KAMAS",
        "INFO:14B22 / traffic");

    doTest("T21",
        "SCSO\nTraffic Stop\n300 N MAIN ST,COA\nSCZ2\nK64\n traffic",
        "SRC:SCSO",
        "CALL:Traffic Stop",
        "ADDR:300 N MAIN ST",
        "CITY:COALVILLE",
        "UNIT:SCZ2,K64,traffic");

    doTest("T22",
        "SCSO\nTraffic Stop\n200 N MAIN ST,COA\nSCZ2\nK64\ntraffic",
        "SRC:SCSO",
        "CALL:Traffic Stop",
        "ADDR:200 N MAIN ST",
        "CITY:COALVILLE",
        "UNIT:SCZ2,K64,traffic");

    doTest("T23",
        "PCFD\n" +
        "Fire Alrm Comml\n" +
        "8417 N RANCH CLUB TRL,PC\n" +
        "PCFD\n" +
        "E37\n" +
        "Promontory Kids Cabin (435)333-4050 - POA: GENERAL - DT: 19:02 - RP: Pending.",

        "SRC:PCFD",
        "CALL:Fire Alrm Comml",
        "ADDR:8417 N RANCH CLUB TRL",
        "CITY:PARK CITY",
        "UNIT:E37",
        "INFO:Promontory Kids Cabin (435)333-4050 - POA: GENERAL - DT: 19:02 - RP: Pending.");

    doTest("T24",
        "PCFD\n" +
        "Medical Aid\n" +
        "7700 STEIN WAY,PCC\n" +
        "PCFD\n" +
        "A34\n" +
        "male 20 ish face down hotel floor - not breathing\n" +
        "19:08:06 06/08/2012 - Peterson T B\n" +
        "ProQA Medical Recommended Dispatch Level = 31D02\n" +
        "20 year old, Male, Unconscious, Breathing.  Unconscious / Fainting (Near).  Unconscious -- Effective breathing.  Caller S",

        "SRC:PCFD",
        "CALL:Medical Aid",
        "ADDR:7700 STEIN WAY",
        "CITY:PARK CITY",
        "UNIT:A34",
        "INFO:male 20 ish face down hotel floor - not breathing / 19:08:06 06/08/2012 - Peterson T B / ProQA Medical Recommended Dispatch Level = 31D02 / 20 year old, Male, Unconscious, Breathing.  Unconscious / Fainting (Near).  Unconscious -- Effective breathing.  Caller S");

    doTest("T25",
        "SCSO\nTraffic Stop\nE ECHO DAM RD,COA\nSCZ2\nK64\n10-60 south beach",
        "SRC:SCSO",
        "CALL:Traffic Stop",
        "ADDR:E ECHO DAM RD",
        "CITY:COALVILLE",
        "UNIT:SCZ2,K64",
        "INFO:10-60 south beach");

    doTest("T26",
        "UHP\nTraffic Stop\nN SR224 & N SILVER SPRINGS DR; SILVER SP,PC\nUHP\nK46\n10-60",
        "SRC:UHP",
        "CALL:Traffic Stop",
        "ADDR:N SR224 & N SILVER SPRINGS DR",
        "MADDR:N UT 224 & N SILVER SPRINGS DR",
        "X:SILVER SP",
        "CITY:PARK CITY",
        "UNIT:K46",
        "INFO:10-60");

    doTest("T27",
        "PCFD\n" +
        "Medical Aid\n" +
        "1776 KEARNS BLVD,PCC\n" +
        "PCFD\n" +
        "E31\n" +
        "Approx 16-17 year old female, c/b/a, struck by a vehicle in front of the high\n" +
        "school, she is pinned under the vehicle, bleeding from the nose is the only\n" +
        "obvious bleeding at this time, caller is unable to get closer to assess\n" +
        "injuries.\n" +
        "18:51:51 06/08/2012",

        "SRC:PCFD",
        "CALL:Medical Aid",
        "ADDR:1776 KEARNS BLVD",
        "CITY:PARK CITY",
        "UNIT:E31",
        "INFO:Approx 16-17 year old female, c/b/a, struck by a vehicle in front of the high / school, she is pinned under the vehicle, bleeding from the nose is the only / obvious bleeding at this time, caller is unable to get closer to assess / injuries. / 18:51:51 06/08/2012");

    doTest("T28",
        "PCFD\n" +
        "Medical Aid\n" +
        "516 MARSAC AVE,PCC\n" +
        "PCFD\n" +
        "A37\n" +
        "Kenna at the Peace House contacted UNI Crisis hotline - She has an early 20's\n" +
        "female c/b/a that has a severe mental illness, has been in and out of\n" +
        "institutions for 6 years. She has been off meds for an unknown period of time\n" +
        "and is anxious and paranoid.",

        "SRC:PCFD",
        "CALL:Medical Aid",
        "ADDR:516 MARSAC AVE",
        "CITY:PARK CITY",
        "UNIT:A37",
        "INFO:Kenna at the Peace House contacted UNI Crisis hotline - She has an early 20's / female c/b/a that has a severe mental illness, has been in and out of / institutions for 6 years. She has been off meds for an unknown period of time / and is anxious and paranoid.");

    doTest("T29",
        "SCSO\nTraffic Stop\nE OLD RANCH RD,PC\nSCZ3\nK46\n10-60",
        "SRC:SCSO",
        "CALL:Traffic Stop",
        "ADDR:E OLD RANCH RD",
        "CITY:PARK CITY",
        "UNIT:SCZ3,K46",
        "INFO:10-60");

    doTest("T30",
        "SCSO\nTraffic Stop\n600 S MAIN ST,COA\nSCZ2\nK64\ntraffic",
        "SRC:SCSO",
        "CALL:Traffic Stop",
        "ADDR:600 S MAIN ST",
        "CITY:COALVILLE",
        "UNIT:SCZ2,K64,traffic");

    doTest("T31",
        "UHP\nTraffic Stop\n9 MIRROR LAKE HWY; U150,KAM\nUHP\n14B22\ntraffic",
        "SRC:UHP",
        "CALL:Traffic Stop",
        "ADDR:9 MIRROR LAKE HWY",
        "X:U150",
        "CITY:KAMAS",
        "INFO:14B22 / traffic");

    doTest("T32",
        "UHP\nTraffic Stop\nN SR224 & N SILVER SPRINGS DR; SILVER SP,PC\nUHP\nK46\n10-60",
        "SRC:UHP",
        "CALL:Traffic Stop",
        "ADDR:N SR224 & N SILVER SPRINGS DR",
        "MADDR:N UT 224 & N SILVER SPRINGS DR",
        "X:SILVER SP",
        "CITY:PARK CITY",
        "UNIT:K46",
        "INFO:10-60");

    doTest("T33",
        "UHP\nTraffic Stop\n4 SR40 EASTBOUND,PC\nUHP\n401\ntraffic",
        "SRC:UHP",
        "CALL:Traffic Stop",
        "ADDR:4 SR40 EB",
        "MADDR:4 UT 40",
        "CITY:PARK CITY",
        "UNIT:401,traffic");

    doTest("T34",
        "SCSO\nTraffic Stop\nN CREEKSIDE LN,PC\nSCZ3\nK71\n10-60",
        "SRC:SCSO",
        "CALL:Traffic Stop",
        "ADDR:N CREEKSIDE LN",
        "CITY:PARK CITY",
        "UNIT:SCZ3,K71",
        "INFO:10-60");

    doTest("T35",
        "UHP\nTraffic Stop\nE MIRROR LAKE; 200 E,KAM\nUHP\n563\ntraffic",
        "SRC:UHP",
        "CALL:Traffic Stop",
        "ADDR:E MIRROR LAKE",
        "MADDR:E MIRROR LAKE & 200 E",
        "X:200 E",
        "CITY:KAMAS",
        "UNIT:563,traffic");

    doTest("T36",
        "UHP\nTraffic Stop\nN SR224 & W UTE BLVD; UTE BLVD,PC\nUHP\nK71\n10-60",
        "SRC:UHP",
        "CALL:Traffic Stop",
        "ADDR:N SR224 & W UTE BLVD",
        "MADDR:N UT 224 & W UTE BLVD",
        "X:UTE BLVD",
        "CITY:PARK CITY",
        "UNIT:K71",
        "INFO:10-60");

    doTest("T37",
        "UHP\nTraffic Stop\nN SR224 & COVE CANYON DR,PC\nUHP\nK46\n10-60",
        "SRC:UHP",
        "CALL:Traffic Stop",
        "ADDR:N SR224 & COVE CANYON DR",
        "MADDR:N UT 224 & COVE CANYON DR",
        "CITY:PARK CITY",
        "UNIT:K46",
        "INFO:10-60");

    doTest("T38",
        "UHP\nTraffic Stop\n22 MIRROR LAKE HWY; U150,KAM\nUHP\n14B22\ntraffic",
        "SRC:UHP",
        "CALL:Traffic Stop",
        "ADDR:22 MIRROR LAKE HWY",
        "X:U150",
        "CITY:KAMAS",
        "INFO:14B22 / traffic");

    doTest("T39",
        "UHP\nTraffic Stop\nN SR224 & N SILVER SPRINGS DR,PC\nUHP\nK46\n10-60",
        "SRC:UHP",
        "CALL:Traffic Stop",
        "ADDR:N SR224 & N SILVER SPRINGS DR",
        "MADDR:N UT 224 & N SILVER SPRINGS DR",
        "CITY:PARK CITY",
        "UNIT:K46",
        "INFO:10-60");

    doTest("T40",
        "UHP\nTraffic Stop\n47 SR40 EASTBOUND,HEB\nUHP\n401\ntraffic",
        "SRC:UHP",
        "CALL:Traffic Stop",
        "ADDR:47 SR40 EB",
        "MADDR:47 UT 40",
        "CITY:HEBER",
        "UNIT:401,traffic");

    doTest("T41",
        "SCSO\nTraffic Stop\n300 N MAIN ST,COA\nSCZ2\n1A68\n10-60",
        "SRC:SCSO",
        "CALL:Traffic Stop",
        "ADDR:300 N MAIN ST",
        "CITY:COALVILLE",
        "UNIT:SCZ2",
        "INFO:1A68 / 10-60");

    doTest("T42",
        "SCSO\nTraffic Stop\nCOVE CANYON DR,PC\nSCZ5\nK62\n1060 sr224",
        "SRC:SCSO",
        "CALL:Traffic Stop",
        "ADDR:COVE CANYON DR",
        "CITY:PARK CITY",
        "UNIT:SCZ5,K62",
        "INFO:1060 sr224");

    doTest("T43",
        "SCSO\nTraffic Stop\nN SR224 & N SILVER SPRINGS DR; SILVER SP,PC\nSCSO\nK45\nK45 advised traffic",
        "SRC:SCSO",
        "CALL:Traffic Stop",
        "ADDR:N SR224 & N SILVER SPRINGS DR",
        "MADDR:N UT 224 & N SILVER SPRINGS DR",
        "X:SILVER SP",
        "CITY:PARK CITY",
        "UNIT:K45",
        "INFO:K45 advised traffic");

    doTest("T44",
        "SCSO\nTraffic Stop\nsr 302,PEO\nSCSO\nK72\nK72 advised out with a vehicle",
        "SRC:SCSO",
        "CALL:Traffic Stop",
        "ADDR:sr 302",
        "MADDR:UT 302",
        "CITY:PEOA",
        "UNIT:K72",
        "INFO:K72 advised out with a vehicle");

    doTest("T45",
        "SCSO\nTraffic Stop\n23 MIRROR LAKE HWY; U150,EVA\nSCSO\nK80\nK80 advised traffic",
        "SRC:SCSO",
        "CALL:Traffic Stop",
        "ADDR:23 MIRROR LAKE HWY",
        "X:U150",
        "CITY:KAMAS",
        "UNIT:K80",
        "INFO:K80 advised traffic");

    doTest("T46",
        "SCSO\nTraffic Stop\nQUARRY MOUNTAIN RD,PC\nSCZ3\n420\n1060 Quarry Village Parking lot",
        "SRC:SCSO",
        "CALL:Traffic Stop",
        "ADDR:QUARRY MOUNTAIN RD",
        "CITY:PARK CITY",
        "UNIT:SCZ3,420",
        "INFO:1060 Quarry Village Parking lot");

    doTest("T47",
        "SCSO\nTraffic Stop\n6545 N LANDMARK DR,PC\nSCZ5\nK45\nK45 advised traffic",
        "SRC:SCSO",
        "CALL:Traffic Stop",
        "ADDR:6545 N LANDMARK DR",
        "CITY:PARK CITY",
        "UNIT:SCZ5,K45",
        "INFO:K45 advised traffic");

    doTest("T48",
        "SCSO\nTraffic Stop\nE HIGHLAND DR; Swaner lookout,PC\nSCZ3\nK57\nK57 advised traffic stop.",
        "SRC:SCSO",
        "CALL:Traffic Stop",
        "ADDR:E HIGHLAND DR",
        "MADDR:E HIGHLAND DR & Swaner lookout",
        "X:Swaner lookout",
        "CITY:PARK CITY",
        "UNIT:SCZ3,K57",
        "INFO:K57 advised traffic stop.");

    doTest("T49",
        "SCSO\nSAR Training\nS ROCKPORT ASPEN CIR,RKP\nSCZ2\nK10\ncase requested",
        "SRC:SCSO",
        "CALL:SAR Training",
        "ADDR:S ROCKPORT ASPEN CIR",
        "CITY:ROCKPORT",
        "UNIT:SCZ2,K10",
        "INFO:case requested");

    doTest("T50",
        "SCSO\nTraffic Stop\n68 S MAIN ST,COA\nSCZ2\nK71\n 10-60",
        "SRC:SCSO",
        "CALL:Traffic Stop",
        "ADDR:68 S MAIN ST",
        "CITY:COALVILLE",
        "UNIT:SCZ2,K71",
        "INFO:10-60");

    doTest("T51",
        "SCSO\nTraffic Stop\nS 50 E,COA\nSCZ2\nK71\n10-60",
        "SRC:SCSO",
        "CALL:Traffic Stop",
        "ADDR:S 50 E",
        "CITY:COALVILLE",
        "UNIT:SCZ2,K71",
        "INFO:10-60");

    doTest("T52",
        "SCSO\nTraffic Stop\nN SILVER CREEK DR & N PROMONTORY RANCH R,PC\nSCZ3\nK55\n10-60 whi ford x1",
        "SRC:SCSO",
        "CALL:Traffic Stop",
        "ADDR:N SILVER CREEK DR & N PROMONTORY RANCH R",
        "CITY:PARK CITY",
        "UNIT:SCZ3,K55",
        "INFO:10-60 whi ford x1");

    doTest("T53",
        "SCSO\nTraffic Stop\nsr32 & oakley downs rd @\nZULU2\nK71\n 10-60",
        "SRC:SCSO",
        "CALL:Traffic Stop",
        "ADDR:sr32 & oakley downs rd",
        "MADDR:UT 32 & oakley downs rd",
        "UNIT:ZULU2,K71",
        "INFO:10-60");

    doTest("T54",
        "SCSO\nTraffic Stop\n1390 S HOYTSVILLE RD,HOY\nSCZ2\nK71\n 10-60",
        "SRC:SCSO",
        "CALL:Traffic Stop",
        "ADDR:1390 S HOYTSVILLE RD",
        "CITY:HOYTSVILLE",
        "UNIT:SCZ2,K71",
        "INFO:10-60");

    doTest("T55",
        "PCFD\nFire Alrm Comml\n1305 LOWELL AVE,PCC\nPCFD\nE31\nmarriot resorts. POA water flow alarm. 435 940 2000. RP is pending.",
        "SRC:PCFD",
        "CALL:Fire Alrm Comml",
        "ADDR:1305 LOWELL AVE",
        "CITY:PARK CITY",
        "UNIT:E31",
        "INFO:marriot resorts. POA water flow alarm. 435 940 2000. RP is pending.");

    doTest("T56",
        "PCFD\nMedical Aid\n15 PROSPECTOR DR,PCC\nPCFD\nE38\n82 yo female that has pain in her stomach.",
        "SRC:PCFD",
        "CALL:Medical Aid",
        "ADDR:15 PROSPECTOR DR",
        "CITY:PARK CITY",
        "UNIT:E38",
        "INFO:82 yo female that has pain in her stomach.");

    doTest("T57",
        "UHP\n" +
        "Injury Accident\n" +
        "146 I80 EASTBOUND,PC\n" +
        "UHP\n" +
        "563\n" +
        "four car accident two black cars, 1 blue car, 1 white car. Non injuries, not\n" +
        "blocking.\n" +
        "16:27:06 06/15/2012 - Pyper J\n" +
        "white jetta 21 yof c/b/a complaining of neck pain\n" +
        "16:28:02 06/15/2012 - Pyper J\n" +
        "comp in the white jetta needs a tow 610h9 Matt Strader 435",

        "SRC:UHP",
        "CALL:Injury Accident",
        "ADDR:146 I80 EB",
        "MADDR:146 I 80",
        "CITY:PARK CITY",
        "UNIT:563",
        "INFO:four car accident two black cars, 1 blue car, 1 white car. Non injuries, not / blocking. / 16:27:06 06/15/2012 - Pyper J / white jetta 21 yof c/b/a complaining of neck pain / 16:28:02 06/15/2012 - Pyper J / comp in the white jetta needs a tow 610h9 Matt Strader 435");

    doTest("T58",
        "PCFD\n" +
        "Medical Aid\n" +
        "1800 PARK AVE,PCC\n" +
        "PCFD\n" +
        "A31\n" +
        "17:16:46 06/15/2012 - Odenbach T\n" +
        "ProQA Medical Recommended Dispatch Level = 21A01\n" +
        "23 year old, Female, Conscious, Breathing.  Hemorrhage / Lacerations.  NOT DANGEROUS hemorrhage.  Caller Statement: intoxicated female with blood on her.\n" +
        " 1. She is complete",

        "SRC:PCFD",
        "CALL:Medical Aid",
        "ADDR:1800 PARK AVE",
        "CITY:PARK CITY",
        "UNIT:A31",
        "INFO:17:16:46 06/15/2012 - Odenbach T / ProQA Medical Recommended Dispatch Level = 21A01 / 23 year old, Female, Conscious, Breathing.  Hemorrhage / Lacerations.  NOT DANGEROUS hemorrhage.  Caller Statement: intoxicated female with blood on her. / 1. She is complete");

    doTest("T59",
        "PCFD\n" +
        "Medical Aid\n" +
        "4045 W HILLTOP CT; HILLTOP CT,PC\n" +
        "PCFD\n" +
        "A35\n" +
        "18:13:13 06/15/2012 - Odenbach T\n" +
        "ProQA Medical Recommended Dispatch Level = 31D02\n" +
        "32 year old, Male, Unconscious, Breathing.  Unconscious / Fainting (Near).  Unconscious -- Effective breathing.  Caller Statement: siezure.\n" +
        " 1. His breathing is not complete",

        "SRC:PCFD",
        "CALL:Medical Aid",
        "ADDR:4045 W HILLTOP CT",
        "X:HILLTOP CT",
        "CITY:PARK CITY",
        "UNIT:A35",
        "INFO:18:13:13 06/15/2012 - Odenbach T / ProQA Medical Recommended Dispatch Level = 31D02 / 32 year old, Male, Unconscious, Breathing.  Unconscious / Fainting (Near).  Unconscious -- Effective breathing.  Caller Statement: siezure. / 1. His breathing is not complete");

    doTest("T60",
        "PCFD\nFire Alrm Comml\n7620 ROYAL ST E,PCC\nPCFD\nE34\nDeer Valley Resort 615-6395 - POA: GENERAL - DT: 18:32 - RP: Pending",
        "SRC:PCFD",
        "CALL:Fire Alrm Comml",
        "ADDR:7620 ROYAL ST E",
        "CITY:PARK CITY",
        "UNIT:E34",
        "INFO:Deer Valley Resort 615-6395 - POA: GENERAL - DT: 18:32 - RP: Pending");

    doTest("T61",
        "PCFD\n" +
        "Medical Aid\n" +
        "373 GILLMOR WAY,PCC\n" +
        "PCFD\n" +
        "A31\n" +
        "lower baseball south east field - near where the diamond and grass meet \n" +
        "18:49:26 06/15/2012 - Peterson T B\n" +
        "ProQA Medical Recommended Dispatch Level = 30B01\n" +
        "12 year old, Male, Conscious, Breathing.  Traumatic Injuries (Specific).  POSSIBLY DANGEROUS body",

        "SRC:PCFD",
        "CALL:Medical Aid",
        "ADDR:373 GILLMOR WAY",
        "CITY:PARK CITY",
        "UNIT:A31",
        "INFO:lower baseball south east field - near where the diamond and grass meet / 18:49:26 06/15/2012 - Peterson T B / ProQA Medical Recommended Dispatch Level = 30B01 / 12 year old, Male, Conscious, Breathing.  Traumatic Injuries (Specific).  POSSIBLY DANGEROUS body");

    doTest("T62",
        "PCFD\nFire Alrm Comml\n710 MAIN ST,PCC\nPCFD\nE38\nMarriott Summit Watch - POA: Ontario Bldg - DT: 19:15 - RP: Pending.",
        "SRC:PCFD",
        "CALL:Fire Alrm Comml",
        "ADDR:710 MAIN ST",
        "CITY:PARK CITY",
        "UNIT:E38",
        "INFO:Marriott Summit Watch - POA: Ontario Bldg - DT: 19:15 - RP: Pending.");

    doTest("T63",
        "NSFD\n" +
        "Brush Fire\n" +
        "169 I80 WESTBOUND,COA\n" +
        "NSFD\n" +
        "NSFD\n" +
        "east of echo on i80 on the tracks\n" +
        "15:08:50 06/15/2012 - Pyper J\n" +
        "union pacific notified they will stop the trains\n" +
        "15:32:31 06/15/2012 - Pyper J\n" +
        "fire contained at this time\n" +
        "17:22:58 06/15/2012 - Pyper J\n" +
        "have reopened the railroad at reduced speed rp on scen",

        "SRC:NSFD",
        "CALL:Brush Fire",
        "ADDR:169 I80 WB",
        "MADDR:169 I 80",
        "CITY:COALVILLE",
        "INFO:east of echo on i80 on the tracks / 15:08:50 06/15/2012 - Pyper J / union pacific notified they will stop the trains / 15:32:31 06/15/2012 - Pyper J / fire contained at this time / 17:22:58 06/15/2012 - Pyper J / have reopened the railroad at reduced speed rp on scen");

    doTest("T64",
        "PCFD\nMedical Aid\n1010 WOODSIDE AVE,PCC\nPCFD\nA31\n11 yom fell skate boarding - c/dif breathing/ alert",
        "SRC:PCFD",
        "CALL:Medical Aid",
        "ADDR:1010 WOODSIDE AVE",
        "CITY:PARK CITY",
        "UNIT:A31",
        "INFO:11 yom fell skate boarding - c/dif breathing/ alert");

    doTest("T65",
        "PCFD\nMedical Aid\n1456 W NEWPARK BLVD,PC\nPCFD\nA35",
        "SRC:PCFD",
        "CALL:Medical Aid",
        "ADDR:1456 W NEWPARK BLVD",
        "CITY:PARK CITY",
        "UNIT:A35");

    doTest("T66",
        "PCFD\nMedical Aid\nW NEWPARK BLVD,PC\nPCFD\nA37\nmale indv votiming c/b/a",
        "SRC:PCFD",
        "CALL:Medical Aid",
        "ADDR:W NEWPARK BLVD",
        "CITY:PARK CITY",
        "UNIT:A37",
        "INFO:male indv votiming c/b/a");

    doTest("T67",
        "UHP\nInjury Accident\nSR189,HEB\nUHP\n448\n22:36:49 06/15/2012 - Harrison S\nProQA Medical Case C12-41360 Aborted: 9. Test case",
        "SRC:UHP",
        "CALL:Injury Accident",
        "ADDR:SR189",
        "MADDR:UT 189",
        "CITY:HEBER",
        "UNIT:448",
        "INFO:22:36:49 06/15/2012 - Harrison S / ProQA Medical Case C12-41360 Aborted: 9. Test case");

    doTest("T68",
        "UHP\n" +
        "Missing Person\n" +
        "MIRROR LAKE HWY,EVA\n" +
        "UHP\n" +
        "K30\n" +
        "Male in sil gmc sierra/called evanston saying he has lost his wife and is\n" +
        "disoriented and confused/unk if she was in a vehicle or if she is hiking\n" +
        "around/is somewhere on the road to whitney res near bear river service on mirror\n" +
        "lake highway",

        "SRC:UHP",
        "CALL:Missing Person",
        "ADDR:MIRROR LAKE HWY",
        "CITY:KAMAS",
        "UNIT:K30",
        "INFO:Male in sil gmc sierra/called evanston saying he has lost his wife and is / disoriented and confused/unk if she was in a vehicle or if she is hiking / around/is somewhere on the road to whitney res near bear river service on mirror / lake highway");

    doTest("T69",
        "SCSO\nSearch/Rescue\nMIRROR LAKE HWY,KAM\nUHP\nS52",
        "SRC:SCSO",
        "CALL:Search/Rescue",
        "ADDR:MIRROR LAKE HWY",
        "CITY:KAMAS",
        "UNIT:UHP,S52");

    doTest("T70",
        "SAR \nSAR Training\nSoapstone Guard Station,KAM\nSCZ4\nS24\nTraining until tomorrow sometime",
        "SRC:SAR",
        "CALL:SAR Training",
        "ADDR:Soapstone Guard Station",
        "CITY:KAMAS",
        "UNIT:SCZ4,S24",
        "INFO:Training until tomorrow sometime");

    doTest("T71",
        "SCSO\n" +
        "Missing Person\n" +
        "9 MIRROR LAKE HWY; U150,KAM\n" +
        "UHP\n" +
        "S52\n" +
        "three missing teenagers two male, one female that have been missing for three\n" +
        "hrs.",

        "SRC:SCSO",
        "CALL:Missing Person",
        "ADDR:9 MIRROR LAKE HWY",
        "X:U150",
        "CITY:KAMAS",
        "UNIT:UHP,S52",
        "INFO:three missing teenagers two male, one female that have been missing for three / hrs.");

    doTest("T72",
        "SAR \nSAR Training\nSoapstone Guard Station,KAM\nSCZ4\nS24\nTraining until tomorrow sometime",
        "SRC:SAR",
        "CALL:SAR Training",
        "ADDR:Soapstone Guard Station",
        "CITY:KAMAS",
        "UNIT:SCZ4,S24",
        "INFO:Training until tomorrow sometime");

    doTest("T73",
        "SCSO\n" +
        "Missing Person\n" +
        "100 E CENTER ST,KAM\n" +
        "SCSO\n" +
        "K54\n" +
        "K54 advised some people rolled up on me and advised their father is missing.  \n" +
        "License Number:  1953549  Sex:  M \n" +
        "ID Number:   Height:  511 \n" +
        "Name:  VERN A CARTER  Weight:  195 \n" +
        "Address:  13800 WEST 3800 NORTH\n" +
        "TABIONA, UT 84072 Eye:  BLU \n" +
        "Last Address Upda",

        "SRC:SCSO",
        "CALL:Missing Person",
        "ADDR:100 E CENTER ST",
        "CITY:KAMAS",
        "UNIT:K54",
        "INFO:K54 advised some people rolled up on me and advised their father is missing. / License Number:  1953549  Sex:  M / ID Number:   Height:  511 / Name:  VERN A CARTER  Weight:  195 / Address:  13800 WEST 3800 NORTH / TABIONA, UT 84072 Eye:  BLU / Last Address Upda");

    doTest("T74",
        "SCSO\n" +
        "Search/Rescue\n" +
        "HOYTS CANYON,KAM\n" +
        "SCZ4\n" +
        "K10\n" +
        "82 yom missing. Made contact with a friend Don Soyer last night around 00:00 and\n" +
        "stated he was up Hoyts Peak near the Lost Mine and he was stuck and his phone\n" +
        "was going to die.",

        "SRC:SCSO",
        "CALL:Search/Rescue",
        "ADDR:HOYTS CANYON",
        "CITY:KAMAS",
        "UNIT:SCZ4,K10",
        "INFO:82 yom missing. Made contact with a friend Don Soyer last night around 00:00 and / stated he was up Hoyts Peak near the Lost Mine and he was stuck and his phone / was going to die.");

    doTest("T75",
        "SCSO\n" +
        "Missing Person\n" +
        "CRESTVIEW DR,PC\n" +
        "SCZ5\n" +
        "K56\n" +
        "Christopher Goode been missing for two weeks, last seen a month ago. Has been in\n" +
        "California until 2 weeks ago, unable to make contact with him for two weeks,\n" +
        "phone is shut off. Might still be in California but not known. Working around\n" +
        "Tahoe.",

        "SRC:SCSO",
        "CALL:Missing Person",
        "ADDR:CRESTVIEW DR",
        "CITY:PARK CITY",
        "UNIT:SCZ5,K56",
        "INFO:Christopher Goode been missing for two weeks, last seen a month ago. Has been in / California until 2 weeks ago, unable to make contact with him for two weeks, / phone is shut off. Might still be in California but not known. Working around / Tahoe.");

    doTest("T76",
        "UHP\n" +
        "Missing Person\n" +
        "E MIRROR LAKE HWY,KAM\n" +
        "UHP\n" +
        "K43\n" +
        "Comp has Tukwila Police Dept in Tukwila Washington have started a report #124572\n" +
        "Caller stated Summit county pinged the cell phone last night and it came from\n" +
        "the great lakes area last night close to midnight.\n\n" +
        "**It is imperative to get the person's cell",

        "SRC:UHP",
        "CALL:Missing Person",
        "ADDR:E MIRROR LAKE HWY",
        "CITY:KAMAS",
        "UNIT:K43",
        "INFO:Comp has Tukwila Police Dept in Tukwila Washington have started a report #124572 / Caller stated Summit county pinged the cell phone last night and it came from / the great lakes area last night close to midnight. / **It is imperative to get the person's cell");

    doTest("T77",
        "PCFD\n" +
        "Brush Fire\n" +
        "2466 MEADOWS DR,PCC\n" +
        "PCFD\n" +
        "E31\n" +
        "Brush fire below Meadows Dr on the west side of Park Meadows, no flames seen\n" +
        "19:17:40 06/28/2012 - Hewitt H       \n" +
        "Near Eagle Point",

        "SRC:PCFD",
        "CALL:Brush Fire",
        "ADDR:2466 MEADOWS DR",
        "CITY:PARK CITY",
        "UNIT:E31",
        "INFO:Brush fire below Meadows Dr on the west side of Park Meadows, no flames seen / 19:17:40 06/28/2012 - Hewitt H / Near Eagle Point");
  }
  
  public static final void main(String[] args) {
    new UTSummitCountyParserTest().generateTests("T1");
  }
}