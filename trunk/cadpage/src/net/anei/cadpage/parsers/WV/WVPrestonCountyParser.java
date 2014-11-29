package net.anei.cadpage.parsers.WV;

import net.anei.cadpage.parsers.dispatch.DispatchA48Parser;

/**
 * Preston County, WV
 */
public class WVPrestonCountyParser extends DispatchA48Parser {
  
  public WVPrestonCountyParser() {
    super(CITY_LIST, "PRESTON COUNTY", "WV", FieldType.NAME, A48_ONE_WORD_CODE);
  }
  
  @Override
  public String getFilter() {
    return "Preston911@preston911.com";
  }
  
  private static final String[] CITY_LIST = new String[]{
    
    //Cities and towns
    "ALBRIGHT",
    "BRANDONVILLE",
    "BRUCETON MILLS",
    "KINGWOOD",
    "MASONTOWN",
    "NEWBURG",
    "REEDSVILLE",
    "ROWLESBURG",
    "TERRA ALTA",
    "TUNNELTON",

    // Unincorporated communities
    "AFTON",
    "ALPINE LAKE",
    "AMBOY",
    "ARTHURDALE",
    "AURORA",
    "AUSTEN",
    "BORGMAN",
    "BRETZ",
    "BULL RUN",
    "CASCADE",
    "CLIFTON MILLS",
    "COLEBANK",
    "CORINTH",
    "CUZZART",
    "DENVER",
    "EGLON",
    "ETAM",
    "EVANSVILLE",
    "FELLOWSVILLE",
    "GLADEFARMS",
    "HAZELTON",
    "HOPEMONT",
    "HOPEWELL",
    "HORSE SHOE RUN",
    "HOWESVILLE",
    "INDEPENDENCE",
    "ISRAEL",
    "LENOX",
    "LITTLE SANDY",
    "MANHEIM",
    "MACOMBER",
    "MANOWN",
    "MARQUESS",
    "MOUNT OLIVET",
    "MOUNT VERNON",
    "ORR",
    "PISGAH",
    "PLEASANTDALE",
    "PRESTON",
    "ROCKVILLE",
    "RODEMER",
    "ROHR",
    "RUTHBELLE",
    "SAINT JOE",
    "SCOTCH HILL",
    "SELL",
    "SILVER LAKE",
    "SINCLAIR",
    "SNIDER",
    "STEVENSBURG",
    "SUGAR VALLEY",
    "THREEFORK BRIDGE",
    "TURNER DOUGLASS",
    "VALLEY POINT",
    "VICTORIA",
    "WEST END",
    "WHITE OAK SPRINGS",
    "ZEVELY",
    
    // Taylor County
    "THORNTON"
  };
}
