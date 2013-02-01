package net.anei.cadpage.parsers.DE;

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
  }
  
  @Override
  public String getFilter() {
    return "kentcenter@state.de.us";
  }
  
  private static final Pattern CODE_PTN = Pattern.compile("^(\\d{1,2}[A-Z]\\d{1,2}[A-Z]?) (?:- )?");
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
      
      if (field.endsWith(":")) field = field.substring(0,field.length()-1).trim();
      
      int pt = field.indexOf(" : ");
      if (pt >= 0) {
        data.strCall = field.substring(0,pt).trim();
        parseAddress(field.substring(pt+3).trim(), data);
      } else {
        super.parse(field, data);
      }
    }
    
    @Override
    public String getFieldNames() {
      return "CODE CALL ADDR APT PLACE";
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
    if (name.equals("PLACE")) return new MyPlaceField();
    return super.getField(name);
  }
  
}


