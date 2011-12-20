package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.VA.VACampbellCountyParser;

import org.junit.Test;


public class VACampbellCountyParserTest extends BaseParserTest {
  
  public VACampbellCountyParserTest() {
    setParser(new VACampbellCountyParser(), "CAMPBELL COUNTY", "VA");
  }
  
  @Test
  public void testParser() {
    doTest("T1",
        "MAILBOX:SQ02 MVC/MOTOR VEHICLE CRASH/ACCIDE 002364 WATERLICK RD/LEESVILLE RD CFS# 2010-061119 REF TO A 3 CAR MVA. AT FIRST A REPORT OF NO PI. NO NEED FOR FIRE. VASI ADV THAT T" ,
        "SRC:SQ02",
        "CALL:MVC/MOTOR VEHICLE CRASH/ACCIDE",
        "ADDR:002364 WATERLICK RD & LEESVILLE RD",
        "MADDR:002364 WATERLICK RD",
        "ID:2010-061119",
        "INFO:REF TO A 3 CAR MVA. AT FIRST A REPORT OF NO PI. NO NEED FOR FIRE. VASI ADV THAT T"
        );
    doTest("T2",
        "MAILBOX:SQ02 (3)ACCIDENT 021400 TIMBERLAKE RD CFS# 2010-061105 2 CAR MVA. WITH ENTRAPMENT",
        "SRC:SQ02",
        "CALL:(3)ACCIDENT",
        "ADDR:021400 TIMBERLAKE RD",
        "ID:2010-061105",
        "INFO:2 CAR MVA. WITH ENTRAPMENT"
      );
    doTest("T3",
        "MAILBOX:SQ02 STABBING 005450 COLONIAL HWY EVI CFS# 2010-061047 STAGE IN THE AREA, DO NOT GO TO THE SCENE",
        "SRC:SQ02",
        "CALL:STABBING",
        "ADDR:005450 COLONIAL HWY",
        "ID:2010-061047",
        "INFO:STAGE IN THE AREA, DO NOT GO TO THE SCENE"
      );
    doTest("T4",
        "MAILBOX:SQ02 UNRESPONSIVE 000218 LAKE FOREST DR CFS# 2010-060825",
        "SRC:SQ02",
        "CALL:UNRESPONSIVE",
        "ADDR:000218 LAKE FOREST DR",
        "ID:2010-060825"
      );
    doTest("T5",
        "MAILBOX:SQ02 HANGUP 911 000381 HORIZON DR CFS# 2010-060777 FEMALE ADVISED SOMETHING ABOUT THE RESCUE SQ. LINE DISCONNECTED",
        "SRC:SQ02",
        "CALL:HANGUP 911",
        "ADDR:000381 HORIZON DR",
        "ID:2010-060777",
        "INFO:FEMALE ADVISED SOMETHING ABOUT THE RESCUE SQ. LINE DISCONNECTED");

    doTest("T6",
        "MAILBOX:CO12 BRUSH/FIELD FIRE 000175 WOODHAVEN DR CFS# 2011-024304",
        "SRC:CO12",
        "CALL:BRUSH/FIELD FIRE",
        "ADDR:000175 WOODHAVEN DR",
        "ID:2011-024304");

    doTest("T7",
        "S: M:MAILBOX:CO13 POWER IN GENERATOR @FIRE STATION IS OUT. DOORS HAVE TO BE OPENED MANUALLY PER CHIEF 13\n",
        "SRC:CO13",
        "CALL:POWER IN GENERATOR",
        "ADDR:FIRE STATION IS OUT DOORS HAVE TO BE OPENED MANUALLY PER CHIEF 13");
  }
  
  public static void main(String[] args) {
    new VACampbellCountyParserTest().generateTests("T1", "SRC CALL CITY ADDR ID INFO");
  }
}
  