package net.anei.cadpage.parsers.FL;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchPrintrakParser;



public class FLCollierCountyParser extends DispatchPrintrakParser {
  
  private static final Pattern MARKER = Pattern.compile("^FCC\\d{12} TYP: ");
  
  public FLCollierCountyParser() {
    super("COLLIER COUNTY", "FL");
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (MARKER.matcher(body).find()) body = "INC:" + body; 
    return super.parseMsg(body, data);
  }
}
