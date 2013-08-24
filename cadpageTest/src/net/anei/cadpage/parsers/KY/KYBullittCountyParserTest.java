package net.anei.cadpage.parsers.KY;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.KY.KYBullittCountyParser;

import org.junit.Test;

/*
Bullitt County, KY
Contact: codeMessaging
Sender:  codeMessaging
BULLITT CO 911:NOINJ >NO INJURY ACCIDENT WATER ST & HWY 44 Cad: 2013-0000006371
BULLITT CO 911:STRUCT>FIRE / STRUCTURE 2340 ARMSTRONG LN XS: HIGHWAY 44 E MT WASHINGTON TRESHA MOTES Map: Grids:, Cad: 2013-0000006447
BULLITT CO 911:INJACC>INJURY ACCIDENT 44 E IN FRONT OF SUBWAY ARIEL BAILEY 5025547459 Cad: 2013-0000006657
BULLITT CO 911:INJPER>INJURED PERSON 2818 HIGHWAY 44 E SHEPHERDSVILLE UNK 5025588061 Map: Grids:, Cad: 2013-0000006871
BULLITT CO 911:ALRFIR>ALARM / FIRE 989 KINGS CHURCH RD TAYLORSVILLE SIMPLEX 8887467539 Map: Grids:, Cad: 2013-0000006898
BULLITT CO 911:LOCK >CHILD LOCKED IN VEHICLE 320 N BARDSTOWN RD XS: HIGHWAY 44 E MT WASHINGTON SHERRY 5029308733 Map: Grids:, Cad: 2013-0000007030
BULLITT CO 911:INJACC>INJURY ACCIDENT DELANIA DR&HIGHWAY 44 E XS: HIGHWAY 44 E MT WASHINGTON AT&T MOBILITY 5024924566 Cad: 2013-0000007451
BULLITT CO 911:INJACC>INJURY ACCIDENT HWY 44 EAT BARDSTOWN RD AT&T MOBILITY 5029385603 Cad: 2013-0000007801
BULLITT CO 911:NOINJ >NO INJURY ACCIDENT 673 N BARDSTOWN RD XS: HIGHWAY 44 E MT WASHINGTON AT&T MOBILITY 5024924564 Map: Grids:, Cad: 2013-0000007811
BULLITT CO 911:FIRE >FIRE DEPARTMENT CALL N BARDSTOWN RD VIVIN 5024089597 Cad: 2013-0000007848
BULLITT CO 911:ALRFIR>ALARM / FIRE 1098 N BARDSTOWN RD XS: HIGHWAY 44 E MT WASHINGTON BLUEGRASS 8008979145 Map: Grids:, Cad: 2013-0000008156
BULLITT CO 911:FIRE >FIRE DEPARTMENT CALL 188 MEADOWVIEW DR XS: N BARDSTOWN RD MT WASHINGTON ROBERT PATTON 5025388792 Map: Grids:, Cad: 2013-0000008493
BULLITT CO 911:NOINJ >NO INJURY ACCIDENT 44 AT CROSSROADS STA 941 Cad: 2013-0000008519 
BULLITT CO 911:LOCK >CHILD LOCKED IN VEHICLE 169 CENTRAL BLVD XS: HIGHWAY 44 E MT WASHINGTON WAGONER,RENEE 5024194707 Map: Grids:, Cad: 2013-0000009916
BULLITT CO 911:ALRFIR>ALARM / FIRE 144 BUTTONWOOD CT XS: CLIFFSIDE DR SHEPHERDSVILLE MONATRONICS 8004191730 Map: Grids:, Cad: 2013-0000009457
BULLITT CO 911:NOINJ >NO INJURY ACCIDENT 31EX AT LANDIS LN TONYA 5024289196 Cad: 2013-0000009615

Contact: Active911
Agency name: Mount Washington Fire Protection District
Location: Mount Washington, KY, United States
Sender: rc.663@c-msg.net
BULLITT CO 911:GAS >NATURAL OR LP GAS LEAK 124 KRISTEN MARIE CT MT WASHINGTON LAURA CHAPMAN 5027626472 Cad: 2013-0000010047
BULLITT CO 911:DOMEST>DOMESTIC 156 ERIN CIR XS: WILCHAR BLVD MT WASHINGTON VERIZON 5026454512 Map: Grids:, Cad: 2013-0000010012
BULLITT CO 911:LOCK >CHILD LOCKED IN VEHICLE 169 CENTRAL BLVD XS: HIGHWAY 44 E MT WASHINGTON WAGONER,RENEE 5024194707 Map: Grids:, Cad: 2013-0000009916
BULLITT CO 911:NOINJ >NO INJURY ACCIDENT 31EX AT LANDIS LN TONYA 5024289196 Cad: 2013-0000009615
BULLITT CO 911:ALRFIR>ALARM / FIRE 144 BUTTONWOOD CT XS: CLIFFSIDE DR SHEPHERDSVILLE MONATRONICS 8004191730 Map: Grids:, Cad: 2013-0000009457
BULLITT CO 911:NOINJ >NO INJURY ACCIDENT 44 AT CROSSROADS STA 941 Cad: 2013-0000008519
BULLITT CO 911:FIRE >FIRE DEPARTMENT CALL 188 MEADOWVIEW DR XS: N BARDSTOWN RD MT WASHINGTON ROBERT PATTON 5025388792 Map: Grids:, Cad: 2013-0000008493
BULLITT CO 911:ALRFIR>ALARM / FIRE 1098 N BARDSTOWN RD XS: HIGHWAY 44 E MT WASHINGTON BLUEGRASS 8008979145 Map: Grids:, Cad: 2013-0000008156

Agency name: Zoneton Fire Protection District
Location: Shepherdsville, KY, United States
Contact: Active911
Sender: rc.719@c-msg.net

BULLITT CO 911:SMOKE >SMOKE INVESTIGATION HIGHWAY 1020 BILLY 5026122516 Cad: 2013-0000013960
BULLITT CO 911:INJACC>INJURY ACCIDENT N PRESTON HWY @ JOHN HARPER SHEPHERDSVILLE ASHLEY TINNELL 5023381415 Cad: 2013-0000013825
BULLITT CO 911:INJACC>INJURY ACCIDENT HWY 1526 AT NB EXIT RAMP BUTLER 5026818145 Cad: 2013-0000013820
BULLITT CO 911:LINES >LINES DOWN POWER/PHONE/CABLE 518 BLOSSOM RD XS: HILLVIEW BLVD LOUISVILLE KRISTEN BENNET 5025658942 Map: Grids:, Cad: 2013-0000013817
BULLITT CO 911:FULARR>CARDIAC ARREST 2999 CORAL RIDGE RD JOANNE MCINTYRE 5022779152 Cad: 2013-0000013745
BULLITT CO 911:ALRFIR>ALARM / FIRE 127 W MILLWATER FLS XS: MILL TRACE SHEPHERDSVILLE MATTINGLY/VIVINT SEC 8778203858 Cad: 2013-0000013658
BULLITT CO 911:INJACC>INJURY ACCIDENT BELLS MILL RD XS: N PRESTON HIGHWAY SHEPHERDSVILLE AT&T MOBILITY 5022927617 Map: Grids:, Cad: 2013-0000013650
BULLITT CO 911:INJACC>INJURY ACCIDENT 121 I 65 S XS: HARDIN CO LINE SHEPHERDSVILLE Cad: 2013-0000013482
BULLITT CO 911:INJACC>INJURY ACCIDENT HWY 61 @ ROUNDTREES FLEA MKT XS: HIGHWAY 44 E SHEPHERDSVILLE SANDRA CURTSINGER 5025416715 Cad: 2013-0000013476
BULLITT CO 911:INJACC>INJURY ACCIDENT 818 OLD PRESTON HWY N XS: N PRESTON HWY LOUISVILLE UNIQUE AUTO BOD 5022779211 Map: Grids:, Cad: 2013-0000013429
BULLITT CO 911:ASSIST>ASSIST 265 NORTHVIEW DR XS: N PRESTON HWY SHEPHERDSVILLE BIANCA BERRY 5029210884 Map: Grids:, Cad: 2013-0000013420
BULLITT CO 911:INJACC>INJURY ACCIDENT 65 AT 1526 JAMES DALTON 5029392831 Cad: 2013-0000013221
BULLITT CO 911:ALRFIR>ALARM / FIRE 199 DEAN ST XS: E BLUE LICK RD SHEPHERDSVILLE NANCY SCARBROUGH 5022779322 Map: Grids:, Cad: 2013-0000013171
BULLITT CO 911:BRUSH >BRUSH/GRASS/MULCH/WOODS MT CARMEL CHURCH RD XS: WILSON CREEK RD LEBANON JUNCTION JASON SWIGART 5027101504 Cad: 2013-0000013098
BULLITT CO 911:INJACC>INJURY ACCIDENT HILLVIEW BLVD&E BLUE LICK RD XS: N PRESTON HWY LOUISVILLE ANDY MARSHALL 5029573521 Cad: 2013-0000013095
BULLITT CO 911:VEHFIR>FIRE / VEHICLE 118 I 65 S XS: HARDIN CO LINE SHEPHERDSVILLE KEN 5028350557 Cad: 2013-0000013005
BULLITT CO 911:ALRFIR>ALARM / FIRE 716 BROOKS HILL RD XS: E BLUE LICK BROOKS EMERGENCY MONITORING 8008773624 Map: Grids:, Cad: 2013-0000012993
BULLITT CO 911:INJACC>INJURY ACCIDENT N PRESTON HWY XS: HIGHWAY 44 E SHEPHERDSVILLE LISA CHERRY 5027245501 Map: Grids:, Cad: 2013-0000012828
BULLITT CO 911:UNCON >UNCONCIOUS PERSON 163 MILLWOOD CT XS: MILLERS CROSSINGS SHEPHERDSVILLE CALHOUN, MICHAEL 5025438794 Map: Grids:, Cad: 2013-0000012739
BULLITT CO 911:VEHFIR>FIRE / VEHICLE 155 HILLVIEW BLVD XS: N PRESTON HWY LOUISVILLE Map: Grids:, Cad: 2013-0000012602
BULLITT CO 911:STRUCT>FIRE / STRUCTURE 202 E BLUEJAY RD XS: MAYFLOWER RD LOUISVILLE Map: Grids:, Cad: 2013-0000012399
BULLITT CO 911:INJACC>INJURY ACCIDENT PRESTON HWY SHEPHERDSVILLE TIM NEWTON 5024173125 Cad: 2013-0000012385
BULLITT CO 911:DIFBRE>DIFFICULTY BREATHING 12211 SOMERSET DR XS: SUMMERS DR LOUISVILLE PATTY HORNUNG 5029573672 Map: Grids:, Cad: 2013-0000012017
BULLITT CO 911:INJACC>INJURY ACCIDENT BROOKS HILL RD XS: E BLUE LICK BROOKS SPPCS 5022101340 Cad: 2013-0000011909
BULLITT CO 911:NOINJ >NO INJURY ACCIDENT E BLUE LICK RD XS: 1526/JOHN HARPER HWY LOUISVILLE 5025942874 Cad: 2013-0000011883
BULLITT CO 911:SHOOT >SHOOTING 210 PIKE LN XS: CHURCH ST LEBANON JUNCTION HARDIN CO 911 / KEVIN 2702340931 Map: Grids:, Cad: 2013-0000011873
BULLITT CO 911:VEHFIR>FIRE / VEHICLE 11400 N PRESTON HWY XS: HIGHWAY 44 E LOUISVILLE ANITA SMITH 5024091827 Cad: 2013-0000011782
BULLITT CO 911:STRUCT>FIRE / STRUCTURE 299 NELLIE WAY XS: WILDERNESS RD BROOKS VICTORIA 5023860302 Map: Grids:, Cad: 2013-0000011766
BULLITT CO 911:SICK >SICK PERSON 140 CREEKSIDE DR XS: PRYOR VALLEY RD SHEPHERDSVILLE TAMMY MEREDITH 5025310172 Map: Grids:, Cad: 2013-0000011694
BULLITT CO 911:GAS >NATURAL OR LP GAS LEAK 156 RED BIRD CT XS: MAYFLOWER RD LOUISVILLE KEITH CAULK 5026419074 Map: Grids:, Cad: 2013-0000011530
BULLITT CO 911:FULARR>CARDIAC ARREST 480 CRESTWOOD LN XS: S SKYLINE DR LOUISVILLE Map: Grids:, Cad: 2013-0000011263
BULLITT CO 911:DIFBRE>DIFFICULTY BREATHING 480 CRESTWOOD LN XS: S SKYLINE DR LOUISVILLE Map: Grids:, Cad: 2013-0000011263
BULLITT CO 911:INJACC>INJURY ACCIDENT 121 I 65 S XS: HARDIN CO LINE SHEPHERDSVILLE CHRIS GARDNER 5022963651 Cad: 2013-0000011201
BULLITT CO 911:NOINJ >NO INJURY ACCIDENT 3315 E BLUE LICK RD XS: 1526/JOHN HARPER HWY SHEPHERDSVILLE PATRICK BAKER 5027184641 Map: Grids:, Cad: 2013-0000011197
BULLITT CO 911:VEHFIR>FIRE / VEHICLE 120 I 65 S XS: HARDIN CO LINE SHEPHERDSVILLE FRANKIE 5027412144 Map: Grids:, Cad: 2013-0000011187
BULLITT CO 911:FIRE >FIRE DEPARTMENT CALL 315 BARRICKS RD Apt: 265 Bldg XS: BEECH DR @ WHISPERING OAKS MHP LOUISVILLE BECKY 5023037982 Map: Grids:, Cad: 2013-0000011182
BULLITT CO 911:FIRE >FIRE DEPARTMENT CALL 1210 BELLS MILL RD XS: N PRESTON HWY SHEPHERDSVILLE GOLLAR,SANDY 5029573423 Map: Grids:, Cad: 2013-0000011181
BULLITT CO 911:EMS >EMS CALL 304 WILMA AVE XS: N PRESTON HWY LOUISVILLE DEBBIE 5025519905 Map: Grids:, Cad: 2013-0000011173
BULLITT CO 911:FIRE >FIRE DEPARTMENT CALL 391 BARRICKS RD XS: BEECH DR @ WHISPERING OAKS MHP LOUISVILLE MONTE FURMAN Map: Grids:, Cad: 2013-0000011137
BULLITT CO 911:FIRE >FIRE DEPARTMENT CALL 265 BARRICKS RD XS: BEECH DR @ WHISPERING OAKS MHP LOUISVILLE MONTE FURMAN Map: Grids:, Cad: 2013-0000011137
BULLITT CO 911:WATER >WATER RESCUE 150 N TRIANGLE LN Apt: 108 Bldg XS: E BLUE LICK RD LOUISVILLE ALERT 1 5029576256 Map: Grids:, Cad: 2013-0000011126
BULLITT CO 911:TEST >TEST 5328 N PRESTON HWY XS: HIGHWAY 44 E SHEPHERDSVILLE Map: Grids:, Cad: 2013-0000011052

 */

