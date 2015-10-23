package net.anei.cadpage.parsers.PA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class PABradfordCountyParser extends FieldProgramParser {
  
  public PABradfordCountyParser() {
    super(CITY_LIST, "BRADFORD COUNTY", "PA", 
          "CFS:ID! MSG:CALL! EMPTY! ( ADDR/Z EMPTY! | CITY? ADDR! APT:APT? CS:X? EMPTY ) SRC!");
  }

  @Override
  public String getFilter() {
    return "bradfordpa911@911email.net";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("E911-Page")) return false;
    body = body.replace(" X:", " CS:");
    return parseFields(body.split("\n"), 6, data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CITY")) return new MyCityField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("SRC")) return new MySourceField();
    return super.getField(name);
  }
  
  private static final Pattern BORO_PTN = Pattern.compile("([ A-Z]+) (?:BORO|BOROUGH)");
  private static final Pattern TWP_PTN = Pattern.compile(".* (?:TWP|TOWNSHIP)");
  private static final Pattern COUNTY_PTN = Pattern.compile("(?:(.*) )?([A-Z]+) (?:COUNTY|COUTNY)");
  private class MyCityField extends CityField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    public boolean checkParse(String field, Data data) {
      
      field = field.toUpperCase();
      
      Matcher match = BORO_PTN.matcher(field);
      if (match.matches()) {
        data.strCity = match.group(1).trim();
        return true;
      }
      
      match = TWP_PTN.matcher(field);
      if (match.matches()) {
        data.strCity = field;
        return true;
      }
      
      match = COUNTY_PTN.matcher(field);
      if (match.matches()) {
        String city = match.group(1);
        if (city != null) {
          data.strCity = city.trim();
        } else {
          data.strCity = match.group(2).trim() + "COUNTY";
        }
        return true;
      }
      
      return super.checkParse(field, data);
    }
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      if (data.strCall.equals("NOTIFY")) {
        data.strCall = append(data.strCall, " - ", field);
      } else {
        super.parse(field, data);
      }
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      field = stripFieldStart(field, "* /");
      field = stripFieldEnd(field, "/ *");
      if (field.equals("*")) return;
      super.parse(field, data);
    }
  }
  
  private class MySourceField extends SourceField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(':');
      if (pt >= 0) field = field.substring(0,pt).trim();
      super.parse(field, data);
    }
  }
  
  private static final String[] CITY_LIST = new String[]{
    
    // Boroughs
    "ALBA",
    "ATHENS",
    "BURLINGTON",
    "CANTON",
    "LE RAYSVILLE",
    "MONROE",
    "NEW ALBANY",
    "ROME",
    "SAYRE",
    "SOUTH WAVERLY",
    "SYLVANIA",
    "TOWANDA",
    "TROY",
    "WYALUSING",

    // Townships
    "ALBANY",
    "ARMENIA",
    "ASYLUM",
    "ATHENS",
    "BURLINGTON",
    "CANTON",
    "COLUMBIA",
    "FRANKLIN",
    "GRANVILLE",
    "HERRICK",
    "LEROY",
    "LITCHFIELD",
    "MONROE",
    "NORTH TOWANDA",
    "ORWELL",
    "OVERTON",
    "PIKE",
    "RIDGEBURY",
    "ROME",
    "SHESHEQUIN",
    "SMITHFIELD",
    "SOUTH CREEK",
    "SPRINGFIELD",
    "STANDING STONE",
    "STEVENS",
    "TERRY",
    "TOWANDA",
    "TROY",
    "TUSCARORA",
    "ULSTER",
    "WARREN",
    "WELLS",
    "WEST BURLINGTON",
    "WILMOT",
    "WINDHAM",
    "WYALUSING",
    "WYSOX",

    // Census-designated place
    "GREENS LANDING",

    // Unincorporated communities
    "BERRYTOWN",
    "BROWNTOWN"
   
  };
}
