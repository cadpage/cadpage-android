package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NCLincolnCountyParserTest extends BaseParserTest {
  
  public NCLincolnCountyParserTest() {
    setParser(new NCLincolnCountyParser(), "LINCOLN COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "4567:CAD:KFD-26D01-26-D-1 SICK PERSON-9999 PALMETTO LN-PANORAMIC LN-TODD LN-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: You are responding to a patient who is sick (or has a current medical condition). The patient is a <REMOVED PT DATA>, who is conscious and",
        "SRC:KFD",
        "ID:4567",
        "CODE:26D01",
        "CALL:SICK PERSON",
        "ADDR:9999 PALMETTO LN",
        "X:PANORAMIC LN & TODD LN",
        "INFO:You are responding to a patient who is sick (or has a current medical condition). The patient is a <REMOVED PT DATA>, who is conscious and");

    doTest("T2",
        "4568:CAD:KFD3-06D04-6-D-4 BREATHING PROBLEMS-8888 N NC 16 HWY-DELLING COMMUNICATIONS-CHARTER LN-HAGERS HOLLOW DR-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: <REMOVED PT DATA>, Conscious, Breathing. Breathing Problems. Clammy. 1.He is completely alert (responding appropriately). 2.He does not have",
        "SRC:KFD3",
        "ID:4568",
        "CODE:06D04",
        "CALL:BREATHING PROBLEMS",
        "ADDR:8888 N NC 16 HWY",
        "PLACE:DELLING COMMUNICATIONS",
        "X:CHARTER LN & HAGERS HOLLOW DR",
        "INFO:<REMOVED PT DATA>, Conscious, Breathing. Breathing Problems. Clammy. 1.He is completely alert (responding appropriately). 2.He does not have");

    doTest("T3",
        "4569:CAD:KFD-06D02-6-D-2 BREATHING PROBLEMS-7777 DICK WILSON RD-CAMPGROUND RD-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: <REMOVED PT DATA>, Conscious, Breathing. Breathing Problems. DIFFICULTY SPEAKING BETWEEN BREATHS. Caller Statement: DIFFICULTY BREATHING AND",
        "SRC:KFD",
        "ID:4569",
        "CODE:06D02",
        "CALL:BREATHING PROBLEMS",
        "ADDR:7777 DICK WILSON RD",
        "X:CAMPGROUND RD",
        "INFO:<REMOVED PT DATA>, Conscious, Breathing. Breathing Problems. DIFFICULTY SPEAKING BETWEEN BREATHS. Caller Statement: DIFFICULTY BREATHING AND");

    doTest("T4",
        "4570:CAD:KLF-201101460-SMOKE INVESTIGATION-N LITTLE EGYPT RD/NC 73 HWY-near the ball field [03/22/11 10:13:09 DISPATCHER] blk smoke near track unkn source [03/22/11 10:12:22]",
        "SRC:KLF",
        "ID:201101460",
        "CALL:SMOKE INVESTIGATION",
        "ADDR:N LITTLE EGYPT RD & NC 73 HWY",
        "PLACE:near the ball field",
        "X:blk smoke near track unkn source");

    doTest("T5",
        "4571:CAD:KFD-201101410-67D02-OUTSIDE FIRE-1111 SAILVIEW DR-CREPE RIDGE DR-CHAPEL CREEK DR-[Fire Priority Info] RESPONSE: Delta RESPONDER SCRIPT: Outside Fire. Brush/grass fire.Caller Statement: burning brush . 2.The caller is safe and out of danger. 3.Everyone else is safe and out of",
        "SRC:KFD",
        "ID:201101410",
        "CODE:67D02",
        "CALL:OUTSIDE FIRE",
        "ADDR:1111 SAILVIEW DR",
        "X:CREPE RIDGE DR & CHAPEL CREEK DR",
        "INFO:Outside Fire. Brush/grass fire.Caller Statement: burning brush . 2.The caller is safe and out of danger. 3.Everyone else is safe and out of");

    doTest("T6",
        "1221:CAD:DFD-201101274-ASSIST MOTORIST AGENCY OFFICER-5555 KING WILKINSON RD-CALVARY BAPTIST CHURCH-MOUNTAINBROOK LN-DELLING DOWNS DR-Event spawned from LOG CALL FOR RECORDS. [03/10/2011 20:03:33 SAM] TREE ACROSS THE ROAD [03/10/11 20:03:06 SAM]",
        "SRC:DFD",
        "ID:201101274",
        "CALL:ASSIST MOTORIST AGENCY OFFICER",
        "ADDR:5555 KING WILKINSON RD",
        "PLACE:CALVARY BAPTIST CHURCH",
        "X:MOUNTAINBROOK LN & DELLING DOWNS DR",
        "INFO:Event spawned from LOG CALL FOR RECORDS. / TREE ACROSS THE ROAD");

    doTest("T7",
        "1873:CAD:JLFD-201101315-52C03U-ALARMS FOR FIRE-888 OPTIMIST CLUB RD-WOODMONT CARE CENTER-FORNEY CREEK PKWY-WOODS LN-[Fire Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: Alarms. COMMERCIAL structure (Unknown).Caller Statement: FIRE ALARM . 1.The caller is an alarm",
        "SRC:JLFD",
        "ID:201101315",
        "CODE:52C03U",
        "CALL:ALARMS FOR FIRE",
        "ADDR:888 OPTIMIST CLUB RD",
        "PLACE:WOODMONT CARE CENTER",
        "X:FORNEY CREEK PKWY & WOODS LN",
        "INFO:Alarms. COMMERCIAL structure (Unknown).Caller Statement: FIRE ALARM . 1.The caller is an alarm");
   }
  
  @Test
  public void testFixLater() {
    
    // This is what T4 really should do.  Will try to fix later
    doTest("T4",
        "4570:CAD:KLF-201101460-SMOKE INVESTIGATION-N LITTLE EGYPT RD/NC 73 HWY-near the ball field [03/22/11 10:13:09 DISPATCHER] blk smoke near track unkn source [03/22/11 10:12:22]",
        "SRC:KLF",
        "ID:201101460",
        "CALL:SMOKE INVESTIGATION",
        "ADDR:N LITTLE EGYPT RD & NC 73 HWY",
        "INFO:near the ball field / blk smoke near track unkn source");
  }
  

  public static void main(String[] args) {
    new NCLincolnCountyParserTest().generateTests("T1");
  }
}
