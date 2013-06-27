package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Albemarle County, VA
 */

public class VAAlbemarleCountyParser extends FieldProgramParser {
    
  
  public VAAlbemarleCountyParser() {
    super("ALBEMARLE COUNTY", "VA",
           "CALL! APT:APT? AD:ADDR! CTY:CITY! LOC:INFO? XST:X? XST2:X");
  }
  
  @Override
  public String getFilter() {
    return "CAD@acuecc.org";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    if (body.length() < 10) return false;
    
    data.strUnit = body.substring(0,10).trim();
    body = body.substring(10).trim();
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return "UNIT " + super.getProgram();
  }
  
  // Address field may contain place name
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(" - ");
      if (pt >= 0) {
        data.strPlace = field.substring(pt+3).trim();
        field = field.substring(0,pt).trim();
      }
      super.parse(field, data); 
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " PLACE";
    }
  }
  
  // City code isn't really a city.  It is a 2 character source code
  // possibly followed by an info field.  And we ignore the source code in
  // favor of the 10 character code at the beginning of the message
  private class MyCityField extends SkipField {
    @Override
    public void parse(String field, Data data) {
      if (field.length() > 3) data.strSupp = field.substring(3).trim();
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("CITY")) return new MyCityField();
    return super.getField(name);
  }

  @Override
  public String adjustMapAddress(String sAddress, boolean cross) {
    return sAddress.replace("LEWIS AND CLARK", "LEWIS_AND_CLARK");
  }

  @Override
  public String postAdjustMapAddress(String sAddress) {
    return sAddress.replace("LEWIS_AND_CLARK", "LEWIS AND CLARK");
  }
}
