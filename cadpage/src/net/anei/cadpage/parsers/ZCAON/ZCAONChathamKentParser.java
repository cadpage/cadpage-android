package net.anei.cadpage.parsers.ZCAON;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class ZCAONChathamKentParser extends FieldProgramParser {
  
  public ZCAONChathamKentParser() {
    super("CHATHAM-KENT", "ON", 
          "CALL:CALL! PLACE:PLACE! ADDR:ADDR! CITY:CITY! ID:ID! DATE:DATE! TIME:TIME! INFO:INFO");
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    return super.parseFields(body.split(";"), data);
  }

}
