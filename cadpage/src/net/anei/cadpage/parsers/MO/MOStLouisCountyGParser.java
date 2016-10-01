package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.dispatch.DispatchGlobalDispatchParser;



public class MOStLouisCountyGParser extends DispatchGlobalDispatchParser {
  
  
  public MOStLouisCountyGParser() {
    super(CITY_TABLE, "ST LOUIS COUNTY", "MO", LEAD_SRC_UNIT_ADDR | PLACE_FOLLOWS_CALL);
    setupCallList(CALL_LIST);

  }
  
  @Override
  public String getFilter() {
    return "Kirkwood@Kirkwoodmo.org";
  }
  
  private static final CodeSet CALL_LIST = new CodeSet(
      "GAS LEAK",
      "LOCK OUT"
  );

  private static final String[] CITY_TABLE = new String[]{


      "BALLWIN",
      "BELLA VILLA",
      "BELLEFONTAINE NEIGHBORS",
      "BELLERIVE",
      "BEL-NOR",
      "BEL-RIDGE",
      "BERKELEY",
      "BEVERLY HILLS",
      "BLACK JACK",
      "BRECKENRIDGE HILLS",
      "BRENTWOOD",
      "BRIDGETON",
      "CALVERTON PARK",
      "CHAMP",
      "CHARLACK",
      "CHESTERFIELD",
      "CLARKSON VALLEY",
      "CLAYTON",
      "COOL VALLEY",
      "COUNTRY CLUB HILLS",
      "COUNTRY LIFE ACRES",
      "CRESTWOOD",
      "CREVE COEUR",
      "CRYSTAL LAKE PARK",
      "DELLWOOD",
      "DES PERES",
      "EDMUNDSON",
      "ELLISVILLE",
      "EUREKA",
      "FENTON",
      "FERGUSON",
      "FLORDELL HILLS",
      "FLORISSANT",
      "FRONTENAC",
      "GLENCOE",
      "GLENDALE",
      "GLEN ECHO PARK",
      "GRANTWOOD VILLAGE",
      "GREENDALE",
      "GREEN PARK",
      "HANLEY HILLS",
      "HAZELWOOD",
      "HILLSDALE",
      "HUNTLEIGH",
      "JENNINGS",
      "KINLOCH",
      "KIRKWOOD",
      "LADUE",
      "LAKESHIRE",
      "MACKENZIE",
      "MANCHESTER",
      "MAPLEWOOD",
      "MARLBOROUGH",
      "MARYLAND HEIGHTS",
      "MOLINE ACRES",
      "NORMANDY",
      "NORTHWOODS",
      "NORWOOD COURT",
      "OAKLAND",
      "OLIVETTE",
      "OVERLAND",
      "PACIFIC",
      "PAGEDALE",
      "PASADENA HILLS",
      "PASADENA PARK",
      "PINE LAWN",
      "RICHMOND HEIGHTS",
      "RIVERVIEW",
      "ROCK HILL",
      "SHREWSBURY",
      "ST. ANN",
      "ST. JOHN",
      "SUNSET HILLS",
      "SYCAMORE HILLS",
      "TOWN AND COUNTRY",
      "TWIN OAKS",
      "UNIVERSITY CITY",
      "UPLANDS PARK",
      "VALLEY PARK",
      "VELDA CITY",
      "VELDA VILLAGE HILLS",
      "VINITA PARK",
      "VINITA TERRACE",
      "WARSON WOODS",
      "WEBSTER GROVES",
      "WELLSTON",
      "WESTWOOD",
      "WILBUR PARK",
      "WILDWOOD",
      "WINCHESTER",
      "WOODSON TERRACE"
  };
}
