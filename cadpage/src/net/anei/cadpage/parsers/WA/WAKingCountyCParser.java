package net.anei.cadpage.parsers.WA;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchA41Parser;

public class WAKingCountyCParser extends DispatchA41Parser {

  public WAKingCountyCParser() {
    super(CITY_CODES, "KING COUNTY", "TX");
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "BUR", "BURIEN",
      "DES", "DES MOINES",
      "NDP", "NORMANDY PARK",
      "STL", "WHITE CENTER",
  });
}
