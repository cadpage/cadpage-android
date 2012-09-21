package net.anei.cadpage.parsers.OR;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchPrintrakParser;

/*
Lane County, OR
Contact: Robert Holmes <rlholmes54@gmail.com>,"Robert Holmes" <RHolmes@lrfr.org>
Sender: Motorola Premier CAD
Sender: ce911@ci.eugene.or.us

FRM:ce911@ci.eugene.or.us\nMSG:LRF TYP: VEHICLE VS PED ACC AD: TORRINGTON AVE&LYNNBROOK DR CTY: EUGENE MAP: EF557 C TIME: 08:12
FRM:ce911@ci.eugene.or.us\nMSG:LRF TYP: TRAUMA B AD: 92609 TERRITORIAL HWY CTY: UNC JUN MAP: LR05331 LOC: SCH TERRITORIAL ELEM TIME: 11:20
FRM:ce911@ci.eugene.or.us\nMSG:LDF TYP: MEDICAL EMERGENCY AD: N MODESTO DR&GIMPL HILL RD CTY: UNC EUG MAP: LF00013 TIME: 22:23
FRM:ce911@ci.eugene.or.us\nMSG:LRF TYP: STRUCTURE FIRE AD: 18152 HWY 36 CTY: UNC BLA MAP: LK00021 LOC: 18152 HWY 36 TIME: 09:30
FRM:ce911@ci.eugene.or.us\nMSG:LDF TYP: BLEEDING D AD: 88267 TERRITORIAL RD CTY: VENETA MAP: LF00008 LOC: DON JUAN RESTAURANT TIME: 18:03
FRM:ce911@ci.eugene.or.us\nMSG:LDF TYP: MVA AD: CANTRELL RD&CENTRAL RD CTY: UNC EUG MAP: LF00008 TIME: 15:41
FRM:ce911@ci.eugene.or.us\nMSG:LDF TYP: CHEST PAIN C AD: 29733 LUSK RD CTY: UNC EUG MAP: LF00015 TIME: 07:37
FRM:ce911@ci.eugene.or.us\nMSG:LDF TYP: VEHICLE VS PED ACC AD: HWY 126 MP29 CTY: UNC WAN MAP: LF00002 LOC: HWY 126 MP29 TIME: 20:08

 */


public class ORLaneCountyParser extends DispatchPrintrakParser {
  
  public ORLaneCountyParser() {
    super(CITY_CODES, "LANE COUNTY", "OR");
  }
  
  @Override
  public String getFilter() {
    return "ce911@ci.eugene.or.us";
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "UNC BLA", "BLACHLY",
      "UNC BLU", "BLUE RIVER",
      "UNC CHE", "CHESHIRE",
      "UNC COT", "COTTAGE GROVE",
      "UNC CRE", "CRESWELL",
      "UNC DEA", "DEADWOOD",
      "UNC DEX", "DEXTER",
      "UNC DOR", "DORENA",
      "UNC ELM", "ELMIRA",
      "UNC EUG", "EUGENE",
      "UNC FAL", "FALL CREEK",
      "UNC FLO", "FLORENCE",
      "UNC HAR", "HARRISBURG",
      "UNC JUN", "JUNCTION CITY",
      "UNC LEA", "LEABURG",
      "UNC LOR", "LORANE",
      "UNC LOW", "LOWELL",
      "UNC MAP", "MAPLETON",
      "UNC MAR", "MARCOLA",
      "UNC MON", "MONROE",
      "UNC NOT", "NOTI",
      "UNC OAK", "OAKRIDGE",
      "UNC PLE", "PLEASANT HILL",
      "UNC SPR", "SPRINGFIELD",
      "UNC SWI", "SWISSHOME",
      "UNC VEN", "VENETA",
      "UNC VID", "VIDA",
      "UNC WAN", "WALTON",
      "UNC WEF", "WESTFIR",
      "UNC WES", "WESTLAKE",
      "UNC YAC", "YACHATS"
  });
}
