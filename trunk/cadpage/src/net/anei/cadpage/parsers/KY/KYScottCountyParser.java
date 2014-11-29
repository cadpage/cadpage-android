package net.anei.cadpage.parsers.KY;

public class KYScottCountyParser extends KYStatePoliceParser {
  
  public KYScottCountyParser() {
    super("SCOTT COUNTY");
  }
  
  @Override
  public String getLocName() {
    return "Scott County, KY";
  }
}
