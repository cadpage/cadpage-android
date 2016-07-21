package net.anei.cadpage.parsers.NC;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;



public class NCWilkesCountyParser extends DispatchSouthernParser {
  
  public NCWilkesCountyParser() {
    super(CITY_LIST, "WILKES COUNTY", "NC", DSFLAG_TRAIL_PLACE | DSFLAG_FOLLOW_CROSS | DSFLAG_ID_OPTIONAL | DSFLAG_TIME_OPTIONAL);
    removeWords("RUN");
  }
  
  @Override
  public String getFilter() {
    return "@wilkescounty.net";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_PREFER_GPS;
  }
  
  @Override
  public String adjustMapAddress(String address) {
    address = NO_EXT_PTN.matcher(address).replaceAll("$1");
    address = EXT_EXD_PTN.matcher(address).replaceAll("$1 EXD");
    return super.adjustMapAddress(address);
  }
  private static final Pattern NO_EXT_PTN = Pattern.compile("\\b(WINKLER MILL RD) EXT", Pattern.CASE_INSENSITIVE);
  private static final Pattern EXT_EXD_PTN = Pattern.compile("\\b(COUNTRY CLUB RD) EXT", Pattern.CASE_INSENSITIVE);
  
  private static final String[] CITY_LIST = new String[]{

    // Towns
    "ELKIN",
    "NORTH WILKESBORO",
    "RONDA",
    "WILKESBORO",

    // Census-designated places
    "CRICKET",
    "FAIRPLAINS",
    "HAYS",
    "MILLERS CREEK",
    "MORAVIAN FALLS",
    "MULBERRY",
    "PLEASANT HILL",
    "TRAPHILL",

    // Unincorporated communities
    "CLINGMAN",
    "DARBY",
    "FERGUSON",
    "MCGRADY",
    "PARSONSVILLE",
    "PURLEAR",
    "ROARING RIVER",
    "THURMOND",

    // Townships
    "ANTIOCH",
    "BEAVER",
    "CREEK",
    "BOOMER",
    "BRUSHY MOUNTAINS",
    "EDWARDS",
    "ELK CREEK",
    "HAYS",
    "JOBS CABIN",
    "LEWIS FORK",
    "LOVELACE",
    "MORAVIAN FALLS",
    "MULBERRY",
    "NEW CASTLE",
    "NORTH WILKESBORO",
    "ROCK CREEK",
    "SOMERS",
    "STANTON",
    "TRAPHILL",
    "UNION",
    "WALNUT GROVE",
    "MILLERS CREEK",
    "WILKESBORO",
    
    // Watauga County
    "WATAUGA",
    "DEEP GAP",
    
    // Yadkin County
    "YADKIN",
    "HAMPTONVILLE"
  };
}