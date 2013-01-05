package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class OHLickingCountyParser extends SmartAddressParser {
  
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
    
    // get rid of decimal points on the house numbers
    body = body.replace(".00", "");
    
    Parser p = new Parser(body);
    p.getOptional("- Nature: ");
    data.strCall = p.getOptional(" - Location: ");
    if (data.strCall.length() == 0) data.strCall = p.get("  ");
    body = p.get();
    
    // Smart address parser has to take things from here
    // Leaving room for a possible apt number between address and city
    parseAddress(StartType.START_ADDR, FLAG_PAD_FIELD, body, data);
    data.strApt = append(data.strApt, " ", getPadField());
    if (data.strApt.startsWith("APT ")) data.strApt = data.strApt.substring(4).trim();
    
    String sInfo = getLeft();
    if (sInfo.startsWith("-") || sInfo.startsWith(".")) sInfo = sInfo.substring(1).trim();
    if (sInfo.startsWith("Comments:")) sInfo = sInfo.substring(9).trim();
    data.strSupp = sInfo;
    
    return true;
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
