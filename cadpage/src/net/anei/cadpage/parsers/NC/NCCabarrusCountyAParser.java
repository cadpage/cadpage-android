package net.anei.cadpage.parsers.NC;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;



public class NCCabarrusCountyAParser extends DispatchOSSIParser {
  
  private static final Pattern OPER_PTN = Pattern.compile("^\\d+:");
  
  @Override
  public String getFilter() {
    return "CAD@cabarruscounty.us, 93001";
  }
  
  public NCCabarrusCountyAParser() {
    super(CITY_CODES, "CABARRUS COUNTY", "NC",
           "( UNIT PRI CALL! ADDR! MAP X X? INFO+ | CALL! ADDR! CITY PLACE? X X NAME )");
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    Matcher match = OPER_PTN.matcher(body);
    if (match.find()) body = body.substring(match.end()).trim();
    boolean ok = body.startsWith("CAD:");
    if (!ok) body = "CAD:" + body;
    if (! super.parseMsg(body, data)) return false;
    return (ok || data.strCity.length() > 3);
  }
  
  private static final Pattern UNIT_PTN = Pattern.compile("[A-Z]+[0-9]+");
  private class MyUnitField extends UnitField {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      String[] terms = field.split(",");
      StringBuffer units = new StringBuffer();
      StringBuffer chan = new StringBuffer();
      for (String term : terms) {
        if (!UNIT_PTN.matcher(term).matches()) return false;
        if (term.startsWith("OPS")) {
          if (chan.length() > 0) chan.append(',');
          chan.append(term);
        } else {
          if (units.length() > 0) units.append(',');
          units.append(term);
        }
      }
      data.strUnit = units.toString();
      data.strChannel = chan.toString();
      return true;
    }
    
    @Override
    public String getFieldNames() {
      return "UNIT CH";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("UNIT")) return new MyUnitField();
    if (name.equals("MAP")) return new MapField("[A-Z]\\d{3}");
    return super.getField(name);
  }
  
  private static Properties CITY_CODES = buildCodeTable(new String[]{
      "HAR",  "HARRISBURG",
      "HUN",  "HUNTERSVILLE",
      "MP",   "MT PLEASANT",
      "CON",  "CONCORD",
      "KAN",  "KANNAPOLIS",
      "DAV",  "DAVIDSON",
      "LOC",  "LOCUST",
      "CHL",  "CHARLOTTE",
      "CLT",  "CHARLOTTE",
      "MID",  "MIDLAND"
  });
}
