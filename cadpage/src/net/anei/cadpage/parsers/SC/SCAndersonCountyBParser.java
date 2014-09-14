package net.anei.cadpage.parsers.SC;

import net.anei.cadpage.parsers.dispatch.DispatchA48Parser;

/**
 * Anderson County, SC (B) 
 */
public class SCAndersonCountyBParser extends DispatchA48Parser {
  
  public SCAndersonCountyBParser() {
    super(SCAndersonCountyAParser.CITY_LIST, "ANDERSON COUNTY", "SC", FieldType.DATE_TIME_INFO, A48_ONE_WORD_CODE);
    setupProtectedNames("SIX AND TWENTY");
  }
}
