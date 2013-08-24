package net.anei.cadpage.parsers.DE;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Kent County, DE
Contact: Dewey Thomas <dewey@codemessaging.net>
From: kentcenter@state.de.us

(Incident Alert)Unit:A64 Status:Dispatched 26A10 Sick Person - Unwell/Ill 125 CENTURY DR Venue: Smyrna Dev/Sub: BRENFORD WOODS Xst's: NEEDHAM DR / NEEDHAM DR Caller: MASS LEXIS
(Incident Alert)Unit:A41 Status:Dispatched 10C1 Chest Pains 73 WYNN WOOD CIR  Venue: Camden Wyoming Dev/Sub: WYNN WOOD Xst's: SPRING RIDGE WAY / SADDLEBROOK DR, S WYNN WOOD CIR Caller: TOMPKINS WAYNE
(Incident Alert)Unit:B64 Status:Dispatched 33C5T Transfer/Interfacility 1181 PADDOCK RD JAMES T VAUGHN CORRECTIONAL CENTER Venue: Smyrna Dev/Sub: Xst's: DELAWARE DEPT OF CORRECTION CT / MC QUAIL RD Caller: PHYLIS
(Incident Alert)Unit:A42 Status:Dispatched 4B3A Assault - Unknown 5 N  WASHINGTON ST PARK PLACE LOUNGE Venue: Milford Dev/Sub: Xst's: PARK AVE / S WASHINGTON ST Caller:
(Incident Alert)Unit:A41 Status:Dispatched 17B1G Falls - Possibly Dangerous 561 N  DUPONT HWY HOLIDAY INN DOVER Venue: Dover Dev/Sub: Xst's: JEFFERIC BLVD / TOWNSEND BLVD Caller: DEBB LESEX
(Incident Alert)Unit:46F1 Status:Dispatched Outside Fire-Small 1788 N  DUPONT HWY MCDONALDS SCARBOROUGH RD Venue: Dover Dev/Sub: Xst's: HOLIDAY BLVD / CEDAR CHASE DR Caller:
(Incident Alert)Unit:A42 Status:Dispatched 21D3 Hemorrhage - Dangerous 204 ASHLEY WAY  Venue: Milford Dev/Sub: THE VILLAS AT MILFORD CROSSING Xst's: UNKNOWN / MOYER CIR E Caller: FULLER SHIRLEY
(Incident Alert)Unit:46F1 Status:Dispatched Vehicle Fire 201 STOVER BLVD MAIN STAY SUITES Venue: Dover Dev/Sub: STOVER Xst's: BAY RD / KRISKO CIR Caller: EAGLE HOSPITALITY ( MAINSTAY S
(Incident Alert)Unit:A51 Status:Dispatched Electrical Hazard-Wire Down ARTHURSVILLE RD  Venue: Clayton Dev/Sub: Xst's: Caller: DIMEO FRED
(Incident Alert)Unit:P51F Status:Dispatched Electrical Hazard-Wire Down ARTHURSVILLE RD  Venue: Clayton Dev/Sub: Xst's: Caller: DIMEO FRED
(Incident Alert)Unit:A41 Status:Dispatched 6D2 Breathing Problems 425 MANNERING DR  Venue: Dover Dev/Sub: GRAND OAKS Xst's: DEAD END / LADY CT Caller: DAMATO
(Incident Alert)Unit:B64 Status:Dispatched 31A3 Fainting Episode 436 GREENS BRANCH LN  Venue: Smyrna Dev/Sub: EAGLE CHASE Xst's: EAGLE WAY / N HIGH ST Caller: WINGFIELD
(Incident Alert)Unit:A42 Status:Dispatched 26A11 Sick Person - Vomiting 47 LADY SLIPPER LN  Venue: Milford Dev/Sub: SARAGLEN ACRES Xst's: DEAD END / JONQUIL CT Caller: MALANIO JOSIE
(Incident Alert)Unit:A64 Status:Dispatched 6D1 Breathing Problems  197 SPENCER DR  Venue: Clayton Dev/Sub: Xst's: BLACKISTON RD / BLACKISTON RD Caller: LEAGER MONICA
(Incident Alert)Unit:B64 Status:Dispatched 31A1 Fainting Episode 169 PADDOCK RD  Venue: Townsend Dev/Sub: Xst's: THOROUGHFARE NECK RD / FLEMINGS LANDING RD Caller: WICKS DEBBIE
(Incident Alert)Unit:C50 Status:Dispatched 9B1A - Obvious Death 2628 VERNON RD  Venue: Harrington Dev/Sub: Xst's: CATTAIL BRANCH RD / WELCH RD Caller: CARTER PAUL
(Incident Alert)Unit:46F3 Status:Dispatched Alarms-Commercial 1294 FORREST AVE BETSY ROSS PIZZA FORREST AVE Venue: Dover Dev/Sub: Xst's: S INDEPENDENCE BLVD, INDEPENDENCE BLVD / KENTON RD Caller:
(Incident Alert)Unit:A41 Status:Dispatched 23O1A Overdose/Poisoning WILLOW GROVE RD  Venue: Camden Wyoming Dev/Sub: Xst's: Caller: STACEY CRYSTAL
(Incident Alert)Unit:B53 Status:Dispatched 17B3 Falls - Unknown 6394 W DENNEYS RD  Venue: Dover Dev/Sub: Xst's: JPS DR / JOSIE AVE Caller: M BLANCHARD
(Incident Alert)Unit:P53E Status:Dispatched 17B3 Falls - Unknown 6394 W DENNEYS RD  Venue: Dover Dev/Sub: Xst's: JPS DR / JOSIE AVE Caller: M BLANCHARD
(Incident Alert)Unit:B50 Status:Dispatched 17A1G Falls - Not Dangerous  42 CHAMBERS CIR HARRINGTON CASINO Venue: Harrington Dev/Sub: STATE FAIR GROUNDS Xst's: WILLIAM M CHAMBERS JR RD / WILLIAM M CHAMBERS JR RD Caller: HAYES PAUL
(Incident Alert)Unit:A64 Status:Dispatched 26A10 Sick Person - Unwell/Ill 910 APPLEBERRY DR  Venue: Smyrna Dev/Sub: BON AYRE  Xst's: DYLAN ST / DAIRY DR, SAKS ST Caller: KRASAVAGE MARTIN
(Incident Alert)Unit:478 Status:Dispatched 17B1G Falls - Possibly Dangerous 618 PROSPECT CHURCH RD  Venue: Harrington Dev/Sub: Xst's: TODDS CHAPEL RD, ANDREWVILLE RD / HAMMONDTOWN RD Caller: CANNON JIM
(Incident Alert)Unit:C50 Status:Dispatched 17B1G Falls - Possibly Dangerous 618 PROSPECT CHURCH RD  Venue: Harrington Dev/Sub: Xst's: TODDS CHAPEL RD, ANDREWVILLE RD / HAMMONDTOWN RD Caller: CANNON JIM
(Incident Alert)Unit:P50F Status:Dispatched Citizen Assist/Service Call  7250 MILFORD HARRINGTON HWY ROYAL FARMS- HARRINGTON Venue: Harrington Dev/Sub: Xst's: CLARK ST, S DUPONT HWY / S DUPONT HWY Caller:
(Incident Alert)Unit:A50 Status:Dispatched 17A2G Falls - Non Recent 502 MASON AVE  Venue: Harrington Dev/Sub: Xst's: MADISON AVE / DEAD END Caller: S STIERS
(Incident Alert)Unit:A41 Status:Dispatched 26A8 Sick Person - Other Pain 1750 S  TAYLOR DR  Venue: Dover Dev/Sub: TAYLOR ESTATES Xst's: N TAYLOR DR, LAKEVIEW AVE / S DUPONT HWY Caller: WINCHELL
(Incident Alert)Unit:A41 Status:Dispatched 24B1 Pregnancy 3036 UPPER KING RD TROOP 3 Venue: Dover Dev/Sub: Xst's: DERBY WOOD CIR / BISON RD Caller:
(Incident Alert)Unit:46F4 Status:Dispatched Structure-Chimney  1401 S FARMVIEW DR  Venue: Dover Dev/Sub: Xst's: WOODMILL DR / S INDEPENDENCE BLVD Caller:
(Incident Alert)Unit:A64 Status:Dispatched 32B2 - Medic Alert 612 SAKS ST  Venue: Smyrna Dev/Sub: BON AYRE  Xst's: STELLA ST / RADNOR LN Caller:
(Incident Alert)Unit:A42 Status:Dispatched 30A1 Traumatic Injury SE FRONT ST  Venue: Milford Dev/Sub: Xst's: Caller: JOHN
(Incident Alert)Unit:A41 Status:Dispatched 6D1 Breathing Problems  688 S  WYNN WOOD CIR  Venue: Camden Wyoming Dev/Sub: WYNN WOOD Xst's: WILDMEADOW LN / DEAD END Caller: G WITT
(Incident Alert)Unit:A64 Status:Dispatched 1C4 Abdominal Pains 306 BIG OAK RD  Venue: Smyrna Dev/Sub: Xst's: STATE HWY 1 / PIER HEAD BLVD Caller: CONLON TIM
(Incident Alert)Unit:A64 Status:Dispatched 17A1G Falls - Not Dangerous  6 REHOBOTH CIR  Venue: Clayton Dev/Sub: CLAYTON COURTS MHP Xst's: DEAD END / CLAYTON DR Caller: HUTTON
(Incident Alert)Unit:A42 Status:Dispatched 13C1 Diabetic - Not Alert 7190 WILKINS RD  Venue: Milford Dev/Sub: Xst's: CEDAR CREEK RD / GREGORY BLVD Caller: DILLON MARY
(Incident Alert)Unit:P41F Status:Dispatched Alarms-Commercial 140 SOUTHERN BLVD WYOMING CONCRETE Venue: Camden Wyoming Dev/Sub: WYOMING Xst's: PINE ST / S LAYTON AVE Caller: 73
(Incident Alert)Unit:A42 Status:Dispatched 13C1 Diabetic - Not Alert 111 LOVERS LN  Venue: Milford Dev/Sub: Xst's: BERRY LN / SE 2ND ST Caller: PD MILFORD
(Incident Alert)Unit:A64 Status:Dispatched 33C5T Transfer/Interfacility 3034 S  DUPONT BLVD PINNACLE HEALTH AND REHAB CTR  Venue: Smyrna Dev/Sub: Xst's: UNKNOWN / VILLAGE DR Caller: KARNAO JASON
(Incident Alert)Unit:46F2 Status:Dispatched Alarms-Commercial 644 S  QUEEN ST  Venue: Dover Dev/Sub: Xst's: S WEST ST / W WATER ST Caller: FIRE DOVER
(Incident Alert)Unit:A42 Status:Dispatched 33C1T Transfer/Interfacility 100 DELAWARE VETERANS BLVD DELAWARE VETERANS HOME Venue: Milford Dev/Sub: Xst's: DEAD END / PATRIOTS WAY Caller: NIXON
(Incident Alert)Unit:A64 Status:Dispatched 26D1 Sick Person - Not Alert 175 ASHFIELD CT CHIMES GROUP HOME Venue: Smyrna Dev/Sub: TWIN WILLOWS Xst's: W BRAEBURN DR / W CAYHILL LN Caller: SIRRELL
(Incident Alert)Unit:P41F Status:Dispatched Alarms-Residential (single) 605 QUAIL RUN  Venue: Camden Wyoming Dev/Sub: WILD QUAIL GOLF AND COUNTRY CLUB Xst's: GREEN WINGED TRL / PINTAIL PL Caller: 28
(Incident Alert)Unit:B64 Status:Dispatched 23B1I Overdose/Poisoning 101 N  CARTER RD  Venue: Smyrna Dev/Sub: Xst's: W MOUNT VERNON ST / DEAK DR Caller: TRACY
(Incident Alert)Unit:A42 Status:Dispatched Service Call -Locked in Vehicle 202 ALLEN WAY  Venue: Milford Dev/Sub: Xst's: AURORA PL / N CHURCH ST Caller: MURRY SHENAY
(Incident Alert)Unit:A41 Status:Dispatched 26C1 Sick Person  1822 THICKET RD  Venue: Camden Wyoming Dev/Sub: Xst's: No Cross Streets Found Caller: SIPPLE VICTORIA
(Incident Alert)Unit:B64 Status:Dispatched 32B2 - Medic Alert 612 SAKS ST  Venue: Smyrna Dev/Sub: BON AYRE  Xst's: STELLA ST / RADNOR LN Caller: 12170
(Incident Alert)Unit:P41F Status:Dispatched Electrical Hazard-Wire Down 8429 WESTVILLE RD  Venue: Camden Wyoming Dev/Sub: Xst's: UNKNOWN / MALLARD DR Caller: DEAN
(Incident Alert)Unit:B64 Status:Dispatched 23C7I Overdose/Poisoning 214 S  CARTER RD  Venue: Smyrna Dev/Sub: Xst's: JULIA WAY / DETTINGER RD Caller:
(Incident Alert)Unit:A42 Status:Dispatched 31D2 Unconscious/Fainting 1042 N  WALNUT ST MILFORD DINER Venue: Milford Dev/Sub: Xst's: N DUPONT BLVD / BUCCANEER BLVD Caller: IRENE
(Incident Alert)Unit:A41 Status:Dispatched 10C4 Chest Pains 642 S  WYNN WOOD CIR  Venue: Camden Wyoming Dev/Sub: WYNN WOOD Xst's: WILDMEADOW LN / RIDINGWOOD LN Caller: JACKSON JOAN
(Incident Alert)Unit:B64 Status:Dispatched 26C2 Sick Person  263 HOLLY HILL DR  Venue: Smyrna Dev/Sub: HOLLY HILL ESTATES Xst's: BERRY DR / CEDAR CT Caller: EPPLER
(Incident Alert)Unit:A41 Status:Dispatched 10C2 Chest Pains  3664 PEACHTREE RUN  Venue: Dover Dev/Sub: Xst's: LOCHMEATH WAY / VANNESSA DR Caller: KNOTS REGINA
(Incident Alert)Unit:A42 Status:Dispatched 33C6T Transfer/Interfacility 219 S  WALNUT ST  Venue: Milford Dev/Sub: Xst's: SE 2ND ST / BARKER ST Caller: SHERRY
(Incident Alert)Unit:46F9 Status:Dispatched Alarms-High Life Hazard 1121 FORREST AVE MODERN MATURITY CTR Venue: Dover Dev/Sub: Xst's: BENNINGTON ST, GEORGE WASHINGTON DR / SAULSBURY RD, FOREST ST Caller: DFD
(Incident Alert)Unit:A42 Status:Dispatched 10D2 Chest Pains  711 EVERGREEN LN  Venue: Milford Dev/Sub: Xst's: MEADOW BROOK LN / WISSEMAN AVE Caller: WARD MARIAN
(Incident Alert)Unit:P51F Status:Dispatched Structure-Mobile Home/Trailer 79 ELAINE DR  Venue: Clayton Dev/Sub: Xst's: MAPLE OAKS LN / SHAWS CORNER RD Caller: DORIAN GODDARD
(Incident Alert)Unit:C50 Status:Dispatched 6D1 Breathing Problems  10 MECHANIC ST HARRINGTON PD Venue: Harrington Dev/Sub: Xst's: FLEMING ST / COMMERCE ST, HANLEY ST, RAILROAD AVE Caller: 

