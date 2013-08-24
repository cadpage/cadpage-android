package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Tioga County, PA
Contact: Nick Hults <hultsnm11@gmail.com>
"Dave Cohick" <dcohick@tiogacountypa.us> (Director of Emergancy Serivces)
Sender: 8145582634

TC911:21D >HEMORRHAGE / LAC - DANGER HEM 76 BAKER CREST LN XS: HICKORY RD RUTLAND TWP DONALD BAKER Map: Grids:, Cad: 2011-0000020687
TC911:MVA >MOTOR VEHICLE ACCIDENT PITTS RD XS: CANOE CAMP CREEK RD RICHMOND TWP BRANT MAXWELL Map: Grids:, Cad: 2011-0000020573
TC911:26A >SICK - NO SYMPTOMS 51 SOUTH MAIN ST MANSFIELD BORO CHERLY BLOOM Cad: 2011-0000020561
TC911:MED >MEDICAL 37 CENTRAL AVE XS: WALNUT ST WELLSBORO BORO GREEN HOME INC Map: Grids:, Cad: 2011-0000020394
TC911:6D >BREATHING PROBLEMS / SEVERE 1883 SHUMWAY HILL RD XS: ROUTE 6 CHARLESTON TWP BROAD ACRS HLTH/REHAB423 Map: Grids:, Cad: 2011-0000020675
TC911:12B >SEIZURES - NOT CURRENT NOT VER 2146 S MAIN ST XS: RICHMOND DR RICHMOND TWP GOODRICH RESIDENCE Map: Grids:, Cad: 2011-0000020612
TC911:30D >TRAUMATIC INJ - DANGEROUS 312 BRADFORD RD XS: ROUTE 6 SULLIVAN TWP JOYCE R BRADFORD-ROBERT Map: Grids:, Cad: 2011-0000020081
TC911:10D >CHEST PAIN - SEVERE SOB 55 BENEDICT LN XS: BENSON AVE ROSEVILLE BORO JAMIE KIRK Map: Grids:, Cad: 2011-0000020564
TC911:MED >MEDICAL 100 SHERWOOD MNR Apt: 219 Bldg XS: NOVELTY PL MANSFIELD BORO FORD, VIRGINIA Map: Grids:, Cad: 2011-0000020827
TC911:MED >MEDICAL 76 BAKER CREST LN XS: HICKORY RD RUTLAND TWP KRISTA Map: Grids:, Cad: 2011-0000021537
TC911:MED >MEDICAL 84 DROBERS LN RUTLAND TWP DENISE STETTLER Cad: 2011-0000032855
TC911:21D >HEMORRHAGE / LAC - DANGER HEM 76 BAKER CREST LN XS: HICKORY RD RUTLAND TWP DONALD BAKER Map: Grids:, Cad: 2011-0000020687

*/

public class PATiogaCountyParserTest extends BaseParserTest {
  
