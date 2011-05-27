package net.anei.cadpage.parsers.DE;
import net.anei.cadpage.parsers.GroupBestParser;

/* 
 * Sussex County, DE
 */


public class DESussexCountyParser extends GroupBestParser {
  
  public DESussexCountyParser() {
    super(new DESussexCountyAParser(), new DESussexCountyBParser());
  }
} 
