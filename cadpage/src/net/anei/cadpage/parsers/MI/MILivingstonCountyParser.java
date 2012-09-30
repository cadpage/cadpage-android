package net.anei.cadpage.parsers.MI;

import java.util.Properties;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/**
 * Livingston County, MI
 * @author ken
 *
 */
public class MILivingstonCountyParser extends DispatchOSSIParser {
  
  public String getFilter() {
    return "CAD@livingstoncounty.livco,93001";
  }
  
  public MILivingstonCountyParser() {
    super(CITY_CODES, "LIVINGSTON COUNTY", "MI",
           "( CANCEL ADDR CITY | SRC ADDR CITY? CALL | FYI CALL PLACE? ADDR/s! X? X? ) INFO+");
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    if (body.startsWith("FYI: ;") || body.startsWith("Update: ;")) body = "CAD:" + body;
    return super.parseMsg(body, data);
  }
  
  private class CancelField extends CallField {
    public CancelField() {
      setPattern("CANCEL");
    }
    
    @Override
    public String getFieldNames() {
      return "CALL";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CANCEL")) return new CancelField();
    if (name.equals("SRC")) return new SourceField("[A-Z]{4}", true);
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "BRTN", "BRIGHTON",
      "HOWL", "HOWELL"
  });
}
