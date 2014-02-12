package net.anei.cadpage.parsers.SC;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchPrintrakParser;

/**
 * Georgetown County, SC
 */
public class SCGeorgetownCountyParser extends DispatchPrintrakParser {
  
  public SCGeorgetownCountyParser() {
    super(CITY_CODES, "GEORGETOWN COUNTY", "SC");
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    return addr.replace("BY-PASS",  "BYPASS");
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "GC",          "GEORGETOWN COUNTY",
      "MI",          "MURRELS INLET"
  }); 
}
