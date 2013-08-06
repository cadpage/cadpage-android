package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;


public class NYGreeneCountyParser extends DispatchB2Parser {
  
  private static final String[] CITY_CODES = new String[]{
    "ASHLAND", "ATHENS", "CAIRO", "CATSKILL", "COXSACKIE", "DURHAM", "GREENVILLE",
    "HALCOTT", "HUNTER", "JEFFERSON HEIGHTS", "JEWETT", "LEEDS", "LEXINGTON", "NEW BALITMORE",
    "PALENVILLE", "PRATTSVILLE", "TANNERSVILLE", "WINDHAM"};
 
  public NYGreeneCountyParser() {
    super("GREENE911:", CITY_CODES, "GREENE COUNTY", "NY");
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    if (body.startsWith("GREENE 911:")) body = "GREENE911:" + body.substring(11);
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getFilter() {
    return "200-200-0004,GREENE911@thinkgreene.us";
  }
}
