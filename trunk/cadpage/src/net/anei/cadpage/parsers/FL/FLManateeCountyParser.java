package net.anei.cadpage.parsers.FL;

import java.util.Properties;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class FLManateeCountyParser extends FieldProgramParser {
  
  public FLManateeCountyParser() {
    super(CITY_CODES, "MANATEE COUNTY", "FL",
        "Location:ADDR/S? Estimated_Address:PLACE? TYPE_CODE:CALL! SUB_TYPE:INFO TIME:TIME% MAP_GRID:MAP");
  }

  @Override
  public String getFilter() {
    return "93001,777,888";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    if (data.strAddress.length() == 0) return false;
    return true;
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      
      int pt = field.indexOf(": @");
      if (pt >= 0) {
        data.strPlace = field.substring(pt+3).trim();
        field = field.substring(0,pt).trim();
      }
      
      if (field.endsWith("Estimated Address")) {
        field = field.substring(0,field.length()-17).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " PLACE";
    }
  }
  
  private class MyPlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      
      // Remove leading EST
      if (field.startsWith("EST ")) field = field.substring(4).trim();
      if (field.startsWith("@")) field = field.substring(1).trim();
      
      // If there was no location field, use this
      if (data.strAddress.length() == 0) {
        parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, field, data);
      }
      
      // Otherwise this is a normal place field
      else {
        super.parse(field, data);
      }
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("PLACE")) return new MyPlaceField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "AM",   "Anna Maria",
      "BB",   "Bradenton Beach",
      "BR",   "Bradenton",
      "CZ",   "Cortez",
      "DE",   "Desoto County",
      "EL",   "Ellenton",
      "HA",   "Hardee County",
      "HB",   "Holmes Beach",
      "HC",   "Hillsborough County",
      "LBK",  "Longboat Key",
      "LK",   "Longboat Key",
      "MY",   "Myakka City",
      "PA",   "Palmetto",
      "PI",   "Pinellas County",
      "PR",   "Parrish",
      "SARA", "Sarasota County",
      "SM",   "Sarasota",
      "UB",   "Bradenton",
      "UP",   "Palmetto",
      "WM",   "Wimauma"
  });
}
