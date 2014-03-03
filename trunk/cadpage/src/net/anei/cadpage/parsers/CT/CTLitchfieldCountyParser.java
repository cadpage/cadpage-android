package net.anei.cadpage.parsers.CT;

import net.anei.cadpage.parsers.GroupBestParser;


public class CTLitchfieldCountyParser extends GroupBestParser {
  
  public CTLitchfieldCountyParser() {
    super(new CTLitchfieldCountyAParser(), new CTNewMilfordParser());
  }
  
  @Override
  public String getLocName() {
    return "Litchfield County, CT";
  }

  static String[] CITY_LIST = new String[]{
    "BARKHAMSTED",
    "BETHLEHEM",
    "BRIDGEWATER",
    "CANAAN",
    "COLEBROOK",
    "CORNWALL",
    "GOSHEN",
    "HARWINTON",
    "NORTHWEST HARWINTON",
    "KENT",
    "SOUTH KENT",
    "LITCHFIELD",
    "BANTAM",
    "MORRIS",
    "NEW HARTFORD",
    "NEW MILFORD",
    "GAYLORDSVILLE",
    "NORFOLK",
    "NORTH CANAAN",
    "PLYMOUTH",
    "TERRYVILLE",
    "ROXBURY",
    "SALISBURY",
    "SHARON",
    "THOMASTON",
    "TORRINGTON",
    "WARREN",
    "WASHINGTON",
    "NEW PRESTON",
    "WATERTOWN",
    "OAKVILLE",
    "WINCHESTER",
    "WINSTED",
    "WOODBURY",

    "CANTON",
    "HARTFORD",
    "SHERMAN",
    "ROXBURY"
  };
}
