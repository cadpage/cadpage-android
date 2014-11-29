package net.anei.cadpage.parsers.IN;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.dispatch.DispatchSPKParser;

public class INShelbyCountyParser extends DispatchSPKParser {
  public INShelbyCountyParser() {
    super("SHELBY COUNTY", "IN");
  }

  private static final Pattern SHELBY_STATE_RD_PATTERN
    = Pattern.compile("(?i)(.*?)SHELBY +STATE +RD +44(.*)");
  @Override
  public String adjustMapAddress (String addr) {
    Matcher m = SHELBY_STATE_RD_PATTERN.matcher(addr);
    if (m.matches())
      return m.group(1)+"STATE 44"+m.group(2);
    return addr;
  }
  
  @Override
  public String getFilter() {
    return "ShelbyCoCAD@in.gov";
  }
}
