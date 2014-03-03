package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchProQAParser;


public class NJAtlanticareEMSParser extends DispatchProQAParser {
  
  public NJAtlanticareEMSParser() {
    super(CITY_LIST, "", "NJ",
           "CALL ADDR XPLACE+? CITY!");
  }
  
  @Override
  public String getFilter() {
    return "medcom@medcom.com,medcom@atlanticare.org";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    Parser p = new Parser(subject);
    data.strSource = p.get(" - ");
    return super.parseMsg(body, data);
  }
  
  private class CrossPlaceField extends Field {
    
    @Override
    public void parse(String field, Data data) {
      if (field.toUpperCase().startsWith("X ")) {
        data.strCross = append(data.strCross, " & ", field.substring(2).trim());
      } else {
        data.strPlace = append(data.strPlace, " - ", field);
      }
    }
    
    @Override
    public String getFieldNames() {
      return "PLACE X";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("XPLACE")) return new CrossPlaceField();
    return super.getField(name);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
  
  private static String[] CITY_LIST = new String[] {
  // Atlantic County
    "ABSECON",    
    "ATLANTIC",
    "ATLANTIC CITY",
    "BRIGANTINE",
    "BUENA VISTA TWP",
    "COLLINGS LAKES",
    "RICHLAND",
    "BUENA",
    "CORBIN",
    "EGG HARBOR",
    "EGG HARBOR TWP",
    "ESTELL MANOR",
    "FOLSOM",
    "GALLOWAY TWP",
    "POMONA",
    "HAMILTON TWP",
    "MAYS LANDING",
    "HAMMONTON",
    "LINWOOD",
    "LONGPORT",
    "MARGATE",
    "MULLICA TWP",
    "ELWOOD-MAGNOLIA",
    "NORTHFIELD",
    "PLEASANTVILLE",
    "PORT REPUBLIC",
    "SOMERS POINT",
    "VENTNOR",
    "WEYMOUTH TWP",
    
  // Cape May County
    "AVALON",
    "CAPE MAY POINT",
    "CAPE MAY",
    "DENNIS TWP",
    "DENNISVILLE",
    "OCEAN VIEW",
    "SOUTH DENNIS",
    "LOWER TWP",
    "DIAMOND BEACH",
    "ERMA",
    "NORTH CAPE MAY",
    "VILLAS",
    "MIDDLE TWP",
    "CAPE MAY COURT HOUSE",
    "GOSHEN",
    "GREEN CREEK",
    "RIO GRANDE",
    "WHITESBORO-BURLEIGH",
    "NORTH WILDWOOD",
    "OCEAN",
    "SEA ISLE",
    "STONE HARBOR",
    "UPPER TWP",
    "BEESLEYS POINT",
    "MARMORA",
    "STRATHMERE",
    "TUCKAHOE",
    "WEST CAPE MAY",
    "WEST WILDWOOD",
    "WILDWOOD CREST",
    "WILDWOOD",
    "WOODBINE",
  };
}
