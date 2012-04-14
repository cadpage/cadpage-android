package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.PA.PABerksCountyParser;

import org.junit.Test;


public class PABerksCountyParserTest extends BaseParserTest {
  
  public PABerksCountyParserTest() {
    setParser(new PABerksCountyParser(), "BERKS COUNTY", "PA");
  }
  
  @Test
  public void testParser() {
    doTest("T1",
        "CAD MSG: *D MVAUNK   E STATE ST / S KEMP ST 0082 2 VEH / COMP IS ANDREW BROOKS / INVOLVED // AT THE INTERSECTION B",
        "CALL:MVAUNK - Accident unknown inj",
        "ADDR:E STATE ST & S KEMP ST",
        "CITY:LYONS",
        "INFO:2 VEH / COMP IS ANDREW BROOKS / INVOLVED / AT THE INTERSECTION B");

    doTest("T2",
        "CAD MSG: *D MVAWITH  102 BEAVER CREEK RD 0087 1 VEH / SPUN OUT / MALE OCC (COMP'S HUSBAND) BELIEVES HE FRACTURED H",
        "CALL:MVAWITH - Accident w/ injury",
        "ADDR:102 BEAVER CREEK RD",
        "CITY:ROCKLAND TWP",
        "INFO:1 VEH / SPUN OUT / MALE OCC (COMP'S HUSBAND) BELIEVES HE FRACTURED H");
    
    doTest("T3",
        "CAD MSG: *D FTEST    STATION 35 @110 PARK AV 0082 BERKS TESING THE TEXT PAGING SYSTEM NO ACTION REQUIRED",
        "CALL:FTEST",
        "PLACE:STATION 35",
        "ADDR:110 PARK AV",
        "MADDR:110 PARK AVE",
        "CITY:LYONS",
        "INFO:BERKS TESING THE TEXT PAGING SYSTEM NO ACTION REQUIRED");
    
    doTest("T4",
        "CAD MSG: *D MVAUNK   NOBLE ST / BASTIAN RD 0079 ONE CAR, OCCUPIED, INTO A FIELD // ONLY LANDMARK SHE COULD MEN",
        "CALL:MVAUNK - Accident unknown inj",
        "ADDR:NOBLE ST & BASTIAN RD",
        "CITY:MAXATAWNY TWP",
        "INFO:ONE CAR, OCCUPIED, INTO A FIELD / ONLY LANDMARK SHE COULD MEN");
    
    doTest("T5",
        "CAD MSG: *D SF       28 NOBLE ST 0081 SEES FLAMES IN BASEMENT //ADVISED TO EVAC /",
        "CALL:SF - Structure Fire",
        "ADDR:28 NOBLE ST",
        "CITY:KUTZTOWN",
        "INFO:SEES FLAMES IN BASEMENT /ADVISED TO EVAC /");
    
    doTest("T6",
        "CAD MSG: *D MVAENT   FORGEDALE RD / DAVIDS DR 0087 2VEHS HEAD ON/2 VICTIMS ENTRAPPED /1 FEMALE SERIOUSLY INJ/BLEED",
        "CALL:MVAENT - Accident w/ entrapment",
        "ADDR:FORGEDALE RD & DAVIDS DR",
        "CITY:ROCKLAND TWP",
        "INFO:2VEHS HEAD ON/2 VICTIMS ENTRAPPED /1 FEMALE SERIOUSLY INJ/BLEED");
    
    doTest("T7",
        "Subject:1/2\nCAD MSG: *D FTELE    STATION 35 @110 PARK AV 0082 CALL REF ITEMS SHE HAS THAT ARE BELEIVED TO BELONG TO YOUR COMPA",
        "CALL:FTELE",
        "PLACE:STATION 35",
        "ADDR:110 PARK AV",
        "MADDR:110 PARK AVE",
        "CITY:LYONS",
        "INFO:CALL REF ITEMS SHE HAS THAT ARE BELEIVED TO BELONG TO YOUR COMPA");

    doTest("T8",
        "CAD MSG: *D ALSMED   106 MAIN ST 0063 56 YOF THROAT FEELS LIKE IS SWELLING CLOSED /BREAKING OUT IN RASH/RESP",
        "CALL:ALSMED",
        "ADDR:106 MAIN ST",
        "CITY:STRAUSSTOWN",
        "INFO:56 YOF THROAT FEELS LIKE IS SWELLING CLOSED /BREAKING OUT IN RASH/RESP");

    doTest("T9",
        "CAD MSG: *D MVAWITH  I78 / MP 39.6 EB 0078 MC DRIVER DOWN IN THE ROADWAY / NOT MOVING / 2 TT PULLED OFF TO THE SI",
        "CALL:MVAWITH - Accident w/ injury",
        "ADDR:I78 & MP 39.6 EB",
        "MADDR:I 78 & MP 39.6",
        "CITY:GREENWICH TWP",
        "INFO:MC DRIVER DOWN IN THE ROADWAY / NOT MOVING / 2 TT PULLED OFF TO THE SI");

    doTest("T10",
        "CAD MSG: *D BLSTRAUM 101 DOE MOUNTAIN LN @BEAR CREEK SKI AREA 0086   14YOM/BROKEN LEFT WRIST/CON AND ALERT/PT WILL BE IN THE SKI PATROLE RO",
        "CALL:BLSTRAUM",
        "ADDR:101 DOE MOUNTAIN LN",
        "PLACE:BEAR CREEK SKI AREA",
        "CITY:LONGSWAMP TWP",
        "INFO:14YOM/BROKEN LEFT WRIST/CON AND ALERT/PT WILL BE IN THE SKI PATROLE RO");

    doTest("T11",
        "FRM: \nMSG:CAD MSG: *D SF       65B MEADOW GLEN LN 0034 HEAVY SMOKE, GETTING WORSE; POSSIBLY COMING FROM DOWNSTAIRS APT; HUNGU",
        "CALL:SF - Structure Fire",
        "ADDR:65B MEADOW GLEN LN",
        "CITY:CUMRU TWP",
        "INFO:HEAVY SMOKE, GETTING WORSE; POSSIBLY COMING FROM DOWNSTAIRS APT; HUNGU");

    doTest("T12",
        "CAD MSG: *D SF       DIRECTLINK @2561 BERNVILLE RD 0054 PENSKI ENTERANCE / BUILDING 1 TRANSFORMER ROOM / SMOKE IN THE BUILDING",
        "CALL:SF - Structure Fire",
        "ADDR:2561 BERNVILLE RD",
        "PLACE:DIRECTLINK",
        "CITY:BERN TWP",
        "INFO:PENSKI ENTERANCE / BUILDING 1 TRANSFORMER ROOM / SMOKE IN THE BUILDING");

    doTest("T13",
        "CAD MSG: *D AFA      RHMC C BUILDING @600 SPRUCE ST 0038 BLDG C/GENERAL FIRE/ATN/610-988-8222",
        "CALL:AFA - Fire Alarm",
        "ADDR:600 SPRUCE ST",
        "PLACE:RHMC C BUILDING",
        "CITY:WEST READING",
        "INFO:BLDG C/GENERAL FIRE/ATN/610-988-8222");

    doTest("T14",
        "CAD MSG: *D ALSMED   459 MEMORIAL HWY 0091 F IN SEIZURES / 1YOF /",
        "CALL:ALSMED",
        "ADDR:459 MEMORIAL HWY",
        "CITY:RUSCOMBMANOR TWP",
        "INFO:F IN SEIZURES / 1YOF /");

    doTest("T15",
        "FRM: \nMSG:CAD MSG: *D AFA      1501 ELIZABETH AV @THOMS TAVERN 0067 KEYPAD FIRE ALM ZONE 95 BUS # 484-794-6038 / GRUMPY'S BARB",
        "CALL:AFA - Fire Alarm",
        "ADDR:1501 ELIZABETH AV",
        "MADDR:1501 ELIZABETH AVE",
        "PLACE:THOMS TAVERN",
        "CITY:LAURELDALE",
        "INFO:KEYPAD FIRE ALM ZONE 95 BUS # 484-794-6038 / GRUMPY'S BARB");
  }
  
  public static void main(String[] args) {
    new PABerksCountyParserTest().generateTests("T15", "CALL ADDR PLACE CITY INFO");
  }
}
