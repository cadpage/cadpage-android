package net.anei.cadpage.parsers.PA;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchBParser;

/*
Fayette County, Pennsylvania
Contact: Michael Wystepek <mjwystepek@gmail.com>
Sender: FAYETTE-911@fcema.org
FAYETTE-911:FACINJ>F-ACCIDENT W/ INJURIES VANCES MILL RD NORTH UNION WILSON PAUL 7249637757 Map: Grids:, Cad: 2011-0000029638
FAYETTE-911:ESCK_A>E SICK/UNKNOWN ALS 570 FLATWOODS RD XS: TOWN COUNTRY RD FRANKLIN ADAMS, J 7243980234 Map: Grids:, Cad: 2011-0000031363
FAYETTE-911:FACCNO>F_ACCIDENT NO INJURIES 1829 PITTSBURGH RD XS: RESERVOIR RD FRANKLIN HARPER, FRAN 4126910370 Map: Grids:, Cad: 2011-0000029521
FAYETTE-911:FACINJ>F-ACCIDENT W/ INJURIES 2418 PITTSBURGH RD XS: RESERVOIR RD & BRADY LN FRANKLIN CHRIS 3046855898 Map: Grids:, Cad: 2011-0000029569
FAYETTE-911:EBRT_A>E_BREATHING ALS 1829 PITTSBURGH RD XS: RESERVOIR RD FRANKLIN DELBRIDGE JOY 7247106364 Map: Grids:, Cad: 2011-0000030505
FAYETTE-911:FACINJ>F-ACCIDENT W/ INJURIES BOLDEN RD XS: COOPER RD & PITTSBURGH RD FRANKLIN HIGGNS ERENST 7245526428 Cad: 2011-0000030796
FAYETTE-911:EBRT_A>E_BREATHING ALS 2527 PITTSBURGH RD FRANKLIN JOHNSON JULIE 7244157363 Map: Grids:, Cad: 2011-0000030936
FAYETTE-911:FTREE >F_TREE DOWN BUENA VISTA RD XS: FLATWOODS RD FRANKLIN THOMPSON KAREN 7248800052 Map: Grids:, Cad: 2011-0000031144
FAYETTE-911:FTREE >F_TREE DOWN BITNER RD XS: VANCES MILL RD & ROUND BARN RD FRANKLIN VERIZON WIRELESS 7248808596 Map: Grids:, Cad: 2011-0000031156

*/

public class PAFayetteCountyParser extends DispatchBParser {
  
  private static final String[] CITY_LIST = new String[]{
    "CONNELLSVILLE",
    "UNIONTOWN",

    "BELLE VERNON",
    "BROWNSVILLE",
    "DAWSON",
    "DUNBAR",
    "EVERSON",
    "FAIRCHANCE",
    "FAYETTE CITY",
    "MARKLEYSBURG",
    "MASONTOWN",
    "NEWELL",
    "OHIOPYLE",
    "PERRYOPOLIS",
    "POINT MARION",
    "SEVEN SPRINGS",
    "SMITHFIELD",
    "SOUTH CONNELLSVILLE",
    "VANDERBILT",
  
    "BROWNSVILLE TWP",
    "BULLSKIN",
    "CONNELLSVILLE TWP",
    "DUNBAR TWP",
    "FRANKLIN",
    "GEORGES",
    "GERMAN",
    "HENRY CLAY",
    "JEFFERSON",
    "LOWER TYRONE",
    "LUZERNE",
    "MENALLEN",
    "NICHOLSON",
    "NORTH UNION",
    "PERRY",
    "REDSTONE",
    "SALTLICK",
    "SOUTH UNION",
    "SPRINGFIELD",
    "SPRINGHILL",
    "STEWART",
    "UPPER TYRONE",
    "WASHINGTON",
    "WHARTON"
  };
  
  private static Set<String> TOWNSHIPS = new HashSet<String>(Arrays.asList(new String[]{
      "BULLSKIN",
      "FRANKLIN",
      "GEORGES",
      "GERMAN",
      "HENRY CLAY",
      "JEFFERSON",
      "LOWER TYRONE",
      "LUZERNE",
      "MENALLEN",
      "NICHOLSON",
      "NORTH UNION",
      "PERRY",
      "REDSTONE",
      "SALTLICK",
      "SOUTH UNION",
      "SPRINGFIELD",
      "SPRINGHILL",
      "STEWART",
      "UPPER TYRONE",
      "WASHINGTON",
      "WHARTON"
  })); 

  public PAFayetteCountyParser() {
    super(CITY_LIST, "FAYETTE COUNTY", "PA");
  }
  
  @Override
  public String getFilter() {
    return "FAYETTE-911@fcema.org";
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return body.startsWith("FAYETTE-911:");
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    
    // Dispatch doesn't usually add a TWP to townships, but Google insists on it
    if (TOWNSHIPS.contains(data.strCity.toUpperCase())) data.strCity += " TWP";
    return true;
  }
}
