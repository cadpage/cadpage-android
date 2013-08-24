package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/* 
Wicomico County, MD (variant B)

Contact: Active911
Agency name: Salisbury Fire Department
Location: Salisbury, MD, United States
Sender: From: msg@cfmsg.com

(Chief ALT) [SFD Sta 2] -- Structure Fire -- 742 Hemlock St Salisbury MD - Cross STS:Shiloh St - E Lincoln Ave
(Chief ALT) [SFD Sta 2] -- Automatic Alarm -- 2425 N Salisbury Blvd Salisbury MD - Cross STS:Eden St - E Ruark Dr
(Chief ALT) [SFD Sta 2] -- Pi Accident -- N Salisbury Blvd & centre Rd Salisbury MD
(Chief ALT) [SFD Sta 2] -- Delayed Ambulance -- 1018 Queen Anne St Salisbury MD - Cross STS:Jefferson St - Hammond St
(Chief ALT) [SFD Sta 2] -- Automatic Alarm -- 112 E North Pointe Dr Salisbury MD - Cross STS:Dickerson Ln
(Chief ALT) [SFD Sta 2] -- Industrial Accident -- 300 Moss Hill Ln Salisbury MD - Cross STS:Hamilton St - Craft St
(Chief ALT) [SFD Sta 16] -- Pi Accident -- S Division St & power St Salisbury MD
(Chief ALT) [SFD Sta 16] -- Structure Fire -- 404 Atlantic Ave Salisbury MD - Cross STS:Michigan Ave - Ontario Ave
(Chief ALT) [SFD Sta 16] -- Structure Fire -- 569 West Rd Salisbury MD - Cross STS:W Isabella St - Boundary St
(Chief ALT) [SFD Sta 2] -- Automatic Alarm -- 505 Marvel Rd Salisbury MD - Cross STS:Windsor Dr - Shipley Dr
(Chief ALT) [SFD Sta 2] -- Pi Accident -- E Church St & truitt St Salisbury MD
(Chief ALT) [SFD Sta 16] -- Pi Accident -- Snow Hill Rd & toadvine Rd Salisbury MD
(Chief ALT) [SFD Sta 16] -- Automatic Alarm -- 926 Snow Hill Rd Salisbury MD - Cross STS:Progress Cir
(Chief ALT) [SFD Sta 2] -- Smoke / Co Detector -- 703 Hammond St Salisbury MD - Cross STS:Queen Anne St
(Chief ALT) [SFD Sta 2] -- Structure Fire -- 30370 Calhoun Ave Delmar MD - Cross STS:Aylmore Ave - Aylmore Ave
(Chief ALT) [SFD Sta 2] -- Auto Accident Rescue -- Deers Head Hospital Rd & harting Dr Salisbury MD
(Chief ALT) [SFD Sta 2] -- Electrical -- 845 Brown St Salisbury MD - Cross STS:Calloway St - Truitt St
(Chief ALT) [SFD Sta 16] -- Non Breathing -- 412 E Lincoln Ave Salisbury MD - Cross STS:Roger St - Springfield Cir
(Chief ALT) [SFD Sta 2] -- Medical Assist -- 200 Civic Ave Salisbury MD - Cross STS:Belmont Ave - E Salisbury Pkwy
(Chief ALT) [SFD Sta 16] -- Natural Cover -- 5767 Mt Hermon Church Rd Salisbury MD - Cross STS:Rip Wil Dr - Mt Hermon Rd
(Chief ALT) [SFD Sta 2] -- Medical Assist -- 108 Glen Ave Salisbury MD - Cross STS:E Main St - Davis St
(Chief ALT) [SFD Sta 16] -- Non Breathing -- 1340 S Division St Salisbury MD - Cross STS:Milford St - Dykes Rd
(Chief ALT) [SFD Sta 16] -- Citizen Assist -- 501 Emory Ct Salisbury MD
(Chief ALT) [SFD Sta 2] -- Pi Accident -- Naylor Mill Rd & northwood Dr Salisbury MD
(Chief ALT) [SFD Sta 2] -- Pi Accident -- E Main St & monument St Salisbury MD
(Chief ALT) [SFD Sta 16] -- Citizen Assist -- 301 Tilghman Rd Salisbury MD - Cross STS:Ocean Gtwy - Woodbrooke Dr
(Chief ALT) [SFD Sta 2] -- Structure Fire -- 500 Snow Hill Rd Salisbury MD - Cross STS:S Schumaker Dr - Spring Ave
(Chief ALT) [SFD Sta 16] -- Auto Accident Rescue -- North Blvd & waverly Dr Salisbury MD

*/


