package net.anei.cadpage.parsers.CO;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Jefferson County, CO
 */
public class COJeffersonCountyParser extends FieldProgramParser {
  
  private static final Pattern RUN_REPORT_PTN = Pattern.compile("Alarm .*DISP:.*ENR:.*SCN:.*CLR:.*");
  

  public COJeffersonCountyParser() {
    super("Jefferson County", "CO",
        "Add:ADDR! Apt:APT? Type:CALL! Pg:MAP! Cross:X? Units:UNIT? Radio:CH? Case#:ID!");
   }

  @Override
  public String getFilter() {
    return "@c-msg.net";
  }
  
  @Override 
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.endsWith("WRCAD")) return false; 
    if (RUN_REPORT_PTN.matcher(body).matches()) {
      data.strCall = "RUN REPORT";
      data.strPlace = body;
      return true;
    }
    
    body = body.replace("Radio:", " Radio:").replace(" Pg", " Pg:").replace(" Map Pg:", " Pg:").replace("Alarm#", " Case#:");
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return super.getProgram() + " PLACE";
  }
}
  





