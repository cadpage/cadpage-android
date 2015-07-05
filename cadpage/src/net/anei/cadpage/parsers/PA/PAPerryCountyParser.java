package net.anei.cadpage.parsers.PA;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchArchonixParser;



public class PAPerryCountyParser extends DispatchArchonixParser {
  
  public PAPerryCountyParser() {
    super(CITY_CODES, "PERRY COUNTY", "PA");
  }
  
  @Override
  public String getFilter() {
    return "911cccad@perryco.org";
  }
  

  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "03",   "SHERMANS DALE",
      "05",   "DUNCANNON",
      "16",   "NEW BLOOMSFIELD",
      "21",   "DUNCANNON",
      "22",   "MARYSVILLE",
      "25",   "LANDISBURG",
      "29",   "DUNCANNON",
      "30",   "DUNCANNON",
      "51",   "",
      "52",   ""
      
  });

}
