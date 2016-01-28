package net.anei.cadpage.parsers.FL;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgInfo.MsgType;
import net.anei.cadpage.parsers.dispatch.DispatchPrintrakParser;



public class FLCollierCountyParser extends DispatchPrintrakParser {
  
  private static final Pattern MARKER = Pattern.compile("^FCC\\d{12} TYP: ");
  private static final Pattern TRAIL_UNIT_PTN = Pattern.compile("(?: +CC[A-Z0-9]*)+(?: +C)?$");
  private static final Pattern TRAIL_INFO_PTN = Pattern.compile("(?:\n+(?:FIRE|EMS)(?: - .*)?)+$");
  private static final Pattern MULTI_BRK_PTN = Pattern.compile("\n{2,}");
  
  public FLCollierCountyParser() {
    super("COLLIER COUNTY", "FL");
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    // Strip off disclaimer
    int pt = body.indexOf("\nThis communication ");
    if (pt >= 0) body = body.substring(0,pt).trim();
    
    // String unit designation off end of string
    String units = "";
    String info = "";
    Matcher match = TRAIL_UNIT_PTN.matcher(body);
    if (match.find()) {
      units = match.group().trim();
      body = body.substring(0,match.start());
    }
    
    // Ditto for odd information unit/map block
    else {
      match = TRAIL_INFO_PTN.matcher(body);
      if (match.find()) {
        info =  match.group().trim();
        info = MULTI_BRK_PTN.matcher(info).replaceAll("\n");
        body = body.substring(0,match.start());
      }
    }
    if (MARKER.matcher(body).find()) body = "INC:" + body; 
    if (!super.parseMsg(body, data)) {
      if (body.startsWith("CC/")) {
        data.msgType = MsgType.GEN_ALERT;
        return true;
      }
      return false;
    }
    
    data.strUnit = append(data.strUnit, " ", units);
    data.strSupp = append(data.strSupp, "\n", info);
    return true;
  }
  
  @Override
  public String getProgram() {
    return super.getProgram() + " INFO UNIT";
  }
}
