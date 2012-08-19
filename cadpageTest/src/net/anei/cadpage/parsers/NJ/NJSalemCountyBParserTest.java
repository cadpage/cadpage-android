package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NJSalemCountyBParserTest extends BaseParserTest {
  
  public NJSalemCountyBParserTest() {
    setParser(new NJSalemCountyBParser(), "SALEM COUNTY", "NJ");
  }
  
  @Test
  public void testBadMsg() {
    doBadTest("(Chief ALT) [CFC EMS] -- Syncope - Not Alert -- Amberwood -- 51 Karens Wy - Cross STS:Beechwood Ct & Silver Birch La - EMD:M31D3");  
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Chief ALT) [STA:7] -- ALS -- 118 E Pittsfield St Pennsville Township NJ - Cross STS:Sparks Ave -- Caller: DAULTON ",
        "SRC:STA:7",
        "CALL:ALS",
        "ADDR:118 E Pittsfield St",
        "CITY:Pennsville Township",
        "X:Sparks Ave",
        "NAME:DAULTON");

    doTest("T2",
        "(Chief ALT) [STA:7] -- Motor Vehicle Accident -- 1163 S Broadway Way Pennsville Township NJ - Cross STS:Freas Rd -- Caller: JACK KUGLER 9352515",
        "SRC:STA:7",
        "CALL:Motor Vehicle Accident",
        "ADDR:1163 S Broadway Way",
        "CITY:Pennsville Township",
        "X:Freas Rd",
        "NAME:JACK KUGLER",
        "PHONE:9352515");

    doTest("T3",
        "(Chief ALT) [STA:7] -- MVC -- Njtp South Mm 1-4.5 Njtp Carneys Point Township NJ -- Caller: SHAWN HAMMELL 6178168",
        "SRC:STA:7",
        "CALL:MVC",
        "ADDR:Njtp South Mm 1-4.5 Njtp",
        "CITY:Carneys Point Township",
        "NAME:SHAWN HAMMELL",
        "PHONE:6178168");

    doTest("T4",
        "(Chief ALT) [STA:7] -- Fire Alarm System -- 117 N Broadway Way Pennsville Township NJ - Cross STS:Brandriff Ave -- Caller: VERIZON / KAREN 6158005",
        "SRC:STA:7",
        "CALL:Fire Alarm System",
        "ADDR:117 N Broadway Way",
        "CITY:Pennsville Township",
        "X:Brandriff Ave",
        "NAME:VERIZON / KAREN",
        "PHONE:6158005");

    doTest("T5",
        "(Chief ALT) [STA:7] -- Out Of County Assist -- Delaware Memorial Brg New Castle DE -- Caller: COUNTY",
        "SRC:STA:7",
        "CALL:Out Of County Assist",
        "ADDR:Delaware Memorial Brg",
        "CITY:New Castle",
        "ST:DE",
        "NAME:COUNTY");

    doTest("T6",
        "(Chief ALT) [STA:7] -- Motor Vehicle Accident -- 430 N Broadway Way Pennsville Township NJ - Cross STS:Rt 130 Overpass -- Caller: 520",
        "SRC:STA:7",
        "CALL:Motor Vehicle Accident",
        "ADDR:430 N Broadway Way",
        "CITY:Pennsville Township",
        "X:Rt 130 Overpass",
        "NAME:520");

    doTest("T7",
        "(Chief ALT) [STA:7] -- Structure Fire - Medium Hazard -- 709 S Broadway Way Pennsville Township NJ - Cross STS:Sharp St And Lighthouse Rd -- Caller: LS-5",
        "SRC:STA:7",
        "CALL:Structure Fire - Medium Hazard",
        "ADDR:709 S Broadway Way",
        "CITY:Pennsville Township",
        "X:Sharp St And Lighthouse Rd",
        "NAME:LS-5");
  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "(Chief ALT) [STA:6] -- Automatic Alarm -- 32000 Campus Dr Parsonsburg MD - Cross STS:Walston Switch Rd ",
        "SRC:STA:6",
        "CALL:Automatic Alarm",
        "ADDR:32000 Campus Dr",
        "CITY:Parsonsburg",
        "ST:MD",
        "X:Walston Switch Rd");

    doTest("T2",
        "(Chief ALT) [STA:6] -- Psychiatric Emergency -- 6115 Ruth St Parsonsburg MD - Cross STS:Steve St - Florence St",
        "SRC:STA:6",
        "CALL:Psychiatric Emergency",
        "ADDR:6115 Ruth St",  // Found in Parsons
        "CITY:Parsonsburg",
        "ST:MD",
        "X:Steve St - Florence St");

    doTest("T3",
        "(Chief ALT) [STA:6] -- Medical Assist -- 6115 Ruth St Parsonsburg MD - Cross STS:Steve St - Florence St",
        "SRC:STA:6",
        "CALL:Medical Assist",
        "ADDR:6115 Ruth St",
        "CITY:Parsonsburg",
        "ST:MD",
        "X:Steve St - Florence St");

    doTest("T4",
        "(Chief ALT) [STA:6] -- Seizure -- 6858 Zion Church Rd Parsonsburg MD - Cross STS:Old Ocean City Rd - Morris Leonard Rd",
        "SRC:STA:6",
        "CALL:Seizure",
        "ADDR:6858 Zion Church Rd",
        "CITY:Parsonsburg",
        "ST:MD",
        "X:Old Ocean City Rd - Morris Leonard Rd");

    doTest("T5",
        "(Chief ALT) [STA:6] -- Sick Subject -- 7573 Parsonsburg Rd Parsonsburg MD - Cross STS:Old Oak Ln - Gadwall Ln",
        "SRC:STA:6",
        "CALL:Sick Subject",
        "ADDR:7573 Parsonsburg Rd",
        "CITY:Parsonsburg",
        "ST:MD",
        "X:Old Oak Ln - Gadwall Ln");

    doTest("T6",
        "(Chief ALT) [STA:6] -- Medical Assist -- 7573 Parsonsburg Rd Parsonsburg MD - Cross STS:Old Oak Ln - Gadwall Ln",
        "SRC:STA:6",
        "CALL:Medical Assist",
        "ADDR:7573 Parsonsburg Rd",
        "CITY:Parsonsburg",
        "ST:MD",
        "X:Old Oak Ln - Gadwall Ln");

    doTest("T7",
        "(Chief ALT) [STA:6] -- Difficulty Breathing -- 31550 Winterplace Pkwy Parsonsburg MD - Cross STS:Hobbs Rd - Blue Ribbon Rd",
        "SRC:STA:6",
        "CALL:Difficulty Breathing",
        "ADDR:31550 Winterplace Pkwy",  // Found in Salisbury, MD
        "CITY:Parsonsburg",
        "ST:MD",
        "X:Hobbs Rd - Blue Ribbon Rd");

    doTest("T8",
        "(Chief ALT) [STA:6] -- Subject Fallen -- 7466 Madeline Cir Parsonsburg MD - Cross STS:Jones Hastings Rd - Jones Hastings Rd",
        "SRC:STA:6",
        "CALL:Subject Fallen",
        "ADDR:7466 Madeline Cir",
        "CITY:Parsonsburg",
        "ST:MD",
        "X:Jones Hastings Rd - Jones Hastings Rd");

    doTest("T9",
        "(Chief ALT) [STA:6] -- Pro Qa Ems -- 33322 Wango Rd Parsonsburg MD - Cross STS:Bear Swamp Rd - Chicken Ln",
        "SRC:STA:6",
        "CALL:Pro Qa Ems",
        "ADDR:33322 Wango Rd",
        "CITY:Parsonsburg",
        "ST:MD",
        "X:Bear Swamp Rd - Chicken Ln");

    doTest("T10",
        "(Chief ALT) [STA:6] -- Sick Subject -- 31550 Winterplace Pkwy Parsonsburg MD - Cross STS:Hobbs Rd - Blue Ribbon Rd",
        "SRC:STA:6",
        "CALL:Sick Subject",
        "ADDR:31550 Winterplace Pkwy", // Found in Salisbury
        "CITY:Parsonsburg",
        "ST:MD",
        "X:Hobbs Rd - Blue Ribbon Rd");

    doTest("T11",
        "(Chief ALT) [STA:6] -- Difficulty Breathing -- 6840 Mt Vernon Ave Parsonsburg MD - Cross STS:Old Ocean City Rd",
        "SRC:STA:6",
        "CALL:Difficulty Breathing",
        "ADDR:6840 Mt Vernon Ave",  // found in Salisbury, MD
        "CITY:Parsonsburg",
        "ST:MD",
        "X:Old Ocean City Rd");

    doTest("T12",
        "(Chief ALT) [STA:6] -- Allergic Reaction -- 33442 Bob Smith Rd Parsonsburg MD - Cross STS:Dagsboro Rd - Esham Rd",
        "SRC:STA:6",
        "CALL:Allergic Reaction",
        "ADDR:33442 Bob Smith Rd",
        "CITY:Parsonsburg",
        "ST:MD",
        "X:Dagsboro Rd - Esham Rd");

    doTest("T13",
        "(Chief ALT) [STA:6] -- Trash Fire -- Old Ocean City Rd & zion Church Rd Parsonsburg MD",
        "SRC:STA:6",
        "CALL:Trash Fire",
        "ADDR:Old Ocean City Rd & zion Church Rd", // Found in Parsons, MD
        "CITY:Parsonsburg",
        "ST:MD");

    doTest("T14",
        "(Chief ALT) [STA:6] -- Pi Accident -- Ocean Gtwy & walston Switch Rd Parsonsburg MD",
        "SRC:STA:6",
        "CALL:Pi Accident",
        "ADDR:Ocean Gtwy & walston Switch Rd",
        "CITY:Parsonsburg",
        "ST:MD");

    doTest("T15",
        "(Chief ALT) [STA:6] -- Pi Accident -- Ocean Gtwy & walston Switch Rd Parsonsburg MD",
        "SRC:STA:6",
        "CALL:Pi Accident",
        "ADDR:Ocean Gtwy & walston Switch Rd",
        "CITY:Parsonsburg",
        "ST:MD");

    doTest("T16",
        "(Chief ALT) [STA:6] -- Pi Accident -- E Line Rd & melson Church Rd Delmar MD",
        "SRC:STA:6",
        "CALL:Pi Accident",
        "ADDR:E Line Rd & melson Church Rd", 
        "CITY:Delmar",
        "ST:MD");

    doTest("T17",
        "(Chief ALT) [STA:6] -- Chest Pain -- 7290 Walston Switch Rd Parsonsburg MD - Cross STS:Rushmore Dr - Morris Leonard Rd",
        "SRC:STA:6",
        "CALL:Chest Pain",
        "ADDR:7290 Walston Switch Rd",
        "CITY:Parsonsburg",
        "ST:MD",
        "X:Rushmore Dr - Morris Leonard Rd");

    doTest("T18",
        "(Chief ALT) [STA:6] -- Subject Fallen -- 31679 Dilworth Ave Parsonsburg MD - Cross STS:Brantley Dr - Cromwell Ave",
        "SRC:STA:6",
        "CALL:Subject Fallen",
        "ADDR:31679 Dilworth Ave",
        "CITY:Parsonsburg",
        "ST:MD",
        "X:Brantley Dr - Cromwell Ave");

    doTest("T19",
        "(Chief ALT) [STA:6] -- Stroke -- 31375 John Deere Dr Parsonsburg MD - Cross STS:Hobbs Rd - Mid Atlantic Ln",
        "SRC:STA:6",
        "CALL:Stroke",
        "ADDR:31375 John Deere Dr", // Found in Salisbury, MD
        "CITY:Parsonsburg",
        "ST:MD",
        "X:Hobbs Rd - Mid Atlantic Ln");

  }
  
  public static void main(String[] args) {
    new NJSalemCountyBParserTest().generateTests("T1");
  }
}