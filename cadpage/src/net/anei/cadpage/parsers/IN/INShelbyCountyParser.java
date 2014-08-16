package net.anei.cadpage.parsers.IN;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.dispatch.DispatchSPKParser;

public class INShelbyCountyParser extends DispatchSPKParser {
  public INShelbyCountyParser() {
    super(CITY_LIST, "SHELBY COUNTY", "IN");
    setupMultiWordStreets("SHELBY STATE");
  }

  private static final Pattern SHELBY_STATE_RD_PATTERN
    = Pattern.compile("(?i)(.*?)SHELBY +STATE +RD +44(.*)");
  @Override
  public String adjustMapAddress (String addr) {
    Matcher m = SHELBY_STATE_RD_PATTERN.matcher(addr);
    if (m.matches())
      return m.group(1)+"STATE 44"+m.group(2);
    return addr;
  }
  
  @Override
  public String getFilter() {
    return "ShelbyCoCAD@in.gov";
  }
  
  private static final String[] CITY_LIST = {
//    Cities and towns
    "EDINBURGH",
    "FAIRLAND",
    "MORRISTOWN",
    "ST. PAUL",
    "SHELBYVILLE",

// Unincorporated towns
    "BLUE RIDGE",
    "BROOKFIELD",
    "BOGGSTOWN",
    "FLAT ROCK",
    "FOUNTAINTOWN",
    "GENEVA",
    "GWYNNEVILLE",
    "LONDON",
    "MARIETTA",
    "MEIKS",
    "MOUNT AUBURN",
    "SUGAR CREEK",
    "WALDRON",

// Townships
    "ADDISON",
    "BRANDYWINE",
    "HANOVER",
    "HENDRICKS",
    "JACKSON",
    "LIBERTY",
    "MARION",
    "MORAL",
    "NOBLE",
//    "SHELBY",
    "SUGAR CREEK",
    "UNION",
    "VAN BUREN",
    "WASHINGTON",

// Adjacent counties
    "SHELBY COUNTY",
    "HANCOCK COUNTY",
    "RUSH COUNTY",
    "DECATUR COUNTY",
    "BARTHOLOMEW COUNTY",
    "JOHNSON COUNTY",
    "MARION COUNTY"
  };
}
