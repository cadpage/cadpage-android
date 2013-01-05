package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA13Parser;



public class OHStarkCountyCencommParser extends DispatchA13Parser {
  
  public OHStarkCountyCencommParser() {
    super("STARK COUNTY", "OH");
  }
  
  @Override
  public String getFilter() {
    return "cencom@neohio.twcbc.com";
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(';');
      if (pt >= 0) {
        data.strCity = field.substring(pt+1).trim();
        field = field.substring(0,pt);
      }
      field = field.replaceAll(" *, *", " ");
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " CITY";
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("DISPATCHED")) return new SkipField("DISPATCHED", true);
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
}
