package net.anei.cadpage.parsers.NC;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;



public class NCCabarrusCountyAParser extends DispatchOSSIParser {
  
  private static final Pattern OPER_PTN = Pattern.compile("^\\d+:");
  private static final Pattern UNIT_PTN = Pattern.compile("[A-Z]+[0-9]+|[A-Z]{2}(?:POV)?|\\d+|FORE|FMO");
  
  @Override
  public String getFilter() {
    return "CAD@cabarruscounty.us, 93001";
  }
  
  public NCCabarrusCountyAParser() {
    super(CITY_CODES, "CABARRUS COUNTY", "NC",
           "FYI? ( UNIT PRI CALL! ADDR! MAP X X? INFO+ " +
                "| ADDR/Z CITY CALL X_PLACE+? " +
                "| ADDR/Z CALL UNIT2 X_PLACE/Z+? CITY " +
                "| CALL! ADDR! CITY? X_PLACE+? ( SRC UNIT | UNIT | NAME ) ) INFO+");
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // Throw out any version B calls
    if (body.contains("|")) return false;
    
    Matcher match = OPER_PTN.matcher(body);
    if (match.find()) body = body.substring(match.end()).trim();
    boolean ok = body.startsWith("CAD:");
    if (!ok) body = "CAD:" + body;
    if (! super.parseMsg(body, data)) return false;
    if (data.strPlace.equals("OOC")) data.defCity = "";
    return (ok || data.strCity.length() > 3);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("MAP")) return new MapField("[A-Z]\\d{3}");
    if (name.equals("X_PLACE")) return new CrossPlaceField();
    if (name.equals("SRC")) return new MySourceField();
    if (name.equals("UNIT")) return new MyUnitField();
    if (name.equals("UNIT2")) return new UnitField("\\d{3}|CPD");
    return super.getField(name);
  }
  
  private class CrossPlaceField extends Field {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      
      String unit = new Parser(field).get(',');
      if (UNIT_PTN.matcher(unit).matches()) return false;
      if (data.strCross.contains("&")) {
        if (data.strPlace.length() > 0 || !UNIT_PTN.matcher(getRelativeField(+1)).matches()) return false;
        String parts[] = data.strCross.split("&");
        data.strPlace = parts[0].trim();
        data.strCross = parts[1].trim();
      }
      
      if (data.strPlace.length() == 0 && data.strCross.length() == 0 && 
          (field.endsWith(" THE RUN") || !isValidAddress(field))) {
        data.strPlace = field;
      } else {
        data.strCross = append(data.strCross, " & ", field);
      }
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }

    @Override
    public String getFieldNames() {
      return "PLACE X";
    }
    
  }
  
  private class MySourceField extends  SourceField {
    public MySourceField() {
      setPattern(UNIT_PTN, true);
    }
  }
  
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
      boolean first = true;
      for (String term : terms) {
        if (first && !UNIT_PTN.matcher(term).matches()) 
          return false;
        if (term.startsWith("OPS")) {
          if (chan.length() > 0) chan.append(',');
          chan.append(term);
        } else {
          if (units.length() > 0) units.append(',');
          units.append(term);
        }
        first = false;
      }
      data.strUnit = units.toString();
      data.strChannel = chan.toString();
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
    
    @Override
    public String getFieldNames() {
      return "UNIT CH";
    }
  }
  
  private static Properties CITY_CODES = buildCodeTable(new String[]{
      "CHASE","CONCORD",          // ?????
      "CHL",  "CHARLOTTE",
      "CLT",  "CHARLOTTE",
      "CON",  "CONCORD",
      "CPD",  "CONCORD",
      "DAV",  "DAVIDSON",
      "GE",   "GEORGEVILLE",
      "GOLD", "GOLD HILL",
      "HAR",  "HARRISBURG",
      "HUN",  "HUNTERSVILLE",
      "KAN",  "KANNAPOLIS",
      "LOC",  "LOCUST",
      "MID",  "MIDLAND",
      "MP",   "MT PLEASANT",
      "ROCK", "ROCKWELL"
  });
}
