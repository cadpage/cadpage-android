package net.anei.cadpage.parsers.CA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Humbolt County, CA
Contact: Josh Miraglia <miragliajj@gmail.com>
Sender: huucad@fire.ca.gov

RA: RIOLRA; MEDICAL; 270 OGLE AVE ,RIO_DELL  X: -124 7.31976  Y: 40 30.3687 Inc# 001122; RIO FRA2; Descr: pain in stomach  Pat Cnt: 1  Age: 28  Years  Sex: Male  Con: Yes  Breath: Yes  Resp Script: You are responding to a patient with abdominal pain.  The patient is a  28-year-old male, who is conscious and breathing. Not alert.  Caller Statement: pain in stomach.  1.He is not completely alert (not responding appropriately).   <a href="http://maps.google.com/?q=40.506146,-124.121996">Map</a>
RA: RIOLRA; MEDICAL; 1 PAINTER ST ,RIO_DELL  X: -124 6.4185  Y: 40 30.1550 Inc# 001112; RIO FRA1; rio dell mobile hm trailer <a href="http://maps.google.com/?q=40.502584,-124.106975">Map</a>
RA: RIOLRA; MEDICAL; 270 OGLE AVE ,RIO_DELL  X: -124 7.31976  Y: 40 30.3687 Inc# 001104; RIO FRA1; 29 YO M with stomach pain. <a href="http://maps.google.com/?q=40.506146,-124.121996">Map</a>
RA: RIOLRA; MEDICAL; 271 CHERRY LN ,RIO_DELL  X: -124 6.43332  Y: 40 29.6445 Inc# 001089; RIO FRA1; 70 yo male leg pain <a href="http://maps.google.com/?q=40.494076,-124.107222">Map</a>
RA: RIOLRA; MEDICAL; 355 DOUGLAS ST ,RIO_DELL  X: -124 6.49914  Y: 40 29.7651 Inc# 001009; RIO FRA1; Descr: breathing issues 85  Pat Cnt: 1  Age: 85  Years  Sex: Female  Con: Yes  Breath: Yes  Resp Script: You are responding to a patient with breathing problems.  The patient is a  85-year-old female, who is conscious and breathing. DIFFICULTY  SPEAKING BETWEEN BREATHS.  Caller Statement: breathing issues 85.  1.She is completely alert (responding appropriately).  2.She has difficulty speaking between breaths.   <a href="http://maps.google.com/?q=40.496086,-124.108319">Map</a>

*/
public class CAHumboldtCountyParserTest extends BaseParserTest {
  
  public CAHumboldtCountyParserTest() {
    setParser(new CAHumboldtCountyParser(), "HUMBOLDT COUNTY", "CA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "RA: RIOLRA; MEDICAL; 270 OGLE AVE ,RIO_DELL  X: -124 7.31976  Y: 40 30.3687 Inc# 001122; RIO FRA2; Descr: pain in stomach  Pat Cnt: 1  Age: 28  Years  Sex: Male  Con: Yes  Breath: Yes  Resp Script: You are responding to a patient with abdominal pain.  The patient is a  28-year-old male, who is conscious and breathing. Not alert.  Caller Statement: pain in stomach.  1.He is not completely alert (not responding appropriately).   <a href=\"http://maps.google.com/?q=40.506146,-124.121996\">Map</a>",
        "SRC:RIOLRA",
        "CALL:MEDICAL",
        "ADDR:270 OGLE AVE",
        "CITY:RIO DELL",
        "GPS:+40.506145,-124.121996",
        "ID:001122",
        "UNIT:RIO FRA2",
        "INFO:pain in stomach  Pat Cnt: 1  Age: 28  Years  Sex: Male  Con: Yes  Breath: Yes  Resp Script: You are responding to a patient with abdominal pain.  The patient is a  28-year-old male, who is conscious and breathing. Not alert.  Caller Statement: pain in stomach.  1.He is not completely alert (not responding appropriately).");

    doTest("T2",
        "RA: RIOLRA; MEDICAL; 1 PAINTER ST ,RIO_DELL  X: -124 6.4185  Y: 40 30.1550 Inc# 001112; RIO FRA1; rio dell mobile hm trailer <a href=\"http://maps.google.com/?q=40.502584,-124.106975\">Map</a>",
        "SRC:RIOLRA",
        "CALL:MEDICAL",
        "ADDR:1 PAINTER ST",
        "CITY:RIO DELL",
        "GPS:+40.502583,-124.106975",
        "ID:001112",
        "UNIT:RIO FRA1",
        "INFO:rio dell mobile hm trailer");

    doTest("T3",
        "RA: RIOLRA; MEDICAL; 270 OGLE AVE ,RIO_DELL  X: -124 7.31976  Y: 40 30.3687 Inc# 001104; RIO FRA1; 29 YO M with stomach pain. <a href=\"http://maps.google.com/?q=40.506146,-124.121996\">Map</a>",
        "SRC:RIOLRA",
        "CALL:MEDICAL",
        "ADDR:270 OGLE AVE",
        "CITY:RIO DELL",
        "GPS:+40.506145,-124.121996",
        "ID:001104",
        "UNIT:RIO FRA1",
        "INFO:29 YO M with stomach pain.");

    doTest("T4",
        "RA: RIOLRA; MEDICAL; 271 CHERRY LN ,RIO_DELL  X: -124 6.43332  Y: 40 29.6445 Inc# 001089; RIO FRA1; 70 yo male leg pain <a href=\"http://maps.google.com/?q=40.494076,-124.107222\">Map</a>",
        "SRC:RIOLRA",
        "CALL:MEDICAL",
        "ADDR:271 CHERRY LN",
        "CITY:RIO DELL",
        "GPS:+40.494075,-124.107222",
        "ID:001089",
        "UNIT:RIO FRA1",
        "INFO:70 yo male leg pain");

    doTest("T5",
        "RA: RIOLRA; MEDICAL; 355 DOUGLAS ST ,RIO_DELL  X: -124 6.49914  Y: 40 29.7651 Inc# 001009; RIO FRA1; Descr: breathing issues 85  Pat Cnt: 1  Age: 85  Years  Sex: Female  Con: Yes  Breath: Yes  Resp Script: You are responding to a patient with breathing problems.  The patient is a  85-year-old female, who is conscious and breathing. DIFFICULTY  SPEAKING BETWEEN BREATHS.  Caller Statement: breathing issues 85.  1.She is completely alert (responding appropriately).  2.She has difficulty speaking between breaths.   <a href=\"http://maps.google.com/?q=40.496086,-124.108319\">Map</a>",
        "SRC:RIOLRA",
        "CALL:MEDICAL",
        "ADDR:355 DOUGLAS ST",
        "CITY:RIO DELL",
        "GPS:+40.496085,-124.108319",
        "ID:001009",
        "UNIT:RIO FRA1",
        "INFO:breathing issues 85  Pat Cnt: 1  Age: 85  Years  Sex: Female  Con: Yes  Breath: Yes  Resp Script: You are responding to a patient with breathing problems.  The patient is a  85-year-old female, who is conscious and breathing. DIFFICULTY  SPEAKING BETWEEN BREATHS.  Caller Statement: breathing issues 85.  1.She is completely alert (responding appropriately).  2.She has difficulty speaking between breaths.");

  }
  
  public static void main(String[] args) {
    new CAHumboldtCountyParserTest().generateTests("T1");
  }
}