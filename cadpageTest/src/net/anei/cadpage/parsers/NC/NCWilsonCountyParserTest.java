package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NCWilsonCountyParserTest extends BaseParserTest {
  
  public NCWilsonCountyParserTest() {
    setParser(new NCWilsonCountyParser(), "WILSON COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "CAD:11000831;06D02;BREATHING PROBLEMS;5036 US 264A E;2C;RANCH FARM CT;HOLDENS CROSS RD;[Medical Priority Info] Key Questions Complete RESPONSE:",
        "ID:11000831",
        "CODE:06D02",
        "CALL:BREATHING PROBLEMS",
        "ADDR:5036 US 264A E",
        "SRC:2C",
        "X:RANCH FARM CT & HOLDENS CROSS RD");

    doTest("T2",
        "CAD:OUTSIDE FIRE - SMALL;5047 SAWDUST RD;4C;LASSITER MILL RD;TARTTS MILL RD",
        "CALL:OUTSIDE FIRE - SMALL",
        "ADDR:5047 SAWDUST RD",
        "SRC:4C",
        "X:LASSITER MILL RD & TARTTS MILL RD");

    doTest("T3",
        "CAD:11000827;69D10;STRUCTURE FIRE 1;4659 EVANSDALE RD;5B;OLD STANTONSBURG RD;CASTLEWOOD LN;403 enroute [05/19/11 13:53:19 DPITTMAN] [Fire Priority Info] Key Que",
        "ID:11000827",
        "CODE:69D10",
        "CALL:STRUCTURE FIRE 1",
        "ADDR:4659 EVANSDALE RD",
        "SRC:5B",
        "X:OLD STANTONSBURG RD & CASTLEWOOD LN",
        "INFO:403 enroute",
        "DATE:05/19/11",
        "TIME:13:53:19");

    doTest("T4",
        "CAD:STRUCTURE FIRE 1;4659 EVANSDALE RD;5B;OLD STANTONSBURG RD;CASTLEWOOD LN;291-5847 [05/19/11 13:51:05 SBATTS]",
        "CALL:STRUCTURE FIRE 1",
        "ADDR:4659 EVANSDALE RD",
        "SRC:5B",
        "X:OLD STANTONSBURG RD & CASTLEWOOD LN",
        "INFO:291-5847",
        "DATE:05/19/11",
        "TIME:13:51:05");

    doTest("T5",
        "CAD:11000827;69D10;STRUCTURE FIRE 1;4659 EVANSDALE RD;5B;OLD STANTONSBURG RD;CASTLEWOOD LN;403 enroute [05/19/11 13:53:19 DPITTMAN] [Fire Priority Info] Key Que",
        "ID:11000827",
        "CODE:69D10",
        "CALL:STRUCTURE FIRE 1",
        "ADDR:4659 EVANSDALE RD",
        "SRC:5B",
        "X:OLD STANTONSBURG RD & CASTLEWOOD LN",
        "INFO:403 enroute",
        "DATE:05/19/11",
        "TIME:13:53:19");

    doTest("T6",
        "CAD:11000831;06D02;BREATHING PROBLEMS;5036 US 264A E;2C;RANCH FARM CT;HOLDENS CROSS RD;[Medical Priority Info] Key Questions Complete RESPONSE: MEDIC & FR RESPO",
        "ID:11000831",
        "CODE:06D02",
        "CALL:BREATHING PROBLEMS",
        "ADDR:5036 US 264A E",
        "SRC:2C",
        "X:RANCH FARM CT & HOLDENS CROSS RD");

    doTest("T7",
        "CAD:11000844;ACCIDENT PROPERTY DAMAGE;NC 222/ASPEN GROVE CHURCH RD;2A;on nc 222 just before aspen grove church while on the phone with hp she advised a hissing",
        "ID:11000844",
        "CALL:ACCIDENT PROPERTY DAMAGE",
        "ADDR:NC 222 & ASPEN GROVE CHURCH RD",
        "SRC:2A",
        "INFO:on nc 222 just before aspen grove church while on the phone with hp she advised a hissing");

    doTest("T8",
        "CAD:11000968;67D02R;OUTSIDE FIRE - WOODS/LRG BRUSH;4164 NC 42 E;4C;KENT RD;VARNELL RD;[Fire Priority Info] Key Questions Complete RESPONSE: Delta RESPONDER SCRI",
        "ID:11000968",
        "CODE:67D02R",
        "CALL:OUTSIDE FIRE - WOODS/LRG BRUSH",
        "ADDR:4164 NC 42 E",
        "SRC:4C",
        "X:KENT RD & VARNELL RD");

    doTest("T8",
        "S: M:CAD:11001633;FIRE ALARM 1;7005 SPRINGFIELD SCHOOL RD;6A;WILLING WORKER RD;PEELE RD\n",
        "ID:11001633",
        "CALL:FIRE ALARM 1",
        "ADDR:7005 SPRINGFIELD SCHOOL RD",
        "SRC:6A",
        "X:WILLING WORKER RD & PEELE RD");
 }
  

  public static void main(String[] args) {
    new NCWilsonCountyParserTest().generateTests("T8");
  }
}
