package net.anei.cadpage.parsers.dispatch;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class DispatchA18Parser extends FieldProgramParser {
  
  public DispatchA18Parser(String defCity, String defState) {
    super(defCity, defState,
          "CALL ADDR X BOX!");
  }
  
  @Override
  protected boolean parseMsg(String field, Data data) {
    return parseFields(field.split("\n"), 4, data);
  }
  
  @Override
  public String adjustMapAddress(String sAddress) {
    int pt = sAddress.indexOf(", Box");
    if (pt >= 0) sAddress = sAddress.substring(0,pt).trim();
    return sAddress;
  }
  
  private static final Pattern BOX_PTN = Pattern.compile("BOX *(\\d+)", Pattern.CASE_INSENSITIVE);
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("-- ")) {
        field = field.substring(3).trim();
      } else if (field.startsWith("-")) {
        int pt = field.indexOf('-',1);
        if (pt < 0) abort();
        data.strPlace = field.substring(1,pt).trim();
        field = field.substring(pt+1).trim();
      } else abort();
      
      int pt = field.lastIndexOf(',');
      if (pt < 0) abort();
      String city = field.substring(pt+1).trim();
      field = field.substring(0,pt).trim();
      
      String box = "";
      Matcher match = BOX_PTN.matcher(city);
      if (match.find()) {
        box = ", Box " + match.group(1);
        city = city.substring(match.end()).trim();
      }
      
      pt = field.lastIndexOf('-');
      if (pt >= 0) {
        city = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
      }
      
      parseAddress(field, data);
      data.strAddress = data.strAddress + box;
      data.strCity = city;
    }
    
    @Override
    public String getFieldNames() {
      return "PLACE ADDR APT CITY";
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace("//", "/");
      if (field.endsWith("/")) field = field.substring(0,field.length()-1).trim();
      if (field.endsWith("/NULL")) field = field.substring(0,field.length()-5).trim();
      super.parse(field, data);
    }
  }
  
  private class MyBoxField extends BoxField {
    @Override
    public void parse(String field, Data data) {
      if (!field.startsWith("Fire Box =")) abort();
      field = field.substring(10).trim();
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("BOX")) return new MyBoxField();
    return super.getField(name);
  }
  
}
