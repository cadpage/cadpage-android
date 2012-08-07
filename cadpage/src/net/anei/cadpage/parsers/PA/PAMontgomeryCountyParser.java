package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.GroupBestParser;

/*
Montgomery county, Pa 
 */


public class PAMontgomeryCountyParser extends GroupBestParser {
  
  public PAMontgomeryCountyParser() {
    super(new PAMontgomeryCountyAParser(), 
           new PAMontgomeryCountyBParser(),
           new PAMontgomeryCountyCParser());
  }
}
