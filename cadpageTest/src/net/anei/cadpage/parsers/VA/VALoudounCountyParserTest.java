package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.VA.VALoudounCountyParser;

import org.junit.Test;

/*

Call:12D02E-SEIZURES CONT,42914 OVERLY SQ-CH Apt:,X-St:NORRINGTON SQ KIR,A6092,Box:1908 ,ADC:5520 G06 [90]
Call:17D03-FALL PATIENT N,42848 RECTORS CHASE WAY-AB Apt:,X-St:HOYSVILLE MANOR D,A6092 904 ACO9,Box:2618 ,ADC:5400 G03 [89]
Call:20D01H-HEAT EXPOSURE,STONE SPRINGS BLVD-AL/MINERAL SPRINGS CIR-AL Apt:,X-St:GREENSTONE DR & M,A6092 9942 ACO9,Box:0910 ,ADC:5520 B02 [77]

([cad13] ) Call:30A01-TRAUMA NOT DAN,775 GATEWAY DR SE-LB Apt:CLUBHS,X-St:SYCOLIN RD SE VAN,M6132 ACO13,Box:2013 ,ADC:515
([cad13] ) Call:PUBR-PUBLIC SERVICE-,60 IDA LEE DR NW-LB Apt:,X-St:KING ST N  ,A6133 A6134 Z613,Box:0113 ,ADC:5157 K01 [2
([cad13] ) Call:ALS-ALS EMERGENCY   ,16591 COURAGE CT-LB Apt:,X-St:LOUDOUN CENTER PL,M6131 ACO13,Box:2024 ,ADC:5158 C08 [

Contact: rebecca mckenna <emtco9516@gmail.com>
bmckenna+caf_=5712385054=vtext.com@arcolavfd.org Call:31A01-FAINTED NOW AL,24801 PINEBROOK RD-CH Apt:110,X-St:TALL CEDARS PKWY ,A619 M6091 ACO19,Box:1921 ,ADC:5520 F01 [97]

Contact: Ffightertl2 <ffightertl2@yahoo.com>
Sender: CC_Message_Notification@usamobility.net
1 of 2\nFRM:CC_Message_Notification@usamobility.net\nMSG:Call:CHIM-CHIMNEY FIRE,13396 BERLIN TPKE-LV Apt:,X-St:MILLTOWN CREEK RO,W612 ER602 TL602\n(Con't) 2 of 2\nK623 A6122 BC602 ECO12 ACO12,Box:1222 ADC:4922 G01 [14]\n\n-- \n[LC602](End)

Contact: Unknown
Call:TRK-TRUCK FIRE,HARRY BYRD HWY-LB/GOOSE CREEK-LB Apt:,X-St:GOOSE CREEK LEESB,W606 E601 M6221 BC601 SO600 ECO22 ACO22,Box:2212

Contact: Derrick Bennett <dbennett@arcolavfd.org>
Sender: 6245
CC_Message_Notification@usamobility.net Call:SF-STRUCTURE FIRE,1200 BLOCK OF DUNVEGAN DRIVE Apt:,X-St:,K604,Box:FQ   ,ADC: [42]\r\n\r\n-- \r\n[LC609]\r

Contact: Anthony Miske <FFighterTL2@yahoo.com>
 1 of 2\nFRM:CC_Message_Notification@usamobility.net\nMSG:Call:29D02l-BIKE OR MOTOR,MOUNTAIN RD-PV/CHARLES TOWN PIKE-PV Apt:,X-St:CHARLES TOWN\n(Con't) 2 of 2\nPIKE,ER602 A6142 AL612 ECO2 ACO14,Box:0226K'ADC:4921 F09 [57]

Contact:  Derrick Bennett <Derrick@cadpage.org>
Sender: Loudoun Employee RSAN <msg_1Z9J@mail.emacoop.loudoun.gov>
CALL:01A01-ABDOMINAL PAIN, 42073 GREENSTONE DR-AL APT: X-ST:MINERAL SPRINGS CIR & BEA M6092 ACO9, BOX:0910 ADC:5520 C02 FDID:99079 6:05 PM
(Loudoun CAD) CALL:31D03-UNCONSCIOUS PE, 25025 OWL CREEK DR-AL APT: X-ST:URAL DR GRAYWACKE DR  E609B, BOX:0948  ADC:5520 B02 FDID:99079 10709\n\nSent by Exchange Information to Company 9 Volunteers (E-mail accounts,\nPagers, Cell phones) through Loudoun Employee RSAN - Powered by the Roam\nSecure Alert Network
CALL:INV-INVESTIGATION, SHREVEPORT DR-AB/BELMONT RIDGE RD-AB APT: X-ST:BELMONT RIDGE RD BELMONT E609B ECO9, BOX:0955 ADC:5400 E06 FDID:10709

Contact: Thomas Kane <tkane@purcellvillefire.org>
Call:HF-HOUSE FIRE,22 ADAMS DR NE-LB Apt:,X-St:HERITAGE WAY NE H,E620 E622B E606B E610 T620 TL606 R613 A6133 BC601 AC602 EM601 ECO20 AC

Contact: Active911
Agency name: Montgomery County Fire  Rescue - Main
Location: Montgomery County, MD, United States
Sender: "Loudoun Employee RSAN" <msg_22VD@mail.emacoop.loudoun.gov>

(Loudoun CAD) CALL:FILL-STATION TRANSFE, 680 SPRING STREET APT: X-ST: E611B ECO11, BOX:FX11  ADC: FDID:10711\n\nSent by Exchange Information to Company 24 Volunteers, Company 11/18 Volunteers, Company 35 Volunteers (E-mail accounts, Pagers, Cell phones) through Loudoun Employee RSAN - Powered by the Roam Secure Alert Network\r\n----\r\n- You received this message because you are registered on Loudoun Employee RSAN. Update your account or authenticate this alert by going to http://alert2.loudoun.gov/myalertlog.php?s_alert_id=97033\r\n\r\n- Tell others about Loudoun Employee RSAN! by forwarding this message to them and encouraging them go to http://alert2.loudoun.gov to register for this free service.
(Loudoun CAD) CALL:31D02-UNCONSCIOUS EF, 20540 FALCONS LANDING CIR-SP APT:4102 X-ST:   A6251 AL615 ACO25 E618, BOX:1810M ADC:5280 K03 FDID:99076 10711\n\nSent by Exchange Information to Company 24 Volunteers, Company 15/25 Volunteers, Company 11/18 Volunteers, Company 35 Volunteers (E-mail accounts, Pagers, Cell phones) through Loudoun Employee RSAN - Powered by the Roam Secure Alert Network\r\n----\r\n- You received this message because you are registered on Loudoun Employee RSAN. Update your account or authenticate this alert by going to http://alert2.loudoun.gov/myalertlog.php?s_alert_id=97019\r\n\r\n- Tell others about Loudoun Employee RSAN! by forwarding this message to them and encouraging them go to http://alert2.loudoun.gov to register for this free service.
(Loudoun CAD) CALL:ILL-ILLNESS, 5527 SULLIVANS MILL ROAD APT: X-ST: M6032 ACO3, BOX:FQ    ADC: FDID:99453\n\nSent by Exchange Information to Company 3 Volunteers (E-mail accounts, Pagers, Cell phones) through Loudoun Employee RSAN - Powered by the Roam Secure Alert Network\r\n----\r\n- You received this message because you are registered on Loudoun Employee RSAN. Update your account or authenticate this alert by going to http://alert2.loudoun.gov/myalertlog.php?s_alert_id=96973\r\n\r\n- Tell others about Loudoun Employee RSAN! by forwarding this message to them and encouraging them go to http://alert2.loudoun.gov to register for this free service.
(Loudoun CAD) CALL:09E01-CARDIAC ARREST, 20608 BELWOOD CT-SP APT: X-ST:CUTWATER PL   M6252 M6152 EM601 ACO25 ECO18 CODE E618, BOX:1823  ADC:5280 G03 FDID:99076 10723 10711 99534\n\nSent by Exchange Information to Company 23 Volunteers, Company 24 Volunteers, Company 15/25 Volunteers, Company 11/18 Volunteers, EM601, Company 35 Volunteers (E-mail accounts, Pagers, Cell phones) through Loudoun Employee RSAN - Powered by the Roam Secure Alert Network\r\n----\r\n- You received this message because you are registered on Loudoun Employee RSAN. Update your account or authenticate this alert by going to http://alert2.loudoun.gov/myalertlog.php?s_alert_id=96945\r\n\r\n- Tell others about Loudoun Employee RSAN! by forwarding this message to them and encouraging them go to http://alert2.loudoun.gov to register for this free service.
(Loudoun CAD) CALL:09D02-DOA OBVIOUS OR, 5 PHILLIPS DR NW-LB APT: X-ST:PHILLIPS CT NW FAIRVIEW S M6132 M6131 EM601 ACO13 ECO20 CODE R613, BOX:0111  ADC:5157 H01 FDID:99398 10723 10701 99534\n\nSent by Exchange Information to Company 23 Volunteers, Company 13 Volunteers, Company 1/20 Volunteers, EM601 (E-mail accounts, Pagers, Cell phones) through Loudoun Employee RSAN - Powered by the Roam Secure Alert Network\r\n----\r\n- You received this message because you are registered on Loudoun Employee RSAN. Update your account or authenticate this alert by going to http://alert2.loudoun.gov/myalertlog.php?s_alert_id=96733\r\n\r\n- Tell others about Loudoun Employee RSAN! by forwarding this message to them and encouraging them go to http://alert2.loudoun.gov to register for this free service.
(Loudoun CAD) CALL:COL-COLLAPSE OR PI I, 101 ENTERPRISE ST-SP APT: X-ST:FREE CT & COMMERCE ST BRI E611 E618 E404 E439 TL611 TL436 R439 M6152 AL625 TS625 BC601 BC603 SO600 EC, BOX:1120  ADC:5402 F01 FDID:10711 99076 05900 10700 10719\n\nSent by Exchange Information to Company 11/18 Volunteers, Company 35 Volunteers, BC601, BC603, Company 15/25 Volunteers, Company 24 Volunteers, Company 19 Volunteers, SO600 (E-mail accounts, Pagers, Cell phones) through Loudoun Employee RSAN - Powered by the Roam Secure Alert Network\r\n----\r\n- You received this message because you are registered on Loudoun Employee RSAN. Update your account or authenticate this alert by going to http://alert2.loudoun.gov/myalertlog.php?s_alert_id=96595\r\n\r\n- Tell others about Loudoun Employee RSAN! by forwarding this message to them and encouraging them go to http://alert2.loudoun.gov to register for this free service.
(Loudoun CAD) CALL:HF-HOUSE FIRE, DOMINICK TER-SP/EDEN DR-SP APT: X-ST:EDEN DR & STEFANIE DR JOS E618 E611 E622 E606 TL611 TL606 R439 M6152 BC601 BC603 EM601 SO600 ECO18 AC, BOX:2414  ADC:5280 D05 FDID:10711 99076 10706 05900 10700 10719 10723\n\nSent by Exchange Information to Company 11/18 Volunteers, Company 35 Volunteers, Company 6/22 Volunteers, BC601, Company 23 Volunteers, Company 24 Volunteers, BC603, Company 15/25 Volunteers, Company 19 Volunteers, EM601, SO600 (E-mail accounts, Pagers, Cell phones) through Loudoun Employee RSAN - Powered by the Roam Secure Alert Network\r\n----\r\n- You received this message because you are registered on Loudoun Employee RSAN. Update your account or authenticate this alert by going to http://alert2.loudoun.gov/myalertlog.php?s_alert_id=96569\r\n\r\n- Tell others about Loudoun Employee RSAN! by forwarding this message to them and encouraging them go to http://alert2.loudoun.gov to register for this free service.
(Loudoun CAD) CALL:09E01-CARDIAC ARREST, GLOUCESTER PKWY-AB/VOSBURG TER-AB APT: X-ST:VOSBURG TER RUNNYMEADE TE A6064 M6062 M6231 EM601 ACO6 ECO6 CODE E606, BOX:0612  ADC:5279 E05 FDID:99624 10723 10706 99534\n\nSent by Exchange Information to Company 23 Volunteers, EM601, Company 6/22 Volunteers (E-mail accounts, Pagers, Cell phones) through Loudoun Employee RSAN - Powered by the Roam Secure Alert Network\r\n----\r\n- You received this message because you are registered on Loudoun Employee RSAN. Update your account or authenticate this alert by going to http://alert2.loudoun.gov/myalertlog.php?s_alert_id=96135\r\n\r\n- Tell others about Loudoun Employee RSAN! by forwarding this message to them and encouraging them go to http://alert2.loudoun.gov to register for this free service.
(Loudoun CAD) CALL:09E01-CARDIAC ARREST, 43497 MILLWRIGHT TER-LB APT: X-ST:RIVERPOINT DR QUIVER RIDG M6221 M6231 EM601 ACO22 ECO22 CODE E622, BOX:2206  ADC:5159 A06 FDID:99624 10723 10706 99534\n\nSent by Exchange Information to Company 23 Volunteers, EM601, Company 6/22 Volunteers (E-mail accounts, Pagers, Cell phones) through Loudoun Employee RSAN - Powered by the Roam Secure Alert Network\r\n----\r\n- You received this message because you are registered on Loudoun Employee RSAN. Update your account or authenticate this alert by going to http://alert2.loudoun.gov/myalertlog.php?s_alert_id=95979\r\n\r\n- Tell others about Loudoun Employee RSAN! by forwarding this message to them and encouraging them go to http://alert2.loudoun.gov to register for this free service.
(Loudoun CAD) CALL:COL-COLLAPSE OR PI I, 43250 DEFENDER DR-CH APT: X-ST:SOUTH RIDING BLVD ELK LIC E698 E609B E415 E623 TL619 TL302 R607 M6092 R421 BC603 BC601 EM601 SO600 EC, BOX:1916  ADC:5520 J03 FDID:10719 10709 05900 10723 92002 10707 99079 10700\n\nSent by Exchange Information to Company 7 Volunteers, BC601, Company 23 Volunteers, BC603, Company 19 Volunteers, EM601, SO600, Company 9 Volunteers (E-mail accounts, Pagers, Cell phones) through Loudoun Employee RSAN - Powered by the Roam Secure Alert Network\r\n----\r\n- You received this message because you are registered on Loudoun Employee RSAN. Update your account or authenticate this alert by going to http://alert2.loudoun.gov/myalertlog.php?s_alert_id=95367\r\n\r\n- Tell others about Loudoun Employee RSAN! by forwarding this message to them and encouraging them go to http://alert2.loudoun.gov to register for this free service.
(Loudoun CAD) CALL:BITE-ANIMAL BITE, 20910 PIONEER RIDGE TER-AB APT: X-ST:   M6221 ACO6, BOX:0623  ADC:5278 K04 FDID:99624\n\nSent by Exchange Information to Company 6/22 Volunteers (E-mail accounts, Pagers, Cell phones) through Loudoun Employee RSAN - Powered by the Roam Secure Alert Network\r\n----\r\n- You received this message because you are registered on Loudoun Employee RSAN. Update your account or authenticate this alert by going to http://alert2.loudoun.gov/myalertlog.php?s_alert_id=95355\r\n\r\n- Tell others about Loudoun Employee RSAN! by forwarding this message to them and encouraging them go to http://alert2.loudoun.gov to register for this free service.

***/

