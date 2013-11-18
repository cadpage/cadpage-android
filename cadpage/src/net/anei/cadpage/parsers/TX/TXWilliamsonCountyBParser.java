package net.anei.cadpage.parsers.TX;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

public class TXWilliamsonCountyBParser extends DispatchOSSIParser {

  public TXWilliamsonCountyBParser() {
    super(CITY_CODES, "WILLIAMSON COUNTY", "TX", 
          "( CANCEL! | FYI? CALL! ) ADDR/S CITY/Y! PLACE_UNIT? SRC");
  }
  
  @Override protected boolean parseMsg(String body, Data data) {
    body = "CAD:" + body;
    return super.parseMsg(body, data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("PLACE_UNIT")) return new MyPlaceUnitField();
    return super.getField(name);
  }
  
  private static Pattern PLACE_UNIT_PAT = Pattern.compile("(?:\\(S\\)(.*?) )?\\(N\\)(.*?)");
  private class MyPlaceUnitField extends Field {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      Matcher mat = PLACE_UNIT_PAT.matcher(field);
      if (!mat.matches()) return false;
      data.strPlace = getOptGroup(mat.group(1));
      data.strUnit = mat.group(2).trim();
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }

    @Override
    public String getFieldNames() {
      return "PLACE UNIT";
    }
  }

  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "LE",      "LEANDER",
      "LH",      "LIBERTY HILL",
      "JA",      "JARRELL",
      "GT",      "GEORGETOWN",
      "FL",      "FLORENCE",
      "TA",      "TAYLOR"
    });
}
