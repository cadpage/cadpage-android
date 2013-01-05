package net.anei.cadpage.parsers.NY;

import java.util.Properties;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class NYNassauCountyMassepequaParser extends FieldProgramParser {
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "MASS", "MASSEPEQUA",
      "MPK",  "MASSEPEQUA PARK"
  });
  
  public NYNassauCountyMassepequaParser() {
    super(CITY_CODES, "NASSAU COUNTY", "NY", 
          "ADDR! Town:CITY! Cross:X! Map:MAP! Block:INFO!");
  }
  
  @Override
  public String getFilter() {
    return "paging@rednmxcad.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    body = body.replace("Block#:", "Block:");
    return super.parseFields(body.split(","), data);
  }
  
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(':');
      if (pt < 0) abort();
      data.strCall = field.substring(0, pt).trim();
      super.parse(field.substring(pt+1).trim(), data);
    }
    
    @Override
    public String getFieldNames() {
      return "CALL " + super.getFieldNames();
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
}
