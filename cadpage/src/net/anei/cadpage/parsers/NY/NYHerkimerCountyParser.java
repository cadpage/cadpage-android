package net.anei.cadpage.parsers.NY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchB3Parser;



public class NYHerkimerCountyParser extends DispatchB3Parser {

  private static final Pattern CITY_SUFFIX = Pattern.compile("^VILLAGE\\b", Pattern.CASE_INSENSITIVE);
  
  public NYHerkimerCountyParser() {
    super(CITY_LIST, "HERKIMER COUNTY", "NY");
  }
  
  @Override
  public String getFilter() {
    return "HC911@herkimercounty.org,911Center@mydomain.com";
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return true;
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.contains(">")) return false;
    body = body.replaceAll("\n", " ").replaceAll(" Grids:,, NY ", " ");
    body = stripFieldEnd(body, " MAP:");
    if (!super.parseMsg(subject, body, data)) return false;
    
    // See if city suffix has bled over into name
    Matcher match = CITY_SUFFIX.matcher(data.strName);
    if (match.find()) data.strName = data.strName.substring(match.end()).trim();
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{  
    "COLD BROOK",
    "COLUMBIA",
    "DANUBE",
    "DEERFIELD", 
    "DOLGEVILLE",
    "FAIRFIELD",
    "FRANKFORT",
    "GERMAN FLATTS",
    "HERKIMER",
    "ILION",
    "LITCHFIELD",
    "LITTLE FALLS",
    "LITTLE FALLS CITY",
    "MANHEIM",
    "MIDDLEVILLE",
    "MOHAWK",
    "NEWPORT",
    "NORWAY",
    "OHIO",
    "POLAND",
    "RUSSIA",
    "SALISBURY",
    "SCHUYLER",
    "STARK",
    "WARREN",
    "WEBB",
    "WEST WINFIELD",
    "WINFIELD"
  }; 
}
