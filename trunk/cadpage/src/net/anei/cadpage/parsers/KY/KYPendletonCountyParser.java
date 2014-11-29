package net.anei.cadpage.parsers.KY;

public class KYPendletonCountyParser extends KYStatePoliceParser {
  
  public KYPendletonCountyParser() {
    super("PENDLETON COUNTY");
  }
  
  @Override
  public String getLocName() {
    return "Pendleton County, KY";
  }
}
