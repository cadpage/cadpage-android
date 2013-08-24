package net.anei.cadpage.parsers.IA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Warren County, IA
Contact: Jason Davis <onceamedic@gmail.com>
Sender: messaging@iamresponding.com

S:INDF M:CFS#: 2013-01188\nCallType: MEDICAL / AMBULANCE CALL\nAddress: 1203 N E ST, IA
S:INDF M:CFS#: 2013-01890\nCallType: FIRE - VEHICLE\nAddress: HWY 65 69 / G 24 HWY, IA
S:INDF M:CFS#: 2013-01883\nCallType: MEDICAL / AMBULANCE CALL\nAddress: 506 S D ST Apt:9, INDIANOLA, IA
S:INDF M:CFS#: 2013-01695\nCallType: MEDICAL / AMBULANCE CALL\nAddress: 307 E SCENIC VALLEY AVE, INDIANOLA, IA
S:INDF M:CFS#: 2013-01979\nCallType: MEDICAL / AMBULANCE CALL\nAddress: 121 MAIN ST, ST MARYS, IA

 */

public class IAWarrenCountyParserTest extends BaseParserTest {
  
  public IAWarrenCountyParserTest() {
    setParser(new IAWarrenCountyParser(), "WARREN COUNTY", "IA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "S:INDF M:CFS#: 2013-01188\nCallType: MEDICAL / AMBULANCE CALL\nAddress: 1203 N E ST, IA",
        "SRC:INDF",
        "ID:2013-01188",
        "CALL:MEDICAL / AMBULANCE CALL",
        "ADDR:1203 N E ST",
        "ST:IA");

    doTest("T2",
        "S:INDF M:CFS#: 2013-01890\nCallType: FIRE - VEHICLE\nAddress: HWY 65 69 / G 24 HWY, IA",
        "SRC:INDF",
        "ID:2013-01890",
        "CALL:FIRE - VEHICLE",
        "ADDR:HWY 65 69 & G 24 HWY",
        "MADDR:HWY 65 69 & G HWY 24",
        "ST:IA");

    doTest("T3",
        "S:INDF M:CFS#: 2013-01883\nCallType: MEDICAL / AMBULANCE CALL\nAddress: 506 S D ST Apt:9, INDIANOLA, IA",
        "SRC:INDF",
        "ID:2013-01883",
        "CALL:MEDICAL / AMBULANCE CALL",
        "ADDR:506 S D ST",
        "APT:9",
        "CITY:INDIANOLA",
        "ST:IA");

    doTest("T4",
        "S:INDF M:CFS#: 2013-01695\nCallType: MEDICAL / AMBULANCE CALL\nAddress: 307 E SCENIC VALLEY AVE, INDIANOLA, IA",
        "SRC:INDF",
        "ID:2013-01695",
        "CALL:MEDICAL / AMBULANCE CALL",
        "ADDR:307 E SCENIC VALLEY AVE",
        "CITY:INDIANOLA",
        "ST:IA");

    doTest("T5",
        "S:INDF M:CFS#: 2013-01979\nCallType: MEDICAL / AMBULANCE CALL\nAddress: 121 MAIN ST, ST MARYS, IA",
        "SRC:INDF",
        "ID:2013-01979",
        "CALL:MEDICAL / AMBULANCE CALL",
        "ADDR:121 MAIN ST",
        "CITY:ST MARYS",
        "ST:IA");

  }
  
  public static void main(String[] args) {
    new IAWarrenCountyParserTest().generateTests("T1");
  }
}