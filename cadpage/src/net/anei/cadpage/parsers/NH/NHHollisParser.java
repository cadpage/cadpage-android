package net.anei.cadpage.parsers.NH;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA16Parser;

/**
 * Hocking County, OH
 */
public class NHHollisParser extends DispatchA16Parser {

  public NHHollisParser() {
    super(CITY_LIST, "HOLLIS", "NH");
  }

  @Override
  public String getFilter() {
    return "hdispatch4@hollisnh.org";
  }

  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("HCC")) return false;
    return super.parseMsg(body, data);
  }

  private static final String[] CITY_LIST = new String[]{
    "BROOKLINE",
    "HOLLIS"
  };
}
  