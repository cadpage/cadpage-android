package net.anei.cadpage.parsers.IN;

import java.util.Properties;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class INLakeCountyParser extends FieldProgramParser {

  public INLakeCountyParser() {
    super(CITY_CODES, "LAKE COUNTY", "IN",
      "SRC CALL ADDR UNIT UNIT! INFO+");
  }

public String getFilter() {
    return "hiplink@lakecountysheriff.com";
  }

protected boolean parseMsg(String subject, String body, Data data) {
  return parseFields(body.split("\n"), 2, data);
}
 
private class MyUnitField extends UnitField {
  
  @Override
  public void parse(String field, Data data) {
    data.strUnit = append(data.strUnit, " ", field);
  }
}

private class MyAddressField extends AddressField {
  
  @Override
  public void parse(String field, Data data) {
    Parser p = new Parser(field);
    data.strCity = convertCodes(p.getLastOptional(','), CITY_CODES);
    String place = p.getLastOptional(';');
    parseAddress(p.get(), data);
    if (place.startsWith("#")) {
      data.strApt = append(data.strApt, "-", place.substring(1).trim());
    } else {
      data.strPlace = place;
    }
  }
  
  @Override
  public String getFieldNames() {
    return "ADDR APT PLACE CITY";
  }
}

  @Override
  public Field getField(String name) {
    if (name.equals("UNIT")) return new MyUnitField();
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "LOW",  "LOWELL",
      "STJ",  "ST JOHN",
      "DYE",  "DYER",
      "CED",  "CEDAR LAKE",
      "SCH",  "SCHERERVILLE",
      "CRO",  "CROWN POINT"
    });
}
