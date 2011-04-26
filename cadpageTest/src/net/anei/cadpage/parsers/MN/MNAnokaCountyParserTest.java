package net.anei.cadpage.parsers.MN;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.MN.MNAnokaCountyParser;

import org.junit.Test;


public class MNAnokaCountyParserTest extends BaseParserTest {
  
  public MNAnokaCountyParserTest() {
    setParser(new MNAnokaCountyParser(), "ANOKA COUNTY", "MN");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "CAD MSG: *D A3   57       HANSON BLVD NW / ANDOVER BLVD NW  NE CORNER..SMOKE/CHARRED GRASS...SM FLAMES INC:10019729   [42]",
        "CALL:*D A3   57",
        "ADDR:HANSON BLVD NW & ANDOVER BLVD NW",
        "INFO:NE CORNER..SMOKE/CHARRED GRASS...SM FLAMES",
        "ID:10019729");
    
    doTest("T2",
        "CAD MSG: *D A3   39F      17844 XEON ST NW  FIRE ALARM... SMOKE OR HEAT UPSTAIRS OR IN GARAGE... SMALL DOG ONSITE INC:10019638",
        "CALL:*D A3   39F",
        "ADDR:17844 XEON ST NW",
        "INFO:FIRE ALARM... SMOKE OR HEAT UPSTAIRS OR IN GARAGE... SMALL DOG ONSITE",
        "ID:10019638");
    
    doTest("T3",
        "CAD MSG: *D A3   45F      14950 HANSON BLVD NW @ANDOVER ELEMENTARY  PLANNED FIRE DRILL AT 1330 ... WILL CALL BACK WHEN COMPLETE INC:10019627",
        "CALL:*D A3   45F",
        "ADDR:14950 HANSON BLVD NW",
        "PLACE:ANDOVER ELEMENTARY",
        "INFO:PLANNED FIRE DRILL AT 1330 ... WILL CALL BACK WHEN COMPLETE",
        "ID:10019627");
    
    doTest("T4",
        "CAD MSG: *D A3   57       A FIRE DEPT 3 @15929 CROSSTOWN BLVD NW  ** ILLEGAL BURN * IN MILLER WOODS THE NEW DEVELOPMENT INC:10019583",
        "CALL:*D A3   57",
        "PLACE:A FIRE DEPT 3",
        "ADDR:15929 CROSSTOWN BLVD NW",
        "INFO:** ILLEGAL BURN * IN MILLER WOODS THE NEW DEVELOPMENT",
        "ID:10019583");
    
    doTest("T5",
        "CAD MSG: *D A3   32R      YMCA @15200 HANSON BLVD NW  ** SKATEBOARD PARK * 7 YO FE * FELL FRM A ACTIVITY BARS * DID LOOSE CONC IS CONC NOW * DIFF BREATHING AMB",
        "CALL:*D A3   32R",
        "PLACE:YMCA",
        "ADDR:15200 HANSON BLVD NW",
        "INFO:** SKATEBOARD PARK * 7 YO FE * FELL FRM A ACTIVITY BARS * DID LOOSE CONC IS CONC NOW * DIFF BREATHING AMB");
    
    doTest("T6",
        "CAD MSG: *D A1   59       RR TRACKS / BUNKER LAKE BLVD NW  PD ACCIDENT/BLOCKING/NEED SGT TO RESPOND ALSO / FIRE RTN FOR WASH DOWN INC:10019310",
        "CALL:*D A1   59",
        "ADDR:RR TRACKS & BUNKER LAKE BLVD NW",
        "INFO:PD ACCIDENT/BLOCKING/NEED SGT TO RESPOND ALSO / FIRE RTN FOR WASH DOWN",
        "ID:10019310");
    
    doTest("T7",
        "CAD MSG: *D A2   56       CO7 NW / CO58 NW  STRONG GAS ODOR IN THE AREA INC:10019278",
        "CALL:*D A2   56",
        "ADDR:CO-7 NW & CO-58 NW",
        "INFO:STRONG GAS ODOR IN THE AREA",
        "ID:10019278");
    
    doTest("T8",
        "CAD MSG: *D A1   51       14015 DRAKE ST NW  POSS FIRE IN THE WALL...LOTS OF SMOKE FROM THE BASEMENT...EVERYONE ISOUT INC:10019127",
        "CALL:*D A1   51",
        "ADDR:14015 DRAKE ST NW",
        "INFO:POSS FIRE IN THE WALL...LOTS OF SMOKE FROM THE BASEMENT...EVERYONE ISOUT",
        "ID:10019127");

    doTest("T9",
        "CAD MSG: *D D4   32M      3254 90 LN NE  LIFT ASSIST ONLY...LARGE MALE (300+) INC:11007548\n",
        "CALL:*D D4   32M",
        "ADDR:3254 90 LN",
        "INFO:NE  LIFT ASSIST ONLYLARGE MALE (300+)",
        "ID:11007548");
        
  }
  
  public static void main(String[] args) {
    new MNAnokaCountyParserTest().generateTests("T9", "CALL ADDR PLACE INFO ID");
  }
}
