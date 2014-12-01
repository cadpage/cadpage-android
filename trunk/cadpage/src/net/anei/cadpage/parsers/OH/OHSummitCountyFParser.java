package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class OHSummitCountyFParser  extends FieldProgramParser {
  
  public OHSummitCountyFParser() {
    super("SUMMIT COUNTY", "OH",
           "CALL ADDR MAP!");
  }

  @Override
  public String getFilter() {
    return "fdall@ems-cad.cityofgreen.org";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Dispatch")) return false;
    return parseFields(body.split("\n"), data);
  }
  
  @Override
  protected Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("MAP")) return new MapField("SS_MABAS_Zones, *(.*)", true);
    return super.getField(name);
  }

  public class MyAddressField extends AddressField {

    @Override
    public void parse(String field, Data data) {
      if (field.endsWith(")")) {
        int pt = field.indexOf('(');
        data.strCross = field.substring(pt+1,field.length()-1).trim();
        field = field.substring(0,pt).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR APT X";
    }
  }
}
