package net.anei.cadpage.parsers.VA;


import net.anei.cadpage.parsers.GroupBestParser;

/* Prince William County, VA */


public class VAPrinceWilliamCountyParser extends GroupBestParser {
  
  public VAPrinceWilliamCountyParser() {
    super(new VAPrinceWilliamCountyAParser(), new VAPrinceWilliamCountyBParser());
  }
}