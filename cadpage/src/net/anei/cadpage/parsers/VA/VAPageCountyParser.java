package net.anei.cadpage.parsers.VA;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchDAPROParser;


/*
Page County, VA
Contact: Shane Taylor <hm88jr@gmail.com>
Sender: 93001045

MAILBOX:RS3 PAIN 16 E MAIN ST LUR CFS# 2011-000782 CROSS: BROAD ST/TANNERY RD

*/

public class VAPageCountyParser extends DispatchDAPROParser {
  
  
  private static final Properties CITY_CODE_TABLE = 
    buildCodeTable(new String[]{
      "LUR", "LURAY"
    });

  
  public VAPageCountyParser() {
    super(CITY_CODE_TABLE, "PAGE COUNTY", "VA");
  }
  
}