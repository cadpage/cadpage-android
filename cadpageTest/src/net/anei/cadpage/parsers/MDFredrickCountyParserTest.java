package net.anei.cadpage.parsers;

import org.junit.Test;


public class MDFredrickCountyParserTest extends BaseParserTest {
  
  public MDFredrickCountyParserTest() {
    setParser(new MDFredrickCountyParser(), "FREDRICK COUNTY", "MD");
  }
  
  @Test
  public void testParser() {
    doTest("T1",
        "(CAD) [FredCo] CT: HOUSE / FIRE-VISIBLE 6801 HARBAUGH RD CSAB:NEXT TO HER HOME ESZ: 626 MAP: 3996A6 Disp: [23]" ,
        "CALL:HOUSE/FIRE-VISIBLE",
        "ADDR:6801 HARBAUGH RD",
        "CITY:Sabillasville",
        "INFO:NEXT TO HER HOME",
        "BOX:626",
        "MAP:3996A6"
        );
    doTest("T2",
        "(CAD) [FredCo] CT: WOODS FIRE 7819 FRIENDS CREEK RD CEMB ESZ: 627 MAP: 3996F6 Disp: E63,B66,DNR [36]" ,
        "CALL:WOODS FIRE",
        "ADDR:7819 FRIENDS CREEK RD",
        "CITY:Emmitsburg",
        "UNIT:E63,B66,DNR",
        "BOX:627",
        "MAP:3996F6"
        );
    doTest("T3",
        "(CAD) [FredCo] CT: COMMERCIAL FIRE ALARM / AUTOMATIC 4 PAWS PL THUR: @CATOCTIN VETERINARY CLINIC ESZ: 1001 MAP: 4108E9 Disp: E102,TWR6 [37]" ,
        "CALL:COMMERCIAL FIRE ALARM/AUTOMATIC",
        "ADDR:4 PAWS PL",
        "CITY:Thurmont",
        "INFO:@CATOCTIN VETERINARY CLINIC",
        "UNIT:E102,TWR6",
        "BOX:1001",
        "MAP:4108E9"
        );
    doTest("T4",
        "(CAD) [FredCo] CT: PERSON FIRE (INSIDE) 16825 S SETON AVE CEMB: @NATIONAL EMERGENCY TRAINING CENTER:SIMULATION LAB ESZ: 620 MAP: 3997H9 Disp: [34]" ,
        "CALL:PERSON FIRE (INSIDE)",
        "ADDR:16825 S SETON AVE",
        "CITY:Emmitsburg",
        "INFO:@NATIONAL EMERGENCY TRAINING CENTER:SIMULATION LAB",
        "BOX:620",
        "MAP:3997H9"
        );
    doTest("T5",
        "(CAD) [FredCo] CT: OUTSIDE INVESTIGATION @MA ADAM CO: @RT15SB/BOYLE RD ESZ: -1 Disp: E63 [38]" ,
        "CALL:OUTSIDE INVESTIGATION",
        "ADDR:RT15SB/BOYLE RD",
        "UNIT:E63",
        "BOX:-1"
        );
    
  }
}