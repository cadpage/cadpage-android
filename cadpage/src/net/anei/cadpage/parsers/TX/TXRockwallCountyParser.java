package net.anei.cadpage.parsers.TX;

/**
 * Rockwall County, TX
 */
public class TXRockwallCountyParser extends TXCollinCountyParser {

  public TXRockwallCountyParser() {
    super("ROCKWALL COUNTY", "TX");
  }
  
  @Override
  public String getFilter() {
    return "ics.gateway@wylietexas.gov";
  }
}
