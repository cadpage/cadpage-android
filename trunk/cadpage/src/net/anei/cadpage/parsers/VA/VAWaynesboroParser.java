package net.anei.cadpage.parsers.VA;


public class VAWaynesboroParser extends VAAugustaCountyParser {
  
  public VAWaynesboroParser() {
    super("WAYNESBORO", "VA");
  }
  
  @Override
  public String getFilter() {
    return "@ci.waynesboro.va.us";
  }
}


