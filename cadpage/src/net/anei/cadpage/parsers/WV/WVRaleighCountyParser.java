package net.anei.cadpage.parsers.WV;


import java.util.Properties;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchBParser;


public class WVRaleighCountyParser extends DispatchBParser {
  
  public WVRaleighCountyParser() {
    super(CITY_LIST, "RALEIGH COUNTY", "WV");
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return body.startsWith("RALEIGH911:");
  }

  @Override
  protected boolean parseAddrField(String field, Data data) {
    if (field.startsWith("RALEIGH911:Return Phone:")) {
      Parser p = new Parser(field.substring(24).trim());
      data.strPhone = p.get(' ');
      p.get(' ');
      field = p.get();
    }
    if (!super.parseAddrField(field, data)) return false;
    if (data.strCity.length() > 0) {
      String city = CITY_PLACE_NAMES.getProperty(data.strCity);
      if (city != null) {
        data.strPlace = data.strCity;
        data.strCity = city;
      }
    }
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{

    // Cities & Towns
    "BECKLEY",
    "LESTER",
    "MABSCOTT",
    "RHODELL",
    "SOPHIA",
    
    // Subdivisions
    "CALLOWAY HEIGHTS",

    // Unincorporated communities
    "ABNEY",
    "ABRAHAM",
    "AFFINITY",
    "AMIGO",
    "ARNETT",
    "ARTIE",
    "BEAVER",
    "BESOCO",
    "BIG STICK",
    "BLUE JAY",
    "BLUE JAY 6",
    "BOLT",
    "BOWYER",
    "BRADLEY",
    "BRAGG", // new
    "CEDAR",
    "CIRTSVILLE",
    "COAL CITY",
    "COLCORD",
    "COOL RIDGE",
    "CRAB ORCHARD",
    "DAMERON",
    "DANIELS",
    "DOROTHY",
    "EASTGULF",
    "ECCLES",
    "EGERIA",
    "EUNICE",
    "FIRECO",
    "FLAT TOP",
    "GHENT",
    "GLEN DANIEL",
    "GLEN MORGAN",
    "HELEN",
    "HOLLYWOOD",
    "HOT COAL",
    "HOTCHKISS",
    "JONBEN",
    "JOSEPHINE",
    "KILLARNEY",
    "LEEVALE",
    "LEGO",
    "LILLYBROOK",
    "MACARTHUR",
    "MCALPIN",
    "MCVEY",
    "MONTCOAL",
    "NAOMA",
    "NEW",
    "ODD",
    "PACKSVILLE",
    "PEMBERTON",
    "PICKSHIN",
    "PINEPOCA",
    "PINEY VIEW",
    "PLUTO",
    "PRICE HILL",
    "PRINCEWICK",
    "PROSPERITY",
    "RALEIGH",
    "REDBIRD",
    "SHADY SPRING",
    "SHILOH",
    "SLAB FORK",
    "SOAK CREEK",
    "SOPHIA",
    "SPRAGUE",
    "STANAFORD",
    "STICKNEY",
    "STOTESBURY",
    "SULLIVAN",
    "SUNDIAL",
    "SYLVIA",
    "TAMS",
    "URY",
    "WHITBY",
    "WHITE OAK",
    "WILLIBET",
    "WINDING GULF",
    "WOODPECK",
    
    // Boone County
    "BOONE COUNTY",
    "WHITESVILLE"
  };
  
  private static final Properties CITY_PLACE_NAMES = buildCodeTable(new String[]{
      "CALLOWAY HEIGHTS",   "BECKLEY",
      "DAMERON",            "",
      "EUNICE",             "WHITESVILLE",
      "LEEVALE",            "WHITESVILLE",
      "PACKSVILLE",         ""
  });
}