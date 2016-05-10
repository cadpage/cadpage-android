package net.anei.cadpage.parsers.KS;

import net.anei.cadpage.parsers.GroupBestParser;

public class KSLabetteCountyParser extends GroupBestParser {
  
  public KSLabetteCountyParser() {
    super(new KSLabetteCountyAParser(), new KSLabetteCountyBParser());
  }

}
