package net.anei.cadpage.parsers;

import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Abstract combination parser that accepts the results of the first parser
 * that accepts each message 
 */

public class GroupBestParser extends MsgParser {
  
  private MsgParser[] parsers;
  
  private String dispFilter;
  
  private MsgParser lastParser = null;
  
  public GroupBestParser(MsgParser ... parsers) {
    super(parsers[0].getDefaultCity(), parsers[0].getDefaultState());
    
    this.parsers = parsers;
    
    // Build a display filter by concatenating all of the filters of
    // our constituent parsers.  As the name implies, this will never be
    // used to do any real filtering, but it will give us something to 
    // display in the settings menu
    StringBuilder sb = new StringBuilder();
    for (MsgParser parser : parsers) {
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
  protected Data parseMsg(Message msg, int parserFlags) {
    
    MsgParser bestParser = null;
    int bestScore = -1;
    Data bestData = null;
    
    for (MsgParser parser : parsers) {
      Data tmp = parser.parseMsg(msg, parserFlags);
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
