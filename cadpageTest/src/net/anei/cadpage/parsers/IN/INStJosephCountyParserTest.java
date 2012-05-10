package net.anei.cadpage.parsers.IN;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class INStJosephCountyParserTest extends BaseParserTest {
  
  public INStJosephCountyParserTest() {
    setParser(new INStJosephCountyParser(), "ST JOSEPH COUNTY", "IN");
  }
  
  @Test
  public void testEricYoder() {

    doTest("T1",
        "Subject:CAD\n[!] ^ 11425 MCKINLEY HW PE :(55231) BELAIR STGAS LEAK FROM PUTING IN A POST 1626,006NIPSCO 1627,014PEN4A\n",
        "ADDR:11425 MCKINLEY HW",
        "MADDR:11425 MCKINLEY HWY",
        "CITY:PENN",
        "ID:55231",
        "INFO:BELAIR STGAS LEAK FROM PUTING IN A POST 1626,006NIPSCO 1627,014PEN4A");

    doTest("T2",
        "Subject:CAD\n" +
        "[!] ^ 17 RIVERCREST DR OS :( 600) N BEECH RDFROM MEDICAL ALARM COMP UNK MED 1617,006CALL BACK # TO ALARM COMP 800-325-17\n",

        "ADDR:17 RIVERCREST DR",
        "CITY:OSCEOLA",
        "ID:600",
        "INFO:N BEECH RDFROM MEDICAL ALARM COMP UNK MED 1617,006CALL BACK # TO ALARM COMP 800-325-17");
  }
  
  @Test
  public void parseTylerHeckaman() {

    doTest("T1",
        "Subject:CAD\n[!] CRASH021 ^ 2 BYPASS HW PE :(60000) ELM RD2 VEH UNK INJ 0613,010ME10 ,PENN1 ",
        "CALL:CRASH021",
        "ADDR:2 BYPASS HW",
        "MADDR:2 BYPASS HWY",
        "CITY:PENN",
        "ID:60000",
        "INFO:ELM RD2 VEH UNK INJ 0613,010ME10 ,PENN1");

    doTest("T2",
        "Subject:CAD\n" +
        "[!] COMAL021 ^ 55693 ASH RD PE :(10000) ELSIE HWDUNGARVIN - COMMERCIAL FIRE ALARM - MANUAL 1233,014NOVI 800-877-3624 PRE ",

        "CALL:COMAL021",
        "ADDR:55693 ASH RD",
        "CITY:PENN",
        "ID:10000",
        "INFO:ELSIE HWDUNGARVIN - COMMERCIAL FIRE ALARM - MANUAL 1233,014NOVI 800-877-3624 PRE");

    doTest("T3",
        "Subject:CAD\n" +
        "[!] RESAL021 ^ 54895 MONTPELLIER DR PE :(11500) BOISE RUN STRESIDENTIAL FIRE ALARM - HALLWAY SMOKE DETECTOR 0813,014PENN ",

        "CALL:RESAL021",
        "ADDR:54895 MONTPELLIER DR",
        "CITY:PENN",
        "ID:11500",
        "X:BOISE RUN",
        "INFO:STRESIDENTIAL FIRE ALARM - HALLWAY SMOKE DETECTOR 0813,014PENN");

    doTest("T4",
        "Subject:CAD\n[!] ^ 56375 CURRANT RD PE :(13402) ESTHER AVM. HEAD INJ FROM ASSULT 2147,014ME12 ,PENN2 ",
        "ADDR:56375 CURRANT RD",
        "CITY:PENN",
        "ID:13402",
        "INFO:ESTHER AVM. HEAD INJ FROM ASSULT 2147,014ME12 ,PENN2");
   
  }
  
  @Test
  public void testActive911() {

    doTest("T1",
        "(NC)[!] INVES 03/23/12 POPPY LN :( ) OBTAIN MORE LOCATION INFOBETWEEN HICKORY AND HOLLY - UNKNOWN TYPE FIRE",
        "CALL:INVES",
        "ADDR:POPPY LN",
        "INFO:OBTAIN MORE LOCATION INFOBETWEEN HICKORY AND HOLLY - UNKNOWN TYPE FIRE");

    doTest("T2",
        "(NC)[!] CRASH009 G-453 03/23/12 30750 SR 2 HW NC :(56000) LARRISON DRPI",
        "CALL:CRASH009",
        "UNIT:G-453",
        "ADDR:30750 SR 2 HW",
        "MADDR:30750 IN 2",
        "CITY:NEW CARLISLE",
        "ID:56000",
        "INFO:LARRISON DRPI");

    doTest("T3",
        "(NC)[!] COMAL009 G-428 03/23/12 31869 CHICAGO TR NC :(51452) HAMILTON TRGENERAL FIRE-SIMPLEX SECURITY",
        "CALL:COMAL009",
        "UNIT:G-428",
        "ADDR:31869 CHICAGO TR",
        "CITY:NEW CARLISLE",
        "ID:51452",
        "INFO:HAMILTON TRGENERAL FIRE-SIMPLEX SECURITY");
 
  }
  
  public static void main(String[] args) {
    new INStJosephCountyParserTest().generateTests("T1","CALL UNIT ADDR CITY ID X INFO");
  }
}