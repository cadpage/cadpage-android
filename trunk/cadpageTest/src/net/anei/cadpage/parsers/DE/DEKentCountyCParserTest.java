package net.anei.cadpage.parsers.DE;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class DEKentCountyCParserTest extends BaseParserTest {
  
  public DEKentCountyCParserTest() {
    setParser(new DEKentCountyCParser(), "KENT COUNTY", "DE");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Incident Alert)Unit:A64 Status:Dispatched 26A10 Sick Person - Unwell/Ill 125 CENTURY DR Venue: Smyrna Dev/Sub: BRENFORD WOODS Xst's: NEEDHAM DR / NEEDHAM DR Caller: MASS LEXIS",
        "UNIT:A64",
        "CODE:26A10",
        "CALL:Sick Person - Unwell/Ill",
        "ADDR:125 CENTURY DR",
        "PLACE:BRENFORD WOODS",
        "CITY:Smyrna",
        "X:NEEDHAM DR / NEEDHAM DR",
        "NAME:MASS LEXIS");

    doTest("T2",
        "(Incident Alert)Unit:A41 Status:Dispatched 10C1 Chest Pains 73 WYNN WOOD CIR  Venue: Camden Wyoming Dev/Sub: WYNN WOOD Xst's: SPRING RIDGE WAY / SADDLEBROOK DR, S WYNN WOOD CIR Caller: TOMPKINS WAYNE",
        "UNIT:A41",
        "CODE:10C1",
        "CALL:Chest Pains",
        "ADDR:73 WYNN WOOD CIR",
        "PLACE:WYNN WOOD",
        "CITY:Camden Wyoming",
        "X:SPRING RIDGE WAY / SADDLEBROOK DR, S WYNN WOOD CIR",
        "NAME:TOMPKINS WAYNE");

    doTest("T3",
        "(Incident Alert)Unit:B64 Status:Dispatched 33C5T Transfer/Interfacility 1181 PADDOCK RD JAMES T VAUGHN CORRECTIONAL CENTER Venue: Smyrna Dev/Sub: Xst's: DELAWARE DEPT OF CORRECTION CT / MC QUAIL RD Caller: PHYLIS",
        "UNIT:B64",
        "CODE:33C5T",
        "CALL:Transfer/Interfacility",
        "ADDR:1181 PADDOCK RD",
        "PLACE:JAMES T VAUGHN CORRECTIONAL CENTER",
        "CITY:Smyrna",
        "X:DELAWARE DEPT OF CORRECTION CT / MC QUAIL RD",
        "NAME:PHYLIS");

    doTest("T4",
        "(Incident Alert)Unit:A42 Status:Dispatched 4B3A Assault - Unknown 5 N  WASHINGTON ST PARK PLACE LOUNGE Venue: Milford Dev/Sub: Xst's: PARK AVE / S WASHINGTON ST Caller:",
        "UNIT:A42",
        "CODE:4B3A",
        "CALL:Assault - Unknown",
        "ADDR:5 N WASHINGTON ST",
        "PLACE:PARK PLACE LOUNGE",
        "CITY:Milford",
        "X:PARK AVE / S WASHINGTON ST");

    doTest("T5",
        "(Incident Alert)Unit:A41 Status:Dispatched 17B1G Falls - Possibly Dangerous 561 N  DUPONT HWY HOLIDAY INN DOVER Venue: Dover Dev/Sub: Xst's: JEFFERIC BLVD / TOWNSEND BLVD Caller: DEBB LESEX",
        "UNIT:A41",
        "CODE:17B1G",
        "CALL:Falls - Possibly Dangerous",
        "ADDR:561 N DUPONT HWY",
        "PLACE:HOLIDAY INN DOVER",
        "CITY:Dover",
        "X:JEFFERIC BLVD / TOWNSEND BLVD",
        "NAME:DEBB LESEX");

    doTest("T6",
        "(Incident Alert)Unit:46F1 Status:Dispatched Outside Fire-Small 1788 N  DUPONT HWY MCDONALDS SCARBOROUGH RD Venue: Dover Dev/Sub: Xst's: HOLIDAY BLVD / CEDAR CHASE DR Caller:",
        "UNIT:46F1",
        "CALL:Outside Fire-Small",
        "ADDR:1788 N DUPONT HWY",
        "PLACE:MCDONALDS SCARBOROUGH RD",
        "CITY:Dover",
        "X:HOLIDAY BLVD / CEDAR CHASE DR");

    doTest("T7",
        "(Incident Alert)Unit:A42 Status:Dispatched 21D3 Hemorrhage - Dangerous 204 ASHLEY WAY  Venue: Milford Dev/Sub: THE VILLAS AT MILFORD CROSSING Xst's: UNKNOWN / MOYER CIR E Caller: FULLER SHIRLEY",
        "UNIT:A42",
        "CODE:21D3",
        "CALL:Hemorrhage - Dangerous",
        "ADDR:204 ASHLEY WAY",
        "PLACE:THE VILLAS AT MILFORD CROSSING",
        "CITY:Milford",
        "X:UNKNOWN / MOYER CIR E",
        "NAME:FULLER SHIRLEY");

    doTest("T8",
        "(Incident Alert)Unit:46F1 Status:Dispatched Vehicle Fire 201 STOVER BLVD MAIN STAY SUITES Venue: Dover Dev/Sub: STOVER Xst's: BAY RD / KRISKO CIR Caller: EAGLE HOSPITALITY ( MAINSTAY S",
        "UNIT:46F1",
        "CALL:Vehicle Fire",
        "ADDR:201 STOVER BLVD",
        "PLACE:MAIN STAY SUITES - STOVER",
        "CITY:Dover",
        "X:BAY RD / KRISKO CIR",
        "NAME:EAGLE HOSPITALITY ( MAINSTAY S");

    doTest("T9",
        "(Incident Alert)Unit:A51 Status:Dispatched Electrical Hazard-Wire Down ARTHURSVILLE RD  Venue: Clayton Dev/Sub: Xst's: Caller: DIMEO FRED",
        "UNIT:A51",
        "CALL:Electrical Hazard-Wire Down",
        "ADDR:ARTHURSVILLE RD",
        "CITY:Clayton",
        "NAME:DIMEO FRED");

    doTest("T10",
        "(Incident Alert)Unit:P51F Status:Dispatched Electrical Hazard-Wire Down ARTHURSVILLE RD  Venue: Clayton Dev/Sub: Xst's: Caller: DIMEO FRED",
        "UNIT:P51F",
        "CALL:Electrical Hazard-Wire Down",
        "ADDR:ARTHURSVILLE RD",
        "CITY:Clayton",
        "NAME:DIMEO FRED");

    doTest("T11",
        "(Incident Alert)Unit:A41 Status:Dispatched 6D2 Breathing Problems 425 MANNERING DR  Venue: Dover Dev/Sub: GRAND OAKS Xst's: DEAD END / LADY CT Caller: DAMATO",
        "UNIT:A41",
        "CODE:6D2",
        "CALL:Breathing Problems",
        "ADDR:425 MANNERING DR",
        "PLACE:GRAND OAKS",
        "CITY:Dover",
        "X:DEAD END / LADY CT",
        "NAME:DAMATO");

    doTest("T12",
        "(Incident Alert)Unit:B64 Status:Dispatched 31A3 Fainting Episode 436 GREENS BRANCH LN  Venue: Smyrna Dev/Sub: EAGLE CHASE Xst's: EAGLE WAY / N HIGH ST Caller: WINGFIELD",
        "UNIT:B64",
        "CODE:31A3",
        "CALL:Fainting Episode",
        "ADDR:436 GREENS BRANCH LN",
        "PLACE:EAGLE CHASE",
        "CITY:Smyrna",
        "X:EAGLE WAY / N HIGH ST",
        "NAME:WINGFIELD");

    doTest("T13",
        "(Incident Alert)Unit:A42 Status:Dispatched 26A11 Sick Person - Vomiting 47 LADY SLIPPER LN  Venue: Milford Dev/Sub: SARAGLEN ACRES Xst's: DEAD END / JONQUIL CT Caller: MALANIO JOSIE",
        "UNIT:A42",
        "CODE:26A11",
        "CALL:Sick Person - Vomiting",
        "ADDR:47 LADY SLIPPER LN",
        "PLACE:SARAGLEN ACRES",
        "CITY:Milford",
        "X:DEAD END / JONQUIL CT",
        "NAME:MALANIO JOSIE");

    doTest("T14",
        "(Incident Alert)Unit:A64 Status:Dispatched 6D1 Breathing Problems  197 SPENCER DR  Venue: Clayton Dev/Sub: Xst's: BLACKISTON RD / BLACKISTON RD Caller: LEAGER MONICA",
        "UNIT:A64",
        "CODE:6D1",
        "CALL:Breathing Problems",
        "ADDR:197 SPENCER DR",
        "CITY:Clayton",
        "X:BLACKISTON RD / BLACKISTON RD",
        "NAME:LEAGER MONICA");

    doTest("T15",
        "(Incident Alert)Unit:B64 Status:Dispatched 31A1 Fainting Episode 169 PADDOCK RD  Venue: Townsend Dev/Sub: Xst's: THOROUGHFARE NECK RD / FLEMINGS LANDING RD Caller: WICKS DEBBIE",
        "UNIT:B64",
        "CODE:31A1",
        "CALL:Fainting Episode",
        "ADDR:169 PADDOCK RD",
        "CITY:Townsend",
        "X:THOROUGHFARE NECK RD / FLEMINGS LANDING RD",
        "NAME:WICKS DEBBIE");

    doTest("T16",
        "(Incident Alert)Unit:C50 Status:Dispatched 9B1A - Obvious Death 2628 VERNON RD  Venue: Harrington Dev/Sub: Xst's: CATTAIL BRANCH RD / WELCH RD Caller: CARTER PAUL",
        "UNIT:C50",
        "CODE:9B1A",
        "CALL:Obvious Death",
        "ADDR:2628 VERNON RD",
        "CITY:Harrington",
        "X:CATTAIL BRANCH RD / WELCH RD",
        "NAME:CARTER PAUL");

    doTest("T17",
        "(Incident Alert)Unit:46F3 Status:Dispatched Alarms-Commercial 1294 FORREST AVE BETSY ROSS PIZZA FORREST AVE Venue: Dover Dev/Sub: Xst's: S INDEPENDENCE BLVD, INDEPENDENCE BLVD / KENTON RD Caller:",
        "UNIT:46F3",
        "CALL:Alarms-Commercial",
        "ADDR:1294 FORREST AVE",
        "PLACE:BETSY ROSS PIZZA FORREST AVE",
        "CITY:Dover",
        "X:S INDEPENDENCE BLVD, INDEPENDENCE BLVD / KENTON RD");

    doTest("T18",
        "(Incident Alert)Unit:A41 Status:Dispatched 23O1A Overdose/Poisoning WILLOW GROVE RD  Venue: Camden Wyoming Dev/Sub: Xst's: Caller: STACEY CRYSTAL",
        "UNIT:A41",
        "CODE:23O1A",
        "CALL:Overdose/Poisoning WILLOW",
        "ADDR:GROVE RD",
        "CITY:Camden Wyoming",
        "NAME:STACEY CRYSTAL");

    doTest("T19",
        "(Incident Alert)Unit:B53 Status:Dispatched 17B3 Falls - Unknown 6394 W DENNEYS RD  Venue: Dover Dev/Sub: Xst's: JPS DR / JOSIE AVE Caller: M BLANCHARD",
        "UNIT:B53",
        "CODE:17B3",
        "CALL:Falls - Unknown",
        "ADDR:6394 W DENNEYS RD",
        "CITY:Dover",
        "X:JPS DR / JOSIE AVE",
        "NAME:M BLANCHARD");

    doTest("T20",
        "(Incident Alert)Unit:P53E Status:Dispatched 17B3 Falls - Unknown 6394 W DENNEYS RD  Venue: Dover Dev/Sub: Xst's: JPS DR / JOSIE AVE Caller: M BLANCHARD",
        "UNIT:P53E",
        "CODE:17B3",
        "CALL:Falls - Unknown",
        "ADDR:6394 W DENNEYS RD",
        "CITY:Dover",
        "X:JPS DR / JOSIE AVE",
        "NAME:M BLANCHARD");

    doTest("T21",
        "(Incident Alert)Unit:B50 Status:Dispatched 17A1G Falls - Not Dangerous  42 CHAMBERS CIR HARRINGTON CASINO Venue: Harrington Dev/Sub: STATE FAIR GROUNDS Xst's: WILLIAM M CHAMBERS JR RD / WILLIAM M CHAMBERS JR RD Caller: HAYES PAUL",
        "UNIT:B50",
        "CODE:17A1G",
        "CALL:Falls - Not Dangerous",
        "ADDR:42 CHAMBERS CIR",
        "PLACE:HARRINGTON CASINO - STATE FAIR GROUNDS",
        "CITY:Harrington",
        "X:WILLIAM M CHAMBERS JR RD / WILLIAM M CHAMBERS JR RD",
        "NAME:HAYES PAUL");

    doTest("T22",
        "(Incident Alert)Unit:A64 Status:Dispatched 26A10 Sick Person - Unwell/Ill 910 APPLEBERRY DR  Venue: Smyrna Dev/Sub: BON AYRE  Xst's: DYLAN ST / DAIRY DR, SAKS ST Caller: KRASAVAGE MARTIN",
        "UNIT:A64",
        "CODE:26A10",
        "CALL:Sick Person - Unwell/Ill",
        "ADDR:910 APPLEBERRY DR",
        "PLACE:BON AYRE",
        "CITY:Smyrna",
        "X:DYLAN ST / DAIRY DR, SAKS ST",
        "NAME:KRASAVAGE MARTIN");

    doTest("T23",
        "(Incident Alert)Unit:478 Status:Dispatched 17B1G Falls - Possibly Dangerous 618 PROSPECT CHURCH RD  Venue: Harrington Dev/Sub: Xst's: TODDS CHAPEL RD, ANDREWVILLE RD / HAMMONDTOWN RD Caller: CANNON JIM",
        "UNIT:478",
        "CODE:17B1G",
        "CALL:Falls - Possibly Dangerous",
        "ADDR:618 PROSPECT CHURCH RD",
        "CITY:Harrington",
        "X:TODDS CHAPEL RD, ANDREWVILLE RD / HAMMONDTOWN RD",
        "NAME:CANNON JIM");

    doTest("T24",
        "(Incident Alert)Unit:C50 Status:Dispatched 17B1G Falls - Possibly Dangerous 618 PROSPECT CHURCH RD  Venue: Harrington Dev/Sub: Xst's: TODDS CHAPEL RD, ANDREWVILLE RD / HAMMONDTOWN RD Caller: CANNON JIM",
        "UNIT:C50",
        "CODE:17B1G",
        "CALL:Falls - Possibly Dangerous",
        "ADDR:618 PROSPECT CHURCH RD",
        "CITY:Harrington",
        "X:TODDS CHAPEL RD, ANDREWVILLE RD / HAMMONDTOWN RD",
        "NAME:CANNON JIM");

    doTest("T25",
        "(Incident Alert)Unit:P50F Status:Dispatched Citizen Assist/Service Call  7250 MILFORD HARRINGTON HWY ROYAL FARMS- HARRINGTON Venue: Harrington Dev/Sub: Xst's: CLARK ST, S DUPONT HWY / S DUPONT HWY Caller:",
        "UNIT:P50F",
        "CALL:Citizen Assist/Service Call",
        "ADDR:7250 MILFORD HARRINGTON HWY",
        "PLACE:ROYAL FARMS- HARRINGTON",
        "CITY:Harrington",
        "X:CLARK ST, S DUPONT HWY / S DUPONT HWY");

    doTest("T26",
        "(Incident Alert)Unit:A50 Status:Dispatched 17A2G Falls - Non Recent 502 MASON AVE  Venue: Harrington Dev/Sub: Xst's: MADISON AVE / DEAD END Caller: S STIERS",
        "UNIT:A50",
        "CODE:17A2G",
        "CALL:Falls - Non Recent",
        "ADDR:502 MASON AVE",
        "CITY:Harrington",
        "X:MADISON AVE / DEAD END",
        "NAME:S STIERS");

    doTest("T27",
        "(Incident Alert)Unit:A41 Status:Dispatched 26A8 Sick Person - Other Pain 1750 S  TAYLOR DR  Venue: Dover Dev/Sub: TAYLOR ESTATES Xst's: N TAYLOR DR, LAKEVIEW AVE / S DUPONT HWY Caller: WINCHELL",
        "UNIT:A41",
        "CODE:26A8",
        "CALL:Sick Person - Other Pain",
        "ADDR:1750 S TAYLOR DR",
        "PLACE:TAYLOR ESTATES",
        "CITY:Dover",
        "X:N TAYLOR DR, LAKEVIEW AVE / S DUPONT HWY",
        "NAME:WINCHELL");

    doTest("T28",
        "(Incident Alert)Unit:A41 Status:Dispatched 24B1 Pregnancy 3036 UPPER KING RD TROOP 3 Venue: Dover Dev/Sub: Xst's: DERBY WOOD CIR / BISON RD Caller:",
        "UNIT:A41",
        "CODE:24B1",
        "CALL:Pregnancy",
        "ADDR:3036 UPPER KING RD",
        "PLACE:TROOP 3",
        "CITY:Dover",
        "X:DERBY WOOD CIR / BISON RD");

    doTest("T29",
        "(Incident Alert)Unit:46F4 Status:Dispatched Structure-Chimney  1401 S FARMVIEW DR  Venue: Dover Dev/Sub: Xst's: WOODMILL DR / S INDEPENDENCE BLVD Caller:",
        "UNIT:46F4",
        "CALL:Structure-Chimney",
        "ADDR:1401 S FARMVIEW DR",
        "CITY:Dover",
        "X:WOODMILL DR / S INDEPENDENCE BLVD");

    doTest("T30",
        "(Incident Alert)Unit:A64 Status:Dispatched 32B2 - Medic Alert 612 SAKS ST  Venue: Smyrna Dev/Sub: BON AYRE  Xst's: STELLA ST / RADNOR LN Caller:",
        "UNIT:A64",
        "CODE:32B2",
        "CALL:Medic Alert",
        "ADDR:612 SAKS ST",
        "PLACE:BON AYRE",
        "CITY:Smyrna",
        "X:STELLA ST / RADNOR LN");

    doTest("T31",
        "(Incident Alert)Unit:A42 Status:Dispatched 30A1 Traumatic Injury SE FRONT ST  Venue: Milford Dev/Sub: Xst's: Caller: JOHN",
        "UNIT:A42",
        "CODE:30A1",
        "CALL:Traumatic Injury",
        "ADDR:SE FRONT ST",
        "CITY:Milford",
        "NAME:JOHN");

    doTest("T32",
        "(Incident Alert)Unit:A41 Status:Dispatched 6D1 Breathing Problems  688 S  WYNN WOOD CIR  Venue: Camden Wyoming Dev/Sub: WYNN WOOD Xst's: WILDMEADOW LN / DEAD END Caller: G WITT",
        "UNIT:A41",
        "CODE:6D1",
        "CALL:Breathing Problems",
        "ADDR:688 S WYNN WOOD CIR",
        "PLACE:WYNN WOOD",
        "CITY:Camden Wyoming",
        "X:WILDMEADOW LN / DEAD END",
        "NAME:G WITT");

    doTest("T33",
        "(Incident Alert)Unit:A64 Status:Dispatched 1C4 Abdominal Pains 306 BIG OAK RD  Venue: Smyrna Dev/Sub: Xst's: STATE HWY 1 / PIER HEAD BLVD Caller: CONLON TIM",
        "UNIT:A64",
        "CODE:1C4",
        "CALL:Abdominal Pains",
        "ADDR:306 BIG OAK RD",
        "CITY:Smyrna",
        "X:STATE HWY 1 / PIER HEAD BLVD",
        "NAME:CONLON TIM");

    doTest("T34",
        "(Incident Alert)Unit:A64 Status:Dispatched 17A1G Falls - Not Dangerous  6 REHOBOTH CIR  Venue: Clayton Dev/Sub: CLAYTON COURTS MHP Xst's: DEAD END / CLAYTON DR Caller: HUTTON",
        "UNIT:A64",
        "CODE:17A1G",
        "CALL:Falls - Not Dangerous",
        "ADDR:6 REHOBOTH CIR",
        "PLACE:CLAYTON COURTS MHP",
        "CITY:Clayton",
        "X:DEAD END / CLAYTON DR",
        "NAME:HUTTON");

    doTest("T35",
        "(Incident Alert)Unit:A42 Status:Dispatched 13C1 Diabetic - Not Alert 7190 WILKINS RD  Venue: Milford Dev/Sub: Xst's: CEDAR CREEK RD / GREGORY BLVD Caller: DILLON MARY",
        "UNIT:A42",
        "CODE:13C1",
        "CALL:Diabetic - Not Alert",
        "ADDR:7190 WILKINS RD",
        "CITY:Milford",
        "X:CEDAR CREEK RD / GREGORY BLVD",
        "NAME:DILLON MARY");

    doTest("T36",
        "(Incident Alert)Unit:P41F Status:Dispatched Alarms-Commercial 140 SOUTHERN BLVD WYOMING CONCRETE Venue: Camden Wyoming Dev/Sub: WYOMING Xst's: PINE ST / S LAYTON AVE Caller: 73",
        "UNIT:P41F",
        "CALL:Alarms-Commercial",
        "ADDR:140 SOUTHERN BLVD",
        "PLACE:WYOMING CONCRETE - WYOMING",
        "CITY:Camden Wyoming",
        "X:PINE ST / S LAYTON AVE",
        "NAME:73");

    doTest("T37",
        "(Incident Alert)Unit:A42 Status:Dispatched 13C1 Diabetic - Not Alert 111 LOVERS LN  Venue: Milford Dev/Sub: Xst's: BERRY LN / SE 2ND ST Caller: PD MILFORD",
        "UNIT:A42",
        "CODE:13C1",
        "CALL:Diabetic - Not Alert",
        "ADDR:111 LOVERS LN",
        "CITY:Milford",
        "X:BERRY LN / SE 2ND ST",
        "NAME:PD MILFORD");

    doTest("T38",
        "(Incident Alert)Unit:A64 Status:Dispatched 33C5T Transfer/Interfacility 3034 S  DUPONT BLVD PINNACLE HEALTH AND REHAB CTR  Venue: Smyrna Dev/Sub: Xst's: UNKNOWN / VILLAGE DR Caller: KARNAO JASON",
        "UNIT:A64",
        "CODE:33C5T",
        "CALL:Transfer/Interfacility",
        "ADDR:3034 S DUPONT BLVD",
        "PLACE:PINNACLE HEALTH AND REHAB CTR",
        "CITY:Smyrna",
        "X:UNKNOWN / VILLAGE DR",
        "NAME:KARNAO JASON");

    doTest("T39",
        "(Incident Alert)Unit:46F2 Status:Dispatched Alarms-Commercial 644 S  QUEEN ST  Venue: Dover Dev/Sub: Xst's: S WEST ST / W WATER ST Caller: FIRE DOVER",
        "UNIT:46F2",
        "CALL:Alarms-Commercial",
        "ADDR:644 S QUEEN ST",
        "CITY:Dover",
        "X:S WEST ST / W WATER ST",
        "NAME:FIRE DOVER");

    doTest("T40",
        "(Incident Alert)Unit:A42 Status:Dispatched 33C1T Transfer/Interfacility 100 DELAWARE VETERANS BLVD DELAWARE VETERANS HOME Venue: Milford Dev/Sub: Xst's: DEAD END / PATRIOTS WAY Caller: NIXON",
        "UNIT:A42",
        "CODE:33C1T",
        "CALL:Transfer/Interfacility",
        "ADDR:100 DELAWARE VETERANS BLVD",
        "PLACE:DELAWARE VETERANS HOME",
        "CITY:Milford",
        "X:DEAD END / PATRIOTS WAY",
        "NAME:NIXON");

    doTest("T41",
        "(Incident Alert)Unit:A64 Status:Dispatched 26D1 Sick Person - Not Alert 175 ASHFIELD CT CHIMES GROUP HOME Venue: Smyrna Dev/Sub: TWIN WILLOWS Xst's: W BRAEBURN DR / W CAYHILL LN Caller: SIRRELL",
        "UNIT:A64",
        "CODE:26D1",
        "CALL:Sick Person - Not Alert",
        "ADDR:175 ASHFIELD CT",
        "PLACE:CHIMES GROUP HOME - TWIN WILLOWS",
        "CITY:Smyrna",
        "X:W BRAEBURN DR / W CAYHILL LN",
        "NAME:SIRRELL");

    doTest("T42",
        "(Incident Alert)Unit:P41F Status:Dispatched Alarms-Residential (single) 605 QUAIL RUN  Venue: Camden Wyoming Dev/Sub: WILD QUAIL GOLF AND COUNTRY CLUB Xst's: GREEN WINGED TRL / PINTAIL PL Caller: 28",
        "UNIT:P41F",
        "CALL:Alarms-Residential (single)",
        "ADDR:605 QUAIL RUN",
        "PLACE:WILD QUAIL GOLF AND COUNTRY CLUB",
        "CITY:Camden Wyoming",
        "X:GREEN WINGED TRL / PINTAIL PL",
        "NAME:28");

    doTest("T43",
        "(Incident Alert)Unit:B64 Status:Dispatched 23B1I Overdose/Poisoning 101 N  CARTER RD  Venue: Smyrna Dev/Sub: Xst's: W MOUNT VERNON ST / DEAK DR Caller: TRACY",
        "UNIT:B64",
        "CODE:23B1I",
        "CALL:Overdose/Poisoning",
        "ADDR:101 N CARTER RD",
        "CITY:Smyrna",
        "X:W MOUNT VERNON ST / DEAK DR",
        "NAME:TRACY");

    doTest("T44",
        "(Incident Alert)Unit:A42 Status:Dispatched Service Call -Locked in Vehicle 202 ALLEN WAY  Venue: Milford Dev/Sub: Xst's: AURORA PL / N CHURCH ST Caller: MURRY SHENAY",
        "UNIT:A42",
        "CALL:Service Call -Locked in Vehicle",
        "ADDR:202 ALLEN WAY",
        "CITY:Milford",
        "X:AURORA PL / N CHURCH ST",
        "NAME:MURRY SHENAY");

    doTest("T45",
        "(Incident Alert)Unit:A41 Status:Dispatched 26C1 Sick Person  1822 THICKET RD  Venue: Camden Wyoming Dev/Sub: Xst's: No Cross Streets Found Caller: SIPPLE VICTORIA",
        "UNIT:A41",
        "CODE:26C1",
        "CALL:Sick Person",
        "ADDR:1822 THICKET RD",
        "CITY:Camden Wyoming",
        "X:No Cross Streets Found",
        "NAME:SIPPLE VICTORIA");

    doTest("T46",
        "(Incident Alert)Unit:B64 Status:Dispatched 32B2 - Medic Alert 612 SAKS ST  Venue: Smyrna Dev/Sub: BON AYRE  Xst's: STELLA ST / RADNOR LN Caller: 12170",
        "UNIT:B64",
        "CODE:32B2",
        "CALL:Medic Alert",
        "ADDR:612 SAKS ST",
        "PLACE:BON AYRE",
        "CITY:Smyrna",
        "X:STELLA ST / RADNOR LN",
        "NAME:12170");

    doTest("T47",
        "(Incident Alert)Unit:P41F Status:Dispatched Electrical Hazard-Wire Down 8429 WESTVILLE RD  Venue: Camden Wyoming Dev/Sub: Xst's: UNKNOWN / MALLARD DR Caller: DEAN",
        "UNIT:P41F",
        "CALL:Electrical Hazard-Wire Down",
        "ADDR:8429 WESTVILLE RD",
        "CITY:Camden Wyoming",
        "X:UNKNOWN / MALLARD DR",
        "NAME:DEAN");

    doTest("T48",
        "(Incident Alert)Unit:B64 Status:Dispatched 23C7I Overdose/Poisoning 214 S  CARTER RD  Venue: Smyrna Dev/Sub: Xst's: JULIA WAY / DETTINGER RD Caller:",
        "UNIT:B64",
        "CODE:23C7I",
        "CALL:Overdose/Poisoning",
        "ADDR:214 S CARTER RD",
        "CITY:Smyrna",
        "X:JULIA WAY / DETTINGER RD");

    doTest("T49",
        "(Incident Alert)Unit:A42 Status:Dispatched 31D2 Unconscious/Fainting 1042 N  WALNUT ST MILFORD DINER Venue: Milford Dev/Sub: Xst's: N DUPONT BLVD / BUCCANEER BLVD Caller: IRENE",
        "UNIT:A42",
        "CODE:31D2",
        "CALL:Unconscious/Fainting",
        "ADDR:1042 N WALNUT ST",
        "PLACE:MILFORD DINER",
        "CITY:Milford",
        "X:N DUPONT BLVD / BUCCANEER BLVD",
        "NAME:IRENE");

    doTest("T50",
        "(Incident Alert)Unit:A41 Status:Dispatched 10C4 Chest Pains 642 S  WYNN WOOD CIR  Venue: Camden Wyoming Dev/Sub: WYNN WOOD Xst's: WILDMEADOW LN / RIDINGWOOD LN Caller: JACKSON JOAN",
        "UNIT:A41",
        "CODE:10C4",
        "CALL:Chest Pains",
        "ADDR:642 S WYNN WOOD CIR",
        "PLACE:WYNN WOOD",
        "CITY:Camden Wyoming",
        "X:WILDMEADOW LN / RIDINGWOOD LN",
        "NAME:JACKSON JOAN");

    doTest("T51",
        "(Incident Alert)Unit:B64 Status:Dispatched 26C2 Sick Person  263 HOLLY HILL DR  Venue: Smyrna Dev/Sub: HOLLY HILL ESTATES Xst's: BERRY DR / CEDAR CT Caller: EPPLER",
        "UNIT:B64",
        "CODE:26C2",
        "CALL:Sick Person",
        "ADDR:263 HOLLY HILL DR",
        "PLACE:HOLLY HILL ESTATES",
        "CITY:Smyrna",
        "X:BERRY DR / CEDAR CT",
        "NAME:EPPLER");

    doTest("T52",
        "(Incident Alert)Unit:A41 Status:Dispatched 10C2 Chest Pains  3664 PEACHTREE RUN  Venue: Dover Dev/Sub: Xst's: LOCHMEATH WAY / VANNESSA DR Caller: KNOTS REGINA",
        "UNIT:A41",
        "CODE:10C2",
        "CALL:Chest Pains",
        "ADDR:3664 PEACHTREE RUN",
        "CITY:Dover",
        "X:LOCHMEATH WAY / VANNESSA DR",
        "NAME:KNOTS REGINA");

    doTest("T53",
        "(Incident Alert)Unit:A42 Status:Dispatched 33C6T Transfer/Interfacility 219 S  WALNUT ST  Venue: Milford Dev/Sub: Xst's: SE 2ND ST / BARKER ST Caller: SHERRY",
        "UNIT:A42",
        "CODE:33C6T",
        "CALL:Transfer/Interfacility",
        "ADDR:219 S WALNUT ST",
        "CITY:Milford",
        "X:SE 2ND ST / BARKER ST",
        "NAME:SHERRY");

    doTest("T54",
        "(Incident Alert)Unit:46F9 Status:Dispatched Alarms-High Life Hazard 1121 FORREST AVE MODERN MATURITY CTR Venue: Dover Dev/Sub: Xst's: BENNINGTON ST, GEORGE WASHINGTON DR / SAULSBURY RD, FOREST ST Caller: DFD",
        "UNIT:46F9",
        "CALL:Alarms-High Life Hazard",
        "ADDR:1121 FORREST AVE",
        "PLACE:MODERN MATURITY CTR",
        "CITY:Dover",
        "X:BENNINGTON ST, GEORGE WASHINGTON DR / SAULSBURY RD, FOREST ST",
        "NAME:DFD");

    doTest("T55",
        "(Incident Alert)Unit:A42 Status:Dispatched 10D2 Chest Pains  711 EVERGREEN LN  Venue: Milford Dev/Sub: Xst's: MEADOW BROOK LN / WISSEMAN AVE Caller: WARD MARIAN",
        "UNIT:A42",
        "CODE:10D2",
        "CALL:Chest Pains",
        "ADDR:711 EVERGREEN LN",
        "CITY:Milford",
        "X:MEADOW BROOK LN / WISSEMAN AVE",
        "NAME:WARD MARIAN");

    doTest("T56",
        "(Incident Alert)Unit:P51F Status:Dispatched Structure-Mobile Home/Trailer 79 ELAINE DR  Venue: Clayton Dev/Sub: Xst's: MAPLE OAKS LN / SHAWS CORNER RD Caller: DORIAN GODDARD",
        "UNIT:P51F",
        "CALL:Structure-Mobile Home/Trailer",
        "ADDR:79 ELAINE DR",
        "CITY:Clayton",
        "X:MAPLE OAKS LN / SHAWS CORNER RD",
        "NAME:DORIAN GODDARD");

    doTest("T57",
        "(Incident Alert)Unit:C50 Status:Dispatched 6D1 Breathing Problems  10 MECHANIC ST HARRINGTON PD Venue: Harrington Dev/Sub: Xst's: FLEMING ST / COMMERCE ST, HANLEY ST, RAILROAD AVE Caller: ",
        "UNIT:C50",
        "CODE:6D1",
        "CALL:Breathing Problems",
        "ADDR:10 MECHANIC ST",
        "PLACE:HARRINGTON PD",
        "CITY:Harrington",
        "X:FLEMING ST / COMMERCE ST, HANLEY ST, RAILROAD AVE");
  }
  
  public static void main(String[] args) {
    new DEKentCountyCParserTest().generateTests("T1");
  }
}
    		