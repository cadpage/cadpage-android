package net.anei.cadpage.parsers.NY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA13Parser;




public class NYStLawrenceCountyParser extends DispatchA13Parser {
  
  private static final Pattern ROUTE_PTN = Pattern.compile("\\b[A-Z]+ +(\\d+)");
  
  public NYStLawrenceCountyParser() {
    super(CITY_LIST, "ST LAWRENCE COUNTY", "NY");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@stlawco.org";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.endsWith("911 DISPATCH")) return false;
    if (! super.parseMsg(body, data)) return false;
    
    // More strangeness.  Cities are often followed a dash and something that might be
    // a place name, but is usually a restatement of a previous ROUTE number, this time
    // adding some qualifiers as to what kind of highway it is.
    int pt = data.strCity.indexOf('-');
    if (pt >= 0) {
      String extra = data.strCity.substring(pt+1).trim();
      if (!extra.equals("WINTHROP")) {
        data.strCity = data.strCity.substring(0,pt).trim();
        
        Matcher match = ROUTE_PTN.matcher(extra);
        if (match.matches()) {
          String searchRoute = "ROUTE " + match.group(1);
          pt = data.strAddress.indexOf(searchRoute);
          if (pt >= 0) {
            data.strAddress = data.strAddress.substring(0,pt) + match.group(0) + data.strAddress.substring(pt+searchRoute.length());
            extra = null;
          }
        }
      }
      if (extra != null) data.strPlace = extra;
    }
    
    // Dispatch sprinkles a lot of #NY terms after addresses for no apparent reason
    if (data.strApt.startsWith("NY")) data.strApt = data.strApt.substring(2).trim();
    
    if (data.strCity.equals("OGD")) {
      data.strCity = "OGDENSBURG";
    }
    
    // Trim VILLAGE off of city names
    else if (data.strCity.endsWith(" VILLAGE")) {
      data.strCity = data.strCity.substring(0,data.strCity.length()-8).trim();
    }
    
    else if (data.strCity.endsWith(" CITY")) {
      data.strCity = data.strCity.substring(0,data.strCity.length()-5).trim();
    }
    
    // More special cases
    else if (NUMERIC.matcher(data.strAddress).matches() && data.strCity.contains(" ")) {
      data.strAddress = data.strAddress + " " + data.strCity;
      data.strCity = "";
    }
    
    else if (data.strCity.endsWith(" DORM")) {
      data.strPlace = append(data.strPlace, " - ", data.strCity);
      data.strCity = "";
    }
    
    else if (data.strCity.equalsIgnoreCase("CLARKSON UNIVERSITY")) {
      data.strPlace = append(data.strPlace, " - ", data.strAddress);
      data.strAddress = data.strCity;
      data.strCity = "POTSDAM";
    }
    
    return true;
  }
  
  @Override
  public String getProgram() {
    return super.getProgram() + " PLACE";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_ADD_PLACE;
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    addr = MAP_CLEAN_PTN.matcher(addr).replaceAll("");
    return addr.trim();
  }
  private static final Pattern MAP_CLEAN_PTN = Pattern.compile("\\bV[AI]CINITY\\b");
  
  private static final String[] CITY_LIST = new String[]{
    "BRASHER",
    "BRASHER FALLS-WINTHROP",
    "CANTON",
    "CLARE",
    "CLIFTON",
    "COLTON",
    "DE KALB",
    "DE PEYSTER",
    "EDWARDS",
    "FINE",
    "FOWLER",
    "GOUVERNEUR",
    "HAMMOND",
    "HERMON",
    "HEUVELTON",
    "HOPKINTON",
    "LAWRENCE",
    "LISBON",
    "LOUISVILLE",
    "MACOMB",
    "MADRID",
    "MASSENA",
    "MORRISTOWN",
    "NORFOLK",
    "NORWOOD",
    "OGD",
    "OGDENSBURG",
    "OSWEGATCHIE",
    "PARISHVILLE",
    "PIERCEFIELD",
    "PIERREPONT",
    "PITCAIRN",
    "POTSDAM",
    "RENSSELAER FALLS",
    "RICHVILLE",
    "ROSSIE",
    "RUSSELL",
    "STAR LAKE",
    "STOCKHOLM",
    "WADDINGTON"
  };
}
	