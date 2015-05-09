package net.anei.cadpage.parsers.MS;

import net.anei.cadpage.parsers.GroupBestParser;


public class MSDeSotoCountyParser extends GroupBestParser {

  public MSDeSotoCountyParser() {
    super(new MSDeSotoCountyAParser(), new MSDeSotoCountyBParser());
  }
}
