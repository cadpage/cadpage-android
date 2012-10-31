package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class NYRocklandCountyCParser extends FieldProgramParser {
  
  public NYRocklandCountyCParser() {
    super("ROCKLAND COUNTY", "NY",
        "Addr:ADDR! X_St:X Name:NAME Phone:PHONE Comp:CALL");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@hatzolohems.org";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.startsWith("ACR# ")) return false;
    data.strCallId = subject.substring(5).trim();
    if (body.startsWith("Add:")) body = "Addr:" + body.substring(4);
    return parseFields(body.split("\n"), data);
  }
  
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      super.parse(p.get(','), data);
      data.strCity = p.get();
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " CITY";
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("Between ")) {
        field = field.substring(8).trim();
      } else if (field.startsWith("Near the intersection of ")) {
        field = "Near " + field.substring(25).trim();
      }
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new MyCrossField();
    return super.getField(name);
    
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }
}
