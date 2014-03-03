package net.anei.cadpage.parsers.WA;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchProQAParser;

/**
 * Pierce County, WA
 */
public class WAPierceCountyAParser extends DispatchProQAParser {
  
  
  public WAPierceCountyAParser() {
    super("PIERCE COUNTY", "WA", 
           "CALL PLACE ADDR EXTRA+");
  }
  
  @Override
  public String getFilter() {
    return "cadpage@rmetro.com";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    int pt = body.indexOf('\n');
    if (pt >= 0) body = body.substring(0,pt).trim();
    return super.parseMsg(body, data);
  }
  
  private class MyPlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      if (field.equals("<Unknown>")) return;
      super.parse(field, data);
    }
  }
  
  private static final Pattern UNIT_PTN = Pattern.compile("\\d{3}");
  private static final Pattern MAP_PTN = Pattern.compile("\\d{3} [A-Z]\\d");
  private class MyExtraField extends Field {
    
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("X=")) {
        data.strCross = append(data.strCross, " & ", field.substring(2).trim());
      }
      
      else if (UNIT_PTN.matcher(field).matches()) {
        data.strUnit = append(data.strUnit, " ", field);
      }
      
      else if (data.strCity.length() == 0 && WAPierceCountyParser.CITY_SET.contains(field.toUpperCase())) {
        data.strCity = field;
      }
      
      else if (MAP_PTN.matcher(field).matches()) {
        data.strMap = field;
        return;
      }
      
      else {
        data.strSupp = append(data.strSupp, " / ", field);
      }
    }
    
    @Override
    public String getFieldNames() {
      return "X UNIT CITY MAP INFO";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("PLACE")) return new MyPlaceField();
    if (name.equals("EXTRA")) return new MyExtraField();
    return super.getField(name);
  }
}
