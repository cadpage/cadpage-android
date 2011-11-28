package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NCRutherfordCountyParserTest extends BaseParserTest {
  
  public NCRutherfordCountyParserTest() {
    setParser(new NCRutherfordCountyParser(), "RUTHERFORD COUNTY", "NC");
  }
  
  @Test
  public void testParser() {
    doTest("T1",
        "Paging: Location= 159 WALKER DR*\nAPT/ROOM* City=Forest City* Call \nType= FIRE STRUCT* Units=SMFD1*\nApr24,3:05am",
        "ADDR:159 WALKER DR",
        "CITY:Forest City",
        "CALL:FIRE STRUCT",
        "UNIT:SMFD1");

    doTest("T2",
        "Paging: Location= 557 US 221A HWY*\nAPT/ROOM* City=Forest City* Call \nType= FIRE POWERLN* Units=DUKE1, SMFD1*\nApr23,4:27am",
        "ADDR:557 US 221A HWY",
        "CITY:Forest City",
        "CALL:FIRE POWERLN",
        "UNIT:DUKE1, SMFD1");

    doTest("T3",
        "Paging: Location= 140 WALKER DR*\nAPT/ROOM* City=Forest City* Call \nType= FIRE ILLEGAL* Units=SMFD1*\nApr23,3:53am",
        "ADDR:140 WALKER DR",
        "CITY:Forest City",
        "CALL:FIRE ILLEGAL",
        "UNIT:SMFD1");

    doTest("T4",
        "Paging: Location= 139 GREENE RD*\nAPT/ROOM* City=Forest City* Call \nType= FIRE STRUCT* Units=SMFD1*\nApr19,5:36pm",
        "ADDR:139 GREENE RD",
        "CITY:Forest City",
        "CALL:FIRE STRUCT",
        "UNIT:SMFD1");

    doTest("T5",
        "Paging: Location= HIGH SHOALS CHURCH RD*\nAPT/ROOM* City=Cliffside* Call \nType= FIRE STRUCT* Units=CFD1, EFD1,SMFD1*\nApr18,10:50pm",
        "ADDR:HIGH SHOALS CHURCH RD",
        "CITY:Cliffside",
        "CALL:FIRE STRUCT",
        "UNIT:CFD1, EFD1,SMFD1");

    doTest("T6",
        "Paging: Location= OLD HENRIETTA RD & BYERS RD*\nAPT/ROOM* City=Ellenboro* Call \nType= STRANGE ODOR* Units=SMFD1*\nApr 25,10:59am",
        "ADDR:OLD HENRIETTA RD & BYERS RD",
        "CITY:Ellenboro",
        "CALL:STRANGE ODOR",
        "UNIT:SMFD1");

    doTest("T7",
        "Paging: Location= US221 S HWY & HARRIS HENRIETTA RD*\nAPT/ROOM* City=Forest City* Call \nType= ACCIDENT PI* Units=SMFD1,RCR1,EMS1*\nApr 25, 3:31pm",
        "ADDR:US221 S HWY & HARRIS HENRIETTA RD",
        "MADDR:US 221 S HWY & HARRIS HENRIETTA RD",
        "CITY:Forest City",
        "CALL:ACCIDENT PI",
        "UNIT:SMFD1,RCR1,EMS1");

    doTest("T8",
        "Paging:Location=376 WOMACK LAKE RD* APT/ROOM* City=FOREST CITY* Call Type=ACCIDENT F* Units=428,MED10,RCR1,SMFD1*",
        "ADDR:376 WOMACK LAKE RD",
        "CITY:FOREST CITY",
        "CALL:ACCIDENT F",
        "UNIT:428,MED10,RCR1,SMFD1");

    doTest("T9",
        "prvs=11539c2346=paging@rutherfordcountync.gov (Message Forwarded by PageGate) Location=WITHROW RD & HUDLOW*\nAPT/ROOM*\n\nCity=FOREST CITY*\n\nCall Type=ACCIDENT PI*\n\n\n\nUnits=103,FCFD1,",
        "ADDR:WITHROW RD & HUDLOW",
        "CITY:FOREST CITY",
        "CALL:ACCIDENT PI",
        "UNIT:103,FCFD1,");
    
  }

public static void main(String[] args) {
    new NCRutherfordCountyParserTest().generateTests("T9");
  }

}