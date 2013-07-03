package net.anei.cadpage.parsers.dispatch;


import net.anei.cadpage.parsers.FieldProgramParser;

import net.anei.cadpage.parsers.MsgInfo.Data;
/**
 * New London County, CT
 */
public class DispatchA16Parser extends FieldProgramParser {
  
  public DispatchA16Parser(String[] cityList, String defCity, String defState) {
    super(cityList, defCity, defState,
          "CALL PLACENAME? ADDR/S! CITY? INFO+ District:UNIT DATETIME INFO+");
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Imc Solutions Page")) return false;
    body = body.replace("\nFire District:", "\nDistrict:");
    return parseFields(body.split("\n"), 4, data);
  }
}
