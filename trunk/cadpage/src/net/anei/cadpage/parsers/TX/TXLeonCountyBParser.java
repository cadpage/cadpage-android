package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class TXLeonCountyBParser extends FieldProgramParser{

  public TXLeonCountyBParser() {
    super("LEON COUNTY", "TX",
      "Call_Type:CALL! City:CITY! Address:ADDRCALL!");
  }

  public String getFilter() {
    return "cadalerts@eforcesoftware.com";
  }

  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.trim().equals("Dispatch Alert")) return false;
    return super.parseMsg(body, data);
  }
  
  private class MyAddressCallField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      int semicolonPosition = field.indexOf(";"); // in 2 of the sample messages during an "ASSIST OTHER AGENCY" call a more specific secondary call was added to the end separated by a semicolon.
      if (semicolonPosition >= 0) {
        data.strCall = append(data.strCall, " / ", field.substring(semicolonPosition + 1)).trim();
        field =field.substring(0, semicolonPosition).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR APT CALL";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDRCALL")) return new MyAddressCallField();
    return super.getField(name);
  }
}