package net.anei.cadpage.parsers.MT;



import net.anei.cadpage.parsers.dispatch.DispatchA16Parser;
/**
 * Stillwater County, MT
 */
public class MTStillwaterCountyParser extends DispatchA16Parser {
  
  public MTStillwaterCountyParser() {
    super(CITY_LIST, "STILLWATER COUNTY", "MT");
  }

  @Override
  public String getFilter() {
    return "cbrophy@scsomt.org";
  }
  

  private static final String[] CITY_LIST= new String[]{
      
  "ABSAROKEE",
  "BEEHIVE",
  "COLUMBUS",
  "DEAN",
  "FISHTAIL",
  "LIMESTONE",
  "MOLT",
  "NYE",
  "PARK CITY",
  "RAPELJE",
  "RAPIDS",
  "REED POINT",
  "SPRINGTIME",
  "WHEAT BASIN"

  };
}
