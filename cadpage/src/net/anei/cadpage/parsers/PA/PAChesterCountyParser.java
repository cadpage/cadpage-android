package net.anei.cadpage.parsers.PA;
import net.anei.cadpage.parsers.GroupBestParser;

/* 
 * Chester Country, PA
 */


public class PAChesterCountyParser extends GroupBestParser {
  
  public PAChesterCountyParser() {
    super(new PAChesterCountyAParser(), 
          new PAChesterCountyBParser(), 
          new PAChesterCountyCParser(), 
          new PAChesterCountyD1Parser(),
          new PAChesterCountyD2Parser(), 
          new PAChesterCountyD3Parser(), 
          new PAChesterCountyD4Parser(), 
          new PAChesterCountyD5Parser(), 
          new PAChesterCountyEParser(),
          new PAChesterCountyFParser(),
          new PAChesterCountyGParser(),
          new PAChesterCountyHParser(),
          new PAChesterCountyIParser(),
          new PAChesterCountyJParser());
  }
} 
