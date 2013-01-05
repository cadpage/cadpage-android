package net.anei.cadpage.parsers.NC;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/**
 * Buncombe county, NC
 */
public class NCRockinghamCountyParser extends DispatchOSSIParser {
  
  public NCRockinghamCountyParser() {
    super(CITY_CODES, "ROCKINGHAM COUNTY", "NC",
           "CALL ADDR X/Z+? CITY ( PLACE CODE UNIT | CODE UNIT | PLACE? UNIT ) CH? X? INFO+");
  }
  
  @Override
  public String getFilter() {
    return "cad@co.rockingham.nc.us";
  }
  
  private static final Pattern PLACE_APT_PTN = Pattern.compile("APT *(.*)|((?:RM|LOT).*)", Pattern.CASE_INSENSITIVE);
  private class MyPlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = PLACE_APT_PTN.matcher(field);
      if (match.matches()) {
        String apt = match.group(1);
        if (apt == null) apt = match.group(2);
        data.strApt = apt;
      } else {
        super.parse(field, data);
      }
    }
  }
  
  
  @Override
  protected Field getField(String name) {
    if (name.equals("PLACE")) return new MyPlaceField();
    if (name.equals("CODE")) return new CodeField("\\d{1,2}[A-Z]\\d{1,2}[A-Za-z]?", true);
    if (name.equals("UNIT")) return new UnitField("[A-Z]{0,3}\\d{1,3}[A-Z]?", true);
    if (name.equals("CH")) return new ChannelField("(?:Radio Channel: *)?(TAC.*)");
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "EDEN", "EDEN",
      "MAD",  "MADISON",
      "MAY",  "MAYODAN",
      "PELH", "PELHAM",
      "REID", "REIDSVILLE",
      "RUFF", "RUFFIN",
      "STON", "STONEVILLE",
      "STOK", "STOKESDALE"
  });
}
