package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Acadian Ambulance, (LA, MS, and TX)
Contact: Heath Manson <heath.manson@gmail.com>
Sender: commcenter@acadian.com

Texas
Resp#9879458 Non Life Threatening EmergencySick Person (Specific Diag.) Loc: Add:228 Birchwood Dr APT: Cross St:Ridgewood Dr/E Old Field Dr City:Huffman Cnty: Harris Map Pg: Dest: Pt's Name:
Resp#9881088 Life Threatening Emergency Breathing Problem Loc: Add:25809 Lakewater Dr APT: Cross St:Waterwood Dr/Dead End City:Huffman Cnty: Harris Map Pg: Dest: Pt's Name:
Resp#9881174 Life Threatening Emergency Heart Problems Loc: Add:187 Cypress St APT: Cross St:Dead End/Main St City:Harris County Cnty: Harris Map Pg: Dest: Pt's Name:
Resp#9881442 Life Threatening Emergency Heart Problems Loc: Add:24212 Fm 2100 Rd APT: Cross St:Unnamed Street/3rd St City:Huffman Cnty: Harris Map Pg: Dest: Pt's Name:
Resp#9881815 Non Life Threatening EmergencySick Person (Specific Diag.) Loc: Add:2206 Stag Cir APT: Cross St:Rain Forest Dr/Dead End City:Huffman Cnty: Harris Map Pg: Dest: Pt's Name:
Resp#9882387 Life Threatening Emergency Breathing Problem Loc: Add:58 Short Leaf Dr APT: Cross St:Hickory Ridge Dr/Magnolia Ln City:Harris County Cnty: Harris Map Pg: Dest: Pt's Name:
Resp#9882614 Unscheduled Tx Unscheduled Transport Loc:Clear Lake Regional Medical CeAdd:500 Medical Center Blvd APT:5536 Cross St:Connecting Road/Unnamed Street City:Webster Cnty: Map Pg: Dest:Park Manor South Belt 11902 Resource Pkwy Pt's Name: taylor paula
Resp#9884208 Immediate/Eme Response 29A01-Minor Injury Loc: Add:Plum Grove Rd & Huffman ClevelAPT: Cross St: City:Harris County Cnty: Harris Map Pg: Dest: Pt's Name:
Resp#9885116 Life Threatening Emergency Traffic Accidents Loc: Add:Kingwood Dr & Huffman ClevelanAPT: Cross St: City:Harris County Cnty: Harris Map Pg: Dest: Pt's Name:
Resp#9893942 Unscheduled Tx Unscheduled Transport Loc:West Houston Medical Center Add:12141 Richmond Ave APT:335 Cross St:Driveway/Unnamed Street City:Houston Cnty: Map Pg: Dest: 7789 Southwest Fwy Pt's Name: gonzalez ofelia
Resp#9909614 Life Threatening Emergency Traffic Accidents Loc: Add:Fm 2100 & Huffman Rd APT: Cross St:FM 2100/Huffman Cleveland RD City:Huffman Cnty: Map Pg: Dest: Pt's Name:


Contact: Active911
Agency name: Acadian
Location: Beaumont, TX, United States

(VisiCad SMTP Paging) Resp#10422288 Life Threatening Emergency Hemorrhage/Lacerations Loc: Add:1131 W Procter St APT: Cross St:Dunbar Ave/Harding Ave City:Port Arthur Cnty: JEFFERSON Map Pg: Dest: Pt's Name:
(VisiCad SMTP Paging) Resp#10422373 Non Life Threatening EmergencySick Person (Specific Diag.) Loc: Add:155 Gary St APT: Cross St:Frontage Rd/Dead End City:Bridge City Cnty: Orange Map Pg: Dest: Pt's Name:

*/

public class TXAcadianAmbulanceParserTest extends BaseParserTest {
  
  public TXAcadianAmbulanceParserTest() {
    setParser(new TXAcadianAmbulanceParser(), "", "TX");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Resp#9879458 Non Life Threatening EmergencySick Person (Specific Diag.) Loc: Add:228 Birchwood Dr APT: Cross St:Ridgewood Dr/E Old Field Dr City:Huffman Cnty: Harris Map Pg: Dest: Pt's Name:",
        "ID:9879458",
        "CALL:Non Life Threatening EmergencySick Person (Specific Diag.)",
        "ADDR:228 Birchwood Dr",
        "X:Ridgewood Dr/E Old Field Dr",
        "CITY:Huffman, Harris");

    doTest("T2",
        "Resp#9881088 Life Threatening Emergency Breathing Problem Loc: Add:25809 Lakewater Dr APT: Cross St:Waterwood Dr/Dead End City:Huffman Cnty: Harris Map Pg: Dest: Pt's Name:",
        "ID:9881088",
        "CALL:Life Threatening Emergency Breathing Problem",
        "ADDR:25809 Lakewater Dr",
        "X:Waterwood Dr/Dead End",
        "CITY:Huffman, Harris");

    doTest("T3",
        "Resp#9881174 Life Threatening Emergency Heart Problems Loc: Add:187 Cypress St APT: Cross St:Dead End/Main St City:Harris County Cnty: Harris Map Pg: Dest: Pt's Name:",
        "ID:9881174",
        "CALL:Life Threatening Emergency Heart Problems",
        "ADDR:187 Cypress St",
        "X:Dead End/Main St",
        "CITY:Harris County");