Contact: CodeMessaging
Unit:C50 Status:Dispatched 17D3 Falls - Not Alert : 2429 BROWNSVILLE RD :  Venue: Harrington Dev/Sub: Xst's: PEAR TREE LN / RED BIRD LN Caller: LAYTON LISA
Unit:B64 Status:Dispatched 26D1 Sick Person - Not Alert : 26 NUGENT LOOP :  Venue: Smyrna Dev/Sub: TOWN AND COUNTRY Xst's: FOXWOOD DR, WHEELER CIR / FOXWOOD DR, WHEELER CIR Caller: GOSLETT CATHY
Unit:P41F Status:Dispatched Vehicle Fire : 263 WALMART DR : WALMART CAMDEN Venue: Dover Dev/Sub: CAMDEN Xst's: THOMAS HARMON DR / DEAD END Caller:
Unit:A42 Status:Dispatched 26A1 Sick Person : 9130 CROOKED RD :  Venue: Lincoln Dev/Sub: Xst's: No Cross Streets Found Caller: HARMON JESSIE
Unit:A41 Status:Dispatched 26A11 Sick Person - Vomiting : 242 S  GOVERNORS BLVD :  Venue: Dover Dev/Sub: CAPITOL PARK Xst's: PRESIDENT DR, N GOVERNORS BLVD / CONGRESS PL Caller: DIXON ERICA
Unit:A42 Status:Dispatched 6D2 Breathing Problems : 6190 GRIFFITH LAKE DR :  Venue: Milford Dev/Sub: Xst's: MEADOW BROOK LN / VINYARD DR Caller: HURD ELAINE
Unit:A50 Status:Dispatched 6D4 Breathing Problems - Clammy : 3034 FARMINGTON RD :  Venue: Harrington Dev/Sub: Xst's: FAIRGROUND RD / TOWER HILL RD Caller: GULLEDGE REBECCA
Unit:B53 Status:Dispatched 29B4 MVC Unknown : S  CARTER RD :  Venue: Smyrna Dev/Sub: Xst's: Caller: KENNY PAMELA
Unit:478 Status:Dispatched 26A7 Sick Person  : 2367 PROSPECT CHURCH RD :  Venue: Harrington Dev/Sub: Xst's: VERNON RD / HAMMONDTOWN RD Caller: MICHAEL
Unit:A51 Status:Dispatched 29B4 MVC Unknown : S  CARTER RD :  Venue: Smyrna Dev/Sub: Xst's: Caller: KENNY PAMELA
Unit:B50 Status:Dispatched 29D2P MVC Rollover : VERNON RD :  Venue: Harrington Dev/Sub: Xst's: Caller: NORRIS TRISTA
Unit:A53 Status:Dispatched 29B1 MVC Injuries : 114 EXIT : EXIT 114 Venue: Smyrna Dev/Sub: Xst's: No Cross Streets Found Caller: 41-22
Unit:B53 Status:Dispatched 29A1 MVC 1st Party Injury : SPRING MEADOW DR :  Venue: Smyrna Dev/Sub: TWIN WILLOWS Xst's: Caller: DSP
Unit:B64 Status:Dispatched 26C2 Sick Person  : 444 W MOUNT VERNON ST :  Venue: Smyrna Dev/Sub: Xst's: SMYRNA CLAYTON BLVD / N HIGH ST Caller: DUNBAR IKEA
Unit:A64 Status:Dispatched 33C1T Transfer/Interfacility : 3034 S  DUPONT BLVD : PINNACLE HEALTH AND REHAB CTR  Venue: Smyrna Dev/Sub: Xst's: UNKNOWN / VILLAGE DR Caller: HEVERIN VICKI
Unit:A50 Status:Dispatched 32B1 - Unknown Problem : 5 LINSTONE LN :  Venue: Milford Dev/Sub: Xst's: UNKNOWN / VALLEY DR Caller:
Unit:A50 Status:At Scene EMS Stand-by : 15 W ROBERT F RIDER RD : HARRINGTON RACEWAY Harrington : STATE FAIR GROUNDS Xst's: F GARY SIMPSON RD / BENJAMIN I SHAW ST Caller: A50

