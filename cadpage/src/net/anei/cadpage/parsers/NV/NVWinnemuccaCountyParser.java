package net.anei.cadpage.parsers.NV;

import net.anei.cadpage.parsers.dispatch.DispatchA20Parser;

/**
 * Winnemucca County, NV
 */
public class NVWinnemuccaCountyParser extends DispatchA20Parser {
  
  public NVWinnemuccaCountyParser() {
    super("WINNEMUCCA COUNTY", "NV");
  }
  
  @Override
  public String getFilter() {
    return "hcsodispatch@hcsonv.com";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }
}
