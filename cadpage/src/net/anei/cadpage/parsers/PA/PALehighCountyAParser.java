package net.anei.cadpage.parsers.PA;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchPrintrakParser;

/**
 * Lehigh County PA
 */
public class PALehighCountyAParser extends DispatchPrintrakParser {
  
  private static final Properties CITY_TABLE = buildCodeTable(new String[]{
      "06 LONGSWAMP", "LONGSWAMP TWP",
      "HANOVER", "HANOVER TWP",
      "HEIDELBERG","HEIDELBERG TWP",
      "LOWER MACUNGIE", "LOWER MACUNGIE TWP",
      "LOWER MILFORD", "LOWER MILFORD TWP",
      "LOWHILL", "LOWHILL TWP",
      "LYNN","LYNN TOWNSHIP",
      "NORTH WHITEHALL", "NORTH WHITEHALL TWP",
      "SALISBURY", "SALISBURY TWP",
      "SOUTH WHITEHALL", "SOUTH WHITEHALL TWP",
      "UPPER MACUNGIE", "UPPER MACUNGIE TWP",
      "UPPER MILFORD", "UPPER MILFORD TWP",
      "UPPER SAUCON", "UPPER SAUCON TWP",
      "WASHINGTON", "WASHINGTON TWP",
      "WEISENBERG", "WEISENBERG TWP",
      "WHITEHALL", "WHITEHALL TWP"
  });
  
  public PALehighCountyAParser() {
    super(CITY_TABLE, "LEHIGH COUNTY", "PA", "UNTS:UNIT", FLG_USE_CMT1_CALL);
  }
  
  @Override
  public String getFilter() {
    return "911@lehighcounty.org,messaging@iamresponding.com";
  }
}
