package net.anei.cadpage.parsers.MI;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA9Parser;


/**
 * Grand Traverse County, MI
 */
public class MIGrandTraverseCountyParser extends DispatchA9Parser {
  
  private static final Pattern CITY_PTN = Pattern.compile("(.*?) +(?:BORO|- NON SPECIFI?C?)", Pattern.CASE_INSENSITIVE);
  
  public MIGrandTraverseCountyParser() {
    super(null, "GRAND TRAVERSE COUNTY", "MI");
  }
  
  @Override
  public String getFilter() {
    return "itsmtp@grandtraverse.org";
  }
  
  
}