public class KYBullittCountyParserTest extends BaseParserTest {
  
  public KYBullittCountyParserTest() {
    setParser(new KYBullittCountyParser(), "BULLITT COUNTY", "KY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "BULLITT CO 911:NOINJ >NO INJURY ACCIDENT WATER ST & HWY 44 Cad: 2013-0000006371",
        "CALL:NO INJURY ACCIDENT",
        "ADDR:WATER ST & HWY 44",  // Does not map initially - Reported to Google
        "ID:2013-0000006371");

    doTest("T2",
        "BULLITT CO 911:STRUCT>FIRE / STRUCTURE 2340 ARMSTRONG LN XS: HIGHWAY 44 E MT WASHINGTON TRESHA MOTES Map: Grids:, Cad: 2013-0000006447",
        "CALL:FIRE / STRUCTURE",
        "ADDR:2340 ARMSTRONG LN",
        "X:HIGHWAY 44 E",
        "CITY:MT WASHINGTON",
        "NAME:TRESHA MOTES",
        "ID:2013-0000006447");

    doTest("T3",
        "BULLITT CO 911:INJACC>INJURY ACCIDENT 44 E IN FRONT OF SUBWAY ARIEL BAILEY 5025547459 Cad: 2013-0000006657",
        "CALL:INJURY ACCIDENT",
        "ADDR:44 E IN FRONT OF SUBWAY ARIEL BAILEY",
        "PHONE:5025547459",
        "ID:2013-0000006657");

    doTest("T4",
        "BULLITT CO 911:INJPER>INJURED PERSON 2818 HIGHWAY 44 E SHEPHERDSVILLE UNK 5025588061 Map: Grids:, Cad: 2013-0000006871",
        "CALL:INJURED PERSON",
        "ADDR:2818 HIGHWAY 44 E",
        "CITY:SHEPHERDSVILLE",
        "PHONE:5025588061",
        "ID:2013-0000006871");

    doTest("T5",
        "BULLITT CO 911:ALRFIR>ALARM / FIRE 989 KINGS CHURCH RD TAYLORSVILLE SIMPLEX 8887467539 Map: Grids:, Cad: 2013-0000006898",
        "CALL:ALARM / FIRE",
        "ADDR:989 KINGS CHURCH RD",
        "CITY:TAYLORSVILLE",
        "NAME:SIMPLEX",
        "PHONE:8887467539",
        "ID:2013-0000006898");

    doTest("T6",
        "BULLITT CO 911:LOCK >CHILD LOCKED IN VEHICLE 320 N BARDSTOWN RD XS: HIGHWAY 44 E MT WASHINGTON SHERRY 5029308733 Map: Grids:, Cad: 2013-0000007030",
        "CALL:CHILD LOCKED IN VEHICLE",
        "ADDR:320 N BARDSTOWN RD",
        "X:HIGHWAY 44 E",
        "CITY:MT WASHINGTON",
        "NAME:SHERRY",
        "PHONE:5029308733",
        "ID:2013-0000007030");

    doTest("T7",
        "BULLITT CO 911:INJACC>INJURY ACCIDENT DELANIA DR&HIGHWAY 44 E XS: HIGHWAY 44 E MT WASHINGTON AT&T MOBILITY 5024924566 Cad: 2013-0000007451",
        "CALL:INJURY ACCIDENT",
        "ADDR:DELANIA DR & HIGHWAY 44 E",
        "X:HIGHWAY 44 E",
        "CITY:MT WASHINGTON",
        "PHONE:5024924566",
        "ID:2013-0000007451");

    doTest("T8",
        "BULLITT CO 911:INJACC>INJURY ACCIDENT HWY 44 EAT BARDSTOWN RD AT&T MOBILITY 5029385603 Cad: 2013-0000007801",
        "CALL:INJURY ACCIDENT",
        "ADDR:HWY 44",
        "NAME:EAT BARDSTOWN RD",
        "PHONE:5029385603",
        "ID:2013-0000007801");

    doTest("T9",
        "BULLITT CO 911:NOINJ >NO INJURY ACCIDENT 673 N BARDSTOWN RD XS: HIGHWAY 44 E MT WASHINGTON AT&T MOBILITY 5024924564 Map: Grids:, Cad: 2013-0000007811",
        "CALL:NO INJURY ACCIDENT",
        "ADDR:673 N BARDSTOWN RD",
        "X:HIGHWAY 44 E",
        "CITY:MT WASHINGTON",
        "PHONE:5024924564",
        "ID:2013-0000007811");

    doTest("T10",
        "BULLITT CO 911:FIRE >FIRE DEPARTMENT CALL N BARDSTOWN RD VIVIN 5024089597 Cad: 2013-0000007848",
        "CALL:FIRE DEPARTMENT CALL",
        "ADDR:N BARDSTOWN RD",
        "NAME:VIVIN",
        "PHONE:5024089597",
        "ID:2013-0000007848");

    doTest("T11",
        "BULLITT CO 911:ALRFIR>ALARM / FIRE 1098 N BARDSTOWN RD XS: HIGHWAY 44 E MT WASHINGTON BLUEGRASS 8008979145 Map: Grids:, Cad: 2013-0000008156",
        "CALL:ALARM / FIRE",
        "ADDR:1098 N BARDSTOWN RD",
        "X:HIGHWAY 44 E",
        "CITY:MT WASHINGTON",
        "NAME:BLUEGRASS",
        "PHONE:8008979145",
        "ID:2013-0000008156");

    doTest("T12",
        "BULLITT CO 911:FIRE >FIRE DEPARTMENT CALL 188 MEADOWVIEW DR XS: N BARDSTOWN RD MT WASHINGTON ROBERT PATTON 5025388792 Map: Grids:, Cad: 2013-0000008493",
        "CALL:FIRE DEPARTMENT CALL",
        "ADDR:188 MEADOWVIEW DR",
        "X:N BARDSTOWN RD",
        "CITY:MT WASHINGTON",
        "NAME:ROBERT PATTON",
        "PHONE:5025388792",
        "ID:2013-0000008493");

    doTest("T13",
        "BULLITT CO 911:NOINJ >NO INJURY ACCIDENT 44 AT CROSSROADS STA 941 Cad: 2013-0000008519 ",
        "CALL:NO INJURY ACCIDENT",
        "ADDR:44 AT CROSSROADS STA 941",
        "ID:2013-0000008519");

    doTest("T14",
        "BULLITT CO 911:LOCK >CHILD LOCKED IN VEHICLE 169 CENTRAL BLVD XS: HIGHWAY 44 E MT WASHINGTON WAGONER,RENEE 5024194707 Map: Grids:, Cad: 2013-0000009916",
        "CALL:CHILD LOCKED IN VEHICLE",
        "ADDR:169 CENTRAL BLVD",
        "X:HIGHWAY 44 E",
        "CITY:MT WASHINGTON",
        "NAME:WAGONER,RENEE",
        "PHONE:5024194707",
        "ID:2013-0000009916");

    doTest("T15",
        "BULLITT CO 911:ALRFIR>ALARM / FIRE 144 BUTTONWOOD CT XS: CLIFFSIDE DR SHEPHERDSVILLE MONATRONICS 8004191730 Map: Grids:, Cad: 2013-0000009457",
        "CALL:ALARM / FIRE",
        "ADDR:144 BUTTONWOOD CT",
        "X:CLIFFSIDE DR",
        "CITY:SHEPHERDSVILLE",
        "NAME:MONATRONICS",
        "PHONE:8004191730",
        "ID:2013-0000009457");

    doTest("T16",
        "BULLITT CO 911:NOINJ >NO INJURY ACCIDENT 31EX AT LANDIS LN TONYA 5024289196 Cad: 2013-0000009615",
        "CALL:NO INJURY ACCIDENT",
        "ADDR:31EX AT LANDIS LN", // No idea what this means???
        "NAME:TONYA",
        "PHONE:5024289196",
        "ID:2013-0000009615");

  }
  
