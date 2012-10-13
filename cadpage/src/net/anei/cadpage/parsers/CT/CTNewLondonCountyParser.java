package net.anei.cadpage.parsers.CT;


import net.anei.cadpage.parsers.FieldProgramParser;

import net.anei.cadpage.parsers.MsgInfo.Data;
/**
 * New London County, CT
 */
public class CTNewLondonCountyParser extends FieldProgramParser {
  
  public CTNewLondonCountyParser() {
    super(CITY_LIST, "NEW LONDON COUNTY", "CT",
          "CALL PLACENAME? ADDR/S! CITY? INFO+ Fire_District:UNIT DATETIME");
  }

  @Override
  public String getFilter() {
    return "@montville-ct.org,dispatch@mail.eastlyme911.gov";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Imc Solutions Page")) return false;
    return parseFields(body.split("\n"), 4, data);
  }
  
  private static final String[] CITY_LIST= new String[]{
    "EAST LYME",
    "MONTVILLE"
  };
}
