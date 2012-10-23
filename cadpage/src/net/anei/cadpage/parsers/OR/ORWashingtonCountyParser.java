package net.anei.cadpage.parsers.OR;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Washington County, OR
 * Also Clackamas County
 */
public class ORWashingtonCountyParser extends FieldProgramParser {
  
  public ORWashingtonCountyParser() {
    this("WASHINGTON COUNTY", "OR");
  }
  
  public ORWashingtonCountyParser(String defCity, String defState) {
    super(defCity, defState,
           "ADDR/SC! MAP:MAP UNIT:UNIT!");
  }
  
  @Override
  public String getAliasCode() {
    return "ORWashingtonCounty";
  }
  
  @Override
  public String getFilter() {
    return "930010,777";
  }

  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      String addr;
      String city = p.getLastOptional(')');
      if (city.length() > 0) {
        addr = p.get('(');
        data.strCross = p.get();
      } else {
        city = p.getLast(' ');
        addr = p.get();
      }
      parseAddress(StartType.START_CALL, addr, data);
      data.strCity = convertCodes(city, CITY_CODES);
      
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " X CITY";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
  @Override
  public String adjustMapAddress(String sAddress) {
    StringBuffer sb = new StringBuffer();
    Matcher match = XX_PTN.matcher(sAddress);
    while (match.find()) {
      match.appendReplacement(sb, convertCodes(match.group(), STREET_CODES));
    }
    match.appendTail(sb);
    return sb.toString();
  }
  private static final Pattern XX_PTN = Pattern.compile("\\b[A-Z]{2}\\b");
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "ALO", "ALOHA",
      "AMI", "AMITY",
      "ARI", "ARIEL",
      "AUM", "AUMSVILLE",
      "AUR", "AURORA",
      "BAN", "BANKS",
      "BEA", "BEAVERCREEK",
      "BIN", "BINGEN",
      "BOR", "BORING",
      "BRI", "BRIGHTWOOD",
      "BRV", "BRIDAL VEIL",
      "BTN", "BEAVERTON",
      "BUX", "BUXTON",
      "CAN", "CANBY",
      "CAR", "CARLTON",
      "CAS", "CASCADE LOCKS",
      "CLA", "CLACKAMAS",
      "COL", "COLTON",
      "CON", "CORNELIUS",
      "COR", "CORBET",
      "DAL", "DALLESPORT",
      "DAM", "DAMASCUS",
      "DAY", "DAYTON",
      "DET", "DETROIT",
      "DUF", "DUFUR",
      "DUN", "DUNDEE",
      "EAG", "EAGLE CREEK",
      "EST", "ESTACADA",
      "FAI", "FAIRVIEW",
      "FOR", "FOREST GROVE",
      "GAL", "GALES CREEK",
      "GAS", "GASTON",
      "GAT", "GATES",
      "GER", "GERVAIS",
      "GLA", "GLADSTONE",
      "GOV", "GOVERNMENT CAMP",
      "GRE", "GRESHAM",
      "HAP", "HAPPY VALLEY",
      "HIL", "HILLSBORO",
      "HOO", "HOOD RIVER",
      "HUB", "HUBBARD",
      "IDA", "IDANHA",
      "IND", "INDEPENDENCE",
      "JEF", "JEFFERSON",
      "KEI", "KEIZER",
      "LAF", "LAFAYETTE",
      "LAK", "LAKE OSWEGO",
      "LYL", "LYLE",
      "LYO", "LYONS",
      "MAN", "MANNING",
      "MAR", "MARYLHURST",
      "MAU", "MAUPIN",
      "MCM", "MCMINNVILLE",
      "MCY", "MILL CITY",
      "MIL", "MILWAUKIE",
      "MOL", "MOLALLA",
      "MOS", "MOSIER",
      "MOU", "MOUNT ANGEL",
      "MTH", "MT HOOD PARKDALE",
      "MUL", "MULINO",
      "NEW", "NEWBERG",
      "NOR", "NORTH PLAINS",
      "ODE", "ODELL",
      "ORE", "OREGON CITY",
      "ORI", "ORIENT",
      "POR", "PORTLAND",
      "RHO", "RHODODENDRON",
      "RIC", "RICKREALL",
      "RID", "RIDGEFIELD",
      "SAL", "SALEM",
      "SAN", "SANDY",
      "SCA", "SCAPPOOSE",
      "SCO", "SCOTTS MILLS",
      "SDN", "SHERIDAN",
      "SEA", "SEASIDE",
      "SHE", "SHERWOOD",
      "SIL", "SILVERTON",
      "STA", "STAYTON",
      "STE", "STEVENSON",
      "STP", "SAINT PAUL",
      "SUB", "SUBLIMITY",
      "THE", "THE DALLES",
      "TIG", "TIGARD",
      "TIM", "TIMBER",
      "TRO", "TROUTDALE",
      "TUA", "TUALATIN",
      "TUR", "TURNER",
      "TYG", "TYGH VALLEY",
      "UND", "UNDERWOOD",
      "USF", "US FOREST SVC",
      "VAN", "VANCOUVER",
      "VER", "VERNONIA",
      "WAR", "WARM SPRINGS",
      "WEL", "WELCHES",
      "WES", "WEST LINN",
      "WHI", "WHITE SALMON",
      "WIL", "WILSONVILLE",
      "WOO", "WOODBURN",
      "YAM", "YAMHILL",
      "RVR", "RIVER FEATURES"
  });
  
  private static final Properties STREET_CODES = buildCodeTable(new String[]{
      "AL", "ALLEY",
      "AN", "ANNEX",
      "AR", "ARCADE",
      "AV", "AVE",
      "BC", "BEACH",
      "BG", "BRIDGE",
      "BL", "BLUFF",
      "BN", "BEND",
      "BP", "BYPASS",
      "BT", "BOTTOM",
      "BV", "BOULEVARD",
      "CC", "CRESCENT",
      "CE", "COURSE",
      "CI", "CIRCLE",
      "CO", "CORRIDOR",
      "CR", "CREST",
//      "CT", "COURT",
      "CX", "CROSSING",
//      "DR", "DRIVE",
//      "EO", "EAST OF",
      "EX", "EXPRESSWAY",
      "FA", "FALL",
      "FG", "FRONTAGE",
      "FK", "FORK",
      "FL", "FIELD",
      "FR", "FERRY",
      "FS", "FOREST",
      "FT", "FORT",
      "FY", "FREEWAY",
      "GD", "GARDENS",
      "GL", "GLEN",
      "GR", "GREEN",
      "GT", "GATEWAY",
      "HL", "HILL",
      "HO", "HOLLOW",
      "HT", "HEIGHTS",
      "HW", "HWY",
      "IL", "ISLE",
      "IN", "INLET",
      "IS", "ISLAND",
      "JC", "JUNCTION",
      "LC", "LOCKS",
      "LD", "LANDING",
      "LG", "LODGE",
      "LK", "LAKE",
      "LN", "LANE",
      "LP", "LOOP",
      "MA", "MALL",
      "MD", "MEADOWS",
      "ML", "MILE",
      "MN", "MOUNTAIN",
      "MP", "MILE POST",
      "MT", "MOUNTAIN",
      "MW", "MOLALLA WESTERN",
      "OR", "ORCHARD",
      "OV", "OVAL",
      "PA", "PATH",
      "PI", "PIKE",
      "PK", "PARKWAY",
//      "PL", "PLACE",
      "PO", "PORT",
      "PS", "PASS",
      "PT", "POINT",
      "PW", "PORTLAND WESTERN",
      "PZ", "PLAZA",
      "RA", "RAMP",
//      "RD", "ROAD",
      "RG", "RIDGE",
      "RI", "RIVER  ",
      "RM", "RIVER MILE",
      "RN", "RANCH",
      "RP", "RAPIDS",
      "RR", "RAILROAD",
      "RU", "RUN",
      "RW", "ROW",
      "SA", "STATION",
//      "SE", "STREAM",
      "SH", "SHORE",
      "SL", "SHOAL",
      "SQ", "SQUARE",
      "SR", "SHORE",
//      "ST", "STREET",
      "SU", "SPUR",
      "TA", "TERRACE",
      "TC", "TRACK",
      "TE", "TERRACE",
      "TK", "TURNPIKE",
      "TL", "TRAIL",
      "TR", "TRAIL",
      "TU", "TUNNEL",
      "UN", "UNION   ",
      "UP", "UNION PACIFIC",
      "VG", "VILLIAGE",
      "VI", "VIA",
      "VL", "VILLIAGE",
      "VS", "VISTA",
      "VW", "VIEW",
      "VY", "VALLEY",
      "WA", "WALK",
//      "WO", "WEST OF",
      "WY", "WAY"
  });
}
