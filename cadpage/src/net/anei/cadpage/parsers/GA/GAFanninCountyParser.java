package net.anei.cadpage.parsers.GA;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;


public class GAFanninCountyParser extends DispatchB2Parser {

  public GAFanninCountyParser() {
    super("911-CENTER:", "FANNIN COUNTY", "GA");
    setupCallList(CALL_LIST);
    
  }
  
  @Override
  public String getFilter() {
    return "911-CENTER@mydomain.com";
  }  
   
  private static final CodeSet CALL_LIST = new CodeSet(
      
      "F1 RESIDENTIAL-FIRE",
      "F4 BRUSH,FIELD,GRASS,WOODS FIRE",
      "F5 CHIMNEY FIRE",
      "F6 VEHICLE FIRE",
      "F10 ELECTRICAL FIRE",
      "F13 EXPLOSION"      
  );

}
