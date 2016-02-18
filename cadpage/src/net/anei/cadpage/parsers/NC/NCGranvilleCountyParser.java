package net.anei.cadpage.parsers.NC;


import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;



public class NCGranvilleCountyParser extends DispatchSouthernParser {
  
  public NCGranvilleCountyParser() {
    super(CITY_LIST, "GRANVILLE COUNTY", "NC", 
           DSFLAG_DISPATCH_ID | DSFLAG_CROSS_NAME_PHONE | DSFLAG_LEAD_PLACE | DSFLAG_ID_OPTIONAL);
    setupCallList(CALL_LIST);
  }

  @Override
  public String getFilter() {
    return "@granvillecounty.org";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    if (NUMERIC.matcher(data.strCall).matches()) {
      data.strSupp = append(data.strCall, " ", data.strSupp);
      data.strCall = "";
    }
    return true;
  }

  private static final CodeSet CALL_LIST = new CodeSet(
      "ACCIDENT-FATALITY",
      "ACCIDENT-PERSONAL INJURY",
      "ACCIDENT-PROPERTY DAMAGE",
      "ACCIDENT UNKNOWN",
      "ALERT",
      "ALLERGIC REACTION",
      "CHEST PAINS",
      "CO2 MONITOR ACTIVATION",
      "DECEASED PERSON",
      "FALL (PERSON HAS FALLEN)",
      "FIRE ALARM",
      "FIRE ALARM KEYPAD FIRE",
      "FIRE ALARM PULL STATION ALARM",
      "FIRE (GRASS-WOODS)",
      "FIRE (OTHER/UNKNOWN)",
      "FIRE (STRUCTURE",
      "FIRE (STRUCTURE)",
      "FIRE (STRUCTURE) MUTUAL AID.",
      "FIRE (VEHICLE) RV ON FIRE",
      "OB CALL",
      "RESPIRATORY DISTRESS",
      "SHORTNESS OF BREATH",
      "SICK CALL",
      "STROKE",
      "UNCONSCIOUS PERSON",
      "UNKNOWN EMS CALL",
      "UNRESPONSIVE PERSON"
  );
  
  private static final String[] CITY_LIST = new String[]{
    
    // Cities and towns
    "BUTNER",
    "CREEDMOOR",
    "OXFORD",
    "STEM",
    "STOVALL",
    
    // Unincorporated communities
    "BEREA",
    "BRASSFIELD",
    "BRAGGTOWN",
    "BULLOCK",
    "CULBRETH",
    "GRISSOM",
    "LEWIS",
    "SHAKE RAG",
    "SHOOFLY",
    "TALLY HO",
    "WILTON",
    
    // Franklin County
    "FRANKLINTON",
    "WAKE FOREST",
    "YOUNGSVILLE"
    
  };
}