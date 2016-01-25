package net.anei.cadpage.parsers.AL;

import net.anei.cadpage.parsers.GroupBestParser;
import net.anei.cadpage.parsers.GroupBlockParser;


public class ALJeffersonCountyParser extends GroupBestParser {
  
  public ALJeffersonCountyParser() {
    super(new ALJeffersonCountyBParser(), 
          new ALJeffersonCountyCParser(), new ALJeffersonCountyDParser(),
          new ALJeffersonCountyEParser(), new ALJeffersonCountyFParser(),

          // The ALJeffersionCountyA parser is highly promiscuous
          // so we only check it after everything else has been tried
          new GroupBlockParser(),         new ALJeffersonCountyAParser(),
          new ALJeffersonCountyGParser());
  }
}