public class VALoudounCountyParserTest extends BaseParserTest {
  
  public VALoudounCountyParserTest() {
    setParser(new VALoudounCountyParser(), "LOUDOUN COUNTY", "VA");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "Call:12D02E-SEIZURES CONT,42914 OVERLY SQ-CH Apt:,X-St:NORRINGTON SQ KIR,A6092,Box:1908 ,ADC:5520 G06 [90]",
        "CODE:12D02E",
        "CALL:SEIZURES CONT",
        "ADDR:42914 OVERLY SQ",
        "CITY:Chantilly",
        "X:NORRINGTON SQ & KIR",
        "UNIT:A6092",
        "BOX:1908",
        "MAP:5520 G06");

    doTest("T2",
        "Call:17D03-FALL PATIENT N,42848 RECTORS CHASE WAY-AB Apt:,X-St:HOYSVILLE MANOR D,A6092 904 ACO9,Box:2618 ,ADC:5400 G03 [89]",
        "CODE:17D03",
        "CALL:FALL PATIENT N",
        "ADDR:42848 RECTORS CHASE WAY",
        "CITY:Ashburn",
        "X:HOYSVILLE MANOR D",
        "UNIT:A6092 904 ACO9",
        "BOX:2618",
        "MAP:5400 G03");

    doTest("T3",
        "Call:20D01H-HEAT EXPOSURE,STONE SPRINGS BLVD-AL/MINERAL SPRINGS CIR-AL Apt:,X-St:GREENSTONE DR & M,A6092 9942 ACO9,Box:0910 ,ADC:5520 B02 [77]",
        "CODE:20D01H",
        "CALL:HEAT EXPOSURE",
        "ADDR:STONE SPRINGS BLVD & MINERAL SPRINGS CIR",
        "CITY:Aldie",
        "X:GREENSTONE DR & M",
        "UNIT:A6092 9942 ACO9",
        "BOX:0910",
        "MAP:5520 B02");
        
