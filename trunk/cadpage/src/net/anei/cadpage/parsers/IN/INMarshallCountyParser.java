package net.anei.cadpage.parsers.IN;

import java.util.Properties;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

public class INMarshallCountyParser extends DispatchOSSIParser {
  
  public INMarshallCountyParser() {
    super(CITY_CODES, "MARSHALL COUNTY", "IN",
           "SKIP PLACE? ADDR/Z CITY X/Z+? CALL! END DATETIME");
  }
  
  @Override
  public String getFilter() {
    return "cad@co.marshall.in.us";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (body.startsWith("Update: ;") || body.startsWith("FYI: ;")) {
      body = "CAD:" + body;
    } 
    return super.parseMsg(body, data);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "ARGO", "ARGOS",
      "BOUR", "BOURBON",
      "BREM", "BREMEN",
      "CULV", "CULVER",
      "DONA", "DONALDSON",
      "LAPA", "LAPAZ",
      "PLYM", "PLYMOUTH",
      "TIPP", "TIPPECANOE",
      "TYNE", "TYNER",
      
      "ETNA", "ETNA GREEN",
      "GROV", "GROVERTOWN",
      "KNOX", "KNOX",
      "LAKE", "LAKEVILLE",
      "MENT", "MENTONE",
      "NAPP", "NAPPANEE",
      "ROCH", "ROCHESTER",
      "WALK", "WALKERTON",
  });
}
