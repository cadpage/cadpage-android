package net.anei.cadpage.parsers.NJ;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

public class NJMiddlesexCountyBParser extends NJSussexCountyAParser {
  
  public NJMiddlesexCountyBParser() {
    super("MIDDLESEX COUNTY", "NJ");
  }
  
  @Override
  public String getFilter() {
    return "@SBPOLICE.COM";
  }
}
