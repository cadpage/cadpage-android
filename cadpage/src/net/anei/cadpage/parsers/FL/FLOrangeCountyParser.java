package net.anei.cadpage.parsers.FL;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA37Parser;

public class FLOrangeCountyParser extends DispatchA37Parser {

  public FLOrangeCountyParser() {
    super("CALL#", CITY_LIST, "ORANGE COUNTY", "FL");
  }
  
  @Override
  public String getFilter() { 
    return "WinterParkFireDepartmentDispatch@cityofwinterpark.org"; 
  }

  @Override
  protected boolean parseMessageField(String field, Data data) {
    
    data.strSupp = field;
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{

      //CITIES
      
      "APOPKA",
      "BAY LAKE",
      "BELLE ISLE",
      "EDGEWOOD",
      "LAKE BUENA VISTA",
      "MAITLAND",
      "OCOEE",
      "ORLANDO",
      "WINTER GARDEN",
      "WINTER PARK"
      };
}
