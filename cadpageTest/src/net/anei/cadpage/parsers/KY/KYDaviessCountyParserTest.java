package net.anei.cadpage.parsers.KY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class KYDaviessCountyParserTest extends BaseParserTest {
  
  public KYDaviessCountyParserTest() {
    setParser(new KYDaviessCountyParser(), "DAVIESS COUNTY", "KY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "911-CENTER:MBD >BREATHING DIFFICULTY 6261 MILLERS MILL RD XS: HIGHWAY 142 PHILPOT MARTIN Map: Grids:, Cad: 2011-0000013315",
        "CALL:BREATHING DIFFICULTY",
        "ADDR:6261 MILLERS MILL RD",
        "X:HIGHWAY 142",
        "NAME:PHILPOT MARTIN",
        "ID:2011-0000013315");

    doTest("T2",
        "911-CENTER:ACCINJ>ACCIDENT WITH INJURIES 3970 CRANE POND RD XS: U S HIGHWAY 231 PHILPOT JOHNS, AMY Map: Grids:, Cad: 2011-0000013291",
        "CALL:ACCIDENT WITH INJURIES",
        "ADDR:3970 CRANE POND RD",
        "X:U S HIGHWAY 231",
        "NAME:PHILPOT JOHNS, AMY",
        "ID:2011-0000013291");

    doTest("T3",
        "911-CENTER:FF >WILDLAND FIRE 9707 OLD HARTFORD RD XS: U S HIGHWAY 231 UTICA KIPLING, ED Map: Grids:, Cad: 2011-0000013076",
        "CALL:WILDLAND FIRE",
        "ADDR:9707 OLD HARTFORD RD",
        "X:U S HIGHWAY 231",
        "NAME:UTICA KIPLING, ED",
        "ID:2011-0000013076");

    doTest("T4",
        "911-CENTER:FF >WILDLAND FIRE 12957 RED HILL-MAXWELL RD XS: E HARMONS FERRY RD UTICA PRESSON, DAVID Map: Grids:, Cad: 2011-0000012778",
        "CALL:WILDLAND FIRE",
        "ADDR:12957 RED HILL-MAXWELL RD",
        "X:E HARMONS FERRY RD",
        "NAME:UTICA PRESSON, DAVID",
        "ID:2011-0000012778");

    doTest("T8",
        "911-CENTER:MPD >UNKNOWN/PERSON DOWN 4255 NEW HARTFORD RD XS: NEAR SOUTHEASTERN PKY OWENSBORO DAVIESS COUNTY BOARD OF EDUCAT Map: Grids:, Cad: 2011-0000013349",
        "CALL:UNKNOWN/PERSON DOWN",
        "ADDR:4255 NEW HARTFORD RD",
        "NAME:XS: NEAR SOUTHEASTERN PKY OWENSBORO DAVIESS COUNTY BOARD OF EDUCAT",
        "ID:2011-0000013349");

    doTest("T9",
        "911-CENTER:FF >WILDLAND FIRE 2324 HARRIET LN XS: OLD HARTFORD RD OWENSBORO HUTCHINSON, G & M Map: Grids:, Cad: 2011-0000013387",
        "CALL:WILDLAND FIRE",
        "ADDR:2324 HARRIET LN",
        "X:OLD HARTFORD RD",
        "NAME:OWENSBORO HUTCHINSON, G & M",
        "ID:2011-0000013387");

    doTest("T10",
        "911-CENTER:MSTR >STROKE 3294 BELLTOWN RD XS: NEW BETHEL CHURCH LN HARTFORD Map: Grids:, Cad: 2011-0000013576",
        "CALL:STROKE",
        "ADDR:3294 BELLTOWN RD",
        "X:NEW BETHEL CHURCH LN",
        "NAME:HARTFORD",
        "ID:2011-0000013576");

    doTest("T11",
        "911-CENTER:MSZ >SEIZURES 4255 NEW HARTFORD RD XS: NEAR SOUTHEASTERN PKY OWENSBORO DAY, RUS Map: Grids:, Cad: 2011-0000013611",
        "CALL:SEIZURES",
        "ADDR:4255 NEW HARTFORD RD",
        "X:NEAR SOUTHEASTERN PKY",
        "NAME:OWENSBORO DAY, RUS",
        "ID:2011-0000013611");
  }
  
  public static void main(String[] args) {
    new KYDaviessCountyParserTest().generateTests("T1", "CALL ADDR X NAME ID");
  }
}