package net.anei.cadpage.parsers;

import java.util.HashSet;
import java.util.Set;

/**
 * Common base class for AliasedMsgParser and GroupBestParser
 * adds the ability to report a sender filter that has been
 * merged with sender filters from other parsers
 */
public abstract class GroupBaseParser extends MsgParser {
  
  private String defCity = null;
  private String defState = null;
  private String filter = "";
  private Set<String> filterSet = new HashSet<String>();
  
  /**
   * Main constructor
   * @param parser initial parser
   */
  protected GroupBaseParser() {
    super(null, null);
  }

  protected void addParser(MsgParser parser) {
    
    String city = parser.getDefaultCity();
    if (defCity == null) defCity = city;
    else if (!defCity.equals(city)) defCity = "";
    
    String state = parser.getDefaultState();
    if (defState == null) defState = state;
    else if (!defState.equals(state)) defState = "";
    
    updateFilter(parser.getFilter());
  }
  /**
   * Merge new parser filter into combined filter
   * @param filterP
   */
  private void updateFilter(String filterP) {
    for (String term : filterP.split(",")) {
      term = term.trim();
      if (term.length() == 0) continue;
      if (filterSet.add(term.toUpperCase())) {
        filter = append(filter, ",", term);
      }
    }
  }
  
  @Override
  public String getDefaultCity() {
    return defCity;
  }
  
  @Override
  public String getDefaultState() {
    return defState;
  }

  @Override
  public String getFilter() {
    return filter;
  }
}
