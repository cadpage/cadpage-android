package net.anei.cadpage.parsers.WI;

import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchPrintrakParser;

/*
Calumet County, WI
Contact: Brian Schwalbach <schwally77@gmail.com>
Sender: Admin.Foxcomm@co.calumet.wi.us <From%3AAdmin.Foxcomm@co.calumet.wi.us>
HAFR       PRI: 1 INC: FHA110114000008 TYP: RESCUE ADVANCED LIFE AD: N8016 PIGEON RD CTY: CMSV CN: BRUSE CMT1: 11 MONTH OLD INFANT WITH SOMETHING STUCK I
BUFD       PRI: 1 INC: FBU110115000010 TYP: ACCIDENT - C AD: CTY TK CE&OUTAGAMIE RD CTY: BUCT CN: KARNER,BEN CMT1: ***IF 2191 OR 2192 IS RESPONDING ALSO
HAFR       PRI: 1 INC: FHA110116000010 TYP: RESCUE ADVANCED LIFE AD: W5872 EASTER LILY DR CTY: CMTH CN: SWEERE, SHANNON CMT1: 13YOA FEMALE BAD
HAFR       PRI: 1 INC: FHA110123000017 TYP: VEHICLE ACCIDENT AD: W7170 HWY 114 CTY: CMTH CN: VANDEHEY, FRANCIS CMT1: **POINT TO POINT TO OUSO TO DISPATCH
HAFR       PRI: 1 INC: FHA110123000016 TYP: RESCUE ADVANCED LIFE AD: N9664 EMERALD LN CTY: CMTH CN: HELLINGSON KATIE CMT1: 60YOA FEMALE DIFFICULTY BREATH
HAFR       PRI: 1 INC: FHA110125000019 TYP: RESCUE ADVANCED LIFE AD: N9085 N COOP RD CTY: CMTH LOC: WOODLAND SCHOOL CN: WOODLAND SCHOOL CMT1: Original Lo
HAFR       PRI: 1 INC: FHA110126000021 TYP: RESCUE ADVANCED LIFE AD: N9114 NOE RD CTY: CMTH CN: COLE, KATHY CMT1: HAND INJURY TIME: 19:22 GAGCA1 HAM321 X
HAFR       PRI: 1 INC: FHA110117000011 TYP: RESCUE ADVANCED LIFE AD: CTY TK KK&NOE RD CTY: CMTH CN: TAUS,ANNETTE CMT1: 44 YR OLD FEMALE WITH CHEST PAINS
HAFR       PRI: 1 INC: FHA110127000023 TYP: STRUCTURE FIRE AD: W2825 EMMONS CTY: BUCT CN: BUCHANAN FIRE CMT1: **POINT TO POINT TO OUSO TO DISPATCH BUCHAN
HAFR       PRI: 1 INC: FHA110130000024 TYP: RESCUE ADVANCED LIFE AD: W5095 GOLF COURSE RD CTY: CMSV LOC: HIGH CLIFF SUPPER CL CMT1: Original Location : H
HAFR       PRI: 1 INC: FHA110224000047 TYP: RESCUE ADVANCED LIFE AD: W6013 BLAZING STAR DR CTY: CMTH CN: WILLIAMS-SERVANT GRE CMT1: 35 FEMALE SUBJECT VAG

Brown County, WI
Contact: Jody Hakes <hakesproperties@sbcglobal.net>
Contact: Wesley Pompa <h2fd24@gmail.com>
Contact: Robert Linz <fm.bob22@gmail.com>
Sender: finstad_rr@co.brown.wi.us
HOFD PRI: 1 INC: FHO110429000014 TYP: VEGETATION FIRE AD: 7571 CTH D CTY: HOLL MAP: 9BD CN: ED CARROL CMT1: WITHIN 10 OF BUILDING, CHANGE TO STRUCTURE CMT2: C
HBFD PRI: 1 INC: FHB110509000117 TYP: FIRE ALARM AD: 710 BOW BELLS RD CTY: HOBA MAP: 10Y CN: CEC, 2964 CMT1: RESIDENTIAL FIRE ALARM...UNK WHERE COMING FROM... CMT2: ATTEMTING KEYHOLDERS.. TIME: 15:18 HBHBFD XST: 661 SILVER CREEK DR XS :30 T2: 3169 FERNDELL ACRES DR 675
HBFD PRI: 1 INC: FHB110407000084 TYP: EXTRICATION RESCUE AD: STH 29/32&SUNLITE DR CTY: HOBA MAP: 12Q CN: SPRINT CMT1: INCIDENT CLONED FROM PARENT: LBR110407013154 CMT2: Original Date/Time for Comment: 11/04/07 07:51 TIME: 08:16 HBHBFD <:1012
HBFD PRI: 1 INC: FHB110406000083 TYP: STRUCTURE FIRE AD: 4580 CHOCTAW TR CTY: HOBA MAP: 14R CN: CELLCOM CMT1: HEARD AND EXPLOSION AND NOW HOUSE IS ON FIRE - FULLY INVOLVED CMT2: Child Inc LHL110406001545 UPDATE PriUnt to HL/HL440 TIME <5= : 18:01 HBHBFD CRAM6021 HBHB1R XST: 4550 CROW CT XST2: 4599 CHOCTAW CT & NAVAJO T 349
HBFD PRI: 1 INC: FHB110407000084 TYP: EXTRICATION RESCUE AD: STH 29/32&SUNLITE DR CTY: HOBA MAP: 12Q CN: SPRINT CMT1: INCIDENT CLONED FROM PARENT: LBR110407013154 CMT2: Original Date/Time for Comment: 11/04/07 07:51 TIME: 08:16 HBHBFD <:1012
HBFD PRI: 1 INC: FHB110515000121 TYP: VEGETATION FIRE AD: FERNANDO DR&PACKERLAND DR CTY: ASHW MAP: 14AE CN: JODY CMT1: WITHIN 10 OF BUILDING, CHANGE TO STRUCTURE CMT2: INCIDENT CLONED FROM PARENT: FAF110515000686 TIME: 01:27 HBEN1711 :74 HBEN1712 21:

*/


