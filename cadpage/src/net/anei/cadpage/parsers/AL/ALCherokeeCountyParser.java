package net.anei.cadpage.parsers.AL;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchGeoconxParser;

/**
 * Cherokee County, AL
 */
public class ALCherokeeCountyParser extends DispatchGeoconxParser {
  
  public ALCherokeeCountyParser() {
    super(CITY_SET, "CHEROKEE COUNTY", "AL");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@911email.ne";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_SR;
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!super.parseMsg(subject, body, data)) return false;
    int pt = data.strAddress.lastIndexOf(" - ");
    if (pt >= 0) {
      data.strMap = data.strAddress.substring(pt+3).trim();
      data.strAddress = data.strAddress.substring(0,pt).trim();
    }
    return true;
  }
  
  @Override
  public String getProgram() {
    return super.getProgram().replace("APT", "APT MAP");
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
