package net.anei.cadpage.parsers;

import org.junit.Test;


public class MDWorcesterCountyParserTest extends BaseParserTest {
  
  public MDWorcesterCountyParserTest() {
    setParser(new MDWorcesterCountyParser(), "WORCESTER COUNTY", "MD");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "CAD:300;FALLS;5914 BOX IRON RD;GIRDLETREE;PINE ST;TAYLOR LANDING RD;11/23/2010 08:31:38",
        "CALL:FALLS",
        "ADDR:5914 BOX IRON RD",
        "CITY:GIRDLETREE",
        "X:PINE ST & TAYLOR LANDING RD",
        "UNIT:300"
        );
    doTest("T2",
            "CAD:100;TRAFFIC TRANSPORTATION ACC;3543 AYDELOTTE RD;DIST: 7.94 FT;POCOMOKE;BRANTLEY RD;SHEEPHOUSE RD;11/16/2010 00:31:42",
            "CALL:TRAFFIC TRANSPORTATION ACC",
            "ADDR:3543 AYDELOTTE RD",
            "CITY:POCOMOKE",
            "X:BRANTLEY RD & SHEEPHOUSE RD",
            "INFO:DIST: 7.94 FT",
            "UNIT:100"
            );
    doTest("T3",
            "CAD:100;FIRE ALARM;125 NEWTOWNE BLVD;HOLIDAY INN EXPRESS;POCOMOKE;OLD SNOW HILL RD;11/12/2010 08:15:38",
            "CALL:FIRE ALARM",
            "ADDR:125 NEWTOWNE BLVD",
            "CITY:POCOMOKE",
            "X:OLD SNOW HILL RD",
            "INFO:HOLIDAY INN EXPRESS",
            "UNIT:100"
            );
    doTest("T4",
            "CAD:100;UNCONSCIOUS FAINTING;1130 OLD VIRGINIA RD;POCOMOKE NAZARENE CHURCH;POCOMOKE;OCEAN HWY;SOUTHERN FIELDS DR;10/17/2010 11:32:35",
            "CALL:UNCONSCIOUS FAINTING",
            "ADDR:1130 OLD VIRGINIA RD",
            "CITY:POCOMOKE",
            "X:OCEAN HWY & SOUTHERN FIELDS DR",
            "INFO:POCOMOKE NAZARENE CHURCH",
            "UNIT:100"
            );

    

 
  }
}
