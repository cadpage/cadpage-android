package net.anei.cadpage.parsers.TN;


import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;


public class TNWilliamsonCountyAParser extends DispatchB2Parser {
  
  private static final Pattern MARKER = Pattern.compile("911-CENTER:[A-Z0-9]+ ?>");
  
  public TNWilliamsonCountyAParser() {
    super("911-CENTER:", CITY_LIST, "WILLIAMSON COUNTY", "TN");
  }
  
  @Override
  public String getFilter() {
    return "911-CENTER@williamson-tn.org";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!MARKER.matcher(body).lookingAt()) return false;
    return super.parseMsg(body, data);
  }

  private static final String[] CITY_LIST = new String[]{
    
    // Cities & Towns
    "BRENTWOOD",
    "FAIRVIEW",
    "FRANKLIN",
    "NOLENSVILLE",
    "SPRING HILL",
    "THOMPSONS STATION",
    
    // Unincorporated Communities
    "ALLISONA",
    "ARRINGTON",
    "BERRY'S CHAPEL",
    "BETHESDA",
    "BETHLEHEM",
    "BOSTON",
    "BURWOOD",
    "COLLEGE GROVE",
    "CLOVERCROFT",
    "COOL SPRINGS",
    "FERNVALE",
    "GRASSLAND",
    "KIRKLAND",
    "LEIPER'S FORK",
    "LIBERTY HILL",
    "PEYTONSVILLE",
    "PRIMM SPRINGS",
    "RUDDERVILLE",
    "SOUTHALL",
    "TRIUNE",
    
    // Davidson County
    "NASHVILLE"
  };
  
}