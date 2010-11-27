package net.anei.cadpage.parsers;

import net.anei.cadpage.SmsMsgInfo;
import net.anei.cadpage.SmsMsgInfo.Data;

/**
 * Abstract combination parser that accepts the results of the first parser
 * that accepts each message 
 */

public class GroupBestParser extends GroupBaseParser {
  
  public GroupBestParser(SmsMsgParser ... parsers) {
    super(parsers);
  }
  
  @Override
  public SmsMsgInfo parse(String body) {

    SmsMsgParser bestParser = null;
    int bestScore = -1;
    Data bestData = null;
    
    for (SmsMsgParser parser : getParsers()) {
      if (parser.isPageMsg(body)) {
        Data tmp = new Data();
        parser.parse(body, tmp);
        int newScore = tmp.score();
        if (newScore > bestScore) {
          bestParser = parser;
          bestData = tmp;
          bestScore = newScore;
        }
      }
    }
    
    setParser(bestParser);
    if (bestData == null) bestData = new Data();
    return new SmsMsgInfo(bestData);
  }
}
