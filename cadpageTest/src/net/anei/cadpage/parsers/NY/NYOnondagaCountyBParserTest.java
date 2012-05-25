package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NYOnondagaCountyBParserTest extends BaseParserTest {
  
  public NYOnondagaCountyBParserTest() {
    setParser(new NYOnondagaCountyBParser(), "ONONDAGA COUNTY", "NY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Subject:7651 MORGAN RD\n" +
        "05/18/12\n" +
        "11:18\n" +
        "MOF123900539\n" +
        "TCL\n" +
        "F-GENERAL ILLNESS\n" +
        "7651 MORGAN RD\n" +
        "PICCADILLY SQ AND BUCKLEY RD\n" +
        "BUCKLEY PARK APTS-APT I -7\n" +
        "DEMO,SEAN\n" +
        "SPECIAL ADDRESS COMMENT:\n" +
        "ACCESS INFORMATION:\n" +
        "USE MORGAN RD DRIVEWAY FOR BLDGS A - E\n" +
        "USE BUCKLEY RD DRIVEWAY FOR BLDGS F - K\n" +
        "_______________________________________________\n" +
        "[e9kduc 04/01/2012]\n" +
        "PAIN IN BOTH ARMS\n" +
        "Number of patients: 1\n" +
        "Responder script: 39 year old, Female, Conscious, Breathing. Sick Person\n" +
        "(Specific Diagnosis). Caller Statement: PAIN IN BOTH ARMS .\n" +
        "PAIN IN BOTH ARMS\n" +
        "Response text: Alpha\n" +
        "Responder script: General weakness.\n" +
        "ARMS FEELS VERY HEAVY - PAIN BETWEEN SHOULDER BLADES -\n" +
        "NO OTHER MED HX\n" +
        "POI COUNTY CH5\n" +
        "NEED RESCUE P3 FOR LIFTING\n\n\n\n" +
        "MOF",

        "DATE:05/18/12",
        "TIME:11:18",
        "ID:MOF123900539",
        "CALL:F-GENERAL ILLNESS",
        "ADDR:7651 MORGAN RD",
        "APT:APT I -7",
        "X:PICCADILLY SQ AND BUCKLEY RD",
        "PLACE:BUCKLEY PARK APTS",
        "NAME:DEMO,SEAN",
        "INFO:USE MORGAN RD DRIVEWAY FOR BLDGS A - E / USE BUCKLEY RD DRIVEWAY FOR BLDGS F - K / PAIN IN BOTH ARMS / #PAT: 1 / 39 year old, Female, Conscious, Breathing. Sick Person / PAIN IN BOTH ARMS . / PAIN IN BOTH ARMS / General weakness. / ARMS FEELS VERY HEAVY - PAIN BETWEEN SHOULDER BLADES - / NO OTHER MED HX / POI COUNTY CH5 / NEED RESCUE P3 FOR LIFTING",
        "PRI:A",
        "SRC:MOF");

    doTest("T2",
        "Subject:7245 HENRY CLAY BLVD\n" +
        "05/17/12\n" +
        "10:39\n" +
        "MOF123900538\n" +
        "TCL\n" +
        "F-ALARM-Fire\n" +
        "7245 HENRY CLAY BLVD\n" +
        "W TAFT RD AND CROSSROADS PARK DR\n" +
        "RITE AID DISTRIBUTION-\n\n" +
        "T/V FIRE ALARM - OLD WAREHOUSE FIRE ALARM INDICATED - ADT - #IKA, 8772387739\n" +
        "ANY UNIT FOR\n\n\n" +
        "BC2,E11,E21,E31,E32,E41,LD1,TK2,\n" +
        "MOF",

        "DATE:05/17/12",
        "TIME:10:39",
        "ID:MOF123900538",
        "CALL:F-ALARM-Fire",
        "ADDR:7245 HENRY CLAY BLVD",
        "X:W TAFT RD AND CROSSROADS PARK DR",
        "PLACE:RITE AID DISTRIBUTION",
        "INFO:T/V FIRE ALARM - OLD WAREHOUSE FIRE ALARM INDICATED - ADT - #IKA, 8772387739 / ANY UNIT FOR",
        "UNIT:BC2,E11,E21,E31,E32,E41,LD1,TK2",
        "SRC:MOF");

    doTest("T3",
        "Subject:7651 MORGAN RD\n" +
        "05/17/12\n" +
        "08:23\n" +
        "MOF123900535\n" +
        "TCL\n" +
        "F-PAIN (NON-TRAUMATIC)\n" +
        "7651 MORGAN RD\n" +
        "PICCADILLY SQ AND BUCKLEY RD\n" +
        "BUCKLEY PARK APTS-BLDG D, APT\n" +
        "CORREIRA,MICHAE\n" +
        "SPECIAL ADDRESS COMMENT:\n" +
        "ACCESS INFORMATION:\n" +
        "USE MORGAN RD DRIVEWAY FOR BLDGS A - E\n" +
        "USE BUCKLEY RD DRIVEWAY FOR BLDGS F - K\n" +
        "_______________________________________________\n" +
        "[e9kduc 04/01/2012]\n" +
        "M911 CC RE:\n" +
        "BELLY BUTTON PAIN\n" +
        "Number of patients: 1\n" +
        "Responder script: 45 year old, Male, Conscious, Breathing. Abdominal Pain\n" +
        "Problems. Caller Statement: BELLY BUTTON PAIN.\n" +
        "Response text: Charlie\n" +
        "Responder script: Males with pain above navel => 35.\n" +
        "Reconfigured on another card: No\n" +
        "POI\n\n\n" +
        "SD2,SD3,\n" +
        "MOF",

        "DATE:05/17/12",
        "TIME:08:23",
        "ID:MOF123900535",
        "CALL:F-PAIN (NON-TRAUMATIC)",
        "ADDR:7651 MORGAN RD",
        "APT:BLDG D, APT",
        "X:PICCADILLY SQ AND BUCKLEY RD",
        "PLACE:BUCKLEY PARK APTS",
        "NAME:CORREIRA,MICHAE",
        "INFO:USE MORGAN RD DRIVEWAY FOR BLDGS A - E / USE BUCKLEY RD DRIVEWAY FOR BLDGS F - K / M911 CC RE: / BELLY BUTTON PAIN / #PAT: 1 / 45 year old, Male, Conscious, Breathing. Abdominal Pain / Problems. BELLY BUTTON PAIN. / Males with pain above navel => 35. / POI",
        "PRI:C",
        "UNIT:SD2,SD3",
        "SRC:MOF");

    doTest("T4",
        "Subject:4227 WETZEL RD\n" +
        "05/17/12\n" +
        "07:51\n" +
        "MOF123900534\n" +
        "TCL\n" +
        "F-WIRE(S) DOWN-Emergency\n" +
        "4227 WETZEL RD\n" +
        "AURORA PATH AND LIVERPOOL CAMPUS DRWY\n" +
        "-\n\n" +
        "M911/ WIRE HANGING LOW OVER WETZEL, NOT ARCING\n" +
        "LIVERPOOL SCHOOLS CALLED, THESE ARE ELECTRICAL AND PHONE WIRES- ONE OF THEIR\n" +
        "MOWERS HIT THE GUIDE WIRE TO THE POLE- WIRES ARE NOW APPRX 11 FEET OFF THE\n" +
        "ROADWAY\n\n\n" +
        "E21,\n" +
        "MOF",

        "DATE:05/17/12",
        "TIME:07:51",
        "ID:MOF123900534",
        "CALL:F-WIRE(S) DOWN-Emergency",
        "ADDR:4227 WETZEL RD",
        "X:AURORA PATH AND LIVERPOOL CAMPUS DRWY",
        "INFO:M911/ WIRE HANGING LOW OVER WETZEL, NOT ARCING / LIVERPOOL SCHOOLS CALLED, THESE ARE ELECTRICAL AND PHONE WIRES- ONE OF THEIR / MOWERS HIT THE GUIDE WIRE TO THE POLE- WIRES ARE NOW APPRX 11 FEET OFF THE / ROADWAY",
        "UNIT:E21",
        "SRC:MOF");

    doTest("T5",
        "Subject:BEAR RD AND MUENCH RD\n" +
        "05/19/12\n" +
        "21:34\n" +
        "MOF123900546\n" +
        "TCL\n" +
        "F-MOTOR VEHICLE COLLISION-INJU\n" +
        "BEAR RD AND MUENCH RD\n" +
        "BEAR RD AND MUENCH RD\n" +
        "-\n" +
        "ELDRED, GARY\n" +
        "TWCBL ELDRED, GARY VOIP 05/19 21:33:30\n" +
        "911- VEH VS MC\n" +
        "MC DRIVER LAYING ON THE GROUND\n" +
        "PATROL_CO_PARK_PRIMARY_BEAT or 1 PATROL_CO_PARK_BACKUP_BEAT or 1\n" +
        "PATROL_ST_PARK_PRIMARY_BEAT or 1 PATROL_ST_PARK_BACKUP_BEAT); (1\n" +
        "PATROL_VILLAGE_PRIMARY_BEAT or 1 PATROL_VILLAGE_BACKUP_BEAT or 1 PATROL_SUPV_\n" +
        "VILLAGE_PRIMARY_BEAT or 1 PATROL_SUPV_ VILLAGE_BACKUP_BEAT); (1 PATROL_UPSTATE)\n\n\n\n" +
        "MOF",

        "DATE:05/19/12",
        "TIME:21:34",
        "ID:MOF123900546",
        "CALL:F-MOTOR VEHICLE COLLISION-INJU",
        "ADDR:BEAR RD AND MUENCH RD",
        "X:BEAR RD AND MUENCH RD",
        "NAME:ELDRED, GARY",
        "INFO:TWCBL ELDRED, GARY VOIP / 911- VEH VS MC / MC DRIVER LAYING ON THE GROUND",
        "SRC:MOF");

    doTest("T6",
        "Subject:313 LONG BRANCH CIR\n" +
        "05/19/12\n" +
        "20:23\n" +
        "MOF123900544\n" +
        "TSL\n" +
        "F-FIRE-RESIDENTIAL\n" +
        "313 LONG BRANCH CIR\n" +
        "LONG BRANCH RD AND LONG BRANCH RD\n" +
        "-\n\n" +
        "8X8 SHED\n" +
        "PATROL_CO_PARK_PRIMARY_BEAT or 1 PATROL_CO_PARK_BACKUP_BEAT or 1\n" +
        "PATROL_ST_PARK_PRIMARY_BEAT or 1 PATROL_ST_PARK_BACKUP_BEAT); (1\n" +
        "PATROL_VILLAGE_PRIMARY_BEAT or 1 PATROL_VILLAGE_BACKUP_BEAT or 1 PATROL_SUPV_\n" +
        "VILLAGE_PRIMARY_BEAT or 1 PATROL_SUPV_ VILLAGE_BACKUP_BEAT); (1 PATROL_UPSTATE)\n" +
        "2-3 FEET FROM FENCH\n\n" +
        "CFCTAC3\n\n" +
        "BVF LVF MOF GNF",

        "DATE:05/19/12",
        "TIME:20:23",
        "ID:MOF123900544",
        "CALL:F-FIRE-RESIDENTIAL",
        "ADDR:313 LONG BRANCH CIR",
        "X:LONG BRANCH RD AND LONG BRANCH RD",
        "INFO:8X8 SHED / 2-3 FEET FROM FENCH",
        "CH:CFCTAC3",
        "SRC:BVF LVF MOF GNF");

    doTest("T7",
        "Subject:7455 MORGAN RD\n" +
        "05/18/12\n" +
        "19:18\n" +
        "MOF123900540\n" +
        "TCL\n" +
        "F-MOTOR VEHICLE COLLISION-INJU\n" +
        "7455 MORGAN RD\n" +
        "AVON PKWY AND STEELWAY BLVD N\n" +
        "GOLDS GYM-\n" +
        "DYER, SARAH\n" +
        "N SECTOR -076.205828 043.128676 05/18 18:39:16\n" +
        "M911 - CC - 3 VEHICLES // 95 HONDA CIVIC BLU VS WHI TOYT PK-UP VS SILVER DODGE\n" +
        "STRATUS\n" +
        "Duplicate Event:Location = 7455 MORGAN RD TCL: @GOLDS GYM, Cross Street 1 = AVON\n" +
        "PKWY STEELWAY BLVD N, Cross Street 2 = STEELWAY BLVD N, Type = MVC - MOTOR\n" +
        "VEHICLE COLLISION, Subtype = DB - DAMAGE ONLY - J/O, Caller Name = CLOUSE,JACOB,\n" +
        "Caller Ph Number = (315) 439-3844, Call Source = 9-911, Alarm Level = 0Location\n" +
        "InfoIFO\n" +
        "-076.205935 043.128644\n" +
        "M911 CC IN A WHI TUNDRA TRUCK VS BLU HONDA VS SILV FORD\n" +
        "End of Duplicate Event data\n" +
        "AU\n" +
        "05/18/12 18:43:38\n" +
        "MORGAN RD TCL\" to \"7455 MORGAN RD TCL: @GOLDS GYM\" at: 05/18/12 18:44:39\n" +
        "ANOTHER CALLER REPORTING THE SAME--VEHS ARE STILL IN THE ROADWAY-GREG CAMERON-NO\n" +
        "CC 412-8039\n" +
        "CB FROM COMP - STATES TROOPER IS OS - AND THE TROOPER REQ TO START AN AMBU FOR\n" +
        "CALLER AND HER 1 WEEK OLD MALE\n" +
        "CALLER - 28YOF - CONC - BREATHING - BACK PAIN\n" +
        "CHILD - 1YOM - CONC - BREATHING - POSS WHIPLASH - IS ALERT\n\n\n" +
        "BC2,E22,R3,\n" +
        "MOF",

        "DATE:05/18/12",
        "TIME:19:18",
        "ID:MOF123900540",
        "CALL:F-MOTOR VEHICLE COLLISION-INJU",
        "ADDR:7455 MORGAN RD",
        "X:AVON PKWY AND STEELWAY BLVD N",
        "PLACE:GOLDS GYM",
        "NAME:DYER, SARAH",
        "INFO:N SECTOR -076.205828 043.128676 / M911 - CC - 3 VEHICLES // 95 HONDA CIVIC BLU VS WHI TOYT PK-UP VS SILVER DODGE / STRATUS / AU / MORGAN RD TCL\" to \"7455 MORGAN RD TCL: @GOLDS GYM\" at: / ANOTHER CALLER REPORTING THE SAME--VEHS ARE STILL IN THE ROADWAY-GREG CAMERON-NO / CC 412-8039 / CB FROM COMP - STATES TROOPER IS OS - AND THE TROOPER REQ TO START AN AMBU FOR / CALLER AND HER 1 WEEK OLD MALE / CALLER - 28YOF - CONC - BREATHING - BACK PAIN / CHILD - 1YOM - CONC - BREATHING - POSS WHIPLASH - IS ALERT",
        "UNIT:BC2,E22,R3",
        "SRC:MOF");

    doTest("T8",
        "Subject:4979 W TAFT RD\n" +
        "05/21/12\n" +
        "07:24\n" +
        "MOF123900549\n" +
        "TCL\n" +
        "F-ALARM-Fire\n" +
        "4979 W TAFT RD\n" +
        "CARRIAGE PKWY AND WINTERSWEET DR\n" +
        "WEGMANS-\n\n" +
        "COUNTY FIRE/ SMOKE DETECTOR ACTIVATION 585-429-3030 OPER 78\n" +
        "CALLED IN BY WEGMANS SECURITY- THEY ARE TRYING TO GET MORE INFO FROM THE STORE\n\n\n" +
        "BC2,E11,E31,E32,E41,TK2,\n" +
        "MOF",

        "DATE:05/21/12",
        "TIME:07:24",
        "ID:MOF123900549",
        "CALL:F-ALARM-Fire",
        "ADDR:4979 W TAFT RD",
        "X:CARRIAGE PKWY AND WINTERSWEET DR",
        "PLACE:WEGMANS",
        "INFO:COUNTY FIRE/ SMOKE DETECTOR ACTIVATION 585-429-3030 OPER 78 / CALLED IN BY WEGMANS SECURITY- THEY ARE TRYING TO GET MORE INFO FROM THE STORE",
        "UNIT:BC2,E11,E31,E32,E41,TK2",
        "SRC:MOF");

    doTest("T9",
        "Subject:29 CANDLELIGHT CIR\n" +
        "05/20/12\n" +
        "09:22\n" +
        "MOF123900547\n" +
        "TCL\n" +
        "F-UNCONSCIOUS PERSON\n" +
        "29 CANDLELIGHT CIR\n" +
        "CANDLELIGHT LN\n" +
        "-29 B\n" +
        "MORGAN,DEIONDRE\n" +
        "FLR 1 APT B WILLIAMS SHONTRAVIA RESD 05/20 09:11:24\n" +
        "12YO SAYS HER MOM,JUST HAD SEIZURE\n" +
        "Number of patients: 1\n" +
        "Responder script: 12 year old, Female, Unconscious, Breathing. Convulsions /\n" +
        "Seizures. Caller Statement: 12YO SAYS HER MOM,JUST HAD SEIZURE.\n" +
        "Dispatch level suffix: E\n" +
        "Response text: Bravo\n" +
        "Responder script: Effective breathing not verified < 35 (Epileptic or Previous\n" +
        "history of seizures).\n" +
        "CORRECTION, CALLER IS 12. HER MOM, THE PT IS 30YOA\n" +
        "POI\n" +
        "ANY UNIT FOR\n" +
        "CALLER CANNOT DETECT BREATHING,  and  MOM WONT WAKE UP\n" +
        "ATTEMPTING PAI'S, HER MOM HAS PINK STUFF IN HER NOSE\n\n\n\n" +
        "MOF",

        "DATE:05/20/12",
        "TIME:09:22",
        "ID:MOF123900547",
        "CALL:F-UNCONSCIOUS PERSON",
        "ADDR:29 CANDLELIGHT CIR",
        "APT:29 B",
        "X:CANDLELIGHT LN",
        "NAME:MORGAN,DEIONDRE",
        "INFO:FLR 1 APT B WILLIAMS SHONTRAVIA RESD / 12YO SAYS HER MOM,JUST HAD SEIZURE / #PAT: 1 / 12 year old, Female, Unconscious, Breathing. Convulsions / / Seizures. 12YO SAYS HER MOM,JUST HAD SEIZURE. / Dispatch level suffix: E / Effective breathing not verified < 35 (Epileptic or Previous / history of seizures). / CORRECTION, CALLER IS 12. HER MOM, THE PT IS 30YOA / POI / ANY UNIT FOR / CALLER CANNOT DETECT BREATHING, and MOM WONT WAKE UP / ATTEMPTING PAI'S, HER MOM HAS PINK STUFF IN HER NOSE",
        "PRI:B",
        "SRC:MOF");

    doTest("T10",
        "Subject:BEAR RD AND MUENCH RD\n" +
        "05/19/12\n" +
        "21:34\n" +
        "MOF123900546\n" +
        "TCL\n" +
        "F-MOTOR VEHICLE COLLISION-INJU\n" +
        "BEAR RD AND MUENCH RD\n" +
        "BEAR RD AND MUENCH RD\n" +
        "-\n" +
        "ELDRED, GARY\n" +
        "TWCBL ELDRED, GARY VOIP 05/19 21:33:30\n" +
        "911- VEH VS MC\n" +
        "MC DRIVER LAYING ON THE GROUND\n" +
        "PATROL_CO_PARK_PRIMARY_BEAT or 1 PATROL_CO_PARK_BACKUP_BEAT or 1\n" +
        "PATROL_ST_PARK_PRIMARY_BEAT or 1 PATROL_ST_PARK_BACKUP_BEAT); (1\n" +
        "PATROL_VILLAGE_PRIMARY_BEAT or 1 PATROL_VILLAGE_BACKUP_BEAT or 1 PATROL_SUPV_\n" +
        "VILLAGE_PRIMARY_BEAT or 1 PATROL_SUPV_ VILLAGE_BACKUP_BEAT); (1 PATROL_UPSTATE)\n\n\n\n" +
        "MOF",

        "DATE:05/19/12",
        "TIME:21:34",
        "ID:MOF123900546",
        "CALL:F-MOTOR VEHICLE COLLISION-INJU",
        "ADDR:BEAR RD AND MUENCH RD",
        "X:BEAR RD AND MUENCH RD",
        "NAME:ELDRED, GARY",
        "INFO:TWCBL ELDRED, GARY VOIP / 911- VEH VS MC / MC DRIVER LAYING ON THE GROUND",
        "SRC:MOF");

    doTest("T11",
        "Subject:313 LONG BRANCH CIR\n" +
        "05/19/12\n" +
        "20:23\n" +
        "MOF123900544\n" +
        "TSL\n" +
        "F-FIRE-RESIDENTIAL\n" +
        "313 LONG BRANCH CIR\n" +
        "LONG BRANCH RD AND LONG BRANCH RD\n" +
        "-\n\n" +
        "8X8 SHED\n" +
        "PATROL_CO_PARK_PRIMARY_BEAT or 1 PATROL_CO_PARK_BACKUP_BEAT or 1\n" +
        "PATROL_ST_PARK_PRIMARY_BEAT or 1 PATROL_ST_PARK_BACKUP_BEAT); (1\n" +
        "PATROL_VILLAGE_PRIMARY_BEAT or 1 PATROL_VILLAGE_BACKUP_BEAT or 1 PATROL_SUPV_\n" +
        "VILLAGE_PRIMARY_BEAT or 1 PATROL_SUPV_ VILLAGE_BACKUP_BEAT); (1 PATROL_UPSTATE)\n" +
        "2-3 FEET FROM FENCH\n\n" +
        "CFCTAC3\n\n" +
        "BVF LVF MOF GNF",

        "DATE:05/19/12",
        "TIME:20:23",
        "ID:MOF123900544",
        "CALL:F-FIRE-RESIDENTIAL",
        "ADDR:313 LONG BRANCH CIR",
        "X:LONG BRANCH RD AND LONG BRANCH RD",
        "INFO:8X8 SHED / 2-3 FEET FROM FENCH",
        "CH:CFCTAC3",
        "SRC:BVF LVF MOF GNF");

    doTest("T12",
        "Subject:7455 MORGAN RD\n" +
        "05/18/12\n" +
        "19:18\n" +
        "MOF123900540\n" +
        "TCL\n" +
        "F-MOTOR VEHICLE COLLISION-INJU\n" +
        "7455 MORGAN RD\n" +
        "AVON PKWY AND STEELWAY BLVD N\n" +
        "GOLDS GYM-\n" +
        "DYER, SARAH\n" +
        "N SECTOR -076.205828 043.128676 05/18 18:39:16\n" +
        "M911 - CC - 3 VEHICLES // 95 HONDA CIVIC BLU VS WHI TOYT PK-UP VS SILVER DODGE\n" +
        "STRATUS\n" +
        "Duplicate Event:Location = 7455 MORGAN RD TCL: @GOLDS GYM, Cross Street 1 = AVON\n" +
        "PKWY STEELWAY BLVD N, Cross Street 2 = STEELWAY BLVD N, Type = MVC - MOTOR\n" +
        "VEHICLE COLLISION, Subtype = DB - DAMAGE ONLY - J/O, Caller Name = CLOUSE,JACOB,\n" +
        "Caller Ph Number = (315) 439-3844, Call Source = 9-911, Alarm Level = 0Location\n" +
        "InfoIFO\n" +
        "-076.205935 043.128644\n" +
        "M911 CC IN A WHI TUNDRA TRUCK VS BLU HONDA VS SILV FORD\n" +
        "End of Duplicate Event data\n" +
        "AU\n" +
        "05/18/12 18:43:38\n" +
        "MORGAN RD TCL\" to \"7455 MORGAN RD TCL: @GOLDS GYM\" at: 05/18/12 18:44:39\n" +
        "ANOTHER CALLER REPORTING THE SAME--VEHS ARE STILL IN THE ROADWAY-GREG CAMERON-NO\n" +
        "CC 412-8039\n" +
        "CB FROM COMP - STATES TROOPER IS OS - AND THE TROOPER REQ TO START AN AMBU FOR\n" +
        "CALLER AND HER 1 WEEK OLD MALE\n" +
        "CALLER - 28YOF - CONC - BREATHING - BACK PAIN\n" +
        "CHILD - 1YOM - CONC - BREATHING - POSS WHIPLASH - IS ALERT\n\n\n" +
        "BC2,E22,R3,\n" +
        "MOF",

        "DATE:05/18/12",
        "TIME:19:18",
        "ID:MOF123900540",
        "CALL:F-MOTOR VEHICLE COLLISION-INJU",
        "ADDR:7455 MORGAN RD",
        "X:AVON PKWY AND STEELWAY BLVD N",
        "PLACE:GOLDS GYM",
        "NAME:DYER, SARAH",
        "INFO:N SECTOR -076.205828 043.128676 / M911 - CC - 3 VEHICLES // 95 HONDA CIVIC BLU VS WHI TOYT PK-UP VS SILVER DODGE / STRATUS / AU / MORGAN RD TCL\" to \"7455 MORGAN RD TCL: @GOLDS GYM\" at: / ANOTHER CALLER REPORTING THE SAME--VEHS ARE STILL IN THE ROADWAY-GREG CAMERON-NO / CC 412-8039 / CB FROM COMP - STATES TROOPER IS OS - AND THE TROOPER REQ TO START AN AMBU FOR / CALLER AND HER 1 WEEK OLD MALE / CALLER - 28YOF - CONC - BREATHING - BACK PAIN / CHILD - 1YOM - CONC - BREATHING - POSS WHIPLASH - IS ALERT",
        "UNIT:BC2,E22,R3",
        "SRC:MOF");

    doTest("T13",
        "Subject:7595 ASTER DR\n" +
        "05/22/12\n" +
        "19:05\n" +
        "MOF123900554\n" +
        "TCL\n" +
        "F-DIFFICULTY BREATHING\n" +
        "7595 ASTER DR\n" +
        "DAHLIA CIR AND IRIS LN\n" +
        "-\n" +
        "LANSETTE,DEAN\n" +
        "LANCETTE-FIC, LYNETTE RESD 05/22 18:51:02\n" +
        "911 CC DEAN -\n" +
        "DIFB\n" +
        "Number of patients: 1\n" +
        "Responder script: 65 year old, Male, Conscious, Breathing. Breathing Problems.\n" +
        "Caller Statement: DIFB.\n" +
        "Response text: Delta\n" +
        "Responder script: DIFFICULTY SPEAKING BETWEEN BREATHS.\n" +
        "POI\n" +
        "Reconfigured on another card: No\n" +
        "89A1 -- STAT ALL SET -- REQ RESCUE FOR LIFT ASST\n" +
        "NEED RESCUE FOR LIFTING\n\n\n\n" +
        "MOF",

        "DATE:05/22/12",
        "TIME:19:05",
        "ID:MOF123900554",
        "CALL:F-DIFFICULTY BREATHING",
        "ADDR:7595 ASTER DR",
        "X:DAHLIA CIR AND IRIS LN",
        "NAME:LANSETTE,DEAN",
        "INFO:LANCETTE-FIC, LYNETTE RESD / 911 CC DEAN - / DIFB / #PAT: 1 / 65 year old, Male, Conscious, Breathing. Breathing Problems. / DIFB. / DIFFICULTY SPEAKING BETWEEN BREATHS. / POI / 89A1 -- STAT ALL SET -- REQ RESCUE FOR LIFT ASST / NEED RESCUE FOR LIFTING",
        "PRI:D",
        "SRC:MOF");
    
  }
  
  public static void main(String[] args) {
    new NYOnondagaCountyBParserTest().generateTests("T1");
  }
}
