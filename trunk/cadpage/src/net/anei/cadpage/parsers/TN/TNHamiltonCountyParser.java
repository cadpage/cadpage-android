package net.anei.cadpage.parsers.TN;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class TNHamiltonCountyParser extends FieldProgramParser {
  
  public TNHamiltonCountyParser() {
    super("HAMILTON COUNTY", "TN",
           "RT:CALL! Loc:ADDR!");
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // There is always some trailing junk that needs to be stripped off.
    // But if we don't find it, assume more is coming
    
    int pt = body.indexOf(" #[");
    if (pt >= 0) body = body.substring(0,pt).trim();
    else data.expectMore = true;

    if (body.endsWith("#")) body = body.substring(0,body.length()-1).trim();

    return super.parseMsg(body, data);
  }
  
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith(")")) field = field.substring(0,field.length()-1).trim();
      int pt = field.indexOf('(');
      if (pt>0) {
        if (field.endsWith(")")) field = field.substring(0,field.length()-1).trim();
        else data.expectMore = true;
        String sCross = field.substring(pt+1, field.length()).trim();
        field = field.substring(0,pt).trim();
        pt = sCross.indexOf(',');
        if (pt >= 0) {
          data.strCity = sCross.substring(pt+1).trim();
          sCross = sCross.substring(0,pt).trim();
        }
        data.strCross = sCross;
      }
      
      pt = field.indexOf(',');
      if (pt >= 0) {
        String city = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
        if (city.equals("HAMILTON COUNTY")) city = "";
        else if (city.endsWith(" CATOOSA CO")) {
          data.strCross = append(city.substring(0,city.length()-10).trim(), " & ", data.strCross);
          city = "CATOOSA COUNTY";
          data.strState = "GA";
        }
        data.strCity = city;
      }
      
      if (field.startsWith("@")) {
        parseAddress(StartType.START_PLACE, FLAG_START_FLD_REQ | FLAG_ANCHOR_END, field.substring(1).trim(), data);
      } else {
        parseAddress(field, data);
      }
    }
    
    @Override
    public String getFieldNames() {
      return "PLACE ADDR APT CITY ST X";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
}
