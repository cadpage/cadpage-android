package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class OHXeniaParserTest extends BaseParserTest {
  
  public OHXeniaParserTest() {
    setParser(new OHXeniaParser(), "GREENE COUNTY", "OH");
  }
  
  @Test
  public void testXeniwTwpParser() {
    
    doTest("T1",
        "MBLS-MEDICAL Location: 160 RICHARD DR DAYTON XENIA RD / ROBERT LN XENIA TWP Time: 17:31 Units: M51  Common",
        "CALL:MBLS-MEDICAL",
        "ADDR:160 RICHARD DR",
        "X:DAYTON XENIA RD / ROBERT LN",
        "CITY:XENIA TWP",
        "UNIT:M51");

    doTest("T2",
        "FMALS-MEDIC AL Location: 378 WINDING TRL LAMPLIGHTER PL, WOODLAND DR / HELEN AVE XENIA TWP Time: 16:39 Unit",
        "CALL:FMALS-MEDIC AL",
        "ADDR:378 WINDING TRL",
        "PLACE:LAMPLIGHTER PL",
        "X:WOODLAND DR / HELEN AVE",
        "CITY:XENIA TWP");

    doTest("T3",
        "FGRA-GRASS/FIELD Location: 731 HOOK RD OLD HOOK RD / S BICKETT RD XENIA TWP Time: 11:52 Units:  Common Name",
        "CALL:FGRA-GRASS/FIELD",
        "ADDR:731 HOOK RD",
        "X:OLD HOOK RD / S BICKETT RD",
        "CITY:XENIA TWP");

    doTest("T4",
        "FMBLS-MEDICAL Location: 721 KINSEY RD CRESTLINE DR / APOLLO DR XENIA TWP Time: 23:36 Units:  Common Name: I",
        "CALL:FMBLS-MEDICAL",
        "ADDR:721 KINSEY RD",
        "X:CRESTLINE DR / APOLLO DR",
        "CITY:XENIA TWP");

    doTest("T5",
        "FGRA-GRASS/FIELD Location: 731 HOOK RD OLD HOOK RD / S BICKETT RD XENIA TWP Time: 11:52 Units:  Common Name",
        "CALL:FGRA-GRASS/FIELD",
        "ADDR:731 HOOK RD",
        "X:OLD HOOK RD / S BICKETT RD",
        "CITY:XENIA TWP");

    doTest("T6",
        "FMBLS-MEDICAL Location: 160 RICHARD DR DAYTON XENIA RD / ROBERT LN XENIA TWP Time: 17:31 Units: M51  Common",
        "CALL:FMBLS-MEDICAL",
        "ADDR:160 RICHARD DR",
        "X:DAYTON XENIA RD / ROBERT LN",
        "CITY:XENIA TWP",
        "UNIT:M51");

    doTest("T7",
        "CRUI Location: STEVENSON RD US 42 E XENIA TWP Time: 23:52 Units: E51 M51 CHF50  Common Name: Info:  IN A DI",
        "CALL:CRUI",
        "ADDR:STEVENSON RD",
        "MADDR:STEVENSON RD & US 42 E",
        "X:US 42 E",
        "CITY:XENIA TWP",
        "UNIT:E51 M51 CHF50",
        "INFO:IN A DI");

    doTest("T8",
        "FMALS-MEDIC AL Location: 378 WINDING TRL LAMPLIGHTER PL, WOODLAND DR / HELEN AVE XENIA TWP Time: 16:39 Unit",
        "CALL:FMALS-MEDIC AL",
        "ADDR:378 WINDING TRL",
        "PLACE:LAMPLIGHTER PL",
        "X:WOODLAND DR / HELEN AVE",
        "CITY:XENIA TWP");

    doTest("T9",
        "CRPI Location: 413 CLIFTON RD LITTLE MIAMI SCENIC BIKE PATH / CLARK RUN RD XENIA TWP Time: 19:17 Units: E51",
        "CALL:CRPI",
        "ADDR:413 CLIFTON RD",
        "X:LITTLE MIAMI SCENIC BIKE PATH / CLARK RUN RD XENIA TWP",
        "UNIT:E51");

    doTest("T10",
        "CRUI Location: STEVENSON RD US 42 E XENIA TWP Time: 23:52 Units: E51 M51 CHF50  Common Name: Info:  IN A DI",
        "CALL:CRUI",
        "ADDR:STEVENSON RD",
        "MADDR:STEVENSON RD & US 42 E",
        "X:US 42 E",
        "CITY:XENIA TWP",
        "UNIT:E51 M51 CHF50",
        "INFO:IN A DI");

    doTest("T11",
        "FMBLS-MEDICAL Location: 9 SEXTON DR OLD SPRINGFIELD PIKE / OLD SPRINGFIELD PIKE XENIA TWP Time: 21:28 Units",
        "CALL:FMBLS-MEDICAL",
        "ADDR:9 SEXTON DR",
        "X:OLD SPRINGFIELD PIKE / OLD SPRINGFIELD PIKE",
        "CITY:XENIA TWP");

    doTest("T12",
        "FACO-FIRE ALARM COMMERCIAL Location: 121 FAIRGROUND RD GREENE COUNTY FAIRGROUNDS / BEAVERCREEK LN XENIA TWP",
        "CALL:FACO-FIRE ALARM COMMERCIAL",
        "ADDR:121 FAIRGROUND RD",
        "X:GREENE COUNTY FAIRGROUNDS / BEAVERCREEK LN XENIA TWP");

    doTest("T13",
        "FMBLS-MEDICAL Location: 1154 HOOK RD S BICKETT RD / OLD HOOK RD XENIA TWP Time: 13:36 Units: M52  Common Na",
        "CALL:FMBLS-MEDICAL",
        "ADDR:1154 HOOK RD S",
        "X:BICKETT RD / OLD HOOK RD",
        "CITY:XENIA TWP",
        "UNIT:M52");

    doTest("T14",
        "FMALS-MEDIC AL Location: 3301 BONE RD UNKNOWN / E SPRING VALLEY PAINTERSVILLE RD CAESARCREEK TWP Time: 18:2",
        "CALL:FMALS-MEDIC AL",
        "ADDR:3301 BONE RD",
        "X:UNKNOWN / E SPRING VALLEY PAINTERSVILLE RD CAESARCREEK TWP");

    doTest("T15",
        "CRUI Location: E LIMESTONE ST XENIA AVE YELLOW SPRINGS Time: 18:42 Units: E82 HUSMA M51 CHF81  Common Name:",
        "CALL:CRUI",
        "ADDR:E LIMESTONE ST",
        "MADDR:E LIMESTONE ST & XENIA AVE",
        "X:XENIA AVE",
        "CITY:YELLOW SPRINGS",
        "UNIT:E82 HUSMA M51 CHF81");

    doTest("T16",
        "FMBLS-MEDICAL Location: 2960 W  ENON RD SR 235 / W HYDE RD XENIA TWP Time: 12:02 Units: M51  Common Name: G",
        "CALL:FMBLS-MEDICAL",
        "ADDR:2960 W ENON RD",
        "X:SR 235 / W HYDE RD",
        "CITY:XENIA TWP",
        "UNIT:M51",
        "NAME:G");

    doTest("T17",
        "FMBLS-MEDICAL Location: 2383 NEEDMORE RD No Cross Streets Found CAESARCREEK TWP Time: 17:05 Units: M52  Com",
        "CALL:FMBLS-MEDICAL",
        "ADDR:2383 NEEDMORE RD",
        "X:No Cross Streets Found CAESARCREEK TWP",
        "UNIT:M52");

    doTest("T18",
        "FMALS-MEDIC AL Location: 1154 HOOK RD S BICKETT RD / OLD HOOK RD XENIA TWP Time: 09:05 Units: M52 E52  Comm",
        "CALL:FMALS-MEDIC AL",
        "ADDR:1154 HOOK RD S",
        "X:BICKETT RD / OLD HOOK RD",
        "CITY:XENIA TWP",
        "UNIT:M52 E52");

    doTest("T19",
        "FMBLS-MEDICAL Location: 1154 HOOK RD S BICKETT RD / OLD HOOK RD XENIA TWP Time: 17:17 Units:  Common Name:",
        "CALL:FMBLS-MEDICAL",
        "ADDR:1154 HOOK RD S",
        "X:BICKETT RD / OLD HOOK RD",
        "CITY:XENIA TWP");

    doTest("T20",
        "FGRA-GRASS/FIELD Location: 55 CLIFTON RD US 68 N / LITTLE MIAMI SCENIC BIKE PATH XENIA TWP Time: 00:05 Unit",
        "CALL:FGRA-GRASS/FIELD",
        "ADDR:55 CLIFTON RD",
        "X:US 68 N",
        "CITY:/ LITTLE MIAMI SCENIC BIKE PATH XENIA TWP");

    doTest("T21",
        "FSCE-SERVICE CALL-ENGINE Location: 8834 MICHAELA LN WARREN COUNTY Time: 20:41 Units: T51 T52  Common Name:",
        "CALL:FSCE-SERVICE CALL-ENGINE",
        "ADDR:8834 MICHAELA LN",
        "X:WARREN COUNTY",
        "UNIT:T51 T52");

    doTest("T22",
        "FMBLS-MEDICAL Location: 1541 SR 380 COUNTRY PLACE CT / RENAISSANCE WOOD CT XENIA TWP Time: 00:28 Units: M52",
        "CALL:FMBLS-MEDICAL",
        "ADDR:1541 SR 380",
        "MADDR:1541 OH 380",
        "X:COUNTRY PLACE CT / RENAISSANCE WOOD CT",
        "CITY:XENIA TWP",
        "UNIT:M52");

    doTest("T23",
        "FMBLS-MEDICAL Location: 467 WILSON DR REGINA DR / MEADOW LN XENIA TWP Time: 23:39 Units:  Common Name: Info",
        "CALL:FMBLS-MEDICAL",
        "ADDR:467 WILSON DR",
        "X:REGINA DR / MEADOW LN",
        "CITY:XENIA TWP");

    doTest("T24",
        "FRES-RESIDENTIAL FIRE Location: 710 HAWKINS RD CREEKSIDE TRAIL BIKE PATH / FORD RD XENIA TWP Time: 20:51 Un",
        "CALL:FRES-RESIDENTIAL FIRE",
        "ADDR:710 HAWKINS RD",
        "X:CREEKSIDE TRAIL",
        "CITY:BIKE PATH / FORD RD XENIA TWP");

    doTest("T25",
        "FMALS-MEDIC AL Location: 1264 BOYD RD DEAD END / US 68 S XENIA TWP Time: 21:25 Units: M52 E52  Common Name:",
        "CALL:FMALS-MEDIC AL",
        "ADDR:1264 BOYD RD",
        "X:DEAD END / US 68 S XENIA TWP",
        "UNIT:M52 E52");

    doTest("T26",
        "FMBLS-MEDICAL Location: 1154 HOOK RD S BICKETT RD / OLD HOOK RD XENIA TWP Time: 17:17 Units:  Common Name:",
        "CALL:FMBLS-MEDICAL",
        "ADDR:1154 HOOK RD S",
        "X:BICKETT RD / OLD HOOK RD",
        "CITY:XENIA TWP");
    
  }
  
  @Test
  public void testJasperTwpParser() {

    doTest("T1",
        "(Dispatch Info) FMBLS-MEDICAL Location: 738 BLACK FOOT TRL SHAWNEE TRL / ONEIDA TRL NEW JASPER TWP Time: 20:37 Units:  Common Name: Info:  Problem: LO",
        "CALL:FMBLS-MEDICAL",
        "ADDR:738 BLACK FOOT TRL",
        "X:SHAWNEE TRL / ONEIDA TRL",
        "CITY:NEW JASPER TWP",
        "INFO:Problem: LO");

    doTest("T2",
        "(Dispatch Info) FMALS-MEDIC AL Location: 3986 SHAWNEE TRL N LAKESHORE DR / NIAGARA TRL NEW JASPER TWP Time: 14:09 Units: M42 BR14  Common Name: Info:",
        "CALL:FMALS-MEDIC AL",
        "ADDR:3986 SHAWNEE TRL N",
        "X:LAKESHORE DR / NIAGARA TRL",
        "CITY:NEW JASPER TWP",
        "UNIT:M42 BR14");

    doTest("T3",
        "(Dispatch Info) FMBLS-MEDICAL Location: 3811 WAYNESVILLE JAMESTOWN RD ST JOHN RD / MT CARMEL RD NEW JASPER TWP Time: 09:57 Units: M14 BR14  Common Nam",
        "CALL:FMBLS-MEDICAL",
        "ADDR:3811 WAYNESVILLE JAMESTOWN RD",
        "X:ST JOHN RD / MT CARMEL RD",
        "CITY:NEW JASPER TWP",
        "UNIT:M14 BR14");

    doTest("T4",
        "(Dispatch Info) CRUI Location: 3809 JASPER RD ST JOHN RD / APACHE TRL NEW JASPER TWP Time: 18:16 Units:  Common Name: Info:  W 2 PTS NON ER TO GMH  PO",
        "CALL:CRUI",
        "ADDR:3809 JASPER RD",
        "X:ST JOHN RD / APACHE TRL",
        "CITY:NEW JASPER TWP",
        "INFO:W 2 PTS NON ER TO GMH  PO");

    doTest("T5",
        "(Dispatch Info) FMALS-MEDIC AL Location: 2136 E  HOOP RD GULTICE RD / COOPER LN NEW JASPER TWP Time: 06:21 Units: M14 BR14  Common Name: Info:  NOT RE",
        "CALL:FMALS-MEDIC AL",
        "ADDR:2136 E HOOP RD",
        "X:GULTICE RD / COOPER LN",
        "CITY:NEW JASPER TWP",
        "UNIT:M14 BR14",
        "INFO:NOT RE");
    
  }
  
  public static void main(String[] args) {
    new OHXeniaParserTest().generateTests("T1");
  }
}
