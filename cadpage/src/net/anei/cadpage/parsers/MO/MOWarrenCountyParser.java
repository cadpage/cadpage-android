package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchGlobalDispatchParser;



public class MOWarrenCountyParser extends DispatchGlobalDispatchParser {
  
  public MOWarrenCountyParser() {
    super(CITY_TABLE, "WARREN COUNTY", "MO", DispatchGlobalDispatchParser.PLACE_FOLLOWS_ADDR);
    setupMultiWordStreets("REVEREND THOMAS S HIGGINS",
                          "ST FRANCIS");
  }
  
  @Override
  public String getFilter() {
    return " warrencounty911@warrencounty911.org";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    if(!subject.equals("Dispatch")) return false;
    
    body = body.replace("\n", ". ");
    
    return super.parseMsg(subject, body, data);
    
  }
  
  private static final String[] CITY_TABLE = new String[]{
    "ASPENHOFF",
    "DUTZOW",
    "FORISTELL",
    "INNSBROOK",
    "MARTHASVILLE",
    "MINDEN",
    "PENDLETON",
    "TRELOAR",
    "TRUESDALE",
    "WARRENTON",
    "WRIGHT CITY",
    
    // Lincoln County
    "HAWK POINT"
  };
}
