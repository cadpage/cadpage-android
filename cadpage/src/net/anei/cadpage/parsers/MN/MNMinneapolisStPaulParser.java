package net.anei.cadpage.parsers.MN;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchPrintrakParser;


/**
 * Bloomington, MN
 */
public class MNMinneapolisStPaulParser extends DispatchPrintrakParser {
  
  public MNMinneapolisStPaulParser() {
    super("MINNEAPOLIS", "MN");
  }
  
  @Override
  public String getLocName() {
    return "Minneapolis/St Paul, MN";
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
