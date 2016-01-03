package net.anei.cadpage.parsers.AL;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

public class ALJeffersonCountyGParser extends DispatchSouthernParser {
    
  public ALJeffersonCountyGParser() {
    super(CITY_LIST, "JEFFERSON COUNTY", "AL",
          "ADDR/S APT EMPTY EMPTY EMPTY UNIT ID TIME CALL! INFO+");
     
  }
  
  private static final Pattern OCA_PTN = Pattern.compile("\\bOCA: *[\\d-]+$");
      
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    Matcher match = OCA_PTN.matcher(body);
    if (match.find()) body = body.substring(0,match.start()).trim();
    if (!super.parseMsg(body, data)) return false;
    if (data.strCity.equalsIgnoreCase("UNINCORPORATED")) data.strCity = "";
    return true;
  }

  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new IdField("\\d{6}-\\d{6}");
    return super.getField(name);
  }
 
  private static final String[] CITY_LIST = new String[]{
      //Cities
      "ADAMSVILLE",
      "BESSEMER",
      "BIRMINGHAM",
      "BRIGHTON",
      "CENTER POINT",
      "CLAY",
      "FAIRFIELD",
      "FULTONDALE",
      "GARDENDALE",
      "GRAYSVILLE",
      "HELENA",
      "HOMEWOOD",
      "HOOVER",
      "HUEYTOWN",
      "IRONDALE",
      "KIMBERLY",
      "LEEDS",
      "LIPSCOMB",
      "MIDFIELD",
      "MOUNTAIN BROOK",
      "PINSON",
      "PLEASANT GROVE",
      "SUMITON",
      "TARRANT",
      "TRUSSVILLE",
      "VESTAVIA HILLS",
      "WARRIOR",

      //Towns
      "ARGO",
      "BROOKSIDE",
      "CARDIFF",
      "COUNTY LINE",
      "MAYTOWN",
      "MORRIS",
      "MULGA",
      "NORTH JOHNS",
      "SYLVAN SPRINGS",
      "TRAFFORD",
      "WEST JEFFERSON",

      //Census-designated places
      "CHALKVILLE",
      "CONCORD",
      "EDGEWATER",
      "FORESTDALE",
      "GRAYSON VALLEY",
      "MCDONALD CHAPEL",
      "MINOR",
      "MOUNT OLIVE",
      "ROCK CREEK",

      //Unincorporated communities

      "ADGER",
      "ALTON",
      "COALBURG",
      "CORNER",
      "CRUMLEY CHAPEL",
      "DOCENA",
      "DOLOMITE",
      "FLAT TOP",
      "HOPEWELL",
      "KIMBRELL",
      "MCCALLA",
      "NEW CASTLE",
      "PALMERDALE",
      "SAYRE",
      "SHANNON",
      "WATSON",
 
      "UNINCORPORATED"
  };

}
