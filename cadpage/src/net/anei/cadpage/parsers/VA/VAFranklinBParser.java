package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

/**
 * Franklin, VA
 */
public class VAFranklinBParser extends DispatchSouthernParser {

  public VAFranklinBParser() {
    super(CALL_LIST, CITY_LIST, "FRANKLIN", "VA", DSFLAG_ID_OPTIONAL | DSFLAG_FOLLOW_CROSS);
  }

  @Override
  public String getFilter() {
    return "smith@shso.org,dispatch2@shso.org";
  }

  @Override
  protected void parseExtra(String sExtra, Data data) {
    if (sExtra.startsWith("-")) sExtra = sExtra.substring(1).trim();
    super.parseExtra(sExtra, data);
  }

  private static final String[] CITY_LIST = new String[]
     {"FRANKLIN","COURTLAND","SEDLEY"};
  
  private static final CodeSet CALL_LIST = new CodeSet(
      "RESCUE EMS",
      "FIRE"     
  );
}
