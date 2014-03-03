package net.anei.cadpage.parsers.MT;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class MTLewisAndClarkCountyAParser extends FieldProgramParser {
  
  private static final String DEF_CITY = "LEWIS AND CLARK COUNTY";
  private static final String DEF_STATE = "MT";

  public MTLewisAndClarkCountyAParser() {
    super(DEF_CITY, DEF_STATE,
           "UNITS:UNIT! CFS:ID! TYP:CALL! LOC:ADDR! BUSN:PLACE APT:APT CMP:NAME PHONE:PHONE CMNTS:INFO+ MEDS:SKIP MAP:MAP+");
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    if (body.startsWith("HELENA 911 ")) body = body.substring(11).trim();
    if (body.length() == 0) return false;
    if (body.charAt(0) == '(') {
      int pt = body.indexOf(')');
      if (pt < 0) return false;
      body = body.substring(pt+1).trim();
    }
    
    int pt = body.indexOf(" TXT STOP");
    if (pt >= 0) body = body.substring(0,pt).trim();
    return super.parseFields(body.split("\n"), data);
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("U:")) field = field.substring(2).trim();
      super.parse(field, data);
    }
  }
  
  private class MyMapField extends MapField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("MAP ")) field = field.substring(4).trim();
      data.strMap = append(data.strMap, " - ", field);
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("MAP")) return new MyMapField();
    return super.getField(name);
  }
  
}
