package net.anei.cadpage.parsers.GA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class GADoughertyCountyParser extends FieldProgramParser {
  
  private static final Pattern MARKER = Pattern.compile("^(?:\\d{6} )?(\\d{15})/");
  
  public GADoughertyCountyParser() {
    super("DOUGHERTY COUNTY", "GA",
           "SKIP SKIP CALL ADDR CITY! PLACE? X X UNIT INFO+");
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    body = body.substring(match.end());
    data.strCallId = match.group(1);
    return parseFields(body.split("/"), data);
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }
}
