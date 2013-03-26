package net.anei.cadpage.parsers.TN;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class TNCumberlandCountyParser extends FieldProgramParser {
  
  public TNCumberlandCountyParser() {
    super("CUMBERLAND COUNTY", "TN",
           "CALL ADDR INFO");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@911email.net";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("E911")) return false;
    return parseFields(body.split("\n"), 2, data);
  }
  
  private class MyAddressField extends AddressCityField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(',');
      if (pt >= 0) {
        data.strCity = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
      }
      parseAddress(field, data);
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
  
}
