package net.anei.cadpage.parsers.NJ;

public class NJEssexCountyParser extends NJBergenCountyBParser {
  
  public NJEssexCountyParser() {
    super("ESSEX COUNTY", "NJ");
  }
  
  @Override
  public String getFilter() {
    return "@NCPD.local";
  }
}
