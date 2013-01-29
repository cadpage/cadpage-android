package net.anei.cadpage.parsers.VA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/**
 * Agusta County, VA
 */
public class VAAugustaCountyParser extends DispatchOSSIParser {
  
  private static final Pattern MAP_PTN = Pattern.compile("\\b\\d{3}-?\\d{2}$");
  
  public VAAugustaCountyParser() {
    super("AUGUSTA COUNTY", "VA",
           "FYI? EMPTY? CALL! ( ADDR/SZ! END | PLACE? ADDR/S! MAP? EXTRA? X X INFO )");
  }
  
  @Override
  public String getFilter() {
    return "cad@co.augusta.va.us";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    return super.parseMsg(body.replace(':',';').replace("CAD;","CAD:"), data);
  }

  // Map field recognizes and isolates a trailing map pattern
  private class MyMapField extends MapField {

    @Override
    public boolean canFail() {
      return true;
    }

    @Override
    public boolean checkParse(String field, Data data) {
      Matcher match = MAP_PTN.matcher(field);
      if (!match.find()) return false;
      field = match.group();
      if (field.indexOf('-') < 0) {
        field = field.substring(0,3) + '-' + field.substring(3);
      }
      parse(field, data);
      return true;
    }
  }
  
  // Extra field contains all kinds of sloppy stuff
  private class ExtraField extends Field {
    
    @Override
    public void parse(String field, Data data) {
      String tmp = field.toUpperCase();
      if (tmp.startsWith("PO ") || tmp.startsWith("P O ")) return;
      if (data.strPlace.length() == 0) data.strPlace = field;
      else data.strSupp = append(data.strSupp, " / ", field);
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("MAP")) return new MyMapField();
    if (name.equals("EXTRA")) return new ExtraField();
    if (name.equals("FYI")) return new SkipField("FYI");
    if (name.equals("EMPTY")) return new SkipField("");
    return super.getField(name);
  }
  
  
}
