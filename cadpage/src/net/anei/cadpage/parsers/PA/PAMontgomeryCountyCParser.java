package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class PAMontgomeryCountyCParser extends FieldProgramParser {
  
  public PAMontgomeryCountyCParser() {
    super("Montgomery County", "PA",
        "ADDR TRUCKS:UNITADDR?  Place:PLACE? XST:X! NAT:CALL! BOX:BOX!");
   }
  
  @Override 
  public boolean parseMsg(String body, Data data) {
    body = body.replace(": @", " Place:").replace(",BOX", " BOX");
    return super.parseMsg(body, data) && data.strAddress.length() > 0;
  }

  @Override
  public String getFilter() {
    return "@c-msg.net";
  }
  private class MyUnitAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(' ');
      if (pt < 0) abort();
      data.strUnit = field.substring(0,pt).trim();
      super.parse(field.substring(pt+1).trim(), data);
    }
    
    @Override
    public String getFieldNames() {
      return "UNIT " + super.getFieldNames();
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("/")) field = field.substring(1).trim();
      if (field.endsWith("/")) field = field.substring(0,field.length()-1).trim();
      super.parse(field, data);
    }
  }
  
  @Override
  protected Field getField(String name) {
    if (name.equals("UNITADDR")) return new MyUnitAddressField();
    if (name.equals("X")) return new MyCrossField();
    return super.getField(name);
  }
}