  public PATiogaCountyParserTest() {
    setParser(new PATiogaCountyParser(), "TIOGA COUNTY", "PA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "TC911:21D >HEMORRHAGE / LAC - DANGER HEM 76 BAKER CREST LN XS: HICKORY RD RUTLAND TWP DONALD BAKER Map: Grids:, Cad: 2011-0000020687",
        "CALL:HEMORRHAGE / LAC - DANGER HEM",
        "ADDR:76 BAKER CREST LN",
        "X:HICKORY RD",
        "CITY:RUTLAND TWP",
        "NAME:DONALD BAKER",
        "ID:2011-0000020687");

    doTest("T2",
        "TC911:MVA >MOTOR VEHICLE ACCIDENT PITTS RD XS: CANOE CAMP CREEK RD RICHMOND TWP BRANT MAXWELL Map: Grids:, Cad: 2011-0000020573",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "ADDR:PITTS RD",
        "MADDR:PITTS RD & CANOE CAMP CREEK RD",
        "X:CANOE CAMP CREEK RD",
        "CITY:RICHMOND TWP",
        "NAME:BRANT MAXWELL",
        "ID:2011-0000020573");

    doTest("T3",
        "TC911:26A >SICK - NO SYMPTOMS 51 SOUTH MAIN ST MANSFIELD BORO CHERLY BLOOM Cad: 2011-0000020561",
        "CALL:SICK - NO SYMPTOMS",
        "ADDR:51 SOUTH MAIN ST",
        "CITY:MANSFIELD",
        "NAME:CHERLY BLOOM",
        "ID:2011-0000020561");

    doTest("T4",
        "TC911:MED >MEDICAL 37 CENTRAL AVE XS: WALNUT ST WELLSBORO BORO GREEN HOME INC Map: Grids:, Cad: 2011-0000020394",
        "CALL:MEDICAL",
        "ADDR:37 CENTRAL AVE",
        "X:WALNUT ST",
        "CITY:WELLSBORO",
        "NAME:GREEN HOME INC",
        "ID:2011-0000020394");

    doTest("T5",
        "TC911:6D >BREATHING PROBLEMS / SEVERE 1883 SHUMWAY HILL RD XS: ROUTE 6 CHARLESTON TWP BROAD ACRS HLTH/REHAB423 Map: Grids:, Cad: 2011-0000020675",
        "CALL:BREATHING PROBLEMS / SEVERE",
        "ADDR:1883 SHUMWAY HILL RD",
        "X:ROUTE 6",
        "CITY:CHARLESTON TWP",
        "NAME:BROAD ACRS HLTH/REHAB423",
        "ID:2011-0000020675");

    doTest("T6",
        "TC911:12B >SEIZURES - NOT CURRENT NOT VER 2146 S MAIN ST XS: RICHMOND DR RICHMOND TWP GOODRICH RESIDENCE Map: Grids:, Cad: 2011-0000020612",
        "CALL:SEIZURES - NOT CURRENT NOT VER",
        "ADDR:2146 S MAIN ST",
        "X:RICHMOND DR",
        "CITY:RICHMOND TWP",
        "NAME:GOODRICH RESIDENCE",
        "ID:2011-0000020612");

    doTest("T7",
        "TC911:30D >TRAUMATIC INJ - DANGEROUS 312 BRADFORD RD XS: ROUTE 6 SULLIVAN TWP JOYCE R BRADFORD-ROBERT Map: Grids:, Cad: 2011-0000020081",
        "CALL:TRAUMATIC INJ - DANGEROUS",
        "ADDR:312 BRADFORD RD",
        "X:ROUTE 6",
        "CITY:SULLIVAN TWP",
        "NAME:JOYCE R BRADFORD-ROBERT",
        "ID:2011-0000020081");

    doTest("T8",
        "TC911:10D >CHEST PAIN - SEVERE SOB 55 BENEDICT LN XS: BENSON AVE ROSEVILLE BORO JAMIE KIRK Map: Grids:, Cad: 2011-0000020564",
        "CALL:CHEST PAIN - SEVERE SOB",
        "ADDR:55 BENEDICT LN",
        "X:BENSON AVE",
        "CITY:ROSEVILLE",
        "NAME:JAMIE KIRK",
        "ID:2011-0000020564");

    doTest("T9",
        "TC911:MED >MEDICAL 100 SHERWOOD MNR Apt: 219 Bldg XS: NOVELTY PL MANSFIELD BORO FORD, VIRGINIA Map: Grids:, Cad: 2011-0000020827",
        "CALL:MEDICAL",
        "ADDR:100 SHERWOOD MNR",
        "APT:219 Bldg",
        "X:NOVELTY PL",
        "CITY:MANSFIELD",
        "NAME:FORD, VIRGINIA",
        "ID:2011-0000020827");

    doTest("T10",
        "TC911:MED >MEDICAL 76 BAKER CREST LN XS: HICKORY RD RUTLAND TWP KRISTA Map: Grids:, Cad: 2011-0000021537",
        "CALL:MEDICAL",
        "ADDR:76 BAKER CREST LN",
        "X:HICKORY RD",
        "CITY:RUTLAND TWP",
        "NAME:KRISTA",
        "ID:2011-0000021537");

    doTest("T11",
        "TC911:MED >MEDICAL 84 DROBERS LN RUTLAND TWP DENISE STETTLER Cad: 2011-0000032855",
        "CALL:MEDICAL",
        "ADDR:84 DROBERS LN",
        "CITY:RUTLAND TWP",
        "NAME:DENISE STETTLER",
        "ID:2011-0000032855");

    doTest("T12",
        "TC911:21D >HEMORRHAGE / LAC - DANGER HEM 76 BAKER CREST LN XS: HICKORY RD RUTLAND TWP DONALD BAKER Map: Grids:, Cad: 2011-0000020687",
        "CALL:HEMORRHAGE / LAC - DANGER HEM",
        "ADDR:76 BAKER CREST LN",
        "X:HICKORY RD",
        "CITY:RUTLAND TWP",
        "NAME:DONALD BAKER",
        "ID:2011-0000020687");

 }
  
  public static void main(String[] args) {
    new PATiogaCountyParserTest().generateTests("T1");
  }
}
