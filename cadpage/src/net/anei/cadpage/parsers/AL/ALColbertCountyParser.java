package net.anei.cadpage.parsers.AL;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import net.anei.cadpage.parsers.dispatch.DispatchGeoconxParser;

/**
 * Colbert County, AL
 */
public class ALColbertCountyParser extends DispatchGeoconxParser {
  
  public ALColbertCountyParser() {
    super(CITY_SET, "COLBERT COUNTY", "AL", true);
  }
  
  @Override
  public String getFilter() {
    return "911alert@comcast.net,dispatch@911email.net";
  }
  
  private static final Set<String> CITY_SET = new HashSet<String>(Arrays.asList(new String[]{

      // Cities
      "MUSCLE SHOALS",
      "SHEFFIELD",
      "TUSCUMBIA",
      
      // Towns
      "CHEROKEE",
      "LEIGHTON",
      "LITTLEVILLE",
      
      // Unincorporated 
      "ALLSBORO",
      "BARTON",
      "BUZZARD ROOST",
      "COLBERT HEIGHTS",
      "FORD CITY",
      "WHITE OAK"
  }));
}
