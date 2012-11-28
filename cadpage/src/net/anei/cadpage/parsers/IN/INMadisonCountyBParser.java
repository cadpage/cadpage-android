package net.anei.cadpage.parsers.IN;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Madison County (Alexandria), IN
 */
public class INMadisonCountyBParser extends FieldProgramParser {
  
  public INMadisonCountyBParser() {
    super("MADISON COUNTY", "IN",
          "( Units:UNIT Call_Type:CALL! Address:ADDRCITY! Info:INFO | Call_Type:CALL! ADDRESS:ADDRCITY! UNITS:UNIT INFO:INFO )");
  }
  
  @Override
  public String getFilter() {
    return "cfs@madisoncountypaging.com";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("CFS")) return false;
    body = body.replace("Call Type:", " Call Type:");
    body = body.replace('\n', ' ');
    return super.parseMsg(body, data);
  }
  
  private class MyAddressCityField extends AddressCityField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(" RD# ");
      if (pt >= 0) {
        data.strMap = field.substring(pt+5).trim();
        field = field.substring(0,pt).trim();
      }
      field = field.replace('@', '&');
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " MAP";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDRCITY")) return new MyAddressCityField();
    return super.getField(name);
  }
}
