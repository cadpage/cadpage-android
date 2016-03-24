package net.anei.cadpage.parsers.KY;

import net.anei.cadpage.parsers.dispatch.DispatchA65Parser;

public class KYPulaskiCountyParser extends DispatchA65Parser {
  
  public KYPulaskiCountyParser() {
    super(CITY_LIST, "PULASKI COUNTY", "KY");
  }
  
  private static final String[] CITY_LIST = new String[]{
    
      "BURNSIDE",
      "ETNA",
      "EUBANK",
      "FERGUSON",
      "INGLE",
      "NANCY",
      "OAK HILL",
      "SCIENCE HILL",
      "SHOPVILLE",
      "SOMERSET",
      "VALLEY OAK",
      "WOODSTOCK"

  };
}