public class MDWicomicoCountyBParserTest extends BaseParserTest {
  
  public MDWicomicoCountyBParserTest() {
    setParser(new MDWicomicoCountyBParser(), "WICOMICO COUNTY", "MD");
  }
  
  @Test
  public void testSalisburyFire() {

    doTest("T1",
        "(Chief ALT) [SFD Sta 2] -- Structure Fire -- 742 Hemlock St Salisbury MD - Cross STS:Shiloh St - E Lincoln Ave",
        "SRC:SFD Sta 2",
        "CALL:Structure Fire",
        "ADDR:742 Hemlock St",
        "CITY:Salisbury",
        "ST:MD",
        "X:Shiloh St - E Lincoln Ave");

    doTest("T2",
        "(Chief ALT) [SFD Sta 2] -- Automatic Alarm -- 2425 N Salisbury Blvd Salisbury MD - Cross STS:Eden St - E Ruark Dr",
        "SRC:SFD Sta 2",
        "CALL:Automatic Alarm",
        "ADDR:2425 N Salisbury Blvd",
        "CITY:Salisbury",
        "ST:MD",
        "X:Eden St - E Ruark Dr");

    doTest("T3",
        "(Chief ALT) [SFD Sta 2] -- Pi Accident -- N Salisbury Blvd & centre Rd Salisbury MD",
        "SRC:SFD Sta 2",
        "CALL:Pi Accident",
        "ADDR:N Salisbury Blvd & centre Rd",
        "CITY:Salisbury",
        "ST:MD");

    doTest("T4",
        "(Chief ALT) [SFD Sta 2] -- Delayed Ambulance -- 1018 Queen Anne St Salisbury MD - Cross STS:Jefferson St - Hammond St",
        "SRC:SFD Sta 2",
        "CALL:Delayed Ambulance",
        "ADDR:1018 Queen Anne St",
        "CITY:Salisbury",
        "ST:MD",
        "X:Jefferson St - Hammond St");

    doTest("T5",
        "(Chief ALT) [SFD Sta 2] -- Automatic Alarm -- 112 E North Pointe Dr Salisbury MD - Cross STS:Dickerson Ln",
        "SRC:SFD Sta 2",
        "CALL:Automatic Alarm",
        "ADDR:112 E North Pointe Dr",
        "CITY:Salisbury",
        "ST:MD",
        "X:Dickerson Ln");

    doTest("T6",
        "(Chief ALT) [SFD Sta 2] -- Industrial Accident -- 300 Moss Hill Ln Salisbury MD - Cross STS:Hamilton St - Craft St",
        "SRC:SFD Sta 2",
        "CALL:Industrial Accident",
        "ADDR:300 Moss Hill Ln",
        "CITY:Salisbury",
        "ST:MD",
        "X:Hamilton St - Craft St");

    doTest("T7",
        "(Chief ALT) [SFD Sta 16] -- Pi Accident -- S Division St & power St Salisbury MD",
        "SRC:SFD Sta 16",
        "CALL:Pi Accident",
        "ADDR:S Division St & power St",
        "CITY:Salisbury",
        "ST:MD");

    doTest("T8",
        "(Chief ALT) [SFD Sta 16] -- Structure Fire -- 404 Atlantic Ave Salisbury MD - Cross STS:Michigan Ave - Ontario Ave",
        "SRC:SFD Sta 16",
        "CALL:Structure Fire",
        "ADDR:404 Atlantic Ave",
        "CITY:Salisbury",
        "ST:MD",
        "X:Michigan Ave - Ontario Ave");

    doTest("T9",
        "(Chief ALT) [SFD Sta 16] -- Structure Fire -- 569 West Rd Salisbury MD - Cross STS:W Isabella St - Boundary St",
        "SRC:SFD Sta 16",
        "CALL:Structure Fire",
        "ADDR:569 West Rd",
        "CITY:Salisbury",
        "ST:MD",
        "X:W Isabella St - Boundary St");

    doTest("T10",
        "(Chief ALT) [SFD Sta 2] -- Automatic Alarm -- 505 Marvel Rd Salisbury MD - Cross STS:Windsor Dr - Shipley Dr",
        "SRC:SFD Sta 2",
        "CALL:Automatic Alarm",
        "ADDR:505 Marvel Rd",
        "CITY:Salisbury",
        "ST:MD",
        "X:Windsor Dr - Shipley Dr");

    doTest("T11",
        "(Chief ALT) [SFD Sta 2] -- Pi Accident -- E Church St & truitt St Salisbury MD",
        "SRC:SFD Sta 2",
        "CALL:Pi Accident",
        "ADDR:E Church St & truitt St",
        "CITY:Salisbury",
        "ST:MD");

    doTest("T12",
        "(Chief ALT) [SFD Sta 16] -- Pi Accident -- Snow Hill Rd & toadvine Rd Salisbury MD",
        "SRC:SFD Sta 16",
        "CALL:Pi Accident",
        "ADDR:Snow Hill Rd & toadvine Rd",
        "CITY:Salisbury",
        "ST:MD");

    doTest("T13",
        "(Chief ALT) [SFD Sta 16] -- Automatic Alarm -- 926 Snow Hill Rd Salisbury MD - Cross STS:Progress Cir",
        "SRC:SFD Sta 16",
        "CALL:Automatic Alarm",
        "ADDR:926 Snow Hill Rd",
        "CITY:Salisbury",
        "ST:MD",
        "X:Progress Cir");

    doTest("T14",
        "(Chief ALT) [SFD Sta 2] -- Smoke / Co Detector -- 703 Hammond St Salisbury MD - Cross STS:Queen Anne St",
        "SRC:SFD Sta 2",
        "CALL:Smoke / Co Detector",
        "ADDR:703 Hammond St",
        "CITY:Salisbury",
        "ST:MD",
        "X:Queen Anne St");

    doTest("T15",
        "(Chief ALT) [SFD Sta 2] -- Structure Fire -- 30370 Calhoun Ave Delmar MD - Cross STS:Aylmore Ave - Aylmore Ave",
        "SRC:SFD Sta 2",
        "CALL:Structure Fire",
        "ADDR:30370 Calhoun Ave",
        "CITY:Delmar",
        "ST:MD",
        "X:Aylmore Ave - Aylmore Ave");

    doTest("T16",
        "(Chief ALT) [SFD Sta 2] -- Auto Accident Rescue -- Deers Head Hospital Rd & harting Dr Salisbury MD",
        "SRC:SFD Sta 2",
        "CALL:Auto Accident Rescue",
        "ADDR:Deers Head Hospital Rd & harting Dr",
        "CITY:Salisbury",
        "ST:MD");

    doTest("T17",
        "(Chief ALT) [SFD Sta 2] -- Electrical -- 845 Brown St Salisbury MD - Cross STS:Calloway St - Truitt St",
        "SRC:SFD Sta 2",
        "CALL:Electrical",
        "ADDR:845 Brown St",
        "CITY:Salisbury",
        "ST:MD",
        "X:Calloway St - Truitt St");

    doTest("T18",
        "(Chief ALT) [SFD Sta 16] -- Non Breathing -- 412 E Lincoln Ave Salisbury MD - Cross STS:Roger St - Springfield Cir",
        "SRC:SFD Sta 16",
        "CALL:Non Breathing",
        "ADDR:412 E Lincoln Ave",
        "CITY:Salisbury",
        "ST:MD",
        "X:Roger St - Springfield Cir");

    doTest("T19",
        "(Chief ALT) [SFD Sta 2] -- Medical Assist -- 200 Civic Ave Salisbury MD - Cross STS:Belmont Ave - E Salisbury Pkwy",
        "SRC:SFD Sta 2",
        "CALL:Medical Assist",
        "ADDR:200 Civic Ave",
        "CITY:Salisbury",
        "ST:MD",
        "X:Belmont Ave - E Salisbury Pkwy");

    doTest("T20",
        "(Chief ALT) [SFD Sta 16] -- Natural Cover -- 5767 Mt Hermon Church Rd Salisbury MD - Cross STS:Rip Wil Dr - Mt Hermon Rd",
        "SRC:SFD Sta 16",
        "CALL:Natural Cover",
        "ADDR:5767 Mt Hermon Church Rd",
        "CITY:Salisbury",
        "ST:MD",
        "X:Rip Wil Dr - Mt Hermon Rd");

    doTest("T21",
        "(Chief ALT) [SFD Sta 2] -- Medical Assist -- 108 Glen Ave Salisbury MD - Cross STS:E Main St - Davis St",
        "SRC:SFD Sta 2",
        "CALL:Medical Assist",
        "ADDR:108 Glen Ave",
        "CITY:Salisbury",
        "ST:MD",
        "X:E Main St - Davis St");

    doTest("T22",
        "(Chief ALT) [SFD Sta 16] -- Non Breathing -- 1340 S Division St Salisbury MD - Cross STS:Milford St - Dykes Rd",
        "SRC:SFD Sta 16",
        "CALL:Non Breathing",
        "ADDR:1340 S Division St",
        "CITY:Salisbury",
        "ST:MD",
        "X:Milford St - Dykes Rd");

    doTest("T23",
        "(Chief ALT) [SFD Sta 16] -- Citizen Assist -- 501 Emory Ct Salisbury MD",
        "SRC:SFD Sta 16",
        "CALL:Citizen Assist",
        "ADDR:501 Emory Ct",
        "CITY:Salisbury",
        "ST:MD");

    doTest("T24",
        "(Chief ALT) [SFD Sta 2] -- Pi Accident -- Naylor Mill Rd & northwood Dr Salisbury MD",
        "SRC:SFD Sta 2",
        "CALL:Pi Accident",
        "ADDR:Naylor Mill Rd & northwood Dr",
        "CITY:Salisbury",
        "ST:MD");

    doTest("T25",
        "(Chief ALT) [SFD Sta 2] -- Pi Accident -- E Main St & monument St Salisbury MD",
        "SRC:SFD Sta 2",
        "CALL:Pi Accident",
        "ADDR:E Main St & monument St",
        "CITY:Salisbury",
        "ST:MD");

    doTest("T26",
        "(Chief ALT) [SFD Sta 16] -- Citizen Assist -- 301 Tilghman Rd Salisbury MD - Cross STS:Ocean Gtwy - Woodbrooke Dr",
        "SRC:SFD Sta 16",
        "CALL:Citizen Assist",
        "ADDR:301 Tilghman Rd",
        "CITY:Salisbury",
        "ST:MD",
        "X:Ocean Gtwy - Woodbrooke Dr");

    doTest("T27",
        "(Chief ALT) [SFD Sta 2] -- Structure Fire -- 500 Snow Hill Rd Salisbury MD - Cross STS:S Schumaker Dr - Spring Ave",
        "SRC:SFD Sta 2",
        "CALL:Structure Fire",
        "ADDR:500 Snow Hill Rd",
        "CITY:Salisbury",
        "ST:MD",
        "X:S Schumaker Dr - Spring Ave");

    doTest("T28",
        "(Chief ALT) [SFD Sta 16] -- Auto Accident Rescue -- North Blvd & waverly Dr Salisbury MD",
        "SRC:SFD Sta 16",
        "CALL:Auto Accident Rescue",
        "ADDR:North Blvd & waverly Dr",
        "CITY:Salisbury",
        "ST:MD");

  }
  
  public static void main(String[] args) {
    new MDWicomicoCountyBParserTest().generateTests("T1");
        
  }
}