package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;




public class NYMadisonCountyBParser extends FieldProgramParser {
  
  public NYMadisonCountyBParser() {
    super("MADISON COUNTY", "NY",
           "SRCID SKIP CALL ADDR");
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.endsWith("911 Dispatch")) return false;
    String[] flds = body.split("\n");
    if (! flds[1].trim().equals("Dispatched")) return false;
    return parseFields(flds, data);
  }
  
  // SRCID field contains source and call ID
  private class SourceIdField extends Field {
    
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(':');
      if (pt < 0) abort();
      data.strSource = field.substring(0,pt).trim();
      data.strCallId = field.substring(pt+1).trim();
    }
    
    @Override
    public String getFieldNames() {
      return "SRC ID";
    }
  }
  
  // Address field contains address, city, and possibly cross streets
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("@")) {
        Parser p = new Parser(field.substring(1).trim());
        data.strPlace = p.get('(');
        p = new Parser(p.get(')'));
        parseAddress(p.get('('), data);
        data.strCity = p.get(')');
      } else {
        Parser p = new Parser(field);
        parseAddress(p.get(','), data);
        data.strCity = p.get('(');
        String sCross = p.get(')');
        if (sCross.startsWith("/")) sCross = sCross.substring(1).trim();
        if (sCross.endsWith("/")) sCross = sCross.substring(0,sCross.length()-1).trim();
        data.strCross = sCross;
      }
      if (data.strCity.endsWith(" VIL")) {
        data.strCity = data.strCity.substring(0,data.strCity.length()-4).trim();
      }
    }
    
    @Override
    public String getFieldNames() {
      return "PLACE ADDR CITY X";
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("SRCID")) return  new SourceIdField();
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
}
	