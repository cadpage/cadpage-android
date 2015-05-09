package net.anei.cadpage.parsers.OH;

import java.util.Properties;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;


public class OHLorainCountyAParser extends DispatchOSSIParser {

  public OHLorainCountyAParser() {
    super(CITY_CODES, "LORAIN COUNTY", "OH",
           "( CANCEL | FYI CALL ) ADDR! PLACE? CITY");
  }
  
  @Override
  public String getFilter() {
    return "cad@lorainco911.com,CAD@windstream.net";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (body.startsWith("CAD:") &&
        (subject.equals("FYI") || subject.equals("Update") || subject.equals("CANCEL"))) {
      body = "CAD:" +  subject + ": " + body.substring(4);
    }
    return super.parseMsg(body, data);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
     "CAR", "CARLISLE TWP",
     "EAT", "EATON"
  });
}
