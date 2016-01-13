package net.anei.cadpage.parsers.ZCANS;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

public class ZCANSAnnapolisCountyParser extends SmartAddressParser {
  
  public ZCANSAnnapolisCountyParser() {
    this("ANNAPOLIS COUNTY");
  }
  
  protected ZCANSAnnapolisCountyParser(String defCity) {
    super(CITY_LIST, defCity, "NS");
    setFieldList("ADDR APT CITY CALL");
  }
  
  @Override
  public String getAliasCode() {
    return "ZCANSAnnapolisCounty";
  }
  
  @Override
  public String getFilter() {
    return "valleycommunications@ns.aliantzinc.ca";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    // See if there is a trailing call description
    boolean good = false;
    int pt = body.indexOf(" * ");
    if (pt >= 0) {
      good = true;
      data.strCall = body.substring(pt+3).trim();
      body = body.substring(0,pt).trim();
    }
    
    // See if address ends with an identifiable city
    pt = body.lastIndexOf(',');
    if (pt >= 0) {
      String city = body.substring(pt+1).trim();
      if (isCity(city)) {
        good = true;
        data.strCity = city;
        body = body.substring(0,pt).trim();
      }
    }
    
    // OK, now lets do the address
    StartType st = data.strCall.length() > 0 ? StartType.START_ADDR : StartType.START_CALL;
    int flags = FLAG_ANCHOR_END;
    if (data.strCity.length() > 0) flags |= FLAG_NO_CITY;
    parseAddress(st, flags, body, data);
    return good || isValidAddress();
  }

  private static final String[] CITY_LIST = new String[]{
    
    // Annapolis County **********************
    
    // Towns
    "ANNAPOLIS ROYAL",
    "MIDDLETON",

    // Villages,
    "LAWRENCETOWN",
    "WILMOT",

    // Native Reserves,
    "BEAR RIVER 6",
    "BEAR RIVER 6B",
    
    // Colchester County ********************

    // Towns
    "STEWIACKE",
    "TRURO",

    // Villages
    "BIBLE HILL",
    "HARMONY",
    "TATAMAGOUCHE",

    // First Nations reserves
    "MILLBROOK 27",
    
    // Hants County *************************
    
    // Towns

    "HANTSPORT",
    "WINDSOR",

    // District municipalities

    "EAST HANTS",
    "WEST HANTS",

    // Native reserves
    "INDIAN BROOK 14",
    
    // Kings County ************************
    
    // Towns
    "BERWICK",
    "KENTVILLE",
    "WOLFVILLE",

    // Villages
    "AYLESFORD",
    "CANNING",
    "CORNWALLIS SQUARE",
    "GREENWOOD",
    "KINGSTON",
    "NEW MINAS",
    "PORT WILLIAMS",

    // Native reserves
    "CAMBRIDGE",
    "GLOOSCAP"

  };
}
