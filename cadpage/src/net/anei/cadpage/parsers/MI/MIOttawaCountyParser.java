package net.anei.cadpage.parsers.MI;

import java.util.Properties;

import net.anei.cadpage.parsers.CodeTable;
import net.anei.cadpage.parsers.dispatch.DispatchA5Parser;


public class MIOttawaCountyParser extends DispatchA5Parser {
  

  public MIOttawaCountyParser() {
    super(CITY_ABBRV, CALL_CODES, "OTTAWA COUNTY", "MI");
  }
  
  @Override
  public String getFilter() {
    return "@OCCDA.ORG";
  }
  
  private static Properties CITY_ABBRV = buildCodeTable(new String[]{
      "HollandCit", "Holland"
  });
  
  private static final CodeTable CALL_CODES = new CodeTable(
        "", ""

  );
  
}
