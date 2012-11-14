package net.anei.cadpage.parsers.AL;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.dispatch.DispatchBParser;

/**
 * St Clair County, AL
 */
public class ALMarshallCountyParser extends DispatchBParser {
  
  private static final Pattern MARKER = Pattern.compile("(?:^|\n)911-CENTER:");

  public ALMarshallCountyParser() {
    super(CITY_LIST, "MARSHALL COUNTY", "AL");
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return MARKER.matcher(body).find();
  }
  
  private static final String[] CITY_LIST = new String[]{
    "ALBERTVILLE",
    "ARAB",
    "BOAZ",
    "DOUGLAS",
    "JOPPA",
    "GRANT",
    "GUNTERSVILLE",
    "HORTON",
    "UNION GROVE"
  };
}
