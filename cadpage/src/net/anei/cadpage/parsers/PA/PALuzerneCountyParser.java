package net.anei.cadpage.parsers.PA;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchA41Parser;

public class PALuzerneCountyParser extends DispatchA41Parser {

  public PALuzerneCountyParser() {
    super(CITY_CODES, "LUZERNE COUNTY", "PA");
  }
  
  @Override
  public String getFilter() {
    return "CADDispatch@LuzerneCounty.org,";
  }

  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "10",   "BEAR CREEK VILLAGE",
      "11",   "ASHLEY",
      "12",   "AVOCA",
      "13",   "BEAR CREEK TWP",
      "15",   "BUCK TWP",
      "16",   "BUTLER TWP",
      "18",   "CONYNGHAM TWP",
      "19",   "COURTDALE",
      "1901", "HAZLE TWP",
      "21",   "DALLAS",
      "22",   "DALLAS TWP",
      "23",   "DENNISON TWP",
      "25",   "DUPONT",
      "2501", "HAZLE TWP",
      "26",   "DURYEA",
      "27",   "EDWARDSVILLE",
      "28",   "EXETER",
      "2801", "HAZLE TWP",
      "29",   "EXETER TWP",
      "31",   "FAIRMOUNT TWP",
      "33",   "FORTY FORT",
      "34",   "FOSTER TWP",
      "3401", "HAZLE TWP",
      "35",   "FRANKLIN TWP",
      "36",   "FREELAND",
      "37",   "HANOVER TWP",
      "38",   "HARVEYS LAKE",
      "39",   "HAZLETON CITY",
      "41",   "HAZLE TWP",
      "43",   "HUGHESTOWN",       // New
      "44",   "HUNLOCK TWP",
      "46",   "JACKSON TWP",
      "4601", "HAZLE TWP",
      "48",   "JENKINS TWP",
      "49",   "KINGSTON",
      "51",   "KINGSTON TWP",
      "52",   "LAFLIN",
      "53",   "LAKE TWP",
      "54",   "LARKSVILLE",
      "5401", "HAZLE TWP",
      "56",   "LEHMAN TWP",
      "57",   "LUZERNE",
      "58",   "NANTICOKE CITY",
      "60",   "PENN LAKE PARK",
      "63",   "NEWPORT TWP",    // New
      "65",   "PITTSTON CITY",
      "66",   "PITTSTON TWP",
      "67",   "PLAINS TWP",
      "68",   "PLYMOUTH",
      "69",   "PLYMOUTH TWP",
      "71",   "PRINGLE",
      "72",   "RICE TWP",
      "73",   "ROSS TWP",
      "7301", "HAZLE TWP",
      "74",   "BERWICK",       // New
      "79",   "SWOYERSVILLE",
      "81",   "UNION TWP",
      "83",   "WEST HAZLETON",
      "84",   "WEST PITTSTON",
      "85",   "WEST WYOMING",
      "86",   "WHITE HAVEN",
      "87",   "WILKES BARRE CITY",
      "88",   "WILKES BARRE TWP",
      "89",   "WRIGHT TWP",
      "91",   "WYOMING",
      "9101", "HAZLE TWP",
      "93",   "EAST SIDE",
      "94",   "MONROE TWP",
      
      // Carbon County
      "WEATHERLY",       "WEATHERLY",
      
      // Columbia County
      "BERWICK",         "BERWICK",
      "BRIAR CREEK",     "BRIAR CREEK",
      
      // Lackawanna County
      "MOOSIC",          "MOOSIC",
      "OLDFORGE",        "OLD FORGE",
      "OLD FORGE",       "OLD FORGE",
      "RANSOM",          "RANSOM",
      
      // Schuylkill County
      "EAST UNION TWP",  "EAST UNION TWP",
      
      // Wyoming County
      "EXETER TWP",      "EXETER TWP",
      "NORTH MORELAND",  "NORTHMORELAND",
      "NORTHMORELAND",   "NORTHMORELAND",
      "NOXEN",           "NOXEN"
 
  });
}
