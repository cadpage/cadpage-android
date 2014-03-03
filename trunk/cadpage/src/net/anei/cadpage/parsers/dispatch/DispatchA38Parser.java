package net.anei.cadpage.parsers.dispatch;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class DispatchA38Parser extends FieldProgramParser {
  
  public DispatchA38Parser(String defCity, String defState) {
    super(defCity, defState,
          "CFS#:ID! CallType:CALL! Address:ADDR!");
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    return super.parseMsg(body, data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new IdField("\\d{4}-\\d{5}", true);
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      String city = p.getLastOptional(',');
      if (city.length() == 2) {
        data.strState = city;
        city = p.getLastOptional(',');
      }
      data.strCity = city;
      data.strApt = p.getLastOptional("Apt:");
      parseAddress(p.get(), data);
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR APT CITY ST";
    }
  }
}
