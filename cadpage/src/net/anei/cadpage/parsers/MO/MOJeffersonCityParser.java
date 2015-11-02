package net.anei.cadpage.parsers.MO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class MOJeffersonCityParser extends FieldProgramParser {

  private static final Pattern TRAIL_OPERATOR_PTN = Pattern.compile(" +[a-z]+$");
  public MOJeffersonCityParser() {
    super("JEFFERSON CITY", "MO",
          "CALL UNIT ADDR/S6! X INFO+");
    setupSaintNames("LOUIS");
    removeWords("X");
  }
  
  @Override
  public String getFilter() {
    return "paging@jeffcitymo.org";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_DIRO;
  }

  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("DONOTREPLY")) return false;
    Matcher match = TRAIL_OPERATOR_PTN.matcher(body);
    if (match.find()) body = body.substring(0,match.start());
    
    return parseFields(body.split("\n"), data);
  }
}