public class WICalumetCountyParser extends DispatchPrintrakParser {
  
  private static final Properties CITY_TABLE = buildCodeTable(new String[]{
      // Brown County
      "ASHW", "ASHWAUBENON",
      "CGB",  "GREEN BAY",
      "TGB",  "GREEN BAY",
      "DENM", "DENMARK",
      "NEWD", "NEW DENMARK",
      "VWRI", "WRIGHTSTOWN",
      "TWRI", "WRIGHTSTOWN",
      "ROCK", "ROCKLAND",
      "DEPE", "DEPERE",
      "PULA", "PULASKI",
      "LEDG", "LEDGEVIEW",
      "HOWA", "HOWARD",
      "HOBA", "HOBART",
      "SCOT", "SCOTT",
      "EATO", "EATON",
      "PITT", "PITTSVILLE",
      "BELL", "BELLEVEUE",
      "HUMB", "HUMBOLDT",
      "ALLO", "ALLOUEZ",
      "SUAM", "SUAMICO",
      "LAWR", "LAWRENCE",
      "GLEN", "GLENMORE",
      "HOLL", "HOLLAND",
      "MORR", "MORRISON",
      
      // Calumet County
      "CMBT", "BROTHERTON",
      "CMCB", "BRILLION",
      "CMCC", "CHILTON",
      "CMCK", "KIEL",
      "CMCN", "NEW HOLSTEIN",
      "CMCT", "CHARLESTOWN",
      "CMTB", "BRILLION",
      "CMSV", "SHERWOOD",
      "CMTH", "HARRISON",
      "CMTN", "NEW HOLSTEIN",
      "CMTR", "RANTOUL",
      "CMTS", "STOCKBRIDGE",
      "CMTW", "WOODVILLE",
      "CMVH", "HILBERT",
      "CMVP", "POTTER",
      "CMVS", "STOCKBRIDGE",
      
      // Outagamie County
      "APPL", "APPLETON",
      "KAUC", "KAUKAUNA",
      "SEYC", "SEYMOUR",
      "NEWL", "NEW LONDON",
      "BLCT", "BLACK CREEK",
      "BUCT", "BUCHANAN",
      "CENT", "CENTER",
      "COLV", "COMBINED LOCKS",
      "DALT", "DALE",
      "DRCT", "DEER CREEK",
      "ELLT", "ELLINGTON",
      "FRET", "FREEDOM",
      "GRCT", "GRAND CHUTE",
      "GRVT", "GREENVILLE",
      "HORT", "HORTONVILLE",
      "HORV", "HORTONVILLE",
      "KAUT", "KAUKAUNA",
      "KIMV", "KIMBERLY",
      "LIBT", "LIBERTY",
      "LTCV", "LITTLE CHUTE", 
      "MPCT", "MAPLE CREEK",
      "ONET", "ONEIDA",
      "OSBT", "OSBORN",
      "SEYT", "SEYMOUR",
      "VANT", "VANDENBROEK",
      
      // Winnebago County
      "WALG", "ALOGMA",
      "WBLA", "BLACK WOLF",
      "WCLA", "CLAYTON",
      "WCME", "MENASHA",
      "WMEN", "MENASHA",
      "WNEE", "NEENAH",
      "WNEK", "NEKIMI",
      "WNEP", "NEPEUSKUN",
      "WOMR", "OMRO",
      "WOSH", "OSHKOSH",
      "WPOY", "POYGAN",
      "WRUS", "RUSHFORD",
      "WTME", "MENASHA",
      "WTNE", "NEENAH",
      "WTOM", "OMRO",
      "WTOS", "OSHKOSH",
      "WTWN", "WINNECONNE",
      "WUTI", "UTICA",
      "WVIN", "VINLAND",
      "WWCR", "WINCHESTER",
      "WWNE", "WINNECONNE",
      "WWOL", "WOLF RIVER"
  });
  
  private static final Pattern HOUSE_NBR_PTN = Pattern.compile("^([NWSE])(\\d+)\\b");
  
  public WICalumetCountyParser() {
    super(CITY_TABLE, "CALUMET COUNTY", "WI");
  }
  
  public WICalumetCountyParser(String county) {
    super(CITY_TABLE, county, "WI");
  }
  
  @Override
  public String getFilter() {
    return "Admin.Foxcomm@co.calumet.wi.us,finstad_rr@co.brown.wi.us";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    if (!super.parseMsg(body, data)) return false;
    
    // There are two address adjustments that need to be made.
    // First need to insert a space into a N3345 type address
    data.strAddress = HOUSE_NBR_PTN.matcher(data.strAddress).replaceFirst("$1 $2");
    
    // Next we have to replace "CTY TK" with "COUNTY RD"
    data.strAddress = data.strAddress.replaceFirst("CTY TK", "COUNTY RD");
    
    return true;
  }
}
