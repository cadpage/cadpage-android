package net.anei.cadpage.parsers.CA;

import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Lake County, CA
 */
public class CALakeCountyParser extends FieldProgramParser {
  
  private static final Pattern DELIM = Pattern.compile("(?<= )\\*(?= )");
  
  public CALakeCountyParser() {
    super(CITY_CODES, "LAKE COUNTY", "CA",
           "ADDR PLACE X APT CITY? CALL! INFO+");
  }
  
  @Override
  public String getFilter() {
    return "lakecounty.dispatch@lakecountyca.gov";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    return parseFields(DELIM.split(body), 5, data);
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(',');
      if (pt >= 0) {
        data.strCity = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
      }
      super.parse(field, data);
    }
  }
  
  // City field doesn't exist if it was entered as part of the address
  private class MyCityField extends CityField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (data.strCity.length() > 0) return false;
      parse(field, data);
      return true;
    }
  }
  
  // Call field expands call codes
  private class MyCallCode extends CallField {
    @Override
    public void parse(String field, Data data) {
      String desc = CALL_CODES.getProperty(field);
      if (desc != null) {
        field = field + " - " + desc;
      }
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("CITY")) return new MyCityField();
    if (name.equals("CALL")) return new MyCallCode();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "CB", "Cobb",
      "CL", "Clearlake",
      "CO", "Clearlake Oaks",
      "CP", "Clearlake Park",
      "FI", "Finley",
      "GL", "Glenhaven",
      "HV", "Hidden Valley Lake",
      "KV", "Kelseyville",
      "LK", "Lake Pillsbury",
      "LL", "Lower Lake",
      "LO", "Loch Lomond",
      "LP", "Lakeport",
      "LU", "Lucerne",
      "MI", "Middletown",
      "NI", "Nice",
      "UL", "Upper Lake",
      "WP", "Whispering Pines",
      "WS", "Witter Springs",
  });
  
  private static final Properties CALL_CODES = buildCodeTable(new String[]{
      "FDAA", "Auto Accident",
      "FDAR", "Alarm Sounding",
      "FDHM", "Haz-Mat",
      "FDMA", "Medical Aid",
      "FDSF", "Structure Fire",
      "FDSC", "Smoke Check",
      "FDPA", "Public Assist",
      "FDLL", "Life Line Alert",
      "FDLD", "Lines Down",
      "FDVF", "Vehicle Fire",
      "FDWF", "Wildland Fire",
      "FDWR", "Water Rescue",
      "FDCF", "Chimney Fire",
      "FDAF", "Appliance Fire",
      "FDOE", "Other Event",
      "FDWI", "Walk-In",
      "FDWC", "Welfare Check",
  });
}
