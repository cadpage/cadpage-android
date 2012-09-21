package net.anei.cadpage.parsers.OR;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.OR.ORWashingtonCountyParser;

import org.junit.Test;


public class ORWashingtonCountyParserTest extends BaseParserTest {
  
  public ORWashingtonCountyParserTest() {
    setParser(new ORWashingtonCountyParser(), "WASHINGTON COUNTY", "OR");
  }
  
  @Test
  public void testParser() {
    doTest("T1",
        "MVA-UKN INJURY SW TUALATIN VALLEY HW/SW331ST AV (33098 TUALATIN VALLEY/331ST) HIL MAP: 5377D UNIT: C2 E01 R8",
        "CALL:MVA-UKN INJURY",
        "ADDR:SW TUALATIN VALLEY HW & SW331ST AV",
        "MADDR:SW TUALATIN VALLEY HWY & SW331ST AVE",
        "X:33098 TUALATIN VALLEY/331ST",
        "CITY:HILLSBORO",
        "MAP:5377D",
        "UNIT:C2 E01 R8");
        
    doTest("T2",
        "ABDOMINAL PAIN 985 N DAVIS ST (DEAD END & N 10TH AV) CON MAP: 5375D UNIT: METWA STA8",
        "CALL:ABDOMINAL PAIN",
        "ADDR:985 N DAVIS ST",
        "X:DEAD END & N 10TH AV",
        "CITY:CORNELIUS",
        "MAP:5375D",
        "UNIT:METWA STA8");

    doTest("T3",
        "BREATHING PROB 39470 SW GEIGER RD (SW LAFOLLETT RD & FERN HILL RD) CON MAP: 5574B UNIT: METWA STA8",
        "CALL:BREATHING PROB",
        "ADDR:39470 SW GEIGER RD",
        "X:SW LAFOLLETT RD & FERN HILL RD",
        "CITY:CORNELIUS",
        "MAP:5574B",
        "UNIT:METWA STA8");

    doTest("T4",
        "SICK PERSON/UNKO 1045 N ADAIR ST (N 10TH AV & N 10TH-11TH AL) CON MAP: 5375D UNIT: METWA STA8",
        "CALL:SICK PERSON/UNKO",
        "ADDR:1045 N ADAIR ST",
        "X:N 10TH AV & N 10TH-11TH AL",
        "CITY:CORNELIUS",
        "MAP:5375D",
        "UNIT:METWA STA8");

    doTest("T5",
        "RESIDENTIAL FIRE 822 N 28TH AV (N HOLLADAY DR & N 27TH AV) CON MAP: 5376D UNIT: METWA TIMERC CAS8 CFDUTY SIRN08 E813 E814 E815 E421 R8 T03 COCB1",
        "CALL:RESIDENTIAL FIRE",
        "ADDR:822 N 28TH AV",
        "MADDR:822 N 28TH AVE",
        "X:N HOLLADAY DR & N 27TH AV",
        "CITY:CORNELIUS",
        "MAP:5376D",
        "UNIT:METWA TIMERC CAS8 CFDUTY SIRN08 E813 E814 E815 E421 R8 T03 COCB1");
  }
  
  @Test
  public void testClackamasCounty() {

    doTest("T1",
        "    UNCON/FAINTING 37905 SE SERBAN RD (SE BLUFF RD & SE BAUMBACK RD) SAN MAP: 6013B UNIT: E74 M1",
        "CALL:UNCON/FAINTING",
        "ADDR:37905 SE SERBAN RD",
        "X:SE BLUFF RD & SE BAUMBACK RD",
        "CITY:SANDY",
        "MAP:6013B",
        "UNIT:E74 M1");
  }
  
