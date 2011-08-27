package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NCRandolphCountyParserTest extends BaseParserTest {
  
  public NCRandolphCountyParserTest() {
    setParser(new NCRandolphCountyParser(), "RANDOLPH COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Randolph 911 - GRFD\nBREATHING\n5064 CROTTS DR\nSTA40\nSTA40\n10-15 JAMES KIRKMAN...BREATHING DIFF...TIGHTNESS IN CHEST...HANDS TINGLING...HEART RATE IS 45\n16:34:30 08/21/2011 - WATSON,A D\nProQA Medical Case Entry Finished\n16:35:13 08/2",
        "SRC:GRFD",
        "CALL:BREATHING",
        "ADDR:5064 CROTTS DR",
        "UNIT:STA40",
        "INFO:10-15 JAMES KIRKMAN...BREATHING DIFF...TIGHTNESS IN CHEST...HANDS TINGLING...HEART RATE IS 45");

    doTest("T2",
        "Randolph 911 - GRFD\nABDOMINAL PAIN\n6242 CEDAR LN\nSTA41\nSTA41\n10-15 HOWARD PEELE..68 YO..SICKNESS AND TREMBLING...TESTICLE PAIN..ABDOMINAL\nPAIN..CONFUSED...26 D 1\n10:26:05 08/22/2011 - MCCORQUODALE, C\nPROQA WOULD NOT LAUNCH",
        "SRC:GRFD",
        "CALL:ABDOMINAL PAIN",
        "ADDR:6242 CEDAR LN",
        "UNIT:STA41",
        "INFO:10-15 HOWARD PEELE..68 YO..SICKNESS AND TREMBLING...TESTICLE PAIN..ABDOMINAL / PAIN..CONFUSED...26 D 1");

    doTest("T3",
        "Randolph 911 - GRFD\nFALL\n8374 HARLOW RD;UNIT 10\nSTA41\nSTA41\nCHILTON MHP...CAILY SKEEN...87 Y/O FEMALE...KEY BEHIND THE ELECTRICAL AT THE TELEPHONE POLE INSIDE THE BLK BOX AND THE KEY IS FOR A DEAD BOLT...ABLE TO VOICE CONTACT UNK INJ",
        "SRC:GRFD",
        "CALL:FALL",
        "ADDR:8374 HARLOW RD",
        "APT:UNIT 10",
        "UNIT:STA41",
        "INFO:CHILTON MHP...CAILY SKEEN...87 Y/O FEMALE...KEY BEHIND THE ELECTRICAL AT THE TELEPHONE POLE INSIDE THE BLK BOX AND THE KEY IS FOR A DEAD BOLT...ABLE TO VOICE CONTACT UNK INJ");

    doTest("T4",
        "Randolph 911 - GRFD\nHEMORRHAGE\n203 GREEN OAK DR; SUITE A\nSTA20\nSTA20\nREF ASSISTING GUILFORD COUNTY\n00:14:45 08/23/2011 - NELSON,A W\nProQA Medical Case 1258044 Aborted: ASSISTING GUILFORD COUNTY",
        "SRC:GRFD",
        "CALL:HEMORRHAGE",
        "ADDR:203 GREEN OAK DR",
        "APT:SUITE A",
        "UNIT:STA20",
        "INFO:REF ASSISTING GUILFORD COUNTY");

    doTest("T5",
        "Randolph 911 - GRFD\nABDOMINAL PAIN\n119 BARWOOD TER\nSTA20\nSTA20\n47YOF.. 1C4.. NEAR FAINTING.. ABOVE THE NAVEL.. \n12:44:15 08/20/2011 - WALTER,D S\nProQA Medical Case Entry Finished\n12:44:48 08/20/2011 - KING,J C\nARCHDALE RD ONTO DON",
        "SRC:GRFD",
        "CALL:ABDOMINAL PAIN",
        "ADDR:119 BARWOOD TER",
        "UNIT:STA20",
        "INFO:47YOF.. 1C4.. NEAR FAINTING.. ABOVE THE NAVEL.. / ARCHDALE RD ONTO DON");
 }

  public static void main(String[] args) {
    new NCRandolphCountyParserTest().generateTests("T1");
  }
}
