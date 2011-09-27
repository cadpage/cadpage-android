package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.PA.PALackawannaCountyParser;

import org.junit.Test;


public class PALackawannaCountyParserTest extends BaseParserTest {
  
  public PALackawannaCountyParserTest() {
    setParser(new PALackawannaCountyParser(), "LACKAWANNA COUNTY", "PA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Unit  Location: 206 MILLER RD STEVENSON RD / CARBONDALE RD 1 Common Name: Call Type: ALS Call Time: 09/26/11 17:02 Narrative  pd notified  POSS CONFUSED ALSO  Nature Of Call: 79YOF FEELING WEEK. SHE DID FALL EARLIER",
        "ADDR:206 MILLER RD",
        "X:STEVENSON RD / CARBONDALE RD 1",
        "CALL:ALS",
        "INFO:pd notified  POSS CONFUSED ALSO / 79YOF FEELING WEEK. SHE DID FALL EARLIER");

    doTest("T2",
        "Unit  Location: 711 MAY ST MAPLE ST / DEAD END 59 Common Name: Call Type: ALS Call Time: 09/26/11 21:33 Narrative  PD ADVISED  REF EMD  HX OF HEART PROBLEMS  Nature Of Call: 56 YOM RAPID HEART RATE",
        "ADDR:711 MAY ST",
        "X:MAPLE ST / DEAD END 59",
        "CALL:ALS",
        "INFO:PD ADVISED  REF EMD  HX OF HEART PROBLEMS / 56 YOM RAPID HEART RATE");

    doTest("T3",
        "Unit  Location: 108 TERRACE DR STURGES RD / SCRANTON CARBONDALE HWY 20 Common Name: LACKAWANNA HEALTH AND REHABCall Type: ALS Call Time: 09/26/11 21:02 Narrative  22-9/LA4 TO MOSES TAYLOR  22-9 ENRT MOMENTARILY  Nature Of Call: in c-2 -- 90 yo f diff breathing low o2 sats",
        "ADDR:108 TERRACE DR",
        "X:STURGES RD / SCRANTON CARBONDALE HWY 20",
        "PLACE:LACKAWANNA HEALTH AND REHAB",
        "CALL:ALS",
        "INFO:22-9/LA4 TO MOSES TAYLOR  22-9 ENRT MOMENTARILY / in c-2 -- 90 yo f diff breathing low o2 sats");

    doTest("T4",
        "Unit  Location: 601 6TH ST DEAD END / MOOSIC HEIGHTS 94 Common Name: Call Type: ALS Call Time: 09/26/11 22:27 Narrative  94PD ADVISED  UNKNOWN DRUGS  MALE TOOK DRUGS  IS BREATHING - IS SEMI-RESPONSIVE  Nature Of Call: 24 YOM COLLAPSED",
        "ADDR:601 6TH ST",
        "X:DEAD END / MOOSIC HEIGHTS 94",
        "CALL:ALS",
        "INFO:94PD ADVISED  UNKNOWN DRUGS  MALE TOOK DRUGS  IS BREATHING - IS SEMI-RESPONSIVE / 24 YOM COLLAPSED");
 
  }
  
  public static void main(String args[]) {
    new PALackawannaCountyParserTest().generateTests("T1");
  }
}