package net.anei.cadpage.parsers;

import org.junit.Test;


public class SCYorkCountyParserTest extends BaseParserTest {
  
  public SCYorkCountyParserTest() {
    setParser(new SCYorkCountyParser(), "YORK COUNTY", "SC");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "F212  P: 2 LOC: 375 STARLIGHT DR X: CAUSE WAY LN / ZENITH AV * * Fort Mill * * Trauma * MED OPS 2//FALL W/INJURY * RYAN CORNWEL NAR:  FRONT OF MOTEL CALLER WILL FLAG THEM DOWN  RM 374/53 YOM FELL OFF SCAFFOLDING LAST WEEK FELL AGAIN TODAY/HIP PAIN  INC#: 2010-00009042",
        "UNIT:F212",
        "ADDR:375 STARLIGHT DR",
        "X:CAUSE WAY LN / ZENITH AV",
        "CITY:Fort Mill",
        "CALL:Trauma - MED OPS 2//FALL W/INJURY",
        "INFO:FRONT OF MOTEL CALLER WILL FLAG THEM DOWN  RM 374/53 YOM FELL OFF SCAFFOLDING LAST WEEK FELL AGAIN TODAY/HIP PAIN",
        "ID:2010-00009042");
   
    doTest("T2",
        "FM2  P: 1 LOC: 9657 BLACK HORSE RUN X: * * * * Structure Fire * YCF OPS 2/STR FIRE * LANCASTER CNTY NAR:  HWY 521 CHARLOTTE HWY  FT MILL ASSIST ON MUTUAL AIDE  INC#: 2010-00000702", 
        "UNIT:FM2",
        "ADDR:9657 BLACK HORSE RUN",
        "CALL:Structure Fire - YCF OPS 2/STR FIRE",
        "INFO:HWY 521 CHARLOTTE HWY  FT MILL ASSIST ON MUTUAL AIDE",
        "ID:2010-00000702");
    
    doTest("T3",
        "RFE1 RFE5 RFE2 RFL1 RFB1  P: 1 LOC: 229 BLANCHE CIR X: STROUPE ST / CRAWFORD RD * CRAWFORD PARK * Rock Hill * * Structure Fire * RHF OPS 2/ STRUCT FIRE * NAR:  ABANDONED HOUSE ON FIRE, FLAMES VISIBLE  INC#: 2010-00005928",
        "UNIT:RFE1 RFE5 RFE2 RFL1 RFB1",
        "ADDR:229 BLANCHE CIR",
        "X:STROUPE ST / CRAWFORD RD",
        "PLACE:CRAWFORD PARK",
        "CITY:Rock Hill",
        "CALL:Structure Fire - RHF OPS 2/ STRUCT FIRE",
        "INFO:ABANDONED HOUSE ON FIRE, FLAMES VISIBLE",
        "ID:2010-00005928");
    
    doTest("T4",
        "P: 1 LOC: E  MAIN ST X: S  ANDERSON RD * * Rock Hill * * Vehicle Fire * YCF OPS 2/VEHICLE FIRE * STANLEY YOUNG NAR:  SMOKE COMING FROM HIS CAR//IN THE PARKING LOT ROCK TAVERN AND BAR NUMBER 2  INC#: 2010-00000439",
        "ADDR:E  MAIN ST",
        "X:S  ANDERSON RD",
        "CITY:Rock Hill",
        "CALL:Vehicle Fire - YCF OPS 2/VEHICLE FIRE",
        "INFO:SMOKE COMING FROM HIS CAR//IN THE PARKING LOT ROCK TAVERN AND BAR NUMBER 2",
        "ID:2010-00000439");
    
    doTest("T5",
        "EMS2  P: 2 LOC: 831 MCDOW DR X: ALABAMA CT / CHARLOTTE AV * * Rock Hill * * Medical * MED OPS 2/RENAL PROBLEMS * WESTMINSTER HEALTH & NAR:  82YOF/BLEEDING FROM HER CATHATER AND HAS A KIDNEY INFECTION  INC#: 2010-00023193",
        "UNIT:EMS2",
        "ADDR:831 MCDOW DR",
        "X:ALABAMA CT / CHARLOTTE AV",
        "CITY:Rock Hill",
        "CALL:Medical - MED OPS 2/RENAL PROBLEMS",
        "INFO:82YOF/BLEEDING FROM HER CATHATER AND HAS A KIDNEY INFECTION",
        "ID:2010-00023193");
    
