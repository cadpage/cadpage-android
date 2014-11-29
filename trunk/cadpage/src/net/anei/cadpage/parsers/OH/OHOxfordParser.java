package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.dispatch.DispatchCiscoParser;

/**
 * Oxford, OH
 */
public class OHOxfordParser extends DispatchCiscoParser {
  
  public OHOxfordParser() {
    super("OXFORD", "OH");
  }
  
  @Override
  public String getFilter() {
    return "cisco@cityofoxford.org";
  }
}
