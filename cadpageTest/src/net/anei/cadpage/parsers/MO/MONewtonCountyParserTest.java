package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class MONewtonCountyParserTest extends BaseParserTest {
  
  public MONewtonCountyParserTest() {
    setParser(new MONewtonCountyParser(), "NEWTON COUNTY", "MO");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Subject:911 CALL\n11178 ELAND RD  CrossStreets: JUNIPER DR 0.01 mi SE IVY DR 0.73 mi N SICK PERSON ESN: pg6 Call Number: 763388",
        "ADDR:11178 ELAND RD",
        "X:JUNIPER DR 0.01 mi SE IVY DR 0.73 mi N",
        "CALL:SICK PERSON",
        "MAP:pg6",
        "ID:763388");

    doTest("T2",
        "Subject:911 CALL\nIRIS RD & STATE LINE RD  CrossStreets: TA-D (TONE PD) HIGH MECH-ALL TERRAIN ESN: pg6 Call Number: 760919",
        "ADDR:IRIS RD & STATE LINE RD",
        "CALL:TA-D (TONE PD) HIGH MECH-ALL TERRAIN",
        "MAP:pg6",
        "ID:760919");

    doTest("T3",
        "Subject:911 CALL\n" +
        "2953 ROWAN DR  CrossStreets: ANTELOPE RD 0.19 mi E HIGHWAY 43 0.81 mi W STRUCTURE FIRE-D / RES (SINGLE) ESN: pg8 Call Number: 7",

        "ADDR:2953 ROWAN DR",
        "X:ANTELOPE RD 0.19 mi E HIGHWAY 43 0.81 mi W",
        "CALL:STRUCTURE FIRE-D / RES (SINGLE)",
        "MAP:pg8",
        "ID:7");

    doTest("T4",
        "Subject:911 CALL\n" +
        "13724 HIGHWAY 43, Apt. 30 TEEPEE MHP CrossStreets: AVALON LN 0.22 mi N LONNIE LN 0.33 mi SW STRUCTURE FIRE ESN: pg7 Call Number",

        "ADDR:13724 HIGHWAY 43,",
        "APT:30 TEEPEE MHP",
        "X:AVALON LN 0.22 mi N",
        "CALL:LONNIE LN 0.33 mi SW STRUCTURE FIRE",
        "MAP:pg7");

    doTest("T5",
        "Subject:911 CALL\n" +
        "20513 HIGHWAY Y  CrossStreets: RHINEHART LN 0.19 mi S REDBUD RD 0.62 mi N CHEST PAIN ESN: pg8 Call Number: 762218",

        "ADDR:20513 HIGHWAY Y",
        "X:RHINEHART LN 0.19 mi S REDBUD RD 0.62 mi N",
        "CALL:CHEST PAIN",
        "MAP:pg8",
        "ID:762218");

    doTest("T6",
        "Subject:911 CALL\n5369 QUINCE RD  CrossStreets: DENNISON LN 0.03 mi E CROW RD 0.71 mi W TA INJURY ESN: pg8 Call Number: 762973",
        "ADDR:5369 QUINCE RD",
        "X:DENNISON LN 0.03 mi E CROW RD 0.71 mi W",
        "CALL:TA INJURY",
        "MAP:pg8",
        "ID:762973");

    doTest("T7",
        "Subject:911 CALL\n" +
        "13724 HIGHWAY 43, Apt. 29 TEEPEE MHP CrossStreets: AVALON LN 0.22 mi N LONNIE LN 0.33 mi SW STRUCTURE FIRE-D / MH-PORTABLE OFC ",

        "ADDR:13724 HIGHWAY 43,",
        "APT:29 TEEPEE MHP",
        "X:AVALON LN 0.22 mi N",
        "CALL:LONNIE LN 0.33 mi SW STRUCTURE FIRE-D / MH-PORTABLE OFC");

    doTest("T8",
        "Subject:911 CALL\n5156 JESSICA LN  CrossStreets: CROW RD 0.31 mi W FALL ESN: pg6 Call Number: 762520",
        "ADDR:5156 JESSICA LN",
        "X:CROW RD 0.31 mi W",
        "CALL:FALL",
        "MAP:pg6",
        "ID:762520");
  }
  
  public static void main(String[] args) {
    new MONewtonCountyParserTest().generateTests("T1");
  }
}