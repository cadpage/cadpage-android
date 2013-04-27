package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.CodeSet;
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
    left = left.replace(" / ", "/");
    Parser p;
    String call = CALL_SET.getCode(left);
    if (call != null) {
      p = new Parser(left.substring(call.length()).trim());
    } else {
      p = new Parser(left);
      call = p.get(' ');
    }
    data.strCall = call;
    data.strUnit = p.getLast(' ');
    data.strName = cleanWirelessCarrier(p.get());
    return true;
  }
  
  private static final CodeSet CALL_SET = new CodeSet(
      "GAS LEAK",
      "MVA PI-H"
  );
  
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
      "BAILEY",
      "BATTLEBORO",
      "CASTALIA",
      "COOPERS",
      "DRY WELLS",
      "FERRELLS",
      "GRIFFINS",
      "JACKSON",
      "MANNINGS",
      "NASHVILLE",
      "NORTH WHITAKERS",
      "OAK LEVEL",
      "RED OAK",
      "ROCKY MOUNT",
      "SPRING HOPE",
      "SOUTH WHITAKERS",
      "STONY CREEK"
  };
}
