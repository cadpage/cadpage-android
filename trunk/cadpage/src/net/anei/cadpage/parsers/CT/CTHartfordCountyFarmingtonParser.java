package net.anei.cadpage.parsers.CT;


public class CTHartfordCountyFarmingtonParser extends CTNewHavenCountyBParser {
  
  public CTHartfordCountyFarmingtonParser() {
    super("HARTFORD COUNTY", "CT");
  }
  
  @Override
  public String getFilter() {
    return "pdpaging@farmington-ct.org,paging@cantonfireandems.org";
  }
}
