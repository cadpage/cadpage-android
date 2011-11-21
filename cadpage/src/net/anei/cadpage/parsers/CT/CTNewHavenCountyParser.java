package net.anei.cadpage.parsers.CT;

import net.anei.cadpage.parsers.GroupBestParser;

/*
New Haven County, CT

*/

public class CTNewHavenCountyParser extends GroupBestParser {
  
  public CTNewHavenCountyParser() {
    super(new CTNewHavenCountyAParser(), new CTNewHavenCountyBParser());
  }
}
