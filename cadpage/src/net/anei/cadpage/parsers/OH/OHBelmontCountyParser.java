package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.dispatch.DispatchA40Parser;

public class OHBelmontCountyParser extends DispatchA40Parser {

  public OHBelmontCountyParser() {
    super(CITY_LIST, "BELMONT COUNTY", "OH");
  }

  
  private static final String[] CITY_LIST = new String[] { 

    "ST. CLAIRSVILLE",
    "BARNESVILLE",
    "BELLAIRE",
    "BELMONT",
    "BETHESDA",
    "BRIDGEPORT",
    "BROOKSIDE",
    "COLERAIN",
    "FAIRVIEW",
    "FLUSHING",
    "GOSHEN",
    "HOLLOWAY",
    "KIRKWOOD",
    "MARTINS FERRY",
    "MEAD",
    "MORRISTOWN",
    "PEASE",
    "POWHATAN POINT",
    "PULTNEY",
    "RICHLAND",
    "SHADYSIDE",
    "SMITH",
    "SOMERSET",
    "ST. CLAIRSVILLE",
    "UNION",
    "WARREN",
    "WASHINGTON",
    "WAYNE",
    "WHEELING",
    "WILSON",
    "YORK",
    "YORKVILLE"
  };
}