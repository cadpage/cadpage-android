package net.anei.cadpage.parsers.MI;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class MISaginawCountyParserTest extends BaseParserTest {
  
  public MISaginawCountyParserTest() {
	  setParser(new MISaginawCountyParser(), "SAGINAW COUNTY", "MI");
  }
  
  @Test
  public void testParserDavidSmigiel() {

    doTest("T1",
        "LOC:S PORTSMOUTH RD / KING RD DESC:LAT: <43.384720>  LONG: <-83.837678> APT: TYP:*M*PDA PIN IN JUST OCCU",
        "ADDR:S PORTSMOUTH RD & KING RD",
        "CALL:PDA PIN IN JUST OCCU",
        "GPS:43.384720,-83.837678");
 }
  
  public void testTld2a() {

    doTest("T1",
        "LOC:2673 OHIO DESC:52/M DIFF BREATHING/CHEST PAINS APT: TYP:*M*SICK PERSON IN PROGRESS",
        "ADDR:2673 OHIO",
        "CALL:52/M DIFF BREATHING/CHEST PAINS");

    doTest("T2",
        "LOC:3833 ORANGE ST DESC:79/F DIFF BREATHING/CHEST PAIN APT: TYP:*M*SICK PERSON IN PROGRESS",
        "ADDR:3833 ORANGE ST",
        "CALL:79/F DIFF BREATHING/CHEST PAIN");

    doTest("T3",
        "LOC:3459 WOODLAND CT DESC:86 FE DIFF BREATHING APT: TYP:*M*SICK PERSON IN PROGRESS",
        "ADDR:3459 WOODLAND CT",
        "CALL:86 FE DIFF BREATHING");

    doTest("T4",
        "LOC:4030 JORDAN DR DESC:80/M  CHEST PAIN APT: TYP:*M*SICK PERSON IN PROGRESS",
        "ADDR:4030 JORDAN DR",
        "CALL:80/M  CHEST PAIN");

    doTest("T5",
        "LOC:S PORTSMOUTH RD / KING RD DESC:LAT: <43.384720>  LONG: <-83.837678> APT: TYP:*M*PDA PIN IN JUST OCCU",
        "ADDR:S PORTSMOUTH RD & KING RD",
        "CALL:PDA PIN IN JUST OCCU",
        "GPS:43.384720,-83.837678");

    doTest("T6",
        "LOC:7723 DIXIE HWY DESC: APT: TYP:*M*FIRE OUTSIDE",
        "ADDR:7723 DIXIE HWY",
        "CALL:FIRE OUTSIDE");

    doTest("T7",
        "LOC:2895 E MOORE RD DESC:80F CHEST PAIN APT: TYP:*M*SICK PERSON IN PROGRESS",
        "ADDR:2895 E MOORE RD",
        "CALL:80F CHEST PAIN");
 
  }
  
  public static void main(String[] args) {
    new MISaginawCountyParserTest().generateTests("T1");
  }
}
