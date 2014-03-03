package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class OHSummitCountyEParser  extends FieldProgramParser {
  
  public OHSummitCountyEParser() {
    super("SUMMIT COUNTY", "OH",
           "FIRE:UNIT! NAME:PLACE! ADDRESS:ADDRCITY! DESCRIPTION:CALL! CROSS_1:X CROSS_2:X");
  }

  @Override
  public String getFilter() {
    return "alerts@inspironlogistics.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Alert Notification")) return false;
    int i = body.indexOf("\n");
    if (i >= 0){
      body = body.substring(0, i);
      body = body.trim();
    }
    return parseFields(body.split("\\|"), data);
  }

  public class MyAddressCityField extends AddressCityField{

    @Override
    public void parse(String field, Data data) {
      field = field.replaceAll("\\@", " \\& ");
      super.parse(field, data);
    }
  }
  
  @Override
  protected Field getField(String name) {
    if (name.equals("ADDRCITY")) return new MyAddressCityField();
    return super.getField(name);
  }
}
