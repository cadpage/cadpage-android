package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.NJ.NJCENCOMParser;

/**
 * Pike County, PA
 */
public class PAPikeCountyParser extends NJCENCOMParser {
  
  public PAPikeCountyParser() {
    super("PIKE COUNTY", "PA");
  }
  
  @Override
  public String getLocName() {
    return "Pike County, PA";
  }
}
