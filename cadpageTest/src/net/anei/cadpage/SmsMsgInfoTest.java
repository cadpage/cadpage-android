package net.anei.cadpage;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class SmsMsgInfoTest {
  
  @BeforeClass
  public static void classSetup() {
    new TestManagePreferences().setOverrideDefault(false);
  }

  @Test
  public void testGetMapAddress() {
    
    doMapTest("PAArmstrongCounty", 
        "868 STATE 28,KENBURG,XX",
        "868 STATE ROUTE 28");
    
    doMapTest("CLHS1", "BROADWAY &S 10TH ST,KENBURG,XX", 
                       "1600 BROADWAY & 4500 S 10TH ST");

    doMapTest("CLHS2", "1000 S RT 50,KENBURG,XX", "1000 S RT 50");
    
    doMapTest("CLHS3", "US 150 & HWY 30,KENBURG,XX", "US 150 & HWY 30");
    
    doMapTest("CR1", "1000 PINE ST,KENBURG,XX", "1000 PINE ST", "MULBERY RD");
    doMapTest("CR2", "PINE ST & BLACK ST,KENBURG,XX", "PINE ST & BLACK ST", "MULBERY RD");
    doMapTest("CR3", "PINE ST & MULBERY RD,KENBURG,XX", "PINE ST", "MULBERY RD");
    
    doMapTest("CN1", "11TH AV&18TH ST,KENBURG,XX", "11TH AV&18TH ST");
    doMapTest("CN2", "11 AV & 18 ST,KENBURG,XX", "11 AV & 18 ST");
    
    doMapTest("APT1", "144 MAIN ST,KENBURG,XX", "144 MAIN ST #14");
    
    doMapTest("BND1", "US HIGHWAY 85 & E 77TH AVE,KENBURG,XX", "US HIGHWAY 85 NB & E 77TH AVE");
    doMapTest("BND2", "US HIGHWAY 100,KENBURG,XX", "US HIGHWAY 100 SB");
    
    doMapPlaceTest("PLC1", "PARK PLACE,US HIGHWAY 100,KENBURG,XX", "US HIGHWAY 100", "PARK PLACE");
    doMapPlaceTest("PLC2", "850 US HIGHWAY 100,KENBURG,XX", "850 US HIGHWAY 100", "PARK PLACE");
    
    doMapTest("DR1", "345 W US 30,KENBURG,XX", "345 W US RT 30");
    doMapTest("DR2", "345 w st 30,KENBURG,XX", "345 w st hwy 30");
    
    doMapTest("BLK1", "6000 REIDSVILLE RD,KENBURG,XX", "6000BLK REIDSVILLE RD");
    doMapTest("BLK2", "6000 OBLKA ST,KENBURG,XX", "6000 OBLKA ST");
    doMapTest("BLK3", "100 OAK FEST RD,KENBURG,XX", "{100} OAK FEST RD");
    doMapTest("BLK4", "2700 BRAGG BLVD,KENBURG,XX", "2700-BLK BRAGG BLVD");
  }
  
  private void doMapTest(String title, String result, String address) {
    doMapTest(title, result, address, "", "", "");
  }
  
  private void doMapTest(String title, String result, String address, String cross) {
    doMapTest(title, result, address, cross, "", "");
  }
  
  private void doMapTest(String title, String result, String address, 
                           String cross, String city, String state) {
    SmsMsgInfo.Data data = new SmsMsgInfo.Data();
    data.strAddress = address;
    data.strCross = cross;
    data.strCity = city;
    data.strState = state;
    
    data.defCity = "KENBURG";
    data.defState = "XX";
    
    SmsMsgInfo info = new SmsMsgInfo(data);
    assertEquals(title, result, info.getMapAddress());
  }
  
  private void doMapPlaceTest(String title, String result, String address, String place) { 
    SmsMsgInfo.Data data = new SmsMsgInfo.Data();
    data.strAddress = address;
    data.strPlace = place;
    
    data.defCity = "KENBURG";
    data.defState = "XX";
    
    SmsMsgInfo info = new SmsMsgInfo(data);
    assertEquals(title, result, info.getMapAddress());
  }

}
