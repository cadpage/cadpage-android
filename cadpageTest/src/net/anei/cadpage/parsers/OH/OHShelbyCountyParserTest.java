package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class OHShelbyCountyParserTest extends BaseParserTest {
  
  public OHShelbyCountyParserTest() {
    setParser(new OHShelbyCountyParser(), "SHELBY COUNTY", "OH");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "11-005105|28 - DRO|CAR CRASHED INTO WATER@11 WATER ST",
        "ID:11-005105",
        "CALL:28 - DRO",
        "INFO:CAR CRASHED INTO WATER",
        "ADDR:11 WATER ST");

    doTest("T2",
        "11-008684|11:09:00|:28 - SF|MICROWAVE ON FIRE @ 301 ELIZABETH ST RUSSIA BETW FIRST ST & CUL DE SAC|PHLIPOT",
        "ID:11-008684",
        "CALL:28 - SF",
        "INFO:MICROWAVE ON FIRE",
        "ADDR:301 ELIZABETH ST",
        "CITY:RUSSIA",
        "X:FIRST ST & CUL DE SAC",
        "NAME:PHLIPOT");

    doTest("T3",
        "11-008838|05:35:00|:28 - MIS|UKNOWN TYPE FIRE ON EAST SIDE OF ROAD NORTH OF CARDO NEAR LOY RD @ 8000-B SR 66 FT LORAMIE BETW LOY RD & BASINBURG RD|",
        "ID:11-008838",
        "CALL:28 - MIS",
        "INFO:UKNOWN TYPE FIRE ON EAST SIDE OF ROAD NORTH OF CARDO NEAR LOY RD",
        "ADDR:8000-B SR 66",
        "MADDR:8000 SR 66",
        "CITY:FT LORAMIE",
        "X:LOY RD & BASINBURG RD");

    doTest("T4",
        "11-009441|21:37:00|:29 - EMS|ELDERLY FEMALE FALL VICTIM  NO INJURY NEEDS HELP  GETTING UP @ 7533 HOYING RD ANNA BETW WRIGHT PUTHOFF RD & THAMAN RD|PLAS",
        "ID:11-009441",
        "CALL:29 - EMS",
        "INFO:ELDERLY FEMALE FALL VICTIM  NO INJURY NEEDS HELP  GETTING UP",
        "ADDR:7533 HOYING RD",
        "CITY:ANNA",
        "X:WRIGHT PUTHOFF RD & THAMAN RD",
        "NAME:PLAS");

    doTest("T5",
        "11-009690|05:32:00|:58 - EMS|SHOT HIMSELF IN THE HEAD, HE IS GONE @ 18590 SR 29 NEW KNOXVILLE BETW BOTKINS RD & WIERWILLE RD|",
        "ID:11-009690",
        "CALL:58 - EMS",
        "INFO:SHOT HIMSELF IN THE HEAD, HE IS GONE",
        "ADDR:18590 SR 29",
        "CITY:NEW KNOXVILLE",
        "X:BOTKINS RD & WIERWILLE RD");

    doTest("T6",
        "11-009558|23:34:00|:29 - EMS|FEMALE WITH AN ALLERGIC REACTION @ 202 S VANDEMARK RD SIDNEY BETW SHAWNEE DR & APACHE DR|SAUNDERS",
        "ID:11-009558",
        "CALL:29 - EMS",
        "INFO:FEMALE WITH AN ALLERGIC REACTION",
        "ADDR:202 S VANDEMARK RD",
        "CITY:SIDNEY",
        "X:SHAWNEE DR & APACHE DR",
        "NAME:SAUNDERS");
     
  }
  
  public static void main(String[] args) {
    new OHShelbyCountyParserTest().generateTests("T1");
  }
}