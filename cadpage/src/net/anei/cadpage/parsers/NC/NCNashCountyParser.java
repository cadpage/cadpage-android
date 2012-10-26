package net.anei.cadpage.parsers.NC;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;


public class NCNashCountyParser extends DispatchOSSIParser {
  
  public NCNashCountyParser() {
    super("NASH COUNTY", "NC",
           "SKIP ADDR! SKIP SKIP CITY! SKIP SKIP? CALL! SKIP PLNAME SKIP SKIP SKIP SKIP SKIP SKIP");
  }
  
  @Override
  public String getFilter() {
    return "nash911@nashcountync.gov";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (body.startsWith("/ ")) body = body.substring(2).trim();
    if (!body.startsWith("NASH911:")) return false;
    body = body + " ";
    return parseFields(body.split("\\* "), data);
  }
  
  private class MyCallField extends CallField {
    public MyCallField() {
      setPattern(Pattern.compile(".+"));
    }
  }
  
  private class PlaceNameField extends Field {
    
    @Override
    public void parse(String field, Data data) {
      if (field.contains(",")) {
        data.strName = field;
      } else {
        data.strPlace = field;
      }
    }
    
    @Override
    public String getFieldNames() {
      return "NAME PLACE";
    }
    
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("PLNAME")) return new PlaceNameField();
    return super.getField(name);
  }
}
