package net.anei.cadpage.parsers.CT;


import net.anei.cadpage.parsers.FieldProgramParser;

import net.anei.cadpage.parsers.MsgInfo.Data;
/**
 * Montville, CT
 */
public class CTMontvilleParser extends FieldProgramParser {
  
  public CTMontvilleParser() {
    super(CITY_LIST, "MONTVILLE", "CT",
          "CALL PLACENAME? ADDR/S! CITY? INFO+ Fire_District:UNIT DATETIME");
  }

  @Override
  public String getFilter() {
    return "@montville-ct.org";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Imc Solutions Page")) return false;
    return parseFields(body.split("\r?\n"), 4, data);
  }
  
  private static final String[] CITY_LIST= new String[]{
    "MONTVILLE"
  };
}
