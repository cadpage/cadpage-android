package net.anei.cadpage.parsers.SC;

import net.anei.cadpage.parsers.dispatch.DispatchSPKParser;

public class SCPickensCountyParser extends DispatchSPKParser {
  public SCPickensCountyParser() {
    super("PICKENS COUNTY", "SC");
  }

  @Override
  public int getMapFlags() {
    return MAP_FLG_PREFER_GPS;
  }
}
