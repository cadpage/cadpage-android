package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA10Parser;


public class OHAshtabulaCountyParser extends DispatchA10Parser {

  public OHAshtabulaCountyParser() {
    super(CITY_LIST, "ASHTABULA COUNTY", "OH",
           "( UNIT ADDR CITY ST X+? CALL! | CALL ADDR/S X!+? INFO+ )");
  }
  
  @Override
  public String getFilter() {
    return "Sheriffadmin@ashtabulacounty.us";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    if (!super.parseMsg(body, data)) return false;
    
    if (data.strCity.endsWith(" TWP")) {
      data.strCity = data.strCity.substring(0,data.strCity.length()-4).trim();
    }
    return true;
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("UNIT")) return new UnitField("\\d{2}", true);
    if (name.equals("ST")) return new StateField("([A-Z]{2})(?: +\\d{5})?", true);
    if (name.equals("CALL")) return new MyCallField();
    return super.getField(name);
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      if (field.length() == 0) field = "ALERT";
      super.parse(field, data);
    }
  }

  private static final String[] CITY_LIST = new String[]{

    // Cities
    "ASHTABULA",
    "CONNEAUT",
    "GENEVA",
    
    // Vilages
    "ANDOVER",
    "GENEVA-ON-THE-LAKE",
    "JEFFERSON",
    "NORTH KINGSVILLE",
    "ORWELL",
    "ROAMING SHORES",
    "ROCK CREEK",

    // Townships
    "ANDOVER TWP",
    "ASHTABULA TWP",
    "AUSTINBURG TWP",
    "CHERRY VALLEY TWP",
    "COLEBROOK TWP",
    "DENMARK TWP",
    "DORSET TWP",
    "GENEVA TWP",
    "HARPERSFIELD TWP",
    "HARTSGROVE TWP",
    "JEFFERSON TWP",
    "KINGSVILLE TWP",
    "LENOX TWP",
    "MONROE TWP",
    "MORGAN TWP",
    "NEW LYME TWP",
    "ORWELL TWP",
    "PIERPONT TWP",
    "PLYMOUTH TWP",
    "RICHMOND TWP",
    "ROME TWP",
    "SAYBROOK TWP",
    "SHEFFIELD TWP",
    "TRUMBULL TWP",
    "WAYNE TWP",
    "WILLIAMSFIELD TWP",
    "WINDSOR TWP",

    // Townships with suffix
    "ANDOVER",
    "ASHTABULA",
    "AUSTINBURG",
    "CHERRY VALLEY",
    "COLEBROOK",
    "DENMARK",
    "DORSET",
    "GENEVA",
    "HARPERSFIELD",
    "HARTSGROVE",
    "JEFFERSON",
    "KINGSVILLE",
    "LENOX",
    "MONROE",
    "MORGAN",
    "NEW LYME",
    "ORWELL",
    "PIERPONT",
    "PLYMOUTH",
    "RICHMOND",
    "ROME",
    "SAYBROOK",
    "SHEFFIELD",
    "TRUMBULL",
    "WAYNE",
    "WILLIAMSFIELD",
    "WINDSOR",
    
    // Census designated places
    "EDGEWOOD",
    
    // Other communities
    "AUSTINBURG",
    "DORSET",
    "EAGLEVILLE",
    "FOOTVILLE",
    "KINGSVILLE",
    "PIERPONT",
    "UNIONVILLE"
  };
}
