package net.anei.cadpage.parsers.IL;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Rock Island County, IL
Contact: Darin Keith <darin.keith@hotmail.com>
Sender: 40404,CAD@ricoetsb.org
System: Sunguard OSSI

@RIFD: 15221:;CRASH PERSONAL INJURIES;24TH ST/18TH AV
@RIFD: 15226:;FIRE OTHER;1323 14TH ST
@RIFD: 15227:;FIRE ALARM;3605 11TH AV
@RIFD: 16193:;MEDICAL CALL;2300-46 79TH AV W
S: M:67:FYI: ;STRUCTURE FIRE/GENERAL;2932 RODMAN AV\n
S: M:68:CANCEL;2932 RODMAN AV; RIA\n
S: M:69:Update: ;FIRE MUTUAL AID;2932 RODMAN AV\n
@RIFD: 17437:;MEDICAL CALL;767 30TH ST;RI

Rock Island County, IL
Contact: Darin Keith <darin.keith@hotmail.com>
Sender: CAD@ricoetsb.org

S: M:91:FYI: ;3130 9TH ST;STRUCTURE FIRE/GENERAL;RI 
S: M:90:Update: ;2626 RODMAN AV;STRUCTURE FIRE/GENERAL;RIA 
S: M:93:FYI: ;2932 RODMAN AV;STRUCTURE FIRE/GENERAL;RIA 

Contact: Jim Oney <jimoney95@yahoo.com>
Sender: CAD@ricoetsb.org
417:FYI: ;28424 38TH AV N;COUNTY EMS ONLY;HIL
416:FYI: ;27521 94TH AV N;COUNTY EMS ONLY;HIL
S: M:417:FYI: ;28424 38TH AV N;COUNTY EMS ONLY;HIL 

Contact: darin.keith@hotmail.com
Sender: CAD@ricoetsb.org
S: M:135:FYI: ;1201 7TH ST;STRUCTURE FIRE/GENERAL;EM 

*/

public class ILRockIslandCountyParserTest extends BaseParserTest {
  
  public ILRockIslandCountyParserTest() {
    setParser(new ILRockIslandCountyParser(), "ROCK ISLAND COUNTY", "IL");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "S: M:91:FYI: ;3130 9TH ST;STRUCTURE FIRE/GENERAL;RI ",
        "ID:91",
        "ADDR:3130 9TH ST",
        "CALL:STRUCTURE FIRE/GENERAL",
        "CITY:ROCK ISLAND");

    doTest("T2",
        "S: M:90:Update: ;2626 RODMAN AV;STRUCTURE FIRE/GENERAL;RIA ",
        "ID:90",
        "ADDR:2626 RODMAN AV",
        "MADDR:2626 RODMAN AVE",
        "CALL:STRUCTURE FIRE/GENERAL",
        "CITY:ROCK ISLAND ARSENAL");

    doTest("T3",
        "S: M:93:FYI: ;2932 RODMAN AV;STRUCTURE FIRE/GENERAL;RIA ",
        "ID:93",
        "ADDR:2932 RODMAN AV",
        "MADDR:2932 RODMAN AVE",
        "CALL:STRUCTURE FIRE/GENERAL",
        "CITY:ROCK ISLAND ARSENAL");
  
  }
  
  @Test
  public void JimOney() {

    doTest("T1",
        "417:FYI: ;28424 38TH AV N;COUNTY EMS ONLY;HIL",
        "ID:417",
        "ADDR:28424 38TH AV N",
        "MADDR:28424 38TH AVE N",
        "CALL:COUNTY EMS ONLY",
        "CITY:HILLSDALE");

    doTest("T2",
        "416:FYI: ;27521 94TH AV N;COUNTY EMS ONLY;HIL",
        "ID:416",
        "ADDR:27521 94TH AV N",
        "MADDR:27521 94TH AVE N",
        "CALL:COUNTY EMS ONLY",
        "CITY:HILLSDALE");
  
  }
  
  @Test
  public void testDarinKeith() {

    doTest("T1",
        "S: M:135:FYI: ;1201 7TH ST;STRUCTURE FIRE/GENERAL;EM ",
        "ID:135",
        "ADDR:1201 7TH ST",
        "CALL:STRUCTURE FIRE/GENERAL",
        "CITY:EAST MOLINE");

  }
  
  public static void main(String[] args) {
    new ILRockIslandCountyParserTest().generateTests("T1");
  }
}