Contact: Active911
Agency name: Clayton Fire Company
Location: Clayton, DE, United States
Sender: kentcenter@state.de.us

Unit:P45F Status:Dispatched HazMat-Uncontained  : 510 MAIN ST : CLAYTON ELEMENTARY Venue: Clayton Dev/Sub: Xst's: HUDSON ST / HIGHLAND AVE Caller: DSP\n
Unit:P45F Status:Dispatched Outside Fire-Small : 101 PARMA DR :  Venue: Clayton Dev/Sub: OLD COUNTRY FARM Xst's: AMALFI DR / SORRENTO DR Caller: CHARLES RANDY\n
Unit:P45F Status:Dispatched Stand-By,Cover-up : 911 KENTON RD : STATION 46-2 Venue: Dover Dev/Sub: Xst's: COLLEGE RD / WALKER RD Caller:\n
Unit:P45F Status:Dispatched Electrical Hazard-Wire Down : 1624 MOUNT FRIENDSHIP RD :  Venue: Smyrna Dev/Sub: Xst's: SHAPLEY DR / WHEATLEYS POND RD Caller: GOSCH GRANT\n
Unit:P45F Status:Dispatched Alarms CO-Residential (single) : 513 SUNRISE DR :  Venue: Clayton Dev/Sub: JOCKEY HOLLOW Xst's: STIRRUP RD / COUNTRY HOLLOW DR Caller: CHRIS JONES\n
Unit:P45F Status:Dispatched 17D3 Falls - Not Alert : 4733 HOLLETTS CORNER RD :  Venue: Clayton Dev/Sub: Xst's: DEER ANTLER RD / SALTER RD Caller: HEVERIN DEBORAH\n
Unit:P45F Status:Dispatched Alarms-High Life Hazard : 86 SORRENTO DR : CLAYTON INTERMEDIATE SCHOOL Venue: Clayton Dev/Sub: OLD COUNTRY FARM Xst's: ABRUZZI DR / SAN MARINO DR Caller: 76785\n
Unit:P45F Status:Dispatched Structure-Large Non-Dwelling : 1385 LOCKWOOD CHAPEL RD :  Venue: Hartly Dev/Sub: Xst's: MYERS DR / JUDITH RD Caller: MILES CHARLES\n
Unit:P45F Status:Dispatched Gas Leak-Building : 365 N  MAIN ST : NORTH SMYRNA ELEMENTARY Venue: Smyrna Dev/Sub: Xst's: PROVIDENCE DR / W GLENWOOD AVE, E GLENWOOD AVE Caller:\n
Unit:P45F Status:Dispatched Alarms-Commercial : 355 W  DUCK CREEK RD : ST JOSEPHS COMPLEX Venue: Clayton Dev/Sub: Xst's: CLAYTON AVE / CHERRY ALY Caller:\n
Unit:P45F Status:Dispatched Alarms-Residential (single) : 1706 BLACKBIRD FOREST RD :  Venue: Clayton Dev/Sub: Xst's: PAULINE DR / CLAYTON DELANEY RD Caller:\n
Unit:P45F Status:Dispatched Gas Leak-Outside Structure : 10 CLAYTON DR :  Venue: Clayton Dev/Sub: CLAYTON COURTS MHP Xst's: DOVER CIR / N BASSETT ST Caller: HULL GAROLD\n
Unit:P45F Status:Dispatched Stand-By,Cover-up : 185 SASSAFRAS ST : STATION 2K Venue: Millington Dev/Sub: Xst's: HURTT AVE / MILLINGTON RD Caller: KCMD\n
Unit:P45F Status:Dispatched Gas Leak-Residential Single 127 W  COMMERCE ST  Venue: Clayton Dev/Sub: KENTON Xst's: HIGH ST / COOPER ST Caller:\n
Unit:P45F Status:Dispatched Alarms-Residential (single) 299 E  RADISON RUN  Venue: Clayton Dev/Sub: HUNTINGTON MILLS Xst's: HUNTINGTON DR / ALTON AVE Caller: 112\n
Unit:P45F Status:Dispatched Structure-Residential Multiple LONGRIDGE RD  Venue: Clayton Dev/Sub: Xst's: Caller:\n
Unit:P45F Status:Dispatched Outside Fire-Small SLOW AND EASY DR  Venue: Clayton Dev/Sub: Xst's: Caller: HESTER SHAWN\n
Unit:P45F Status:Dispatched Alarms-Commercial 355 W  DUCK CREEK RD ST JOSEPHS COMMUNITY CENTER Venue: Clayton Dev/Sub: Xst's: CLAYTON AVE / CHERRY ALY Caller: OPER DES\n

Contact: Active911
Agency name: Cheswold Fire Co.
Location: Cheswold, DE, United States
Sender: kentcenter@state.de.us

