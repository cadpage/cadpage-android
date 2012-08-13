package net.anei.cadpage.parsers.PA;

import java.util.Properties;

import net.anei.cadpage.parsers.GroupBestParser;

/*
Montgomery county, Pa 
 */


public class PAMontgomeryCountyParser extends GroupBestParser {
  
  public PAMontgomeryCountyParser() {
    super(new PAMontgomeryCountyAParser(), 
           new PAMontgomeryCountyBParser(),
           new PAMontgomeryCountyCParser(),
           new PAMontgomeryCountyDParser());
  }
  
  static final Properties CITY_CODES = buildCodeTable(new String[]{
      "ABGN", "ABINGTON TWP",
      "AMBL", "AMBLER",
      "BRYA", "BRYN ATHYN",
      "BUCO", "BUCKS COUNTY",
      "CHEL", "CHELTENHAM TWP",
      "HATB", "HATBORO",
      "HORS", "HORHAM TWP",
      "JENK", "JENKINTOWN",
      "LGWY", "LOWER GWYNEDD TWP",
      "LMER", "LOWER MERION TWP",
      "LMOR", "LOWER MORELAND TWP",
      "PLYM", "PLYMOUTH TWP",
      "RKLG", "ROCKLEDGE",
      "SPRG", "SPRINGFIELD TWP",
      "UDUB", "UPPER DUBLIN TWP",
      "UGWY", "UPPER GWYNEDD TWP",
      "UMOR", "UPPER MORELAND TWP",
      "WHPN", "WHITPAIN TWP"
  });

}
