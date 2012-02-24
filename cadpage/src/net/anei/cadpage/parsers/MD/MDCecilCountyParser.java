package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.GroupBestParser;

/*    
 Cecil County, MD
 
 */

public class MDCecilCountyParser extends GroupBestParser {
  
  public MDCecilCountyParser() {
    super(new MDCecilCountyAParser(),
           new MDCecilCountyBParser());
  }
  
}
