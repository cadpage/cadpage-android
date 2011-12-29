package net.anei.cadpage.parsers.CA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class CARiversideCountyParserTest extends BaseParserTest {
  
  public CARiversideCountyParserTest() {
    setParser(new CARiversideCountyParser(), "RIVERSIDE COUNTY", "CA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "MED, TRAFFIC COLLISION; 24630 UPPER RIM ROCK RD ,IDYL ; IFO ADDY SOLO VEH ROLLOVER; 24899 BLK AZALEA RD; 814_F_4/155__98; Inc# 118228; Cmd: RRU SUP 8; Tac: RVC TAC 0; M626; icy roads access from lower way",
        "CALL:MED, TRAFFIC COLLISION",
        "ADDR:24630 UPPER RIM ROCK RD",
        "CITY:IDYLLWILD",
        "INFO:IFO ADDY SOLO VEH ROLLOVER / icy roads access from lower way",
        "X:24899 BLK AZALEA RD",
        "MAP:814_F_4/155__98",
        "ID:118228",
        "SRC:RRU SUP 8",
        "CH:RVC TAC 0",
        "UNIT:M626");

    doTest("T2",
        "MED, PERSON DOWN; STN621 @ 54160 MARANATHA DR ,IDYL ; ; 25778 BLK JOHNSON RD; 814_C_6/154__131; Inc# 119114; Cmd: RRU SUP 11; Tac: RVC TAC 0; M625; NO TEXT",
        "CALL:MED, PERSON DOWN",
        "PLACE:STN621",
        "ADDR:54160 MARANATHA DR",
        "CITY:IDYLLWILD",
        "INFO:NO TEXT",
        "X:25778 BLK JOHNSON RD",
        "MAP:814_C_6/154__131",
        "ID:119114",
        "SRC:RRU SUP 11",
        "CH:RVC TAC 0",
        "UNIT:M625");

    doTest("T3",
        "MED, PERSON DOWN; 25280 NORWOOD DR ,PINC ; RX TO PRES MEDS; 52100 BLK ACORN LN; 813_H_5/154__116; Inc# 118213; Cmd: RRU SUP 8; Tac: RVC TAC 0; STN23A E23 M624; NO TEXT",
        "CALL:MED, PERSON DOWN",
        "ADDR:25280 NORWOOD DR",
        "CITY:PINE COVE",
        "INFO:RX TO PRES MEDS / NO TEXT",
        "X:52100 BLK ACORN LN",
        "MAP:813_H_5/154__116",
        "ID:118213",
        "SRC:RRU SUP 8",
        "CH:RVC TAC 0",
        "UNIT:STN23A E23 M624");

    doTest("T4",
        "MED, FALL; TAHQUITZ CONFERENCE ASSOC @ 55251 S CIRCLE DR ,IDYL ; PT IN PLOT; 25000 BLK JOHN MUIR RD; 814_E_5/155__121; Inc# 118088; Cmd: RRU SUP 11; Tac: RVC TAC 0; STN621A ME621 M624; 659-2934",
        "CALL:MED, FALL",
        "PLACE:TAHQUITZ CONFERENCE ASSOC",
        "ADDR:55251 S CIRCLE DR",
        "CITY:IDYLLWILD",
        "INFO:PT IN PLOT / 659-2934",
        "X:25000 BLK JOHN MUIR RD",
        "MAP:814_E_5/155__121",
        "ID:118088",
        "SRC:RRU SUP 11",
        "CH:RVC TAC 0",
        "UNIT:STN621A ME621 M624");

    doTest("T5",
        "FMS, ELECTRICAL; 54912 WILDWOOD DR / 54860 S CIRCLE DR ,IDYL ; TREE FALLEN INTO SMALLER TREE; ; 814_E_6/155__133; Inc# 117897; Cmd: RRU SUP 8; Tac: RVC TAC 0; M624; hanging over power lines, not actually touching power lines-",
        "CALL:FMS, ELECTRICAL",
        "ADDR:54912 WILDWOOD DR & 54860 S CIRCLE DR",
        "MADDR:54912 WILDWOOD DR",
        "CITY:IDYLLWILD",
        "INFO:TREE FALLEN INTO SMALLER TREE / hanging over power lines, not actually touching power lines-",
        "MAP:814_E_6/155__133",
        "ID:117897",
        "SRC:RRU SUP 8",
        "CH:RVC TAC 0",
        "UNIT:M624");

    doTest("T6",
        "FIRE, COMMERCIAL ALARM; 52500 TEMECULA DR ,IDYL ; IAF-LOWER WAYNE; 52200 BLK CAHUILLA DR; 843_J_1/154__164; Inc# 117832; Cmd: RRU SUP 11; Tac: RVC TAC 5; STN621A ME621 E23; fire alarm , rm #118 premise 951-659-2171",
        "CALL:FIRE, COMMERCIAL ALARM",
        "ADDR:52500 TEMECULA DR",
        "CITY:IDYLLWILD",
        "INFO:IAF-LOWER WAYNE / fire alarm , rm #118 premise 951-659-2171",
        "X:52200 BLK CAHUILLA DR",
        "MAP:843_J_1/154__164",
        "ID:117832",
        "SRC:RRU SUP 11",
        "CH:RVC TAC 5",
        "UNIT:STN621A ME621 E23");

    doTest("T7",
        "MED, FALL; 54915 S CIRCLE DR ,IDYL ; ILL, HEAD INJ; 54099 BLK MONTGOMERY ST; 814_E_6/155__133; Inc# 117490; Cmd: RRU SUP 11; Tac: RVC TAC 0; SQ621; 951-468-4043",
        "CALL:MED, FALL",
        "ADDR:54915 S CIRCLE DR",
        "CITY:IDYLLWILD",
        "INFO:ILL, HEAD INJ / 951-468-4043",
        "X:54099 BLK MONTGOMERY ST",
        "MAP:814_E_6/155__133",
        "ID:117490",
        "SRC:RRU SUP 11",
        "CH:RVC TAC 0",
        "UNIT:SQ621");

    doTest("T8",
        "MED, CHILD BIRTH; 52830 PINE COVE RD ,PINC ; ; 25056 BLK MARION RIDGE DR; 813_J_5/154__117; Inc# 117230; Cmd: RRU SUP 8; Tac: RVC TAC 0; STN23A E23 M624; e23 e/r, req amr",
        "CALL:MED, CHILD BIRTH",
        "ADDR:52830 PINE COVE RD",
        "CITY:PINE COVE",
        "INFO:e23 e/r, req amr",
        "X:25056 BLK MARION RIDGE DR",
        "MAP:813_J_5/154__117",
        "ID:117230",
        "SRC:RRU SUP 8",
        "CH:RVC TAC 0",
        "UNIT:STN23A E23 M624");

    doTest("T9",
        "MED, FALL; 52735 OAK KNOLL RD ,PINC ; HEAD INJ; 25322 BLK MARION RIDGE DR; 813_J_5/154__117; Inc# 117011; Cmd: RRU SUP 8; Tac: RVC TAC 0; M624; NO TEXT",
        "CALL:MED, FALL",
        "ADDR:52735 OAK KNOLL RD",
        "CITY:PINE COVE",
        "INFO:HEAD INJ / NO TEXT",
        "X:25322 BLK MARION RIDGE DR",
        "MAP:813_J_5/154__117",
        "ID:117011",
        "SRC:RRU SUP 8",
        "CH:RVC TAC 0",
        "UNIT:M624");

    doTest("T10",
        "MED, DIFFICULTY BREATHING; 54310 VALLEY VIEW DR ,IDYL ; ; 26500 BLK PINE AV; 814_D_7/154__156; Inc# 116620; Cmd: RRU SUP 8; Tac: RVC TAC 0; M625; White Jeep in driveway",
        "CALL:MED, DIFFICULTY BREATHING",
        "ADDR:54310 VALLEY VIEW DR",
        "CITY:IDYLLWILD",
        "INFO:White Jeep in driveway",
        "X:26500 BLK PINE AV",
        "MAP:814_D_7/154__156",
        "ID:116620",
        "SRC:RRU SUP 8",
        "CH:RVC TAC 0",
        "UNIT:M625");
 }
  
  public static void main(String[] args) {
    new CARiversideCountyParserTest().generateTests("T1");
  }
}