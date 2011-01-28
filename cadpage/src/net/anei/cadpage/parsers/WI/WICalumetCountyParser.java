package net.anei.cadpage.parsers.WI;

import java.util.Properties;

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

Town of Brotherton.    CMBT
City of Brillion.              CMCB
City of Chilton.              CMCC
City of Kiel.                    CMCK
City of New Holstein    CMCN
Town of Charlestown.    CMCT
Village of Sherwood.    CMSV
Town of Brillion.           CMTB
Town of Chilton.            CMTC
Town of Harrison.         CMTH
Town of New Holstein.  CMTN
Town of Rantoul.           CMTR
Town of Stockbridge.    CMTS
Town of Woodville.        CMTW
Village of Hilbert.           CMVH
Village of Potter.             CMVP
Village of Stockbridge.    CMVS
 */


public class WICalumetCountyParser extends DispatchPrintrakParser {
  
  private static final Properties CITY_TABLE = buildCodeTable(new String[]{
      // Brown County
      "ASHW", "ASHWAUBENON",
      "CGB",  "GREEN BAY",
      "TGB",  "TOWN OF GREEN BAY",
      "DENM", "DENMARK",
      "NEWD", "NEW DENMARK",
      "VWRI", "WRIGHTSTOWN VILLAGE",
      "TWRI", "WRIGHTSTOWN TOWN",
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
      "CMSV", "SHERWOOD",
      "CMTH", "HARRISON",
      "CMTN", "NEW HOLSTEIN",
      "CMTR", "RANTOUL",
      "CMTS", "STOCKBRIDGE",
      "CMTW", "WOODVILLE",
      "CMVH", "HILBERT",
      "CMVP", "POTTER",
      "CMVS", "STOCKBRIDGE",
      
      // Outagamie Countie
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
      "GRCT", "GRAND CHUTE"
  });
  
  public WICalumetCountyParser() {
    super(CITY_TABLE, "CALUMET", "WI");
  }
  
  @Override
  public String getFilter() {
    return "Admin.Foxcomm@co.calumet.wi.us";
  }
}