    doTest("T4",
        "([cad13] ) Call:30A01-TRAUMA NOT DAN,775 GATEWAY DR SE-LB Apt:CLUBHS,X-St:SYCOLIN RD SE VAN,M6132 ACO13,Box:2013 ,ADC:515",
        "CODE:30A01",
        "CALL:TRAUMA NOT DAN",
        "ADDR:775 GATEWAY DR SE",
        "CITY:Leesburg",
        "APT:CLUBHS",
        "X:SYCOLIN RD SE & VAN",
        "UNIT:M6132 ACO13",
        "BOX:2013",
        "MAP:515");
    
    doTest("T5",
        "([cad13] ) Call:PUBR-PUBLIC SERVICE-,60 IDA LEE DR NW-LB Apt:,X-St:KING ST N  ,A6133 A6134 Z613,Box:0113 ,ADC:5157 K01 [2",
        "CODE:PUBR",
        "CALL:PUBLIC SERVICE-",
        "ADDR:60 IDA LEE DR NW",
        "CITY:Leesburg",
        "X:KING ST N",
        "UNIT:A6133 A6134 Z613",
        "BOX:0113",
        "MAP:5157 K01");
        
    doTest("T6",
        "([cad13] ) Call:ALS-ALS EMERGENCY   ,16591 COURAGE CT-LB Apt:,X-St:LOUDOUN CENTER PL,M6131 ACO13,Box:2024 ,ADC:5158 C08 [",
        "CODE:ALS",
        "CALL:ALS EMERGENCY",
        "ADDR:16591 COURAGE CT",
        "CITY:Leesburg",
        "X:LOUDOUN CENTER PL",
        "UNIT:M6131 ACO13",
        "BOX:2024",
        "MAP:5158 C08");
    
