package net.anei.cadpage.parsers.OH;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchA5Parser;

/**
 * Clark County, OH
 */
public class OHClarkCountyParser extends DispatchA5Parser {
  
  public OHClarkCountyParser() {
    super(CITY_CODES, "CLARK COUNTY", "OH");
  }
  
  @Override
  public String getFilter() {
    return "E911-122@CI.SPRINGFIELD.OH.US";
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "N CARLISLE",     "NEW CARLISLE"
  });
}