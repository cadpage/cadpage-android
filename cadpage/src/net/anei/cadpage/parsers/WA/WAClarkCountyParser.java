package net.anei.cadpage.parsers.WA;

import java.util.Properties;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class WAClarkCountyParser extends FieldProgramParser {
  
  public WAClarkCountyParser() {
    super(CITY_CODES, "CLARK COUNTY", "WA",
           "SRC LOC:ADDR/S! MAP:MAP! OPS:CALL! SUB_TYPE:CODE! PRI:PRI! TIME:TIME! EV#:ID! ALARM:SKIP! Disp:UNIT!");
  }
  
  @Override
  public String getFilter() {
    return "777,CRESA CAD";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    if (data.strCity.equals("Clark County")) data.strCity = "";
    return true;
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      data.strPlace = p.getLastOptional(": @");
      data.strApt = p.getLastOptional(',');
      super.parse(p.get(), data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " PLACE";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "BG",   "Battleground",
      "CAM",  "Camas",
      "CLK",  "Clark County",
      "CPD",  "Camas",
      "LCPD", "La Center",
      "RPD",  "Ridgefield",
      "VAN",  "Vancouver",
      "VPD",  "Vancouver",
      "WAS",  "Washougal",
      "WPD",  "Washougal"
      
  });
}
