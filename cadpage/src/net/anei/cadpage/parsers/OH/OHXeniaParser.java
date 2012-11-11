package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class OHXeniaParser extends FieldProgramParser {
  
  public OHXeniaParser() {
    super("GREENE COUNTY", "OH",
           "CALL Location:ADDR! Time:SKIP Units:UNIT Common_Name:NAME Info:INFO");
  }
  
  @Override
  public String getFilter() {
    return "psisn_dispatch@ci.xenia.oh.us";
  }
  
  private class MyAddressField extends AddressField {

    @Override
    public void parse(String field, Data data) {
      parseAddress(StartType.START_ADDR, field, data);
      Parser p = new Parser(getLeft());
      data.strPlace = p.getOptional(',');
      field = p.get();
      parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS, field, data);
      data.strCity = getLeft();
    }

    @Override
    public String getFieldNames() {
      return "ADDR PLACE X CITY";
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
}
