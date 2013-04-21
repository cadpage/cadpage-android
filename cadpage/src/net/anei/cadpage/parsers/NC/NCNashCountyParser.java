package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;


public class NCNashCountyParser extends SmartAddressParser {
  
  public NCNashCountyParser() {
    super(CITY_LIST, "NASH COUNTY", "NC");
    setFieldList("ADDR APT CITY CALL NAME UNIT");
  }
  
  @Override
  public String getFilter() {
    return "nash911@nashcountync.gov,9300";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    if (body.startsWith("/ ")) body = body.substring(2).trim();
    if (!body.startsWith("NASH911:")) return false;
    body = body.substring(8).trim();
    
    parseAddress(StartType.START_ADDR, body, data);
    String left = getLeft();
    if (left.length() == 0) return false;
    Parser p = new Parser(left.replace(" / ", "/"));
    data.strCall = p.get(' ');
    data.strUnit = p.getLast(' ');
    data.strName = cleanWirelessCarrier(p.get());
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{

      "BAILEY",
      "CASTALIA",
      "DORTCHES",
      "MIDDLESEX",
      "MOMEYER",
      "NASHVILLE",
      "RED OAK",
      "ROCKY MOUNT",
      "SPRING HOPE",
      "WHITAKERS",
      "BAILEY TWP",
      "BATTLEBORO TWP",
      "CASTALIA TWP",
      "COOPERS TWP",
      "DRY WELLS TWP",
      "FERRELLS TWP",
      "GRIFFINS TWP",
      "JACKSON TWP",
      "MANNINGS TWP",
      "NASHVILLE TWP",
      "NORTH WHITAKERS TWP",
      "OAK LEVEL TWP",
      "RED OAK TWP",
      "ROCKY MOUNT TWP",
      "SPRING HOPE TWP",
      "SOUTH WHITAKERS TWP",
      "STONY CREEK TWP"
  };
}
