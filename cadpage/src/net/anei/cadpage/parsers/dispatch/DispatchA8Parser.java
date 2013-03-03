package net.anei.cadpage.parsers.dispatch;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class DispatchA8Parser extends FieldProgramParser {

  private static final Pattern DELIM = Pattern.compile("\\*\\*");
  
  protected DispatchA8Parser(String defCity, String defState) {
    super(defCity, defState,
           "DISPATCH? TIME CALL ADDR PLACE ( MAP X | NAME PHONE! MAP ) INFO+");
  }
  
  @Override
  public String getFilter() {
    return "cazfd@fdcms.com,cazfire1@windstream.net,lfdfire@verizon.net";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    return parseFields(DELIM.split(body), 6, data);
  }
  
  // Place field needs to strip off trailing dash
  // and is complete ignored if place was set in address field parsing
  private class BasePlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("-")) field = field.substring(1).trim();
      if (field.endsWith("-")) field = field.substring(0, field.length()-1).trim();
      
      if (field.startsWith("APT ")) {
        int pt = field.indexOf(',', 4);
        if (pt < 0) pt = field.indexOf(' ', 4);
        if (pt < 0) pt = field.length();
        data.strApt = field.substring(4,pt).trim();
        field = field.substring(Math.min(pt+1, field.length())).trim();
      }
      
      if (field.equals(data.strPlace)) return;
      data.strPlace = append(data.strPlace, " - ", field);
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("DISPATCH")) return new SkipField("Dispatch", true);
    if (name.equals("TIME")) return new TimeField("\\d\\d:\\d\\d(?::\\d\\d)?", false);
    if (name.equals("PLACE")) return new BasePlaceField();
    if (name.equals("MAP")) return new MapField("\\d\\d-[A-Z0-9]\\d", false);
    return super.getField(name);
  }
  
}
	