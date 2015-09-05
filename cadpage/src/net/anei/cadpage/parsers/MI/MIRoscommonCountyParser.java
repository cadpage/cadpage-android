package net.anei.cadpage.parsers.MI;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

public class MIRoscommonCountyParser extends DispatchOSSIParser {
  
  public MIRoscommonCountyParser() {
    super(CITY_CODES, "ROSCOMMON COUNTY", "MI", 
          "( CANCEL ADDR CITY | ( FYI | EMPTY ) CALL ADDR CITY! ) INFO+");
  }
  
  @Override
  public String getFilter() {
    return "CAD@roscommoncounty.net";
  }

  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "GERR", "GERRISH TWP",
      "LYO",  "LYON TWP",
      "LYON", "LYON TWP",
      "ROSC", "ROSCOMMON TWP"
  });
}
