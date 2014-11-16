package net.anei.cadpage.parsers.KY;

import net.anei.cadpage.parsers.dispatch.DispatchGeoconxParser;

/**
 * Marshall County, NC
 */
public class KYHancockCountyParser extends DispatchGeoconxParser {
  
  public KYHancockCountyParser() {
    super("HANCOCK COUNTY", "KY", GCX_FLG_EMPTY_SUBJECT_OK);
  }
}
