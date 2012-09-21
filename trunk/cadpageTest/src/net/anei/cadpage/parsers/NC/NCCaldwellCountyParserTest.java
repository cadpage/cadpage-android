package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NCCaldwellCountyParserTest extends BaseParserTest {
  
  public NCCaldwellCountyParserTest() {
    setParser(new NCCaldwellCountyParser(), "CALDWELL COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "BREATHING PROBLEMS CHARLIE;25 WATER ST;GF;APT 12;CIRCLE ST;NORTH SUMMIT AV",
        "CALL:BREATHING PROBLEMS CHARLIE",
        "ADDR:25 WATER ST",
        "APT:12",
        "CITY:GRANITE FALLS",
        "X:CIRCLE ST & NORTH SUMMIT AV");

    doTest("T2",
        "CARDIAC RESP ARREST DEATH ECHO;5105 WENDOVER LN;GF;GUNPOWDER RD",
        "CALL:CARDIAC RESP ARREST DEATH ECHO",
        "ADDR:5105 WENDOVER LN",
        "CITY:GRANITE FALLS",
        "X:GUNPOWDER RD");

    doTest("T3",
        "FALL WITH PERSONAL INJURY;2998 CAMPGROUND RD;GF;SHELTON HOLLAR PL;C BELL MCRARY PL;1107150247",
        "CALL:FALL WITH PERSONAL INJURY",
        "ADDR:2998 CAMPGROUND RD",
        "CITY:GRANITE FALLS",
        "X:SHELTON HOLLAR PL & C BELL MCRARY PL",
        "ID:1107150247");

    doTest("T4",
        "FALL WITH PERSONAL INJURY;WALMART GRANITE FALLS;4780 HICKORY BLVD;GF;GLEN RIDGE DR;RIVERBEND DR;1107160106",
        "CALL:FALL WITH PERSONAL INJURY",
        "PLACE:WALMART GRANITE FALLS",
        "ADDR:4780 HICKORY BLVD",
        "CITY:GRANITE FALLS",
        "X:GLEN RIDGE DR & RIVERBEND DR",
        "ID:1107160106");

    doTest("T5",
        "CARBON MONOXIDE DETECTOR ALARM;398 THOMPSON DR;HUD;SHADY OAK TER;HICKORY BLVD;1107200204",
        "CALL:CARBON MONOXIDE DETECTOR ALARM",
        "ADDR:398 THOMPSON DR",
        "CITY:HUDSON",
        "X:SHADY OAK TER & HICKORY BLVD",
        "ID:1107200204");

    doTest("T6",
        "UNKNOWN MEDICAL CODE;1450 SHAIRE CENTER DR;LEN;APT 1;ANDREWS CIR;LOVEJOY ST;1108080045",
        "CALL:UNKNOWN MEDICAL CODE",
        "ADDR:1450 SHAIRE CENTER DR",
        "APT:1",
        "CITY:LENOIR",
        "X:ANDREWS CIR & LOVEJOY ST",
        "ID:1108080045");

    doTest("T7",
        "UNCONSC FAINT NEAR DELTA;9 LIBERTY ST;GF;FALLS AV;1108100046",
        "CALL:UNCONSC FAINT NEAR DELTA",
        "ADDR:9 LIBERTY ST",
        "CITY:GRANITE FALLS",
        "X:FALLS AV",
        "ID:1108100046");

    doTest("T8",
        "ACCIDENT PROPERTY DAMAGE;GRACE CHAPEL RD/WOLFE RD;HICK;1202190163",
        "CALL:ACCIDENT PROPERTY DAMAGE",
        "ADDR:GRACE CHAPEL RD & WOLFE RD",
        "CITY:HICKORY",
        "ID:1202190163");
  }

  public static void main(String[] args) {
    new NCCaldwellCountyParserTest().generateTests("T1");
  }
}
