package net.anei.cadpage;

import static org.junit.Assert.*;

import org.junit.Test;

public class SmsMsgInfoTest {

  @Test
  public void testGetMapAddress() {
    doMapTest("CLHS1", "BROADWAY &S 10TH ST,KENBURG,XX", 
                       "1600 BROADWAY & 4500 S 10TH ST");

    doMapTest("CLHS2", "1000 S RT 50,KENBURG,XX", "1000 S RT 50");
    
    doMapTest("CLHS3", "US 150 & HWY 30,KENBURG,XX", "US 150 & HWY 30");
    
    doMapTest("CR1", "1000 PINE ST,KENBURG,XX", "1000 PINE ST", "MULBERY RD");
    doMapTest("CR2", "PINE ST & BLACK ST,KENBURG,XX", "PINE ST & BLACK ST", "MULBERY RD");
    doMapTest("CR3", "PINE ST & MULBERY RD,KENBURG,XX", "PINE ST", "MULBERY RD");
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

}
