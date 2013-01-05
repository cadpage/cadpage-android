package net.anei.cadpage.parsers.NC;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/**
 * Burke County, NC
 */
public class NCBurkeCountyParser extends DispatchOSSIParser {
  
  public NCBurkeCountyParser() {
    super("BURKE COUNTY", "NC",
           "SRC CALL CODE? ADDR! X? X? INFO+");
  }
  
  @Override
  public String getFilter() {
    return "CAD@bceoc.org,CAD@burke.local";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (body.startsWith("|")) body = body.substring(1).trim();
    return super.parseMsg(body, data);
  }
  
  class MyCodeField extends CodeField {
    public MyCodeField() {
      setPattern(Pattern.compile("\\d\\d[A-Z]\\d\\d"));
    }
  }
  
  @Override
  protected Field getField(String name) {
    if (name.equals("CODE")) return new MyCodeField();
    return super.getField(name);
  }
}
