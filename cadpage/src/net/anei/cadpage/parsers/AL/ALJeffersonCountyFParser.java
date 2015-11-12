
package net.anei.cadpage.parsers.AL;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Jefferson County, AL (F)
 */
public class ALJeffersonCountyFParser extends FieldProgramParser {

  public ALJeffersonCountyFParser() {
    super("JEFFERSON COUNTY", "AL",
          "Incident_Type:CALL? Incident_Location:ADDR! Incident_Number:ID! Date:DATE! Time:TIME! Incident_Type:CALL? Priority:PRI! Cross_Streets:X Remarks:INFO+");
  }
    
  @Override
  public String getFilter() {
    return "automailer@velocityps.com";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    body = body.replace(" Time:", "\nTime:");
    body = body.replace("\nCross Street:", "\nCross Streets:");
    if (!parseFields(body.split("\n"), data)) return false;
    return data.strCall.length() > 0;
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      if (data.strCall.length() > 0) return;
      data.strCall = field;
    }
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      data.strName = p.getLastOptional('@');
      data.strCity = p .getLastOptional(',');
      super.parse(p.get(), data);
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR APT CITY NAME";
    }
  }
  
  private class MyInfoField extends InfoField {
    
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("[") && field.endsWith("]")) return;
      super.parse(field, data);
    }
  }
}