    doTest("T7",
        "bmckenna+caf_=5712385054=vtext.com@arcolavfd.org Call:31A01-FAINTED NOW AL,24801 PINEBROOK RD-CH Apt:110,X-St:TALL CEDARS PKWY ,A619 M6091 ACO19,Box:1921 ,ADC:5520 F01 [97]",
        "CODE:31A01",
        "CALL:FAINTED NOW AL",
        "ADDR:24801 PINEBROOK RD",
        "CITY:Chantilly",
        "APT:110",
        "X:TALL CEDARS PKWY",
        "UNIT:A619 M6091 ACO19",
        "BOX:1921",
        "MAP:5520 F01");

    doTest("T8",
        "Call:TRK-TRUCK FIRE,HARRY BYRD HWY-LB/GOOSE CREEK-LB Apt:,X-St:GOOSE CREEK LEESB,W606 E601 M6221 BC601 SO600 ECO22 ACO22,Box:2212",
        "CODE:TRK",
        "CALL:TRUCK FIRE",
        "ADDR:HARRY BYRD HWY & GOOSE CREEK",
        "CITY:Leesburg",
        "X:GOOSE CREEK LEESB",
        "UNIT:W606 E601 M6221 BC601 SO600 ECO22 ACO22",
        "BOX:2212");

