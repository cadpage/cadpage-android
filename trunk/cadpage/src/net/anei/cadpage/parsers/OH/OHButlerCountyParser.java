package net.anei.cadpage.parsers.OH;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA3Parser;


public class OHButlerCountyParser extends DispatchA3Parser {
  
  private static final Pattern SPECIAL_COMMENT_PTN = Pattern.compile(" Special Comment:+ *\\*([\\w ]+)\\*");
  
  public OHButlerCountyParser() {
    super(0, "BCSO:", "BUTLER COUNTY", "OH");
  }
  
  protected boolean parseMsg(String body, Data data) {
    body = SPECIAL_COMMENT_PTN.matcher(body).replaceAll(" $1");
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getFilter() {
    return "BCSO@butlersheriff.org";
  }
}
