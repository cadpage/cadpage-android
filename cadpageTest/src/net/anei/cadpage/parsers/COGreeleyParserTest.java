package net.anei.cadpage.parsers;

import org.junit.Test;


public class COGreeleyParserTest extends BaseParserTest {
  
  public COGreeleyParserTest() {
    setParser(new COGreeleyParser(), "Greeley", "CO");
  }
  
  @Test
  public void testParser() {
    doTest("T1",
        "20442,ALARMF,23691 CR 60H.E1 E4 L1,TEXT:AUDIBLE FROM GENERAL AND SMOKE DETECTOR \\COMP:1ST CLASS SECURITY \\PH:800 482 9800," ,
        "CALL:ALARMF",
        "ADDR:23691 CR 60H",
        "ID:20442",
        "UNIT:E1 E4 L1",
        "INFO:AUDIBLE FROM GENERAL AND SMOKE DETECTOR"
        );
    doTest("T2",
    	"20431,SMKODR,1ST ST/8TH AV.E4 L1,TEXT:SMELL OF NATURAL GAS ALL OVER THE AREA \\COMP:W012,",
    	"CALL:SMKODR",
    	"ADDR:1ST ST/8TH AV",
    	"ID:20431",
    	"UNIT:E4 L1",
    	"INFO:SMELL OF NATURAL GAS ALL OVER THE AREA"
    		);
    doTest("T3",
    	"20373,SMKODR,10TH AV/22ND ST.E4 R1,TEXT:STRONG SMELL OF NATURAL GAS IN AIR IN THIS AREA \\COMP:MIKE RUANE \\PH:608 630 2959,",	
    	"CALL:SMKODR",
    	"ADDR:10TH AV/22ND ST",
    	"ID:20373",
    	"UNIT:E4 R1",
    	"INFO:STRONG SMELL OF NATURAL GAS IN AIR IN THIS AREA"
    );
    doTest("T4",
    	"20032,SMKODR,2114 BLUEBELL AV.E4 R1,TEXT:FROM THE SOUTH, STRONG SMELL OF NATURAL GAS UNK WHERE ITS COMING FROM,",
    	"CALL:SMKODR",
    	"ADDR:2114 BLUEBELL AV",
    	"ID:20032",
    	"UNIT:E4 R1",
    	"INFO:FROM THE SOUTH, STRONG SMELL OF NATURAL GAS UNK WHERE ITS COMING FROM,"
	);
    doTest("T5",
    	"19897,ALARMF,2013 1ST AV.E4 E1 L1,TEXT:AUDIBLE COMING FROM PULL STATION  NW DOOR, NO ATC, PREM PH 970 674 1957 \\COMP:OP 311 SHERLOCK PLUS \\PH:800 443",
    	"CALL:ALARMF",
    	"ADDR:2013 1ST AV",
    	"ID:19897",
    	"UNIT:E4 E1 L1",
    	"INFO:AUDIBLE COMING FROM PULL STATION  NW DOOR, NO ATC, PREM PH 970 674 1957"
	);
    doTest("T6",
    	"19547,AIRAF ,600 AIRPORT RD.E4,TEXT:PLANE COMING IN WITHOUT LANDING GEAR.  RP WANTS FIRE AND MEDICAL TO RESPOND AND STANDBY. \\COMP:MANDY \\PH:336-3000,",
    	"CALL:AIRAF",
    	"ADDR:600 AIRPORT RD",
    	"ID:19547",
    	"UNIT:E4",
    	"INFO:PLANE COMING IN WITHOUT LANDING GEAR.  RP WANTS FIRE AND MEDICAL TO RESPOND AND STANDBY."
    );
    
  }
}