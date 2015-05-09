package net.anei.cadpage.parsers.KY;

public class KYCarrollCountyParser extends KYStatePoliceParser {
  
  public KYCarrollCountyParser() {
    super("CARROLL COUNTY");
  }
  
  @Override
  public String getLocName() {
    return "Carroll County, KY";
  }
}