  @Test
  public void testMountWashingtonFire() {

    doTest("T1",
        "BULLITT CO 911:GAS >NATURAL OR LP GAS LEAK 124 KRISTEN MARIE CT MT WASHINGTON LAURA CHAPMAN 5027626472 Cad: 2013-0000010047",
        "CALL:NATURAL OR LP GAS LEAK",
        "ADDR:124 KRISTEN MARIE CT",
        "CITY:MT WASHINGTON",
        "NAME:LAURA CHAPMAN",
        "PHONE:5027626472",
        "ID:2013-0000010047");

    doTest("T2",
        "BULLITT CO 911:DOMEST>DOMESTIC 156 ERIN CIR XS: WILCHAR BLVD MT WASHINGTON VERIZON 5026454512 Map: Grids:, Cad: 2013-0000010012",
        "CALL:DOMESTIC",
        "ADDR:156 ERIN CIR",
        "X:WILCHAR BLVD",
        "CITY:MT WASHINGTON",
        "PHONE:5026454512",
        "ID:2013-0000010012");

    doTest("T3",
        "BULLITT CO 911:LOCK >CHILD LOCKED IN VEHICLE 169 CENTRAL BLVD XS: HIGHWAY 44 E MT WASHINGTON WAGONER,RENEE 5024194707 Map: Grids:, Cad: 2013-0000009916",
        "CALL:CHILD LOCKED IN VEHICLE",
        "ADDR:169 CENTRAL BLVD",
        "X:HIGHWAY 44 E",
        "CITY:MT WASHINGTON",
        "NAME:WAGONER,RENEE",
        "PHONE:5024194707",
        "ID:2013-0000009916");

    doTest("T4",
        "BULLITT CO 911:NOINJ >NO INJURY ACCIDENT 31EX AT LANDIS LN TONYA 5024289196 Cad: 2013-0000009615",
        "CALL:NO INJURY ACCIDENT",
        "ADDR:31EX AT LANDIS LN",
        "NAME:TONYA",
        "PHONE:5024289196",
        "ID:2013-0000009615");

    doTest("T5",
        "BULLITT CO 911:ALRFIR>ALARM / FIRE 144 BUTTONWOOD CT XS: CLIFFSIDE DR SHEPHERDSVILLE MONATRONICS 8004191730 Map: Grids:, Cad: 2013-0000009457",
        "CALL:ALARM / FIRE",
        "ADDR:144 BUTTONWOOD CT",
        "X:CLIFFSIDE DR",
        "CITY:SHEPHERDSVILLE",
        "NAME:MONATRONICS",
        "PHONE:8004191730",
        "ID:2013-0000009457");

    doTest("T6",
        "BULLITT CO 911:NOINJ >NO INJURY ACCIDENT 44 AT CROSSROADS STA 941 Cad: 2013-0000008519",
        "CALL:NO INJURY ACCIDENT",
        "ADDR:44 AT CROSSROADS STA 941",
        "ID:2013-0000008519");

    doTest("T7",
        "BULLITT CO 911:FIRE >FIRE DEPARTMENT CALL 188 MEADOWVIEW DR XS: N BARDSTOWN RD MT WASHINGTON ROBERT PATTON 5025388792 Map: Grids:, Cad: 2013-0000008493",
        "CALL:FIRE DEPARTMENT CALL",
        "ADDR:188 MEADOWVIEW DR",
        "X:N BARDSTOWN RD",
        "CITY:MT WASHINGTON",
        "NAME:ROBERT PATTON",
        "PHONE:5025388792",
        "ID:2013-0000008493");

    doTest("T8",
        "BULLITT CO 911:ALRFIR>ALARM / FIRE 1098 N BARDSTOWN RD XS: HIGHWAY 44 E MT WASHINGTON BLUEGRASS 8008979145 Map: Grids:, Cad: 2013-0000008156",
        "CALL:ALARM / FIRE",
        "ADDR:1098 N BARDSTOWN RD",
        "X:HIGHWAY 44 E",
        "CITY:MT WASHINGTON",
        "NAME:BLUEGRASS",
        "PHONE:8008979145",
        "ID:2013-0000008156");
    
  }
  
