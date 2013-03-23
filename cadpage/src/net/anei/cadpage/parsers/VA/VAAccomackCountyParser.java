package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;


public class VAAccomackCountyParser extends DispatchOSSIParser {
  
  public VAAccomackCountyParser() {
    this("ACCOMACK COUNTY");
  }
  
  public VAAccomackCountyParser(String county) {
    super(county, "VA",
           "FYI? CALL ADDR! ( CITYST | SKIP MAP MAP ) X X ( ID | INFO )");
  }
  
  @Override
  public String getAliasCode() {
    return "VAAccomackCounty";
  }
  
  @Override
  public String getFilter() {
    return "cad@esva911.org,14100";
  }

  // We need a special field parser to handle the CITYST field
  private class CityStField extends Field {

    @Override
    public boolean canFail() {
      return true;
    }

    @Override
    public boolean checkParse(String field, Data data) {
      if (! field.contains(" ")) return false;
      parse(field, data);
      return true;
    }

    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      data.strCity = p.get(' ');
      data.strState = p.get();
    }
    
    @Override
    public String getFieldNames() {
      return "CITY ST";
    }
  }
  
  // And we need a special MAP field that will append two map data fields
  private class MyMapField extends MapField {
    @Override
    public void parse(String field, Data data) {
      data.strMap = append(data.strMap, ",", field);
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("CITYST")) return new CityStField();
    if (name.equals("MAP")) return new MyMapField();
    if (name.equals("ID")) return new IdField("\\d{8,}");
    return super.getField(name);
  }
  
  
}
