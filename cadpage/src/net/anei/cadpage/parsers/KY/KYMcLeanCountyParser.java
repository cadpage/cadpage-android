package net.anei.cadpage.parsers.KY;

import net.anei.cadpage.parsers.dispatch.DispatchEmergitechParser;

/**
 * McLean County, KY
 */
public class KYMcLeanCountyParser extends DispatchEmergitechParser {
  
  public KYMcLeanCountyParser() {
    super("Dispatch:", 67, CITY_LIST, "MCLEAN COUNTY", "KY");
  }

  private static final String[] CITY_LIST = new String[]{

      "BEECH GROVE",
      "BUEL",
      "BUTTONSBERRY",
      "CALHOUN",
      "CLEOPATRA",
      "COMER",
      "CONGLETON",
      "ELBA",
      "GLENVILLE",
      "GUFFIE",
      "ISLAND",
      "LEMON",
      "LIVERMORE",
      "LIVIA",
      "NUCKOLS",
      "PACK",
      "POPLAR GROVE",
      "POVERTY",
      "RUMSEY",
      "SACRAMENTO",
      "SEMIWAY",
      "WRIGHTSBURG",
      "WYMAN"
  };
}
