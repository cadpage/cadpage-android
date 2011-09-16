package net.anei.cadpage.parsers.SC;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchBParser;

/*
Florence County, SC
Contact: Anthony Fox <anthonyf@westflorencefd.com>

FLORENCE CO 911:21B2 >HEM/LACER-SERIOUS 2004 NEW HOPE DR XS: W MCARTHUR DR OFF MECHANICSVILLE RD FLORENCE BARR, ETHEL Map: Grids:0,0 Cad: 2011-0000105
FLORENCE CO 911:32D1 >UNK PROBLEM-LIFE STAT QUESTION W MARION ST XS: N ALEXANDER FLORENCE DAWN WITHERSPOON Cad: 2011-0000103800
FLORENCE CO 911:FIRE >FIRE CALL 1912 ENTERPRISE DR XS: W LUCAS ST FLORENCE SEC CENT 7186 Map: Grids:0,0 Cad: 2011-0000104914
FLORENCE CO 911:52C1G >HGH LIFE HZD ALRM GEN 3006 HOFFMEYER RD XS: WINDSOR FOREST DR FLORENCE SIMPLEX Map: Grids:0,0 Cad: 2011-0000104810
FLORENCE CO 911:32D1 >UNK PROBLEM-LIFE STAT QUESTION 2438 WILLWOOD DR Apt: A Bldg XS: BENTREE LN OFF W PALMETTO ST FLORENCE RAMANDA Cad: 2011-00001032

*/

public class SCFlorenceCountyParser extends DispatchBParser {
 
  public SCFlorenceCountyParser() {
    super(CITY_CODES, "FLORENCE COUNTY", "SC");
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return true;
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // See if this is one of our pages
    if (! body.startsWith("FLORENCE CO 911:")) return false;
    body = body.substring(16);
    int pt = body.indexOf('>');
    if (pt < 0) return false;
    data.strCode = body.substring(0,pt).trim();
    
    // Call superclass parser
    return super.parseMsg(body, data);
  }
  
  private static final String[] CITY_CODES = new String[]{
    "COWARD",
    "EFFINGHAM",
    "FLORENCE",
    "JOHNSONVILLE",
    "LAKE CITY",
    "MARS BLUFF",
    "OLANTA",
    "PAMPLICO",
    "QUINBY",
    "SCRANTON",
    "TIMMONSVILLE"
  };
}
