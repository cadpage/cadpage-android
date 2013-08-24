package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/* 
Fairfax City, VA
Contact: John Gaskins <jhgaskins@msn.com>
Sender: msg@rsan.fairfaxva.gov

Subject: ACCIDENT INVOLVING PD\nBox 4051 /\nEvent ACCIF /\nAdrs I66 EB PRI TP rt 50 /\nNote SIX PTs / FFX PD OFFICER INVOLVED, BC403 WITH COMMAND /\nCh 4C\n\nSent on: 03/11 22:31\n\nSent by Information Exchange to Incident Notification (e-mail, pagers, cell phones) through Fairfax RSAN\n\n--\n\n- to update your user profile, go to http://rsan.fairfaxva.gov\n
Subject: <no data>\nBox 6039 /\nEvent FHOU /\nAdrs 47308 GRANDVIEW PL /\nNote FIRE IN THE KITCHEN. E439, E404, R439, BC401, E618 ON SCENE /\nCh 6D\n\nSent on: 03/11 14:23\n\nSent by Information Exchange to Incident Notification (e-mail, pagers, cell phones) through Fairfax RSAN\n\n--\n\n- to update your user profile, go to http://rsan.fairfaxva.gov
Subject: <no data>\nDate: Mon, 11 Mar 2013 01:14:16 -0400\n\nBox 1199 /\nEvent FGAPT /\nAdrs 2634 Wagon Drive /\nNote E205 on scene with smoke from the roof /\nCh 4D\n\nSent on: 03/11 01:14\n\nSent by Information Exchange to Incident Notification (e-mail, pagers, cell phones) through Fairfax RSAN\n\n--\n\n- to update your user profile, go to http://rsan.fairfaxva.gov
Subject: <no data>\nBox 1192 /\nEvent FHIRIS /\nAdrs 2000 Huntington Ave /\nNote E411 On scene with balconey fire 8th floor /\nCh 4D\n\nSent on: 03/11 00:33\n\nSent by Information Exchange to Incident Notification (e-mail, pagers, cell phones) through Fairfax RSAN\n\n--\n\n- to update your user profile, go to http://rsan.fairfaxva.gov

*/

public class VAFairfaxCityParserTest extends BaseParserTest {
  
  public VAFairfaxCityParserTest() {
    setParser(new VAFairfaxCityParser(), "FAIRFAX", "VA");
  }
  
  @Test
  public void testParser() {
 
  }
  
  public static void main(String[] args) {
    new VAFairfaxCityParserTest().generateTests("T1");
  }
}