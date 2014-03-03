package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;


public class NCClevelandCountyParser extends DispatchOSSIParser {
  
  @Override
  public String getFilter() {
    return "CAD@clevelandcounty.com";
  }
  
  public NCClevelandCountyParser() {
    super("CLEVELAND COUNTY", "NC",
           "( NAME PHONE | PHONE? ) CALL+? ADDR ( X X? | PLACE X  X? | PLACE PLACE X X? | ) INFO+");
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    body = body.replace("-", ";");
    return super.parseMsg(body, data);
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      data.strCall = append(data.strCall, "-", field);
    }
  }
  
  private class MyPlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      data.strPlace = append(data.strPlace, "-", field);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("PHONE")) return new PhoneField("\\d{10}");
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("PLACE")) return new MyPlaceField();
    return super.getField(name);
  }
}
