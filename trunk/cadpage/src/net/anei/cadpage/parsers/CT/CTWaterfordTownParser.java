package net.anei.cadpage.parsers.CT;


import java.util.regex.Pattern;

import net.anei.cadpage.parsers.dispatch.DispatchVisionAirParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Waterford Town, CT
 */
public class CTWaterfordTownParser extends DispatchVisionAirParser {
  
  private static final Pattern DELIM = Pattern.compile("\\*[\n ]");
  
  public CTWaterfordTownParser() {
    super("", "WATERFORD TWP", "CT",
          "ID ADDR APT APT CITY INFO SKIP CALL! PLACENAME PHONE UNIT EMPTY+? EXTRA INFO+");
  }
  
  @Override
  public String getFilter() {
    return "wecc@waterfordct.org";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (body.endsWith("*")) body = body + '\n';
    return parseFields(DELIM.split(body), 8, data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new IdField("\\d{4}-\\d{6}", true);
    return super.getField(name);
  }
}
