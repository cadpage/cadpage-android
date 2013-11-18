package net.anei.cadpage.parsers.TX;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;



public class TXWilliamsonCountyAParser extends DispatchOSSIParser {

  public TXWilliamsonCountyAParser() {
    super("WILLIAMSON COUNTY", "TX",
           "HEAD? CALL ADDR! UNIT CH");
  }
  
  @Override
  public String getFilter() {
    return "cad@wilco.org";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }
 
  @Override
  public boolean parseMsg(String body, Data data) {
    body = body.replaceAll("SH 130 TOLL", "TX 130");
    return super.parseMsg(body, data);
  }
  
  private class HeadField extends SkipField {
    public HeadField() {
      setPattern(Pattern.compile("FYI:|Update:"));
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("HEAD")) return new HeadField();
    return super.getField(name);
  }
  
}
