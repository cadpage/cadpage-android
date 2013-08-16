package net.anei.cadpage.parsers.LA;

import net.anei.cadpage.parsers.dispatch.DispatchA26Parser;

/**
 * Ascension Parish, LA
 */
public class LAAscensionParishParser extends DispatchA26Parser {
  
  
  public LAAscensionParishParser() {
    super("ASCENSION PARISH", "LA");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@ascensionsheriff.com";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }
}
