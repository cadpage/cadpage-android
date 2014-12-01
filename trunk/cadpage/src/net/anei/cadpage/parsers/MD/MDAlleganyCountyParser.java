package net.anei.cadpage.parsers.MD;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class MDAlleganyCountyParser extends FieldProgramParser {
  
  private static final Pattern MARKER = Pattern.compile("(\\d\\d:\\d\\d) #(\\d+) +");
  
  public MDAlleganyCountyParser() {
    super("ALLEGANY COUNTY", "MD",
           "ADDR/SC! BOX:BOX! DUE:UNIT!");
  }
  
  @Override
  public String getFilter() {
    return "acgov_911_cad@allconet.org";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (! subject.equals("CAD")) return false;
    
    do {
      Matcher match = MARKER.matcher(body);
      if (match.find()) {
        data.strTime = match.group(1);
        data.strCallId = match.group(2);
        body = body.substring(match.end());
        break;
      }
      
      if (body.startsWith("CT:")) {
        body = body.substring(3).trim();
        break;
      }
      
      return false;
      
    } while (false);
    
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return "TIME ID " + super.getProgram();
  }
}
