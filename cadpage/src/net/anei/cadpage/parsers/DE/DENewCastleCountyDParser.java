package net.anei.cadpage.parsers.DE;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class DENewCastleCountyDParser extends FieldProgramParser {
  
  public DENewCastleCountyDParser() {
    super("NEW CASTLE COUNTY", "DE",
          "CALL:CALL! ADDR:ADDR! ( DCITY:CITY DCITY:ST | CITY:CITY ST:ST | ) APT:APT? PL:PLACE? XST:X? UNIT:UNIT? INFO:INFO? INFO+? DCITY:SKIP CITY:SKIP");
  }
  
  @Override
  public String getFilter() {
    return "@c-msg.net";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (body.contains("\nADDR:")) { 
      if (!parseFields(body.split("\n"), data)) return false;
    } else {
      if (!super.parseMsg(body, data)) return false;
    }
    DENewCastleCountyEParser.fixCity(data);
    return true;
  }
  
  @Override
  public String getProgram() {
    return super.getProgram().replace("CITY", "PLACE CITY ST");
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace('@', '&');
      field = DENewCastleCountyEParser.checkDashCity(field, data);
      super.parse(field, data);
    }
  }

  private class MyInfoField extends InfoField {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (field.startsWith("CITY:") || field.startsWith("DCITY:")) return false;
      data.strSupp = append(data.strSupp, "\n", field);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    return DENewCastleCountyEParser.adjustMapAddressStatic(addr);
  }
  
  @Override
  public String adjustMapCity(String city) {
    return DENewCastleCountyEParser.adjustMapCityStatic(city);
  }
}
  