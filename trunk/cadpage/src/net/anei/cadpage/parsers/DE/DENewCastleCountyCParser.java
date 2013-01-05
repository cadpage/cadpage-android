package net.anei.cadpage.parsers.DE;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA7BaseParser;



public class DENewCastleCountyCParser extends DispatchA7BaseParser {
  
  public DENewCastleCountyCParser() {
    super(-1, null, "NEW CASTLE COUNTY", "DE", null);
  }
  
  @Override
  public String getFilter() {
    return "CAD_DONOTREPLY@NCCDE.ORG";
  }
  
  private static final Pattern SOFT_BREAK_PTN = Pattern.compile("\n(?=[^/ ])");
  
  private static final Pattern ID_PTN = Pattern.compile("Incident History for: #([A-Z]+\\d+) ");
  private static final Pattern DATE_TIME_PTN = Pattern.compile("\n *(Received|Entered|Dispatched)  +(\\d\\d/\\d\\d/\\d\\d) +(\\d\\d:\\d\\d:\\d\\d) +");
  private static final Pattern CALL_PTN = Pattern.compile(" Final Type: (.*?) *\n");
  private static final Pattern PRI_PTN = Pattern.compile(" Final Priority: ([A-Z0-9]) *\n");
  private static final Pattern UNIT_PTN = Pattern.compile(" Primary Unit:(.*?)\n");
  private static final Pattern BOX_PTN = Pattern.compile(" Fire +BLK: ([A-Z0-9]+) *\n");
  private static final Pattern MAP_LAT_LONG_PTN = Pattern.compile(" Map Page: ([A-Z0-9]*) +Lat: +([-+][\\.0-9]+)? Long: ([-+][\\.0-9]+)? *(?=\n)");
  private static final Pattern ADDR_CROSS_PTN = Pattern.compile("\n *Loc: *(.*?) *(?:high xst: (.*?) *)?(?=\n)");
  private static final Pattern COMMUNITY_PTN = Pattern.compile("\n +Community:  +(.*?) +(?=\n)");
  private static final Pattern LOC_INFO_PTN = Pattern.compile("\n +Loc Info: +(.*?) *(?=\n)");
  private static final Pattern LOC_INFO_SPLIT_PTN = Pattern.compile(" *(?:,|---+) *");
  private static final Pattern LOC_INFO_APT_PTN = Pattern.compile("(?:RM|UNIT|SUITE?|STE|APT|BLDG) +.*|.* +(?:FLOOR)",Pattern.CASE_INSENSITIVE);
  private static final Pattern LOC_INFO_APT2_PTN = Pattern.compile("(?:RM|APT|SUITE?) +#? *(.*?)");
  private static final Pattern NAME_PHONE_ADDR_PTN = Pattern.compile("\n +Name: *(.*?) +CC: .*? +Phone: *(.*?) *\n +Addr: (.*?) *\n");
  private static final Pattern NEXT_LINE_PTN = Pattern.compile("(.*?)(?:(\r?\n)|$)");
  
  private static final Pattern ENTRY_MARK_PTN = Pattern.compile("^/\\d++\\?? ");
  private static final Pattern CONT_MARK_PTN = Pattern.compile("^ {30}"); 
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    body = SOFT_BREAK_PTN.matcher(body).replaceAll(" ");
    
    Parser p = new Parser(body);
    
    Matcher match = p.getMatcher(ID_PTN);
    if (match == null) return false;
    data.strCallId = match.group(1);
    
    do {
      match = p.getMatcher(DATE_TIME_PTN);
      if (match == null) break;
      data.strDate = match.group(2);
      data.strTime = match.group(3);
    } while (!"Dispatched".equals(match.group(1)));
    
    match = p.getMatcher(CALL_PTN);
    if (match == null) return false;
    data.strCall = match.group(1).trim();
    
    match = p.getMatcher(PRI_PTN);
    if (match == null) return false;
    data.strPriority = match.group(1).trim();
    
    match = p.getMatcher(UNIT_PTN);
    if (match == null) return false;
    String priUnit = match.group(1).trim();
    data.strUnit = priUnit;
    
    match = p.getMatcher(BOX_PTN);
    if (match == null) return false;
    data.strBox = match.group(1);
    
    match = p.getMatcher(MAP_LAT_LONG_PTN);
    if (match == null) return false;
    data.strMap = match.group(1);
    String lat = match.group(2);
    String lng = match.group(3);
    if (lat != null && lng != null) data.strGPSLoc = lat + ',' + lng;
    
    match = p.getMatcher(ADDR_CROSS_PTN);
    if (match == null) return false;
    parseAddressA7(match.group(1).trim(), data);
    data.strCross = append(data.strCross, " & ", getOptGroup(match.group(2)));
    
    // We have no idea what the municipality codes are, so let's add them to the map field
    data.strMap = append(data.strCity, "-", data.strMap);
    data.strCity = "";
    
