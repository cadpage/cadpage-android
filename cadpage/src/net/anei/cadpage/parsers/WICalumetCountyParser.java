package net.anei.cadpage.parsers;

import java.util.Properties;

import net.anei.cadpage.SmsMsgInfo.Data;

/*
Not currently enabled.  Need more info from user

Calumet County, WI
Contact: Brian Schwalbach <schwally77@gmail.com>
Sender: Admin.Foxcomm@co.calumet.wi.us <From%3AAdmin.Foxcomm@co.calumet.wi.us>
HAFR       PRI: 1 INC: FHA110114000008 TYP: RESCUE ADVANCED LIFE AD: N8016 PIGEON RD CTY: CMSV CN: BRUSE CMT1: 11 MONTH OLD INFANT WITH SOMETHING STUCK I
BUFD       PRI: 1 INC: FBU110115000010 TYP: ACCIDENT - C AD: CTY TK CE&OUTAGAMIE RD CTY: BUCT CN: KARNER,BEN CMT1: ***IF 2191 OR 2192 IS RESPONDING ALSO
HAFR       PRI: 1 INC: FHA110116000010 TYP: RESCUE ADVANCED LIFE AD: W5872 EASTER LILY DR CTY: CMTH CN: SWEERE, SHANNON CMT1: 13YOA FEMALE BAD
 */


public class WICalumetCountyParser extends DispatchPrintrakParser {
  
  private static final Properties CITY_TABLE = buildCodeTable(new String[]{
      "CMSV",
      "BUCT",
      "CMTH",
  });
  
  public WICalumetCountyParser() {
    super(CITY_TABLE, "CALUMET COUNTY", "WI");
  }
  
  @Override
  public String getFilter() {
    return "Admin.Foxcomm@co.calumet.wi.us";
  }
}
