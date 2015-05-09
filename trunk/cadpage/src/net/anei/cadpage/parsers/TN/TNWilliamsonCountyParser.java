package net.anei.cadpage.parsers.TN;

import net.anei.cadpage.parsers.GroupBestParser;

public class TNWilliamsonCountyParser extends GroupBestParser {
  
  public TNWilliamsonCountyParser() {
    super(new TNWilliamsonCountyAParser(), new TNWilliamsonCountyBParser());
  }
}
