package net.anei.cadpage.parsers.MI;

import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.GroupBestParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class MIInghamCountyParser extends GroupBestParser {
  
  public MIInghamCountyParser() {
    super(new MIInghamCountyAParser(), new MIInghamCountyBParser());
  }
  
}