(Incident Alert) Unit:P43F Status:Dispatched Structure-Residential Single : 7710 PEARSONS CORNER RD :  Venue: Dover Dev/Sub: Xst's: KRISTA LEE DR / KENTON RD Caller: leeks lynda
(Incident Alert) Unit:P43F Status:Dispatched 29B1 MVC Injuries : N DUPONT HWY :  Venue: Dover Dev/Sub: Xst's: Caller:
(Incident Alert) Unit:P43F Status:Dispatched Structure-Appliance Contained : 2 BURNHAM LN :  Venue: Dover Dev/Sub: LAKESHORE VILLAGE Xst's: UNKNOWN / WALDEN LN Caller: RANDALL MARK
(Incident Alert) Unit:P43F Status:Dispatched Alarms-Commercial : 36 JEROME DR : WALMART CHESWOLD Venue: Dover Dev/Sub: Xst's: UNKNOWN / N DUPONT HWY Caller: WALMART
(Incident Alert) Unit:P43F Status:Dispatched Structure-Large Non-Dwelling : 1385 LOCKWOOD CHAPEL RD :  Venue: Hartly Dev/Sub: Xst's: MYERS DR / JUDITH RD Caller:
(Incident Alert) Unit:P43F Status:Dispatched 29B1 MVC Injuries : MOORTON RD :  Venue: Dover Dev/Sub: LAKESHORE VILLAGE Xst's: Caller: MAULE RICHARD
(Incident Alert) Unit:P43F Status:Dispatched Gas Leak-Outside Structure : 5729 W  DENNEYS RD : COMCAST DOVER Venue: Dover Dev/Sub: Xst's: UNKNOWN / N DUPONT HWY Caller: ARNOLD CHERYL
(Incident Alert) Unit:P43F Status:Dispatched 29B4 MVC Unknown : 68 STATE HWY 1 : MM 68 - SR 1 Venue: Dover Dev/Sub: Xst's: FAST LANDING RD / TWIN WILLOWS RD Caller: MARGARET
(Incident Alert) Unit:P43F Status:Dispatched 29B1 MVC Injuries : JEROME DR :  Venue: Dover Dev/Sub: Xst's: Caller: ARNOLD KEVIN

Contact: Active911
Agency name: Bowers Fire Company Inc. Sta. 40
Location: Frederica, DE, United States
Sender: kentcenter@state.de.us

