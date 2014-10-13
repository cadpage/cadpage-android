package net.anei.cadpage.parsers.WV;

import net.anei.cadpage.parsers.dispatch.DispatchSPKParser;

public class WVHardyCountyCParser extends DispatchSPKParser {
  public WVHardyCountyCParser() {
    super(WVHardyCountyParser.CITY_LIST, "HARDY COUNTY", "WV");
  }

  @Override
  public String getFilter() {
    return "hardyeoc@hardynet.com";
  }
}
