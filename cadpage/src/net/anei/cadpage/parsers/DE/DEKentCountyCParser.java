package net.anei.cadpage.parsers.DE;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Kent County, DE
 */
public class DEKentCountyCParser extends FieldProgramParser {
  
  public DEKentCountyCParser() {
    super("KENT COUNTY", "DE",
           "Unit:UNIT! Status:ADDR/SCP! Venue:CITY! Dev/Sub:PLACE! Xst's:X Caller:NAME");
    setupMultiWordStreets("SLOW AND EASY");
  }
  
  @Override
  public String getFilter() {
    return "kentcenter@state.de.us";
  }
  
  private static final Pattern CODE_PTN = Pattern.compile("^(\\d{1,2}[A-Z]\\d{1,2}[A-Z]?) (?:- )?");
  private static final Pattern ADDR_SPLIT_PTN = Pattern.compile(" *: *");
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      
      if (!field.startsWith("Dispatched ")) abort();
      field = field.substring(11).trim();
      
      Matcher match = CODE_PTN.matcher(field);
      if (match.find()) {
        data.strCode = match.group(1);
        field = field.substring(match.end()).trim();
      }
      
      String[] parts = ADDR_SPLIT_PTN.split(field, -1);
      if (parts.length > 3) abort();
      if (parts.length >=2) {
        data.strCall = parts[0];
        parseAddress(parts[1], data);
        if (parts.length == 3) data.strPlace = parts[2];
      }
      else {
        super.parse(field, data);
      }
    }
    
    @Override
    public String getFieldNames() {
      return "CODE CALL ADDR APT PLACE";
    }
  }
  
  private class MyCityField extends CityField {
    @Override
    public void parse(String field, Data data) {
      super.parse(field, data);
      String state = CITY_STATE_TABLE.getProperty(data.strCity.toUpperCase());
      if (state != null) data.strState = state;
    }
    
    @Override
    public String getFieldNames() {
      return "CITY ST";
    }
  }
  
  private class MyPlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      data.strPlace = append(data.strPlace, " - ", field);
    }
  }
  
  @Override
  protected Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("CITY")) return new MyCityField();
    if (name.equals("PLACE")) return new MyPlaceField();
    return super.getField(name);
  }
  
  // Out of state municipalities
  private static final Properties CITY_STATE_TABLE = buildCodeTable(new String[]{
     "MILLINGTON", "MD" 
  });
  
}