(Incident Alert) Unit:P40E Status:Dispatched 6D2 Breathing Problems : 2941 BOWERS BEACH RD :  Venue: Frederica Dev/Sub: BAYVIEW HEIGHTS Xst's: ATLANTIC AVE / BAYVIEW AVE Caller: JENNIFER SHAMBLIN
(Incident Alert) Unit:A40 Status:Dispatched 19D2 Heart Problems  : 696 E  FRONT ST :  Venue: Frederica Dev/Sub: BAKERS CHOICE Xst's: E OAK ST / E POPLAR ST Caller: AMBRUSTER JOHN
(Incident Alert) Unit:A40 Status:Dispatched 10D2 Chest Pains  : 533 E  3RD ST :  Venue: Frederica Dev/Sub: BAKERS CHOICE Xst's: E POPLAR ST / E OAK ST Caller: KRAFULAK JAMES
(Incident Alert) Unit:A40 Status:Dispatched 17A1 Falls - Not Dangerous : 533 E  3RD ST :  Venue: Frederica Dev/Sub: BAKERS CHOICE Xst's: E POPLAR ST / E OAK ST Caller: E KRASULAK
(Incident Alert) Unit:A40 Status:Dispatched 12C1 Seizure - Focal : 2959 BOWERS BEACH RD :  Venue: Frederica Dev/Sub: BAYVIEW HEIGHTS Xst's: ATLANTIC AVE / BAYVIEW AVE Caller: GLODBOROUGH EDMOUND
(Incident Alert) Unit:A40 Status:Dispatched 17B1G Falls - Possibly Dangerous : 55 WILLIAMS AVE :  Venue: Frederica Dev/Sub: BOWERS BEACH Xst's: UNKNOWN / MAIN ST Caller:
(Incident Alert) Unit:A40 Status:Dispatched 32B2 - Medic Alert : 215 KESTREL CT :  Venue: Frederica Dev/Sub: HIGH POINT MHP Xst's: LAKE SHORE DR / DEAD END Caller: DES
(Incident Alert) Unit:A40 Status:Dispatched 6D2 Breathing Problems : 344 JEAN BRADLEY CIR :  Venue: Frederica Dev/Sub: HIGH POINT MHP Xst's: LAKE SHORE DR / WEST DR Caller: PEDRICK
(Incident Alert) Unit:P40E Status:Dispatched 6D2 Breathing Problems : 46 SYCAMORE DR :  Venue: Frederica Dev/Sub: HIGH POINT MHP Xst's: SECOND ST, FRONT ST / LAKE SHORE DR, SECOND ST Caller: KATHRYNE
(Incident Alert) Unit:A40 Status:Dispatched 17A1G Falls - Not Dangerous  : 216 KESTREL CT :  Venue: Frederica Dev/Sub: HIGH POINT MHP Xst's: LAKE SHORE DR / DEAD END Caller: 71 DES
(Incident Alert) Unit:A40 Status:Dispatched 17B1G Falls - Possibly Dangerous : 533 E  3RD ST :  Venue: Frederica Dev/Sub: BAKERS CHOICE Xst's: E POPLAR ST / E OAK ST Caller: PLYMINE SUZANNE
(Incident Alert) Unit:A40 Status:Dispatched 10D4 Chest Pains - Clammy : 78 SYCAMORE DR :  Venue: Frederica Dev/Sub: HIGH POINT MHP Xst's: LAKE SHORE DR, SECOND ST / SECOND ST, FRONT ST Caller: HARMON BRITTANY
(Incident Alert) Unit:A40 Status:Dispatched 26O7 Sick Person - Constipation : 303 LAKE SHORE DR :  Venue: Frederica Dev/Sub: HIGH POINT MHP Xst's: WENDY LN / DONNA LN Caller: OPDYKE MARY
(Incident Alert) Unit:A40 Status:Dispatched 29B1 MVC Injuries : CANTERBURY RD :  Venue: Milford Dev/Sub: Xst's: Caller: FETZER ROBERT
(Incident Alert) Unit:A40 Status:Dispatched 31A3 Fainting Episode : 1 MOONWALKER RD : ILC INDUSTRIES Venue: Felton Dev/Sub: Xst's: DEAD END / DEAD END Caller: GALLO SHANNON

 */

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
        "CALL:Overdose/Poisoning",
        "ADDR:WILLOW GROVE RD",
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

    doTest("T58",
        "(Incident Alert)Unit:C50 Status:Dispatched 6D1 Breathing Problems  10 MECHANIC ST HARRINGTON PD Venue: Harrington Dev/Sub: Xst's: FLEMING ST / COMMERCE ST, HANLEY ST, RAILROAD AVE Caller: ",
        "UNIT:C50",
        "CODE:6D1",
        "CALL:Breathing Problems",
        "ADDR:10 MECHANIC ST",
        "PLACE:HARRINGTON PD",
        "CITY:Harrington",
        "X:FLEMING ST / COMMERCE ST, HANLEY ST, RAILROAD AVE");
 
  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "Unit:C50 Status:Dispatched 17D3 Falls - Not Alert : 2429 BROWNSVILLE RD :  Venue: Harrington Dev/Sub: Xst's: PEAR TREE LN / RED BIRD LN Caller: LAYTON LISA",
        "UNIT:C50",
        "CODE:17D3",
        "CALL:Falls - Not Alert",
        "ADDR:2429 BROWNSVILLE RD",
        "CITY:Harrington",
        "X:PEAR TREE LN / RED BIRD LN",
        "NAME:LAYTON LISA");

    doTest("T2",
        "Unit:B64 Status:Dispatched 26D1 Sick Person - Not Alert : 26 NUGENT LOOP :  Venue: Smyrna Dev/Sub: TOWN AND COUNTRY Xst's: FOXWOOD DR, WHEELER CIR / FOXWOOD DR, WHEELER CIR Caller: GOSLETT CATHY",
        "UNIT:B64",
        "CODE:26D1",
        "CALL:Sick Person - Not Alert",
        "ADDR:26 NUGENT LOOP",
        "PLACE:TOWN AND COUNTRY",
        "CITY:Smyrna",
        "X:FOXWOOD DR, WHEELER CIR / FOXWOOD DR, WHEELER CIR",
        "NAME:GOSLETT CATHY");

    doTest("T3",
        "Unit:P41F Status:Dispatched Vehicle Fire : 263 WALMART DR : WALMART CAMDEN Venue: Dover Dev/Sub: CAMDEN Xst's: THOMAS HARMON DR / DEAD END Caller:",
        "UNIT:P41F",
        "CALL:Vehicle Fire",
        "ADDR:263 WALMART DR",
        "PLACE:WALMART CAMDEN - CAMDEN",
        "CITY:Dover",
        "X:THOMAS HARMON DR / DEAD END");

    doTest("T4",
        "Unit:A42 Status:Dispatched 26A1 Sick Person : 9130 CROOKED RD :  Venue: Lincoln Dev/Sub: Xst's: No Cross Streets Found Caller: HARMON JESSIE",
        "UNIT:A42",
        "CODE:26A1",
        "CALL:Sick Person",
        "ADDR:9130 CROOKED RD",
        "CITY:Lincoln",
        "X:No Cross Streets Found",
        "NAME:HARMON JESSIE");

    doTest("T5",
        "Unit:A41 Status:Dispatched 26A11 Sick Person - Vomiting : 242 S  GOVERNORS BLVD :  Venue: Dover Dev/Sub: CAPITOL PARK Xst's: PRESIDENT DR, N GOVERNORS BLVD / CONGRESS PL Caller: DIXON ERICA",
        "UNIT:A41",
        "CODE:26A11",
        "CALL:Sick Person - Vomiting",
        "ADDR:242 S  GOVERNORS BLVD",
        "PLACE:CAPITOL PARK",
        "CITY:Dover",
        "X:PRESIDENT DR, N GOVERNORS BLVD / CONGRESS PL",
        "NAME:DIXON ERICA");

    doTest("T6",
        "Unit:A42 Status:Dispatched 6D2 Breathing Problems : 6190 GRIFFITH LAKE DR :  Venue: Milford Dev/Sub: Xst's: MEADOW BROOK LN / VINYARD DR Caller: HURD ELAINE",
        "UNIT:A42",
        "CODE:6D2",
        "CALL:Breathing Problems",
        "ADDR:6190 GRIFFITH LAKE DR",
        "CITY:Milford",
        "X:MEADOW BROOK LN / VINYARD DR",
        "NAME:HURD ELAINE");

    doTest("T7",
        "Unit:A50 Status:Dispatched 6D4 Breathing Problems - Clammy : 3034 FARMINGTON RD :  Venue: Harrington Dev/Sub: Xst's: FAIRGROUND RD / TOWER HILL RD Caller: GULLEDGE REBECCA",
        "UNIT:A50",
        "CODE:6D4",
        "CALL:Breathing Problems - Clammy",
        "ADDR:3034 FARMINGTON RD",
        "CITY:Harrington",
        "X:FAIRGROUND RD / TOWER HILL RD",
        "NAME:GULLEDGE REBECCA");

    doTest("T8",
        "Unit:B53 Status:Dispatched 29B4 MVC Unknown : S  CARTER RD :  Venue: Smyrna Dev/Sub: Xst's: Caller: KENNY PAMELA",
        "UNIT:B53",
        "CODE:29B4",
        "CALL:MVC Unknown",
        "ADDR:S  CARTER RD",
        "CITY:Smyrna",
        "NAME:KENNY PAMELA");

    doTest("T9",
        "Unit:478 Status:Dispatched 26A7 Sick Person  : 2367 PROSPECT CHURCH RD :  Venue: Harrington Dev/Sub: Xst's: VERNON RD / HAMMONDTOWN RD Caller: MICHAEL",
        "UNIT:478",
        "CODE:26A7",
        "CALL:Sick Person",
        "ADDR:2367 PROSPECT CHURCH RD",
        "CITY:Harrington",
        "X:VERNON RD / HAMMONDTOWN RD",
        "NAME:MICHAEL");

    doTest("T10",
        "Unit:A51 Status:Dispatched 29B4 MVC Unknown : S  CARTER RD :  Venue: Smyrna Dev/Sub: Xst's: Caller: KENNY PAMELA",
        "UNIT:A51",
        "CODE:29B4",
        "CALL:MVC Unknown",
        "ADDR:S  CARTER RD",
        "CITY:Smyrna",
        "NAME:KENNY PAMELA");

    doTest("T11",
        "Unit:B50 Status:Dispatched 29D2P MVC Rollover : VERNON RD :  Venue: Harrington Dev/Sub: Xst's: Caller: NORRIS TRISTA",
        "UNIT:B50",
        "CODE:29D2P",
        "CALL:MVC Rollover",
        "ADDR:VERNON RD",
        "CITY:Harrington",
        "NAME:NORRIS TRISTA");

    doTest("T12",
        "Unit:A53 Status:Dispatched 29B1 MVC Injuries : 114 EXIT : EXIT 114 Venue: Smyrna Dev/Sub: Xst's: No Cross Streets Found Caller: 41-22",
        "UNIT:A53",
        "CODE:29B1",
        "CALL:MVC Injuries",
        "ADDR:114 EXIT",
        "PLACE:EXIT 114",
        "CITY:Smyrna",
        "X:No Cross Streets Found",
        "NAME:41-22");

    doTest("T13",
        "Unit:B53 Status:Dispatched 29A1 MVC 1st Party Injury : SPRING MEADOW DR :  Venue: Smyrna Dev/Sub: TWIN WILLOWS Xst's: Caller: DSP",
        "UNIT:B53",
        "CODE:29A1",
        "CALL:MVC 1st Party Injury",
        "ADDR:SPRING MEADOW DR",
        "PLACE:TWIN WILLOWS",
        "CITY:Smyrna",
        "NAME:DSP");

    doTest("T14",
        "Unit:B64 Status:Dispatched 26C2 Sick Person  : 444 W MOUNT VERNON ST :  Venue: Smyrna Dev/Sub: Xst's: SMYRNA CLAYTON BLVD / N HIGH ST Caller: DUNBAR IKEA",
        "UNIT:B64",
        "CODE:26C2",
        "CALL:Sick Person",
        "ADDR:444 W MOUNT VERNON ST",
        "CITY:Smyrna",
        "X:SMYRNA CLAYTON BLVD / N HIGH ST",
        "NAME:DUNBAR IKEA");

    doTest("T15",
        "Unit:A64 Status:Dispatched 33C1T Transfer/Interfacility : 3034 S  DUPONT BLVD : PINNACLE HEALTH AND REHAB CTR  Venue: Smyrna Dev/Sub: Xst's: UNKNOWN / VILLAGE DR Caller: HEVERIN VICKI",
        "UNIT:A64",
        "CODE:33C1T",
        "CALL:Transfer/Interfacility",
        "ADDR:3034 S  DUPONT BLVD",
        "PLACE:PINNACLE HEALTH AND REHAB CTR",
        "CITY:Smyrna",
        "X:UNKNOWN / VILLAGE DR",
        "NAME:HEVERIN VICKI");

    doTest("T16",
        "Unit:A50 Status:Dispatched 32B1 - Unknown Problem : 5 LINSTONE LN :  Venue: Milford Dev/Sub: Xst's: UNKNOWN / VALLEY DR Caller:",
        "UNIT:A50",
        "CODE:32B1",
        "CALL:Unknown Problem",
        "ADDR:5 LINSTONE LN",
        "CITY:Milford",
        "X:UNKNOWN / VALLEY DR");

  }
  
  @Test
  public void testClaytonFire() {

    doTest("T1",
        "Unit:P45F Status:Dispatched HazMat-Uncontained  : 510 MAIN ST : CLAYTON ELEMENTARY Venue: Clayton Dev/Sub: Xst's: HUDSON ST / HIGHLAND AVE Caller: DSP\n",
        "UNIT:P45F",
        "CALL:HazMat-Uncontained",
        "ADDR:510 MAIN ST",
        "PLACE:CLAYTON ELEMENTARY",
        "CITY:Clayton",
        "X:HUDSON ST / HIGHLAND AVE",
        "NAME:DSP");

    doTest("T2",
        "Unit:P45F Status:Dispatched Outside Fire-Small : 101 PARMA DR :  Venue: Clayton Dev/Sub: OLD COUNTRY FARM Xst's: AMALFI DR / SORRENTO DR Caller: CHARLES RANDY\n",
        "UNIT:P45F",
        "CALL:Outside Fire-Small",
        "ADDR:101 PARMA DR",
        "PLACE:OLD COUNTRY FARM",
        "CITY:Clayton",
        "X:AMALFI DR / SORRENTO DR",
        "NAME:CHARLES RANDY");

    doTest("T3",
        "Unit:P45F Status:Dispatched Stand-By,Cover-up : 911 KENTON RD : STATION 46-2 Venue: Dover Dev/Sub: Xst's: COLLEGE RD / WALKER RD Caller:\n",
        "UNIT:P45F",
        "CALL:Stand-By,Cover-up",
        "ADDR:911 KENTON RD",
        "PLACE:STATION 46-2",
        "CITY:Dover",
        "X:COLLEGE RD / WALKER RD");

    doTest("T4",
        "Unit:P45F Status:Dispatched Electrical Hazard-Wire Down : 1624 MOUNT FRIENDSHIP RD :  Venue: Smyrna Dev/Sub: Xst's: SHAPLEY DR / WHEATLEYS POND RD Caller: GOSCH GRANT\n",
        "UNIT:P45F",
        "CALL:Electrical Hazard-Wire Down",
        "ADDR:1624 MOUNT FRIENDSHIP RD",
        "CITY:Smyrna",
        "X:SHAPLEY DR / WHEATLEYS POND RD",
        "NAME:GOSCH GRANT");

    doTest("T5",
        "Unit:P45F Status:Dispatched Alarms CO-Residential (single) : 513 SUNRISE DR :  Venue: Clayton Dev/Sub: JOCKEY HOLLOW Xst's: STIRRUP RD / COUNTRY HOLLOW DR Caller: CHRIS JONES\n",
        "UNIT:P45F",
        "CALL:Alarms CO-Residential (single)",
        "ADDR:513 SUNRISE DR",
        "PLACE:JOCKEY HOLLOW",
        "CITY:Clayton",
        "X:STIRRUP RD / COUNTRY HOLLOW DR",
        "NAME:CHRIS JONES");

    doTest("T6",
        "Unit:P45F Status:Dispatched 17D3 Falls - Not Alert : 4733 HOLLETTS CORNER RD :  Venue: Clayton Dev/Sub: Xst's: DEER ANTLER RD / SALTER RD Caller: HEVERIN DEBORAH\n",
        "UNIT:P45F",
        "CODE:17D3",
        "CALL:Falls - Not Alert",
        "ADDR:4733 HOLLETTS CORNER RD",
        "CITY:Clayton",
        "X:DEER ANTLER RD / SALTER RD",
        "NAME:HEVERIN DEBORAH");

    doTest("T7",
        "Unit:P45F Status:Dispatched Alarms-High Life Hazard : 86 SORRENTO DR : CLAYTON INTERMEDIATE SCHOOL Venue: Clayton Dev/Sub: OLD COUNTRY FARM Xst's: ABRUZZI DR / SAN MARINO DR Caller: 76785\n",
        "UNIT:P45F",
        "CALL:Alarms-High Life Hazard",
        "ADDR:86 SORRENTO DR",
        "PLACE:CLAYTON INTERMEDIATE SCHOOL - OLD COUNTRY FARM",
        "CITY:Clayton",
        "X:ABRUZZI DR / SAN MARINO DR",
        "NAME:76785");

    doTest("T8",
        "Unit:P45F Status:Dispatched Structure-Large Non-Dwelling : 1385 LOCKWOOD CHAPEL RD :  Venue: Hartly Dev/Sub: Xst's: MYERS DR / JUDITH RD Caller: MILES CHARLES\n",
        "UNIT:P45F",
        "CALL:Structure-Large Non-Dwelling",
        "ADDR:1385 LOCKWOOD CHAPEL RD",
        "CITY:Hartly",
        "X:MYERS DR / JUDITH RD",
        "NAME:MILES CHARLES");

    doTest("T9",
        "Unit:P45F Status:Dispatched Gas Leak-Building : 365 N  MAIN ST : NORTH SMYRNA ELEMENTARY Venue: Smyrna Dev/Sub: Xst's: PROVIDENCE DR / W GLENWOOD AVE, E GLENWOOD AVE Caller:\n",
        "UNIT:P45F",
        "CALL:Gas Leak-Building",
        "ADDR:365 N  MAIN ST",
        "PLACE:NORTH SMYRNA ELEMENTARY",
        "CITY:Smyrna",
        "X:PROVIDENCE DR / W GLENWOOD AVE, E GLENWOOD AVE");

    doTest("T10",
        "Unit:P45F Status:Dispatched Alarms-Commercial : 355 W  DUCK CREEK RD : ST JOSEPHS COMPLEX Venue: Clayton Dev/Sub: Xst's: CLAYTON AVE / CHERRY ALY Caller:\n",
        "UNIT:P45F",
        "CALL:Alarms-Commercial",
        "ADDR:355 W  DUCK CREEK RD",
        "PLACE:ST JOSEPHS COMPLEX",
        "CITY:Clayton",
        "X:CLAYTON AVE / CHERRY ALY");

    doTest("T11",
        "Unit:P45F Status:Dispatched Alarms-Residential (single) : 1706 BLACKBIRD FOREST RD :  Venue: Clayton Dev/Sub: Xst's: PAULINE DR / CLAYTON DELANEY RD Caller:\n",
        "UNIT:P45F",
        "CALL:Alarms-Residential (single)",
        "ADDR:1706 BLACKBIRD FOREST RD",
        "CITY:Clayton",
        "X:PAULINE DR / CLAYTON DELANEY RD");

    doTest("T12",
        "Unit:P45F Status:Dispatched Gas Leak-Outside Structure : 10 CLAYTON DR :  Venue: Clayton Dev/Sub: CLAYTON COURTS MHP Xst's: DOVER CIR / N BASSETT ST Caller: HULL GAROLD\n",
        "UNIT:P45F",
        "CALL:Gas Leak-Outside Structure",
        "ADDR:10 CLAYTON DR",
        "PLACE:CLAYTON COURTS MHP",
        "CITY:Clayton",
        "X:DOVER CIR / N BASSETT ST",
        "NAME:HULL GAROLD");

    doTest("T13",
        "Unit:P45F Status:Dispatched Stand-By,Cover-up : 185 SASSAFRAS ST : STATION 2K Venue: Millington Dev/Sub: Xst's: HURTT AVE / MILLINGTON RD Caller: KCMD\n",
        "UNIT:P45F",
        "CALL:Stand-By,Cover-up",
        "ADDR:185 SASSAFRAS ST",
        "PLACE:STATION 2K",
        "CITY:Millington",
        "ST:MD",
        "X:HURTT AVE / MILLINGTON RD",
        "NAME:KCMD");

    doTest("T14",
        "Unit:P45F Status:Dispatched Gas Leak-Residential Single 127 W  COMMERCE ST  Venue: Clayton Dev/Sub: KENTON Xst's: HIGH ST / COOPER ST Caller:\n",
        "UNIT:P45F",
        "CALL:Gas Leak-Residential Single",
        "ADDR:127 W COMMERCE ST",
        "PLACE:KENTON",
        "CITY:Clayton",
        "X:HIGH ST / COOPER ST");

    doTest("T15",
        "Unit:P45F Status:Dispatched Alarms-Residential (single) 299 E  RADISON RUN  Venue: Clayton Dev/Sub: HUNTINGTON MILLS Xst's: HUNTINGTON DR / ALTON AVE Caller: 112\n",
        "UNIT:P45F",
        "CALL:Alarms-Residential (single)",
        "ADDR:299 E RADISON RUN",
        "PLACE:HUNTINGTON MILLS",
        "CITY:Clayton",
        "X:HUNTINGTON DR / ALTON AVE",
        "NAME:112");

    doTest("T16",
        "Unit:P45F Status:Dispatched Structure-Residential Multiple LONGRIDGE RD  Venue: Clayton Dev/Sub: Xst's: Caller:\n",
        "UNIT:P45F",
        "CALL:Structure-Residential Multiple",
        "ADDR:LONGRIDGE RD",
        "CITY:Clayton");

    doTest("T17",
        "Unit:P45F Status:Dispatched Outside Fire-Small SLOW AND EASY DR  Venue: Clayton Dev/Sub: Xst's: Caller: HESTER SHAWN\n",
        "UNIT:P45F",
        "CALL:Outside Fire-Small",
        "ADDR:SLOW AND EASY DR",
        "MADDR:SLOW & EASY DR",
        "CITY:Clayton",
        "NAME:HESTER SHAWN");

    doTest("T18",
        "Unit:P45F Status:Dispatched Alarms-Commercial 355 W  DUCK CREEK RD ST JOSEPHS COMMUNITY CENTER Venue: Clayton Dev/Sub: Xst's: CLAYTON AVE / CHERRY ALY Caller: OPER DES\n",
        "UNIT:P45F",
        "CALL:Alarms-Commercial",
        "ADDR:355 W DUCK CREEK RD",
        "PLACE:ST JOSEPHS COMMUNITY CENTER",
        "CITY:Clayton",
        "X:CLAYTON AVE / CHERRY ALY",
        "NAME:OPER DES");
   
  }
  
  @Test
  public void testCheswoldFire() {

    doTest("T1",
        "(Incident Alert) Unit:P43F Status:Dispatched Structure-Residential Single : 7710 PEARSONS CORNER RD :  Venue: Dover Dev/Sub: Xst's: KRISTA LEE DR / KENTON RD Caller: leeks lynda",
        "UNIT:P43F",
        "CALL:Structure-Residential Single",
        "ADDR:7710 PEARSONS CORNER RD",
        "CITY:Dover",
        "X:KRISTA LEE DR / KENTON RD",
        "NAME:leeks lynda");

    doTest("T2",
        "(Incident Alert) Unit:P43F Status:Dispatched 29B1 MVC Injuries : N DUPONT HWY :  Venue: Dover Dev/Sub: Xst's: Caller:",
        "UNIT:P43F",
        "CODE:29B1",
        "CALL:MVC Injuries",
        "ADDR:N DUPONT HWY",
        "CITY:Dover");

    doTest("T3",
        "(Incident Alert) Unit:P43F Status:Dispatched Structure-Appliance Contained : 2 BURNHAM LN :  Venue: Dover Dev/Sub: LAKESHORE VILLAGE Xst's: UNKNOWN / WALDEN LN Caller: RANDALL MARK",
        "UNIT:P43F",
        "CALL:Structure-Appliance Contained",
        "ADDR:2 BURNHAM LN",
        "PLACE:LAKESHORE VILLAGE",
        "CITY:Dover",
        "X:UNKNOWN / WALDEN LN",
        "NAME:RANDALL MARK");

    doTest("T4",
        "(Incident Alert) Unit:P43F Status:Dispatched Alarms-Commercial : 36 JEROME DR : WALMART CHESWOLD Venue: Dover Dev/Sub: Xst's: UNKNOWN / N DUPONT HWY Caller: WALMART",
        "UNIT:P43F",
        "CALL:Alarms-Commercial",
        "ADDR:36 JEROME DR",
        "PLACE:WALMART CHESWOLD",
        "CITY:Dover",
        "X:UNKNOWN / N DUPONT HWY",
        "NAME:WALMART");

    doTest("T5",
        "(Incident Alert) Unit:P43F Status:Dispatched Structure-Large Non-Dwelling : 1385 LOCKWOOD CHAPEL RD :  Venue: Hartly Dev/Sub: Xst's: MYERS DR / JUDITH RD Caller:",
        "UNIT:P43F",
        "CALL:Structure-Large Non-Dwelling",
        "ADDR:1385 LOCKWOOD CHAPEL RD",
        "CITY:Hartly",
        "X:MYERS DR / JUDITH RD");

    doTest("T6",
        "(Incident Alert) Unit:P43F Status:Dispatched 29B1 MVC Injuries : MOORTON RD :  Venue: Dover Dev/Sub: LAKESHORE VILLAGE Xst's: Caller: MAULE RICHARD",
        "UNIT:P43F",
        "CODE:29B1",
        "CALL:MVC Injuries",
        "ADDR:MOORTON RD",
        "PLACE:LAKESHORE VILLAGE",
        "CITY:Dover",
        "NAME:MAULE RICHARD");

    doTest("T7",
        "(Incident Alert) Unit:P43F Status:Dispatched Gas Leak-Outside Structure : 5729 W  DENNEYS RD : COMCAST DOVER Venue: Dover Dev/Sub: Xst's: UNKNOWN / N DUPONT HWY Caller: ARNOLD CHERYL",
        "UNIT:P43F",
        "CALL:Gas Leak-Outside Structure",
        "ADDR:5729 W  DENNEYS RD",
        "PLACE:COMCAST DOVER",
        "CITY:Dover",
        "X:UNKNOWN / N DUPONT HWY",
        "NAME:ARNOLD CHERYL");

    doTest("T8",
        "(Incident Alert) Unit:P43F Status:Dispatched 29B4 MVC Unknown : 68 STATE HWY 1 : MM 68 - SR 1 Venue: Dover Dev/Sub: Xst's: FAST LANDING RD / TWIN WILLOWS RD Caller: MARGARET",
        "UNIT:P43F",
        "CODE:29B4",
        "CALL:MVC Unknown",
        "ADDR:68 STATE HWY 1",
        "MADDR:68 STATE 1",
        "PLACE:MM 68 - SR 1",
        "CITY:Dover",
        "X:FAST LANDING RD / TWIN WILLOWS RD",
        "NAME:MARGARET");

    doTest("T9",
        "(Incident Alert) Unit:P43F Status:Dispatched 29B1 MVC Injuries : JEROME DR :  Venue: Dover Dev/Sub: Xst's: Caller: ARNOLD KEVIN",
        "UNIT:P43F",
        "CODE:29B1",
        "CALL:MVC Injuries",
        "ADDR:JEROME DR",
        "CITY:Dover",
        "NAME:ARNOLD KEVIN");

    doTest("T10",
        "(Incident Alert) Unit:P43F Status:Dispatched Gas Leak-Residential Single 127 W  COMMERCE ST  Venue: Clayton Dev/Sub: KENTON Xst's: HIGH ST / COOPER ST Caller:",
        "UNIT:P43F",
        "CALL:Gas Leak-Residential Single",
        "ADDR:127 W COMMERCE ST",
        "PLACE:KENTON",
        "CITY:Clayton",
        "X:HIGH ST / COOPER ST");
   
  }
  
  @Test
  public void testBowersFire() {

    doTest("T1",
        "(Incident Alert) Unit:P40E Status:Dispatched 6D2 Breathing Problems : 2941 BOWERS BEACH RD :  Venue: Frederica Dev/Sub: BAYVIEW HEIGHTS Xst's: ATLANTIC AVE / BAYVIEW AVE Caller: JENNIFER SHAMBLIN",
        "UNIT:P40E",
        "CODE:6D2",
        "CALL:Breathing Problems",
        "ADDR:2941 BOWERS BEACH RD",
        "PLACE:BAYVIEW HEIGHTS",
        "CITY:Frederica",
        "X:ATLANTIC AVE / BAYVIEW AVE",
        "NAME:JENNIFER SHAMBLIN");

    doTest("T2",
        "(Incident Alert) Unit:A40 Status:Dispatched 19D2 Heart Problems  : 696 E  FRONT ST :  Venue: Frederica Dev/Sub: BAKERS CHOICE Xst's: E OAK ST / E POPLAR ST Caller: AMBRUSTER JOHN",
        "UNIT:A40",
        "CODE:19D2",
        "CALL:Heart Problems",
        "ADDR:696 E  FRONT ST",
        "PLACE:BAKERS CHOICE",
        "CITY:Frederica",
        "X:E OAK ST / E POPLAR ST",
        "NAME:AMBRUSTER JOHN");

    doTest("T3",
        "(Incident Alert) Unit:A40 Status:Dispatched 10D2 Chest Pains  : 533 E  3RD ST :  Venue: Frederica Dev/Sub: BAKERS CHOICE Xst's: E POPLAR ST / E OAK ST Caller: KRAFULAK JAMES",
        "UNIT:A40",
        "CODE:10D2",
        "CALL:Chest Pains",
        "ADDR:533 E  3RD ST",
        "PLACE:BAKERS CHOICE",
        "CITY:Frederica",
        "X:E POPLAR ST / E OAK ST",
        "NAME:KRAFULAK JAMES");

    doTest("T4",
        "(Incident Alert) Unit:A40 Status:Dispatched 17A1 Falls - Not Dangerous : 533 E  3RD ST :  Venue: Frederica Dev/Sub: BAKERS CHOICE Xst's: E POPLAR ST / E OAK ST Caller: E KRASULAK",
        "UNIT:A40",
        "CODE:17A1",
        "CALL:Falls - Not Dangerous",
        "ADDR:533 E  3RD ST",
        "PLACE:BAKERS CHOICE",
        "CITY:Frederica",
        "X:E POPLAR ST / E OAK ST",
        "NAME:E KRASULAK");

    doTest("T5",
        "(Incident Alert) Unit:A40 Status:Dispatched 12C1 Seizure - Focal : 2959 BOWERS BEACH RD :  Venue: Frederica Dev/Sub: BAYVIEW HEIGHTS Xst's: ATLANTIC AVE / BAYVIEW AVE Caller: GLODBOROUGH EDMOUND",
        "UNIT:A40",
        "CODE:12C1",
        "CALL:Seizure - Focal",
        "ADDR:2959 BOWERS BEACH RD",
        "PLACE:BAYVIEW HEIGHTS",
        "CITY:Frederica",
        "X:ATLANTIC AVE / BAYVIEW AVE",
        "NAME:GLODBOROUGH EDMOUND");

    doTest("T6",
        "(Incident Alert) Unit:A40 Status:Dispatched 17B1G Falls - Possibly Dangerous : 55 WILLIAMS AVE :  Venue: Frederica Dev/Sub: BOWERS BEACH Xst's: UNKNOWN / MAIN ST Caller:",
        "UNIT:A40",
        "CODE:17B1G",
        "CALL:Falls - Possibly Dangerous",
        "ADDR:55 WILLIAMS AVE",
        "PLACE:BOWERS BEACH",
        "CITY:Frederica",
        "X:UNKNOWN / MAIN ST");

    doTest("T7",
        "(Incident Alert) Unit:A40 Status:Dispatched 32B2 - Medic Alert : 215 KESTREL CT :  Venue: Frederica Dev/Sub: HIGH POINT MHP Xst's: LAKE SHORE DR / DEAD END Caller: DES",
        "UNIT:A40",
        "CODE:32B2",
        "CALL:Medic Alert",
        "ADDR:215 KESTREL CT",
        "PLACE:HIGH POINT MHP",
        "CITY:Frederica",
        "X:LAKE SHORE DR / DEAD END",
        "NAME:DES");

    doTest("T8",
        "(Incident Alert) Unit:A40 Status:Dispatched 6D2 Breathing Problems : 344 JEAN BRADLEY CIR :  Venue: Frederica Dev/Sub: HIGH POINT MHP Xst's: LAKE SHORE DR / WEST DR Caller: PEDRICK",
        "UNIT:A40",
        "CODE:6D2",
        "CALL:Breathing Problems",
        "ADDR:344 JEAN BRADLEY CIR",
        "PLACE:HIGH POINT MHP",
        "CITY:Frederica",
        "X:LAKE SHORE DR / WEST DR",
        "NAME:PEDRICK");

    doTest("T9",
        "(Incident Alert) Unit:P40E Status:Dispatched 6D2 Breathing Problems : 46 SYCAMORE DR :  Venue: Frederica Dev/Sub: HIGH POINT MHP Xst's: SECOND ST, FRONT ST / LAKE SHORE DR, SECOND ST Caller: KATHRYNE",
        "UNIT:P40E",
        "CODE:6D2",
        "CALL:Breathing Problems",
        "ADDR:46 SYCAMORE DR",
        "PLACE:HIGH POINT MHP",
        "CITY:Frederica",
        "X:SECOND ST, FRONT ST / LAKE SHORE DR, SECOND ST",
        "NAME:KATHRYNE");

    doTest("T10",
        "(Incident Alert) Unit:A40 Status:Dispatched 17A1G Falls - Not Dangerous  : 216 KESTREL CT :  Venue: Frederica Dev/Sub: HIGH POINT MHP Xst's: LAKE SHORE DR / DEAD END Caller: 71 DES",
        "UNIT:A40",
        "CODE:17A1G",
        "CALL:Falls - Not Dangerous",
        "ADDR:216 KESTREL CT",
        "PLACE:HIGH POINT MHP",
        "CITY:Frederica",
        "X:LAKE SHORE DR / DEAD END",
        "NAME:71 DES");

    doTest("T11",
        "(Incident Alert) Unit:A40 Status:Dispatched 17B1G Falls - Possibly Dangerous : 533 E  3RD ST :  Venue: Frederica Dev/Sub: BAKERS CHOICE Xst's: E POPLAR ST / E OAK ST Caller: PLYMINE SUZANNE",
        "UNIT:A40",
        "CODE:17B1G",
        "CALL:Falls - Possibly Dangerous",
        "ADDR:533 E  3RD ST",
        "PLACE:BAKERS CHOICE",
        "CITY:Frederica",
        "X:E POPLAR ST / E OAK ST",
        "NAME:PLYMINE SUZANNE");

    doTest("T12",
        "(Incident Alert) Unit:A40 Status:Dispatched 10D4 Chest Pains - Clammy : 78 SYCAMORE DR :  Venue: Frederica Dev/Sub: HIGH POINT MHP Xst's: LAKE SHORE DR, SECOND ST / SECOND ST, FRONT ST Caller: HARMON BRITTANY",
        "UNIT:A40",
        "CODE:10D4",
        "CALL:Chest Pains - Clammy",
        "ADDR:78 SYCAMORE DR",
        "PLACE:HIGH POINT MHP",
        "CITY:Frederica",
        "X:LAKE SHORE DR, SECOND ST / SECOND ST, FRONT ST",
        "NAME:HARMON BRITTANY");

    doTest("T13",
        "(Incident Alert) Unit:A40 Status:Dispatched 26O7 Sick Person - Constipation : 303 LAKE SHORE DR :  Venue: Frederica Dev/Sub: HIGH POINT MHP Xst's: WENDY LN / DONNA LN Caller: OPDYKE MARY",
        "UNIT:A40",
        "CODE:26O7",
        "CALL:Sick Person - Constipation",
        "ADDR:303 LAKE SHORE DR",
        "PLACE:HIGH POINT MHP",
        "CITY:Frederica",
        "X:WENDY LN / DONNA LN",
        "NAME:OPDYKE MARY");

    doTest("T14",
        "(Incident Alert) Unit:A40 Status:Dispatched 29B1 MVC Injuries : CANTERBURY RD :  Venue: Milford Dev/Sub: Xst's: Caller: FETZER ROBERT",
        "UNIT:A40",
        "CODE:29B1",
        "CALL:MVC Injuries",
        "ADDR:CANTERBURY RD",
        "CITY:Milford",
        "NAME:FETZER ROBERT");

    doTest("T15",
        "(Incident Alert) Unit:A40 Status:Dispatched 31A3 Fainting Episode : 1 MOONWALKER RD : ILC INDUSTRIES Venue: Felton Dev/Sub: Xst's: DEAD END / DEAD END Caller: GALLO SHANNON",
        "UNIT:A40",
        "CODE:31A3",
        "CALL:Fainting Episode",
        "ADDR:1 MOONWALKER RD",
        "PLACE:ILC INDUSTRIES",
        "CITY:Felton",
        "X:DEAD END / DEAD END",
        "NAME:GALLO SHANNON");
 
  }
  
  public static void main(String[] args) {
    new DEKentCountyCParserTest().generateTests("T1");
  }
}
    		