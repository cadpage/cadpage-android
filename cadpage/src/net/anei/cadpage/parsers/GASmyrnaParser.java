package net.anei.cadpage.parsers;


public class GASmyrnaParser extends DispatchAParser {
  
  public GASmyrnaParser() {
    setDefaults("SMYRNA", "GA");
  }
  
  @Override
  public String getFilter() {
    return "cad@ci.smyrna.ga.us";
  }
}
