package net.anei.cadpage.parsers.KY;

import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;



public class KYGrantCountyParser extends DispatchB2Parser {
  
  public KYGrantCountyParser() {
    super("KSP DRY RIDGE E-911:", CITY_LIST, "GRANT COUNTY", "KY");
  }
  
  @Override
  public String getFilter() {
    return "KSPDRYRIDGEE-911@P06.gov";
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{
    "BOURBON",
    "BROOKSVILLE",
    "CAMPBELLSBURG",
    "CORINTH",
    "CRITTENDEN",
    "CYNTHIANA",
    "DRY RIDGE",
    "FALMOUTH",
    "FLORENCE",
    "HARRISON",
    "MILFORD",
    "MILLERSBURG",
    "PARIS",
    "PENDLETON",
    "ROBERTSON",
    "SADIEVILLE",
    "WILLIAMSTOWN"
  };


}
