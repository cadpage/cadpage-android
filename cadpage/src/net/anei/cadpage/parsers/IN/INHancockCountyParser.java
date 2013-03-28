package net.anei.cadpage.parsers.IN;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Hancock County, IN
 */
public class INHancockCountyParser extends FieldProgramParser {
  
  public INHancockCountyParser() {
    super(CITY_LIST, "HANCOCK COUNTY", "IN",
           "CALL ( MUTADDR INFO | CALL+? ADDR/SXP CITY? X/Z? MAP ) UNIT! INFO+");
  }
  
  @Override
  public String getFilter() {
    return "mplus@hancockcoingov.org,777";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    return parseFields(body.split("/"), data);
  }
  
  private static final Pattern MUTAID_PTN = Pattern.compile("(.*)-(.*) CO");
  private class MutualAidAddressField extends AddressField {
    @Override
    public boolean checkParse(String field, Data data) {
      Matcher match = MUTAID_PTN.matcher(field);
      if (!match.matches()) return false;
      super.parse(match.group(1).trim(), data);
      data.strCity = match.group(2).trim() + " COUNTY";
      return true;
    }
  }
  
  // Address class, special case if field after address starts with &
  // make it a cross road rather than an place name
  private class MyAddressField extends AddressField {
    
    @Override
    public boolean checkParse(String field, Data data) {
      field = field.replace(".", " ").trim().replaceAll("  +", " ");
      if (!super.checkParse(field, data)) return false;
      if (data.strPlace.startsWith("&")) {
        data.strCross = data.strPlace.substring(2).trim();
        data.strPlace = "";
      }
      return true;
    }
    
    @Override 
    public String getFieldNames() {
      return super.getFieldNames() + " X";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("MUTADDR")) return new MutualAidAddressField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("MAP")) return new MapField("\\d\\d(?:00\\d\\d)?", true);
    return super.getField(name);
  }
  
  private static final String[] CITY_LIST = new String[]{
    "FORTVILLE",
    "GREENFIELD",
    "MAXWELL",
    "MCCORDSVILLE",
    "NEW PALESTINE",
    "SHIRLEY",
    "SPRING LAKE",
    "WILKINSON",

    "BLUE RIVER TWP",
    "BRANDYWINE TWP",
    "BROWN TWP",
    "BUCK CREEK TWP",
    "CENTER TWP",
    "GREEN TWP",
    "JACKSON TWP",
    "SUGAR CREEK TWP",
    "VERNON TWP"
  };
}
