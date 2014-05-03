package net.anei.cadpage.parsers.CA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class CAStanislausCountyParser extends FieldProgramParser {

  public CAStanislausCountyParser() {
    super(CITY_CODES, "STANISLAUS COUNTY", "CA", 
          "SRC CALL ADDR! DET:INFO! ALRMLVL:PRI! DISPTIME:TIME!");
  }

  protected boolean parseMsg(String subject, String body, Data data) {
    int ni = body.indexOf("\nSent");
    if (ni != -1) body = body.substring(0, ni);

    return parseFields(body.split("-"), data);
  }

  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }

  private static Pattern ADDR_X_PTN = Pattern.compile("(.*)\\((?!MapBook:)([^\\(\\)]*/[^\\(\\)]*)\\)");
  private static Pattern ADDR_MAP_PTN = Pattern.compile("(.*)\\(MapBook:([^\\(\\)]*)\\)");
  private static Pattern AT = Pattern.compile("@(.*?)(?:#(.*?))?\\((.*?)\\),(.*)");
  private static Pattern ADDR = Pattern.compile("([^,\\(\\)]*?)(?:\\(([^\\(\\)]*?)\\))?,([^,#]*?)(?:#(.*?))?");
  private static Pattern INTERSECTION = Pattern.compile("([^,]*?)(?:, ([A-Z]{2}))?/([^,]*?)(?:, ([A-Z]{2}))?");

  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      
      // Strip cross street from end of field
      Matcher mat = ADDR_X_PTN.matcher(field);
      if (mat.matches()) {
        field = mat.group(1).trim();
        data.strCross = stripFieldEnd(mat.group(2).trim(), "/");
      }
      
      // Strip map page from end of field
      mat = ADDR_MAP_PTN.matcher(field);
      if (mat.matches()) {
        field = mat.group(1).trim();
        data.strMap = mat.group(2).trim();
      }
      // Identify place format
      if (field.startsWith("@")) {
        mat = AT.matcher(field);
        if (!mat.matches()) abort();
        data.strPlace = mat.group(1).trim();
        data.strApt = getOptGroup(mat.group(2)).trim();
        parseAddress(mat.group(3).trim(), data);
        data.strCity = convertCodes(mat.group(4).trim(), CITY_CODES);;
      } else {
        // Resort to standard format
        mat = ADDR.matcher(field);
        if (mat.matches()) {
          parseAddress(mat.group(1).trim(), data);
          data.strPlace = getOptGroup(mat.group(2));
          data.strCity = convertCodes(mat.group(3).trim(), CITY_CODES);
          data.strApt = getOptGroup(mat.group(4)).trim();
        } else {
          // if not standard format, intersection format
          mat = INTERSECTION.matcher(field);
          if (!mat.matches()) abort();
          String cityA = getOptGroup(mat.group(2));
          String cityB = getOptGroup(mat.group(4));
          if (cityA != null && cityB != null && !cityA.equals(cityB)) {
            // If cities both exist and don't match, then include them in the intersection
            data.strAddress = mat.group(1).trim() + ", " + convertCodes(cityA, CITY_CODES) + " & " + mat.group(3).trim() + ", " + convertCodes(cityB, CITY_CODES);
          } else {
            // If they do match, parse and save to strCity
            data.strAddress = mat.group(1).trim() + " & " + mat.group(3).trim();
            if (cityA != null) data.strCity = convertCodes(cityA, CITY_CODES);
            else if (cityB != null) data.strCity = convertCodes(cityB, CITY_CODES);
          }
        }
      }
    }

    @Override
    public String getFieldNames() {
      return "PLACE ADDR APT CITY MAP X";
    }
  }

  private static Properties CITY_CODES = buildCodeTable(new String[] {
      "CO MO", "Modesto",
      "MO", "Modesto",
      "SA", "Salida"
  });
  
}
