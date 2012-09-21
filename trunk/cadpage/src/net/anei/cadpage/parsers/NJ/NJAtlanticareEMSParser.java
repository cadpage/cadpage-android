package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchProQAParser;

/*
Atlanticare EMS, NJ (Atlantic & Cape May Counties)
Contact: Me <grbrown@fastmail.net>
Sender: medcom@medcom.com

[NOPHI MEDCOM - part 1 of 1]  RC:Run# 54365/LINWOOD-EMS/199 NEW RD/law office in central square/LINWOOD/11:14/////////<Unknown>
[NOPHI MEDCOM - part 1 of 1]  RC:Run# 54353/MICU/42 ROUTE 50/X KRUK TERRACE/OCEAN VIEW/10:16///////SEAVILLE//<Unknown>
[NOPHI MEDCOM - part 1 of 1]  RC:Run# 54345/MICU/117 HARRISON AVE/x new rd/PLEASANTVILLE/09:36/////////<Unknown>
[NOPHI MEDCOM - part 1 of 1]  RC:Run# 54374/MICU/301 W  DELILAH RD/U7/PLEASANTVILLE/12:08/////////<Unknown>
[NOPHI MEDCOM - part 1 of 1]  RC:Run# 54384/MICU/13 MANCHESTER ST/x s moore rd/ABSECON/12:29/////////<Unknown>

 */

public class NJAtlanticareEMSParser extends DispatchProQAParser {
  
  public NJAtlanticareEMSParser() {
    super(CITY_LIST, "", "NJ",
           "CALL ADDR XPLACE+? CITY!");
  }
  
  @Override
  public String getFilter() {
    return "medcom@medcom.com";
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
