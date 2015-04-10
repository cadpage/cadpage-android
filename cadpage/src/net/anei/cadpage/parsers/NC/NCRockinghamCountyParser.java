package net.anei.cadpage.parsers.NC;

import java.util.Properties;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/**
 * Buncombe county, NC
 */
public class NCRockinghamCountyParser extends DispatchOSSIParser {
  
  public NCRockinghamCountyParser() {
    super(CITY_CODES, "ROCKINGHAM COUNTY", "NC",
           "ID?: FYI? ( ADDR/Z CITY X/Z+? CALL UNIT | CALL ADDR APT? X/Z+? ( CITY ID? APT2? ( CODE UNIT? CH? | UNIT CH? | CH | PLACE CODE UNIT? CH? | PLACE UNIT CH? | PLACE CH | ) | ID CODE? UNIT? CH? | CODE UNIT? CH? | UNIT CH? | CH ) ) INFO+");
  }
  
  @Override
  public String getFilter() {
    return "@co.rockingham.nc.us,14101,messaging@iamresponding.com";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    int pt = body.indexOf('\n');
    if (pt >= 0) body = body.substring(0,pt).trim();

    return super.parseMsg(body, data);
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("APT")) return new AptField("[A-Z]|\\d{1,3}", true);
    if (name.equals("ID")) return new IdField("\\d{8}", true);
    if (name.equals("APT2")) return new AptField("(?:APT|RM|LOT) *(.*)", true);
    if (name.equals("CODE")) return new CodeField("\\d{1,2}[A-Z]\\d{1,2}[A-Za-z]?", true);
    if (name.equals("UNIT")) return new UnitField("(?!TAC)[A-Z]{0,3}\\d{1,3}[A-Z]?", true);
    if (name.equals("CH")) return new ChannelField("(?:Radio Channel: *)?(TAC.*)", true);
    return super.getField(name);
  }
  
  private class MyCallField extends  CallField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("{")) {
        int pt = field.indexOf('}');
        if (pt >= 0) {
          data.strUnit = field.substring(1,pt).trim();
          field = field.substring(pt+1).trim();
        }
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "UNIT CALL";
    }
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "EDEN", "EDEN",
      "MAD",  "MADISON",
      "MAY",  "MAYODAN",
      "PELH", "PELHAM",
      "REID", "REIDSVILLE",
      "RUFF", "RUFFIN",
      "STON", "STONEVILLE",
      "STOK", "STOKESDALE",
      "SUMM", "SUMMERFIELD"
  });
}
