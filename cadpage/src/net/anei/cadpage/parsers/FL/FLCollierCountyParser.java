package net.anei.cadpage.parsers.FL;

import java.util.Properties;
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
  public String getFilter() {
    return "ccsocad@colliersheriff.org,ccsocad@colliersheriff.net";
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
    
    String call = CALL_CODES.getProperty(data.strCode);
    if (call != null) {
      data.strCall = append(data.strCall, " - ", call);
    }
    
    data.strUnit = append(data.strUnit, " ", units);
    data.strSupp = append(data.strSupp, "\n", info);
    return true;
  }
  
  @Override
  public String getProgram() {
    return super.getProgram() + " INFO UNIT";
  }
  
  private static final Properties CALL_CODES = buildCodeTable(new String[]{
      "04I",  "Crash w/Injuries",
      "04N",  "Crash - Neg Injuries",
      "04U",  "Crash - Unknown Injuries",
      "05",   "Murder",
      "07",   "Dead Person",
      "08",   "Missing",
      "15",   "Details",
      "20",   "Mentally Ill Person",
      "22",   "Disturbance",
      "24I",  "Robbery IP",
      "24N",  "Robbery Neg IP",
      "25",   "Fire",
      "26",   "Drowning",
      "30",   "Bomb",
      "32",   "Alarm",
      "34",   "Sex Crime",
      "37",   "Explosion",
      "39",   "Assault/Battery",
      "40",   "Hazardous Incident",
      "53",   "Assist",
      "54",   "Rescue",
      "56",   "Abuse",
      "59",   "Barricade/Hostage Situation",
      "60",   "Suicide",
      "62",   "Shooting",
      "63",   "Stabbing",
      "66",   "Severe Weather",
      "71",   "Medical Emergency",
      "80",   "MERT (Intracoastal or Gulf of Mexico)",
      "81",   "Aircraft Alert",
      "MCI1", "MCI Level 1",
      "MCI2", "MCI Level 2",
      "MCI3", "MCI Level 3",
      "MCI4", "MCI Level 4",
      "MCI5", "MCI Level 5"

  });
}
