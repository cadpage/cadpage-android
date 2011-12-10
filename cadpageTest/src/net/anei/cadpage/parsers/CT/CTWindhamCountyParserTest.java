package net.anei.cadpage.parsers.CT;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class CTWindhamCountyParserTest extends BaseParserTest {
  
  public CTWindhamCountyParserTest() {
    setParser(new CTWindhamCountyParser(), "WINDHAM COUNTY", "CT");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Moosup FD Page) STA94 STA594 MOOS1  UHF-4 PRI 1 person fallen Medical Alarm 1 SARA LN / Moosup (X-STS HIGH ST / DEAD END ) 07:31",
        "SRC:Moosup FD",
        "UNIT:STA94 STA594 MOOS1",
        "CH:UHF-4",
        "PRI:1",
        "CALL:person fallen Medical Alarm",
        "ADDR:1 SARA LN",
        "CITY:Moosup",
        "X:HIGH ST / DEAD END",
        "TIME:07:31");

    doTest("T2",
        "(Moosup FD Page) STA94 STA594 MOOS1  33.88 PRI 1 Sick Person 109 WHIP POOR WILL DR / Moosup (X-STS ) 10:57",
        "SRC:Moosup FD",
        "UNIT:STA94 STA594 MOOS1",
        "CH:33.88",
        "PRI:1",
        "CALL:Sick Person",
        "ADDR:109 WHIP POOR WILL DR",
        "CITY:Moosup",
        "TIME:10:57");

    doTest("T3",
        "(Moosup FD Page) STA94 STA594 MOOS1  UHF-4 PRI 1 Sick Person BARBER HILL RD / N  MAIN ST Moosup (X-STS ) 17:35",
        "SRC:Moosup FD",
        "UNIT:STA94 STA594 MOOS1",
        "CH:UHF-4",
        "PRI:1",
        "CALL:Sick Person BARBER",
        "ADDR:HILL RD & N  MAIN ST",
        "CITY:Moosup",
        "TIME:17:35");

    doTest("T4",
        "(Moosup FD Page) STA94 94OFF  33.90 Vehicle Fire I 395 SOUTH SOUTH OF REST AREA / Moosup (X-STS ) 14:24",
        "SRC:Moosup FD",
        "UNIT:STA94 94OFF",
        "CH:33.90",
        "CALL:Vehicle Fire",
        "ADDR:I 395 SOUTH SOUTH OF REST AREA",
        "CITY:Moosup",
        "TIME:14:24");

    doTest("T5",
        "(Moosup FD Page) STA94  UHF-4 Wire Down Starting a Small Grass Fire / Tree/Wires Down 201 STARKWEATHER RD / Moosup (X-STS GROVE ST  STERLING HILL RD / PLAINFIELD",
        "SRC:Moosup FD",
        "UNIT:STA94",
        "CH:UHF-4",
        "CALL:Wire Down Starting a Small Grass Fire/Tree/Wires Down",
        "ADDR:201 STARKWEATHER RD",
        "CITY:Moosup",
        "X:GROVE ST  STERLING HILL RD / PLAINFIELD");

    doTest("T6",
        "(Moosup FD Page) STA94  33.88 Please Operate 33.88/  Lift Assist 2 N  POTVIN AVE / Moosup (X-STS DAGGETT ST / POTVIN AVE ) 11:34",
        "SRC:Moosup FD",
        "UNIT:STA94",
        "CH:33.88",
        "CALL:Please Operate 33.88/Lift Assist",
        "ADDR:2 N POTVIN AVE",
        "CITY:Moosup",
        "X:DAGGETT ST / POTVIN AVE",
        "TIME:11:34");

    doTest("T7",
        "(Moosup FD Page) STA94  33.76 OUT BUILDING SMOLDERING Outside/Unknown Fire 399 SNAKE MEADOW RD / SNAKE MEADOW CLUB Moosup (X-STS OLEAROS HILL RD / DEMERS RD )",
        "SRC:Moosup FD",
        "UNIT:STA94",
        "CH:33.76",
        "CALL:OUT BUILDING SMOLDERING Outside/Unknown Fire",
        "ADDR:399 SNAKE MEADOW RD",
        "PLACE:SNAKE MEADOW CLUB",
        "CITY:Moosup",
        "X:OLEAROS HILL RD / DEMERS RD");

    doTest("T8",
        "(Moosup FD Page) STA94  UHF-4 Alarm Reset / Smoke from Cooking /  Fire Alarm 25 SUNNY ACRES / Moosup (X-STS DAGGETT ST / DEAD END ) 10:19",
        "SRC:Moosup FD",
        "UNIT:STA94",
        "CH:UHF-4",
        "CALL:Alarm Reset/Smoke from Cooking/Fire Alarm",
        "ADDR:25 SUNNY ACRES",
        "CITY:Moosup",
        "X:DAGGETT ST / DEAD END",
        "TIME:10:19");

    doTest("T9",
        "(Moosup FD Page) STA94  33.90 PRI 1 ROLL OVER / STA94 MANPOWER REQUESTED / Vehicle Accident I 395 S / EXIT 88 / Plainfield (X-STS ) 11:27",
        "SRC:Moosup FD",
        "UNIT:STA94",
        "CH:33.90",
        "PRI:1",
        "CALL:ROLL OVER/STA94 MANPOWER REQUESTED/Vehicle Accident",
        "ADDR:I 395 S & EXIT 88",
        "CITY:Plainfield",
        "TIME:11:27");

    doTest("T10",
        "(Moosup FD Page) QVMedic STA94 STA594 MOOS1  UHF-4 PRI 1 PARTIAL AIR WAS OBSTRUCTIONS / Choking/Airway Problem 67 S MAIN ST / Moosup (X-STS VOSSLER DR / WARD LN",
        "SRC:Moosup FD",
        "UNIT:QVMedic STA94 STA594 MOOS1",
        "CH:UHF-4",
        "PRI:1",
        "CALL:PARTIAL AIR WAS OBSTRUCTIONS/Choking/Airway Problem",
        "ADDR:67 S MAIN ST",
        "CITY:Moosup",
        "X:VOSSLER DR / WARD LN");

    doTest("T11",
        "(Moosup FD Page) STA94 STA594 MOOS2  UHF-4 PRI 1 MOOS AMB 2ND CREW / Vehicle Accident SNAKE MEADOW RD / VALLEY VIEW RD / Moosup (X-STS ) 22:10",
        "SRC:Moosup FD",
        "UNIT:STA94 STA594 MOOS2",
        "CH:UHF-4",
        "PRI:1",
        "CALL:MOOS AMB 2ND CREW/Vehicle Accident SNAKE",
        "ADDR:MEADOW RD & VALLEY VIEW RD",
        "CITY:Moosup",
        "TIME:22:10");
  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "STA97 STA594 MOOS2  UHF-4 PRI 1 2ND CREW NEEDED Cardiac Distress 30 PICKETT RD / Central Village (X-STS TEX",
        "UNIT:STA97 STA594 MOOS2",
        "CH:UHF-4",
        "PRI:1",
        "CALL:2ND CREW NEEDED Cardiac Distress",
        "ADDR:30 PICKETT RD",
        "CITY:Central Village",
        "X:TEX");

    doTest("T2",
        "Subject:Central Village FD Page\nSTA97 STA594 MOOS2  UHF-4 PRI 1 MOOS AMB 2ND CREW NEEDED / Injured Person 80 S CADY LN / CENTRAL CYCLE TRAC",
        "SRC:Central Village FD",
        "UNIT:STA97 STA594 MOOS2",
        "CH:UHF-4",
        "PRI:1",
        "CALL:MOOS AMB 2ND CREW NEEDED/Injured Person",
        "ADDR:80 S CADY LN",
        "PLACE:CENTRAL CYCLE TRAC");

    doTest("T3",
        "1 of 2\nFRM:messaging@iamresponding.com\nSUBJ:K.B. Ambulance\nMSG:RES65  KB2  UHF-2 PRI 1 KB SECOND CREW / POLICE ENROUTE /  Cardiac/Respiratory\n(Con't) 2 of 2\nArrest 36 SAW MILL HILL RD / Killingly (X-STS TILLINGHAST RD / PROVIDENCE PIKE  BAILEY HILL RD ) 07:11¿\n(End)",
        "SRC:K.B. Ambulance",
        "UNIT:RES65 KB2",
        "CH:UHF-2",
        "PRI:1",
        "CALL:KB SECOND CREW/POLICE ENROUTE/Cardiac/Respiratory Arrest",
        "ADDR:36 SAW MILL HILL RD",
        "CITY:Killingly",
        "X:TILLINGHAST RD / PROVIDENCE PIKE  BAILEY HILL RD");

  }
  
  public static void main(String[] args) {
    new CTWindhamCountyParserTest().generateTests("T1", "SRC UNIT CH PRI CALL ADDR PLACE CITY X TIME");
  }
}