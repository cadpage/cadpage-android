package net.anei.cadpage.parsers.MI;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/**
 * Eaton County, MI
 */
public class MIIsabellaCountyParser extends DispatchOSSIParser {
  
  public MIIsabellaCountyParser() {
    super(CITY_CODES, "ISABELLA COUNTY", "MI",
           "( CANCEL | FYI CALL ) ADDR! CITY X/+? INFO+");
  }
  
  @Override
  public String getFilter() {
    return "cad@isabellacounty.org";
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CANCEL")) return new CallField("CANCEL", true);
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "ALMA",  "ALMA",
      "RMS",   "REMUS",
      "BLA",   "BLANCHARD",
      "MP",    "MT PLEASANT",
      "RSB",   "ROSEBUSH",
      "CLR",   "CLARE",
      "SHP",   "SHEPHERD",
      "BEAV",  "BEVERTON",
      "BRY",   "BARRYTON",
      "CLM",   "COLEMAN",
      "EDM",   "EDMORE",
      "FRW",   "FARWELL",
      "LKE",   "LAKE",
      "LKI",   "LAKE ISABELLA",
      "LVW",   "LAKEVIEW",
      "RVD",   "RIVERDALE",
      "STL",   "ST LOUIS",
      "VEST",  "VESTABURG",
      "WDM",   "WEIDMAN",
      "WNN",   "WINN",
      "LMS",   "LOOMIS"
  });
}
