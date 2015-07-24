package net.anei.cadpage.parsers.MI;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;

public class MIAlconaCountyParser extends DispatchB2Parser {

  public MIAlconaCountyParser() {
    super("ALCONACAD:", CITY_LIST,"ALCONA COUNTY", "MI");
    setupCallList(CALL_LIST);
  }
  
  @Override
  public String getFilter() {
    return "ALCONACAD@alcona-county.net";
  }
  
  static final String[] CITY_LIST = new String[]{

      "ALCONA",
      "ALVIN",
      "BACKUS BEACH",
      "BARTON CITY",
      "BLACK RIVER",
      "BRYANT",
      "CHEVIERS",
      "CURRAN",
      "CURTISVILLE",
      "GLENNIE",
      "GREENBUSH",
      "GUSTIN",
      "HARRISVILLE",
      "HUBBARD LAKE",
      "KILLMASTER",
      "KURTZ",
      "LARSON BEACH",
      "LINCOLN",
      "LOST LAKE WOODS",
      "MIKADO",
      "SPRINGPORT",
      "SPRUCE",
      "WALLACE",
     
      //TOWNSHIPS
      
      "ALCONA TOWNSHIP",
      "CALEDONIA TOWNSHIP",
      "CURTIS TOWNSHIP",
      "GREENBUSH TOWNSHIP",
      "GUSTIN TOWNSHIP",
      "HARRISVILLE TOWNSHIP",
      "HAWES TOWNSHIP",
      "HAYNES TOWNSHIP",
      "MIKADO TOWNSHIP",
      "MILLEN TOWNSHIP",
      "MITCHELL TOWNSHIP"
  };
  
  private static final CodeSet CALL_LIST = new CodeSet(
      "FIRE ANY",
      "MEDICAL"
  );
}
