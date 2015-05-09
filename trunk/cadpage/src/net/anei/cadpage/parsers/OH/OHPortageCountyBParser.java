package net.anei.cadpage.parsers.OH;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA39Parser;

/**
 * Portage County, OH
 */
public class OHPortageCountyBParser extends DispatchA39Parser {

  public OHPortageCountyBParser() {
    super(CITY_LIST, "PORTAGE COUNTY", "OH");
  }

  @Override
  public String getFilter() {
    return "garrettsvilledispatch@gmail.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    // Fix a few dispatch oddities
    Matcher match = SLASH_DOTS_PTN.matcher(body);
    if (match.matches()) body = match.group(1) + '\n' + match.group(2) + '\n' + match.group(3);
    body = BROISUS_PTN.matcher(body).replaceAll("BROSIUS");
    
    return super.parseMsg(subject, body, data);
  }
  private static final Pattern SLASH_DOTS_PTN = Pattern.compile("(.*)\n(.*)\\.\\.+(.*)");
  private static final Pattern BROISUS_PTN = Pattern.compile("\\bBROISUS\\b", Pattern.CASE_INSENSITIVE);

  private static final String[] CITY_LIST = new String[]{
    
    // Townships
    "ATWATER TWP",
    "BRIMFIELD TWP",
    "CHARLESTOWN TWP",
    "DEERFIELD TWP",
    "EDINBURG TWP",
    "FRANKLIN TWP",
    "FREEDOM TWP",
    "HIRAM TWP",
    "MANTUA TWP",
    "NELSON TWP",
    "PALMYRA TWP",
    "PARIS TWP",
    "RANDOLPH TWP",
    "RAVENNA TWP",
    "ROOTSTOWN TWP",
    "SHALERSVILLE TWP",
    "SUFFIELD TWP",
    "WINDHAM TWP",

    // Cities and villages
    "AURORA",
    "BRADY LAKE",
    "GARRETTSVILLE",
    "HIRAM",
    "KENT",
    "MANTUA",
    "MOGADORE",
    "RAVENNA",
    "STREETSBORO",
    "SUGAR BUSH KNOLLS",
    "WINDHAM",

    // Unincorporated communities
    "DIAMOND",
    "WAYLAND",

    // Census-designated places
    "ATWATER",
    "BRIMFIELD",

      
  };
}
