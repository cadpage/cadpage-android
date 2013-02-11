package net.anei.cadpage.parsers.IA;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class IAWarrenCountyParser extends FieldProgramParser {
  
  public IAWarrenCountyParser() {
    super("WARREN COUNTY", "IA",
           "CFS#:ID! CallType:CALL! Address:ADDR!");
  }
  
  @Override
  public String getFilter() {
    return "messaging@iamresponding.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    data.strSource = subject;
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
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
  
  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new IdField("\\d{4}-\\d{5}", true);
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
}