    doTest("T4",
        "Resp#9881442 Life Threatening Emergency Heart Problems Loc: Add:24212 Fm 2100 Rd APT: Cross St:Unnamed Street/3rd St City:Huffman Cnty: Harris Map Pg: Dest: Pt's Name:",
        "ID:9881442",
        "CALL:Life Threatening Emergency Heart Problems",
        "ADDR:24212 Fm 2100 Rd",
        "MADDR:24212 FM 2100",
        "X:Unnamed Street/3rd St",
        "CITY:Huffman, Harris");

    doTest("T5",
        "Resp#9881815 Non Life Threatening EmergencySick Person (Specific Diag.) Loc: Add:2206 Stag Cir APT: Cross St:Rain Forest Dr/Dead End City:Huffman Cnty: Harris Map Pg: Dest: Pt's Name:",
        "ID:9881815",
        "CALL:Non Life Threatening EmergencySick Person (Specific Diag.)",
        "ADDR:2206 Stag Cir",
        "X:Rain Forest Dr/Dead End",
        "CITY:Huffman, Harris");

    doTest("T6",
        "Resp#9882387 Life Threatening Emergency Breathing Problem Loc: Add:58 Short Leaf Dr APT: Cross St:Hickory Ridge Dr/Magnolia Ln City:Harris County Cnty: Harris Map Pg: Dest: Pt's Name:",
        "ID:9882387",
        "CALL:Life Threatening Emergency Breathing Problem",
        "ADDR:58 Short Leaf Dr",
        "X:Hickory Ridge Dr/Magnolia Ln",
        "CITY:Harris County");

    doTest("T7",
        "Resp#9882614 Unscheduled Tx Unscheduled Transport Loc:Clear Lake Regional Medical CeAdd:500 Medical Center Blvd APT:5536 Cross St:Connecting Road/Unnamed Street City:Webster Cnty: Map Pg: Dest:Park Manor South Belt 11902 Resource Pkwy Pt's Name: taylor paula",
        "ID:9882614",
        "CALL:Unscheduled Tx Unscheduled Transport",
        "PLACE:Clear Lake Regional Medical Ce",
        "ADDR:500 Medical Center Blvd",
        "APT:5536",
        "X:Connecting Road/Unnamed Street",
        "CITY:Webster",
        "INFO:Park Manor South Belt 11902 Resource Pkwy",
        "NAME:taylor paula");

    doTest("T8",
        "Resp#9884208 Immediate/Eme Response 29A01-Minor Injury Loc: Add:Plum Grove Rd & Huffman ClevelAPT: Cross St: City:Harris County Cnty: Harris Map Pg: Dest: Pt's Name:",
        "ID:9884208",
        "CALL:Immediate/Eme Response 29A01-Minor Injury",
        "ADDR:Plum Grove Rd & Huffman-Cleveland Rd",
        "CITY:Harris County");

    doTest("T9",
        "Resp#9885116 Life Threatening Emergency Traffic Accidents Loc: Add:Kingwood Dr & Huffman ClevelanAPT: Cross St: City:Harris County Cnty: Harris Map Pg: Dest: Pt's Name:",
        "ID:9885116",
        "CALL:Life Threatening Emergency Traffic Accidents",
        "ADDR:Kingwood Dr & Huffman-Cleveland Rd",
        "CITY:Harris County");

    doTest("T10",
        "Resp#9893942 Unscheduled Tx Unscheduled Transport Loc:West Houston Medical Center Add:12141 Richmond Ave APT:335 Cross St:Driveway/Unnamed Street City:Houston Cnty: Map Pg: Dest: 7789 Southwest Fwy Pt's Name: gonzalez ofelia",
        "ID:9893942",
        "CALL:Unscheduled Tx Unscheduled Transport",
        "PLACE:West Houston Medical Center",
        "ADDR:12141 Richmond Ave",
        "APT:335",
        "X:Driveway/Unnamed Street",
        "CITY:Houston",
        "INFO:7789 Southwest Fwy",
        "NAME:gonzalez ofelia");

    doTest("T11",
        "Resp#9909614 Life Threatening Emergency Traffic Accidents Loc: Add:Fm 2100 & Huffman Rd APT: Cross St:FM 2100/Huffman Cleveland RD City:Huffman Cnty: Map Pg: Dest: Pt's Name:",
        "ID:9909614",
        "CALL:Life Threatening Emergency Traffic Accidents",
        "ADDR:Fm 2100 & Huffman Rd",
        "X:FM 2100/Huffman Cleveland RD",
        "CITY:Huffman");
  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "(VisiCad SMTP Paging) Resp#10422288 Life Threatening Emergency Hemorrhage/Lacerations Loc: Add:1131 W Procter St APT: Cross St:Dunbar Ave/Harding Ave City:Port Arthur Cnty: JEFFERSON Map Pg: Dest: Pt's Name:",
        "ID:10422288",
        "CALL:Life Threatening Emergency Hemorrhage/Lacerations",
        "ADDR:1131 W Procter St",
        "X:Dunbar Ave/Harding Ave",
        "CITY:Port Arthur, JEFFERSON");

    doTest("T2",
        "(VisiCad SMTP Paging) Resp#10422373 Non Life Threatening EmergencySick Person (Specific Diag.) Loc: Add:155 Gary St APT: Cross St:Frontage Rd/Dead End City:Bridge City Cnty: Orange Map Pg: Dest: Pt's Name:",
        "ID:10422373",
        "CALL:Non Life Threatening EmergencySick Person (Specific Diag.)",
        "ADDR:155 Gary St",
        "X:Frontage Rd/Dead End",
        "CITY:Bridge City, Orange");

  }
  
  public static void main(String[] args) {
    new TXAcadianAmbulanceParserTest().generateTests("T1");
  }
}