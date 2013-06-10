package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;



public class MDWorcesterCountyAParser extends DispatchOSSIParser {
 
  public MDWorcesterCountyAParser() {
    super(MDWorcesterCountyParser.CITY_LIST, "WORCESTER COUNTY", "MD",
    		   "SRC? CALL ADDR PLACE? CITY! X X INFO+ DATETIME");
  }
  
  @Override
  protected Field getField(String name) {
    if (name.equals("SRC")) return new SourceField("[0-9]{1,2}00[A-Z]?|S[0-9]", true);
    return super.getField(name);
  }
}
