package net.anei.cadpage.parsers.VA;

import java.util.Properties;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.dispatch.DispatchDAPROParser;

/**
 * Warren County, VA
 */
public class VAWarrenCountyParser extends DispatchDAPROParser {
  
  public VAWarrenCountyParser() {
    super(CITY_CODES, "WARREN COUNTY", "VA");
    setupCallList(CALL_SET);
  }
  
  @Override
  public String getFilter() {
    return "mailbox@warrencountysheriff.org";
  }
  
  private static final CodeSet CALL_SET = new CodeSet(
      "BREATHING DIFFICULTY",
      "CARDIC ARREST (CODE BLUE)",
      "CHANGE IN MENTAL STATUS",
      "DISORIENTED",
      "FALL/FRACTURE",
      "FIRE ALARM ACTIVATION",
      "MVA / UNKNOWN INJURY",
      "MVA / W/ ENTRAPMENT/ROLLOVER",
      "MVA / WITH INJURY"
  );
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
        "BEN", "BENTONVILLE",
        "FRO", "FRONT ROYAL",
        "LIN", "LINDEN"
    });
}