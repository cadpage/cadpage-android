package net.anei.cadpage.parsers.PA;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchArchonixParser;



public class PAFultonCountyParser extends DispatchArchonixParser {
  
  public PAFultonCountyParser() {
    super(CITY_CODES, MA_CITY_CODES, "FULTON COUNTY", "PA");
  }
  
  @Override
  public String getFilter() {
    return "EP911@ccpa.net";
  }
  

  private static final Properties CITY_CODES = buildCodeTable(new String[]{

      "AR FC", "AYR TWP", 
      "BC FC", "BRUSH CREEK TWP",
      "BL FC", "BELFAST TWP",
      "BT FC", "BETHEL TWP",
      "DB FC", "DUBLIN TWP",
      "LC FC", "LICKING CREEK TWP",
      "MC FC", "MCCONNELLSBURG",
      "TD FC", "TODD TWP",
      "TH FC", "THOMPSON TWP",
      "TY FC", "TAYLOR TWP",
      "UN FC", "UNION TWP",
      "VH FC", "VALLEY-HI",
      "WL FC", "WELLS TWP",
      
      "FC FR", "FRANKLIN COUNTY",
      "HC HU", "HUNTINGDON COUNTY"
  });
  
  private static final Properties MA_CITY_CODES = buildCodeTable(new String[]{
      
  });

}
