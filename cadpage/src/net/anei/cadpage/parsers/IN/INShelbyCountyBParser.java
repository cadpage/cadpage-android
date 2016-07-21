package net.anei.cadpage.parsers.IN;

import net.anei.cadpage.parsers.dispatch.DispatchA48Parser;

public class INShelbyCountyBParser extends DispatchA48Parser {
  
  public INShelbyCountyBParser() {
    super(CITY_LIST, "SHELBY COUNTY", "IN", FieldType.X_NAME);
    setupCallList(CALL_LIST);
  }
  
  private static final String[] CALL_LIST = new String[]{
    "fillah"
  };
  
  private static final String[] CITY_LIST = new String[]{
      //Cities and towns

      "EDINBURGH",
      "FAIRLAND",
      "MORRISTOWN",
      "ST. PAUL",
      "SHELBYVILLE",

      //Unincorporated towns

      "BLUE RIDGE",
      "BROOKFIELD",
      "BOGGSTOWN",
      "FLAT ROCK",
      "FOUNTAINTOWN",
      "GENEVA",
      "GWYNNEVILLE",
      "LONDON",
      "MARIETTA",
      "MEIKS",
      "MOUNT AUBURN",
      "SUGAR CREEK",
      "WALDRON",

  //Townships

      "ADDISON",
      "BRANDYWINE",
      "HANOVER",
      "HENDRICKS",
      "JACKSON",
      "LIBERTY",
      "MARION",
      "MORAL",
      "NOBLE",
      "SHELBY",
      "SUGAR CREEK",
      "UNION",
      "VAN BUREN",
      "WASHINGTON"
  };
}
