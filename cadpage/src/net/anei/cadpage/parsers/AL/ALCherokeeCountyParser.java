package net.anei.cadpage.parsers.AL;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import net.anei.cadpage.parsers.dispatch.DispatchGeoconxParser;

/**
 * Cherokee County, AL
 */
public class ALCherokeeCountyParser extends DispatchGeoconxParser {
  
  public ALCherokeeCountyParser() {
    super(CITY_SET, "CHEROKEE COUNTY", "AL", GCX_FLG_EMPTY_SUBJECT_OK | GCX_FLG_NAME_PHONE);
  }
  
  @Override
  public String getFilter() {
    return "dispatch@911email.ne";
  }
  
  private static final Set<String> CITY_SET = new HashSet<String>(Arrays.asList(new String[]{

      //INCORPORATED
      "CEDAR BLUFF",
      "CENTRE",
      "COLLINSVILLE",
      "GAYLESVILLE",
      "LEESBURG",
      "PIEDMONT",
      "SAND ROCK",
      
      //UNINCORPORATED
      "FORNEY",
      "LITTLE RIVER",
      "ROCK RUN",
      
      //CDPS
      "BROOMTOWN",
      "SPRING GARDEN"

  }));
}
