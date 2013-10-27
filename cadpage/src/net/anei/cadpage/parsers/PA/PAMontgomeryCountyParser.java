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
           new PAMontgomeryCountyFParser(),
           new PAMontgomeryCountyGParser());
  }
  
  public static final Properties CITY_CODES = buildCodeTable(new String[]{
      "ABGN", "ABINGTON TWP",
      "AMBL", "AMBLER",
      "BECO", "BERKS COUNTY",
      "BGPT", "BRIDGEPORT",
      "BRYA", "BRYN ATHYN",
      "BUCO", "BUCKS COUNTY",
      "CHCO", "CHESTER COUNTY",
      "CHEL", "CHELTENHAM TWP",
      "CLGV", "COLLEGEVILLE",
      "CONS", "CONSHOHOCKEN",
      "DECO", "DELAWARE COUNTY",
      "DGLS", "DOUGLASS TWP",
      "EGRN", "EAST GREENVILLE",
      "ELPK", "ELKINS PARK",
      "ENOR", "EAST NORRITON TWP",
      "FRCN", "FRANCONIA TWP",
      "GRLN", "GREEN LANE",
      "HATB", "HATBORO",
      "HORS", "HORSHAM TWP",
      "HTFB", "HATFIELD",
      "HTFT", "HATFIELD TWP",
      "JENK", "JENKINTOWN",
      "LAMT", "LA MOTT",
      "LANS", "LANSDALE",
      "LFRE", "LOWER FREDERICK TWP",
      "LGWY", "LOWER GWYNEDD TWP",
      "LMER", "LOWER MERION TWP",
      "LMOR", "LOWER MORELAND TWP",
      "LMRK", "LIMERICK TWP",
      "LPOT", "LOWER POTTSGROVE TWP",
      "LPRO", "LOWER PROVIDENCE TWP",
      "LSAL", "LOWER SALFORD TWP",
      "MARL", "MARLBOROUGH TWP",
      "MONT", "MONTGOMERY TWP",
      "MYTWN", "My Demo Town",
      "NARB", "NARBETH",
      "NHAN", "NEW HANOVER TWP",
      "NRSN", "NORRISTOWN",
      "NWAL", "NORTH WALES",
      "PNBG", "PENNSBURG",
      "PERK", "PERKIOMEN TWP",
      "PLYM", "PLYMOUTH TWP",
      "POTT", "POTTSTOWN",
      "RDHL", "RED HILL",
      "RKLG", "ROCKLEDGE",
      "RYFD", "ROYERSFORD",
      "SALF", "SALFORD TWP",
      "SCHW", "SCHWENKSVILLE",
      "SKPK", "SKIPPACK TWP",
      "SOUD", "SOUDERTON",
      "SPRG", "SPRINGFIELD TWP",
      "TLFD", "TELFORD",
      "TWMC", "TOWAMENCIN TWP",
      "TRPP", "TRAPP",
      "UDUB", "UPPER DUBLIN TWP",
      "UFRE", "UPPER FREDERICK TWP",
      "UGWY", "UPPER GWYNEDD TWP",
      "UHAN", "UPPER HANOVER TWP",
      "UMER", "UPPER MERION TWP",
      "UMOR", "UPPER MORELAND TWP",
      "UPOT", "UPPER POTTSGROVE TWP",
      "UPRO", "UPPER PROVIDENCE TWP",
      "USAL", "UPPER SALFORD",
      "WCON", "WEST CONSHOHOCKEN",
      "WNOR", "WEST NORRITON",
      "WPOT", "WEST POTTSGROVE",
      "WMSH", "WHITEMARSH TWP",
      "WHPN", "WHITPAIN TWP",
      "WORC", "WORCESTER TWP"

  });

}
