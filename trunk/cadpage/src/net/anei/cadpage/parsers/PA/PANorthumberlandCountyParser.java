package net.anei.cadpage.parsers.PA;

import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class PANorthumberlandCountyParser extends FieldProgramParser {
  
  private static final Pattern DELIM = Pattern.compile(" \\*(?= )");
  
  public PANorthumberlandCountyParser() {
    super(CITY_CODES, "NORTHUMBERLAND COUNTY", "PA",
           "ADDR CITY CALL! Dispatch:UNIT!");
  }
  
  @Override
  public String getFilter() {
    return "@northumberland.alertpa.org";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (body.startsWith("desc ")) body = body.substring(5).trim();
    int pt = body.indexOf("\nSent by the Northumberland County");
    if (pt >= 0) body = body.substring(0,pt).trim();
    body = body.replace('\n', ' ');
    return parseFields(DELIM.split(body), data);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "COA", "COAL",
      "NOB", "NORTHUMBERLAND",
      "POI", "POINT TWP",
      "SHA", "SHAMOKIN",
      "SUN", "SUNBURY",
      "UPA", "UPPER AUGUSTA TWP",
      "YSE", "SNYDER",
  });
}
