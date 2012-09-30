package net.anei.cadpage.parsers.VA;

import java.util.Properties;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/**
 * Prince George County, VA
 */
public class VAPrinceGeorgeCountyParser extends DispatchOSSIParser {
 
  public VAPrinceGeorgeCountyParser() {
    super(CITY_CODES, "PRINCE GEORGE COUNTY", "VA",
           "ID: CALL ADDR! X/Z+? CITY");
  }
  
  @Override
  public String getFilter() {
    return "cad@messages.princegeorgeva.org,cad@princegeorgeva.org";
  }

  private static final String AUTO_AID_PFX = "FIRE AUTOMATIC AID - ";
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith(AUTO_AID_PFX)) {
        data.strCity = field.substring(AUTO_AID_PFX.length()).trim();
        field = field.substring(0,AUTO_AID_PFX.length()-3).trim();
      }
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    return super.getField(name);
  }

  private static final Properties CITY_CODES= buildCodeTable(new String[]{
      "CARS", "CARSON",
      "PETE", "PETERSBURG"
  });
}
