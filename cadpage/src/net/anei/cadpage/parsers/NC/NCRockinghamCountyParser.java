package net.anei.cadpage.parsers.NC;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/**
 * Buncombe county, NC
 */
public class NCRockinghamCountyParser extends DispatchOSSIParser {
  
  public NCRockinghamCountyParser() {
    super(CITY_CODES, "ROCKINGHAM COUNTY", "NC",
           "CALL ADDR X/Z+? CITY CODE? UNIT CH? INFO+");
  }
  
  @Override
  public String getFilter() {
    return "cad@co.rockingham.nc.us";
  }
  
  @Override
  protected Field getField(String name) {
    if (name.equals("CODE")) return new CodeField("\\d{1,2}[A-Z]\\d{1,2}");
    if (name.equals("CH")) return new ChannelField("TAC.*");
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "REID", "REIDSVILLE",
      "RUFF", "RUFFIN"
  });
}
