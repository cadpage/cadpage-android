package net.anei.cadpage.parsers.NY;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeTable;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.StandardCodeTable;
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
    
    // Sectors should be moved to the MAP field
    if (data.strPlace.endsWith(" SECTOR")) {
      data.strMap = data.strPlace;
      data.strPlace = "";
    }
    
    // If call contains a response code expand it to full description
    // The last part of the code may contain a leading zero which
    // will need to be removed.
    if (data.strCall.startsWith("Response Type ")) {
      String code = data.strCall.substring(14).trim();
      String call = CALL_CODES.getCodeDescription(code);
      if (call != null) {
        data.strCode = code;
        data.strCall = call;
      }
    }
    
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
    if (data.strCity.endsWith("#NY")) {
      data.strCity = data.strCity.substring(0,data.strCity.length()-3).trim();
    }
    
    // Redundant processing, but extra information is sometimes appended to address
    
    String addr = data.strAddress;
    pt = addr.indexOf(" - ");
    if (pt >= 0) {
      data.strMap = append(data.strPlace, " - ", addr.substring(pt+3).trim());
      addr = addr.substring(0,pt).trim();
    } 
      
    String saveCity = data.strCity;
    data.strAddress = "";
    parseAddress(StartType.START_ADDR, addr, data);
    data.strSupp = cleanCitySuffix(getLeft(), data);
    if (saveCity.length() > 0) {
      if (!data.strCity.equals(saveCity)) {
        data.strSupp = append(data.strSupp, " ", saveCity);
      }
    }
    
    // And Place name may follow city names
    addr = data.strCity;
    data.strCity = "";
    Result res = parseAddress(StartType.START_ADDR, FLAG_ONLY_CITY, addr);
    if (res.getStatus() > 0) {
      res.getData(data);
      addr = res.getLeft();
      addr = cleanCitySuffix(addr, data);
    }
    data.strPlace = append(addr, " - ", data.strPlace);
    
    data.strCity = convertCodes(data.strCity, CITY_CODES);
    
    if (data.strCity.equalsIgnoreCase("CLARKSON UNIVERSITY")) {
      data.strPlace = append(data.strPlace, " - ", data.strAddress);
      data.strAddress = data.strCity;
      data.strCity = "POTSDAM";
    }
    
    return true;
  }

  private String cleanCitySuffix(String addr, Data data) {
    if (addr.startsWith("VILLAGE")) {
      addr = addr.substring(7).trim();
    }
    else if (addr.startsWith("CITY")) {
      addr = addr.substring(4).trim();
    }
    if (addr.startsWith("CROSS ")) {
      data.strCross = append(data.strCross, " / ", addr.substring(6).trim());
      addr = "";
    }
    return addr;
  }
  
  @Override
  public String getProgram() {
    return super.getProgram().replace("CALL", "CODE CALL").replace("CITY", "MAP CITY") + " PLACE";
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
    "CLARKSON UNIVERSITY",
    "CLIFTON",
    "COLTON",
    "DE KALB",
    "DE PEYSTER",
    "DEPEYSTER",
    "EDWARDS",
    "FINE",
    "FOWLER",
    "GOUV",
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
    "OGDENBURG",
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
    "SOUTH COLTON",
    "STAR LAKE",
    "STOCKHOLM",
    "WADDINGTON",
    
    // Jefferson County
    "ANTWERP"
  };
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "DEPEYSTER",    "DE PEYSTER",
      "GOUV",         "GOUVERNEUR",
      "OGD",          "OGDENSBURG",
      "OGDENBURG",    "OGDENSBURG"
  });
  
  private static final CodeTable CALL_CODES = new StandardCodeTable(
      "FAFA",      "Automatic Fire Alarm",
      "FAFARD",    "Automatic Fire Alarm – reduced response",
      "FAIRCR",    "Aircraft Fire",
      "FBARN1",    "Barn Fire – first alarm",
      "FBARN2",    "Barn Fire – second alarm",
      "FBARN3",    "Barn Fire – third alarm",
      "FBARN4",    "Barn Fire – fourth alarm",
      "FCB",       "Controlled Burn",
      "FCODET",    "Carbon Monoxide Detector",
      "FHMINI",    "Hazardous Materials Incident – inside investigation",
      "FHMNS",     "Hazardous Materials Incident – non-structure",
      "FHMOUI",    "Hazardous Materials Incident – outside investigation",
      "FHMSTR",    "Hazardous Materials Incident – structure fire",
      "FLZ",       "Helicopter Landing Zone",
      "FMASTN",    "Mass Transportation Incident",
      "FMA",       "Fire Department Medical Assist", 
      "FMISC",     "Miscellaneous Incident",
      "FOTRES",    "Miscellaneous Rescue",
      "FOUI",      "Outside Investigation",
      "FSTR1",     "Structure Fire – first alarm",
      "FSTR2",     "Structure Fire – second alarm",
      "FSTR3",     "Structure Fire – third alarm",
      "FSTR4",     "Structure Fire – fourth alarm",
      "FVEHSM",    "Motor Vehicle Fire – car or small truck",
      "FVEHLG",    "Motor Vehicle Fire – large truck",
      "FVSNI",     "Motor Vehicle Versus Structure – no injuries",
      "FWARES",    "Water Rescue",
      "FWF",       "Wild Fire",
      "FWFVEH",    "Wild Fire Involving Vehicle",
      "FWFSTR",    "Wild Fire Endangering Structure",
      "FXFER1",    "Transfer Assignment – first alarm",
      "FXFER2",    "Transfer Assignment – second alarm",
      "FXFER3",    "Transfer Assignment – third alarm",
      "FXFER4",    "Transfer Assignment – fourth alarm",
      "MUTAID",    "Mutual Aid Response",
      "XFER",      "Transfer"    
  );
}
	