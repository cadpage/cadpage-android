package net.anei.cadpage.parsers.TN;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchA66Parser;

public class TNBlountCountyBParser extends DispatchA66Parser {
  
  public TNBlountCountyBParser() {
    super(CITY_CODES, "BLOUNT COUNTY", "TN");
  }
  
  @Override
  public String getFilter() {
    return "@c-msg.org";
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "WAL", "WALLAND",
      "TOW", "TOWNSEND",
      "TAL", "TALLASSEE",
      "MA1", "MARYVILLE",
      "MA2", "MARYVILLE",
      "MA3", "MARYVILLE",
      "MA3", "MARYVILLE",
      "MA5", "MARYVILLE",
      "ROC", "ROCKFORD",
      "SEY", "SEYMOUR",
      "LOU", "LOUISVILLE",
      "LEN", "LENOIR CITY",
      "ALC", "ALCOA",
      "FRI", "FRIENDSVILLE",
      "GR1", "GREENBACK",
      "GRE", "GREENBACK",
      "KN1", "KNOXVILLE",
      "KN2", "KNOXVILLE",
      "KN3", "KNOXVILLE"
  });
}
