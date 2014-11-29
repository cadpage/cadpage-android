package net.anei.cadpage.parsers.IL;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA9Parser;


/**
 * Madison County, IL
 */
public class ILMadisonCountyParser extends DispatchA9Parser {
  
  private static final Pattern TRAILING_BLANK_PTN = Pattern.compile(" +\\n");
  
  public ILMadisonCountyParser() {
    super(null, "MADISON COUNTY", "IL");
  }
  
  @Override
  public String getFilter() {
    return "glentelecom@glen-carbon.il.us";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    body = TRAILING_BLANK_PTN.matcher(body).replaceAll("\n");
    return super.parseMsg(body, data);
  }
  
}
