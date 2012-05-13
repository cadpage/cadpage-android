package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA7BaseParser;

/*
Bucks County, PA
Base parser with methods needed by all Bucks COunty Parsers

 */


public class PABucksCountyBaseParser extends DispatchA7BaseParser {
  
  public PABucksCountyBaseParser(String program) {
    super(INIT_TOWN_CODE, TOWN_CODES, CITY_LIST, "BUCKS COUNTY", "PA", program);
  }
   
  
  @Override
  protected void parseAddress(StartType sType, int flags, String address, Data data) {
    address = cleanupAddress(address);
    super.parseAddress(sType, flags, address, data);
  }

  @Override
  protected void parseAddress(String address, Data data) {
    address = cleanupAddress(address);
    super.parseAddress(address, data);
  }

  /**
   * Clean dispatch typos and abbreviations in address
   * @param sAddr original address
   * @return cleaned up address
   */
  private String cleanupAddress(String sAddr) {
    // Clean up dispatch boo boos
    sAddr = sAddr.replace("FRIER RD", "FREIER RD");
    sAddr = sAddr.replace("WHITE BRIAR", "WHITEBRIAR");
    sAddr = expandStreet("COLD SPRING CREAMERY", sAddr);
    sAddr = expandStreet("FALLSINGTON TULLYTOWN", sAddr);
    return sAddr;
  }

  private static final int INIT_TOWN_CODE = 21;
  private static final String[] TOWN_CODES = new String[]{
  /*21*/ "BEDMINSTER TWP",
  /*22*/ "BENSALEM TWP",
  /*23*/ "BRIDGETON TWP",
  /*24*/ "BRISTOL",
  /*25*/ "BRISTOL TWP",
  /*26*/ "BUCKINGHAM TWP",
  /*27*/ "CHALFONT",
  /*28*/ "DOYLESTOWN",
  /*29*/ "DOYLESTOWN TWP",
  /*30*/ "",
  /*31*/ "DUBLIN",
  /*32*/ "DURHAM TWP",
  /*33*/ "EAST ROCKHILL",
  /*34*/ "FALLS TWP",
  /*35*/ "HAYCOCK TWP",
  /*36*/ "HILLTOWN TWP",
  /*37*/ "HULMEVILLE",
  /*38*/ "IVYLAND",
  /*39*/ "LANGHORNE",
  /*40*/ "",
  /*41*/ "LANGHORNE MANOR",
  /*42*/ "LOWER MAKEFIELD TWP",
  /*43*/ "LOWER SOUTHAMPTON TWP",
  /*44*/ "MIDDLETOWN TWP",
  /*45*/ "MILFORD TWP",
  /*46*/ "MORRISVILLE",
  /*47*/ "NEW BRITAIN",
  /*48*/ "NEW BRITAIN TWP",
  /*49*/ "NEW HOPE",
  /*50*/ "",
  /*51*/ "NEWTOWN",
  /*52*/ "NEWTOWN TWP",
  /*53*/ "NOCKAMIXON TWP",
  /*54*/ "NORTHAMPTON TWP",
  /*55*/ "PENNDEL",
  /*56*/ "PERKASIE",
  /*57*/ "PLUMSTEAD TWP",
  /*58*/ "QUAKERTOWN",
  /*59*/ "RICHLAND TWP",
  /*60*/ "",
  /*61*/ "RICHLANDTOWN",
  /*62*/ "RIEGELSVILLE",
  /*63*/ "SELLERSVILLE",
  /*64*/ "SILVERDALE",
  /*65*/ "SOLEBURY TWP",
  /*66*/ "SPRINGFIELD TWP",
  /*67*/ "TELFORD",
  /*68*/ "TINICUM TWP",
  /*69*/ "TRUMBAUERSVILLE",
  /*70*/ "",
  /*71*/ "TULLYTOWN",
  /*72*/ "UPPER MAKEFIELD TWP",
  /*73*/ "UPPER SOUTHAMPTON TWP",
  /*74*/ "WARMINSTER TWP",
  /*75*/ "WARRINGTON TWP",
  /*76*/ "WARWICK TWP",
  /*77*/ "WEST ROCKHILL TWP",
  /*78*/ "WRIGHTSTOWN TWP",
  /*79*/ "YARDLEY"
  };
  
  // City list is only used for out of county mutual aid calls
  private static final String[] CITY_LIST = new String[]{
    "MONTGOMERY TWP"
  };
}
