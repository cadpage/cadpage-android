package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class OHChampaignCountyParser extends FieldProgramParser {

  public OHChampaignCountyParser() {
    super("CHAMPAIGN COUNTY", "OH",
           "DATETIME ADDR! X1:X! X2:X! CALL UNIT");
  }
  
  @Override
  public String getFilter() {
    return "champaign911@co.champaign.oh.us";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("CAD Page")) return false;
    return parseFields(body.split("\n"), data);
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      parseAddress(p.get(','), data);
      data.strCity = p.get(',');
      data.strSupp = p.get();
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " CITY INFO";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME")) return new DateTimeField("(\\d\\d?/\\d\\d?/\\d{4} +\\d\\d:\\d\\d:\\d\\d),", true);
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
}
