package net.anei.cadpage.parsers;

/*
Greene County NY (or Athens FD)
Contact: 8456569957@mms.att.net
Sender: 200-200-000
GREENE 911:WIRES >WIRES DOWN / ARCING 117 RIVER RD ATHENS BRAUMULLER, HELENE Map: Grids:0,0 Cad: 2010-0000033052
GREENE 911:ALARMF>FIRE ALARM 558 SLEEPY HOLLOW RD ATHENS ADT SECURITY-OP ANDREA- Map:62 Grids:0,0 Cad: 2010-0000033344
*/

public class NYGreeneCountyParser extends DispatchBParser {
  
  private static final String[] CITY_CODES = new String[]{"ATHENS"};
  
  private static final String DEF_STATE = "NY";
  private static final String DEF_CITY = "GREENE COUNTY";
 
  public NYGreeneCountyParser() {
    super(CITY_CODES, DEF_CITY, DEF_STATE);
  }
  
  @Override
  public String getFilter() {
    return "200-200-000";
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return body.startsWith("GREENE 911:");
  }
}
