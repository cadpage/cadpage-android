package net.anei.cadpage.parsers.MO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class MOStLouisCountyCParser extends FieldProgramParser {
  
  private static final Pattern LAT_LONG_PTN = Pattern.compile("(38)(\\d{6}) +(\\d{2})(\\d{6})$");
  private static final Pattern SRC_UNIT_PTN = Pattern.compile("(?: +(SOUTH MAIN))? +([A-Z][a-z]+(?: +[A-Z]{2,3})?) \\[ ([A-Z0-9,]+)$");

  public MOStLouisCountyCParser() {
    super("ST LOUIS COUNTY", "MO", 
        "CALL! AT:ADDR! BUS:PLACE? XST:X!");
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
    
    // Pages come in two forms, a fixed field position version and a version apparently
    // derived from the fixed position version with all extra blanks removed.  We will try
    // the compressed version first, looking for a Camel case source name separted from
    // the units with a '[' separator
    match = SRC_UNIT_PTN.matcher(body);
    if (match.find()) {
      data.strChannel = getOptGroup(match.group(1));
      data.strSource = match.group(2).trim();
      data.strUnit = match.group(3).trim();
      body = body.substring(0,match.start());
      
      // Also, the compressed version drops the : from the AT: keyword :(
      int pt = body.indexOf(" AT ");
      if (pt >= 0) {
        body = body.substring(0,pt+3) + ":" + body.substring(pt+3);
      }
    }

    // For the fixed position version, we can grab the source and unit field
    // from fixed character positions in the text body
    // For the compressed version, the logic moves to the cross street field
    else if (body.length() >= 143 && body.charAt(127) != ' ' & body.charAt(142) != ' ') {
      data.strSource = substring(body,127,142);
      data.strUnit = substring(body,142);
      body = body.substring(0,127).trim();
    }
    
    // If neither pattern matches, we have a problem
    else return false;
    
    // Now we can call the superclass parseMsg method to handle everything else
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return super.getProgram() + " CH SRC UNIT GPS";
  }
}
