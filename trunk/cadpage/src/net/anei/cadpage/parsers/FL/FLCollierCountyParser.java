package net.anei.cadpage.parsers.FL;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchPrintrakParser;



public class FLCollierCountyParser extends DispatchPrintrakParser {
  
  private static final Pattern MARKER = Pattern.compile("^FCC\\d{12} TYP: ");
  private static final Pattern TRAIL_UNIT_PTN = Pattern.compile("(?: +CC[A-Z0-9]*)+(?: +C)?$");
  
  public FLCollierCountyParser() {
    super("COLLIER COUNTY", "FL");
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    // String unit designation off end of string
    String units = "";
    Matcher match = TRAIL_UNIT_PTN.matcher(body);
    if (match.find()) {
      units = match.group().trim();
      body = body.substring(0,match.start());
    }
    if (MARKER.matcher(body).find()) body = "INC:" + body; 
    if (!super.parseMsg(body, data)) return false;
    
    data.strUnit = append(data.strUnit, " ", units);
    return true;
  }
  
  @Override
  public String getProgram() {
    return super.getProgram() + " UNIT";
  }
}
