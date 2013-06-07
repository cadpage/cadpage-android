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
           new PAMontgomeryCountyEParser(),
           new PAMontgomeryCountyFParser());
  }
  
  static final Properties CITY_CODES = buildCodeTable(new String[]{
      "ABGN", "ABINGTON TWP",
      "AMBL", "AMBLER",
      "BRYA", "BRYN ATHYN",
      "BUCO", "BUCKS COUNTY",
      "CHCO", "CHESTER COUNTY",
      "CHEL", "CHELTENHAM TWP",
      "ELPK", "ELKINS PARK",
      "HATB", "HATBORO",
      "HORS", "HORHAM TWP",
      "HTFB", "HATFIELD",
      "HTFT", "HATFIELD TWP",
      "JENK", "JENKINTOWN",
      "LAMT", "LA MOTT",
      "LANS", "LANSDALE",
      "LGWY", "LOWER GWYNEDD TWP",
      "LMER", "LOWER MERION TWP",
      "LMOR", "LOWER MORELAND TWP",
      "LMRK", "LIMERICK TWP",
      "MONT", "MONTGOMERY TWP",
      "NWAL", "NORTH WALES",
      "PLYM", "PLYMOUTH TWP",
      "RKLG", "ROCKLEDGE",
      "RYFD", "ROYERSFORD",
      "SPRG", "SPRINGFIELD TWP",
      "TWMC", "TOWAMENCIN TWP",
      "UDUB", "UPPER DUBLIN TWP",
      "UGWY", "UPPER GWYNEDD TWP",
      "UMOR", "UPPER MORELAND TWP",
      "UPRO", "UPPER PROVIDENCE TWP",
      "WHPN", "WHITPAIN TWP",
      "WORC", "WORCESTER TWP"
  });

}
