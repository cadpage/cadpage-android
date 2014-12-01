package net.anei.cadpage.parsers.KY;

public class KYHarrisonCountyParser extends KYStatePoliceParser {
  
  public KYHarrisonCountyParser() {
    super("HARRISON COUNTY");
  }
  
  @Override
  public String getLocName() {
    return "Harrison County, KY";
  }
}
