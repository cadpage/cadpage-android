package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class MDPrinceGeorgesCountyBParserTest extends BaseParserTest {
  
  public MDPrinceGeorgesCountyBParserTest() {
    setParser(new MDPrinceGeorgesCountyBParser(), "PRINCE GEORGES COUNTY", "MD");
  }
  
  @Test
  public void testParser1() {

    doTest("T1",
        "DISPATCH From FED01:ALS1, Medic Local, 4500 LORDS LANDING RD #205, PP, btwn BISHOPS BEQUEST RD and CAPTAIN",
        "SRC:FED01",
        "CALL:ALS1-Medic Local",
        "ADDR:4500 LORDS LANDING RD",
        "APT:205",
        "X:BISHOPS BEQUEST RD and CAPTAIN");

    doTest("T2",
        "DISPATCH From FED10:ALS1, Medic Local, 6802 BURCH HILL RD, PP, btwn BRANDYWINE RD and COLLIN HILL WAY, TGC2",
        "SRC:FED10",
        "CALL:ALS1-Medic Local",
        "ADDR:6802 BURCH HILL RD",
        "X:BRANDYWINE RD and COLLIN HILL WAY",
        "CH:TGC2");

    doTest("T3",
        "DISPATCH From FED10:BLS0, BLS Amb, 12003 WALLACE LN, PP, btwn DULEY STATION RD and WALLACE LANDING CT, TGC 2, 4504, 5884 C 1, Medical ProQA recommends dispatch at this time, Unit:A820",
        "SRC:FED10",
        "CALL:BLS0-BLS Amb",
        "ADDR:12003 WALLACE LN",
        "X:DULEY STATION RD and WALLACE LANDING CT",
        "CH:TGC 2",
        "MAP:5884 C 1",
        "UNIT:A820");

    doTest("T4",
        "DISPATCH From FED10:BLS0, BLS Amb, 12003 WALLACE LN, PP, btwn DULEY STATION RD and WALLACE LANDING CT, TGC 2, 4504, 5884 C 1, Medical ProQA recommends dispatch at this time, Unit:A820",
        "SRC:FED10",
        "CALL:BLS0-BLS Amb",
        "ADDR:12003 WALLACE LN",
        "X:DULEY STATION RD and WALLACE LANDING CT",
        "CH:TGC 2",
        "MAP:5884 C 1",
        "UNIT:A820");

    doTest("T5",
        "DISPATCH From FED10:HOUSEF, House Fire, 10511 MULLIKIN DR, PP, btwn PARKVIEW LN and GATOR PL, TGC3, 2514, 5882 G 1, Fire ProQA recommends dispatch at this time, Units:BO887, E823, E825, E847, RE840, SQ827, TK832, TK837",
        "SRC:FED10",
        "CALL:HOUSEF-House Fire",
        "ADDR:10511 MULLIKIN DR",
        "X:PARKVIEW LN and GATOR PL",
        "CH:TGC3",
        "MAP:5882 G 1",
        "UNIT:BO887, E823, E825, E847, RE840, SQ827, TK832, TK837");

    doTest("T6",
        "DISPATCH From FED01:ALS1, Medic Local, 4905 ASHFORD PL, PP, btwn CRANFORD DR and ASHFORD DR, TGA2, 2017, 5 651 K 9, Medical ProQA recommends dispatch at this time, Units:A820, MD845",
        "SRC:FED01",
        "CALL:ALS1-Medic Local",
        "ADDR:4905 ASHFORD PL",
        "X:CRANFORD DR and ASHFORD DR",
        "CH:TGA2",
        "MAP:5 651 K 9",
        "UNIT:A820, MD845");

    doTest("T7",
        "DISPATCH From FED01:BLS, BLS Amb, 14741 GOVERNOR ODEN BOWIE DR, PP, btwn ELM ST and MAIN ST, TGA2, 2009, 5652 K 10, PER ID 1879 FB NEEDED TO RESPOND TO 5TH FL FOR SEMI CONCIOUS SICK CITZ..NFI @ THIS TIME, Units:A843, E820",
        "SRC:FED01",
        "CALL:BLS-BLS Amb",
        "ADDR:14741 GOVERNOR ODEN BOWIE DR",
        "X:ELM ST and MAIN ST",
        "CH:TGA2",
        "MAP:5652 K 10",
        "INFO:PER ID 1879 FB NEEDED TO RESPOND TO 5TH FL FOR SEMI CONCIOUS SICK CITZ..NFI @ THIS TIME",
        "UNIT:A843, E820");
  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "BC 887 STREET, Street Alarm, 11113 BIRCH WAY, PP, btwn ELM WAY and PENNY AVE, TGC3, 2515, 5882 G 2, Fire ProQA recommends dispatch at this time, Units:BO887, E825, RE840, SQ827, TK832",
        "SRC:BC 887",
        "CALL:STREET-Street Alarm",
        "ADDR:11113 BIRCH WAY",
        "X:ELM WAY and PENNY AVE",
        "CH:TGC3",
        "MAP:5882 G 2",
        "UNIT:BO887, E825, RE840, SQ827, TK832");

    doTest("T2",
        "E820 ALS, Medic Local, 15903 BISHOPSTONE TER, PP, btwn GALESHEAD DR and END, TGA2, 2001, 5653 D 5, Police ProQA recommends dispatch at this time, Units:A843, E820, NMR",
        "SRC:E820",
        "CALL:ALS-Medic Local",
        "ADDR:15903 BISHOPSTONE TER",
        "X:GALESHEAD DR and END",
        "CH:TGA2",
        "MAP:5653 D 5",
        "UNIT:A843, E820, NMR");

    doTest("T3",
        "A820 ALS1, Medic Local, 9805 BROADMOOR TER, PP, btwn BROADMOOR LN and BROADMOOR CT, TGC2, 4505, 5768 C 10, Medical ProQA recommends dispatch at this time, Units:A820, MD845",
        "SRC:A820",
        "CALL:ALS1-Medic Local",
        "ADDR:9805 BROADMOOR TER",
        "X:BROADMOOR LN and BROADMOOR CT",
        "CH:TGC2",
        "MAP:5768 C 10",
        "UNIT:A820, MD845");

    doTest("T4",
        "A820 BLS, BLS Amb, 20 DIANE DR, TGA2, MAAA, ANNE ARUNDEL BOX 0904 A820 FOR SICK PERSON ON BRAVO W/ MEDIC 9, Unit:A820",
        "SRC:A820",
        "CALL:BLS-BLS Amb",
        "ADDR:20 DIANE DR",
        "CH:TGA2",
        "CITY:ANNE ARUNDEL COUNTY",
        "INFO:ANNE ARUNDEL BOX 0904 A820 FOR SICK PERSON ON BRAVO W/ MEDIC 9",
        "UNIT:A820");

    doTest("T5",
        "A820 BLS1, BLS Amb, 5302 WATER ST, PP, btwn MAIN ST and CHURCH ST, TGA2, 2009, 5652 K 10, Police ProQA recommends dispatch at this time, Unit:A820",
        "SRC:A820",
        "CALL:BLS1-BLS Amb",
        "ADDR:5302 WATER ST",
        "X:MAIN ST and CHURCH ST",
        "CH:TGA2",
        "MAP:5652 K 10",
        "UNIT:A820");

    doTest("T6",
        "E845 HOUSEG, House Gas Leak, 6512 HALLAM DR, PP, btwn HALLAM CT and MEADOW LARK AVE, TGC2, 2308, 5767 F 2, Fire ProQA recommends dispatch at this time, Units:BO883, E823, E845, SQ827, TK825",
        "SRC:E845",
        "CALL:HOUSEG-House Gas Leak",
        "ADDR:6512 HALLAM DR",
        "X:HALLAM CT and MEADOW LARK AVE",
        "CH:TGC2",
        "MAP:5767 F 2",
        "UNIT:BO883, E823, E845, SQ827, TK825");

    doTest("T7",
        "A843 ALS1, Medic Local, 4321 COLLINGTON RD #3, PP, btwn EVERGREEN PKY and TOWN CENTER BLVD, TGA2, 1608, 54  2/2 / 13 C 9, 3RD FLOOR, Units:A843, E816, NMR",
        "SRC:A843",
        "CALL:ALS1-Medic Local",
        "ADDR:4321 COLLINGTON RD",
        "APT:3",
        "X:EVERGREEN PKY and TOWN CENTER BLVD",
        "CH:TGA2",
        "MAP:54  2/2 / 13 C 9",
        "INFO:3RD FLOOR",
        "UNIT:A843, E816, NMR");

    doTest("T8",
        "A820 ALS1, Medic Local, 15201 JOPPA PL, PP, btwn JENNINGS MILL DR and END, TGA2, 4313, 5533 B 6, Medical ProQA recommends dispatch at this time, Units:A820, E843, MD818 Eff Body:roQA recommends dispatch at this time, Units:A820, E843, MD818",
        "SRC:A820",
        "CALL:ALS1-Medic Local",
        "ADDR:15201 JOPPA PL",
        "X:JENNINGS MILL DR and END",
        "CH:TGA2",
        "MAP:5533 B 6",
        "UNIT:A820, E843, A820, E843, MD818");

    doTest("T9",
        "BC 887 MOTOR, Motorcycle Accident, NB CAP BELT OL A HWY/NB BRANCH AVE, PP, at NB CAP BELT OL A HWY/NB BRANCH AVE, PP <0/0>, TGC2, 2941, 5650 C 9, MOTORCYLCE SLAMMED INTO THE BACK OF A CAR, Unit:BO887",
        "SRC:BC 887",
        "CALL:MOTOR-Motorcycle Accident",
        "ADDR:NB CAP BELT OL A HWY & NB BRANCH AVE",
        "MADDR:CAP BELT OL A HWY & BRANCH AVE",
        "X:NB CAP BELT OL A HWY/NB BRANCH AVE",
        "CH:TGC2",
        "MAP:5650 C 9",
        "INFO:MOTORCYLCE SLAMMED INTO THE BACK OF A CAR",
        "UNIT:BO887");

    doTest("T10",
        "E845 PIAH, PIA Limited Access, SB CRAIN HWY SW/FRANK TIPPETT RD, PP,  <11400/ 11200>, TGC2, 4015, 5883 H 3, TWO VEHICLE ACCIDENT INVOLVING A WHITE FORD F150 AND A WHITE VAN....POSSIBLE INJURIES....TRANSFERRED CALLER TO MSP, Units:E845, MD845, RE840",
        "SRC:E845",
        "CALL:PIAH-PIA Limited Access",
        "ADDR:SB CRAIN HWY SW & FRANK TIPPETT RD",
        "MADDR:CRAIN HWY SW & FRANK TIPPETT RD",
        "CH:TGC2",
        "MAP:5883 H 3",
        "INFO:TWO VEHICLE ACCIDENT INVOLVING A WHITE FORD F150 AND A WHITE VAN....POSSIBLE INJURIES....TRANSFERRED CALLER TO MSP",
        "UNIT:E845, MD845, RE840");

    doTest("T11",
        "E845 PIAH, PIA Limited Access, NB CRAIN HWY SE/TRUMPS HILL RD, PP,  <9200/ 9200>, TGC2, 4505, 5768 B 8, VEH INTO THE WOODS JUST PAST THE CROOM RD..S/B..NO 1034 ON VEH..ADV THERE ARE PEOPLE STANDING OUT SIDE OF TH",
        "SRC:E845",
        "CALL:PIAH-PIA Limited Access",
        "ADDR:NB CRAIN HWY SE & TRUMPS HILL RD",
        "MADDR:CRAIN HWY SE & TRUMPS HILL RD",
        "CH:TGC2",
        "MAP:5768 B 8",
        "INFO:VEH INTO THE WOODS JUST PAST THE CROOM RD..S/B..NO 1034 ON VEH..ADV THERE ARE PEOPLE STANDING OUT SIDE OF TH");
  }
  
  @Test
  public void testParser3() {

    doTest("T1",
        "SQ814 APTF, Apartment Fire, 1404 KANAWHA ST #302, PP, btwn 14TH AVE and 15TH AVE, TGA2, 3413, 5409 C 2, Fire ProQA recommends dispatch at this time, Units:BO884, E702, E712, E834, PE844, SQ814, TK801, TK812",
        "SRC:SQ814",
        "CALL:APTF-Apartment Fire",
        "ADDR:1404 KANAWHA ST",
        "APT:302",
        "X:14TH AVE and 15TH AVE",
        "CH:TGA2",
        "MAP:5409 C 2",
        "UNIT:BO884, E702, E712, E834, PE844, SQ814, TK801, TK812");

    doTest("T2",
        "SQ814 BUILDG, Building Gas Leak, 13922 BALTIMORE AVE, LP, btwn LAUREL LAKES CT and CYPRESS ST, TGA9, 1007, 5169 B 7, Fire ProQA recommends dispatch at this time, Units:BO886, E810, RE849, SQ814, TK831",
        "SRC:SQ814",
        "CALL:BUILDG-Building Gas Leak",
        "ADDR:13922 BALTIMORE AVE",
        "X:LAUREL LAKES CT and CYPRESS ST",
        "CH:TGA9",
        "MAP:5169 B 7",
        "UNIT:BO886, E810, RE849, SQ814, TK831");

    doTest("T3",
        "SQ814 HOUSEF, House Fire, 3400 PENNSYLVANIA ST, PP, btwn WELLS BLVD and ADELPHI RD, TGA2, 0117, 5409 G 4, Fire ProQA recommends dispatch at this time, Units:BO884, E807, E811, E834, PE844, SQ814, TK801, TK812",
        "SRC:SQ814",
        "CALL:HOUSEF-House Fire",
        "ADDR:3400 PENNSYLVANIA ST",
        "X:WELLS BLVD and ADELPHI RD",
        "CH:TGA2",
        "MAP:5409 G 4",
        "UNIT:BO884, E807, E811, E834, PE844, SQ814, TK801, TK812");
  }
  
  @Test
  public void testParser4() {

    doTest("T1",
        "Ambulance 820 ALS1, Medic Local, 17102 USHER PL, PP, btwn GOHAGEN RD and TERRYTOWN CT, TGC7, 2002, 5653 G 8, Medical ProQA recommends dispatch at this time, Units:A820, E820, NMR",
        "SRC:Ambulance 820",
        "CALL:ALS1-Medic Local",
        "ADDR:17102 USHER PL",
        "X:GOHAGEN RD and TERRYTOWN CT",
        "CH:TGC7",
        "MAP:5653 G 8",
        "UNIT:A820, E820, NMR");

    doTest("T2",
        "Medic 829 ALS1, Medic Local, 2411 KIRTLAND AVE, PP, btwn MARBURY DR and MASON ST, TGC7, 2622, 5650 K 3, Medical ProQA recommends dispatch at this time, Units:A826, MD829",
        "SRC:Medic 829",
        "CALL:ALS1-Medic Local",
        "ADDR:2411 KIRTLAND AVE",
        "X:MARBURY DR and MASON ST",
        "CH:TGC7",
        "MAP:5650 K 3",
        "UNIT:A826, MD829");

    doTest("T3",
        "Ambulance 812 PIAH, PIA Limited Access, SB CAP BELT IL A HWY/SB BALTIMORE AVE, PP, at SB CAP BELT IL A HWY/SB BALTIMORE AVE, PP <0/0>, TGA2, 4113, 5288 B 8, 3 VEHICLES ACCIDENT, UNK INJ...MSP CP ADV, Units:A812, E831",
        "SRC:Ambulance 812",
        "CALL:PIAH-PIA Limited Access",
        "ADDR:SB CAP BELT IL A HWY & SB BALTIMORE AVE",
        "MADDR:CAP BELT IL A HWY & BALTIMORE AVE",
        "X:SB CAP BELT IL A HWY/SB BALTIMORE AVE",
        "CH:TGA2",
        "MAP:5288 B 8",
        "INFO:3 VEHICLES ACCIDENT / UNK INJ...MSP CP ADV",
        "UNIT:A812, E831");

    doTest("T4",
        "Battalion Chief 886 HOUSEF, House Fire, 5031 HURON ST, PP, btwn 50TH PL and 51ST AVE, TA11, 1112, 5288 C 9, HOUSE ON FIRE, CAN SEE THE SMOKE COMING FROM THE HOME - COMPL LEFT THE PHONE BUT STILL HAVE AN O/L, Units:BO886, E811, E813, E831, E835, SQ814, TK812, TW807",
        "SRC:Battalion Chief 886",
        "CALL:HOUSEF-House Fire",
        "ADDR:5031 HURON ST",
        "X:50TH PL and 51ST AVE",
        "CH:TA11",
        "MAP:5288 C 9",
        "INFO:HOUSE ON FIRE / CAN SEE THE SMOKE COMING FROM THE HOME - COMPL LEFT THE PHONE BUT STILL HAVE AN O/L",
        "UNIT:BO886, E811, E813, E831, E835, SQ814, TK812, TW807");

    doTest("T5",
        "Ambulance 827 RAP, Rape, 4220 APPLE ORCHARD LN, PP, btwn APPLEGATE LN and APPLE ORCHARD CT, TGC2, 2917, 5650 A 8, Police ProQA recommends dispatch at this time, Units:A827, TK829",
        "SRC:Ambulance 827",
        "CALL:RAP-Rape",
        "ADDR:4220 APPLE ORCHARD LN",
        "X:APPLEGATE LN and APPLE ORCHARD CT",
        "CH:TGC2",
        "MAP:5650 A 8",
        "UNIT:A827, TK829");

    doTest("T6",
        "Paramedic Ambulance 838 ALS1, Medic Local, 1114 HILL RD, PP, btwn LOWLAND DR and HIGHLAND PARK DR, TGA2, 3812, 5530 H 6, Medical ProQA recommends dispatch at this time, Units:PA838, QT838",
        "SRC:Paramedic Ambulance 838",
        "CALL:ALS1-Medic Local",
        "ADDR:1114 HILL RD",
        "X:LOWLAND DR and HIGHLAND PARK DR",
        "CH:TGA2",
        "MAP:5530 H 6",
        "UNIT:PA838, QT838");

    doTest("T7",
        "Engine 820 ASPD, Assist Police, 4709 COLONEL ASHTON PL, PP, btwn END and COLONELS CHOICE RD, TG1, 2015, 5652 J 9, Police ProQA recommends dispatch at this time, Unit:E820",
        "SRC:Engine 820",
        "CALL:ASPD-Assist Police",
        "ADDR:4709 COLONEL ASHTON PL",
        "X:END and COLONELS CHOICE RD",
        "CH:TG1",
        "MAP:5652 J 9",
        "UNIT:E820");

    doTest("T8",
        "Ambulance 836 BLS0, BLS Amb, 15407 GIDEON GILPIN ST, PP, btwn COMMANDER HOWE TER and CAPTAIN ANDRE CT, TGC2, 4001, 5998 J 2, Medical ProQA recommends dispatch at this time, Unit:A836",
        "SRC:Ambulance 836",
        "CALL:BLS0-BLS Amb",
        "ADDR:15407 GIDEON GILPIN ST",
        "X:COMMANDER HOWE TER and CAPTAIN ANDRE CT",
        "CH:TGC2",
        "MAP:5998 J 2",
        "UNIT:A836");
  }
  
  @Test
  public void testParser5() {

    doTest("T1",
        "Engine 848 BUILDF, Building Fire, 7474 GREENWAY CENTER DR, GP, btwn MD TRADE CTR RD and MD TRADE CTR RD, TGA2, 3506, 5410 J 2, Fire ProQA recommends dispatch at this time, Units:BO886, E811, E812, E835, E848, RE818, TK812, TK814",
        "SRC:Engine 848",
        "CALL:BUILDF-Building Fire",
        "ADDR:7474 GREENWAY CENTER DR",
        "CH:TGA2",
        "MAP:5410 J 2",
        "UNIT:BO886, E811, E812, E835, E848, RE818, TK812, TK814");

    doTest("T2",
        "Tower 807 HOUSEF, House Fire, 1834 VILLAGE GREEN DR, PP, btwn SHERIFF RD and BARLOWE RD, TGA2, 3324, 5530 K 4, Fire ProQA recommends dispatch at this time, Units:BO881, E808, E833, E838, PE830, TK828, TK855, TW807",
        "SRC:Tower 807",
        "CALL:HOUSEF-House Fire",
        "ADDR:1834 VILLAGE GREEN DR",
        "X:SHERIFF RD and BARLOWE RD",
        "CH:TGA2",
        "MAP:5530 K 4",
        "UNIT:BO881, E808, E833, E838, PE830, TK828, TK855, TW807");

    doTest("T3",
        "Mini Pumper 828 BLS, BLS Amb, 9350-A WASHINGTON BLVD, PP, btwn CRESTVIEW DR and CARTER AVE, TGA2, 4802, 5411 E 6, INJ HER LEFT ANKLE // WOULD LIKE IT CHECKED OUT, Unit:MP828",
        "SRC:Mini Pumper 828",
        "CALL:BLS-BLS Amb",
        "ADDR:9350-A WASHINGTON BLVD",
        "MADDR:9350 WASHINGTON BLVD",
        "X:CRESTVIEW DR and CARTER AVE",
        "CH:TGA2",
        "MAP:5411 E 6",
        "INFO:INJ HER LEFT ANKLE // WOULD LIKE IT CHECKED OUT",
        "UNIT:MP828");
   
  }
  
  public static void main(String[] args) {
    new MDPrinceGeorgesCountyBParserTest().generateTests("T1");
  }
  
  
}