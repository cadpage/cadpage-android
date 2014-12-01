package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.GroupBestParser;
import net.anei.cadpage.parsers.MsgParser;

/*
 * Group of parsers required to process US/NY/FireRescueSystems
 */


public class NYSuffolkCountyBFIParser extends GroupBestParser {
  
  public NYSuffolkCountyBFIParser() {
    super(new MsgParser[]{
        new NYSuffolkCountyBParser(),
        new NYSuffolkCountyFParser(),
        new NYSuffolkCountyIParser()
    });
  }
}
