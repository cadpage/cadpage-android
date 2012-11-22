package net.anei.cadpage.parsers.PA;

import java.util.Properties;

import net.anei.cadpage.parsers.GroupBestParser;

/*
 * Montgomery county, Pa 
 */


public class PAMontgomeryCountyParser extends GroupBestParser {
  
  public PAMontgomeryCountyParser() {
    super(new PAMontgomeryCountyAParser(), 
           new PAMontgomeryCountyBParser(),
           new PAMontgomeryCountyCParser(),
           new PAMontgomeryCountyDParser(),
           new PAMontgomeryCountyEParser());
  }
  
  static final Properties CITY_CODES = buildCodeTable(new String[]{
      "ABGN", "ABINGTON TWP",
      "AMBL", "AMBLER",
      "BRYA", "BRYN ATHYN",
      "BUCO", "BUCKS COUNTY",
      "CHEL", "CHELTENHAM TWP",
      "HATB", "HATBORO",
      "HORS", "HORHAM TWP",
      "HTFB", "HATFIELD",
      "HTFT", "HATFIELD TWP",
      "JENK", "JENKINTOWN",
      "LANS", "LANSDALE",
      "LGWY", "LOWER GWYNEDD TWP",
      "LMER", "LOWER MERION TWP",
      "LMOR", "LOWER MORELAND TWP",
      "MONT", "MONTGOMERY TWP",
      "NWAL", "NORTH WALES",
      "PLYM", "PLYMOUTH TWP",
      "RKLG", "ROCKLEDGE",
      "SPRG", "SPRINGFIELD TWP",
      "TWMC", "TOWAMENCIN TWP",
      "UDUB", "UPPER DUBLIN TWP",
      "UGWY", "UPPER GWYNEDD TWP",
      "UMOR", "UPPER MORELAND TWP",
      "WHPN", "WHITPAIN TWP",
      "WORC", "WORCESTER TWP"
  });

}
