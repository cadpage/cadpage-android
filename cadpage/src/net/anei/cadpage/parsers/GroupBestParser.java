package net.anei.cadpage.parsers;

import net.anei.cadpage.SmsMmsMessage;
import net.anei.cadpage.SmsMsgInfo.Data;

/**
 * Abstract combination parser that accepts the results of the first parser
 * that accepts each message 
 */

public class GroupBestParser extends SmsMsgParser {
  
  private SmsMsgParser[] parsers;
  
  private String dispFilter;
  
  private SmsMsgParser lastParser = null;
  
  public GroupBestParser(SmsMsgParser ... parsers) {
    super(parsers[0].getDefaultCity(), parsers[0].getDefaultState());
    
    this.parsers = parsers;
    
    // Build a display filter by concatenating all of the filters of
    // our constituent parsers.  As the name implies, this will never be
    // used to do any real filtering, but it will give us something to 
    // display in the settings menu
    StringBuilder sb = new StringBuilder();
    for (SmsMsgParser parser : parsers) {
      String filter = parser.getFilter();
      if (filter.length() > 0) {
        if (sb.length() > 0) sb.append(',');
        sb.append(filter);
      }
    }
    dispFilter = sb.toString();
  }
  
  @Override
  public String getFilter() {
    return dispFilter;
  }

  @Override
  protected Data parseMsg(SmsMmsMessage msg, boolean overrideFilter, boolean genAlert) {

    SmsMsgParser bestParser = null;
    int bestScore = -1;
    Data bestData = null;
    
    for (SmsMsgParser parser : parsers) {
      Data tmp = parser.parseMsg(msg, overrideFilter, genAlert);
      if (tmp != null) {
        int newScore = tmp.score();
        if (newScore > bestScore) {
          bestParser = parser;
          bestData = tmp;
          bestScore = newScore;
        }
      }
    }
    
    lastParser = bestParser;
    return bestData;
  }

  // We have to override this to satisfy abstract requirements, but it will
  // never be called and doesn't have to do anything
  @Override
  protected boolean parseMsg(String strMessage, Data data) {
    return false;
  }
  
  // Override getParserCode to relay request to the parser that really
  // parsed the information
  @Override
  public String getParserCode() {
    return (lastParser == null ? null : lastParser.getParserCode());
  }

}
