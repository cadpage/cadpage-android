package net.anei.cadpage.parsers.TX;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchA41Parser;

public class TXFortBendCountyParser extends DispatchA41Parser {

  public TXFortBendCountyParser() {
    super(CITY_CODES, "FORT BEND COUNTY", "TX", "[A-Z]{2,3}");
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "BEA", "BEASLEY",
      "EB", "EAST BERNARD", 
      "FUL", "FULSHEAR",
      "HOU", "HOUSTON",
      "KEN", "KENDLETON",
      "KTY", "KATY",
      "NDV", "NEEDVILLE",
      "PLK", "PLEAK",
      "RIC", "RICHMOND",
      "ROS", "ROSENBERG",
      "SIM", "SIMONTON",
      "SUG", "SUGAR LAND",
      "WAL", "WALLIS",
  });
}
