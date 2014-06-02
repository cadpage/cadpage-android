package net.anei.cadpage.parsers.OR;

import java.util.Properties;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;


public class ORTillamookCountyParser extends SmartAddressParser {
  
  public ORTillamookCountyParser() {
    super(CITY_LIST, "TILLAMOOK COUNTY", "OR");
    setFieldList("CALL ADDR APT PLACE CITY INFO");
  }
  
  @Override
  public String getFilter() {
    return "5038122399@vzwpix.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    body = body.replace('\n', ' ');
    parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ | FLAG_IGNORE_AT, body, data);
    if (data.strCity.length() == 0) return false;
    data.strSupp = getLeft();
    
    String city = CITY_PLACE_TABLE.getProperty(data.strCity.toUpperCase());
    if (city != null) {
      data.strPlace = data.strCity;
      data.strCity = city;
    }
    return isValidAddress();
  }
  
  private static final String[] CITY_LIST = new String[]{

    // Cities
    "BAY CITY",
    "GARIBALDI",
    "MANZANITA",
    "NEHALEM",
    "ROCKAWAY BEACH",
    "TILLAMOOK",
    "WHEELER",

    // Unincorporated communities and CDPs
    "BARVIEW",
    "BAYOCEAN",
    "BAYSIDE GARDENS",
    "BEAVER",
    "BRIGHTON",
    "CAPE MEARES",
    "CASTLE ROCK",
    "CLOVERDALE",
    "DOLPH",
    "FAIRVIEW",
    "FOSS",
    "HEBO",
    "HEMLOCK",
    "IDAVILLE",
    "IDIOTVILLE",
    "JORDAN CREEK",
    "LEES CAMP",
    "MANHATTAN BEACH",
    "MEDA",
    "MOHLER",
    "NEAHKAHNIE BEACH",
    "NEDONNA BEACH",
    "NESKOWIN",
    "NETARTS",
    "OCEANSIDE",
    "ORETOWN",
    "PACIFIC CITY",
    "PLEASANT VALLEY",
    "SANDLAKE",
    "TIERRA DEL MAR",
    "TWIN ROCKS",
    "WATSECO",
    "WOODS"
   
  };
  
  private static final Properties CITY_PLACE_TABLE = buildCodeTable(new String[]{
      "SANDLAKE",         "Cloverdale"
  });
 
}
