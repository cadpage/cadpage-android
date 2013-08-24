package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/* 
Rutherford County, NC
Contact: Jeffrey Lynn <lynnj163@yahoo.com>
Sender: paging@rutherfordcountync.gov

Paging: Location= 159 WALKER DR*\nAPT/ROOM* City=Forest City* Call \nType= FIRE STRUCT* Units=SMFD1*\nApr24,3:05am
Paging: Location= 557 US 221A HWY*\nAPT/ROOM* City=Forest City* Call \nType= FIRE POWERLN* Units=DUKE1, SMFD1*\nApr23,4:27am
Paging: Location= 140 WALKER DR*\nAPT/ROOM* City=Forest City* Call \nType= FIRE ILLEGAL* Units=SMFD1*\nApr23,3:53am
Paging: Location= 139 GREENE RD*\nAPT/ROOM* City=Forest City* Call \nType= FIRE STRUCT* Units=SMFD1*\nApr19,5:36pm
Paging: Location= HIGH SHOALS CHURCH RD*\nAPT/ROOM* City=Cliffside* Call \nType= FIRE STRUCT* Units=CFD1, EFD1,SMFD1*\nApr18,10:50pm
Paging: Location= OLD HENRIETTA RD & BYERS RD*\nAPT/ROOM* City=Ellenboro* Call \nType= STRANGE ODOR* Units=SMFD1*\nApr 25,10:59am
Paging: Location= US221 S HWY & HARRIS HENRIETTA RD*\nAPT/ROOM* City=Forest City* Call \nType= ACCIDENT PI* Units=SMFD1,RCR1,EMS1*\nApr 25, 3:31pm

Contact: Jeff Lynn <lynnj163@gmail.com>
Paging:Location=376 WOMACK LAKE RD* APT/ROOM* City=FOREST CITY* Call Type=ACCIDENT F* Units=428,MED10,RCR1,SMFD1*

Contact: Ferrell Hamrick <fireball3412@gmail.com>
prvs=11539c2346=paging@rutherfordcountync.gov (Message Forwarded by PageGate) Location=WITHROW RD & HUDLOW*\nAPT/ROOM*\n\nCity=FOREST CITY*\n\nCall Type=ACCIDENT PI*\n\n\n\nUnits=103,FCFD1,

Contact: Active911
[] Paging:Line1=2012-059502* Location=1600 US 221S HWY* APT/ROOM=* City=FOREST CITY* Call Type=EMS CHESTPAI* Line11=CHEST PAIN (NON-TRAUMATIC)* Units=ems1,MED11,vls1*\r\n\n
[] Paging:Location=108 PATCHES LN* APT/ROOM=* City=BOSTIC* Call Type=EMS DIFF BRE* Units=802,MED30,RCR1*\r\n\n
[] Paging:Line1=2012-059515* Location=394 SHENANDOAH DR* APT/ROOM=* City=Spindale* Call Type=EMS CHESTPAI* Line11=CHEST PAIN (NON-TRAUMATIC)* Units=MED10*\r\n\n
[] Paging:Line1=2012-059516* Location=113 GOLD TREE LN* APT/ROOM=* City=RUTHERFORDTON* Call Type=EMS CHESTPAI* Line11=CHEST PAIN (NON-TRAUMATIC)* Units=MED11*\r\n\n
[] Paging:Line1=2012-059517* Location=SANDY MUSH* APT/ROOM=* City=RUTHERFORDTON* Call Type=STAND BY* Line11=STAND BY* Units=MED40*\r\n\n
[] Paging:Location=1172 PINEY RIDGE RD* APT/ROOM=* City=FOREST CITY* Call Type=EMS CHESTPAI* Units=MED40,RCR1*\r\n\n

*/

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
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "[] Paging:Line1=2012-059502* Location=1600 US 221S HWY* APT/ROOM=* City=FOREST CITY* Call Type=EMS CHESTPAI* Line11=CHEST PAIN (NON-TRAUMATIC)* Units=ems1,MED11,vls1*\r\n\n",
        "ADDR:1600 US 221S HWY",
        "CITY:FOREST CITY",
        "CALL:EMS CHESTPAI",
        "INFO:CHEST PAIN (NON-TRAUMATIC)",
        "UNIT:ems1,MED11,vls1");

    doTest("T2",
        "[] Paging:Location=108 PATCHES LN* APT/ROOM=* City=BOSTIC* Call Type=EMS DIFF BRE* Units=802,MED30,RCR1*\r\n\n",
        "ADDR:108 PATCHES LN",
        "CITY:BOSTIC",
        "CALL:EMS DIFF BRE",
        "UNIT:802,MED30,RCR1");

    doTest("T3",
        "[] Paging:Line1=2012-059515* Location=394 SHENANDOAH DR* APT/ROOM=* City=Spindale* Call Type=EMS CHESTPAI* Line11=CHEST PAIN (NON-TRAUMATIC)* Units=MED10*\r\n\n",
        "ADDR:394 SHENANDOAH DR",
        "CITY:Spindale",
        "CALL:EMS CHESTPAI",
        "INFO:CHEST PAIN (NON-TRAUMATIC)",
        "UNIT:MED10");

    doTest("T4",
        "[] Paging:Line1=2012-059516* Location=113 GOLD TREE LN* APT/ROOM=* City=RUTHERFORDTON* Call Type=EMS CHESTPAI* Line11=CHEST PAIN (NON-TRAUMATIC)* Units=MED11*\r\n\n",
        "ADDR:113 GOLD TREE LN",
        "CITY:RUTHERFORDTON",
        "CALL:EMS CHESTPAI",
        "INFO:CHEST PAIN (NON-TRAUMATIC)",
        "UNIT:MED11");

    doTest("T5",
        "[] Paging:Line1=2012-059517* Location=SANDY MUSH* APT/ROOM=* City=RUTHERFORDTON* Call Type=STAND BY* Line11=STAND BY* Units=MED40*\r\n\n",
        "ADDR:SANDY MUSH",
        "CITY:RUTHERFORDTON",
        "CALL:STAND BY",
        "INFO:STAND BY",
        "UNIT:MED40");

    doTest("T6",
        "[] Paging:Location=1172 PINEY RIDGE RD* APT/ROOM=* City=FOREST CITY* Call Type=EMS CHESTPAI* Units=MED40,RCR1*\r\n\n",
        "ADDR:1172 PINEY RIDGE RD",
        "CITY:FOREST CITY",
        "CALL:EMS CHESTPAI",
        "UNIT:MED40,RCR1");

  }

  public static void main(String[] args) {
    new NCRutherfordCountyParserTest().generateTests("T1");
  }

}