  @Test
  public void testZakDelair() {

    doTest("T1",
        "UNK PROB/MN DOWN 95 82ND DR (SAFEWAY (GLADSTONE)) GLA MAP: 6398D UNIT: R101 M1",
        "CALL:UNK PROB/MN DOWN",
        "ADDR:95 82ND DR",
        "X:SAFEWAY (GLADSTONE)",
        "CITY:GLADSTONE",
        "MAP:6398D",
        "UNIT:R101 M1");

  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "[] PRE NOTIFICATION 59185 E CHALET PL (DEAD END & E EAST RD) SAN MAP: 6324A UNIT: SQ252 SQ251 M1 2509\r\n\r\n\n",
        "CALL:PRE NOTIFICATION",
        "ADDR:59185 E CHALET PL",
        "CITY:SANDY",
        "X:DEAD END & E EAST RD",
        "MAP:6324A",
        "UNIT:SQ252 SQ251 M1 2509");

    doTest("T2",
        "[] BREATHING PROB. 59185 E CHALET PL (DEAD END & E EAST RD) SAN MAP: 6324A UNIT: SQ252\r\n\r\n\n",
        "CALL:BREATHING PROB",
        "ADDR:59185 E CHALET PL",
        "CITY:SANDY",
        "X:DEAD END & E EAST RD",
        "MAP:6324A",
        "UNIT:SQ252");

    doTest("T3",
        "[] PRE NOTIFICATION 59454 E SLEEPY HOLLOW DR (E EAST RD & E BARLOW TRAIL RD) SAN MAP: 6324B UNIT: SQ252 SQ251 M1 2509\r\n\r\n\n",
        "CALL:PRE NOTIFICATION",
        "ADDR:59454 E SLEEPY HOLLOW DR",
        "CITY:SANDY",
        "X:E EAST RD & E BARLOW TRAIL RD",
        "MAP:6324B",
        "UNIT:SQ252 SQ251 M1 2509");

    doTest("T4",
        "[] PRE NOTIFICATION 27160 E MARION RD (E ROAD 10 & E ROAD 20) RHO MAP: 6731A UNIT: SQ252 M1 3709\r\n\r\n\n",
        "CALL:PRE NOTIFICATION",
        "ADDR:27160 E MARION RD",
        "CITY:RHODODENDRON",
        "X:E ROAD 10 & E ROAD 20",
        "MAP:6731A",
        "UNIT:SQ252 M1 3709");

    doTest("T5",
        "[] PRE NOTIFICATION 59454 E SLEEPY HOLLOW DR (E EAST RD & E BARLOW TRAIL RD) SAN MAP: 6324B UNIT: SQ252 SQ251 M1 2509\r\n\r\n\n",
        "CALL:PRE NOTIFICATION",
        "ADDR:59454 E SLEEPY HOLLOW DR",
        "CITY:SANDY",
        "X:E EAST RD & E BARLOW TRAIL RD",
        "MAP:6324B",
        "UNIT:SQ252 SQ251 M1 2509");

    doTest("T6",
        "[] UNKNOWN TYP FIRE 31315 E MULTORPOR DR (SKI BOWL (EAST)) GOV MAP: 6939 UNIT: E251 E254 2509\r\n\r\n\n",
        "CALL:UNKNOWN TYP FIRE",
        "ADDR:31315 E MULTORPOR DR",
        "CITY:GOVERNMENT CAMP",
        "X:SKI BOWL (EAST)",
        "MAP:6939",
        "UNIT:E251 E254 2509");

    doTest("T7",
        "[] FIRE ALARM, COMM 30521 E MELDRUM ST (E LIGE LN & E GOVERNMENT CAMP LP) GOV MAP: 6939 UNIT: E251 E254 WT251 2509\r\n\r\n\n",
        "CALL:FIRE ALARM, COMM",
        "ADDR:30521 E MELDRUM ST",
        "CITY:GOVERNMENT CAMP",
        "X:E LIGE LN & E GOVERNMENT CAMP LP",
        "MAP:6939",
        "UNIT:E251 E254 WT251 2509");

  }
  
  public static void main(String[] args) {
    new ORWashingtonCountyParserTest().generateTests("T1");
  }
}