    doTest("T6",
        "RFE4 RFE2 RFL1 RFB1  P: 1 LOC: 1830 W  MAIN ST X: CARDINAL POINTE DR / BRITTANY RIDGE PL, FINCHER RD * * Rock Hill * * Fire Alarm * RHF OPS2 / COMM FIRE ALARM * NAR:  INC#: 2010-00005938", 
        "UNIT:RFE4 RFE2 RFL1 RFB1",
        "ADDR:1830 W  MAIN ST",
        "X:CARDINAL POINTE DR / BRITTANY RIDGE PL, FINCHER RD",
        "CITY:Rock Hill",
        "CALL:Fire Alarm - RHF OPS2 / COMM FIRE ALARM",
        "ID:2010-00005938");

    doTest("T7",
        "YRS1 EMS6  P: 1 LOC: 24 CANNON CT X: DEAD END / ROSS CANNON ST * * York * * Medical Emergency * MED OPS 2 / GI BLEED * NAR:  INC#: 2010-00002884",
        "UNIT:YRS1 EMS6",
        "ADDR:24 CANNON CT",
        "X:DEAD END / ROSS CANNON ST",
        "CITY:York",
        "CALL:Medical Emergency - MED OPS 2 / GI BLEED",
        "ID:2010-00002884");

    doTest("T8",
        "CRS1 EMS5  P: 1 LOC: 2715 FILBERT HWY X: GOOD RD / SOUTHBEND RD * * Clover * * Medical Emergency * MED OPS 3/TROUBLE BREATHING * DEBBIE MITCHEL NAR:  INC#: 2010-00001750", 
        "UNIT:CRS1 EMS5",
        "ADDR:2715 FILBERT HWY",
        "X:GOOD RD / SOUTHBEND RD",
        "CITY:Clover",
        "CALL:Medical Emergency - MED OPS 3/TROUBLE BREATHING",
        "ID:2010-00001750");

    doTest("T9",
        "EMS1 RFE3  P: 1 LOC: 227 LONE OAK CIR X: INDIA HOOK RD / INDIA HOOK RD * VILLAGE AT INDIA HOOK * Rock Hill VILLAGE AT IND * * Medical Emergency * MED OPS 2 / DIABETIC  * LINDEMANN C DR NAR:  INC#: 2010-00023236", 
        "UNIT:EMS1 RFE3",
        "ADDR:227 LONE OAK CIR",
        "X:INDIA HOOK RD / INDIA HOOK RD",
        "PLACE:VILLAGE AT INDIA HOOK",
        "CITY:Rock Hill VILLAGE AT IND",
        "CALL:Medical Emergency - MED OPS 2 / DIABETIC",
        "ID:2010-00023236");

    doTest("T10",
        "EMS9  P: 1 LOC: 101 SEDGEWOOD DR X: EBENEZER RD / WINTHROP DR * * Rock Hill * * Trauma Emergency * MED OPS 2/SUICIDE ATTEMPT * SAUNDRA WHITE NAR:  RHPD ADVISED  18 YOM/TIED SHIRT AROUND HIS NECK/STUCK HEAD IN TOILET/COMBATIVE/HAS BEEN GIVEN MEDS TO HELP HIM CALM DOWN/BANGING HEAD ON WALL/ENTER AT FRONT OF FACILITY BEHIND FOUNDERS  INC#: 2010-00023234",
        "UNIT:EMS9",
        "ADDR:101 SEDGEWOOD DR",
        "X:EBENEZER RD / WINTHROP DR",
        "CITY:Rock Hill",
        "CALL:Trauma Emergency - MED OPS 2/SUICIDE ATTEMPT",
        "INFO:RHPD ADVISED  18 YOM/TIED SHIRT AROUND HIS NECK/STUCK HEAD IN TOILET/COMBATIVE/HAS BEEN GIVEN MEDS TO HELP HIM CALM DOWN/BANGING HEAD ON WALL/ENTER AT FRONT OF FACILITY BEHIND FOUNDERS",
        "ID:2010-00023234");
    
  }
}