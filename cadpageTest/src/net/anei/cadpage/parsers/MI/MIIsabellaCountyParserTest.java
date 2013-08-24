package net.anei.cadpage.parsers.MI;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


/*
Isabella County, MI
Contact: Ryan Guthrie <ryan@livewithunited.com>
Sender: cad@isabellacounty.org

CAD:FYI: ;AMBULANCE;402 W REMUS RD;MP;FITCH DR;S MERIDIAN RD;chest pains [12/13/12 21:20:21 HADLEY] m-65 / hx heart / diff brthing [12/13/12 21:20:07 HADLEY]
CAD:FYI: ;INJURY ACCIDENT;1999 S WINN RD/W PICKARD RD;MP
CAD:FYI: ;AMBULANCE;2095 S NOTTAWA RD;MP;W PICKARD RD;W BROADWAY RD;77 y/o male, copd pt, diff breathing. [12/03/12 04:32:07 RMARTIN]
CAD:CANCEL;2560 S NOTTAWA RD; MP
CAD:FYI: ;SUICIDE INCLUDING ATTEMPTS;2560 S NOTTAWA RD;MP;W BROADWAY RD;suicidal male subject, richard anthony szott. [11/30/12 20:00:18 DRAPER]

Agency name: Fremont Township Fire  Rescue
Location: Winn, MI, United States
Contact: Active911

CAD:FYI: ;SUICIDE INCLUDING ATTEMPTS;346 COACHMAN DR;MP;FOUR SQUARE DR;17/f took pills, is alert [12/20/12 16:28:04 AKING]
CAD:FYI: ;AMBULANCE;3570 S WINN RD;MP;W REMUS RD;W BROOMFIELD RD;f-62 / was choking on chicken - did dislodge it to the point of being able to brth but is st
CAD:FYI: ;SUICIDE INCLUDING ATTEMPTS;2560 S NOTTAWA RD;MP;W BROADWAY RD;suicidal male subject, richard anthony szott. [11/30/12 20:00:18 DRAPER]
CAD:FYI: ;AMBULANCE;2095 S NOTTAWA RD;MP;W PICKARD RD;W BROADWAY RD;77 y/o male, copd pt, diff breathing. [12/03/12 04:32:07 RMARTIN]

*/

public class MIIsabellaCountyParserTest extends BaseParserTest {
  
  public MIIsabellaCountyParserTest() {
	  setParser(new MIIsabellaCountyParser(), "ISABELLA COUNTY", "MI");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "CAD:FYI: ;AMBULANCE;402 W REMUS RD;MP;FITCH DR;S MERIDIAN RD;chest pains [12/13/12 21:20:21 HADLEY] m-65 / hx heart / diff brthing [12/13/12 21:20:07 HADLEY]",
        "CALL:AMBULANCE",
        "ADDR:402 W REMUS RD",
        "CITY:MT PLEASANT",
        "X:FITCH DR & S MERIDIAN RD",
        "INFO:chest pains / m-65 / hx heart / diff brthing",
        "DATE:12/13/12",
        "TIME:21:20:21");

    doTest("T2",
        "CAD:FYI: ;INJURY ACCIDENT;1999 S WINN RD/W PICKARD RD;MP",
        "CALL:INJURY ACCIDENT",
        "ADDR:1999 S WINN RD & W PICKARD RD",
        "MADDR:1999 S WINN RD",
        "CITY:MT PLEASANT");

    doTest("T3",
        "CAD:FYI: ;AMBULANCE;2095 S NOTTAWA RD;MP;W PICKARD RD;W BROADWAY RD;77 y/o male, copd pt, diff breathing. [12/03/12 04:32:07 RMARTIN]",
        "CALL:AMBULANCE",
        "ADDR:2095 S NOTTAWA RD",
        "CITY:MT PLEASANT",
        "X:W PICKARD RD & W BROADWAY RD",
        "INFO:77 y/o male, copd pt, diff breathing.",
        "DATE:12/03/12",
        "TIME:04:32:07");

    doTest("T4",
        "CAD:CANCEL;2560 S NOTTAWA RD; MP",
        "CALL:CANCEL",
        "ADDR:2560 S NOTTAWA RD",
        "CITY:MT PLEASANT");

    doTest("T5",
        "CAD:FYI: ;SUICIDE INCLUDING ATTEMPTS;2560 S NOTTAWA RD;MP;W BROADWAY RD;suicidal male subject, richard anthony szott. [11/30/12 20:00:18 DRAPER]",
        "CALL:SUICIDE INCLUDING ATTEMPTS",
        "ADDR:2560 S NOTTAWA RD",
        "CITY:MT PLEASANT",
        "X:W BROADWAY RD",
        "INFO:suicidal male subject, richard anthony szott.",
        "DATE:11/30/12",
        "TIME:20:00:18");

  }
  
  @Test
  public void testFremontTwpFire() {

    doTest("T1",
        "CAD:FYI: ;SUICIDE INCLUDING ATTEMPTS;346 COACHMAN DR;MP;FOUR SQUARE DR;17/f took pills, is alert [12/20/12 16:28:04 AKING]",
        "CALL:SUICIDE INCLUDING ATTEMPTS",
        "ADDR:346 COACHMAN DR",
        "CITY:MT PLEASANT",
        "X:FOUR SQUARE DR",
        "INFO:17/f took pills, is alert",
        "DATE:12/20/12",
        "TIME:16:28:04");

    doTest("T2",
        "CAD:FYI: ;AMBULANCE;3570 S WINN RD;MP;W REMUS RD;W BROOMFIELD RD;f-62 / was choking on chicken - did dislodge it to the point of being able to brth but is st",
        "CALL:AMBULANCE",
        "ADDR:3570 S WINN RD",
        "CITY:MT PLEASANT",
        "X:W REMUS RD & W BROOMFIELD RD",
        "INFO:f-62 / was choking on chicken - did dislodge it to the point of being able to brth but is st");

    doTest("T3",
        "CAD:FYI: ;SUICIDE INCLUDING ATTEMPTS;2560 S NOTTAWA RD;MP;W BROADWAY RD;suicidal male subject, richard anthony szott. [11/30/12 20:00:18 DRAPER]",
        "CALL:SUICIDE INCLUDING ATTEMPTS",
        "ADDR:2560 S NOTTAWA RD",
        "CITY:MT PLEASANT",
        "X:W BROADWAY RD",
        "INFO:suicidal male subject, richard anthony szott.",
        "DATE:11/30/12",
        "TIME:20:00:18");

    doTest("T4",
        "CAD:FYI: ;AMBULANCE;2095 S NOTTAWA RD;MP;W PICKARD RD;W BROADWAY RD;77 y/o male, copd pt, diff breathing. [12/03/12 04:32:07 RMARTIN]",
        "CALL:AMBULANCE",
        "ADDR:2095 S NOTTAWA RD",
        "CITY:MT PLEASANT",
        "X:W PICKARD RD & W BROADWAY RD",
        "INFO:77 y/o male, copd pt, diff breathing.",
        "DATE:12/03/12",
        "TIME:04:32:07");
   
  }
  
  public static void main(String[] args) {
    new MIIsabellaCountyParserTest().generateTests("T1");
  }
}
