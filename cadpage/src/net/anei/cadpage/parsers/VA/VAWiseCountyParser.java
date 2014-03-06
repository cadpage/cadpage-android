package net.anei.cadpage.parsers.VA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Wise County, VA
 */

public class VAWiseCountyParser extends FieldProgramParser {
  public VAWiseCountyParser() {
    super("WISE COUNTY", "VA",
          "SRC CALL ADDR MAP UNIT INFO+");
  }
  
  @Override
  public String getFilter() {
    return "Spillman_Paging@911.com";
  }

  private static final String SOURCE_VAL_PATTERN_STRING = "[A-Z]{4}",
    MAP_VAL_PATTERN_STRING = "\\d{3}[A-Z]?",
    UNIT_VAL_PATTERN_STRING = "[A-Z]{4,5}|[A-Z]{3}\\d+",
    CALLID_VAL_PATTERN_STRING = "\\d{2}[A-Z]{3}\\d{4}";
  private static final Pattern RUN_REPORT_PATTERN
    = Pattern.compile("("+SOURCE_VAL_PATTERN_STRING+")\\n"
+                     "("+UNIT_VAL_PATTERN_STRING+")\\n"
+                     "("+CALLID_VAL_PATTERN_STRING+").*", Pattern.DOTALL);
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Message from HipLink"))
      return false;
    
    Matcher m = RUN_REPORT_PATTERN.matcher(body);
    if (m.matches()) {
      data.strCall = "RUN REPORT";
      data.strSource = m.group(1);
      data.strUnit = m.group(2);
      data.strCallId = m.group(3);
      data.strPlace = body;
      return true;
    }
    return parseFields(body.split("\n"), data);
  }
 
  @Override
  public Field getField(String name) {
    if (name.equals("SRC"))return new SourceField(SOURCE_VAL_PATTERN_STRING, true);
    if (name.equals("MAP")) return new MapField(MAP_VAL_PATTERN_STRING, true);
    if (name.equals("UNIT")) return new UnitField(UNIT_VAL_PATTERN_STRING, true);
    return super.getField(name);
  }
}
