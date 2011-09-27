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

    doTest("T5",
        "Unit  Location: 116 FULTON ST PROSPECT ST / PROSPECT ST 61 Common Name: Call Type: BLS Call Time: 09/27/11 13:56 Narrative  CALLER REFUSED EMD  REQ NO SIRENS  Nature Of Call: 85 YOF PAIN IN THE SHOULDER",
        "ADDR:116 FULTON ST",
        "X:PROSPECT ST / PROSPECT ST 61",
        "CALL:BLS",
        "INFO:CALLER REFUSED EMD  REQ NO SIRENS / 85 YOF PAIN IN THE SHOULDER");

    doTest("T6",
        "Unit  Location: 2500 N  WASHINGTON AVE DEAD END / HIGHNETT PL 50 Common Name: MU WOODLAND APARTMENTSCall Type: AFA Call Time: 09/27/11 14:53 Narrative  simplex panel PHN 5703486242// ATT KH  Nature Of Call: bldg 2,4,6",
        "ADDR:2500 N WASHINGTON AVE",
        "X:DEAD END / HIGHNETT PL 50",
        "PLACE:MU WOODLAND APARTMENTS",
        "CALL:AFA",
        "INFO:simplex panel PHN 5703486242// ATT KH / bldg 2,4,6");

    doTest("T7",
        "Unit  Location: 2500 N  WASHINGTON AVE DEAD END / HIGHNETT PL 50 Common Name: MU WOODLAND APARTMENTSCall Type: AFA Call Time: 09/27/11 14:53 Narrative  simplex panel PHN 5703486242// ATT KH  Nature Of Call: bldg 2,4,6",
        "ADDR:2500 N WASHINGTON AVE",
        "X:DEAD END / HIGHNETT PL 50",
        "PLACE:MU WOODLAND APARTMENTS",
        "CALL:AFA",
        "INFO:simplex panel PHN 5703486242// ATT KH / bldg 2,4,6");

    doTest("T8",
        "Unit  Location: 415 VENARD RD TEDRICK ST / ELAN GARDENS 2 Common Name: HERITAGE BAPTIST CHURCHCall Type: AFA Call Time: 09/27/11 15:07 Narrative  2pd advised  Nature Of Call: GEN FIRE ALRM ZONE 1",
        "ADDR:415 VENARD RD",
        "X:TEDRICK ST / ELAN GARDENS 2",
        "PLACE:HERITAGE BAPTIST CHURCH",
        "CALL:AFA",
        "INFO:2pd advised / GEN FIRE ALRM ZONE 1");

    doTest("T9",
        "Unit  Location: 1196 CHAPMAN LAKE RD 28 Common Name: Call Type: AFA Call Time: 09/27/11 16:07 Narrative  Nature Of Call: res fire/ cutler res/ gen fire",
        "ADDR:1196 CHAPMAN LAKE RD",
        "APT:28",
        "CALL:AFA",
        "INFO:res fire/ cutler res/ gen fire");
  }
  
  public static void main(String args[]) {
    new PALackawannaCountyParserTest().generateTests("T5");
  }
}