package net.anei.cadpage.parsers.WI;

import java.util.Properties;
import net.anei.cadpage.parsers.dispatch.DispatchProphoenixParser;

public class WIRacineCountyParser extends DispatchProphoenixParser {
  
  public WIRacineCountyParser() {
    super(CITY_CODES,"RACINE COUNTY", "WI");
  }
  
  @Override
  public String getFilter() {
    return "PhoenixAlert@goracine.org";
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "CA", "CALEDONIA",
      "MP", "MOUNT PLEASENT",
      "RA", "RACINE",
      "SO", "BURLINGTON",
      "SV", "STURTEVANT",
      "TW", "WATERFORD",
      "VW", "WATERFORD"
  });
}
