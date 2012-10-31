package net.anei.cadpage.parsers.NY;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.dispatch.DispatchBParser;



public class NYGreeneCountyParser extends DispatchBParser {
  
  private static final String[] CITY_CODES = new String[]{
    "ASHLAND", "ATHENS", "CAIRO", "CATSKILL", "COXSACKIE", "DURHAM", "GREENVILLE",
    "HALCOTT", "HUNTER", "JEFFERSON HEIGHTS", "JEWETT", "LEEDS", "LEXINGTON", "NEW BALITMORE",
    "PALENVILLE", "PRATTSVILLE", "TANNERSVILLE", "WINDHAM"};

  private static final Pattern MARKER = Pattern.compile("^GREENE ?911:");
 
  public NYGreeneCountyParser() {
    super(CITY_CODES, "GREENE COUNTY", "NY");
  }
  
  @Override
  public String getFilter() {
    return "200-200-0004,GREENE911@thinkgreene.us";
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return MARKER.matcher(body).find();
  }
}
