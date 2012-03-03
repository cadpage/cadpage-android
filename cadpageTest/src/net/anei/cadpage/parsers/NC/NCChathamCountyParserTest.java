package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.NC.NCChathamCountyParserTest;

import org.junit.Test;


public class NCChathamCountyParserTest extends BaseParserTest {
  
  public NCChathamCountyParserTest() {
    setParser(new NCChathamCountyParser(), "CHATHAM COUNTY", "NC");
  }
  
  @Test
  public void testParser() {
    doTest("T1",
        "HEATHER.BOONE:399 LYNDFIELD CLOSE PITTSBORO MDL 10D04 1119468 18:13:33 Chest Pains- Clammy HUSBAND HAVING CHEST PAINS - EMER",
        "ADDR:399 LYNDFIELD CLOSE",
        "CITY:PITTSBORO",
        "CODE:10D04",
        "ID:1119468",
        "TIME:18:13:33",
        "INFO:Chest Pains- Clammy HUSBAND HAVING CHEST PAINS - EMER");

    doTest("T2",
        "HEATHER.BOONE:791 RED GATE RD PITTSBORO 1119520 05:38:59 medical call HUSBAND OFF BALCONY",
        "ADDR:791 RED GATE RD",
        "CITY:PITTSBORO",
        "ID:1119520",
        "TIME:05:38:59",
        "INFO:medical call HUSBAND OFF BALCONY");

    doTest("T3",
        "LISA.SCOTT:965 SEAFORTH BEACH RD PITTSBORO 1119461 17:08:12 medical call 10YOM WEARING WHITE SHORTS NAMED TRAY LAST SEEN APPROX 4 MINS AGO(End)",
        "ADDR:965 SEAFORTH BEACH RD",
        "CITY:PITTSBORO",
        "ID:1119461",
        "TIME:17:08:12",
        "INFO:medical call 10YOM WEARING WHITE SHORTS NAMED TRAY LAST SEEN APPROX 4 MINS AGO(End)");

    doTest("T4",
        "KIM.HANNER:858 BRUMLEY PITTSBORO MDL 31C02 1119495 22:11:57 Unconscious / Fainting (Near) Fainting episodes an WIFE PASSED OUT, IS CONS NOW(End)",
        "ADDR:858 BRUMLEY",
        "CITY:PITTSBORO",
        "CODE:31C02",
        "ID:1119495",
        "TIME:22:11:57",
        "INFO:Unconscious / Fainting (Near) Fainting episodes an WIFE PASSED OUT, IS CONS NOW(End)");

    doTest("T5",
        "KIM.HANNER:475 NATURE TRAIL RD CHAPEL HILL 1119504 00:09:15 Convulsions/ Seizures- CONTINUOUS or MULTIPLE seiz PREVIOUS CALL FOR THIS ADDRESS WITH THIS NUMBER GIVEN BY CARY PD UNKNOWN PROBLEM POSSIBLE SEIZURES(End)",
        "ADDR:475 NATURE TRAIL RD",
        "CITY:CHAPEL HILL",
        "ID:1119504",
        "TIME:00:09:15",
        "INFO:Convulsions/ Seizures- CONTINUOUS or MULTIPLE seiz PREVIOUS CALL FOR THIS ADDRESS WITH THIS NUMBER GIVEN BY CARY PD UNKNOWN PROBLEM POSSIBLE SEIZURES(End)");

    doTest("T6",
        "  / TRACY.BALDWIN__:602 N SECOND AVE SILER CITY 1207466 16:44:01 medical call caller christie harris subj having chest pain\n",
        "ADDR:602 N SECOND AVE",
        "CITY:SILER CITY",
        "ID:1207466",
        "TIME:16:44:01",
        "INFO:medical call caller christie harris subj having chest pain");

  }
  
  public static void main(String[] args) {
    new NCChathamCountyParserTest().generateTests("T1", "ADDR CITY CODE ID TIME CALL INFO");
  }
}
/*, "ADDR CITY CODE CODE ID CALL INFO"*/