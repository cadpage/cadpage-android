package net.anei.cadpage.parsers.IN;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/**
 * Kosciusko County, IN
 */
public class INKosciuskoCountyParser extends DispatchOSSIParser {
  
  public INKosciuskoCountyParser() {
    super(CITY_CODES, "KOSCIUSKO COUNTY", "IN",
           "( CANCEL | FYI CALL ) ADDR! ( END | APTPLACE? CITY/Y END )");
  }
  
  @Override
  public String getFilter() {
    return "CAD@co.marshall.in.us,CAD@kcgov.local,CAD@kcgov.com";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA | MAP_FLG_SUPPR_SR;
  }
  
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    if (subject.length() > 0 && body.startsWith("CAD:;")) {
      body = "CAD:" + subject + body.substring(3);
    }
    if (!super.parseMsg(body, data)) return false;
    
    // A city starting with a digit probably means this is a Marshall County page
    // In any case we don't want to accept it
    if (data.strCity.length() > 0 && Character.isDigit(data.strCity.charAt(0))) return false;
    return true;
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CANCEL")) return new CallField("CANCEL", true);
    if (name.equals("APTPLACE")) return new MyAptPlaceField();
    return super.getField(name);
  }
  
  private static final Pattern APT_MARK_PTN = Pattern.compile("\\(S\\) \\(N\\)|\\([NS]\\)");
  private class MyAptPlaceField extends AptField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = APT_MARK_PTN.matcher(field);
      if (match.find()) {
        data.strPlace = field.substring(match.end()).trim();
        field = field.substring(0,match.start()).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "APT PLACE";
    }
  }

  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "952",  "MARION",
      "AKRN", "AKRON",
      "ATW",  "ATWOOD",
      "BREM", "BREMEN",
      "BRK",  "BURKET",
      "CLAY", "CLAYPOOL",
      "COL",  "COLUMBIA CITY",
      "CROM", "CROMWELL",
      "EG",   "ETNA GREEN",
      "FTW",  "FT WAYNE",
      "GOSH", "GOSHEN",
      "KIM",  "KIMMELL",
      "LAR",  "LARWILL",
      "LEES", "LEESBURG",
      "MENT", "MENTONE",
      "MILF", "MILFORD",
      "NAPP", "NAPPANEE",
      "NW",   "NORTH WEBSTER",
      "PIE",  "PIERCETON",
      "PIER", "PIERCETON",
      "PLY",  "PLYMOUTH",
      "ROA",  "ROANN",
      "ROCH", "ROCHESTER",
      "SID",  "SIDNEY",
      "SL",   "SILVER LAKE",
      "SWHT", "SOUTH WHITLEY",
      "SYR",  "SYRACUSE",
      "TIPP", "TIPPECANOE",
      "WAR",  "WARSAW",
      "WL",   "WINONA LAKE"
      
  });
}
