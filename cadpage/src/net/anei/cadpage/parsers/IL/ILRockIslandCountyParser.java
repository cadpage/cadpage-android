package net.anei.cadpage.parsers.IL;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgParser;

/*
Rock Island County, IL
Contact: Darin Keith <darin.keith@hotmail.com>
Sender: 40404
System: Sunguard OSSI

@RIFD: 15221:;CRASH PERSONAL INJURIES;24TH ST/18TH AV
@RIFD: 15226:;FIRE OTHER;1323 14TH ST
@RIFD: 15227:;FIRE ALARM;3605 11TH AV

*/

public class ILRockIslandCountyParser extends MsgParser {
  
  private static final Pattern MASTER = 
      Pattern.compile("@([A-Z]+): (\\d+):;([^;]+?);([^;]+?)");
  
  public ILRockIslandCountyParser() {
    super("ROCK ISLAND COUNTY", "IL");
  }
  
  @Override
  public String getFilter() {
    return "40404";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    data.strSource = match.group(1);
    data.strCallId = match.group(2);
    data.strCall = match.group(3).trim();
    parseAddress(match.group(4).trim(), data);
    return true;
  }
  
}
