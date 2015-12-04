package net.anei.cadpage.parsers.VA;

import java.util.Properties;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

public class VAStauntonParser extends DispatchOSSIParser {
  
  public VAStauntonParser() {
    super("STAUNTON", "VA", 
          "ADDR CITY CALL! INFO+");
    setupGpsLookupTable(GPS_LOOKUP_TABLE);
  }
  
  @Override
  public String getFilter() {
    return "CAD@staunton.net";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Text Message")) return false;
    return super.parseMsg("CAD:" + body, data);
  }
  
  private static final Properties GPS_LOOKUP_TABLE = buildCodeTable(new String[]{
      "208 ACADEMY ST",       "38.1524844007,-79.0704670340",
      "312 ACADEMY ST",       "38.1539707942,-79.0692253053",
      "316 ACADEMY ST",       "38.1544298321,-79.0688011676",
      "138 N COALTER ST",     "38.1521710943,-79.0680524827",
      "140 N COALTER ST",     "38.1521081405,-79.0680128798",
      "146 N COALTER ST",     "38.1522333470,-79.0678088173",
      "172 N COALTER ST",     "38.1531327394,-79.0675502925",
      "204 N COALTER ST",     "38.1534113961,-79.0672809454",
      "220 N COALTER ST",     "38.1556251307,-79.0662680630",
      "301 DEMING DR",        "38.1551023436,-79.0686859803",
      "315 DEMING DR",        "38.1548948326,-79.0683188662",
      "101 E FREDERICK ST",   "38.1510740714,-79.0714421778",
      "115 E FREDERICK ST",   "38.1512924511,-79.0710483223",
      "201 E FREDERICK ST",   "38.1512356265,-79.0702984035",
      "215 E FREDERICK ST",   "38.1512040225,-79.0696236938",
      "227 E FREDERICK ST",   "38.1514265332,-79.0690213905",
      "218 HUNT DR",          "38.1520663205,-79.0703725263",
      "234 HUNT DR",          "38.1520894826,-79.0694628283",
      "219 KABLE ST",         "38.1534502623,-79.0675657289",
      "227 KABLE ST",         "38.1542291945,-79.0681777015",
      "240 KABLE ST",         "38.1537310655,-79.0687216267",
      "110 N MARKET ST",      "38.1521061270,-79.0710789934",
      "120 N MARKET ST",      "38.1523986730,-79.0710420861",
      "201 N MARKET ST",      "38.1529135597,-79.0706853659",
      "209 N MARKET ST",      "38.1531364680,-79.0706603675",
      "215 N MARKET ST",      "38.1532805093,-79.0706697553",
      "221 N MARKET ST",      "38.1535291432,-79.0706811816",
      "121 N NEW ST",         "38.1513899030,-79.0715461939",
      "209 N NEW ST",         "38.1520026656,-79.0716356992",
      "221 N NEW ST",         "38.1524357351,-79.0716932193",
      "303 N NEW ST",         "38.1528198087,-79.0717580884",
      "224 POINTS ST",        "38.1550235093,-79.0697057962",
      "321 POINTS ST",        "38.1531414941,-79.0702329039",
      "228 PROSPECT ST",      "38.1543809293,-79.0691128001",
      "314 PROSPECT ST",      "38.1549783949,-79.0680139393",
      "318 PROSPECT ST",      "38.1552730918,-79.0680579141",
      "361 PROSPECT ST",      "38.1558278821,-79.0679776624",
      "233 SYCAMORE ST",      "38.1524966155,-79.0683446288",
      "237 SYCAMORE ST",      "38.1524339156,-79.0686828688",
      "242 SYCAMORE ST",      "38.1521412059,-79.0685748697",
      "245 SYCAMORE ST",      "38.1524494713,-79.0695824682",
      "249 SYCAMORE ST",      "38.1524710225,-79.0699475973",
      "128 TAMS ST",          "38.1563171978,-79.0682174385",
      "100 TULLIDGE DR",      "38.1556926300,-79.0699533910",
      "108 KING DR",          "38.1519712558,-79.0713372632",
      "109 KING DR",          "38.1522256661,-79.0712496087",
      "1125 WESTMORELAND DR", "38.1561770998,-79.0674897820"
      

  });
}
