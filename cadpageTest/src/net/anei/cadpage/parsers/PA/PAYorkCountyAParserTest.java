package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class PAYorkCountyAParserTest extends BaseParserTest {
  
  public PAYorkCountyAParserTest() {
    setParser(new PAYorkCountyAParser(), "YORK COUNTY", "PA");
  }
  
  @Test
  public void testParser1() {

    doTest("T1",
        "NORTH CODORUS TWP \n\n1983 SLAGEL RD STOVERSTOWN RD / VIEW DR FIRE STRUCT RESID Working Fire 12-01 S99-1 RIT1 17:05",
        "CITY:NORTH CODORUS",
        "ADDR:1983 SLAGEL RD",
        "X:STOVERSTOWN RD / VIEW DR",
        "CALL:FIRE STRUCT RESID Working Fire",
        "MAP:12-01",
        "UNIT:S99-1 RIT1",
        "TIME:17:05");

    doTest("T2",
        "YORK TWP COUNTRY MEADOWS \n\n2760 PINE GROVE RD 2760 PINE GROVE RD LEADER HEIGHTS RD, PINE GROVE CIR / PINE GROVE CMN FIRE AFA HIGH RISK general alm from the Leader Heights Building 19-04 FIRESTA19 E19 E18-1 E89-2 E35-2 TK19 TK34 EMSSTA18 A18 12:22",
        "CITY:YORK",
        "PLACE:COUNTRY MEADOWS",
        "ADDR:2760 PINE GROVE RD",
        "APT:2760",
        "X:PINE GROVE RD / LEADER HEIGHTS RD",
        "CALL:PINE GROVE CIR / PINE GROVE CMN FIRE AFA HIGH RISK general alm from the Leader Heights Building",
        "MAP:19-04",
        "SRC:FIRESTA19",
        "UNIT:E19 E18-1 E89-2 E35-2 TK19 TK34 EMSSTA18 A18",
        "TIME:12:22");

    doTest("T3",
        "PENN TWP \n\n1060 WILSON AVE OLD RIDGE RD / YORK ST, GRANDVIEW RD FIRE VEHICLE HR mulching machine on fire 49-17 FIRESTA49 E49-2 E46-3 E49-1",
        "CITY:PENN",
        "ADDR:1060 WILSON AVE",
        "X:OLD RIDGE RD / YORK ST",
        "CALL:GRANDVIEW RD FIRE VEHICLE HR mulching machine on fire",
        "MAP:49-17",
        "SRC:FIRESTA49",
        "UNIT:E49-2 E46-3 E49-1");

    doTest("T4",
        "YORK CITY \n\n900 E KING ST S TREMONT ST / S CAMBRIDGE ST HAZMAT NO INJ hit gas service outside residence 99-06 FIRESTA99 E99-5 E99-1 TK99-1 DO99 15:23",
        "CITY:YORK",
        "ADDR:900 E KING ST S",
        "X:TREMONT ST / S CAMBRIDGE ST",
        "CALL:HAZMAT NO INJ hit gas service outside residence",
        "MAP:99-06",
        "SRC:FIRESTA99",
        "UNIT:E99-5 E99-1 TK99-1 DO99",
        "TIME:15:23");

    doTest("T5",
        "MANCH TWP METRO BANK MANCH TWP \n\n55 ARSENAL RD I 83X21BARSENALRD NB / I 83 NB VEH ACC INJ CL 2 30/F/leaking fluids 24-07 FIRESTA24 E24-1 R24  13:20",
        "CITY:MANCHESTER",
        "PLACE:METRO BANK MANCH TWP",
        "ADDR:55 ARSENAL RD",
        "CALL:I 83X21BARSENALRD NB / I 83 NB VEH ACC INJ CL 2 30 / F / leaking fluids",
        "MAP:24-07",
        "SRC:FIRESTA24",
        "UNIT:E24-1 R24",
        "TIME:13:20");

    doTest("T6",
        "HELLAM TWP \n\n4045 CODORUS FURNACE RD RIVER FARM RD / JENNIFER LN LANDING ZONE Jennifer and Furnace for LZ 21-13 R24  11:08",
        "CITY:HELLAM",
        "ADDR:4045 CODORUS FURNACE RD",
        "X:RIVER FARM RD / JENNIFER LN",
        "CALL:LANDING ZONE Jennifer and Furnace for LZ",
        "MAP:21-13",
        "UNIT:R24",
        "TIME:11:08");

    doTest("T7",
        "Fire Incident / YORK TWP I83 SB EXIT 16A\n\nI 83 SB I 83X16ASQUEENST SB FIRE VEHICLE HR cancel call 19-832 UFIRE24 UFIRE25 UEMS24  00:27¿\n\n\n",
        "CITY:YORK",
        "PLACE:I83 SB EXIT 16A",
        "ADDR:I 83 SB",
        "MADDR:I83 SB EXIT 16A,I 83",
        "CALL:I 83X16ASQUEENST SB FIRE VEHICLE HR cancel call",
        "MAP:19-832",
        "UNIT:UFIRE24 UFIRE25 UEMS24",
        "TIME:00:27");

    doTest("T8",
        "MANCH TWP CODORUS STONE COMPANY\n\n135 MUNDIS RACE RD EMIG RD, MUNDIS LN / DELLINGER RD FIRE AFA HIGH RISK / 2nd floor smoke /  24-03 FIRESTA24 E24-1 E89-3 TK24 EMSSTA24 A23-2  11:58",
        "CITY:MANCHESTER",
        "PLACE:CODORUS STONE COMPANY",
        "ADDR:135 MUNDIS RACE RD",
        "X:EMIG RD / MUNDIS LN",
        "CALL:/ DELLINGER RD FIRE AFA HIGH RISK / 2nd floor smoke /",
        "MAP:24-03",
        "SRC:FIRESTA24",
        "UNIT:E24-1 E89-3 TK24 EMSSTA24 A23-2",
        "TIME:11:58");

    doTest("T9",
        "MANCH TWP GRAHAM PKG 3280 FARMTRAIL RD\n\n3280 FARMTRAIL RD CHURCH RD / FARMBROOK LN FIRE AFA HIGH RISK general fire alarm 24-10 FIRESTA24 E24-1 E23-1 TK24 EMSSTA24 A24-2  04:41",
        "CITY:MANCHESTER",
        "PLACE:GRAHAM PKG 3280 FARMTRAIL RD",
        "ADDR:3280 FARMTRAIL RD",
        "X:CHURCH RD / FARMBROOK LN",
        "CALL:FIRE AFA HIGH RISK general fire alarm",
        "MAP:24-10",
        "SRC:FIRESTA24",
        "UNIT:E24-1 E23-1 TK24 EMSSTA24 A24-2",
        "TIME:04:41");

    doTest("T10",
        "Fire Incident / MANCH TWP \n\nCHURCH RD BOARD RD DEBRIS REMOVAL veh acc no inj leaking 24-02 FIRESTA24 E24-1  18:17¿\n\n\n",
        "CITY:MANCHESTER",
        "ADDR:CHURCH RD & BOARD RD",
        "CALL:DEBRIS REMOVAL veh acc no inj leaking",
        "MAP:24-02",
        "SRC:FIRESTA24",
        "UNIT:E24-1",
        "TIME:18:17");

    doTest("T11",
        "Fire Incident / W MANCHESTER TWP    CARLISLE RD RTE 30 WB VEH ACC INJ CL 2 r24 avail 02-05 UFIRE24  20:27¿\n\n\n",
        "CITY:W MANCHESTER",
        "ADDR:CARLISLE RD & RTE 30 WB",
        "MADDR:CARLISLE RD & RTE 30",
        "X:VEH ACC INJ CL",
        "CALL:2 r24 avail",
        "MAP:02-05",
        "UNIT:UFIRE24",
        "TIME:20:27");
  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "Subject:Fire Incident\nMANCH TWP    975 DETWILER DR BELAIR WAY / STILLMEADOW LN FIRE STRUCT RESID shed on fire 24-14 FIRESTA24 E24-1 E2-1 TK24 R",
        "CITY:MANCHESTER",
        "ADDR:975 DETWILER DR",
        "X:BELAIR WAY / STILLMEADOW LN",
        "CALL:FIRE STRUCT RESID shed on fire",
        "MAP:24-14",
        "SRC:FIRESTA24",
        "UNIT:E24-1 E2-1 TK24 R");

    doTest("T2",
        "Subject:Fire Incident\nMANCH TWP CARS PLUS  2008 N  GEORGE ST WOODLAND AVE / I 83 SB, LIGHTNER RD, I 83X22NGEORGEST SB FIRE WIRES 24-07 FIRESTA",
        "CITY:MANCHESTER",
        "PLACE:CARS PLUS",
        "ADDR:2008 N GEORGE ST",
        "X:WOODLAND AVE / I 83 SB",
        "CALL:LIGHTNER RD I 83X22NGEORGEST SB FIRE WIRES",
        "MAP:24-07",
        "UNIT:FIRESTA");

    doTest("T3",
        "Subject:Fire Incident\nMANCH TWP I83 NB EXIT EMIGSVILLE   I 83 NB I 83X24EMIGSVILLE NB DEBRIS REMOVAL non injury accident south of exit    24-83",
        "CITY:MANCHESTER",
        "PLACE:I83 NB EXIT EMIGSVILLE",
        "ADDR:I 83 NB",
        "MADDR:I83 NB EXIT EMIGSVILLE,I 83",
        "CALL:I 83X24EMIGSVILLE NB DEBRIS REMOVAL non injury accident south of exit",
        "MAP:24-83");

    doTest("T4",
        "Subject:Fire Incident\nMANCH TWP    130 HARVEST DR WOODMONT DR / LEAF ST STROKE/CVA CL 1 42 m/cons/yh 24-16 EMSSTA24 FIRESTA24 E24-1 A261 EMSSTA102-2 M102-2  21:05",
        "CITY:MANCHESTER",
        "ADDR:130 HARVEST DR",
        "X:WOODMONT DR / LEAF ST",
        "CALL:STROKE / CVA CL 1 42 m / cons / yh",
        "MAP:24-16",
        "UNIT:EMSSTA24 FIRESTA24 E24-1 A261 EMSSTA102-2 M102-2",
        "TIME:21:05");
  }
  
  @Test
  public void testParser3() {

    doTest("T1",
        "0049000  HANOVER BORO GOLDEN EXCHANGE CONDO ASSOCIATION   9 2ND AVE EXCHANGE PL / W WALNUT ST FIRE AFA HIGH RISK General Alarm  46-02 FIRESTA46 E46-1 E49-1",
        "ID:0049000",
        "CITY:HANOVER",
        "PLACE:GOLDEN EXCHANGE CONDO ASSOCIATION",
        "ADDR:9 2ND AVE",
        "X:EXCHANGE PL / W WALNUT ST",
        "CALL:FIRE AFA HIGH RISK General Alarm",
        "MAP:46-02",
        "SRC:FIRESTA46",
        "UNIT:E46-1 E49-1");

  }
  
  @Test
  public void testParser4() {

    doTest("T1",
        "FAIRVIEW TWP I83 SB EXIT FISHING CREEK   I 83 SB I 83X36FISHINGCREEK SB VEH ACC INJ CL 2 unk age pt/bleeding from face/unk dest 68-83 FIRESTA68 E68-2 R68  11:36",
        "SRC:FIRESTA68",
        "CITY:FAIRVIEW",
        "PLACE:I83 SB EXIT FISHING CREEK",
        "ADDR:I 83 SB",
        "MADDR:I83 SB EXIT FISHING CREEK,I 83",
        "CALL:I 83X36FISHINGCREEK SB VEH ACC INJ CL 2 unk age pt / bleeding from face / unk dest",
        "MAP:68-83",
        "SRC:FIRESTA68",
        "UNIT:E68-2 R68",
        "TIME:11:36");

    doTest("T2",
        "NEWBERRY TWP    46 MALL RD PRIVET DR / BILL DUGAN DR FIRE STRUCT RESID stove fire reported out still smoking  31-07 FIRESTA31 T31-1 E68-2 T28 T68 TK69 EMSSTA31 MICU31  12:51",
        "SRC:FIRESTA31",
        "CITY:NEWBERRY",
        "ADDR:46 MALL RD",
        "X:PRIVET DR / BILL DUGAN DR",
        "CALL:FIRE STRUCT RESID stove fire reported out still smoking",
        "MAP:31-07",
        "SRC:FIRESTA31",
        "UNIT:T31-1 E68-2 T28 T68 TK69 EMSSTA31 MICU31",
        "TIME:12:51");

    doTest("T3",
        "(Station 68) FAIRVIEW TWP    426 VALLEY RD SAND SPUR DR / TRAILER PARK FIRE STRUCT RESID Holding box to E69, E68-2,BLS 68-02 UFIRE68 UFIRE28  03:36",
        "SRC:Station 68",
        "CITY:FAIRVIEW",
        "ADDR:426 VALLEY RD",
        "X:SAND SPUR DR / TRAILER PARK",
        "CALL:FIRE STRUCT RESID Holding box to E69 E68-2 BLS",
        "MAP:68-02",
        "SRC:Station 68",
        "UNIT:UFIRE68 UFIRE28",
        "TIME:03:36");

    doTest("T4",
        "(Station 68) FAIRVIEW TWP    56 MEADOWBROOK CT DEAD END / SHAUFFNERTOWN RD, DILLER RD FIRE STRUCT RESID Mobile home fire   68-05 FIRESTA68 E68-2 E69-1 T",
        "SRC:Station 68",
        "CITY:FAIRVIEW",
        "ADDR:56 MEADOWBROOK CT",
        "X:DEAD END / SHAUFFNERTOWN RD",
        "CALL:DILLER RD FIRE STRUCT RESID Mobile home fire",
        "MAP:68-05",
        "SRC:FIRESTA68",
        "UNIT:E68-2 E69-1 T");

    doTest("T5",
        "(Station 68) FAIRVIEW TWP I83 SB EXIT 39B   I 83 SB I 83X39BPATURNPIKE SB VEH ACC OT NO INJ  Veh OT 68-83 FIRESTA68 E68-2 R68  05:56",
        "SRC:FIRESTA68",
        "CITY:FAIRVIEW",
        "PLACE:I83 SB EXIT 39B",
        "ADDR:I 83 SB",
        "MADDR:I83 SB EXIT 39B,I 83",
        "CALL:I 83X39BPATURNPIKE SB VEH ACC OT NO INJ Veh OT",
        "MAP:68-83",
        "SRC:FIRESTA68",
        "UNIT:E68-2 R68",
        "TIME:05:56");

    doTest("T6",
        "(Station 68) FAIRVIEW TWP    768 LEWISBERRY RD IRONSTONE RD, FISHING CREEK RD / CEDARS RD FIRE VEHICLE  WORKING FIRE 68-04 UFIRE68 UEMS68  18:47",
        "SRC:Station 68",
        "CITY:FAIRVIEW",
        "ADDR:768 LEWISBERRY RD",
        "X:IRONSTONE RD / FISHING CREEK RD",
        "CALL:/ CEDARS RD FIRE VEHICLE WORKING FIRE",
        "MAP:68-04",
        "UNIT:UFIRE68 UEMS68",
        "TIME:18:47");

    doTest("T7",
        "(Station 68) NEWBERRY TWP    OLD TRAIL RD PINES RD VEH ACC INJ CL 2 updated locat ion 31-01 UFIRE31 UEMS31 UFIRE68  03:57",
        "SRC:Station 68",
        "CITY:NEWBERRY",
        "ADDR:OLD TRAIL RD & PINES RD",
        "X:VEH ACC INJ CL",
        "CALL:2 updated locat ion",
        "MAP:31-01",
        "UNIT:UFIRE31 UEMS31 UFIRE68",
        "TIME:03:57");

    doTest("T8",
        "(Station 68) FAIRVIEW TWP    02 FOXFIRE LN OLD FORGE RD / WHEATLAND RD FIRE STRUCT RESID fire on back porch 68-04 FIRESTA68 E68-2 CCE24 E69-1 T68 CCT24",
        "SRC:FIRESTA68",
        "CITY:FAIRVIEW",
        "ADDR:02 FOXFIRE LN",
        "X:OLD FORGE RD / WHEATLAND RD",
        "CALL:FIRE STRUCT RESID fire on back porch",
        "MAP:68-04",
        "UNIT:E68-2 CCE24 E69-1 T68 CCT24");

  }
  
  @Test
  public void testMatthewRuss() {

    doTest("T1",
        "Subject:Fire Incident\n" +
        "MANCH TWP HOMEWOOD SUITES BY HILTON   200 MASONIC DR PARKLYN LN / IRONSTONE DR RESC RESID CL 2 poss someone stuck in elev\r",

        "CITY:MANCHESTER",
        "PLACE:HOMEWOOD SUITES BY HILTON",
        "ADDR:200 MASONIC DR",
        "X:PARKLYN LN / IRONSTONE DR",
        "CALL:RESC RESID CL 2 poss someone stuck in elev");

  }
  
  public static void main(String[] args) {
    new PAYorkCountyAParserTest().generateTests("T1", "SRC ID CITY PLACE ADDR APT X CALL MAP UNIT TIME");
  }
}
