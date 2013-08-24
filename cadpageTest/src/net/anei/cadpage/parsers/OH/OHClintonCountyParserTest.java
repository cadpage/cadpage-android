package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Clinton County, OH
Contact: Kieth (kieth4548@gmail.com)
Sender: noreply@clintonsheriff.com.

Structure Fire, 2408 CLARK RD NEW VIENNA, REKINDLED FIRE, SR 350 E,NEW VIENNA//THORNBURG RD,NEW VIENNA
FIRE, 12308 CAREYTOWN RD , 1231297, TOP OF A UTILITY POLE ON FIRE , SCISSORVILLE RD,LEESBURG//
FIRE, 6989 FARMERS RD MARTINSVILLE, 1231135, TRAILOR ON FIRE NOBODY INSIDE, RAPID FORD RD,MARTINSVILLE//SR 28 E,MARTINSVILLE
ATTEMPTED SUICIDE, 270 BERNARD RD NEW VIENNA, 1229348, MALE SUBJECT TALKING OUT OF HIS HEAD HES ADVISING HE CALLED THE MENTAL HEALTH PLACE ALREADY, HUFFM

 */
public class OHClintonCountyParserTest extends BaseParserTest {
  
  public OHClintonCountyParserTest() {
    setParser(new OHClintonCountyParser(), "CLINTON COUNTY", "OH");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Structure Fire, 2408 CLARK RD NEW VIENNA, REKINDLED FIRE, SR 350 E,NEW VIENNA//THORNBURG RD,NEW VIENNA",
        "CALL:Structure Fire",
        "ADDR:2408 CLARK RD",
        "CITY:NEW VIENNA",
        "INFO:REKINDLED FIRE",
        "X:SR 350 E & THORNBURG RD");

    doTest("T2",
        "FIRE, 12308 CAREYTOWN RD , 1231297, TOP OF A UTILITY POLE ON FIRE , SCISSORVILLE RD,LEESBURG//",
        "CALL:FIRE",
        "ADDR:12308 CAREYTOWN RD",
        "CITY:LEESBURG",
        "PHONE:1231297",
        "INFO:TOP OF A UTILITY POLE ON FIRE",
        "X:SCISSORVILLE RD");

    doTest("T3",
        "FIRE, 6989 FARMERS RD MARTINSVILLE, 1231135, TRAILOR ON FIRE NOBODY INSIDE, RAPID FORD RD,MARTINSVILLE//SR 28 E,MARTINSVILLE",
        "CALL:FIRE",
        "ADDR:6989 FARMERS RD",
        "CITY:MARTINSVILLE",
        "PHONE:1231135",
        "INFO:TRAILOR ON FIRE NOBODY INSIDE",
        "X:RAPID FORD RD & SR 28 E");

    doTest("T4",
        "ATTEMPTED SUICIDE, 270 BERNARD RD NEW VIENNA, 1229348, MALE SUBJECT TALKING OUT OF HIS HEAD HES ADVISING HE CALLED THE MENTAL HEALTH PLACE ALREADY, HUFFM",
        "CALL:ATTEMPTED SUICIDE",
        "ADDR:270 BERNARD RD",
        "CITY:NEW VIENNA",
        "PHONE:1229348",
        "INFO:MALE SUBJECT TALKING OUT OF HIS HEAD HES ADVISING HE CALLED THE MENTAL HEALTH PLACE ALREADY",
        "X:HUFFM");

  }
  
  public static void main(String[] args) {
    new OHClintonCountyParserTest().generateTests("T1");
  }
}