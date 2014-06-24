package net.anei.cadpage.parsers.WV;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;

/**
 * Wyoming County, WV
 */
public class WVWyomingCountyParser extends DispatchB2Parser {
  
  private static final Pattern ID_PTN = Pattern.compile("^(\\d+):");


  public WVWyomingCountyParser() {
    super("911-CENTER:", CITY_LIST, "MARSHALL COUNTY", "AL");
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    Matcher match = ID_PTN.matcher(body);
    if (match.lookingAt()) body = body.substring(match.end()).trim();
    return super.parseMsg(body,  data);
  }
  
  private static final String[] CITY_LIST = new String[]{
    
    // Fill in cities
  };
}
