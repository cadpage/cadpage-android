package net.anei.cadpage.parsers;

import net.anei.cadpage.SmsMsgInfo.Data;

/**
 * Abstract combination parser that accepts the results of the first parser
 * that accepts each message 
 */

public class GroupFirstParser extends GroupBaseParser {
  
  public GroupFirstParser(SmsMsgParser ... parsers) {
    super(parsers);
  }

  @Override
  protected void parse(String body, Data data) {
    for (SmsMsgParser parser : getParsers()) {
      if (parser.isPageMsg(body)) {
        setParser(parser);
        parser.parse(body, data);
        return;
      }
    }
  }
}
