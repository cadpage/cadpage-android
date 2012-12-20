package net.anei.cadpage.parsers.TX;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Harris County NWEMS, TX
 */
public class TXHarrisCountyNWEMSParser extends FieldProgramParser {
  
  private static final Pattern DELIM = Pattern.compile("\\* ");

  public TXHarrisCountyNWEMSParser() {
    super("HARRIS COUNTY", "TX",
           "ID ADDR APT UNK CITY ( X/Z X/Z MAP | ) EMPTY+? EXTRA? CODE CALL NAME PHONE UNIT! INFO+");
  }
  
  public String getFilter() {
    return "cad@nwems.org";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (!parseFields(DELIM.split(body+" "), 10, data)) return false;
    if (data.strCity.equals("HARRIS CO")) data.strCity = "";
    return true;
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace("//", "&");
      super.parse(field, data);
    }
  }
  
  private class MyExtraField extends Field {
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
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("MAP")) return new MapField("\\d{3}[A-Z]{1,4}", true);
    if (name.equals("EXTRA")) return new MyExtraField();
    return super.getField(name);
  }
}
