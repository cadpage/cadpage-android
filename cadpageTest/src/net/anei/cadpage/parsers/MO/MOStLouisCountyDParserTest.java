package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
St Louis, MO
Contact: Active911
Agency name: Lemay FireProtection District
Location: St. Louis, MO, United States
Sender: dispatch@cce911.org

(Cad Page) Vehicle Fire AT Reavis Barracks Rd / Union Rd BUS:  XST:  SOUTH MAIN Lemay FPD [ 1614,16DN2
(Cad Page) 04 Assault *Not Secure* QD AT 316 W Felton Ave BUS:  XST: TELEGRAPH RD/CLYDE AVE SOUTH MAIN Lemay FPD [ 1617,16DN2,RCDN3
(Cad Page) 17 Fall QD AT 1307 Dammert Ave BUS:  XST: FORBES AVE/NAERT AVE SOUTH MAIN Lemay FPD [ 1617,16DN,RCDN3
(Cad Page) 17 Fall QD AT 9518 Longwood Ave BUS:  XST: GENTRY AVE/W HOLDEN AVE SOUTH MAIN Lemay FPD [ 1617,16DN2,RCDN4
(Cad Page) Fire Other AT 777 River City Casino Blvd BUS: RIVER CITY CASINO XST: RIVER CITY BLVD/RIVER CITY BLVD SOUTH MAIN Lemay FPD [ 1614,16DN2
(Cad Page) 01 Abdominal Pain QD AT 832 Virgo Ln BUS:  XST: HOFFMEISTER AVE/PAULE AVE SOUTH MAIN Lemay FPD [ 1617,16DN,RCDN4
(Cad Page) 25B6 Psych Case Unk Status AT 1211 Wachtel Ave BUS:  XST: DEGENHARDT AVE/JEFFORDS ST SOUTH MAIN Lemay FPD [ 16DN,1137,1602,16DN2
(Cad Page) 28 Stroke QD AT 4005 Ripa Ave BUS: ALEXIAN BROTHERS SHERBROOKE VILLAGE XST: Dead End/MEREDITH DR SOUTH MAIN Lemay FPD [ 16DN,1617,1614
(Cad Page) Stroke AT 4005 Ripa Ave BUS: ALEXIAN BROTHERS SHERBROOKE VILLAGE XST: Dead End/MEREDITH DR SOUTH MAIN Lemay FPD [ 1617,1614,16DN
(Cad Page) 26 Sick Case QD AT 4005 Ripa Ave BUS: ALEXIAN BROTHERS SHERBROOKE VILLAGE XST: Dead End/MEREDITH DR SOUTH MAIN Lemay FD [ 16DN2,1717,1602,16DN
(Cad Page) 28 Stroke QD AT 2254 Telegraph Rd BUS:  XST: WALWORTH DR/SOUTHAMPTON DR SOUTH MAIN Lemay FD [ 1617,1614,16DN
(Cad Page) 30 Accidental Injury QD AT 9626 Perrin Ave BUS:  XST: E HOLDEN AVE/E LORETTA AVE SOUTH MAIN Lemay FD [ 16DN2,1717,1614,16DN
(Cad Page) Carbon Monoxide Det AT 614 Military Rd BUS:  XST: BAYLESS AVE/HORN AVE SOUTH MAIN Lemay FD [ 1614,16DN
(Cad Page) 06 Breathing Problems QD AT 339 Placid Ave BUS:  XST: REMBOLD AVE/KIRCHNER AVE SOUTH MAIN Lemay FD [ 1617,1614,16DN2
(Cad Page) Psychiatric / OBS AT 829 Regina Ave BUS:  XST: HOFFMEISTER AVE/ORIENT AVE SOUTH MAIN Lemay FD [ 1617,16DN
(Cad Page) Alarm Commercial AT 422 W Ripa Ave BUS: ST MARKS SCHOOL XST: LARK AVE/TELEGRAPH RD SOUTH MAIN Lemay FD [ 1614,1710,1602
(Cad Page) 26 Sick Case QD AT 3614 Cleves Ave BUS:  XST: LEMAY FERRY RD/PARDELLA AVE SOUTH MAIN Lemay FD [ 16DN2,1717,1614,16DN
(Cad Page) 26 Sick Case QD AT 8629 S Grand Ave BUS:  XST: SHOSS AVE/LITTLE BROADWAY ST SOUTH MAIN Lemay FD [ 1617,16DN2
(Cad Page) 26C1 Sick Case Altered LOC AT 4100 - 4198 KETTLER RD BUS:  XST: Dead End/KETMORE DR SOUTH MAIN Lemay FD [ 1617
(Cad Page) 17 Fall QD AT 1674 Blue Ridge Dr BUS:  XST: KARLSRUHE PL/DUMONT PL SOUTH MAIN Lemay FD [ 1617,16DN2
(Cad Page) 10C1 Chest Pain Diff Breathing AT 1201 Telegraph Rd BUS: LEMAY HOUSE 1 XST: REGINA AVE/POINT DR SOUTH MAIN Lemay FD [ 1617,1617
(Cad Page) 10 Chest Pain QD AT 1201 Telegraph Rd BUS: LEMAY HOUSE 1 XST: REGINA AVE/POINT DR SOUTH MAIN Lemay FD [ 1617
(Cad Page) Miscellaneous Still AT 158 Kingston Dr BUS:  XST: WINDING AVE/CLYDE AVE SOUTH MAIN Lemay FD [ 1614,16DN
(Cad Page) 10 Chest Pain QD AT Bayless Ave / Lemay Ferry Rd BUS:  XST:  SOUTH MAIN Lemay FD [ 16DN2,1614,1137
(Cad Page) 10A1 Chest Pain AT Bayless Ave / Lemay Ferry Rd BUS:  XST:  SOUTH MAIN Lemay FD [ 16DN2,1614,1137
(Cad Page) Chest Pain AT Bayless Ave / Lemay Ferry Rd BUS:  XST:  SOUTH MAIN Lemay FD [ 16DN2,1614,1137
(Cad Page) 10 Chest Pain QD AT Bayless Ave / Lemay Ferry Rd BUS:  XST:  SOUTH MAIN Lemay FD [ 1137,1614,16DN2
(Cad Page) 02 Allergic Reaction QD AT 140 E Loretta Ave BUS:  XST: S BROADWAY ST/JOPLIN AVE SOUTH MAIN Lemay FD [ 1617,16DN
(Cad Page) 21 Hemorrhage QD AT 2637 Tuckahoe Dr BUS:  XST: ALBEMARLE CIR/POPLAR FOREST DR SOUTH MAIN Lemay FD [ 16DN2,1717,1614,16DN
(Cad Page) 26 Sick Case QD AT 810 Virgo Ln BUS:  XST: HOFFMEISTER AVE/PAULE AVE SOUTH MAIN Lemay FD [ 16DN2,1137,1602,16DN
(Cad Page) 31 Unconscious QD AT 9353 S Broadway St BUS: COMMUNITY CARE CENTER OF LEMAY XST: WEISS AVE/E HOFFMEISTER AVE SOUTH MAIN Lemay FD [ 1617,1614,16DN2
(Cad Page) 25 Psych/OBS *Violent* QD AT 829 Regina Ave BUS:  XST: HOFFMEISTER AVE/ORIENT AVE SOUTH MAIN Lemay FPD [ 1617,16DN2
(Cad Page) Psychiatric / OBS AT 328 Hoffmeister Ave BUS:  XST: MILITARY RD/DAMMERT AVE SOUTH MAIN Lemay FPD [ 1617,16DN2
(Cad Page) Carbon Monoxide Det AT 1805 Sybil Ct BUS:  XST: Dead End/PARK CREST DR SOUTH MAIN Lemay FPD [ 1614,16DN2
(Cad Page) Alarm Commercial AT 4220 Ripa Ave BUS: st marks school XST: Dead End/MEREDITH DR SOUTH MAIN Lemay FPD [ 1614,1134,1602
(Cad Page) Alarm Commercial AT 9353 S Broadway St BUS: COMMUNITY CARE CENTER OF LEMAY XST: WEISS AVE/E HOFFMEISTER AVE SOUTH MAIN Lemay FPD [ 1614,1710,1602
(Cad Page) 29 MVA Vehicle Rescue W/Fire AT 0 I 55 Nb BUS: 55 XST: RAMP I 55 NB TO BAYLESS AVE/BAYLESS AVE SOUTH MAIN Lemay FPD [ 1137,1614,1139,1114,1717,1602,
(Cad Page) 17 Fall QD AT 9455 Gentry Ave BUS:  XST: ORIENT AVE/VINCENT AVE SOUTH MAIN Lemay FPD [ 1617,16DN2
(Cad Page) 31 Unconscious QD AT 416 Earlsfield Ln BUS:  XST: PORCHESTER DR/Dead End SOUTH MAIN Lemay FPD [ 1617,1614,16DN2
(Cad Page) 25 Psych/OBS *Not Secure* QD AT 198 Viehl Ave BUS:  XST: S BROADWAY ST/LUNA AVE SOUTH MAIN Lemay FPD [ 1617,16DN2
(Cad Page) 06D2 Difficulty Breathing AT 4005 Ripa Ave BUS: ALEXIAN BROTHERS SHERBROOKE VILLAGE XST: Dead End/MEREDITH DR SOUTH MAIN Lemay FPD [ 1617,16DN2,16DN2,1614,RCDN6
(Cad Page) 06 Breathing Problems QD AT 4005 Ripa Ave BUS: ALEXIAN BROTHERS SHERBROOKE VILLAGE XST: Dead End/MEREDITH DR SOUTH MAIN Lemay FPD [ 1617,1614,16DN2
(Cad Page) 04 Assault *Not Secure* QD AT 9612 S Broadway St BUS:  XST: E VELMA AVE/W HOLDEN AVE SOUTH MAIN Lemay FPD [ 1617,16DN2
(Cad Page) 21 Hemorrhage QD AT 725 Reed Ave BUS:  XST: BAYLESS AVE/WEISS AVE SOUTH MAIN Lemay FPD [ 1617,16DN2
(Cad Page) 25 Suicide Attempt QD AT 100 Kingston Dr BUS:  XST: S BROADWAY ST/WINDING AVE SOUTH MAIN Lemay FPD [ 1617,16DN2
(Cad Page) Miscellaneous Still AT 1500 Telegraph Rd BUS:  XST: DAMMERT AVE/ALLEGHANY DR SOUTH MAIN Lemay FPD [ 1710,16DN2
(Cad Page) Fire Mulch AT Kingston Dr / S Broadway St BUS:  XST:  SOUTH MAIN Lemay FPD [ 1614,16DN2
(Cad Page) Smoke In The Area AT 300 Bayless Ave BUS:  XST: MILITARY RD/Dead End SOUTH MAIN Lemay FPD [ 16DN2,1614
(Cad Page) Miscellaneous Still AT 300 Bayless Ave BUS:  XST: MILITARY RD/Dead End SOUTH MAIN Lemay FPD [ 1614,16DN2
(Cad Page) 17 Lift Assist QD AT 236 Carrington Ln BUS:  XST: KINGSTON DR/BROOK AVE SOUTH MAIN Lemay FPD [ 1614,16DN2
(Cad Page) 26 Sick Case QD AT 624 Guernsey Cir BUS:  XST: Dead End/CAMBORNE DR SOUTH MAIN Lemay FPD [ 1617,16DN2
(Cad Page) 25 Psych/OBS *Not Secure* QD AT S Broadway St / Kingston Dr BUS:  XST:  SOUTH MAIN Lemay FPD [ 1617,16DN2
(Cad Page) 25 Suicide Attempt QD AT S Broadway St / Kingston Dr BUS:  XST:  SOUTH MAIN Lemay FPD [ 1617,16DN2
(Cad Page) 25 Psych/OBS *Not Secure* QD AT S Broadway St / Kingston Dr BUS:  XST:  SOUTH MAIN Lemay FPD [ 1617,16DN2
(Cad Page) 26 Sick Case QD AT 124 Vincent Ave BUS:  XST: S BROADWAY ST/GENTRY AVE SOUTH MAIN Lemay FPD [ 1617,16DN2
(Cad Page) 26 Sick Case QD AT 9500 S Broadway St BUS:  XST: W CARTWRIGHT AVE/E CARTWRIGHT AVE SOUTH MAIN Lemay FPD [ 1617,16DN
(Cad Page) 19C4 Heart Problem Cardiac Hx AT 108 W Loretta Ave BUS:  XST: CLYDE AVE/S BROADWAY ST SOUTH MAIN Lemay FPD [ 1617,1617,1614,16DN2,16DN2,RCD
(Cad Page) 10 Chest Pain QD AT 108 W Loretta Ave BUS:  XST: CLYDE AVE/S BROADWAY ST SOUTH MAIN Lemay FPD [ 1617,1614,16DN2
(Cad Page) 26 Sick Case QD AT 529 Linda Ln BUS:  XST: TELEGRAPH RD/KASKE DR SOUTH MAIN Lemay FPD [ 1617,16DN2
(Cad Page) 10 Chest Pain QD AT 4109 Diebold Ct BUS:  XST: MARCHI DR/Dead End SOUTH MAIN Lemay FPD [ 1617,1614,16DN
(Cad Page) 13 Diabetic Problems QD AT I 55 SB / MM201 BUS:  XST:  SOUTH MAIN Lemay FPD [ 1617,1614,1114,1602,16DN
(Cad Page) 05 Back Pain QD AT 1762 Lemay Ferry Rd BUS: AHEPA 53 APARTMENTS PHASE 3 XST: PARK CREST DR/DUMONT PL SOUTH MAIN Lemay FPD [ 1617,16DN2
(Cad Page) 11 Choking QD AT 4256 Lasata Dr BUS:  XST: UNION RD/Dead End SOUTH MAIN Lemay FPD [ 1617,1614,16DN
(Cad Page) 26 Sick Case QD AT 4261 Burnett Walk BUS: REDO ADDRESSING XST: UNION RD/Dead End SOUTH MAIN Lemay FPD [ 1617,16DN2
(Cad Page) 10 Chest Pain QD AT 273 Pardella Ave BUS:  XST: LITTLE BROADWAY ST/FANNIE AVE SOUTH MAIN Lemay FPD [ 16DN2,1614,1137
(Cad Page) 06 Breathing Problems QD AT 273 Pardella Ave BUS:  XST: LITTLE BROADWAY ST/FANNIE AVE SOUTH MAIN Lemay FPD [ 1137,1614,16DN2
(Cad Page) 06 Breathing Problems QD AT 2520 TELEGRAPH RD BUS:  XST: BEATRICE AVE/REAVIS BARRACKS RD SOUTH MAIN Lemay FPD [ 1617,1614,16DN2
(Cad Page) 04 Assault *Scene Secure* QD AT 1201 Telegraph Rd BUS: LEMAY HOUSE 1 XST: REGINA AVE/POINT DR SOUTH MAIN Lemay FPD [ 1617
(Cad Page) 06 Breathing Problems QD AT 333 Forbes Ave BUS:  XST: GENTRY AVE/DAMMERT AVE SOUTH MAIN Lemay FPD [ 1617,1614,16DN2
(Cad Page) 26 Sick Case QD AT 780 Pardella Ave BUS:  XST: WEISS AVE/HOFFMEISTER AVE SOUTH MAIN Lemay FPD
(Cad Page) 19 Heart Problems QD AT 950 Dammert Ave BUS:  XST: PLACID AVE/PAULE AVE SOUTH MAIN Lemay FPD
(Cad Page) 21 Hemorrhage QD AT 8428 Tennessee Ave BUS:  XST: MIDWAY AVE/RIVER CITY BLVD SOUTH MAIN Lemay FPD
(Cad Page) 04 Assault *Scene Secure* QD AT S Grand Ave / Fannie Ave BUS:  XST:  SOUTH MAIN Lemay FPD
(Cad Page) 04 Assault *Not Secure* QD AT S Grand Ave / Fannie Ave BUS:  XST:  SOUTH MAIN Lemay FPD
(Cad Page) 17 Fall QD AT 711 Orient Ave BUS:  XST: ERSKINE AVE/REGINA AVE SOUTH MAIN Lemay FPD
(Cad Page) 32 Unknown EMS Problem QD AT 9305 S Broadway St BUS: AMERICAN LEGION XST: WEISS AVE/E HOFFMEISTER AVE SOUTH MAIN Lemay FPD

*/

public class MOStLouisCountyDParserTest extends BaseParserTest {
  
  public MOStLouisCountyDParserTest() {
    setParser(new DummyParser(), "ST LOUIS COUNTY", "MO");
  }
  
  @Test
  public void testParser() {

    
  }
  
  public static void main(String[] args) {
    new MOStLouisCountyDParserTest().generateTests("T1");
  }
}
