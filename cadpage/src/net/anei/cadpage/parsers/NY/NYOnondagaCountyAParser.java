package net.anei.cadpage.parsers.NY;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


/**
 * Onondaga County, NY
 */
public class NYOnondagaCountyAParser extends FieldProgramParser {

  private static final Pattern MARKER = Pattern.compile("^(?:(?:(?:I/)?CAD MSG )?([A-Z]+) +)?(\\d\\d:\\d\\d:\\d\\d) +");
  
  private static final Pattern CITY_EXP_PTN = Pattern.compile("\\b(TMA),[A-Z]\\b");

  public NYOnondagaCountyAParser() {
    super(CITY_CODES, "ONONDAGA COUNTY", "NY",
           "ADDR/SXP! XTS:X! P:PRI Lev:SKIP X:INFO Disp:UNIT%");
  }
  
  @Override
  public String getFilter() {
    return "e9web1@ongov.net,messaging@emergencysmc.com,@notifyatonce.net";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // Some services split message into subject and message
    if (subject.startsWith("CAD MSG")) {
      body = subject + " " + body;
    }
    
    // Make sure pages starts with initial marker
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    data.strSource = getOptGroup(match.group(1));
    data.strTime = match.group(2);
    body = body.substring(match.end());
    
    // Drop line breaks and duplicate blanks
    body = body.replace('\n', ' ').replaceAll("  +", " ");
    body = CITY_EXP_PTN.matcher(body).replaceAll("$1");
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return "SRC TIME " + super.getProgram();
  }
  
  private static final Pattern ADDR_COUNTY_PTN = Pattern.compile(" +(CAY|COR|MAD|OND|ONO|OSW)$");
  private static final Pattern ADDR_ZIP_PTN = Pattern.compile(" +(13\\d{3})$");
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      
      // Some times there is a county field, and sometimes there is not.  In any
      // case, we can ignore it and rely on the city code in front of it
      Matcher match = ADDR_COUNTY_PTN.matcher(field);
      if (match.find()) field = field.substring(0,match.start());
      
