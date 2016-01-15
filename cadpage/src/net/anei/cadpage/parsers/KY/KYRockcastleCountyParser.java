package net.anei.cadpage.parsers.KY;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA48Parser;

public class KYRockcastleCountyParser extends DispatchA48Parser {

  public KYRockcastleCountyParser() {
    super(CITY_LIST, "ROCKCASTLE COUNTY", "KY", FieldType.X_NAME);
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!super.parseMsg(subject, body, data)) return false;
    data.strSource = data.strName;
    return true;
  }
  
  @Override
  public String getProgram() {
    return super.getProgram().replace("NAME", "SRC");
  }
    
  private static final String[] CITY_LIST = new String[]{

      "BRODHEAD",
      "LIVINGSTON",
      "MOUNT VERNON"
    
  };
}
