package net.anei.cadpage.parsers.MI;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class MISaginawCountyParserTest extends BaseParserTest {
  
  public MISaginawCountyParserTest() {
	  setParser(new MISaginawCountyParser(), "SAGINAW COUNTY", "MI");
  }
  
  @Test
  public void testParserDavidSmigiel() {

    doTest("T1",
        "LOC:S PORTSMOUTH RD / KING RD DESC:LAT: <43.384720>  LONG: <-83.837678> APT: TYP:*M*PDA PIN IN JUST OCCU",
        "ADDR:S PORTSMOUTH RD & KING RD",
        "GPS:43.384720,-83.837678",
        "CALL:PDA PIN IN JUST OCCU");
  }
  
  public void testTld2a() {

    doTest("T1",
        "LOC:2673 OHIO DESC:52/M DIFF BREATHING/CHEST PAINS APT: TYP:*M*SICK PERSON IN PROGRESS",
        "ADDR:2673 OHIO",
        "INFO:52/M DIFF BREATHING/CHEST PAINS",
        "CALL:SICK PERSON IN PROGRESS");

    doTest("T2",
        "LOC:3833 ORANGE ST DESC:79/F DIFF BREATHING/CHEST PAIN APT: TYP:*M*SICK PERSON IN PROGRESS",
        "ADDR:3833 ORANGE ST",
        "INFO:79/F DIFF BREATHING/CHEST PAIN",
        "CALL:SICK PERSON IN PROGRESS");

    doTest("T3",
        "LOC:3459 WOODLAND CT DESC:86 FE DIFF BREATHING APT: TYP:*M*SICK PERSON IN PROGRESS",
        "ADDR:3459 WOODLAND CT",
        "INFO:86 FE DIFF BREATHING",
        "CALL:SICK PERSON IN PROGRESS");

    doTest("T4",
        "LOC:4030 JORDAN DR DESC:80/M  CHEST PAIN APT: TYP:*M*SICK PERSON IN PROGRESS",
        "ADDR:4030 JORDAN DR",
        "INFO:80/M  CHEST PAIN",
        "CALL:SICK PERSON IN PROGRESS");

    doTest("T5",
        "LOC:S PORTSMOUTH RD / KING RD DESC:LAT: <43.384720>  LONG: <-83.837678> APT: TYP:*M*PDA PIN IN JUST OCCU",
        "ADDR:S PORTSMOUTH RD & KING RD",
        "GPS:43.384720,-83.837678",
        "CALL:PDA PIN IN JUST OCCU");

    doTest("T6",
        "LOC:7723 DIXIE HWY DESC: APT: TYP:*M*FIRE OUTSIDE",
        "ADDR:7723 DIXIE HWY",
        "CALL:FIRE OUTSIDE");

    doTest("T7",
        "LOC:2895 E MOORE RD DESC:80F CHEST PAIN APT: TYP:*M*SICK PERSON IN PROGRESS",
        "ADDR:2895 E MOORE RD",
        "INFO:80F CHEST PAIN",
        "CALL:SICK PERSON IN PROGRESS");
  }
  
  @Test
  public void testChrisGerding() {

    doTest("T1",
        "LOC:NICHOLS RD / ASHMAN DESC:ENG SQUAD TENDER APT: TYP:*M*MUTUAL AID",
        "ADDR:NICHOLS RD & ASHMAN",
        "INFO:ENG SQUAD TENDER",
        "CALL:MUTUAL AID");

  }
  
  @Test
  public void testEricBrown() {

    doTest("T1",
        "LOC:442 S 24TH DESC:32F- DIFF BREATH   STOMACH PAIN APT: TYP:*M*SICK PERSON IN PROGRESS",
        "ADDR:442 S 24TH",
        "INFO:32F- DIFF BREATH   STOMACH PAIN",
        "CALL:SICK PERSON IN PROGRESS");
  }
  
  @Test
  public void testJoshMosher() {

    doTest("T1",
        "LOC:4891 IRONWOOD ST DESC:GREASE SPILL - SMOKE NO FLAMES APT: TYP:*M*APPLIANCE FIRE",
        "ADDR:4891 IRONWOOD ST",
        "INFO:GREASE SPILL - SMOKE NO FLAMES",
        "CALL:APPLIANCE FIRE");

    doTest("T2",
        "LOC:4019 EMERICK ST DESC:BONFIRE IN BACK YD APT: TYP:*M*FIRE OUTSIDE",
        "ADDR:4019 EMERICK ST",
        "INFO:BONFIRE IN BACK YD",
        "CALL:FIRE OUTSIDE");

    doTest("T3",
        "LOC:4787 FASHION SQUARE BLVD DESC:MACY UPPERLEVEL SMELL OF ELECTRICAL BURN APT: TYP:*M*ELEVATOR ENTRAPMENT RESCUE",
        "ADDR:4787 FASHION SQUARE BLVD",
        "INFO:MACY UPPERLEVEL SMELL OF ELECTRICAL BURN",
        "CALL:ELEVATOR ENTRAPMENT RESCUE");

    doTest("T4",
        "LOC:GRATIOT RD / N CENTER RD DESC:PRINTER SHOP APT: TYP:*M*STRUCTURE FIRE",
        "ADDR:GRATIOT RD & N CENTER RD",
        "INFO:PRINTER SHOP",
        "CALL:STRUCTURE FIRE");

  }
  
  public static void main(String[] args) {
    new MISaginawCountyParserTest().generateTests("T1");
  }
}
