package net.anei.cadpage.parsers.MO;


import java.util.Properties;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class MOFestusParser extends FieldProgramParser {
 
  public MOFestusParser() {
    super(CITY_CODES, "FETUS", "MO",
          "CALL CALL ADDR/S SRC X INFO UNIT INFO+? JPAD END");
  }
  
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equalsIgnoreCase("call")) return false;
    String[] flds = body.split("/");
    if (flds.length < 8) return false;
    return parseFields(flds, data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("JPAD")) return new SkipField("JPAD.*", true);
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
    "CC", "CRYSTAL CITY",
    "JEFFCO", "JEFFERSON COUNTY"
  });
}