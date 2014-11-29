package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.dispatch.DispatchA19Parser;


public class OHDarkeCountyParser extends DispatchA19Parser {

  public OHDarkeCountyParser() {
    super("DARKE COUNTY", "OH");
  }
  
  @Override
  public String getFilter() {
    return "rroberts@darkecountysheriff.org,pidle@jaghealthcare.com,bstump@jaghealthcare.com";
  }
}
