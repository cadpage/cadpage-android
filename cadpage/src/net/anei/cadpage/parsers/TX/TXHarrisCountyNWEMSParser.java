package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchVisionAirParser;

/**
 * Harris County NWEMS, TX
 */
public class TXHarrisCountyNWEMSParser extends DispatchVisionAirParser {
  
  public TXHarrisCountyNWEMSParser() {
    super("", "HARRIS COUNTY", "TX",
           "ID ADDR APT UNK CITY ( X/Z X/Z MAP | ) EMPTY+? SPEC? CODE CALL NAME PHONE UNIT! INFO+? EXTRA EXTRA+");
  }
  
  public String getFilter() {
    return "cad@nwems.org";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    if (data.strCity.equals("HARRIS CO")) data.strCity = "";
    return true;
  }
  
  private class SpecialField extends Field {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override 
    public boolean checkParse(String field, Data data) {
      if (field.startsWith("Landmark Comment:")) {
        data.strSupp = append(data.strSupp, " / ", field.substring(17).trim());
        return true;
      }
      if (field.startsWith("NBH:")) {
        data.strPlace = field.substring(4).trim();
        return true;
      }
      return false;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
    
    @Override
    public String getFieldNames() {
      return "INFO PLACE";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ID")) return new IdField("|\\d{9}", true);
    if (name.equals("MAP")) return new MapField("\\d{3}[A-Z]{1,4}", true);
    if (name.equals("SPEC")) return new SpecialField();
    return super.getField(name);
  }
}
