package net.anei.cadpage.parsers.MN;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchPrintrakParser;


/**
 * Bloomington, MN
 */
public class MNBloomingtonParser extends DispatchPrintrakParser {
  
  public MNBloomingtonParser() {
    super("BLOOMINGTON", "MN");
  }
  
  @Override
  public String getFilter() {
    return "logis-emergin-paging@logis.org";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    return super.parseMsg("TYP: " + body, data);
  }
}
