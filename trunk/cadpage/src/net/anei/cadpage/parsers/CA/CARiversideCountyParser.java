package net.anei.cadpage.parsers.CA;

import java.util.Properties;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Riverside County, CA
 */
public class CARiversideCountyParser extends FieldProgramParser {
  
  public CARiversideCountyParser() {
    super("RIVERSIDE COUNTY", "CA",
           "CALL ADDR INFO? X MAP Inc:ID! Cmd:SRC! Tac:CH! UNIT! INFO+");
  }
  
  @Override
  public String getFilter() {
    return "messaging@iamresponding.com";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    body = body.replace(" Inc# ", " Inc: ");
    return parseFields(body.split(";"), data);
  }
  
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      data.strCity = convertCodes(p.getLastOptional(','), CITY_CODES);
      data.strPlace =p.getOptional('@');
      parseAddress(p.get(), data);
    }
    
    @Override
    public String getFieldNames() {
      return "PLACE ADDR CITY";
    }
  }
  
  private class MyCrossField extends CrossField {
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (!field.contains(" BLK ")) return false;
      super.parse(field, data);
      return true;
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new MyCrossField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "IDYL", "IDYLLWILD",
      "PINC", "PINE COVE"
  });
}
