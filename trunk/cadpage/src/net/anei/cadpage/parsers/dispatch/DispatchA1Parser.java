package net.anei.cadpage.parsers.dispatch;

import java.util.Properties;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class DispatchA1Parser extends FieldProgramParser {

  public DispatchA1Parser(String defCity, String defState) {
    this(null, defCity, defState);
  }
  
  public DispatchA1Parser(Properties cityCodes, String defCity, String defState) {
    super(cityCodes, defCity, defState, 
           "ALRM_LVL:PRI LOC:SKIP PLACE? ADDR! APT? CITY BTWN:X COM:INFO INFO+? CT:INFO INFO+?");
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (! subject.startsWith("Alert: ")) return false;
    data.strCall = subject.substring(7).trim();
    return parseFields(body.split("\\n"), data);
  }
  
  private class MyPlaceField extends PlaceField {

    @Override
    public boolean canFail() {
      return true;
    }

    @Override
    public boolean checkParse(String field, Data data) {

      // If first or second following field starts with BTWN: this must be an address
      // followed by a city
      if (getRelativeField(1).startsWith("BTWN:")) return false;
      if (getRelativeField(2).startsWith("BTWN:")) return false;
      
      // If next field looks like an apartment, and third field starts with BTWN:, 
      // then this must be an address followed by apartment and city
      String aptFld = getRelativeField(1);
      if ((aptFld.length()<=3 || aptFld.startsWith("APT") || aptFld.startsWith("LOT"))&& 
           getRelativeField(3).startsWith("BTWN:")) return false;
      
      // Otherwise, we can be a place field
      parse(field, data);
      return true;
    }
  }
  
  // This should be the address field.  But check to see if the place field
  // in front of it makes a better address
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      if (data.strPlace.length() > 0) {
        int chk1 = checkAddress(data.strPlace);
        if (chk1 > 0 && chk1 > checkAddress(field)) {
          String tmp = data.strPlace;
          data.strPlace = field;
          field = tmp;
        }
      }
      super.parse(field, data);
    }
  }
  
  private class MyAptField extends AptField {

    @Override
    public boolean canFail() {
      return true;
    }

    @Override
    public boolean checkParse(String field, Data data) {
      if (field.startsWith("APT")) {
        field = field.substring(3).trim();
      }
      else if (field.startsWith("LOT")) {
      }
      else if (field.length() > 3) return false; 
      parse(field, data);
      return true;
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (field.length() == 0) return false;
      parse(field, data);
      return true;
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("PLACE")) return new MyPlaceField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("APT")) return new MyAptField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  @Override
  public String getProgram() {
    return "CALL " + super.getProgram();
  }
}
