package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA14Parser;


public class NYSuffolkCountyBParser extends DispatchA14Parser {
  
  public NYSuffolkCountyBParser() {
    super(CITY_LIST, "SUFFOLK COUNTY", "NY");
    setupMultiWordStreets("INDIAN HEAD");
  }
  
  @Override
  public String getFilter() {
    return "@firerescuesystems.xohost.com,scmproducts@optonline.net,paging@bcfa.xohost.com,alarms@ronkonkomafd.net";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    if (!super.parseMsg(body, data)) return false;
    if (data.strPlace.endsWith("*")) data.strPlace = data.strPlace.substring(0, data.strPlace.length()-1).trim();
    if (data.strAddress.length() == 0) {
      data.strAddress = data.strPlace;
      data.strPlace = "";
    }
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{
    "BELLE TERRE", 
    "COMMACK",
    "CORAM",
    "E NORTHPORT",
    "MOUNT SINAI", 
    "MILLER PLACE",
    "PORT JEFFERSON",
    "SMITHTOWN",
    "STONY BROOK" 
  };
}
