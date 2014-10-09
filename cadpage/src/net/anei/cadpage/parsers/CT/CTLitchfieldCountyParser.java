package net.anei.cadpage.parsers.CT;

import net.anei.cadpage.parsers.GroupBestParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class CTLitchfieldCountyParser extends GroupBestParser {
  
  public CTLitchfieldCountyParser() {
    super(new CTLitchfieldCountyAParser(), new CTNewMilfordParser());
  }
  
  @Override
  public String getLocName() {
    return "Litchfield County, CT";
  }
  
  public static void fixCity(Data data) {
    if (data.strCity.equals("HEMLOCK ROXBURY")) data.strCity = "ROXBURY";
    if (data.strCity.endsWith(" MA")) {
      data.strState = "MA";
      data.strCity = data.strCity.substring(0,data.strCity.length()-3).trim();
    }
  }

  static String[] CITY_LIST = new String[]{
    "BANTAM",
    "BARKHAMSTED",
    "BETHLEHEM",
    "BRIDGEWATER",
    "BURLINGTON",
    "CANAAN",
    "CANTON",
    "COLEBROOK",
    "CORNWALL",
    "GAYLORDSVILLE",
    "GOSHEN",
    "HARTFORD",
    "HARTLAND",
    "HARWINTON",
    "KENT",
    "LITCHFIELD",
    "MORRIS",
    "NEW HARTFORD",
    "NEW MILFORD",
    "NEW PRESTON",
    "NORFOLK",
    "NORTH CANAAN",
    "NORTHWEST HARWINTON",
    "OAKVILLE",
    "PLYMOUTH",
    "ROXBURY",
    "ROXBURY",
    "SALISBURY",
    "SANDISFIELD",
    "SHARON",
    "SHEFFIELD",
    "SHERMAN",
    "SOUTH KENT",
    "TERRYVILLE",
    "THOMASTON",
    "TORRINGTON",
    "WARREN",
    "WASHINGTON",
    "WATERTOWN",
    "WINCHESTER",
    "WINSTED",
    "WOODBURY",
    
    "GRANVILLE MA",
    "SANDISFIELD MA",
    "SHEFFIELD MA"
    
  };
}
