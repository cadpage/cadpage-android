package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NCGreensboroParserTest extends BaseParserTest {
  
  public NCGreensboroParserTest() {
    setParser(new NCGreensboroParser(), "GREENSBORO", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "388:CAD@greensboro-nc.gov:CAD:FYI: ;1137919;CARDIAC / RESPIRATORY ARREST;1202 BILBRO ST;W WHITTINGTON ST;IRELAND ST;09E01",
        "ID:1137919",
        "CALL:CARDIAC / RESPIRATORY ARREST",
        "ADDR:1202 BILBRO ST",
        "X:W WHITTINGTON ST & IRELAND ST",
        "CODE:09E01");

    doTest("T2",
        "397:CAD@greensboro-nc.gov:CAD:1138157;STAB / GUNSHOT WOUND;707 W FLORIDA ST;DIST: 25.68 FT;HUDGINS DR;HUDGINS DR;27D01G;SMITH HOMES",
        "ID:1138157",
        "CALL:STAB / GUNSHOT WOUND",
        "ADDR:707 W FLORIDA ST",
        "INFO:DIST: 25.68 FT",
        "X:HUDGINS DR & HUDGINS DR",
        "CODE:27D01G",
        "PLACE:SMITH HOMES");

    doTest("T3",
        "392:CAD@greensboro-nc.gov:CAD:FYI: ;1138044;CARDIAC / RESPIRATORY ARREST;827 GARDENGATE RD;WOODEDGE DR;09E02",
        "ID:1138044",
        "CALL:CARDIAC / RESPIRATORY ARREST",
        "ADDR:827 GARDENGATE RD",
        "X:WOODEDGE DR",
        "CODE:09E02");

    doTest("T4",
        "400:CAD@greensboro-nc.gov:CAD:1138253;BREATHING PROBLEMS;1515 WOODMERE DR;APT L;TEXTILE DR;PHILLIPS AV;06D02",
        "ID:1138253",
        "CALL:BREATHING PROBLEMS",
        "ADDR:1515 WOODMERE DR",
        "APT:L",
        "X:TEXTILE DR & PHILLIPS AV",
        "CODE:06D02");

    doTest("T5",
        "393:CAD@greensboro-nc.gov:CAD:1138092;ACCIDENT WITH PERSONAL INJURY;E CONE BLVD/CHESHIRE WAY;DIST: 32.08 FT;29D02p",
        "ID:1138092",
        "CALL:ACCIDENT WITH PERSONAL INJURY",
        "ADDR:E CONE BLVD & CHESHIRE WAY",
        "INFO:DIST: 32.08 FT",
        "CODE:29D02p");

    doTest("T6",
        "395:CAD@greensboro-nc.gov:CAD:1138115;ACCIDENT WITH PERSONAL INJURY;2615 HIGH POINT RD;MAYWOOD ST;W FLORIDA ST;SUNSET CLEANERS",
        "ID:1138115",
        "CALL:ACCIDENT WITH PERSONAL INJURY",
        "ADDR:2615 HIGH POINT RD",
        "X:MAYWOOD ST & W FLORIDA ST",
        "PLACE:SUNSET CLEANERS");
 }
  

  public static void main(String[] args) {
    new NCGreensboroParserTest().generateTests("T1");
  }
}
