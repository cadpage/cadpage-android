package net.anei.cadpage.parsers.IL;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchProQAParser;



public class ILMedstarParser extends DispatchProQAParser {
  
  private static final Properties COUNTY_CODES = buildCodeTable(new String[]{
      "SCC", "ST CLAIR COUNTY"
  });
  
  private static final Pattern MAP_PAT = Pattern.compile("(.*?) +PG *(\\d+)");
  private static final Pattern APT_PAT = Pattern.compile("(?:RM|ROOM|APT|SUITE) .*|[-\\d ]+", Pattern.CASE_INSENSITIVE);
  private static final Pattern CROSS_PAT = Pattern.compile(".*(?:&| AND ).*", Pattern.CASE_INSENSITIVE);
  
  public ILMedstarParser() {
    super(COUNTY_CODES, "", "IL", null);
  }
  
  @Override
  public String getFilter() {
    return "emsdispatch@medstarems.net";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    int pt = body.indexOf("ProQA comments:");
    if (pt >= 0) body = body.substring(0,pt).trim();
    return super.parseMsg(body,  data);
  }
  
  @Override
  public boolean parseFields(String[] fields, Data data) {
    
    if (fields.length < 3) return false;
    
    // First line is always the address
    int ndx = 1;
    for (String fld : fields) {
      switch (ndx) {
      
      // Line 1 is always the address
      case 1:
        parseAddress(fld, data);
        ndx++;
        break;
        
      // After that things get complicated  
      case 2:
        
        // See if it has a room signature
        if (APT_PAT.matcher(fld).matches()) {
          data.strApt = fld;
          break;
        }
        
        // Short 3 character fields are asssumed to be dispatcher initials
        // and ignored
        if (fld.length() <= 3) break;
        
        // Anything with a ' PG ' in it should be a county code and map page number
        Matcher match = MAP_PAT.matcher(fld);
        if (match.matches()) {
          data.strCity = convertCodes(match.group(1), COUNTY_CODES);
          data.strMap = match.group(2);
          break;
        }
        
        // Anything consisting of blanks and upper case letters is assumed to be a city
        // Any regular text lines found up to know become cross streets
        if (CITY_SET.contains(fld.toUpperCase())) {
          if (fld.equalsIgnoreCase("SHILO")) fld = "SHILOH";
          data.strCity = fld;
          fld = append(data.strCall, " / ", data.strSupp);
          if (CROSS_PAT.matcher(data.strCall).matches()) {
            data.strCross = fld;
          } else {
            data.strPlace = fld;
          }
          data.strCall = data.strSupp = "";
          ndx++;
          break;
        }
        
        // Otherwise fall through case and treat as call or info text
      case 3:
        if (fld.equals("<PROQA_DET>")) break;
        if (data.strCall.length() == 0) {
          data.strCall = fld;
        } else if (data.strSupp.length() > 0) {
          data.strSupp = data.strSupp + " / " + fld;
        } else if (isCallExtend(data.strCall, fld)) {
          data.strCall = data.strCall + "/" + fld;
        } else {
          data.strSupp = fld;
        }
        break;
      }
    }
    return true;
  }
  
  private boolean isCallExtend(String call, String info) {
    call = call.toUpperCase();
    info = info.toUpperCase();
    if (call.endsWith(" C") && info.startsWith("B ")) return true;
    if (call.endsWith(" Y") && info.startsWith("O ")) return true;
    if (info.equals("SUICIDE ATTEMPT")) return true;
    if (info.equals("RAPE")) return true;
    if (info.startsWith("BACK INJURIES")) return true;
    if (info.startsWith("LACERATIONS")) return true;
    if (info.startsWith("FAINTING")) return true;
    return false;
  }
  
  private static final Set<String> CITY_SET = new HashSet<String>(Arrays.asList(new String[]{
      // Clinton County
      
      // Cities
      "BREESE",
      "CARLYLE",
      "CENTRALIA",
      "TRENTON",
      // Villages
      "ALBERS",
      "AVISTON",
      "BARTELSO",
      "BECKEMEYER",
      "DAMIANSVILLE",
      "GERMANTOWN",
      "HOFFMAN",
      "KEYESPORT",
      "HUEY",
      "NEW BADEN",
      "ST ROSE",
      // Townships
      "BREESE",
      "BROOKSIDE",
      "CARLYLE",
      "CLEMENT",
      "EAST FORK",
      "GERMANTOWN",
      "IRISHTOWN",
      "LAKE",
      "LOOKING GLASS",
      "MERIDIAN",
      "SAINT ROSE",
      "SANTA FE",
      "SUGAR CREEK",
      "WADE",
      "WHEATFIELD",
      
      // St Clair County
      
      // Cities and Towns
      "ALORTON",
      "BELLEVILLE",
      "BROOKLYN",
      "CAHOKIA",
      "CASEYVILLE",
      "CENTREVILLE",
      "COLLINSVILLE",
      "DUPO",
      "EAST CARONDELET",
      "EAST ST LOUIS",
      "EAST SAINT LOUIS",
      "FAIRMONT CITY",
      "FAIRVIEW HEIGHTS",
      "FAYETTEVILLE",
      "FREEBURG",
      "LEBANON",
      "LENZBURG",
      "MARISSA",
      "MASCOUTAH",
      "MILLSTADT",
      "NEW ATHENS",
      "O'FALLON",
      "SAUGET",
      "SCOTT AFB",
      "SHILOH",
      "SHILO",    // Dispatch typo
      "SMITHTON",
      "ST. LIBORY",
      "SUMMERFIELD",
      "SWANSEA",
      "WASHINGTON PARK",
      // Townships
      "BELLEVILLE",
      "CANTEEN",
      "CASEYVILLE",
      "CENTREVILLE",
      "ENGELMANN",
      "FAYETTEVILLE",
      "FREEBURG",
      "LEBANON",
      "LENZBURG",
      "MARISSA",
      "MASCOUTAH",
      "MILLSTADT",
      "NEW ATHENS",
      "O'FALLON",
      "PRAIRIE DU LONG",
      "ST CLAIR",
      "SHILOH VALLEY",
      "SMITHTON",
      "STITES",
      "STOOKEY",
      "SUGARLOAF",
      
      // Randolf County
      
      // Cities and Towns
      "BALDWIN",
      "CHESTER",
      "COULTERVILLE",
      "ELLIS GROVE",
      "EVANSVILLE",
      "KASKASKIA",
      "PERCY",
      "PRAIRIE DU ROCHER",
      "RED BUD",
      "ROCKWOOD",
      "RUMA",
      "SPARTA",
      "STEELEVILLE",
      "TILDEN",
      // Unincorprated communities
      "GLENN",
      "GRIGG",
      "MENARD",
      "MODOC",
      "SCHULINE",
      "WALSH",
      "WELGE",
      "WINE HILL"
  }));
}