      String sPlace = "";
      int pt = field.indexOf(':');
      if (pt >= 0) {
        sPlace = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
        if (sPlace.startsWith("@")) sPlace = sPlace.substring(1).trim();
      }
      if (field.startsWith("/")) {
        data.strAddress = field;
      } else {
        super.parse(field, data);
      }
      data.strPlace = append(data.strPlace, " / ", sPlace);
      match = ADDR_ZIP_PTN.matcher(data.strAddress);
      if (match.find()) {
        if (data.strCity.length() == 0) data.strCity = match.group(1);
        data.strAddress = data.strAddress.substring(0,match.start());
      }
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      String cross = p.get(',');
      if (data.strAddress.startsWith("/")) {
        if (data.strCity.length() == 0) {
          data.strCity = convertCodes(data.strAddress.substring(1).trim(), CITY_CODES);
        }
        data.strAddress = "";
        parseAddress(cross, data);
      } else {
        super.parse(cross, data);
      }
      String place = p.get(',');
      if (place.startsWith("APT ")) {
        data.strApt = place.substring(4).trim();
      } else {
        if (place.startsWith("IFO")) place = place.substring(3).trim();
        data.strPlace = append(data.strPlace , " / ", place);
      }
      String call = p.get();
      if (call.length() == 0) abort();
      if (call.endsWith("-")) call = call.substring(0,call.length()-1).trim();
      data.strCall = call;
    }
    
    @Override
    public String getFieldNames() {
      return "X CALL";
    }
  }

  // Remove redundant date/time from info field
  private static final Pattern DATE_TIME_PTN = Pattern.compile("\\b\\d\\d/\\d\\d \\d\\d:\\d\\d:\\d\\d:\\b");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = DATE_TIME_PTN.matcher(field);
      if (match.find()) {
        field = append(field.substring(0,match.start()).trim(), " ", field.substring(match.end()));
      }
      super.parse(field, data);
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  @Override
  public String adjustMapAddress(String address) {
    address = ROUTE_11_PTN.matcher(address).replaceAll("NEW YORK STATE BICYCLE ROUTE 11");
    address = ROUTE_20_PTN.matcher(address).replaceAll("US 20");
    return address;
  }
  private static final Pattern ROUTE_11_PTN = Pattern.compile("\\b(?:RT|ROUTE) *11\\b");
  private static final Pattern ROUTE_20_PTN = Pattern.compile("\\b(?:RT|ROUTE) *20\\b");
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      
      // Cayuga County
      "OCAU", "AUBURN CITY",
      "OTAR", "AURELIUS",
      "OTBT", "BRUTUS",
      "OTCA", "CAYUGA",
      "OTCQ", "CONQUEST",
      "OTCT", "CATO",
      "OTFL", "FLEMING",
      "OTGN", "GENOA",
      "OTIR", "IRA",
      "OTLD", "LEDYARD",
      "OTLO", "LOCKE",
      "OTME", "MERIDIAN",
      "OTMN", "MONTEZUMA",
      "OTMO", "MORAVIA",
      "OTNI", "NILES",
      "OTOW", "OWASCO",
      "OTSE", "SENNETT",
      "OTSM", "SUMMERHILL",
      "OTSN", "SEMPRONIUS",
      "OTSO", "SCIPIO",
      "OTSP", "SPRINGPORT",
      "OTSR", "STERLING",
      "OTTH", "THROOP",
      "OTVC", "VICTORY",
      "OTVN", "VENICE",
      "OVAU", "AURORA",
      "OVCT", "CATO",
      "OVFH", "FAIR HAVEN",
      "OVME", "MENTZ",
      "OVMO", "MORAVIA",
      "OVPO", "PORT BYRON",
      "OVUS", "UNION SPRINGS",
      "OVWE", "WEEDSPORT",
      
      // Cortland County
      "OCCO", "CORTLAND CITY",
      "OTCN", "CINCINNATUS",
      "OTCO", "CORTLANDVILLE",
      "OTCU", "CUYLER",
      "OTFT", "FREETOWN",
      "OTHO", "HOMER",
      "OTHR", "HARFORD",
      "OTLP", "LAPEER",
      "OTMR", "MARATHON",
      "OTPB", "PREBLE",
      "OTSL", "SOLON",
      "OTST", "SCOTT",
      "OTTA", "TAYLOR",
      "OTTX", "TRUXTON",
      "OTVG", "VIRGIL",
      "OTWI", "WILLETT",
      "OVHO", "HOMER",
      "OVMC", "MCGRAW",
      "OVMR", "MARATHON",
      
      // Madison County
      "OCON", "ONEIDA CITY",
      "OTBK", "BROOKFIELD",
      "OTCZ", "CAZENOVIA",
      "OTDR", "DERUYTER TOWN",
      "OTEA", "EATON",
      "OTFE", "FENNER",
      "OTGE", "GEORGETOWN",
      "OTHM", "HAMILTON",
      "OTLB", "LEBANON",
      "OTLI", "LINCOLN",
      "OTLN", "LENOX",
      "OTMD", "MADISON",
      "OTNE", "NELSON",
      "OTSF", "SMITHFIELD",
      "OTSK", "STOCKBRIDGE",
      "OTSV", "SULLIVAN",
      "OVCH", "CHITTENANGO",
      "OVCN", "CANASTOTA",
      "OVCZ", "CAZENOVIA",
      "OVDR", "DERUYTER",
      "OVEA", "EARLVILLE",
      "OVHM", "HAMILTON",
      "OVMD", "MADISON",
      "OVMU", "MUNNSVILLE",
      "OVMV", "MORRISVILLE",
      "OVWM", "WAMPSVILLE",
      
      // Oneida County
      "OCRO", "ROME CITY",
      "OCSH", "SHERRILL CITY",
      "OCUT", "UTICA CITY",
      "OTAN", "AUBURN",
      "OTAU", "AUGUSTA",
      "OTAV", "AVA",
      "OTBO", "BOONVILLE",
      "OTBR", "BRIDGEWATER",
      "OTCM", "CAMDEN",
      "OTDE", "DERUYTER",
      "OTFO", "FORESTPORT",
      "OTFR", "FLORENCE",
      "OTFY", "FLOYD",
      "OTKI", "KIRKLAND ",
      "OTLE", "LEE",
      "OTML", "MARSHALL",
      "OTMY", "MARCY",
      "OTNH", "NEW HARTFORD",
      "OTPS", "PARIS",
      "OTRE", "REMSEN",
      "OTSA", "SANGERFIELD",
      "OTSE", "STEUBEN",
      "OTTR", "TRENTON",
      "OTVE", "VERNON",
      "OTVI", "VIENNA",
      "OTVR", "VERONA",
      "OTWE", "WESTMORELAND",
      "OTWH", "WHITESTOWN",
      "OTWS", "WESTERN",
      "OVBA", "BARNEVELD",
      "OVBO", "BOONVILLE",
      "OVBR", "BRIDGEWATER",
      "OVCA", "CAMDEN",
      "OVCI", "CLINTON",
      "OVCY", "CLAYVILLE",
      "OVHP", "HOLLAND PATENT",
      "OVNH", "NEW HARTFORD",
      "OVNY", "NEW YORK MILLS",
      "OVOC", "ONEIDA CASTLE",
      "OVOF", "ORISKANY FALLS",
      "OVOR", "ORISKANY",
      "OVPR", "PREBLE",
      "OVRE", "REMSEN",
      "OVSY", "SYLVAN BEACH",
      "OVVE", "VERNON",
      "OVWA", "WATERVILLE",
      "OVWH", "WHITESBORO",
      "OVYO", "YORKVILLE",
      
      // Onondaga County
      "NAT",  "ONONDAGA NATION",
      "SYR",  "SYRACUSE CITY",
      "SYR",  "SYRACUSE CITY",
      "TCI",  "CICERO",
      "TCL",  "CLAY",
      "TCM",  "CAMILLUS",
      "TDW",  "DEWITT",
      "TEB",  "ELBRIDGE",
      "TFB",  "FABIUS",
      "TGD",  "GEDDES",
      "TLF",  "LAFAYETTE",
      "TLY",  "LYSANDER",
      "TMA",  "MANLIUS",
      "TMR",  "MARCELLUS",
      "TON",  "ONONDAGA",
      "TOT",  "OTISCO",
      "TPO",  "POMPEY",
      "TSK",  "SKANEATELES",
      "TSL",  "SALINA",
      "TSP",  "SPAFFORD",
      "TTU",  "TULLY",
      "TVB",  "VAN BUREN",
      "TVB",  "VANBUREN",
      "VBV",  "BALDWINSVILLE",
      "VCM",  "CAMILLUS",
      "VEB",  "ELBRIDGE",
      "VES",  "EAST SYRACUSE",
      "VFB",  "FABIUS",
      "VFY",  "FAYETTEVILLE",
      "VJR",  "JORDAN",
      "VLV",  "LIVERPOOL",
      "VMA",  "MANLIUS",
      "VMI",  "MINOA",
      "VMR",  "MARCELLUS",
      "VNS",  "NORTH SYRACUSE",
      "VSK",  "SKANEATELES",
      "VSV",  "SOLVAY",
      "VTU",  "TULLY",
      
      // Oswego County
      "OCFU", "FULTON CITY",
      "OCOS", "OSWEGO CITY",
      "OTAL", "ALBION",
      "OTAM", "AMBOY",
      "OTBY", "BOYLSTON",
      "OTCS", "CONSTANTIA",
      "OTGR", "GRANBY",
      "OTHN", "HANNIBAL",
      "OTHS", "HASTINGS",
      "OTHV", "NEW HAVEN",
      "OTMI", "MINETTO",
      "OTMX", "MEXICO",
      "OTOR", "ORWELL",
      "OTOS", "OSWEGO",
      "OTPA", "PARISH",
      "OTPL", "PALERMO",
      "OTRF", "REDFIELD",
      "OTRI", "RICHLAND",
      "OTSB", "SCRIBA",
      "OTSC", "SANDY CREEK",
      "OTSH", "SCHROEPPEL",
      "OTVL", "VOLNEY",
      "OTWM", "WEST MONROE",
      "OTWT", "WILLIAMSTOWN",
      "OVAT", "ALTMAR",
      "OVCL", "CLEVELAND",
      "OVCS", "CENTRAL SQUARE",
      "OVHN", "HANNIBAL",
      "OVLA", "LACONA",
      "OVMX", "MEXICO",
      "OVPA", "PARISH",
      "OVPF", "PHOENIX",
      "OVPU", "PULASKI",
      "OVSC", "SANDY CREEK",

  });
  
}
	