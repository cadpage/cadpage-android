package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA40Parser;

public class OHLickingCountyParser extends DispatchA40Parser {

  public OHLickingCountyParser() {
    super(CITY_LIST, "LICKING COUNTY", "OH");
  }

  @Override
  public String getFilter() {
    return "LC911@lcounty.com";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {

    if (!body.startsWith("LC911:")) return false;
    body = body.substring(6).trim();

    if (super.parseMsg(body, data)) return true;

    // If that did not work, see if this is an older, but still supported format
    int pt = body.indexOf("  ");
    if (pt < 0) return false;
    data.strCall = body.substring(0,pt).trim();
    body = body.substring(pt+2).trim();

    parseAddress(StartType.START_ADDR, FLAG_RECHECK_APT, body, data);

    return data.strCity.length() > 0;
  }

  private static final String[] CITY_LIST = new String[]{
      "ALEXANDRIA",
      "BUCKEYE LAKE",
      "GRANVILLE",
      "GRATIOT",
      "HANOVER",
      "HARTFORD",
      "HEATH",
      "HEBRON",
      "JOHNSTOWN",
      "KIRKERSVILLE",
      "NEWARK",
      "NEW ALBANY",
      "PATASKALA",
      "REYNOLDSBURG",
      "ST LOUISVILLE",
      "UTICA",
  
      "BENNINGTON TWP",
      "BOWLING GREEN TWP",
      "BURLINGTON TWP",
      "EDEN TWP",
      "ETNA TWP",
      "FALLSBURY TWP",
      "FRANKLIN TWP",
      "GRANVILLE TWP",
      "HANOVER TWP",
      "HARRISON TWP",
      "HARTFORD TWP",
      "HOPEWELL TWP",
      "JERSEY TWP",
      "LIBERTY TWP",
      "LICKING TWP",
      "MADISON TWP",
      "MARY ANN TWP",
      "MCKEAN TWP",
      "MONROE TWP",
      "NEWARK TWP",
      "NEWTON TWP",
      "PERRY TWP",
      "ST ALBANS TWP",
      "UNION TWP",
      "WASHINGTON TWP",
  
      "BEECHWOOD TRAILS",
      "GRANVILLE SOUTH",
      "HARBOR HILLS",
      "BROWNSVILLE",
      "ETNA",
      "HOMER",
      "JACKSONTOWN",
  };
}
