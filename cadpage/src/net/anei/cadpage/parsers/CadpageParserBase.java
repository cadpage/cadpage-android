package net.anei.cadpage.parsers;

import java.util.HashMap;
import java.util.Map;

import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Base class for the two CadpageParser classes
 */
public class CadpageParserBase  extends FieldProgramParser{
  
  private Map<String,Field> fieldMap = new HashMap<String,Field>();
  
  public CadpageParserBase() {
    // Pass empty strings to subclass constructor, we never really try to run a 
    // field program or use the default city/state values
    super("", "", "");
    initMap();
  }
  
  private void initMap() {
    setMap("PRI");
    setMap("DATE");
    setMap("TIME");
    setMap("CALL",        "title");
    setMap("PLACE", "PL");
    setMap("ADDR",        "address");
    setMap("CITY",        "city");
    setMap("ST");
    setMap("APT");
    setMap("X");
    setMap("BOX");
    setMap("MAP",         "map_code");
    setMap("CH");
    setMap("UNIT");
    setMap("INFO");
    setMap("NAME");
    setMap("PHONE", "PH");
    setMap("CODE");
    setMap("GPS");
    setMap("ID",           "cad_code");
    setMap("SRC");
    setMap("DCITY");
    setMap("DST");
    setMap("MADDR");
    setMap("URL",         "response_url");
  }

  /**
   * Set up key -> Field process map
   * @param keys list of key used to access this field.  The first key will
   * be used to look up the field that all of them will refer to.
   */
  private void setMap(String ... keys) {
    Field field = getField(keys[0]);
    for (String key : keys) fieldMap.put(key, field);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("DCITY")) return new DefCityField();
    if (name.equals("DST")) return new DefStateField();
    if (name.equals("MADDR")) return new SkipField();
    return super.getField(name);
  }
  
  // We need an address field that just saves the address.  The default
  // field process handles all kinds of cool things
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      data.strAddress = field;
    }
  }

  // And something to save the default city and state
  private class DefCityField extends Field {
    @Override 
    public void parse(String field, Data data) {
      data.defCity = field;
    }
  }
  
  private class DefStateField extends Field {
    @Override 
    public void parse(String field, Data data) {
      data.defState = field;
    }
  }
  
  /**
   * Get Field object that will really be used to process items
   * @param name field name
   * @return Field object if found or null otherwise
   */
  protected Field getMapField(String name) {
    return fieldMap.get(name);
  }
}
