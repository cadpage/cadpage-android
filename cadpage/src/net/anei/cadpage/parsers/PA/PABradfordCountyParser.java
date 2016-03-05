package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.dispatch.DispatchA65Parser;

public class PABradfordCountyParser extends DispatchA65Parser {
  
  public PABradfordCountyParser() {
    super(CITY_LIST, "BRADFORD COUNTY", "PA");
  }

  @Override
  public String getFilter() {
    return "bradfordpa911@911email.net";
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