    doTest("T9",
        "1 of 2\nFRM:CC_Message_Notification@usamobility.net\nMSG:Call:CHIM-CHIMNEY FIRE,13396 BERLIN TPKE-LV Apt:,X-St:MILLTOWN CREEK RO,W612 ER602 TL602\n(Con't) 2 of 2\nK623 A6122 BC602 ECO12 ACO12,Box:1222 ,ADC:4922 G01 [14]\n\n-- \n[LC602](End)",
        "CODE:CHIM",
        "CALL:CHIMNEY FIRE",
        "ADDR:13396 BERLIN TPKE",
        "CITY:Lovettsville",
        "X:MILLTOWN CREEK RO",
        "UNIT:W612 ER602 TL602 K623 A6122 BC602 ECO12 ACO12",
        "BOX:1222",
        "MAP:4922 G01");

    doTest("T10",
        "CC_Message_Notification@usamobility.net Call:SF-STRUCTURE FIRE,1200 BLOCK OF DUNVEGAN DRIVE Apt:,X-St:,K604,Box:FQ   ,ADC: [42]\r\n" +
        "\r\n" +
        "-- \r\n" +
        "[LC609]\r",

        "CODE:SF",
        "CALL:STRUCTURE FIRE",
        "ADDR:1200 BLOCK OF DUNVEGAN DRIVE",
        "MADDR:1200 DUNVEGAN DRIVE",
        "UNIT:K604",
        "BOX:FQ");

