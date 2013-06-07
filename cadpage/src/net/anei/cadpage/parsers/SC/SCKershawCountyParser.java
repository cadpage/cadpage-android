package net.anei.cadpage.parsers.SC;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.dispatch.DispatchB3Parser;

/**
 * Kershire County, SC
 */
public class SCKershawCountyParser extends DispatchB3Parser {

  public SCKershawCountyParser() {
    super("KERSHAWCOUNTY911:", CITY_LIST, "KERSHAW COUNTY", "SC");
    setupCallList((CodeSet)null);
  }
  
  @Override
  public String getFilter() {
    return "kershawcounty911@kershaw.sc.gov";
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{
    "ANTIOCH",
    "BETHUNE",
    "BOYKIN",
    "CAMDEN",
    "CASSATT",
    "ELGIN",
    "LIBERTY HILL",
    "LUGOFF",
    "WESTVILLE"
  };
}
