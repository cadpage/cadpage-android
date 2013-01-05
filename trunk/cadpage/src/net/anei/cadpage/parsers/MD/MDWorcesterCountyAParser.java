package net.anei.cadpage.parsers.MD;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;



public class MDWorcesterCountyAParser extends DispatchOSSIParser {
 
  public MDWorcesterCountyAParser() {
    super(MDWorcesterCountyParser.CITY_LIST, "WORCESTER COUNTY", "MD",
    		   "SRC? CALL ADDR PLACE? CITY! X X INFO+ DATETIME!");
  }
  
  private static final Pattern SOURCE_PAT = Pattern.compile("[0-9]{1,2}00[A-Z]?|S[0-9]");
  private class MySourceField extends SourceField {
    public MySourceField() {
      setPattern(SOURCE_PAT);
    }
  }
  
  @Override
  protected Field getField(String name) {
    if (name.equals("SRC")) return new MySourceField();
    return super.getField(name);
  }
}
