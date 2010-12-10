package net.anei.cadpage.parsers;

import net.anei.cadpage.SmsMsgInfo;
import net.anei.cadpage.SmsMsgInfo.Data;

/**
 * Abstract combination parser that accepts the results of the first parser
 * that accepts each message 
 */

public class GroupBestParser extends SmsMsgParser {
  
  private SmsMsgParser[] parsers;
  
  private SmsMsgParser lastParser = null;
  
  public GroupBestParser(SmsMsgParser ... parsers) {
    this.parsers = parsers;
  }


  @Override
  public SmsMsgInfo parseMsg(String body) {

    SmsMsgParser bestParser = null;
    int bestScore = -1;
    Data bestData = null;
    
    for (SmsMsgParser parser : parsers) {
      Data tmp = new Data();
      if (parser.parseMsg(body, tmp)) {
        int newScore = tmp.score();
        if (newScore > bestScore) {
          bestParser = parser;
          bestData = tmp;
          bestScore = newScore;
        }
      }
    }
    
    lastParser = bestParser;
    if (bestData == null) return null;
    return new SmsMsgInfo(bestData);
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
    return lastParser.getParserCode();
  }

}
