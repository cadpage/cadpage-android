package net.anei.cadpage.parsers.TX;

import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;
/**
 * Parker County, TX
 */
public class TXParkerCountyParser extends FieldProgramParser {
  
  private static final Pattern DELIM = Pattern.compile(" *\n+ *");
  
  public TXParkerCountyParser() {
    super("PARKER COUNTY", "TX",
        "TITLE CALL STATION SRC PLACE_NAME PLACE ADDRESS ADDR CROSS_STREET X CITY_T CITY LAT_LONG GPS MAP_T MAP DETAILS! INFO+");
  }
  
  public String getFilter() {
    return "Fire.Dispatch@parkercountytx.com";
  }
  
  protected boolean parseMsg(String body, Data data) {
    if (!parseFields(DELIM.split(body), 14, data)) return false;
    data.strCross = clean(data.strCross);
    data.strCity = clean(data.strCity);
    data.strMap = clean(data.strMap);
    data.strGPSLoc = clean(data.strGPSLoc);
    
    String city = PLACE_CITY_XREF.getProperty(data.strCity.toUpperCase());
    if (city != null) {
      data.strPlace = append(data.strCity, " - ", data.strPlace);
      data.strCity = city;
    }
    return true;
  }
  
  private String clean(String field) {
    if (field.equals("NA") || field.equals("N/A")) return "";
    return field;
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("TITLE")) return new SkipField("Title", true);
    if (name.equals("STATION")) return new SkipField("Station", true);
    if (name.equals("PLACE_NAME")) return new SkipField("Place Name", true);
    if (name.equals("ADDRESS")) return new SkipField("Address");
    if (name.equals("CROSS_STREET")) return new SkipField("Cross Street", true);
    if (name.equals("CITY_T")) return new SkipField("City", true);
    if (name.equals("LAT_LONG")) return new SkipField("Lat/Long", true);
    if (name.equals("MAP_T")) return new SkipField("Map", true);
    if (name.equals("DETAILS")) return new SkipField("Details", true);
    return super.getField(name);
  }
  
  private static final Properties PLACE_CITY_XREF = buildCodeTable(new String[]{
      "SILVERCREEK",        "AZLE",
      "LAKE COUNTRY ACRES",  ""
  });
}
