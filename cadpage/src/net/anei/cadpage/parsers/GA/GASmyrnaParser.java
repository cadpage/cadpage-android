package net.anei.cadpage.parsers.GA;

import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;


public class GASmyrnaParser extends DispatchOSSIParser {
  
  public GASmyrnaParser() {
    super("SMYRNA", "GA",
           "SKIP CALL ADDR! X+? INFO+? ID");
  }
  
  @Override
  public String getFilter() {
    return "cad@ci.smyrna.ga.us";
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new IdField("\\d{4,}");
    return super.getField(name);
  }
}
