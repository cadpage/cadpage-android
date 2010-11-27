package net.anei.cadpage.parsers;

import net.anei.cadpage.SmsMsgInfo.Data;


/**
 * This class extends the new message parser class to provide compatibility
 * for parser classes that still use the old class standards
 */
public abstract class SmsMsgParserLegacy extends SmsMsgParser {
  
  /**
   * @return true if this message contain the text phrases that indicate it is 
   * a valid page message
   */
  public abstract boolean isPageMsg(String msgText);

  protected abstract void parse(String strMessage, Data data);

  @Override
  protected boolean parseMsg(String strMessage, Data data) {
    if (! isPageMsg(strMessage)) return false;
    parse(strMessage, data);
    return true;
  }
}
