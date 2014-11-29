package net.anei.cadpage.parsers.NC;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;



public class NCJacksonCountyParser extends DispatchSouthernParser {
  
  private static final Pattern GEN_ALERT_ADDRESS_PTN = Pattern.compile("(?:(?:NORTHERN|SOUTHERN|EASTERN|WESTERN) )?JACKSON CO(?:UNTY)?(?: WEATHER)?|UNIT +\\d+|\\d+ +BASE|.* FIRE DEPT|.* FD|1");
  
  
  public NCJacksonCountyParser() {
    super(CITY_LIST, "JACKSON COUNTY", "NC", DSFLAG_OPT_DISPATCH_ID | DSFLAG_LEAD_PLACE | DSFLAG_FOLLOW_CROSS);
    setupMultiWordStreets(
        "CAMP CR",
        "DEER RUN",
        "LAUREL KNOB"
    );
  }
  
  @Override
  public String getFilter() {
    return "Bill@mydomain.com,232@jacksonrescue.org";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_CR_CREEK;
  }
  

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (! super.parseMsg(body, data)) return false;
    
    if (data.strPlace.length() > 0 && isValidAddress(data.strPlace)) {
      data.strAddress = append(data.strAddress, " & ", data.strPlace);
      data.strPlace = "";
    }
    
    // Weather alerts show up as dispatched calls rather than general alerts
    if (data.strSupp.startsWith("WEATHER ") || GEN_ALERT_ADDRESS_PTN.matcher(data.strAddress).matches()) {
      data.strPlace = append(data.strCall, " ", data.strSupp);
      data.strCall = "GENERAL ALERT";
      data.strSupp = "";
    }
    return true;
  }


  private static final String[] CITY_LIST = new String[]{
    "BALSAM",
    "CASHIERS",
    "CULLOWHEE",
    "DILLSBORO",
    "FOREST HILLS",
    "GLENVILLE",
    "HIGHLANDS",
    "SAVANNAH",
    "SYLVA",
    "WEBSTER",
    "TUCKASEGEE",
    "WHITTIER",
    
    // Haywood County
    "MAGGIE VALLEY",
    
    // Transylvania County
    "SAPPHIRE"
    
  };

}
