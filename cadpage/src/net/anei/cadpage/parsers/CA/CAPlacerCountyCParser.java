package net.anei.cadpage.parsers.CA;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class CAPlacerCountyCParser extends FieldProgramParser {
  
  public CAPlacerCountyCParser() {
    super(CITY_LIST, "PLACER COUNTY", "CA", 
          "( SELECT/1 CALL! Address:ADDR! Common_Name:PLACE! XStreets:X! Additional_Location_Info:INFO! Assigned_Units:UNIT! Quadrant:MAP! District:MAP/S! Beat:MAP/S! Incident:ID! Narrative:INFO! " + 
          "| CALL ADDR CODE UNIT UNIT/CS INFO+? ID! )");
  }
  
  @Override
  public String getFilter() {
    return "Dispatch@roseville.ca.us";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Dispatch")) return false;
    
    if (body.indexOf(" Address:") >= 0) {
      setSelectValue("1");
      return super.parseMsg(body, data);
    }  else {
      setSelectValue("2");
      return parseFields(body.split("\n"), data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new CallField("[A-Z]+", true);
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("ID")) return new IdField("\\d{4}-\\d{8}\\b.*", true);
    return super.getField(name);
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(',');
      if (pt >= 0) {
        String addr = field.substring(0,pt).replace('@',  '&');
        String city =field.substring(pt+1).trim();
        parseAddress(StartType.START_ADDR, FLAG_NO_CITY | FLAG_RECHECK_APT | FLAG_ANCHOR_END, 
                     addr, data);
        parseAddress(StartType.START_ADDR, FLAG_ONLY_CITY, city, data);
        if (data.strCity.length() == 0) abort();
        data.strPlace = getLeft();
      } else {
        field = field.replace('@', '&');
        parseAddress(StartType.START_ADDR, FLAG_RECHECK_APT, field, data);
        data.strPlace = getLeft();
      }
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR APT CITY PLACE";
    }
  }
  
  private static final String[] CITY_LIST = new String[]{
    "ROSEVILLE"
  };
}
