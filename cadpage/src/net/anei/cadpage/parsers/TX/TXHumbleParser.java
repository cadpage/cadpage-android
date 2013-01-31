package net.anei.cadpage.parsers.TX;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;



public class TXHumbleParser extends DispatchOSSIParser {
  
  // Pattern to find a single dash delimiter followed by a numeric ID token
  private static Pattern TRAIL_DELIM = Pattern.compile(" - (?=\\d+$ *)");
  
  // Pattern to identify status messages
  private static Pattern INCIDENT_PTN = Pattern.compile(" *Incident: \\d{9} *| *\\[ \\d{9} \\] *");
  
  public TXHumbleParser() {
    super("HUMBLE", "TX",
           "CALL CALL2? ADDRCITY/Z! Map:MAP PLACE Xst's:X Units:UNIT ID");
  }
  
  @Override
  public String getFilter() {
    return "msg@cfmsg.com,alert@cfmsg.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    // Strip off leading single dash
    // If last field delimiter is a single dash, turn it to a double dash
    Parser p = new Parser(subject);
    data.strSource = p.get('|');
    if (data.strSource.equalsIgnoreCase("Chief ALT")) {
      data.strSource = p.get('|');
    }
    if (!data.strSource.endsWith("FIRE") && !data.strSource.endsWith("EMS")) return false;
    if (body.startsWith("- ")) body = body.substring(2).trim();
    body = TRAIL_DELIM.matcher(body).replaceFirst(" - ");
    
    // Split line into double dash delimited fields and process them
    String[] flds = body.split(" -+ ");
    if (INCIDENT_PTN.matcher(flds[0]).matches()) return false;
    return parseFields(flds, data);
  }
  private class Call2Field extends CallField {
    
    @Override
    public void parse(String field, Data data) {
      data.strCall = append(data.strCall, " - ", field);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL2")) return new Call2Field();
    return super.getField(name);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
}
