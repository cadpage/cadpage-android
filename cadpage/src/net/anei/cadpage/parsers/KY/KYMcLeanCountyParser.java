package net.anei.cadpage.parsers.KY;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.dispatch.DispatchEmergitechParser;

/**
 * McLean County, KY
 */
public class KYMcLeanCountyParser extends DispatchEmergitechParser {
  
  public KYMcLeanCountyParser() {
    super("Dispatch:", 0, CITY_LIST, "MCLEAN COUNTY", "KY");
    setupCallList(CALL_LIST);
  }

  private static final CodeSet CALL_LIST = new CodeSet(
      "AUTO ACCIDENT WITH INJURIES",
      "BLOOD PRESSURE HIGH/LOW",
      "BREATHING PROBLEMS",
      "BURNING - CONTROLLED",
      "CHEST PAIN",
      "FALLS - GROUND LEVEL - OTHER",
      "GENERAL MEDICAL",
      "OVERDOSE",
      "SEIZURES",
      "TRANSFER PATIENT"
  );
  
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
      "UTICA",
      "WRIGHTSBURG",
      "WYMAN"
  };
}
