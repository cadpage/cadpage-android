package net.anei.cadpage.parsers.SC;

import net.anei.cadpage.parsers.GroupBestParser;

/*
Charleston County, SC

 */


public class SCCharlestonCountyParser extends GroupBestParser {
  
  public SCCharlestonCountyParser() {
    super(new SCCharlestonCountyAParser(), new SCCharlestonCountyBParser());
  }
  
  @Override
  public String getFilter() {
    return "CDC_Dispatch@charlestoncounty.org";
  }
}
