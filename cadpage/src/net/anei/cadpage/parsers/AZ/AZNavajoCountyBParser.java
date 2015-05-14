package net.anei.cadpage.parsers.AZ;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchA20Parser;

/**
 * Navajo County (B), AZ
 */
public class AZNavajoCountyBParser extends DispatchA20Parser {
  
  public AZNavajoCountyBParser() {
    super(CALL_CODES, "NAVAJO COUNTY", "AZ");
  }
  
  @Override
  public String getFilter() {
    return "@cityofhanfordca.com";
  }
  
  private static final Properties CALL_CODES = buildCodeTable(new String[]{
  });
}
