package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class TXNuecesCountyParser extends FieldProgramParser {
  
  public TXNuecesCountyParser() {
    super("NUECES COUNTY", "TX",
           "( NCFIRE:IDCALL | CALL! ) ALRM:SKIP! PRI:PRI! ESZ:ADDR! EV:ID");
  }
  
  @Override
  public String getFilter() {
    return "ccpdpaging@cctexas.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("CAD Notify")) return false;
    return super.parseMsg(body, data);
  }
  
  private class MyIdCallField extends CallField {
    
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(' ');
      if (pt < 0) abort();
      data.strCallId = field.substring(0,pt).trim();
      data.strCall = field.substring(pt+1).trim();
    }
    
    @Override
    public String getFieldNames() {
      return "ID CALL";
    }
  }
  
  
  private class MyAddressField extends AddressField {

    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf('/');
      if (pt < 0) abort();
      data.strUnit = field.substring(0,pt).trim();
      field = field.substring(pt+1).trim();
      pt = field.lastIndexOf(": @");
      if (pt >= 0) {
        data.strPlace = field.substring(pt+3).trim();
        field = field.substring(0,pt);
      }
      if (field.endsWith(" NUECS")) field = field.substring(0,field.length()-6).trim();
      if (field.endsWith(" CC")) {
        data.strCity = "CORPUS CHRISTI";
        field = field.substring(0, field.length()-3).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "UNIT " + super.getFieldNames() + " CITY PLACE";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("IDCALL")) return new MyIdCallField();
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
}
