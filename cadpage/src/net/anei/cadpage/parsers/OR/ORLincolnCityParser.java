package net.anei.cadpage.parsers.OR;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class ORLincolnCityParser extends FieldProgramParser {
  
  public ORLincolnCityParser() {
    super("LINCOLN CITY", "OR",
          "CALL! Loc:ADDR Rcvd:TIME! Units:UNIT! Comments:INFO");
  }
  
  @Override
  public String getFilter() {
    return "Group_Page_Notification@usamobility.net";
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      if (!field.endsWith(" ()")) abort();
      field = field.substring(0,field.length()-3).trim();
      super.parse(field, data);
    }
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.lastIndexOf(':');
      if (pt >= 0) {
        data.strApt = field.substring(pt+1).trim();
        field = field.substring(0,pt);
      }
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
}
