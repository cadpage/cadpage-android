package net.anei.cadpage.parsers.IA;

import java.util.Properties;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

public class IAStoryCountyParser extends DispatchOSSIParser {
  
  public IAStoryCountyParser() {
    super(CITY_CODES, "STORY COUNTY", "IA", 
          "( CANCEL ADDR CITY! | FYI ADDR CITY CALL ) INFO+");
  }
  
  @Override
  public String getFilter() {
    return "CAD@storycom.org";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    body = "CAD:" + append(subject, ": ", body);
    return super.parseMsg(body, data);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "AMES", "AMES",
      "CAMB", "CAMBRIDGE",
      "COLL", "COLLINS",
      "COLO", "COLO",
      "GILB", "GILBERT",
      "HUXL", "HUXLEY",
      "KELL", "KELLY",
      "MAX",  "MAXWELL",
      "MCCA", "MCCALLSBURG",
      "NEVA", "NEVADA",
      "ROLA", "ROLAND",
      "SHEL", "SHELDAHL",
      "SLAT", "SLATER",
      "STOR", "STORY CITY",
      "ZEAR", "ZEARING"
  });
}
