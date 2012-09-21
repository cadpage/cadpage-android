package net.anei.cadpage.parsers.MO;


import java.util.Properties;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


/*
Festus, MO (in Jefferson County)
Contact: Tim Mullins <tmullinsaco@yahoo.com>
Sender: JBITTER@CITYOFFESTUS.ORG
System: ITI

(call) FIRE / BRUSH / 2819 NORTH SELMA ROAD JEFFCO/R7 /DOOLING HO /EMS /6610 /jpad brush with exposer R-7 FD720146 /JPAD 603031
(call) FIRE/10-50 J-2/ STATE RD CC JEFFCO/FESTUS FIRE / HWY 67 /FIRE DEP /H4 FI H1 FESTUS  FD66651 / JPAD H4 FI H1
S:Call M:FIRE / MUTUAL AID / 12532 STATE RD TT JEFFCO/R-7 / R7SCHOOLRD / EMS / H3 FI H1 / BRUSH ENDANGERING A STRUCTURE/ 66 14 6037 \nR-7 FD720096 / JPAD H3 FI H1\n

*/

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