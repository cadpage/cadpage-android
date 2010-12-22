package net.anei.cadpage.parsers;

import net.anei.cadpage.SmsMsgInfo.Data;

/****
Rocky Point, NY
Contact: Jonathan broder <redorbj@gmail.com>
Sender: paging@alpinesoftware.com <From%3Apaging@alpinesoftware.com>

Falls, Not dangerous body area at 6 CROWN RD, ROCKY POINT  c/s: FISH RD . . 08:00:02
Automatic Alarm, Residential at 38 CHERYL DR, SHOREHAM  c/s: COBBLESTONE DR . . 08:23:03
Breathing Problems, Abnormal breathing at 151 BROADWAY, ROCKY POINT  c/s: CLUBHOUSE DR . . 12:42:23<br>
Breathing Problems, Difficulty Speaking Between Breaths at 6 CROWN RD, ROCKY POINT  c/s: FISH RD . . 16:09:05<br>
Cardiac or Respiratory Arrest, Not breathing at all at 258 GLEN DR, SHOREHAM  c/s: LEISURE DR . . 14:31:40<br>
****/

public class NYRockyPointParser extends SmartAddressParser {
  
  private static final String DEF_STATE = "NY";
  private static final String DEF_CITY = "ROCKY POINT";
  
  public NYRockyPointParser() {
    super(DEF_CITY, DEF_STATE);
  }
  
  @Override
  public String getFilter() {
    return "paging@alpinesoftware.com";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {

    Parser p = new Parser(body);
    
    // Drop call time at end of message
    if (p.getLastOptional(" . . ").length() == 0) return false;

    // get everything else
    data.strCross = p.getLastOptional(" c/s:");
    data.strCity = p.getLastOptional(',');
    data.strAddress = p.getLastOptional(" at ");
    data.strCall = p.get();
    
    return true;
  }
}
