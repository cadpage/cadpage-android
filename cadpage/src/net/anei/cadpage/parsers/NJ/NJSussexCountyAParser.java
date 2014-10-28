package net.anei.cadpage.parsers.NJ;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class NJSussexCountyAParser extends SmartAddressParser {
  
  private static final Pattern SUBJECT_PTN = Pattern.compile("[A-Z]{1,5}-?[A-Z]?\\d{4}-?\\d{5,6}");
  private static final Pattern MASTER_PTN = 
    Pattern.compile("([-A-Za-z0-9 ]+) @ ([^,]+?) *, ([^-]*) -(?: (.*?)[-\\.]*)?(?: +Active Units: *(.*))?"); 
  private static final Pattern END_STAR_PTN = Pattern.compile("([A-Z0-9])\\*");
  private static final Pattern LEAD_INFO_JUNK_PTN = Pattern.compile("^[-\\*\\. ]+");
  
  public NJSussexCountyAParser() {
    super(CITY_LIST, "SUSSEX COUNTY", "NJ");
    setFieldList("ID CODE CALL ADDR APT CITY INFO UNIT");
  }
  
  @Override
  public String getFilter() {
    return "@NPD.local";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (! SUBJECT_PTN.matcher(subject).matches()) return false;
    data.strCallId = subject;
    body = body.replace('\n', ' ');
    Matcher match = MASTER_PTN.matcher(body);
    if (!match.matches()) return false;
    data.strCall = match.group(1).trim().toUpperCase();
    String call = CALL_CODES.getProperty(data.strCall);
    if (call != null) {
      data.strCode = data.strCall;
      data.strCall = call;
    }
    
    parseAddress(StartType.START_ADDR, FLAG_NO_CITY | FLAG_ANCHOR_END | FLAG_RECHECK_APT, match.group(2).trim(), data);
    String city = stripFieldEnd(match.group(3).trim(), ".");
    String sInfo = getOptGroup(match.group(4));
    data.strUnit = getOptGroup(match.group(5));
    
    int pt = city.lastIndexOf(',');
    if (pt >= 0) {
      data.strApt = append(data.strApt, ", ", city.substring(0,pt).trim());
      city = city.substring(pt+1).trim();
    }
    data.strCity = city;
    
    if (data.strCity.equals("OUT OF TOWN")) {
      data.strCity = data.defCity = data.defState = "";
    }
    if (data.strAddress.equals("OUT OF TOWN")) {
      String defCity = data.strCity;
      data.strCity = "";
      data.strAddress = "";
      sInfo = stripFieldStart(sInfo, "*");
      sInfo = END_STAR_PTN.matcher(sInfo).replaceFirst("$1 *");
      parseAddress(StartType.START_OTHER, FLAG_IGNORE_AT, sInfo, data);
      data.strCall = append(data.strCall, " - ", getStart());
      data.strSupp = getLeft();
      if (data.strAddress.length() == 0) data.strAddress = "OUT OF TOWN";
      if (data.strCity.length() == 0) {
        if (data.strSupp.startsWith("IN ")) {
          Parser p = new Parser(data.strSupp.substring(3).trim());
          data.strCity = p.get(' ');
          if (data.strCity.length() > 0) {
            data.strSupp = p.get();
          }
        }
        else if (data.strSupp.startsWith("(")) {
          pt = data.strSupp.indexOf(')');
          if (pt >= 0) {
            data.strCity = data.strSupp.substring(1,pt).trim();
            data.strSupp = data.strSupp.substring(pt+1).trim();
          }
        }
        if (data.strCity.length() == 0) data.strCity = defCity;
        if (data.strCity.length() == 0) data.defCity = data.defState = "";
      }
    } else {
      data.strSupp = sInfo;
    }
    data.strCity = stripFieldEnd(data.strCity, " BOROUGH");
    data.strSupp = LEAD_INFO_JUNK_PTN.matcher(data.strSupp).replaceFirst("");
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{

    "ANDOVER",
    "ANDOVER BOROUGH",
    "BRANCHVILLE",
    "BYRAM CENTER",
    "CRANDON LAKES",
    "CRANDON LAKES",
    "FRANKFORD",
    "FREDON",
    "GLENWOOD",
    "HIGHLAND LAKES",
    "HOPATCONG",
    "LAFAYETTE",
    "LAKE MOHAWK",
    "MCAFEE",
    "NEWTON",
    "OGDENSBURG",
    "ROSS CORNER",
    "SPARTA",
    "STANHOPE",
    "STILLWATER",
    "SUSSEX",
    "VERNON CENTER",
    "VERNON VALLEY",

    "ANDOVER TWP",
    "BYRAM TWP",
    "FRANKFORD TWP",
    "FRANKLIN",
    "FREDON TWP",
    "GREEN TWP",
    "HAMBURG",
    "HAMPTON TWP",
    "HARDYSTON TWP",
    "LAFAYETTE TWP",
    "MONTAGUE TWP",
    "SANDYSTON TWP",
    "SPARTA TWP",
    "STILLWATER TWP",
    "VERNON TWP",
    "WALPACK TWP",
    "WANTAGE TWP",
    
    "WARREN COUNTY",
      
    "ALLAMUCHY",
    "ALLAMUCHY TWP",
    "ALPHA",
    "ANDERSON",
    "ASBURY",
    "BEATYESTOWN",
    "BELVIDERE",
    "BLAIRSTOWN",
    "BLAIRSTOWN TWP",
    "BRAINARDS",
    "BRASS CASTLE",
    "BRIDGEVILLE",
    "BROADWAY",
    "BROOKFIELD",
    "BUTTZVILLE",
    "CHANGEWATER",
    "COLUMBIA",
    "DELAWARE",
    "DELAWARE PARK",
    "FINESVILLE",
    "FRANKLIN TWP",
    "FRELINGHUYSEN TWP",
    "GREAT MEADOWS",
    "GREENWICH",
    "GREENWICH TWP",
    "HACKETTSTOWN",
    "HAINESBURG",
    "HARDWICK",
    "HARDWICK TWP",
    "HARMONY",
    "HARMONY TWP",
    "HOPE",
    "HOPE TWP",
    "HUTCHINSON",
    "INDEPENDENCE TWP",
    "JOHNSONBURG",
    "KNOWLTON TWP",
    "LIBERTY TWP",
    "LOPATCONG OVERLOOK",
    "LOPATCONG TWP",
    "MANSFIELD TWP",
    "MARKSBORO",
    "MOUNT HERMON",
    "MOUNTAIN LAKE",
    "NEW VILLAGE",
    "OXFORD",
    "OXFORD TWP",
    "PANTHER VALLEY",
    "PHILLIPSBURG",
    "POHATCONG TWP",
    "PORT COLDEN",
    "PORT MURRAY",
    "SILVER LAKE",
    "STEWARTSVILLE",
    "UPPER POHATCONG",
    "UPPER STEWARTSVILLE",
    "VIENNA",
    "WASHINGTON",
    "WASHINGTON TWP",
    "WHITE TWP"
  };
  
  private static final Properties CALL_CODES = buildCodeTable(new String[]{
      // "1045F",    "1045F",
      "ALARMF",   "FIRE ALARM",
      "ALMCO",    "FIRE ALARM CO",
      "ALMCOM",   "FIRE ALARM CO",
      "ALMRES",   "FIRE ALARM RES",
      // "BURN-F",   "BURN-F",
      // "ASSIST-F", "ASSIST-F",
      "FDPLANE",  "FIRE AIRCRAFT",
      // "FFIRA",    "FFIRA",
      // "FIREPD",   "FIREPD",
      "FUEL",     "FUEL SPILL",   
      // "HAZODR",   "HAZODR",
      "MED",      "MEDICAL",
      // "MEDALS",   "MEDALS",
      "MVA-F",    "MV CRASH W/INJURY",
      "MVAINJ",   "MV CRASH W/INJURY",
      "PUBAST",   "PUBLIC ASSIST",
      // "PUMP",     "PUMP",
      "TRANSF",   "TRANSFER",
      
      "FALARM",   "FIRE ALARM",
      "FALCO",    "FIRE ALARM CO",
      "FBRSH",    "FIRE BRUSH",
      "FBRUSH",   "FIRE BRUSH",
      "FGAS",     "FIRE GAS LEAK",
      "FIRE",     "FIRE",                   // Was FIRE LANDING ZONE ???
      "FMA",      "FIRE MUTUAL AID",
      "FOTHER",   "FIRE OTHER",
      "FSMKCOND", "SMOKE CONDITION",
      "FSTRUC",   "STRUCTURE FIRE",
      "FSTRUCT",  "FIRE STRUCTURE",
      "FVEHICLE", "FIRE VEHICLE",
      "MDSTB",    "MEDICAL STAND BY",
      "MEDEM",    "MEDICAL EMERGENCY",
      "MEDMA",    "MEDICAL MUTUAL AID",
      "MGAS",     "EMS GAS LEAK",
      "MVCIEMS",  "MV CRASH W/INJURY",
      "MVCIFD",   "MV CRASH W/INJURY"
      
  });
}
