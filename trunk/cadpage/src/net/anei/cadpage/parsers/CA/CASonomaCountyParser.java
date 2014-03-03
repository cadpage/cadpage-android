package net.anei.cadpage.parsers.CA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Sonoma County, CA
 */
public class CASonomaCountyParser extends FieldProgramParser {
  
  public CASonomaCountyParser() {
    super(CITY_LIST, 
           "SONOMA COUNTY", "CA",
           "Loc:ADDR? BOX:BOX TYP:CALL? CN:NAME C#:PHONE TYP:CALL? TYPE_CODE:SKIP CALLER_NAME:NAME CALLER_ADDR:ADDR2/S TIME:TIME COM:INFO");
  }
  
  @Override
  public String getFilter() {
    return "sclec@sonoma-county.org,bc71@srcity.org,ps-cst@Sonoma-county.org";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    body = body.replace(" CN:COM ", " CN: COM:").replace(" CN:COM:", " CN: COM:");
    if (! super.parseMsg(body, data)) return false;
    if (data.strAddress.length() == 0) return false;
    return true;
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("ADDR2")) return new MyAddress2Field();
    if (name.equals("TIME")) return new MyTimeField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private static final Pattern PLACE_MARKER = Pattern.compile(" *: *@? *");
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String fld, Data data) {
      Matcher match = PLACE_MARKER.matcher(fld);
      if (match.find()) {
        data.strPlace = fld.substring(match.end());
        fld = fld.substring(0,match.start());
      }
      if (fld.length() <= 3) {
        data.strSource = fld;
        fld = data.strPlace;
        data.strPlace = "";
      }
      
      int pt = fld.lastIndexOf(',');
      if (pt >= 0) {
        data.strApt = fld.substring(pt+1).trim();
        fld = fld.substring(0, pt);
      }
      
      fld = fld.replace(" AT ", " & ");
      parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, fld, data);
      if (data.strCity.length() > 0) {
        if (data.strSource.length() == 0) data.strSource = data.strCity;
        data.strCity = convertCodes(data.strCity, CITY_CODES);
      } else if (data.strSource.length() > 0) {
        data.strCity = convertCodes(data.strSource, CITY_CODES);
      }
      if (data.strCity.length() <= 3) data.strCity = "";
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR APT CITY SRC PLACE";
    }
  }
  
  private class MyAddress2Field extends MyAddressField {
    @Override
    public void parse(String field, Data data) {
      if (data.strAddress.length() > 0) return;
      super.parse(field, data);
    }
  }
  
  private class MyTimeField extends TimeField {
    @Override 
    public void parse(String field, Data data) {
      if (field.length() < 5) return;
      if (field.length() < 8) field = field.substring(0,5);
      super.parse(field, data);
    }
  }
  
  private static final Pattern GPS_PTN = Pattern.compile("^(?:N )?(-\\d{3}.\\d{4,}) (?:T )?(\\d{2}.\\d{4,})(?: METERS \\d+)? *");
  private static final Pattern JUNK_PTN = Pattern.compile(" *(?:Unit ([A-Z0-9]+) (?:requested case number [A-Z0-9]+|.*)|\\*\\* Case number (?:[A-Z0-9]+ has been assigned for [:A-Z0-9]+|.*)|\\*\\* >>>> (?:by: [A-Z ]+ on terminal: [a-z0-9]+|.*)) *");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      
      Matcher match = GPS_PTN.matcher(field);
      if (match.find()) {
        setGPSLoc(match.group(1)+','+match.group(2), data);
        field = field.substring(match.end());
      }
      
      match = JUNK_PTN.matcher(field);
      if (match.find()) {
        int  last = 0;
        String result = "";
        do {
          result = append(result, " - ", field.substring(last,match.start()));
          last = match.end();
          String unit = match.group(1);
          if (unit !=  null) data.strUnit = append(data.strUnit, " ", unit);
        } while (match.find());
        result = append(result, " - ", field.substring(last));
        field = result;
      }
      
      int pt = field.indexOf("**");
      if (pt >= 0) {
        String tail = field.substring(pt);
        if ("** Case number ".startsWith(tail) || "** >>>> ".startsWith(tail)) {
          field = field.substring(0,pt).trim();
        }
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "GPS INFO UNIT";
    }
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "AGU", "AQUA CALIENTE",
      "ANP", "ANNAPOLIS",
      "AST", "CLOVERDALE",
      "BBY", "BODEGA BAY",
      "BEL", "SANTA ROSA",
      "BEN", "SANTA ROSA",
      "BLO", "PETALUMA",
      "BOD", "BODEGA",
      "BOY", "BOYES HOT SPRINGS",
      "CAM", "CAMP MEEKER",
      "CAZ", "CAZADERO",
      "CL",  "CLOVERDALE",
      "CLO", "CLOVERDALE",
      "CO",  "COTATI",
      "COT", "COTATI",
      "DRC", "HEALDSBURG",
      "DUN", "DUNCANS MILLS",
      "ELD", "ELDRIDGE",
      "ELV", "EL VERANO",
      "FIT", "HEALDSBURG",
      "FOR", "FORESTVILLE",
      "FTR", "FORT ROSS",
      "FUL", "SANTA ROSA",
      "GEY", "GEYSERVILLE",
      "GLE", "GLEN ELLEN",
      "GRA", "GRATON",
      "GUE", "GUERNVILLE",
      "HBG", "HEALDSBURG",
      "HE",  "HEALDSBURG",
      "HEA", "HEALDSBURG",
      "HES", "SEBATOPOL",
      "JCD", "JCD",
      "JEN", "JENNER",
      "KEN", "KENWOOD",
      "KNI", "CALISTOGA",
      "KOR", "FORESTVILLE",
      "LAK", "PETALUMA",
      "LAR", "SANTA ROSA",
      "LKC", "LAKE COUNTY",
      "LSO", "GEYSERVILLE",
      "MAY", "GLEN ELLEN",
      "MEN", "MENDOCINO COUNTY",
      "MRN", "MARIN COUNTY",
      "MRO", "MONTE RIO",
      "MTN", "CALISTOGA",
      "MWS", "SANTA ROSA",
      "NAP", "NAPA",
      "OCC", "OCCIDENTAL",
      "PE",  "PETALUMA",
      "PEN", "PENNGROVE",
      "PET", "PETALUMA",
      "RIN", "SANTA ROSA",
      "RLN", "HEALDSBURG",
      "RND", "RIO NIDO",
      "ROH", "ROHNERT PARK",
      "ROS", "SANTA ROSA",
      "RP",  "ROHNERT PARK",
      "SCH", "SCHELLVILLE",
      "SE",  "SEBATOPOL",
      "SEB", "SEBATOPOL",
      "SO",  "SONOMA",
      "SOL", "SOLANO COUNTY",
      "SON", "SONOMA",
      "SR",  "SANTA ROSA",
      "SRO", "SANTA ROSA",
      "SSU", "ROHNERT PARK",
      "TCG", "PETALUMA",
      "TIM", "TIMBER COVE",
      "TSR", "SEA RANCH",
      "TWI", "SEBATOPOL",
      "TWR", "PETALUMA",
      "VFR", "VALLEY FORD",
      "WI",  "WINDSOR",
      "WIN", "WINDSOR",
      "WSR", "SANTA ROSA",

      "BDGA",      "BODEGA",
      "BDGA BAY",  "BODEGA BAY"
  });
  
  private static final String[] CITY_LIST = CITY_CODES.keySet().toArray(new String[CITY_CODES.size()]);
}
