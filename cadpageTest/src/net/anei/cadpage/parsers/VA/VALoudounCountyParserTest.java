package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.VA.VALoudounCountyParser;

import org.junit.Test;


public class VALoudounCountyParserTest extends BaseParserTest {
  
  public VALoudounCountyParserTest() {
    setParser(new VALoudounCountyParser(), "LOUDOUN COUNTY", "VA");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "Call:12D02E-SEIZURES CONT,42914 OVERLY SQ-CH Apt:,X-St:NORRINGTON SQ KIR,A6092,Box:1908 ,ADC:5520 G06 [90]",
        "CALL:12D02E-SEIZURES CONT",
        "ADDR:42914 OVERLY SQ",
        "CITY:Chantilly",
        "X:NORRINGTON SQ KIR",
        "UNIT:A6092",
        "BOX:1908",
        "MAP:5520 G06");

    doTest("T2",
        "Call:17D03-FALL PATIENT N,42848 RECTORS CHASE WAY-AB Apt:,X-St:HOYSVILLE MANOR D,A6092 904 ACO9,Box:2618 ,ADC:5400 G03 [89]",
        "CALL:17D03-FALL PATIENT N",
        "ADDR:42848 RECTORS CHASE WAY",
        "CITY:Ashburn",
        "X:HOYSVILLE MANOR D",
        "UNIT:A6092 904 ACO9",
        "BOX:2618",
        "MAP:5400 G03");

    doTest("T3",
        "Call:20D01H-HEAT EXPOSURE,STONE SPRINGS BLVD-AL/MINERAL SPRINGS CIR-AL Apt:,X-St:GREENSTONE DR & M,A6092 9942 ACO9,Box:0910 ,ADC:5520 B02 [77]",
        "CALL:20D01H-HEAT EXPOSURE",
        "ADDR:STONE SPRINGS BLVD & MINERAL SPRINGS CIR",
        "CITY:Aldie",
        "X:GREENSTONE DR & M",
        "UNIT:A6092 9942 ACO9",
        "BOX:0910",
        "MAP:5520 B02");
        
    doTest("T4",
        "([cad13] ) Call:30A01-TRAUMA NOT DAN,775 GATEWAY DR SE-LB Apt:CLUBHS,X-St:SYCOLIN RD SE VAN,M6132 ACO13,Box:2013 ,ADC:515",
        "CALL:30A01-TRAUMA NOT DAN",
        "ADDR:775 GATEWAY DR SE",
        "CITY:Leesburg",
        "APT:CLUBHS",
        "X:SYCOLIN RD SE VAN",
        "UNIT:M6132 ACO13",
        "BOX:2013",
        "MAP:515");
    
    doTest("T5",
        "([cad13] ) Call:PUBR-PUBLIC SERVICE-,60 IDA LEE DR NW-LB Apt:,X-St:KING ST N  ,A6133 A6134 Z613,Box:0113 ,ADC:5157 K01 [2",
        "CALL:PUBR-PUBLIC SERVICE-",
        "ADDR:60 IDA LEE DR NW",
        "CITY:Leesburg",
        "X:KING ST N",
        "UNIT:A6133 A6134 Z613",
        "BOX:0113",
        "MAP:5157 K01");
        
    doTest("T6",
        "([cad13] ) Call:ALS-ALS EMERGENCY   ,16591 COURAGE CT-LB Apt:,X-St:LOUDOUN CENTER PL,M6131 ACO13,Box:2024 ,ADC:5158 C08 [",
        "CALL:ALS-ALS EMERGENCY",
        "ADDR:16591 COURAGE CT",
        "CITY:Leesburg",
        "X:LOUDOUN CENTER PL",
        "UNIT:M6131 ACO13",
        "BOX:2024",
        "MAP:5158 C08");
    
    doTest("T7",
        "bmckenna+caf_=5712385054=vtext.com@arcolavfd.org Call:31A01-FAINTED NOW AL,24801 PINEBROOK RD-CH Apt:110,X-St:TALL CEDARS PKWY ,A619 M6091 ACO19,Box:1921 ,ADC:5520 F01 [97]",
        "CALL:31A01-FAINTED NOW AL",
        "ADDR:24801 PINEBROOK RD",
        "CITY:Chantilly",
        "APT:110",
        "X:TALL CEDARS PKWY",
        "UNIT:A619 M6091 ACO19",
        "BOX:1921",
        "MAP:5520 F01");

    doTest("T8",
        "Call:TRK-TRUCK FIRE,HARRY BYRD HWY-LB/GOOSE CREEK-LB Apt:,X-St:GOOSE CREEK LEESB,W606 E601 M6221 BC601 SO600 ECO22 ACO22,Box:2212",
        "CALL:TRK-TRUCK FIRE",
        "ADDR:HARRY BYRD HWY & GOOSE CREEK",
        "CITY:Leesburg",
        "X:GOOSE CREEK LEESB",
        "UNIT:W606 E601 M6221 BC601 SO600 ECO22 ACO22",
        "BOX:2212");

    doTest("T9",
        "1 of 2\nFRM:CC_Message_Notification@usamobility.net\nMSG:Call:CHIM-CHIMNEY FIRE,13396 BERLIN TPKE-LV Apt:,X-St:MILLTOWN CREEK RO,W612 ER602 TL602\n(Con't) 2 of 2\nK623 A6122 BC602 ECO12 ACO12,Box:1222 ,ADC:4922 G01 [14]\n\n-- \n[LC602](End)",
        "CALL:CHIM-CHIMNEY FIRE",
        "ADDR:13396 BERLIN TPKE",
        "CITY:Lovettsville",
        "X:MILLTOWN CREEK RO",
        "UNIT:W612 ER602 TL602 K623 A6122 BC602 ECO12 ACO12",
        "BOX:1222",
        "MAP:4922 G01");
 }
  
  public static void main(String[] args) {
    new VALoudounCountyParserTest().generateTests("T8", "CALL ADDR CITY APT X UNIT BOX MAP");
  }
}