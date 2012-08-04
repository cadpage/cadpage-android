package net.anei.cadpage.parsers.CO;

import net.anei.cadpage.parsers.BaseParserTest;
import org.junit.Test;

public class COJeffersonCountyParserTest extends BaseParserTest {
  
  public COJeffersonCountyParserTest() {
    setParser(new COJeffersonCountyParser(), "Jefferson County", "CO");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "[WRCAD] Add:3745 Quail St Type: UNKM PgH-16 Units:WR1,WM4Radio:TAC2 Case#:0708201205966-001385",
        "ADDR:3745 Quail St",
        "CALL:UNKM",
        "MAP:H-16",
        "UNIT:WR1,WM4",
        "CH:TAC2",
        "ID:0708201205966-001385");

    doTest("T2",
        "[WRCAD] Add:2650 Harlan St Type: UNKM PgH-19 Units:WR1,WM1Radio:TAC2 Case#:0714201205966-001431",
        "ADDR:2650 Harlan St",
        "CALL:UNKM",
        "MAP:H-19",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0714201205966-001431");

    doTest("T3",
        "[WRCAD] Add:4345 Everett St Type: FALL PgG-17 Units:WM1,WR1Radio:TAC2 Case#:0627201205966-001283",
        "ADDR:4345 Everett St",
        "CALL:FALL",
        "MAP:G-17",
        "UNIT:WM1,WR1",
        "CH:TAC2",
        "ID:0627201205966-001283");

    doTest("T4",
        "[WRCAD] Add:3480 Ames St Type: LINE PgH-19 Units:WR1,WRD71Radio:TAC2 Case#:0627201205966-001282",
        "ADDR:3480 Ames St",
        "CALL:LINE",
        "MAP:H-19",
        "UNIT:WR1,WRD71",
        "CH:TAC2",
        "ID:0627201205966-001282");

    doTest("T5",
        "[WRCAD] Add:7045 W 43rd Ave Type: INV PgG-18 Units:WR1,WRD71Radio:TAC3 Case#:0705201205966-001352",
        "ADDR:7045 W 43rd Ave",
        "CALL:INV",
        "MAP:G-18",
        "UNIT:WR1,WRD71",
        "CH:TAC3",
        "ID:0705201205966-001352");

    doTest("T6",
        "[WRCAD] Add:2686 Newland St Type: CO PgH-19 Units:WR1Radio:TAC2 Case#:0712201205966-001412",
        "ADDR:2686 Newland St",
        "CALL:CO",
        "MAP:H-19",
        "UNIT:WR1",
        "CH:TAC2",
        "ID:0712201205966-001412");

    doTest("T7",
        "[WRCAD] Add:4643 Wadsworth Blvd Type: FALL PgG-18 Units:WR1,WM1Radio:TAC2 Case#:0711201205966-001410",
        "ADDR:4643 Wadsworth Blvd",
        "CALL:FALL",
        "MAP:G-18",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0711201205966-001410");

    doTest("T8",
        "[WRCAD] Add:7380 W 32nd Ave Type: STROK PgH-18 Units:WR1,WM1Radio:TAC2 Case#:0713201205966-001423",
        "ADDR:7380 W 32nd Ave",
        "CALL:STROK",
        "MAP:H-18",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0713201205966-001423");

    doTest("T9",
        "[WRCAD] Add:7535 W 44th Ave Type: ALTER PgG-18 Units:WR1,WM2Radio:TAC2 Case#:0718201205966-001458",
        "ADDR:7535 W 44th Ave",
        "CALL:ALTER",
        "MAP:G-18",
        "UNIT:WR1,WM2",
        "CH:TAC2",
        "ID:0718201205966-001458");

    doTest("T10",
        "[WRCAD] Add:7777 W 29th Ave Type: PSYCH PgH-18 Units:WR1,WM1Radio:TAC2 Case#:0704201205966-001341",
        "ADDR:7777 W 29th Ave",
        "CALL:PSYCH",
        "MAP:H-18",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0704201205966-001341");

    doTest("T11",
        "[WRCAD] Add:4407 Teller St Type: CPRA PgG-18 Units:WR1,WM1Radio:TAC2 Case#:0630201205966-001302",
        "ADDR:4407 Teller St",
        "CALL:CPRA",
        "MAP:G-18",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0630201205966-001302");

  }
  
  public static void main(String[] args) {
    new COJeffersonCountyParserTest().generateTests("T1");
  }
}
  