  @Test
  public void testZonetonFire() {

    doTest("T1",
        "BULLITT CO 911:SMOKE >SMOKE INVESTIGATION HIGHWAY 1020 BILLY 5026122516 Cad: 2013-0000013960",
        "CALL:SMOKE INVESTIGATION",
        "ADDR:HIGHWAY 1020",
        "NAME:BILLY",
        "PHONE:5026122516",
        "ID:2013-0000013960");

    doTest("T2",
        "BULLITT CO 911:INJACC>INJURY ACCIDENT N PRESTON HWY @ JOHN HARPER SHEPHERDSVILLE ASHLEY TINNELL 5023381415 Cad: 2013-0000013825",
        "CALL:INJURY ACCIDENT",
        "ADDR:N PRESTON HWY & JOHN HARPER",
        "CITY:SHEPHERDSVILLE",
        "NAME:ASHLEY TINNELL",
        "PHONE:5023381415",
        "ID:2013-0000013825");

    doTest("T3",
        "BULLITT CO 911:INJACC>INJURY ACCIDENT HWY 1526 AT NB EXIT RAMP BUTLER 5026818145 Cad: 2013-0000013820",
        "CALL:INJURY ACCIDENT",
        "ADDR:HWY 1526",
        "NAME:AT NB EXIT RAMP BUTLER",
        "PHONE:5026818145",
        "ID:2013-0000013820");

    doTest("T4",
        "BULLITT CO 911:LINES >LINES DOWN POWER/PHONE/CABLE 518 BLOSSOM RD XS: HILLVIEW BLVD LOUISVILLE KRISTEN BENNET 5025658942 Map: Grids:, Cad: 2013-0000013817",
        "CALL:LINES DOWN POWER/PHONE/CABLE",
        "ADDR:518 BLOSSOM RD",
        "X:HILLVIEW BLVD",
        "CITY:LOUISVILLE",
        "NAME:KRISTEN BENNET",
        "PHONE:5025658942",
        "ID:2013-0000013817");

    doTest("T5",
        "BULLITT CO 911:FULARR>CARDIAC ARREST 2999 CORAL RIDGE RD JOANNE MCINTYRE 5022779152 Cad: 2013-0000013745",
        "CALL:CARDIAC ARREST",
        "ADDR:2999 CORAL RIDGE RD",
        "NAME:JOANNE MCINTYRE",
        "PHONE:5022779152",
        "ID:2013-0000013745");

    doTest("T6",
        "BULLITT CO 911:ALRFIR>ALARM / FIRE 127 W MILLWATER FLS XS: MILL TRACE SHEPHERDSVILLE MATTINGLY/VIVINT SEC 8778203858 Cad: 2013-0000013658",
        "CALL:ALARM / FIRE",
        "ADDR:127 W MILLWATER FLS",  // Can't find this one
        "X:MILL TRACE",
        "CITY:SHEPHERDSVILLE",
        "NAME:MATTINGLY/VIVINT SEC",
        "PHONE:8778203858",
        "ID:2013-0000013658");

    doTest("T7",
        "BULLITT CO 911:INJACC>INJURY ACCIDENT BELLS MILL RD XS: N PRESTON HIGHWAY SHEPHERDSVILLE AT&T MOBILITY 5022927617 Map: Grids:, Cad: 2013-0000013650",
        "CALL:INJURY ACCIDENT",
        "ADDR:BELLS MILL RD",
        "MADDR:BELLS MILL RD & N PRESTON HIGHWAY",
        "X:N PRESTON HIGHWAY",
        "CITY:SHEPHERDSVILLE",
        "PHONE:5022927617",
        "ID:2013-0000013650");

    doTest("T8",
        "BULLITT CO 911:INJACC>INJURY ACCIDENT 121 I 65 S XS: HARDIN CO LINE SHEPHERDSVILLE Cad: 2013-0000013482",
        "CALL:INJURY ACCIDENT",
        "ADDR:121 I 65 S",
        "X:HARDIN CO LINE",
        "CITY:SHEPHERDSVILLE",
        "ID:2013-0000013482");

    doTest("T9",
        "BULLITT CO 911:INJACC>INJURY ACCIDENT HWY 61 @ ROUNDTREES FLEA MKT XS: HIGHWAY 44 E SHEPHERDSVILLE SANDRA CURTSINGER 5025416715 Cad: 2013-0000013476",
        "CALL:INJURY ACCIDENT",
        "ADDR:HWY 61 & ROUNDTREES FLEA MKT",  // Not mapping
        "X:HIGHWAY 44 E",
        "CITY:SHEPHERDSVILLE",
        "NAME:SANDRA CURTSINGER",
        "PHONE:5025416715",
        "ID:2013-0000013476");

    doTest("T10",
        "BULLITT CO 911:INJACC>INJURY ACCIDENT 818 OLD PRESTON HWY N XS: N PRESTON HWY LOUISVILLE UNIQUE AUTO BOD 5022779211 Map: Grids:, Cad: 2013-0000013429",
        "CALL:INJURY ACCIDENT",
        "ADDR:818 OLD PRESTON HWY N",
        "X:N PRESTON HWY",
        "CITY:LOUISVILLE",
        "NAME:UNIQUE AUTO BOD",
        "PHONE:5022779211",
        "ID:2013-0000013429");

    doTest("T11",
        "BULLITT CO 911:ASSIST>ASSIST 265 NORTHVIEW DR XS: N PRESTON HWY SHEPHERDSVILLE BIANCA BERRY 5029210884 Map: Grids:, Cad: 2013-0000013420",
        "CALL:ASSIST",
        "ADDR:265 NORTHVIEW DR",
        "X:N PRESTON HWY",
        "CITY:SHEPHERDSVILLE",
        "NAME:BIANCA BERRY",
        "PHONE:5029210884",
        "ID:2013-0000013420");

    doTest("T12",
        "BULLITT CO 911:INJACC>INJURY ACCIDENT 65 AT 1526 JAMES DALTON 5029392831 Cad: 2013-0000013221",
        "CALL:INJURY ACCIDENT",
        "ADDR:65 AT 1526 JAMES DALTON",  // Not finding
        "PHONE:5029392831",
        "ID:2013-0000013221");

    doTest("T13",
        "BULLITT CO 911:ALRFIR>ALARM / FIRE 199 DEAN ST XS: E BLUE LICK RD SHEPHERDSVILLE NANCY SCARBROUGH 5022779322 Map: Grids:, Cad: 2013-0000013171",
        "CALL:ALARM / FIRE",
        "ADDR:199 DEAN ST",
        "X:E BLUE LICK RD",
        "CITY:SHEPHERDSVILLE",
        "NAME:NANCY SCARBROUGH",
        "PHONE:5022779322",
        "ID:2013-0000013171");

    doTest("T14",
        "BULLITT CO 911:BRUSH >BRUSH/GRASS/MULCH/WOODS MT CARMEL CHURCH RD XS: WILSON CREEK RD LEBANON JUNCTION JASON SWIGART 5027101504 Cad: 2013-0000013098",
        "CALL:BRUSH/GRASS/MULCH/WOODS",
        "ADDR:MT CARMEL CHURCH RD",
        "MADDR:MT CARMEL CHURCH RD & WILSON CREEK RD", 
        "X:WILSON CREEK RD",
        "CITY:LEBANON JUNCTION",
        "NAME:JASON SWIGART",
        "PHONE:5027101504",
        "ID:2013-0000013098");

    doTest("T15",
        "BULLITT CO 911:INJACC>INJURY ACCIDENT HILLVIEW BLVD&E BLUE LICK RD XS: N PRESTON HWY LOUISVILLE ANDY MARSHALL 5029573521 Cad: 2013-0000013095",
        "CALL:INJURY ACCIDENT",
        "ADDR:HILLVIEW BLVD & E BLUE LICK RD",
        "X:N PRESTON HWY",
        "CITY:LOUISVILLE",
        "NAME:ANDY MARSHALL",
        "PHONE:5029573521",
        "ID:2013-0000013095");

    doTest("T16",
        "BULLITT CO 911:VEHFIR>FIRE / VEHICLE 118 I 65 S XS: HARDIN CO LINE SHEPHERDSVILLE KEN 5028350557 Cad: 2013-0000013005",
        "CALL:FIRE / VEHICLE",
        "ADDR:118 I 65 S",
        "X:HARDIN CO LINE",
        "CITY:SHEPHERDSVILLE",
        "NAME:KEN",
        "PHONE:5028350557",
        "ID:2013-0000013005");

    doTest("T17",
        "BULLITT CO 911:ALRFIR>ALARM / FIRE 716 BROOKS HILL RD XS: E BLUE LICK BROOKS EMERGENCY MONITORING 8008773624 Map: Grids:, Cad: 2013-0000012993",
        "CALL:ALARM / FIRE",
        "ADDR:716 BROOKS HILL RD",
        "X:E BLUE LICK",
        "CITY:BROOKS",
        "NAME:EMERGENCY MONITORING",
        "PHONE:8008773624",
        "ID:2013-0000012993");

    doTest("T18",
        "BULLITT CO 911:INJACC>INJURY ACCIDENT N PRESTON HWY XS: HIGHWAY 44 E SHEPHERDSVILLE LISA CHERRY 5027245501 Map: Grids:, Cad: 2013-0000012828",
        "CALL:INJURY ACCIDENT",
        "ADDR:N PRESTON HWY",
        "MADDR:N PRESTON HWY & HIGHWAY 44 E",  // Preston hwy doesn't go that far south
        "X:HIGHWAY 44 E",
        "CITY:SHEPHERDSVILLE",
        "NAME:LISA CHERRY",
        "PHONE:5027245501",
        "ID:2013-0000012828");

    doTest("T19",
        "BULLITT CO 911:UNCON >UNCONCIOUS PERSON 163 MILLWOOD CT XS: MILLERS CROSSINGS SHEPHERDSVILLE CALHOUN, MICHAEL 5025438794 Map: Grids:, Cad: 2013-0000012739",
        "CALL:UNCONCIOUS PERSON",
        "ADDR:163 MILLWOOD CT",
        "X:MILLERS CROSSINGS",
        "CITY:SHEPHERDSVILLE",
        "NAME:CALHOUN, MICHAEL",
        "PHONE:5025438794",
        "ID:2013-0000012739");

    doTest("T20",
        "BULLITT CO 911:VEHFIR>FIRE / VEHICLE 155 HILLVIEW BLVD XS: N PRESTON HWY LOUISVILLE Map: Grids:, Cad: 2013-0000012602",
        "CALL:FIRE / VEHICLE",
        "ADDR:155 HILLVIEW BLVD",
        "X:N PRESTON HWY",
        "CITY:LOUISVILLE",
        "ID:2013-0000012602");

    doTest("T21",
        "BULLITT CO 911:STRUCT>FIRE / STRUCTURE 202 E BLUEJAY RD XS: MAYFLOWER RD LOUISVILLE Map: Grids:, Cad: 2013-0000012399",
        "CALL:FIRE / STRUCTURE",
        "ADDR:202 E BLUEJAY RD",
        "X:MAYFLOWER RD",
        "CITY:LOUISVILLE",
        "ID:2013-0000012399");

    doTest("T22",
        "BULLITT CO 911:INJACC>INJURY ACCIDENT PRESTON HWY SHEPHERDSVILLE TIM NEWTON 5024173125 Cad: 2013-0000012385",
        "CALL:INJURY ACCIDENT",
        "ADDR:PRESTON HWY",
        "CITY:SHEPHERDSVILLE",
        "NAME:TIM NEWTON",
        "PHONE:5024173125",
        "ID:2013-0000012385");

    doTest("T23",
        "BULLITT CO 911:DIFBRE>DIFFICULTY BREATHING 12211 SOMERSET DR XS: SUMMERS DR LOUISVILLE PATTY HORNUNG 5029573672 Map: Grids:, Cad: 2013-0000012017",
        "CALL:DIFFICULTY BREATHING",
        "ADDR:12211 SOMERSET DR",
        "X:SUMMERS DR",
        "CITY:LOUISVILLE",
        "NAME:PATTY HORNUNG",
        "PHONE:5029573672",
        "ID:2013-0000012017");

    doTest("T24",
        "BULLITT CO 911:INJACC>INJURY ACCIDENT BROOKS HILL RD XS: E BLUE LICK BROOKS SPPCS 5022101340 Cad: 2013-0000011909",
        "CALL:INJURY ACCIDENT",
        "ADDR:BROOKS HILL RD",
        "MADDR:BROOKS HILL RD & E BLUE LICK",
        "X:E BLUE LICK",
        "CITY:BROOKS",
        "NAME:SPPCS",
        "PHONE:5022101340",
        "ID:2013-0000011909");

    doTest("T25",
        "BULLITT CO 911:NOINJ >NO INJURY ACCIDENT E BLUE LICK RD XS: 1526/JOHN HARPER HWY LOUISVILLE 5025942874 Cad: 2013-0000011883",
        "CALL:NO INJURY ACCIDENT",
        "ADDR:E BLUE LICK RD",
        "MADDR:E BLUE LICK RD & 1526",
        "X:1526 / JOHN HARPER HWY",
        "CITY:LOUISVILLE",
        "PHONE:5025942874",
        "ID:2013-0000011883");

    doTest("T26",
        "BULLITT CO 911:SHOOT >SHOOTING 210 PIKE LN XS: CHURCH ST LEBANON JUNCTION HARDIN CO 911 / KEVIN 2702340931 Map: Grids:, Cad: 2013-0000011873",
        "CALL:SHOOTING",
        "ADDR:210 PIKE LN",
        "X:CHURCH ST",
        "CITY:LEBANON JUNCTION",
        "NAME:HARDIN CO 911 / KEVIN",
        "PHONE:2702340931",
        "ID:2013-0000011873");

    doTest("T27",
        "BULLITT CO 911:VEHFIR>FIRE / VEHICLE 11400 N PRESTON HWY XS: HIGHWAY 44 E LOUISVILLE ANITA SMITH 5024091827 Cad: 2013-0000011782",
        "CALL:FIRE / VEHICLE",
        "ADDR:11400 N PRESTON HWY",
        "X:HIGHWAY 44 E",
        "CITY:LOUISVILLE",
        "NAME:ANITA SMITH",
        "PHONE:5024091827",
        "ID:2013-0000011782");

    doTest("T28",
        "BULLITT CO 911:STRUCT>FIRE / STRUCTURE 299 NELLIE WAY XS: WILDERNESS RD BROOKS VICTORIA 5023860302 Map: Grids:, Cad: 2013-0000011766",
        "CALL:FIRE / STRUCTURE",
        "ADDR:299 NELLIE WAY",
        "X:WILDERNESS RD",
        "CITY:BROOKS",
        "NAME:VICTORIA",
        "PHONE:5023860302",
        "ID:2013-0000011766");

    doTest("T29",
        "BULLITT CO 911:SICK >SICK PERSON 140 CREEKSIDE DR XS: PRYOR VALLEY RD SHEPHERDSVILLE TAMMY MEREDITH 5025310172 Map: Grids:, Cad: 2013-0000011694",
        "CALL:SICK PERSON",
        "ADDR:140 CREEKSIDE DR",
        "X:PRYOR VALLEY RD",
        "CITY:SHEPHERDSVILLE",
        "NAME:TAMMY MEREDITH",
        "PHONE:5025310172",
        "ID:2013-0000011694");

    doTest("T30",
        "BULLITT CO 911:GAS >NATURAL OR LP GAS LEAK 156 RED BIRD CT XS: MAYFLOWER RD LOUISVILLE KEITH CAULK 5026419074 Map: Grids:, Cad: 2013-0000011530",
        "CALL:NATURAL OR LP GAS LEAK",
        "ADDR:156 RED BIRD CT",
        "X:MAYFLOWER RD",
        "CITY:LOUISVILLE",
        "NAME:KEITH CAULK",
        "PHONE:5026419074",
        "ID:2013-0000011530");

    doTest("T31",
        "BULLITT CO 911:FULARR>CARDIAC ARREST 480 CRESTWOOD LN XS: S SKYLINE DR LOUISVILLE Map: Grids:, Cad: 2013-0000011263",
        "CALL:CARDIAC ARREST",
        "ADDR:480 CRESTWOOD LN",
        "X:S SKYLINE DR",
        "CITY:LOUISVILLE",
        "ID:2013-0000011263");

    doTest("T32",
        "BULLITT CO 911:DIFBRE>DIFFICULTY BREATHING 480 CRESTWOOD LN XS: S SKYLINE DR LOUISVILLE Map: Grids:, Cad: 2013-0000011263",
        "CALL:DIFFICULTY BREATHING",
        "ADDR:480 CRESTWOOD LN",
        "X:S SKYLINE DR",
        "CITY:LOUISVILLE",
        "ID:2013-0000011263");

    doTest("T33",
        "BULLITT CO 911:INJACC>INJURY ACCIDENT 121 I 65 S XS: HARDIN CO LINE SHEPHERDSVILLE CHRIS GARDNER 5022963651 Cad: 2013-0000011201",
        "CALL:INJURY ACCIDENT",
        "ADDR:121 I 65 S",
        "X:HARDIN CO LINE",
        "CITY:SHEPHERDSVILLE",
        "NAME:CHRIS GARDNER",
        "PHONE:5022963651",
        "ID:2013-0000011201");

    doTest("T34",
        "BULLITT CO 911:NOINJ >NO INJURY ACCIDENT 3315 E BLUE LICK RD XS: 1526/JOHN HARPER HWY SHEPHERDSVILLE PATRICK BAKER 5027184641 Map: Grids:, Cad: 2013-0000011197",
        "CALL:NO INJURY ACCIDENT",
        "ADDR:3315 E BLUE LICK RD",
        "X:1526 / JOHN HARPER HWY",
        "CITY:SHEPHERDSVILLE",
        "NAME:PATRICK BAKER",
        "PHONE:5027184641",
        "ID:2013-0000011197");

    doTest("T35",
        "BULLITT CO 911:VEHFIR>FIRE / VEHICLE 120 I 65 S XS: HARDIN CO LINE SHEPHERDSVILLE FRANKIE 5027412144 Map: Grids:, Cad: 2013-0000011187",
        "CALL:FIRE / VEHICLE",
        "ADDR:120 I 65 S",
        "X:HARDIN CO LINE",
        "CITY:SHEPHERDSVILLE",
        "NAME:FRANKIE",
        "PHONE:5027412144",
        "ID:2013-0000011187");

    doTest("T36",
        "BULLITT CO 911:FIRE >FIRE DEPARTMENT CALL 315 BARRICKS RD Apt: 265 Bldg XS: BEECH DR @ WHISPERING OAKS MHP LOUISVILLE BECKY 5023037982 Map: Grids:, Cad: 2013-0000011182",
        "CALL:FIRE DEPARTMENT CALL",
        "ADDR:315 BARRICKS RD",
        "APT:265 Bldg",
        "X:BEECH DR & WHISPERING OAKS MHP",
        "CITY:LOUISVILLE",
        "NAME:BECKY",
        "PHONE:5023037982",
        "ID:2013-0000011182");

    doTest("T37",
        "BULLITT CO 911:FIRE >FIRE DEPARTMENT CALL 1210 BELLS MILL RD XS: N PRESTON HWY SHEPHERDSVILLE GOLLAR,SANDY 5029573423 Map: Grids:, Cad: 2013-0000011181",
        "CALL:FIRE DEPARTMENT CALL",
        "ADDR:1210 BELLS MILL RD",
        "X:N PRESTON HWY",
        "CITY:SHEPHERDSVILLE",
        "NAME:GOLLAR,SANDY",
        "PHONE:5029573423",
        "ID:2013-0000011181");

    doTest("T38",
        "BULLITT CO 911:EMS >EMS CALL 304 WILMA AVE XS: N PRESTON HWY LOUISVILLE DEBBIE 5025519905 Map: Grids:, Cad: 2013-0000011173",
        "CALL:EMS CALL",
        "ADDR:304 WILMA AVE",
        "X:N PRESTON HWY",
        "CITY:LOUISVILLE",
        "NAME:DEBBIE",
        "PHONE:5025519905",
        "ID:2013-0000011173");

    doTest("T39",
        "BULLITT CO 911:FIRE >FIRE DEPARTMENT CALL 391 BARRICKS RD XS: BEECH DR @ WHISPERING OAKS MHP LOUISVILLE MONTE FURMAN Map: Grids:, Cad: 2013-0000011137",
        "CALL:FIRE DEPARTMENT CALL",
        "ADDR:391 BARRICKS RD",
        "X:BEECH DR & WHISPERING OAKS MHP",
        "CITY:LOUISVILLE",
        "NAME:MONTE FURMAN",
        "ID:2013-0000011137");

    doTest("T40",
        "BULLITT CO 911:FIRE >FIRE DEPARTMENT CALL 265 BARRICKS RD XS: BEECH DR @ WHISPERING OAKS MHP LOUISVILLE MONTE FURMAN Map: Grids:, Cad: 2013-0000011137",
        "CALL:FIRE DEPARTMENT CALL",
        "ADDR:265 BARRICKS RD",
        "X:BEECH DR & WHISPERING OAKS MHP",
        "CITY:LOUISVILLE",
        "NAME:MONTE FURMAN",
        "ID:2013-0000011137");

    doTest("T41",
        "BULLITT CO 911:WATER >WATER RESCUE 150 N TRIANGLE LN Apt: 108 Bldg XS: E BLUE LICK RD LOUISVILLE ALERT 1 5029576256 Map: Grids:, Cad: 2013-0000011126",
        "CALL:WATER RESCUE",
        "ADDR:150 N TRIANGLE LN",
        "APT:108 Bldg",
        "X:E BLUE LICK RD",
        "CITY:LOUISVILLE",
        "NAME:ALERT 1",
        "PHONE:5029576256",
        "ID:2013-0000011126");

    doTest("T42",
        "BULLITT CO 911:TEST >TEST 5328 N PRESTON HWY XS: HIGHWAY 44 E SHEPHERDSVILLE Map: Grids:, Cad: 2013-0000011052",
        "CALL:TEST",
        "ADDR:5328 N PRESTON HWY",
        "X:HIGHWAY 44 E",
        "CITY:SHEPHERDSVILLE",
        "ID:2013-0000011052");
  
  }
  
  public static void main(String[] args) {
    new KYBullittCountyParserTest().generateTests("T1");
  }
}
