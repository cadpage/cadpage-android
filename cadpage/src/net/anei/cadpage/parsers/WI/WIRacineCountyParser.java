package net.anei.cadpage.parsers.WI;

import java.util.Properties;
import net.anei.cadpage.parsers.dispatch.DispatchProphoenixParser;

public class WIRacineCountyParser extends DispatchProphoenixParser {
  
  public WIRacineCountyParser() {
    super(CITY_TABLE,"RACINE COUNTY", "WI");
  }
  
  @Override
  public String getFilter() {
    return "PhoenixAlert@goracine.org";
  }
  
  private static final Properties CITY_TABLE = buildCodeTable(new String[]{
      //Cities, villages, and towns
      
      "Burlington",
      "Caledonia",
      "Dover",
      "Elmwood Park",
      "Mount Pleasant",
      "North Bay",
      "Norway",
      "Racine",
      "Raymond",
      "Rochester",
      "Sturtevant",
      "Union Grove",
      "Waterford",
      "Wind Point",
      "Yorkville",

  //Census-designated places"

      "Bohners Lake",
      "Browns Lake",
      "Eagle Lake",
      "Waterford North",
      "Wind Lake",

  //Unincorporated communities

      "Beaumont",
      "Buena Park",
      "Caldwell",
      "Cedar Park",
      "Eagle Lake Manor",
      "Franksville",
      "Husher",
      "Ives Grove",
      "Kansasville",
      "Kneeland",
      "North Cape",
      "Raymond",
      "Rosewood",
      "Sylvania",
      "Tichigan",
      "Union Church",
      "Yorkville",

  //Ghost towns

      "Muskego Settlement",
      "Raymond Center"
  });
}
