package net.anei.cadpage.parsers.OH;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class OHPortageCountyParser extends FieldProgramParser {
  
  public OHPortageCountyParser() {
    super("PORTAGE", "OH",
           "CALL ADDR CITY INFO+");
  }
  
  @Override
  public String getFilter() {
    return "911@ci.ravenna.oh.us";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (!body.startsWith("* ")) return false;
    body = body.substring(2).replace('\n', ' ').trim();
    if (!parseFields(body.split("\\*"), data)) return false;
    
    if (data.strAddress.length() == 0) {
      parseAddress(data.strCross, data);
      data.strCross = "";
    }
    return true;
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(',');
      if (pt < 0) abort();
      super.parse(field.substring(pt+1).trim(), data);
      String src = field.substring(0,pt).trim();
      pt = src.indexOf("_general");
      if (pt >= 0) {
        data.strSource = src.substring(0,pt).trim();
      }
    }
    
    @Override 
    public String getFieldNames() {
      return "SRC CALL";
    }
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace(',', ' ').trim();
      if (field.startsWith("0 ")) field = field.substring(2).trim();
      if (field.equals("0")) field = "";
      super.parse(field, data);
    }
  }
  
  private class MyCityField extends CityField {
    @Override
    public void parse(String field, Data data) {
      
      // ,Ravenna is the name of the dispatch center
      // and needs to be stripped off
      if (field.endsWith(",Ravenna")) field = field.substring(0,field.length()-8).trim();
      Parser p = new Parser(field);
      String city = p.getLast(',');
      String cross = p.get();
      if (cross.length() == 0 && city.contains("/")) {
        cross = city;
        city = "";
      }
      data.strCross = cross;
      data.strCity = city;
    }
    
    @Override
    public String getFieldNames() {
      return "X CITY";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("CITY")) return new MyCityField();
    return super.getField(name);
  }
  
  @Override
  public String postAdjustMapAddress(String addr) {
    return STATE225_PTN.matcher(addr).replaceAll("STATE ROUTE 225");
  }
  private static final Pattern STATE225_PTN = Pattern.compile("\\b(STATE|ST|OH) +225\\b", Pattern.CASE_INSENSITIVE);
}
