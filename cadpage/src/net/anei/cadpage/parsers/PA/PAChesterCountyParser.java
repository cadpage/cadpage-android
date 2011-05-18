package net.anei.cadpage.parsers.PA;
import net.anei.cadpage.parsers.GroupBestParser;

/* 
 * Chester Country, PA
 */


public class PAChesterCountyParser extends GroupBestParser {
  
  public PAChesterCountyParser() {
    super(new PAChesterCountyAParser(), new PAChesterCountyBParser(), new PAChesterCountyCParser());
  }
} 
