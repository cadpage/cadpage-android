package net.anei.cadpage.parsers.CA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.Message;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class CAStanislausCountyParser extends FieldProgramParser {

  public CAStanislausCountyParser() {
    super(CITY_CODES, "STANISLAUS COUNTY", "CA", 
          "SRC CALL ADDR_PFX+? ADDR/Z! DET:INFO! ALRMLVL:PRI! DISPTIME:TIME!");
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }
  
  private String fromAddress;

  @Override
  protected Data parseMsg(Message msg, int parseFlags) {
    fromAddress = msg.getFromAddress();
    return super.parseMsg(msg, parseFlags);
  }

  private static final Pattern FAKE_ADDRESS_PTN = Pattern.compile("[A-Z]{3}-[A-Z0-9]+-@.*");
  
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // One particular construct get misinterpreted as a sender address and subject
    // and we have to put things back together
    if (FAKE_ADDRESS_PTN.matcher(fromAddress).matches() && subject.length() > 0) {
      body = fromAddress + " (" + subject + ")" + body;
    }
    
    
    
    int ni = body.indexOf("\nSent");
    if (ni != -1) body = body.substring(0, ni);

    return parseFields(body.split("-"), data);
  }

  @Override
  public Field getField(String name) {
    if (name.equals("ADDR_PFX")) return new MyAddressPrefixField();
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
  private class MyAddressPrefixField extends Field {
    @Override
    public void parse(String field, Data data) {
      data.strAddress = append(data.strAddress, "-", field);
    }

    @Override
    public String getFieldNames() {
      return "";
    }
  }

  private static Pattern ADDR_X_PTN = Pattern.compile("(.*)\\((?!MapBook:)([^\\(\\)]*/[^\\(\\)]*)\\)");
  private static Pattern ADDR_MAP_PTN = Pattern.compile("(.*)\\(MapBook:([^\\(\\)]*)\\)");
  private static Pattern AT = Pattern.compile("@(.*?)(?:#(.*?))?\\((.*?)\\),(.*)");
  private static Pattern ADDR = Pattern.compile("([^,\\(\\)]*?)(?:\\(([^\\(\\)]*?)\\))?,([^,#]*?)(?:#(.*?))?");
  private static Pattern INTERSECTION = Pattern.compile("([^,]*?)(?:, ([A-Z]{2}(?: [A-Z]{2})?))?/([^,]*?)(?:, ([A-Z]{2}(?: [A-Z]{2})?))?");
  private static Pattern APT_PTN = Pattern.compile("^(APT?|RM|ROOM|UNIT|SPC?|SPACE)[- ]*");

  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      
      // Prepend any prefix information
      field = append(data.strAddress, "-", field);
      data.strAddress = "";
      
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
        if (mat.matches()) {
          data.strPlace = mat.group(1).trim();
          data.strApt = cleanApt(getOptGroup(mat.group(2)));
          parseAddress(mat.group(3).trim(), data);
          data.strCity = getCityCode(mat.group(4));
        } else {
          data.strAddress = field.substring(1).trim();
        }
      } else if ((mat = ADDR.matcher(field)).matches()) {
        parseAddress(mat.group(1).trim(), data);
        data.strPlace = getOptGroup(mat.group(2));
        data.strCity = getCityCode(mat.group(3));
        data.strApt = cleanApt(getOptGroup(mat.group(4)));
      } else if ((mat = INTERSECTION.matcher(field)).matches()) {
        String cityA = getOptGroup(mat.group(2));
        String cityB = getOptGroup(mat.group(4));
        if (cityA != null && cityB != null && !cityA.equals(cityB)) {
          // If cities both exist and don't match, then include them in the intersection
          data.strAddress = mat.group(1).trim() + ", " + getCityCode(cityA) + " & " + mat.group(3).trim() + ", " + getCityCode(cityB);
        } else {
          // If they do match, parse and save to strCity
          data.strAddress = mat.group(1).trim() + " & " + mat.group(3).trim();
          if (cityA != null) data.strCity = getCityCode(cityA);
          else if (cityB != null) data.strCity = getCityCode(cityB);
        }
      }
      
      else parseAddress(field, data);
    }
    
    private String getCityCode(String code) {
      code = code.trim();
      if (code.startsWith("CO ")) code = code.substring(3);
      return convertCodes(code, CITY_CODES);
    }
    
    private String cleanApt(String apt) {
      return APT_PTN.matcher(apt.trim()).replaceFirst("");
    }
    

    @Override
    public String getFieldNames() {
      return "PLACE ADDR APT CITY MAP X";
    }
  }

  private static Properties CITY_CODES = buildCodeTable(new String[] {
      "CE", "Ceres",
      "CL", "Crows Landing",
      "DE", "Denair",
      "DG", "Diablo Grande",
      "GR", "Grayson",
      "HU", "Hughson",
      "KE", "Keyes",
      "KF", "Knights Ferry",
      "LG", "La Grange",
      "MO", "Modesto",
      "NM", "Newman",
      "OD", "Oakdale",
      "PS", "Patterson",
      "RB", "Riverbank",
      "SA", "Salida",
      "TU", "Turlock",
      "WE", "Westley",
      "WF", "Waterford"
  });
  
}
