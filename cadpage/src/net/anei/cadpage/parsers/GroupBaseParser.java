package net.anei.cadpage.parsers;

import net.anei.cadpage.SmsMsgInfo.Data;

/**
 * Abstract combination parser that accepts the results of the first parser
 * that accepts each message 
 */

public abstract class GroupBaseParser extends SmsMsgParser {
  
  private SmsMsgParser[] parsers;
  
  private SmsMsgParser lastParser = null;
  
  public GroupBaseParser(SmsMsgParser[] parsers) {
    this.parsers = parsers;
  }
  
  public SmsMsgParser[] getParsers() {
    return parsers;
  }
  
  protected void setParser(SmsMsgParser parser) {
    this.lastParser = parser;
  }

  @Override
  public boolean isPageMsg(String body) {
    
    for (SmsMsgParser parser : parsers) {
      if (parser.isPageMsg(body)) {
        lastParser = parser;
        return true;
      }
    }
    return false;
  }

  // We have to override this to satisfy abstract requirements, but it will
  // never be called and doesn't have to do anything
  @Override
  protected void parse(String body, Data data) {}
  
  @Override
  public String getParserCode() {
    return lastParser.getParserCode();
  }
}
