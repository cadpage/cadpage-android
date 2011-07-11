package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NCBrunswickCountyParserTest extends BaseParserTest {
  
  public NCBrunswickCountyParserTest() {
    setParser(new NCBrunswickCountyParser(), "BRUNSWICK COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "349:560 CUMBERLAND ST SE BOLIVIA MDL 09B01 11-020650 17:02:34 Cardiac or Respiratiory Arrest / Death RECV CALL FROM FUNERAL HOME ADVING THAT THEY RECV CALL STATING A FEMALE WAS DEAD AT THIS LOCATION AD",
        "ADDR:560 CUMBERLAND ST SE",
        "CITY:BOLIVIA",
        "CODE:09B01",
        "ID:11-020650",
        "INFO:Cardiac or Respiratiory Arrest / Death RECV CALL FROM FUNERAL HOME ADVING THAT THEY RECV CALL STATING A FEMALE WAS DEAD AT THIS LOCATION AD");

    doTest("T2",
        "415:111 SE 32ND ST OAK ISLAND VERIZON WIRELESS 7045790781 MDL 09E01 11-025910 20:39:44 Cardiac or Respiratiory Arrest - De",
        "ADDR:111 SE 32ND ST",
        "CITY:OAK ISLAND",
        "NAME:VERIZON WIRELESS",
        "PHONE:7045790781",
        "CODE:09E01",
        "ID:11-025910",
        "INFO:Cardiac or Respiratiory Arrest - De");

    doTest("T3",
        "411:22 BOUNDARYLINE DR NW C CALABASH LYNN 9102094924 11-025720 06:59:32 Structure Fire SMELL SOMETHING BURNING IN RESD",
        "ADDR:22 BOUNDARYLINE DR NW C",
        "CITY:CALABASH",
        "NAME:LYNN",
        "PHONE:9102094924",
        "ID:11-025720",
        "INFO:Structure Fire SMELL SOMETHING BURNING IN RESD");

    doTest("T4",
        "399:1295 DECATOR ST SW SUPPLY PAM 9106339368 MDL 09E01 11-025419 22:11:30 Cardiac or RespArrest  CALLER ADV THE PT IS STIFF",
        "ADDR:1295 DECATOR ST SW",
        "CITY:SUPPLY",
        "NAME:PAM",
        "PHONE:9106339368",
        "CODE:09E01",
        "ID:11-025419",
        "INFO:Cardiac or RespArrest  CALLER ADV THE PT IS STIFF");

    doTest("T5",
        "428:BAY POINT CT / JENNIS AV FELICIA  9103685110 MDL 27D04 11-026412 21:09:48 Stab-Gunshot-Pen Trauma AT THE END OF  RD .",
        "ADDR:BAY POINT CT & JENNIS AV",
        "NAME:FELICIA",
        "PHONE:9103685110",
        "CODE:27D04",
        "ID:11-026412",
        "INFO:Stab-Gunshot-Pen Trauma AT THE END OF  RD .");

    doTest("T6",
        "426:BAY POINT CT-JENNIS AV FELICIA 9103685110 11-026412 21:07:25 Stab-Gun-Trauma AT THE END OF BAYPOINT RD MALE SUBJ IS CUT",
        "ADDR:BAY POINT CT-JENNIS AV",
        "NAME:FELICIA",
        "PHONE:9103685110",
        "ID:11-026412",
        "INFO:Stab-Gun-Trauma AT THE END OF BAYPOINT RD MALE SUBJ IS CUT");

    doTest("T7",
        "415:111 SE 32ND ST OAK ISLAND  7045790781 MDL 09E01 11-025910 20:39:44 Cardiac or Resp Arrest - Death TRANS BY OKI... ADVD TH",
        "ADDR:111 SE 32ND ST",
        "CITY:OAK ISLAND",
        "PHONE:7045790781",
        "CODE:09E01",
        "ID:11-025910",
        "INFO:Cardiac or Resp Arrest - Death TRANS BY OKI... ADVD TH");

    doTest("T8",
        "411:22 BOUNDARYLINE DR NW C CALABASH LYNN 9102094924 11-025720 06:59:32 Structure Fire SMELL SOMETHING BURNING IN RESD,",
        "ADDR:22 BOUNDARYLINE DR NW C",
        "CITY:CALABASH",
        "NAME:LYNN",
        "PHONE:9102094924",
        "ID:11-025720",
        "INFO:Structure Fire SMELL SOMETHING BURNING IN RESD,");
  }
  

  public static void main(String[] args) {
    new NCBrunswickCountyParserTest().generateTests("T1", "ADDR CITY NAME PHONE CODE ID CALL INFO");
  }
}