    match = p.getMatcher(COMMUNITY_PTN);
    if (match != null) {
      String place = match.group(1);
      if (CITY_SET.contains(place)) {
        data.strCity = place;
      } else if (!data.strPlace.contains(place)) {
        data.strPlace = append(place, " - ", data.strPlace);
      }
    }
    
    match = p.getMatcher(LOC_INFO_PTN);
    if (match != null) {
      String place = "";
      for (String tmp : LOC_INFO_SPLIT_PTN.split(match.group(1))) {
        tmp = tmp.trim();
        if (tmp.length() == 0) continue;
        if (CITY_SET.contains(tmp)) {
          data.strCity = tmp;
          continue;
        }
        if (tmp.startsWith("XST-")) {
          data.strCross = append(data.strCross, " & ", tmp);
          continue;
        }
        if (LOC_INFO_APT_PTN.matcher(tmp).matches()) {
          match = LOC_INFO_APT2_PTN.matcher(tmp);
          if (match.matches()) tmp = match.group(1);
          data.strApt = tmp;
          continue;
        }
        if (data.strPlace.contains(tmp)) continue;
        place = append(place, " ", tmp);
      }
      data.strPlace = append(data.strPlace, " - ", place);
    }
    if (data.strCity.length() > 0) {
      String city = convertCodes(data.strCity, CITY_CODES);
      int pt = city.indexOf(',');
      if (pt >= 0) {
        data.strState = city.substring(pt+1);
        city = city.substring(0,pt);
      }
      data.strCity = city;
    }
    
    match = p.getMatcher(NAME_PHONE_ADDR_PTN);
    if (match == null) return false;
    data.strName = match.group(1).trim();
    data.strPhone = match.group(2).trim();
    String sAddr = match.group(3).trim();
    if (sAddr.length() > 0 && !sAddr.equals(data.strAddress)) {
      data.strName = data.strName + " (" + sAddr + ")";
    }
    
    boolean entry = false;
    while (true) {
      match = p.getMatcher(NEXT_LINE_PTN);
      if (match == null) break;
      String line = match.group(1);
      if (line.trim().length() == 0) continue;
      if (line.length() < 23) break;
      if (ENTRY_MARK_PTN.matcher(line).find()) {
        String type = line.substring(17,23).trim();
        entry = type.equals("ENTRY") || type.equals("COPY") || type.equals("SUPP");
        if (entry && line.length() > 32) {
          line = line.substring(32).trim();
          if (line.startsWith("TXT:")) line = line.substring(4).trim();
          if (!line.startsWith("PROQA")) data.strSupp = append(data.strSupp, "\n", line);
        }
        else if (type.startsWith("DISP") || type.startsWith("ASST")) {
          String unit = substring(line,25,32).trim();
          if (! priUnit.equals(unit)) data.strUnit = append(data.strUnit, " ", unit);
        }
      }
      else if (CONT_MARK_PTN.matcher(line).find()) {
        if (entry && line.length() > 33) {
          line = line.substring(33).trim();
          if (line.startsWith("TXT:")) {
            data.strSupp = append(data.strSupp, "\n", line.substring(4).trim());
          } else {
            data.strSupp = append(data.strSupp, " ", line);
          }
        }
      }
      else break;
      if (match.group(2) == null) break;
    }
    
    return true;
  }
  
  private static final Set<String> CITY_SET = new HashSet<String>(Arrays.asList(new String[]{
      "ARDEN",
      "ARDENCROFT",
      "ARDENTOWN",
      "BELLEFONTE",
      "CLAYTON",
      "DELAWARE CITY",
      "ELSMERE",
      "MIDDLETOWN",
      "NEW CASTLE",
      "NEWARK",
      "NEWPORT",
      "ODESSA",
      "SMYRNA",
      "TOWNSEND",
      "WILMINGTON",

      "BEAR",
      "BROOKSIDE",
      "CLAYMONT",
      "COLLINS PARK",
      "CHRISTIANA",
      "EDGEMOOR",
      "GLASGOW",
      "GREENVILLE",
      "HOCKESSIN",
      "HOLLY OAK",
      "MARSHALLTON",
      "MINQUADALE",
      "MONTCHANIN",
      "MONTCHANIN VILLAGE",
      "NORTH STAR",
      "OGLETOWN",
      "PORT PENN",
      "PIKE CREEK",
      "ROCKLAND",
      "ST GEORGES",
      "STANTON",
      "WILMINGTON MANOR",
      "WINTERTHUR",
  
      "BETHAL TWP",
      "BETHEL TWP",
      "FAIRFAX",
      "TALLEYVILLE"
  }));
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "BETHAL TWP",   "BETHEL TWP,PA",
      "BETHEL TWP",   "BETHEL TWP,PA",
      "MONTCHANIN VILLAGE", "MONTCHANIN"
  });
}
  