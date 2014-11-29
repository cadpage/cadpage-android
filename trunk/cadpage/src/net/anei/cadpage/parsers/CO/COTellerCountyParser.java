package net.anei.cadpage.parsers.CO;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class COTellerCountyParser extends FieldProgramParser {
  
  public COTellerCountyParser() {
    super("TELLER COUNTY", "CO",
           "( PROB:CALL! ADD:ADDR! APT:APT! LOC:PLACE! | Add:ADDR! Problem:CALL! Loc:PLACE  Code:CODE )");
  }
  
  @Override
  public String getFilter() {
    return "ept@ept911.info";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    body = body.replace("LOC:", " LOC:");
    return super.parseMsg(body, data);
  }

  @Override
  public Field getField(String name) {
    if (name.equals("PLACE")) return new MyPlaceField();
    return super.getField(name);
  }
  
  private class MyPlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      field = substring(field, 0, 20);
      super.parse(field,  data);
    }
  }
}
