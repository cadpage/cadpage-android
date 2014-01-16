package net.anei.cadpage.parsers.OH;

import java.util.Properties;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Cuyahoga County, OH
 */
public class OHCuyahogaCountyAParser extends FieldProgramParser{

  public OHCuyahogaCountyAParser() {
    super(CITY_CODES, "CUYAHOGA COUNTY", "OH",
        "CALL ADDR/S5XXa! INFO+");
  }

  @Override
  public String getFilter() {
    return "dispatch@chagrinfallspd.com";
  }

  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Dispatch Message")) return false;
    return parseFields(body.split("\n"), 2, data);

  }
  private static final Properties CITY_CODES = buildCodeTable(new String[]{

      //Cities
      "BAY VILLAGE",   "BAY VILLAGE",
      "BEACHWOOD",     "BEACHWOOD",
      "BEDFORD",       "BEDFORD",
      "BEDFORD HEIG",  "BEDFORD HEIGHTS",
      "BEREA",         "BEREA",
      "BRECKSVILLE",   "BRECKSVILLE",
      "BROADVIEW HE",  "BROADVIEW HEIGHTS",
      "BROOK PARK",    "BROOK PARK",
      "BROOKLYN",      "BROOKLYN",
      "CLEVELAND",     "CLEVELAND",
      "CLEVELAND HE",  "CLEVELAND HEIGHTS",
      "E CLEVELAND",   "E CLEVELAND",
      "EUCLID",        "EUCLID",
      "FAIRVIEW PAR",  "FAIRVIEW PARK",
      "GARFIELD HEI",  "GARFIELD HEIGHTS",
      "HIGHLAND HEI",  "HIGHLAND HEIGHTS",
      "INDEPENDENCE",  "INDEPENDENCE",
      "LAKEWOOD",      "LAKEWOOD",
      "LYNDHURST",     "LYNDHURST",
      "MAPLE HEIGHT",  "MAPLE HEIGHTS",
      "MAYFIELD HEI",  "MAYFIELD HEIGHTS",
      "MIDDLEBURG H",  "MIDDLEBURG HEIGHTS",
      "N OLMSTED",     "N OLMSTED",
      "N ROYALTON",    "N ROYALTON",
      "OLMSTED FALL",  "OLMSTED FALLS",
      "PARMA",         "PARMA",
      "PARMA HEIGHT",  "PARMA HEIGHTS",
      "PEPPER PIKE",   "PEPPER PIKE",
      "RICHMOND HEI",  "RICHMOND HEIGHTS",
      "ROCKY RIVER",   "ROCKY RIVER",
      "SEVEN HILLS",   "SEVEN HILLS",
      "SHAKER HEIGH",  "SHAKER HEIGHTS",
      "SOLON",         "SOLON",
      "S EUCLID",      "S EUCLID",
      "S RUSSELL",      "S RUSSELL",
      "STRONGSVILLE",  "STRONGSVILLE",
      "UNIVERSITY H",  "UNIVERSITY HEIGHTS",
      "WARRENSVILLE",  "WARRENSVILLE HEIGHTS",
      "WESTLAKE",      "WESTLAKE",

      //VILLAGES
      "BENTLEYVILLE",  "BENTLEYVILLE",
      "BRATENAHL",     "BRATENAHL",
      "BROOKLYN HEI",  "BROOKLYN HEIGHTS",
      "CHAGRIN FALL",  "CHAGRIN FALLS",
      "CUYAHOGA HEI",  "CUYAHOGA HEIGHTS",
      "GATES MILLS",   "GATES MILLS",
      "GLENWILLOW",    "GLENWILLOW",
      "HIGHLAND HIL",  "HIGHLAND HILLS",
      "HUNTING VALL",  "HUNTING VALLEY",
      "LINNDALE",      "LINNDALE",
      "MAYFIELD",      "MAYFIELD",
      "MORELAND HIL",  "MORELAND HILLS",
      "NEWBURGH HEI",  "NEWBURGH HEIGHTS",
      "N RANDALL",     "N RANDALL",
      "OAKWOOD",       "OAKWOOD",
      "ORANGE",        "ORANGE",
      "VALLEY VIEW",   "VALLEY VIEW",
      "WALTON HILLS",  "WALTON HILLS",
      "WOODMERE",      "WOODMERE",

      //TOWNSHIPS
      "CHAGRIN FALL",  "CHAGRIN FALLS TWP",
      "OLMSTED",       "OLMSTED TWP",

  });

}
