package net.anei.cadpage.parsers.PA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Wyoming County, PA
 */
public class PAWyomingCountyParser extends DispatchOSSIParser {
  public PAWyomingCountyParser() {
    super(CITY_CODE, "WYOMING COUNTY", "PA",
          "CALL! ADDRCITY ( ( CITY | PLACE CITY! ) X/Z+? UNIT! " +
                         "| UNIT! | X X/Z+? UNIT! | PLACE X/Z+? UNIT! ) INFO+");
    setupCities(CITY_LIST);
  }

  @Override
  public String getFilter() {
    return "CAD@wycopa911.org";
  }
  
  private static final String UNIT_PATTERN_S
    = "[A-Z]{1,5}(?:\\d{1,3}(?:[A-Z]\\d{0,2})?)?";
  @Override
  public Field getField(String name) {
    if (name.equals("PLACE")) return new MyPlaceField();
    if (name.equals("UNIT")) return new UnitField(UNIT_PATTERN_S+"(?:,"+UNIT_PATTERN_S+")*,?", true);
    return super.getField(name);
  }
  
  private Pattern PLACE_CITY_PTN = Pattern.compile("(.*?)(?:\\(S\\) *)?\\(N\\)(.*)");
  private class MyPlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = PLACE_CITY_PTN.matcher(field);
      if (match.matches()) {
        field = match.group(1).trim();
        if (data.strCity.length() == 0) {
          String city = match.group(2).trim();
          if (city.equals("EXETER TWP LUZERNE")) city = "EXETER TWP";
          else city = stripFieldEnd(city, " BOROUGH");
          data.strCity = city;
        }
      }
      super.parse(field, data);
    }
  }
  
  private static final Properties CITY_CODE = buildCodeTable(new String[] {
    "DALL",               "DALLAS",
    "DALT",               "DALTON",
    "DIST",               "FALLS",
    "FACT",               "FACTORYVILLE",
    "FALL",               "FALLS",
    "FORK",               "FORKSTON",
    "HARG",               "PITTSTON",
    "HARV",               "HARVEYS LAKE",
    "HOPB",               "HOP BOTTOM",
    "LACE",               "LACEYVILLE",
    "MEHO",               "MEHOOPANY",
    "MESH",               "MESHOPPEN",
    "MONT",               "MONTROSE",
    "NICH",               "NICHOLSON",
    "NOXE",               "NOXEN",
    "PITT",               "PITTSTON",
    "TUNK",               "TUNKHANNOCK",
    "WYAL",               "WYALUSING",
    "WYOM",               "WYOMING"
  });
   
  
  private static final String[] CITY_LIST = new String[]{
      
      // Boroughs
      "FACTORYVILLE",
      "LACEYVILLE",
      "MESHOPPEN",
      "NICHOLSON",
      "TUNKHANNOCK",

      // Townships
      "BRAINTRIM TOWNSHIP",
      "BRAINTRIM TWP",
      "CLINTON TOWNSHIP",
      "CLINTON TWP",
      "EATON TOWNSHIP",
      "EATON TWP",
      "EXETER TOWNSHIP",
      "EXETER TWP",
      "FALLS TOWNSHIP",
      "FALLS TWP",
      "FORKSTON TOWNSHIP",
      "FORKSTON TWP",
      "LEMON TOWNSHIP",
      "LEMON TWP",
      "MEHOOPANY TOWNSHIP",
      "MEHOOPANY TWP",
      "MESHOPPEN TOWNSHIP",
      "MESHOPPEN TWP",
      "MONROE TOWNSHIP",
      "MONROE TWP",
      "NICHOLSON TOWNSHIP",
      "NICHOLSON TWP",
      "NORTH BRANCH TOWNSHIP",
      "NORTH BRANCH TWP",
      "NORTHMORELAND TOWNSHIP",
      "NORTHMORELAND TWP",
      "NOXEN TOWNSHIP",
      "NOXEN TWP",
      "OVERFIELD TOWNSHIP",
      "OVERFIELD TWP",
      "TUNKHANNOCK TOWNSHIP",
      "TUNKHANNOCK TWP",
      "WASHINGTON TOWNSHIP",
      "WASHINGTON TWP",
      "WINDHAM TOWNSHIP",
      "WINDHAM TWP",

      // Census-designated places
      "LAKE WINOLA",
      "NOXEN",
      "WEST FALLS",
      
      // Bradford County
      "TERRY TOWNSHIP",
      "TERRY TWP",
      "TUSCARORA TOWNSHIP",
      "TUSCARORA TWP",

      // Lackawanna County
      "GLENBURN",

      "BENTON TOWNSHIP",
      "BENTON TWP",
      "GLENBURN TOWNSHIP",
      "GLENBURN TWP",
      "LAPLUME TOWNSHIP",
      "LAPLUME TWP",
      "NEWTON TOWNSHIP",
      "NEWTON TWP",
      "NORTH ABINGTON TOWNSHIP",
      "NORTH ABINGTON TWP",
      "WAVERLY TOWNSHIP",
      "WAVERLY TWP",

      // Luzerne County
      "LARKSVILLE",
      
      "EXETER TWP",
      
      // Susquehanna County
      "AUBURN TOWNSHIP",
      "AUBURN TWP",
      "FRANKLIN TOWNSHIP",
      "FRANKLIN TWP",
      "LATHROP TOWNSHIP",
      "LATHROP TWP",
      "LENOX TOWNSHIP",
      "LENOX TWP"
  };
}
