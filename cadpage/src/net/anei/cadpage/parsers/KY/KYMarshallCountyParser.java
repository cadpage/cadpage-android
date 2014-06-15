package net.anei.cadpage.parsers.KY;

import net.anei.cadpage.parsers.dispatch.DispatchGeoconxParser;

/**
 * Marshall County, NC
 */
public class KYMarshallCountyParser extends DispatchGeoconxParser {
  
  public KYMarshallCountyParser() {
    super("MARSHALL COUNTY", "KY", GCX_FLG_EMPTY_SUBJECT_OK);
  }
  
  @Override
  public String getFilter() {
    return "911@mcfire.us,goneflyin07@yahoo.com,brian.andrus@hbfd.us,jasonacord@country-chevrolet.com,scottjones@country-chevrolet.com,jasonacord@country-chevrolet.com,jonathan.smith@hbfd.us";
  }
}
