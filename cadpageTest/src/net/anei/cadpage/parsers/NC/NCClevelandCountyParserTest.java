package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NCClevelandCountyParserTest extends BaseParserTest {
  
  public NCClevelandCountyParserTest() {
    setParser(new NCClevelandCountyParser(), "CLEVELAND COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "CAD:7044775828-CHEST PA-1861 E MARION ST-CAMDEN CT-BORDERS RD-[Medical Priority Info] PROBLEM: TINGLING DOWN HER ARMS # PATS: 1 AGE: 30 Years SEX: Female CO",
        "PHONE:7044775828",
        "CALL:CHEST PA",
        "ADDR:1861 E MARION ST",
        "X:CAMDEN CT & BORDERS RD",
        "INFO:TINGLING DOWN HER ARMS # PATS: 1 AGE: 30 Years SEX: Female CO");

    doTest("T2",
        "CAD:10-50 PI-CHARLES RD/W DIXON BLVD-[LAW] 2 cars [07/25/12 19:10:38 C89] Aborted by Medical Priority with code: 1. Caller hung up [07/25/12 19:10:23 C89]",
        "CALL:10-50 PI",
        "ADDR:CHARLES RD & W DIXON BLVD",
        "INFO:2 cars / Aborted by Medical Priority with code: 1. Caller hung up",
        "DATE:07/25/12",
        "TIME:19:10:38");

    doTest("T3",
        "CAD:7042978331-SEIZURES-117 PALMER ST-E MARION ST-AIRLINE AV-[Medical Priority Info] PROBLEM: seizure # PATS: 1 AGE: 22 Years SEX: Male CONSCIOUS: No BREATH",
        "PHONE:7042978331",
        "CALL:SEIZURES",
        "ADDR:117 PALMER ST",
        "X:E MARION ST & AIRLINE AV",
        "INFO:seizure # PATS: 1 AGE: 22 Years SEX: Male CONSCIOUS: No BREATH");

    doTest("T4",
        "CAD:KELIOSA-SEIZURES-313 S POST RD-GARRETT DR-KINGS ROAD EXT-[Medical Priority Info] PROBLEM: seizure # PATS: 1 AGE: 3 Years SEX: Female CONSCIOUS: No BREAT",
        "CALL:KELIOSA-SEIZURES",
        "ADDR:313 S POST RD",
        "X:GARRETT DR & KINGS ROAD EXT",
        "INFO:seizure # PATS: 1 AGE: 3 Years SEX: Female CONSCIOUS: No BREAT");

    doTest("T5",
        "CAD:10-50 PI-CHARLES RD/W DIXON BLVD-[LAW] 2 cars [07/25/12 19:10:38 C89] Aborted by Medical Priority with code: 1. Caller hung up [07/25/12 19:10:23 C89]",
        "CALL:10-50 PI",
        "ADDR:CHARLES RD & W DIXON BLVD",
        "INFO:2 cars / Aborted by Medical Priority with code: 1. Caller hung up",
        "DATE:07/25/12",
        "TIME:19:10:38");

    doTest("T6",
        "CAD:SPRINT PCS-9802953855-FIREAPT-415 GARDNER ST-SMITH ST-MARTIN ST-kitchen on fire at aprtment 5 they are trying to get every one out of adjacent apts [07/",
        "NAME:SPRINT PCS",
        "PHONE:9802953855",
        "CALL:FIREAPT",
        "ADDR:415 GARDNER ST",
        "X:SMITH ST & MARTIN ST",
        "INFO:kitchen on fire at aprtment 5 they are trying to get every one out of adjacent apts");

    doTest("T7",
        "CAD:CICILIA-8286444392-FIRE/HAZ-354 WASHBURN SWITCH RD-LILLCO DR-AMBER LN-GAS LEAK INSIDE THE HOUSE [07/31/12 21:18:19 C84]",
        "NAME:CICILIA",
        "PHONE:8286444392",
        "CALL:FIRE/HAZ",
        "ADDR:354 WASHBURN SWITCH RD",
        "X:LILLCO DR & AMBER LN",
        "INFO:GAS LEAK INSIDE THE HOUSE",
        "DATE:07/31/12",
        "TIME:21:18:19");

    doTest("T8",
        "CAD:AT&T MOBILITY-9118385620-FIRE/MIS-705 E DIXON BLVD-WAL-MART-EARL RD-GROVE ST",
        "NAME:AT&T MOBILITY",
        "PHONE:9118385620",
        "CALL:FIRE/MIS",
        "ADDR:705 E DIXON BLVD",
        "INFO:WAL / MART / EARL RD / GROVE ST");
  }

  public static void main(String[] args) {
    new NCClevelandCountyParserTest().generateTests("T1");
  }
}
