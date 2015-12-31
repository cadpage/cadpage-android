package net.anei.cadpage.parsers.KY;

import java.util.Properties;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA48Parser;

public class KYRockcastleCountyParser extends DispatchA48Parser {

  public KYRockcastleCountyParser() {
    super(CITY_LIST, "ROCKCASTLE COUNTY", "KY", FieldType.X,  A48_OPT_ONE_WORD_CODE);
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!super.parseMsg(subject, body, data)) return false;
    if (data.strCode.length() == 0) {
      String call = CALL_CODES.getProperty(data.strCall);
      if (call !=  null) {
        data.strCode = data.strCall;
        data.strCall = call;
      }
    }
    return true;
  }

  
  private static final Properties CALL_CODES = buildCodeTable(new String[]{
      "FIRER",      "FIRE RESIDENTIAL",
      "FIREA",      "FIRE ALARM",
      "CAVRES",     "CAVE RESCUE",
      "ACCI",       "ACCIDENT WITH INJURIES",
      "FIREO",      "FIRE OTHER",
      "FIREB",      "FIRE BRUSH",
      "FIREV",      "FIRE VEHICLE"
      
  });
    
  private static final String[] CITY_LIST = new String[]{

      "BRODHEAD",
      "LIVINGSTON",
      "MOUNT VERNON"
    
  };
}
