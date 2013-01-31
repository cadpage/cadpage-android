package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchAegisParser;



public class MDCarolineCountyParser extends DispatchAegisParser {
  
  public MDCarolineCountyParser() {
    super("CAROLINE COUNTY", "MD",
           "CALL ADDR XSts:X");
  }
  
  @Override
  public String getFilter() {
    return "alert@cfmsg.com";
  }
  
  // Assume single word city name, because that all they have
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      int pt = field.lastIndexOf(' ');
      if (pt < 0) abort();
      data.strCity = field.substring(pt+1).trim();
      super.parse(field.substring(0,pt).trim(), data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " CITY";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
}
