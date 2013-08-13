package net.anei.cadpage.parsers.MO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class MOStLouisCountyCParser extends FieldProgramParser {
  
  private static final Pattern LAT_LONG_PTN = Pattern.compile("(38)(\\d{6}) +(\\d{2})(\\d{6})$");

  public MOStLouisCountyCParser() {
    super("ST LOUIS COUNTY", "MO", 
        "CALL! AT:ADDR! XST:X!");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@cce911.org";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {

    if (!subject.equals("Cad Page")) return false;
    
    Matcher match = LAT_LONG_PTN.matcher(body);
    if (match.find()) {
      setGPSLoc(match.group(1)+'.'+match.group(2)+','+match.group(3)+'.'+match.group(4), data);
      body = body.substring(0,match.start()).trim();
    }
    
    if (body.length() < 143) return false;
    if (body.charAt(127) == ' ') return false;
    if (body.charAt(142) == ' ') return false;
    data.strSource = substring(body,127,142);
    data.strUnit = substring(body,142);
    body = body.substring(0,127).trim();
    
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return super.getProgram() + " SRC UNIT GPS";
  }
}
