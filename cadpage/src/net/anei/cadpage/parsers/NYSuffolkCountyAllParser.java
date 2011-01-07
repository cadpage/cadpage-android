package net.anei.cadpage.parsers;

/*
 * Selects best parser from all of the Suffolk County, NY parsers
 */


public class NYSuffolkCountyAllParser extends GroupBestParser {
  
  public NYSuffolkCountyAllParser() {
    super(new SmsMsgParser[]{
        new NYSuffolkCountyAParser(),
        new NYSuffolkCountyBParser(),
        new NYSuffolkCountyCParser(),
        new NYDixHillsParser(),
        new NYAmherstParser()
    });
  }
}
