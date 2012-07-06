package net.anei.cadpage.parsers.MI;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class MIMontcalmCountyParserTest extends BaseParserTest {
  
  public MIMontcalmCountyParserTest() {
	  setParser(new MIMontcalmCountyParser(), "MONTCALM COUNTY", "MI");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "CAD:FYI: ;06/22/2012 01:39:53;4566 S GREENVILLE RD;Event spawned from STRUCTURE FIRE. [06/22/2012 01:38:55 TMORTENSEN]",
        "DATE:06/22/2012",
        "TIME:01:39:53",
        "ADDR:4566 S GREENVILLE RD",
        "CALL:STRUCTURE FIRE.");

    doTest("T2",
        "CAD:FYI: ;06/29/2012 14:52:54;215 N STATE ST;wire across the roadway [06/29/12 14:53:21 AHIRKAWAY]    ",
        "DATE:06/29/2012",
        "TIME:14:52:54",
        "ADDR:215 N STATE ST",
        "CALL:wire across the roadway");

    doTest("T3",
        "CAD:Update: ;06/29/2012 14:52:54;300 N STATE ST;PHONE AND CABLE WIRES, TIRED OFF [06/29/12 15:10:51 JJOURDAN] wire across the roadway [06/29/12 14:53:21 AHIRKAWAY]",
        "DATE:06/29/2012",
        "TIME:14:52:54",
        "ADDR:300 N STATE ST",
        "CALL:PHONE AND CABLE WIRES, TIRED OFF",
        "INFO:wire across the roadway");

    doTest("T4",
        "CAD:FYI: ;07/03/2012 18:09:20;N LINCOLN ST/E DAY ST;LINE HANGING LOW - POLE TO HOUSE [07/03/12 18:10:19 MROSE] In the city of stanton mi.",
        "DATE:07/03/2012",
        "TIME:18:09:20",
        "ADDR:N LINCOLN ST & E DAY ST",
        "CALL:LINE HANGING LOW - POLE TO HOUSE",
        "INFO:In the city of stanton mi.");

    doTest("T5",
        "CAD:FYI: ;07/05/2012 02:30:55;3720 EAST SHORE DR;POWER LINES DOWN-NO POWER IN THE AREA [07/05/12 02:32:30 TLARSON]",
        "DATE:07/05/2012",
        "TIME:02:30:55",
        "ADDR:3720 EAST SHORE DR",
        "CALL:POWER LINES DOWN-NO POWER IN THE AREA");

    doTest("T6",
        "CAD:FYI: ;07/05/2012 02:36:07;96 W EVERGREEN RD;POWER LINES ARCING AND SPARKING [07/05/12 02:38:06 TLARSON]",
        "DATE:07/05/2012",
        "TIME:02:36:07",
        "ADDR:96 W EVERGREEN RD",
        "CALL:POWER LINES ARCING AND SPARKING");

    doTest("T7",
        "CAD:FYI: ;07/05/2012 03:05:45;S STAINES RD/E SIDNEY RD;POWER LINES DOWN IN THE ROADWAY NORTH OF INTERSECTION [07/05/12 03:06:40 TMORTENSEN]",
        "DATE:07/05/2012",
        "TIME:03:05:45",
        "ADDR:S STAINES RD & E SIDNEY RD",
        "CALL:POWER LINES DOWN IN THE ROADWAY NORTH OF INTERSECTION");

    doTest("T8",
        "CAD:FYI: ;07/05/2012 03:06:43;5201 W HILLIS RD;TREE DOWN AND LINES ON FIRE [07/05/12 03:07:14 TMORTENSEN]",
        "DATE:07/05/2012",
        "TIME:03:06:43",
        "ADDR:5201 W HILLIS RD",
        "CALL:TREE DOWN AND LINES ON FIRE");

    doTest("T9",
        "CAD:FYI: ;07/05/2012 03:09:06;2700 S NEVINS RD;3 POWER LINES [07/05/12 03:10:12 TMORTENSEN]",
        "DATE:07/05/2012",
        "TIME:03:09:06",
        "ADDR:2700 S NEVINS RD",
        "CALL:3 POWER LINES");

    doTest("T10",
        "CAD:FYI: ;07/05/2012 03:21:54;S SHERIDAN RD/E PAKES RD;TREES DOWN/WIRES ACROSS THE ROADWAY [07/05/12 03:22:13 SDAVIS]",
        "DATE:07/05/2012",
        "TIME:03:21:54",
        "ADDR:S SHERIDAN RD & E PAKES RD",
        "CALL:TREES DOWN/WIRES ACROSS THE ROADWAY");

    doTest("T11",
        "CAD:FYI: ;07/05/2012 03:24:52;147 E SIDNEY RD;LINES DOWN IN THE DRIVEWAY OF THE CALLERS ADDRESS [07/05/12 03:25:46 TLARSON] POWER LINES DOWN- [07/05/12",
        "DATE:07/05/2012",
        "TIME:03:24:52",
        "ADDR:147 E SIDNEY RD",
        "CALL:LINES DOWN IN THE DRIVEWAY OF THE CALLERS ADDRESS",
        "INFO:POWER LINES DOWN-");

    doTest("T12",
        "CAD:FYI: ;07/05/2012 03:53:11;588 W SIDNEY RD;TREES ON POWER LINES AT THE ABOVE LOCATION-REPORTED BY TRUCK 7 FROM STANTON FIRE [07/05/12 03:53:47",
        "DATE:07/05/2012",
        "TIME:03:53:11",
        "ADDR:588 W SIDNEY RD",
        "CALL:TREES ON POWER LINES AT THE ABOVE LOCATION-REPORTED BY TRUCK 7 FROM STANTON FIRE");

  }
  
  public static void main(String[] args) {
    new MIMontcalmCountyParserTest().generateTests("T1");
  }
}
