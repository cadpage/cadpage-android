package net.anei.cadpage.parsers.VA;

import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchDAPROParser;

/**
 * Prince Edward County, VA
 */
public class VAPrinceEdwardCountyParser extends DispatchDAPROParser {
  
  public VAPrinceEdwardCountyParser() {
    super(CITY_CODE_TABLE, "PRINCE EDWARD COUNTY", "VA");
  }
  
  @Override
  public String getFilter() {
    return "MAILBOX@farmvilleva.com";
  }
  
  private static final Properties CITY_CODE_TABLE =
    buildCodeTable(new String[]{
        "FAR", "FARMVILLE",
        "MEH", "MEHERRIN",
        "PAM", "PAMPLIN CITY",
        "PRO", "PROSPECT",
        "RIC", "RICE"
    });
}