package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.NC.NCPolkCountyParserTest;

import org.junit.Test;


public class NCPolkCountyParserTest extends BaseParserTest {
  
  public NCPolkCountyParserTest() {
    setParser(new NCPolkCountyParser(), "POLK COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "polkcounty911:767 THERMAL VIEW DR TRYON SMITH 828817313307:38:26 FALL VICTIM 89 YO FEMALE FROM STORY RD TO SKYUKA RD",
        "ADDR:767 THERMAL VIEW DR",
        "CITY:TRYON",
        "NAME:SMITH",
        "ID:8288173133",
        "INFO:FALL VICTIM 89 YO FEMALE",
        "X:STORY RD TO SKYUKA RD");

    doTest("T2",
        "polkcounty911:1426 HAYES RD COLUMBUS 07:20:59 TREE DOWN CONTS FROM S PEAK ST TO PENIEL RD",
        "ADDR:1426 HAYES RD",
        "CITY:COLUMBUS",
        "INFO:TREE DOWN CONTS",
        "X:S PEAK ST TO PENIEL RD");

    doTest("T3",
        "polkcounty911:418 S PEAK ST COLUMBUS EARLY, DORIS 8288948807 13:09:13 MEDICAL EMERGEN 86 YO VERY WEAK FROM E MILLS ST AND CONTS AS HAYES RD",
        "ADDR:418 S PEAK ST",
        "CITY:COLUMBUS",
        "NAME:EARLY, DORIS",
        "ID:8288948807",
        "INFO:MEDICAL EMERGEN 86 YO VERY WEAK",
        "X:E MILLS ST AND CONTS AS HAYES RD");

    doTest("T4",
        "polkcounty911:429 LOCKHART RD TRYON RHONDA 828859020509:57:24 MEDICAL EMERGEN 38 YO LEFT LEG PAINNUMB FOOT FROM W HOWARD ST TO LANIER LN",
        "ADDR:429 LOCKHART RD",
        "CITY:TRYON",
        "NAME:RHONDA",
        "ID:8288590205",
        "INFO:MEDICAL EMERGEN 38 YO LEFT LEG PAINNUMB FOOT",
        "X:W HOWARD ST TO LANIER LN");

    doTest("T5",
        "polkcounty911:86 GREENVILLE ST SALUDA PAT 8287494411 13:49:40 CHOKING FEMALE CHOKING FOR PAST HOUR//PALE",
        "ADDR:86 GREENVILLE ST",
        "CITY:SALUDA",
        "NAME:PAT",
        "ID:8287494411",
        "INFO:CHOKING FEMALE CHOKING FOR PAST HOUR//PALE");

    doTest("T6",
        "polkcounty911:159 LANIER DR COLUMBUS John 8643030507 08:08:08 UNCONSCIOUS 75 yo man with cancer.",
        "ADDR:159 LANIER DR",
        "CITY:COLUMBUS",
        "NAME:John",
        "ID:8643030507",
        "CALL:UNCONSCIOUS 75",
        "INFO:yo man with cancer.");

    doTest("T7",
        "polkcounty911:1 GREEN RIVER COVE RD mill spring carol 8288179441 09:52:03 DOWN POWER LINE FROM S NC 9 HWY TO RUTHERFORD CO LINE",
        "ADDR:1 GREEN RIVER COVE RD",
        "CITY:mill spring",
        "NAME:carol",
        "ID:8288179441",
        "INFO:DOWN POWER LINE",
        "X:S NC 9 HWY TO RUTHERFORD CO LINE");

    doTest("T8",
        "Polkcounty911:1733 E US 74 HWY before pea ridge rd MILL SPRING 423637001121:49:01 10-50. June 9, 9:48 PM",
        "ADDR:1733 E US 74 HWY",
        "X:pea ridge rd",
        "CITY:MILL SPRING",
        "ID:4236370011",
        "CALL:10-50");

    doTest("T9",
        "polkcounty911:26 KELLY LN MILL SPRING 8288948141 16:50:54 SEIZURES 25 Y/O MALE SEIZING FROM CHIMNEY ROCK RD TO DEAD END. June 10 4:50 PM.",
        "ADDR:26 KELLY LN",
        "CITY:MILL SPRING",
        "ID:8288948141",
        "INFO:SEIZURES 25 Y/O MALE SEIZING",
        "X:CHIMNEY ROCK RD TO DEAD END");

    doTest("T10",
        "polkcounty911:935 POLK COUNTY LINE RD RUTHERFORDTON BAILY, PHILLIP 8287489222 14:23:05 VEHICLE FIRE 18 WHEELER LOADED WITH LUMBER ON FIRE FROM ROCK SPRINGS. June 11, 2:21 PM.",
        "ADDR:935 POLK COUNTY LINE RD",
        "CITY:RUTHERFORDTON",
        "NAME:BAILY, PHILLIP",
        "ID:8287489222",
        "INFO:VEHICLE FIRE 18 WHEELER LOADED WITH LUMBER ON FIRE",
        "X:ROCK SPRINGS");

    doTest("T11",
        "polkcounty911:4861 E NC 108 HWY MILL SPRING SLIMPLEX GRENELL 888746753911:28:38 FIRE ALARM BUILDING ONE FROM HOUSTON RD/WALKER ST TO RUTHERFORD CO LINE. June 14, 11:29 AM.",
        "ADDR:4861 E NC 108 HWY",
        "CITY:MILL SPRING",
        "NAME:SLIMPLEX GRENELL",
        "ID:8887467539",
        "INFO:FIRE ALARM BUILDING ONE",
        "X:HOUSTON RD/WALKER ST TO RUTHERFORD CO LINE");

    doTest("T12",
        "polkcounty911:620 BURT BLACKWELL RD MILL SPRING QUANDT, LEONARD & CRYSTAL 8288946023 13:27:52 SMOKE COMPLAINT ACROSS FROM THE ABOVE ADDRESS NEAR DUKE POWER. June 15, 1:28 PM",
        "ADDR:620 BURT BLACKWELL RD",
        "CITY:MILL SPRING",
        "NAME:QUANDT, LEONARD & CRYSTAL",
        "ID:8288946023",
        "INFO:SMOKE COMPLAINT ACROSS",
        "X:THE ABOVE ADDRESS NEAR DUKE POWER");

    doTest("T13",
        "polkcounty911:1 COLUMBUS FIRE DEPT 2201 17:54:26 STANDBY REQUEST MSFD STANDBY FOR THEM REF RESOURCES DEPLETED. June 18, 5:55 PM",
        "ADDR:1 COLUMBUS FIRE DEPT 2201",
        "INFO:STANDBY REQUEST MSFD STANDBY FOR THEM REF RESOURCES DEPLETED");

    doTest("T14",
        "polkcounty911:1 GREEN RIVER COVE RD mill spring carol 8288179441 09:52:03 DOWN POWER LINE FROM S NC 9 HWY TO RUTHERFORD CO LINE. June 19 9:53 AM.",
        "ADDR:1 GREEN RIVER COVE RD",
        "CITY:mill spring",
        "NAME:carol",
        "ID:8288179441",
        "INFO:DOWN POWER LINE",
        "X:S NC 9 HWY TO RUTHERFORD CO LINE");
  }
  
  public static void main(String[] args) {
    new NCPolkCountyParserTest().generateTests("T1", "ADDR CITY NAME ID CALL INFO X");
  }
}
