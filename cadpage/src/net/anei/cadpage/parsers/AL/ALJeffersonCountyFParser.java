
package net.anei.cadpage.parsers.AL;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgInfo.MsgType;

/**
 * Jefferson County, AL (F)
 */
public class ALJeffersonCountyFParser extends FieldProgramParser {

  public ALJeffersonCountyFParser() {
    super("JEFFERSON COUNTY", "AL",
          "CALL:CALL! PLACE:PLACE! ADDR:ADDR! CITY:CITY! ID:ID! PRI:PRI! DATE:DATE! TIME:TIME! MAP:MAP! UNIT:UNIT! INFO:INFO/N+");
  }
    
  @Override
  public String getFilter() {
    return "automailer@velocityps.com";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    return parseFields(body.split("\n"), data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("UNIT")) return new MyUnitField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private class MyUnitField extends UnitField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace(' ', '_');
      super.parse(field, data);
    }
  }
  
  private class MyInfoField extends InfoField {
    
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("[") && field.endsWith("]")) return;
      if (field.startsWith("Dispatched:")) data.msgType = MsgType.RUN_REPORT;
      if (field.startsWith("CROSS STREET OF ")) {
        data.strCross = field.substring(15).trim();
        return;
      }
      if (field.startsWith("CROSS STREETS ARE ")) {
        field = field.substring(18).trim().replaceAll("  +", " ");
        if (field.equals("AND")) return;
        field = stripFieldEnd(field, " AND").replace(" AND ", " / ");
        data.strCross = field;
        return;
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "X " + super.getFieldNames();
    }
  }
}
