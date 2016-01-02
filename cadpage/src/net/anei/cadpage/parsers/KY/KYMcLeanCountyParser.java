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
      "ABDOMINAL PAIN",
      "ANNOUNCEMENT",
      "ASSAULT",
      "AUTO ACCIDENT - NO INJURY",
      "AUTO ACCIDENT NO INJURIES",
      "AUTO ACCIDENT WITH INJURIES",
      "BLEEDING",
      "BLOOD PRESSURE HIGH/LOW",
      "BREATHING PROBLEMS",
      "BURNING - CONTROLLED",
      "CHEST PAIN",
      "DIABETIC PROBLEM",
      "FALL",
      "FALLS - GROUND LEVEL - OTHER",
      "FIRE - REKINDLE",
      "FIRE - STRUCTURE",
      "FIRE - TREES, BRUSH, GRASS",
      "GENERAL MEDICAL",
      "HEADACHES",
      "HEART ATTACK",
      "HEART / FAST /SLOW",
      "MUTUAL AID",
      "OVERDOSE",
      "PAIN",
      "SEIZURES",
      "STROKE",
      "SUICIDE",
      "SUICIDE-ATTEMPT",
      "SUICIDE-THREATENING",
      "ROAD CLOSED",
      "STAND BY/RESPOND",
      "TEST",
      "TRANSFER PATIENT",
      "UNKNOWN MEDICAL EMERGENCY",
      "UNRESPONSIVE",
      "WALK-IN",
      "WEATHER",
      "WEATHER ALERT"
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
      "OWENSBORO",
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
