package net.anei.cadpage.parsers.DE;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class DENewCastleCountyEParser extends FieldProgramParser {
  
  public DENewCastleCountyEParser() {
    super("NEW CASTLE COUNTY", "DE",
          "Tac_#:CH! Date/Time:DATETIME! Call_Address:ADDRCITY/S6Xa! Common_Name:PLACE! Cross_Streets:X! Local_Info:PLACE! Development:CITY! Type:CODE_CALL! Narrative:INFO! INFO/N+ EMS_Dist:MAP! Fire_Quad:MAP! Inc_Numbers:ID! Units_Assigned:UNIT! Alerts:INFO/N! INFO/N+ Status_Times:SKIP");
  }
  
  @Override
  public String getFilter() {
    return "NW911@state.de.us";
  }
  
  private static final Pattern MARKER = Pattern.compile("NCC911 Rip & Run *\\n");
  private static final Pattern RUN_REPORT_PTN = Pattern.compile(".*\nUnits Assigned:(.*?)\n.*?\\sCleared at:.*", Pattern.DOTALL);
  
  @Override
  public boolean parseMsg(String body, Data data) {
    Matcher match = MARKER.matcher(body);
    if (!match.lookingAt()) return false;
    body = body.substring(match.end()).trim();
    
    match = RUN_REPORT_PTN.matcher(body);
    if (match.matches()) {
      data.strCall = "RUN REPORT";
      data.strPlace = body;
      data.strUnit = match.group(1).trim();
      return true;
    }
    
    if (!parseFields(body.split("\n"), data)) return false;
    fixCity(data);
    return true;
  }
  
  private static final DateFormat DATE_TIME_FMT = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME")) return new DateTimeField("\\d\\d?/\\d\\d?/\\d{4} \\d\\d?:\\d\\d:\\d\\d [AP]M", DATE_TIME_FMT, true);
    if (name.equals("ADDRCITY")) return new MyAddressCityField();
    if (name.equals("PLACE")) return new MyPlaceField();
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("CITY")) return new MyCityField();
    if (name.equals("CODE_CALL")) return new MyCodeCallField();
    if (name.equals("MAP")) return new MyMapField();
    return super.getField(name);
  }

  private static final Pattern ADDR_ST_PTN = Pattern.compile("[A-Z]{2}");
  private class MyAddressCityField extends AddressCityField {
    
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      String apt = p.getLastOptional(" Qual:");
      String city = p.getLastOptional(',');
      if (ADDR_ST_PTN.matcher(city).matches()) {
        data.strState = city;
        city = p.getLastOptional(',');
      }
      if (city.toUpperCase().startsWith("INTERSTATE")) city = "";
      data.strCity = city;
      field = p.get().replace('@', '&');
      parseAddress(StartType.START_ADDR, FLAG_RECHECK_APT | FLAG_ANCHOR_END, field, data);
      if (!data.strApt.contains(apt)) data.strApt = append(data.strApt, "-", apt);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " ST";
    }
  }
  
  private static final Pattern PLACE_APT_PTN = Pattern.compile("(.*?)[-, ]*(?:\\b(?:RM|ROOM|APT|LOT|COTTAGE|SUITE)\\b|(?<!REF) #)[ #]*(.+)", Pattern.CASE_INSENSITIVE);
  private class MyPlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      
      // Check for duplicated address line
      int pt = field.lastIndexOf('-');
      if (pt >= 0) {
        if (data.strAddress.startsWith(field.substring(pt+1).trim())) {
          field = field.substring(0,pt).trim();
        }
      }
      
      // Check for apt number
      Matcher match =  PLACE_APT_PTN.matcher(field);
      if (match.matches()) {
        field = match.group(1);
        String apt = match.group(2);
        if (!data.strApt.contains(apt)) {
          data.strApt = append(data.strApt, "-", apt);
        }
      }
      
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "PLACE APT";
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      if (field.equals ("No Cross Streets Found")) return;
      super.parse(field, data);
    }
  }
  
  private class MyCityField extends CityField {
    @Override
    public void parse(String field, Data data) {
      if (data.strCity.length() > 0) return;
      super.parse(field, data);
    }
  }
  
  private class MyCodeCallField extends Field {

    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      String call = p.get(" Priority:");
      String pri = p.get();
      call = suppressDup(call);
      data.strPriority = suppressDup(pri);
      
      int pt = call.indexOf(' ');
      if (pt < 0) abort();
      data.strCode = call.substring(0,pt).trim();
      data.strCall = call.substring(pt+1).trim();
    }
    
    private String suppressDup(String field) {
      int pt = field.indexOf(',');
      if (pt < 0) return field;
      String part1 = field.substring(0,pt).trim();
      String part2 = field.substring(pt+1).trim();
      if (part1.equals(part2)) return part1;
      return field;
    }

    @Override
    public String getFieldNames() {
      return "CODE CALL PRI";
    }
  }
  
  private class MyMapField extends MapField {
    @Override
    public void parse(String field, Data data) {
      if (field.length() == 0) return;
      if (data.strMap.length() == 0) {
        data.strMap = field;
        return;
      }
      if (field.equals(data.strMap)) return;
      data.strMap = "E:" + data.strMap + " F:" + field;
    }
  }
  
  private static final Pattern DEMOTE_CITY_PTN = 
      Pattern.compile(".*\\b(?:TRAILER PARK|PLAZA|(SHOP(?:PING)? (?:CTR|CENTER))|APARTMENTS|APTS|CONDOS|TOWNHOUSES|TWNHSES|MALL|PROFESSIONAL|HOUSE|CENTER)\\b.*", Pattern.CASE_INSENSITIVE);
  static void fixCity(Data data) {
    
    // Sometimes the city field obviously should not be a city
    if (DEMOTE_CITY_PTN.matcher(data.strCity).matches()) {
      String oldPlace = data.strPlace.toUpperCase();
      String newPlace = data.strCity.toUpperCase();
      if (!oldPlace.contains(newPlace)) {
        if (newPlace.contains(oldPlace)) {
          data.strPlace = data.strCity;
        } else {
          data.strPlace = append(data.strPlace, " - ", data.strCity);
        }
      }
      data.strCity = getMapCity(data.strCity);
    }
    
    // Some cities are in other states
    if (data.strState.length() == 0) {
      String st = CITY_ST_TABLE.getProperty(data.strCity);
      if (st != null) data.strState = st;
    }
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    return adjustMapAddressStatic(addr);
  }
  
  static String adjustMapAddressStatic(String addr) {
    addr = PZ_PTN.matcher(addr).replaceAll("PLAZA");
    return addr;
  }
  private static final Pattern PZ_PTN = Pattern.compile("\\bPZ\\b", Pattern.CASE_INSENSITIVE);
  
  @Override
  public String adjustMapCity(String city) {
    return adjustMapCityStatic(city);
  }

  static String adjustMapCityStatic(String city) {
    if (city.length() == 0) return "";
    city = getMapCity(city);
    if (city.length()== 0) city = "NEW CASTLE COUNTY";
    return city;
  }

  private static String getMapCity(String city) {
    String upCity = city.toUpperCase();
    if (CITY_SET.contains(upCity)) return city;
    city = MAP_CITY_TABLE.getProperty(upCity);
    if (city != null) return city;
    return "";
  }
  
  private static final Set<String> CITY_SET = new HashSet<String>(Arrays.asList(
      "ALAPOCAS",
      "ARDEN",
      "ARDENCROFT",
      "ARDENTOWN",
      "BEAR",
      "BELLEFONTE",
      "BROOKSIDE",
      "CHRISTIANA",
      "CLAYMONT",
      "CLAYTON",
      "COLLINS PARK",
      "DELAWARE CITY",
      "EDGEMOOR",
      "ELSMERE",
      "FAIRFAX",
      "GASGOW",
      "GRANOGUE",
      "GREENVILLE",
      "GWINHURST",
      "HOCKESSIN",
      "HOLLY OAK",
      "INDIAN FIELD",
      "MIDDLETOWN",
      "MILL CREEK",
      "MINQUADALE",
      "MONTCHANIN",
      "MONTCHANIN VILLAGE",
      "NEW CASTLE",
      "NEWARK",
      "NEWPORT",
      "NORTH STAR",
      "ODESSA",
      "OGLETOWN",
      "PIKE CREEK",
      "PORT PENN",
      "ROCKLAND",
      "SMYRNA",
      "ST GEORGES",
      "STANTON",
      "TALLEYVILLE",
      "TOWNSEND",
      "WESTOVER HILLS",
      "WILMINGTON",
      "WILMINGTON MANOR",
      "WINTERTHUR",
      "WOODDALE",
      "YORKLYN",
      
      "CHESTER COUNTY",
      "DELAWARE COUNTY",
      "GLOUCESTER COUNTY",
      "SALEM COUNTY",
      "KENT COUNTY",
      "CECIL COUNTY"
  )); 
  
  private static final Properties CITY_ST_TABLE = buildCodeTable(new String[]{
      "CHESTER COUNTY",     "PA",
      "DELAWARE COUNTY",    "PA",
      "GLOUCESTER COUNTY",  "NJ",
      "SALEM COUNTY",       "NJ",
      "CECIL COUNTY",       "MD"
  });
  
  private static final Properties MAP_CITY_TABLE = buildCodeTable(new String[]{
  
      "ASHBOURNE HILLS",              "Claymont",
      "BNAI BRITH HOUSE",             "Claymont",
      "KNOLLWOOD",                    "Claymont",
      "NORTHTOWNE PLAZA",             "Claymont",
      "RADNOR WOODS",                 "Claymont",
      "RIVERSIDE",                    "Claymont",
      "ROLLING PARK",                 "Claymont",
      "STONEYBROOK APARTMENTS",       "Claymont",
      "TRI STATE MALL UPPER LEVEL",   "Claymont",
      "WATER VIEW COURT APARTMENTS",  "Claymont",
      "WOODSTREAM GARDEN APARTMENTS", "Claymont",
      
      "ADARE VILLAGE",                "Hockessin",
      "AUTUMNWOOD",                   "Hockessin",
      "COKESBURY VILLAGE",            "Hockessin",
      "GATEWAY TOWNHOUSES",           "Hockessin",
      "HOCKESSIN CENTER",             "Hockessin",
      "HOCKESSIN HUNT",               "Hockessin",
      "HOCKESSIN VALLEY FALLS",       "Hockessin",
      "HORSESHOE HILLS",              "Hockessin",
      "LANTANA SQUARE SHOPPING CTR.", "Hockessin",
      "MEWS AT HOCKESSIN",            "Hockessin",
      "NINE GATES VALLEY",            "Hockessin",
      "QUAKER HILL",                  "Hockessin",
      "ROLLING RIDGE",                "Hockessin",
      "SNUG HILL",                    "Hockessin",
      "STENNING WOODS",               "Hockessin",
      "STUYVESANT HILLS",             "Hockessin",
      "WALNUT HILL",                  "Hockessin",
      "WELLINGTON HILLS",             "Hockessin",
      "WESTWOODS",                    "Hockessin",
      
      "ARBOR PLACE",                  "New Castle",
      "GARFIELD PARK",                "New Castle",
      "JEFFERSON FARMS",              "New Castle",
      "HOLLOWAY TERRACE",             "New Castle",
      "MINQUADALE TRAILER PARK",      "New Castle",
      "OAKMONT",                      "New Castle",
      "OVERVIEW GARDENS",             "New Castle",
      "ROSE HILL",                    "New Castle",
      "SIMONDS GARDENS",              "New Castle",
      "SWANWYCK",                     "New Castle",
      
      "ALTERSGATE",                   "Newark",
      "BEECH HILL",                   "Newark",
      "BROOKSIDE PARK",               "Newark",
      "CARRINGTON WAY APARTMENTS",    "Newark",
      "CHERRY HILL",                  "Newark",
      "CHESTNUT VALLEY",              "Newark",
      "FAIRFIELD",                    "Newark",
      "FOXWOOD APARTMENTS",           "Newark",
      "GEORGE READ VILLAGE",          "Newark",
      "HARBOR CLUB APARTMENTS",       "Newark",
      "HILLSTREAM",                   "Newark",
      "JARRELL FARMS",                "Newark",
      "LAMBETH RIDING",               "Newark",
      "PENCADER CORPORATE CENTER",    "Newark",
      "PEOPLES PLAZA",                "Newark",
      "POLLY DRUMMOND SHOPPING CENTER","Newark",
      "TODD ESTATES",                 "Newark",
      "UNIVERSITY OF DELAWARE",       "Newark",
      "VICTORIA MEWS APTS",           "Newark",
      "WOODLAND VILLAGE",             "Newark",
  
      "AUGUSTINE PROFESSIONAL CENTER","Wilmington",
      "BALLYMEADE",                   "Wilmington",
      "BELVEDERE",                    "Wilmington",
      "BRANDON",                      "Wilmington",
      "BRANDYWOOD",                   "Wilmington",
      "CARILLON CROSSING",            "Wilmington",
      "CEDAR HEIGHTS",                "Wilmington",
      "CHATHAM",                      "Wilmington",
      "COLONIAL HEIGHTS",             "Wilmington",
      "COLONIAL WOODS",               "Wilmington",
      "CONCORD PLAZA",                "Wilmington",
      "CRANSTON HEIGHTS",             "Wilmington",
      "DEER VALLEY",                  "Wilmington",
      "DREXEL",                       "Wilmington",
      "DUNLEITH",                     "Wilmington",
      "FOULK WOODS",                  "Wilmington",
      "FOULKSTONE PLAZA",             "Wilmington",
      "FURNACE CREEK HOLLOW",         "Wilmington",
      "GORDON HEIGHTS",               "Wilmington",
      "GORDY ESTATES",                "Wilmington",
      "GRAYSTONE PLAZA SHOPPING CTR.", "Wilmington",
      "GRAYLYN CREST",                "Wilmington",
      "GRENDON FARMS",                "Wilmington",
      "HIGHLAND WEST",                "Wilmington",
      "HOLIDAY HILLS",                "Wilmington",
      "KIAMENSI GARDENS",             "Wilmington",
      "LANCASHIRE",                   "Wilmington",
      "LIMESTONE HILLS",              "Wilmington",
      "LONGVIEW COURT APARTMENTS",    "Wilmington",
      "LONGVIEW FARMS",               "Wilmington",
      "MERIDEN",                      "Wilmington",
      "MIDWAY PLAZA SHOPPING CENTER", "Wilmington",
      "NORTHPOINTE AT LIMESTONE HILLS","Wilmington",
      "NORTHWOOD",                    "Wilmington",
      "OAK LANE MANOR",               "Wilmington",
      "OWLS NEST",                    "Wilmington",
      "PARK PLACE TRAILER PARK",      "Wilmington",
      "PLEASANT HILLS",               "Wilmington",
      "RAMBLEWOOD",                   "Wilmington",
      "SILVERBROOK APARTMENTS",       "Wilmington",
      "ST. GEORGES COURT APARTMENTS", "Wilmington",
      "SUMMIT CHASE",                 "Wilmington",
      "ROCKLAND CENTER",              "Wilmington",
      "SILVIEW",                      "Wilmington",
      "SOUTHBRIDGE",                  "Wilmington",
      "TALLEYVILLE SHOP CTR",         "Wilmington",
      "TYBROOK",                      "Wilmington",
      "VALLEY RUN TWNHSES",           "Wilmington",
      "VILLAGE OF HERSHEY RUN CONDOS","Wilmington",
      "WINDYBUSH",                    "Wilmington",
      "WINTERSET FARMS TRAILER PARK", "Wilmington",
      "WOODLAND APARTMENTS",          "Wilmington",
      "WYCLIFFE",                     "Wilmington",
      "WYNNWOOD",                     "Wilmington",
      
      "MANOR PARK",                   "Wilmingon Manor"
      
  });
}
  