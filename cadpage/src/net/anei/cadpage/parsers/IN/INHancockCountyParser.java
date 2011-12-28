package net.anei.cadpage.parsers.IN;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Hancock County, IN
Contact: Brandon Wilch <bwilch@bctfd.org>

Vehicle Accident - PI/4100 N 600W GREENFIELD & W AIRPORT BLV/52/ E71 M71 FG1 BCFP1/gate 2A
Structure #ALARM#/7935 W 600N MCCORDSVILLE R12B12089 OAKLANDON/N 700W & N 800W/52/ E71 E72 L71 M71 FG1 BCFP1/General fire alarm
Vehicle Accident - PI/3600 N 600W GREENFIELD/W 350N & W STONER DR/17/ E71 M71 FG3 BCFP1
Sick / Ill Person/2500 N 700W GREENFIELD/W 200N & W 300N/53/ E71 M71 FG1 BCFP1/LE on traffic stop; requesting check out
Aircraft Down/5881 W AIRPORT BLV GREENFIELD FUEL DEPOT/N AVIATION WAY & N 600W/18/ T71 BCFP1/Aircraft into a cart; Vietest building

*/

public class INHancockCountyParser extends FieldProgramParser {
  
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
  
  public INHancockCountyParser() {
    super(CITY_LIST, "HANCOCK COUNTY", "IN",
           "CALL+? ADDR/SXP X/Z? MAP UNIT! INFO+");
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    return parseFields(body.split("/"), data);
  }
  
  // Address class, special case if field after address starts with &
  // make it a cross road rather than an place name
  private class MyAddressField extends AddressField {
    
    @Override
    public boolean checkParse(String field, Data data) {
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
  
  // Map class must be hard 2 digits
  private class MyMapField extends MapField {
    public MyMapField() {
      setPattern(Pattern.compile("\\d\\d"), true);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("MAP")) return new MyMapField();
    return super.getField(name);
  }
}
