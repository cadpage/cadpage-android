package net.anei.cadpage.parsers.PA;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchBParser;



public class PASnyderCountyParser extends DispatchBParser {
  
  private static final Pattern CAD_PTN = Pattern.compile(" C[Aa][Dd][ :](?=\\d)");

  public PASnyderCountyParser() {
    super(CITY_LIST, "SNYDER COUNTY", "PA");
  }
  
  @Override
  public String getFilter() {
    return "SNYDER911@snydercounty.org,5705419455";
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return body.startsWith("SNYDER911:") || body.startsWith("SYNDER911:") ||
            body.contains(" Cad:");
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    if (subject.contains(">") && body.startsWith("SNYDER911:")) {
      body = body.substring(0,10) + subject + ' ' + body.substring(10);
    } else if (subject.equals("EVENT")  && body.startsWith("SNYDER911:")) {
      body = body.substring(0,10) + "EVENT:" + body.substring(10);
    }
    
    body = CAD_PTN.matcher(body).replaceAll(" Cad:");
    body = body.replace(" MAP:", "Map:");
    body = body.replace(" Map:Grids:", " Map: Grids:");
    if (! super.parseMsg(body, data)) return false;
    if (data.strCity.endsWith(" BORO")) {
      data.strCity = data.strCity.substring(0, data.strCity.length()-5);
    }
    else if (data.strCity.endsWith(", UC")) {
      data.strCity =  data.strCity.substring(0,data.strCity.length()-4) + ", UNION COUNTY";
    }
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{
    "BEAVERTOWN BORO",
    "FREEBURG BORO",
    "MCCLURE BORO",
    "MIDDLEBURG BORO",
    "SELINSGROVE BORO",
    "SHAMOKIN DAM BORO",
    
    "ADAMS TWP",
    "BEAVER TWP",
    "CENTER TWP",
    "CHAPMAN TWP",
    "FRANKLIN TWP",
    "JACKSON TWP",
    "MIDDLECREEK TWP",
    "MONROE TWP",
    "PENN TWP",
    "PERRY TWP",
    "SPRING TWP",
    "UNION TWP",
    "WASHINGTON TWP",
    "WEST BEAVER TWP",
    "WEST PERRY TWP",
    
    // Union County
    "HARTLEY TWP , UC"
 };
}