    doTest("T11",
        " 1 of 2\n" +
        "FRM:CC_Message_Notification@usamobility.net\n" +
        "MSG:Call:29D02l-BIKE OR MOTOR,MOUNTAIN RD-PV/CHARLES TOWN PIKE-PV Apt:,X-St:CHARLES TOWN\n" +
        "(Con't) 2 of 2\n" +
        "PIKE,ER602 A6142 AL612 ECO2 ACO14,Box:0226K'ADC:4921 F09 [57]",

        "CODE:29D02L",
        "CALL:BIKE OR MOTOR",
        "ADDR:MOUNTAIN RD & CHARLES TOWN PIKE",
        "CITY:Purcellville",
        "X:CHARLES TOWN PIKE",
        "UNIT:ER602 A6142 AL612 ECO2 ACO14",
        "BOX:0226K'ADC:4921 F09");
        
  }
  
  @Test
  public void testDerrickBennet() {

    doTest("T1",
        "CALL:01A01-ABDOMINAL PAIN, 42073 GREENSTONE DR-AL APT: X-ST:MINERAL SPRINGS CIR & BEA M6092 ACO9, BOX:0910 ADC:5520 C02 FDID:99079 6:05 PM",
        "CODE:01A01",
        "CALL:ABDOMINAL PAIN",
        "ADDR:42073 GREENSTONE DR",
        "CITY:Aldie",
        "X:MINERAL SPRINGS CIR & BEA",
        "UNIT:M6092 ACO9",
        "BOX:0910",
        "MAP:5520 C02",
        "ID:99079",
        "TIME:18:05:00");

    doTest("T2",
        "(Loudoun CAD) CALL:31D03-UNCONSCIOUS PE, 25025 OWL CREEK DR-AL APT: X-ST:URAL DR GRAYWACKE DR  E609B, BOX:0948  ADC:5520 B02 FDID:99079 10709\n\n" +
        "Sent by Exchange Information to Company 9 Volunteers (E-mail accounts,\n" +
        "Pagers, Cell phones) through Loudoun Employee RSAN - Powered by the Roam\n" +
        "Secure Alert Network",

        "CODE:31D03",
        "CALL:UNCONSCIOUS PE",
        "ADDR:25025 OWL CREEK DR",
        "CITY:Aldie",
        "X:URAL DR & GRAYWACKE DR",
        "UNIT:E609B",
        "BOX:0948",
        "MAP:5520 B02",
        "ID:99079 10709");

    doTest("T3",
        "CALL:INV-INVESTIGATION, SHREVEPORT DR-AB/BELMONT RIDGE RD-AB APT: X-ST:BELMONT RIDGE RD BELMONT E609B ECO9, BOX:0955 ADC:5400 E06 FDID:10709",
        "CODE:INV",
        "CALL:INVESTIGATION",
        "ADDR:SHREVEPORT DR & BELMONT RIDGE RD",
        "CITY:Ashburn",
        "X:BELMONT RIDGE RD & BELMONT",
        "UNIT:E609B ECO9",
        "BOX:0955",
        "MAP:5400 E06",
        "ID:10709");
 
  }
  
  @Test
  public void testThomasKane() {

    doTest("T1",
        "Call:HF-HOUSE FIRE,22 ADAMS DR NE-LB Apt:,X-St:HERITAGE WAY NE H,E620 E622B E606B E610 T620 TL606 R613 A6133 BC601 AC602 EM601 ECO20 AC",
        "CODE:HF",
        "CALL:HOUSE FIRE",
        "ADDR:22 ADAMS DR NE",
        "CITY:Leesburg",
        "X:HERITAGE WAY NE & H",
        "UNIT:E620 E622B E606B E610 T620 TL606 R613 A6133 BC601 AC602 EM601 ECO20 AC");
   
  }
  
  @Test
  public void testMontgomeryCountyFireRescue() {

    doTest("T1",
        "(Loudoun CAD) CALL:FILL-STATION TRANSFE, 680 SPRING STREET APT: X-ST: E611B ECO11, BOX:FX11  ADC: FDID:10711\n\n" +
        "Sent by Exchange Information to Company 24 Volunteers, Company 11/18 Volunteers, Company 35 Volunteers (E-mail accounts, Pagers, Cell phones) through Loudoun Employee RSAN - Powered by the Roam Secure Alert Network\r\n" +
        "----\r\n" +
        "- You received this message because you are registered on Loudoun Employee RSAN. Update your account or authenticate this alert by going to http://alert2.loudoun.gov/myalertlog.php?s_alert_id=97033\r\n" +
        "\r\n" +
        "- Tell others about Loudoun Employee RSAN! by forwarding this message to them and encouraging them go to http://alert2.loudoun.gov to register for this free service.",

        "CODE:FILL",
        "CALL:STATION TRANSFE",
        "ADDR:680 SPRING STREET",
        "UNIT:E611B ECO11",
        "BOX:FX11",
        "ID:10711");

    doTest("T2",
        "(Loudoun CAD) CALL:31D02-UNCONSCIOUS EF, 20540 FALCONS LANDING CIR-SP APT:4102 X-ST:   A6251 AL615 ACO25 E618, BOX:1810M ADC:5280 K03 FDID:99076 10711\n\n" +
        "Sent by Exchange Information to Company 24 Volunteers, Company 15/25 Volunteers, Company 11/18 Volunteers, Company 35 Volunteers (E-mail accounts, Pagers, Cell phones) through Loudoun Employee RSAN - Powered by the Roam Secure Alert Network\r\n" +
        "----\r\n" +
        "- You received this message because you are registered on Loudoun Employee RSAN. Update your account or authenticate this alert by going to http://alert2.loudoun.gov/myalertlog.php?s_alert_id=97019\r\n" +
        "\r\n" +
        "- Tell others about Loudoun Employee RSAN! by forwarding this message to them and encouraging them go to http://alert2.loudoun.gov to register for this free service.",

        "CODE:31D02",
        "CALL:UNCONSCIOUS EF",
        "ADDR:20540 FALCONS LANDING CIR",
        "APT:4102",
        "CITY:Sterling",
        "UNIT:A6251 AL615 ACO25 E618",
        "BOX:1810M",
        "MAP:5280 K03",
        "ID:99076 10711");

    doTest("T3",
        "(Loudoun CAD) CALL:ILL-ILLNESS, 5527 SULLIVANS MILL ROAD APT: X-ST: M6032 ACO3, BOX:FQ    ADC: FDID:99453\n\n" +
        "Sent by Exchange Information to Company 3 Volunteers (E-mail accounts, Pagers, Cell phones) through Loudoun Employee RSAN - Powered by the Roam Secure Alert Network\r\n" +
        "----\r\n" +
        "- You received this message because you are registered on Loudoun Employee RSAN. Update your account or authenticate this alert by going to http://alert2.loudoun.gov/myalertlog.php?s_alert_id=96973\r\n" +
        "\r\n" +
        "- Tell others about Loudoun Employee RSAN! by forwarding this message to them and encouraging them go to http://alert2.loudoun.gov to register for this free service.",

        "CODE:ILL",
        "CALL:ILLNESS",
        "ADDR:5527 SULLIVANS MILL ROAD",
        "UNIT:M6032 ACO3",
        "BOX:FQ",
        "ID:99453");

    doTest("T4",
        "(Loudoun CAD) CALL:09E01-CARDIAC ARREST, 20608 BELWOOD CT-SP APT: X-ST:CUTWATER PL   M6252 M6152 EM601 ACO25 ECO18 CODE E618, BOX:1823  ADC:5280 G03 FDID:99076 10723 10711 99534\n\n" +
        "Sent by Exchange Information to Company 23 Volunteers, Company 24 Volunteers, Company 15/25 Volunteers, Company 11/18 Volunteers, EM601, Company 35 Volunteers (E-mail accounts, Pagers, Cell phones) through Loudoun Employee RSAN - Powered by the Roam Secure Alert Network\r\n" +
        "----\r\n" +
        "- You received this message because you are registered on Loudoun Employee RSAN. Update your account or authenticate this alert by going to http://alert2.loudoun.gov/myalertlog.php?s_alert_id=96945\r\n" +
        "\r\n" +
        "- Tell others about Loudoun Employee RSAN! by forwarding this message to them and encouraging them go to http://alert2.loudoun.gov to register for this free service.",

        "CODE:09E01",
        "CALL:CARDIAC ARREST",
        "ADDR:20608 BELWOOD CT",
        "CITY:Sterling",
        "X:CUTWATER PL",
        "UNIT:M6252 M6152 EM601 ACO25 ECO18 CODE E618",
        "BOX:1823",
        "MAP:5280 G03",
        "ID:99076 10723 10711 99534");

    doTest("T5",
        "(Loudoun CAD) CALL:09D02-DOA OBVIOUS OR, 5 PHILLIPS DR NW-LB APT: X-ST:PHILLIPS CT NW FAIRVIEW S M6132 M6131 EM601 ACO13 ECO20 CODE R613, BOX:0111  ADC:5157 H01 FDID:99398 10723 10701 99534\n\n" +
        "Sent by Exchange Information to Company 23 Volunteers, Company 13 Volunteers, Company 1/20 Volunteers, EM601 (E-mail accounts, Pagers, Cell phones) through Loudoun Employee RSAN - Powered by the Roam Secure Alert Network\r\n" +
        "----\r\n" +
        "- You received this message because you are registered on Loudoun Employee RSAN. Update your account or authenticate this alert by going to http://alert2.loudoun.gov/myalertlog.php?s_alert_id=96733\r\n" +
        "\r\n" +
        "- Tell others about Loudoun Employee RSAN! by forwarding this message to them and encouraging them go to http://alert2.loudoun.gov to register for this free service.",

        "CODE:09D02",
        "CALL:DOA OBVIOUS OR",
        "ADDR:5 PHILLIPS DR NW",
        "CITY:Leesburg",
        "X:PHILLIPS CT NW & FAIRVIEW S",
        "UNIT:M6132 M6131 EM601 ACO13 ECO20 CODE R613",
        "BOX:0111",
        "MAP:5157 H01",
        "ID:99398 10723 10701 99534");

    doTest("T6",
        "(Loudoun CAD) CALL:COL-COLLAPSE OR PI I, 101 ENTERPRISE ST-SP APT: X-ST:FREE CT & COMMERCE ST BRI E611 E618 E404 E439 TL611 TL436 R439 M6152 AL625 TS625 BC601 BC603 SO600 EC, BOX:1120  ADC:5402 F01 FDID:10711 99076 05900 10700 10719\n\n" +
        "Sent by Exchange Information to Company 11/18 Volunteers, Company 35 Volunteers, BC601, BC603, Company 15/25 Volunteers, Company 24 Volunteers, Company 19 Volunteers, SO600 (E-mail accounts, Pagers, Cell phones) through Loudoun Employee RSAN - Powered by the Roam Secure Alert Network\r\n" +
        "----\r\n" +
        "- You received this message because you are registered on Loudoun Employee RSAN. Update your account or authenticate this alert by going to http://alert2.loudoun.gov/myalertlog.php?s_alert_id=96595\r\n" +
        "\r\n" +
        "- Tell others about Loudoun Employee RSAN! by forwarding this message to them and encouraging them go to http://alert2.loudoun.gov to register for this free service.",

        "CODE:COL",
        "CALL:COLLAPSE OR PI I",
        "ADDR:101 ENTERPRISE ST",
        "CITY:Sterling",
        "X:FREE CT & COMMERCE ST BRI",
        "UNIT:E611 E618 E404 E439 TL611 TL436 R439 M6152 AL625 TS625 BC601 BC603 SO600 EC",
        "BOX:1120",
        "MAP:5402 F01",
        "ID:10711 99076 05900 10700 10719");

    doTest("T7",
        "(Loudoun CAD) CALL:HF-HOUSE FIRE, DOMINICK TER-SP/EDEN DR-SP APT: X-ST:EDEN DR & STEFANIE DR JOS E618 E611 E622 E606 TL611 TL606 R439 M6152 BC601 BC603 EM601 SO600 ECO18 AC, BOX:2414  ADC:5280 D05 FDID:10711 99076 10706 05900 10700 10719 10723\n\n" +
        "Sent by Exchange Information to Company 11/18 Volunteers, Company 35 Volunteers, Company 6/22 Volunteers, BC601, Company 23 Volunteers, Company 24 Volunteers, BC603, Company 15/25 Volunteers, Company 19 Volunteers, EM601, SO600 (E-mail accounts, Pagers, Cell phones) through Loudoun Employee RSAN - Powered by the Roam Secure Alert Network\r\n" +
        "----\r\n" +
        "- You received this message because you are registered on Loudoun Employee RSAN. Update your account or authenticate this alert by going to http://alert2.loudoun.gov/myalertlog.php?s_alert_id=96569\r\n" +
        "\r\n" +
        "- Tell others about Loudoun Employee RSAN! by forwarding this message to them and encouraging them go to http://alert2.loudoun.gov to register for this free service.",

        "CODE:HF",
        "CALL:HOUSE FIRE",
        "ADDR:DOMINICK TER & EDEN DR",
        "CITY:Sterling",
        "X:EDEN DR & STEFANIE DR JOS",
        "UNIT:E618 E611 E622 E606 TL611 TL606 R439 M6152 BC601 BC603 EM601 SO600 ECO18 AC",
        "BOX:2414",
        "MAP:5280 D05",
        "ID:10711 99076 10706 05900 10700 10719 10723");

    doTest("T8",
        "(Loudoun CAD) CALL:09E01-CARDIAC ARREST, GLOUCESTER PKWY-AB/VOSBURG TER-AB APT: X-ST:VOSBURG TER RUNNYMEADE TE A6064 M6062 M6231 EM601 ACO6 ECO6 CODE E606, BOX:0612  ADC:5279 E05 FDID:99624 10723 10706 99534\n\n" +
        "Sent by Exchange Information to Company 23 Volunteers, EM601, Company 6/22 Volunteers (E-mail accounts, Pagers, Cell phones) through Loudoun Employee RSAN - Powered by the Roam Secure Alert Network\r\n" +
        "----\r\n" +
        "- You received this message because you are registered on Loudoun Employee RSAN. Update your account or authenticate this alert by going to http://alert2.loudoun.gov/myalertlog.php?s_alert_id=96135\r\n" +
        "\r\n" +
        "- Tell others about Loudoun Employee RSAN! by forwarding this message to them and encouraging them go to http://alert2.loudoun.gov to register for this free service.",

        "CODE:09E01",
        "CALL:CARDIAC ARREST",
        "ADDR:GLOUCESTER PKWY & VOSBURG TER",
        "CITY:Ashburn",
        "X:VOSBURG TER & RUNNYMEADE TE",
        "UNIT:A6064 M6062 M6231 EM601 ACO6 ECO6 CODE E606",
        "BOX:0612",
        "MAP:5279 E05",
        "ID:99624 10723 10706 99534");

    doTest("T9",
        "(Loudoun CAD) CALL:09E01-CARDIAC ARREST, 43497 MILLWRIGHT TER-LB APT: X-ST:RIVERPOINT DR QUIVER RIDG M6221 M6231 EM601 ACO22 ECO22 CODE E622, BOX:2206  ADC:5159 A06 FDID:99624 10723 10706 99534\n\n" +
        "Sent by Exchange Information to Company 23 Volunteers, EM601, Company 6/22 Volunteers (E-mail accounts, Pagers, Cell phones) through Loudoun Employee RSAN - Powered by the Roam Secure Alert Network\r\n" +
        "----\r\n" +
        "- You received this message because you are registered on Loudoun Employee RSAN. Update your account or authenticate this alert by going to http://alert2.loudoun.gov/myalertlog.php?s_alert_id=95979\r\n" +
        "\r\n" +
        "- Tell others about Loudoun Employee RSAN! by forwarding this message to them and encouraging them go to http://alert2.loudoun.gov to register for this free service.",

        "CODE:09E01",
        "CALL:CARDIAC ARREST",
        "ADDR:43497 MILLWRIGHT TER",
        "CITY:Leesburg",
        "X:RIVERPOINT DR & QUIVER RIDG",
        "UNIT:M6221 M6231 EM601 ACO22 ECO22 CODE E622",
        "BOX:2206",
        "MAP:5159 A06",
        "ID:99624 10723 10706 99534");

    doTest("T10",
        "(Loudoun CAD) CALL:COL-COLLAPSE OR PI I, 43250 DEFENDER DR-CH APT: X-ST:SOUTH RIDING BLVD ELK LIC E698 E609B E415 E623 TL619 TL302 R607 M6092 R421 BC603 BC601 EM601 SO600 EC, BOX:1916  ADC:5520 J03 FDID:10719 10709 05900 10723 92002 10707 99079 10700\n\n" +
        "Sent by Exchange Information to Company 7 Volunteers, BC601, Company 23 Volunteers, BC603, Company 19 Volunteers, EM601, SO600, Company 9 Volunteers (E-mail accounts, Pagers, Cell phones) through Loudoun Employee RSAN - Powered by the Roam Secure Alert Network\r\n" +
        "----\r\n" +
        "- You received this message because you are registered on Loudoun Employee RSAN. Update your account or authenticate this alert by going to http://alert2.loudoun.gov/myalertlog.php?s_alert_id=95367\r\n" +
        "\r\n" +
        "- Tell others about Loudoun Employee RSAN! by forwarding this message to them and encouraging them go to http://alert2.loudoun.gov to register for this free service.",

        "CODE:COL",
        "CALL:COLLAPSE OR PI I",
        "ADDR:43250 DEFENDER DR",
        "CITY:Chantilly",
        "X:SOUTH RIDING BLVD & ELK LIC",
        "UNIT:E698 E609B E415 E623 TL619 TL302 R607 M6092 R421 BC603 BC601 EM601 SO600 EC",
        "BOX:1916",
        "MAP:5520 J03",
        "ID:10719 10709 05900 10723 92002 10707 99079 10700");

    doTest("T11",
        "(Loudoun CAD) CALL:BITE-ANIMAL BITE, 20910 PIONEER RIDGE TER-AB APT: X-ST:   M6221 ACO6, BOX:0623  ADC:5278 K04 FDID:99624\n\n" +
        "Sent by Exchange Information to Company 6/22 Volunteers (E-mail accounts, Pagers, Cell phones) through Loudoun Employee RSAN - Powered by the Roam Secure Alert Network\r\n" +
        "----\r\n" +
        "- You received this message because you are registered on Loudoun Employee RSAN. Update your account or authenticate this alert by going to http://alert2.loudoun.gov/myalertlog.php?s_alert_id=95355\r\n" +
        "\r\n" +
        "- Tell others about Loudoun Employee RSAN! by forwarding this message to them and encouraging them go to http://alert2.loudoun.gov to register for this free service.",

        "CODE:BITE",
        "CALL:ANIMAL BITE",
        "ADDR:20910 PIONEER RIDGE TER",
        "CITY:Ashburn",
        "UNIT:M6221 ACO6",
        "BOX:0623",
        "MAP:5278 K04",
        "ID:99624");

  }
  
  public static void main(String[] args) {
    new VALoudounCountyParserTest().generateTests("T1");
  }
}