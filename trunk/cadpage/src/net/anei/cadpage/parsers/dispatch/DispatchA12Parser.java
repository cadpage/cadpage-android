package net.anei.cadpage.parsers.dispatch;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class DispatchA12Parser extends FieldProgramParser {
  
  public DispatchA12Parser(String defCity, String defState) {
    super(defCity, defState,
          "CALL! Loc:ADDR Rcvd:TIME! Units:UNIT? Comments:INFO");
  }
  
  private class BaseCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      if (!field.endsWith(" ()")) abort();
      field = field.substring(0,field.length()-3).trim();
      super.parse(field, data);
    }
  }
  
  private class BaseAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      data.strApt = p.getLastOptional(':');
      data.strApt = append(p.getLastOptional("[#"), "-", data.strApt);
      data.strPlace = p.getLastOptional("[@");
      int pt = data.strPlace.indexOf('#');
      if (pt >= 0) {
        data.strApt = data.strPlace.substring(pt+1).trim();
        data.strPlace = data.strPlace.substring(0,pt).trim();
      }
      data.strCity = p.getLastOptional(',');
      super.parse(p.get(), data);
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR CITY PLACE APT";
    }
  }
  
  private class BaseUnitField extends UnitField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.lastIndexOf(' ');
      if (pt < 0) abort();
      super.parse(field.substring(0,pt).trim(), data);
      data.strCallId = field.substring(pt+1);
    }
    
    @Override
    public String getFieldNames() {
      return "UNIT ID";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new BaseCallField();
    if (name.equals("ADDR")) return new BaseAddressField();
    if (name.equals("UNIT")) return new BaseUnitField();
    return super.getField(name);
  }
}
