package net.anei.cadpage.parsers;

import org.junit.Test;


public class MDFrederickCountyParserTest extends BaseParserTest {
  
  public MDFrederickCountyParserTest() {
    setParser(new MDFrederickCountyParser(), "FREDERICK COUNTY", "MD");
  }
  
  @Test
  public void testBadMsg() {
    doBadTest("I will be there till about 11 so if u want come on in");
  }
  
  @Test
  public void testParser() {
        
    doTest("T1",
        "(CAD) [FredCo] CT: HOUSE / FIRE-VISIBLE 6801 HARBAUGH RD CSAB:NEXT TO HER HOME ESZ: 626 MAP: 3996A6 Disp: [23]" ,
        "CALL:HOUSE/FIRE-VISIBLE",
        "ADDR:6801 HARBAUGH RD",
        "CITY:Sabillasville",
        "PLACE:NEXT TO HER HOME",
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
        "PLACE:@CATOCTIN VETERINARY CLINIC",
        "UNIT:E102,TWR6",
        "BOX:1001",
        "MAP:4108E9"
        );
    doTest("T4",
        "(CAD) [FredCo] CT: PERSON FIRE (INSIDE) 16825 S SETON AVE CEMB: @NATIONAL EMERGENCY TRAINING CENTER:SIMULATION LAB ESZ: 620 MAP: 3997H9 Disp: [34]" ,
        "CALL:PERSON FIRE (INSIDE)",
        "ADDR:16825 S SETON AVE",
        "CITY:Emmitsburg",
        "PLACE:@NATIONAL EMERGENCY TRAINING CENTER:SIMULATION LAB",
        "BOX:620",
        "MAP:3997H9"
        );
    doTest("T5",
        "(CAD) [FredCo] CT: OUTSIDE INVESTIGATION @MA ADAM CO: @RT15SB/BOYLE RD ESZ: -1 Disp: E63 [38]" ,
        "CALL:Mutual Aid: OUTSIDE INVESTIGATION",
        "ADDR:RT15SB & BOYLE RD",
        "CITY:Adams County",
        "ST:PA",
        "UNIT:E63",
        "BOX:-1"
        );
    doTest("T5A",
        "(CAD) [FredCo] CT: OUTSIDE INVESTIGATION @MA ADAM CO ESZ: -1 Disp: E63 [38]" ,
        "CALL:Mutual Aid: OUTSIDE INVESTIGATION",
        "CITY:Adams County",
        "ST:PA",
        "UNIT:E63",
        "BOX:-1"
        );
    doTest("T6",
        "(FredCo) [CAD] CT: CHEST PAIN  1811 MONOCACY BLVD FRE1: @WAL MART: PHARMACY  ESZ: 215 MAP: 4448J9  Disp: A29,A247,M17",
        "CALL:CHEST PAIN",
        "ADDR:1811 MONOCACY BLVD",
        "CITY:Frederick City",
        "PLACE:@WAL MART: PHARMACY",
        "MAP:4448J9",
        "UNIT:A29,A247,M17",
        "BOX:215"
        );
    
    doTest("T7",
        "(FredCo) [CAD] CT: HOUSE / FIRE-VISIBLE CACO: @MA CARRCO: 1594 BAUST CHURCH RD ESZ: 9902 Disp: ET94,",
        "CALL:Mutual Aid: HOUSE / FIRE-VISIBLE CACO:",
        "ADDR:1594 BAUST CHURCH RD",
        "CITY:Carroll County",
        "BOX:9902",
        "UNIT:ET94,");
    
    doTest("T18",
        "[FredCo] CT: INJURY FROM VEHICLE ACCIDENT LL(-77:23:59.6013,39:21:53.1520): @I270NB / MONOCACY RIVER ESZ: 327002 MAP: 46",
        "CALL:INJURY FROM VEHICLE ACCIDENT",
        "ADDR:LL(-77:23:59.6013,39:21:53.1520)",
        "PLACE:@I270NB / MONOCACY RIVER",
        "BOX:327002",
        "MAP:46");
        
    
  }
}