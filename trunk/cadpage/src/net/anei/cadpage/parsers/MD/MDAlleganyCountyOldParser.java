package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class MDAlleganyCountyOldParser extends FieldProgramParser {
  
  public MDAlleganyCountyOldParser() {
    super("ALLEGANY COUNTY", "MD",
           "ADDR/SC Units:UNIT");
  }
  
  @Override
  public String getFilter() {
    return "LogiSYS";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (! subject.startsWith("CAD Page for CFS ")) return false;
    data.strCallId = subject.substring(17).trim();
    
    body = body.replaceAll("\\s+", " ");
    return super.parseMsg(body, data);
  }
  
  private class MyAddressField extends AddressField {

    @Override
    public void parse(String field, Data data) {
      // Address may be separated by a U: marker
      int pt = field.indexOf(" U:");
      if (pt >= 0) {
        data.strCall = field.substring(0, pt).trim();
        parseAddress(field.substring(pt+3).trim(), data);;
      }
      
      // Otherwise invoke the smart parser to split the call from the address
      else {
        super.parse(field, data);
      }
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }
}
